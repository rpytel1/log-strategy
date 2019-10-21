public void pdfbox_f3039_0(OutputStream destStream)
{    destinationStream = destStream;}
public PDDocumentInformation pdfbox_f3040_0()
{    return destinationDocumentInformation;}
public void pdfbox_f3041_0(PDDocumentInformation info)
{    destinationDocumentInformation = info;}
public PDMetadata pdfbox_f3042_0()
{    return destinationMetadata;}
public void pdfbox_f3043_0(PDMetadata meta)
{    destinationMetadata = meta;}
public void pdfbox_f3044_0(String source) throws FileNotFoundException
{    addSource(new File(source));}
public void pdfbox_f3045_0(File source) throws FileNotFoundException
{    sources.add(source);}
public void pdfbox_f3046_0(InputStream source)
{    sources.add(source);}
public void pdfbox_f3047_0(List<InputStream> sourcesList)
{    sources.addAll(sourcesList);}
public void pdfbox_f3048_0() throws IOException
{    mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());}
public void pdfbox_f3049_0(MemoryUsageSetting memUsageSetting) throws IOException
{    if (documentMergeMode == DocumentMergeMode.PDFBOX_LEGACY_MODE) {        legacyMergeDocuments(memUsageSetting);    } else if (documentMergeMode == DocumentMergeMode.OPTIMIZE_RESOURCES_MODE) {        optimizedMergeDocuments(memUsageSetting);    }}
private void pdfbox_f3050_0(MemoryUsageSetting memUsageSetting) throws IOException
{    try (PDDocument destination = new PDDocument(memUsageSetting)) {        PDFCloneUtility cloner = new PDFCloneUtility(destination);        for (Object sourceObject : sources) {            PDDocument sourceDoc = null;            try {                if (sourceObject instanceof File) {                    sourceDoc = PDDocument.load((File) sourceObject, memUsageSetting);                } else {                    sourceDoc = PDDocument.load((InputStream) sourceObject, memUsageSetting);                }                for (PDPage page : sourceDoc.getPages()) {                    PDPage newPage = new PDPage((COSDictionary) cloner.cloneForNewDocument(page.getCOSObject()));                    newPage.setCropBox(page.getCropBox());                    newPage.setMediaBox(page.getMediaBox());                    newPage.setRotation(page.getRotation());                    PDResources resources = page.getResources();                    if (resources != null) {                                                                        newPage.setResources(new PDResources((COSDictionary) cloner.cloneForNewDocument(resources)));                    } else {                        newPage.setResources(new PDResources());                    }                    destination.addPage(newPage);                }            } finally {                IOUtils.closeQuietly(sourceDoc);            }        }        if (destinationStream == null) {            destination.save(destinationFileName);        } else {            destination.save(destinationStream);        }    }}
private void pdfbox_f3051_0(MemoryUsageSetting memUsageSetting) throws IOException
{    if (sources != null && !sources.isEmpty()) {                                                List<PDDocument> tobeclosed = new ArrayList<>();        MemoryUsageSetting partitionedMemSetting = memUsageSetting != null ? memUsageSetting.getPartitionedCopy(sources.size() + 1) : MemoryUsageSetting.setupMainMemoryOnly();        try (PDDocument destination = new PDDocument(partitionedMemSetting)) {            for (Object sourceObject : sources) {                PDDocument sourceDoc = null;                if (sourceObject instanceof File) {                    sourceDoc = PDDocument.load((File) sourceObject, partitionedMemSetting);                } else {                    sourceDoc = PDDocument.load((InputStream) sourceObject, partitionedMemSetting);                }                tobeclosed.add(sourceDoc);                appendDocument(destination, sourceDoc);            }                        if (destinationDocumentInformation != null) {                destination.setDocumentInformation(destinationDocumentInformation);            }            if (destinationMetadata != null) {                destination.getDocumentCatalog().setMetadata(destinationMetadata);            }            if (destinationStream == null) {                destination.save(destinationFileName);            } else {                destination.save(destinationStream);            }        } finally {            for (PDDocument doc : tobeclosed) {                IOUtils.closeAndLogException(doc, LOG, "PDDocument", null);            }        }    }}
public void pdfbox_f3052_1(PDDocument destination, PDDocument source) throws IOException
{    if (source.getDocument().isClosed()) {        throw new IOException("Error: source PDF is closed.");    }    if (destination.getDocument().isClosed()) {        throw new IOException("Error: destination PDF is closed.");    }    PDDocumentCatalog destCatalog = destination.getDocumentCatalog();    PDDocumentCatalog srcCatalog = source.getDocumentCatalog();    if (isDynamicXfa(srcCatalog.getAcroForm())) {        throw new IOException("Error: can't merge source document containing dynamic XFA form content.");    }    PDDocumentInformation destInfo = destination.getDocumentInformation();    PDDocumentInformation srcInfo = source.getDocumentInformation();    mergeInto(srcInfo.getCOSObject(), destInfo.getCOSObject(), Collections.<COSName>emptySet());        float destVersion = destination.getVersion();    float srcVersion = source.getVersion();    if (destVersion < srcVersion) {        destination.setVersion(srcVersion);    }    int pageIndexOpenActionDest = -1;    if (destCatalog.getOpenAction() == null) {                PDDestinationOrAction openAction = null;        try {            openAction = srcCatalog.getOpenAction();        } catch (IOException ex) {                                }        PDDestination openActionDestination = null;        if (openAction instanceof PDActionGoTo) {            openActionDestination = ((PDActionGoTo) openAction).getDestination();        } else if (openAction instanceof PDDestination) {            openActionDestination = (PDDestination) openAction;        }        if (openActionDestination instanceof PDPageDestination) {            PDPage page = ((PDPageDestination) openActionDestination).getPage();            if (page != null) {                pageIndexOpenActionDest = srcCatalog.getPages().indexOf(page);            }        }        destCatalog.setOpenAction(openAction);    }    PDFCloneUtility cloner = new PDFCloneUtility(destination);    mergeAcroForm(cloner, destCatalog, srcCatalog);    COSArray destThreads = (COSArray) destCatalog.getCOSObject().getDictionaryObject(COSName.THREADS);    COSArray srcThreads = (COSArray) cloner.cloneForNewDocument(destCatalog.getCOSObject().getDictionaryObject(COSName.THREADS));    if (destThreads == null) {        destCatalog.getCOSObject().setItem(COSName.THREADS, srcThreads);    } else {        destThreads.addAll(srcThreads);    }    PDDocumentNameDictionary destNames = destCatalog.getNames();    PDDocumentNameDictionary srcNames = srcCatalog.getNames();    if (srcNames != null) {        if (destNames == null) {            destCatalog.getCOSObject().setItem(COSName.NAMES, cloner.cloneForNewDocument(srcNames));        } else {            cloner.cloneMerge(srcNames, destNames);        }    }    if (destNames != null) {                destNames.getCOSObject().removeItem(COSName.ID_TREE);            }    PDDocumentNameDestinationDictionary destDests = destCatalog.getDests();    PDDocumentNameDestinationDictionary srcDests = srcCatalog.getDests();    if (srcDests != null) {        if (destDests == null) {            destCatalog.getCOSObject().setItem(COSName.DESTS, cloner.cloneForNewDocument(srcDests));        } else {            cloner.cloneMerge(srcDests, destDests);        }    }    PDDocumentOutline destOutline = destCatalog.getDocumentOutline();    PDDocumentOutline srcOutline = srcCatalog.getDocumentOutline();    if (srcOutline != null) {        if (destOutline == null || destOutline.getFirstChild() == null) {            PDDocumentOutline cloned = new PDDocumentOutline((COSDictionary) cloner.cloneForNewDocument(srcOutline));            destCatalog.setDocumentOutline(cloned);        } else {                        PDOutlineItem destLastOutlineItem = destOutline.getFirstChild();            while (destLastOutlineItem.getNextSibling() != null) {                destLastOutlineItem = destLastOutlineItem.getNextSibling();            }            for (PDOutlineItem item : srcOutline.children()) {                                                COSDictionary clonedDict = (COSDictionary) cloner.cloneForNewDocument(item);                clonedDict.removeItem(COSName.PREV);                clonedDict.removeItem(COSName.NEXT);                PDOutlineItem clonedItem = new PDOutlineItem(clonedDict);                destLastOutlineItem.insertSiblingAfter(clonedItem);                destLastOutlineItem = destLastOutlineItem.getNextSibling();            }        }    }    PageMode destPageMode = destCatalog.getPageMode();    PageMode srcPageMode = srcCatalog.getPageMode();    if (destPageMode == null) {        destCatalog.setPageMode(srcPageMode);    }    COSDictionary destLabels = (COSDictionary) destCatalog.getCOSObject().getDictionaryObject(COSName.PAGE_LABELS);    COSDictionary srcLabels = (COSDictionary) srcCatalog.getCOSObject().getDictionaryObject(COSName.PAGE_LABELS);    if (srcLabels != null) {        int destPageCount = destination.getNumberOfPages();        COSArray destNums;        if (destLabels == null) {            destLabels = new COSDictionary();            destNums = new COSArray();            destLabels.setItem(COSName.NUMS, destNums);            destCatalog.getCOSObject().setItem(COSName.PAGE_LABELS, destLabels);        } else {            destNums = (COSArray) destLabels.getDictionaryObject(COSName.NUMS);        }        COSArray srcNums = (COSArray) srcLabels.getDictionaryObject(COSName.NUMS);        if (srcNums != null) {            int startSize = destNums.size();            for (int i = 0; i < srcNums.size(); i += 2) {                COSBase base = srcNums.getObject(i);                if (!(base instanceof COSNumber)) {                                                            while (destNums.size() > startSize) {                        destNums.remove(startSize);                    }                    break;                }                COSNumber labelIndex = (COSNumber) base;                long labelIndexValue = labelIndex.intValue();                destNums.add(COSInteger.get(labelIndexValue + destPageCount));                destNums.add(cloner.cloneForNewDocument(srcNums.getObject(i + 1)));            }        }    }    COSStream destMetadata = (COSStream) destCatalog.getCOSObject().getDictionaryObject(COSName.METADATA);    COSStream srcMetadata = (COSStream) srcCatalog.getCOSObject().getDictionaryObject(COSName.METADATA);    if (destMetadata == null && srcMetadata != null) {        try {            PDStream newStream = new PDStream(destination, srcMetadata.createInputStream(), (COSName) null);            mergeInto(srcMetadata, newStream.getCOSObject(), new HashSet<>(Arrays.asList(COSName.FILTER, COSName.LENGTH)));            destCatalog.getCOSObject().setItem(COSName.METADATA, newStream);        } catch (IOException ex) {                                }    }    COSDictionary destOCP = (COSDictionary) destCatalog.getCOSObject().getDictionaryObject(COSName.OCPROPERTIES);    COSDictionary srcOCP = (COSDictionary) srcCatalog.getCOSObject().getDictionaryObject(COSName.OCPROPERTIES);    if (destOCP == null && srcOCP != null) {        destCatalog.getCOSObject().setItem(COSName.OCPROPERTIES, cloner.cloneForNewDocument(srcOCP));    } else if (destOCP != null && srcOCP != null) {        cloner.cloneMerge(srcOCP, destOCP);    }    mergeOutputIntents(cloner, srcCatalog, destCatalog);        boolean mergeStructTree = false;    int destParentTreeNextKey = -1;    Map<Integer, COSObjectable> srcNumberTreeAsMap = null;    Map<Integer, COSObjectable> destNumberTreeAsMap = null;    PDStructureTreeRoot srcStructTree = srcCatalog.getStructureTreeRoot();    PDStructureTreeRoot destStructTree = destCatalog.getStructureTreeRoot();    if (destStructTree == null && srcStructTree != null) {                        destStructTree = new PDStructureTreeRoot();        destCatalog.setStructureTreeRoot(destStructTree);        destStructTree.setParentTree(new PDNumberTreeNode(PDParentTreeValue.class));                for (PDPage page : destCatalog.getPages()) {            page.getCOSObject().removeItem(COSName.STRUCT_PARENTS);            for (PDAnnotation ann : page.getAnnotations()) {                ann.getCOSObject().removeItem(COSName.STRUCT_PARENT);            }        }    }    if (destStructTree != null) {        PDNumberTreeNode destParentTree = destStructTree.getParentTree();        destParentTreeNextKey = destStructTree.getParentTreeNextKey();        if (destParentTree != null) {            destNumberTreeAsMap = getNumberTreeAsMap(destParentTree);            if (destParentTreeNextKey < 0) {                if (destNumberTreeAsMap.isEmpty()) {                    destParentTreeNextKey = 0;                } else {                    destParentTreeNextKey = Collections.max(destNumberTreeAsMap.keySet()) + 1;                }            }            if (destParentTreeNextKey >= 0 && srcStructTree != null) {                PDNumberTreeNode srcParentTree = srcStructTree.getParentTree();                if (srcParentTree != null) {                    srcNumberTreeAsMap = getNumberTreeAsMap(srcParentTree);                    if (!srcNumberTreeAsMap.isEmpty()) {                        mergeStructTree = true;                    }                }            }        }    }    Map<COSDictionary, COSDictionary> objMapping = new HashMap<>();    int pageIndex = 0;    for (PDPage page : srcCatalog.getPages()) {        PDPage newPage = new PDPage((COSDictionary) cloner.cloneForNewDocument(page.getCOSObject()));        if (!mergeStructTree) {                        newPage.getCOSObject().removeItem(COSName.STRUCT_PARENTS);            for (PDAnnotation ann : newPage.getAnnotations()) {                ann.getCOSObject().removeItem(COSName.STRUCT_PARENT);            }        }        newPage.setCropBox(page.getCropBox());        newPage.setMediaBox(page.getMediaBox());        newPage.setRotation(page.getRotation());        PDResources resources = page.getResources();        if (resources != null) {                        newPage.setResources(new PDResources((COSDictionary) cloner.cloneForNewDocument(resources)));        } else {            newPage.setResources(new PDResources());        }        if (mergeStructTree) {                                    updateStructParentEntries(newPage, destParentTreeNextKey);            objMapping.put(page.getCOSObject(), newPage.getCOSObject());            List<PDAnnotation> oldAnnots = page.getAnnotations();            List<PDAnnotation> newAnnots = newPage.getAnnotations();            for (int i = 0; i < oldAnnots.size(); i++) {                objMapping.put(oldAnnots.get(i).getCOSObject(), newAnnots.get(i).getCOSObject());            }                }        destination.addPage(newPage);        if (pageIndex == pageIndexOpenActionDest) {                                    PDDestinationOrAction openAction = destCatalog.getOpenAction();            PDPageDestination pageDestination;            if (openAction instanceof PDActionGoTo) {                pageDestination = (PDPageDestination) ((PDActionGoTo) openAction).getDestination();            } else {                pageDestination = (PDPageDestination) openAction;            }            pageDestination.setPage(newPage);        }        ++pageIndex;    }    if (mergeStructTree) {        updatePageReferences(cloner, srcNumberTreeAsMap, objMapping);        int maxSrcKey = -1;        for (Map.Entry<Integer, COSObjectable> entry : srcNumberTreeAsMap.entrySet()) {            int srcKey = entry.getKey();            maxSrcKey = Math.max(srcKey, maxSrcKey);            destNumberTreeAsMap.put(destParentTreeNextKey + srcKey, cloner.cloneForNewDocument(entry.getValue()));        }        destParentTreeNextKey += maxSrcKey + 1;        PDNumberTreeNode newParentTreeNode = new PDNumberTreeNode(PDParentTreeValue.class);                                        newParentTreeNode.setNumbers(destNumberTreeAsMap);        destStructTree.setParentTree(newParentTreeNode);        destStructTree.setParentTreeNextKey(destParentTreeNextKey);        mergeKEntries(cloner, srcStructTree, destStructTree);        mergeRoleMap(srcStructTree, destStructTree);        mergeIDTree(cloner, srcStructTree, destStructTree);        mergeMarkInfo(destCatalog, srcCatalog);        mergeLanguage(destCatalog, srcCatalog);        mergeViewerPreferences(destCatalog, srcCatalog);    }}
private void pdfbox_f3053_0(PDDocumentCatalog destCatalog, PDDocumentCatalog srcCatalog)
{    PDViewerPreferences srcViewerPreferences = srcCatalog.getViewerPreferences();    if (srcViewerPreferences == null) {        return;    }    PDViewerPreferences destViewerPreferences = destCatalog.getViewerPreferences();    if (destViewerPreferences == null) {        destViewerPreferences = new PDViewerPreferences(new COSDictionary());        destCatalog.setViewerPreferences(destViewerPreferences);    }    mergeInto(srcViewerPreferences.getCOSObject(), destViewerPreferences.getCOSObject(), Collections.<COSName>emptySet());        if (srcViewerPreferences.hideToolbar() || destViewerPreferences.hideToolbar()) {        destViewerPreferences.setHideToolbar(true);    }    if (srcViewerPreferences.hideMenubar() || destViewerPreferences.hideMenubar()) {        destViewerPreferences.setHideMenubar(true);    }    if (srcViewerPreferences.hideWindowUI() || destViewerPreferences.hideWindowUI()) {        destViewerPreferences.setHideWindowUI(true);    }    if (srcViewerPreferences.fitWindow() || destViewerPreferences.fitWindow()) {        destViewerPreferences.setFitWindow(true);    }    if (srcViewerPreferences.centerWindow() || destViewerPreferences.centerWindow()) {        destViewerPreferences.setCenterWindow(true);    }    if (srcViewerPreferences.displayDocTitle() || destViewerPreferences.displayDocTitle()) {        destViewerPreferences.setDisplayDocTitle(true);    }}
private void pdfbox_f3054_0(PDDocumentCatalog destCatalog, PDDocumentCatalog srcCatalog)
{    if (destCatalog.getLanguage() == null && srcCatalog.getLanguage() != null) {        destCatalog.setLanguage(srcCatalog.getLanguage());    }}
private void pdfbox_f3055_0(PDDocumentCatalog destCatalog, PDDocumentCatalog srcCatalog)
{    PDMarkInfo destMark = destCatalog.getMarkInfo();    PDMarkInfo srcMark = srcCatalog.getMarkInfo();    if (destMark == null) {        destMark = new PDMarkInfo();    }    if (srcMark == null) {        srcMark = new PDMarkInfo();    }    destMark.setMarked(true);    destMark.setSuspect(srcMark.isSuspect() || destMark.isSuspect());    destMark.setSuspect(srcMark.usesUserProperties() || destMark.usesUserProperties());    destCatalog.setMarkInfo(destMark);}
private void pdfbox_f3056_0(PDFCloneUtility cloner, PDStructureTreeRoot srcStructTree, PDStructureTreeRoot destStructTree) throws IOException
{        COSArray newKArray = new COSArray();    if (destStructTree.getK() != null) {        COSBase base = destStructTree.getK();        if (base instanceof COSArray) {            newKArray.addAll((COSArray) base);        } else {            newKArray.add(base);        }    }    if (srcStructTree.getK() != null) {        COSBase base = cloner.cloneForNewDocument(srcStructTree.getK());        if (base instanceof COSArray) {            newKArray.addAll((COSArray) base);        } else {            newKArray.add(base);        }    }    if (newKArray.size() > 0) {        COSDictionary kDictLevel0 = new COSDictionary();        updateParentEntry(newKArray, kDictLevel0);        kDictLevel0.setItem(COSName.K, newKArray);        kDictLevel0.setItem(COSName.P, destStructTree);        kDictLevel0.setItem(COSName.S, COSName.DOCUMENT);        destStructTree.setK(kDictLevel0);    }}
private void pdfbox_f3057_1(PDFCloneUtility cloner, PDStructureTreeRoot srcStructTree, PDStructureTreeRoot destStructTree) throws IOException
{    PDNameTreeNode<PDStructureElement> srcIDTree = srcStructTree.getIDTree();    PDNameTreeNode<PDStructureElement> destIDTree = destStructTree.getIDTree();    if (srcIDTree == null) {        return;    }    if (destIDTree == null) {        destIDTree = new PDStructureElementNameTreeNode();    }    Map<String, PDStructureElement> srcNames = getIDTreeAsMap(srcIDTree);    Map<String, PDStructureElement> destNames = getIDTreeAsMap(destIDTree);    for (Map.Entry<String, PDStructureElement> entry : srcNames.entrySet()) {        if (destNames.containsKey(entry.getKey())) {                    } else {            destNames.put(entry.getKey(), new PDStructureElement((COSDictionary) cloner.cloneForNewDocument(entry.getValue().getCOSObject())));        }    }    destIDTree = new PDStructureElementNameTreeNode();    destIDTree.setNames(destNames);    destStructTree.setIDTree(destIDTree);}
 static Map<String, PDStructureElement> pdfbox_f3058_0(PDNameTreeNode<PDStructureElement> idTree) throws IOException
{    Map<String, PDStructureElement> names = idTree.getNames();    if (names == null) {        names = new LinkedHashMap<>();    } else {                names = new LinkedHashMap<>(names);    }    List<PDNameTreeNode<PDStructureElement>> kids = idTree.getKids();    if (kids != null) {        for (PDNameTreeNode<PDStructureElement> kid : kids) {            names.putAll(getIDTreeAsMap(kid));        }    }    return names;}
 static Map<Integer, COSObjectable> pdfbox_f3059_0(PDNumberTreeNode tree) throws IOException
{    Map<Integer, COSObjectable> numbers = tree.getNumbers();    if (numbers == null) {        numbers = new LinkedHashMap<>();    } else {                numbers = new LinkedHashMap<>(numbers);    }    List<PDNumberTreeNode> kids = tree.getKids();    if (kids != null) {        for (PDNumberTreeNode kid : kids) {            numbers.putAll(getNumberTreeAsMap(kid));        }    }    return numbers;}
private void pdfbox_f3060_1(PDStructureTreeRoot srcStructTree, PDStructureTreeRoot destStructTree)
{    COSDictionary srcDict = srcStructTree.getCOSObject().getCOSDictionary(COSName.ROLE_MAP);    COSDictionary destDict = destStructTree.getCOSObject().getCOSDictionary(COSName.ROLE_MAP);    if (srcDict == null) {        return;    }    if (destDict == null) {                destStructTree.getCOSObject().setItem(COSName.ROLE_MAP, srcDict);        return;    }    for (Map.Entry<COSName, COSBase> entry : srcDict.entrySet()) {        COSBase destValue = destDict.getDictionaryObject(entry.getKey());        if (destValue != null && destValue.equals(entry.getValue())) {                        continue;        }        if (destDict.containsKey(entry.getKey())) {                    } else {            destDict.setItem(entry.getKey(), entry.getValue());        }    }}
private void pdfbox_f3061_0(PDFCloneUtility cloner, PDDocumentCatalog destCatalog, PDDocumentCatalog srcCatalog) throws IOException
{    try {        PDAcroForm destAcroForm = destCatalog.getAcroForm();        PDAcroForm srcAcroForm = srcCatalog.getAcroForm();        if (destAcroForm == null && srcAcroForm != null) {            destCatalog.getCOSObject().setItem(COSName.ACRO_FORM, cloner.cloneForNewDocument(srcAcroForm.getCOSObject()));        } else {            if (srcAcroForm != null) {                if (acroFormMergeMode == AcroFormMergeMode.PDFBOX_LEGACY_MODE) {                    acroFormLegacyMode(cloner, destAcroForm, srcAcroForm);                } else if (acroFormMergeMode == AcroFormMergeMode.JOIN_FORM_FIELDS_MODE) {                    acroFormJoinFieldsMode(cloner, destAcroForm, srcAcroForm);                }            }        }    } catch (IOException e) {                if (!ignoreAcroFormErrors) {            throw new IOException(e);        }    }}
private void pdfbox_f3062_0(PDFCloneUtility cloner, PDAcroForm destAcroForm, PDAcroForm srcAcroForm) throws IOException
{    acroFormLegacyMode(cloner, destAcroForm, srcAcroForm);}
private void pdfbox_f3063_0(PDFCloneUtility cloner, PDAcroForm destAcroForm, PDAcroForm srcAcroForm) throws IOException
{    List<PDField> srcFields = srcAcroForm.getFields();    COSArray destFields;    if (srcFields != null && !srcFields.isEmpty()) {                                final String prefix = "dummyFieldName";        final int prefixLength = prefix.length();        for (PDField destField : destAcroForm.getFieldTree()) {            String fieldName = destField.getPartialName();            if (fieldName.startsWith(prefix)) {                nextFieldNum = Math.max(nextFieldNum, Integer.parseInt(fieldName.substring(prefixLength, fieldName.length())) + 1);            }        }                        COSBase base = destAcroForm.getCOSObject().getItem(COSName.FIELDS);        if (base instanceof COSArray) {            destFields = (COSArray) base;        } else {            destFields = new COSArray();        }        for (PDField srcField : srcAcroForm.getFields()) {            COSDictionary dstField = (COSDictionary) cloner.cloneForNewDocument(srcField.getCOSObject());                        if (destAcroForm.getField(srcField.getFullyQualifiedName()) != null) {                dstField.setString(COSName.T, prefix + nextFieldNum++);            }            destFields.add(dstField);        }        destAcroForm.getCOSObject().setItem(COSName.FIELDS, destFields);    }}
private void pdfbox_f3064_0(PDFCloneUtility cloner, PDDocumentCatalog srcCatalog, PDDocumentCatalog destCatalog) throws IOException
{    List<PDOutputIntent> srcOutputIntents = srcCatalog.getOutputIntents();    List<PDOutputIntent> dstOutputIntents = destCatalog.getOutputIntents();    for (PDOutputIntent srcOI : srcOutputIntents) {        String srcOCI = srcOI.getOutputConditionIdentifier();        if (srcOCI != null && !"Custom".equals(srcOCI)) {                        boolean skip = false;            for (PDOutputIntent dstOI : dstOutputIntents) {                if (dstOI.getOutputConditionIdentifier().equals(srcOCI)) {                    skip = true;                    break;                }            }            if (skip) {                continue;            }        }        destCatalog.addOutputIntent(new PDOutputIntent((COSDictionary) cloner.cloneForNewDocument(srcOI)));        dstOutputIntents.add(srcOI);    }}
public boolean pdfbox_f3065_0()
{    return ignoreAcroFormErrors;}
public void pdfbox_f3066_0(boolean ignoreAcroFormErrorsValue)
{    ignoreAcroFormErrors = ignoreAcroFormErrorsValue;}
private void pdfbox_f3067_0(PDFCloneUtility cloner, Map<Integer, COSObjectable> numberTreeAsMap, Map<COSDictionary, COSDictionary> objMapping) throws IOException
{    for (COSObjectable obj : numberTreeAsMap.values()) {        if (obj == null) {            continue;        }        PDParentTreeValue val = (PDParentTreeValue) obj;        COSBase base = val.getCOSObject();        if (base instanceof COSArray) {            updatePageReferences(cloner, (COSArray) base, objMapping);        } else {            updatePageReferences(cloner, (COSDictionary) base, objMapping);        }    }}
private void pdfbox_f3068_1(PDFCloneUtility cloner, COSDictionary parentTreeEntry, Map<COSDictionary, COSDictionary> objMapping) throws IOException
{    COSDictionary pageDict = parentTreeEntry.getCOSDictionary(COSName.PG);    if (objMapping.containsKey(pageDict)) {        parentTreeEntry.setItem(COSName.PG, objMapping.get(pageDict));    }    COSBase obj = parentTreeEntry.getDictionaryObject(COSName.OBJ);    if (obj instanceof COSDictionary) {        COSDictionary objDict = (COSDictionary) obj;        if (objMapping.containsKey(objDict)) {            parentTreeEntry.setItem(COSName.OBJ, objMapping.get(objDict));        } else {                                    COSBase item = parentTreeEntry.getItem(COSName.OBJ);            if (item instanceof COSObject) {                            } else {                                            }            parentTreeEntry.setItem(COSName.OBJ, cloner.cloneForNewDocument(obj));        }    }    COSBase kSubEntry = parentTreeEntry.getDictionaryObject(COSName.K);    if (kSubEntry instanceof COSArray) {        updatePageReferences(cloner, (COSArray) kSubEntry, objMapping);    } else if (kSubEntry instanceof COSDictionary) {        updatePageReferences(cloner, (COSDictionary) kSubEntry, objMapping);    }}
private void pdfbox_f3069_0(PDFCloneUtility cloner, COSArray parentTreeEntry, Map<COSDictionary, COSDictionary> objMapping) throws IOException
{    for (int i = 0; i < parentTreeEntry.size(); i++) {        COSBase subEntry = parentTreeEntry.getObject(i);        if (subEntry instanceof COSArray) {            updatePageReferences(cloner, (COSArray) subEntry, objMapping);        } else if (subEntry instanceof COSDictionary) {            updatePageReferences(cloner, (COSDictionary) subEntry, objMapping);        }    }}
private void pdfbox_f3070_0(COSArray kArray, COSDictionary newParent)
{    for (int i = 0; i < kArray.size(); i++) {        COSBase subEntry = kArray.getObject(i);        if (subEntry instanceof COSDictionary) {            COSDictionary dictEntry = (COSDictionary) subEntry;            if (dictEntry.getDictionaryObject(COSName.P) != null) {                dictEntry.setItem(COSName.P, newParent);            }        }    }}
private void pdfbox_f3071_0(PDPage page, int structParentOffset) throws IOException
{    if (page.getStructParents() >= 0) {        page.setStructParents(page.getStructParents() + structParentOffset);    }    List<PDAnnotation> annots = page.getAnnotations();    List<PDAnnotation> newannots = new ArrayList<>();    for (PDAnnotation annot : annots) {        if (annot.getStructParent() >= 0) {            annot.setStructParent(annot.getStructParent() + structParentOffset);        }        newannots.add(annot);    }    page.setAnnotations(newannots);}
private boolean pdfbox_f3072_0(PDAcroForm acroForm)
{    return acroForm != null && acroForm.xfaIsDynamic();}
private void pdfbox_f3073_0(COSDictionary src, COSDictionary dst, Set<COSName> exclude)
{    for (Map.Entry<COSName, COSBase> entry : src.entrySet()) {        if (!exclude.contains(entry.getKey()) && !dst.containsKey(entry.getKey())) {            dst.setItem(entry.getKey(), entry.getValue());        }    }}
public MemoryUsageSetting pdfbox_f3074_0()
{    return memoryUsageSetting;}
public void pdfbox_f3075_0(MemoryUsageSetting memoryUsageSetting)
{    this.memoryUsageSetting = memoryUsageSetting;}
public List<PDDocument> pdfbox_f3076_0(PDDocument document) throws IOException
{    destinationDocuments = new ArrayList<>();    sourceDocument = document;    processPages();    return destinationDocuments;}
public void pdfbox_f3077_0(int split)
{    if (split <= 0) {        throw new IllegalArgumentException("Number of pages is smaller than one");    }    splitLength = split;}
public void pdfbox_f3078_0(int start)
{    if (start <= 0) {        throw new IllegalArgumentException("Start page is smaller than one");    }    startPage = start;}
public void pdfbox_f3079_0(int end)
{    if (end <= 0) {        throw new IllegalArgumentException("End page is smaller than one");    }    endPage = end;}
private void pdfbox_f3080_0() throws IOException
{    for (PDPage page : sourceDocument.getPages()) {        if (currentPageNumber + 1 >= startPage && currentPageNumber + 1 <= endPage) {            processPage(page);            currentPageNumber++;        } else {            if (currentPageNumber > endPage) {                break;            } else {                currentPageNumber++;            }        }    }}
private void pdfbox_f3081_0() throws IOException
{    if (splitAtPage(currentPageNumber) || currentDestinationDocument == null) {        currentDestinationDocument = createNewDocument();        destinationDocuments.add(currentDestinationDocument);    }}
protected boolean pdfbox_f3082_0(int pageNumber)
{    return (pageNumber + 1 - Math.max(1, startPage)) % splitLength == 0;}
protected PDDocument pdfbox_f3083_0() throws IOException
{    PDDocument document = memoryUsageSetting == null ? new PDDocument() : new PDDocument(memoryUsageSetting);    document.getDocument().setVersion(getSourceDocument().getVersion());    document.setDocumentInformation(getSourceDocument().getDocumentInformation());    document.getDocumentCatalog().setViewerPreferences(getSourceDocument().getDocumentCatalog().getViewerPreferences());    return document;}
protected void pdfbox_f3084_0(PDPage page) throws IOException
{    createNewDocumentIfNecessary();    PDPage imported = getDestinationDocument().importPage(page);    imported.setResources(page.getResources());        processAnnotations(imported);}
private void pdfbox_f3085_0(PDPage imported) throws IOException
{    List<PDAnnotation> annotations = imported.getAnnotations();    for (PDAnnotation annotation : annotations) {        if (annotation instanceof PDAnnotationLink) {            PDAnnotationLink link = (PDAnnotationLink) annotation;            PDDestination destination = link.getDestination();            if (destination == null && link.getAction() != null) {                PDAction action = link.getAction();                if (action instanceof PDActionGoTo) {                    destination = ((PDActionGoTo) action).getDestination();                }            }            if (destination instanceof PDPageDestination) {                                ((PDPageDestination) destination).setPage(null);            }        }                annotation.setPage(null);    }}
protected final PDDocument pdfbox_f3086_0()
{    return sourceDocument;}
protected final PDDocument pdfbox_f3087_0()
{    return currentDestinationDocument;}
private static boolean pdfbox_f3088_0(char ch)
{    return isDigit(ch) || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F');}
private COSBase pdfbox_f3089_1() throws IOException
{    long numOffset = seqSource.getPosition();    COSBase value = parseDirObject();    skipSpaces();        if (!(value instanceof COSNumber) || !isDigit()) {        return value;    }        long genOffset = seqSource.getPosition();    COSBase generationNumber = parseDirObject();    skipSpaces();    readExpectedChar('R');    if (!(value instanceof COSInteger)) {                return COSNull.NULL;    }    if (!(generationNumber instanceof COSInteger)) {                return COSNull.NULL;    }    COSObjectKey key = new COSObjectKey(((COSInteger) value).longValue(), ((COSInteger) generationNumber).intValue());        return getObjectFromPool(key);}
private COSBase pdfbox_f3090_0(COSObjectKey key) throws IOException
{    if (document == null) {        throw new IOException("object reference " + key + " at offset " + seqSource.getPosition() + " in content stream");    }    return document.getObjectFromPool(key);}
protected COSDictionary pdfbox_f3091_1() throws IOException
{    readExpectedChar('<');    readExpectedChar('<');    skipSpaces();    COSDictionary obj = new COSDictionary();    boolean done = false;    while (!done) {        skipSpaces();        char c = (char) seqSource.peek();        if (c == '>') {            done = true;        } else if (c == '/') {            parseCOSDictionaryNameValuePair(obj);        } else {                                    if (readUntilEndOfCOSDictionary()) {                                return obj;            }        }    }    readExpectedChar('>');    readExpectedChar('>');    return obj;}
private boolean pdfbox_f3092_0() throws IOException
{    int c = seqSource.read();    while (c != -1 && c != '/' && c != '>') {                if (c == E) {            c = seqSource.read();            if (c == N) {                c = seqSource.read();                if (c == D) {                    c = seqSource.read();                    boolean isStream = c == S && seqSource.read() == T && seqSource.read() == R && seqSource.read() == E && seqSource.read() == A && seqSource.read() == M;                    boolean isObj = !isStream && c == O && seqSource.read() == B && seqSource.read() == J;                    if (isStream || isObj) {                                                return true;                    }                }            }        }        c = seqSource.read();    }    if (c == -1) {        return true;    }    seqSource.unread(c);    return false;}
private void pdfbox_f3093_1(COSDictionary obj) throws IOException
{    COSName key = parseCOSName();    COSBase value = parseCOSDictionaryValue();    skipSpaces();    if (((char) seqSource.peek()) == 'd') {                        String potentialDEF = readString();        if (!potentialDEF.equals(DEF)) {            seqSource.unread(potentialDEF.getBytes(ISO_8859_1));        } else {            skipSpaces();        }    }    if (value == null) {            } else {                value.setDirect(true);        obj.setItem(key, value);    }}
protected void pdfbox_f3094_0() throws IOException
{            int whitespace = seqSource.read();        while (ASCII_SPACE == whitespace) {        whitespace = seqSource.read();    }    if (ASCII_CR == whitespace) {        whitespace = seqSource.read();        if (ASCII_LF != whitespace) {            seqSource.unread(whitespace);                        }    } else if (ASCII_LF != whitespace) {                                seqSource.unread(whitespace);    }}
private int pdfbox_f3095_0(final int bracesParameter) throws IOException
{    int braces = bracesParameter;    byte[] nextThreeBytes = new byte[3];    int amountRead = seqSource.read(nextThreeBytes);        if (amountRead == 3 && nextThreeBytes[0] == ASCII_CR) {        if ((nextThreeBytes[1] == ASCII_LF && (nextThreeBytes[2] == '/') || nextThreeBytes[2] == '>') || nextThreeBytes[1] == '/' || nextThreeBytes[1] == '>') {            braces = 0;        }    }    if (amountRead > 0) {        seqSource.unread(nextThreeBytes, 0, amountRead);    }    return braces;}
protected COSString pdfbox_f3096_0() throws IOException
{    char nextChar = (char) seqSource.read();    if (nextChar == '<') {        return parseCOSHexString();    } else if (nextChar != '(') {        throw new IOException("parseCOSString string should start with '(' or '<' and not '" + nextChar + "' at offset " + seqSource.getPosition());    }    ByteArrayOutputStream out = new ByteArrayOutputStream();        int braces = 1;    int c = seqSource.read();    while (braces > 0 && c != -1) {        char ch = (char) c;                int nextc = -2;        if (ch == ')') {            braces--;            braces = checkForEndOfString(braces);            if (braces != 0) {                out.write(ch);            }        } else if (ch == '(') {            braces++;            out.write(ch);        } else if (ch == '\\') {                        char next = (char) seqSource.read();            switch(next) {                case 'n':                    out.write('\n');                    break;                case 'r':                    out.write('\r');                    break;                case 't':                    out.write('\t');                    break;                case 'b':                    out.write('\b');                    break;                case 'f':                    out.write('\f');                    break;                case ')':                                        braces = checkForEndOfString(braces);                    if (braces != 0) {                        out.write(next);                    } else {                        out.write('\\');                    }                    break;                case '(':                case '\\':                    out.write(next);                    break;                case ASCII_LF:                case ASCII_CR:                                        c = seqSource.read();                    while (isEOL(c) && c != -1) {                        c = seqSource.read();                    }                    nextc = c;                    break;                case '0':                case '1':                case '2':                case '3':                case '4':                case '5':                case '6':                case '7':                    {                        StringBuilder octal = new StringBuilder();                        octal.append(next);                        c = seqSource.read();                        char digit = (char) c;                        if (digit >= '0' && digit <= '7') {                            octal.append(digit);                            c = seqSource.read();                            digit = (char) c;                            if (digit >= '0' && digit <= '7') {                                octal.append(digit);                            } else {                                nextc = c;                            }                        } else {                            nextc = c;                        }                        int character = 0;                        try {                            character = Integer.parseInt(octal.toString(), 8);                        } catch (NumberFormatException e) {                            throw new IOException("Error: Expected octal character, actual='" + octal + "'", e);                        }                        out.write(character);                        break;                    }                default:                    {                                                                        out.write(next);                    }            }        } else {            out.write(ch);        }        if (nextc != -2) {            c = nextc;        } else {            c = seqSource.read();        }    }    if (c != -1) {        seqSource.unread(c);    }    return new COSString(out.toByteArray());}
private COSString pdfbox_f3097_0() throws IOException
{    final StringBuilder sBuf = new StringBuilder();    while (true) {        int c = seqSource.read();        if (isHexDigit((char) c)) {            sBuf.append((char) c);        } else if (c == '>') {            break;        } else if (c < 0) {            throw new IOException("Missing closing bracket for hex string. Reached EOS.");        } else if ((c == ' ') || (c == '\n') || (c == '\t') || (c == '\r') || (c == '\b') || (c == '\f')) {            continue;        } else {                        if (sBuf.length() % 2 != 0) {                sBuf.deleteCharAt(sBuf.length() - 1);            }                        do {                c = seqSource.read();            } while (c != '>' && c >= 0);                        if (c < 0) {                throw new IOException("Missing closing bracket for hex string. Reached EOS.");            }                        break;        }    }    return COSString.parseHex(sBuf.toString());}
protected COSArray pdfbox_f3098_1() throws IOException
{    long startPosition = seqSource.getPosition();    readExpectedChar('[');    COSArray po = new COSArray();    COSBase pbo;    skipSpaces();    int i;    while (((i = seqSource.peek()) > 0) && ((char) i != ']')) {        pbo = parseDirObject();        if (pbo instanceof COSObject) {                        if (po.size() > 0 && po.get(po.size() - 1) instanceof COSInteger) {                COSInteger genNumber = (COSInteger) po.remove(po.size() - 1);                if (po.size() > 0 && po.get(po.size() - 1) instanceof COSInteger) {                    COSInteger number = (COSInteger) po.remove(po.size() - 1);                    COSObjectKey key = new COSObjectKey(number.longValue(), genNumber.intValue());                    pbo = getObjectFromPool(key);                } else {                                        pbo = null;                }            } else {                pbo = null;            }        }        if (pbo != null) {            po.add(pbo);        } else {                                                            String isThisTheEnd = readString();            seqSource.unread(isThisTheEnd.getBytes(ISO_8859_1));            if (ENDOBJ_STRING.equals(isThisTheEnd) || ENDSTREAM_STRING.equals(isThisTheEnd)) {                return po;            }        }        skipSpaces();    }        seqSource.read();    skipSpaces();    return po;}
protected boolean pdfbox_f3099_0(int ch)
{    return ch == ASCII_SPACE || ch == ASCII_CR || ch == ASCII_LF || ch == 9 || ch == '>' || ch == '<' || ch == '[' || ch == '/' || ch == ']' || ch == ')' || ch == '(' || ch == 0 || ch == '\f';}
protected COSName pdfbox_f3100_1() throws IOException
{    readExpectedChar('/');    ByteArrayOutputStream buffer = new ByteArrayOutputStream();    int c = seqSource.read();    while (c != -1) {        int ch = c;        if (ch == '#') {            int ch1 = seqSource.read();            int ch2 = seqSource.read();                        if (isHexDigit((char) ch1) && isHexDigit((char) ch2)) {                String hex = Character.toString((char) ch1) + (char) ch2;                try {                    buffer.write(Integer.parseInt(hex, 16));                } catch (NumberFormatException e) {                    throw new IOException("Error: expected hex digit, actual='" + hex + "'", e);                }                c = seqSource.read();            } else {                                if (ch2 == -1 || ch1 == -1) {                                        c = -1;                    break;                }                seqSource.unread(ch2);                c = ch1;                buffer.write(ch);            }        } else if (isEndOfName(ch)) {            break;        } else {            buffer.write(ch);            c = seqSource.read();        }    }    if (c != -1) {        seqSource.unread(c);    }    byte[] bytes = buffer.toByteArray();    String string;    if (isValidUTF8(bytes)) {        string = new String(buffer.toByteArray(), Charsets.UTF_8);    } else {                string = new String(buffer.toByteArray(), Charsets.WINDOWS_1252);    }    return COSName.getPDFName(string);}
private boolean pdfbox_f3101_1(byte[] input)
{    try {        utf8Decoder.decode(ByteBuffer.wrap(input));        return true;    } catch (CharacterCodingException e) {                return false;    }}
protected COSBoolean pdfbox_f3102_0() throws IOException
{    COSBoolean retval;    char c = (char) seqSource.peek();    if (c == 't') {        String trueString = new String(seqSource.readFully(4), ISO_8859_1);        if (!trueString.equals(TRUE)) {            throw new IOException("Error parsing boolean: expected='true' actual='" + trueString + "' at offset " + seqSource.getPosition());        } else {            retval = COSBoolean.TRUE;        }    } else if (c == 'f') {        String falseString = new String(seqSource.readFully(5), ISO_8859_1);        if (!falseString.equals(FALSE)) {            throw new IOException("Error parsing boolean: expected='true' actual='" + falseString + "' at offset " + seqSource.getPosition());        } else {            retval = COSBoolean.FALSE;        }    } else {        throw new IOException("Error parsing boolean expected='t or f' actual='" + c + "' at offset " + seqSource.getPosition());    }    return retval;}
protected COSBase pdfbox_f3103_0() throws IOException
{    COSBase retval = null;    skipSpaces();    int nextByte = seqSource.peek();    char c = (char) nextByte;    switch(c) {        case '<':            {                                int leftBracket = seqSource.read();                                c = (char) seqSource.peek();                seqSource.unread(leftBracket);                if (c == '<') {                    retval = parseCOSDictionary();                    skipSpaces();                } else {                    retval = parseCOSString();                }                break;            }        case '[':            {                                retval = parseCOSArray();                break;            }        case '(':            retval = parseCOSString();            break;        case '/':                        retval = parseCOSName();            break;        case 'n':            {                                readExpectedString(NULL);                retval = COSNull.NULL;                break;            }        case 't':            {                String trueString = new String(seqSource.readFully(4), ISO_8859_1);                if (trueString.equals(TRUE)) {                    retval = COSBoolean.TRUE;                } else {                    throw new IOException("expected true actual='" + trueString + "' " + seqSource + "' at offset " + seqSource.getPosition());                }                break;            }        case 'f':            {                String falseString = new String(seqSource.readFully(5), ISO_8859_1);                if (falseString.equals(FALSE)) {                    retval = COSBoolean.FALSE;                } else {                    throw new IOException("expected false actual='" + falseString + "' " + seqSource + "' at offset " + seqSource.getPosition());                }                break;            }        case 'R':            seqSource.read();            retval = new COSObject(null);            break;        case (char) -1:            return null;        default:            {                if (Character.isDigit(c) || c == '-' || c == '+' || c == '.') {                    StringBuilder buf = new StringBuilder();                    int ic = seqSource.read();                    c = (char) ic;                    while (Character.isDigit(c) || c == '-' || c == '+' || c == '.' || c == 'E' || c == 'e') {                        buf.append(c);                        ic = seqSource.read();                        c = (char) ic;                    }                    if (ic != -1) {                        seqSource.unread(ic);                    }                    retval = COSNumber.get(buf.toString());                } else {                                                                                String badString = readString();                    if (badString.isEmpty()) {                        int peek = seqSource.peek();                                                throw new IOException("Unknown dir object c='" + c + "' cInt=" + (int) c + " peek='" + (char) peek + "' peekInt=" + peek + " at offset " + seqSource.getPosition());                    }                                        if (ENDOBJ_STRING.equals(badString) || ENDSTREAM_STRING.equals(badString)) {                        seqSource.unread(badString.getBytes(ISO_8859_1));                    }                }            }    }    return retval;}
protected String pdfbox_f3104_0() throws IOException
{    skipSpaces();    StringBuilder buffer = new StringBuilder();    int c = seqSource.read();    while (!isEndOfName((char) c) && c != -1) {        buffer.append((char) c);        c = seqSource.read();    }    if (c != -1) {        seqSource.unread(c);    }    return buffer.toString();}
protected void pdfbox_f3105_0(String expectedString) throws IOException
{    readExpectedString(expectedString.toCharArray(), false);}
protected final void pdfbox_f3106_0(final char[] expectedString, boolean skipSpaces) throws IOException
{    skipSpaces();    for (char c : expectedString) {        if (seqSource.read() != c) {            throw new IOException("Expected string '" + new String(expectedString) + "' but missed at character '" + c + "' at offset " + seqSource.getPosition());        }    }    skipSpaces();}
protected void pdfbox_f3107_0(char ec) throws IOException
{    char c = (char) seqSource.read();    if (c != ec) {        throw new IOException("expected='" + ec + "' actual='" + c + "' at offset " + seqSource.getPosition());    }}
protected String pdfbox_f3108_0(int length) throws IOException
{    skipSpaces();    int c = seqSource.read();            StringBuilder buffer = new StringBuilder(length);    while (!isWhitespace(c) && !isClosing(c) && c != -1 && buffer.length() < length && c != '[' && c != '<' && c != '(' && c != '/') {        buffer.append((char) c);        c = seqSource.read();    }    if (c != -1) {        seqSource.unread(c);    }    return buffer.toString();}
protected boolean pdfbox_f3109_0() throws IOException
{    return isClosing(seqSource.peek());}
protected boolean pdfbox_f3110_0(int c)
{    return c == ']';}
protected String pdfbox_f3111_0() throws IOException
{    if (seqSource.isEOF()) {        throw new IOException("Error: End-of-File, expected line");    }    StringBuilder buffer = new StringBuilder(11);    int c;    while ((c = seqSource.read()) != -1) {                if (isEOL(c)) {            break;        }        buffer.append((char) c);    }        if (isCR(c) && isLF(seqSource.peek())) {        seqSource.read();    }    return buffer.toString();}
protected boolean pdfbox_f3112_0() throws IOException
{    return isEOL(seqSource.peek());}
protected boolean pdfbox_f3113_0(int c)
{    return isLF(c) || isCR(c);}
private boolean pdfbox_f3114_0(int c)
{    return ASCII_LF == c;}
private boolean pdfbox_f3115_0(int c)
{    return ASCII_CR == c;}
protected boolean pdfbox_f3116_0() throws IOException
{    return isWhitespace(seqSource.peek());}
protected boolean pdfbox_f3117_0(int c)
{    return c == 0 || c == 9 || c == 12 || c == ASCII_LF || c == ASCII_CR || c == ASCII_SPACE;}
protected boolean pdfbox_f3118_0() throws IOException
{    return isSpace(seqSource.peek());}
protected boolean pdfbox_f3119_0(int c)
{    return ASCII_SPACE == c;}
protected boolean pdfbox_f3120_0() throws IOException
{    return isDigit(seqSource.peek());}
protected static boolean pdfbox_f3121_0(int c)
{    return c >= ASCII_ZERO && c <= ASCII_NINE;}
protected void pdfbox_f3122_0() throws IOException
{    int c = seqSource.read();        while (isWhitespace(c) || c == 37) {        if (c == 37) {                        c = seqSource.read();            while (!isEOL(c) && c != -1) {                c = seqSource.read();            }        } else {            c = seqSource.read();        }    }    if (c != -1) {        seqSource.unread(c);    }}
protected long pdfbox_f3123_0() throws IOException
{    long retval = readLong();    if (retval < 0 || retval >= OBJECT_NUMBER_THRESHOLD) {        throw new IOException("Object Number '" + retval + "' has more than 10 digits or is negative");    }    return retval;}
protected int pdfbox_f3124_0() throws IOException
{    int retval = readInt();    if (retval < 0 || retval > GENERATION_NUMBER_THRESHOLD) {        throw new IOException("Generation Number '" + retval + "' has more than 5 digits");    }    return retval;}
protected int pdfbox_f3125_0() throws IOException
{    skipSpaces();    int retval = 0;    StringBuilder intBuffer = readStringNumber();    try {        retval = Integer.parseInt(intBuffer.toString());    } catch (NumberFormatException e) {        seqSource.unread(intBuffer.toString().getBytes(ISO_8859_1));        throw new IOException("Error: Expected an integer type at offset " + seqSource.getPosition() + ", instead got '" + intBuffer + "'", e);    }    return retval;}
protected long pdfbox_f3126_0() throws IOException
{    skipSpaces();    long retval = 0;    StringBuilder longBuffer = readStringNumber();    try {        retval = Long.parseLong(longBuffer.toString());    } catch (NumberFormatException e) {        seqSource.unread(longBuffer.toString().getBytes(ISO_8859_1));        throw new IOException("Error: Expected a long type at offset " + seqSource.getPosition() + ", instead got '" + longBuffer + "'", e);    }    return retval;}
protected final StringBuilder pdfbox_f3127_0() throws IOException
{    int lastByte;    StringBuilder buffer = new StringBuilder();    while ((lastByte = seqSource.read()) != ASCII_SPACE && lastByte != ASCII_LF && lastByte != ASCII_CR &&     lastByte != 60 &&     lastByte != '[' &&     lastByte != '(' &&     lastByte != 0 && lastByte != -1) {        buffer.append((char) lastByte);        if (buffer.length() > MAX_LENGTH_LONG) {            throw new IOException("Number '" + buffer + "' is getting too long, stop reading at offset " + seqSource.getPosition());        }    }    if (lastByte != -1) {        seqSource.unread(lastByte);    }    return buffer;}
public void pdfbox_f3128_0(int byteCount)
{    if (byteCount > 15) {        readTrailBytes = byteCount;    }}
protected COSDictionary pdfbox_f3129_0() throws IOException
{    COSDictionary trailer = null;    boolean rebuildTrailer = false;    try {                        long startXRefOffset = getStartxrefOffset();        if (startXRefOffset > -1) {            trailer = parseXref(startXRefOffset);        } else {            rebuildTrailer = isLenient();        }    } catch (IOException exception) {        if (isLenient()) {            rebuildTrailer = true;        } else {            throw exception;        }    }        if (trailer != null && trailer.getItem(COSName.ROOT) == null) {        rebuildTrailer = isLenient();    }    if (rebuildTrailer) {        trailer = rebuildTrailer();    } else {                prepareDecryption();        if (bfSearchCOSObjectKeyOffsets != null && !bfSearchCOSObjectKeyOffsets.isEmpty()) {            bfSearchForObjStreams();        }    }    return trailer;}
private COSDictionary pdfbox_f3130_1(long startXRefOffset) throws IOException
{    source.seek(startXRefOffset);    long startXrefOffset = Math.max(0, parseStartXref());        long fixedOffset = checkXRefOffset(startXrefOffset);    if (fixedOffset > -1) {        startXrefOffset = fixedOffset;    }    document.setStartXref(startXrefOffset);    long prev = startXrefOffset;        Set<Long> prevSet = new HashSet<>();    while (prev > 0) {                source.seek(prev);                skipSpaces();                if (source.peek() == X) {                        if (!parseXrefTable(prev) || !parseTrailer()) {                throw new IOException("Expected trailer object at offset " + source.getPosition());            }            COSDictionary trailer = xrefTrailerResolver.getCurrentTrailer();                        if (trailer.containsKey(COSName.XREF_STM)) {                int streamOffset = trailer.getInt(COSName.XREF_STM);                                fixedOffset = checkXRefOffset(streamOffset);                if (fixedOffset > -1 && fixedOffset != streamOffset) {                                        streamOffset = (int) fixedOffset;                    trailer.setInt(COSName.XREF_STM, streamOffset);                }                if (streamOffset > 0) {                    source.seek(streamOffset);                    skipSpaces();                    try {                        parseXrefObjStream(prev, false);                    } catch (IOException ex) {                        if (isLenient) {                                                    } else {                            throw ex;                        }                    }                } else {                    if (isLenient) {                                            } else {                        throw new IOException("Skipped XRef stream due to a corrupt offset:" + streamOffset);                    }                }            }            prev = trailer.getLong(COSName.PREV);            if (prev > 0) {                                fixedOffset = checkXRefOffset(prev);                if (fixedOffset > -1 && fixedOffset != prev) {                    prev = fixedOffset;                    trailer.setLong(COSName.PREV, prev);                }            }        } else {                        prev = parseXrefObjStream(prev, true);            if (prev > 0) {                                fixedOffset = checkXRefOffset(prev);                if (fixedOffset > -1 && fixedOffset != prev) {                    prev = fixedOffset;                    COSDictionary trailer = xrefTrailerResolver.getCurrentTrailer();                    trailer.setLong(COSName.PREV, prev);                }            }        }        if (prevSet.contains(prev)) {            throw new IOException("/Prev loop at offset " + prev);        }        prevSet.add(prev);    }        xrefTrailerResolver.setStartxref(startXrefOffset);    COSDictionary trailer = xrefTrailerResolver.getTrailer();    document.setTrailer(trailer);    document.setIsXRefStream(XRefType.STREAM == xrefTrailerResolver.getXrefType());        checkXrefOffsets();        document.addXRefTable(xrefTrailerResolver.getXrefTable());    return trailer;}
private long pdfbox_f3131_0(long objByteOffset, boolean isStandalone) throws IOException
{        long objectNumber = readObjectNumber();        long currentHighestXRefObjectNumber = document.getHighestXRefObjectNumber();    document.setHighestXRefObjectNumber(Math.max(currentHighestXRefObjectNumber, objectNumber));    readGenerationNumber();    readExpectedString(OBJ_MARKER, true);    COSDictionary dict = parseCOSDictionary();    try (COSStream xrefStream = parseCOSStream(dict)) {        parseXrefStream(xrefStream, objByteOffset, isStandalone);    }    return dict.getLong(COSName.PREV);}
private long pdfbox_f3132_1() throws IOException
{    byte[] buf;    long skipBytes;        try {        final int trailByteCount = (fileLen < readTrailBytes) ? (int) fileLen : readTrailBytes;        buf = new byte[trailByteCount];        skipBytes = fileLen - trailByteCount;        source.seek(skipBytes);        int off = 0;        int readBytes;        while (off < trailByteCount) {            readBytes = source.read(buf, off, trailByteCount - off);                        if (readBytes < 1) {                throw new IOException("No more bytes to read for trailing buffer, but expected: " + (trailByteCount - off));            }            off += readBytes;        }    } finally {        source.seek(0);    }        int bufOff = lastIndexOf(EOF_MARKER, buf, buf.length);    if (bufOff < 0) {        if (isLenient) {                        bufOff = buf.length;                    } else {            throw new IOException("Missing end of file marker '" + new String(EOF_MARKER) + "'");        }    }        bufOff = lastIndexOf(STARTXREF, buf, bufOff);    if (bufOff < 0) {        throw new IOException("Missing 'startxref' marker.");    } else {        return skipBytes + bufOff;    }}
protected int pdfbox_f3133_0(final char[] pattern, final byte[] buf, final int endOff)
{    final int lastPatternChOff = pattern.length - 1;    int bufOff = endOff;    int patOff = lastPatternChOff;    char lookupCh = pattern[patOff];    while (--bufOff >= 0) {        if (buf[bufOff] == lookupCh) {            if (--patOff < 0) {                                return bufOff;            }                        lookupCh = pattern[patOff];        } else if (patOff < lastPatternChOff) {                        patOff = lastPatternChOff;            lookupCh = pattern[patOff];        }    }    return -1;}
public boolean pdfbox_f3134_0()
{    return isLenient;}
public void pdfbox_f3135_0(boolean lenient)
{    if (initialParseDone) {        throw new IllegalArgumentException("Cannot change leniency after parsing");    }    this.isLenient = lenient;}
private long pdfbox_f3136_0(final COSObject obj)
{    return obj.getObjectNumber() << 32 | obj.getGenerationNumber();}
private void pdfbox_f3137_0(final Queue<COSBase> toBeParsedList, final Collection<COSBase> newObjects, final Set<Long> addedObjects)
{    for (COSBase newObject : newObjects) {        addNewToList(toBeParsedList, newObject, addedObjects);    }}
private void pdfbox_f3138_0(final Queue<COSBase> toBeParsedList, final COSBase newObject, final Set<Long> addedObjects)
{    if (newObject instanceof COSObject) {        final long objId = getObjectId((COSObject) newObject);        if (!addedObjects.add(objId)) {            return;        }        toBeParsedList.add(newObject);    } else if (newObject instanceof COSDictionary || newObject instanceof COSArray) {        toBeParsedList.add(newObject);    }}
protected void pdfbox_f3139_1(COSDictionary dict, COSName... excludeObjects) throws IOException
{        final Queue<COSBase> toBeParsedList = new LinkedList<>();        final TreeMap<Long, List<COSObject>> objToBeParsed = new TreeMap<>();        final Set<Long> parsedObjects = new HashSet<>();    final Set<Long> addedObjects = new HashSet<>();    addExcludedToList(excludeObjects, dict, parsedObjects);    addNewToList(toBeParsedList, dict.getValues(), addedObjects);        while (!(toBeParsedList.isEmpty() && objToBeParsed.isEmpty())) {                        COSBase baseObj;        while ((baseObj = toBeParsedList.poll()) != null) {            if (baseObj instanceof COSDictionary) {                addNewToList(toBeParsedList, ((COSDictionary) baseObj).getValues(), addedObjects);            } else if (baseObj instanceof COSArray) {                for (COSBase cosBase : (COSArray) baseObj) {                    addNewToList(toBeParsedList, cosBase, addedObjects);                }            } else if (baseObj instanceof COSObject) {                COSObject obj = (COSObject) baseObj;                long objId = getObjectId(obj);                COSObjectKey objKey = new COSObjectKey(obj.getObjectNumber(), obj.getGenerationNumber());                if (!parsedObjects.contains(objId)) {                    Long fileOffset = document.getXrefTable().get(objKey);                    if (fileOffset == null && isLenient) {                        Map<COSObjectKey, Long> bfCOSObjectKeyOffsets = getBFCOSObjectOffsets();                        fileOffset = bfCOSObjectKeyOffsets.get(objKey);                        if (fileOffset != null) {                                                        document.getXrefTable().put(objKey, fileOffset);                        }                    }                                        if (fileOffset != null && fileOffset != 0) {                        if (fileOffset > 0) {                            objToBeParsed.put(fileOffset, Collections.singletonList(obj));                        } else {                                                                                    COSObjectKey key = new COSObjectKey((int) -fileOffset, 0);                            fileOffset = document.getXrefTable().get(key);                            if ((fileOffset == null) || (fileOffset <= 0)) {                                if (isLenient) {                                    Map<COSObjectKey, Long> bfCOSObjectKeyOffsets = getBFCOSObjectOffsets();                                    fileOffset = bfCOSObjectKeyOffsets.get(key);                                    if (fileOffset != null) {                                                                                document.getXrefTable().put(key, fileOffset);                                    } else {                                                                                continue;                                    }                                } else {                                    throw new IOException("Invalid object stream xref object reference for key '" + objKey + "': " + fileOffset);                                }                            }                            List<COSObject> stmObjects = objToBeParsed.get(fileOffset);                            if (stmObjects == null) {                                stmObjects = new ArrayList<>();                                objToBeParsed.put(fileOffset, stmObjects);                            } else                             if (!(stmObjects instanceof ArrayList)) {                                throw new IOException(obj + " cannot be assigned to offset " + fileOffset + ", this belongs to " + stmObjects.get(0));                            }                            stmObjects.add(obj);                        }                    } else {                                                COSObject pdfObject = document.getObjectFromPool(objKey);                        pdfObject.setObject(COSNull.NULL);                    }                }            }        }                if (objToBeParsed.isEmpty()) {            break;        }        for (COSObject obj : objToBeParsed.remove(objToBeParsed.firstKey())) {            COSBase parsedObj = parseObjectDynamically(obj, false);            if (parsedObj != null) {                obj.setObject(parsedObj);                addNewToList(toBeParsedList, parsedObj, addedObjects);                parsedObjects.add(getObjectId(obj));            }        }    }}
private void pdfbox_f3140_0(COSName[] excludeObjects, COSDictionary dict, final Set<Long> parsedObjects)
{    if (excludeObjects != null) {        for (COSName objName : excludeObjects) {            COSBase baseObj = dict.getItem(objName);            if (baseObj instanceof COSObject) {                parsedObjects.add(getObjectId((COSObject) baseObj));            }        }    }}
protected final COSBase pdfbox_f3141_0(COSObject obj, boolean requireExistingNotCompressedObj) throws IOException
{    return parseObjectDynamically(obj.getObjectNumber(), obj.getGenerationNumber(), requireExistingNotCompressedObj);}
protected COSBase pdfbox_f3142_1(long objNr, int objGenNr, boolean requireExistingNotCompressedObj) throws IOException
{        final COSObjectKey objKey = new COSObjectKey(objNr, objGenNr);    final COSObject pdfObject = document.getObjectFromPool(objKey);    if (pdfObject.getObject() == null) {                        Long offsetOrObjstmObNr = document.getXrefTable().get(objKey);                if (offsetOrObjstmObNr == null && isLenient) {            Map<COSObjectKey, Long> bfCOSObjectKeyOffsets = getBFCOSObjectOffsets();            offsetOrObjstmObNr = bfCOSObjectKeyOffsets.get(objKey);            if (offsetOrObjstmObNr != null) {                                document.getXrefTable().put(objKey, offsetOrObjstmObNr);            }        }                if (requireExistingNotCompressedObj && ((offsetOrObjstmObNr == null) || (offsetOrObjstmObNr <= 0))) {            throw new IOException("Object must be defined and must not be compressed object: " + objKey.getNumber() + ":" + objKey.getGeneration());        }        if (offsetOrObjstmObNr == null) {                        pdfObject.setObject(COSNull.NULL);        } else if (offsetOrObjstmObNr > 0) {                        parseFileObject(offsetOrObjstmObNr, objKey, pdfObject);        } else {                                    parseObjectStream((int) -offsetOrObjstmObNr);        }    }    return pdfObject.getObject();}
private void pdfbox_f3143_1(Long offsetOrObjstmObNr, final COSObjectKey objKey, final COSObject pdfObject) throws IOException
{        source.seek(offsetOrObjstmObNr);        final long readObjNr = readObjectNumber();    final int readObjGen = readGenerationNumber();    readExpectedString(OBJ_MARKER, true);        if ((readObjNr != objKey.getNumber()) || (readObjGen != objKey.getGeneration())) {        throw new IOException("XREF for " + objKey.getNumber() + ":" + objKey.getGeneration() + " points to wrong object: " + readObjNr + ":" + readObjGen + " at offset " + offsetOrObjstmObNr);    }    skipSpaces();    COSBase pb = parseDirObject();    String endObjectKey = readString();    if (endObjectKey.equals(STREAM_STRING)) {        source.rewind(endObjectKey.getBytes(ISO_8859_1).length);        if (pb instanceof COSDictionary) {            COSStream stream = parseCOSStream((COSDictionary) pb);            if (securityHandler != null) {                securityHandler.decryptStream(stream, objKey.getNumber(), objKey.getGeneration());            }            pb = stream;        } else {                        throw new IOException("Stream not preceded by dictionary (offset: " + offsetOrObjstmObNr + ").");        }        skipSpaces();        endObjectKey = readLine();                if (!endObjectKey.startsWith(ENDOBJ_STRING) && endObjectKey.startsWith(ENDSTREAM_STRING)) {            endObjectKey = endObjectKey.substring(9).trim();            if (endObjectKey.length() == 0) {                                                endObjectKey = readLine();            }        }    } else if (securityHandler != null) {        securityHandler.decrypt(pb, objKey.getNumber(), objKey.getGeneration());    }    pdfObject.setObject(pb);    if (!endObjectKey.startsWith(ENDOBJ_STRING)) {        if (isLenient) {                    } else {            throw new IOException("Object (" + readObjNr + ":" + readObjGen + ") at offset " + offsetOrObjstmObNr + " does not end with 'endobj' but with '" + endObjectKey + "'");        }    }}
private void pdfbox_f3144_1(int objstmObjNr) throws IOException
{    final COSBase objstmBaseObj = parseObjectDynamically(objstmObjNr, 0, true);    if (objstmBaseObj instanceof COSStream) {                PDFObjectStreamParser parser;        try {            parser = new PDFObjectStreamParser((COSStream) objstmBaseObj, document);        } catch (IOException ex) {            if (isLenient) {                                return;            } else {                throw ex;            }        }        try {            parser.parse();        } catch (IOException exception) {            if (isLenient) {                                                return;            } else {                throw exception;            }        }                for (COSObject next : parser.getObjects()) {            COSObjectKey stmObjKey = new COSObjectKey(next);            Long offset = xrefTrailerResolver.getXrefTable().get(stmObjKey);            if (offset != null && offset == -objstmObjNr) {                COSObject stmObj = document.getObjectFromPool(stmObjKey);                stmObj.setObject(next.getObject());            }        }    }}
private COSNumber pdfbox_f3145_1(final COSBase lengthBaseObj, final COSName streamType) throws IOException
{    if (lengthBaseObj == null) {        return null;    }    COSNumber retVal;        if (lengthBaseObj instanceof COSNumber) {        retVal = (COSNumber) lengthBaseObj;    } else     if (lengthBaseObj instanceof COSObject) {        COSObject lengthObj = (COSObject) lengthBaseObj;        COSBase length = lengthObj.getObject();        if (length == null) {                        final long curFileOffset = source.getPosition();            boolean isObjectStream = COSName.OBJ_STM.equals(streamType);            parseObjectDynamically(lengthObj, isObjectStream);                        source.seek(curFileOffset);            length = lengthObj.getObject();        }        if (length == null) {            throw new IOException("Length object content was not read.");        }        if (COSNull.NULL == length) {                        return null;        }        if (!(length instanceof COSNumber)) {            throw new IOException("Wrong type of referenced length object " + lengthObj + ": " + length.getClass().getSimpleName());        }        retVal = (COSNumber) length;    } else {        throw new IOException("Wrong type of length object: " + lengthBaseObj.getClass().getSimpleName());    }    return retVal;}
protected COSStream pdfbox_f3146_1(COSDictionary dic) throws IOException
{    COSStream stream = document.createCOSStream(dic);        readString();    skipWhiteSpaces();    /*         * This needs to be dic.getItem because when we are parsing, the underlying object might still be null.         */    COSNumber streamLengthObj = getLength(dic.getItem(COSName.LENGTH), dic.getCOSName(COSName.TYPE));    if (streamLengthObj == null) {        if (isLenient) {                    } else {            throw new IOException("Missing length for stream.");        }    }        try (OutputStream out = stream.createRawOutputStream()) {        if (streamLengthObj != null && validateStreamLength(streamLengthObj.longValue())) {            readValidStream(out, streamLengthObj);        } else {            readUntilEndStream(new EndstreamOutputStream(out));        }    }    String endStream = readString();    if (endStream.equals("endobj") && isLenient) {                        source.rewind(ENDOBJ.length);    } else if (endStream.length() > 9 && isLenient && endStream.substring(0, 9).equals(ENDSTREAM_STRING)) {                        source.rewind(endStream.substring(9).getBytes(ISO_8859_1).length);    } else if (!endStream.equals(ENDSTREAM_STRING)) {        throw new IOException("Error reading stream, expected='endstream' actual='" + endStream + "' at offset " + source.getPosition());    }    return stream;}
private void pdfbox_f3147_0(final OutputStream out) throws IOException
{    int bufSize;    int charMatchCount = 0;    byte[] keyw = ENDSTREAM;        final int quickTestOffset = 5;        while ((bufSize = source.read(strmBuf, charMatchCount, STRMBUFLEN - charMatchCount)) > 0) {        bufSize += charMatchCount;        int bIdx = charMatchCount;        int quickTestIdx;                for (int maxQuicktestIdx = bufSize - quickTestOffset; bIdx < bufSize; bIdx++) {                                                            quickTestIdx = bIdx + quickTestOffset;            if (charMatchCount == 0 && quickTestIdx < maxQuicktestIdx) {                final byte ch = strmBuf[quickTestIdx];                if ((ch > 't') || (ch < 'a')) {                                                            bIdx = quickTestIdx;                    continue;                }            }                        final byte ch = strmBuf[bIdx];            if (ch == keyw[charMatchCount]) {                if (++charMatchCount == keyw.length) {                                        bIdx++;                    break;                }            } else {                if ((charMatchCount == 3) && (ch == ENDOBJ[charMatchCount])) {                                        keyw = ENDOBJ;                    charMatchCount++;                } else {                                                                                                                        charMatchCount = (ch == E) ? 1 : ((ch == N) && (charMatchCount == 7)) ? 2 : 0;                                        keyw = ENDSTREAM;                }            }        }        int contentBytes = Math.max(0, bIdx - charMatchCount);                if (contentBytes > 0) {            out.write(strmBuf, 0, contentBytes);        }        if (charMatchCount == keyw.length) {                        source.rewind(bufSize - contentBytes);            break;        } else {                        System.arraycopy(keyw, 0, strmBuf, 0, charMatchCount);        }    }        out.flush();}
private void pdfbox_f3148_0(OutputStream out, COSNumber streamLengthObj) throws IOException
{    long remainBytes = streamLengthObj.longValue();    while (remainBytes > 0) {        final int chunk = (remainBytes > STREAMCOPYBUFLEN) ? STREAMCOPYBUFLEN : (int) remainBytes;        final int readBytes = source.read(streamCopyBuf, 0, chunk);        if (readBytes <= 0) {                        throw new IOException("read error at offset " + source.getPosition() + ": expected " + chunk + " bytes, but read() returns " + readBytes);        }        out.write(streamCopyBuf, 0, readBytes);        remainBytes -= readBytes;    }}
private boolean pdfbox_f3149_1(long streamLength) throws IOException
{    boolean streamLengthIsValid = true;    long originOffset = source.getPosition();    long expectedEndOfStream = originOffset + streamLength;    if (expectedEndOfStream > fileLen) {        streamLengthIsValid = false;            } else {        source.seek(expectedEndOfStream);        skipSpaces();        if (!isString(ENDSTREAM)) {            streamLengthIsValid = false;                    }        source.seek(originOffset);    }    return streamLengthIsValid;}
private long pdfbox_f3150_0(long startXRefOffset) throws IOException
{        if (!isLenient) {        return startXRefOffset;    }    source.seek(startXRefOffset);    skipSpaces();    if (source.peek() == X && isString(XREF_TABLE)) {        return startXRefOffset;    }    if (startXRefOffset > 0) {        if (checkXRefStreamOffset(startXRefOffset)) {            return startXRefOffset;        } else {            return calculateXRefFixedOffset(startXRefOffset);        }    }        return -1;}
private boolean pdfbox_f3151_1(long startXRefOffset) throws IOException
{        if (!isLenient || startXRefOffset == 0) {        return true;    }        source.seek(startXRefOffset - 1);    int nextValue = source.read();        if (isWhitespace(nextValue)) {        skipSpaces();        if (isDigit()) {            try {                                readObjectNumber();                readGenerationNumber();                readExpectedString(OBJ_MARKER, true);                                COSDictionary dict = parseCOSDictionary();                source.seek(startXRefOffset);                if ("XRef".equals(dict.getNameAsString(COSName.TYPE))) {                    return true;                }            } catch (IOException exception) {                                                source.seek(startXRefOffset);            }        }    }    return false;}
private long pdfbox_f3152_1(long objectOffset) throws IOException
{    if (objectOffset < 0) {                return 0;    }        long newOffset = bfSearchForXRef(objectOffset);    if (newOffset > -1) {                return newOffset;    }        return 0;}
private boolean pdfbox_f3153_1(Map<COSObjectKey, Long> xrefOffset) throws IOException
{    if (xrefOffset == null) {        return true;    }    for (Entry<COSObjectKey, Long> objectEntry : xrefOffset.entrySet()) {        COSObjectKey objectKey = objectEntry.getKey();        Long objectOffset = objectEntry.getValue();                if (objectOffset != null && objectOffset >= 0 && !checkObjectKey(objectKey, objectOffset)) {                        return false;        }    }    return true;}
private void pdfbox_f3154_1() throws IOException
{        if (!isLenient) {        return;    }    Map<COSObjectKey, Long> xrefOffset = xrefTrailerResolver.getXrefTable();    if (!validateXrefOffsets(xrefOffset)) {        Map<COSObjectKey, Long> bfCOSObjectKeyOffsets = getBFCOSObjectOffsets();        if (!bfCOSObjectKeyOffsets.isEmpty()) {                        xrefOffset.clear();            xrefOffset.putAll(bfCOSObjectKeyOffsets);        }    }}
private boolean pdfbox_f3155_1(COSObjectKey objectKey, long offset) throws IOException
{        if (offset < MINIMUM_SEARCH_OFFSET) {        return false;    }    boolean objectKeyFound = false;    try {        source.seek(offset);                if (objectKey.getNumber() == readObjectNumber()) {            int genNumber = readGenerationNumber();            if (genNumber == objectKey.getGeneration()) {                                readExpectedString(OBJ_MARKER, true);                objectKeyFound = true;            } else if (isLenient && genNumber > objectKey.getGeneration()) {                                readExpectedString(OBJ_MARKER, true);                objectKeyFound = true;                objectKey.fixGeneration(genNumber);            }        }    } catch (IOException exception) {                    }        return objectKeyFound;}
private Map<COSObjectKey, Long> pdfbox_f3156_0() throws IOException
{    if (bfSearchCOSObjectKeyOffsets == null) {        bfSearchForObjects();    }    return bfSearchCOSObjectKeyOffsets;}
private void pdfbox_f3157_0() throws IOException
{    bfSearchForLastEOFMarker();    bfSearchCOSObjectKeyOffsets = new HashMap<>();    long originOffset = source.getPosition();    long currentOffset = MINIMUM_SEARCH_OFFSET;    long lastObjectId = Long.MIN_VALUE;    int lastGenID = Integer.MIN_VALUE;    long lastObjOffset = Long.MIN_VALUE;    char[] endobjString = "ndo".toCharArray();    char[] endobjRemainingString = "bj".toCharArray();    boolean endOfObjFound = false;    do {        source.seek(currentOffset);        int nextChar = source.read();        currentOffset++;        if (isWhitespace(nextChar) && isString(OBJ_MARKER)) {            long tempOffset = currentOffset - 2;            source.seek(tempOffset);            int genID = source.peek();                        if (isDigit(genID)) {                genID -= 48;                tempOffset--;                source.seek(tempOffset);                if (isWhitespace()) {                    while (tempOffset > MINIMUM_SEARCH_OFFSET && isWhitespace()) {                        source.seek(--tempOffset);                    }                    boolean objectIDFound = false;                    while (tempOffset > MINIMUM_SEARCH_OFFSET && isDigit()) {                        source.seek(--tempOffset);                        objectIDFound = true;                    }                    if (objectIDFound) {                        source.read();                        long objectId = readObjectNumber();                        if (lastObjOffset > 0) {                                                        bfSearchCOSObjectKeyOffsets.put(new COSObjectKey(lastObjectId, lastGenID), lastObjOffset);                        }                        lastObjectId = objectId;                        lastGenID = genID;                        lastObjOffset = tempOffset + 1;                        currentOffset += OBJ_MARKER.length - 1;                        endOfObjFound = false;                    }                }            }        } else         if (nextChar == 'e' && isString(endobjString)) {            currentOffset += endobjString.length;            source.seek(currentOffset);            if (source.isEOF()) {                endOfObjFound = true;                continue;            }            if (isString(endobjRemainingString)) {                currentOffset += endobjRemainingString.length;                endOfObjFound = true;                continue;            }        }    } while (currentOffset < lastEOFMarker && !source.isEOF());    if ((lastEOFMarker < Long.MAX_VALUE || endOfObjFound) && lastObjOffset > 0) {                        bfSearchCOSObjectKeyOffsets.put(new COSObjectKey(lastObjectId, lastGenID), lastObjOffset);    }        source.seek(originOffset);}
private long pdfbox_f3158_0(long xrefOffset) throws IOException
{    long newOffset = -1;        bfSearchForXRefTables();        bfSearchForXRefStreams();        long newOffsetTable = searchNearestValue(bfSearchXRefTablesOffsets, xrefOffset);        long newOffsetStream = searchNearestValue(bfSearchXRefStreamsOffsets, xrefOffset);        if (newOffsetTable > -1 && newOffsetStream > -1) {        long differenceTable = xrefOffset - newOffsetTable;        long differenceStream = xrefOffset - newOffsetStream;        if (Math.abs(differenceTable) > Math.abs(differenceStream)) {            newOffset = newOffsetStream;            bfSearchXRefStreamsOffsets.remove(newOffsetStream);        } else {            newOffset = newOffsetTable;            bfSearchXRefTablesOffsets.remove(newOffsetTable);        }    } else if (newOffsetTable > -1) {        newOffset = newOffsetTable;        bfSearchXRefTablesOffsets.remove(newOffsetTable);    } else if (newOffsetStream > -1) {        newOffset = newOffsetStream;        bfSearchXRefStreamsOffsets.remove(newOffsetStream);    }    return newOffset;}
private long pdfbox_f3159_0(List<Long> values, long offset)
{    long newValue = -1;    Long currentDifference = null;    int currentOffsetIndex = -1;    int numberOfOffsets = values.size();        for (int i = 0; i < numberOfOffsets; i++) {        long newDifference = offset - values.get(i);                if (currentDifference == null || (Math.abs(currentDifference) > Math.abs(newDifference))) {            currentDifference = newDifference;            currentOffsetIndex = i;        }    }    if (currentOffsetIndex > -1) {        newValue = values.get(currentOffsetIndex);    }    return newValue;}
private boolean pdfbox_f3160_1(COSDictionary trailer) throws IOException
{    Map<String, COSDictionary> trailerDicts = new HashMap<>();    long originOffset = source.getPosition();    source.seek(MINIMUM_SEARCH_OFFSET);    while (!source.isEOF()) {                if (isString(TRAILER_MARKER)) {            source.seek(source.getPosition() + TRAILER_MARKER.length);            try {                boolean rootFound = false;                boolean infoFound = false;                skipSpaces();                COSDictionary trailerDict = parseCOSDictionary();                StringBuilder trailerKeys = new StringBuilder();                COSObject rootObj = trailerDict.getCOSObject(COSName.ROOT);                if (rootObj != null) {                    long objNumber = rootObj.getObjectNumber();                    int genNumber = rootObj.getGenerationNumber();                    trailerKeys.append(objNumber).append(" ");                    trailerKeys.append(genNumber).append(" ");                    rootFound = true;                }                COSObject infoObj = trailerDict.getCOSObject(COSName.INFO);                if (infoObj != null) {                    long objNumber = infoObj.getObjectNumber();                    int genNumber = infoObj.getGenerationNumber();                    trailerKeys.append(objNumber).append(" ");                    trailerKeys.append(genNumber).append(" ");                    infoFound = true;                }                if (rootFound && infoFound) {                    trailerDicts.put(trailerKeys.toString(), trailerDict);                }            } catch (IOException exception) {                                continue;            }        }        source.read();    }    source.seek(originOffset);        int trailerdictsSize = trailerDicts.size();    String firstEntry = null;    if (trailerdictsSize > 0) {        String[] keys = new String[trailerdictsSize];        trailerDicts.keySet().toArray(keys);        firstEntry = keys[0];        for (int i = 1; i < trailerdictsSize; i++) {            if (firstEntry.equals(keys[i])) {                trailerDicts.remove(keys[i]);            }        }    }        if (trailerDicts.size() == 1) {        boolean rootFound = false;        boolean infoFound = false;        COSDictionary trailerDict = trailerDicts.get(firstEntry);        COSBase rootObj = trailerDict.getItem(COSName.ROOT);        if (rootObj instanceof COSObject) {                        COSDictionary rootDict = retrieveCOSDictionary((COSObject) rootObj);            if (rootDict != null && isCatalog(rootDict)) {                rootFound = true;            }        }        COSBase infoObj = trailerDict.getItem(COSName.INFO);        if (infoObj instanceof COSObject) {                        COSDictionary infoDict = retrieveCOSDictionary((COSObject) infoObj);            if (infoDict != null && isInfo(infoDict)) {                infoFound = true;            }        }        if (rootFound && infoFound) {            trailer.setItem(COSName.ROOT, rootObj);            trailer.setItem(COSName.INFO, infoObj);            if (trailerDict.containsKey(COSName.ENCRYPT)) {                COSBase encObj = trailerDict.getItem(COSName.ENCRYPT);                if (encObj instanceof COSObject) {                                                            COSDictionary encDict = retrieveCOSDictionary((COSObject) encObj);                    if (encDict != null) {                        trailer.setItem(COSName.ENCRYPT, encObj);                    }                }            }            if (trailerDict.containsKey(COSName.ID)) {                COSBase idObj = trailerDict.getItem(COSName.ID);                if (idObj instanceof COSArray) {                    trailer.setItem(COSName.ID, idObj);                }            }            return true;        }    }    return false;}
private void pdfbox_f3161_1() throws IOException
{    if (lastEOFMarker == null) {        long originOffset = source.getPosition();        source.seek(MINIMUM_SEARCH_OFFSET);        while (!source.isEOF()) {                        if (isString(EOF_MARKER)) {                long tempMarker = source.getPosition();                source.seek(tempMarker + 5);                try {                                                                                skipSpaces();                    if (!isString(XREF_TABLE)) {                        readObjectNumber();                        readGenerationNumber();                    }                } catch (IOException exception) {                                                            lastEOFMarker = tempMarker;                }            }            source.read();        }        source.seek(originOffset);                if (lastEOFMarker == null) {            lastEOFMarker = Long.MAX_VALUE;        }    }}
private void pdfbox_f3162_1() throws IOException
{    HashMap<Long, COSObjectKey> bfSearchObjStreamsOffsets = new HashMap<>();    long originOffset = source.getPosition();    source.seek(MINIMUM_SEARCH_OFFSET);    char[] string = " obj".toCharArray();    while (!source.isEOF()) {                if (isString(OBJ_STREAM)) {            long currentPosition = source.getPosition();                        long newOffset = -1;            boolean objFound = false;            for (int i = 1; i < 40 && !objFound; i++) {                long currentOffset = currentPosition - (i * 10);                if (currentOffset > 0) {                    source.seek(currentOffset);                    for (int j = 0; j < 10; j++) {                        if (isString(string)) {                            long tempOffset = currentOffset - 1;                            source.seek(tempOffset);                            int genID = source.peek();                                                        if (isDigit(genID)) {                                tempOffset--;                                source.seek(tempOffset);                                if (isSpace()) {                                    int length = 0;                                    source.seek(--tempOffset);                                    while (tempOffset > MINIMUM_SEARCH_OFFSET && isDigit()) {                                        source.seek(--tempOffset);                                        length++;                                    }                                    if (length > 0) {                                        source.read();                                        newOffset = source.getPosition();                                        long objNumber = readObjectNumber();                                        int genNumber = readGenerationNumber();                                        COSObjectKey streamObjectKey = new COSObjectKey(objNumber, genNumber);                                        bfSearchObjStreamsOffsets.put(newOffset, streamObjectKey);                                    }                                }                            }                                                        objFound = true;                            break;                        } else {                            currentOffset++;                            source.read();                        }                    }                }            }            source.seek(currentPosition + OBJ_STREAM.length);        }        source.read();    }        for (Entry<Long, COSObjectKey> streamOffsetsEntry : bfSearchObjStreamsOffsets.entrySet()) {        Long offset = streamOffsetsEntry.getKey();        Long bfOffset = bfSearchCOSObjectKeyOffsets.get(streamOffsetsEntry.getValue());                if (bfOffset == null) {                        continue;        }                if (offset.equals(bfOffset)) {            source.seek(offset);            long stmObjNumber = readObjectNumber();            int stmGenNumber = readGenerationNumber();            readExpectedString(OBJ_MARKER, true);            int nrOfObjects = 0;            byte[] numbersBytes = null;            COSStream stream = null;            COSInputStream is = null;            try {                COSDictionary dict = parseCOSDictionary();                int offsetFirstStream = dict.getInt(COSName.FIRST);                nrOfObjects = dict.getInt(COSName.N);                                if (offsetFirstStream == -1 || nrOfObjects == -1) {                    continue;                }                stream = parseCOSStream(dict);                if (securityHandler != null) {                    securityHandler.decryptStream(stream, stmObjNumber, stmGenNumber);                }                is = stream.createInputStream();                numbersBytes = new byte[offsetFirstStream];                long isResult = is.read(numbersBytes);                if (Long.compare(isResult, numbersBytes.length) != 0) {                                    }            } catch (IOException exception) {                                continue;            } finally {                if (is != null) {                    is.close();                }                if (stream != null) {                    stream.close();                }            }            int start = 0;                        while (start < numbersBytes.length && numbersBytes[start] == 32) {                start++;            }            String numbersStr = new String(numbersBytes, start, numbersBytes.length - start, "ISO-8859-1");            numbersStr = numbersStr.replaceAll("\n", " ").replaceAll("  ", " ");            String[] numbers = numbersStr.split(" ");            if (numbers.length < nrOfObjects * 2) {                                continue;            }            Map<COSObjectKey, Long> xrefOffset = xrefTrailerResolver.getXrefTable();            for (int i = 0; i < nrOfObjects; i++) {                try {                    long objNumber = Long.parseLong(numbers[i * 2]);                    COSObjectKey objKey = new COSObjectKey(objNumber, 0);                    Long existingOffset = bfSearchCOSObjectKeyOffsets.get(objKey);                    if (existingOffset != null && existingOffset < 0) {                                                COSObjectKey objStmKey = new COSObjectKey(Math.abs(existingOffset), 0);                        existingOffset = bfSearchCOSObjectKeyOffsets.get(objStmKey);                    }                    if (existingOffset == null || offset > existingOffset) {                        bfSearchCOSObjectKeyOffsets.put(objKey, -stmObjNumber);                        xrefOffset.put(objKey, -stmObjNumber);                    }                } catch (NumberFormatException exception) {                                    }            }        }    }    source.seek(originOffset);}
private void pdfbox_f3163_0() throws IOException
{    if (bfSearchXRefTablesOffsets == null) {                bfSearchXRefTablesOffsets = new ArrayList<>();        long originOffset = source.getPosition();        source.seek(MINIMUM_SEARCH_OFFSET);                while (!source.isEOF()) {            if (isString(XREF_TABLE)) {                long newOffset = source.getPosition();                source.seek(newOffset - 1);                                if (isWhitespace()) {                    bfSearchXRefTablesOffsets.add(newOffset);                }                source.seek(newOffset + 4);            }            source.read();        }        source.seek(originOffset);    }}
private void pdfbox_f3164_1() throws IOException
{    if (bfSearchXRefStreamsOffsets == null) {                bfSearchXRefStreamsOffsets = new ArrayList<>();        long originOffset = source.getPosition();        source.seek(MINIMUM_SEARCH_OFFSET);                String objString = " obj";        char[] string = objString.toCharArray();        while (!source.isEOF()) {            if (isString(XREF_STREAM)) {                                long newOffset = -1;                long xrefOffset = source.getPosition();                boolean objFound = false;                for (int i = 1; i < 40 && !objFound; i++) {                    long currentOffset = xrefOffset - (i * 10);                    if (currentOffset > 0) {                        source.seek(currentOffset);                        for (int j = 0; j < 10; j++) {                            if (isString(string)) {                                long tempOffset = currentOffset - 1;                                source.seek(tempOffset);                                int genID = source.peek();                                                                if (isDigit(genID)) {                                    tempOffset--;                                    source.seek(tempOffset);                                    if (isSpace()) {                                        int length = 0;                                        source.seek(--tempOffset);                                        while (tempOffset > MINIMUM_SEARCH_OFFSET && isDigit()) {                                            source.seek(--tempOffset);                                            length++;                                        }                                        if (length > 0) {                                            source.read();                                            newOffset = source.getPosition();                                        }                                    }                                }                                                                objFound = true;                                break;                            } else {                                currentOffset++;                                source.read();                            }                        }                    }                }                if (newOffset > -1) {                    bfSearchXRefStreamsOffsets.add(newOffset);                }                source.seek(xrefOffset + 5);            }            source.read();        }        source.seek(originOffset);    }}
private COSDictionary pdfbox_f3165_0() throws IOException
{    COSDictionary trailer = null;    bfSearchForObjects();    if (bfSearchCOSObjectKeyOffsets != null) {                xrefTrailerResolver.reset();                xrefTrailerResolver.nextXrefObj(0, XRefType.TABLE);        for (Entry<COSObjectKey, Long> entry : bfSearchCOSObjectKeyOffsets.entrySet()) {            xrefTrailerResolver.setXRef(entry.getKey(), entry.getValue());        }        xrefTrailerResolver.setStartxref(0);        trailer = xrefTrailerResolver.getTrailer();        getDocument().setTrailer(trailer);        boolean searchForObjStreamsDone = false;        if (!bfSearchForTrailer(trailer) && !searchForTrailerItems(trailer)) {                        bfSearchForObjStreams();            searchForObjStreamsDone = true;                        searchForTrailerItems(trailer);        }                prepareDecryption();        if (!searchForObjStreamsDone) {            bfSearchForObjStreams();        }    }    trailerWasRebuild = true;    return trailer;}
private boolean pdfbox_f3166_0(COSDictionary trailer) throws IOException
{    boolean rootFound = false;    for (Entry<COSObjectKey, Long> entry : bfSearchCOSObjectKeyOffsets.entrySet()) {        COSDictionary dictionary = retrieveCOSDictionary(entry.getKey(), entry.getValue());        if (dictionary == null) {            continue;        }                if (isCatalog(dictionary)) {            trailer.setItem(COSName.ROOT, document.getObjectFromPool(entry.getKey()));            rootFound = true;        } else         if (isInfo(dictionary)) {            trailer.setItem(COSName.INFO, document.getObjectFromPool(entry.getKey()));        }            }    return rootFound;}
private COSDictionary pdfbox_f3167_0(COSObject object) throws IOException
{    COSObjectKey key = new COSObjectKey(object);    Long offset = bfSearchCOSObjectKeyOffsets.get(key);    if (offset != null) {        return retrieveCOSDictionary(key, offset);    }    return null;}
private COSDictionary pdfbox_f3168_1(COSObjectKey key, long offset) throws IOException
{    COSDictionary dictionary = null;        if (offset < 0) {        COSObject compressedObject = document.getObjectFromPool(key);        if (compressedObject.getObject() == null) {            parseObjectStream((int) -offset);        }        COSBase baseObject = compressedObject.getObject();        if (baseObject instanceof COSDictionary) {            dictionary = (COSDictionary) baseObject;        }    } else {        source.seek(offset);        readObjectNumber();        readGenerationNumber();        readExpectedString(OBJ_MARKER, true);        if (source.peek() != '<') {            return null;        }        try {            dictionary = parseCOSDictionary();        } catch (IOException exception) {                    }    }    return dictionary;}
protected void pdfbox_f3169_0(COSDictionary root) throws IOException
{    if (trailerWasRebuild) {                COSBase pages = root.getDictionaryObject(COSName.PAGES);        if (pages instanceof COSDictionary) {            checkPagesDictionary((COSDictionary) pages, new HashSet<COSObject>());        }    }    if (!(root.getDictionaryObject(COSName.PAGES) instanceof COSDictionary)) {        throw new IOException("Page tree root must be a dictionary");    }}
private int pdfbox_f3170_1(COSDictionary pagesDict, Set<COSObject> set)
{        COSBase kids = pagesDict.getDictionaryObject(COSName.KIDS);    int numberOfPages = 0;    if (kids instanceof COSArray) {        COSArray kidsArray = (COSArray) kids;        List<? extends COSBase> kidsList = kidsArray.toList();        for (COSBase kid : kidsList) {            if (!(kid instanceof COSObject) || set.contains((COSObject) kid)) {                kidsArray.remove(kid);                continue;            }            COSObject kidObject = (COSObject) kid;            COSBase kidBaseobject = kidObject.getObject();                        if (kidBaseobject == null || kidBaseobject.equals(COSNull.NULL)) {                                kidsArray.remove(kid);            } else if (kidBaseobject instanceof COSDictionary) {                COSDictionary kidDictionary = (COSDictionary) kidBaseobject;                COSName type = kidDictionary.getCOSName(COSName.TYPE);                if (COSName.PAGES.equals(type)) {                                        set.add(kidObject);                    numberOfPages += checkPagesDictionary(kidDictionary, set);                } else if (COSName.PAGE.equals(type)) {                                        numberOfPages++;                }            }        }    }        pagesDict.setInt(COSName.COUNT, numberOfPages);    return numberOfPages;}
protected boolean pdfbox_f3171_0(COSDictionary dictionary)
{    return COSName.CATALOG.equals(dictionary.getCOSName(COSName.TYPE));}
private boolean pdfbox_f3172_0(COSDictionary dictionary)
{    if (dictionary.containsKey(COSName.PARENT) || dictionary.containsKey(COSName.A) || dictionary.containsKey(COSName.DEST)) {        return false;    }    if (!dictionary.containsKey(COSName.MOD_DATE) && !dictionary.containsKey(COSName.TITLE) && !dictionary.containsKey(COSName.AUTHOR) && !dictionary.containsKey(COSName.SUBJECT) && !dictionary.containsKey(COSName.KEYWORDS) && !dictionary.containsKey(COSName.CREATOR) && !dictionary.containsKey(COSName.PRODUCER) && !dictionary.containsKey(COSName.CREATION_DATE)) {        return false;    }    return true;}
private long pdfbox_f3173_0() throws IOException
{    long startXref = -1;    if (isString(STARTXREF)) {        readString();        skipSpaces();                startXref = readLong();    }    return startXref;}
private boolean pdfbox_f3174_0(byte[] string) throws IOException
{    boolean bytesMatching = false;    if (source.peek() == string[0]) {        int length = string.length;        byte[] bytesRead = new byte[length];        int numberOfBytes = source.read(bytesRead, 0, length);        while (numberOfBytes < length) {            int readMore = source.read(bytesRead, numberOfBytes, length - numberOfBytes);            if (readMore < 0) {                break;            }            numberOfBytes += readMore;        }        bytesMatching = Arrays.equals(string, bytesRead);        source.rewind(numberOfBytes);    }    return bytesMatching;}
private boolean pdfbox_f3175_0(char[] string) throws IOException
{    boolean bytesMatching = true;    long originOffset = source.getPosition();    for (char c : string) {        if (source.read() != c) {            bytesMatching = false;            break;        }    }    source.seek(originOffset);    return bytesMatching;}
private boolean pdfbox_f3176_1() throws IOException
{        trailerOffset = source.getPosition();        if (isLenient) {        int nextCharacter = source.peek();        while (nextCharacter != 't' && isDigit(nextCharacter)) {            if (source.getPosition() == trailerOffset) {                                            }            readLine();            nextCharacter = source.peek();        }    }    if (source.peek() != 't') {        return false;    }        long currentOffset = source.getPosition();    String nextLine = readLine();    if (!nextLine.trim().equals("trailer")) {                if (nextLine.startsWith("trailer")) {                        int len = "trailer".length();                        source.seek(currentOffset + len);        } else {            return false;        }    }                skipSpaces();    COSDictionary parsedTrailer = parseCOSDictionary();    xrefTrailerResolver.setTrailer(parsedTrailer);    skipSpaces();    return true;}
protected boolean pdfbox_f3177_0() throws IOException
{    return parseHeader(PDF_HEADER, PDF_DEFAULT_VERSION);}
protected boolean pdfbox_f3178_0() throws IOException
{    return parseHeader(FDF_HEADER, FDF_DEFAULT_VERSION);}
private boolean pdfbox_f3179_1(String headerMarker, String defaultVersion) throws IOException
{        String header = readLine();        if (!header.contains(headerMarker)) {        header = readLine();        while (!header.contains(headerMarker)) {                        if ((header.length() > 0) && (Character.isDigit(header.charAt(0)))) {                break;            }            header = readLine();        }    }        if (!header.contains(headerMarker)) {        source.seek(0);        return false;    }            int headerStart = header.indexOf(headerMarker);        if (headerStart > 0) {                header = header.substring(headerStart, header.length());    }        if (header.startsWith(headerMarker) && !header.matches(headerMarker + "\\d.\\d")) {        if (header.length() < headerMarker.length() + 3) {                        header = headerMarker + defaultVersion;                    } else {            String headerGarbage = header.substring(headerMarker.length() + 3, header.length()) + "\n";            header = header.substring(0, headerMarker.length() + 3);            source.rewind(headerGarbage.getBytes(ISO_8859_1).length);        }    }    float headerVersion = -1;    try {        String[] headerParts = header.split("-");        if (headerParts.length == 2) {            headerVersion = Float.parseFloat(headerParts[1]);        }    } catch (NumberFormatException exception) {            }    if (headerVersion < 0) {        if (isLenient) {            headerVersion = 1.7f;        } else {            throw new IOException("Error getting header version: " + header);        }    }    document.setVersion(headerVersion);        source.seek(0);    return true;}
protected boolean pdfbox_f3180_1(long startByteOffset) throws IOException
{    if (source.peek() != 'x') {        return false;    }    String xref = readString();    if (!xref.trim().equals("xref")) {        return false;    }        String str = readString();    byte[] b = str.getBytes(ISO_8859_1);    source.rewind(b.length);        xrefTrailerResolver.nextXrefObj(startByteOffset, XRefType.TABLE);    if (str.startsWith("trailer")) {                return false;    }        while (true) {        String currentLine = readLine();        String[] splitString = currentLine.split("\\s");        if (splitString.length != 2) {                        return false;        }                long currObjID;        try {            currObjID = Long.parseLong(splitString[0]);        } catch (NumberFormatException exception) {                        return false;        }                int count = 0;        try {            count = Integer.parseInt(splitString[1]);        } catch (NumberFormatException exception) {                        return false;        }        skipSpaces();        for (int i = 0; i < count; i++) {            if (source.isEOF() || isEndOfName((char) source.peek())) {                break;            }            if (source.peek() == 't') {                break;            }                        currentLine = readLine();            splitString = currentLine.split("\\s");            if (splitString.length < 3) {                                break;            }            /* This supports the corrupt table as reported in                 * PDFBOX-474 (XXXX XXX XX n) */            if (splitString[splitString.length - 1].equals("n")) {                try {                    long currOffset = Long.parseLong(splitString[0]);                    int currGenID = Integer.parseInt(splitString[1]);                    COSObjectKey objKey = new COSObjectKey(currObjID, currGenID);                    xrefTrailerResolver.setXRef(objKey, currOffset);                } catch (NumberFormatException e) {                    throw new IOException(e);                }            } else if (!splitString[2].equals("f")) {                throw new IOException("Corrupt XRefTable Entry - ObjID:" + currObjID);            }            currObjID++;            skipSpaces();        }        skipSpaces();        if (!isDigit()) {            break;        }    }    return true;}
private void pdfbox_f3181_0(COSStream stream, long objByteOffset, boolean isStandalone) throws IOException
{        if (isStandalone) {        xrefTrailerResolver.nextXrefObj(objByteOffset, XRefType.STREAM);        xrefTrailerResolver.setTrailer(stream);    }    PDFXrefStreamParser parser = new PDFXrefStreamParser(stream, document, xrefTrailerResolver);    parser.parse();}
public COSDocument pdfbox_f3182_0() throws IOException
{    if (document == null) {        throw new IOException("You must parse the document first before calling getDocument()");    }    return document;}
public PDEncryption pdfbox_f3183_0() throws IOException
{    if (document == null) {        throw new IOException("You must parse the document first before calling getEncryption()");    }    return encryption;}
public AccessPermission pdfbox_f3184_0() throws IOException
{    if (document == null) {        throw new IOException("You must parse the document first before calling getAccessPermission()");    }    return accessPermission;}
protected COSBase pdfbox_f3185_0(COSDictionary trailer) throws IOException
{        for (COSBase trailerEntry : trailer.getValues()) {        if (trailerEntry instanceof COSObject) {            COSObject tmpObj = (COSObject) trailerEntry;            parseObjectDynamically(tmpObj, false);        }    }        COSObject root = trailer.getCOSObject(COSName.ROOT);    if (root == null) {        throw new IOException("Missing root object specification in trailer.");    }    return root.getObject();}
private void pdfbox_f3186_0() throws IOException
{    if (encryption != null) {        return;    }    COSBase trailerEncryptItem = document.getTrailer().getItem(COSName.ENCRYPT);    if (trailerEncryptItem == null || trailerEncryptItem instanceof COSNull) {        return;    }    if (trailerEncryptItem instanceof COSObject) {        COSObject trailerEncryptObj = (COSObject) trailerEncryptItem;        parseDictionaryRecursive(trailerEncryptObj);    }    try {        encryption = new PDEncryption(document.getEncryptionDictionary());        DecryptionMaterial decryptionMaterial;        if (keyStoreInputStream != null) {            KeyStore ks = KeyStore.getInstance("PKCS12");            ks.load(keyStoreInputStream, password.toCharArray());            decryptionMaterial = new PublicKeyDecryptionMaterial(ks, keyAlias, password);        } else {            decryptionMaterial = new StandardDecryptionMaterial(password);        }        securityHandler = encryption.getSecurityHandler();        securityHandler.prepareForDecryption(encryption, document.getDocumentID(), decryptionMaterial);        accessPermission = securityHandler.getCurrentAccessPermission();    } catch (IOException e) {        throw e;    } catch (GeneralSecurityException e) {        throw new IOException("Error (" + e.getClass().getSimpleName() + ") while creating security handler for decryption", e);    } finally {        if (keyStoreInputStream != null) {            IOUtils.closeQuietly(keyStoreInputStream);        }    }}
private void pdfbox_f3187_0(COSObject dictionaryObject) throws IOException
{    parseObjectDynamically(dictionaryObject, true);    if (!(dictionaryObject.getObject() instanceof COSDictionary)) {                throw new IOException("Dictionary object expected at offset " + source.getPosition());    }    COSDictionary dictionary = (COSDictionary) dictionaryObject.getObject();    for (COSBase value : dictionary.getValues()) {        if (value instanceof COSObject) {            COSObject object = (COSObject) value;            if (object.getObject() == null) {                parseDictionaryRecursive(object);            }        }    }}
public void pdfbox_f3188_0(byte[] b, int off, int len) throws IOException
{    if (pos == 0 && len > 10) {                mustFilter = false;        for (int i = 0; i < 10; ++i) {                        if ((b[i] < 0x09) || ((b[i] > 0x0a) && (b[i] < 0x20) && (b[i] != 0x0d))) {                                mustFilter = true;                break;            }        }    }    if (mustFilter) {                if (hasCR) {                        hasCR = false;            if (!hasLF && len == 1 && b[off] == '\n') {                                return;            }            super.write('\r');        }        if (hasLF) {            super.write('\n');            hasLF = false;        }                if (len > 0) {            if (b[off + len - 1] == '\r') {                hasCR = true;                --len;            } else if (b[off + len - 1] == '\n') {                hasLF = true;                --len;                if (len > 0 && b[off + len - 1] == '\r') {                    hasCR = true;                    --len;                }            }        }    }    super.write(b, off, len);    pos += len;}
public void pdfbox_f3189_0() throws IOException
{        if (hasCR && !hasLF) {        super.write('\r');        ++pos;    }    hasCR = false;    hasLF = false;    super.flush();}
protected final boolean pdfbox_f3190_0(COSDictionary dictionary)
{    return dictionary.containsKey(COSName.FDF);}
private void pdfbox_f3191_1() throws IOException
{    String eofLookupRangeStr = System.getProperty(SYSPROP_EOFLOOKUPRANGE);    if (eofLookupRangeStr != null) {        try {            setEOFLookupRange(Integer.parseInt(eofLookupRangeStr));        } catch (NumberFormatException nfe) {                    }    }    document = new COSDocument();}
private void pdfbox_f3192_0() throws IOException
{    COSDictionary trailer = retrieveTrailer();    COSBase rootObject = parseTrailerValuesDynamically(trailer);        if (rootObject instanceof COSDictionary) {        parseDictObjects((COSDictionary) rootObject, (COSName[]) null);    }    initialParseDone = true;}
public void pdfbox_f3193_0() throws IOException
{        boolean exceptionOccurred = true;    try {        if (!parseFDFHeader()) {            throw new IOException("Error: Header doesn't contain versioninfo");        }        initialParse();        exceptionOccurred = false;    } finally {        if (exceptionOccurred && document != null) {            IOUtils.closeQuietly(document);            document = null;        }    }}
public int pdfbox_f3194_0() throws IOException
{    int b = input.read();    position++;    return b;}
public int pdfbox_f3195_0(byte[] b) throws IOException
{    int n = input.read(b);    if (n > 0) {        position += n;        return n;    } else {        return -1;    }}
public int pdfbox_f3196_0(byte[] b, int offset, int length) throws IOException
{    int n = input.read(b, offset, length);    if (n > 0) {        position += n;        return n;    } else {        return -1;    }}
public long pdfbox_f3197_0() throws IOException
{    return position;}
public int pdfbox_f3198_0() throws IOException
{    int b = input.read();    if (b != -1) {        input.unread(b);    }    return b;}
public void pdfbox_f3199_0(int b) throws IOException
{    input.unread(b);    position--;}
public void pdfbox_f3200_0(byte[] bytes) throws IOException
{    input.unread(bytes);    position -= bytes.length;}
public void pdfbox_f3201_0(byte[] bytes, int start, int len) throws IOException
{    input.unread(bytes, start, len);    position -= len - start;}
public byte[] pdfbox_f3202_0(int length) throws IOException
{    byte[] bytes = new byte[length];    int off = 0;    int len = length;    while (len > 0) {        int n = this.read(bytes, off, len);        if (n > 0) {            off += n;            len -= n;            position += n;        } else {            break;        }    }    return bytes;}
public boolean pdfbox_f3203_0() throws IOException
{    return peek() == -1;}
public void pdfbox_f3204_0() throws IOException
{    input.close();}
public void pdfbox_f3205_1() throws IOException
{    try {                int numberOfObjects = stream.getInt("N");        if (numberOfObjects == -1) {            throw new IOException("/N entry missing in object stream");        }        List<Long> objectNumbers = new ArrayList<>(numberOfObjects);        streamObjects = new ArrayList<>(numberOfObjects);        for (int i = 0; i < numberOfObjects; i++) {            long objectNumber = readObjectNumber();                        readLong();            objectNumbers.add(objectNumber);        }        COSObject object;        COSBase cosObject;        int objectCounter = 0;        while ((cosObject = parseDirObject()) != null) {            object = new COSObject(cosObject);            object.setGenerationNumber(0);            if (objectCounter >= objectNumbers.size()) {                                break;            }            object.setObjectNumber(objectNumbers.get(objectCounter));            streamObjects.add(object);            if (LOG.isDebugEnabled()) {                            }                        if (!seqSource.isEOF() && seqSource.peek() == 'e') {                readLine();            }            objectCounter++;        }    } finally {        seqSource.close();    }}
public List<COSObject> pdfbox_f3206_0()
{    return streamObjects;}
private void pdfbox_f3207_1(ScratchFile scratchFile) throws IOException
{    String eofLookupRangeStr = System.getProperty(SYSPROP_EOFLOOKUPRANGE);    if (eofLookupRangeStr != null) {        try {            setEOFLookupRange(Integer.parseInt(eofLookupRangeStr));        } catch (NumberFormatException nfe) {                    }    }    document = new COSDocument(scratchFile);}
public PDDocument pdfbox_f3208_0() throws IOException
{    PDDocument doc = new PDDocument(getDocument(), source, getAccessPermission());    doc.setEncryptionDictionary(getEncryption());    return doc;}
protected void pdfbox_f3209_0() throws IOException
{    COSDictionary trailer = retrieveTrailer();    COSBase base = parseTrailerValuesDynamically(trailer);    if (!(base instanceof COSDictionary)) {        throw new IOException("Expected root dictionary, but got this: " + base);    }    COSDictionary root = (COSDictionary) base;        if (isLenient() && !root.containsKey(COSName.TYPE)) {        root.setItem(COSName.TYPE, COSName.CATALOG);    }        parseDictObjects(root, (COSName[]) null);        COSBase infoBase = trailer.getDictionaryObject(COSName.INFO);    if (infoBase instanceof COSDictionary) {        parseDictObjects((COSDictionary) infoBase, (COSName[]) null);    }        checkPages(root);    document.setDecrypted();    initialParseDone = true;}
public void pdfbox_f3210_0() throws IOException
{        boolean exceptionOccurred = true;    try {                if (!parsePDFHeader() && !parseFDFHeader()) {            throw new IOException("Error: Header doesn't contain versioninfo");        }        if (!initialParseDone) {            initialParse();        }        exceptionOccurred = false;    } finally {        if (exceptionOccurred && document != null) {            IOUtils.closeQuietly(document);            document = null;        }    }}
public void pdfbox_f3211_0() throws IOException
{    Object token;    while ((token = parseNextToken()) != null) {        streamObjects.add(token);    }}
public List<Object> pdfbox_f3212_0()
{    return streamObjects;}
public Object pdfbox_f3213_1() throws IOException
{    Object retval;    skipSpaces();    int nextByte = seqSource.peek();    if (((byte) nextByte) == -1) {        return null;    }    char c = (char) nextByte;    switch(c) {        case '<':            {                                int leftBracket = seqSource.read();                                c = (char) seqSource.peek();                                seqSource.unread(leftBracket);                if (c == '<') {                    retval = parseCOSDictionary();                } else {                    retval = parseCOSString();                }                break;            }        case '[':            {                                retval = parseCOSArray();                break;            }        case '(':                        retval = parseCOSString();            break;        case '/':                        retval = parseCOSName();            break;        case 'n':            {                                String nullString = readString();                if (nullString.equals("null")) {                    retval = COSNull.NULL;                } else {                    retval = Operator.getOperator(nullString);                }                break;            }        case 't':        case 'f':            {                String next = readString();                if (next.equals("true")) {                    retval = COSBoolean.TRUE;                    break;                } else if (next.equals("false")) {                    retval = COSBoolean.FALSE;                } else {                    retval = Operator.getOperator(next);                }                break;            }        case 'R':            {                String line = readString();                if (line.equals("R")) {                    retval = new COSObject(null);                } else {                    retval = Operator.getOperator(line);                }                break;            }        case '0':        case '1':        case '2':        case '3':        case '4':        case '5':        case '6':        case '7':        case '8':        case '9':        case '-':        case '+':        case '.':            {                /* We will be filling buf with the rest of the number.  Only                 * allow 1 "." and "-" and "+" at start of number. */                StringBuilder buf = new StringBuilder();                buf.append(c);                seqSource.read();                                if (c == '-' && seqSource.peek() == c) {                    seqSource.read();                }                boolean dotNotRead = c != '.';                while (Character.isDigit(c = (char) seqSource.peek()) || dotNotRead && c == '.' || c == '-') {                    if (c != '-') {                                                buf.append(c);                    }                    seqSource.read();                    if (dotNotRead && c == '.') {                        dotNotRead = false;                    }                }                retval = COSNumber.get(buf.toString());                break;            }        case 'B':            {                String next = readString();                retval = Operator.getOperator(next);                if (next.equals(OperatorName.BEGIN_INLINE_IMAGE)) {                    Operator beginImageOP = (Operator) retval;                    COSDictionary imageParams = new COSDictionary();                    beginImageOP.setImageParameters(imageParams);                    Object nextToken = null;                    while ((nextToken = parseNextToken()) instanceof COSName) {                        Object value = parseNextToken();                        imageParams.setItem((COSName) nextToken, (COSBase) value);                    }                                        if (nextToken instanceof Operator) {                        Operator imageData = (Operator) nextToken;                        if (imageData.getImageData() == null || imageData.getImageData().length == 0) {                                                    }                        beginImageOP.setImageData(imageData.getImageData());                    }                }                break;            }        case 'I':            {                                String id = Character.toString((char) seqSource.read()) + (char) seqSource.read();                if (!id.equals(OperatorName.BEGIN_INLINE_IMAGE_DATA)) {                    throw new IOException("Error: Expected operator 'ID' actual='" + id + "' at stream offset " + seqSource.getPosition());                }                ByteArrayOutputStream imageData = new ByteArrayOutputStream();                if (isWhitespace()) {                                        seqSource.read();                }                int lastByte = seqSource.read();                int currentByte = seqSource.read();                                while (!(lastByte == 'E' && currentByte == 'I' && hasNextSpaceOrReturn() && hasNoFollowingBinData(seqSource)) && !seqSource.isEOF()) {                    imageData.write(lastByte);                    lastByte = currentByte;                    currentByte = seqSource.read();                }                                retval = Operator.getOperator(OperatorName.BEGIN_INLINE_IMAGE_DATA);                                ((Operator) retval).setImageData(imageData.toByteArray());                break;            }        case ']':            {                                                seqSource.read();                                retval = COSNull.NULL;                break;            }        default:            {                                String operator = readOperator();                if (operator.trim().length() == 0) {                                        retval = null;                } else {                    retval = Operator.getOperator(operator);                }            }    }    return retval;}
private boolean pdfbox_f3214_1(SequentialSource pdfSource) throws IOException
{        final int readBytes = pdfSource.read(binCharTestArr, 0, MAX_BIN_CHAR_TEST_LENGTH);    boolean noBinData = true;    int startOpIdx = -1;    int endOpIdx = -1;    if (readBytes > 0) {        for (int bIdx = 0; bIdx < readBytes; bIdx++) {            final byte b = binCharTestArr[bIdx];            if (b != 0 && b < 0x09 || b > 0x0a && b < 0x20 && b != 0x0d) {                                noBinData = false;                break;            }                        if (startOpIdx == -1 && !(b == 0 || b == 9 || b == 0x20 || b == 0x0a || b == 0x0d)) {                startOpIdx = bIdx;            } else if (startOpIdx != -1 && endOpIdx == -1 && (b == 0 || b == 9 || b == 0x20 || b == 0x0a || b == 0x0d)) {                endOpIdx = bIdx;            }        }                if (endOpIdx != -1 && startOpIdx != -1) {                        String s = new String(binCharTestArr, startOpIdx, endOpIdx - startOpIdx);            if (!"Q".equals(s) && !"EMC".equals(s) && !"S".equals(s)) {                noBinData = false;            }        }                if (readBytes == MAX_BIN_CHAR_TEST_LENGTH) {                        if (startOpIdx != -1 && endOpIdx == -1) {                endOpIdx = MAX_BIN_CHAR_TEST_LENGTH;            }            if (endOpIdx != -1 && startOpIdx != -1 && endOpIdx - startOpIdx > 3) {                noBinData = false;            }        }        pdfSource.unread(binCharTestArr, 0, readBytes);    }    if (!noBinData) {            }    return noBinData;}
protected String pdfbox_f3215_0() throws IOException
{    skipSpaces();            StringBuilder buffer = new StringBuilder(4);    int nextChar = seqSource.peek();    while (    nextChar != -1 && !isWhitespace(nextChar) && !isClosing(nextChar) && nextChar != '[' && nextChar != '<' && nextChar != '(' && nextChar != '/' && (nextChar < '0' || nextChar > '9')) {        char currentChar = (char) seqSource.read();        nextChar = seqSource.peek();        buffer.append(currentChar);                if (currentChar == 'd' && (nextChar == '0' || nextChar == '1')) {            buffer.append((char) seqSource.read());            nextChar = seqSource.peek();        }    }    return buffer.toString();}
private boolean pdfbox_f3216_0(int c)
{    return c == 10 || c == 13 || c == 32;}
private boolean pdfbox_f3217_0() throws IOException
{    return isSpaceOrReturn(seqSource.peek());}
public COSStream pdfbox_f3218_0() throws IOException
{    stream.setItem(COSName.TYPE, COSName.XREF);    if (size == -1) {        throw new IllegalArgumentException("size is not set in xrefstream");    }    stream.setLong(COSName.SIZE, size);    List<Long> indexEntry = getIndexEntry();    COSArray indexAsArray = new COSArray();    for (Long i : indexEntry) {        indexAsArray.add(COSInteger.get(i));    }    stream.setItem(COSName.INDEX, indexAsArray);    int[] wEntry = getWEntry();    COSArray wAsArray = new COSArray();    for (int j : wEntry) {        wAsArray.add(COSInteger.get(j));    }    stream.setItem(COSName.W, wAsArray);    try (OutputStream outputStream = this.stream.createOutputStream(COSName.FLATE_DECODE)) {        writeStreamData(outputStream, wEntry);        outputStream.flush();    }    Set<COSName> keySet = this.stream.keySet();    for (COSName cosName : keySet) {                if (COSName.ROOT.equals(cosName) || COSName.INFO.equals(cosName) || COSName.PREV.equals(cosName)) {            continue;        }                if (COSName.ENCRYPT.equals(cosName)) {            continue;        }        COSBase dictionaryObject = this.stream.getDictionaryObject(cosName);        dictionaryObject.setDirect(true);    }    return this.stream;}
public void pdfbox_f3219_0(COSDictionary trailerDict)
{    Set<Entry<COSName, COSBase>> entrySet = trailerDict.entrySet();    for (Entry<COSName, COSBase> entry : entrySet) {        COSName key = entry.getKey();        if (COSName.INFO.equals(key) || COSName.ROOT.equals(key) || COSName.ENCRYPT.equals(key) || COSName.ID.equals(key) || COSName.PREV.equals(key)) {            stream.setItem(key, entry.getValue());        }    }}
public void pdfbox_f3220_0(COSWriterXRefEntry entry)
{    objectNumbers.add(entry.getKey().getNumber());    if (entry.isFree()) {                FreeReference value = new FreeReference();        value.nextGenNumber = entry.getKey().getGeneration();        value.nextFree = entry.getKey().getNumber();        streamData.put(value.nextFree, value);    } else {                        NormalReference value = new NormalReference();        value.genNumber = entry.getKey().getGeneration();        value.offset = entry.getOffset();        streamData.put(entry.getKey().getNumber(), value);    }}
private int[] pdfbox_f3221_0()
{    long[] wMax = new long[3];    for (Object entry : streamData.values()) {        if (entry instanceof FreeReference) {            FreeReference free = (FreeReference) entry;                        wMax[0] = Math.max(wMax[0], ENTRY_FREE);            wMax[1] = Math.max(wMax[1], free.nextFree);            wMax[2] = Math.max(wMax[2], free.nextGenNumber);        } else if (entry instanceof NormalReference) {            NormalReference ref = (NormalReference) entry;                        wMax[0] = Math.max(wMax[0], ENTRY_NORMAL);            wMax[1] = Math.max(wMax[1], ref.offset);            wMax[2] = Math.max(wMax[2], ref.genNumber);        } else if (entry instanceof ObjectStreamReference) {            ObjectStreamReference objStream = (ObjectStreamReference) entry;                        wMax[0] = Math.max(wMax[0], ENTRY_OBJSTREAM);            wMax[1] = Math.max(wMax[1], objStream.offset);            wMax[2] = Math.max(wMax[2], objStream.objectNumberOfObjectStream);        } else         {            throw new RuntimeException("unexpected reference type");        }    }        int[] w = new int[3];    for (int i = 0; i < w.length; i++) {        while (wMax[i] > 0) {            w[i]++;            wMax[i] >>= 8;        }    }    return w;}
public void pdfbox_f3222_0(long streamSize)
{    this.size = streamSize;}
private List<Long> pdfbox_f3223_0()
{    LinkedList<Long> linkedList = new LinkedList<>();    Long first = null;    Long length = null;    Set<Long> objNumbers = new TreeSet<>();        objNumbers.add(0L);    objNumbers.addAll(objectNumbers);    for (Long objNumber : objNumbers) {        if (first == null) {            first = objNumber;            length = 1L;        }        if (first + length == objNumber) {            length += 1;        }        if (first + length < objNumber) {            linkedList.add(first);            linkedList.add(length);            first = objNumber;            length = 1L;        }    }    linkedList.add(first);    linkedList.add(length);    return linkedList;}
private void pdfbox_f3224_0(OutputStream os, long number, int bytes) throws IOException
{    byte[] buffer = new byte[bytes];    for (int i = 0; i < bytes; i++) {        buffer[i] = (byte) (number & 0xff);        number >>= 8;    }    for (int i = 0; i < bytes; i++) {        os.write(buffer[bytes - i - 1]);    }}
private void pdfbox_f3225_0(OutputStream os, int[] w) throws IOException
{        writeNumber(os, ENTRY_FREE, w[0]);    writeNumber(os, ENTRY_FREE, w[1]);    writeNumber(os, 0xFFFF, w[2]);        for (Object entry : streamData.values()) {        if (entry instanceof FreeReference) {            FreeReference free = (FreeReference) entry;            writeNumber(os, ENTRY_FREE, w[0]);            writeNumber(os, free.nextFree, w[1]);            writeNumber(os, free.nextGenNumber, w[2]);        } else if (entry instanceof NormalReference) {            NormalReference ref = (NormalReference) entry;            writeNumber(os, ENTRY_NORMAL, w[0]);            writeNumber(os, ref.offset, w[1]);            writeNumber(os, ref.genNumber, w[2]);        } else if (entry instanceof ObjectStreamReference) {            ObjectStreamReference objStream = (ObjectStreamReference) entry;            writeNumber(os, ENTRY_OBJSTREAM, w[0]);            writeNumber(os, objStream.offset, w[1]);            writeNumber(os, objStream.objectNumberOfObjectStream, w[2]);        } else         {            throw new RuntimeException("unexpected reference type");        }    }}
public COSObject pdfbox_f3226_0(int objectNumber)
{    return null;}
public void pdfbox_f3227_0() throws IOException
{    COSBase w = stream.getDictionaryObject(COSName.W);    if (!(w instanceof COSArray)) {        throw new IOException("/W array is missing in Xref stream");    }    COSArray xrefFormat = (COSArray) w;    COSBase base = stream.getDictionaryObject(COSName.INDEX);    COSArray indexArray;    if (base instanceof COSArray) {        indexArray = (COSArray) base;    } else {                indexArray = new COSArray();        indexArray.add(COSInteger.ZERO);        indexArray.add(COSInteger.get(stream.getInt(COSName.SIZE, 0)));    }    List<Long> objNums = new ArrayList<>();    /*         * Populates objNums with all object numbers available         */    Iterator<COSBase> indexIter = indexArray.iterator();    while (indexIter.hasNext()) {        base = indexIter.next();        if (!(base instanceof COSInteger)) {            throw new IOException("Xref stream must have integer in /Index array");        }        long objID = ((COSInteger) base).longValue();        if (!indexIter.hasNext()) {            break;        }        base = indexIter.next();        if (!(base instanceof COSInteger)) {            throw new IOException("Xref stream must have integer in /Index array");        }        int size = ((COSInteger) base).intValue();        for (int i = 0; i < size; i++) {            objNums.add(objID + i);        }    }    Iterator<Long> objIter = objNums.iterator();    /*         * Calculating the size of the line in bytes         */    int w0 = xrefFormat.getInt(0, 0);    int w1 = xrefFormat.getInt(1, 0);    int w2 = xrefFormat.getInt(2, 0);    int lineSize = w0 + w1 + w2;    while (!seqSource.isEOF() && objIter.hasNext()) {        byte[] currLine = new byte[lineSize];        seqSource.read(currLine);        int type;        if (w0 == 0) {                                    type = 1;        } else {            type = 0;            /*                 * Grabs the number of bytes specified for the first column in                 * the W array and stores it.                 */            for (int i = 0; i < w0; i++) {                type += (currLine[i] & 0x00ff) << ((w0 - i - 1) * 8);            }        }                Long objID = objIter.next();        /*             * 3 different types of entries.             */        switch(type) {            case 0:                /*                     * Skipping free objects                     */                break;            case 1:                int offset = 0;                for (int i = 0; i < w1; i++) {                    offset += (currLine[i + w0] & 0x00ff) << ((w1 - i - 1) * 8);                }                int genNum = 0;                for (int i = 0; i < w2; i++) {                    genNum += (currLine[i + w0 + w1] & 0x00ff) << ((w2 - i - 1) * 8);                }                COSObjectKey objKey = new COSObjectKey(objID, genNum);                xrefTrailerResolver.setXRef(objKey, offset);                break;            case 2:                /*                     * object stored in object stream:                      * 2nd argument is object number of object stream                     * 3rd argument is index of object within object stream                     *                      * For sequential PDFParser we do not need this information                     * because                     * These objects are handled by the dereferenceObjects() method                     * since they're only pointing to object numbers                     *                      * However for XRef aware parsers we have to know which objects contain                     * object streams. We will store this information in normal xref mapping                     * table but add object stream number with minus sign in order to                     * distinguish from file offsets                     */                int objstmObjNr = 0;                for (int i = 0; i < w1; i++) {                    objstmObjNr += (currLine[i + w0] & 0x00ff) << ((w1 - i - 1) * 8);                }                objKey = new COSObjectKey(objID, 0);                xrefTrailerResolver.setXRef(objKey, -objstmObjNr);                break;            default:                break;        }    }}
public int pdfbox_f3228_0() throws IOException
{    return reader.read();}
public int pdfbox_f3229_0(byte[] b) throws IOException
{    return reader.read(b);}
public int pdfbox_f3230_0(byte[] b, int offset, int length) throws IOException
{    return reader.read(b, offset, length);}
public long pdfbox_f3231_0() throws IOException
{    return reader.getPosition();}
public int pdfbox_f3232_0() throws IOException
{    return reader.peek();}
public void pdfbox_f3233_0(int b) throws IOException
{    reader.rewind(1);}
public void pdfbox_f3234_0(byte[] bytes) throws IOException
{    reader.rewind(bytes.length);}
public void pdfbox_f3235_0(byte[] bytes, int start, int len) throws IOException
{    reader.rewind(len - start);}
public byte[] pdfbox_f3236_0(int length) throws IOException
{    return reader.readFully(length);}
public boolean pdfbox_f3237_0() throws IOException
{    return reader.isEOF();}
public void pdfbox_f3238_0() throws IOException
{    reader.close();}
public void pdfbox_f3239_0()
{    xrefTable.clear();}
public final COSDictionary pdfbox_f3240_0()
{    if (bytePosToXrefMap.isEmpty()) {        return null;    }    Set<Long> offsets = bytePosToXrefMap.keySet();    SortedSet<Long> sortedOffset = new TreeSet<>(offsets);    return bytePosToXrefMap.get(sortedOffset.first()).trailer;}
public final COSDictionary pdfbox_f3241_0()
{    if (bytePosToXrefMap.isEmpty()) {        return null;    }    Set<Long> offsets = bytePosToXrefMap.keySet();    SortedSet<Long> sortedOffset = new TreeSet<>(offsets);    return bytePosToXrefMap.get(sortedOffset.last()).trailer;}
public final int pdfbox_f3242_0()
{    return bytePosToXrefMap.size();}
public void pdfbox_f3243_0(final long startBytePos, XRefType type)
{    curXrefTrailerObj = new XrefTrailerObj();    bytePosToXrefMap.put(startBytePos, curXrefTrailerObj);    curXrefTrailerObj.xrefType = type;}
public XRefType pdfbox_f3244_0()
{    return (resolvedXrefTrailer == null) ? null : resolvedXrefTrailer.xrefType;}
public void pdfbox_f3245_1(COSObjectKey objKey, long offset)
{    if (curXrefTrailerObj == null) {                        return;    }        if (!curXrefTrailerObj.xrefTable.containsKey(objKey)) {        curXrefTrailerObj.xrefTable.put(objKey, offset);    }}
public void pdfbox_f3246_1(COSDictionary trailer)
{    if (curXrefTrailerObj == null) {                        return;    }    curXrefTrailerObj.trailer = trailer;}
public COSDictionary pdfbox_f3247_0()
{    return curXrefTrailerObj.trailer;}
public void pdfbox_f3248_1(long startxrefBytePosValue)
{    if (resolvedXrefTrailer != null) {                return;    }    resolvedXrefTrailer = new XrefTrailerObj();    resolvedXrefTrailer.trailer = new COSDictionary();    XrefTrailerObj curObj = bytePosToXrefMap.get(startxrefBytePosValue);    List<Long> xrefSeqBytePos = new ArrayList<>();    if (curObj == null) {                                xrefSeqBytePos.addAll(bytePosToXrefMap.keySet());        Collections.sort(xrefSeqBytePos);    } else {                resolvedXrefTrailer.xrefType = curObj.xrefType;                        xrefSeqBytePos.add(startxrefBytePosValue);        while (curObj.trailer != null) {            long prevBytePos = curObj.trailer.getLong(COSName.PREV, -1L);            if (prevBytePos == -1) {                break;            }            curObj = bytePosToXrefMap.get(prevBytePos);            if (curObj == null) {                                break;            }            xrefSeqBytePos.add(prevBytePos);                        if (xrefSeqBytePos.size() >= bytePosToXrefMap.size()) {                break;            }        }                Collections.reverse(xrefSeqBytePos);    }        for (Long bPos : xrefSeqBytePos) {        curObj = bytePosToXrefMap.get(bPos);        if (curObj.trailer != null) {            resolvedXrefTrailer.trailer.addAll(curObj.trailer);        }        resolvedXrefTrailer.xrefTable.putAll(curObj.xrefTable);    }}
public COSDictionary pdfbox_f3249_0()
{    return (resolvedXrefTrailer == null) ? null : resolvedXrefTrailer.trailer;}
public Map<COSObjectKey, Long> pdfbox_f3250_0()
{    return (resolvedXrefTrailer == null) ? null : resolvedXrefTrailer.xrefTable;}
public Set<Long> pdfbox_f3251_0(final int objstmObjNr)
{    if (resolvedXrefTrailer == null) {        return null;    }    final Set<Long> refObjNrs = new HashSet<>();    final long cmpVal = -objstmObjNr;    for (Entry<COSObjectKey, Long> xrefEntry : resolvedXrefTrailer.xrefTable.entrySet()) {        if (xrefEntry.getValue() == cmpVal) {            refObjNrs.add(xrefEntry.getKey().getNumber());        }    }    return refObjNrs;}
protected void pdfbox_f3252_0()
{    for (XrefTrailerObj trailerObj : bytePosToXrefMap.values()) {        trailerObj.reset();    }    curXrefTrailerObj = null;    resolvedXrefTrailer = null;}
public void pdfbox_f3253_0(COSBase base) throws IOException
{    writeObject(base);}
public void pdfbox_f3254_0(Operator op) throws IOException
{    writeObject(op);}
public void pdfbox_f3255_0(Object... tokens) throws IOException
{    for (Object token : tokens) {        writeObject(token);    }    output.write("\n".getBytes(Charsets.US_ASCII));}
public void pdfbox_f3256_0(List<?> tokens) throws IOException
{    for (Object token : tokens) {        writeObject(token);    }}
private void pdfbox_f3257_0(Object o) throws IOException
{    if (o instanceof COSString) {        COSWriter.writeString((COSString) o, output);        output.write(SPACE);    } else if (o instanceof COSFloat) {        ((COSFloat) o).writePDF(output);        output.write(SPACE);    } else if (o instanceof COSInteger) {        ((COSInteger) o).writePDF(output);        output.write(SPACE);    } else if (o instanceof COSBoolean) {        ((COSBoolean) o).writePDF(output);        output.write(SPACE);    } else if (o instanceof COSName) {        ((COSName) o).writePDF(output);        output.write(SPACE);    } else if (o instanceof COSArray) {        COSArray array = (COSArray) o;        output.write(COSWriter.ARRAY_OPEN);        for (int i = 0; i < array.size(); i++) {            writeObject(array.get(i));            output.write(SPACE);        }        output.write(COSWriter.ARRAY_CLOSE);    } else if (o instanceof COSDictionary) {        COSDictionary obj = (COSDictionary) o;        output.write(COSWriter.DICT_OPEN);        for (Map.Entry<COSName, COSBase> entry : obj.entrySet()) {            if (entry.getValue() != null) {                writeObject(entry.getKey());                output.write(SPACE);                writeObject(entry.getValue());                output.write(SPACE);            }        }        output.write(COSWriter.DICT_CLOSE);        output.write(SPACE);    } else if (o instanceof Operator) {        Operator op = (Operator) o;        if (op.getName().equals(OperatorName.BEGIN_INLINE_IMAGE)) {            output.write(OperatorName.BEGIN_INLINE_IMAGE.getBytes(Charsets.ISO_8859_1));            COSDictionary dic = op.getImageParameters();            for (COSName key : dic.keySet()) {                Object value = dic.getDictionaryObject(key);                key.writePDF(output);                output.write(SPACE);                writeObject(value);                output.write(EOL);            }            output.write(OperatorName.BEGIN_INLINE_IMAGE_DATA.getBytes(Charsets.ISO_8859_1));            output.write(EOL);            output.write(op.getImageData());            output.write(EOL);            output.write(OperatorName.END_INLINE_IMAGE.getBytes(Charsets.ISO_8859_1));            output.write(EOL);        } else {            output.write(op.getName().getBytes(Charsets.ISO_8859_1));            output.write(EOL);        }    } else {        throw new IOException("Error:Unknown type in content stream:" + o);    }}
public long pdfbox_f3258_0()
{    return position;}
public boolean pdfbox_f3259_0()
{    return onNewLine;}
public void pdfbox_f3260_0(boolean newOnNewLine)
{    onNewLine = newOnNewLine;}
public void pdfbox_f3261_0(byte[] b, int off, int len) throws IOException
{    setOnNewLine(false);    out.write(b, off, len);    position += len;}
public void pdfbox_f3262_0(int b) throws IOException
{    setOnNewLine(false);    out.write(b);    position++;}
public void pdfbox_f3263_0() throws IOException
{    write(CRLF);}
public void pdfbox_f3264_0() throws IOException
{    if (!isOnNewLine()) {        write(EOL);        setOnNewLine(true);    }}
public void pdfbox_f3265_0() throws IOException
{    write(LF);}
private void pdfbox_f3266_0(PDDocument doc)
{    if (doc != null) {        COSDocument cosDoc = doc.getDocument();        Map<COSObjectKey, Long> xrefTable = cosDoc.getXrefTable();        Set<COSObjectKey> keySet = xrefTable.keySet();        long highestNumber = doc.getDocument().getHighestXRefObjectNumber();        for (COSObjectKey cosObjectKey : keySet) {            COSBase object = cosDoc.getObjectFromPool(cosObjectKey).getObject();            if (object != null && cosObjectKey != null && !(object instanceof COSNumber)) {                objectKeys.put(object, cosObjectKey);                keyObject.put(cosObjectKey, object);            }            if (cosObjectKey != null) {                long num = cosObjectKey.getNumber();                if (num > highestNumber) {                    highestNumber = num;                }            }        }        setNumber(highestNumber);    }}
protected void pdfbox_f3267_0(COSWriterXRefEntry entry)
{    getXRefEntries().add(entry);}
public void pdfbox_f3268_0() throws IOException
{    if (getStandardOutput() != null) {        getStandardOutput().close();    }    if (incrementalOutput != null) {        incrementalOutput.close();    }}
protected long pdfbox_f3269_0()
{    return number;}
public Map<COSBase, COSObjectKey> pdfbox_f3270_0()
{    return objectKeys;}
protected java.io.OutputStream pdfbox_f3271_0()
{    return output;}
protected COSStandardOutputStream pdfbox_f3272_0()
{    return standardOutput;}
protected long pdfbox_f3273_0()
{    return startxref;}
protected List<COSWriterXRefEntry> pdfbox_f3274_0()
{    return xRefEntries;}
protected void pdfbox_f3275_0(long newNumber)
{    number = newNumber;}
private void pdfbox_f3276_0(OutputStream newOutput)
{    output = newOutput;}
private void pdfbox_f3277_0(COSStandardOutputStream newStandardOutput)
{    standardOutput = newStandardOutput;}
protected void pdfbox_f3278_0(long newStartxref)
{    startxref = newStartxref;}
protected void pdfbox_f3279_0(COSDocument doc) throws IOException
{    COSDictionary trailer = doc.getTrailer();    COSDictionary root = trailer.getCOSDictionary(COSName.ROOT);    COSDictionary info = trailer.getCOSDictionary(COSName.INFO);    COSDictionary encrypt = trailer.getCOSDictionary(COSName.ENCRYPT);    if (root != null) {        addObjectToWrite(root);    }    if (info != null) {        addObjectToWrite(info);    }    doWriteObjects();    willEncrypt = false;    if (encrypt != null) {        addObjectToWrite(encrypt);    }    doWriteObjects();}
private void pdfbox_f3280_0() throws IOException
{    while (objectsToWrite.size() > 0) {        COSBase nextObject = objectsToWrite.removeFirst();        objectsToWriteSet.remove(nextObject);        doWriteObject(nextObject);    }}
private void pdfbox_f3281_0(COSBase object)
{    COSBase actual = object;    if (actual instanceof COSObject) {        actual = ((COSObject) actual).getObject();    }    if (!writtenObjects.contains(object) && !objectsToWriteSet.contains(object) && !actualsAdded.contains(actual)) {        COSBase cosBase = null;        COSObjectKey cosObjectKey = null;        if (actual != null) {            cosObjectKey = objectKeys.get(actual);        }        if (cosObjectKey != null) {            cosBase = keyObject.get(cosObjectKey);        }        if (actual != null && objectKeys.containsKey(actual) && object instanceof COSUpdateInfo && !((COSUpdateInfo) object).isNeedToBeUpdated() && cosBase instanceof COSUpdateInfo && !((COSUpdateInfo) cosBase).isNeedToBeUpdated()) {            return;        }        objectsToWrite.add(object);        objectsToWriteSet.add(object);        if (actual != null) {            actualsAdded.add(actual);        }    }}
public void pdfbox_f3282_0(COSBase obj) throws IOException
{    writtenObjects.add(obj);        currentObjectKey = getObjectKey(obj);        addXRefEntry(new COSWriterXRefEntry(getStandardOutput().getPos(), obj, currentObjectKey));        getStandardOutput().write(String.valueOf(currentObjectKey.getNumber()).getBytes(Charsets.ISO_8859_1));    getStandardOutput().write(SPACE);    getStandardOutput().write(String.valueOf(currentObjectKey.getGeneration()).getBytes(Charsets.ISO_8859_1));    getStandardOutput().write(SPACE);    getStandardOutput().write(OBJ);    getStandardOutput().writeEOL();        if (obj != null) {        obj.accept(this);    }    getStandardOutput().writeEOL();    getStandardOutput().write(ENDOBJ);    getStandardOutput().writeEOL();}
protected void pdfbox_f3283_0(COSDocument doc) throws IOException
{    String headerString;    if (fdfDocument != null) {        headerString = "%FDF-" + Float.toString(doc.getVersion());    } else {        headerString = "%PDF-" + Float.toString(doc.getVersion());    }    getStandardOutput().write(headerString.getBytes(Charsets.ISO_8859_1));    getStandardOutput().writeEOL();    getStandardOutput().write(COMMENT);    getStandardOutput().write(GARBAGE);    getStandardOutput().writeEOL();}
protected void pdfbox_f3284_0(COSDocument doc) throws IOException
{    getStandardOutput().write(TRAILER);    getStandardOutput().writeEOL();    COSDictionary trailer = doc.getTrailer();        Collections.sort(getXRefEntries());    COSWriterXRefEntry lastEntry = getXRefEntries().get(getXRefEntries().size() - 1);    trailer.setLong(COSName.SIZE, lastEntry.getKey().getNumber() + 1);        if (!incrementalUpdate) {        trailer.removeItem(COSName.PREV);    }    if (!doc.isXRefStream()) {        trailer.removeItem(COSName.XREF_STM);    }        trailer.removeItem(COSName.DOC_CHECKSUM);    COSArray idArray = trailer.getCOSArray(COSName.ID);    if (idArray != null) {        idArray.setDirect(true);    }    trailer.accept(this);}
private void pdfbox_f3285_0(COSDocument doc, long hybridPrev) throws IOException
{    if (doc.isXRefStream() || hybridPrev != -1) {                                        PDFXRefStream pdfxRefStream = new PDFXRefStream(doc);                List<COSWriterXRefEntry> xRefEntries2 = getXRefEntries();        for (COSWriterXRefEntry cosWriterXRefEntry : xRefEntries2) {            pdfxRefStream.addEntry(cosWriterXRefEntry);        }        COSDictionary trailer = doc.getTrailer();        if (incrementalUpdate) {                        trailer.setLong(COSName.PREV, doc.getStartXref());        } else {            trailer.removeItem(COSName.PREV);        }        pdfxRefStream.addTrailerInfo(trailer);                        pdfxRefStream.setSize(getNumber() + 2);        setStartxref(getStandardOutput().getPos());        COSStream stream2 = pdfxRefStream.getStream();        doWriteObject(stream2);    }    if (!doc.isXRefStream() || hybridPrev != -1) {        COSDictionary trailer = doc.getTrailer();        trailer.setLong(COSName.PREV, doc.getStartXref());        if (hybridPrev != -1) {            COSName xrefStm = COSName.XREF_STM;            trailer.removeItem(xrefStm);            trailer.setLong(xrefStm, getStartxref());        }        doWriteXRefTable();        doWriteTrailer(doc);    }}
private void pdfbox_f3286_0() throws IOException
{    addXRefEntry(COSWriterXRefEntry.getNullEntry());        Collections.sort(getXRefEntries());        setStartxref(getStandardOutput().getPos());    getStandardOutput().write(XREF);    getStandardOutput().writeEOL();            Long[] xRefRanges = getXRefRanges(getXRefEntries());    int xRefLength = xRefRanges.length;    int x = 0;    int j = 0;    while (x < xRefLength && (xRefLength % 2) == 0) {        writeXrefRange(xRefRanges[x], xRefRanges[x + 1]);        for (int i = 0; i < xRefRanges[x + 1]; ++i) {            writeXrefEntry(xRefEntries.get(j++));        }        x += 2;    }}
private void pdfbox_f3287_0() throws IOException
{        IOUtils.copy(new RandomAccessInputStream(incrementalInput), incrementalOutput);        incrementalOutput.write(((ByteArrayOutputStream) output).toByteArray());}
private void pdfbox_f3288_0() throws IOException
{        long inLength = incrementalInput.length();    long beforeLength = signatureOffset;    long afterOffset = signatureOffset + signatureLength;    long afterLength = getStandardOutput().getPos() - (inLength + signatureLength) - (signatureOffset - inLength);    String byteRange = "0 " + beforeLength + " " + afterOffset + " " + afterLength + "]";        byteRangeArray.set(0, COSInteger.ZERO);    byteRangeArray.set(1, COSInteger.get(beforeLength));    byteRangeArray.set(2, COSInteger.get(afterOffset));    byteRangeArray.set(3, COSInteger.get(afterLength));    if (byteRange.length() > byteRangeLength) {        throw new IOException("Can't write new byteRange '" + byteRange + "' not enough space: byteRange.length(): " + byteRange.length() + ", byteRangeLength: " + byteRangeLength);    }        ByteArrayOutputStream byteOut = (ByteArrayOutputStream) output;    byteOut.flush();    incrementPart = byteOut.toByteArray();        byte[] byteRangeBytes = byteRange.getBytes(Charsets.ISO_8859_1);    for (int i = 0; i < byteRangeLength; i++) {        if (i >= byteRangeBytes.length) {                        incrementPart[(int) (byteRangeOffset + i - inLength)] = 0x20;        } else {            incrementPart[(int) (byteRangeOffset + i - inLength)] = byteRangeBytes[i];        }    }    if (signatureInterface != null) {                final InputStream dataToSign = getDataToSign();                byte[] signatureBytes = signatureInterface.sign(dataToSign);        writeExternalSignature(signatureBytes);    }}
public InputStream pdfbox_f3289_0() throws IOException
{    if (incrementPart == null || incrementalInput == null) {        throw new IllegalStateException("PDF not prepared for signing");    }        int incPartSigOffset = (int) (signatureOffset - incrementalInput.length());    int afterSigOffset = incPartSigOffset + (int) signatureLength;    int[] range = { 0, incPartSigOffset, afterSigOffset, incrementPart.length - afterSigOffset };    return new SequenceInputStream(new RandomAccessInputStream(incrementalInput), new COSFilterInputStream(incrementPart, range));}
public void pdfbox_f3290_0(byte[] cmsSignature) throws IOException
{    if (incrementPart == null || incrementalInput == null) {        throw new IllegalStateException("PDF not prepared for setting signature");    }    byte[] signatureBytes = Hex.getBytes(cmsSignature);        if (signatureBytes.length > signatureLength - 2) {        throw new IOException("Can't write signature, not enough space");    }        int incPartSigOffset = (int) (signatureOffset - incrementalInput.length());    System.arraycopy(signatureBytes, 0, incrementPart, incPartSigOffset + 1, signatureBytes.length);        IOUtils.copy(new RandomAccessInputStream(incrementalInput), incrementalOutput);    incrementalOutput.write(incrementPart);        incrementPart = null;}
private void pdfbox_f3291_0(long x, long y) throws IOException
{    getStandardOutput().write(String.valueOf(x).getBytes(Charsets.ISO_8859_1));    getStandardOutput().write(SPACE);    getStandardOutput().write(String.valueOf(y).getBytes(Charsets.ISO_8859_1));    getStandardOutput().writeEOL();}
private void pdfbox_f3292_0(COSWriterXRefEntry entry) throws IOException
{    String offset = formatXrefOffset.format(entry.getOffset());    String generation = formatXrefGeneration.format(entry.getKey().getGeneration());    getStandardOutput().write(offset.getBytes(Charsets.ISO_8859_1));    getStandardOutput().write(SPACE);    getStandardOutput().write(generation.getBytes(Charsets.ISO_8859_1));    getStandardOutput().write(SPACE);    getStandardOutput().write(entry.isFree() ? XREF_FREE : XREF_USED);    getStandardOutput().writeCRLF();}
protected Long[] pdfbox_f3293_0(List<COSWriterXRefEntry> xRefEntriesList)
{    long last = -2;    long count = 1;    List<Long> list = new ArrayList<>();    for (Object object : xRefEntriesList) {        long nr = (int) ((COSWriterXRefEntry) object).getKey().getNumber();        if (nr == last + 1) {            ++count;            last = nr;        } else if (last == -2) {            last = nr;        } else {            list.add(last - count + 1);            list.add(count);            last = nr;            count = 1;        }    }        if (xRefEntriesList.size() > 0) {        list.add(last - count + 1);        list.add(count);    }    return list.toArray(new Long[list.size()]);}
private COSObjectKey pdfbox_f3294_0(COSBase obj)
{    COSBase actual = obj;    if (actual instanceof COSObject) {        actual = ((COSObject) obj).getObject();    }            COSObjectKey key = objectKeys.get(obj);    if (key == null && actual != null) {        key = objectKeys.get(actual);    }    if (key == null) {        setNumber(getNumber() + 1);        key = new COSObjectKey(getNumber(), 0);        objectKeys.put(obj, key);        if (actual != null) {            objectKeys.put(actual, key);        }    }    return key;}
public Object pdfbox_f3295_0(COSArray obj) throws IOException
{    int count = 0;    getStandardOutput().write(ARRAY_OPEN);    for (Iterator<COSBase> i = obj.iterator(); i.hasNext(); ) {        COSBase current = i.next();        if (current instanceof COSDictionary) {            if (current.isDirect()) {                visitFromDictionary((COSDictionary) current);            } else {                addObjectToWrite(current);                writeReference(current);            }        } else if (current instanceof COSObject) {            COSBase subValue = ((COSObject) current).getObject();            if (willEncrypt || incrementalUpdate || subValue instanceof COSDictionary || subValue == null) {                                                                                addObjectToWrite(current);                writeReference(current);            } else {                subValue.accept(this);            }        } else if (current == null) {            COSNull.NULL.accept(this);        } else {            current.accept(this);        }        count++;        if (i.hasNext()) {            if (count % 10 == 0) {                getStandardOutput().writeEOL();            } else {                getStandardOutput().write(SPACE);            }        }    }    getStandardOutput().write(ARRAY_CLOSE);    getStandardOutput().writeEOL();    return null;}
public Object pdfbox_f3296_0(COSBoolean obj) throws IOException
{    obj.writePDF(getStandardOutput());    return null;}
public Object pdfbox_f3297_0(COSDictionary obj) throws IOException
{    if (!reachedSignature) {        COSBase itemType = obj.getItem(COSName.TYPE);        if (COSName.SIG.equals(itemType) || COSName.DOC_TIME_STAMP.equals(itemType)) {            reachedSignature = true;        }    }    getStandardOutput().write(DICT_OPEN);    getStandardOutput().writeEOL();    for (Map.Entry<COSName, COSBase> entry : obj.entrySet()) {        COSBase value = entry.getValue();        if (value != null) {            entry.getKey().accept(this);            getStandardOutput().write(SPACE);            if (value instanceof COSDictionary) {                COSDictionary dict = (COSDictionary) value;                if (!incrementalUpdate) {                                                            COSBase item = dict.getItem(COSName.XOBJECT);                    if (item != null && !COSName.XOBJECT.equals(entry.getKey())) {                        item.setDirect(true);                    }                    item = dict.getItem(COSName.RESOURCES);                    if (item != null && !COSName.RESOURCES.equals(entry.getKey())) {                        item.setDirect(true);                    }                }                if (dict.isDirect()) {                                                            visitFromDictionary(dict);                } else {                    addObjectToWrite(dict);                    writeReference(dict);                }            } else if (value instanceof COSObject) {                COSBase subValue = ((COSObject) value).getObject();                if (willEncrypt || incrementalUpdate || subValue instanceof COSDictionary || subValue == null) {                                                                                                    addObjectToWrite(value);                    writeReference(value);                } else {                    subValue.accept(this);                }            } else {                                if (reachedSignature && COSName.CONTENTS.equals(entry.getKey())) {                    signatureOffset = getStandardOutput().getPos();                    value.accept(this);                    signatureLength = getStandardOutput().getPos() - signatureOffset;                } else if (reachedSignature && COSName.BYTERANGE.equals(entry.getKey())) {                    byteRangeArray = (COSArray) entry.getValue();                    byteRangeOffset = getStandardOutput().getPos() + 1;                    value.accept(this);                    byteRangeLength = getStandardOutput().getPos() - 1 - byteRangeOffset;                    reachedSignature = false;                } else {                    value.accept(this);                }            }            getStandardOutput().writeEOL();        } else {                                        }    }    getStandardOutput().write(DICT_CLOSE);    getStandardOutput().writeEOL();    return null;}
public Object pdfbox_f3298_0(COSDocument doc) throws IOException
{    if (!incrementalUpdate) {        doWriteHeader(doc);    } else {                                        getStandardOutput().writeCRLF();    }    doWriteBody(doc);        COSDictionary trailer = doc.getTrailer();    long hybridPrev = -1;    if (trailer != null) {        hybridPrev = trailer.getLong(COSName.XREF_STM);    }    if (incrementalUpdate || doc.isXRefStream()) {        doWriteXRefInc(doc, hybridPrev);    } else {        doWriteXRefTable();        doWriteTrailer(doc);    }        getStandardOutput().write(STARTXREF);    getStandardOutput().writeEOL();    getStandardOutput().write(String.valueOf(getStartxref()).getBytes(Charsets.ISO_8859_1));    getStandardOutput().writeEOL();    getStandardOutput().write(EOF);    getStandardOutput().writeEOL();    if (incrementalUpdate) {        if (signatureOffset == 0 || byteRangeOffset == 0) {            doWriteIncrement();        } else {            doWriteSignature();        }    }    return null;}
public Object pdfbox_f3299_0(COSFloat obj) throws IOException
{    obj.writePDF(getStandardOutput());    return null;}
public Object pdfbox_f3300_0(COSInteger obj) throws IOException
{    obj.writePDF(getStandardOutput());    return null;}
public Object pdfbox_f3301_0(COSName obj) throws IOException
{    obj.writePDF(getStandardOutput());    return null;}
public Object pdfbox_f3302_0(COSNull obj) throws IOException
{    obj.writePDF(getStandardOutput());    return null;}
public void pdfbox_f3303_0(COSBase obj) throws IOException
{    COSObjectKey key = getObjectKey(obj);    getStandardOutput().write(String.valueOf(key.getNumber()).getBytes(Charsets.ISO_8859_1));    getStandardOutput().write(SPACE);    getStandardOutput().write(String.valueOf(key.getGeneration()).getBytes(Charsets.ISO_8859_1));    getStandardOutput().write(SPACE);    getStandardOutput().write(REFERENCE);}
public Object pdfbox_f3304_0(COSStream obj) throws IOException
{    if (willEncrypt) {        pdDocument.getEncryption().getSecurityHandler().encryptStream(obj, currentObjectKey.getNumber(), currentObjectKey.getGeneration());    }    InputStream input = null;    try {                visitFromDictionary(obj);        getStandardOutput().write(STREAM);        getStandardOutput().writeCRLF();        input = obj.createRawInputStream();        IOUtils.copy(input, getStandardOutput());        getStandardOutput().writeCRLF();        getStandardOutput().write(ENDSTREAM);        getStandardOutput().writeEOL();        return null;    } finally {        if (input != null) {            input.close();        }    }}
public Object pdfbox_f3305_0(COSString obj) throws IOException
{    if (willEncrypt) {        pdDocument.getEncryption().getSecurityHandler().encryptString(obj, currentObjectKey.getNumber(), currentObjectKey.getGeneration());    }    COSWriter.writeString(obj, getStandardOutput());    return null;}
public void pdfbox_f3306_0(COSDocument doc) throws IOException
{    PDDocument pdDoc = new PDDocument(doc);    write(pdDoc);}
public void pdfbox_f3307_0(PDDocument doc) throws IOException
{    write(doc, null);}
public void pdfbox_f3308_0(PDDocument doc, SignatureInterface signInterface) throws IOException
{    Long idTime = doc.getDocumentId() == null ? System.currentTimeMillis() : doc.getDocumentId();    pdDocument = doc;    signatureInterface = signInterface;    if (incrementalUpdate) {        prepareIncrement(doc);    }        if (doc.isAllSecurityToBeRemoved()) {        willEncrypt = false;                        COSDocument cosDoc = doc.getDocument();        COSDictionary trailer = cosDoc.getTrailer();        trailer.removeItem(COSName.ENCRYPT);    } else {        if (pdDocument.getEncryption() != null) {            if (!incrementalUpdate) {                SecurityHandler securityHandler = pdDocument.getEncryption().getSecurityHandler();                if (!securityHandler.hasProtectionPolicy()) {                    throw new IllegalStateException("PDF contains an encryption dictionary, please remove it with " + "setAllSecurityToBeRemoved() or set a protection policy with protect()");                }                securityHandler.prepareDocumentForEncryption(pdDocument);            }            willEncrypt = true;        } else {            willEncrypt = false;        }    }    COSDocument cosDoc = pdDocument.getDocument();    COSDictionary trailer = cosDoc.getTrailer();    COSArray idArray;    boolean missingID = true;    COSBase base = trailer.getDictionaryObject(COSName.ID);    if (base instanceof COSArray) {        idArray = (COSArray) base;        if (idArray.size() == 2) {            missingID = false;        }    } else {        idArray = new COSArray();    }    if (missingID || incrementalUpdate) {        MessageDigest md5;        try {            md5 = MessageDigest.getInstance("MD5");        } catch (NoSuchAlgorithmException e) {                        throw new RuntimeException(e);        }                        md5.update(Long.toString(idTime).getBytes(Charsets.ISO_8859_1));        COSDictionary info = trailer.getCOSDictionary(COSName.INFO);        if (info != null) {            for (COSBase cosBase : info.getValues()) {                md5.update(cosBase.toString().getBytes(Charsets.ISO_8859_1));            }        }                COSString firstID = missingID ? new COSString(md5.digest()) : (COSString) idArray.get(0);                COSString secondID = missingID ? firstID : new COSString(md5.digest());        idArray = new COSArray();        idArray.add(firstID);        idArray.add(secondID);        trailer.setItem(COSName.ID, idArray);    }    cosDoc.accept(this);}
public void pdfbox_f3309_0(FDFDocument doc) throws IOException
{    fdfDocument = doc;    willEncrypt = false;    COSDocument cosDoc = fdfDocument.getDocument();    cosDoc.accept(this);}
public static void pdfbox_f3310_0(COSString string, OutputStream output) throws IOException
{    writeString(string.getBytes(), string.getForceHexForm(), output);}
public static void pdfbox_f3311_0(byte[] bytes, OutputStream output) throws IOException
{    writeString(bytes, false, output);}
private static void pdfbox_f3312_0(byte[] bytes, boolean forceHex, OutputStream output) throws IOException
{        boolean isASCII = true;    if (!forceHex) {        for (byte b : bytes) {                        if (b < 0) {                isASCII = false;                break;            }                        if (b == 0x0d || b == 0x0a) {                isASCII = false;                break;            }        }    }    if (isASCII && !forceHex) {                output.write('(');        for (byte b : bytes) {            switch(b) {                case '(':                case ')':                case '\\':                    output.write('\\');                    output.write(b);                    break;                default:                    output.write(b);                    break;            }        }        output.write(')');    } else {                output.write('<');        Hex.writeHexBytes(bytes, output);        output.write('>');    }}
public int pdfbox_f3313_0(COSWriterXRefEntry obj)
{    if (obj != null) {        return Long.compare(getKey().getNumber(), obj.getKey().getNumber());    }    return -1;}
public static COSWriterXRefEntry pdfbox_f3314_0()
{    return NULLENTRY;}
public COSObjectKey pdfbox_f3315_0()
{    return key;}
public long pdfbox_f3316_0()
{    return offset;}
public boolean pdfbox_f3317_0()
{    return free;}
public void pdfbox_f3318_0(boolean newFree)
{    free = newFree;}
private void pdfbox_f3319_0(COSObjectKey newKey)
{    key = newKey;}
public final void pdfbox_f3320_0(long newOffset)
{    offset = newOffset;}
public COSBase pdfbox_f3321_0()
{    return object;}
private void pdfbox_f3322_0(COSBase newObject)
{    object = newObject;}
public int pdfbox_f3323_0()
{    return actual.size();}
public boolean pdfbox_f3324_0()
{    return actual.isEmpty();}
public boolean pdfbox_f3325_0(Object o)
{    return actual.contains(o);}
public Iterator<E> pdfbox_f3326_0()
{    return actual.iterator();}
public Object[] pdfbox_f3327_0()
{    return actual.toArray();}
public X[] pdfbox_f3328_0(X[] a)
{    return actual.toArray(a);}
public boolean pdfbox_f3329_0(E o)
{        if (parentDict != null) {        parentDict.setItem(dictKey, array);                        parentDict = null;    }        if (o instanceof String) {        array.add(new COSString((String) o));    } else {        if (array != null) {            array.add(((COSObjectable) o).getCOSObject());        }    }    return actual.add(o);}
public boolean pdfbox_f3330_0(Object o)
{    boolean retval = true;    int index = actual.indexOf(o);    if (index >= 0) {        actual.remove(index);        array.remove(index);    } else {        retval = false;    }    return retval;}
public boolean pdfbox_f3331_0(Collection<?> c)
{    return actual.containsAll(c);}
public boolean pdfbox_f3332_0(Collection<? extends E> c)
{        if (parentDict != null && c.size() > 0) {        parentDict.setItem(dictKey, array);                        parentDict = null;    }    array.addAll(toCOSObjectList(c));    return actual.addAll(c);}
public boolean pdfbox_f3333_0(int index, Collection<? extends E> c)
{        if (parentDict != null && c.size() > 0) {        parentDict.setItem(dictKey, array);                        parentDict = null;    }    array.addAll(index, toCOSObjectList(c));    return actual.addAll(index, c);}
public static List<Integer> pdfbox_f3334_0(COSArray intArray)
{    List<Integer> retval = null;    if (intArray != null) {        List<Integer> numbers = new ArrayList<>();        for (int i = 0; i < intArray.size(); i++) {            COSNumber num;            if (intArray.get(i) instanceof COSObject) {                num = (COSNumber) ((COSObject) intArray.get(i)).getObject();            } else {                num = (COSNumber) intArray.get(i);            }            numbers.add(num.intValue());        }        retval = new COSArrayList<>(numbers, intArray);    }    return retval;}
public static List<Float> pdfbox_f3335_0(COSArray floatArray)
{    List<Float> retval = null;    if (floatArray != null) {        List<Float> numbers = new ArrayList<>(floatArray.size());        for (int i = 0; i < floatArray.size(); i++) {            COSBase base = floatArray.getObject(i);            if (base instanceof COSNumber) {                numbers.add(((COSNumber) base).floatValue());            } else {                numbers.add(null);            }        }        retval = new COSArrayList<>(numbers, floatArray);    }    return retval;}
public static List<String> pdfbox_f3336_0(COSArray nameArray)
{    List<String> retval = null;    if (nameArray != null) {        List<String> names = new ArrayList<>();        for (int i = 0; i < nameArray.size(); i++) {            names.add(((COSName) nameArray.getObject(i)).getName());        }        retval = new COSArrayList<>(names, nameArray);    }    return retval;}
public static List<String> pdfbox_f3337_0(COSArray stringArray)
{    List<String> retval = null;    if (stringArray != null) {        List<String> string = new ArrayList<>();        for (int i = 0; i < stringArray.size(); i++) {            string.add(((COSString) stringArray.getObject(i)).getString());        }        retval = new COSArrayList<>(string, stringArray);    }    return retval;}
public static COSArray pdfbox_f3338_0(List<String> strings)
{    COSArray retval = new COSArray();    for (String string : strings) {        retval.add(COSName.getPDFName(string));    }    return retval;}
public static COSArray pdfbox_f3339_0(List<String> strings)
{    COSArray retval = new COSArray();    for (String string : strings) {        retval.add(new COSString(string));    }    return retval;}
public static COSArray pdfbox_f3340_0(List<?> cosObjectableList)
{    COSArray array = null;    if (cosObjectableList != null) {        if (cosObjectableList instanceof COSArrayList) {                        array = ((COSArrayList<?>) cosObjectableList).array;        } else {            array = new COSArray();            for (Object next : cosObjectableList) {                if (next instanceof String) {                    array.add(new COSString((String) next));                } else if (next instanceof Integer || next instanceof Long) {                    array.add(COSInteger.get(((Number) next).longValue()));                } else if (next instanceof Float || next instanceof Double) {                    array.add(new COSFloat(((Number) next).floatValue()));                } else if (next instanceof COSObjectable) {                    COSObjectable object = (COSObjectable) next;                    array.add(object.getCOSObject());                } else if (next == null) {                    array.add(COSNull.NULL);                } else {                    throw new IllegalArgumentException("Error: Don't know how to convert type to COSBase '" + next.getClass().getName() + "'");                }            }        }    }    return array;}
private List<COSBase> pdfbox_f3341_0(Collection<?> list)
{    List<COSBase> cosObjects = new ArrayList<>();    for (Object next : list) {        if (next instanceof String) {            cosObjects.add(new COSString((String) next));        } else {            COSObjectable cos = (COSObjectable) next;            cosObjects.add(cos.getCOSObject());        }    }    return cosObjects;}
public boolean pdfbox_f3342_0(Collection<?> c)
{    array.removeAll(toCOSObjectList(c));    return actual.removeAll(c);}
public boolean pdfbox_f3343_0(Collection<?> c)
{    array.retainAll(toCOSObjectList(c));    return actual.retainAll(c);}
public void pdfbox_f3344_0()
{        if (parentDict != null) {        parentDict.setItem(dictKey, null);    }    actual.clear();    array.clear();}
public boolean pdfbox_f3345_0(Object o)
{    return actual.equals(o);}
public int pdfbox_f3346_0()
{    return actual.hashCode();}
public E pdfbox_f3347_0(int index)
{    return actual.get(index);}
public E pdfbox_f3348_0(int index, E element)
{    if (element instanceof String) {        COSString item = new COSString((String) element);        if (parentDict != null && index == 0) {            parentDict.setItem(dictKey, item);        }        array.set(index, item);    } else {        if (parentDict != null && index == 0) {            parentDict.setItem(dictKey, ((COSObjectable) element).getCOSObject());        }        array.set(index, ((COSObjectable) element).getCOSObject());    }    return actual.set(index, element);}
public void pdfbox_f3349_0(int index, E element)
{        if (parentDict != null) {        parentDict.setItem(dictKey, array);                        parentDict = null;    }    actual.add(index, element);    if (element instanceof String) {        array.add(index, new COSString((String) element));    } else {        array.add(index, ((COSObjectable) element).getCOSObject());    }}
public E pdfbox_f3350_0(int index)
{    array.remove(index);    return actual.remove(index);}
public int pdfbox_f3351_0(Object o)
{    return actual.indexOf(o);}
public int pdfbox_f3352_0(Object o)
{    return actual.indexOf(o);}
public ListIterator<E> pdfbox_f3353_0()
{    return actual.listIterator();}
public ListIterator<E> pdfbox_f3354_0(int index)
{    return actual.listIterator(index);}
public List<E> pdfbox_f3355_0(int fromIndex, int toIndex)
{    return actual.subList(fromIndex, toIndex);}
public String pdfbox_f3356_0()
{    return "COSArrayList{" + array.toString() + "}";}
public COSArray pdfbox_f3357_0()
{    return array;}
public int pdfbox_f3358_0()
{    return map.size();}
public boolean pdfbox_f3359_0()
{    return size() == 0;}
public boolean pdfbox_f3360_0(Object key)
{    return actuals.containsKey(key);}
public boolean pdfbox_f3361_0(Object value)
{    return actuals.containsValue(value);}
public V pdfbox_f3362_0(Object key)
{    return actuals.get(key);}
public V pdfbox_f3363_0(K key, V value)
{    COSObjectable object = (COSObjectable) value;    map.setItem(COSName.getPDFName((String) key), object.getCOSObject());    return actuals.put(key, value);}
public V pdfbox_f3364_0(Object key)
{    map.removeItem(COSName.getPDFName((String) key));    return actuals.remove(key);}
public void pdfbox_f3365_0(Map<? extends K, ? extends V> t)
{    throw new RuntimeException("Not yet implemented");}
public void pdfbox_f3366_0()
{    map.clear();    actuals.clear();}
public Set<K> pdfbox_f3367_0()
{    return actuals.keySet();}
public Collection<V> pdfbox_f3368_0()
{    return actuals.values();}
public Set<Map.Entry<K, V>> pdfbox_f3369_0()
{    return Collections.unmodifiableSet(actuals.entrySet());}
public boolean pdfbox_f3370_0(Object o)
{    boolean retval = false;    if (o instanceof COSDictionaryMap) {        COSDictionaryMap<K, V> other = (COSDictionaryMap<K, V>) o;        retval = other.map.equals(this.map);    }    return retval;}
public String pdfbox_f3371_0()
{    return actuals.toString();}
public int pdfbox_f3372_0()
{    return map.hashCode();}
public static COSDictionary pdfbox_f3373_0(Map<String, ?> someMap)
{    COSDictionary dic = new COSDictionary();    for (Entry<String, ?> entry : someMap.entrySet()) {        String name = entry.getKey();        COSObjectable object = (COSObjectable) entry.getValue();        dic.setItem(COSName.getPDFName(name), object.getCOSObject());    }    return dic;}
public static COSDictionaryMap<String, Object> pdfbox_f3374_0(COSDictionary map) throws IOException
{    COSDictionaryMap<String, Object> retval = null;    if (map != null) {        Map<String, Object> actualMap = new HashMap<>();        for (COSName key : map.keySet()) {            COSBase cosObj = map.getDictionaryObject(key);            Object actualObject = null;            if (cosObj instanceof COSString) {                actualObject = ((COSString) cosObj).getString();            } else if (cosObj instanceof COSInteger) {                actualObject = ((COSInteger) cosObj).intValue();            } else if (cosObj instanceof COSName) {                actualObject = ((COSName) cosObj).getName();            } else if (cosObj instanceof COSFloat) {                actualObject = ((COSFloat) cosObj).floatValue();            } else if (cosObj instanceof COSBoolean) {                actualObject = ((COSBoolean) cosObj).getValue() ? Boolean.TRUE : Boolean.FALSE;            } else {                throw new IOException("Error:unknown type of object to convert:" + cosObj);            }            actualMap.put(key.getName(), actualObject);        }        retval = new COSDictionaryMap<>(actualMap, map);    }    return retval;}
public COSDictionary pdfbox_f3375_0()
{    return fs;}
private COSDictionary pdfbox_f3376_0()
{    if (efDictionary == null && fs != null) {        efDictionary = (COSDictionary) fs.getDictionaryObject(COSName.EF);    }    return efDictionary;}
private COSBase pdfbox_f3377_0(COSName key)
{    COSDictionary ef = getEFDictionary();    if (ef != null) {        return ef.getDictionaryObject(key);    }    return null;}
public String pdfbox_f3378_0()
{    String filename = getFileUnicode();    if (filename == null) {        filename = getFileDos();    }    if (filename == null) {        filename = getFileMac();    }    if (filename == null) {        filename = getFileUnix();    }    if (filename == null) {        filename = getFile();    }    return filename;}
public String pdfbox_f3379_0()
{    return fs.getString(COSName.UF);}
public void pdfbox_f3380_0(String file)
{    fs.setString(COSName.UF, file);}
public String pdfbox_f3381_0()
{    return fs.getString(COSName.F);}
public void pdfbox_f3382_0(String file)
{    fs.setString(COSName.F, file);}
public String pdfbox_f3383_0()
{    return fs.getString(COSName.DOS);}
public void pdfbox_f3384_0(String file)
{    fs.setString(COSName.DOS, file);}
public String pdfbox_f3385_0()
{    return fs.getString(COSName.MAC);}
public void pdfbox_f3386_0(String file)
{    fs.setString(COSName.MAC, file);}
public String pdfbox_f3387_0()
{    return fs.getString(COSName.UNIX);}
public void pdfbox_f3388_0(String file)
{    fs.setString(COSName.UNIX, file);}
public void pdfbox_f3389_0(boolean fileIsVolatile)
{    fs.setBoolean(COSName.V, fileIsVolatile);}
public boolean pdfbox_f3390_0()
{    return fs.getBoolean(COSName.V, false);}
public PDEmbeddedFile pdfbox_f3391_0()
{    PDEmbeddedFile file = null;    COSStream stream = (COSStream) getObjectFromEFDictionary(COSName.F);    if (stream != null) {        file = new PDEmbeddedFile(stream);    }    return file;}
public void pdfbox_f3392_0(PDEmbeddedFile file)
{    COSDictionary ef = getEFDictionary();    if (ef == null && file != null) {        ef = new COSDictionary();        fs.setItem(COSName.EF, ef);    }    if (ef != null) {        ef.setItem(COSName.F, file);    }}
public PDEmbeddedFile pdfbox_f3393_0()
{    PDEmbeddedFile file = null;    COSStream stream = (COSStream) getObjectFromEFDictionary(COSName.DOS);    if (stream != null) {        file = new PDEmbeddedFile(stream);    }    return file;}
public void pdfbox_f3394_0(PDEmbeddedFile file)
{    COSDictionary ef = getEFDictionary();    if (ef == null && file != null) {        ef = new COSDictionary();        fs.setItem(COSName.EF, ef);    }    if (ef != null) {        ef.setItem(COSName.DOS, file);    }}
public PDEmbeddedFile pdfbox_f3395_0()
{    PDEmbeddedFile file = null;    COSStream stream = (COSStream) getObjectFromEFDictionary(COSName.MAC);    if (stream != null) {        file = new PDEmbeddedFile(stream);    }    return file;}
public void pdfbox_f3396_0(PDEmbeddedFile file)
{    COSDictionary ef = getEFDictionary();    if (ef == null && file != null) {        ef = new COSDictionary();        fs.setItem(COSName.EF, ef);    }    if (ef != null) {        ef.setItem(COSName.MAC, file);    }}
public PDEmbeddedFile pdfbox_f3397_0()
{    PDEmbeddedFile file = null;    COSStream stream = (COSStream) getObjectFromEFDictionary(COSName.UNIX);    if (stream != null) {        file = new PDEmbeddedFile(stream);    }    return file;}
public void pdfbox_f3398_0(PDEmbeddedFile file)
{    COSDictionary ef = getEFDictionary();    if (ef == null && file != null) {        ef = new COSDictionary();        fs.setItem(COSName.EF, ef);    }    if (ef != null) {        ef.setItem(COSName.UNIX, file);    }}
public PDEmbeddedFile pdfbox_f3399_0()
{    PDEmbeddedFile file = null;    COSStream stream = (COSStream) getObjectFromEFDictionary(COSName.UF);    if (stream != null) {        file = new PDEmbeddedFile(stream);    }    return file;}
public void pdfbox_f3400_0(PDEmbeddedFile file)
{    COSDictionary ef = getEFDictionary();    if (ef == null && file != null) {        ef = new COSDictionary();        fs.setItem(COSName.EF, ef);    }    if (ef != null) {        ef.setItem(COSName.UF, file);    }}
public void pdfbox_f3401_0(String description)
{    fs.setString(COSName.DESC, description);}
public String pdfbox_f3402_0()
{    return fs.getString(COSName.DESC);}
public void pdfbox_f3403_0(String mimeType)
{    getCOSObject().setName(COSName.SUBTYPE, mimeType);}
public String pdfbox_f3404_0()
{    return getCOSObject().getNameAsString(COSName.SUBTYPE);}
public int pdfbox_f3405_0()
{    return getCOSObject().getEmbeddedInt("Params", "Size");}
public void pdfbox_f3406_0(int size)
{    getCOSObject().setEmbeddedInt("Params", "Size", size);}
public Calendar pdfbox_f3407_0() throws IOException
{    return getCOSObject().getEmbeddedDate("Params", "CreationDate");}
public void pdfbox_f3408_0(Calendar creation)
{    getCOSObject().setEmbeddedDate("Params", "CreationDate", creation);}
public Calendar pdfbox_f3409_0() throws IOException
{    return getCOSObject().getEmbeddedDate("Params", "ModDate");}
public void pdfbox_f3410_0(Calendar mod)
{    getCOSObject().setEmbeddedDate("Params", "ModDate", mod);}
public String pdfbox_f3411_0()
{    return getCOSObject().getEmbeddedString("Params", "CheckSum");}
public void pdfbox_f3412_0(String checksum)
{    getCOSObject().setEmbeddedString("Params", "CheckSum", checksum);}
public String pdfbox_f3413_0()
{    String retval = null;    COSDictionary params = (COSDictionary) getCOSObject().getDictionaryObject(COSName.PARAMS);    if (params != null) {        retval = params.getEmbeddedString("Mac", "Subtype");    }    return retval;}
public void pdfbox_f3414_0(String macSubtype)
{    COSDictionary params = (COSDictionary) getCOSObject().getDictionaryObject(COSName.PARAMS);    if (params == null && macSubtype != null) {        params = new COSDictionary();        getCOSObject().setItem(COSName.PARAMS, params);    }    if (params != null) {        params.setEmbeddedString("Mac", "Subtype", macSubtype);    }}
public String pdfbox_f3415_0()
{    String retval = null;    COSDictionary params = (COSDictionary) getCOSObject().getDictionaryObject(COSName.PARAMS);    if (params != null) {        retval = params.getEmbeddedString("Mac", "Creator");    }    return retval;}
public void pdfbox_f3416_0(String macCreator)
{    COSDictionary params = (COSDictionary) getCOSObject().getDictionaryObject(COSName.PARAMS);    if (params == null && macCreator != null) {        params = new COSDictionary();        getCOSObject().setItem(COSName.PARAMS, params);    }    if (params != null) {        params.setEmbeddedString("Mac", "Creator", macCreator);    }}
public String pdfbox_f3417_0()
{    String retval = null;    COSDictionary params = (COSDictionary) getCOSObject().getDictionaryObject(COSName.PARAMS);    if (params != null) {        retval = params.getEmbeddedString("Mac", "ResFork");    }    return retval;}
public void pdfbox_f3418_0(String macResFork)
{    COSDictionary params = (COSDictionary) getCOSObject().getDictionaryObject(COSName.PARAMS);    if (params == null && macResFork != null) {        params = new COSDictionary();        getCOSObject().setItem(COSName.PARAMS, params);    }    if (params != null) {        params.setEmbeddedString("Mac", "ResFork", macResFork);    }}
public static PDFileSpecification pdfbox_f3419_0(COSBase base) throws IOException
{    PDFileSpecification retval = null;    if (base == null) {        } else if (base instanceof COSString) {        retval = new PDSimpleFileSpecification((COSString) base);    } else if (base instanceof COSDictionary) {        retval = new PDComplexFileSpecification((COSDictionary) base);    } else {        throw new IOException("Error: Unknown file specification " + base);    }    return retval;}
public String pdfbox_f3420_0()
{    return file.getString();}
public void pdfbox_f3421_0(String fileName)
{    file = new COSString(fileName);}
public COSBase pdfbox_f3422_0()
{    return file;}
public COSDictionary pdfbox_f3423_0()
{    if (functionStream != null) {        return functionStream.getCOSObject();    } else {        return functionDictionary;    }}
protected PDStream pdfbox_f3424_0()
{    return functionStream;}
public static PDFunction pdfbox_f3425_0(COSBase function) throws IOException
{    if (function == COSName.IDENTITY) {        return new PDFunctionTypeIdentity(null);    }    COSBase base = function;    if (function instanceof COSObject) {        base = ((COSObject) function).getObject();    }    if (!(base instanceof COSDictionary)) {        throw new IOException("Error: Function must be a Dictionary, but is " + base.getClass().getSimpleName());    }    COSDictionary functionDictionary = (COSDictionary) base;    int functionType = functionDictionary.getInt(COSName.FUNCTION_TYPE);    switch(functionType) {        case 0:            return new PDFunctionType0(functionDictionary);        case 2:            return new PDFunctionType2(functionDictionary);        case 3:            return new PDFunctionType3(functionDictionary);        case 4:            return new PDFunctionType4(functionDictionary);        default:            throw new IOException("Error: Unknown function type " + functionType);    }}
public int pdfbox_f3426_0()
{    if (numberOfOutputValues == -1) {        COSArray rangeValues = getRangeValues();        numberOfOutputValues = rangeValues.size() / 2;    }    return numberOfOutputValues;}
public PDRange pdfbox_f3427_0(int n)
{    COSArray rangeValues = getRangeValues();    return new PDRange(rangeValues, n);}
public void pdfbox_f3428_0(COSArray rangeValues)
{    range = rangeValues;    getCOSObject().setItem(COSName.RANGE, rangeValues);}
public int pdfbox_f3429_0()
{    if (numberOfInputValues == -1) {        COSArray array = getDomainValues();        numberOfInputValues = array.size() / 2;    }    return numberOfInputValues;}
public PDRange pdfbox_f3430_0(int n)
{    COSArray domainValues = getDomainValues();    return new PDRange(domainValues, n);}
public void pdfbox_f3431_0(COSArray domainValues)
{    domain = domainValues;    getCOSObject().setItem(COSName.DOMAIN, domainValues);}
protected COSArray pdfbox_f3432_0()
{    if (range == null) {        range = (COSArray) getCOSObject().getDictionaryObject(COSName.RANGE);    }    return range;}
private COSArray pdfbox_f3433_0()
{    if (domain == null) {        domain = (COSArray) getCOSObject().getDictionaryObject(COSName.DOMAIN);    }    return domain;}
protected float[] pdfbox_f3434_0(float[] inputValues)
{    COSArray rangesArray = getRangeValues();    float[] result;    if (rangesArray != null) {        float[] rangeValues = rangesArray.toFloatArray();        int numberOfRanges = rangeValues.length / 2;        result = new float[numberOfRanges];        for (int i = 0; i < numberOfRanges; i++) {            int index = i << 1;            result[i] = clipToRange(inputValues[i], rangeValues[index], rangeValues[index + 1]);        }    } else {        result = inputValues;    }    return result;}
protected float pdfbox_f3435_0(float x, float rangeMin, float rangeMax)
{    if (x < rangeMin) {        return rangeMin;    } else if (x > rangeMax) {        return rangeMax;    }    return x;}
protected float pdfbox_f3436_0(float x, float xRangeMin, float xRangeMax, float yRangeMin, float yRangeMax)
{    return yRangeMin + ((x - xRangeMin) * (yRangeMax - yRangeMin) / (xRangeMax - xRangeMin));}
public String pdfbox_f3437_0()
{    return "FunctionType" + getFunctionType();}
public int pdfbox_f3438_0()
{    return 0;}
public COSArray pdfbox_f3439_0()
{    if (size == null) {        size = (COSArray) getCOSObject().getDictionaryObject(COSName.SIZE);    }    return size;}
public int pdfbox_f3440_0()
{    return getCOSObject().getInt(COSName.BITS_PER_SAMPLE);}
public int pdfbox_f3441_0()
{    return getCOSObject().getInt(COSName.ORDER, 1);}
public void pdfbox_f3442_0(int bps)
{    getCOSObject().setInt(COSName.BITS_PER_SAMPLE, bps);}
private COSArray pdfbox_f3443_0()
{    if (encode == null) {        encode = (COSArray) getCOSObject().getDictionaryObject(COSName.ENCODE);                if (encode == null) {            encode = new COSArray();            COSArray sizeValues = getSize();            int sizeValuesSize = sizeValues.size();            for (int i = 0; i < sizeValuesSize; i++) {                encode.add(COSInteger.ZERO);                encode.add(COSInteger.get(sizeValues.getInt(i) - 1));            }        }    }    return encode;}
private COSArray pdfbox_f3444_0()
{    if (decode == null) {        decode = (COSArray) getCOSObject().getDictionaryObject(COSName.DECODE);                if (decode == null) {            decode = getRangeValues();        }    }    return decode;}
public PDRange pdfbox_f3445_0(int paramNum)
{    PDRange retval = null;    COSArray encodeValues = getEncodeValues();    if (encodeValues != null && encodeValues.size() >= paramNum * 2 + 1) {        retval = new PDRange(encodeValues, paramNum);    }    return retval;}
public void pdfbox_f3446_0(COSArray encodeValues)
{    encode = encodeValues;    getCOSObject().setItem(COSName.ENCODE, encodeValues);}
public PDRange pdfbox_f3447_0(int paramNum)
{    PDRange retval = null;    COSArray decodeValues = getDecodeValues();    if (decodeValues != null && decodeValues.size() >= paramNum * 2 + 1) {        retval = new PDRange(decodeValues, paramNum);    }    return retval;}
public void pdfbox_f3448_0(COSArray decodeValues)
{    decode = decodeValues;    getCOSObject().setItem(COSName.DECODE, decodeValues);}
 float[] pdfbox_f3449_0()
{    return rinterpol(new int[numberOfInputValues], 0);}
private float[] pdfbox_f3450_0(int[] coord, int step)
{    float[] resultSample = new float[numberOfOutputValues];    if (step == in.length - 1) {                if (inPrev[step] == inNext[step]) {            coord[step] = inPrev[step];            int[] tmpSample = getSamples()[calcSampleIndex(coord)];            for (int i = 0; i < numberOfOutputValues; ++i) {                resultSample[i] = tmpSample[i];            }            return resultSample;        }        coord[step] = inPrev[step];        int[] sample1 = getSamples()[calcSampleIndex(coord)];        coord[step] = inNext[step];        int[] sample2 = getSamples()[calcSampleIndex(coord)];        for (int i = 0; i < numberOfOutputValues; ++i) {            resultSample[i] = interpolate(in[step], inPrev[step], inNext[step], sample1[i], sample2[i]);        }        return resultSample;    } else {                if (inPrev[step] == inNext[step]) {            coord[step] = inPrev[step];            return rinterpol(coord, step + 1);        }        coord[step] = inPrev[step];        float[] sample1 = rinterpol(coord, step + 1);        coord[step] = inNext[step];        float[] sample2 = rinterpol(coord, step + 1);        for (int i = 0; i < numberOfOutputValues; ++i) {            resultSample[i] = interpolate(in[step], inPrev[step], inNext[step], sample1[i], sample2[i]);        }        return resultSample;    }}
private int pdfbox_f3451_0(int[] vector)
{            float[] sizeValues = getSize().toFloatArray();    int index = 0;    int sizeProduct = 1;    int dimension = vector.length;    for (int i = dimension - 2; i >= 0; --i) {        sizeProduct *= sizeValues[i];    }    for (int i = dimension - 1; i >= 0; --i) {        index += sizeProduct * vector[i];        if (i - 1 >= 0) {            sizeProduct /= sizeValues[i - 1];        }    }    return index;}
private int[][] pdfbox_f3452_1()
{    if (samples == null) {        int arraySize = 1;        int nIn = getNumberOfInputParameters();        int nOut = getNumberOfOutputParameters();        COSArray sizes = getSize();        for (int i = 0; i < nIn; i++) {            arraySize *= sizes.getInt(i);        }        samples = new int[arraySize][nOut];        int bitsPerSample = getBitsPerSample();        int index = 0;        try {                        try (ImageInputStream mciis = new MemoryCacheImageInputStream(getPDStream().createInputStream())) {                for (int i = 0; i < arraySize; i++) {                    for (int k = 0; k < nOut; k++) {                                                samples[index][k] = (int) mciis.readBits(bitsPerSample);                    }                    index++;                }            }        } catch (IOException exception) {                    }    }    return samples;}
public float[] pdfbox_f3453_0(float[] input) throws IOException
{            float[] sizeValues = getSize().toFloatArray();    int bitsPerSample = getBitsPerSample();    float maxSample = (float) (Math.pow(2, bitsPerSample) - 1.0);    int numberOfInputValues = input.length;    int numberOfOutputValues = getNumberOfOutputParameters();    int[] inputPrev = new int[numberOfInputValues];    int[] inputNext = new int[numberOfInputValues];        input = input.clone();    for (int i = 0; i < numberOfInputValues; i++) {        PDRange domain = getDomainForInput(i);        PDRange encodeValues = getEncodeForParameter(i);        input[i] = clipToRange(input[i], domain.getMin(), domain.getMax());        input[i] = interpolate(input[i], domain.getMin(), domain.getMax(), encodeValues.getMin(), encodeValues.getMax());        input[i] = clipToRange(input[i], 0, sizeValues[i] - 1);        inputPrev[i] = (int) Math.floor(input[i]);        inputNext[i] = (int) Math.ceil(input[i]);    }    float[] outputValues = new Rinterpol(input, inputPrev, inputNext).rinterpolate();    for (int i = 0; i < numberOfOutputValues; i++) {        PDRange range = getRangeForOutput(i);        PDRange decodeValues = getDecodeForParameter(i);        outputValues[i] = interpolate(outputValues[i], 0, maxSample, decodeValues.getMin(), decodeValues.getMax());        outputValues[i] = clipToRange(outputValues[i], range.getMin(), range.getMax());    }    return outputValues;}
public int pdfbox_f3454_0()
{    return 2;}
public float[] pdfbox_f3455_0(float[] input) throws IOException
{            float xToN = (float) Math.pow(input[0], exponent);    float[] result = new float[Math.min(c0.size(), c1.size())];    for (int j = 0; j < result.length; j++) {        float c0j = ((COSNumber) c0.get(j)).floatValue();        float c1j = ((COSNumber) c1.get(j)).floatValue();        result[j] = c0j + xToN * (c1j - c0j);    }    return clipToRange(result);}
public COSArray pdfbox_f3456_0()
{    return c0;}
public COSArray pdfbox_f3457_0()
{    return c1;}
public float pdfbox_f3458_0()
{    return exponent;}
public String pdfbox_f3459_0()
{    return "FunctionType2{" + "C0: " + getC0() + " " + "C1: " + getC1() + " " + "N: " + getN() + "}";}
public int pdfbox_f3460_0()
{    return 3;}
public float[] pdfbox_f3461_0(float[] input) throws IOException
{                PDFunction function = null;    float x = input[0];    PDRange domain = getDomainForInput(0);        x = clipToRange(x, domain.getMin(), domain.getMax());    if (functionsArray == null) {        COSArray ar = getFunctions();        functionsArray = new PDFunction[ar.size()];        for (int i = 0; i < ar.size(); ++i) {            functionsArray[i] = PDFunction.create(ar.getObject(i));        }    }    if (functionsArray.length == 1) {                function = functionsArray[0];        PDRange encRange = getEncodeForParameter(0);        x = interpolate(x, domain.getMin(), domain.getMax(), encRange.getMin(), encRange.getMax());    } else {        if (boundsValues == null) {            boundsValues = getBounds().toFloatArray();        }        int boundsSize = boundsValues.length;                        float[] partitionValues = new float[boundsSize + 2];        int partitionValuesSize = partitionValues.length;        partitionValues[0] = domain.getMin();        partitionValues[partitionValuesSize - 1] = domain.getMax();        System.arraycopy(boundsValues, 0, partitionValues, 1, boundsSize);                for (int i = 0; i < partitionValuesSize - 1; i++) {            if (x >= partitionValues[i] && (x < partitionValues[i + 1] || (i == partitionValuesSize - 2 && Float.compare(x, partitionValues[i + 1]) == 0))) {                function = functionsArray[i];                PDRange encRange = getEncodeForParameter(i);                x = interpolate(x, partitionValues[i], partitionValues[i + 1], encRange.getMin(), encRange.getMax());                break;            }        }        if (function == null) {            throw new IOException("partition not found in type 3 function");        }    }    float[] functionValues = new float[] { x };        float[] functionResult = function.eval(functionValues);        return clipToRange(functionResult);}
public COSArray pdfbox_f3462_0()
{    if (functions == null) {        functions = (COSArray) (getCOSObject().getDictionaryObject(COSName.FUNCTIONS));    }    return functions;}
public COSArray pdfbox_f3463_0()
{    if (bounds == null) {        bounds = (COSArray) (getCOSObject().getDictionaryObject(COSName.BOUNDS));    }    return bounds;}
public COSArray pdfbox_f3464_0()
{    if (encode == null) {        encode = (COSArray) (getCOSObject().getDictionaryObject(COSName.ENCODE));    }    return encode;}
private PDRange pdfbox_f3465_0(int n)
{    COSArray encodeValues = getEncode();    return new PDRange(encodeValues, n);}
public int pdfbox_f3466_0()
{    return 4;}
public float[] pdfbox_f3467_0(float[] input) throws IOException
{        ExecutionContext context = new ExecutionContext(OPERATORS);    for (int i = 0; i < input.length; i++) {        PDRange domain = getDomainForInput(i);        float value = clipToRange(input[i], domain.getMin(), domain.getMax());        context.getStack().push(value);    }        instructions.execute(context);        int numberOfOutputValues = getNumberOfOutputParameters();    int numberOfActualOutputValues = context.getStack().size();    if (numberOfActualOutputValues < numberOfOutputValues) {        throw new IllegalStateException("The type 4 function returned " + numberOfActualOutputValues + " values but the Range entry indicates that " + numberOfOutputValues + " values be returned.");    }    float[] outputValues = new float[numberOfOutputValues];    for (int i = numberOfOutputValues - 1; i >= 0; i--) {        PDRange range = getRangeForOutput(i);        outputValues[i] = context.popReal();        outputValues[i] = clipToRange(outputValues[i], range.getMin(), range.getMax());    }        return outputValues;}
public int pdfbox_f3468_0()
{        throw new UnsupportedOperationException();}
public float[] pdfbox_f3469_0(float[] input) throws IOException
{    return input;}
public String pdfbox_f3470_0()
{    return "FunctionTypeIdentity";}
public void pdfbox_f3471_0(ExecutionContext context)
{    Number num = context.popNumber();    if (num instanceof Integer) {        context.getStack().push(Math.abs(num.intValue()));    } else {        context.getStack().push(Math.abs(num.floatValue()));    }}
public void pdfbox_f3472_0(ExecutionContext context)
{    Number num2 = context.popNumber();    Number num1 = context.popNumber();    if (num1 instanceof Integer && num2 instanceof Integer) {        long sum = num1.longValue() + num2.longValue();        if (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) {            context.getStack().push((float) sum);        } else {            context.getStack().push((int) sum);        }    } else {        float sum = num1.floatValue() + num2.floatValue();        context.getStack().push(sum);    }}
public void pdfbox_f3473_0(ExecutionContext context)
{    float den = context.popReal();    float num = context.popReal();    float atan = (float) Math.atan2(num, den);    atan = (float) Math.toDegrees(atan) % 360;    if (atan < 0) {        atan = atan + 360;    }    context.getStack().push(atan);}
public void pdfbox_f3474_0(ExecutionContext context)
{    Number num = context.popNumber();    if (num instanceof Integer) {        context.getStack().push(num);    } else {        context.getStack().push((float) Math.ceil(num.doubleValue()));    }}
public void pdfbox_f3475_0(ExecutionContext context)
{    float angle = context.popReal();    float cos = (float) Math.cos(Math.toRadians(angle));    context.getStack().push(cos);}
public void pdfbox_f3476_0(ExecutionContext context)
{    Number num = context.popNumber();    context.getStack().push(num.intValue());}
public void pdfbox_f3477_0(ExecutionContext context)
{    Number num = context.popNumber();    context.getStack().push(num.floatValue());}
public void pdfbox_f3478_0(ExecutionContext context)
{    Number num2 = context.popNumber();    Number num1 = context.popNumber();    context.getStack().push(num1.floatValue() / num2.floatValue());}
public void pdfbox_f3479_0(ExecutionContext context)
{    Number exp = context.popNumber();    Number base = context.popNumber();    double value = Math.pow(base.doubleValue(), exp.doubleValue());    context.getStack().push((float) value);}
public void pdfbox_f3480_0(ExecutionContext context)
{    Number num = context.popNumber();    if (num instanceof Integer) {        context.getStack().push(num);    } else {        context.getStack().push((float) Math.floor(num.doubleValue()));    }}
public void pdfbox_f3481_0(ExecutionContext context)
{    int num2 = context.popInt();    int num1 = context.popInt();    context.getStack().push(num1 / num2);}
public void pdfbox_f3482_0(ExecutionContext context)
{    Number num = context.popNumber();    context.getStack().push((float) Math.log(num.doubleValue()));}
public void pdfbox_f3483_0(ExecutionContext context)
{    Number num = context.popNumber();    context.getStack().push((float) Math.log10(num.doubleValue()));}
public void pdfbox_f3484_0(ExecutionContext context)
{    int int2 = context.popInt();    int int1 = context.popInt();    context.getStack().push(int1 % int2);}
public void pdfbox_f3485_0(ExecutionContext context)
{    Number num2 = context.popNumber();    Number num1 = context.popNumber();    if (num1 instanceof Integer && num2 instanceof Integer) {        long result = num1.longValue() * num2.longValue();        if (result >= Integer.MIN_VALUE && result <= Integer.MAX_VALUE) {            context.getStack().push((int) result);        } else {            context.getStack().push((float) result);        }    } else {        double result = num1.doubleValue() * num2.doubleValue();        context.getStack().push((float) result);    }}
public void pdfbox_f3486_0(ExecutionContext context)
{    Number num = context.popNumber();    if (num instanceof Integer) {        int v = num.intValue();        if (v == Integer.MIN_VALUE) {            context.getStack().push(-num.floatValue());        } else {            context.getStack().push(-num.intValue());        }    } else {        context.getStack().push(-num.floatValue());    }}
public void pdfbox_f3487_0(ExecutionContext context)
{    Number num = context.popNumber();    if (num instanceof Integer) {        context.getStack().push(num.intValue());    } else {        context.getStack().push((float) Math.round(num.doubleValue()));    }}
public void pdfbox_f3488_0(ExecutionContext context)
{    float angle = context.popReal();    float sin = (float) Math.sin(Math.toRadians(angle));    context.getStack().push(sin);}
public void pdfbox_f3489_0(ExecutionContext context)
{    float num = context.popReal();    if (num < 0) {        throw new IllegalArgumentException("argument must be nonnegative");    }    context.getStack().push((float) Math.sqrt(num));}
public void pdfbox_f3490_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    Number num2 = context.popNumber();    Number num1 = context.popNumber();    if (num1 instanceof Integer && num2 instanceof Integer) {        long result = num1.longValue() - num2.longValue();        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {            stack.push((float) result);        } else {            stack.push((int) result);        }    } else {        float result = num1.floatValue() - num2.floatValue();        stack.push(result);    }}
public void pdfbox_f3491_0(ExecutionContext context)
{    Number num = context.popNumber();    if (num instanceof Integer) {        context.getStack().push(num.intValue());    } else {        context.getStack().push((float) (int) (num.floatValue()));    }}
public void pdfbox_f3492_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    Object op2 = stack.pop();    Object op1 = stack.pop();    if (op1 instanceof Boolean && op2 instanceof Boolean) {        boolean bool1 = (Boolean) op1;        boolean bool2 = (Boolean) op2;        boolean result = applyForBoolean(bool1, bool2);        stack.push(result);    } else if (op1 instanceof Integer && op2 instanceof Integer) {        int int1 = (Integer) op1;        int int2 = (Integer) op2;        int result = applyforInteger(int1, int2);        stack.push(result);    } else {        throw new ClassCastException("Operands must be bool/bool or int/int");    }}
protected boolean pdfbox_f3493_0(boolean bool1, boolean bool2)
{    return bool1 && bool2;}
protected int pdfbox_f3494_0(int int1, int int2)
{    return int1 & int2;}
public void pdfbox_f3495_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    int shift = (Integer) stack.pop();    int int1 = (Integer) stack.pop();    if (shift < 0) {        int result = int1 >> Math.abs(shift);        stack.push(result);    } else {        int result = int1 << shift;        stack.push(result);    }}
public void pdfbox_f3496_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    stack.push(Boolean.FALSE);}
public void pdfbox_f3497_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    Object op1 = stack.pop();    if (op1 instanceof Boolean) {        boolean bool1 = (Boolean) op1;        boolean result = !bool1;        stack.push(result);    } else if (op1 instanceof Integer) {        int int1 = (Integer) op1;        int result = -int1;        stack.push(result);    } else {        throw new ClassCastException("Operand must be bool or int");    }}
protected boolean pdfbox_f3498_0(boolean bool1, boolean bool2)
{    return bool1 || bool2;}
protected int pdfbox_f3499_0(int int1, int int2)
{    return int1 | int2;}
public void pdfbox_f3500_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    stack.push(Boolean.TRUE);}
protected boolean pdfbox_f3501_0(boolean bool1, boolean bool2)
{    return bool1 ^ bool2;}
protected int pdfbox_f3502_0(int int1, int int2)
{    return int1 ^ int2;}
public void pdfbox_f3503_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    InstructionSequence proc = (InstructionSequence) stack.pop();    Boolean condition = (Boolean) stack.pop();    if (condition) {        proc.execute(context);    }}
public void pdfbox_f3504_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    InstructionSequence proc2 = (InstructionSequence) stack.pop();    InstructionSequence proc1 = (InstructionSequence) stack.pop();    Boolean condition = (Boolean) stack.pop();    if (condition) {        proc1.execute(context);    } else {        proc2.execute(context);    }}
public Stack<Object> pdfbox_f3505_0()
{    return this.stack;}
public Operators pdfbox_f3506_0()
{    return this.operators;}
public Number pdfbox_f3507_0()
{    return (Number) stack.pop();}
public int pdfbox_f3508_0()
{    return (Integer) stack.pop();}
public float pdfbox_f3509_0()
{    return ((Number) stack.pop()).floatValue();}
public void pdfbox_f3510_0(String name)
{    this.instructions.add(name);}
public void pdfbox_f3511_0(int value)
{    this.instructions.add(value);}
public void pdfbox_f3512_0(float value)
{    this.instructions.add(value);}
public void pdfbox_f3513_0(boolean value)
{    this.instructions.add(value);}
public void pdfbox_f3514_0(InstructionSequence child)
{    this.instructions.add(child);}
public void pdfbox_f3515_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    for (Object o : instructions) {        if (o instanceof String) {            String name = (String) o;            Operator cmd = context.getOperators().getOperator(name);            if (cmd != null) {                cmd.execute(context);            } else {                throw new UnsupportedOperationException("Unknown operator or name: " + name);            }        } else {            stack.push(o);        }    }        while (!stack.isEmpty() && stack.peek() instanceof InstructionSequence) {        InstructionSequence nested = (InstructionSequence) stack.pop();        nested.execute(context);    }}
public InstructionSequence pdfbox_f3516_0()
{    return this.mainSequence;}
public static InstructionSequence pdfbox_f3517_0(CharSequence text)
{    InstructionSequenceBuilder builder = new InstructionSequenceBuilder();    Parser.parse(text, builder);    return builder.getInstructionSequence();}
private InstructionSequence pdfbox_f3518_0()
{    return this.seqStack.peek();}
public void pdfbox_f3519_0(CharSequence text)
{    String token = text.toString();    token(token);}
private void pdfbox_f3520_0(String token)
{    if ("{".equals(token)) {        InstructionSequence child = new InstructionSequence();        getCurrentSequence().addProc(child);        this.seqStack.push(child);    } else if ("}".equals(token)) {        this.seqStack.pop();    } else {        Matcher m = INTEGER_PATTERN.matcher(token);        if (m.matches()) {            getCurrentSequence().addInteger(parseInt(token));            return;        }        m = REAL_PATTERN.matcher(token);        if (m.matches()) {            getCurrentSequence().addReal(parseReal(token));            return;        }                getCurrentSequence().addName(token);    }}
public static int pdfbox_f3521_0(String token)
{    return Integer.parseInt(token);}
public static float pdfbox_f3522_0(String token)
{    return Float.parseFloat(token);}
public Operator pdfbox_f3523_0(String operatorName)
{    return this.operators.get(operatorName);}
public static void pdfbox_f3524_0(CharSequence input, SyntaxHandler handler)
{    Tokenizer tokenizer = new Tokenizer(input, handler);    tokenizer.tokenize();}
private boolean pdfbox_f3528_0()
{    return index < input.length();}
private char pdfbox_f3529_0()
{    return input.charAt(index);}
private char pdfbox_f3530_0()
{    index++;    if (!hasMore()) {        return EOT;    } else {        return currentChar();    }}
private char pdfbox_f3531_0()
{    if (index < input.length() - 1) {        return input.charAt(index + 1);    } else {        return EOT;    }}
private State pdfbox_f3532_0()
{    char ch = currentChar();    switch(ch) {        case CR:        case LF:        case         FF:            state = State.NEWLINE;            break;        case NUL:        case TAB:        case SPACE:            state = State.WHITESPACE;            break;        case '%':            state = State.COMMENT;            break;        default:            state = State.TOKEN;    }    return state;}
private void pdfbox_f3533_0()
{    while (hasMore()) {        buffer.setLength(0);        nextState();        switch(state) {            case NEWLINE:                scanNewLine();                break;            case WHITESPACE:                scanWhitespace();                break;            case COMMENT:                scanComment();                break;            default:                scanToken();        }    }}
private void pdfbox_f3534_0()
{    assert state == State.NEWLINE;    char ch = currentChar();    buffer.append(ch);    if (ch == CR && peek() == LF) {                buffer.append(nextChar());    }    handler.newLine(buffer);    nextChar();}
private void pdfbox_f3535_0()
{    assert state == State.WHITESPACE;    buffer.append(currentChar());    loop: while (hasMore()) {        char ch = nextChar();        switch(ch) {            case NUL:            case TAB:            case SPACE:                buffer.append(ch);                break;            default:                break loop;        }    }    handler.whitespace(buffer);}
private void pdfbox_f3536_0()
{    assert state == State.COMMENT;    buffer.append(currentChar());    loop: while (hasMore()) {        char ch = nextChar();        switch(ch) {            case CR:            case LF:            case FF:                break loop;            default:                buffer.append(ch);        }    }        handler.comment(buffer);}
private void pdfbox_f3537_0()
{    assert state == State.TOKEN;    char ch = currentChar();    buffer.append(ch);    switch(ch) {        case '{':        case '}':            handler.token(buffer);            nextChar();            return;        default:    }    loop: while (hasMore()) {        ch = nextChar();        switch(ch) {            case NUL:            case TAB:            case SPACE:            case CR:            case LF:            case FF:            case EOT:            case '{':            case '}':                break loop;            default:                buffer.append(ch);        }    }        handler.token(buffer);}
public void pdfbox_f3538_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    Object op2 = stack.pop();    Object op1 = stack.pop();    boolean result = isEqual(op1, op2);    stack.push(result);}
protected boolean pdfbox_f3539_0(Object op1, Object op2)
{    boolean result;    if (op1 instanceof Number && op2 instanceof Number) {        Number num1 = (Number) op1;        Number num2 = (Number) op2;        result = Float.compare(num1.floatValue(), num2.floatValue()) == 0;    } else {        result = op1.equals(op2);    }    return result;}
public void pdfbox_f3540_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    Object op2 = stack.pop();    Object op1 = stack.pop();    Number num1 = (Number) op1;    Number num2 = (Number) op2;    boolean result = compare(num1, num2);    stack.push(result);}
protected boolean pdfbox_f3541_0(Number num1, Number num2)
{    return num1.floatValue() >= num2.floatValue();}
protected boolean pdfbox_f3542_0(Number num1, Number num2)
{    return num1.floatValue() > num2.floatValue();}
protected boolean pdfbox_f3543_0(Number num1, Number num2)
{    return num1.floatValue() <= num2.floatValue();}
protected boolean pdfbox_f3544_0(Number num1, Number num2)
{    return num1.floatValue() < num2.floatValue();}
protected boolean pdfbox_f3545_0(Object op1, Object op2)
{    boolean result = super.isEqual(op1, op2);    return !result;}
public void pdfbox_f3546_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    int n = ((Number) stack.pop()).intValue();    if (n > 0) {        int size = stack.size();                List<Object> copy = new java.util.ArrayList<>(stack.subList(size - n, size));        stack.addAll(copy);    }}
public void pdfbox_f3547_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    stack.push(stack.peek());}
public void pdfbox_f3548_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    Object any2 = stack.pop();    Object any1 = stack.pop();    stack.push(any2);    stack.push(any1);}
public void pdfbox_f3549_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    int n = ((Number) stack.pop()).intValue();    if (n < 0) {        throw new IllegalArgumentException("rangecheck: " + n);    }    int size = stack.size();    stack.push(stack.get(size - n - 1));}
public void pdfbox_f3550_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    stack.pop();}
public void pdfbox_f3551_0(ExecutionContext context)
{    Stack<Object> stack = context.getStack();    int j = ((Number) stack.pop()).intValue();    int n = ((Number) stack.pop()).intValue();    if (j == 0) {                return;    }    if (n < 0) {        throw new IllegalArgumentException("rangecheck: " + n);    }    LinkedList<Object> rolled = new LinkedList<>();    LinkedList<Object> moved = new LinkedList<>();    if (j < 0) {                int n1 = n + j;        for (int i = 0; i < n1; i++) {            moved.addFirst(stack.pop());        }        for (int i = j; i < 0; i++) {            rolled.addFirst(stack.pop());        }        stack.addAll(moved);        stack.addAll(rolled);    } else {                int n1 = n - j;        for (int i = j; i > 0; i--) {            rolled.addFirst(stack.pop());        }        for (int i = 0; i < n1; i++) {            moved.addFirst(stack.pop());        }        stack.addAll(rolled);        stack.addAll(moved);    }}
public COSDictionary pdfbox_f3552_0()
{    return this.dictionary;}
public boolean pdfbox_f3553_0(Object obj)
{    if (this == obj) {        return true;    }    if (obj instanceof PDDictionaryWrapper) {        return this.dictionary.equals(((PDDictionaryWrapper) obj).dictionary);    }    return false;}
public int pdfbox_f3554_0()
{    return this.dictionary.hashCode();}
public InputStream pdfbox_f3555_0() throws IOException
{    return createInputStream();}
public void pdfbox_f3556_0(byte[] xmp) throws IOException
{    try (OutputStream os = createOutputStream()) {        os.write(xmp);    }}
public COSDictionary pdfbox_f3557_0()
{    return node;}
public PDNameTreeNode<T> pdfbox_f3558_0()
{    return parent;}
public void pdfbox_f3559_0(PDNameTreeNode<T> parentNode)
{    parent = parentNode;    calculateLimits();}
public boolean pdfbox_f3560_0()
{    return parent == null;}
public List<PDNameTreeNode<T>> pdfbox_f3561_0()
{    List<PDNameTreeNode<T>> retval = null;    COSArray kids = (COSArray) node.getDictionaryObject(COSName.KIDS);    if (kids != null) {        List<PDNameTreeNode<T>> pdObjects = new ArrayList<>();        for (int i = 0; i < kids.size(); i++) {            pdObjects.add(createChildNode((COSDictionary) kids.getObject(i)));        }        retval = new COSArrayList<>(pdObjects, kids);    }    return retval;}
public void pdfbox_f3562_0(List<? extends PDNameTreeNode<T>> kids)
{    if (kids != null && kids.size() > 0) {        for (PDNameTreeNode<T> kidsNode : kids) {            kidsNode.setParent(this);        }        node.setItem(COSName.KIDS, COSArrayList.converterToCOSArray(kids));                if (isRootNode()) {            node.setItem(COSName.NAMES, null);        }    } else {                node.setItem(COSName.KIDS, null);                node.setItem(COSName.LIMITS, null);    }    calculateLimits();}
private void pdfbox_f3563_1()
{    if (isRootNode()) {        node.setItem(COSName.LIMITS, null);    } else {        List<PDNameTreeNode<T>> kids = getKids();        if (kids != null && kids.size() > 0) {            PDNameTreeNode<T> firstKid = kids.get(0);            PDNameTreeNode<T> lastKid = kids.get(kids.size() - 1);            String lowerLimit = firstKid.getLowerLimit();            setLowerLimit(lowerLimit);            String upperLimit = lastKid.getUpperLimit();            setUpperLimit(upperLimit);        } else {            try {                Map<String, T> names = getNames();                if (names != null && names.size() > 0) {                    Set<String> strings = names.keySet();                    String[] keys = strings.toArray(new String[strings.size()]);                    String lowerLimit = keys[0];                    setLowerLimit(lowerLimit);                    String upperLimit = keys[keys.length - 1];                    setUpperLimit(upperLimit);                } else {                    node.setItem(COSName.LIMITS, null);                }            } catch (IOException exception) {                node.setItem(COSName.LIMITS, null);                            }        }    }}
public T pdfbox_f3564_1(String name) throws IOException
{    T retval = null;    Map<String, T> names = getNames();    if (names != null) {        retval = names.get(name);    } else {        List<PDNameTreeNode<T>> kids = getKids();        if (kids != null) {            for (int i = 0; i < kids.size() && retval == null; i++) {                PDNameTreeNode<T> childNode = kids.get(i);                String upperLimit = childNode.getUpperLimit();                String lowerLimit = childNode.getLowerLimit();                if (upperLimit == null || lowerLimit == null || upperLimit.compareTo(lowerLimit) < 0 || (lowerLimit.compareTo(name) <= 0 && upperLimit.compareTo(name) >= 0)) {                    retval = childNode.getValue(name);                }            }        } else {                    }    }    return retval;}
public Map<String, T> pdfbox_f3565_0() throws IOException
{    COSArray namesArray = (COSArray) node.getDictionaryObject(COSName.NAMES);    if (namesArray != null) {        Map<String, T> names = new LinkedHashMap<>();        for (int i = 0; i < namesArray.size(); i += 2) {            COSString key = (COSString) namesArray.getObject(i);            COSBase cosValue = namesArray.getObject(i + 1);            names.put(key.getString(), convertCOSToPD(cosValue));        }        return Collections.unmodifiableMap(names);    } else {        return null;    }}
public void pdfbox_f3566_0(Map<String, T> names)
{    if (names == null) {        node.setItem(COSName.NAMES, (COSObjectable) null);        node.setItem(COSName.LIMITS, (COSObjectable) null);    } else {        COSArray array = new COSArray();        List<String> keys = new ArrayList<>(names.keySet());        Collections.sort(keys);        for (String key : keys) {            array.add(new COSString(key));            array.add(names.get(key));        }        node.setItem(COSName.NAMES, array);        calculateLimits();    }}
public String pdfbox_f3567_0()
{    String retval = null;    COSArray arr = (COSArray) node.getDictionaryObject(COSName.LIMITS);    if (arr != null) {        retval = arr.getString(1);    }    return retval;}
private void pdfbox_f3568_0(String upper)
{    COSArray arr = (COSArray) node.getDictionaryObject(COSName.LIMITS);    if (arr == null) {        arr = new COSArray();        arr.add(null);        arr.add(null);        node.setItem(COSName.LIMITS, arr);    }    arr.setString(1, upper);}
public String pdfbox_f3569_0()
{    String retval = null;    COSArray arr = (COSArray) node.getDictionaryObject(COSName.LIMITS);    if (arr != null) {        retval = arr.getString(0);    }    return retval;}
private void pdfbox_f3570_0(String lower)
{    COSArray arr = (COSArray) node.getDictionaryObject(COSName.LIMITS);    if (arr == null) {        arr = new COSArray();        arr.add(null);        arr.add(null);        node.setItem(COSName.LIMITS, arr);    }    arr.setString(0, lower);}
public COSDictionary pdfbox_f3571_0()
{    return node;}
public List<PDNumberTreeNode> pdfbox_f3572_0()
{    List<PDNumberTreeNode> retval = null;    COSArray kids = (COSArray) node.getDictionaryObject(COSName.KIDS);    if (kids != null) {        List<PDNumberTreeNode> pdObjects = new ArrayList<>();        for (int i = 0; i < kids.size(); i++) {            pdObjects.add(createChildNode((COSDictionary) kids.getObject(i)));        }        retval = new COSArrayList<>(pdObjects, kids);    }    return retval;}
public void pdfbox_f3573_0(List<? extends PDNumberTreeNode> kids)
{    if (kids != null && !kids.isEmpty()) {        PDNumberTreeNode firstKid = kids.get(0);        PDNumberTreeNode lastKid = kids.get(kids.size() - 1);        Integer lowerLimit = firstKid.getLowerLimit();        this.setLowerLimit(lowerLimit);        Integer upperLimit = lastKid.getUpperLimit();        this.setUpperLimit(upperLimit);    } else if (node.getDictionaryObject(COSName.NUMS) == null) {                node.setItem(COSName.LIMITS, null);    }    node.setItem(COSName.KIDS, COSArrayList.converterToCOSArray(kids));}
public Object pdfbox_f3574_1(Integer index) throws IOException
{    Map<Integer, COSObjectable> numbers = getNumbers();    if (numbers != null) {        return numbers.get(index);    }    Object retval = null;    List<PDNumberTreeNode> kids = getKids();    if (kids != null) {        for (int i = 0; i < kids.size() && retval == null; i++) {            PDNumberTreeNode childNode = kids.get(i);            if (childNode.getLowerLimit().compareTo(index) <= 0 && childNode.getUpperLimit().compareTo(index) >= 0) {                retval = childNode.getValue(index);            }        }    } else {            }    return retval;}
public Map<Integer, COSObjectable> pdfbox_f3575_1() throws IOException
{    Map<Integer, COSObjectable> indices = null;    COSBase numBase = node.getDictionaryObject(COSName.NUMS);    if (numBase instanceof COSArray) {        COSArray numbersArray = (COSArray) numBase;        indices = new HashMap<>();        for (int i = 0; i < numbersArray.size(); i += 2) {            COSBase base = numbersArray.getObject(i);            if (!(base instanceof COSInteger)) {                                return null;            }            COSInteger key = (COSInteger) base;            COSBase cosValue = numbersArray.getObject(i + 1);            indices.put(key.intValue(), cosValue == null ? null : convertCOSToPD(cosValue));        }        indices = Collections.unmodifiableMap(indices);    }    return indices;}
protected COSObjectable pdfbox_f3576_0(COSBase base) throws IOException
{        try {        return valueType.getDeclaredConstructor(base.getClass()).newInstance(base);    } catch (Exception t) {        throw new IOException("Error while trying to create value in number tree:" + t.getMessage(), t);    }}
protected PDNumberTreeNode pdfbox_f3577_0(COSDictionary dic)
{    return new PDNumberTreeNode(dic, valueType);}
public void pdfbox_f3578_0(Map<Integer, ? extends COSObjectable> numbers)
{    if (numbers == null) {        node.setItem(COSName.NUMS, (COSObjectable) null);        node.setItem(COSName.LIMITS, (COSObjectable) null);    } else {        List<Integer> keys = new ArrayList<>(numbers.keySet());        Collections.sort(keys);        COSArray array = new COSArray();        for (Integer key : keys) {            array.add(COSInteger.get(key));            COSObjectable obj = numbers.get(key);            array.add(obj == null ? COSNull.NULL : obj);        }        Integer lower = null;        Integer upper = null;        if (!keys.isEmpty()) {            lower = keys.get(0);            upper = keys.get(keys.size() - 1);        }        setUpperLimit(upper);        setLowerLimit(lower);        node.setItem(COSName.NUMS, array);    }}
public Integer pdfbox_f3579_0()
{    Integer retval = null;    COSArray arr = (COSArray) node.getDictionaryObject(COSName.LIMITS);    if (arr != null && arr.get(0) != null) {        retval = arr.getInt(1);    }    return retval;}
private void pdfbox_f3580_0(Integer upper)
{    COSArray arr = (COSArray) node.getDictionaryObject(COSName.LIMITS);    if (arr == null) {        arr = new COSArray();        arr.add(null);        arr.add(null);        node.setItem(COSName.LIMITS, arr);    }    if (upper != null) {        arr.setInt(1, upper);    } else {        arr.set(1, null);    }}
public Integer pdfbox_f3581_0()
{    Integer retval = null;    COSArray arr = (COSArray) node.getDictionaryObject(COSName.LIMITS);    if (arr != null && arr.get(0) != null) {        retval = arr.getInt(0);    }    return retval;}
private void pdfbox_f3582_0(Integer lower)
{    COSArray arr = (COSArray) node.getDictionaryObject(COSName.LIMITS);    if (arr == null) {        arr = new COSArray();        arr.add(null);        arr.add(null);        node.setItem(COSName.LIMITS, arr);    }    if (lower != null) {        arr.setInt(0, lower);    } else {        arr.set(0, null);    }}
public static PDObjectStream pdfbox_f3583_0(PDDocument document)
{    COSStream cosStream = document.getDocument().createCOSStream();    PDObjectStream strm = new PDObjectStream(cosStream);    strm.getCOSObject().setItem(COSName.TYPE, COSName.OBJ_STM);    return strm;}
public String pdfbox_f3584_0()
{    return getCOSObject().getNameAsString(COSName.TYPE);}
public int pdfbox_f3585_0()
{    return getCOSObject().getInt(COSName.N, 0);}
public void pdfbox_f3586_0(int n)
{    getCOSObject().setInt(COSName.N, n);}
public int pdfbox_f3587_0()
{    return getCOSObject().getInt(COSName.FIRST, 0);}
public void pdfbox_f3588_0(int n)
{    getCOSObject().setInt(COSName.FIRST, n);}
public PDObjectStream pdfbox_f3589_0()
{    PDObjectStream retval = null;    COSStream stream = (COSStream) getCOSObject().getDictionaryObject(COSName.EXTENDS);    if (stream != null) {        retval = new PDObjectStream(stream);    }    return retval;}
public void pdfbox_f3590_0(PDObjectStream stream)
{    getCOSObject().setItem(COSName.EXTENDS, stream);}
public COSDictionary pdfbox_f3591_0()
{    return root;}
public String pdfbox_f3592_0()
{    return root.getNameAsString(KEY_STYLE);}
public void pdfbox_f3593_0(String style)
{    if (style != null) {        root.setName(KEY_STYLE, style);    } else {        root.removeItem(KEY_STYLE);    }}
public int pdfbox_f3594_0()
{    return root.getInt(KEY_START, 1);}
public void pdfbox_f3595_0(int start)
{    if (start <= 0) {        throw new IllegalArgumentException("The page numbering start value must be a positive integer");    }    root.setInt(KEY_START, start);}
public String pdfbox_f3596_0()
{    return root.getString(KEY_PREFIX);}
public void pdfbox_f3597_0(String prefix)
{    if (prefix != null) {        root.setString(KEY_PREFIX, prefix);    } else {        root.removeItem(KEY_PREFIX);    }}
private void pdfbox_f3598_0(PDNumberTreeNode node) throws IOException
{    if (node.getKids() != null) {        List<PDNumberTreeNode> kids = node.getKids();        for (PDNumberTreeNode kid : kids) {            findLabels(kid);        }    } else if (node.getNumbers() != null) {        Map<Integer, COSObjectable> numbers = node.getNumbers();        for (Entry<Integer, COSObjectable> i : numbers.entrySet()) {            if (i.getKey() >= 0) {                labels.put(i.getKey(), (PDPageLabelRange) i.getValue());            }        }    }}
public int pdfbox_f3599_0()
{    return labels.size();}
public PDPageLabelRange pdfbox_f3600_0(int startPage)
{    return labels.get(startPage);}
public void pdfbox_f3601_0(int startPage, PDPageLabelRange item)
{    if (startPage < 0) {        throw new IllegalArgumentException("startPage parameter of setLabelItem may not be < 0");    }    labels.put(startPage, item);}
public COSBase pdfbox_f3602_0()
{    COSDictionary dict = new COSDictionary();    COSArray arr = new COSArray();    for (Entry<Integer, PDPageLabelRange> i : labels.entrySet()) {        arr.add(COSInteger.get(i.getKey()));        arr.add(i.getValue());    }    dict.setItem(COSName.NUMS, arr);    return dict;}
public Map<String, Integer> pdfbox_f3603_0()
{    final Map<String, Integer> labelMap = new HashMap<>(doc.getNumberOfPages());    computeLabels((pageIndex, label) -> labelMap.put(label, pageIndex));    return labelMap;}
public String[] pdfbox_f3604_0()
{    final String[] map = new String[doc.getNumberOfPages()];    computeLabels((pageIndex, label) -> {        if (pageIndex < doc.getNumberOfPages()) {            map[pageIndex] = label;        }    });    return map;}
public NavigableSet<Integer> pdfbox_f3605_0()
{    return new TreeSet<>(labels.keySet());}
private void pdfbox_f3606_0(LabelHandler handler)
{    Iterator<Entry<Integer, PDPageLabelRange>> iterator = labels.entrySet().iterator();    if (!iterator.hasNext()) {        return;    }    int pageIndex = 0;    Entry<Integer, PDPageLabelRange> lastEntry = iterator.next();    while (iterator.hasNext()) {        Entry<Integer, PDPageLabelRange> entry = iterator.next();        int numPages = entry.getKey() - lastEntry.getKey();        LabelGenerator gen = new LabelGenerator(lastEntry.getValue(), numPages);        while (gen.hasNext()) {            handler.newLabel(pageIndex, gen.next());            pageIndex++;        }        lastEntry = entry;    }    LabelGenerator gen = new LabelGenerator(lastEntry.getValue(), doc.getNumberOfPages() - lastEntry.getKey());    while (gen.hasNext()) {        handler.newLabel(pageIndex, gen.next());        pageIndex++;    }}
public boolean pdfbox_f3607_0()
{    return currentPage < numPages;}
public String pdfbox_f3608_0()
{    if (!hasNext()) {        throw new NoSuchElementException();    }    StringBuilder buf = new StringBuilder();    if (labelInfo.getPrefix() != null) {        String label = labelInfo.getPrefix();                while (label.lastIndexOf(0) != -1) {            label = label.substring(0, label.length() - 1);        }        buf.append(label);    }    if (labelInfo.getStyle() != null) {        buf.append(getNumber(labelInfo.getStart() + currentPage, labelInfo.getStyle()));    }    currentPage++;    return buf.toString();}
private String pdfbox_f3609_0(int pageIndex, String style)
{    if (style != null) {        switch(style) {            case PDPageLabelRange.STYLE_DECIMAL:                return Integer.toString(pageIndex);            case PDPageLabelRange.STYLE_LETTERS_LOWER:                return makeLetterLabel(pageIndex);            case PDPageLabelRange.STYLE_LETTERS_UPPER:                return makeLetterLabel(pageIndex).toUpperCase();            case PDPageLabelRange.STYLE_ROMAN_LOWER:                return makeRomanLabel(pageIndex);            case PDPageLabelRange.STYLE_ROMAN_UPPER:                return makeRomanLabel(pageIndex).toUpperCase();            default:                break;        }    }        return Integer.toString(pageIndex);}
private static String pdfbox_f3610_0(int pageIndex)
{    StringBuilder buf = new StringBuilder();    int power = 0;    while (power < 3 && pageIndex > 0) {        buf.insert(0, ROMANS[power][pageIndex % 10]);        pageIndex /= 10;        power++;    }        for (int i = 0; i < pageIndex; i++) {        buf.insert(0, 'm');    }    return buf.toString();}
private static String pdfbox_f3611_0(int num)
{    StringBuilder buf = new StringBuilder();    int numLetters = num / 26 + Integer.signum(num % 26);    int letter = num % 26 + 26 * (1 - Integer.signum(num % 26)) + 'a' - 1;    for (int i = 0; i < numLetters; i++) {        buf.appendCodePoint(letter);    }    return buf.toString();}
public void pdfbox_f3612_0()
{        throw new UnsupportedOperationException();}
public COSBase pdfbox_f3613_0()
{    return rangeArray;}
public COSArray pdfbox_f3614_0()
{    return rangeArray;}
public float pdfbox_f3615_0()
{    COSNumber min = (COSNumber) rangeArray.getObject(startingIndex * 2);    return min.floatValue();}
public void pdfbox_f3616_0(float min)
{    rangeArray.set(startingIndex * 2, new COSFloat(min));}
public float pdfbox_f3617_0()
{    COSNumber max = (COSNumber) rangeArray.getObject(startingIndex * 2 + 1);    return max.floatValue();}
public void pdfbox_f3618_0(float max)
{    rangeArray.set(startingIndex * 2 + 1, new COSFloat(max));}
public String pdfbox_f3619_0()
{    return "PDRange{" + getMin() + ", " + getMax() + '}';}
public boolean pdfbox_f3620_0(float x, float y)
{    float llx = getLowerLeftX();    float urx = getUpperRightX();    float lly = getLowerLeftY();    float ury = getUpperRightY();    return x >= llx && x <= urx && y >= lly && y <= ury;}
public PDRectangle pdfbox_f3621_0()
{    PDRectangle retval = new PDRectangle();    retval.setUpperRightX(getWidth());    retval.setUpperRightY(getHeight());    return retval;}
public COSArray pdfbox_f3622_0()
{    return rectArray;}
public float pdfbox_f3623_0()
{    return ((COSNumber) rectArray.get(0)).floatValue();}
public void pdfbox_f3624_0(float value)
{    rectArray.set(0, new COSFloat(value));}
public float pdfbox_f3625_0()
{    return ((COSNumber) rectArray.get(1)).floatValue();}
public void pdfbox_f3626_0(float value)
{    rectArray.set(1, new COSFloat(value));}
public float pdfbox_f3627_0()
{    return ((COSNumber) rectArray.get(2)).floatValue();}
public void pdfbox_f3628_0(float value)
{    rectArray.set(2, new COSFloat(value));}
public float pdfbox_f3629_0()
{    return ((COSNumber) rectArray.get(3)).floatValue();}
public void pdfbox_f3630_0(float value)
{    rectArray.set(3, new COSFloat(value));}
public float pdfbox_f3631_0()
{    return getUpperRightX() - getLowerLeftX();}
public float pdfbox_f3632_0()
{    return getUpperRightY() - getLowerLeftY();}
public GeneralPath pdfbox_f3633_0(Matrix matrix)
{    float x1 = getLowerLeftX();    float y1 = getLowerLeftY();    float x2 = getUpperRightX();    float y2 = getUpperRightY();    Point2D.Float p0 = matrix.transformPoint(x1, y1);    Point2D.Float p1 = matrix.transformPoint(x2, y1);    Point2D.Float p2 = matrix.transformPoint(x2, y2);    Point2D.Float p3 = matrix.transformPoint(x1, y2);    GeneralPath path = new GeneralPath();    path.moveTo(p0.getX(), p0.getY());    path.lineTo(p1.getX(), p1.getY());    path.lineTo(p2.getX(), p2.getY());    path.lineTo(p3.getX(), p3.getY());    path.closePath();    return path;}
public COSBase pdfbox_f3634_0()
{    return rectArray;}
public GeneralPath pdfbox_f3635_0()
{    float x1 = getLowerLeftX();    float y1 = getLowerLeftY();    float x2 = getUpperRightX();    float y2 = getUpperRightY();    GeneralPath path = new GeneralPath();    path.moveTo(x1, y1);    path.lineTo(x2, y1);    path.lineTo(x2, y2);    path.lineTo(x1, y2);    path.closePath();    return path;}
public String pdfbox_f3636_0()
{    return "[" + getLowerLeftX() + "," + getLowerLeftY() + "," + getUpperRightX() + "," + getUpperRightY() + "]";}
public void pdfbox_f3637_0()
{    List<COSName> filters = getFilters();    if (filters == null) {        if (stream.getLength() > 0) {            OutputStream out = null;            try {                byte[] bytes = IOUtils.toByteArray(stream.createInputStream());                out = stream.createOutputStream(COSName.FLATE_DECODE);                out.write(bytes);            } catch (IOException e) {                                throw new RuntimeException(e);            } finally {                IOUtils.closeQuietly(out);            }        } else {            filters = new ArrayList<>();            filters.add(COSName.FLATE_DECODE);            setFilters(filters);        }    }}
public COSStream pdfbox_f3638_0()
{    return stream;}
public OutputStream pdfbox_f3639_0() throws IOException
{    return stream.createOutputStream();}
public OutputStream pdfbox_f3640_0(COSName filter) throws IOException
{    return stream.createOutputStream(filter);}
public COSInputStream pdfbox_f3641_0() throws IOException
{    return stream.createInputStream();}
public COSInputStream pdfbox_f3642_0(DecodeOptions options) throws IOException
{    return stream.createInputStream(options);}
public InputStream pdfbox_f3643_0(List<String> stopFilters) throws IOException
{    InputStream is = stream.createRawInputStream();    ByteArrayOutputStream os = new ByteArrayOutputStream();    List<COSName> filters = getFilters();    if (filters != null) {        for (int i = 0; i < filters.size(); i++) {            COSName nextFilter = filters.get(i);            if ((stopFilters != null) && stopFilters.contains(nextFilter.getName())) {                break;            } else {                Filter filter = FilterFactory.INSTANCE.getFilter(nextFilter);                filter.decode(is, os, stream, i);                IOUtils.closeQuietly(is);                is = new ByteArrayInputStream(os.toByteArray());                os.reset();            }        }    }    return is;}
public int pdfbox_f3644_0()
{    return stream.getInt(COSName.LENGTH, 0);}
public List<COSName> pdfbox_f3645_0()
{    List<COSName> retval = null;    COSBase filters = stream.getFilters();    if (filters instanceof COSName) {        COSName name = (COSName) filters;        retval = new COSArrayList<>(name, name, stream, COSName.FILTER);    } else if (filters instanceof COSArray) {        retval = (List<COSName>) ((COSArray) filters).toList();    }    return retval;}
public void pdfbox_f3646_0(List<COSName> filters)
{    COSBase obj = COSArrayList.converterToCOSArray(filters);    stream.setItem(COSName.FILTER, obj);}
public List<Object> pdfbox_f3647_0() throws IOException
{    List<Object> retval = null;    COSBase dp = stream.getDictionaryObject(COSName.DECODE_PARMS);    if (dp == null) {                        dp = stream.getDictionaryObject(COSName.DP);    }    if (dp instanceof COSDictionary) {        Map<?, ?> map = COSDictionaryMap.convertBasicTypesToMap((COSDictionary) dp);        retval = new COSArrayList<Object>(map, dp, stream, COSName.DECODE_PARMS);    } else if (dp instanceof COSArray) {        COSArray array = (COSArray) dp;        List<Object> actuals = new ArrayList<>();        for (int i = 0; i < array.size(); i++) {            actuals.add(COSDictionaryMap.convertBasicTypesToMap((COSDictionary) array.getObject(i)));        }        retval = new COSArrayList<>(actuals, array);    }    return retval;}
public void pdfbox_f3648_0(List<?> decodeParams)
{    stream.setItem(COSName.DECODE_PARMS, COSArrayList.converterToCOSArray(decodeParams));}
public PDFileSpecification pdfbox_f3649_0() throws IOException
{    COSBase f = stream.getDictionaryObject(COSName.F);    return PDFileSpecification.createFS(f);}
public void pdfbox_f3650_0(PDFileSpecification f)
{    stream.setItem(COSName.F, f);}
public List<String> pdfbox_f3651_0()
{    List<String> retval = null;    COSBase filters = stream.getDictionaryObject(COSName.F_FILTER);    if (filters instanceof COSName) {        COSName name = (COSName) filters;        retval = new COSArrayList<>(name.getName(), name, stream, COSName.F_FILTER);    } else if (filters instanceof COSArray) {        retval = COSArrayList.convertCOSNameCOSArrayToList((COSArray) filters);    }    return retval;}
public void pdfbox_f3652_0(List<String> filters)
{    COSBase obj = COSArrayList.convertStringListToCOSNameCOSArray(filters);    stream.setItem(COSName.F_FILTER, obj);}
public List<Object> pdfbox_f3653_0() throws IOException
{    List<Object> retval = null;    COSBase dp = stream.getDictionaryObject(COSName.F_DECODE_PARMS);    if (dp instanceof COSDictionary) {        Map<?, ?> map = COSDictionaryMap.convertBasicTypesToMap((COSDictionary) dp);        retval = new COSArrayList<Object>(map, dp, stream, COSName.F_DECODE_PARMS);    } else if (dp instanceof COSArray) {        COSArray array = (COSArray) dp;        List<Object> actuals = new ArrayList<>();        for (int i = 0; i < array.size(); i++) {            actuals.add(COSDictionaryMap.convertBasicTypesToMap((COSDictionary) array.getObject(i)));        }        retval = new COSArrayList<>(actuals, array);    }    return retval;}
public void pdfbox_f3654_0(List<?> decodeParams)
{    stream.setItem("FDecodeParams", COSArrayList.converterToCOSArray(decodeParams));}
public byte[] pdfbox_f3655_0() throws IOException
{    ByteArrayOutputStream output = new ByteArrayOutputStream();    try (InputStream is = createInputStream()) {        IOUtils.copy(is, output);    }    return output.toByteArray();}
public PDMetadata pdfbox_f3656_0()
{    PDMetadata retval = null;    COSBase mdStream = stream.getDictionaryObject(COSName.METADATA);    if (mdStream != null) {        if (mdStream instanceof COSStream) {            retval = new PDMetadata((COSStream) mdStream);        } else if (mdStream instanceof COSNull) {                } else {            throw new IllegalStateException("Expected a COSStream but was a " + mdStream.getClass().getSimpleName());        }    }    return retval;}
public void pdfbox_f3657_0(PDMetadata meta)
{    stream.setItem(COSName.METADATA, meta);}
public int pdfbox_f3658_0()
{    return this.stream.getInt(COSName.DL);}
public void pdfbox_f3659_0(int decodedStreamLength)
{    this.stream.setInt(COSName.DL, decodedStreamLength);}
public String pdfbox_f3660_0()
{    return this.getCOSObject().getNameAsString(COSName.TYPE);}
public PDFont pdfbox_f3661_0(COSObject indirect) throws IOException
{    SoftReference<PDFont> font = fonts.get(indirect);    if (font != null) {        return font.get();    }    return null;}
public void pdfbox_f3662_0(COSObject indirect, PDFont font) throws IOException
{    fonts.put(indirect, new SoftReference<>(font));}
public PDColorSpace pdfbox_f3663_0(COSObject indirect) throws IOException
{    SoftReference<PDColorSpace> colorSpace = colorSpaces.get(indirect);    if (colorSpace != null) {        return colorSpace.get();    }    return null;}
public void pdfbox_f3664_0(COSObject indirect, PDColorSpace colorSpace) throws IOException
{    colorSpaces.put(indirect, new SoftReference<>(colorSpace));}
public PDExtendedGraphicsState pdfbox_f3665_0(COSObject indirect)
{    SoftReference<PDExtendedGraphicsState> extGState = extGStates.get(indirect);    if (extGState != null) {        return extGState.get();    }    return null;}
public void pdfbox_f3666_0(COSObject indirect, PDExtendedGraphicsState extGState)
{    extGStates.put(indirect, new SoftReference<>(extGState));}
public PDShading pdfbox_f3667_0(COSObject indirect) throws IOException
{    SoftReference<PDShading> shading = shadings.get(indirect);    if (shading != null) {        return shading.get();    }    return null;}
public void pdfbox_f3668_0(COSObject indirect, PDShading shading) throws IOException
{    shadings.put(indirect, new SoftReference<>(shading));}
public PDAbstractPattern pdfbox_f3669_0(COSObject indirect) throws IOException
{    SoftReference<PDAbstractPattern> pattern = patterns.get(indirect);    if (pattern != null) {        return pattern.get();    }    return null;}
public void pdfbox_f3670_0(COSObject indirect, PDAbstractPattern pattern) throws IOException
{    patterns.put(indirect, new SoftReference<>(pattern));}
public PDPropertyList pdfbox_f3671_0(COSObject indirect)
{    SoftReference<PDPropertyList> propertyList = properties.get(indirect);    if (propertyList != null) {        return propertyList.get();    }    return null;}
public void pdfbox_f3672_0(COSObject indirect, PDPropertyList propertyList)
{    properties.put(indirect, new SoftReference<>(propertyList));}
public PDXObject pdfbox_f3673_0(COSObject indirect) throws IOException
{    SoftReference<PDXObject> xobject = xobjects.get(indirect);    if (xobject != null) {        return xobject.get();    }    return null;}
public void pdfbox_f3674_0(COSObject indirect, PDXObject xobject) throws IOException
{    xobjects.put(indirect, new SoftReference<>(xobject));}
public static PDAttributeObject pdfbox_f3675_0(COSDictionary dictionary)
{    String owner = dictionary.getNameAsString(COSName.O);    if (owner != null) {        switch(owner) {            case PDUserAttributeObject.OWNER_USER_PROPERTIES:                return new PDUserAttributeObject(dictionary);            case PDListAttributeObject.OWNER_LIST:                return new PDListAttributeObject(dictionary);            case PDPrintFieldAttributeObject.OWNER_PRINT_FIELD:                return new PDPrintFieldAttributeObject(dictionary);            case PDTableAttributeObject.OWNER_TABLE:                return new PDTableAttributeObject(dictionary);            case PDLayoutAttributeObject.OWNER_LAYOUT:                return new PDLayoutAttributeObject(dictionary);            case PDExportFormatAttributeObject.OWNER_XML_1_00:            case PDExportFormatAttributeObject.OWNER_HTML_3_20:            case PDExportFormatAttributeObject.OWNER_HTML_4_01:            case PDExportFormatAttributeObject.OWNER_OEB_1_00:            case PDExportFormatAttributeObject.OWNER_RTF_1_05:            case PDExportFormatAttributeObject.OWNER_CSS_1_00:            case PDExportFormatAttributeObject.OWNER_CSS_2_00:                return new PDExportFormatAttributeObject(dictionary);            default:                break;        }    }    return new PDDefaultAttributeObject(dictionary);}
private PDStructureElement pdfbox_f3676_0()
{    return this.structureElement;}
protected void pdfbox_f3677_0(PDStructureElement structureElement)
{    this.structureElement = structureElement;}
public String pdfbox_f3678_0()
{    return this.getCOSObject().getNameAsString(COSName.O);}
protected void pdfbox_f3679_0(String owner)
{    this.getCOSObject().setName(COSName.O, owner);}
public boolean pdfbox_f3680_0()
{        return (this.getCOSObject().size() == 1) && (this.getOwner() != null);}
protected void pdfbox_f3681_0(COSBase oldBase, COSBase newBase)
{    if (this.isValueChanged(oldBase, newBase)) {        this.notifyChanged();    }}
private boolean pdfbox_f3682_0(COSBase oldValue, COSBase newValue)
{    if (oldValue == null) {        return newValue != null;    }    return !oldValue.equals(newValue);}
protected void pdfbox_f3683_0()
{    if (this.getStructureElement() != null) {        this.getStructureElement().attributeChanged(this);    }}
public String pdfbox_f3684_0()
{    return "O=" + this.getOwner();}
protected static String pdfbox_f3685_0(Object[] array)
{    StringBuilder sb = new StringBuilder("[");    for (int i = 0; i < array.length; i++) {        if (i > 0) {            sb.append(", ");        }        sb.append(array[i]);    }    return sb.append(']').toString();}
protected static String pdfbox_f3686_0(float[] array)
{    StringBuilder sb = new StringBuilder("[");    for (int i = 0; i < array.length; i++) {        if (i > 0) {            sb.append(", ");        }        sb.append(array[i]);    }    return sb.append(']').toString();}
public List<String> pdfbox_f3687_0()
{    List<String> attrNames = new ArrayList<>();    for (Entry<COSName, COSBase> entry : this.getCOSObject().entrySet()) {        COSName key = entry.getKey();        if (!COSName.O.equals(key)) {            attrNames.add(key.getName());        }    }    return attrNames;}
public COSBase pdfbox_f3688_0(String attrName)
{    return this.getCOSObject().getDictionaryObject(attrName);}
protected COSBase pdfbox_f3689_0(String attrName, COSBase defaultValue)
{    COSBase value = this.getCOSObject().getDictionaryObject(attrName);    if (value == null) {        return defaultValue;    }    return value;}
public void pdfbox_f3690_0(String attrName, COSBase attrValue)
{    COSBase old = this.getAttributeValue(attrName);    this.getCOSObject().setItem(COSName.getPDFName(attrName), attrValue);    this.potentiallyNotifyChanged(old, attrValue);}
public String pdfbox_f3691_0()
{    StringBuilder sb = new StringBuilder().append(super.toString()).append(", attributes={");    Iterator<String> it = this.getAttributeNames().iterator();    while (it.hasNext()) {        String name = it.next();        sb.append(name).append('=').append(this.getAttributeValue(name));        if (it.hasNext()) {            sb.append(", ");        }    }    return sb.append('}').toString();}
public COSDictionary pdfbox_f3692_0()
{    return this.dictionary;}
public PDPage pdfbox_f3693_0()
{    COSDictionary pg = (COSDictionary) this.getCOSObject().getDictionaryObject(COSName.PG);    if (pg != null) {        return new PDPage(pg);    }    return null;}
public void pdfbox_f3694_0(PDPage page)
{    this.getCOSObject().setItem(COSName.PG, page);}
public int pdfbox_f3695_0()
{    return this.getCOSObject().getInt(COSName.MCID);}
public void pdfbox_f3696_0(int mcid)
{    this.getCOSObject().setInt(COSName.MCID, mcid);}
public String pdfbox_f3697_0()
{    return "mcid=" + this.getMCID();}
public COSDictionary pdfbox_f3698_0()
{    return dictionary;}
public boolean pdfbox_f3699_0()
{    return dictionary.getBoolean("Marked", false);}
public void pdfbox_f3700_0(boolean value)
{    dictionary.setBoolean("Marked", value);}
public boolean pdfbox_f3701_0()
{    return dictionary.getBoolean("UserProperties", false);}
public void pdfbox_f3702_0(boolean userProps)
{    dictionary.setBoolean("UserProperties", userProps);}
public boolean pdfbox_f3703_0()
{    return dictionary.getBoolean("Suspects", false);}
public void pdfbox_f3704_0(boolean suspect)
{    dictionary.setBoolean("Suspects", false);}
public COSDictionary pdfbox_f3705_0()
{    return this.dictionary;}
public COSObjectable pdfbox_f3706_1()
{    COSBase obj = this.getCOSObject().getDictionaryObject(COSName.OBJ);    if (!(obj instanceof COSDictionary)) {        return null;    }    try {        if (obj instanceof COSStream) {                        PDXObject xobject = PDXObject.createXObject(obj, null);            if (xobject != null) {                return xobject;            }        }        COSDictionary objDictionary = (COSDictionary) obj;        PDAnnotation annotation = PDAnnotation.createAnnotation(obj);        /*             * COSName.TYPE is optional, so if annotation is of type unknown and             * COSName.TYPE is not COSName.ANNOT it still may be an annotation.             * TODO shall we return the annotation object instead of null?             * what else can be the target of the object reference?             */        if (!(annotation instanceof PDAnnotationUnknown) || COSName.ANNOT.equals(objDictionary.getDictionaryObject(COSName.TYPE))) {            return annotation;        }    } catch (IOException exception) {                }    return null;}
public void pdfbox_f3707_0(PDAnnotation annotation)
{    this.getCOSObject().setItem(COSName.OBJ, annotation);}
public void pdfbox_f3708_0(PDXObject xobject)
{    this.getCOSObject().setItem(COSName.OBJ, xobject);}
public COSBase pdfbox_f3709_0()
{    return obj.getCOSObject();}
public String pdfbox_f3710_0()
{    return obj.toString();}
public String pdfbox_f3711_0()
{    return this.getCOSObject().getNameAsString(COSName.S);}
public final void pdfbox_f3712_0(String structureType)
{    this.getCOSObject().setName(COSName.S, structureType);}
public PDStructureNode pdfbox_f3713_0()
{    COSBase base = this.getCOSObject().getDictionaryObject(COSName.P);    if (base instanceof COSDictionary) {        return PDStructureNode.create((COSDictionary) base);    }    return null;}
public final void pdfbox_f3714_0(PDStructureNode structureNode)
{    this.getCOSObject().setItem(COSName.P, structureNode);}
public String pdfbox_f3715_0()
{    return this.getCOSObject().getString(COSName.ID);}
public void pdfbox_f3716_0(String id)
{    this.getCOSObject().setString(COSName.ID, id);}
public PDPage pdfbox_f3717_0()
{    COSBase base = this.getCOSObject().getDictionaryObject(COSName.PG);    if (base instanceof COSDictionary) {        return new PDPage((COSDictionary) base);    }    return null;}
public void pdfbox_f3718_0(PDPage page)
{    this.getCOSObject().setItem(COSName.PG, page);}
public Revisions<PDAttributeObject> pdfbox_f3719_0()
{    Revisions<PDAttributeObject> attributes = new Revisions<>();    COSBase a = this.getCOSObject().getDictionaryObject(COSName.A);    if (a instanceof COSArray) {        COSArray aa = (COSArray) a;        Iterator<COSBase> it = aa.iterator();        PDAttributeObject ao = null;        while (it.hasNext()) {            COSBase item = it.next();            if (item instanceof COSObject) {                item = ((COSObject) item).getObject();            }            if (item instanceof COSDictionary) {                ao = PDAttributeObject.create((COSDictionary) item);                ao.setStructureElement(this);                attributes.addObject(ao, 0);            } else if (item instanceof COSInteger) {                attributes.setRevisionNumber(ao, ((COSNumber) item).intValue());            }        }    }    if (a instanceof COSDictionary) {        PDAttributeObject ao = PDAttributeObject.create((COSDictionary) a);        ao.setStructureElement(this);        attributes.addObject(ao, 0);    }    return attributes;}
public void pdfbox_f3720_0(Revisions<PDAttributeObject> attributes)
{    COSName key = COSName.A;    if ((attributes.size() == 1) && (attributes.getRevisionNumber(0) == 0)) {        PDAttributeObject attributeObject = attributes.getObject(0);        attributeObject.setStructureElement(this);        this.getCOSObject().setItem(key, attributeObject);        return;    }    COSArray array = new COSArray();    for (int i = 0; i < attributes.size(); i++) {        PDAttributeObject attributeObject = attributes.getObject(i);        attributeObject.setStructureElement(this);        int revisionNumber = attributes.getRevisionNumber(i);        if (revisionNumber < 0) {            throw new IllegalArgumentException("The revision number shall be > -1");        }        array.add(attributeObject);        array.add(COSInteger.get(revisionNumber));    }    this.getCOSObject().setItem(key, array);}
public void pdfbox_f3721_0(PDAttributeObject attributeObject)
{    COSName key = COSName.A;    attributeObject.setStructureElement(this);    COSBase a = this.getCOSObject().getDictionaryObject(key);    COSArray array;    if (a instanceof COSArray) {        array = (COSArray) a;    } else {        array = new COSArray();        if (a != null) {            array.add(a);            array.add(COSInteger.get(0));        }    }    this.getCOSObject().setItem(key, array);    array.add(attributeObject);    array.add(COSInteger.get(this.getRevisionNumber()));}
public void pdfbox_f3722_0(PDAttributeObject attributeObject)
{    COSName key = COSName.A;    COSBase a = this.getCOSObject().getDictionaryObject(key);    if (a instanceof COSArray) {        COSArray array = (COSArray) a;        array.remove(attributeObject.getCOSObject());        if ((array.size() == 2) && (array.getInt(1) == 0)) {            this.getCOSObject().setItem(key, array.getObject(0));        }    } else {        COSBase directA = a;        if (a instanceof COSObject) {            directA = ((COSObject) a).getObject();        }        if (attributeObject.getCOSObject().equals(directA)) {            this.getCOSObject().setItem(key, null);        }    }    attributeObject.setStructureElement(null);}
public void pdfbox_f3723_0(PDAttributeObject attributeObject)
{    COSName key = COSName.A;    COSBase a = this.getCOSObject().getDictionaryObject(key);    if (a instanceof COSArray) {        COSArray array = (COSArray) a;        for (int i = 0; i < array.size(); i++) {            COSBase entry = array.getObject(i);            if (entry.equals(attributeObject.getCOSObject())) {                COSBase next = array.get(i + 1);                if (next instanceof COSInteger) {                    array.set(i + 1, COSInteger.get(this.getRevisionNumber()));                }            }        }    } else {        COSArray array = new COSArray();        array.add(a);        array.add(COSInteger.get(this.getRevisionNumber()));        this.getCOSObject().setItem(key, array);    }}
public Revisions<String> pdfbox_f3724_0()
{    COSName key = COSName.C;    Revisions<String> classNames = new Revisions<>();    COSBase c = this.getCOSObject().getDictionaryObject(key);    if (c instanceof COSName) {        classNames.addObject(((COSName) c).getName(), 0);    }    if (c instanceof COSArray) {        COSArray array = (COSArray) c;        Iterator<COSBase> it = array.iterator();        String className = null;        while (it.hasNext()) {            COSBase item = it.next();            if (item instanceof COSObject) {                item = ((COSObject) item).getObject();            }            if (item instanceof COSName) {                className = ((COSName) item).getName();                classNames.addObject(className, 0);            } else if (item instanceof COSInteger) {                classNames.setRevisionNumber(className, ((COSNumber) item).intValue());            }        }    }    return classNames;}
public void pdfbox_f3725_0(Revisions<String> classNames)
{    if (classNames == null) {        return;    }    COSName key = COSName.C;    if ((classNames.size() == 1) && (classNames.getRevisionNumber(0) == 0)) {        String className = classNames.getObject(0);        this.getCOSObject().setName(key, className);        return;    }    COSArray array = new COSArray();    for (int i = 0; i < classNames.size(); i++) {        String className = classNames.getObject(i);        int revisionNumber = classNames.getRevisionNumber(i);        if (revisionNumber < 0) {            throw new IllegalArgumentException("The revision number shall be > -1");        }        array.add(COSName.getPDFName(className));        array.add(COSInteger.get(revisionNumber));    }    this.getCOSObject().setItem(key, array);}
public void pdfbox_f3726_0(String className)
{    if (className == null) {        return;    }    COSName key = COSName.C;    COSBase c = this.getCOSObject().getDictionaryObject(key);    COSArray array;    if (c instanceof COSArray) {        array = (COSArray) c;    } else {        array = new COSArray();        if (c != null) {            array.add(c);            array.add(COSInteger.get(0));        }    }    this.getCOSObject().setItem(key, array);    array.add(COSName.getPDFName(className));    array.add(COSInteger.get(this.getRevisionNumber()));}
public void pdfbox_f3727_0(String className)
{    if (className == null) {        return;    }    COSName key = COSName.C;    COSBase c = this.getCOSObject().getDictionaryObject(key);    COSName name = COSName.getPDFName(className);    if (c instanceof COSArray) {        COSArray array = (COSArray) c;        array.remove(name);        if ((array.size() == 2) && (array.getInt(1) == 0)) {            this.getCOSObject().setItem(key, array.getObject(0));        }    } else {        COSBase directC = c;        if (c instanceof COSObject) {            directC = ((COSObject) c).getObject();        }        if (name.equals(directC)) {            this.getCOSObject().setItem(key, null);        }    }}
public int pdfbox_f3728_0()
{    return this.getCOSObject().getInt(COSName.R, 0);}
public void pdfbox_f3729_0(int revisionNumber)
{    if (revisionNumber < 0) {        throw new IllegalArgumentException("The revision number shall be > -1");    }    this.getCOSObject().setInt(COSName.R, revisionNumber);}
public void pdfbox_f3730_0()
{    this.setRevisionNumber(this.getRevisionNumber() + 1);}
public String pdfbox_f3731_0()
{    return this.getCOSObject().getString(COSName.T);}
public void pdfbox_f3732_0(String title)
{    this.getCOSObject().setString(COSName.T, title);}
public String pdfbox_f3733_0()
{    return this.getCOSObject().getString(COSName.LANG);}
public void pdfbox_f3734_0(String language)
{    this.getCOSObject().setString(COSName.LANG, language);}
public String pdfbox_f3735_0()
{    return this.getCOSObject().getString(COSName.ALT);}
public void pdfbox_f3736_0(String alternateDescription)
{    this.getCOSObject().setString(COSName.ALT, alternateDescription);}
public String pdfbox_f3737_0()
{    return this.getCOSObject().getString(COSName.E);}
public void pdfbox_f3738_0(String expandedForm)
{    this.getCOSObject().setString(COSName.E, expandedForm);}
public String pdfbox_f3739_0()
{    return this.getCOSObject().getString(COSName.ACTUAL_TEXT);}
public void pdfbox_f3740_0(String actualText)
{    this.getCOSObject().setString(COSName.ACTUAL_TEXT, actualText);}
public String pdfbox_f3741_0()
{    String type = this.getStructureType();    Map<String, Object> roleMap = getRoleMap();    if (roleMap.containsKey(type)) {        Object mappedValue = getRoleMap().get(type);        if (mappedValue instanceof String) {            type = (String) mappedValue;        }    }    return type;}
public void pdfbox_f3742_0(PDMarkedContent markedContent)
{    if (markedContent == null) {        return;    }    this.appendKid(COSInteger.get(markedContent.getMCID()));}
public void pdfbox_f3743_0(PDMarkedContentReference markedContentReference)
{    this.appendObjectableKid(markedContentReference);}
public void pdfbox_f3744_0(PDObjectReference objectReference)
{    this.appendObjectableKid(objectReference);}
public void pdfbox_f3745_0(COSInteger markedContentIdentifier, Object refKid)
{    this.insertBefore((COSBase) markedContentIdentifier, refKid);}
public void pdfbox_f3746_0(PDMarkedContentReference markedContentReference, Object refKid)
{    this.insertObjectableBefore(markedContentReference, refKid);}
public void pdfbox_f3747_0(PDObjectReference objectReference, Object refKid)
{    this.insertObjectableBefore(objectReference, refKid);}
public void pdfbox_f3748_0(COSInteger markedContentIdentifier)
{    this.removeKid((COSBase) markedContentIdentifier);}
public void pdfbox_f3749_0(PDMarkedContentReference markedContentReference)
{    this.removeObjectableKid(markedContentReference);}
public void pdfbox_f3750_0(PDObjectReference objectReference)
{    this.removeObjectableKid(objectReference);}
private PDStructureTreeRoot pdfbox_f3751_0()
{    PDStructureNode parent = this.getParent();    while (parent instanceof PDStructureElement) {        parent = ((PDStructureElement) parent).getParent();    }    if (parent instanceof PDStructureTreeRoot) {        return (PDStructureTreeRoot) parent;    }    return null;}
private Map<String, Object> pdfbox_f3752_0()
{    PDStructureTreeRoot root = this.getStructureTreeRoot();    if (root != null) {        return root.getRoleMap();    }    return Collections.emptyMap();}
public static PDStructureNode pdfbox_f3753_0(COSDictionary node)
{    String type = node.getNameAsString(COSName.TYPE);    if ("StructTreeRoot".equals(type)) {        return new PDStructureTreeRoot(node);    }    if (type == null || "StructElem".equals(type)) {        return new PDStructureElement(node);    }    throw new IllegalArgumentException("Dictionary must not include a Type entry with a value that is neither StructTreeRoot nor StructElem.");}
public COSDictionary pdfbox_f3754_0()
{    return dictionary;}
public String pdfbox_f3755_0()
{    return this.getCOSObject().getNameAsString(COSName.TYPE);}
public List<Object> pdfbox_f3756_0()
{    List<Object> kidObjects = new ArrayList<>();    COSBase k = this.getCOSObject().getDictionaryObject(COSName.K);    if (k instanceof COSArray) {        for (COSBase kid : (COSArray) k) {            Object kidObject = this.createObject(kid);            if (kidObject != null) {                kidObjects.add(kidObject);            }        }    } else {        Object kidObject = this.createObject(k);        if (kidObject != null) {            kidObjects.add(kidObject);        }    }    return kidObjects;}
public void pdfbox_f3757_0(List<Object> kids)
{    this.getCOSObject().setItem(COSName.K, COSArrayList.converterToCOSArray(kids));}
public void pdfbox_f3758_0(PDStructureElement structureElement)
{    this.appendObjectableKid(structureElement);    structureElement.setParent(this);}
protected void pdfbox_f3759_0(COSObjectable objectable)
{    if (objectable == null) {        return;    }    this.appendKid(objectable.getCOSObject());}
protected void pdfbox_f3760_0(COSBase object)
{    if (object == null) {        return;    }    COSBase k = this.getCOSObject().getDictionaryObject(COSName.K);    if (k == null) {                this.getCOSObject().setItem(COSName.K, object);    } else if (k instanceof COSArray) {                COSArray array = (COSArray) k;        array.add(object);    } else {                COSArray array = new COSArray();        array.add(k);        array.add(object);        this.getCOSObject().setItem(COSName.K, array);    }}
public void pdfbox_f3761_0(PDStructureElement newKid, Object refKid)
{    this.insertObjectableBefore(newKid, refKid);}
protected void pdfbox_f3762_0(COSObjectable newKid, Object refKid)
{    if (newKid == null) {        return;    }    this.insertBefore(newKid.getCOSObject(), refKid);}
protected void pdfbox_f3763_0(COSBase newKid, Object refKid)
{    if (newKid == null || refKid == null) {        return;    }    COSBase k = this.getCOSObject().getDictionaryObject(COSName.K);    if (k == null) {        return;    }    COSBase refKidBase = null;    if (refKid instanceof COSObjectable) {        refKidBase = ((COSObjectable) refKid).getCOSObject();    } else if (refKid instanceof COSInteger) {        refKidBase = (COSBase) refKid;    }    if (k instanceof COSArray) {        COSArray array = (COSArray) k;        int refIndex = array.indexOfObject(refKidBase);        array.add(refIndex, newKid.getCOSObject());    } else {        boolean onlyKid = k.equals(refKidBase);        if (!onlyKid && (k instanceof COSObject)) {            COSBase kObj = ((COSObject) k).getObject();            onlyKid = kObj.equals(refKidBase);        }        if (onlyKid) {            COSArray array = new COSArray();            array.add(newKid);            array.add(refKidBase);            this.getCOSObject().setItem(COSName.K, array);        }    }}
public boolean pdfbox_f3764_0(PDStructureElement structureElement)
{    boolean removed = this.removeObjectableKid(structureElement);    if (removed) {        structureElement.setParent(null);    }    return removed;}
protected boolean pdfbox_f3765_0(COSObjectable objectable)
{    if (objectable == null) {        return false;    }    return this.removeKid(objectable.getCOSObject());}
protected boolean pdfbox_f3766_0(COSBase object)
{    if (object == null) {        return false;    }    COSBase k = this.getCOSObject().getDictionaryObject(COSName.K);    if (k == null) {                return false;    } else if (k instanceof COSArray) {                COSArray array = (COSArray) k;        boolean removed = array.removeObject(object);                if (array.size() == 1) {            this.getCOSObject().setItem(COSName.K, array.getObject(0));        }        return removed;    } else {                boolean onlyKid = k.equals(object);        if (!onlyKid && (k instanceof COSObject)) {            COSBase kObj = ((COSObject) k).getObject();            onlyKid = kObj.equals(object);        }        if (onlyKid) {            this.getCOSObject().setItem(COSName.K, null);            return true;        }        return false;    }}
protected Object pdfbox_f3767_0(COSBase kid)
{    COSDictionary kidDic = null;    if (kid instanceof COSDictionary) {        kidDic = (COSDictionary) kid;    } else if (kid instanceof COSObject) {        COSBase base = ((COSObject) kid).getObject();        if (base instanceof COSDictionary) {            kidDic = (COSDictionary) base;        }    }    if (kidDic != null) {        return createObjectFromDic(kidDic);    } else if (kid instanceof COSInteger) {                COSInteger mcid = (COSInteger) kid;        return mcid.intValue();    }    return null;}
private COSObjectable pdfbox_f3768_0(COSDictionary kidDic)
{    String type = kidDic.getNameAsString(COSName.TYPE);    if (type == null) {                return new PDStructureElement(kidDic);    }    switch(type) {        case PDStructureElement.TYPE:                        return new PDStructureElement(kidDic);        case PDObjectReference.TYPE:                        return new PDObjectReference(kidDic);        case PDMarkedContentReference.TYPE:                        return new PDMarkedContentReference(kidDic);        default:            return null;    }}
public COSBase pdfbox_f3769_0()
{    return this.getCOSObject().getDictionaryObject(COSName.K);}
public void pdfbox_f3770_0(COSBase k)
{    this.getCOSObject().setItem(COSName.K, k);}
public PDNameTreeNode<PDStructureElement> pdfbox_f3771_0()
{    COSBase base = this.getCOSObject().getDictionaryObject(COSName.ID_TREE);    if (base instanceof COSDictionary) {        return new PDStructureElementNameTreeNode((COSDictionary) base);    }    return null;}
public void pdfbox_f3772_0(PDNameTreeNode<PDStructureElement> idTree)
{    this.getCOSObject().setItem(COSName.ID_TREE, idTree);}
public PDNumberTreeNode pdfbox_f3773_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.PARENT_TREE);    if (base instanceof COSDictionary) {        return new PDNumberTreeNode((COSDictionary) base, PDParentTreeValue.class);    }    return null;}
public void pdfbox_f3774_0(PDNumberTreeNode parentTree)
{    this.getCOSObject().setItem(COSName.PARENT_TREE, parentTree);}
public int pdfbox_f3775_0()
{    return this.getCOSObject().getInt(COSName.PARENT_TREE_NEXT_KEY);}
public void pdfbox_f3776_0(int parentTreeNextkey)
{    this.getCOSObject().setInt(COSName.PARENT_TREE_NEXT_KEY, parentTreeNextkey);}
public Map<String, Object> pdfbox_f3777_1()
{    COSBase rm = this.getCOSObject().getDictionaryObject(COSName.ROLE_MAP);    if (rm instanceof COSDictionary) {        try {            return COSDictionaryMap.convertBasicTypesToMap((COSDictionary) rm);        } catch (IOException e) {                    }    }    return new HashMap<>();}
public void pdfbox_f3778_0(Map<String, String> roleMap)
{    COSDictionary rmDic = new COSDictionary();    for (Map.Entry<String, String> entry : roleMap.entrySet()) {        rmDic.setName(entry.getKey(), entry.getValue());    }    this.getCOSObject().setItem(COSName.ROLE_MAP, rmDic);}
public List<PDUserProperty> pdfbox_f3779_0()
{    COSArray p = (COSArray) this.getCOSObject().getDictionaryObject(COSName.P);    List<PDUserProperty> properties = new ArrayList<>(p.size());    for (int i = 0; i < p.size(); i++) {        properties.add(new PDUserProperty((COSDictionary) p.getObject(i), this));    }    return properties;}
public void pdfbox_f3780_0(List<PDUserProperty> userProperties)
{    COSArray p = new COSArray();    for (PDUserProperty userProperty : userProperties) {        p.add(userProperty);    }    this.getCOSObject().setItem(COSName.P, p);}
public void pdfbox_f3781_0(PDUserProperty userProperty)
{    COSArray p = (COSArray) this.getCOSObject().getDictionaryObject(COSName.P);    p.add(userProperty);    this.notifyChanged();}
public void pdfbox_f3782_0(PDUserProperty userProperty)
{    if (userProperty == null) {        return;    }    COSArray p = (COSArray) this.getCOSObject().getDictionaryObject(COSName.P);    p.remove(userProperty.getCOSObject());    this.notifyChanged();}
public String pdfbox_f3784_0()
{    return super.toString() + ", userProperties=" + this.getOwnerUserProperties();}
public String pdfbox_f3785_0()
{    return this.getCOSObject().getNameAsString(COSName.N);}
public void pdfbox_f3786_0(String name)
{    this.potentiallyNotifyChanged(this.getName(), name);    this.getCOSObject().setName(COSName.N, name);}
public COSBase pdfbox_f3787_0()
{    return this.getCOSObject().getDictionaryObject(COSName.V);}
public void pdfbox_f3788_0(COSBase value)
{    this.potentiallyNotifyChanged(this.getValue(), value);    this.getCOSObject().setItem(COSName.V, value);}
public String pdfbox_f3789_0()
{    return this.getCOSObject().getString(COSName.F);}
public void pdfbox_f3790_0(String formattedValue)
{    this.potentiallyNotifyChanged(this.getFormattedValue(), formattedValue);    this.getCOSObject().setString(COSName.F, formattedValue);}
public boolean pdfbox_f3791_0()
{    return this.getCOSObject().getBoolean(COSName.H, false);}
public void pdfbox_f3792_0(boolean hidden)
{    this.potentiallyNotifyChanged(this.isHidden(), hidden);    this.getCOSObject().setBoolean(COSName.H, hidden);}
public String pdfbox_f3793_0()
{    return "Name=" + this.getName() + ", Value=" + this.getValue() + ", FormattedValue=" + this.getFormattedValue() + ", Hidden=" + this.isHidden();}
private void pdfbox_f3794_0(Object oldEntry, Object newEntry)
{    if (this.isEntryChanged(oldEntry, newEntry)) {        this.userAttributeObject.userPropertyChanged(this);    }}
private boolean pdfbox_f3795_0(Object oldEntry, Object newEntry)
{    if (oldEntry == null) {        return newEntry != null;    }    return !oldEntry.equals(newEntry);}
public int pdfbox_f3796_0()
{    final int prime = 31;    int result = super.hashCode();    result = prime * result + ((userAttributeObject == null) ? 0 : userAttributeObject.hashCode());    return result;}
public boolean pdfbox_f3797_0(Object obj)
{    if (this == obj) {        return true;    }    if (!super.equals(obj)) {        return false;    }    if (getClass() != obj.getClass()) {        return false;    }    PDUserProperty other = (PDUserProperty) obj;    if (userAttributeObject == null) {        if (other.userAttributeObject != null) {            return false;        }    } else if (!userAttributeObject.equals(other.userAttributeObject)) {        return false;    }    return true;}
private List<T> pdfbox_f3798_0()
{    if (this.objects == null) {        this.objects = new ArrayList<>();    }    return this.objects;}
private List<Integer> pdfbox_f3799_0()
{    if (this.revisionNumbers == null) {        this.revisionNumbers = new ArrayList<>();    }    return this.revisionNumbers;}
public T pdfbox_f3800_0(int index)
{    return this.getObjects().get(index);}
public int pdfbox_f3801_0(int index)
{    return this.getRevisionNumbers().get(index);}
public void pdfbox_f3802_0(T object, int revisionNumber)
{    this.getObjects().add(object);    this.getRevisionNumbers().add(revisionNumber);}
protected void pdfbox_f3803_0(T object, int revisionNumber)
{    int index = this.getObjects().indexOf(object);    if (index > -1) {        this.getRevisionNumbers().set(index, revisionNumber);    }}
public int pdfbox_f3804_0()
{    return this.getObjects().size();}
public String pdfbox_f3805_0()
{    StringBuilder sb = new StringBuilder();    for (int i = 0; i < this.getObjects().size(); i++) {        if (i > 0) {            sb.append("; ");        }        sb.append("object=").append(this.getObjects().get(i)).append(", revisionNumber=").append(this.getRevisionNumber(i));    }    return sb.toString();}
public static PDMarkedContent pdfbox_f3806_0(COSName tag, COSDictionary properties)
{    if (COSName.ARTIFACT.equals(tag)) {        return new PDArtifactMarkedContent(properties);    }    return new PDMarkedContent(tag, properties);}
public String pdfbox_f3807_0()
{    return this.tag;}
public COSDictionary pdfbox_f3808_0()
{    return this.properties;}
public int pdfbox_f3809_0()
{    return this.getProperties() == null ? -1 : this.getProperties().getInt(COSName.MCID);}
public String pdfbox_f3810_0()
{    return this.getProperties() == null ? null : this.getProperties().getNameAsString(COSName.LANG);}
public String pdfbox_f3811_0()
{    return this.getProperties() == null ? null : this.getProperties().getString(COSName.ACTUAL_TEXT);}
public String pdfbox_f3812_0()
{    return this.getProperties() == null ? null : this.getProperties().getString(COSName.ALT);}
public String pdfbox_f3813_0()
{    return this.getProperties() == null ? null : this.getProperties().getString(COSName.E);}
public List<Object> pdfbox_f3814_0()
{    return this.contents;}
public void pdfbox_f3815_0(TextPosition text)
{    this.getContents().add(text);}
public void pdfbox_f3816_0(PDMarkedContent markedContent)
{    this.getContents().add(markedContent);}
public void pdfbox_f3817_0(PDXObject xobject)
{    this.getContents().add(xobject);}
public String pdfbox_f3818_0()
{    return "tag=" + this.tag + ", properties=" + this.properties + ", contents=" + this.contents;}
public static PDPropertyList pdfbox_f3819_0(COSDictionary dict)
{    if (COSName.OCG.equals(dict.getItem(COSName.TYPE))) {        return new PDOptionalContentGroup(dict);    } else if (COSName.OCMD.equals(dict.getItem(COSName.TYPE))) {        return new PDOptionalContentMembershipDictionary(dict);    } else {                return new PDPropertyList(dict);    }}
public COSDictionary pdfbox_f3820_0()
{    return dict;}
public COSDictionary pdfbox_f3821_0()
{    return dictionary;}
public PDColor pdfbox_f3822_0()
{    COSArray colorValues = (COSArray) dictionary.getDictionaryObject(COSName.C);    if (colorValues == null) {        colorValues = new COSArray();        colorValues.add(COSInteger.ZERO);        colorValues.add(COSInteger.ZERO);        colorValues.add(COSInteger.ZERO);        dictionary.setItem(COSName.C, colorValues);    }    return new PDColor(colorValues.toFloatArray(), PDDeviceRGB.INSTANCE);}
public void pdfbox_f3823_0(PDColor color)
{    COSArray values = null;    if (color != null) {        values = color.toCOSArray();    }    dictionary.setItem(COSName.C, values);}
public float pdfbox_f3824_0()
{    return dictionary.getFloat(COSName.W, 1);}
public void pdfbox_f3825_0(float width)
{    dictionary.setFloat(COSName.W, width);}
public String pdfbox_f3826_0()
{    return dictionary.getNameAsString(COSName.S, GUIDELINE_STYLE_SOLID);}
public void pdfbox_f3827_0(String style)
{    dictionary.setName(COSName.S, style);}
public PDLineDashPattern pdfbox_f3828_0()
{    PDLineDashPattern pattern;    COSArray d = (COSArray) dictionary.getDictionaryObject(COSName.D);    if (d == null) {        d = new COSArray();        d.add(COSInteger.THREE);        dictionary.setItem(COSName.D, d);    }    COSArray lineArray = new COSArray();    lineArray.add(d);        pattern = new PDLineDashPattern(lineArray, 0);    return pattern;}
public void pdfbox_f3829_0(COSArray dashArray)
{    COSArray array = null;    if (dashArray != null) {        array = dashArray;    }    dictionary.setItem(COSName.D, array);}
public String pdfbox_f3830_0()
{    return this.getProperties().getNameAsString(COSName.TYPE);}
public PDRectangle pdfbox_f3831_0()
{    PDRectangle retval = null;    COSArray a = (COSArray) this.getProperties().getDictionaryObject(COSName.BBOX);    if (a != null) {        retval = new PDRectangle(a);    }    return retval;}
public boolean pdfbox_f3832_0()
{    return this.isAttached("Top");}
public boolean pdfbox_f3833_0()
{    return this.isAttached("Bottom");}
public boolean pdfbox_f3834_0()
{    return this.isAttached("Left");}
public boolean pdfbox_f3835_0()
{    return this.isAttached("Right");}
public String pdfbox_f3836_0()
{    return this.getProperties().getNameAsString(COSName.SUBTYPE);}
private boolean pdfbox_f3837_0(String edge)
{    COSArray a = (COSArray) this.getProperties().getDictionaryObject(COSName.ATTACHED);    if (a != null) {        for (int i = 0; i < a.size(); i++) {            if (edge.equals(a.getName(i))) {                return true;            }        }    }    return false;}
public String pdfbox_f3838_0()
{    return this.getName(PDListAttributeObject.LIST_NUMBERING, PDListAttributeObject.LIST_NUMBERING_NONE);}
public void pdfbox_f3839_0(String listNumbering)
{    this.setName(PDListAttributeObject.LIST_NUMBERING, listNumbering);}
public int pdfbox_f3840_0()
{    return this.getInteger(PDTableAttributeObject.ROW_SPAN, 1);}
public void pdfbox_f3841_0(int rowSpan)
{    this.setInteger(PDTableAttributeObject.ROW_SPAN, rowSpan);}
public int pdfbox_f3842_0()
{    return this.getInteger(PDTableAttributeObject.COL_SPAN, 1);}
public void pdfbox_f3843_0(int colSpan)
{    this.setInteger(PDTableAttributeObject.COL_SPAN, colSpan);}
public String[] pdfbox_f3844_0()
{    return this.getArrayOfString(PDTableAttributeObject.HEADERS);}
public void pdfbox_f3845_0(String[] headers)
{    this.setArrayOfString(PDTableAttributeObject.HEADERS, headers);}
public String pdfbox_f3846_0()
{    return this.getName(PDTableAttributeObject.SCOPE);}
public void pdfbox_f3847_0(String scope)
{    this.setName(PDTableAttributeObject.SCOPE, scope);}
public String pdfbox_f3848_0()
{    return this.getString(PDTableAttributeObject.SUMMARY);}
public void pdfbox_f3849_0(String summary)
{    this.setString(PDTableAttributeObject.SUMMARY, summary);}
public String pdfbox_f3850_0()
{    StringBuilder sb = new StringBuilder().append(super.toString());    if (this.isSpecified(PDListAttributeObject.LIST_NUMBERING)) {        sb.append(", ListNumbering=").append(this.getListNumbering());    }    if (this.isSpecified(PDTableAttributeObject.ROW_SPAN)) {        sb.append(", RowSpan=").append(String.valueOf(this.getRowSpan()));    }    if (this.isSpecified(PDTableAttributeObject.COL_SPAN)) {        sb.append(", ColSpan=").append(String.valueOf(this.getColSpan()));    }    if (this.isSpecified(PDTableAttributeObject.HEADERS)) {        sb.append(", Headers=").append(arrayToString(this.getHeaders()));    }    if (this.isSpecified(PDTableAttributeObject.SCOPE)) {        sb.append(", Scope=").append(this.getScope());    }    if (this.isSpecified(PDTableAttributeObject.SUMMARY)) {        sb.append(", Summary=").append(this.getSummary());    }    return sb.toString();}
public PDGamma pdfbox_f3851_0()
{    return this.getColourByIndex(0);}
public void pdfbox_f3852_0(PDGamma colour)
{    this.setColourByIndex(0, colour);}
public PDGamma pdfbox_f3853_0()
{    return this.getColourByIndex(1);}
public void pdfbox_f3854_0(PDGamma colour)
{    this.setColourByIndex(1, colour);}
public PDGamma pdfbox_f3855_0()
{    return this.getColourByIndex(2);}
public void pdfbox_f3856_0(PDGamma colour)
{    this.setColourByIndex(2, colour);}
public PDGamma pdfbox_f3857_0()
{    return this.getColourByIndex(3);}
public void pdfbox_f3858_0(PDGamma colour)
{    this.setColourByIndex(3, colour);}
public COSBase pdfbox_f3859_0()
{    return this.array;}
private PDGamma pdfbox_f3860_0(int index)
{    PDGamma retval = null;    COSBase item = this.array.getObject(index);    if (item instanceof COSArray) {        retval = new PDGamma((COSArray) item);    }    return retval;}
private void pdfbox_f3861_0(int index, PDGamma colour)
{    COSBase base;    if (colour == null) {        base = COSNull.NULL;    } else {        base = colour.getCOSArray();    }    this.array.set(index, base);}
public String pdfbox_f3862_0()
{    return this.getName(PLACEMENT, PLACEMENT_INLINE);}
public void pdfbox_f3863_0(String placement)
{    this.setName(PLACEMENT, placement);}
public String pdfbox_f3864_0()
{    return this.getName(WRITING_MODE, WRITING_MODE_LRTB);}
public void pdfbox_f3865_0(String writingMode)
{    this.setName(WRITING_MODE, writingMode);}
public PDGamma pdfbox_f3866_0()
{    return this.getColor(BACKGROUND_COLOR);}
public void pdfbox_f3867_0(PDGamma backgroundColor)
{    this.setColor(BACKGROUND_COLOR, backgroundColor);}
public Object pdfbox_f3868_0()
{    return this.getColorOrFourColors(BORDER_COLOR);}
public void pdfbox_f3869_0(PDGamma borderColor)
{    this.setColor(BORDER_COLOR, borderColor);}
public void pdfbox_f3870_0(PDFourColours borderColors)
{    this.setFourColors(BORDER_COLOR, borderColors);}
public Object pdfbox_f3871_0()
{    return this.getNameOrArrayOfName(BORDER_STYLE, BORDER_STYLE_NONE);}
public void pdfbox_f3872_0(String borderStyle)
{    this.setName(BORDER_STYLE, borderStyle);}
public void pdfbox_f3873_0(String[] borderStyles)
{    this.setArrayOfName(BORDER_STYLE, borderStyles);}
public Object pdfbox_f3874_0()
{    return this.getNumberOrArrayOfNumber(BORDER_THICKNESS, UNSPECIFIED);}
public void pdfbox_f3875_0(float borderThickness)
{    this.setNumber(BORDER_THICKNESS, borderThickness);}
public void pdfbox_f3876_0(int borderThickness)
{    this.setNumber(BORDER_THICKNESS, borderThickness);}
public void pdfbox_f3877_0(float[] borderThicknesses)
{    this.setArrayOfNumber(BORDER_THICKNESS, borderThicknesses);}
public Object pdfbox_f3878_0()
{    return this.getNumberOrArrayOfNumber(PADDING, 0.f);}
public void pdfbox_f3879_0(float padding)
{    this.setNumber(PADDING, padding);}
public void pdfbox_f3880_0(int padding)
{    this.setNumber(PADDING, padding);}
public void pdfbox_f3881_0(float[] paddings)
{    this.setArrayOfNumber(PADDING, paddings);}
public PDGamma pdfbox_f3882_0()
{    return this.getColor(COLOR);}
public void pdfbox_f3883_0(PDGamma color)
{    this.setColor(COLOR, color);}
public float pdfbox_f3884_0()
{    return this.getNumber(SPACE_BEFORE, 0.f);}
public void pdfbox_f3885_0(float spaceBefore)
{    this.setNumber(SPACE_BEFORE, spaceBefore);}
public void pdfbox_f3886_0(int spaceBefore)
{    this.setNumber(SPACE_BEFORE, spaceBefore);}
public float pdfbox_f3887_0()
{    return this.getNumber(SPACE_AFTER, 0.f);}
public void pdfbox_f3888_0(float spaceAfter)
{    this.setNumber(SPACE_AFTER, spaceAfter);}
public void pdfbox_f3889_0(int spaceAfter)
{    this.setNumber(SPACE_AFTER, spaceAfter);}
public float pdfbox_f3890_0()
{    return this.getNumber(START_INDENT, 0.f);}
public void pdfbox_f3891_0(float startIndent)
{    this.setNumber(START_INDENT, startIndent);}
public void pdfbox_f3892_0(int startIndent)
{    this.setNumber(START_INDENT, startIndent);}
public float pdfbox_f3893_0()
{    return this.getNumber(END_INDENT, 0.f);}
public void pdfbox_f3894_0(float endIndent)
{    this.setNumber(END_INDENT, endIndent);}
public void pdfbox_f3895_0(int endIndent)
{    this.setNumber(END_INDENT, endIndent);}
public float pdfbox_f3896_0()
{    return this.getNumber(TEXT_INDENT, 0.f);}
public void pdfbox_f3897_0(float textIndent)
{    this.setNumber(TEXT_INDENT, textIndent);}
public void pdfbox_f3898_0(int textIndent)
{    this.setNumber(TEXT_INDENT, textIndent);}
public String pdfbox_f3899_0()
{    return this.getName(TEXT_ALIGN, TEXT_ALIGN_START);}
public void pdfbox_f3900_0(String textIndent)
{    this.setName(TEXT_ALIGN, textIndent);}
public PDRectangle pdfbox_f3901_0()
{    COSArray array = (COSArray) this.getCOSObject().getDictionaryObject(BBOX);    if (array != null) {        return new PDRectangle(array);    }    return null;}
public void pdfbox_f3902_0(PDRectangle bbox)
{    String name = BBOX;    COSBase oldValue = this.getCOSObject().getDictionaryObject(name);    this.getCOSObject().setItem(name, bbox);    COSBase newValue = bbox == null ? null : bbox.getCOSObject();    this.potentiallyNotifyChanged(oldValue, newValue);}
public Object pdfbox_f3903_0()
{    return this.getNumberOrName(WIDTH, WIDTH_AUTO);}
public void pdfbox_f3904_0()
{    this.setName(WIDTH, WIDTH_AUTO);}
public void pdfbox_f3905_0(float width)
{    this.setNumber(WIDTH, width);}
public void pdfbox_f3906_0(int width)
{    this.setNumber(WIDTH, width);}
public Object pdfbox_f3907_0()
{    return this.getNumberOrName(HEIGHT, HEIGHT_AUTO);}
public void pdfbox_f3908_0()
{    this.setName(HEIGHT, HEIGHT_AUTO);}
public void pdfbox_f3909_0(float height)
{    this.setNumber(HEIGHT, height);}
public void pdfbox_f3910_0(int height)
{    this.setNumber(HEIGHT, height);}
public String pdfbox_f3911_0()
{    return this.getName(BLOCK_ALIGN, BLOCK_ALIGN_BEFORE);}
public void pdfbox_f3912_0(String blockAlign)
{    this.setName(BLOCK_ALIGN, blockAlign);}
public String pdfbox_f3913_0()
{    return this.getName(INLINE_ALIGN, INLINE_ALIGN_START);}
public void pdfbox_f3914_0(String inlineAlign)
{    this.setName(INLINE_ALIGN, inlineAlign);}
public Object pdfbox_f3915_0()
{    return this.getNameOrArrayOfName(T_BORDER_STYLE, BORDER_STYLE_NONE);}
public void pdfbox_f3916_0(String tBorderStyle)
{    this.setName(T_BORDER_STYLE, tBorderStyle);}
public void pdfbox_f3917_0(String[] tBorderStyles)
{    this.setArrayOfName(T_BORDER_STYLE, tBorderStyles);}
public Object pdfbox_f3918_0()
{    return this.getNumberOrArrayOfNumber(T_PADDING, 0.f);}
public void pdfbox_f3919_0(float tPadding)
{    this.setNumber(T_PADDING, tPadding);}
public void pdfbox_f3920_0(int tPadding)
{    this.setNumber(T_PADDING, tPadding);}
public void pdfbox_f3921_0(float[] tPaddings)
{    this.setArrayOfNumber(T_PADDING, tPaddings);}
public float pdfbox_f3922_0()
{    return this.getNumber(BASELINE_SHIFT, 0.f);}
public void pdfbox_f3923_0(float baselineShift)
{    this.setNumber(BASELINE_SHIFT, baselineShift);}
public void pdfbox_f3924_0(int baselineShift)
{    this.setNumber(BASELINE_SHIFT, baselineShift);}
public Object pdfbox_f3925_0()
{    return this.getNumberOrName(LINE_HEIGHT, LINE_HEIGHT_NORMAL);}
public void pdfbox_f3926_0()
{    this.setName(LINE_HEIGHT, LINE_HEIGHT_NORMAL);}
public void pdfbox_f3927_0()
{    this.setName(LINE_HEIGHT, LINE_HEIGHT_AUTO);}
public void pdfbox_f3928_0(float lineHeight)
{    this.setNumber(LINE_HEIGHT, lineHeight);}
public void pdfbox_f3929_0(int lineHeight)
{    this.setNumber(LINE_HEIGHT, lineHeight);}
public PDGamma pdfbox_f3930_0()
{    return this.getColor(TEXT_DECORATION_COLOR);}
public void pdfbox_f3931_0(PDGamma textDecorationColor)
{    this.setColor(TEXT_DECORATION_COLOR, textDecorationColor);}
public float pdfbox_f3932_0()
{    return this.getNumber(TEXT_DECORATION_THICKNESS);}
public void pdfbox_f3933_0(float textDecorationThickness)
{    this.setNumber(TEXT_DECORATION_THICKNESS, textDecorationThickness);}
public void pdfbox_f3934_0(int textDecorationThickness)
{    this.setNumber(TEXT_DECORATION_THICKNESS, textDecorationThickness);}
public String pdfbox_f3935_0()
{    return this.getName(TEXT_DECORATION_TYPE, TEXT_DECORATION_TYPE_NONE);}
public void pdfbox_f3936_0(String textDecorationType)
{    this.setName(TEXT_DECORATION_TYPE, textDecorationType);}
public String pdfbox_f3937_0()
{    return this.getName(RUBY_ALIGN, RUBY_ALIGN_DISTRIBUTE);}
public void pdfbox_f3938_0(String rubyAlign)
{    this.setName(RUBY_ALIGN, rubyAlign);}
public String pdfbox_f3939_0()
{    return this.getName(RUBY_POSITION, RUBY_POSITION_BEFORE);}
public void pdfbox_f3940_0(String rubyPosition)
{    this.setName(RUBY_POSITION, rubyPosition);}
public String pdfbox_f3941_0()
{    return this.getName(GLYPH_ORIENTATION_VERTICAL, GLYPH_ORIENTATION_VERTICAL_AUTO);}
public void pdfbox_f3942_0(String glyphOrientationVertical)
{    this.setName(GLYPH_ORIENTATION_VERTICAL, glyphOrientationVertical);}
public int pdfbox_f3943_0()
{    return this.getInteger(COLUMN_COUNT, 1);}
public void pdfbox_f3944_0(int columnCount)
{    this.setInteger(COLUMN_COUNT, columnCount);}
public Object pdfbox_f3945_0()
{    return this.getNumberOrArrayOfNumber(COLUMN_GAP, UNSPECIFIED);}
public void pdfbox_f3946_0(float columnGap)
{    this.setNumber(COLUMN_GAP, columnGap);}
public void pdfbox_f3947_0(int columnGap)
{    this.setNumber(COLUMN_GAP, columnGap);}
public void pdfbox_f3948_0(float[] columnGaps)
{    this.setArrayOfNumber(COLUMN_GAP, columnGaps);}
public Object pdfbox_f3949_0()
{    return this.getNumberOrArrayOfNumber(COLUMN_WIDTHS, UNSPECIFIED);}
public void pdfbox_f3950_0(float columnWidth)
{    this.setNumber(COLUMN_WIDTHS, columnWidth);}
public void pdfbox_f3951_0(int columnWidth)
{    this.setNumber(COLUMN_WIDTHS, columnWidth);}
public void pdfbox_f3952_0(float[] columnWidths)
{    this.setArrayOfNumber(COLUMN_WIDTHS, columnWidths);}
public String pdfbox_f3953_0()
{    StringBuilder sb = new StringBuilder().append(super.toString());    if (this.isSpecified(PLACEMENT)) {        sb.append(", Placement=").append(this.getPlacement());    }    if (this.isSpecified(WRITING_MODE)) {        sb.append(", WritingMode=").append(this.getWritingMode());    }    if (this.isSpecified(BACKGROUND_COLOR)) {        sb.append(", BackgroundColor=").append(this.getBackgroundColor());    }    if (this.isSpecified(BORDER_COLOR)) {        sb.append(", BorderColor=").append(this.getBorderColors());    }    if (this.isSpecified(BORDER_STYLE)) {        Object borderStyle = this.getBorderStyle();        sb.append(", BorderStyle=");        if (borderStyle instanceof String[]) {            sb.append(arrayToString((String[]) borderStyle));        } else {            sb.append(borderStyle);        }    }    if (this.isSpecified(BORDER_THICKNESS)) {        Object borderThickness = this.getBorderThickness();        sb.append(", BorderThickness=");        if (borderThickness instanceof float[]) {            sb.append(arrayToString((float[]) borderThickness));        } else {            sb.append(String.valueOf(borderThickness));        }    }    if (this.isSpecified(PADDING)) {        Object padding = this.getPadding();        sb.append(", Padding=");        if (padding instanceof float[]) {            sb.append(arrayToString((float[]) padding));        } else {            sb.append(String.valueOf(padding));        }    }    if (this.isSpecified(COLOR)) {        sb.append(", Color=").append(this.getColor());    }    if (this.isSpecified(SPACE_BEFORE)) {        sb.append(", SpaceBefore=").append(String.valueOf(this.getSpaceBefore()));    }    if (this.isSpecified(SPACE_AFTER)) {        sb.append(", SpaceAfter=").append(String.valueOf(this.getSpaceAfter()));    }    if (this.isSpecified(START_INDENT)) {        sb.append(", StartIndent=").append(String.valueOf(this.getStartIndent()));    }    if (this.isSpecified(END_INDENT)) {        sb.append(", EndIndent=").append(String.valueOf(this.getEndIndent()));    }    if (this.isSpecified(TEXT_INDENT)) {        sb.append(", TextIndent=").append(String.valueOf(this.getTextIndent()));    }    if (this.isSpecified(TEXT_ALIGN)) {        sb.append(", TextAlign=").append(this.getTextAlign());    }    if (this.isSpecified(BBOX)) {        sb.append(", BBox=").append(this.getBBox());    }    if (this.isSpecified(WIDTH)) {        Object width = this.getWidth();        sb.append(", Width=");        if (width instanceof Float) {            sb.append(String.valueOf(width));        } else {            sb.append(width);        }    }    if (this.isSpecified(HEIGHT)) {        Object height = this.getHeight();        sb.append(", Height=");        if (height instanceof Float) {            sb.append(String.valueOf(height));        } else {            sb.append(height);        }    }    if (this.isSpecified(BLOCK_ALIGN)) {        sb.append(", BlockAlign=").append(this.getBlockAlign());    }    if (this.isSpecified(INLINE_ALIGN)) {        sb.append(", InlineAlign=").append(this.getInlineAlign());    }    if (this.isSpecified(T_BORDER_STYLE)) {        Object tBorderStyle = this.getTBorderStyle();        sb.append(", TBorderStyle=");        if (tBorderStyle instanceof String[]) {            sb.append(arrayToString((String[]) tBorderStyle));        } else {            sb.append(tBorderStyle);        }    }    if (this.isSpecified(T_PADDING)) {        Object tPadding = this.getTPadding();        sb.append(", TPadding=");        if (tPadding instanceof float[]) {            sb.append(arrayToString((float[]) tPadding));        } else {            sb.append(String.valueOf(tPadding));        }    }    if (this.isSpecified(BASELINE_SHIFT)) {        sb.append(", BaselineShift=").append(String.valueOf(this.getBaselineShift()));    }    if (this.isSpecified(LINE_HEIGHT)) {        Object lineHeight = this.getLineHeight();        sb.append(", LineHeight=");        if (lineHeight instanceof Float) {            sb.append(String.valueOf(lineHeight));        } else {            sb.append(lineHeight);        }    }    if (this.isSpecified(TEXT_DECORATION_COLOR)) {        sb.append(", TextDecorationColor=").append(this.getTextDecorationColor());    }    if (this.isSpecified(TEXT_DECORATION_THICKNESS)) {        sb.append(", TextDecorationThickness=").append(String.valueOf(this.getTextDecorationThickness()));    }    if (this.isSpecified(TEXT_DECORATION_TYPE)) {        sb.append(", TextDecorationType=").append(this.getTextDecorationType());    }    if (this.isSpecified(RUBY_ALIGN)) {        sb.append(", RubyAlign=").append(this.getRubyAlign());    }    if (this.isSpecified(RUBY_POSITION)) {        sb.append(", RubyPosition=").append(this.getRubyPosition());    }    if (this.isSpecified(GLYPH_ORIENTATION_VERTICAL)) {        sb.append(", GlyphOrientationVertical=").append(this.getGlyphOrientationVertical());    }    if (this.isSpecified(COLUMN_COUNT)) {        sb.append(", ColumnCount=").append(String.valueOf(this.getColumnCount()));    }    if (this.isSpecified(COLUMN_GAP)) {        Object columnGap = this.getColumnGap();        sb.append(", ColumnGap=");        if (columnGap instanceof float[]) {            sb.append(arrayToString((float[]) columnGap));        } else {            sb.append(String.valueOf(columnGap));        }    }    if (this.isSpecified(COLUMN_WIDTHS)) {        Object columnWidth = this.getColumnWidths();        sb.append(", ColumnWidths=");        if (columnWidth instanceof float[]) {            sb.append(arrayToString((float[]) columnWidth));        } else {            sb.append(String.valueOf(columnWidth));        }    }    return sb.toString();}
public String pdfbox_f3954_0()
{    return this.getName(LIST_NUMBERING, LIST_NUMBERING_NONE);}
public void pdfbox_f3955_0(String listNumbering)
{    this.setName(LIST_NUMBERING, listNumbering);}
public String pdfbox_f3956_0()
{    StringBuilder sb = new StringBuilder().append(super.toString());    if (this.isSpecified(LIST_NUMBERING)) {        sb.append(", ListNumbering=").append(this.getListNumbering());    }    return sb.toString();}
public String pdfbox_f3957_0()
{    return this.getName(ROLE);}
public void pdfbox_f3958_0(String role)
{    this.setName(ROLE, role);}
public String pdfbox_f3959_0()
{    return this.getName(CHECKED, CHECKED_STATE_OFF);}
public void pdfbox_f3960_0(String checkedState)
{    this.setName(CHECKED, checkedState);}
public String pdfbox_f3961_0()
{    return this.getString(DESC);}
public void pdfbox_f3962_0(String alternateName)
{    this.setString(DESC, alternateName);}
public String pdfbox_f3963_0()
{    StringBuilder sb = new StringBuilder().append(super.toString());    if (this.isSpecified(ROLE)) {        sb.append(", Role=").append(this.getRole());    }    if (this.isSpecified(CHECKED)) {        sb.append(", Checked=").append(this.getCheckedState());    }    if (this.isSpecified(DESC)) {        sb.append(", Desc=").append(this.getAlternateName());    }    return sb.toString();}
public boolean pdfbox_f3964_0(String name)
{    return this.getCOSObject().getDictionaryObject(name) != null;}
protected String pdfbox_f3965_0(String name)
{    return this.getCOSObject().getString(name);}
protected void pdfbox_f3966_0(String name, String value)
{    COSBase oldBase = this.getCOSObject().getDictionaryObject(name);    this.getCOSObject().setString(name, value);    COSBase newBase = this.getCOSObject().getDictionaryObject(name);    this.potentiallyNotifyChanged(oldBase, newBase);}
protected String[] pdfbox_f3967_0(String name)
{    COSBase v = this.getCOSObject().getDictionaryObject(name);    if (v instanceof COSArray) {        COSArray array = (COSArray) v;        String[] strings = new String[array.size()];        for (int i = 0; i < array.size(); i++) {            strings[i] = ((COSName) array.getObject(i)).getName();        }        return strings;    }    return null;}
protected void pdfbox_f3968_0(String name, String[] values)
{    COSBase oldBase = this.getCOSObject().getDictionaryObject(name);    COSArray array = new COSArray();    for (String value : values) {        array.add(new COSString(value));    }    this.getCOSObject().setItem(name, array);    COSBase newBase = this.getCOSObject().getDictionaryObject(name);    this.potentiallyNotifyChanged(oldBase, newBase);}
protected String pdfbox_f3969_0(String name)
{    return this.getCOSObject().getNameAsString(name);}
protected String pdfbox_f3970_0(String name, String defaultValue)
{    return this.getCOSObject().getNameAsString(name, defaultValue);}
protected Object pdfbox_f3971_0(String name, String defaultValue)
{    COSBase v = this.getCOSObject().getDictionaryObject(name);    if (v instanceof COSArray) {        COSArray array = (COSArray) v;        String[] names = new String[array.size()];        for (int i = 0; i < array.size(); i++) {            COSBase item = array.getObject(i);            if (item instanceof COSName) {                names[i] = ((COSName) item).getName();            }        }        return names;    }    if (v instanceof COSName) {        return ((COSName) v).getName();    }    return defaultValue;}
protected void pdfbox_f3972_0(String name, String value)
{    COSBase oldBase = this.getCOSObject().getDictionaryObject(name);    this.getCOSObject().setName(name, value);    COSBase newBase = this.getCOSObject().getDictionaryObject(name);    this.potentiallyNotifyChanged(oldBase, newBase);}
protected void pdfbox_f3973_0(String name, String[] values)
{    COSBase oldBase = this.getCOSObject().getDictionaryObject(name);    COSArray array = new COSArray();    for (String value : values) {        array.add(COSName.getPDFName(value));    }    this.getCOSObject().setItem(name, array);    COSBase newBase = this.getCOSObject().getDictionaryObject(name);    this.potentiallyNotifyChanged(oldBase, newBase);}
protected Object pdfbox_f3974_0(String name, String defaultValue)
{    COSBase value = this.getCOSObject().getDictionaryObject(name);    if (value instanceof COSNumber) {        return ((COSNumber) value).floatValue();    }    if (value instanceof COSName) {        return ((COSName) value).getName();    }    return defaultValue;}
protected int pdfbox_f3975_0(String name, int defaultValue)
{    return this.getCOSObject().getInt(name, defaultValue);}
protected void pdfbox_f3976_0(String name, int value)
{    COSBase oldBase = this.getCOSObject().getDictionaryObject(name);    this.getCOSObject().setInt(name, value);    COSBase newBase = this.getCOSObject().getDictionaryObject(name);    this.potentiallyNotifyChanged(oldBase, newBase);}
protected float pdfbox_f3977_0(String name, float defaultValue)
{    return this.getCOSObject().getFloat(name, defaultValue);}
protected float pdfbox_f3978_0(String name)
{    return this.getCOSObject().getFloat(name);}
protected Object pdfbox_f3979_0(String name, float defaultValue)
{    COSBase v = this.getCOSObject().getDictionaryObject(name);    if (v instanceof COSArray) {        COSArray array = (COSArray) v;        float[] values = new float[array.size()];        for (int i = 0; i < array.size(); i++) {            COSBase item = array.getObject(i);            if (item instanceof COSNumber) {                values[i] = ((COSNumber) item).floatValue();            }        }        return values;    }    if (v instanceof COSNumber) {        return ((COSNumber) v).floatValue();    }    if (Float.compare(defaultValue, UNSPECIFIED) == 0) {        return null;    }    return defaultValue;}
protected void pdfbox_f3980_0(String name, float value)
{    COSBase oldBase = this.getCOSObject().getDictionaryObject(name);    this.getCOSObject().setFloat(name, value);    COSBase newBase = this.getCOSObject().getDictionaryObject(name);    this.potentiallyNotifyChanged(oldBase, newBase);}
protected void pdfbox_f3981_0(String name, int value)
{    COSBase oldBase = this.getCOSObject().getDictionaryObject(name);    this.getCOSObject().setInt(name, value);    COSBase newBase = this.getCOSObject().getDictionaryObject(name);    this.potentiallyNotifyChanged(oldBase, newBase);}
protected void pdfbox_f3982_0(String name, float[] values)
{    COSArray array = new COSArray();    for (float value : values) {        array.add(new COSFloat(value));    }    COSBase oldBase = this.getCOSObject().getDictionaryObject(name);    this.getCOSObject().setItem(name, array);    COSBase newBase = this.getCOSObject().getDictionaryObject(name);    this.potentiallyNotifyChanged(oldBase, newBase);}
protected PDGamma pdfbox_f3983_0(String name)
{    COSArray c = (COSArray) this.getCOSObject().getDictionaryObject(name);    if (c != null) {        return new PDGamma(c);    }    return null;}
protected Object pdfbox_f3984_0(String name)
{    COSArray array = (COSArray) this.getCOSObject().getDictionaryObject(name);    if (array == null) {        return null;    }    if (array.size() == 3) {                return new PDGamma(array);    } else if (array.size() == 4) {        return new PDFourColours(array);    }    return null;}
protected void pdfbox_f3985_0(String name, PDGamma value)
{    COSBase oldValue = this.getCOSObject().getDictionaryObject(name);    this.getCOSObject().setItem(name, value);    COSBase newValue = value == null ? null : value.getCOSObject();    this.potentiallyNotifyChanged(oldValue, newValue);}
protected void pdfbox_f3986_0(String name, PDFourColours value)
{    COSBase oldValue = this.getCOSObject().getDictionaryObject(name);    this.getCOSObject().setItem(name, value);    COSBase newValue = value == null ? null : value.getCOSObject();    this.potentiallyNotifyChanged(oldValue, newValue);}
public int pdfbox_f3987_0()
{    return this.getInteger(ROW_SPAN, 1);}
public void pdfbox_f3988_0(int rowSpan)
{    this.setInteger(ROW_SPAN, rowSpan);}
public int pdfbox_f3989_0()
{    return this.getInteger(COL_SPAN, 1);}
public void pdfbox_f3990_0(int colSpan)
{    this.setInteger(COL_SPAN, colSpan);}
public String[] pdfbox_f3991_0()
{    return this.getArrayOfString(HEADERS);}
public void pdfbox_f3992_0(String[] headers)
{    this.setArrayOfString(HEADERS, headers);}
public String pdfbox_f3993_0()
{    return this.getName(SCOPE);}
public void pdfbox_f3994_0(String scope)
{    this.setName(SCOPE, scope);}
public String pdfbox_f3995_0()
{    return this.getString(SUMMARY);}
public void pdfbox_f3996_0(String summary)
{    this.setString(SUMMARY, summary);}
public String pdfbox_f3997_0()
{    StringBuilder sb = new StringBuilder().append(super.toString());    if (this.isSpecified(ROW_SPAN)) {        sb.append(", RowSpan=").append(String.valueOf(this.getRowSpan()));    }    if (this.isSpecified(COL_SPAN)) {        sb.append(", ColSpan=").append(String.valueOf(this.getColSpan()));    }    if (this.isSpecified(HEADERS)) {        sb.append(", Headers=").append(arrayToString(this.getHeaders()));    }    if (this.isSpecified(SCOPE)) {        sb.append(", Scope=").append(this.getScope());    }    if (this.isSpecified(SUMMARY)) {        sb.append(", Summary=").append(this.getSummary());    }    return sb.toString();}
private boolean pdfbox_f3998_0(int bit)
{    return (bytes & (1 << (bit - 1))) != 0;}
private boolean pdfbox_f3999_0(int bit, boolean value)
{    int permissions = bytes;    if (value) {        permissions = permissions | (1 << (bit - 1));    } else {        permissions = permissions & (~(1 << (bit - 1)));    }    bytes = permissions;    return (bytes & (1 << (bit - 1))) != 0;}
public boolean pdfbox_f4000_0()
{    return (this.canAssembleDocument() && this.canExtractContent() && this.canExtractForAccessibility() && this.canFillInForm() && this.canModify() && this.canModifyAnnotations() && this.canPrint() && this.canPrintDegraded());}
public static AccessPermission pdfbox_f4001_0()
{    AccessPermission ret = new AccessPermission();    ret.setCanAssembleDocument(true);    ret.setCanExtractContent(true);    ret.setCanExtractForAccessibility(true);    ret.setCanFillInForm(true);    ret.setCanModify(true);    ret.setCanModifyAnnotations(true);    ret.setCanPrint(true);    ret.setCanPrintDegraded(true);    return ret;}
public int pdfbox_f4002_0()
{    setPermissionBit(1, true);    setPermissionBit(7, false);    setPermissionBit(8, false);    for (int i = 13; i <= 32; i++) {        setPermissionBit(i, false);    }    return bytes;}
public int pdfbox_f4003_0()
{    return bytes;}
public boolean pdfbox_f4004_0()
{    return isPermissionBitOn(PRINT_BIT);}
public void pdfbox_f4005_0(boolean allowPrinting)
{    if (!readOnly) {        setPermissionBit(PRINT_BIT, allowPrinting);    }}
public boolean pdfbox_f4006_0()
{    return isPermissionBitOn(MODIFICATION_BIT);}
public void pdfbox_f4007_0(boolean allowModifications)
{    if (!readOnly) {        setPermissionBit(MODIFICATION_BIT, allowModifications);    }}
public boolean pdfbox_f4008_0()
{    return isPermissionBitOn(EXTRACT_BIT);}
public void pdfbox_f4009_0(boolean allowExtraction)
{    if (!readOnly) {        setPermissionBit(EXTRACT_BIT, allowExtraction);    }}
public boolean pdfbox_f4010_0()
{    return isPermissionBitOn(MODIFY_ANNOTATIONS_BIT);}
public void pdfbox_f4011_0(boolean allowAnnotationModification)
{    if (!readOnly) {        setPermissionBit(MODIFY_ANNOTATIONS_BIT, allowAnnotationModification);    }}
public boolean pdfbox_f4012_0()
{    return isPermissionBitOn(FILL_IN_FORM_BIT);}
public void pdfbox_f4013_0(boolean allowFillingInForm)
{    if (!readOnly) {        setPermissionBit(FILL_IN_FORM_BIT, allowFillingInForm);    }}
public boolean pdfbox_f4014_0()
{    return isPermissionBitOn(EXTRACT_FOR_ACCESSIBILITY_BIT);}
public void pdfbox_f4015_0(boolean allowExtraction)
{    if (!readOnly) {        setPermissionBit(EXTRACT_FOR_ACCESSIBILITY_BIT, allowExtraction);    }}
public boolean pdfbox_f4016_0()
{    return isPermissionBitOn(ASSEMBLE_DOCUMENT_BIT);}
public void pdfbox_f4017_0(boolean allowAssembly)
{    if (!readOnly) {        setPermissionBit(ASSEMBLE_DOCUMENT_BIT, allowAssembly);    }}
public boolean pdfbox_f4018_0()
{    return isPermissionBitOn(DEGRADED_PRINT_BIT);}
public void pdfbox_f4019_0(boolean canPrintDegraded)
{    if (!readOnly) {        setPermissionBit(DEGRADED_PRINT_BIT, canPrintDegraded);    }}
public void pdfbox_f4020_0()
{    readOnly = true;}
public boolean pdfbox_f4021_0()
{    return readOnly;}
protected boolean pdfbox_f4022_0()
{    if (canFillInForm()) {        return true;    }    if (canExtractForAccessibility()) {        return true;    }    if (canAssembleDocument()) {        return true;    }    return canPrintDegraded();}
 static MessageDigest pdfbox_f4023_0()
{    try {        return MessageDigest.getInstance("MD5");    } catch (NoSuchAlgorithmException e) {                throw new RuntimeException(e);    }}
 static MessageDigest pdfbox_f4024_0()
{    try {        return MessageDigest.getInstance("SHA-1");    } catch (NoSuchAlgorithmException e) {                throw new RuntimeException(e);    }}
 static MessageDigest pdfbox_f4025_0()
{    try {        return MessageDigest.getInstance("SHA-256");    } catch (NoSuchAlgorithmException e) {                throw new RuntimeException(e);    }}
public COSDictionary pdfbox_f4026_0()
{    return cryptFilterDictionary;}
public void pdfbox_f4027_0(int length)
{    cryptFilterDictionary.setInt(COSName.LENGTH, length);}
public int pdfbox_f4028_0()
{    return cryptFilterDictionary.getInt(COSName.LENGTH, 40);}
public void pdfbox_f4029_0(COSName cfm)
{    cryptFilterDictionary.setItem(COSName.CFM, cfm);}
public COSName pdfbox_f4030_0()
{    return (COSName) cryptFilterDictionary.getDictionaryObject(COSName.CFM);}
public SecurityHandler pdfbox_f4031_0() throws IOException
{    if (securityHandler == null) {        throw new IOException("No security handler for filter " + getFilter());    }    return securityHandler;}
public void pdfbox_f4032_0(SecurityHandler securityHandler)
{    this.securityHandler = securityHandler;}
public boolean pdfbox_f4033_0()
{    return securityHandler == null;}
public COSDictionary pdfbox_f4034_0()
{    return dictionary;}
public void pdfbox_f4035_0(String filter)
{    dictionary.setItem(COSName.FILTER, COSName.getPDFName(filter));}
public final String pdfbox_f4036_0()
{    return dictionary.getNameAsString(COSName.FILTER);}
public String pdfbox_f4037_0()
{    return dictionary.getNameAsString(COSName.SUB_FILTER);}
public void pdfbox_f4038_0(String subfilter)
{    dictionary.setName(COSName.SUB_FILTER, subfilter);}
public void pdfbox_f4039_0(int version)
{    dictionary.setInt(COSName.V, version);}
public int pdfbox_f4040_0()
{    return dictionary.getInt(COSName.V, 0);}
public void pdfbox_f4041_0(int length)
{    dictionary.setInt(COSName.LENGTH, length);}
public int pdfbox_f4042_0()
{    return dictionary.getInt(COSName.LENGTH, 40);}
public void pdfbox_f4043_0(int revision)
{    dictionary.setInt(COSName.R, revision);}
