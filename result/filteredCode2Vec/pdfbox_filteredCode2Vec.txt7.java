public void pdfbox_f7086_0(float x, float y, float width, float height) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: addRect is not allowed within a text block.");    }    writeOperand(x);    writeOperand(y);    writeOperand(width);    writeOperand(height);    writeOperator(OperatorName.APPEND_RECT);}
public void pdfbox_f7087_0(float x1, float y1, float x2, float y2, float x3, float y3) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: curveTo is not allowed within a text block.");    }    writeOperand(x1);    writeOperand(y1);    writeOperand(x2);    writeOperand(y2);    writeOperand(x3);    writeOperand(y3);    writeOperator(OperatorName.CURVE_TO);}
public void pdfbox_f7088_0(float x2, float y2, float x3, float y3) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: curveTo2 is not allowed within a text block.");    }    writeOperand(x2);    writeOperand(y2);    writeOperand(x3);    writeOperand(y3);    writeOperator(OperatorName.CURVE_TO_REPLICATE_INITIAL_POINT);}
public void pdfbox_f7089_0(float x1, float y1, float x3, float y3) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: curveTo1 is not allowed within a text block.");    }    writeOperand(x1);    writeOperand(y1);    writeOperand(x3);    writeOperand(y3);    writeOperator(OperatorName.CURVE_TO_REPLICATE_FINAL_POINT);}
public void pdfbox_f7090_0(float x, float y) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: moveTo is not allowed within a text block.");    }    writeOperand(x);    writeOperand(y);    writeOperator(OperatorName.MOVE_TO);}
public void pdfbox_f7091_0(float x, float y) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: lineTo is not allowed within a text block.");    }    writeOperand(x);    writeOperand(y);    writeOperator(OperatorName.LINE_TO);}
public void pdfbox_f7092_0() throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: stroke is not allowed within a text block.");    }    writeOperator(OperatorName.STROKE_PATH);}
public void pdfbox_f7093_0() throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: closeAndStroke is not allowed within a text block.");    }    writeOperator(OperatorName.CLOSE_AND_STROKE);}
public void pdfbox_f7094_0() throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: fill is not allowed within a text block.");    }    writeOperator(OperatorName.FILL_NON_ZERO);}
public void pdfbox_f7095_0() throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: fillEvenOdd is not allowed within a text block.");    }    writeOperator(OperatorName.FILL_EVEN_ODD);}
public void pdfbox_f7096_0() throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: fillAndStroke is not allowed within a text block.");    }    writeOperator(OperatorName.FILL_NON_ZERO_AND_STROKE);}
public void pdfbox_f7097_0() throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: fillAndStrokeEvenOdd is not allowed within a text block.");    }    writeOperator(OperatorName.FILL_EVEN_ODD_AND_STROKE);}
public void pdfbox_f7098_0() throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: closeAndFillAndStroke is not allowed within a text block.");    }    writeOperator(OperatorName.CLOSE_FILL_NON_ZERO_AND_STROKE);}
public void pdfbox_f7099_0() throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: closeAndFillAndStrokeEvenOdd is not allowed within a text block.");    }    writeOperator(OperatorName.CLOSE_FILL_EVEN_ODD_AND_STROKE);}
public void pdfbox_f7100_0(PDShading shading) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: shadingFill is not allowed within a text block.");    }    writeOperand(resources.add(shading));    writeOperator(OperatorName.SHADING_FILL);}
public void pdfbox_f7101_0() throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: closePath is not allowed within a text block.");    }    writeOperator(OperatorName.CLOSE_PATH);}
public void pdfbox_f7102_0() throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: clip is not allowed within a text block.");    }    writeOperator(OperatorName.CLIP_NON_ZERO);        writeOperator(OperatorName.ENDPATH);}
public void pdfbox_f7103_0() throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: clipEvenOdd is not allowed within a text block.");    }    writeOperator(OperatorName.CLIP_EVEN_ODD);        writeOperator(OperatorName.ENDPATH);}
public void pdfbox_f7104_0(float lineWidth) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: setLineWidth is not allowed within a text block.");    }    writeOperand(lineWidth);    writeOperator(OperatorName.SET_LINE_WIDTH);}
public void pdfbox_f7105_0(int lineJoinStyle) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: setLineJoinStyle is not allowed within a text block.");    }    if (lineJoinStyle >= 0 && lineJoinStyle <= 2) {        writeOperand(lineJoinStyle);        writeOperator(OperatorName.SET_LINE_JOINSTYLE);    } else {        throw new IllegalArgumentException("Error: unknown value for line join style");    }}
public void pdfbox_f7106_0(int lineCapStyle) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: setLineCapStyle is not allowed within a text block.");    }    if (lineCapStyle >= 0 && lineCapStyle <= 2) {        writeOperand(lineCapStyle);        writeOperator(OperatorName.SET_LINE_CAPSTYLE);    } else {        throw new IllegalArgumentException("Error: unknown value for line cap style");    }}
public void pdfbox_f7107_0(float[] pattern, float phase) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: setLineDashPattern is not allowed within a text block.");    }    write("[");    for (float value : pattern) {        writeOperand(value);    }    write("] ");    writeOperand(phase);    writeOperator(OperatorName.SET_LINE_DASHPATTERN);}
public void pdfbox_f7108_0(float miterLimit) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: setMiterLimit is not allowed within a text block.");    }    if (miterLimit <= 0.0) {        throw new IllegalArgumentException("A miter limit <= 0 is invalid and will not render in Acrobat Reader");    }    writeOperand(miterLimit);    writeOperator(OperatorName.SET_LINE_MITERLIMIT);}
public void pdfbox_f7109_0(COSName tag) throws IOException
{    writeOperand(tag);    writeOperator(OperatorName.BEGIN_MARKED_CONTENT);}
public void pdfbox_f7110_0(COSName tag, PDPropertyList propertyList) throws IOException
{    writeOperand(tag);    writeOperand(resources.add(propertyList));    writeOperator(OperatorName.BEGIN_MARKED_CONTENT_SEQ);}
public void pdfbox_f7111_0() throws IOException
{    writeOperator(OperatorName.END_MARKED_CONTENT);}
public void pdfbox_f7112_0(PDExtendedGraphicsState state) throws IOException
{    writeOperand(resources.add(state));    writeOperator(OperatorName.SET_GRAPHICS_STATE_PARAMS);}
public void pdfbox_f7113_0(String comment) throws IOException
{    if (comment.indexOf('\n') >= 0 || comment.indexOf('\r') >= 0) {        throw new IllegalArgumentException("comment should not include a newline");    }    outputStream.write('%');    outputStream.write(comment.getBytes(Charsets.US_ASCII));    outputStream.write('\n');}
protected void pdfbox_f7114_0(float real) throws IOException
{    int byteCount = NumberFormatUtil.formatFloatFast(real, formatDecimal.getMaximumFractionDigits(), formatBuffer);    if (byteCount == -1) {                write(formatDecimal.format(real));    } else {        outputStream.write(formatBuffer, 0, byteCount);    }    outputStream.write(' ');}
protected void pdfbox_f7115_0(int integer) throws IOException
{    write(formatDecimal.format(integer));    outputStream.write(' ');}
protected void pdfbox_f7116_0(COSName name) throws IOException
{    name.writePDF(outputStream);    outputStream.write(' ');}
protected void pdfbox_f7117_0(String text) throws IOException
{    outputStream.write(text.getBytes(Charsets.US_ASCII));    outputStream.write('\n');}
protected void pdfbox_f7118_0(String text) throws IOException
{    outputStream.write(text.getBytes(Charsets.US_ASCII));}
protected void pdfbox_f7119_0(byte[] data) throws IOException
{    outputStream.write(data);}
protected void pdfbox_f7120_0() throws IOException
{    outputStream.write('\n');}
protected void pdfbox_f7121_0(byte[] data) throws IOException
{    outputStream.write(data);}
private void pdfbox_f7122_0(AffineTransform transform) throws IOException
{    double[] values = new double[6];    transform.getMatrix(values);    for (double v : values) {        writeOperand((float) v);    }}
public void pdfbox_f7123_1() throws IOException
{    if (inTextMode) {            }    outputStream.close();}
protected boolean pdfbox_f7124_0(int val)
{    return val < 0 || val > 255;}
private boolean pdfbox_f7125_0(double val)
{    return val < 0 || val > 1;}
protected void pdfbox_f7126_0(PDColorSpace colorSpace)
{    if (strokingColorSpaceStack.isEmpty()) {        strokingColorSpaceStack.add(colorSpace);    } else {        strokingColorSpaceStack.pop();        strokingColorSpaceStack.push(colorSpace);    }}
protected void pdfbox_f7127_0(PDColorSpace colorSpace)
{    if (nonStrokingColorSpaceStack.isEmpty()) {        nonStrokingColorSpaceStack.add(colorSpace);    } else {        nonStrokingColorSpaceStack.pop();        nonStrokingColorSpaceStack.push(colorSpace);    }}
public void pdfbox_f7128_0(float spacing) throws IOException
{    writeOperand(spacing);    writeOperator(OperatorName.SET_CHAR_SPACING);}
public void pdfbox_f7129_0(float spacing) throws IOException
{    writeOperand(spacing);    writeOperator(OperatorName.SET_WORD_SPACING);}
public void pdfbox_f7130_0(float scale) throws IOException
{    writeOperand(scale);    writeOperator(OperatorName.SET_TEXT_HORIZONTAL_SCALING);}
public void pdfbox_f7131_0(RenderingMode rm) throws IOException
{    writeOperand(rm.intValue());    writeOperator(OperatorName.SET_TEXT_RENDERINGMODE);}
public void pdfbox_f7132_0(float rise) throws IOException
{    writeOperand(rise);    writeOperator(OperatorName.SET_TEXT_RISE);}
private byte[] pdfbox_f7133_0(GsubWorker gsubWorker, Set<Integer> glyphIds, PDType0Font font, String text) throws IOException
{    Pattern spaceRegex = Pattern.compile("\\s");        List<String> words = new CompoundCharacterTokenizer("\\s").tokenize(text);    ByteArrayOutputStream out = new ByteArrayOutputStream();    for (String word : words) {        if (spaceRegex.matcher(word).matches()) {            out.write(font.encode(word));        } else {            glyphIds.addAll(applyGSUBRules(gsubWorker, out, font, word));        }    }    return out.toByteArray();}
private List<Integer> pdfbox_f7134_0(GsubWorker gsubWorker, ByteArrayOutputStream out, PDType0Font font, String word) throws IOException
{    List<Integer> originalGlyphIds = new ArrayList<>();    CmapLookup cmapLookup = font.getCmapLookup();        for (char unicodeChar : word.toCharArray()) {        int glyphId = cmapLookup.getGlyphId(unicodeChar);        if (glyphId <= 0) {            throw new IllegalStateException("could not find the glyphId for the character: " + unicodeChar);        }        originalGlyphIds.add(glyphId);    }    List<Integer> glyphIdsAfterGsub = gsubWorker.applyTransforms(originalGlyphIds);    for (Integer glyphId : glyphIdsAfterGsub) {        out.write(font.encodeGlyphId(glyphId));    }    return glyphIdsAfterGsub;}
public boolean pdfbox_f7135_0(PDColor color) throws IOException
{    if (color != null) {        float[] components = color.getComponents();        if (components.length > 0) {            setStrokingColor(components);            return true;        }    }    return false;}
public void pdfbox_f7136_0(float[] components) throws IOException
{    for (float value : components) {        writeOperand(value);    }    int numComponents = components.length;    switch(numComponents) {        case 1:            writeOperator(OperatorName.STROKING_COLOR_GRAY);            break;        case 3:            writeOperator(OperatorName.STROKING_COLOR_RGB);            break;        case 4:            writeOperator(OperatorName.STROKING_COLOR_CMYK);            break;        default:            break;    }}
public boolean pdfbox_f7137_0(PDColor color) throws IOException
{    if (color != null) {        float[] components = color.getComponents();        if (components.length > 0) {            setNonStrokingColor(components);            return true;        }    }    return false;}
public void pdfbox_f7138_0(float[] components) throws IOException
{    for (float value : components) {        writeOperand(value);    }    int numComponents = components.length;    switch(numComponents) {        case 1:            writeOperator(OperatorName.NON_STROKING_GRAY);            break;        case 3:            writeOperator(OperatorName.NON_STROKING_RGB);            break;        case 4:            writeOperator(OperatorName.NON_STROKING_CMYK);            break;        default:            break;    }}
public void pdfbox_f7139_0(float lineWidth, PDBorderStyleDictionary bs, COSArray border) throws IOException
{        if (bs != null && bs.getCOSObject().containsKey(COSName.D) && bs.getStyle().equals(PDBorderStyleDictionary.STYLE_DASHED)) {        setLineDashPattern(bs.getDashStyle().getDashArray(), 0);    } else if (bs == null && border.size() > 3 && border.getObject(3) instanceof COSArray) {        setLineDashPattern(((COSArray) border.getObject(3)).toFloatArray(), 0);    }    setLineWidthOnDemand(lineWidth);}
public void pdfbox_f7140_0(float lineWidth) throws IOException
{        if (!(Math.abs(lineWidth - 1) < 1e-6)) {        setLineWidth(lineWidth);    }}
public void pdfbox_f7141_0(float lineWidth, boolean hasStroke, boolean hasFill) throws IOException
{        boolean resolvedHasStroke = hasStroke;        if (lineWidth < 1e-6) {        resolvedHasStroke = false;    }    if (hasFill && resolvedHasStroke) {        fillAndStroke();    } else if (resolvedHasStroke) {        stroke();    } else if (hasFill) {        fill();    } else {        writeOperator(OperatorName.ENDPATH);    }}
protected PDPageDestination pdfbox_f7142_0(COSBase base) throws IOException
{    COSBase destination = base;    if (base instanceof COSDictionary) {                                destination = ((COSDictionary) base).getDictionaryObject(COSName.D);    }    return (PDPageDestination) PDDestination.create(destination);}
protected PDNameTreeNode<PDPageDestination> pdfbox_f7143_0(COSDictionary dic)
{    return new PDDestinationNameTreeNode(dic);}
public void pdfbox_f7144_0(PDPage page)
{    getPages().add(page);}
public void pdfbox_f7145_0(PDSignature sigObject) throws IOException
{    addSignature(sigObject, new SignatureOptions());}
public void pdfbox_f7146_0(PDSignature sigObject, SignatureOptions options) throws IOException
{    addSignature(sigObject, null, options);}
public void pdfbox_f7147_0(PDSignature sigObject, SignatureInterface signatureInterface) throws IOException
{    addSignature(sigObject, signatureInterface, new SignatureOptions());}
public void pdfbox_f7148_0(PDSignature sigObject, SignatureInterface signatureInterface, SignatureOptions options) throws IOException
{    if (signatureAdded) {        throw new IllegalStateException("Only one signature may be added in a document");    }    signatureAdded = true;                int preferredSignatureSize = options.getPreferredSignatureSize();    if (preferredSignatureSize > 0) {        sigObject.setContents(new byte[preferredSignatureSize]);    } else {        sigObject.setContents(new byte[SignatureOptions.DEFAULT_SIGNATURE_SIZE]);    }        sigObject.setByteRange(RESERVE_BYTE_RANGE);    signInterface = signatureInterface;            int pageCount = getNumberOfPages();    if (pageCount == 0) {        throw new IllegalStateException("Cannot sign an empty document");    }    int startIndex = Math.min(Math.max(options.getPage(), 0), pageCount - 1);    PDPage page = getPage(startIndex);        PDDocumentCatalog catalog = getDocumentCatalog();    PDAcroForm acroForm = catalog.getAcroForm();    catalog.getCOSObject().setNeedToBeUpdated(true);    if (acroForm == null) {        acroForm = new PDAcroForm(this);        catalog.setAcroForm(acroForm);    } else {        acroForm.getCOSObject().setNeedToBeUpdated(true);    }    PDSignatureField signatureField = null;    if (!(acroForm.getCOSObject().getDictionaryObject(COSName.FIELDS) instanceof COSArray)) {        acroForm.getCOSObject().setItem(COSName.FIELDS, new COSArray());    } else {        COSArray fieldArray = (COSArray) acroForm.getCOSObject().getDictionaryObject(COSName.FIELDS);        fieldArray.setNeedToBeUpdated(true);        signatureField = findSignatureField(acroForm.getFieldIterator(), sigObject);    }    if (signatureField == null) {        signatureField = new PDSignatureField(acroForm);                signatureField.setValue(sigObject);                signatureField.getWidgets().get(0).setPage(page);    } else {        sigObject.getCOSObject().setNeedToBeUpdated(true);    }                        signatureField.getWidgets().get(0).setPrinted(true);        List<PDField> acroFormFields = acroForm.getFields();    acroForm.getCOSObject().setDirect(true);    acroForm.setSignaturesExist(true);    acroForm.setAppendOnly(true);    boolean checkFields = checkSignatureField(acroForm.getFieldIterator(), signatureField);    if (checkFields) {        signatureField.getCOSObject().setNeedToBeUpdated(true);    } else {        acroFormFields.add(signatureField);    }        COSDocument visualSignature = options.getVisualSignature();        if (visualSignature == null) {        prepareNonVisibleSignature(signatureField);        return;    }    prepareVisibleSignature(signatureField, acroForm, visualSignature);        List<PDAnnotation> annotations = page.getAnnotations();                page.setAnnotations(annotations);        if (!(annotations instanceof COSArrayList && acroFormFields instanceof COSArrayList && ((COSArrayList<?>) annotations).toList().equals(((COSArrayList<?>) acroFormFields).toList()) && checkFields)) {        PDAnnotationWidget widget = signatureField.getWidgets().get(0);                if (checkSignatureAnnotation(annotations, widget)) {            widget.getCOSObject().setNeedToBeUpdated(true);        } else {            annotations.add(widget);        }    }    page.getCOSObject().setNeedToBeUpdated(true);}
private PDSignatureField pdfbox_f7149_0(Iterator<PDField> fieldIterator, PDSignature sigObject)
{    PDSignatureField signatureField = null;    while (fieldIterator.hasNext()) {        PDField pdField = fieldIterator.next();        if (pdField instanceof PDSignatureField) {            PDSignature signature = ((PDSignatureField) pdField).getSignature();            if (signature != null && signature.getCOSObject().equals(sigObject.getCOSObject())) {                signatureField = (PDSignatureField) pdField;            }        }    }    return signatureField;}
private boolean pdfbox_f7150_0(Iterator<PDField> fieldIterator, PDSignatureField signatureField)
{    while (fieldIterator.hasNext()) {        PDField field = fieldIterator.next();        if (field instanceof PDSignatureField && field.getCOSObject().equals(signatureField.getCOSObject())) {            return true;        }    }    return false;}
private boolean pdfbox_f7151_0(List<PDAnnotation> annotations, PDAnnotationWidget widget)
{    for (PDAnnotation annotation : annotations) {        if (annotation.getCOSObject().equals(widget.getCOSObject())) {            return true;        }    }    return false;}
private void pdfbox_f7152_0(PDSignatureField signatureField, PDAcroForm acroForm, COSDocument visualSignature)
{        boolean annotNotFound = true;    boolean sigFieldNotFound = true;    for (COSObject cosObject : visualSignature.getObjects()) {        if (!annotNotFound && !sigFieldNotFound) {            break;        }        COSBase base = cosObject.getObject();        if (base instanceof COSDictionary) {            COSDictionary cosBaseDict = (COSDictionary) base;                        COSBase type = cosBaseDict.getDictionaryObject(COSName.TYPE);            if (annotNotFound && COSName.ANNOT.equals(type)) {                assignSignatureRectangle(signatureField, cosBaseDict);                annotNotFound = false;            }                        COSBase fieldType = cosBaseDict.getDictionaryObject(COSName.FT);            COSBase apDict = cosBaseDict.getDictionaryObject(COSName.AP);            if (sigFieldNotFound && COSName.SIG.equals(fieldType) && apDict instanceof COSDictionary) {                assignAppearanceDictionary(signatureField, (COSDictionary) apDict);                assignAcroFormDefaultResource(acroForm, cosBaseDict);                sigFieldNotFound = false;            }        }    }    if (annotNotFound || sigFieldNotFound) {        throw new IllegalArgumentException("Template is missing required objects");    }}
private void pdfbox_f7153_0(PDSignatureField signatureField, COSDictionary annotDict)
{        COSArray rectArray = (COSArray) annotDict.getDictionaryObject(COSName.RECT);    PDRectangle rect = new PDRectangle(rectArray);    PDRectangle existingRectangle = signatureField.getWidgets().get(0).getRectangle();        if (existingRectangle == null || existingRectangle.getCOSArray().size() != 4) {        signatureField.getWidgets().get(0).setRectangle(rect);    }}
private void pdfbox_f7154_0(PDSignatureField signatureField, COSDictionary apDict)
{        PDAppearanceDictionary ap = new PDAppearanceDictionary(apDict);    apDict.setDirect(true);    signatureField.getWidgets().get(0).setAppearance(ap);}
private void pdfbox_f7155_0(PDAcroForm acroForm, COSDictionary newDict)
{        COSBase newBase = newDict.getDictionaryObject(COSName.DR);    if (newBase instanceof COSDictionary) {        COSDictionary newDR = (COSDictionary) newBase;        PDResources defaultResources = acroForm.getDefaultResources();        if (defaultResources == null) {            acroForm.getCOSObject().setItem(COSName.DR, newDR);            newDR.setDirect(true);            newDR.setNeedToBeUpdated(true);        } else {            COSDictionary oldDR = defaultResources.getCOSObject();            COSBase newXObjectBase = newDR.getItem(COSName.XOBJECT);            COSBase oldXObjectBase = oldDR.getItem(COSName.XOBJECT);            if (newXObjectBase instanceof COSDictionary && oldXObjectBase instanceof COSDictionary) {                ((COSDictionary) oldXObjectBase).addAll((COSDictionary) newXObjectBase);                oldDR.setNeedToBeUpdated(true);            }        }    }}
private void pdfbox_f7156_0(PDSignatureField signatureField)
{                signatureField.getWidgets().get(0).setRectangle(new PDRectangle());}
public void pdfbox_f7157_0(PDPage page)
{    getPages().remove(page);}
public void pdfbox_f7158_0(int pageNumber)
{    getPages().remove(pageNumber);}
public PDPage pdfbox_f7159_1(PDPage page) throws IOException
{    PDPage importedPage = new PDPage(new COSDictionary(page.getCOSObject()), resourceCache);    PDStream dest = new PDStream(this, page.getContents(), COSName.FLATE_DECODE);    importedPage.setContents(dest);    addPage(importedPage);    importedPage.setCropBox(page.getCropBox());    importedPage.setMediaBox(page.getMediaBox());    importedPage.setRotation(page.getRotation());    if (page.getResources() != null && !page.getCOSObject().containsKey(COSName.RESOURCES)) {                    }    return importedPage;}
public COSDocument pdfbox_f7160_0()
{    return document;}
public PDDocumentInformation pdfbox_f7161_0()
{    if (documentInformation == null) {        COSDictionary trailer = document.getTrailer();        COSDictionary infoDic = trailer.getCOSDictionary(COSName.INFO);        if (infoDic == null) {            infoDic = new COSDictionary();            trailer.setItem(COSName.INFO, infoDic);        }        documentInformation = new PDDocumentInformation(infoDic);    }    return documentInformation;}
public void pdfbox_f7162_0(PDDocumentInformation info)
{    documentInformation = info;    document.getTrailer().setItem(COSName.INFO, info.getCOSObject());}
public PDDocumentCatalog pdfbox_f7163_0()
{    if (documentCatalog == null) {        COSDictionary trailer = document.getTrailer();        COSBase dictionary = trailer.getDictionaryObject(COSName.ROOT);        if (dictionary instanceof COSDictionary) {            documentCatalog = new PDDocumentCatalog(this, (COSDictionary) dictionary);        } else {            documentCatalog = new PDDocumentCatalog(this);        }    }    return documentCatalog;}
public boolean pdfbox_f7164_0()
{    return document.isEncrypted();}
public PDEncryption pdfbox_f7165_0()
{    if (encryption == null && isEncrypted()) {        encryption = new PDEncryption(document.getEncryptionDictionary());    }    return encryption;}
public void pdfbox_f7166_0(PDEncryption encryption)
{    this.encryption = encryption;}
public PDSignature pdfbox_f7167_0()
{    List<PDSignature> signatureDictionaries = getSignatureDictionaries();    int size = signatureDictionaries.size();    if (size > 0) {        return signatureDictionaries.get(size - 1);    }    return null;}
public List<PDSignatureField> pdfbox_f7168_0()
{    List<PDSignatureField> fields = new ArrayList<>();    PDAcroForm acroForm = getDocumentCatalog().getAcroForm();    if (acroForm != null) {        for (PDField field : acroForm.getFieldTree()) {            if (field instanceof PDSignatureField) {                fields.add((PDSignatureField) field);            }        }    }    return fields;}
public List<PDSignature> pdfbox_f7169_0()
{    List<PDSignature> signatures = new ArrayList<>();    for (PDSignatureField field : getSignatureFields()) {        COSBase value = field.getCOSObject().getDictionaryObject(COSName.V);        if (value instanceof COSDictionary) {            signatures.add(new PDSignature((COSDictionary) value));        }    }    return signatures;}
public void pdfbox_f7170_0(TrueTypeFont ttf)
{    fontsToClose.add(ttf);}
 Set<PDFont> pdfbox_f7171_0()
{    return fontsToSubset;}
public static PDDocument pdfbox_f7172_0(File file) throws IOException
{    return load(file, "", MemoryUsageSetting.setupMainMemoryOnly());}
public static PDDocument pdfbox_f7173_0(File file, MemoryUsageSetting memUsageSetting) throws IOException
{    return load(file, "", null, null, memUsageSetting);}
public static PDDocument pdfbox_f7174_0(File file, String password) throws IOException
{    return load(file, password, null, null, MemoryUsageSetting.setupMainMemoryOnly());}
public static PDDocument pdfbox_f7175_0(File file, String password, MemoryUsageSetting memUsageSetting) throws IOException
{    return load(file, password, null, null, memUsageSetting);}
public static PDDocument pdfbox_f7176_0(File file, String password, InputStream keyStore, String alias) throws IOException
{    return load(file, password, keyStore, alias, MemoryUsageSetting.setupMainMemoryOnly());}
public static PDDocument pdfbox_f7177_0(File file, String password, InputStream keyStore, String alias, MemoryUsageSetting memUsageSetting) throws IOException
{        @SuppressWarnings({ "squid:S2095" })    RandomAccessBufferedFileInputStream raFile = new RandomAccessBufferedFileInputStream(file);    try {        return load(raFile, password, keyStore, alias, memUsageSetting);    } catch (IOException ioe) {        IOUtils.closeQuietly(raFile);        throw ioe;    }}
private static PDDocument pdfbox_f7178_0(RandomAccessBufferedFileInputStream raFile, String password, InputStream keyStore, String alias, MemoryUsageSetting memUsageSetting) throws IOException
{    ScratchFile scratchFile = new ScratchFile(memUsageSetting);    try {        PDFParser parser = new PDFParser(raFile, password, keyStore, alias, scratchFile);        parser.parse();        return parser.getPDDocument();    } catch (IOException ioe) {        IOUtils.closeQuietly(scratchFile);        throw ioe;    }}
public static PDDocument pdfbox_f7179_0(InputStream input) throws IOException
{    return load(input, "", null, null, MemoryUsageSetting.setupMainMemoryOnly());}
public static PDDocument pdfbox_f7180_0(InputStream input, MemoryUsageSetting memUsageSetting) throws IOException
{    return load(input, "", null, null, memUsageSetting);}
public static PDDocument pdfbox_f7181_0(InputStream input, String password) throws IOException
{    return load(input, password, null, null, MemoryUsageSetting.setupMainMemoryOnly());}
public static PDDocument pdfbox_f7182_0(InputStream input, String password, InputStream keyStore, String alias) throws IOException
{    return load(input, password, keyStore, alias, MemoryUsageSetting.setupMainMemoryOnly());}
public static PDDocument pdfbox_f7183_0(InputStream input, String password, MemoryUsageSetting memUsageSetting) throws IOException
{    return load(input, password, null, null, memUsageSetting);}
public static PDDocument pdfbox_f7184_0(InputStream input, String password, InputStream keyStore, String alias, MemoryUsageSetting memUsageSetting) throws IOException
{    ScratchFile scratchFile = new ScratchFile(memUsageSetting);    try {        RandomAccessRead source = scratchFile.createBuffer(input);        PDFParser parser = new PDFParser(source, password, keyStore, alias, scratchFile);        parser.parse();        return parser.getPDDocument();    } catch (IOException ioe) {        IOUtils.closeQuietly(scratchFile);        throw ioe;    }}
public static PDDocument pdfbox_f7185_0(byte[] input) throws IOException
{    return load(input, "");}
public static PDDocument pdfbox_f7186_0(byte[] input, String password) throws IOException
{    return load(input, password, null, null);}
public static PDDocument pdfbox_f7187_0(byte[] input, String password, InputStream keyStore, String alias) throws IOException
{    return load(input, password, keyStore, alias, MemoryUsageSetting.setupMainMemoryOnly());}
public static PDDocument pdfbox_f7188_0(byte[] input, String password, InputStream keyStore, String alias, MemoryUsageSetting memUsageSetting) throws IOException
{    ScratchFile scratchFile = new ScratchFile(memUsageSetting);    RandomAccessRead source = new RandomAccessBuffer(input);    PDFParser parser = new PDFParser(source, password, keyStore, alias, scratchFile);    parser.parse();    return parser.getPDDocument();}
public void pdfbox_f7189_0(String fileName) throws IOException
{    save(new File(fileName));}
public void pdfbox_f7190_0(File file) throws IOException
{    save(new BufferedOutputStream(new FileOutputStream(file)));}
public void pdfbox_f7191_0(OutputStream output) throws IOException
{    if (document.isClosed()) {        throw new IOException("Cannot save a document which has been closed");    }        for (PDFont font : fontsToSubset) {        font.subset();    }    fontsToSubset.clear();        try (COSWriter writer = new COSWriter(output)) {        writer.write(this);    }}
public void pdfbox_f7192_0(OutputStream output) throws IOException
{    if (pdfSource == null) {        throw new IllegalStateException("document was not loaded from a file or a stream");    }    try (COSWriter writer = new COSWriter(output, pdfSource)) {        writer.write(this, signInterface);    }}
public ExternalSigningSupport pdfbox_f7193_0(OutputStream output) throws IOException
{    if (pdfSource == null) {        throw new IllegalStateException("document was not loaded from a file or a stream");    }            PDSignature foundSignature = null;    for (PDSignature sig : getSignatureDictionaries()) {        foundSignature = sig;        if (sig.getCOSObject().isNeedToBeUpdated()) {            break;        }    }    if (foundSignature == null) {        throw new IllegalStateException("document does not contain signature fields");    }    int[] byteRange = foundSignature.getByteRange();    if (!Arrays.equals(byteRange, RESERVE_BYTE_RANGE)) {        throw new IllegalStateException("signature reserve byte range has been changed " + "after addSignature(), please set the byte range that existed after addSignature()");    }    COSWriter writer = new COSWriter(output, pdfSource);    writer.write(this);    signingSupport = new SigningSupport(writer);    return signingSupport;}
public PDPage pdfbox_f7194_0(int pageIndex)
{    return getDocumentCatalog().getPages().get(pageIndex);}
public PDPageTree pdfbox_f7195_0()
{    return getDocumentCatalog().getPages();}
public int pdfbox_f7196_0()
{    return getDocumentCatalog().getPages().getCount();}
public void pdfbox_f7197_0() throws IOException
{    if (!document.isClosed()) {                                        IOException firstException = null;                if (signingSupport != null) {            firstException = IOUtils.closeAndLogException(signingSupport, LOG, "SigningSupport", firstException);        }                firstException = IOUtils.closeAndLogException(document, LOG, "COSDocument", firstException);                if (pdfSource != null) {            firstException = IOUtils.closeAndLogException(pdfSource, LOG, "RandomAccessRead pdfSource", firstException);        }                for (TrueTypeFont ttf : fontsToClose) {            firstException = IOUtils.closeAndLogException(ttf, LOG, "TrueTypeFont", firstException);        }                if (firstException != null) {            throw firstException;        }    }}
public void pdfbox_f7198_1(ProtectionPolicy policy) throws IOException
{    if (isAllSecurityToBeRemoved()) {                setAllSecurityToBeRemoved(false);    }    if (!isEncrypted()) {        encryption = new PDEncryption();    }    SecurityHandler securityHandler = SecurityHandlerFactory.INSTANCE.newSecurityHandlerForPolicy(policy);    if (securityHandler == null) {        throw new IOException("No security handler for policy " + policy);    }    getEncryption().setSecurityHandler(securityHandler);}
public AccessPermission pdfbox_f7199_0()
{    if (accessPermission == null) {        accessPermission = AccessPermission.getOwnerAccessPermission();    }    return accessPermission;}
public boolean pdfbox_f7200_0()
{    return allSecurityToBeRemoved;}
public void pdfbox_f7201_0(boolean removeAllSecurity)
{    allSecurityToBeRemoved = removeAllSecurity;}
public Long pdfbox_f7202_0()
{    return documentId;}
public void pdfbox_f7203_0(Long docId)
{    documentId = docId;}
public float pdfbox_f7204_1()
{    float headerVersionFloat = getDocument().getVersion();        if (headerVersionFloat >= 1.4f) {        String catalogVersion = getDocumentCatalog().getVersion();        float catalogVersionFloat = -1;        if (catalogVersion != null) {            try {                catalogVersionFloat = Float.parseFloat(catalogVersion);            } catch (NumberFormatException exception) {                            }        }                return Math.max(catalogVersionFloat, headerVersionFloat);    } else {        return headerVersionFloat;    }}
public void pdfbox_f7205_1(float newVersion)
{    float currentVersion = getVersion();        if (Float.compare(newVersion, currentVersion) == 0) {        return;    }        if (newVersion < currentVersion) {                return;    }        if (getDocument().getVersion() >= 1.4f) {        getDocumentCatalog().setVersion(Float.toString(newVersion));    } else {                getDocument().setVersion(newVersion);    }}
public ResourceCache pdfbox_f7206_0()
{    return resourceCache;}
public void pdfbox_f7207_0(ResourceCache resourceCache)
{    this.resourceCache = resourceCache;}
public COSDictionary pdfbox_f7208_0()
{    return root;}
public PDAcroForm pdfbox_f7209_0()
{    if (cachedAcroForm == null) {        COSDictionary dict = (COSDictionary) root.getDictionaryObject(COSName.ACRO_FORM);        cachedAcroForm = dict == null ? null : new PDAcroForm(document, dict);    }    return cachedAcroForm;}
public void pdfbox_f7210_0(PDAcroForm acroForm)
{    root.setItem(COSName.ACRO_FORM, acroForm);    cachedAcroForm = null;}
public PDPageTree pdfbox_f7211_0()
{        return new PDPageTree((COSDictionary) root.getDictionaryObject(COSName.PAGES), document);}
public PDViewerPreferences pdfbox_f7212_0()
{    COSBase base = root.getDictionaryObject(COSName.VIEWER_PREFERENCES);    return base instanceof COSDictionary ? new PDViewerPreferences((COSDictionary) base) : null;}
public void pdfbox_f7213_0(PDViewerPreferences prefs)
{    root.setItem(COSName.VIEWER_PREFERENCES, prefs);}
public PDDocumentOutline pdfbox_f7214_0()
{    COSBase cosObj = root.getDictionaryObject(COSName.OUTLINES);    return cosObj instanceof COSDictionary ? new PDDocumentOutline((COSDictionary) cosObj) : null;}
public void pdfbox_f7215_0(PDDocumentOutline outlines)
{    root.setItem(COSName.OUTLINES, outlines);}
public List<PDThread> pdfbox_f7216_0()
{    COSArray array = (COSArray) root.getDictionaryObject(COSName.THREADS);    if (array == null) {        array = new COSArray();        root.setItem(COSName.THREADS, array);    }    List<PDThread> pdObjects = new ArrayList<>();    for (int i = 0; i < array.size(); i++) {        pdObjects.add(new PDThread((COSDictionary) array.getObject(i)));    }    return new COSArrayList<>(pdObjects, array);}
public void pdfbox_f7217_0(List<PDThread> threads)
{    root.setItem(COSName.THREADS, COSArrayList.converterToCOSArray(threads));}
public PDMetadata pdfbox_f7218_0()
{    COSBase metaObj = root.getDictionaryObject(COSName.METADATA);    if (metaObj instanceof COSStream) {        return new PDMetadata((COSStream) metaObj);    }    return null;}
public void pdfbox_f7219_0(PDMetadata meta)
{    root.setItem(COSName.METADATA, meta);}
public void pdfbox_f7220_0(PDDestinationOrAction action)
{    root.setItem(COSName.OPEN_ACTION, action);}
public PDDestinationOrAction pdfbox_f7221_0() throws IOException
{    COSBase openAction = root.getDictionaryObject(COSName.OPEN_ACTION);    if (openAction instanceof COSDictionary) {        return PDActionFactory.createAction((COSDictionary) openAction);    } else if (openAction instanceof COSArray) {        return PDDestination.create(openAction);    } else {        return null;    }}
public PDDocumentCatalogAdditionalActions pdfbox_f7222_0()
{    COSDictionary addAction = (COSDictionary) root.getDictionaryObject(COSName.AA);    if (addAction == null) {        addAction = new COSDictionary();        root.setItem(COSName.AA, addAction);    }    return new PDDocumentCatalogAdditionalActions(addAction);}
public void pdfbox_f7223_0(PDDocumentCatalogAdditionalActions actions)
{    root.setItem(COSName.AA, actions);}
public PDDocumentNameDictionary pdfbox_f7224_0()
{    COSDictionary names = (COSDictionary) root.getDictionaryObject(COSName.NAMES);    return names == null ? null : new PDDocumentNameDictionary(this, names);}
public PDDocumentNameDestinationDictionary pdfbox_f7225_0()
{    PDDocumentNameDestinationDictionary nameDic = null;    COSDictionary dests = (COSDictionary) root.getDictionaryObject(COSName.DESTS);    if (dests != null) {        nameDic = new PDDocumentNameDestinationDictionary(dests);    }    return nameDic;}
public PDPageDestination pdfbox_f7226_0(PDNamedDestination namedDest) throws IOException
{    PDPageDestination pageDestination = null;    PDDocumentNameDictionary namesDict = getNames();    if (namesDict != null) {        PDDestinationNameTreeNode destsTree = namesDict.getDests();        if (destsTree != null) {            pageDestination = destsTree.getValue(namedDest.getNamedDestination());        }    }    if (pageDestination == null) {                PDDocumentNameDestinationDictionary nameDestDict = getDests();        if (nameDestDict != null) {            String name = namedDest.getNamedDestination();            pageDestination = (PDPageDestination) nameDestDict.getDestination(name);        }    }    return pageDestination;}
public void pdfbox_f7227_0(PDDocumentNameDictionary names)
{    root.setItem(COSName.NAMES, names);}
public PDMarkInfo pdfbox_f7228_0()
{    COSDictionary dic = (COSDictionary) root.getDictionaryObject(COSName.MARK_INFO);    return dic == null ? null : new PDMarkInfo(dic);}
public void pdfbox_f7229_0(PDMarkInfo markInfo)
{    root.setItem(COSName.MARK_INFO, markInfo);}
public List<PDOutputIntent> pdfbox_f7230_0()
{    List<PDOutputIntent> retval = new ArrayList<>();    COSArray array = (COSArray) root.getDictionaryObject(COSName.OUTPUT_INTENTS);    if (array != null) {        for (COSBase cosBase : array) {            if (cosBase instanceof COSObject) {                cosBase = ((COSObject) cosBase).getObject();            }            PDOutputIntent oi = new PDOutputIntent((COSDictionary) cosBase);            retval.add(oi);        }    }    return retval;}
public void pdfbox_f7231_0(PDOutputIntent outputIntent)
{    COSArray array = (COSArray) root.getDictionaryObject(COSName.OUTPUT_INTENTS);    if (array == null) {        array = new COSArray();        root.setItem(COSName.OUTPUT_INTENTS, array);    }    array.add(outputIntent.getCOSObject());}
public void pdfbox_f7232_0(List<PDOutputIntent> outputIntents)
{    COSArray array = new COSArray();    for (PDOutputIntent intent : outputIntents) {        array.add(intent.getCOSObject());    }    root.setItem(COSName.OUTPUT_INTENTS, array);}
public PageMode pdfbox_f7233_1()
{    String mode = root.getNameAsString(COSName.PAGE_MODE);    if (mode != null) {        try {            return PageMode.fromString(mode);        } catch (IllegalArgumentException e) {                        return PageMode.USE_NONE;        }    } else {        return PageMode.USE_NONE;    }}
public void pdfbox_f7234_0(PageMode mode)
{    root.setName(COSName.PAGE_MODE, mode.stringValue());}
public PageLayout pdfbox_f7235_0()
{    String mode = root.getNameAsString(COSName.PAGE_LAYOUT);    if (mode != null) {        return PageLayout.fromString(mode);    } else {        return PageLayout.SINGLE_PAGE;    }}
public void pdfbox_f7236_0(PageLayout layout)
{    root.setName(COSName.PAGE_LAYOUT, layout.stringValue());}
public PDURIDictionary pdfbox_f7237_0()
{    COSDictionary uri = (COSDictionary) root.getDictionaryObject(COSName.URI);    return uri == null ? null : new PDURIDictionary(uri);}
public void pdfbox_f7238_0(PDURIDictionary uri)
{    root.setItem(COSName.URI, uri);}
public PDStructureTreeRoot pdfbox_f7239_0()
{    COSDictionary dict = root.getCOSDictionary(COSName.STRUCT_TREE_ROOT);    return dict == null ? null : new PDStructureTreeRoot(dict);}
public void pdfbox_f7240_0(PDStructureTreeRoot treeRoot)
{    root.setItem(COSName.STRUCT_TREE_ROOT, treeRoot);}
public String pdfbox_f7241_0()
{    return root.getString(COSName.LANG);}
public void pdfbox_f7242_0(String language)
{    root.setString(COSName.LANG, language);}
public String pdfbox_f7243_0()
{    return root.getNameAsString(COSName.VERSION);}
public void pdfbox_f7244_0(String version)
{    root.setName(COSName.VERSION, version);}
public PDPageLabels pdfbox_f7245_0() throws IOException
{    COSDictionary dict = (COSDictionary) root.getDictionaryObject(COSName.PAGE_LABELS);    return dict == null ? null : new PDPageLabels(document, dict);}
public void pdfbox_f7246_0(PDPageLabels labels)
{    root.setItem(COSName.PAGE_LABELS, labels);}
public PDOptionalContentProperties pdfbox_f7247_0()
{    COSDictionary dict = (COSDictionary) root.getDictionaryObject(COSName.OCPROPERTIES);    return dict == null ? null : new PDOptionalContentProperties(dict);}
public void pdfbox_f7248_0(PDOptionalContentProperties ocProperties)
{    root.setItem(COSName.OCPROPERTIES, ocProperties);        if (ocProperties != null && document.getVersion() < 1.5) {        document.setVersion(1.5f);    }}
public COSDictionary pdfbox_f7249_0()
{    return info;}
public Object pdfbox_f7250_0(String propertyKey)
{    return info.getString(propertyKey);}
public String pdfbox_f7251_0()
{    return info.getString(COSName.TITLE);}
public void pdfbox_f7252_0(String title)
{    info.setString(COSName.TITLE, title);}
public String pdfbox_f7253_0()
{    return info.getString(COSName.AUTHOR);}
public void pdfbox_f7254_0(String author)
{    info.setString(COSName.AUTHOR, author);}
public String pdfbox_f7255_0()
{    return info.getString(COSName.SUBJECT);}
public void pdfbox_f7256_0(String subject)
{    info.setString(COSName.SUBJECT, subject);}
public String pdfbox_f7257_0()
{    return info.getString(COSName.KEYWORDS);}
public void pdfbox_f7258_0(String keywords)
{    info.setString(COSName.KEYWORDS, keywords);}
public String pdfbox_f7259_0()
{    return info.getString(COSName.CREATOR);}
public void pdfbox_f7260_0(String creator)
{    info.setString(COSName.CREATOR, creator);}
public String pdfbox_f7261_0()
{    return info.getString(COSName.PRODUCER);}
public void pdfbox_f7262_0(String producer)
{    info.setString(COSName.PRODUCER, producer);}
public Calendar pdfbox_f7263_0()
{    return info.getDate(COSName.CREATION_DATE);}
public void pdfbox_f7264_0(Calendar date)
{    info.setDate(COSName.CREATION_DATE, date);}
public Calendar pdfbox_f7265_0()
{    return info.getDate(COSName.MOD_DATE);}
public void pdfbox_f7266_0(Calendar date)
{    info.setDate(COSName.MOD_DATE, date);}
public String pdfbox_f7267_0()
{    return info.getNameAsString(COSName.TRAPPED);}
public Set<String> pdfbox_f7268_0()
{    Set<String> keys = new TreeSet<>();    for (COSName key : info.keySet()) {        keys.add(key.getName());    }    return keys;}
public String pdfbox_f7269_0(String fieldName)
{    return info.getString(fieldName);}
public void pdfbox_f7270_0(String fieldName, String fieldValue)
{    info.setString(fieldName, fieldValue);}
public void pdfbox_f7271_0(String value)
{    if (value != null && !value.equals("True") && !value.equals("False") && !value.equals("Unknown")) {        throw new RuntimeException("Valid values for trapped are " + "'True', 'False', or 'Unknown'");    }    info.setName(COSName.TRAPPED, value);}
public COSDictionary pdfbox_f7272_0()
{    return nameDictionary;}
public PDDestination pdfbox_f7273_0(String name) throws IOException
{    COSBase item = nameDictionary.getDictionaryObject(name);        if (item instanceof COSArray) {        return PDDestination.create(item);    } else if (item instanceof COSDictionary) {        COSDictionary dict = (COSDictionary) item;        if (dict.containsKey(COSName.D)) {            return PDDestination.create(dict.getDictionaryObject(COSName.D));        }    }    return null;}
public COSDictionary pdfbox_f7274_0()
{    return nameDictionary;}
public PDDestinationNameTreeNode pdfbox_f7275_0()
{    PDDestinationNameTreeNode dests = null;    COSDictionary dic = (COSDictionary) nameDictionary.getDictionaryObject(COSName.DESTS);        if (dic == null) {        dic = (COSDictionary) catalog.getCOSObject().getDictionaryObject(COSName.DESTS);    }    if (dic != null) {        dests = new PDDestinationNameTreeNode(dic);    }    return dests;}
public void pdfbox_f7276_0(PDDestinationNameTreeNode dests)
{    nameDictionary.setItem(COSName.DESTS, dests);                        catalog.getCOSObject().setItem(COSName.DESTS, (COSObjectable) null);}
public PDEmbeddedFilesNameTreeNode pdfbox_f7277_0()
{    PDEmbeddedFilesNameTreeNode retval = null;    COSDictionary dic = (COSDictionary) nameDictionary.getDictionaryObject(COSName.EMBEDDED_FILES);    if (dic != null) {        retval = new PDEmbeddedFilesNameTreeNode(dic);    }    return retval;}
public void pdfbox_f7278_0(PDEmbeddedFilesNameTreeNode ef)
{    nameDictionary.setItem(COSName.EMBEDDED_FILES, ef);}
public PDJavascriptNameTreeNode pdfbox_f7279_0()
{    PDJavascriptNameTreeNode retval = null;    COSDictionary dic = (COSDictionary) nameDictionary.getDictionaryObject(COSName.JAVA_SCRIPT);    if (dic != null) {        retval = new PDJavascriptNameTreeNode(dic);    }    return retval;}
public void pdfbox_f7280_0(PDJavascriptNameTreeNode js)
{    nameDictionary.setItem(COSName.JAVA_SCRIPT, js);}
protected PDComplexFileSpecification pdfbox_f7281_0(COSBase base) throws IOException
{    return new PDComplexFileSpecification((COSDictionary) base);}
protected PDNameTreeNode<PDComplexFileSpecification> pdfbox_f7282_0(COSDictionary dic)
{    return new PDEmbeddedFilesNameTreeNode(dic);}
protected PDActionJavaScript pdfbox_f7283_0(COSBase base) throws IOException
{    if (!(base instanceof COSDictionary)) {        throw new IOException("Error creating Javascript object, expected a COSDictionary and not " + base);    }    return (PDActionJavaScript) PDActionFactory.createAction((COSDictionary) base);}
protected PDNameTreeNode<PDActionJavaScript> pdfbox_f7284_0(COSDictionary dic)
{    return new PDJavascriptNameTreeNode(dic);}
public COSDictionary pdfbox_f7285_0()
{    return page;}
public Iterator<PDStream> pdfbox_f7286_0()
{    List<PDStream> streams = new ArrayList<>();    COSBase base = page.getDictionaryObject(COSName.CONTENTS);    if (base instanceof COSStream) {        streams.add(new PDStream((COSStream) base));    } else if (base instanceof COSArray && ((COSArray) base).size() > 0) {        COSArray array = (COSArray) base;        for (int i = 0; i < array.size(); i++) {            COSStream stream = (COSStream) array.getObject(i);            streams.add(new PDStream(stream));        }    }    return streams.iterator();}
public InputStream pdfbox_f7287_0() throws IOException
{    COSBase base = page.getDictionaryObject(COSName.CONTENTS);    if (base instanceof COSStream) {        return ((COSStream) base).createInputStream();    } else if (base instanceof COSArray && ((COSArray) base).size() > 0) {        COSArray streams = (COSArray) base;        byte[] delimiter = new byte[] { '\n' };        List<InputStream> inputStreams = new ArrayList<>();        for (int i = 0; i < streams.size(); i++) {            COSBase strm = streams.getObject(i);            if (strm instanceof COSStream) {                COSStream stream = (COSStream) strm;                inputStreams.add(stream.createInputStream());                inputStreams.add(new ByteArrayInputStream(delimiter));            }        }        return new SequenceInputStream(Collections.enumeration(inputStreams));    }    return new ByteArrayInputStream(new byte[0]);}
public boolean pdfbox_f7288_0()
{    COSBase contents = page.getDictionaryObject(COSName.CONTENTS);    if (contents instanceof COSStream) {        return ((COSStream) contents).size() > 0;    } else if (contents instanceof COSArray) {        return ((COSArray) contents).size() > 0;    }    return false;}
public PDResources pdfbox_f7289_0()
{    if (pageResources == null) {        COSBase base = PDPageTree.getInheritableAttribute(page, COSName.RESOURCES);                if (base instanceof COSDictionary) {            pageResources = new PDResources((COSDictionary) base, resourceCache);        }    }    return pageResources;}
public void pdfbox_f7290_0(PDResources resources)
{    pageResources = resources;    if (resources != null) {        page.setItem(COSName.RESOURCES, resources);    } else {        page.removeItem(COSName.RESOURCES);    }}
public int pdfbox_f7291_0()
{    return page.getInt(COSName.STRUCT_PARENTS);}
public void pdfbox_f7292_0(int structParents)
{    page.setInt(COSName.STRUCT_PARENTS, structParents);}
public PDRectangle pdfbox_f7293_0()
{    return getCropBox();}
public Matrix pdfbox_f7294_0()
{        return new Matrix();}
public PDRectangle pdfbox_f7295_1()
{    if (mediaBox == null) {        COSBase base = PDPageTree.getInheritableAttribute(page, COSName.MEDIA_BOX);        if (base instanceof COSArray) {            mediaBox = new PDRectangle((COSArray) base);        }    }    if (mediaBox == null) {                mediaBox = PDRectangle.LETTER;    }    return mediaBox;}
public void pdfbox_f7296_0(PDRectangle mediaBox)
{    this.mediaBox = mediaBox;    if (mediaBox == null) {        page.removeItem(COSName.MEDIA_BOX);    } else {        page.setItem(COSName.MEDIA_BOX, mediaBox);    }}
public PDRectangle pdfbox_f7297_0()
{    COSBase base = PDPageTree.getInheritableAttribute(page, COSName.CROP_BOX);    if (base instanceof COSArray) {        return clipToMediaBox(new PDRectangle((COSArray) base));    } else {        return getMediaBox();    }}
public void pdfbox_f7298_0(PDRectangle cropBox)
{    if (cropBox == null) {        page.removeItem(COSName.CROP_BOX);    } else {        page.setItem(COSName.CROP_BOX, cropBox.getCOSArray());    }}
public PDRectangle pdfbox_f7299_0()
{    COSBase base = page.getDictionaryObject(COSName.BLEED_BOX);    if (base instanceof COSArray) {        return clipToMediaBox(new PDRectangle((COSArray) base));    } else {        return getCropBox();    }}
public void pdfbox_f7300_0(PDRectangle bleedBox)
{    if (bleedBox == null) {        page.removeItem(COSName.BLEED_BOX);    } else {        page.setItem(COSName.BLEED_BOX, bleedBox);    }}
public PDRectangle pdfbox_f7301_0()
{    COSBase base = page.getDictionaryObject(COSName.TRIM_BOX);    if (base instanceof COSArray) {        return clipToMediaBox(new PDRectangle((COSArray) base));    } else {        return getCropBox();    }}
public void pdfbox_f7302_0(PDRectangle trimBox)
{    if (trimBox == null) {        page.removeItem(COSName.TRIM_BOX);    } else {        page.setItem(COSName.TRIM_BOX, trimBox);    }}
public PDRectangle pdfbox_f7303_0()
{    COSBase base = page.getDictionaryObject(COSName.ART_BOX);    if (base instanceof COSArray) {        return clipToMediaBox(new PDRectangle((COSArray) base));    } else {        return getCropBox();    }}
public void pdfbox_f7304_0(PDRectangle artBox)
{    if (artBox == null) {        page.removeItem(COSName.ART_BOX);    } else {        page.setItem(COSName.ART_BOX, artBox);    }}
private PDRectangle pdfbox_f7305_0(PDRectangle box)
{    PDRectangle mediaBox = getMediaBox();    PDRectangle result = new PDRectangle();    result.setLowerLeftX(Math.max(mediaBox.getLowerLeftX(), box.getLowerLeftX()));    result.setLowerLeftY(Math.max(mediaBox.getLowerLeftY(), box.getLowerLeftY()));    result.setUpperRightX(Math.min(mediaBox.getUpperRightX(), box.getUpperRightX()));    result.setUpperRightY(Math.min(mediaBox.getUpperRightY(), box.getUpperRightY()));    return result;}
public int pdfbox_f7306_0()
{    COSBase obj = PDPageTree.getInheritableAttribute(page, COSName.ROTATE);    if (obj instanceof COSNumber) {        int rotationAngle = ((COSNumber) obj).intValue();        if (rotationAngle % 90 == 0) {            return (rotationAngle % 360 + 360) % 360;        }    }    return 0;}
public void pdfbox_f7307_0(int rotation)
{    page.setInt(COSName.ROTATE, rotation);}
public void pdfbox_f7308_0(PDStream contents)
{    page.setItem(COSName.CONTENTS, contents);}
public void pdfbox_f7309_0(List<PDStream> contents)
{    COSArray array = new COSArray();    contents.forEach(array::add);    page.setItem(COSName.CONTENTS, array);}
public List<PDThreadBead> pdfbox_f7310_0()
{    COSArray beads = (COSArray) page.getDictionaryObject(COSName.B);    if (beads == null) {        beads = new COSArray();    }    List<PDThreadBead> pdObjects = new ArrayList<>();    for (int i = 0; i < beads.size(); i++) {        COSBase base = beads.getObject(i);        PDThreadBead bead = null;                if (base instanceof COSDictionary) {            bead = new PDThreadBead((COSDictionary) base);        }        pdObjects.add(bead);    }    return new COSArrayList<>(pdObjects, beads);}
public void pdfbox_f7311_0(List<PDThreadBead> beads)
{    page.setItem(COSName.B, COSArrayList.converterToCOSArray(beads));}
public PDMetadata pdfbox_f7312_0()
{    PDMetadata retval = null;    COSBase base = page.getDictionaryObject(COSName.METADATA);    if (base instanceof COSStream) {        retval = new PDMetadata((COSStream) base);    }    return retval;}
public void pdfbox_f7313_0(PDMetadata meta)
{    page.setItem(COSName.METADATA, meta);}
public PDPageAdditionalActions pdfbox_f7314_0()
{    COSDictionary addAct;    COSBase base = page.getDictionaryObject(COSName.AA);    if (base instanceof COSDictionary) {        addAct = (COSDictionary) base;    } else {        addAct = new COSDictionary();        page.setItem(COSName.AA, addAct);    }    return new PDPageAdditionalActions(addAct);}
public void pdfbox_f7315_0(PDPageAdditionalActions actions)
{    page.setItem(COSName.AA, actions);}
public PDTransition pdfbox_f7316_0()
{    COSBase base = page.getDictionaryObject(COSName.TRANS);    return base instanceof COSDictionary ? new PDTransition((COSDictionary) base) : null;}
public void pdfbox_f7317_0(PDTransition transition)
{    page.setItem(COSName.TRANS, transition);}
public void pdfbox_f7318_0(PDTransition transition, float duration)
{    page.setItem(COSName.TRANS, transition);    page.setItem(COSName.DUR, new COSFloat(duration));}
public List<PDAnnotation> pdfbox_f7319_0() throws IOException
{    return getAnnotations(annotation -> true);}
public List<PDAnnotation> pdfbox_f7320_0(AnnotationFilter annotationFilter) throws IOException
{    COSBase base = page.getDictionaryObject(COSName.ANNOTS);    if (base instanceof COSArray) {        COSArray annots = (COSArray) base;        List<PDAnnotation> actuals = new ArrayList<>();        for (int i = 0; i < annots.size(); i++) {            COSBase item = annots.getObject(i);            if (item == null) {                continue;            }            PDAnnotation createdAnnotation = PDAnnotation.createAnnotation(item);            if (annotationFilter.accept(createdAnnotation)) {                actuals.add(createdAnnotation);            }        }        return new COSArrayList<>(actuals, annots);    }    return new COSArrayList<>(page, COSName.ANNOTS);}
public void pdfbox_f7321_0(List<PDAnnotation> annotations)
{    page.setItem(COSName.ANNOTS, COSArrayList.converterToCOSArray(annotations));}
public boolean pdfbox_f7322_0(Object other)
{    return other instanceof PDPage && ((PDPage) other).getCOSObject() == this.getCOSObject();}
public int pdfbox_f7323_0()
{    return page.hashCode();}
public ResourceCache pdfbox_f7324_0()
{    return resourceCache;}
public List<PDViewportDictionary> pdfbox_f7325_1()
{    COSBase base = page.getDictionaryObject(COSName.VP);    if (!(base instanceof COSArray)) {        return null;    }    COSArray array = (COSArray) base;    List<PDViewportDictionary> viewports = new ArrayList<>();    for (int i = 0; i < array.size(); ++i) {        COSBase base2 = array.getObject(i);        if (base2 instanceof COSDictionary) {            viewports.add(new PDViewportDictionary((COSDictionary) base2));        } else {                    }    }    return viewports;}
public void pdfbox_f7326_0(List<PDViewportDictionary> viewports)
{    if (viewports == null) {        page.removeItem(COSName.VP);        return;    }    COSArray array = new COSArray();    viewports.forEach(array::add);    page.setItem(COSName.VP, array);}
public boolean pdfbox_f7327_0()
{    return this == OVERWRITE;}
public boolean pdfbox_f7328_0()
{    return this == PREPEND;}
public void pdfbox_f7329_0(String text) throws IOException
{    showText(text);}
public void pdfbox_f7330_0(float tx, float ty) throws IOException
{    newLineAtOffset(tx, ty);}
public void pdfbox_f7331_0(double a, double b, double c, double d, double e, double f) throws IOException
{    setTextMatrix(new Matrix((float) a, (float) b, (float) c, (float) d, (float) e, (float) f));}
public void pdfbox_f7332_0(AffineTransform matrix) throws IOException
{    setTextMatrix(new Matrix(matrix));}
public void pdfbox_f7333_0(double sx, double sy, double tx, double ty) throws IOException
{    setTextMatrix(new Matrix((float) sx, 0f, 0f, (float) sy, (float) tx, (float) ty));}
public void pdfbox_f7334_0(double tx, double ty) throws IOException
{    setTextMatrix(Matrix.getTranslateInstance((float) tx, (float) ty));}
public void pdfbox_f7335_0(double angle, double tx, double ty) throws IOException
{    setTextMatrix(Matrix.getRotateInstance(angle, (float) tx, (float) ty));}
public void pdfbox_f7336_0(PDInlineImage inlineImage, float x, float y) throws IOException
{    drawImage(inlineImage, x, y, inlineImage.getWidth(), inlineImage.getHeight());}
public void pdfbox_f7337_0(PDInlineImage inlineImage, float x, float y, float width, float height) throws IOException
{    drawImage(inlineImage, x, y, width, height);}
public void pdfbox_f7338_0(PDXObject xobject, float x, float y, float width, float height) throws IOException
{    AffineTransform transform = new AffineTransform(width, 0, 0, height, x, y);    drawXObject(xobject, transform);}
public void pdfbox_f7339_0(PDXObject xobject, AffineTransform transform) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: drawXObject is not allowed within a text block.");    }    String xObjectPrefix;    if (xobject instanceof PDImageXObject) {        xObjectPrefix = "Im";    } else {        xObjectPrefix = "Form";    }    COSName objMapping = resources.add(xobject, xObjectPrefix);    saveGraphicsState();    transform(new Matrix(transform));    writeOperand(objMapping);    writeOperator(OperatorName.DRAW_OBJECT);    restoreGraphicsState();}
public void pdfbox_f7340_0(double a, double b, double c, double d, double e, double f) throws IOException
{    transform(new Matrix((float) a, (float) b, (float) c, (float) d, (float) e, (float) f));}
public void pdfbox_f7341_0(AffineTransform at) throws IOException
{    transform(new Matrix(at));}
public void pdfbox_f7342_0(PDColorSpace colorSpace) throws IOException
{    setStrokingColorSpaceStack(colorSpace);    writeOperand(getName(colorSpace));    writeOperator(OperatorName.STROKING_COLORSPACE);}
public void pdfbox_f7343_0(PDColorSpace colorSpace) throws IOException
{    setNonStrokingColorSpaceStack(colorSpace);    writeOperand(getName(colorSpace));    writeOperator(OperatorName.NON_STROKING_COLORSPACE);}
public void pdfbox_f7344_0(float[] components) throws IOException
{    if (strokingColorSpaceStack.isEmpty()) {        throw new IllegalStateException("The color space must be set before setting a color");    }    for (float component : components) {        writeOperand(component);    }    PDColorSpace currentStrokingColorSpace = strokingColorSpaceStack.peek();    if (currentStrokingColorSpace instanceof PDSeparation || currentStrokingColorSpace instanceof PDPattern || currentStrokingColorSpace instanceof PDICCBased) {        writeOperator(OperatorName.STROKING_COLOR_N);    } else {        writeOperator(OperatorName.STROKING_COLOR);    }}
public void pdfbox_f7345_0(int c, int m, int y, int k) throws IOException
{    if (isOutside255Interval(c) || isOutside255Interval(m) || isOutside255Interval(y) || isOutside255Interval(k)) {        throw new IllegalArgumentException("Parameters must be within 0..255, but are " + String.format("(%d,%d,%d,%d)", c, m, y, k));    }    setStrokingColor(c / 255f, m / 255f, y / 255f, k / 255f);}
public void pdfbox_f7346_0(int g) throws IOException
{    if (isOutside255Interval(g)) {        throw new IllegalArgumentException("Parameter must be within 0..255, but is " + g);    }    setStrokingColor(g / 255f);}
public void pdfbox_f7347_0(float[] components) throws IOException
{    if (nonStrokingColorSpaceStack.isEmpty()) {        throw new IllegalStateException("The color space must be set before setting a color");    }    for (float component : components) {        writeOperand(component);    }    PDColorSpace currentNonStrokingColorSpace = nonStrokingColorSpaceStack.peek();    if (currentNonStrokingColorSpace instanceof PDSeparation || currentNonStrokingColorSpace instanceof PDPattern || currentNonStrokingColorSpace instanceof PDICCBased) {        writeOperator(OperatorName.NON_STROKING_COLOR_N);    } else {        writeOperator(OperatorName.NON_STROKING_COLOR);    }}
public void pdfbox_f7348_0(float x, float y, float width, float height) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: fillRect is not allowed within a text block.");    }    addRect(x, y, width, height);    fill();}
public void pdfbox_f7349_0(float x1, float y1, float x2, float y2, float x3, float y3) throws IOException
{    curveTo(x1, y1, x2, y2, x3, y3);}
public void pdfbox_f7350_0(float x2, float y2, float x3, float y3) throws IOException
{    curveTo2(x2, y2, x3, y3);}
public void pdfbox_f7351_0(float x1, float y1, float x3, float y3) throws IOException
{    curveTo1(x1, y1, x3, y3);}
public void pdfbox_f7352_0(float xStart, float yStart, float xEnd, float yEnd) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: addLine is not allowed within a text block.");    }    moveTo(xStart, yStart);    lineTo(xEnd, yEnd);}
public void pdfbox_f7353_0(float xStart, float yStart, float xEnd, float yEnd) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: drawLine is not allowed within a text block.");    }    moveTo(xStart, yStart);    lineTo(xEnd, yEnd);    stroke();}
public void pdfbox_f7354_0(float[] x, float[] y) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: addPolygon is not allowed within a text block.");    }    if (x.length != y.length) {        throw new IllegalArgumentException("Error: some points are missing coordinate");    }    for (int i = 0; i < x.length; i++) {        if (i == 0) {            moveTo(x[i], y[i]);        } else {            lineTo(x[i], y[i]);        }    }    closeSubPath();}
public void pdfbox_f7355_0(float[] x, float[] y) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: drawPolygon is not allowed within a text block.");    }    addPolygon(x, y);    stroke();}
public void pdfbox_f7356_0(float[] x, float[] y) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: fillPolygon is not allowed within a text block.");    }    addPolygon(x, y);    fill();}
public void pdfbox_f7357_0(int windingRule) throws IOException
{    switch(windingRule) {        case PathIterator.WIND_NON_ZERO:            fill();            break;        case PathIterator.WIND_EVEN_ODD:            fillEvenOdd();            break;        default:            throw new IllegalArgumentException("Error: unknown value for winding rule");    }}
public void pdfbox_f7358_0() throws IOException
{    closePath();}
public void pdfbox_f7359_0(int windingRule) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: clipPath is not allowed within a text block.");    }    switch(windingRule) {        case PathIterator.WIND_NON_ZERO:            writeOperator(OperatorName.CLIP_NON_ZERO);            break;        case PathIterator.WIND_EVEN_ODD:            writeOperator(OperatorName.CLIP_EVEN_ODD);            break;        default:            throw new IllegalArgumentException("Error: unknown value for winding rule");    }    writeOperator(OperatorName.ENDPATH);}
public void pdfbox_f7360_0(COSName tag) throws IOException
{    beginMarkedContent(tag);}
public void pdfbox_f7361_0(COSName tag, COSName propsName) throws IOException
{    writeOperand(tag);    writeOperand(propsName);    writeOperator(OperatorName.BEGIN_MARKED_CONTENT_SEQ);}
public void pdfbox_f7362_0() throws IOException
{    endMarkedContent();}
public void pdfbox_f7363_0(String commands) throws IOException
{    write(commands);}
public void pdfbox_f7364_0(byte[] commands) throws IOException
{    write(commands);}
public void pdfbox_f7365_0(int data) throws IOException
{    writeOperand(data);}
public void pdfbox_f7366_0(double data) throws IOException
{    writeOperand((float) data);}
public void pdfbox_f7367_0(float data) throws IOException
{    writeOperand(data);}
public void pdfbox_f7368_0(COSName name) throws IOException
{    writeOperand(name);}
public static COSBase pdfbox_f7369_0(COSDictionary node, COSName key)
{    COSBase value = node.getDictionaryObject(key);    if (value != null) {        return value;    }    COSBase base = node.getDictionaryObject(COSName.PARENT, COSName.P);    if (base instanceof COSDictionary) {        COSDictionary parent = (COSDictionary) base;        if (COSName.PAGES.equals(parent.getDictionaryObject(COSName.TYPE))) {            return getInheritableAttribute(parent, key);        }    }    return null;}
public Iterator<PDPage> pdfbox_f7370_0()
{    return new PageIterator(root);}
private List<COSDictionary> pdfbox_f7371_1(COSDictionary node)
{    List<COSDictionary> result = new ArrayList<>();    COSArray kids = node.getCOSArray(COSName.KIDS);    if (kids == null) {                return result;    }    for (int i = 0, size = kids.size(); i < size; i++) {        COSBase base = kids.getObject(i);        if (base instanceof COSDictionary) {            result.add((COSDictionary) base);        } else {                    }    }    return result;}
private void pdfbox_f7372_0(COSDictionary node)
{    if (isPageTreeNode(node)) {        List<COSDictionary> kids = getKids(node);        for (COSDictionary kid : kids) {            enqueueKids(kid);        }    } else {        queue.add(node);    }}
public boolean pdfbox_f7373_0()
{    return !queue.isEmpty();}
public PDPage pdfbox_f7374_0()
{    COSDictionary next = queue.poll();    sanitizeType(next);    ResourceCache resourceCache = document != null ? document.getResourceCache() : null;    return new PDPage(next, resourceCache);}
public void pdfbox_f7375_0()
{    throw new UnsupportedOperationException();}
public PDPage pdfbox_f7376_0(int index)
{    COSDictionary dict = get(index + 1, root, 0);    sanitizeType(dict);    ResourceCache resourceCache = document != null ? document.getResourceCache() : null;    return new PDPage(dict, resourceCache);}
private static void pdfbox_f7377_0(COSDictionary dictionary)
{    COSName type = dictionary.getCOSName(COSName.TYPE);    if (type == null) {        dictionary.setItem(COSName.TYPE, COSName.PAGE);        return;    }    if (!COSName.PAGE.equals(type)) {        throw new IllegalStateException("Expected 'Page' but found " + type);    }}
private COSDictionary pdfbox_f7378_0(int pageNum, COSDictionary node, int encountered)
{    if (pageNum < 0) {        throw new IndexOutOfBoundsException("Index out of bounds: " + pageNum);    }    if (isPageTreeNode(node)) {        int count = node.getInt(COSName.COUNT, 0);        if (pageNum <= encountered + count) {                        for (COSDictionary kid : getKids(node)) {                                if (isPageTreeNode(kid)) {                    int kidCount = kid.getInt(COSName.COUNT, 0);                    if (pageNum <= encountered + kidCount) {                                                return get(pageNum, kid, encountered);                    } else {                        encountered += kidCount;                    }                } else {                                        encountered++;                    if (pageNum == encountered) {                                                return get(pageNum, kid, encountered);                    }                }            }            throw new IllegalStateException("1-based index not found: " + pageNum);        } else {            throw new IndexOutOfBoundsException("1-based index out of bounds: " + pageNum);        }    } else {        if (encountered == pageNum) {            return node;        } else {            throw new IllegalStateException("1-based index not found: " + pageNum);        }    }}
private boolean pdfbox_f7379_0(COSDictionary node)
{        return node != null && (node.getCOSName(COSName.TYPE) == COSName.PAGES || node.containsKey(COSName.KIDS));}
public int pdfbox_f7380_0(PDPage page)
{    SearchContext context = new SearchContext(page);    if (findPage(context, root)) {        return context.index;    }    return -1;}
private boolean pdfbox_f7381_0(SearchContext context, COSDictionary node)
{    for (COSDictionary kid : getKids(node)) {        if (context.found) {            break;        }        if (isPageTreeNode(kid)) {            findPage(context, kid);        } else {            context.visitPage(kid);        }    }    return context.found;}
private void pdfbox_f7382_0(COSDictionary current)
{    index++;    found = searched.equals(current);}
public int pdfbox_f7383_0()
{    return root.getInt(COSName.COUNT, 0);}
public COSDictionary pdfbox_f7384_0()
{    return root;}
public void pdfbox_f7385_0(int index)
{    COSDictionary node = get(index + 1, root, 0);    remove(node);}
public void pdfbox_f7386_0(PDPage page)
{    remove(page.getCOSObject());}
private void pdfbox_f7387_0(COSDictionary node)
{        COSDictionary parent = (COSDictionary) node.getDictionaryObject(COSName.PARENT, COSName.P);    COSArray kids = (COSArray) parent.getDictionaryObject(COSName.KIDS);    if (kids.removeObject(node)) {                do {            node = (COSDictionary) node.getDictionaryObject(COSName.PARENT, COSName.P);            if (node != null) {                node.setInt(COSName.COUNT, node.getInt(COSName.COUNT) - 1);            }        } while (node != null);    }}
public void pdfbox_f7388_0(PDPage page)
{        COSDictionary node = page.getCOSObject();    node.setItem(COSName.PARENT, root);            COSArray kids = (COSArray) root.getDictionaryObject(COSName.KIDS);    kids.add(node);        do {        node = (COSDictionary) node.getDictionaryObject(COSName.PARENT, COSName.P);        if (node != null) {            node.setInt(COSName.COUNT, node.getInt(COSName.COUNT) + 1);        }    } while (node != null);}
public void pdfbox_f7389_0(PDPage newPage, PDPage nextPage)
{    COSDictionary nextPageDict = nextPage.getCOSObject();    COSDictionary parentDict = (COSDictionary) nextPageDict.getDictionaryObject(COSName.PARENT);    COSArray kids = (COSArray) parentDict.getDictionaryObject(COSName.KIDS);    boolean found = false;    for (int i = 0; i < kids.size(); ++i) {        COSDictionary pageDict = (COSDictionary) kids.getObject(i);        if (pageDict.equals(nextPage.getCOSObject())) {            kids.add(i, newPage.getCOSObject());            newPage.getCOSObject().setItem(COSName.PARENT, parentDict);            found = true;            break;        }    }    if (!found) {        throw new IllegalArgumentException("attempted to insert before orphan page");    }    increaseParents(parentDict);}
public void pdfbox_f7390_0(PDPage newPage, PDPage prevPage)
{    COSDictionary prevPageDict = prevPage.getCOSObject();    COSDictionary parentDict = (COSDictionary) prevPageDict.getDictionaryObject(COSName.PARENT);    COSArray kids = (COSArray) parentDict.getDictionaryObject(COSName.KIDS);    boolean found = false;    for (int i = 0; i < kids.size(); ++i) {        COSDictionary pageDict = (COSDictionary) kids.getObject(i);        if (pageDict.equals(prevPage.getCOSObject())) {            kids.add(i + 1, newPage.getCOSObject());            newPage.getCOSObject().setItem(COSName.PARENT, parentDict);            found = true;            break;        }    }    if (!found) {        throw new IllegalArgumentException("attempted to insert before orphan page");    }    increaseParents(parentDict);}
private void pdfbox_f7391_0(COSDictionary parentDict)
{    do {        int cnt = parentDict.getInt(COSName.COUNT);        parentDict.setInt(COSName.COUNT, cnt + 1);        parentDict = (COSDictionary) parentDict.getDictionaryObject(COSName.PARENT);    } while (parentDict != null);}
public COSDictionary pdfbox_f7392_0()
{    return resources;}
public PDFont pdfbox_f7393_0(COSName name) throws IOException
{    COSObject indirect = getIndirect(COSName.FONT, name);    if (cache != null && indirect != null) {        PDFont cached = cache.getFont(indirect);        if (cached != null) {            return cached;        }    } else if (indirect == null) {        SoftReference<PDFont> ref = directFontCache.get(name);        if (ref != null) {            PDFont cached = ref.get();            if (cached != null) {                return cached;            }        }    }    PDFont font = null;    COSDictionary dict = (COSDictionary) get(COSName.FONT, name);    if (dict != null) {        font = PDFontFactory.createFont(dict, cache);    }    if (cache != null && indirect != null) {        cache.put(indirect, font);    } else if (indirect == null) {        directFontCache.put(name, new SoftReference<>(font));    }    return font;}
public PDColorSpace pdfbox_f7394_0(COSName name) throws IOException
{    return getColorSpace(name, false);}
public PDColorSpace pdfbox_f7395_0(COSName name, boolean wasDefault) throws IOException
{    COSObject indirect = getIndirect(COSName.COLORSPACE, name);    if (cache != null && indirect != null) {        PDColorSpace cached = cache.getColorSpace(indirect);        if (cached != null) {            return cached;        }    }        PDColorSpace colorSpace;    COSBase object = get(COSName.COLORSPACE, name);    if (object != null) {        colorSpace = PDColorSpace.create(object, this, wasDefault);    } else {        colorSpace = PDColorSpace.create(name, this, wasDefault);    }        if (cache != null && !(colorSpace instanceof PDPattern)) {        cache.put(indirect, colorSpace);    }    return colorSpace;}
public boolean pdfbox_f7396_0(COSName name)
{    return get(COSName.COLORSPACE, name) != null;}
public PDExtendedGraphicsState pdfbox_f7397_0(COSName name)
{    COSObject indirect = getIndirect(COSName.EXT_G_STATE, name);    if (cache != null && indirect != null) {        PDExtendedGraphicsState cached = cache.getExtGState(indirect);        if (cached != null) {            return cached;        }    }        PDExtendedGraphicsState extGState = null;    COSDictionary dict = (COSDictionary) get(COSName.EXT_G_STATE, name);    if (dict != null) {        extGState = new PDExtendedGraphicsState(dict);    }    if (cache != null) {        cache.put(indirect, extGState);    }    return extGState;}
public PDShading pdfbox_f7398_0(COSName name) throws IOException
{    COSObject indirect = getIndirect(COSName.SHADING, name);    if (cache != null && indirect != null) {        PDShading cached = cache.getShading(indirect);        if (cached != null) {            return cached;        }    }        PDShading shading = null;    COSDictionary dict = (COSDictionary) get(COSName.SHADING, name);    if (dict != null) {        shading = PDShading.create(dict);    }    if (cache != null) {        cache.put(indirect, shading);    }    return shading;}
public PDAbstractPattern pdfbox_f7399_0(COSName name) throws IOException
{    COSObject indirect = getIndirect(COSName.PATTERN, name);    if (cache != null && indirect != null) {        PDAbstractPattern cached = cache.getPattern(indirect);        if (cached != null) {            return cached;        }    }        PDAbstractPattern pattern = null;    COSDictionary dict = (COSDictionary) get(COSName.PATTERN, name);    if (dict != null) {        pattern = PDAbstractPattern.create(dict);    }    if (cache != null) {        cache.put(indirect, pattern);    }    return pattern;}
public PDPropertyList pdfbox_f7400_0(COSName name)
{    COSObject indirect = getIndirect(COSName.PROPERTIES, name);    if (cache != null && indirect != null) {        PDPropertyList cached = cache.getProperties(indirect);        if (cached != null) {            return cached;        }    }        PDPropertyList propertyList = null;    COSDictionary dict = (COSDictionary) get(COSName.PROPERTIES, name);    if (dict != null) {        propertyList = PDPropertyList.create(dict);    }    if (cache != null) {        cache.put(indirect, propertyList);    }    return propertyList;}
public boolean pdfbox_f7401_0(COSName name)
{        COSBase value = get(COSName.XOBJECT, name);    if (value == null) {        return false;    } else if (value instanceof COSObject) {        value = ((COSObject) value).getObject();    }    if (!(value instanceof COSStream)) {        return false;    }    COSStream stream = (COSStream) value;    return COSName.IMAGE.equals(stream.getCOSName(COSName.SUBTYPE));}
public PDXObject pdfbox_f7402_0(COSName name) throws IOException
{    COSObject indirect = getIndirect(COSName.XOBJECT, name);    if (cache != null && indirect != null) {        PDXObject cached = cache.getXObject(indirect);        if (cached != null) {            return cached;        }    }        PDXObject xobject;    COSBase value = get(COSName.XOBJECT, name);    if (value == null) {        xobject = null;    } else if (value instanceof COSObject) {        xobject = PDXObject.createXObject(((COSObject) value).getObject(), this);    } else {        xobject = PDXObject.createXObject(value, this);    }    if (cache != null && isAllowedCache(xobject)) {        cache.put(indirect, xobject);    }    return xobject;}
private boolean pdfbox_f7403_0(PDXObject xobject)
{    if (xobject instanceof PDImageXObject) {        COSBase colorSpace = xobject.getCOSObject().getDictionaryObject(COSName.COLORSPACE);        if (colorSpace instanceof COSName) {                        COSName colorSpaceName = (COSName) colorSpace;            if (colorSpaceName.equals(COSName.DEVICECMYK) && hasColorSpace(COSName.DEFAULT_CMYK)) {                return false;            }            if (colorSpaceName.equals(COSName.DEVICERGB) && hasColorSpace(COSName.DEFAULT_RGB)) {                return false;            }            if (colorSpaceName.equals(COSName.DEVICEGRAY) && hasColorSpace(COSName.DEFAULT_GRAY)) {                return false;            }            if (hasColorSpace(colorSpaceName)) {                return false;            }        }    }    return true;}
private COSObject pdfbox_f7404_0(COSName kind, COSName name)
{    COSDictionary dict = (COSDictionary) resources.getDictionaryObject(kind);    if (dict == null) {        return null;    }    COSBase base = dict.getItem(name);    if (base instanceof COSObject) {        return (COSObject) base;    }        return null;}
private COSBase pdfbox_f7405_0(COSName kind, COSName name)
{    COSDictionary dict = (COSDictionary) resources.getDictionaryObject(kind);    if (dict == null) {        return null;    }    return dict.getDictionaryObject(name);}
public Iterable<COSName> pdfbox_f7406_0()
{    return getNames(COSName.COLORSPACE);}
public Iterable<COSName> pdfbox_f7407_0()
{    return getNames(COSName.XOBJECT);}
public Iterable<COSName> pdfbox_f7408_0()
{    return getNames(COSName.FONT);}
public Iterable<COSName> pdfbox_f7409_0()
{    return getNames(COSName.PROPERTIES);}
public Iterable<COSName> pdfbox_f7410_0()
{    return getNames(COSName.SHADING);}
public Iterable<COSName> pdfbox_f7411_0()
{    return getNames(COSName.PATTERN);}
public Iterable<COSName> pdfbox_f7412_0()
{    return getNames(COSName.EXT_G_STATE);}
private Iterable<COSName> pdfbox_f7413_0(COSName kind)
{    COSDictionary dict = (COSDictionary) resources.getDictionaryObject(kind);    if (dict == null) {        return Collections.emptySet();    }    return dict.keySet();}
public COSName pdfbox_f7414_0(PDFont font)
{    return add(COSName.FONT, "F", font);}
public COSName pdfbox_f7415_0(PDColorSpace colorSpace)
{    return add(COSName.COLORSPACE, "cs", colorSpace);}
public COSName pdfbox_f7416_0(PDExtendedGraphicsState extGState)
{    return add(COSName.EXT_G_STATE, "gs", extGState);}
public COSName pdfbox_f7417_0(PDShading shading)
{    return add(COSName.SHADING, "sh", shading);}
public COSName pdfbox_f7418_0(PDAbstractPattern pattern)
{    return add(COSName.PATTERN, "p", pattern);}
public COSName pdfbox_f7419_0(PDPropertyList properties)
{    if (properties instanceof PDOptionalContentGroup) {        return add(COSName.PROPERTIES, "oc", properties);    } else {        return add(COSName.PROPERTIES, "Prop", properties);    }}
public COSName pdfbox_f7420_0(PDImageXObject image)
{    return add(COSName.XOBJECT, "Im", image);}
public COSName pdfbox_f7421_0(PDFormXObject form)
{    return add(COSName.XOBJECT, "Form", form);}
public COSName pdfbox_f7422_0(PDXObject xobject, String prefix)
{    return add(COSName.XOBJECT, prefix, xobject);}
private COSName pdfbox_f7423_0(COSName kind, String prefix, COSObjectable object)
{        COSDictionary dict = (COSDictionary) resources.getDictionaryObject(kind);    if (dict != null && dict.containsValue(object.getCOSObject())) {        return dict.getKeyForValue(object.getCOSObject());    }        if (dict != null && COSName.FONT.equals(kind)) {        for (Map.Entry<COSName, COSBase> entry : dict.entrySet()) {            if (entry.getValue() instanceof COSObject && object.getCOSObject() == ((COSObject) entry.getValue()).getObject()) {                return entry.getKey();            }        }    }        COSName name = createKey(kind, prefix);    put(kind, name, object);    return name;}
private COSName pdfbox_f7424_0(COSName kind, String prefix)
{    COSDictionary dict = (COSDictionary) resources.getDictionaryObject(kind);    if (dict == null) {        return COSName.getPDFName(prefix + 1);    }        String key;    int n = dict.keySet().size();    do {        ++n;        key = prefix + n;    } while (dict.containsKey(key));    return COSName.getPDFName(key);}
private void pdfbox_f7425_0(COSName kind, COSName name, COSObjectable object)
{    COSDictionary dict = (COSDictionary) resources.getDictionaryObject(kind);    if (dict == null) {        dict = new COSDictionary();        resources.setItem(kind, dict);    }    dict.setItem(name, object);}
public void pdfbox_f7426_0(COSName name, PDFont font)
{    put(COSName.FONT, name, font);}
public void pdfbox_f7427_0(COSName name, PDColorSpace colorSpace)
{    put(COSName.COLORSPACE, name, colorSpace);}
public void pdfbox_f7428_0(COSName name, PDExtendedGraphicsState extGState)
{    put(COSName.EXT_G_STATE, name, extGState);}
public void pdfbox_f7429_0(COSName name, PDShading shading)
{    put(COSName.SHADING, name, shading);}
public void pdfbox_f7430_0(COSName name, PDAbstractPattern pattern)
{    put(COSName.PATTERN, name, pattern);}
public void pdfbox_f7431_0(COSName name, PDPropertyList properties)
{    put(COSName.PROPERTIES, name, properties);}
public void pdfbox_f7432_0(COSName name, PDXObject xobject)
{    put(COSName.XOBJECT, name, xobject);}
public ResourceCache pdfbox_f7433_0()
{    return cache;}
protected PDStructureElement pdfbox_f7434_0(COSBase base) throws IOException
{    return new PDStructureElement((COSDictionary) base);}
protected PDNameTreeNode<PDStructureElement> pdfbox_f7435_0(COSDictionary dic)
{    return new PDStructureElementNameTreeNode(dic);}
public RenderingHints pdfbox_f7436_0()
{    return renderingHints;}
public void pdfbox_f7437_0(RenderingHints renderingHints)
{    this.renderingHints = renderingHints;}
public boolean pdfbox_f7438_0()
{    return subsamplingAllowed;}
public void pdfbox_f7439_0(boolean subsamplingAllowed)
{    this.subsamplingAllowed = subsamplingAllowed;}
public int pdfbox_f7440_0()
{    return document.getNumberOfPages();}
public PageFormat pdfbox_f7441_0(int pageIndex)
{    PDPage page = document.getPage(pageIndex);    PDRectangle mediaBox = PDFPrintable.getRotatedMediaBox(page);    PDRectangle cropBox = PDFPrintable.getRotatedCropBox(page);                            Paper paper;    boolean isLandscape;    if (mediaBox.getWidth() > mediaBox.getHeight()) {                paper = new Paper();        paper.setSize(mediaBox.getHeight(), mediaBox.getWidth());        paper.setImageableArea(cropBox.getLowerLeftY(), cropBox.getLowerLeftX(), cropBox.getHeight(), cropBox.getWidth());        isLandscape = true;    } else {        paper = new Paper();        paper.setSize(mediaBox.getWidth(), mediaBox.getHeight());        paper.setImageableArea(cropBox.getLowerLeftX(), cropBox.getLowerLeftY(), cropBox.getWidth(), cropBox.getHeight());        isLandscape = false;    }    PageFormat format = new PageFormat();    format.setPaper(paper);        switch(orientation) {        case AUTO:            format.setOrientation(isLandscape ? PageFormat.LANDSCAPE : PageFormat.PORTRAIT);            break;        case LANDSCAPE:            format.setOrientation(PageFormat.LANDSCAPE);            break;        case PORTRAIT:            format.setOrientation(PageFormat.PORTRAIT);            break;        default:            break;    }    return format;}
public Printable pdfbox_f7442_0(int i)
{    if (i >= getNumberOfPages()) {        throw new IndexOutOfBoundsException(i + " >= " + getNumberOfPages());    }    PDFPrintable printable = new PDFPrintable(document, Scaling.ACTUAL_SIZE, showPageBorder, dpi);    printable.setSubsamplingAllowed(subsamplingAllowed);    printable.setRenderingHints(renderingHints);    return printable;}
public boolean pdfbox_f7443_0()
{    return subsamplingAllowed;}
public void pdfbox_f7444_0(boolean subsamplingAllowed)
{    this.subsamplingAllowed = subsamplingAllowed;}
public RenderingHints pdfbox_f7445_0()
{    return renderingHints;}
public void pdfbox_f7446_0(RenderingHints renderingHints)
{    this.renderingHints = renderingHints;}
public int pdfbox_f7447_0(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException
{    if (pageIndex < 0 || pageIndex >= document.getNumberOfPages()) {        return NO_SUCH_PAGE;    }    try {        Graphics2D graphics2D = (Graphics2D) graphics;        PDPage page = document.getPage(pageIndex);        PDRectangle cropBox = getRotatedCropBox(page);                final double imageableWidth = pageFormat.getImageableWidth();        final double imageableHeight = pageFormat.getImageableHeight();        double scale = 1;        if (scaling != Scaling.ACTUAL_SIZE) {                        double scaleX = imageableWidth / cropBox.getWidth();            double scaleY = imageableHeight / cropBox.getHeight();            scale = Math.min(scaleX, scaleY);                        if (scale > 1 && scaling == Scaling.SHRINK_TO_FIT) {                scale = 1;            }                        if (scale < 1 && scaling == Scaling.STRETCH_TO_FIT) {                scale = 1;            }        }                graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());                if (center) {            graphics2D.translate((imageableWidth - cropBox.getWidth() * scale) / 2, (imageableHeight - cropBox.getHeight() * scale) / 2);        }                Graphics2D printerGraphics = null;        BufferedImage image = null;        if (dpi > 0) {            float dpiScale = dpi / 72;            image = new BufferedImage((int) (imageableWidth * dpiScale / scale), (int) (imageableHeight * dpiScale / scale), BufferedImage.TYPE_INT_ARGB);            printerGraphics = graphics2D;            graphics2D = image.createGraphics();                        printerGraphics.scale(scale / dpiScale, scale / dpiScale);            scale = dpiScale;        }                AffineTransform transform = (AffineTransform) graphics2D.getTransform().clone();        graphics2D.setBackground(Color.WHITE);        renderer.setSubsamplingAllowed(subsamplingAllowed);        renderer.setRenderingHints(renderingHints);        renderer.renderPageToGraphics(pageIndex, graphics2D, (float) scale, (float) scale, RenderDestination.PRINT);                if (showPageBorder) {            graphics2D.setTransform(transform);            graphics2D.setClip(0, 0, (int) imageableWidth, (int) imageableHeight);            graphics2D.scale(scale, scale);            graphics2D.setColor(Color.GRAY);            graphics2D.setStroke(new BasicStroke(0.5f));            graphics.drawRect(0, 0, (int) cropBox.getWidth(), (int) cropBox.getHeight());        }                if (printerGraphics != null) {            printerGraphics.setBackground(Color.WHITE);            printerGraphics.clearRect(0, 0, image.getWidth(), image.getHeight());            printerGraphics.drawImage(image, 0, 0, null);            graphics2D.dispose();        }        return PAGE_EXISTS;    } catch (IOException e) {        throw new PrinterIOException(e);    }}
 static PDRectangle pdfbox_f7448_0(PDPage page)
{    PDRectangle cropBox = page.getCropBox();    int rotationAngle = page.getRotation();    if (rotationAngle == 90 || rotationAngle == 270) {        return new PDRectangle(cropBox.getLowerLeftY(), cropBox.getLowerLeftX(), cropBox.getHeight(), cropBox.getWidth());    } else {        return cropBox;    }}
 static PDRectangle pdfbox_f7449_0(PDPage page)
{    PDRectangle mediaBox = page.getMediaBox();    int rotationAngle = page.getRotation();    if (rotationAngle == 90 || rotationAngle == 270) {        return new PDRectangle(mediaBox.getLowerLeftY(), mediaBox.getLowerLeftX(), mediaBox.getHeight(), mediaBox.getWidth());    } else {        return mediaBox;    }}
public GeneralPath pdfbox_f7450_1(int code)
{    GeneralPath path = cache.get(code);    if (path != null) {        return path;    }    try {        if (!font.hasGlyph(code)) {            String fontName = ((PDFontLike) font).getName();            if (font instanceof PDType0Font) {                int cid = ((PDType0Font) font).codeToCID(code);                String cidHex = String.format("%04x", cid);                            } else if (font instanceof PDSimpleFont) {                                PDSimpleFont simpleFont = (PDSimpleFont) font;                if (code == 10 && simpleFont.isStandard14()) {                                        path = new GeneralPath();                    cache.put(code, path);                    return path;                }            } else {                            }        }        path = font.getNormalizedPath(code);        cache.put(code, path);        return path;    } catch (IOException e) {                        return new GeneralPath();    }}
public void pdfbox_f7451_0(int x, int y, int width, int height)
{    groupG2D.clearRect(x, y, width, height);    alphaG2D.clearRect(x, y, width, height);}
public void pdfbox_f7452_0(int x, int y, int width, int height)
{    groupG2D.clipRect(x, y, width, height);    alphaG2D.clipRect(x, y, width, height);}
public void pdfbox_f7453_0(int x, int y, int width, int height, int dx, int dy)
{    groupG2D.copyArea(x, y, width, height, dx, dy);    alphaG2D.copyArea(x, y, width, height, dx, dy);}
public Graphics pdfbox_f7454_0()
{    Graphics g = groupG2D.create();    Graphics a = alphaG2D.create();    if (g instanceof Graphics2D && a instanceof Graphics2D) {        return new GroupGraphics(groupImage, (Graphics2D) g, groupAlphaImage, (Graphics2D) a);    }    throw new UnsupportedOperationException();}
public void pdfbox_f7455_0()
{    groupG2D.dispose();    alphaG2D.dispose();}
public void pdfbox_f7456_0(int x, int y, int width, int height, int startAngle, int arcAngle)
{    groupG2D.drawArc(x, y, width, height, startAngle, arcAngle);    alphaG2D.drawArc(x, y, width, height, startAngle, arcAngle);}
public boolean pdfbox_f7457_0(Image img, int x, int y, Color bgcolor, ImageObserver observer)
{    groupG2D.drawImage(img, x, y, bgcolor, observer);    return alphaG2D.drawImage(img, x, y, bgcolor, observer);}
public boolean pdfbox_f7458_0(Image img, int x, int y, ImageObserver observer)
{    groupG2D.drawImage(img, x, y, observer);    return alphaG2D.drawImage(img, x, y, observer);}
public boolean pdfbox_f7459_0(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer)
{    groupG2D.drawImage(img, x, y, width, height, bgcolor, observer);    return alphaG2D.drawImage(img, x, y, width, height, bgcolor, observer);}
public boolean pdfbox_f7460_0(Image img, int x, int y, int width, int height, ImageObserver observer)
{    groupG2D.drawImage(img, x, y, width, height, observer);    return alphaG2D.drawImage(img, x, y, width, height, observer);}
public boolean pdfbox_f7461_0(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer)
{    groupG2D.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, bgcolor, observer);    return alphaG2D.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, bgcolor, observer);}
public boolean pdfbox_f7462_0(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer)
{    groupG2D.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer);    return alphaG2D.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer);}
public void pdfbox_f7463_0(int x1, int y1, int x2, int y2)
{    groupG2D.drawLine(x1, y1, x2, y2);    alphaG2D.drawLine(x1, y1, x2, y2);}
public void pdfbox_f7464_0(int x, int y, int width, int height)
{    groupG2D.drawOval(x, y, width, height);    alphaG2D.drawOval(x, y, width, height);}
public void pdfbox_f7465_0(int[] xPoints, int[] yPoints, int nPoints)
{    groupG2D.drawPolygon(xPoints, yPoints, nPoints);    alphaG2D.drawPolygon(xPoints, yPoints, nPoints);}
public void pdfbox_f7466_0(int[] xPoints, int[] yPoints, int nPoints)
{    groupG2D.drawPolyline(xPoints, yPoints, nPoints);    alphaG2D.drawPolyline(xPoints, yPoints, nPoints);}
public void pdfbox_f7467_0(int x, int y, int width, int height, int arcWidth, int arcHeight)
{    groupG2D.drawRoundRect(x, y, width, height, arcWidth, arcHeight);    alphaG2D.drawRoundRect(x, y, width, height, arcWidth, arcHeight);}
public void pdfbox_f7468_0(AttributedCharacterIterator iterator, int x, int y)
{    groupG2D.drawString(iterator, x, y);    alphaG2D.drawString(iterator, x, y);}
public void pdfbox_f7469_0(String str, int x, int y)
{    groupG2D.drawString(str, x, y);    alphaG2D.drawString(str, x, y);}
public void pdfbox_f7470_0(int x, int y, int width, int height, int startAngle, int arcAngle)
{    groupG2D.fillArc(x, y, width, height, startAngle, arcAngle);    alphaG2D.fillArc(x, y, width, height, startAngle, arcAngle);}
public void pdfbox_f7471_0(int x, int y, int width, int height)
{    groupG2D.fillOval(x, y, width, height);    alphaG2D.fillOval(x, y, width, height);}
public void pdfbox_f7472_0(int[] xPoints, int[] yPoints, int nPoints)
{    groupG2D.fillPolygon(xPoints, yPoints, nPoints);    alphaG2D.fillPolygon(xPoints, yPoints, nPoints);}
public void pdfbox_f7473_0(int x, int y, int width, int height)
{    groupG2D.fillRect(x, y, width, height);    alphaG2D.fillRect(x, y, width, height);}
public void pdfbox_f7474_0(int x, int y, int width, int height, int arcWidth, int arcHeight)
{    groupG2D.fillRoundRect(x, y, width, height, arcWidth, arcHeight);    alphaG2D.fillRoundRect(x, y, width, height, arcWidth, arcHeight);}
public Shape pdfbox_f7475_0()
{    return groupG2D.getClip();}
public Rectangle pdfbox_f7476_0()
{    return groupG2D.getClipBounds();}
public Color pdfbox_f7477_0()
{    return groupG2D.getColor();}
public Font pdfbox_f7478_0()
{    return groupG2D.getFont();}
public FontMetrics pdfbox_f7479_0(Font f)
{    return groupG2D.getFontMetrics(f);}
public void pdfbox_f7480_0(int x, int y, int width, int height)
{    groupG2D.setClip(x, y, width, height);    alphaG2D.setClip(x, y, width, height);}
public void pdfbox_f7481_0(Shape clip)
{    groupG2D.setClip(clip);    alphaG2D.setClip(clip);}
public void pdfbox_f7482_0(Color c)
{    groupG2D.setColor(c);    alphaG2D.setColor(c);}
public void pdfbox_f7483_0(Font font)
{    groupG2D.setFont(font);    alphaG2D.setFont(font);}
public void pdfbox_f7484_0()
{    groupG2D.setPaintMode();    alphaG2D.setPaintMode();}
public void pdfbox_f7485_0(Color c1)
{    groupG2D.setXORMode(c1);    alphaG2D.setXORMode(c1);}
public void pdfbox_f7486_0(int x, int y)
{    groupG2D.translate(x, y);    alphaG2D.translate(x, y);}
public void pdfbox_f7487_0(Map<?, ?> hints)
{    groupG2D.addRenderingHints(hints);    alphaG2D.addRenderingHints(hints);}
public void pdfbox_f7488_0(Shape s)
{    groupG2D.clip(s);    alphaG2D.clip(s);}
public void pdfbox_f7489_0(Shape s)
{    groupG2D.draw(s);    alphaG2D.draw(s);}
public void pdfbox_f7490_0(GlyphVector g, float x, float y)
{    groupG2D.drawGlyphVector(g, x, y);    alphaG2D.drawGlyphVector(g, x, y);}
public void pdfbox_f7491_0(BufferedImage img, BufferedImageOp op, int x, int y)
{    groupG2D.drawImage(img, op, x, y);    alphaG2D.drawImage(img, op, x, y);}
public boolean pdfbox_f7492_0(Image img, AffineTransform xform, ImageObserver obs)
{    groupG2D.drawImage(img, xform, obs);    return alphaG2D.drawImage(img, xform, obs);}
public void pdfbox_f7493_0(RenderableImage img, AffineTransform xform)
{    groupG2D.drawRenderableImage(img, xform);    alphaG2D.drawRenderableImage(img, xform);}
public void pdfbox_f7494_0(RenderedImage img, AffineTransform xform)
{    groupG2D.drawRenderedImage(img, xform);    alphaG2D.drawRenderedImage(img, xform);}
public void pdfbox_f7495_0(AttributedCharacterIterator iterator, float x, float y)
{    groupG2D.drawString(iterator, x, y);    alphaG2D.drawString(iterator, x, y);}
public void pdfbox_f7496_0(String str, float x, float y)
{    groupG2D.drawString(str, x, y);    alphaG2D.drawString(str, x, y);}
public void pdfbox_f7497_0(Shape s)
{    groupG2D.fill(s);    alphaG2D.fill(s);}
public Color pdfbox_f7498_0()
{    return groupG2D.getBackground();}
public Composite pdfbox_f7499_0()
{    return groupG2D.getComposite();}
public GraphicsConfiguration pdfbox_f7500_0()
{    return groupG2D.getDeviceConfiguration();}
public FontRenderContext pdfbox_f7501_0()
{    return groupG2D.getFontRenderContext();}
public Paint pdfbox_f7502_0()
{    return groupG2D.getPaint();}
public Object pdfbox_f7503_0(RenderingHints.Key hintKey)
{    return groupG2D.getRenderingHint(hintKey);}
public RenderingHints pdfbox_f7504_0()
{    return groupG2D.getRenderingHints();}
public Stroke pdfbox_f7505_0()
{    return groupG2D.getStroke();}
public AffineTransform pdfbox_f7506_0()
{    return groupG2D.getTransform();}
public boolean pdfbox_f7507_0(Rectangle rect, Shape s, boolean onStroke)
{    return groupG2D.hit(rect, s, onStroke);}
public void pdfbox_f7508_0(double theta)
{    groupG2D.rotate(theta);    alphaG2D.rotate(theta);}
public void pdfbox_f7509_0(double theta, double x, double y)
{    groupG2D.rotate(theta, x, y);    alphaG2D.rotate(theta, x, y);}
public void pdfbox_f7510_0(double sx, double sy)
{    groupG2D.scale(sx, sy);    alphaG2D.scale(sx, sy);}
public void pdfbox_f7511_0(Color color)
{    groupG2D.setBackground(color);    alphaG2D.setBackground(color);}
public void pdfbox_f7512_0(Composite comp)
{    groupG2D.setComposite(comp);    alphaG2D.setComposite(comp);}
public void pdfbox_f7513_0(Paint paint)
{    groupG2D.setPaint(paint);    alphaG2D.setPaint(paint);}
public void pdfbox_f7514_0(RenderingHints.Key hintKey, Object hintValue)
{    groupG2D.setRenderingHint(hintKey, hintValue);    alphaG2D.setRenderingHint(hintKey, hintValue);}
public void pdfbox_f7515_0(Map<?, ?> hints)
{    groupG2D.setRenderingHints(hints);    alphaG2D.setRenderingHints(hints);}
public void pdfbox_f7516_0(Stroke s)
{    groupG2D.setStroke(s);    alphaG2D.setStroke(s);}
public void pdfbox_f7517_0(AffineTransform tx)
{    groupG2D.setTransform(tx);    alphaG2D.setTransform(tx);}
public void pdfbox_f7518_0(double shx, double shy)
{    groupG2D.shear(shx, shy);    alphaG2D.shear(shx, shy);}
public void pdfbox_f7519_0(AffineTransform tx)
{    groupG2D.transform(tx);    alphaG2D.transform(tx);}
public void pdfbox_f7520_0(double tx, double ty)
{    groupG2D.translate(tx, ty);    alphaG2D.translate(tx, ty);}
 void pdfbox_f7521_0(BufferedImage backdrop, int offsetX, int offsetY)
{    int groupWidth = groupImage.getWidth();    int groupHeight = groupImage.getHeight();    int backdropWidth = backdrop.getWidth();    int backdropHeight = backdrop.getHeight();    int groupType = groupImage.getType();    int groupAlphaType = groupAlphaImage.getType();    int backdropType = backdrop.getType();    DataBuffer groupDataBuffer = groupImage.getRaster().getDataBuffer();    DataBuffer groupAlphaDataBuffer = groupAlphaImage.getRaster().getDataBuffer();    DataBuffer backdropDataBuffer = backdrop.getRaster().getDataBuffer();    if (groupType == BufferedImage.TYPE_INT_ARGB && groupAlphaType == BufferedImage.TYPE_INT_ARGB && (backdropType == BufferedImage.TYPE_INT_ARGB || backdropType == BufferedImage.TYPE_INT_RGB) && groupDataBuffer instanceof DataBufferInt && groupAlphaDataBuffer instanceof DataBufferInt && backdropDataBuffer instanceof DataBufferInt) {                int[] groupData = ((DataBufferInt) groupDataBuffer).getData();        int[] groupAlphaData = ((DataBufferInt) groupAlphaDataBuffer).getData();        int[] backdropData = ((DataBufferInt) backdropDataBuffer).getData();        boolean backdropHasAlpha = backdropType == BufferedImage.TYPE_INT_ARGB;        for (int y = 0; y < groupHeight; y++) {            for (int x = 0; x < groupWidth; x++) {                int index = x + y * groupWidth;                                int alphagn = (groupAlphaData[index] >> 24) & 0xFF;                if (alphagn == 0) {                                        groupData[index] = 0;                    continue;                }                int backdropX = x + offsetX;                int backdropY = y + offsetY;                                int backdropRGB;                                float alpha0;                if (backdropX >= 0 && backdropX < backdropWidth && backdropY >= 0 && backdropY < backdropHeight) {                    backdropRGB = backdropData[backdropX + backdropY * backdropWidth];                    alpha0 = backdropHasAlpha ? ((backdropRGB >> 24) & 0xFF) : 255;                } else {                                        backdropRGB = 0;                    alpha0 = 0;                }                                float alphaFactor = alpha0 / (float) alphagn - alpha0 / 255.0f;                                int groupRGB = groupData[index];                                int r = backdropRemoval(groupRGB, backdropRGB, 16, alphaFactor);                int g = backdropRemoval(groupRGB, backdropRGB, 8, alphaFactor);                int b = backdropRemoval(groupRGB, backdropRGB, 0, alphaFactor);                                                groupData[index] = (alphagn << 24) | (r << 16) | (g << 8) | b;            }        }    } else {        for (int y = 0; y < groupHeight; y++) {            for (int x = 0; x < groupWidth; x++) {                int alphagn = (groupAlphaImage.getRGB(x, y) >> 24) & 0xFF;                if (alphagn == 0) {                    groupImage.setRGB(x, y, 0);                    continue;                }                int backdropX = x + offsetX;                int backdropY = y + offsetY;                int backdropRGB;                float alpha0;                if (backdropX >= 0 && backdropX < backdropWidth && backdropY >= 0 && backdropY < backdropHeight) {                    backdropRGB = backdrop.getRGB(backdropX, backdropY);                    alpha0 = (backdropRGB >> 24) & 0xFF;                } else {                    backdropRGB = 0;                    alpha0 = 0;                }                int groupRGB = groupImage.getRGB(x, y);                float alphaFactor = alpha0 / alphagn - alpha0 / 255.0f;                int r = backdropRemoval(groupRGB, backdropRGB, 16, alphaFactor);                int g = backdropRemoval(groupRGB, backdropRGB, 8, alphaFactor);                int b = backdropRemoval(groupRGB, backdropRGB, 0, alphaFactor);                groupImage.setRGB(x, y, (alphagn << 24) | (r << 16) | (g << 8) | b);            }        }    }}
private int pdfbox_f7522_0(int groupRGB, int backdropRGB, int shift, float alphaFactor)
{    float cn = (groupRGB >> shift) & 0xFF;    float c0 = (backdropRGB >> shift) & 0xFF;    int c = Math.round(cn + (cn - c0) * alphaFactor);    return (c < 0) ? 0 : (c > 255 ? 255 : c);}
 int pdfbox_f7523_0()
{    return BufferedImage.TYPE_BYTE_BINARY;}
 int pdfbox_f7524_0()
{    return BufferedImage.TYPE_BYTE_GRAY;}
 int pdfbox_f7525_0()
{    return BufferedImage.TYPE_INT_RGB;}
 int pdfbox_f7526_0()
{    return BufferedImage.TYPE_INT_ARGB;}
public AnnotationFilter pdfbox_f7527_0()
{    return annotationFilter;}
public void pdfbox_f7528_0(AnnotationFilter annotationFilter)
{    this.annotationFilter = annotationFilter;}
public final PDFRenderer pdfbox_f7529_0()
{    return renderer;}
protected final Graphics2D pdfbox_f7530_0()
{    return graphics;}
protected final GeneralPath pdfbox_f7531_0()
{    return linePath;}
private void pdfbox_f7532_0()
{    graphics.addRenderingHints(renderingHints);}
public void pdfbox_f7533_0(Graphics g, PDRectangle pageSize) throws IOException
{    graphics = (Graphics2D) g;    xform = graphics.getTransform();    initialClip = graphics.getClip();    this.pageSize = pageSize;    setRenderingHints();    graphics.translate(0, pageSize.getHeight());    graphics.scale(1, -1);        graphics.translate(-pageSize.getLowerLeftX(), -pageSize.getLowerLeftY());    processPage(getPage());    for (PDAnnotation annotation : getPage().getAnnotations(annotationFilter)) {        showAnnotation(annotation);    }    graphics = null;}
 void pdfbox_f7534_0(Graphics2D g, PDTilingPattern pattern, PDColorSpace colorSpace, PDColor color, Matrix patternMatrix) throws IOException
{    Graphics2D savedGraphics = graphics;    graphics = g;    GeneralPath savedLinePath = linePath;    linePath = new GeneralPath();    int savedClipWindingRule = clipWindingRule;    clipWindingRule = -1;    Area savedLastClip = lastClip;    lastClip = null;    Shape savedInitialClip = initialClip;    initialClip = null;    boolean savedFlipTG = flipTG;    flipTG = true;    setRenderingHints();    processTilingPattern(pattern, color, colorSpace, patternMatrix);    flipTG = savedFlipTG;    graphics = savedGraphics;    linePath = savedLinePath;    lastClip = savedLastClip;    initialClip = savedInitialClip;    clipWindingRule = savedClipWindingRule;}
private float pdfbox_f7535_0(float color)
{    return color < 0 ? 0 : (color > 1 ? 1 : color);}
protected Paint pdfbox_f7536_1(PDColor color) throws IOException
{    PDColorSpace colorSpace = color.getColorSpace();    if (!(colorSpace instanceof PDPattern)) {        float[] rgb = colorSpace.toRGB(color.getComponents());        return new Color(clampColor(rgb[0]), clampColor(rgb[1]), clampColor(rgb[2]));    } else {        PDPattern patternSpace = (PDPattern) colorSpace;        PDAbstractPattern pattern = patternSpace.getPattern(color);        if (pattern instanceof PDTilingPattern) {            PDTilingPattern tilingPattern = (PDTilingPattern) pattern;            if (tilingPattern.getPaintType() == PDTilingPattern.PAINT_COLORED) {                                return tilingPaintFactory.create(tilingPattern, null, null, xform);            } else {                                return tilingPaintFactory.create(tilingPattern, patternSpace.getUnderlyingColorSpace(), color, xform);            }        } else {            PDShadingPattern shadingPattern = (PDShadingPattern) pattern;            PDShading shading = shadingPattern.getShading();            if (shading == null) {                                return new Color(0, 0, 0, 0);            }            return shading.toPaint(Matrix.concatenate(getInitialMatrix(), shadingPattern.getMatrix()));        }    }}
private void pdfbox_f7537_0()
{    Area clippingPath = getGraphicsState().getCurrentClippingPath();    if (clippingPath != lastClip) {        graphics.setClip(clippingPath);        if (initialClip != null) {                        }        lastClip = clippingPath;    }}
public void pdfbox_f7538_0() throws IOException
{    setClip();    beginTextClip();}
public void pdfbox_f7539_0() throws IOException
{    endTextClip();}
private void pdfbox_f7540_0()
{        textClippings = new ArrayList<>();}
private void pdfbox_f7541_0()
{    PDGraphicsState state = getGraphicsState();    RenderingMode renderingMode = state.getTextState().getRenderingMode();        if (renderingMode.isClip() && !textClippings.isEmpty()) {                        GeneralPath path = new GeneralPath();        for (Shape shape : textClippings) {            path.append(shape, false);        }        state.intersectClippingPath(path);        textClippings = new ArrayList<>();                        lastClip = null;    }}
protected void pdfbox_f7542_0(Matrix textRenderingMatrix, PDFont font, int code, String unicode, Vector displacement) throws IOException
{    AffineTransform at = textRenderingMatrix.createAffineTransform();    at.concatenate(font.getFontMatrix().createAffineTransform());        PDVectorFont vectorFont = (PDVectorFont) font;    GlyphCache cache = glyphCaches.get(font);    if (cache == null) {        cache = new GlyphCache(vectorFont);        glyphCaches.put(font, cache);    }    GeneralPath path = cache.getPathForCharacterCode(code);    drawGlyph(path, font, code, displacement, at);}
private void pdfbox_f7543_0(GeneralPath path, PDFont font, int code, Vector displacement, AffineTransform at) throws IOException
{    PDGraphicsState state = getGraphicsState();    RenderingMode renderingMode = state.getTextState().getRenderingMode();    if (path != null) {                if (!font.isEmbedded() && !font.isVertical() && !font.isStandard14() && font.hasExplicitWidth(code)) {            float fontWidth = font.getWidthFromFont(code);            if (            fontWidth > 0 && Math.abs(fontWidth - displacement.getX() * 1000) > 0.0001) {                float pdfWidth = displacement.getX() * 1000;                at.scale(pdfWidth / fontWidth, 1);            }        }                Shape glyph = at.createTransformedShape(path);        if (renderingMode.isFill()) {            graphics.setComposite(state.getNonStrokingJavaComposite());            graphics.setPaint(getNonStrokingPaint());            setClip();            if (isContentRendered()) {                graphics.fill(glyph);            }        }        if (renderingMode.isStroke()) {            graphics.setComposite(state.getStrokingJavaComposite());            graphics.setPaint(getStrokingPaint());            graphics.setStroke(getStroke());            setClip();            if (isContentRendered()) {                graphics.draw(glyph);            }        }        if (renderingMode.isClip()) {            textClippings.add(glyph);        }    }}
protected void pdfbox_f7544_0(Matrix textRenderingMatrix, PDType3Font font, int code, String unicode, Vector displacement) throws IOException
{    PDGraphicsState state = getGraphicsState();    RenderingMode renderingMode = state.getTextState().getRenderingMode();    if (!RenderingMode.NEITHER.equals(renderingMode)) {        super.showType3Glyph(textRenderingMatrix, font, code, unicode, displacement);    }}
public void pdfbox_f7545_0(Point2D p0, Point2D p1, Point2D p2, Point2D p3)
{            linePath.moveTo((float) p0.getX(), (float) p0.getY());    linePath.lineTo((float) p1.getX(), (float) p1.getY());    linePath.lineTo((float) p2.getX(), (float) p2.getY());    linePath.lineTo((float) p3.getX(), (float) p3.getY());            linePath.closePath();}
private Paint pdfbox_f7546_0(Paint parentPaint, PDSoftMask softMask) throws IOException
{    if (softMask == null || softMask.getGroup() == null) {        return parentPaint;    }    PDColor backdropColor = null;    if (COSName.LUMINOSITY.equals(softMask.getSubType())) {        COSArray backdropColorArray = softMask.getBackdropColor();        PDTransparencyGroup form = softMask.getGroup();        PDColorSpace colorSpace = form.getGroup().getColorSpace(form.getResources());        if (colorSpace != null && backdropColorArray != null) {            backdropColor = new PDColor(backdropColorArray, colorSpace);        }    }    TransparencyGroup transparencyGroup = new TransparencyGroup(softMask.getGroup(), true, softMask.getInitialTransformationMatrix(), backdropColor);    BufferedImage image = transparencyGroup.getImage();    if (image == null) {                return parentPaint;    }    BufferedImage gray = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);    if (COSName.ALPHA.equals(softMask.getSubType())) {        gray.setData(image.getAlphaRaster());    } else if (COSName.LUMINOSITY.equals(softMask.getSubType())) {        Graphics g = gray.getGraphics();        g.drawImage(image, 0, 0, null);        g.dispose();    } else {        throw new IOException("Invalid soft mask subtype.");    }    gray = adjustImage(gray);    Rectangle2D tpgBounds = transparencyGroup.getBounds();    adjustRectangle(tpgBounds);    return new SoftMask(parentPaint, gray, tpgBounds, backdropColor, softMask.getTransferFunction());}
private void pdfbox_f7547_0(Rectangle2D r)
{    Matrix m = new Matrix(xform);    float scaleX = Math.abs(m.getScalingFactorX());    float scaleY = Math.abs(m.getScalingFactorY());    AffineTransform adjustedTransform = new AffineTransform(xform);    adjustedTransform.scale(1.0 / scaleX, 1.0 / scaleY);    r.setRect(adjustedTransform.createTransformedShape(r).getBounds2D());}
private BufferedImage pdfbox_f7548_0(BufferedImage gray) throws IOException
{    AffineTransform at = new AffineTransform(xform);    Matrix m = new Matrix(at);    at.scale(1.0 / Math.abs(m.getScalingFactorX()), 1.0 / Math.abs(m.getScalingFactorY()));    Rectangle originalBounds = new Rectangle(gray.getWidth(), gray.getHeight());    Rectangle2D transformedBounds = at.createTransformedShape(originalBounds).getBounds2D();    at.preConcatenate(AffineTransform.getTranslateInstance(-transformedBounds.getMinX(), -transformedBounds.getMinY()));    int width = (int) Math.ceil(transformedBounds.getWidth());    int height = (int) Math.ceil(transformedBounds.getHeight());    BufferedImage transformedGray = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);    Graphics2D g2 = (Graphics2D) transformedGray.getGraphics();    g2.drawImage(gray, at, null);    g2.dispose();    return transformedGray;}
private Paint pdfbox_f7549_0() throws IOException
{    return applySoftMaskToPaint(getPaint(getGraphicsState().getStrokingColor()), getGraphicsState().getSoftMask());}
private Paint pdfbox_f7550_0() throws IOException
{    return applySoftMaskToPaint(getPaint(getGraphicsState().getNonStrokingColor()), getGraphicsState().getSoftMask());}
private BasicStroke pdfbox_f7551_0()
{    PDGraphicsState state = getGraphicsState();        float lineWidth = transformWidth(state.getLineWidth());        if (lineWidth < 0.25) {        lineWidth = 0.25f;    }    PDLineDashPattern dashPattern = state.getLineDashPattern();    float phaseStart = dashPattern.getPhase();    float[] dashArray = getDashArray(dashPattern);    phaseStart = transformWidth(phaseStart);        if (dashArray.length == 0 || Float.isInfinite(phaseStart) || Float.isNaN(phaseStart)) {        dashArray = null;    } else {        for (int i = 0; i < dashArray.length; ++i) {            if (Float.isInfinite(dashArray[i]) || Float.isNaN(dashArray[i])) {                dashArray = null;                break;            }        }    }        int lineCap = Math.min(2, Math.max(0, state.getLineCap()));    int lineJoin = Math.min(2, Math.max(0, state.getLineJoin()));    return new BasicStroke(lineWidth, lineCap, lineJoin, state.getMiterLimit(), dashArray, phaseStart);}
private float[] pdfbox_f7552_0(PDLineDashPattern dashPattern)
{    float[] dashArray = dashPattern.getDashArray();    if (JAVA_VERSION < 10) {        float scalingFactorX = new Matrix(xform).getScalingFactorX();        for (int i = 0; i < dashArray.length; ++i) {                        float w = transformWidth(dashArray[i]);                        if (scalingFactorX < 0.5f) {                                dashArray[i] = Math.max(w, 0.2f);            } else {                dashArray[i] = Math.max(w, 0.062f);            }        }    } else {        for (int i = 0; i < dashArray.length; ++i) {                        dashArray[i] = transformWidth(dashArray[i]);        }    }    return dashArray;}
public void pdfbox_f7553_0() throws IOException
{    graphics.setComposite(getGraphicsState().getStrokingJavaComposite());    graphics.setPaint(getStrokingPaint());    graphics.setStroke(getStroke());    setClip();        if (isContentRendered()) {        graphics.draw(linePath);    }    linePath.reset();}
public void pdfbox_f7554_0(int windingRule) throws IOException
{    graphics.setComposite(getGraphicsState().getNonStrokingJavaComposite());    graphics.setPaint(getNonStrokingPaint());    setClip();    linePath.setWindingRule(windingRule);                    Rectangle2D bounds = linePath.getBounds2D();    boolean noAntiAlias = isRectangular(linePath) && bounds.getWidth() > 1 && bounds.getHeight() > 1;    if (noAntiAlias) {        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);    }    Shape shape;    if (!(graphics.getPaint() instanceof Color)) {                Area area = new Area(linePath);        area.intersect(new Area(graphics.getClip()));        intersectShadingBBox(getGraphicsState().getNonStrokingColor(), area);        shape = area;    } else {        shape = linePath;    }    if (isContentRendered()) {        graphics.fill(shape);    }    linePath.reset();    if (noAntiAlias) {                        setRenderingHints();    }}
private void pdfbox_f7555_0(PDColor color, Area area) throws IOException
{    if (color.getColorSpace() instanceof PDPattern) {        PDColorSpace colorSpace = color.getColorSpace();        PDAbstractPattern pat = ((PDPattern) colorSpace).getPattern(color);        if (pat instanceof PDShadingPattern) {            PDShading shading = ((PDShadingPattern) pat).getShading();            PDRectangle bbox = shading.getBBox();            if (bbox != null) {                Matrix m = Matrix.concatenate(getInitialMatrix(), pat.getMatrix());                Area bboxArea = new Area(bbox.transform(m));                area.intersect(bboxArea);            }        }    }}
private boolean pdfbox_f7556_0(GeneralPath path)
{    PathIterator iter = path.getPathIterator(null);    double[] coords = new double[6];    int count = 0;    int[] xs = new int[4];    int[] ys = new int[4];    while (!iter.isDone()) {        switch(iter.currentSegment(coords)) {            case PathIterator.SEG_MOVETO:                if (count == 0) {                    xs[count] = (int) Math.floor(coords[0]);                    ys[count] = (int) Math.floor(coords[1]);                } else {                    return false;                }                count++;                break;            case PathIterator.SEG_LINETO:                if (count < 4) {                    xs[count] = (int) Math.floor(coords[0]);                    ys[count] = (int) Math.floor(coords[1]);                } else {                    return false;                }                count++;                break;            case PathIterator.SEG_CUBICTO:                return false;            case PathIterator.SEG_CLOSE:                break;            default:                break;        }        iter.next();    }    if (count == 4) {        return xs[0] == xs[1] || xs[0] == xs[2] || ys[0] == ys[1] || ys[0] == ys[3];    }    return false;}
public void pdfbox_f7557_0(int windingRule) throws IOException
{        GeneralPath path = (GeneralPath) linePath.clone();    fillPath(windingRule);    linePath = path;    strokePath();}
public void pdfbox_f7558_0(int windingRule)
{        clipWindingRule = windingRule;}
public void pdfbox_f7559_0(float x, float y)
{    linePath.moveTo(x, y);}
public void pdfbox_f7560_0(float x, float y)
{    linePath.lineTo(x, y);}
public void pdfbox_f7561_0(float x1, float y1, float x2, float y2, float x3, float y3)
{    linePath.curveTo(x1, y1, x2, y2, x3, y3);}
public Point2D pdfbox_f7562_0()
{    return linePath.getCurrentPoint();}
public void pdfbox_f7563_0()
{    linePath.closePath();}
public void pdfbox_f7564_0()
{    if (clipWindingRule != -1) {        linePath.setWindingRule(clipWindingRule);        getGraphicsState().intersectClippingPath(linePath);                        lastClip = null;        clipWindingRule = -1;    }    linePath.reset();}
public void pdfbox_f7565_0(PDImage pdImage) throws IOException
{    Matrix ctm = getGraphicsState().getCurrentTransformationMatrix();    AffineTransform at = ctm.createAffineTransform();    if (!pdImage.getInterpolate()) {        boolean isScaledUp = pdImage.getWidth() < Math.round(at.getScaleX()) || pdImage.getHeight() < Math.round(at.getScaleY());                if (isScaledUp) {            graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);        }    }    if (pdImage.isStencil()) {        if (getGraphicsState().getNonStrokingColor().getColorSpace() instanceof PDPattern) {                                                                                                                                    Paint paint = getNonStrokingPaint();            Rectangle2D unitRect = new Rectangle2D.Float(0, 0, 1, 1);            Rectangle2D bounds = at.createTransformedShape(unitRect).getBounds2D();            BufferedImage renderedPaint = new BufferedImage((int) Math.ceil(bounds.getWidth()), (int) Math.ceil(bounds.getHeight()), BufferedImage.TYPE_INT_ARGB);            Graphics2D g = (Graphics2D) renderedPaint.getGraphics();            g.translate(-bounds.getMinX(), -bounds.getMinY());            g.setPaint(paint);            g.fill(bounds);            g.dispose();                        BufferedImage mask = pdImage.getImage();            BufferedImage renderedMask = new BufferedImage((int) Math.ceil(bounds.getWidth()), (int) Math.ceil(bounds.getHeight()), BufferedImage.TYPE_INT_RGB);            g = (Graphics2D) renderedMask.getGraphics();            g.translate(-bounds.getMinX(), -bounds.getMinY());            AffineTransform imageTransform = new AffineTransform(at);            imageTransform.scale(1.0 / mask.getWidth(), -1.0 / mask.getHeight());            imageTransform.translate(0, -mask.getHeight());            g.drawImage(mask, imageTransform, null);            g.dispose();                        final int[] transparent = new int[4];            int[] alphaPixel = null;            WritableRaster raster = renderedPaint.getRaster();            WritableRaster alpha = renderedMask.getRaster();            int h = renderedMask.getRaster().getHeight();            int w = renderedMask.getRaster().getWidth();            for (int y = 0; y < h; y++) {                for (int x = 0; x < w; x++) {                    alphaPixel = alpha.getPixel(x, y, alphaPixel);                    if (alphaPixel[0] == 255) {                        raster.setPixel(x, y, transparent);                    }                }            }                        setClip();            graphics.setComposite(getGraphicsState().getNonStrokingJavaComposite());            if (isContentRendered()) {                graphics.drawImage(renderedPaint, AffineTransform.getTranslateInstance(bounds.getMinX(), bounds.getMinY()), null);            }        } else {                        BufferedImage image = pdImage.getStencilImage(getNonStrokingPaint());                        drawBufferedImage(image, at);        }    } else {        if (subsamplingAllowed) {            int subsampling = getSubsampling(pdImage, at);                        drawBufferedImage(pdImage.getImage(null, subsampling), at);        } else {                        drawBufferedImage(pdImage.getImage(), at);        }    }    if (!pdImage.getInterpolate()) {                        setRenderingHints();    }}
private int pdfbox_f7566_0(PDImage pdImage, AffineTransform at)
{        double scale = Math.abs(at.getDeterminant() * xform.getDeterminant());    int subsampling = (int) Math.floor(Math.sqrt(pdImage.getWidth() * pdImage.getHeight() / scale));    if (subsampling > 8) {        subsampling = 8;    }    if (subsampling < 1) {        subsampling = 1;    }    if (subsampling > pdImage.getWidth() || subsampling > pdImage.getHeight()) {                        subsampling = Math.min(pdImage.getWidth(), pdImage.getHeight());    }    return subsampling;}
private void pdfbox_f7567_0(BufferedImage image, AffineTransform at) throws IOException
{    graphics.setComposite(getGraphicsState().getNonStrokingJavaComposite());    setClip();    AffineTransform imageTransform = new AffineTransform(at);    PDSoftMask softMask = getGraphicsState().getSoftMask();    if (softMask != null) {        imageTransform.scale(1, -1);        imageTransform.translate(0, -1);        Paint awtPaint = new TexturePaint(image, new Rectangle2D.Double(imageTransform.getTranslateX(), imageTransform.getTranslateY(), imageTransform.getScaleX(), imageTransform.getScaleY()));        awtPaint = applySoftMaskToPaint(awtPaint, softMask);        graphics.setPaint(awtPaint);        Rectangle2D unitRect = new Rectangle2D.Float(0, 0, 1, 1);        if (isContentRendered()) {            graphics.fill(at.createTransformedShape(unitRect));        }    } else {        COSBase transfer = getGraphicsState().getTransfer();        if (transfer instanceof COSArray || transfer instanceof COSDictionary) {            image = applyTransferFunction(image, transfer);        }        int width = image.getWidth();        int height = image.getHeight();        imageTransform.scale(1.0 / width, -1.0 / height);        imageTransform.translate(0, -height);        if (isContentRendered()) {            graphics.drawImage(image, imageTransform, null);        }    }}
private BufferedImage pdfbox_f7568_0(BufferedImage image, COSBase transfer) throws IOException
{    BufferedImage bim;    if (image.getColorModel().hasAlpha()) {        bim = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);    } else {        bim = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);    }            Integer[] rMap;    Integer[] gMap;    Integer[] bMap;    PDFunction rf;    PDFunction gf;    PDFunction bf;    if (transfer instanceof COSArray) {        COSArray ar = (COSArray) transfer;        rf = PDFunction.create(ar.getObject(0));        gf = PDFunction.create(ar.getObject(1));        bf = PDFunction.create(ar.getObject(2));        rMap = new Integer[256];        gMap = new Integer[256];        bMap = new Integer[256];    } else {        rf = PDFunction.create(transfer);        gf = rf;        bf = rf;        rMap = new Integer[256];        gMap = rMap;        bMap = rMap;    }        float[] input = new float[1];    for (int x = 0; x < image.getWidth(); ++x) {        for (int y = 0; y < image.getHeight(); ++y) {            int rgb = image.getRGB(x, y);            int ri = (rgb >> 16) & 0xFF;            int gi = (rgb >> 8) & 0xFF;            int bi = rgb & 0xFF;            int ro;            int go;            int bo;            if (rMap[ri] != null) {                ro = rMap[ri];            } else {                input[0] = (ri & 0xFF) / 255f;                ro = (int) (rf.eval(input)[0] * 255);                rMap[ri] = ro;            }            if (gMap[gi] != null) {                go = gMap[gi];            } else {                input[0] = (gi & 0xFF) / 255f;                go = (int) (gf.eval(input)[0] * 255);                gMap[gi] = go;            }            if (bMap[bi] != null) {                bo = bMap[bi];            } else {                input[0] = (bi & 0xFF) / 255f;                bo = (int) (bf.eval(input)[0] * 255);                bMap[bi] = bo;            }            bim.setRGB(x, y, (rgb & 0xFF000000) | (ro << 16) | (go << 8) | bo);        }    }    return bim;}
public void pdfbox_f7569_1(COSName shadingName) throws IOException
{    PDShading shading = getResources().getShading(shadingName);    if (shading == null) {                return;    }    Matrix ctm = getGraphicsState().getCurrentTransformationMatrix();    Paint paint = shading.toPaint(ctm);    paint = applySoftMaskToPaint(paint, getGraphicsState().getSoftMask());    graphics.setComposite(getGraphicsState().getNonStrokingJavaComposite());    graphics.setPaint(paint);    graphics.setClip(null);    lastClip = null;            PDRectangle bbox = shading.getBBox();    Area area;    if (bbox != null) {        area = new Area(bbox.transform(ctm));        area.intersect(getGraphicsState().getCurrentClippingPath());    } else {        area = getGraphicsState().getCurrentClippingPath();    }    if (isContentRendered()) {        graphics.fill(area);    }}
public void pdfbox_f7570_0(PDAnnotation annotation) throws IOException
{    lastClip = null;    int deviceType = -1;    if (graphics.getDeviceConfiguration() != null && graphics.getDeviceConfiguration().getDevice() != null) {        deviceType = graphics.getDeviceConfiguration().getDevice().getType();    }    if (deviceType == GraphicsDevice.TYPE_PRINTER && !annotation.isPrinted()) {        return;    }    if (deviceType == GraphicsDevice.TYPE_RASTER_SCREEN && annotation.isNoView()) {        return;    }    if (annotation.isHidden()) {        return;    }    if (annotation.isInvisible() && annotation instanceof PDAnnotationUnknown) {                return;    }    if (isHiddenOCG(annotation.getOptionalContent())) {        return;    }    PDAppearanceDictionary appearance = annotation.getAppearance();    if (appearance == null || appearance.getNormalAppearance() == null) {        annotation.constructAppearances(renderer.document);    }    if (annotation.isNoRotate() && getCurrentPage().getRotation() != 0) {        PDRectangle rect = annotation.getRectangle();        AffineTransform savedTransform = graphics.getTransform();                        graphics.rotate(Math.toRadians(getCurrentPage().getRotation()), rect.getLowerLeftX(), rect.getUpperRightY());        super.showAnnotation(annotation);        graphics.setTransform(savedTransform);    } else {        super.showAnnotation(annotation);    }}
public void pdfbox_f7571_0(PDFormXObject form) throws IOException
{    if (isContentRendered()) {        super.showForm(form);    }}
public void pdfbox_f7572_1(PDTransparencyGroup form) throws IOException
{    if (!isContentRendered()) {        return;    }    TransparencyGroup group = new TransparencyGroup(form, false, getGraphicsState().getCurrentTransformationMatrix(), null);    BufferedImage image = group.getImage();    if (image == null) {                return;    }    graphics.setComposite(getGraphicsState().getNonStrokingJavaComposite());    setClip();            PDRectangle bbox = group.getBBox();    AffineTransform savedTransform = graphics.getTransform();    Matrix m = new Matrix(xform);    float xScale = Math.abs(m.getScalingFactorX());    float yScale = Math.abs(m.getScalingFactorY());    AffineTransform transform = new AffineTransform(xform);    transform.scale(1.0 / xScale, 1.0 / yScale);    graphics.setTransform(transform);        float x = bbox.getLowerLeftX() - pageSize.getLowerLeftX();    float y = pageSize.getUpperRightY() - bbox.getUpperRightY();    if (flipTG) {        graphics.translate(0, image.getHeight());        graphics.scale(1, -1);    } else {        graphics.translate(x * xScale, y * yScale);    }    PDSoftMask softMask = getGraphicsState().getSoftMask();    if (softMask != null) {        Paint awtPaint = new TexturePaint(image, new Rectangle2D.Float(0, 0, image.getWidth(), image.getHeight()));        awtPaint = applySoftMaskToPaint(awtPaint, softMask);        graphics.setPaint(awtPaint);        if (isContentRendered()) {            graphics.fill(new Rectangle2D.Float(0, 0, bbox.getWidth() * xScale, bbox.getHeight() * yScale));        }    } else {        if (isContentRendered()) {            try {                graphics.drawImage(image, null, null);            } catch (InternalError ie) {                            }        }    }    graphics.setTransform(savedTransform);}
private BufferedImage pdfbox_f7573_0(int width, int height)
{    /**     * gray + alpha     */    int[] bandOffsets = new int[] { 1, 0 };    int bands = bandOffsets.length;    /**     * Color Model used for raw GRAY + ALPHA     */    final ColorModel CM_GRAY_ALPHA = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_GRAY), true, false, Transparency.TRANSLUCENT, DataBuffer.TYPE_BYTE);        DataBuffer buffer = new DataBufferByte(width * height * bands);        WritableRaster raster = Raster.createInterleavedRaster(buffer, width, height, width * bands, bands, bandOffsets, new Point(0, 0));        return new BufferedImage(CM_GRAY_ALPHA, raster, false, null);}
private boolean pdfbox_f7574_1(PDColorSpace colorSpace)
{    if (colorSpace instanceof PDDeviceGray) {        return true;    }    if (colorSpace instanceof PDICCBased) {        try {            return ((PDICCBased) colorSpace).getAlternateColorSpace() instanceof PDDeviceGray;        } catch (IOException ex) {                        return false;        }    }    return false;}
public BufferedImage pdfbox_f7575_0()
{    return image;}
public PDRectangle pdfbox_f7576_0()
{    return bbox;}
public Rectangle2D pdfbox_f7577_0()
{    Point2D size = new Point2D.Double(pageSize.getWidth(), pageSize.getHeight());        AffineTransform dpiTransform = AffineTransform.getScaleInstance(scaleX, scaleY);    size = dpiTransform.transform(size, size);        return new Rectangle2D.Double(minX - pageSize.getLowerLeftX() * scaleX, size.getY() - minY - height + pageSize.getLowerLeftY() * scaleY, width, height);}
private boolean pdfbox_f7578_0(PDTransparencyGroup group, Set<COSBase> groupsDone)
{    if (groupsDone.contains(group.getCOSObject())) {                return false;    }    groupsDone.add(group.getCOSObject());    PDResources resources = group.getResources();    if (resources == null) {        return false;    }    for (COSName name : resources.getExtGStateNames()) {        PDExtendedGraphicsState extGState = resources.getExtGState(name);        if (extGState == null) {            continue;        }        BlendMode blendMode = extGState.getBlendMode();        if (blendMode != BlendMode.NORMAL) {            return true;        }    }        for (COSName name : resources.getXObjectNames()) {        PDXObject xObject;        try {            xObject = resources.getXObject(name);        } catch (IOException ex) {            continue;        }        if (xObject instanceof PDTransparencyGroup && hasBlendMode((PDTransparencyGroup) xObject, groupsDone)) {            return true;        }    }    return false;}
public void pdfbox_f7579_0(COSName tag, COSDictionary properties)
{    if (nestedHiddenOCGCount > 0) {        nestedHiddenOCGCount++;        return;    }    if (tag == null || getPage().getResources() == null) {        return;    }    if (isHiddenOCG(getPage().getResources().getProperties(tag))) {        nestedHiddenOCGCount = 1;    }}
public void pdfbox_f7580_0()
{    if (nestedHiddenOCGCount > 0) {        nestedHiddenOCGCount--;    }}
private boolean pdfbox_f7581_0()
{    return nestedHiddenOCGCount <= 0;}
private boolean pdfbox_f7582_0(PDPropertyList propertyList)
{    if (propertyList instanceof PDOptionalContentGroup) {        PDOptionalContentGroup group = (PDOptionalContentGroup) propertyList;        RenderState printState = group.getRenderState(destination);        if (printState == null) {            if (!getRenderer().isGroupEnabled(group)) {                return true;            }        } else if (RenderState.OFF.equals(printState)) {            return true;        }    } else if (propertyList instanceof PDOptionalContentMembershipDictionary) {        return isHiddenOCMD((PDOptionalContentMembershipDictionary) propertyList);    }    return false;}
private boolean pdfbox_f7583_1(PDOptionalContentMembershipDictionary ocmd)
{    if (ocmd.getCOSObject().getCOSArray(COSName.VE) != null) {                    }    List<Boolean> visibles = new ArrayList<>();    for (PDPropertyList prop : ocmd.getOCGs()) {        visibles.add(!isHiddenOCG(prop));    }    COSName visibilityPolicy = ocmd.getVisibilityPolicy();    if (COSName.ANY_OFF.equals(visibilityPolicy)) {        for (boolean visible : visibles) {            if (!visible) {                return true;            }        }        return false;    }    if (COSName.ALL_ON.equals(visibilityPolicy)) {        for (boolean visible : visibles) {            if (!visible) {                return true;            }        }        return false;    }    if (COSName.ALL_OFF.equals(visibilityPolicy)) {        for (boolean visible : visibles) {            if (visible) {                return false;            }        }        return true;    }        for (boolean visible : visibles) {        if (visible) {            return false;        }    }    return true;}
private static int pdfbox_f7584_0()
{        String version = System.getProperty("java.specification.version");    final StringTokenizer st = new StringTokenizer(version, ".");    try {        int major = Integer.parseInt(st.nextToken());        int minor = 0;        if (st.hasMoreTokens()) {            minor = Integer.parseInt(st.nextToken());        }        return major == 1 ? minor : major;    } catch (NumberFormatException nfe) {                return 0;    }}
public PDPage pdfbox_f7585_0()
{    return page;}
 PDFRenderer pdfbox_f7586_0()
{    return renderer;}
public boolean pdfbox_f7587_0()
{    return subsamplingAllowed;}
public RenderDestination pdfbox_f7588_0()
{    return this.destination;}
public RenderingHints pdfbox_f7589_0()
{    return renderingHints;}
public AnnotationFilter pdfbox_f7590_0()
{    return annotationFilter;}
public void pdfbox_f7591_0(AnnotationFilter annotationsFilter)
{    this.annotationFilter = annotationsFilter;}
public boolean pdfbox_f7592_0()
{    return subsamplingAllowed;}
public void pdfbox_f7593_0(boolean subsamplingAllowed)
{    this.subsamplingAllowed = subsamplingAllowed;}
public RenderDestination pdfbox_f7594_0()
{    return defaultDestination;}
public void pdfbox_f7595_0(RenderDestination defaultDestination)
{    this.defaultDestination = defaultDestination;}
public RenderingHints pdfbox_f7596_0()
{    return renderingHints;}
public void pdfbox_f7597_0(RenderingHints renderingHints)
{    this.renderingHints = renderingHints;}
public BufferedImage pdfbox_f7598_0(int pageIndex) throws IOException
{    return renderImage(pageIndex, 1);}
public BufferedImage pdfbox_f7599_0(int pageIndex, float scale) throws IOException
{    return renderImage(pageIndex, scale, ImageType.RGB);}
public BufferedImage pdfbox_f7600_0(int pageIndex, float dpi) throws IOException
{    return renderImage(pageIndex, dpi / 72f, ImageType.RGB);}
public BufferedImage pdfbox_f7601_0(int pageIndex, float dpi, ImageType imageType) throws IOException
{    return renderImage(pageIndex, dpi / 72f, imageType);}
public BufferedImage pdfbox_f7602_0(int pageIndex, float scale, ImageType imageType) throws IOException
{    return renderImage(pageIndex, scale, imageType, defaultDestination == null ? RenderDestination.EXPORT : defaultDestination);}
public BufferedImage pdfbox_f7603_0(int pageIndex, float scale, ImageType imageType, RenderDestination destination) throws IOException
{    PDPage page = document.getPage(pageIndex);    PDRectangle cropbBox = page.getCropBox();    float widthPt = cropbBox.getWidth();    float heightPt = cropbBox.getHeight();        int widthPx = (int) Math.max(Math.floor(widthPt * scale), 1);    int heightPx = (int) Math.max(Math.floor(heightPt * scale), 1);        if ((long) widthPx * (long) heightPx > Integer.MAX_VALUE) {        throw new IOException(        "Maximum size of image exceeded (w * h * scale) = " + widthPt + " * " + heightPt + " * " + scale + " > " + Integer.MAX_VALUE);    }    int rotationAngle = page.getRotation();    int bimType = imageType.toBufferedImageType();    if (imageType != ImageType.ARGB && hasBlendMode(page)) {                                        bimType = BufferedImage.TYPE_INT_ARGB;    }        BufferedImage image;    if (rotationAngle == 90 || rotationAngle == 270) {        image = new BufferedImage(heightPx, widthPx, bimType);    } else {        image = new BufferedImage(widthPx, heightPx, bimType);    }    pageImage = image;        Graphics2D g = image.createGraphics();    if (image.getType() == BufferedImage.TYPE_INT_ARGB) {        g.setBackground(new Color(0, 0, 0, 0));    } else {        g.setBackground(Color.WHITE);    }    g.clearRect(0, 0, image.getWidth(), image.getHeight());    transform(g, page, scale, scale);        RenderingHints actualRenderingHints = renderingHints == null ? createDefaultRenderingHints(g) : renderingHints;    PageDrawerParameters parameters = new PageDrawerParameters(this, page, subsamplingAllowed, destination, actualRenderingHints);    PageDrawer drawer = createPageDrawer(parameters);    drawer.drawPage(g, page.getCropBox());    g.dispose();    if (image.getType() != imageType.toBufferedImageType()) {                BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), imageType.toBufferedImageType());        Graphics2D dstGraphics = newImage.createGraphics();        dstGraphics.setBackground(Color.WHITE);        dstGraphics.clearRect(0, 0, image.getWidth(), image.getHeight());        dstGraphics.drawImage(image, 0, 0, null);        dstGraphics.dispose();        image = newImage;    }    return image;}
public void pdfbox_f7604_0(int pageIndex, Graphics2D graphics) throws IOException
{    renderPageToGraphics(pageIndex, graphics, 1);}
public void pdfbox_f7605_0(int pageIndex, Graphics2D graphics, float scale) throws IOException
{    renderPageToGraphics(pageIndex, graphics, scale, scale);}
public void pdfbox_f7606_0(int pageIndex, Graphics2D graphics, float scaleX, float scaleY) throws IOException
{    renderPageToGraphics(pageIndex, graphics, scaleX, scaleY, defaultDestination == null ? RenderDestination.VIEW : defaultDestination);}
public void pdfbox_f7607_0(int pageIndex, Graphics2D graphics, float scaleX, float scaleY, RenderDestination destination) throws IOException
{    PDPage page = document.getPage(pageIndex);        transform(graphics, page, scaleX, scaleY);    PDRectangle cropBox = page.getCropBox();    graphics.clearRect(0, 0, (int) cropBox.getWidth(), (int) cropBox.getHeight());        RenderingHints actualRenderingHints = renderingHints == null ? createDefaultRenderingHints(graphics) : renderingHints;    PageDrawerParameters parameters = new PageDrawerParameters(this, page, subsamplingAllowed, destination, actualRenderingHints);    PageDrawer drawer = createPageDrawer(parameters);    drawer.drawPage(graphics, cropBox);}
public boolean pdfbox_f7608_0(PDOptionalContentGroup group)
{    PDOptionalContentProperties ocProperties = document.getDocumentCatalog().getOCProperties();    return ocProperties == null || ocProperties.isGroupEnabled(group);}
private void pdfbox_f7609_0(Graphics2D graphics, PDPage page, float scaleX, float scaleY)
{    graphics.scale(scaleX, scaleY);        int rotationAngle = page.getRotation();    PDRectangle cropBox = page.getCropBox();    if (rotationAngle != 0) {        float translateX = 0;        float translateY = 0;        switch(rotationAngle) {            case 90:                translateX = cropBox.getHeight();                break;            case 270:                translateY = cropBox.getWidth();                break;            case 180:                translateX = cropBox.getWidth();                translateY = cropBox.getHeight();                break;            default:                break;        }        graphics.translate(translateX, translateY);        graphics.rotate(Math.toRadians(rotationAngle));    }}
private boolean pdfbox_f7610_0(Graphics2D graphics)
{    GraphicsConfiguration deviceConfiguration = graphics.getDeviceConfiguration();    if (deviceConfiguration == null) {        return false;    }    GraphicsDevice device = deviceConfiguration.getDevice();    if (device == null) {        return false;    }    DisplayMode displayMode = device.getDisplayMode();    if (displayMode == null) {        return false;    }    return displayMode.getBitDepth() == 1;}
private RenderingHints pdfbox_f7611_0(Graphics2D graphics)
{    RenderingHints r = new RenderingHints(null);    r.put(RenderingHints.KEY_INTERPOLATION, isBitonal(graphics) ? RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR : RenderingHints.VALUE_INTERPOLATION_BICUBIC);    r.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);    r.put(RenderingHints.KEY_ANTIALIASING, isBitonal(graphics) ? RenderingHints.VALUE_ANTIALIAS_OFF : RenderingHints.VALUE_ANTIALIAS_ON);    return r;}
protected PageDrawer pdfbox_f7612_0(PageDrawerParameters parameters) throws IOException
{    PageDrawer pageDrawer = new PageDrawer(parameters);    pageDrawer.setAnnotationFilter(annotationFilter);    return pageDrawer;}
private boolean pdfbox_f7613_0(PDPage page)
{        PDResources resources = page.getResources();    if (resources == null) {        return false;    }    for (COSName name : resources.getExtGStateNames()) {        PDExtendedGraphicsState extGState = resources.getExtGState(name);        if (extGState == null) {                        continue;        }        BlendMode blendMode = extGState.getBlendMode();        if (blendMode != BlendMode.NORMAL) {            return true;        }    }    return false;}
 BufferedImage pdfbox_f7614_0()
{    return pageImage;}
private static void pdfbox_f7615_1()
{    String cmmProperty = System.getProperty("sun.java2d.cmm");    if (!"sun.java2d.cmm.kcms.KcmsServiceProvider".equals(cmmProperty)) {        try {                        Class.forName("sun.java2d.cmm.kcms.KcmsServiceProvider");            String version = System.getProperty("java.version");            if (version == null || isGoodVersion(version, "1.8.0_(\\d+)", 191) || isGoodVersion(version, "9.0.(\\d+)", 4)) {                return;            }                                                                                } catch (ClassNotFoundException e) {                }    }}
private static boolean pdfbox_f7616_0(String version, String regex, int min)
{    Matcher matcher = Pattern.compile(regex).matcher(version);    if (matcher.matches() && matcher.groupCount() >= 1) {        try {            int v = Integer.parseInt(matcher.group(1));            if (v >= min) {                                return true;            }        } catch (NumberFormatException ex) {            return true;        }    }    return false;}
public PaintContext pdfbox_f7617_0(ColorModel cm, Rectangle deviceBounds, Rectangle2D userBounds, AffineTransform xform, RenderingHints hints)
{    PaintContext ctx = paint.createContext(cm, deviceBounds, userBounds, xform, hints);    return new SoftPaintContext(ctx);}
public int pdfbox_f7618_0()
{    return TRANSLUCENT;}
public ColorModel pdfbox_f7619_0()
{    return ARGB_COLOR_MODEL;}
public Raster pdfbox_f7620_1(int x1, int y1, int w, int h)
{    Raster raster = context.getRaster(x1, y1, w, h);    ColorModel rasterCM = context.getColorModel();    float[] input = null;    Float[] map = null;    if (transferFunction != null) {        map = new Float[256];        input = new float[1];    }        WritableRaster output = getColorModel().createCompatibleWritableRaster(w, h);        x1 = x1 - (int) bboxDevice.getX();    y1 = y1 - (int) bboxDevice.getY();    int[] gray = new int[4];    Object pixelInput = null;    int[] pixelOutput = new int[4];    for (int y = 0; y < h; y++) {        for (int x = 0; x < w; x++) {            pixelInput = raster.getDataElements(x, y, pixelInput);            pixelOutput[0] = rasterCM.getRed(pixelInput);            pixelOutput[1] = rasterCM.getGreen(pixelInput);            pixelOutput[2] = rasterCM.getBlue(pixelInput);            pixelOutput[3] = rasterCM.getAlpha(pixelInput);                        gray[0] = 0;            if (x1 + x >= 0 && y1 + y >= 0 && x1 + x < mask.getWidth() && y1 + y < mask.getHeight()) {                mask.getRaster().getPixel(x1 + x, y1 + y, gray);                int g = gray[0];                if (transferFunction != null) {                                        try {                        if (map[g] != null) {                                                        pixelOutput[3] = Math.round(pixelOutput[3] * map[g]);                        } else {                                                        input[0] = g / 255f;                            float f = transferFunction.eval(input)[0];                            map[g] = f;                            pixelOutput[3] = Math.round(pixelOutput[3] * f);                        }                    } catch (IOException ex) {                                                                        pixelOutput[3] = Math.round(pixelOutput[3] * (bc / 255f));                    }                } else {                    pixelOutput[3] = Math.round(pixelOutput[3] * (g / 255f));                }            } else {                pixelOutput[3] = Math.round(pixelOutput[3] * (bc / 255f));            }            output.setPixel(x, y, pixelOutput);        }    }    return output;}
public PaintContext pdfbox_f7622_0(ColorModel cm, Rectangle deviceBounds, Rectangle2D userBounds, AffineTransform xform, RenderingHints hints)
{    AffineTransform xformPattern = (AffineTransform) xform.clone();        AffineTransform patternNoScale = patternMatrix.createAffineTransform();    patternNoScale.scale(1 / patternMatrix.getScalingFactorX(), 1 / patternMatrix.getScalingFactorY());    xformPattern.concatenate(patternNoScale);    return paint.createContext(cm, deviceBounds, userBounds, xformPattern, hints);}
private BufferedImage pdfbox_f7623_0(PageDrawer drawer, PDTilingPattern pattern, PDColorSpace colorSpace, PDColor color, AffineTransform xform, Rectangle2D anchorRect) throws IOException
{    float width = (float) Math.abs(anchorRect.getWidth());    float height = (float) Math.abs(anchorRect.getHeight());        Matrix xformMatrix = new Matrix(xform);    float xScale = Math.abs(xformMatrix.getScalingFactorX());    float yScale = Math.abs(xformMatrix.getScalingFactorY());    width *= xScale;    height *= yScale;    int rasterWidth = Math.max(1, ceiling(width));    int rasterHeight = Math.max(1, ceiling(height));    BufferedImage image = new BufferedImage(rasterWidth, rasterHeight, BufferedImage.TYPE_INT_ARGB);    Graphics2D graphics = image.createGraphics();        if (pattern.getYStep() < 0) {        graphics.translate(0, rasterHeight);        graphics.scale(1, -1);    }        if (pattern.getXStep() < 0) {        graphics.translate(rasterWidth, 0);        graphics.scale(-1, 1);    }        graphics.scale(xScale, yScale);            Matrix newPatternMatrix;    newPatternMatrix = Matrix.getScaleInstance(Math.abs(patternMatrix.getScalingFactorX()), Math.abs(patternMatrix.getScalingFactorY()));        newPatternMatrix.concatenate(Matrix.getTranslateInstance(-pattern.getBBox().getLowerLeftX(), -pattern.getBBox().getLowerLeftY()));        drawer.drawTilingPattern(graphics, pattern, colorSpace, color, newPatternMatrix);    graphics.dispose();    return image;}
private static int pdfbox_f7624_0(double num)
{    BigDecimal decimal = new BigDecimal(num);        decimal = decimal.setScale(5, RoundingMode.CEILING);    return decimal.intValue();}
public int pdfbox_f7625_0()
{    return Transparency.TRANSLUCENT;}
private Rectangle2D pdfbox_f7626_1(PDTilingPattern pattern)
{    float xStep = pattern.getXStep();    if (Float.compare(xStep, 0) == 0) {        xStep = pattern.getBBox().getWidth();    }    float yStep = pattern.getYStep();    if (Float.compare(yStep, 0) == 0) {        yStep = pattern.getBBox().getHeight();    }    float xScale = patternMatrix.getScalingFactorX();    float yScale = patternMatrix.getScalingFactorY();    float width = xStep * xScale;    float height = yStep * yScale;    if (Math.abs(width * height) > MAXEDGE * MAXEDGE) {                                                                width = Math.min(MAXEDGE, Math.abs(width)) * Math.signum(width);        height = Math.min(MAXEDGE, Math.abs(height)) * Math.signum(height);        }        PDRectangle anchor = pattern.getBBox();    return new Rectangle2D.Float(anchor.getLowerLeftX() * xScale, anchor.getLowerLeftY() * yScale, width, height);}
 Paint pdfbox_f7627_0(PDTilingPattern pattern, PDColorSpace colorSpace, PDColor color, AffineTransform xform) throws IOException
{    Paint paint = null;    TilingPaintParameter tilingPaintParameter = new TilingPaintParameter(drawer.getInitialMatrix(), pattern.getCOSObject(), colorSpace, color, xform);    WeakReference<Paint> weakRef = weakCache.get(tilingPaintParameter);    if (weakRef != null) {                paint = weakRef.get();    }    if (paint == null) {        paint = new TilingPaint(drawer, pattern, colorSpace, color, xform);        weakCache.put(tilingPaintParameter, new WeakReference<>(paint));    }    return paint;}
public boolean pdfbox_f7628_1(Object obj)
{    if (this == obj) {        return true;    }    if (!(obj instanceof TilingPaintParameter)) {        return false;    }    final TilingPaintParameter other = (TilingPaintParameter) obj;    if (this.matrix != other.matrix && (this.matrix == null || !this.matrix.equals(other.matrix))) {        return false;    }    if (this.patternDict != other.patternDict && (this.patternDict == null || !this.patternDict.equals(other.patternDict))) {        return false;    }    if (this.colorSpace != other.colorSpace && (this.colorSpace == null || !this.colorSpace.equals(other.colorSpace))) {        return false;    }    if (this.color == null && other.color != null) {        return false;    }    if (this.color != null && other.color == null) {        return false;    }    if (this.color != null && this.color.getColorSpace() != other.color.getColorSpace()) {        return false;    }    try {        if (this.color != other.color && this.color.toRGB() != other.color.toRGB()) {            return false;        }    } catch (IOException ex) {                return false;    }    return !(this.xform != other.xform && (this.xform == null || !this.xform.equals(other.xform)));}
public int pdfbox_f7629_0()
{    int hash = 7;    hash = 23 * hash + (this.matrix != null ? this.matrix.hashCode() : 0);    hash = 23 * hash + (this.patternDict != null ? this.patternDict.hashCode() : 0);    hash = 23 * hash + (this.colorSpace != null ? this.colorSpace.hashCode() : 0);    hash = 23 * hash + (this.color != null ? this.color.hashCode() : 0);    hash = 23 * hash + (this.xform != null ? this.xform.hashCode() : 0);    return hash;}
public String pdfbox_f7630_0()
{    return "TilingPaintParameter{" + "matrix=" + matrix + ", pattern=" + patternDict + ", colorSpace=" + colorSpace + ", color=" + color + ", xform=" + xform + '}';}
public void pdfbox_f7631_0(PDPage page) throws IOException
{    this.pageRotation = page.getRotation();    this.pageSize = page.getCropBox();    if (Float.compare(pageSize.getLowerLeftX(), 0) == 0 && Float.compare(pageSize.getLowerLeftY(), 0) == 0) {        translateMatrix = null;    } else {                translateMatrix = Matrix.getTranslateInstance(-pageSize.getLowerLeftX(), -pageSize.getLowerLeftY());    }    super.processPage(page);}
protected void pdfbox_f7632_1(Matrix textRenderingMatrix, PDFont font, int code, String unicode, Vector displacement) throws IOException
{                            PDGraphicsState state = getGraphicsState();    Matrix ctm = state.getCurrentTransformationMatrix();    float fontSize = state.getTextState().getFontSize();    float horizontalScaling = state.getTextState().getHorizontalScaling() / 100f;    Matrix textMatrix = getTextMatrix();    BoundingBox bbox = font.getBoundingBox();    if (bbox.getLowerLeftY() < Short.MIN_VALUE) {                        bbox.setLowerLeftY(-(bbox.getLowerLeftY() + 65536));    }        float glyphHeight = bbox.getHeight() / 2;        PDFontDescriptor fontDescriptor = font.getFontDescriptor();    if (fontDescriptor != null) {        float capHeight = fontDescriptor.getCapHeight();        if (Float.compare(capHeight, 0) != 0 && (capHeight < glyphHeight || Float.compare(glyphHeight, 0) == 0)) {            glyphHeight = capHeight;        }                        float ascent = fontDescriptor.getAscent();        float descent = fontDescriptor.getDescent();        if (capHeight > ascent && ascent > 0 && descent < 0 && ((ascent - descent) / 2 < glyphHeight || Float.compare(glyphHeight, 0) == 0)) {            glyphHeight = (ascent - descent) / 2;        }    }        float height;    if (font instanceof PDType3Font) {        height = font.getFontMatrix().transformPoint(0, glyphHeight).y;    } else {        height = glyphHeight / 1000;    }    float displacementX = displacement.getX();        if (font.isVertical()) {        displacementX = font.getWidth(code) / 1000;                TrueTypeFont ttf = null;        if (font instanceof PDTrueTypeFont) {            ttf = ((PDTrueTypeFont) font).getTrueTypeFont();        } else if (font instanceof PDType0Font) {            PDCIDFont cidFont = ((PDType0Font) font).getDescendantFont();            if (cidFont instanceof PDCIDFontType2) {                ttf = ((PDCIDFontType2) cidFont).getTrueTypeFont();            }        }        if (ttf != null && ttf.getUnitsPerEm() != 1000) {            displacementX *= 1000f / ttf.getUnitsPerEm();        }    }                                    float tx = displacementX * fontSize * horizontalScaling;    float ty = displacement.getY() * fontSize;        Matrix td = Matrix.getTranslateInstance(tx, ty);            Matrix nextTextRenderingMatrix = td.multiply(textMatrix).multiply(ctm);    float nextX = nextTextRenderingMatrix.getTranslateX();    float nextY = nextTextRenderingMatrix.getTranslateY();        float dxDisplay = nextX - textRenderingMatrix.getTranslateX();    float dyDisplay = height * textRenderingMatrix.getScalingFactorY();                                    float glyphSpaceToTextSpaceFactor = 1 / 1000f;    if (font instanceof PDType3Font) {        glyphSpaceToTextSpaceFactor = font.getFontMatrix().getScaleX();    }    float spaceWidthText = 0;    try {                spaceWidthText = font.getSpaceWidth() * glyphSpaceToTextSpaceFactor;    } catch (Exception exception) {            }    if (Float.compare(spaceWidthText, 0) == 0) {        spaceWidthText = font.getAverageFontWidth() * glyphSpaceToTextSpaceFactor;                spaceWidthText *= .80f;    }    if (Float.compare(spaceWidthText, 0) == 0) {                spaceWidthText = 1.0f;    }        float spaceWidthDisplay = spaceWidthText * textRenderingMatrix.getScalingFactorX();        unicode = font.toUnicode(code, glyphList);        if (unicode == null) {        if (font instanceof PDSimpleFont) {            char c = (char) code;            unicode = new String(new char[] { c });        } else {                        return;        }    }        Matrix translatedTextRenderingMatrix;    if (translateMatrix == null) {        translatedTextRenderingMatrix = textRenderingMatrix;    } else {        translatedTextRenderingMatrix = Matrix.concatenate(translateMatrix, textRenderingMatrix);        nextX -= pageSize.getLowerLeftX();        nextY -= pageSize.getLowerLeftY();    }    processTextPosition(new TextPosition(pageRotation, pageSize.getWidth(), pageSize.getHeight(), translatedTextRenderingMatrix, nextX, nextY, Math.abs(dyDisplay), dxDisplay, Math.abs(spaceWidthDisplay), unicode, new int[] { code }, font, fontSize, (int) (fontSize * textMatrix.getScalingFactorX())));}
private boolean pdfbox_f7634_0(float first, float second, float variance)
{    return second > first - variance && second < first + variance;}
public void pdfbox_f7635_0(COSName tag, COSDictionary properties)
{    PDMarkedContent markedContent = PDMarkedContent.create(tag, properties);    if (this.currentMarkedContents.isEmpty()) {        this.markedContents.add(markedContent);    } else {        PDMarkedContent currentMarkedContent = this.currentMarkedContents.peek();        if (currentMarkedContent != null) {            currentMarkedContent.addMarkedContent(markedContent);        }    }    this.currentMarkedContents.push(markedContent);}
public void pdfbox_f7636_0()
{    if (!this.currentMarkedContents.isEmpty()) {        this.currentMarkedContents.pop();    }}
public void pdfbox_f7637_0(PDXObject xobject)
{    if (!this.currentMarkedContents.isEmpty()) {        this.currentMarkedContents.peek().addXObject(xobject);    }}
protected void pdfbox_f7638_0(TextPosition text)
{    boolean showCharacter = true;    if (this.suppressDuplicateOverlappingText) {        showCharacter = false;        String textCharacter = text.getUnicode();        float textX = text.getX();        float textY = text.getY();        List<TextPosition> sameTextCharacters = this.characterListMapping.get(textCharacter);        if (sameTextCharacters == null) {            sameTextCharacters = new ArrayList<>();            this.characterListMapping.put(textCharacter, sameTextCharacters);        }                                                                                                boolean suppressCharacter = false;        float tolerance = (text.getWidth() / textCharacter.length()) / 3.0f;        for (TextPosition sameTextCharacter : sameTextCharacters) {            TextPosition character = sameTextCharacter;            String charCharacter = character.getUnicode();            float charX = character.getX();            float charY = character.getY();                        if (charCharacter != null &&             within(charX, textX, tolerance) && within(charY, textY, tolerance)) {                suppressCharacter = true;                break;            }        }        if (!suppressCharacter) {            sameTextCharacters.add(text);            showCharacter = true;        }    }    if (showCharacter) {        List<TextPosition> textList = new ArrayList<>();        /* In the wild, some PDF encoded documents put diacritics (accents on             * top of characters) into a separate Tj element.  When displaying them             * graphically, the two chunks get overlayed.  With text output though,             * we need to do the overlay. This code recombines the diacritic with             * its associated character if the two are consecutive.             */        if (textList.isEmpty()) {            textList.add(text);        } else {            /* test if we overlap the previous entry.                   * Note that we are making an assumption that we need to only look back                 * one TextPosition to find what we are overlapping.                   * This may not always be true. */            TextPosition previousTextPosition = textList.get(textList.size() - 1);            if (text.isDiacritic() && previousTextPosition.contains(text)) {                previousTextPosition.mergeDiacritic(text);            } else /* If the previous TextPosition was the diacritic, merge it into this                 * one and remove it from the list. */            if (previousTextPosition.isDiacritic() && text.contains(previousTextPosition)) {                text.mergeDiacritic(previousTextPosition);                textList.remove(textList.size() - 1);                textList.add(text);            } else {                textList.add(text);            }        }        if (!this.currentMarkedContents.isEmpty()) {            this.currentMarkedContents.peek().addText(text);        }    }}
public List<PDMarkedContent> pdfbox_f7639_0()
{    return this.markedContents;}
public String pdfbox_f7640_0(PDDocument doc) throws IOException
{    StringWriter outputStream = new StringWriter();    writeText(doc, outputStream);    return outputStream.toString();}
private void pdfbox_f7641_0()
{    currentPageNo = 0;    document = null;    if (charactersByArticle != null) {        charactersByArticle.clear();    }    if (characterListMapping != null) {        characterListMapping.clear();    }}
public void pdfbox_f7642_0(PDDocument doc, Writer outputStream) throws IOException
{    resetEngine();    document = doc;    output = outputStream;    if (getAddMoreFormatting()) {        paragraphEnd = lineSeparator;        pageStart = lineSeparator;        articleStart = lineSeparator;        articleEnd = lineSeparator;    }    startDocument(document);    processPages(document.getPages());    endDocument(document);}
protected void pdfbox_f7643_0(PDPageTree pages) throws IOException
{    PDPage startBookmarkPage = startBookmark == null ? null : startBookmark.findDestinationPage(document);    if (startBookmarkPage != null) {        startBookmarkPageNumber = pages.indexOf(startBookmarkPage) + 1;    } else {                startBookmarkPageNumber = -1;    }    PDPage endBookmarkPage = endBookmark == null ? null : endBookmark.findDestinationPage(document);    if (endBookmarkPage != null) {        endBookmarkPageNumber = pages.indexOf(endBookmarkPage) + 1;    } else {                endBookmarkPageNumber = -1;    }    if (startBookmarkPageNumber == -1 && startBookmark != null && endBookmarkPageNumber == -1 && endBookmark != null && startBookmark.getCOSObject() == endBookmark.getCOSObject()) {                                startBookmarkPageNumber = 0;        endBookmarkPageNumber = 0;    }    for (PDPage page : pages) {        currentPageNo++;        if (page.hasContents()) {            processPage(page);        }    }}
public void pdfbox_f7646_0(PDPage page) throws IOException
{    if (currentPageNo >= startPage && currentPageNo <= endPage && (startBookmarkPageNumber == -1 || currentPageNo >= startBookmarkPageNumber) && (endBookmarkPageNumber == -1 || currentPageNo <= endBookmarkPageNumber)) {        startPage(page);        int numberOfArticleSections = 1;        if (shouldSeparateByBeads) {            fillBeadRectangles(page);            numberOfArticleSections += beadRectangles.size() * 2;        }        int originalSize = charactersByArticle.size();        charactersByArticle.ensureCapacity(numberOfArticleSections);        int lastIndex = Math.max(numberOfArticleSections, originalSize);        for (int i = 0; i < lastIndex; i++) {            if (i < originalSize) {                charactersByArticle.get(i).clear();            } else {                if (numberOfArticleSections < originalSize) {                    charactersByArticle.remove(i);                } else {                    charactersByArticle.add(new ArrayList<TextPosition>());                }            }        }        characterListMapping.clear();        super.processPage(page);        writePage();        endPage(page);    }}
private void pdfbox_f7647_0(PDPage page)
{    beadRectangles = new ArrayList<>();    for (PDThreadBead bead : page.getThreadBeads()) {        if (bead == null) {                        beadRectangles.add(null);            continue;        }        PDRectangle rect = bead.getRectangle();                                PDRectangle mediaBox = page.getMediaBox();        float upperRightY = mediaBox.getUpperRightY() - rect.getLowerLeftY();        float lowerLeftY = mediaBox.getUpperRightY() - rect.getUpperRightY();        rect.setLowerLeftY(lowerLeftY);        rect.setUpperRightY(upperRightY);                PDRectangle cropBox = page.getCropBox();        if (Float.compare(cropBox.getLowerLeftX(), 0) != 0 || Float.compare(cropBox.getLowerLeftY(), 0) != 0) {            rect.setLowerLeftX(rect.getLowerLeftX() - cropBox.getLowerLeftX());            rect.setLowerLeftY(rect.getLowerLeftY() - cropBox.getLowerLeftY());            rect.setUpperRightX(rect.getUpperRightX() - cropBox.getLowerLeftX());            rect.setUpperRightY(rect.getUpperRightY() - cropBox.getLowerLeftY());        }        beadRectangles.add(rect);    }}
protected void pdfbox_f7648_0() throws IOException
{    startArticle(true);}
protected void pdfbox_f7649_0(boolean isLTR) throws IOException
{    output.write(getArticleStart());}
protected void pdfbox_f7650_0() throws IOException
{    output.write(getArticleEnd());}
protected void pdfbox_f7653_0() throws IOException
{    float maxYForLine = MAX_Y_FOR_LINE_RESET_VALUE;    float minYTopForLine = MIN_Y_TOP_FOR_LINE_RESET_VALUE;    float endOfLastTextX = END_OF_LAST_TEXT_X_RESET_VALUE;    float lastWordSpacing = LAST_WORD_SPACING_RESET_VALUE;    float maxHeightForLine = MAX_HEIGHT_FOR_LINE_RESET_VALUE;    PositionWrapper lastPosition = null;    PositionWrapper lastLineStartPosition = null;        boolean startOfPage = true;    boolean startOfArticle;    if (charactersByArticle.size() > 0) {        writePageStart();    }    for (List<TextPosition> textList : charactersByArticle) {        if (getSortByPosition()) {            TextPositionComparator comparator = new TextPositionComparator();                                                QuickSort.sort(textList, comparator);        }        startArticle();        startOfArticle = true;                                List<LineItem> line = new ArrayList<>();        Iterator<TextPosition> textIter = textList.iterator();                                                                        float previousAveCharWidth = -1;        while (textIter.hasNext()) {            TextPosition position = textIter.next();            PositionWrapper current = new PositionWrapper(position);            String characterValue = position.getUnicode();                        if (lastPosition != null && (position.getFont() != lastPosition.getTextPosition().getFont() || Float.compare(position.getFontSize(), lastPosition.getTextPosition().getFontSize()) != 0)) {                previousAveCharWidth = -1;            }            float positionX;            float positionY;            float positionWidth;            float positionHeight;                        if (getSortByPosition()) {                positionX = position.getXDirAdj();                positionY = position.getYDirAdj();                positionWidth = position.getWidthDirAdj();                positionHeight = position.getHeightDir();            } else {                positionX = position.getX();                positionY = position.getY();                positionWidth = position.getWidth();                positionHeight = position.getHeight();            }                        int wordCharCount = position.getIndividualWidths().length;                                    float wordSpacing = position.getWidthOfSpace();            float deltaSpace;            if (Float.compare(wordSpacing, 0) == 0 || Float.isNaN(wordSpacing)) {                deltaSpace = Float.MAX_VALUE;            } else {                if (lastWordSpacing < 0) {                    deltaSpace = wordSpacing * getSpacingTolerance();                } else {                    deltaSpace = (wordSpacing + lastWordSpacing) / 2f * getSpacingTolerance();                }            }                                                            float averageCharWidth;            if (previousAveCharWidth < 0) {                averageCharWidth = positionWidth / wordCharCount;            } else {                averageCharWidth = (previousAveCharWidth + positionWidth / wordCharCount) / 2f;            }            float deltaCharWidth = averageCharWidth * getAverageCharTolerance();                                    float expectedStartOfNextWordX = EXPECTED_START_OF_NEXT_WORD_X_RESET_VALUE;            if (Float.compare(endOfLastTextX, END_OF_LAST_TEXT_X_RESET_VALUE) != 0) {                expectedStartOfNextWordX = endOfLastTextX + Math.min(deltaSpace, deltaCharWidth);            }            if (lastPosition != null) {                if (startOfArticle) {                    lastPosition.setArticleStart();                    startOfArticle = false;                }                                if (!overlap(positionY, positionHeight, maxYForLine, maxHeightForLine)) {                    writeLine(normalize(line));                    line.clear();                    lastLineStartPosition = handleLineSeparation(current, lastPosition, lastLineStartPosition, maxHeightForLine);                    expectedStartOfNextWordX = EXPECTED_START_OF_NEXT_WORD_X_RESET_VALUE;                    maxYForLine = MAX_Y_FOR_LINE_RESET_VALUE;                    maxHeightForLine = MAX_HEIGHT_FOR_LINE_RESET_VALUE;                    minYTopForLine = MIN_Y_TOP_FOR_LINE_RESET_VALUE;                }                                if (Float.compare(expectedStartOfNextWordX, EXPECTED_START_OF_NEXT_WORD_X_RESET_VALUE) != 0 && expectedStartOfNextWordX < positionX &&                 lastPosition.getTextPosition().getUnicode() != null && !lastPosition.getTextPosition().getUnicode().endsWith(" ")) {                    line.add(LineItem.getWordSeparator());                }            }            if (positionY >= maxYForLine) {                maxYForLine = positionY;            }                                    endOfLastTextX = positionX + positionWidth;                        if (characterValue != null) {                if (startOfPage && lastPosition == null) {                                        writeParagraphStart();                }                line.add(new LineItem(position));            }            maxHeightForLine = Math.max(maxHeightForLine, positionHeight);            minYTopForLine = Math.min(minYTopForLine, positionY - positionHeight);            lastPosition = current;            if (startOfPage) {                lastPosition.setParagraphStart();                lastPosition.setLineStart();                lastLineStartPosition = lastPosition;                startOfPage = false;            }            lastWordSpacing = wordSpacing;            previousAveCharWidth = averageCharWidth;        }                if (line.size() > 0) {            writeLine(normalize(line));            writeParagraphEnd();        }        endArticle();    }    writePageEnd();}
private boolean pdfbox_f7654_0(float y1, float height1, float y2, float height2)
{    return within(y1, y2, .1f) || y2 <= y1 && y2 >= y1 - height1 || y1 <= y2 && y1 >= y2 - height2;}
protected void pdfbox_f7655_0() throws IOException
{    output.write(getLineSeparator());}
protected void pdfbox_f7656_0() throws IOException
{    output.write(getWordSeparator());}
protected void pdfbox_f7657_0(TextPosition text) throws IOException
{    output.write(text.getUnicode());}
protected void pdfbox_f7658_0(String text, List<TextPosition> textPositions) throws IOException
{    writeString(text);}
protected void pdfbox_f7659_0(String text) throws IOException
{    output.write(text);}
private boolean pdfbox_f7660_0(float first, float second, float variance)
{    return second < first + variance && second > first - variance;}
protected void pdfbox_f7661_0(TextPosition text)
{    boolean showCharacter = true;    if (suppressDuplicateOverlappingText) {        showCharacter = false;        String textCharacter = text.getUnicode();        float textX = text.getX();        float textY = text.getY();        TreeMap<Float, TreeSet<Float>> sameTextCharacters = characterListMapping.get(textCharacter);        if (sameTextCharacters == null) {            sameTextCharacters = new TreeMap<>();            characterListMapping.put(textCharacter, sameTextCharacters);        }                                                                                        boolean suppressCharacter = false;        float tolerance = text.getWidth() / textCharacter.length() / 3.0f;        SortedMap<Float, TreeSet<Float>> xMatches = sameTextCharacters.subMap(textX - tolerance, textX + tolerance);        for (TreeSet<Float> xMatch : xMatches.values()) {            SortedSet<Float> yMatches = xMatch.subSet(textY - tolerance, textY + tolerance);            if (!yMatches.isEmpty()) {                suppressCharacter = true;                break;            }        }        if (!suppressCharacter) {            TreeSet<Float> ySet = sameTextCharacters.get(textX);            if (ySet == null) {                ySet = new TreeSet<>();                sameTextCharacters.put(textX, ySet);            }            ySet.add(textY);            showCharacter = true;        }    }    if (showCharacter) {                int foundArticleDivisionIndex = -1;        int notFoundButFirstLeftAndAboveArticleDivisionIndex = -1;        int notFoundButFirstLeftArticleDivisionIndex = -1;        int notFoundButFirstAboveArticleDivisionIndex = -1;        float x = text.getX();        float y = text.getY();        if (shouldSeparateByBeads) {            for (int i = 0; i < beadRectangles.size() && foundArticleDivisionIndex == -1; i++) {                PDRectangle rect = beadRectangles.get(i);                if (rect != null) {                    if (rect.contains(x, y)) {                        foundArticleDivisionIndex = i * 2 + 1;                    } else if ((x < rect.getLowerLeftX() || y < rect.getUpperRightY()) && notFoundButFirstLeftAndAboveArticleDivisionIndex == -1) {                        notFoundButFirstLeftAndAboveArticleDivisionIndex = i * 2;                    } else if (x < rect.getLowerLeftX() && notFoundButFirstLeftArticleDivisionIndex == -1) {                        notFoundButFirstLeftArticleDivisionIndex = i * 2;                    } else if (y < rect.getUpperRightY() && notFoundButFirstAboveArticleDivisionIndex == -1) {                        notFoundButFirstAboveArticleDivisionIndex = i * 2;                    }                } else {                    foundArticleDivisionIndex = 0;                }            }        } else {            foundArticleDivisionIndex = 0;        }        int articleDivisionIndex;        if (foundArticleDivisionIndex != -1) {            articleDivisionIndex = foundArticleDivisionIndex;        } else if (notFoundButFirstLeftAndAboveArticleDivisionIndex != -1) {            articleDivisionIndex = notFoundButFirstLeftAndAboveArticleDivisionIndex;        } else if (notFoundButFirstLeftArticleDivisionIndex != -1) {            articleDivisionIndex = notFoundButFirstLeftArticleDivisionIndex;        } else if (notFoundButFirstAboveArticleDivisionIndex != -1) {            articleDivisionIndex = notFoundButFirstAboveArticleDivisionIndex;        } else {            articleDivisionIndex = charactersByArticle.size() - 1;        }        List<TextPosition> textList = charactersByArticle.get(articleDivisionIndex);                if (textList.isEmpty()) {            textList.add(text);        } else {                                                            TextPosition previousTextPosition = textList.get(textList.size() - 1);            if (text.isDiacritic() && previousTextPosition.contains(text)) {                previousTextPosition.mergeDiacritic(text);            } else             if (previousTextPosition.isDiacritic() && text.contains(previousTextPosition)) {                text.mergeDiacritic(previousTextPosition);                textList.remove(textList.size() - 1);                textList.add(text);            } else {                textList.add(text);            }        }    }}
public int pdfbox_f7662_0()
{    return startPage;}
public void pdfbox_f7663_0(int startPageValue)
{    startPage = startPageValue;}
public int pdfbox_f7664_0()
{    return endPage;}
public void pdfbox_f7665_0(int endPageValue)
{    endPage = endPageValue;}
public void pdfbox_f7666_0(String separator)
{    lineSeparator = separator;}
public String pdfbox_f7667_0()
{    return lineSeparator;}
public String pdfbox_f7668_0()
{    return wordSeparator;}
public void pdfbox_f7669_0(String separator)
{    wordSeparator = separator;}
public boolean pdfbox_f7670_0()
{    return suppressDuplicateOverlappingText;}
protected int pdfbox_f7671_0()
{    return currentPageNo;}
protected Writer pdfbox_f7672_0()
{    return output;}
protected List<List<TextPosition>> pdfbox_f7673_0()
{    return charactersByArticle;}
public void pdfbox_f7674_0(boolean suppressDuplicateOverlappingTextValue)
{    suppressDuplicateOverlappingText = suppressDuplicateOverlappingTextValue;}
public boolean pdfbox_f7675_0()
{    return shouldSeparateByBeads;}
public void pdfbox_f7676_0(boolean aShouldSeparateByBeads)
{    shouldSeparateByBeads = aShouldSeparateByBeads;}
public PDOutlineItem pdfbox_f7677_0()
{    return endBookmark;}
public void pdfbox_f7678_0(PDOutlineItem aEndBookmark)
{    endBookmark = aEndBookmark;}
public PDOutlineItem pdfbox_f7679_0()
{    return startBookmark;}
public void pdfbox_f7680_0(PDOutlineItem aStartBookmark)
{    startBookmark = aStartBookmark;}
public boolean pdfbox_f7681_0()
{    return addMoreFormatting;}
public void pdfbox_f7682_0(boolean newAddMoreFormatting)
{    addMoreFormatting = newAddMoreFormatting;}
public boolean pdfbox_f7683_0()
{    return sortByPosition;}
public void pdfbox_f7684_0(boolean newSortByPosition)
{    sortByPosition = newSortByPosition;}
public float pdfbox_f7685_0()
{    return spacingTolerance;}
public void pdfbox_f7686_0(float spacingToleranceValue)
{    spacingTolerance = spacingToleranceValue;}
public float pdfbox_f7687_0()
{    return averageCharTolerance;}
public void pdfbox_f7688_0(float averageCharToleranceValue)
{    averageCharTolerance = averageCharToleranceValue;}
public float pdfbox_f7689_0()
{    return indentThreshold;}
public void pdfbox_f7690_0(float indentThresholdValue)
{    indentThreshold = indentThresholdValue;}
public float pdfbox_f7691_0()
{    return dropThreshold;}
public void pdfbox_f7692_0(float dropThresholdValue)
{    dropThreshold = dropThresholdValue;}
public String pdfbox_f7693_0()
{    return paragraphStart;}
public void pdfbox_f7694_0(String s)
{    paragraphStart = s;}
public String pdfbox_f7695_0()
{    return paragraphEnd;}
public void pdfbox_f7696_0(String s)
{    paragraphEnd = s;}
public String pdfbox_f7697_0()
{    return pageStart;}
public void pdfbox_f7698_0(String pageStartValue)
{    pageStart = pageStartValue;}
public String pdfbox_f7699_0()
{    return pageEnd;}
public void pdfbox_f7700_0(String pageEndValue)
{    pageEnd = pageEndValue;}
public String pdfbox_f7701_0()
{    return articleStart;}
public void pdfbox_f7702_0(String articleStartValue)
{    articleStart = articleStartValue;}
public String pdfbox_f7703_0()
{    return articleEnd;}
public void pdfbox_f7704_0(String articleEndValue)
{    articleEnd = articleEndValue;}
private PositionWrapper pdfbox_f7705_0(PositionWrapper current, PositionWrapper lastPosition, PositionWrapper lastLineStartPosition, float maxHeightForLine) throws IOException
{    current.setLineStart();    isParagraphSeparation(current, lastPosition, lastLineStartPosition, maxHeightForLine);    lastLineStartPosition = current;    if (current.isParagraphStart()) {        if (lastPosition.isArticleStart()) {            if (lastPosition.isLineStart()) {                writeLineSeparator();            }            writeParagraphStart();        } else {            writeLineSeparator();            writeParagraphSeparator();        }    } else {        writeLineSeparator();    }    return lastLineStartPosition;}
private void pdfbox_f7706_0(PositionWrapper position, PositionWrapper lastPosition, PositionWrapper lastLineStartPosition, float maxHeightForLine)
{    boolean result = false;    if (lastLineStartPosition == null) {        result = true;    } else {        float yGap = Math.abs(position.getTextPosition().getYDirAdj() - lastPosition.getTextPosition().getYDirAdj());        float newYVal = multiplyFloat(getDropThreshold(), maxHeightForLine);                float xGap = position.getTextPosition().getXDirAdj() - lastLineStartPosition.getTextPosition().getXDirAdj();        float newXVal = multiplyFloat(getIndentThreshold(), position.getTextPosition().getWidthOfSpace());        float positionWidth = multiplyFloat(0.25f, position.getTextPosition().getWidth());        if (yGap > newYVal) {            result = true;        } else if (xGap > newXVal) {                        if (!lastLineStartPosition.isParagraphStart()) {                result = true;            } else {                position.setHangingIndent();            }        } else if (xGap < -position.getTextPosition().getWidthOfSpace()) {                        if (!lastLineStartPosition.isParagraphStart()) {                result = true;            }        } else if (Math.abs(xGap) < positionWidth) {                        if (lastLineStartPosition.isHangingIndent()) {                position.setHangingIndent();            } else if (lastLineStartPosition.isParagraphStart()) {                                                Pattern liPattern = matchListItemPattern(lastLineStartPosition);                if (liPattern != null) {                    Pattern currentPattern = matchListItemPattern(position);                    if (liPattern == currentPattern) {                        result = true;                    }                }            }        }    }    if (result) {        position.setParagraphStart();    }}
private float pdfbox_f7707_0(float value1, float value2)
{        return Math.round(value1 * value2 * 1000) / 1000f;}
protected void pdfbox_f7708_0() throws IOException
{    writeParagraphEnd();    writeParagraphStart();}
protected void pdfbox_f7709_0() throws IOException
{    if (inParagraph) {        writeParagraphEnd();        inParagraph = false;    }    output.write(getParagraphStart());    inParagraph = true;}
protected void pdfbox_f7710_0() throws IOException
{    if (!inParagraph) {        writeParagraphStart();    }    output.write(getParagraphEnd());    inParagraph = false;}
protected void pdfbox_f7711_0() throws IOException
{    output.write(getPageStart());}
protected void pdfbox_f7712_0() throws IOException
{    output.write(getPageEnd());}
private Pattern pdfbox_f7713_0(PositionWrapper pw)
{    TextPosition tp = pw.getTextPosition();    String txt = tp.getUnicode();    return matchPattern(txt, getListItemPatterns());}
protected void pdfbox_f7714_0(List<Pattern> patterns)
{    listOfPatterns = patterns;}
protected List<Pattern> pdfbox_f7715_0()
{    if (listOfPatterns == null) {        listOfPatterns = new ArrayList<>();        for (String expression : LIST_ITEM_EXPRESSIONS) {            Pattern p = Pattern.compile(expression);            listOfPatterns.add(p);        }    }    return listOfPatterns;}
protected static Pattern pdfbox_f7716_0(String string, List<Pattern> patterns)
{    for (Pattern p : patterns) {        if (p.matcher(string).matches()) {            return p;        }    }    return null;}
private void pdfbox_f7717_0(List<WordWithTextPositions> line) throws IOException
{    int numberOfStrings = line.size();    for (int i = 0; i < numberOfStrings; i++) {        WordWithTextPositions word = line.get(i);        writeString(word.getText(), word.getTextPositions());        if (i < numberOfStrings - 1) {            writeWordSeparator();        }    }}
private List<WordWithTextPositions> pdfbox_f7718_0(List<LineItem> line)
{    List<WordWithTextPositions> normalized = new LinkedList<>();    StringBuilder lineBuilder = new StringBuilder();    List<TextPosition> wordPositions = new ArrayList<>();    for (LineItem item : line) {        lineBuilder = normalizeAdd(normalized, lineBuilder, wordPositions, item);    }    if (lineBuilder.length() > 0) {        normalized.add(createWord(lineBuilder.toString(), wordPositions));    }    return normalized;}
private String pdfbox_f7719_0(String word)
{    Bidi bidi = new Bidi(word, Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT);        if (!bidi.isMixed() && bidi.getBaseLevel() == Bidi.DIRECTION_LEFT_TO_RIGHT) {        return word;    }        int runCount = bidi.getRunCount();    byte[] levels = new byte[runCount];    Integer[] runs = new Integer[runCount];    for (int i = 0; i < runCount; i++) {        levels[i] = (byte) bidi.getRunLevel(i);        runs[i] = i;    }        Bidi.reorderVisually(levels, 0, runs, 0, runCount);        StringBuilder result = new StringBuilder();    for (int i = 0; i < runCount; i++) {        int index = runs[i];        int start = bidi.getRunStart(index);        int end = bidi.getRunLimit(index);        int level = levels[index];        if ((level & 1) != 0) {            while (--end >= start) {                char character = word.charAt(end);                if (Character.isMirrored(word.codePointAt(end))) {                    if (MIRRORING_CHAR_MAP.containsKey(character)) {                        result.append(MIRRORING_CHAR_MAP.get(character));                    } else {                        result.append(character);                    }                } else {                    result.append(character);                }            }        } else {            result.append(word, start, end);        }    }    return result.toString();}
private static void pdfbox_f7720_0(InputStream inputStream) throws IOException
{    LineNumberReader rd = new LineNumberReader(new InputStreamReader(inputStream));    do {        String s = rd.readLine();        if (s == null) {            break;        }                int comment = s.indexOf('#');        if (comment != -1) {            s = s.substring(0, comment);        }        if (s.length() < 2) {            continue;        }        StringTokenizer st = new StringTokenizer(s, ";");        int nFields = st.countTokens();        Character[] fields = new Character[nFields];        for (int i = 0; i < nFields; i++) {            fields[i] = (char) Integer.parseInt(st.nextToken().trim(), 16);        }        if (fields.length == 2) {                        MIRRORING_CHAR_MAP.put(fields[0], fields[1]);        }    } while (true);}
private WordWithTextPositions pdfbox_f7721_0(String word, List<TextPosition> wordPositions)
{    return new WordWithTextPositions(normalizeWord(word), wordPositions);}
private String pdfbox_f7722_0(String word)
{    StringBuilder builder = null;    int p = 0;    int q = 0;    int strLength = word.length();    for (; q < strLength; q++) {                                                char c = word.charAt(q);        if (0xFB00 <= c && c <= 0xFDFF || 0xFE70 <= c && c <= 0xFEFF) {            if (builder == null) {                builder = new StringBuilder(strLength * 2);            }            builder.append(word.substring(p, q));                        if (c == 0xFDF2 && q > 0 && (word.charAt(q - 1) == 0x0627 || word.charAt(q - 1) == 0xFE8D)) {                builder.append("\u0644\u0644\u0647");            } else {                                builder.append(Normalizer.normalize(word.substring(q, q + 1), Normalizer.Form.NFKC).trim());            }            p = q + 1;        }    }    if (builder == null) {        return handleDirection(word);    } else {        builder.append(word.substring(p, q));        return handleDirection(builder.toString());    }}
private StringBuilder pdfbox_f7723_0(List<WordWithTextPositions> normalized, StringBuilder lineBuilder, List<TextPosition> wordPositions, LineItem item)
{    if (item.isWordSeparator()) {        normalized.add(createWord(lineBuilder.toString(), new ArrayList<>(wordPositions)));        lineBuilder = new StringBuilder();        wordPositions.clear();    } else {        TextPosition text = item.getTextPosition();        lineBuilder.append(text.getUnicode());        wordPositions.add(text);    }    return lineBuilder;}
public static LineItem pdfbox_f7724_0()
{    return WORD_SEPARATOR;}
public TextPosition pdfbox_f7725_0()
{    return textPosition;}
public boolean pdfbox_f7726_0()
{    return textPosition == null;}
public String pdfbox_f7727_0()
{    return text;}
public List<TextPosition> pdfbox_f7728_0()
{    return textPositions;}
public TextPosition pdfbox_f7729_0()
{    return position;}
public boolean pdfbox_f7730_0()
{    return isLineStart;}
public void pdfbox_f7731_0()
{    this.isLineStart = true;}
public boolean pdfbox_f7732_0()
{    return isParagraphStart;}
public void pdfbox_f7733_0()
{    this.isParagraphStart = true;}
public boolean pdfbox_f7734_0()
{    return isArticleStart;}
public void pdfbox_f7735_0()
{    this.isArticleStart = true;}
public boolean pdfbox_f7736_0()
{    return isPageBreak;}
public void pdfbox_f7737_0()
{    this.isPageBreak = true;}
public boolean pdfbox_f7738_0()
{    return isHangingIndent;}
public void pdfbox_f7739_0()
{    this.isHangingIndent = true;}
public void pdfbox_f7741_0(String regionName, Rectangle2D rect)
{    regions.add(regionName);    regionArea.put(regionName, rect);}
public void pdfbox_f7742_0(String regionName)
{    regions.remove(regionName);    regionArea.remove(regionName);}
public List<String> pdfbox_f7743_0()
{    return regions;}
public String pdfbox_f7744_0(String regionName)
{    StringWriter text = regionText.get(regionName);    return text.toString();}
public void pdfbox_f7745_0(PDPage page) throws IOException
{    for (String region : regions) {        setStartPage(getCurrentPageNo());        setEndPage(getCurrentPageNo());                        String regionName = region;        ArrayList<List<TextPosition>> regionCharactersByArticle = new ArrayList<>();        regionCharactersByArticle.add(new ArrayList<TextPosition>());        regionCharacterList.put(regionName, regionCharactersByArticle);        regionText.put(regionName, new StringWriter());    }    if (page.hasContents()) {        processPage(page);    }}
protected void pdfbox_f7746_0(TextPosition text)
{    for (Map.Entry<String, Rectangle2D> regionAreaEntry : regionArea.entrySet()) {        Rectangle2D rect = regionAreaEntry.getValue();        if (rect.contains(text.getX(), text.getY())) {            charactersByArticle = regionCharacterList.get(regionAreaEntry.getKey());            super.processTextPosition(text);        }    }}
protected void pdfbox_f7747_0() throws IOException
{    for (String region : regionArea.keySet()) {        charactersByArticle = regionCharacterList.get(region);        output = regionText.get(region);        super.writePage();    }}
private static Map<Integer, String> pdfbox_f7748_0()
{    Map<Integer, String> map = new HashMap<>(31);    map.put(0x0060, "\u0300");    map.put(0x02CB, "\u0300");    map.put(0x0027, "\u0301");    map.put(0x02B9, "\u0301");    map.put(0x02CA, "\u0301");    map.put(0x005e, "\u0302");    map.put(0x02C6, "\u0302");    map.put(0x007E, "\u0303");    map.put(0x02C9, "\u0304");    map.put(0x00B0, "\u030A");    map.put(0x02BA, "\u030B");    map.put(0x02C7, "\u030C");    map.put(0x02C8, "\u030D");    map.put(0x0022, "\u030E");    map.put(0x02BB, "\u0312");    map.put(0x02BC, "\u0313");    map.put(0x0486, "\u0313");    map.put(0x055A, "\u0313");    map.put(0x02BD, "\u0314");    map.put(0x0485, "\u0314");    map.put(0x0559, "\u0314");    map.put(0x02D4, "\u031D");    map.put(0x02D5, "\u031E");    map.put(0x02D6, "\u031F");    map.put(0x02D7, "\u0320");    map.put(0x02B2, "\u0321");    map.put(0x02CC, "\u0329");    map.put(0x02B7, "\u032B");    map.put(0x02CD, "\u0331");    map.put(0x005F, "\u0332");    map.put(0x204E, "\u0359");    return map;}
public String pdfbox_f7749_0()
{    return unicode;}
public int[] pdfbox_f7750_0()
{    return charCodes;}
public Matrix pdfbox_f7751_0()
{    return textMatrix;}
public float pdfbox_f7752_0()
{    if (direction < 0) {        float a = textMatrix.getScaleY();        float b = textMatrix.getShearY();        float c = textMatrix.getShearX();        float d = textMatrix.getScaleX();                if (a > 0 && Math.abs(b) < d && Math.abs(c) < a && d > 0) {            direction = 0;        } else         if (a < 0 && Math.abs(b) < Math.abs(d) && Math.abs(c) < Math.abs(a) && d < 0) {            direction = 180;        } else         if (Math.abs(a) < Math.abs(c) && b > 0 && c < 0 && Math.abs(d) < b) {            direction = 90;        } else         if (Math.abs(a) < c && b < 0 && c > 0 && Math.abs(d) < Math.abs(b)) {            direction = 270;        } else {            direction = 0;        }    }    return direction;}
private float pdfbox_f7753_0(float rotation)
{    if (Float.compare(rotation, 0) == 0) {        return textMatrix.getTranslateX();    } else if (Float.compare(rotation, 90) == 0) {        return textMatrix.getTranslateY();    } else if (Float.compare(rotation, 180) == 0) {        return pageWidth - textMatrix.getTranslateX();    } else if (Float.compare(rotation, 270) == 0) {        return pageHeight - textMatrix.getTranslateY();    }    return 0;}
public float pdfbox_f7754_0()
{    return x;}
public float pdfbox_f7755_0()
{    return getXRot(getDir());}
private float pdfbox_f7756_0(float rotation)
{    if (Float.compare(rotation, 0) == 0) {        return textMatrix.getTranslateY();    } else if (Float.compare(rotation, 90) == 0) {        return pageWidth - textMatrix.getTranslateX();    } else if (Float.compare(rotation, 180) == 0) {        return pageHeight - textMatrix.getTranslateY();    } else if (Float.compare(rotation, 270) == 0) {        return textMatrix.getTranslateX();    }    return 0;}
public float pdfbox_f7757_0()
{    return y;}
public float pdfbox_f7758_0()
{    float dir = getDir();        if (Float.compare(dir, 0) == 0 || Float.compare(dir, 180) == 0) {        return pageHeight - getYLowerLeftRot(dir);    } else {        return pageWidth - getYLowerLeftRot(dir);    }}
private float pdfbox_f7759_0(float rotation)
{    if (Float.compare(rotation, 90) == 0 || Float.compare(rotation, 270) == 0) {        return Math.abs(endY - textMatrix.getTranslateY());    } else {        return Math.abs(endX - textMatrix.getTranslateX());    }}
public float pdfbox_f7760_0()
{    return getWidthRot(rotation);}
public float pdfbox_f7761_0()
{    return getWidthRot(getDir());}
public float pdfbox_f7762_0()
{    return maxHeight;}
public float pdfbox_f7763_0()
{        return maxHeight;}
public float pdfbox_f7764_0()
{    return fontSize;}
public float pdfbox_f7765_0()
{    return fontSizePt;}
public PDFont pdfbox_f7766_0()
{    return font;}
public float pdfbox_f7767_0()
{    return widthOfSpace;}
public float pdfbox_f7768_0()
{    return textMatrix.getScalingFactorX();}
public float pdfbox_f7769_0()
{    return textMatrix.getScalingFactorY();}
public float[] pdfbox_f7770_0()
{    return widths;}
public boolean pdfbox_f7771_0(TextPosition tp2)
{    double thisXstart = getXDirAdj();    double thisWidth = getWidthDirAdj();    double thisXend = thisXstart + thisWidth;    double tp2Xstart = tp2.getXDirAdj();    double tp2Xend = tp2Xstart + tp2.getWidthDirAdj();        if (tp2Xend <= thisXstart || tp2Xstart >= thisXend) {        return false;    }            double thisYstart = getYDirAdj();    double tp2Ystart = tp2.getYDirAdj();    if (tp2Ystart + tp2.getHeightDir() < thisYstart || tp2Ystart > thisYstart + getHeightDir()) {        return false;    } else     if (tp2Xstart > thisXstart && tp2Xend > thisXend) {        double overlap = thisXend - tp2Xstart;        double overlapPercent = overlap / thisWidth;        return overlapPercent > .15;    } else if (tp2Xstart < thisXstart && tp2Xend < thisXend) {        double overlap = tp2Xend - thisXstart;        double overlapPercent = overlap / thisWidth;        return overlapPercent > .15;    }    return true;}
public void pdfbox_f7772_1(TextPosition diacritic)
{    if (diacritic.getUnicode().length() > 1) {        return;    }    float diacXStart = diacritic.getXDirAdj();    float diacXEnd = diacXStart + diacritic.widths[0];    float currCharXStart = getXDirAdj();    int strLen = unicode.length();    boolean wasAdded = false;    for (int i = 0; i < strLen && !wasAdded; i++) {        if (i >= widths.length) {                        break;        }        float currCharXEnd = currCharXStart + widths[i];                if (diacXStart < currCharXStart && diacXEnd <= currCharXEnd) {            if (i == 0) {                insertDiacritic(i, diacritic);            } else {                float distanceOverlapping1 = diacXEnd - currCharXStart;                float percentage1 = distanceOverlapping1 / widths[i];                float distanceOverlapping2 = currCharXStart - diacXStart;                float percentage2 = distanceOverlapping2 / widths[i - 1];                if (percentage1 >= percentage2) {                    insertDiacritic(i, diacritic);                } else {                    insertDiacritic(i - 1, diacritic);                }            }            wasAdded = true;        } else         if (diacXStart < currCharXStart) {            insertDiacritic(i, diacritic);            wasAdded = true;        } else         if (diacXEnd <= currCharXEnd) {            insertDiacritic(i, diacritic);            wasAdded = true;        } else         if (i == strLen - 1) {            insertDiacritic(i, diacritic);            wasAdded = true;        }                currCharXStart += widths[i];    }}
private void pdfbox_f7773_0(int i, TextPosition diacritic)
{    StringBuilder sb = new StringBuilder();    sb.append(unicode.substring(0, i));    float[] widths2 = new float[widths.length + 1];    System.arraycopy(widths, 0, widths2, 0, i);            sb.append(unicode.charAt(i));    widths2[i] = widths[i];    sb.append(combineDiacritic(diacritic.getUnicode()));    widths2[i + 1] = 0;        sb.append(unicode.substring(i + 1, unicode.length()));    System.arraycopy(widths, i + 1, widths2, i + 2, widths.length - i - 1);    unicode = sb.toString();    widths = widths2;}
private String pdfbox_f7774_0(String str)
{        int codePoint = str.codePointAt(0);        if (DIACRITICS.containsKey(codePoint)) {        return DIACRITICS.get(codePoint);    } else {        return Normalizer.normalize(str, Normalizer.Form.NFKC).trim();    }}
public boolean pdfbox_f7775_0()
{    String text = this.getUnicode();    if (text.length() != 1) {        return false;    }    if ("ー".equals(text)) {                return false;    }    int type = Character.getType(text.charAt(0));    return type == Character.NON_SPACING_MARK || type == Character.MODIFIER_SYMBOL || type == Character.MODIFIER_LETTER;}
public String pdfbox_f7776_0()
{    return getUnicode();}
public float pdfbox_f7777_0()
{    return endX;}
public float pdfbox_f7778_0()
{    return endY;}
public int pdfbox_f7779_0()
{    return rotation;}
public float pdfbox_f7780_0()
{    return pageHeight;}
public float pdfbox_f7781_0()
{    return pageWidth;}
public boolean pdfbox_f7782_0(Object o)
{    if (this == o) {        return true;    }    if (!(o instanceof TextPosition)) {        return false;    }    TextPosition that = (TextPosition) o;    if (Float.compare(that.endX, endX) != 0) {        return false;    }    if (Float.compare(that.endY, endY) != 0) {        return false;    }    if (Float.compare(that.maxHeight, maxHeight) != 0) {        return false;    }    if (rotation != that.rotation) {        return false;    }    if (Float.compare(that.x, x) != 0) {        return false;    }    if (Float.compare(that.y, y) != 0) {        return false;    }    if (Float.compare(that.pageHeight, pageHeight) != 0) {        return false;    }    if (Float.compare(that.pageWidth, pageWidth) != 0) {        return false;    }    if (Float.compare(that.widthOfSpace, widthOfSpace) != 0) {        return false;    }    if (Float.compare(that.fontSize, fontSize) != 0) {        return false;    }    if (fontSizePt != that.fontSizePt) {        return false;    }    if (Float.compare(that.direction, direction) != 0) {        return false;    }    if (textMatrix != null ? !textMatrix.equals(that.textMatrix) : that.textMatrix != null) {        return false;    }    if (!Arrays.equals(charCodes, that.charCodes)) {        return false;    }    if (font != null ? !font.equals(that.font) : that.font != null) {        return false;    }    if (!Arrays.equals(widths, that.widths)) {        return false;    }    return unicode != null ? unicode.equals(that.unicode) : that.unicode == null;}
public int pdfbox_f7783_0()
{    int result = textMatrix != null ? textMatrix.hashCode() : 0;    result = 31 * result + Float.floatToIntBits(endX);    result = 31 * result + Float.floatToIntBits(endY);    result = 31 * result + Float.floatToIntBits(maxHeight);    result = 31 * result + rotation;    result = 31 * result + Float.floatToIntBits(x);    result = 31 * result + Float.floatToIntBits(y);    result = 31 * result + Float.floatToIntBits(pageHeight);    result = 31 * result + Float.floatToIntBits(pageWidth);    result = 31 * result + Float.floatToIntBits(widthOfSpace);    result = 31 * result + Arrays.hashCode(charCodes);    result = 31 * result + (font != null ? font.hashCode() : 0);    result = 31 * result + Float.floatToIntBits(fontSize);    result = 31 * result + fontSizePt;    return result;}
public int pdfbox_f7784_0(TextPosition pos1, TextPosition pos2)
{        int cmp1 = Float.compare(pos1.getDir(), pos2.getDir());    if (cmp1 != 0) {        return cmp1;    }        float x1 = pos1.getXDirAdj();    float x2 = pos2.getXDirAdj();    float pos1YBottom = pos1.getYDirAdj();    float pos2YBottom = pos2.getYDirAdj();        float pos1YTop = pos1YBottom - pos1.getHeightDir();    float pos2YTop = pos2YBottom - pos2.getHeightDir();    float yDifference = Math.abs(pos1YBottom - pos2YBottom);        if (yDifference < .1 || pos2YBottom >= pos1YTop && pos2YBottom <= pos1YBottom || pos1YBottom >= pos2YTop && pos1YBottom <= pos2YBottom) {        return Float.compare(x1, x2);    } else if (pos1YBottom < pos2YBottom) {        return -1;    } else {        return 1;    }}
public static String pdfbox_f7785_0(Calendar cal)
{    if (cal == null) {        return null;    }    String offset = formatTZoffset(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET), "'");    return String.format(Locale.US, "D:" +     "%1$4tY%1$2tm%1$2td" +     "%1$2tH%1$2tM%1$2tS" +     "%2$s" +     "'", cal, offset);}
public static String pdfbox_f7786_0(Calendar cal)
{    String offset = formatTZoffset(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET), ":");    return String.format(Locale.US,     "%1$4tY" +     "-%1$2tm" +     "-%1$2td" +     "T" +     "%1$2tH:%1$2tM:%1$2tS" +     "%2$s", cal, offset);}
private static int pdfbox_f7787_0(long proposedOffset)
{    if (proposedOffset <= 14 * MILLIS_PER_HOUR && proposedOffset >= -14 * MILLIS_PER_HOUR) {                return (int) proposedOffset;    }        proposedOffset = ((proposedOffset + HALF_DAY) % DAY + DAY) % DAY;    if (proposedOffset == 0) {        return HALF_DAY;    }        proposedOffset = (proposedOffset - HALF_DAY) % HALF_DAY;        return (int) proposedOffset;}
 static String pdfbox_f7788_0(long millis, String sep)
{        SimpleDateFormat sdf = new SimpleDateFormat("Z");    sdf.setTimeZone(new SimpleTimeZone(restrainTZoffset(millis), "unknown"));    String tz = sdf.format(new Date());    return tz.substring(0, 3) + sep + tz.substring(3);}
private static int pdfbox_f7789_0(String text, ParsePosition where, int maxlen, int remedy)
{    if (text == null) {        return remedy;    }            int retval = 0;    int index = where.getIndex();    int limit = index + Math.min(maxlen, text.length() - index);    for (; index < limit; index++) {                int cval = text.charAt(index) - '0';                if (cval < 0 || cval > 9) {                        break;        }                retval = retval * 10 + cval;    }    if (index == where.getIndex()) {        return remedy;    }    where.setIndex(index);    return retval;}
private static char pdfbox_f7790_0(String text, ParsePosition where, String optionals)
{    char retval = ' ', currch;    while (text != null && where.getIndex() < text.length() && optionals.indexOf((currch = text.charAt(where.getIndex()))) >= 0) {        retval = (currch != ' ') ? currch : retval;        where.setIndex(where.getIndex() + 1);    }    return retval;}
private static boolean pdfbox_f7791_0(String text, String victim, ParsePosition where)
{    if (text.startsWith(victim, where.getIndex())) {        where.setIndex(where.getIndex() + victim.length());        return true;    }    return false;}
 static GregorianCalendar pdfbox_f7792_0()
{    GregorianCalendar retCal = new GregorianCalendar(Locale.ENGLISH);    retCal.setTimeZone(new SimpleTimeZone(0, "UTC"));    retCal.setLenient(false);    retCal.set(Calendar.MILLISECOND, 0);    return retCal;}
private static void pdfbox_f7793_0(GregorianCalendar cal, TimeZone tz)
{    cal.setTimeZone(tz);    int offset = (cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / MILLIS_PER_MINUTE;    cal.add(Calendar.MINUTE, -offset);}
 static boolean pdfbox_f7794_0(String text, GregorianCalendar cal, ParsePosition initialWhere)
{    ParsePosition where = new ParsePosition(initialWhere.getIndex());    TimeZone tz = new SimpleTimeZone(0, "GMT");    int tzHours, tzMin;    char sign = skipOptionals(text, where, "Z+- ");    boolean hadGMT = (sign == 'Z' || skipString(text, "GMT", where) || skipString(text, "UTC", where));    sign = (!hadGMT) ? sign : skipOptionals(text, where, "+- ");    tzHours = parseTimeField(text, where, 2, -999);    skipOptionals(text, where, "\': ");    tzMin = parseTimeField(text, where, 2, 0);    skipOptionals(text, where, "\' ");    if (tzHours != -999) {                int hrSign = (sign == '-' ? -1 : 1);        tz.setRawOffset(restrainTZoffset(hrSign * (tzHours * MILLIS_PER_HOUR + tzMin * (long) MILLIS_PER_MINUTE)));        updateZoneId(tz);    } else if (!hadGMT) {                String tzText = text.substring(initialWhere.getIndex()).trim();        tz = TimeZone.getTimeZone(tzText);                if ("GMT".equals(tz.getID())) {                        return false;        } else {                        where.setIndex(text.length());        }    }    adjustTimeZoneNicely(cal, tz);    initialWhere.setIndex(where.getIndex());    return true;}
private static void pdfbox_f7795_0(TimeZone tz)
{    int offset = tz.getRawOffset();    char pm = '+';    if (offset < 0) {        pm = '-';        offset = -offset;    }    int hh = offset / 3600000;    int mm = offset % 3600000 / 60000;    if (offset == 0) {        tz.setID("GMT");    } else if (pm == '+' && hh <= 12) {        tz.setID(String.format(Locale.US, "GMT+%02d:%02d", hh, mm));    } else if (pm == '-' && hh <= 14) {        tz.setID(String.format(Locale.US, "GMT-%02d:%02d", hh, mm));    } else {        tz.setID("unknown");    }}
private static GregorianCalendar pdfbox_f7796_1(String text, ParsePosition initialWhere)
{    ParsePosition where = new ParsePosition(initialWhere.getIndex());    int year = parseTimeField(text, where, 4, 0);    if (where.getIndex() != 4 + initialWhere.getIndex()) {        return null;    }    skipOptionals(text, where, "/- ");        int month = parseTimeField(text, where, 2, 1) - 1;    skipOptionals(text, where, "/- ");    int day = parseTimeField(text, where, 2, 1);    skipOptionals(text, where, " T");    int hour = parseTimeField(text, where, 2, 0);    skipOptionals(text, where, ": ");    int minute = parseTimeField(text, where, 2, 0);    skipOptionals(text, where, ": ");    int second = parseTimeField(text, where, 2, 0);    char nextC = skipOptionals(text, where, ".");    if (nextC == '.') {                parseTimeField(text, where, 19, 0);    }    GregorianCalendar dest = newGreg();    try {        dest.set(year, month, day, hour, minute, second);                dest.getTimeInMillis();    } catch (IllegalArgumentException ill) {                return null;    }    initialWhere.setIndex(where.getIndex());    skipOptionals(text, initialWhere, " ");        return dest;}
private static GregorianCalendar pdfbox_f7797_0(String text, String[] fmts, ParsePosition initialWhere)
{    for (String fmt : fmts) {        ParsePosition where = new ParsePosition(initialWhere.getIndex());        SimpleDateFormat sdf = new SimpleDateFormat(fmt, Locale.ENGLISH);        GregorianCalendar retCal = newGreg();        sdf.setCalendar(retCal);        if (sdf.parse(text, where) != null) {            initialWhere.setIndex(where.getIndex());            skipOptionals(text, initialWhere, " ");            return retCal;        }    }    return null;}
private static Calendar pdfbox_f7798_0(String text, ParsePosition initialWhere)
{    if (text == null || text.isEmpty()) {        return null;    }        int longestLen = -999999;                GregorianCalendar longestDate = null;        int whereLen;    ParsePosition where = new ParsePosition(initialWhere.getIndex());        skipOptionals(text, where, " ");    int startPosition = where.getIndex();        GregorianCalendar retCal = parseBigEndianDate(text, where);        if (retCal != null && (where.getIndex() == text.length() || parseTZoffset(text, retCal, where))) {                whereLen = where.getIndex();        if (whereLen == text.length()) {            initialWhere.setIndex(whereLen);            return retCal;        }        longestLen = whereLen;        longestDate = retCal;    }        where.setIndex(startPosition);    String[] formats = Character.isDigit(text.charAt(startPosition)) ? DIGIT_START_FORMATS : ALPHA_START_FORMATS;    retCal = parseSimpleDate(text, formats, where);        if (retCal != null && (where.getIndex() == text.length() || parseTZoffset(text, retCal, where))) {                whereLen = where.getIndex();        if (whereLen == text.length()) {            initialWhere.setIndex(whereLen);            return retCal;        }        if (whereLen > longestLen) {            longestLen = whereLen;            longestDate = retCal;        }    }    if (longestDate != null) {        initialWhere.setIndex(longestLen);        return longestDate;    }    return retCal;}
public static Calendar pdfbox_f7799_0(COSString text)
{    if (text == null) {        return null;    }    return toCalendar(text.getString());}
public static Calendar pdfbox_f7800_0(String text)
{    if (text == null || text.trim().isEmpty()) {        return null;    }    ParsePosition where = new ParsePosition(0);    skipOptionals(text, where, " ");    skipString(text, "D:", where);    Calendar calendar = parseDate(text, where);    if (calendar == null || where.getIndex() != text.length()) {                return null;    }    return calendar;}
public void pdfbox_f7801_0(T value)
{    if (this.value != null) {        throw new IllegalStateException("Value already set for this trie node");    }    this.value = value;}
public T pdfbox_f7802_0()
{    return value;}
public T pdfbox_f7803_0(byte[] bytes)
{    ByteTrieNode<T> node = root;    T val = node.getValue();    for (byte b : bytes) {        ByteTrieNode<T> child = node.children.get(b);        if (child == null) {            break;        }        node = child;        if (node.getValue() != null) {            val = node.getValue();        }    }    return val;}
public void pdfbox_f7804_0(T value, byte[]... parts)
{    int depth = 0;    ByteTrieNode<T> node = root;    for (byte[] part : parts) {        for (byte b : part) {            ByteTrieNode<T> child = node.children.get(b);            if (child == null) {                child = new ByteTrieNode<>();                node.children.put(b, child);            }            node = child;            depth++;        }    }    node.setValue(value);    maxDepth = Math.max(maxDepth, depth);}
public void pdfbox_f7805_0(T defaultValue)
{    root.setValue(defaultValue);}
public int pdfbox_f7806_0()
{    return maxDepth;}
public static FileType pdfbox_f7807_0(final BufferedInputStream inputStream) throws IOException
{    if (!inputStream.markSupported()) {        throw new IOException("Stream must support mark/reset");    }    int maxByteCount = root.getMaxDepth();    inputStream.mark(maxByteCount);    byte[] bytes = new byte[maxByteCount];    int bytesRead = inputStream.read(bytes);    if (bytesRead == -1) {        throw new IOException("Stream ended before file's magic number could be determined.");    }    inputStream.reset();        return root.find(bytes);}
public static FileType pdfbox_f7808_0(final byte[] fileBytes) throws IOException
{    return root.find(fileBytes);}
public static String pdfbox_f7809_0(byte b)
{    char[] chars = new char[] { HEX_CHARS[getHighNibble(b)], HEX_CHARS[getLowNibble(b)] };    return new String(chars);}
public static String pdfbox_f7810_0(byte[] bytes)
{    StringBuilder string = new StringBuilder(bytes.length * 2);    for (byte b : bytes) {        string.append(HEX_CHARS[getHighNibble(b)]).append(HEX_CHARS[getLowNibble(b)]);    }    return string.toString();}
public static byte[] pdfbox_f7811_0(byte b)
{    return new byte[] { HEX_BYTES[getHighNibble(b)], HEX_BYTES[getLowNibble(b)] };}
public static byte[] pdfbox_f7812_0(byte[] bytes)
{    byte[] asciiBytes = new byte[bytes.length * 2];    for (int i = 0; i < bytes.length; i++) {        asciiBytes[i * 2] = HEX_BYTES[getHighNibble(bytes[i])];        asciiBytes[i * 2 + 1] = HEX_BYTES[getLowNibble(bytes[i])];    }    return asciiBytes;}
public static char[] pdfbox_f7813_0(short num)
{    char[] hex = new char[4];    hex[0] = HEX_CHARS[(num >> 12) & 0x0F];    hex[1] = HEX_CHARS[(num >> 8) & 0x0F];    hex[2] = HEX_CHARS[(num >> 4) & 0x0F];    hex[3] = HEX_CHARS[num & 0x0F];    return hex;}
public static char[] pdfbox_f7814_0(String text)
{            char[] hex = new char[text.length() * 4];    for (int stringIdx = 0, charIdx = 0; stringIdx < text.length(); stringIdx++) {        char c = text.charAt(stringIdx);        hex[charIdx++] = HEX_CHARS[(c >> 12) & 0x0F];        hex[charIdx++] = HEX_CHARS[(c >> 8) & 0x0F];        hex[charIdx++] = HEX_CHARS[(c >> 4) & 0x0F];        hex[charIdx++] = HEX_CHARS[c & 0x0F];    }    return hex;}
public static void pdfbox_f7815_0(byte b, OutputStream output) throws IOException
{    output.write(HEX_BYTES[getHighNibble(b)]);    output.write(HEX_BYTES[getLowNibble(b)]);}
public static void pdfbox_f7816_0(byte[] bytes, OutputStream output) throws IOException
{    for (byte b : bytes) {        writeHexByte(b, output);    }}
private static int pdfbox_f7817_0(byte b)
{    return (b & 0xF0) >> 4;}
private static int pdfbox_f7818_0(byte b)
{    return b & 0x0F;}
public static byte[] pdfbox_f7819_0(String base64Value)
{    return Base64.getDecoder().decode(base64Value.replaceAll("\\s", ""));}
public static byte[] pdfbox_f7820_1(String s) throws IOException
{    ByteArrayOutputStream baos = new ByteArrayOutputStream();    int i = 0;    while (i < s.length() - 1) {        if (s.charAt(i) == '\n' || s.charAt(i) == '\r') {            ++i;        } else {            String hexByte = s.substring(i, i + 2);            try {                                baos.write(Integer.parseInt(hexByte, 16));            } catch (NumberFormatException ex) {                                break;            }            i += 2;        }    }    return baos.toByteArray();}
public static Matrix pdfbox_f7821_0(COSBase base)
{    if (!(base instanceof COSArray)) {        return new Matrix();    }    COSArray array = (COSArray) base;    if (array.size() < 6) {        return new Matrix();    }    for (int i = 0; i < 6; ++i) {        if (!(array.getObject(i) instanceof COSNumber)) {            return new Matrix();        }    }    return new Matrix(array);}
public void pdfbox_f7822_0()
{    System.arraycopy(DEFAULT_SINGLE, 0, single, 0, DEFAULT_SINGLE.length);}
public AffineTransform pdfbox_f7823_0()
{    return new AffineTransform(    single[0],     single[1],     single[3],     single[4], single[6],     single[7]);}
public void pdfbox_f7824_0(AffineTransform af)
{    single[0] = (float) af.getScaleX();    single[1] = (float) af.getShearY();    single[3] = (float) af.getShearX();    single[4] = (float) af.getScaleY();    single[6] = (float) af.getTranslateX();    single[7] = (float) af.getTranslateY();}
public float pdfbox_f7825_0(int row, int column)
{    return single[row * 3 + column];}
public void pdfbox_f7826_0(int row, int column, float value)
{    single[row * 3 + column] = value;}
public float[][] pdfbox_f7827_0()
{    float[][] retval = new float[3][3];    retval[0][0] = single[0];    retval[0][1] = single[1];    retval[0][2] = single[2];    retval[1][0] = single[3];    retval[1][1] = single[4];    retval[1][2] = single[5];    retval[2][0] = single[6];    retval[2][1] = single[7];    retval[2][2] = single[8];    return retval;}
public double[][] pdfbox_f7828_0()
{    double[][] retval = new double[3][3];    retval[0][0] = single[0];    retval[0][1] = single[1];    retval[0][2] = single[2];    retval[1][0] = single[3];    retval[1][1] = single[4];    retval[1][2] = single[5];    retval[2][0] = single[6];    retval[2][1] = single[7];    retval[2][2] = single[8];    return retval;}
public void pdfbox_f7829_0(Matrix matrix)
{    matrix.multiply(this, this);}
public void pdfbox_f7830_0(Vector vector)
{    Matrix m = Matrix.getTranslateInstance(vector.getX(), vector.getY());    concatenate(m);}
public void pdfbox_f7831_0(float tx, float ty)
{    Matrix m = Matrix.getTranslateInstance(tx, ty);    concatenate(m);}
public void pdfbox_f7832_0(float sx, float sy)
{    Matrix m = Matrix.getScaleInstance(sx, sy);    concatenate(m);}
public void pdfbox_f7833_0(double theta)
{    Matrix m = Matrix.getRotateInstance(theta, 0, 0);    concatenate(m);}
public Matrix pdfbox_f7834_0(Matrix b)
{    return this.multiply(b, new Matrix());}
public Matrix pdfbox_f7835_0(Matrix other, Matrix result)
{    if (result == null) {        result = new Matrix();    }    if (other != null && other.single != null) {                float[] thisOperand = this.single;        float[] otherOperand = other.single;        if (this == result) {            final float[] thisOrigVals = new float[this.single.length];            System.arraycopy(this.single, 0, thisOrigVals, 0, this.single.length);            thisOperand = thisOrigVals;        }        if (other == result) {            final float[] otherOrigVals = new float[other.single.length];            System.arraycopy(other.single, 0, otherOrigVals, 0, other.single.length);            otherOperand = otherOrigVals;        }        result.single[0] = thisOperand[0] * otherOperand[0] + thisOperand[1] * otherOperand[3] + thisOperand[2] * otherOperand[6];        result.single[1] = thisOperand[0] * otherOperand[1] + thisOperand[1] * otherOperand[4] + thisOperand[2] * otherOperand[7];        result.single[2] = thisOperand[0] * otherOperand[2] + thisOperand[1] * otherOperand[5] + thisOperand[2] * otherOperand[8];        result.single[3] = thisOperand[3] * otherOperand[0] + thisOperand[4] * otherOperand[3] + thisOperand[5] * otherOperand[6];        result.single[4] = thisOperand[3] * otherOperand[1] + thisOperand[4] * otherOperand[4] + thisOperand[5] * otherOperand[7];        result.single[5] = thisOperand[3] * otherOperand[2] + thisOperand[4] * otherOperand[5] + thisOperand[5] * otherOperand[8];        result.single[6] = thisOperand[6] * otherOperand[0] + thisOperand[7] * otherOperand[3] + thisOperand[8] * otherOperand[6];        result.single[7] = thisOperand[6] * otherOperand[1] + thisOperand[7] * otherOperand[4] + thisOperand[8] * otherOperand[7];        result.single[8] = thisOperand[6] * otherOperand[2] + thisOperand[7] * otherOperand[5] + thisOperand[8] * otherOperand[8];    }    return result;}
public void pdfbox_f7836_0(Point2D point)
{    float x = (float) point.getX();    float y = (float) point.getY();    float a = single[0];    float b = single[1];    float c = single[3];    float d = single[4];    float e = single[6];    float f = single[7];    point.setLocation(x * a + y * c + e, x * b + y * d + f);}
public Point2D.Float pdfbox_f7837_0(float x, float y)
{    float a = single[0];    float b = single[1];    float c = single[3];    float d = single[4];    float e = single[6];    float f = single[7];    return new Point2D.Float(x * a + y * c + e, x * b + y * d + f);}
public Vector pdfbox_f7838_0(Vector vector)
{    float a = single[0];    float b = single[1];    float c = single[3];    float d = single[4];    float e = single[6];    float f = single[7];    float x = vector.getX();    float y = vector.getY();    return new Vector(x * a + y * c + e, x * b + y * d + f);}
public Matrix pdfbox_f7839_0()
{    Matrix matrix = new Matrix();    matrix.single[0] = this.single[0];    matrix.single[4] = this.single[4];    return matrix;}
public static Matrix pdfbox_f7840_0(float sx, float sy)
{    Matrix matrix = new Matrix();    matrix.single[0] = sx;    matrix.single[4] = sy;    return matrix;}
public Matrix pdfbox_f7841_0()
{    Matrix matrix = new Matrix();    matrix.single[6] = this.single[6];    matrix.single[7] = this.single[7];    return matrix;}
public static Matrix pdfbox_f7842_0(float tx, float ty)
{    return getTranslateInstance(tx, ty);}
public static Matrix pdfbox_f7843_0(float tx, float ty)
{    Matrix matrix = new Matrix();    matrix.single[6] = tx;    matrix.single[7] = ty;    return matrix;}
public static Matrix pdfbox_f7844_0(double theta, float tx, float ty)
{    float cosTheta = (float) Math.cos(theta);    float sinTheta = (float) Math.sin(theta);    Matrix matrix = new Matrix();    matrix.single[0] = cosTheta;    matrix.single[1] = sinTheta;    matrix.single[3] = -sinTheta;    matrix.single[4] = cosTheta;    matrix.single[6] = tx;    matrix.single[7] = ty;    return matrix;}
public static Matrix pdfbox_f7845_0(Matrix a, Matrix b)
{    Matrix copy = a.clone();    copy.concatenate(b);    return copy;}
public Matrix pdfbox_f7846_0()
{    Matrix clone = new Matrix();    System.arraycopy(single, 0, clone.single, 0, 9);    return clone;}
public float pdfbox_f7847_0()
{    float xScale = single[0];    /**     * BM: if the trm is rotated, the calculation is a little more complicated     *     * The rotation matrix multiplied with the scaling matrix is:     * (   x   0   0)    ( cos  sin  0)    ( x*cos x*sin   0)     * (   0   y   0) *  (-sin  cos  0)  = (-y*sin y*cos   0)     * (   0   0   1)    (   0    0  1)    (     0     0   1)     *     * So, if you want to deduce x from the matrix you take     * M(0,0) = x*cos and M(0,1) = x*sin and use the theorem of Pythagoras     *     * sqrt(M(0,0)^2+M(0,1)^2) =     * sqrt(x2*cos2+x2*sin2) =     * sqrt(x2*(cos2+sin2)) = <- here is the trick cos2+sin2 is one     * sqrt(x2) =     * abs(x)     */    if (!(Float.compare(single[1], 0.0f) == 0 && Float.compare(single[3], 0.0f) == 0)) {        xScale = (float) Math.sqrt(Math.pow(single[0], 2) + Math.pow(single[1], 2));    }    return xScale;}
public float pdfbox_f7848_0()
{    float yScale = single[4];    if (!(Float.compare(single[1], 0.0f) == 0 && Float.compare(single[3], 0.0f) == 0)) {        yScale = (float) Math.sqrt(Math.pow(single[3], 2) + Math.pow(single[4], 2));    }    return yScale;}
public float pdfbox_f7849_0()
{    return single[0];}
public float pdfbox_f7850_0()
{    return single[1];}
public float pdfbox_f7851_0()
{    return single[3];}
public float pdfbox_f7852_0()
{    return single[4];}
public float pdfbox_f7853_0()
{    return single[6];}
public float pdfbox_f7854_0()
{    return single[7];}
public float pdfbox_f7855_0()
{    return single[6];}
public float pdfbox_f7856_0()
{    return single[7];}
public COSArray pdfbox_f7857_0()
{    COSArray array = new COSArray();    array.add(new COSFloat(single[0]));    array.add(new COSFloat(single[1]));    array.add(new COSFloat(single[3]));    array.add(new COSFloat(single[4]));    array.add(new COSFloat(single[6]));    array.add(new COSFloat(single[7]));    return array;}
public String pdfbox_f7858_0()
{    return "[" + single[0] + "," + single[1] + "," + single[3] + "," + single[4] + "," + single[6] + "," + single[7] + "]";}
public int pdfbox_f7859_0()
{    return Arrays.hashCode(single);}
public boolean pdfbox_f7860_0(Object obj)
{    if (this == obj) {        return true;    }    if (obj == null) {        return false;    }    if (getClass() != obj.getClass()) {        return false;    }    return Arrays.equals(this.single, ((Matrix) obj).single);}
public static int pdfbox_f7861_0(float value, int maxFractionDigits, byte[] asciiBuffer)
{    if (Float.isNaN(value) || Float.isInfinite(value) || value > Long.MAX_VALUE || value <= Long.MIN_VALUE || maxFractionDigits > MAX_FRACTION_DIGITS) {        return -1;    }    int offset = 0;    long integerPart = (long) value;        if (value < 0) {        asciiBuffer[offset++] = '-';        integerPart = -integerPart;    }        long fractionPart = (long) ((Math.abs((double) value) - integerPart) * POWER_OF_TENS[maxFractionDigits] + 0.5d);        if (fractionPart >= POWER_OF_TENS[maxFractionDigits]) {        integerPart++;        fractionPart -= POWER_OF_TENS[maxFractionDigits];    }        offset = formatPositiveNumber(integerPart, getExponent(integerPart), false, asciiBuffer, offset);    if (fractionPart > 0 && maxFractionDigits > 0) {        asciiBuffer[offset++] = '.';        offset = formatPositiveNumber(fractionPart, maxFractionDigits - 1, true, asciiBuffer, offset);    }    return offset;}
private static int pdfbox_f7862_0(long number, int exp, boolean omitTrailingZeros, byte[] asciiBuffer, int startOffset)
{    int offset = startOffset;    long remaining = number;    while (remaining > Integer.MAX_VALUE && (!omitTrailingZeros || remaining > 0)) {        long digit = remaining / POWER_OF_TENS[exp];        remaining -= (digit * POWER_OF_TENS[exp]);        asciiBuffer[offset++] = (byte) ('0' + digit);        exp--;    }        int remainingInt = (int) remaining;    while (exp >= 0 && (!omitTrailingZeros || remainingInt > 0)) {        int digit = remainingInt / POWER_OF_TENS_INT[exp];        remainingInt -= (digit * POWER_OF_TENS_INT[exp]);        asciiBuffer[offset++] = (byte) ('0' + digit);        exp--;    }    return offset;}
private static int pdfbox_f7863_0(long number)
{    for (int exp = 0; exp < (POWER_OF_TENS.length - 1); exp++) {        if (number < POWER_OF_TENS[exp + 1]) {            return exp;        }    }    return POWER_OF_TENS.length - 1;}
public static void pdfbox_f7864_0(List<T> list, Comparator<T> cmp)
{    int size = list.size();    if (size < 2) {        return;    }    quicksort(list, cmp);}
public static void pdfbox_f7865_0(List<T> list)
{    sort(list, (Comparator<T>) OBJCOMP);}
private static void pdfbox_f7866_0(List<T> list, Comparator<T> cmp)
{    Deque<Integer> stack = new ArrayDeque<>();    stack.push(0);    stack.push(list.size());    while (!stack.isEmpty()) {        int right = stack.pop();        int left = stack.pop();        if (right - left < 2) {            continue;        }        int p = left + ((right - left) / 2);        p = partition(list, cmp, p, left, right);        stack.push(p + 1);        stack.push(right);        stack.push(left);        stack.push(p);    }}
private static int pdfbox_f7867_0(List<T> list, Comparator<T> cmp, int p, int start, int end)
{    int l = start;    int h = end - 2;    T piv = list.get(p);    swap(list, p, end - 1);    while (l < h) {        if (cmp.compare(list.get(l), piv) <= 0) {            l++;        } else if (cmp.compare(piv, list.get(h)) <= 0) {            h--;        } else {            swap(list, l, h);        }    }    int idx = h;    if (cmp.compare(list.get(h), piv) < 0) {        idx++;    }    swap(list, end - 1, idx);    return idx;}
private static void pdfbox_f7868_0(List<T> list, int i, int j)
{    T tmp = list.get(i);    list.set(i, list.get(j));    list.set(j, tmp);}
private int pdfbox_f7869_0(Object key)
{    if (isEmpty() || (key == null)) {        return -1;    }    for (int aIdx = 0; aIdx < mapArr.length; aIdx += 2) {        if (key.equals(mapArr[aIdx])) {            return aIdx;        }    }    return -1;}
private int pdfbox_f7870_0(Object value)
{    if (isEmpty() || (value == null)) {        return -1;    }    for (int aIdx = 1; aIdx < mapArr.length; aIdx += 2) {        if (value.equals(mapArr[aIdx])) {            return aIdx;        }    }    return -1;}
public int pdfbox_f7871_0()
{    return mapArr == null ? 0 : mapArr.length >> 1;}
public boolean pdfbox_f7872_0()
{    return (mapArr == null) || (mapArr.length == 0);}
public boolean pdfbox_f7873_0(Object key)
{    return findKey(key) >= 0;}
public boolean pdfbox_f7874_0(Object value)
{    return findValue(value) >= 0;}
public V pdfbox_f7875_0(Object key)
{    int kIdx = findKey(key);    return kIdx < 0 ? null : (V) mapArr[kIdx + 1];}
public V pdfbox_f7876_0(K key, V value)
{    if ((key == null) || (value == null)) {        throw new NullPointerException("Key or value must not be null.");    }    if (mapArr == null) {        mapArr = new Object[] { key, value };        return null;    } else {        int kIdx = findKey(key);        if (kIdx < 0) {                        int oldLen = mapArr.length;            Object[] newMapArr = new Object[oldLen + 2];            System.arraycopy(mapArr, 0, newMapArr, 0, oldLen);            newMapArr[oldLen] = key;            newMapArr[oldLen + 1] = value;            mapArr = newMapArr;            return null;        } else {                        @SuppressWarnings("unchecked")            V oldValue = (V) mapArr[kIdx + 1];            mapArr[kIdx + 1] = value;            return oldValue;        }    }}
public V pdfbox_f7877_0(Object key)
{    int kIdx = findKey(key);    if (kIdx < 0) {                return null;    }    @SuppressWarnings("unchecked")    V oldValue = (V) mapArr[kIdx + 1];    int oldLen = mapArr.length;    if (oldLen == 2) {                mapArr = null;    } else {        Object[] newMapArr = new Object[oldLen - 2];        System.arraycopy(mapArr, 0, newMapArr, 0, kIdx);        System.arraycopy(mapArr, kIdx + 2, newMapArr, kIdx, oldLen - kIdx - 2);        mapArr = newMapArr;    }    return oldValue;}
public final void pdfbox_f7878_0(Map<? extends K, ? extends V> otherMap)
{    if ((mapArr == null) || (mapArr.length == 0)) {                mapArr = new Object[otherMap.size() << 1];        int aIdx = 0;        for (Entry<? extends K, ? extends V> entry : otherMap.entrySet()) {            if ((entry.getKey() == null) || (entry.getValue() == null)) {                throw new NullPointerException("Key or value must not be null.");            }            mapArr[aIdx++] = entry.getKey();            mapArr[aIdx++] = entry.getValue();        }    } else {        int oldLen = mapArr.length;                        Object[] newMapArr = new Object[oldLen + (otherMap.size() << 1)];        System.arraycopy(mapArr, 0, newMapArr, 0, oldLen);        int newIdx = oldLen;        for (Entry<? extends K, ? extends V> entry : otherMap.entrySet()) {            if ((entry.getKey() == null) || (entry.getValue() == null)) {                throw new NullPointerException("Key or value must not be null.");            }            int existKeyIdx = findKey(entry.getKey());            if (existKeyIdx >= 0) {                                newMapArr[existKeyIdx + 1] = entry.getValue();            } else {                                newMapArr[newIdx++] = entry.getKey();                newMapArr[newIdx++] = entry.getValue();            }        }        if (newIdx < newMapArr.length) {            Object[] reducedMapArr = new Object[newIdx];            System.arraycopy(newMapArr, 0, reducedMapArr, 0, newIdx);            newMapArr = reducedMapArr;        }        mapArr = newMapArr;    }}
public void pdfbox_f7879_0()
{    mapArr = null;}
public Set<K> pdfbox_f7880_0()
{    if (isEmpty()) {        return Collections.emptySet();    }    Set<K> keys = new LinkedHashSet<>();    for (int kIdx = 0; kIdx < mapArr.length; kIdx += 2) {        keys.add((K) mapArr[kIdx]);    }    return Collections.unmodifiableSet(keys);}
public Collection<V> pdfbox_f7881_0()
{    if (isEmpty()) {        return Collections.emptySet();    }    List<V> values = new ArrayList<>(mapArr.length >> 1);    for (int vIdx = 1; vIdx < mapArr.length; vIdx += 2) {        values.add((V) mapArr[vIdx]);    }    return Collections.unmodifiableList(values);}
public K pdfbox_f7882_0()
{    return (K) mapArr[keyIdx];}
public V pdfbox_f7883_0()
{    return (V) mapArr[keyIdx + 1];}
public V pdfbox_f7884_0(V value)
{    if (value == null) {        throw new NullPointerException("Key or value must not be null.");    }    V oldValue = getValue();    mapArr[keyIdx + 1] = value;    return oldValue;}
public int pdfbox_f7885_0()
{    return getKey().hashCode();}
public boolean pdfbox_f7886_0(Object obj)
{    if (!(obj instanceof SmallMap.SmallMapEntry)) {        return false;    }    @SuppressWarnings("unchecked")    SmallMapEntry other = (SmallMapEntry) obj;    return getKey().equals(other.getKey()) && getValue().equals(other.getValue());}
public Set<java.util.Map.Entry<K, V>> pdfbox_f7887_0()
{    if (isEmpty()) {        return Collections.emptySet();    }    Set<java.util.Map.Entry<K, V>> entries = new LinkedHashSet<>();    for (int kIdx = 0; kIdx < mapArr.length; kIdx += 2) {        entries.add(new SmallMapEntry(kIdx));    }    return Collections.unmodifiableSet(entries);}
public float pdfbox_f7888_0()
{    return x;}
public float pdfbox_f7889_0()
{    return y;}
public Vector pdfbox_f7890_0(float sxy)
{    return new Vector(x * sxy, y * sxy);}
public String pdfbox_f7891_0()
{    return "(" + x + ", " + y + ")";}
public static String pdfbox_f7892_1()
{    try (InputStream is = Version.class.getResourceAsStream(PDFBOX_VERSION_PROPERTIES)) {        if (is == null) {            return null;        }        Properties properties = new Properties();        properties.load(is);        return properties.getProperty("pdfbox.version", null);    } catch (IOException io) {                return null;    }}
public static Document pdfbox_f7893_0(InputStream is) throws IOException
{    return parse(is, false);}
public static Document pdfbox_f7894_0(InputStream is, boolean nsAware) throws IOException
{    try {        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();        builderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);        builderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);        builderFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);        builderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);        builderFactory.setXIncludeAware(false);        builderFactory.setExpandEntityReferences(false);        builderFactory.setNamespaceAware(nsAware);        DocumentBuilder builder = builderFactory.newDocumentBuilder();        return builder.parse(is);    } catch (FactoryConfigurationError | ParserConfigurationException | SAXException e) {        throw new IOException(e.getMessage(), e);    }}
public static String pdfbox_f7895_0(Element node)
{    StringBuilder sb = new StringBuilder();    NodeList children = node.getChildNodes();    int numNodes = children.getLength();    for (int i = 0; i < numNodes; i++) {        Node next = children.item(i);        if (next instanceof Text) {            sb.append(next.getNodeValue());        }    }    return sb.toString();}
public void pdfbox_f7896_0()
{        final COSObjectKey objectUnderTest = new COSObjectKey(0L, 0);    final COSObjectKey other = new COSObjectKey(0L, 0);        final int retval = objectUnderTest.compareTo(other);        Assert.assertEquals(0, retval);}
public void pdfbox_f7897_0()
{        final COSObjectKey objectUnderTest = new COSObjectKey(0L, 0);    final COSObjectKey other = new COSObjectKey(-9_223_372_036_854_775_808L, 0);        final int retval = objectUnderTest.compareTo(other);        Assert.assertEquals(1, retval);}
public void pdfbox_f7898_0()
{    for (String deviation : deviations) {        COSString cosString = new COSString(deviation);        assertEquals(cosString.getString(), deviation);    }}
public void pdfbox_f7899_0() throws IOException
{    for (int i = 0; i < 256; i++) {        String hex = String.format("FEFF%04X", i);        COSString cs1 = COSString.parseHex(hex);        COSString cs2 = new COSString(cs1.getString());        assertEquals(cs1, cs2);    }}
public void pdfbox_f7900_0()
{    assertEquals(testCOSBase, testCOSBase.getCOSObject());}
public void pdfbox_f7901_0()
{    testCOSBase.setDirect(true);    assertTrue(testCOSBase.isDirect());    testCOSBase.setDirect(false);    assertFalse(testCOSBase.isDirect());}
protected void pdfbox_f7902_0(byte[] byteArr1, byte[] byteArr2)
{    assertEquals(byteArr1.length, byteArr1.length);    for (int i = 0; i < byteArr1.length; i++) {        assertEquals(byteArr1[i], byteArr2[i]);    }}
public void pdfbox_f7903_0()
{    try {        testCOSBase = COSNumber.get("1.1");    } catch (IOException e) {        fail("Failed to create a COSNumber in setUp()");    }}
public void pdfbox_f7904_0(int low, int high, int step)
{    this.low = low;    this.high = high;    this.step = step;}
public void pdfbox_f7905_0()
{        loop(123456);        loop(System.currentTimeMillis());}
private void pdfbox_f7906_0(long seed)
{    Random rnd = new Random(seed);    for (int i = low; i < high; i += step) {        float num = i * rnd.nextFloat();        try {            runTest(num);        } catch (AssertionError a) {            fail("num = " + num + ", seed = " + seed);        }    }}
public void pdfbox_f7907_0()
{    new BaseTester() {        @Override        void runTest(float num) {            COSFloat test1 = new COSFloat(num);            COSFloat test2 = new COSFloat(num);            COSFloat test3 = new COSFloat(num);                        assertTrue(test1.equals(test1));                        assertTrue(test2.equals(test3));            assertTrue(test1.equals(test2));                        assertTrue(test1.equals(test2));            assertTrue(test2.equals(test3));            assertTrue(test1.equals(test3));            float nf = Float.intBitsToFloat(Float.floatToIntBits(num) + 1);            COSFloat test4 = new COSFloat(nf);            assertFalse(test4.equals(test1));        }    }.runTests();}
 void pdfbox_f7908_0(float num)
{    COSFloat test1 = new COSFloat(num);    COSFloat test2 = new COSFloat(num);    COSFloat test3 = new COSFloat(num);        assertTrue(test1.equals(test1));        assertTrue(test2.equals(test3));    assertTrue(test1.equals(test2));        assertTrue(test1.equals(test2));    assertTrue(test2.equals(test3));    assertTrue(test1.equals(test3));    float nf = Float.intBitsToFloat(Float.floatToIntBits(num) + 1);    COSFloat test4 = new COSFloat(nf);    assertFalse(test4.equals(test1));}
 void pdfbox_f7909_0(float num)
{    COSFloat test1 = new COSFloat(num);    COSFloat test2 = new COSFloat(num);    assertEquals(test1.hashCode(), test2.hashCode());    float nf = Float.intBitsToFloat(Float.floatToIntBits(num) + 1);    COSFloat test3 = new COSFloat(nf);    assertFalse(test3.hashCode() == test1.hashCode());}
public void pdfbox_f7910_0()
{    new HashCodeTester().runTests();}
 void pdfbox_f7911_0(float num)
{    COSFloat testFloat = new COSFloat(num);    assertEquals(num, testFloat.floatValue());}
public void pdfbox_f7912_0()
{    new FloatValueTester().runTests();}
 void pdfbox_f7913_0(float num)
{    COSFloat testFloat = new COSFloat(num);            assertEquals(Float.toString(num), Double.toString(testFloat.doubleValue()));}
public void pdfbox_f7914_0()
{    new DoubleValueTester().runTests();}
 void pdfbox_f7915_0(float num)
{    COSFloat testFloat = new COSFloat(num);    assertEquals((int) num, testFloat.intValue());}
public void pdfbox_f7916_0()
{    new IntValueTester().runTests();}
 void pdfbox_f7917_0(float num)
{    COSFloat testFloat = new COSFloat(num);    assertEquals((long) num, testFloat.longValue());}
public void pdfbox_f7918_0()
{    new LongValueTester().runTests();}
 void pdfbox_f7919_0(float num)
{    try {        COSFloat cosFloat = new COSFloat(num);        cosFloat.accept(visitor);        assertEquals(floatToString(cosFloat.floatValue()), outStream.toString("ISO-8859-1"));        testByteArrays(floatToString(num).getBytes("ISO-8859-1"), outStream.toByteArray());        outStream.reset();    } catch (IOException e) {        fail("Failed to write " + num + " exception: " + e.getMessage());    }}
public void pdfbox_f7920_0()
{    new AcceptTester().runTests();}
 void pdfbox_f7921_0(float num)
{    try {        COSFloat cosFloat = new COSFloat(num);        cosFloat.writePDF(outStream);        assertEquals(floatToString(cosFloat.floatValue()), outStream.toString("ISO-8859-1"));        assertEquals(floatToString(num), outStream.toString("ISO-8859-1"));        testByteArrays(floatToString(num).getBytes("ISO-8859-1"), outStream.toByteArray());        outStream.reset();    } catch (IOException e) {        fail("Failed to write " + num + " exception: " + e.getMessage());    }}
public void pdfbox_f7922_0()
{    WritePDFTester writePDFTester = new WritePDFTester();    writePDFTester.runTests();        writePDFTester.runTest(0.000000000000000000000000000000001f);}
public void pdfbox_f7923_0() throws IOException
{        COSFloat cosFloat = new COSFloat("--16.33");    assertEquals(-16.33f, cosFloat.floatValue());}
private String pdfbox_f7924_0(float value)
{        return removeTrailingNull(new BigDecimal(String.valueOf(value)).toPlainString());}
private String pdfbox_f7925_0(String value)
{        if (value.indexOf('.') > -1 && !value.endsWith(".0")) {        while (value.endsWith("0") && !value.endsWith(".0")) {            value = value.substring(0, value.length() - 1);        }    }    return value;}
public static Test pdfbox_f7926_0()
{    return new TestSuite(TestCOSFloat.class);}
public void pdfbox_f7927_0()
{    try {        testCOSBase = COSNumber.get("0");    } catch (IOException e) {        fail("Failed to create a COSNumber in setUp()");    }}
public void pdfbox_f7928_0()
{        for (int i = -1000; i < 3000; i += 200) {        COSInteger test1 = COSInteger.get(i);        COSInteger test2 = COSInteger.get(i);        COSInteger test3 = COSInteger.get(i);                assertTrue(test1.equals(test1));                assertTrue(test2.equals(test1));        assertTrue(test1.equals(test2));                assertTrue(test1.equals(test2));        assertTrue(test2.equals(test3));        assertTrue(test1.equals(test3));                assertFalse(test1 == null);        assertFalse(test2 == null);        assertFalse(test3 == null);        COSInteger test4 = COSInteger.get(i + 1);        assertFalse(test4.equals(test1));    }}
public void pdfbox_f7929_0()
{    for (int i = -1000; i < 3000; i += 200) {        COSInteger test1 = COSInteger.get(i);        COSInteger test2 = COSInteger.get(i);        assertEquals(test1.hashCode(), test2.hashCode());        COSInteger test3 = COSInteger.get(i + 1);        assertFalse(test3.hashCode() == test1.hashCode());    }}
public void pdfbox_f7930_0()
{    for (int i = -1000; i < 3000; i += 200) {        assertEquals((float) i, COSInteger.get(i).floatValue());    }}
public void pdfbox_f7931_0()
{    for (int i = -1000; i < 3000; i += 200) {        assertEquals((double) i, COSInteger.get(i).doubleValue());    }}
public void pdfbox_f7932_0()
{    for (int i = -1000; i < 3000; i += 200) {        assertEquals(i, COSInteger.get(i).intValue());    }}
public void pdfbox_f7933_0()
{    for (int i = -1000; i < 3000; i += 200) {        assertEquals((long) i, COSInteger.get(i).longValue());    }}
public void pdfbox_f7934_0()
{    ByteArrayOutputStream outStream = new ByteArrayOutputStream();    COSWriter visitor = new COSWriter(outStream);    int index = 0;    try {        for (int i = -1000; i < 3000; i += 200) {            index = i;            COSInteger cosInt = COSInteger.get(i);            cosInt.accept(visitor);            testByteArrays(String.valueOf(i).getBytes("ISO-8859-1"), outStream.toByteArray());            outStream.reset();        }    } catch (Exception e) {        fail("Failed to write " + index + " exception: " + e.getMessage());    }}
public void pdfbox_f7935_0()
{    ByteArrayOutputStream outStream = new ByteArrayOutputStream();    int index = 0;    try {        for (int i = -1000; i < 3000; i += 200) {            index = i;            COSInteger cosInt = COSInteger.get(i);            cosInt.writePDF(outStream);            testByteArrays(String.valueOf(i).getBytes("ISO-8859-1"), outStream.toByteArray());            outStream.reset();        }    } catch (Exception e) {        fail("Failed to write " + index + " exception: " + e.getMessage());    }}
public static Test pdfbox_f7936_0()
{    return new TestSuite(TestCOSInteger.class);}
public void pdfbox_f7937_0() throws IOException
{    String special = "中国你好!";    ByteArrayOutputStream baos = new ByteArrayOutputStream();    try (PDDocument document = new PDDocument()) {        PDPage page = new PDPage();        document.addPage(page);        document.getDocumentCatalog().getCOSObject().setString(COSName.getPDFName(special), special);        document.save(baos);    }    try (PDDocument document = PDDocument.load(baos.toByteArray())) {        COSDictionary catalogDict = document.getDocumentCatalog().getCOSObject();        Assert.assertTrue(catalogDict.containsKey(special));        Assert.assertEquals(special, catalogDict.getString(special));    }}
public void pdfbox_f7938_0()
{    try {                assertEquals(COSInteger.ZERO, COSNumber.get("0"));        assertEquals(COSInteger.ONE, COSNumber.get("1"));        assertEquals(COSInteger.TWO, COSNumber.get("2"));        assertEquals(COSInteger.THREE, COSNumber.get("3"));                assertEquals(COSInteger.get(100), COSNumber.get("100"));        assertEquals(COSInteger.get(256), COSNumber.get("256"));        assertEquals(COSInteger.get(-1000), COSNumber.get("-1000"));        assertEquals(COSInteger.get(2000), COSNumber.get("+2000"));                assertEquals(new COSFloat(1.1f), COSNumber.get("1.1"));        assertEquals(new COSFloat(100f), COSNumber.get("100.0"));        assertEquals(new COSFloat(-100.001f), COSNumber.get("-100.001"));                        assertNotNull(COSNumber.get("-2e-006"));        assertNotNull(COSNumber.get("-8e+05"));        try {            assertEquals("Null Value...", COSNumber.get(null));            fail("Failed to throw a NullPointerException");        } catch (NullPointerException e) {                }    } catch (IOException e) {        fail("Failed to convert a number " + e.getMessage());    }}
public void pdfbox_f7939_0() throws IOException
{    byte[] testString = "This is a test string to be used as input for TestCOSStream".getBytes("ASCII");    COSStream stream = createStream(testString, null);    validateEncoded(stream, testString);}
public void pdfbox_f7940_0() throws IOException
{    byte[] testString = "This is a test string to be used as input for TestCOSStream".getBytes("ASCII");    COSStream stream = createStream(testString, null);    validateDecoded(stream, testString);}
public void pdfbox_f7941_0() throws IOException
{    byte[] testString = "This is a test string to be used as input for TestCOSStream".getBytes("ASCII");    byte[] testStringEncoded = encodeData(testString, COSName.FLATE_DECODE);    COSStream stream = createStream(testString, COSName.FLATE_DECODE);    validateEncoded(stream, testStringEncoded);}
public void pdfbox_f7942_0() throws IOException
{    byte[] testString = "This is a test string to be used as input for TestCOSStream".getBytes("ASCII");    byte[] testStringEncoded = encodeData(testString, COSName.FLATE_DECODE);    COSStream stream = new COSStream();    try (OutputStream output = stream.createRawOutputStream()) {        output.write(testStringEncoded);    }    stream.setItem(COSName.FILTER, COSName.FLATE_DECODE);    validateDecoded(stream, testString);}
public void pdfbox_f7943_0() throws IOException
{    byte[] testString = "This is a test string to be used as input for TestCOSStream".getBytes("ASCII");    byte[] testStringEncoded = encodeData(testString, COSName.FLATE_DECODE);    testStringEncoded = encodeData(testStringEncoded, COSName.ASCII85_DECODE);    COSArray filters = new COSArray();    filters.add(COSName.ASCII85_DECODE);    filters.add(COSName.FLATE_DECODE);    COSStream stream = createStream(testString, filters);    validateEncoded(stream, testStringEncoded);}
public void pdfbox_f7944_0() throws IOException
{    byte[] testString = "This is a test string to be used as input for TestCOSStream".getBytes("ASCII");    byte[] testStringEncoded = encodeData(testString, COSName.FLATE_DECODE);    testStringEncoded = encodeData(testStringEncoded, COSName.ASCII85_DECODE);    COSStream stream = new COSStream();    COSArray filters = new COSArray();    filters.add(COSName.ASCII85_DECODE);    filters.add(COSName.FLATE_DECODE);    stream.setItem(COSName.FILTER, filters);    try (OutputStream output = stream.createRawOutputStream()) {        output.write(testStringEncoded);    }    validateDecoded(stream, testString);}
public void pdfbox_f7945_0() throws IOException
{    byte[] testString = "This is a test string to be used as input for TestCOSStream".getBytes("ASCII");    byte[] testStringEncoded = encodeData(testString, COSName.FLATE_DECODE);    COSStream stream = new COSStream();    OutputStream output = stream.createOutputStream(COSName.FLATE_DECODE);    output.write(testString);    output.close();    output.close();    validateEncoded(stream, testStringEncoded);}
private byte[] pdfbox_f7946_0(byte[] original, COSName filter) throws IOException
{    Filter encodingFilter = FilterFactory.INSTANCE.getFilter(filter);    ByteArrayOutputStream encoded = new ByteArrayOutputStream();    encodingFilter.encode(new ByteArrayInputStream(original), encoded, new COSDictionary(), 0);    return encoded.toByteArray();}
private COSStream pdfbox_f7947_0(byte[] testString, COSBase filters) throws IOException
{    COSStream stream = new COSStream();    try (OutputStream output = stream.createOutputStream(filters)) {        output.write(testString);    }    return stream;}
private void pdfbox_f7948_0(COSStream stream, byte[] expected) throws IOException
{    byte[] decoded = IOUtils.toByteArray(stream.createRawInputStream());    stream.close();    assertTrue("Encoded data doesn't match input", Arrays.equals(expected, decoded));}
private void pdfbox_f7949_0(COSStream stream, byte[] expected) throws IOException
{    byte[] encoded = IOUtils.toByteArray(stream.createInputStream());    stream.close();    assertTrue("Decoded data doesn't match input", Arrays.equals(expected, encoded));}
public static Test pdfbox_f7950_0()
{    return new TestSuite(TestCOSString.class);}
public void pdfbox_f7951_0()
{    testCOSBase = new COSString("test cos string");}
public static void pdfbox_f7952_0(String[] args)
{    String[] arg = { TestCOSString.class.getName() };    junit.textui.TestRunner.main(arg);}
public void pdfbox_f7953_0()
{    String inputString = "Test with a text and a few numbers 1, 2 and 3";    String pdfHex = "<" + createHex(inputString) + ">";    COSString cosStr = new COSString(inputString);    cosStr.setForceHexForm(true);    writePDFTests(pdfHex, cosStr);    COSString escStr = new COSString(ESC_CHAR_STRING);    writePDFTests("(" + ESC_CHAR_STRING_PDF_FORMAT + ")", escStr);    escStr.setForceHexForm(true);        writePDFTests("<" + createHex(ESC_CHAR_STRING) + ">", escStr);}
private void pdfbox_f7954_0(String expected, COSString testSubj)
{    ByteArrayOutputStream outStream = new ByteArrayOutputStream();    try {        COSWriter.writeString(testSubj, outStream);    } catch (IOException e) {        fail("IOException: " + e.getMessage());    }    assertEquals(expected, outStream.toString());}
public void pdfbox_f7955_0()
{    String expected = "Quick and simple test";    String hexForm = createHex(expected);    try {        COSString test1 = COSString.parseHex(hexForm);        writePDFTests("(" + expected + ")", test1);        COSString test2 = COSString.parseHex(createHex(ESC_CHAR_STRING));        writePDFTests("(" + ESC_CHAR_STRING_PDF_FORMAT + ")", test2);    } catch (IOException e) {        fail("IOException thrown: " + e.getMessage());    }    try {        COSString.parseHex(hexForm + "xx");        fail("Should have thrown an IOException here");    } catch (IOException e) {        }}
private String pdfbox_f7956_0(String str)
{    StringBuilder sb = new StringBuilder();    for (char c : str.toCharArray()) {        sb.append(Integer.toString(c, 16));    }    return sb.toString().toUpperCase();}
public void pdfbox_f7957_0()
{    String expected = "Test subject for testing getHex";    COSString test1 = new COSString(expected);    String hexForm = createHex(expected);    assertEquals(hexForm, test1.toHexString());    COSString escCS = new COSString(ESC_CHAR_STRING);            assertEquals(createHex(ESC_CHAR_STRING), escCS.toHexString());}
public void pdfbox_f7958_0()
{    try {        String testStr = "Test subject for getString()";        COSString test1 = new COSString(testStr);        assertEquals(testStr, test1.getString());        COSString hexStr = COSString.parseHex(createHex(testStr));        assertEquals(testStr, hexStr.getString());        COSString escapedString = new COSString(ESC_CHAR_STRING);        assertEquals(ESC_CHAR_STRING, escapedString.getString());        testStr = "Line1\nLine2\nLine3\n";        COSString lineFeedString = new COSString(testStr);        assertEquals(testStr, lineFeedString.getString());    } catch (IOException e) {        fail("IOException thrown: " + e.getMessage());    }}
public void pdfbox_f7959_0()
{    COSString str = new COSString(ESC_CHAR_STRING);    testByteArrays(ESC_CHAR_STRING.getBytes(), str.getBytes());}
public void pdfbox_f7960_0()
{        COSString testSubj = new COSString(ESC_CHAR_STRING);    writePDFTests("(" + ESC_CHAR_STRING_PDF_FORMAT + ")", testSubj);    String textString = "This is just an arbitrary piece of text for testing";    COSString testSubj2 = new COSString(textString);    writePDFTests("(" + textString + ")", testSubj2);}
public void pdfbox_f7961_0() throws IOException
{    String theString = "\u4e16";    COSString string = new COSString(theString);    assertTrue(string.getString().equals(theString));    String textAscii = "This is some regular text. It should all be expressable in ASCII";    /**     * En français où les choses sont accentués. En español, así     */    String text8Bit = "En fran\u00e7ais o\u00f9 les choses sont accentu\u00e9s. En espa\u00f1ol, as\u00ed";    /**     * をクリックしてく     */    String textHighBits = "\u3092\u30af\u30ea\u30c3\u30af\u3057\u3066\u304f";        COSString stringAscii = new COSString(textAscii);    assertEquals(stringAscii.getString(), textAscii);    COSString string8Bit = new COSString(text8Bit);    assertEquals(string8Bit.getString(), text8Bit);    COSString stringHighBits = new COSString(textHighBits);    assertEquals(stringHighBits.getString(), textHighBits);            assertEquals(textAscii, new String(stringAscii.getBytes(), "ISO-8859-1"));        assertEquals(text8Bit, new String(string8Bit.getBytes(), "ISO-8859-1"));        assertEquals(textHighBits, new String(stringHighBits.getBytes(), "UnicodeBig"));        ByteArrayOutputStream out = new ByteArrayOutputStream();    COSWriter.writeString(stringAscii, out);    assertEquals("(" + textAscii + ")", new String(out.toByteArray(), "ASCII"));    out.reset();    COSWriter.writeString(string8Bit, out);    StringBuffer hex = new StringBuffer();    for (char c : text8Bit.toCharArray()) {        hex.append(Integer.toHexString(c).toUpperCase());    }    assertEquals("<" + hex.toString() + ">", new String(out.toByteArray(), "ASCII"));    out.reset();    COSWriter.writeString(stringHighBits, out);    hex = new StringBuffer();        hex.append("FEFF");    for (char c : textHighBits.toCharArray()) {        hex.append(Integer.toHexString(c).toUpperCase());    }    assertEquals("<" + hex.toString() + ">", new String(out.toByteArray(), "ASCII"));}
public void pdfbox_f7962_0() throws IOException
{    ByteArrayOutputStream outStream = new ByteArrayOutputStream();    ICOSVisitor visitor = new COSWriter(outStream);    COSString testSubj = new COSString(ESC_CHAR_STRING);    testSubj.accept(visitor);    assertEquals("(" + ESC_CHAR_STRING_PDF_FORMAT + ")", outStream.toString());    outStream.reset();    testSubj.setForceHexForm(true);    testSubj.accept(visitor);    assertEquals("<" + createHex(ESC_CHAR_STRING) + ">", outStream.toString());}
public void pdfbox_f7963_0()
{        for (int i = 0; i < 10; i++) {                COSString x1 = new COSString("Test");        assertTrue(x1.equals(x1));                COSString y1 = new COSString("Test");        assertTrue(x1.equals(y1));        assertTrue(y1.equals(x1));        COSString x2 = new COSString("Test");        x2.setForceHexForm(true);                assertFalse(x1.equals(x2));        assertFalse(x2.equals(x1));                COSString z1 = new COSString("Test");        assertTrue(x1.equals(y1));        assertTrue(y1.equals(z1));        assertTrue(x1.equals(z1));                assertTrue(x1.equals(y1));        assertFalse(y1.equals(x2));        assertFalse(x1.equals(x2));                assertFalse(x1 == null);        assertFalse(y1 == null);        assertFalse(z1 == null);        assertFalse(x2 == null);    }}
public void pdfbox_f7964_0()
{    COSString str1 = new COSString("Test1");    COSString str2 = new COSString("Test2");    assertFalse(str1.hashCode() == str2.hashCode());    COSString str3 = new COSString("Test1");    assertTrue(str1.hashCode() == str3.hashCode());    str3.setForceHexForm(true);    assertFalse(str1.hashCode() == str3.hashCode());}
public void pdfbox_f7965_0() throws IOException
{    COSString test1 = COSString.parseHex("000000FF000000");    COSString test2 = COSString.parseHex("000000FF00FFFF");    assertEquals(test1, test1);    assertEquals(test2, test2);    assertFalse(test1.toHexString().equals(test2.toHexString()));    assertFalse(Arrays.equals(test1.getBytes(), test2.getBytes()));    assertFalse(test1.equals(test2));    assertFalse(test2.equals(test1));    assertFalse(test1.getString().equals(test2.getString()));}
public void pdfbox_f7966_0() throws IOException
{    assertTrue(COSString.parseHex("FEFF").getString().isEmpty());    assertTrue(COSString.parseHex("FFFE").getString().isEmpty());}
public void pdfbox_f7967_0()
{        COSUpdateInfo testCOSDictionary = new COSDictionary();    testCOSDictionary.setNeedToBeUpdated(true);    assertTrue(testCOSDictionary.isNeedToBeUpdated());    testCOSDictionary.setNeedToBeUpdated(false);    assertFalse(testCOSDictionary.isNeedToBeUpdated());        COSUpdateInfo testCOSObject;    testCOSObject = new COSObject(null);    testCOSObject.setNeedToBeUpdated(true);    assertTrue(testCOSObject.isNeedToBeUpdated());    testCOSObject.setNeedToBeUpdated(false);    assertFalse(testCOSObject.isNeedToBeUpdated());}
public static Collection pdfbox_f7968_0()
{    return Arrays.asList(40, 128, 256);}
public void pdfbox_f7969_0() throws Exception
{    if (Cipher.getMaxAllowedKeyLength("AES") != Integer.MAX_VALUE) {                fail("JCE unlimited strength jurisdiction policy files are not installed");    }    permission1 = new AccessPermission();    permission1.setCanAssembleDocument(false);    permission1.setCanExtractContent(false);    permission1.setCanExtractForAccessibility(true);    permission1.setCanFillInForm(false);    permission1.setCanModify(false);    permission1.setCanModifyAnnotations(false);    permission1.setCanPrint(false);    permission1.setCanPrintDegraded(false);    permission2 = new AccessPermission();    permission2.setCanAssembleDocument(false);    permission2.setCanExtractContent(false);    permission2.setCanExtractForAccessibility(true);    permission2.setCanFillInForm(false);    permission2.setCanModify(false);    permission2.setCanModifyAnnotations(false);        permission2.setCanPrint(true);    permission2.setCanPrintDegraded(false);    recipient1 = getRecipient("test1.der", permission1);    recipient2 = getRecipient("test2.der", permission2);    password1 = "test1";    password2 = "test2";    keyStore1 = "test1.pfx";    keyStore2 = "test2.pfx";    document = PDDocument.load(new File(this.getClass().getResource("test.pdf").toURI()));    text = new PDFTextStripper().getText(document);    producer = document.getDocumentInformation().getProducer();    document.setVersion(1.7f);}
public void pdfbox_f7970_0() throws Exception
{    document.close();}
public void pdfbox_f7971_0() throws Exception
{    PublicKeyProtectionPolicy policy = new PublicKeyProtectionPolicy();    policy.addRecipient(recipient1);    policy.setEncryptionKeyLength(keyLength);    document.protect(policy);    PDDocument encryptedDoc = null;    try {        File file = save("testProtectionError");        encryptedDoc = reload(file, password2, getKeyStore(keyStore2));        Assert.assertTrue(encryptedDoc.isEncrypted());        fail("No exception when using an incorrect decryption key");    } catch (IOException ex) {        String msg = ex.getMessage();        Assert.assertTrue("not the expected exception: " + msg, msg.contains("serial-#: rid 2 vs. cert 3"));    } finally {        if (encryptedDoc != null) {            encryptedDoc.close();        }    }}
public void pdfbox_f7972_0() throws Exception
{    PublicKeyProtectionPolicy policy = new PublicKeyProtectionPolicy();    policy.addRecipient(recipient1);    policy.setEncryptionKeyLength(keyLength);    document.protect(policy);    File file = save("testProtection");    try (PDDocument encryptedDoc = reload(file, password1, getKeyStore(keyStore1))) {        Assert.assertTrue(encryptedDoc.isEncrypted());        AccessPermission permission = encryptedDoc.getCurrentAccessPermission();        Assert.assertFalse(permission.canAssembleDocument());        Assert.assertFalse(permission.canExtractContent());        Assert.assertTrue(permission.canExtractForAccessibility());        Assert.assertFalse(permission.canFillInForm());        Assert.assertFalse(permission.canModify());        Assert.assertFalse(permission.canModifyAnnotations());        Assert.assertFalse(permission.canPrint());        Assert.assertFalse(permission.canPrintDegraded());    }}
public void pdfbox_f7973_0() throws Exception
{    PublicKeyProtectionPolicy policy = new PublicKeyProtectionPolicy();    policy.addRecipient(recipient1);    policy.addRecipient(recipient2);    policy.setEncryptionKeyLength(keyLength);    document.protect(policy);        File file = save("testMultipleRecipients");    try (PDDocument encryptedDoc1 = reload(file, password1, getKeyStore(keyStore1))) {        AccessPermission permission = encryptedDoc1.getCurrentAccessPermission();        Assert.assertFalse(permission.canAssembleDocument());        Assert.assertFalse(permission.canExtractContent());        Assert.assertTrue(permission.canExtractForAccessibility());        Assert.assertFalse(permission.canFillInForm());        Assert.assertFalse(permission.canModify());        Assert.assertFalse(permission.canModifyAnnotations());        Assert.assertFalse(permission.canPrint());        Assert.assertFalse(permission.canPrintDegraded());    }        try (PDDocument encryptedDoc2 = reload(file, password2, getKeyStore(keyStore2))) {        AccessPermission permission = encryptedDoc2.getCurrentAccessPermission();        Assert.assertFalse(permission.canAssembleDocument());        Assert.assertFalse(permission.canExtractContent());        Assert.assertTrue(permission.canExtractForAccessibility());        Assert.assertFalse(permission.canFillInForm());        Assert.assertFalse(permission.canModify());        Assert.assertFalse(permission.canModifyAnnotations());        Assert.assertTrue(permission.canPrint());        Assert.assertFalse(permission.canPrintDegraded());    }}
private PDDocument pdfbox_f7974_0(File file, String decryptionPassword, InputStream keyStore) throws IOException, NoSuchAlgorithmException
{    PDDocument doc2 = PDDocument.load(file, decryptionPassword, keyStore, null, MemoryUsageSetting.setupMainMemoryOnly());    Assert.assertEquals("Extracted text is different", text, new PDFTextStripper().getText(doc2));    Assert.assertEquals("Producer is different", producer, doc2.getDocumentInformation().getProducer());    return doc2;}
private PublicKeyRecipient pdfbox_f7975_0(String certificate, AccessPermission permission) throws Exception
{    try (InputStream input = TestPublicKeyEncryption.class.getResourceAsStream(certificate)) {        CertificateFactory factory = CertificateFactory.getInstance("X.509");        PublicKeyRecipient recipient = new PublicKeyRecipient();        recipient.setPermission(permission);        recipient.setX509((X509Certificate) factory.generateCertificate(input));        return recipient;    }}
private InputStream pdfbox_f7976_0(String name)
{    return TestPublicKeyEncryption.class.getResourceAsStream(name);}
private File pdfbox_f7977_0(String name) throws IOException
{    File file = new File(testResultsDir, name + "-" + keyLength + "bit.pdf");    document.save(file);    return file;}
protected void pdfbox_f7978_0() throws Exception
{    testResultsDir.mkdirs();    if (Cipher.getMaxAllowedKeyLength("AES") != Integer.MAX_VALUE) {                fail("JCE unlimited strength jurisdiction policy files are not installed");    }    permission = new AccessPermission();    permission.setCanAssembleDocument(false);    permission.setCanExtractContent(false);    permission.setCanExtractForAccessibility(true);    permission.setCanFillInForm(false);    permission.setCanModify(false);    permission.setCanModifyAnnotations(false);    permission.setCanPrint(true);    permission.setCanPrintDegraded(false);    permission.setReadOnly();}
public void pdfbox_f7979_0() throws IOException
{    AccessPermission fullAP = new AccessPermission();    AccessPermission restrAP = new AccessPermission();    restrAP.setCanPrint(false);    restrAP.setCanExtractContent(false);    restrAP.setCanModify(false);    byte[] inputFileAsByteArray = getFileResourceAsByteArray("PasswordSample-40bit.pdf");    checkPerms(inputFileAsByteArray, "owner", fullAP);    checkPerms(inputFileAsByteArray, "user", restrAP);    try {        checkPerms(inputFileAsByteArray, "", null);        fail("wrong password not detected");    } catch (IOException ex) {        assertEquals("Cannot decrypt PDF, the password is incorrect", ex.getMessage());    }    restrAP.setCanAssembleDocument(false);    restrAP.setCanExtractForAccessibility(false);    restrAP.setCanPrintDegraded(false);    inputFileAsByteArray = getFileResourceAsByteArray("PasswordSample-128bit.pdf");    checkPerms(inputFileAsByteArray, "owner", fullAP);    checkPerms(inputFileAsByteArray, "user", restrAP);    try {        checkPerms(inputFileAsByteArray, "", null);        fail("wrong password not detected");    } catch (IOException ex) {        assertEquals("Cannot decrypt PDF, the password is incorrect", ex.getMessage());    }    inputFileAsByteArray = getFileResourceAsByteArray("PasswordSample-256bit.pdf");    checkPerms(inputFileAsByteArray, "owner", fullAP);    checkPerms(inputFileAsByteArray, "user", restrAP);    try {        checkPerms(inputFileAsByteArray, "", null);        fail("wrong password not detected");    } catch (IOException ex) {        assertEquals("Cannot decrypt PDF, the password is incorrect", ex.getMessage());    }}
private void pdfbox_f7980_0(byte[] inputFileAsByteArray, String password, AccessPermission expectedPermissions) throws IOException
{    try (PDDocument doc = PDDocument.load(inputFileAsByteArray, password)) {        AccessPermission currentAccessPermission = doc.getCurrentAccessPermission();                assertEquals(expectedPermissions.isOwnerPermission(), currentAccessPermission.isOwnerPermission());        if (!expectedPermissions.isOwnerPermission()) {            assertEquals(true, currentAccessPermission.isReadOnly());        }        assertEquals(expectedPermissions.canAssembleDocument(), currentAccessPermission.canAssembleDocument());        assertEquals(expectedPermissions.canExtractContent(), currentAccessPermission.canExtractContent());        assertEquals(expectedPermissions.canExtractForAccessibility(), currentAccessPermission.canExtractForAccessibility());        assertEquals(expectedPermissions.canFillInForm(), currentAccessPermission.canFillInForm());        assertEquals(expectedPermissions.canModify(), currentAccessPermission.canModify());        assertEquals(expectedPermissions.canModifyAnnotations(), currentAccessPermission.canModifyAnnotations());        assertEquals(expectedPermissions.canPrint(), currentAccessPermission.canPrint());        assertEquals(expectedPermissions.canPrintDegraded(), currentAccessPermission.canPrintDegraded());        new PDFRenderer(doc).renderImage(0);    }}
public void pdfbox_f7981_0() throws Exception
{    byte[] inputFileAsByteArray = getFileResourceAsByteArray("Acroform-PDFBOX-2333.pdf");    int sizePriorToEncryption = inputFileAsByteArray.length;    testSymmEncrForKeySize(40, false, sizePriorToEncryption, inputFileAsByteArray, USERPASSWORD, OWNERPASSWORD, permission);    testSymmEncrForKeySize(128, false, sizePriorToEncryption, inputFileAsByteArray, USERPASSWORD, OWNERPASSWORD, permission);    testSymmEncrForKeySize(128, true, sizePriorToEncryption, inputFileAsByteArray, USERPASSWORD, OWNERPASSWORD, permission);    testSymmEncrForKeySize(256, true, sizePriorToEncryption, inputFileAsByteArray, USERPASSWORD, OWNERPASSWORD, permission);}
public void pdfbox_f7982_0() throws IOException
{    byte[] inputFileAsByteArray;    try (InputStream is = new FileInputStream("target/pdfs/PDFBOX-4308.pdf")) {        inputFileAsByteArray = IOUtils.toByteArray(is);    }    int sizePriorToEncryption = inputFileAsByteArray.length;    testSymmEncrForKeySize(40, false, sizePriorToEncryption, inputFileAsByteArray, USERPASSWORD, OWNERPASSWORD, permission);}
public void pdfbox_f7983_0() throws Exception
{    String testFileName = "preEnc_20141025_105451.pdf";    byte[] inputFileWithEmbeddedFileAsByteArray = getFileResourceAsByteArray(testFileName);    int sizeOfFileWithEmbeddedFile = inputFileWithEmbeddedFileAsByteArray.length;    File extractedEmbeddedFile = extractEmbeddedFile(new ByteArrayInputStream(inputFileWithEmbeddedFileAsByteArray), "innerFile.pdf");    testSymmEncrForKeySizeInner(40, false, sizeOfFileWithEmbeddedFile, inputFileWithEmbeddedFileAsByteArray, extractedEmbeddedFile, USERPASSWORD, OWNERPASSWORD);    testSymmEncrForKeySizeInner(128, false, sizeOfFileWithEmbeddedFile, inputFileWithEmbeddedFileAsByteArray, extractedEmbeddedFile, USERPASSWORD, OWNERPASSWORD);    testSymmEncrForKeySizeInner(128, true, sizeOfFileWithEmbeddedFile, inputFileWithEmbeddedFileAsByteArray, extractedEmbeddedFile, USERPASSWORD, OWNERPASSWORD);    testSymmEncrForKeySizeInner(256, true, sizeOfFileWithEmbeddedFile, inputFileWithEmbeddedFileAsByteArray, extractedEmbeddedFile, USERPASSWORD, OWNERPASSWORD);}
public void pdfbox_f7984_0() throws IOException
{    final int TESTCOUNT = 1000;    File file = new File(testResultsDir, "PDFBOX-4453.pdf");    try (PDDocument doc = new PDDocument()) {        doc.addPage(new PDPage());        for (int i = 0; i < TESTCOUNT; ++i) {                                    COSDictionary dict = new COSDictionary();            doc.getPage(0).getCOSObject().setItem(COSName.getPDFName("_Test-" + i), dict);                                    dict.setString("key1", "3");            dict.setString("key2", "0");        }                StandardProtectionPolicy spp = new StandardProtectionPolicy("12345", "", new AccessPermission());        spp.setEncryptionKeyLength(40);        spp.setPreferAES(false);        doc.protect(spp);        doc.save(file);    }    try (PDDocument doc = PDDocument.load(file)) {        Assert.assertTrue(doc.isEncrypted());        for (int i = 0; i < TESTCOUNT; ++i) {            COSDictionary dict = doc.getPage(0).getCOSObject().getCOSDictionary(COSName.getPDFName("_Test-" + i));            Assert.assertEquals("3", dict.getString("key1"));            Assert.assertEquals("0", dict.getString("key2"));        }    }}
private void pdfbox_f7985_0(int keyLength, boolean preferAES, int sizePriorToEncr, byte[] inputFileAsByteArray, String userpassword, String ownerpassword, AccessPermission permission) throws IOException
{    PDDocument document = PDDocument.load(inputFileAsByteArray);    String prefix = "Simple-";    int numSrcPages = document.getNumberOfPages();    PDFRenderer pdfRenderer = new PDFRenderer(document);    List<BufferedImage> srcImgTab = new ArrayList<>();    List<byte[]> srcContentStreamTab = new ArrayList<>();    for (int i = 0; i < numSrcPages; ++i) {        srcImgTab.add(pdfRenderer.renderImage(i));        try (InputStream unfilteredStream = document.getPage(i).getContents()) {            srcContentStreamTab.add(IOUtils.toByteArray(unfilteredStream));        }    }    try (PDDocument encryptedDoc = encrypt(keyLength, preferAES, sizePriorToEncr, document, prefix, permission, userpassword, ownerpassword)) {        Assert.assertEquals(numSrcPages, encryptedDoc.getNumberOfPages());        pdfRenderer = new PDFRenderer(encryptedDoc);        for (int i = 0; i < encryptedDoc.getNumberOfPages(); ++i) {                        BufferedImage bim = pdfRenderer.renderImage(i);            ValidateXImage.checkIdent(bim, srcImgTab.get(i));                        try (InputStream unfilteredStream = encryptedDoc.getPage(i).getContents()) {                byte[] bytes = IOUtils.toByteArray(unfilteredStream);                Assert.assertArrayEquals("content stream of page " + i + " not identical", srcContentStreamTab.get(i), bytes);            }        }        File pdfFile = new File(testResultsDir, prefix + keyLength + "-bit-" + (preferAES ? "AES" : "RC4") + "-decrypted.pdf");        encryptedDoc.setAllSecurityToBeRemoved(true);        encryptedDoc.save(pdfFile);    }}
private PDDocument pdfbox_f7986_0(int keyLength, boolean preferAES, int sizePriorToEncr, PDDocument doc, String prefix, AccessPermission permission, String userpassword, String ownerpassword) throws IOException
{    StandardProtectionPolicy spp = new StandardProtectionPolicy(ownerpassword, userpassword, permission);    spp.setEncryptionKeyLength(keyLength);    spp.setPreferAES(preferAES);        doc.setAllSecurityToBeRemoved(true);    doc.protect(spp);    File pdfFile = new File(testResultsDir, prefix + keyLength + "-bit-" + (preferAES ? "AES" : "RC4") + "-encrypted.pdf");    doc.save(pdfFile);    doc.close();    long sizeEncrypted = pdfFile.length();    Assert.assertTrue(keyLength + "-bit " + (preferAES ? "AES" : "RC4") + " encrypted pdf should not have same size as plain one", sizeEncrypted != sizePriorToEncr);        PDDocument encryptedDoc = PDDocument.load(pdfFile, ownerpassword);    Assert.assertTrue(encryptedDoc.isEncrypted());    Assert.assertTrue(encryptedDoc.getCurrentAccessPermission().isOwnerPermission());        PDEncryption encryption = encryptedDoc.getEncryption();    int revision = encryption.getRevision();    if (revision < 5) {        StandardSecurityHandler standardSecurityHandler = new StandardSecurityHandler();        int keyLengthInBytes = encryption.getVersion() == 1 ? 5 : encryption.getLength() / 8;        byte[] computedUserPassword = standardSecurityHandler.getUserPassword(ownerpassword.getBytes(Charsets.ISO_8859_1), encryption.getOwnerKey(), revision, keyLengthInBytes);        Assert.assertEquals(userpassword.substring(0, 32), new String(computedUserPassword, Charsets.ISO_8859_1));    }    encryptedDoc.close();        encryptedDoc = PDDocument.load(pdfFile, userpassword);    Assert.assertTrue(encryptedDoc.isEncrypted());    Assert.assertFalse(encryptedDoc.getCurrentAccessPermission().isOwnerPermission());    assertEquals(permission.getPermissionBytes(), encryptedDoc.getCurrentAccessPermission().getPermissionBytes());    return encryptedDoc;}
private File pdfbox_f7987_1(InputStream pdfInputStream, String name) throws IOException
{    PDDocument docWithEmbeddedFile;    docWithEmbeddedFile = PDDocument.load(pdfInputStream);    PDDocumentCatalog catalog = docWithEmbeddedFile.getDocumentCatalog();    PDDocumentNameDictionary names = catalog.getNames();    PDEmbeddedFilesNameTreeNode embeddedFiles = names.getEmbeddedFiles();    Map<String, PDComplexFileSpecification> embeddedFileNames = embeddedFiles.getNames();    Assert.assertEquals(1, embeddedFileNames.size());    Map.Entry<String, PDComplexFileSpecification> entry = embeddedFileNames.entrySet().iterator().next();        PDComplexFileSpecification complexFileSpec = entry.getValue();    PDEmbeddedFile embeddedFile = complexFileSpec.getEmbeddedFile();    File resultFile = new File(testResultsDir, name);    try (FileOutputStream fos = new FileOutputStream(resultFile);        InputStream is = embeddedFile.createInputStream()) {        IOUtils.copy(is, fos);    }        assertEquals(embeddedFile.getSize(), resultFile.length());    return resultFile;}
private void pdfbox_f7988_0(int keyLength, boolean preferAES, int sizePriorToEncr, byte[] inputFileWithEmbeddedFileAsByteArray, File embeddedFilePriorToEncryption, String userpassword, String ownerpassword) throws IOException
{    PDDocument document = PDDocument.load(inputFileWithEmbeddedFileAsByteArray);    try (PDDocument encryptedDoc = encrypt(keyLength, preferAES, sizePriorToEncr, document, "ContainsEmbedded-", permission, userpassword, ownerpassword)) {        File decryptedFile = new File(testResultsDir, "DecryptedContainsEmbedded-" + keyLength + "-bit-" + (preferAES ? "AES" : "RC4") + ".pdf");        encryptedDoc.setAllSecurityToBeRemoved(true);        encryptedDoc.save(decryptedFile);        File extractedEmbeddedFile = extractEmbeddedFile(new FileInputStream(decryptedFile), "decryptedInnerFile-" + keyLength + "-bit-" + (preferAES ? "AES" : "RC4") + ".pdf");        Assert.assertEquals(keyLength + "-bit " + (preferAES ? "AES" : "RC4") + " decrypted inner attachment pdf should have same size as plain one", embeddedFilePriorToEncryption.length(), extractedEmbeddedFile.length());                Assert.assertArrayEquals(getFileAsByteArray(embeddedFilePriorToEncryption), getFileAsByteArray(extractedEmbeddedFile));    }}
private byte[] pdfbox_f7989_0(String testFileName) throws IOException
{    return IOUtils.toByteArray(TestSymmetricKeyEncryption.class.getResourceAsStream(testFileName));}
private byte[] pdfbox_f7990_0(File f) throws IOException
{    return Files.readAllBytes(f.toPath());}
public void pdfbox_f7991_0()
{    Assert.assertEquals(Integer.parseInt("11111111", 2), getBitSeq(Integer.parseInt("11111111", 2), 0, 8));    Assert.assertEquals(Integer.parseInt("00000000", 2), getBitSeq(Integer.parseInt("00000000", 2), 0, 8));    Assert.assertEquals(Integer.parseInt("1", 2), getBitSeq(Integer.parseInt("11111111", 2), 0, 1));    Assert.assertEquals(Integer.parseInt("0", 2), getBitSeq(Integer.parseInt("00000000", 2), 0, 1));    Assert.assertEquals(Integer.parseInt("001", 2), getBitSeq(Integer.parseInt("00110001", 2), 0, 3));    Assert.assertEquals(Integer.parseInt("10101010", 2), getBitSeq(Integer.parseInt("10101010", 2), 0, 8));    Assert.assertEquals(Integer.parseInt("10", 2), getBitSeq(Integer.parseInt("10101010", 2), 0, 2));    Assert.assertEquals(Integer.parseInt("01", 2), getBitSeq(Integer.parseInt("10101010", 2), 1, 2));    Assert.assertEquals(Integer.parseInt("10", 2), getBitSeq(Integer.parseInt("10101010", 2), 2, 2));    Assert.assertEquals(Integer.parseInt("101", 2), getBitSeq(Integer.parseInt("10101010", 2), 3, 3));    Assert.assertEquals(Integer.parseInt("1010101", 2), getBitSeq(Integer.parseInt("10101010", 2), 1, 7));    Assert.assertEquals(Integer.parseInt("01", 2), getBitSeq(Integer.parseInt("10101010", 2), 3, 2));    Assert.assertEquals(Integer.parseInt("00110001", 2), getBitSeq(Integer.parseInt("00110001", 2), 0, 8));    Assert.assertEquals(Integer.parseInt("10001", 2), getBitSeq(Integer.parseInt("00110001", 2), 0, 5));    Assert.assertEquals(Integer.parseInt("0011", 2), getBitSeq(Integer.parseInt("00110001", 2), 4, 4));    Assert.assertEquals(Integer.parseInt("110", 2), getBitSeq(Integer.parseInt("00110001", 2), 3, 3));    Assert.assertEquals(Integer.parseInt("00", 2), getBitSeq(Integer.parseInt("00110001", 2), 6, 2));    Assert.assertEquals(Integer.parseInt("1111", 2), getBitSeq(Integer.parseInt("11110000", 2), 4, 4));    Assert.assertEquals(Integer.parseInt("11", 2), getBitSeq(Integer.parseInt("11110000", 2), 6, 2));    Assert.assertEquals(Integer.parseInt("0000", 2), getBitSeq(Integer.parseInt("11110000", 2), 0, 4));}
public void pdfbox_f7992_0()
{    Assert.assertEquals(Integer.parseInt("00000000", 2), calcSetBitSeq(Integer.parseInt("11111111", 2), 0, 8, 0));    Assert.assertEquals(Integer.parseInt("00000001", 2), calcSetBitSeq(Integer.parseInt("11111111", 2), 0, 8, 1));    Assert.assertEquals(Integer.parseInt("11111111", 2), calcSetBitSeq(Integer.parseInt("11111111", 2), 0, 1, 1));    Assert.assertEquals(Integer.parseInt("11111101", 2), calcSetBitSeq(Integer.parseInt("11111111", 2), 0, 2, 1));    Assert.assertEquals(Integer.parseInt("11111001", 2), calcSetBitSeq(Integer.parseInt("11111111", 2), 0, 3, 1));    Assert.assertEquals(Integer.parseInt("00000001", 2), calcSetBitSeq(Integer.parseInt("00000000", 2), 0, 2, 1));    Assert.assertEquals(Integer.parseInt("11110001", 2), calcSetBitSeq(Integer.parseInt("11111111", 2), 0, 4, 1));    Assert.assertEquals(Integer.parseInt("11100011", 2), calcSetBitSeq(Integer.parseInt("11111111", 2), 1, 4, 1));    Assert.assertEquals(Integer.parseInt("00000010", 2), calcSetBitSeq(Integer.parseInt("00000000", 2), 1, 1, 1));    Assert.assertEquals(Integer.parseInt("11111111", 2), calcSetBitSeq(Integer.parseInt("11111111", 2), 7, 1, 1));    Assert.assertEquals(Integer.parseInt("01111111", 2), calcSetBitSeq(Integer.parseInt("11111111", 2), 7, 1, 0));    Assert.assertEquals(Integer.parseInt("10000000", 2), calcSetBitSeq(Integer.parseInt("00000000", 2), 7, 1, 1));    Assert.assertEquals(Integer.parseInt("00000000", 2), calcSetBitSeq(Integer.parseInt("00000000", 2), 7, 1, 0));    Assert.assertEquals(Integer.parseInt("01000000", 2), calcSetBitSeq(Integer.parseInt("00000000", 2), 6, 1, 1));    Assert.assertEquals(Integer.parseInt("00000000", 2), calcSetBitSeq(Integer.parseInt("00000000", 2), 6, 1, 0));    Assert.assertEquals(Integer.parseInt("00110000", 2), calcSetBitSeq(Integer.parseInt("00000000", 2), 3, 3, 6));    Assert.assertEquals(Integer.parseInt("01100000", 2), calcSetBitSeq(Integer.parseInt("00000000", 2), 4, 3, 6));    Assert.assertEquals(Integer.parseInt("11000000", 2), calcSetBitSeq(Integer.parseInt("00000000", 2), 5, 3, 6));    Assert.assertEquals(Integer.parseInt("11111111", 2), calcSetBitSeq(Integer.parseInt("00000000", 2), 0, 8, 0xFF));    Assert.assertEquals(Integer.parseInt("11111111", 2), calcSetBitSeq(Integer.parseInt("11111111", 2), 0, 8, 0xFF));    Assert.assertEquals(0x7E, calcSetBitSeq(0xA5, 0, 8, 0xD9 + 0xA5));        Assert.assertEquals(Integer.parseInt("00000010", 2), calcSetBitSeq(Integer.parseInt("00000000", 2), 1, 1, 3));}
public void pdfbox_f7993_0() throws IOException
{    final int COUNT = 10;    Random rd = new Random(123456);    for (int iter = 0; iter < COUNT * 2; iter++) {        long seed;        if (iter < COUNT) {                        seed = rd.nextLong();        } else {                        seed = new Random().nextLong();        }        boolean success = false;        try {            final Random random = new Random(seed);            final int numBytes = 10000 + random.nextInt(20000);            byte[] original = new byte[numBytes];            int upto = 0;            while (upto < numBytes) {                final int left = numBytes - upto;                if (random.nextBoolean() || left < 2) {                                        final int end = upto + Math.min(left, 10 + random.nextInt(100));                    while (upto < end) {                        original[upto++] = (byte) random.nextInt();                    }                } else {                                        final int end = upto + Math.min(left, 2 + random.nextInt(10));                    final byte value = (byte) random.nextInt(4);                    while (upto < end) {                        original[upto++] = value;                    }                }            }            for (Filter filter : FilterFactory.INSTANCE.getAllFilters()) {                                if (filter instanceof DCTFilter || filter instanceof CCITTFaxFilter || filter instanceof JPXFilter || filter instanceof JBIG2Filter || filter instanceof RunLengthDecodeFilter) {                    continue;                }                checkEncodeDecode(filter, original);            }            success = true;        } finally {            if (!success) {                System.err.println("NOTE: test failed with seed=" + seed);            }        }    }}
public void pdfbox_f7994_0() throws IOException
{    PDDocument.load(new File("target/pdfs/PDFBOX-4517-cryptfilter.pdf"), "userpassword1234");}
public void pdfbox_f7995_0() throws IOException
{    Filter lzwFilter = FilterFactory.INSTANCE.getFilter(COSName.LZW_DECODE);    byte[] byteArray = IOUtils.toByteArray(this.getClass().getResourceAsStream("PDFBOX-1777.bin"));    checkEncodeDecode(lzwFilter, byteArray);}
private void pdfbox_f7996_0(Filter filter, byte[] original) throws IOException
{    ByteArrayOutputStream encoded = new ByteArrayOutputStream();    filter.encode(new ByteArrayInputStream(original), encoded, new COSDictionary());    ByteArrayOutputStream decoded = new ByteArrayOutputStream();    filter.decode(new ByteArrayInputStream(encoded.toByteArray()), decoded, new COSDictionary(), 0);    assertTrue("Data that is encoded and then decoded through " + filter.getClass() + " does not match the original data", Arrays.equals(original, decoded.toByteArray()));}
public void pdfbox_f7997_0() throws IOException
{    byte[] data = "Hello World!".getBytes();    byte[] buffer = new byte[data.length];    long count = IOUtils.populateBuffer(new ByteArrayInputStream(data), buffer);    assertEquals(12, count);        buffer = new byte[data.length - 2];    InputStream in = new ByteArrayInputStream(data);    count = IOUtils.populateBuffer(in, buffer);    assertEquals(10, count);    byte[] leftOver = IOUtils.toByteArray(in);    assertEquals(2, leftOver.length);        buffer = new byte[data.length + 2];    in = new ByteArrayInputStream(data);    count = IOUtils.populateBuffer(in, buffer);    assertEquals(12, count);        assertEquals(-1, in.read());}
public void pdfbox_f7998_0() throws IOException
{    RandomAccessBuffer buffer = new RandomAccessBuffer();    byte[] byteArray = new byte[CHUNK_SIZE + 2];        for (int i = 0; i < 2; i++) {        byteArray[CHUNK_SIZE + i] = 1;    }    buffer.write(byteArray);    buffer.seek(CHUNK_SIZE - 2);        buffer.read(byteArray, 0, 2);        buffer.read(byteArray, 0, 2);        assertEquals(2, byteArray[0] + byteArray[1]);    buffer.close();    buffer = new RandomAccessBuffer();    byteArray = new byte[2 * CHUNK_SIZE + 2];        for (int i = 0; i < CHUNK_SIZE; i++) {        byteArray[CHUNK_SIZE + i] = 1;    }        for (int i = 0; i < 2; i++) {        byteArray[2 * CHUNK_SIZE + i] = 2;    }    buffer.write(byteArray);    buffer.seek(700);    byte[] bytesRead = new byte[1348];    buffer.read(bytesRead, 0, bytesRead.length);    assertEquals(2, buffer.read());    buffer.close();}
public void pdfbox_f7999_0() throws IOException
{        RandomAccessBuffer buffer = new RandomAccessBuffer();    for (int i = 0; i < 10; i++) {        buffer.write(i);    }        buffer.seek(0);        int result = 0;    for (int i = 0; i < 10; i++) {        result += buffer.read();    }    assertEquals(45, result);    buffer.close();}
public void pdfbox_f8000_0() throws IOException
{        byte[] byteArray = new byte[10];    for (byte i = 0; i < 10; i++) {        byteArray[i] = i;    }        RandomAccessBuffer buffer = new RandomAccessBuffer();    buffer.write(byteArray);        buffer.seek(0);            int result = 0;    for (int i = 0; i < 10; i++) {        result += buffer.read();    }    assertEquals(45, result);        buffer.seek(0);            buffer.read(byteArray, 0, byteArray.length);    result = 0;    for (int i = 0; i < 10; i++) {        result += byteArray[i];    }    assertEquals(45, result);    buffer.close();}
public void pdfbox_f8001_0() throws IOException
{        byte[] byteArray = new byte[2 * CHUNK_SIZE + 100];    for (int i = CHUNK_SIZE; i < 2 * CHUNK_SIZE; i++) {        byteArray[i] = 1;    }    for (int i = 2 * CHUNK_SIZE; i < 2 * CHUNK_SIZE + 100; i++) {        byteArray[i] = 2;    }        RandomAccessBuffer buffer = new RandomAccessBuffer();    buffer.write(byteArray);        buffer.seek(0);        assertEquals(0, buffer.read());        buffer.seek(CHUNK_SIZE - 1);    assertEquals(0, buffer.read());        buffer.seek(CHUNK_SIZE);    assertEquals(1, buffer.read());        buffer.seek(CHUNK_SIZE - 5);            byteArray = new byte[10];    buffer.read(byteArray, 0, byteArray.length);    int result = 0;    for (int i = 0; i < 10; i++) {        result += byteArray[i];    }    assertEquals(5, result);        buffer.seek(2 * CHUNK_SIZE - 5);            byteArray = new byte[10];    buffer.read(byteArray);    result = 0;    for (int i = 0; i < 10; i++) {        result += byteArray[i];    }    assertEquals(15, result);    buffer.close();}
public void pdfbox_f8002_0() throws IOException
{        byte[] byteArray = new byte[CHUNK_SIZE + 100];    RandomAccessBuffer buffer = new RandomAccessBuffer();    for (int i = CHUNK_SIZE; i < CHUNK_SIZE + 100; i++) {        byteArray[i] = 1;    }    buffer.write(byteArray);        buffer.seek(CHUNK_SIZE - 5);            byteArray = new byte[10];    buffer.read(byteArray, 0, byteArray.length);    int result = 0;    for (int i = 0; i < 10; i++) {        result += byteArray[i];    }    assertEquals(5, result);        buffer.seek(CHUNK_SIZE - 5);        for (int i = 0; i < 5; i++) {        buffer.write(2);    }    for (int i = 0; i < 5; i++) {        buffer.write(3);    }        buffer.seek(CHUNK_SIZE - 5);            byteArray = new byte[10];    buffer.read(byteArray, 0, byteArray.length);    result = 0;    for (int i = 0; i < 10; i++) {        result += byteArray[i];    }    assertEquals(25, result);    buffer.close();}
public void pdfbox_f8003_0() throws IOException
{        RandomAccessBuffer buffer = new RandomAccessBuffer();    for (int i = 0; i < 10; i++) {        buffer.write(i);    }        buffer.seek(0);        buffer.seek(20);        assertEquals(-1, buffer.read());        assertTrue(buffer.isEOF());    buffer.close();}
public void pdfbox_f8004_0() throws Exception
{        byte[] byteArray = new byte[CHUNK_SIZE - 1];    RandomAccessBuffer buffer = new RandomAccessBuffer();    buffer.write(byteArray);        buffer.write(0);        buffer.seek(buffer.getPosition());    buffer.close();}
public void pdfbox_f8005_0() throws Exception
{                int chunkSize = (CHUNK_SIZE << 4) + 3;    byte[] byteArray = new byte[chunkSize];    RandomAccessBuffer buffer = new RandomAccessBuffer(byteArray);        for (int i = 0; i < chunkSize; i++) {        buffer.write(1);    }        RandomAccessBuffer bufferClone = buffer.clone();        buffer.seek(0);    int bufRead = buffer.read(new byte[(int) buffer.length()]);    bufferClone.seek(0);    int bufCloneRead = bufferClone.read(new byte[(int) bufferClone.length()]);    assertEquals(bufRead, bufCloneRead);    buffer.close();    bufferClone.close();}
protected void pdfbox_f8006_0() throws Exception
{    super.setUp();    testResultsDir.mkdirs();}
public void pdfbox_f8007_0() throws IOException
{    RandomAccessOutputStream out;    byte[] buffer;    File file = new File(testResultsDir, "raf-outputstream.bin");    file.delete();    RandomAccessFile raFile = new RandomAccessFile(file, "rw");        buffer = createDataSequence(16, 10);    out = new RandomAccessOutputStream(raFile);    for (byte b : buffer) {        out.write(b);    }    assertEquals(16, raFile.length());    assertEquals(16, raFile.getPosition());    out.close();        out = new RandomAccessOutputStream(raFile);    assertEquals(16, raFile.length());    assertEquals(16, raFile.getPosition());    out.close();        buffer = createDataSequence(8, 30);    out = new RandomAccessOutputStream(raFile);    out.write(buffer);    assertEquals(24, raFile.length());    assertEquals(24, raFile.getPosition());    out.close();        buffer = createDataSequence(16, 50);    out = new RandomAccessOutputStream(raFile);    out.write(buffer, 8, 4);    out.write(buffer, 4, 2);    assertEquals(30, raFile.length());    assertEquals(30, raFile.getPosition());    out.close();        buffer = new byte[(int) raFile.length()];    raFile.seek(0);    assertEquals(buffer.length, raFile.read(buffer, 0, buffer.length));    assertEquals(10, buffer[0]);    assertEquals(11, buffer[1]);    assertEquals(25, buffer[15]);    assertEquals(30, buffer[16]);    assertEquals(31, buffer[17]);    assertEquals(37, buffer[23]);    assertEquals(58, buffer[24]);    assertEquals(59, buffer[25]);    assertEquals(60, buffer[26]);    assertEquals(61, buffer[27]);    assertEquals(54, buffer[28]);    assertEquals(55, buffer[29]);        raFile.close();    file.delete();}
protected byte[] pdfbox_f8008_0(int length, int firstByteValue)
{    byte[] buffer = new byte[length];    for (int i = 0; i < buffer.length; i++) {        buffer[i] = (byte) (firstByteValue + i);    }    return buffer;}
public void pdfbox_f8009_0() throws IOException
{    try (PDDocument doc = new PDDocument()) {        PDType0Font font = PDType0Font.load(doc, GsubWorkerForBengaliTest.class.getResourceAsStream(LOHIT_BENGALI_TTF), true);        cmapLookup = font.getCmapLookup();        gsubWorkerForBengali = new GsubWorkerFactory().getGsubWorker(cmapLookup, font.getGsubData());    }}
public void pdfbox_f8010_0()
{        List<Integer> glyphsAfterGsub = Arrays.asList(56, 102, 91);        List<Integer> result = gsubWorkerForBengali.applyTransforms(getGlyphIds("আমি"));        assertEquals(glyphsAfterGsub, result);}
public void pdfbox_f8011_0()
{        List<Integer> glyphsAfterGsub = Arrays.asList(89, 156, 101, 97);        List<Integer> result = gsubWorkerForBengali.applyTransforms(getGlyphIds("ব্যাস"));        assertEquals(glyphsAfterGsub, result);}
public void pdfbox_f8012_0()
{        List<Integer> glyphsAfterGsub = Arrays.asList(438, 89, 94, 101);        List<Integer> result = gsubWorkerForBengali.applyTransforms(getGlyphIds("বেলা"));        assertEquals(glyphsAfterGsub, result);}
public void pdfbox_f8013_0()
{        List<Integer> glyphsAfterGsub = Arrays.asList(108, 89, 101, 97);        List<Integer> result = gsubWorkerForBengali.applyTransforms(getGlyphIds("বোস"));        assertEquals(glyphsAfterGsub, result);}
public void pdfbox_f8014_0()
{        List<Integer> glyphsAfterGsub = Arrays.asList(108, 96, 101, 108, 94, 101);        List<Integer> result = gsubWorkerForBengali.applyTransforms(getGlyphIds("ষোলো"));        assertEquals(glyphsAfterGsub, result);}
public void pdfbox_f8015_0()
{        List<Integer> glyphsAfterGsub = Arrays.asList(108, 73, 101, 108, 77, 101);        List<Integer> result = gsubWorkerForBengali.applyTransforms(getGlyphIds("ছোটো"));        assertEquals(glyphsAfterGsub, result);}
public void pdfbox_f8016_0()
{        List<Integer> glyphsAfterGsub = Arrays.asList(108, 91, 114, 94);        List<Integer> result = gsubWorkerForBengali.applyTransforms(getGlyphIds("মৌল"));        assertEquals(glyphsAfterGsub, result);}
public void pdfbox_f8017_0()
{        List<Integer> glyphsAfterGsub = Arrays.asList(439, 89, 93);        List<Integer> result = gsubWorkerForBengali.applyTransforms(getGlyphIds("বৈর"));        assertEquals(glyphsAfterGsub, result);}
public void pdfbox_f8018_0()
{        List<Integer> glyphsAfterGsub = Arrays.asList(167, 103, 438, 93, 93);        List<Integer> result = gsubWorkerForBengali.applyTransforms(getGlyphIds("ক্ষীরের"));        assertEquals(glyphsAfterGsub, result);}
public void pdfbox_f8019_0()
{        List<Integer> glyphsAfterGsub = Arrays.asList(274, 82);        List<Integer> result = gsubWorkerForBengali.applyTransforms(getGlyphIds("দ্রুত"));        assertEquals(glyphsAfterGsub, result);}
public void pdfbox_f8020_0()
{        List<Integer> glyphsAfterGsub = Arrays.asList(85, 104, 440, 82);        List<Integer> result = gsubWorkerForBengali.applyTransforms(getGlyphIds("ধুর্ত"));        assertEquals(glyphsAfterGsub, result);}
public void pdfbox_f8021_0()
{        List<Integer> glyphsAfterGsub = Arrays.asList(352, 108, 87, 101);        List<Integer> result = gsubWorkerForBengali.applyTransforms(getGlyphIds("রুপো"));        assertEquals(glyphsAfterGsub, result);}
public void pdfbox_f8022_0()
{        List<Integer> glyphsAfterGsub = Arrays.asList(67, 108, 369, 101, 94);        List<Integer> result = gsubWorkerForBengali.applyTransforms(getGlyphIds("কল্লোল"));        assertEquals(glyphsAfterGsub, result);}
public void pdfbox_f8023_0()
{        List<Integer> glyphsAfterGsub = Arrays.asList(98, 78, 101, 113);        List<Integer> result = gsubWorkerForBengali.applyTransforms(getGlyphIds("হঠাৎ"));        assertEquals(glyphsAfterGsub, result);}
private List<Integer> pdfbox_f8024_0(String word)
{    List<Integer> originalGlyphIds = new ArrayList<>();    for (char unicodeChar : word.toCharArray()) {        int glyphId = cmapLookup.getGlyphId(unicodeChar);        assertTrue(glyphId > 0);        originalGlyphIds.add(glyphId);    }    return originalGlyphIds;}
public void pdfbox_f8025_0()
{    OUT_DIR.mkdirs();}
public void pdfbox_f8026_0() throws IOException
{    PDFMergerUtility merger = new PDFMergerUtility();    File toBeMerged = new File(IN_DIR, "AcroFormForMerge.pdf");    File pdfOutput = new File(OUT_DIR, "PDFBoxLegacyMerge-SameMerged.pdf");    merger.setDestinationFileName(pdfOutput.getAbsolutePath());    merger.addSource(toBeMerged);    merger.addSource(toBeMerged);    merger.mergeDocuments(null);    merger.setAcroFormMergeMode(AcroFormMergeMode.PDFBOX_LEGACY_MODE);    try (PDDocument compliantDocument = PDDocument.load(new File(IN_DIR, "PDFBoxLegacyMerge-SameMerged.pdf"));        PDDocument toBeCompared = PDDocument.load(new File(OUT_DIR, "PDFBoxLegacyMerge-SameMerged.pdf"))) {        PDAcroForm compliantAcroForm = compliantDocument.getDocumentCatalog().getAcroForm();        PDAcroForm toBeComparedAcroForm = toBeCompared.getDocumentCatalog().getAcroForm();        assertEquals("There shall be the same number of root fields", compliantAcroForm.getFields().size(), toBeComparedAcroForm.getFields().size());        for (PDField compliantField : compliantAcroForm.getFieldTree()) {            assertNotNull("There shall be a field with the same FQN", toBeComparedAcroForm.getField(compliantField.getFullyQualifiedName()));            PDField toBeComparedField = toBeComparedAcroForm.getField(compliantField.getFullyQualifiedName());            compareFieldProperties(compliantField, toBeComparedField);        }        for (PDField toBeComparedField : toBeComparedAcroForm.getFieldTree()) {            assertNotNull("There shall be a field with the same FQN", compliantAcroForm.getField(toBeComparedField.getFullyQualifiedName()));            PDField compliantField = compliantAcroForm.getField(toBeComparedField.getFullyQualifiedName());            compareFieldProperties(toBeComparedField, compliantField);        }    }}
private void pdfbox_f8027_0(PDField sourceField, PDField toBeComapredField)
{                final String[] keys = { "FT", "T", "TU", "TM", "Ff", "V", "DV", "Opts", "TI", "I", "Rect", "DA" };    COSDictionary sourceFieldCos = sourceField.getCOSObject();    COSDictionary toBeComparedCos = toBeComapredField.getCOSObject();    for (String key : keys) {        COSBase sourceBase = sourceFieldCos.getDictionaryObject(key);        COSBase toBeComparedBase = toBeComparedCos.getDictionaryObject(key);        if (sourceBase != null) {            assertEquals("The content of the field properties shall be the same", sourceBase.toString(), toBeComparedBase.toString());        } else {            assertNull("If the source property is null the compared property shall be null too", toBeComparedBase);        }    }}
public void pdfbox_f8028_0() throws IOException
{        PDFMergerUtility merger = new PDFMergerUtility();    File f1 = new File(TARGET_PDF_DIR, "PDFBOX-1031-1.pdf");    File f2 = new File(TARGET_PDF_DIR, "PDFBOX-1031-2.pdf");    File pdfOutput = new File(OUT_DIR, "PDFBOX-1031.pdf");    try (InputStream is1 = new FileInputStream(f1);        InputStream is2 = new FileInputStream(f2)) {        merger.setDestinationFileName(pdfOutput.getAbsolutePath());        merger.addSource(is1);        merger.addSource(is2);        merger.mergeDocuments(null);    }        try (PDDocument mergedPDF = PDDocument.load(pdfOutput)) {        assertEquals("There shall be 2 pages", 2, mergedPDF.getNumberOfPages());        assertNotNull("There shall be an /Annots entry for the first page", mergedPDF.getPage(0).getCOSObject().getDictionaryObject(COSName.ANNOTS));        assertEquals("There shall be 1 annotation for the first page", 1, mergedPDF.getPage(0).getAnnotations().size());        assertNotNull("There shall be an /Annots entry for the second page", mergedPDF.getPage(1).getCOSObject().getDictionaryObject(COSName.ANNOTS));        assertEquals("There shall be 1 annotation for the second page", 1, mergedPDF.getPage(0).getAnnotations().size());    }}
public void pdfbox_f8029_0() throws IOException
{    File file1 = new File(TARGET_PDF_DIR, "PDFBOX-1100-1.pdf");    File file2 = new File(TARGET_PDF_DIR, "PDFBOX-1100-2.pdf");        PDFMergerUtility merger = new PDFMergerUtility();    File pdfOutput = new File(OUT_DIR, "PDFBOX-1100.pdf");    try (InputStream is1 = new FileInputStream(file1);        InputStream is2 = new FileInputStream(file2)) {        merger.setDestinationFileName(pdfOutput.getAbsolutePath());        merger.addSource(is1);        merger.addSource(is2);        merger.mergeDocuments(null);    }        try (PDDocument mergedPDF = PDDocument.load(pdfOutput)) {        assertEquals("There shall be 2 pages", 2, mergedPDF.getNumberOfPages());        PDAcroForm acroForm = mergedPDF.getDocumentCatalog().getAcroForm();        PDField formField = acroForm.getField("Testfeld");        assertNotNull("There shall be an /AP entry for the field", formField.getCOSObject().getDictionaryObject(COSName.AP));        assertNotNull("There shall be a /V entry for the field", formField.getCOSObject().getDictionaryObject(COSName.V));        formField = acroForm.getField("Testfeld2");        assertNotNull("There shall be an /AP entry for the field", formField.getCOSObject().getDictionaryObject(COSName.AP));        assertNotNull("There shall be a /V entry for the field", formField.getCOSObject().getDictionaryObject(COSName.V));    }}
public void pdfbox_f8030_0()
{    OUT_DIR.mkdirs();}
public void pdfbox_f8031_0() throws IOException
{        PDFMergerUtility merger = new PDFMergerUtility();    File file1 = new File(TARGET_PDF_DIR, "PDFBOX-1065-1.pdf");    File file2 = new File(TARGET_PDF_DIR, "PDFBOX-1065-2.pdf");    try (InputStream is1 = new FileInputStream(file1);        InputStream is2 = new FileInputStream(file2)) {        File pdfOutput = new File(OUT_DIR, "PDFBOX-1065.pdf");        merger.setDestinationFileName(pdfOutput.getAbsolutePath());        merger.addSource(is1);        merger.addSource(is2);        merger.mergeDocuments(null);                PDDocument mergedPDF = PDDocument.load(pdfOutput);        assertEquals("There shall be 6 pages", 6, mergedPDF.getNumberOfPages());        PDDocumentNameDestinationDictionary destinations = mergedPDF.getDocumentCatalog().getDests();                        assertEquals("There shall be 12 entries", 12, destinations.getCOSObject().entrySet().size());        List<PDAnnotation> sourceAnnotations01 = mergedPDF.getPage(0).getAnnotations();        List<PDAnnotation> sourceAnnotations02 = mergedPDF.getPage(3).getAnnotations();        List<PDAnnotation> targetAnnotations01 = mergedPDF.getPage(2).getAnnotations();        List<PDAnnotation> targetAnnotations02 = mergedPDF.getPage(5).getAnnotations();                assertEquals("There shall be 3 source annotations at the first page", 3, sourceAnnotations01.size());        assertEquals("There shall be 3 source annotations at the third page", 3, targetAnnotations01.size());        assertTrue("The annotations shall match to each other", testAnnotationsMatch(sourceAnnotations01, targetAnnotations01));                assertEquals("There shall be 3 source annotations at the first page", 3, sourceAnnotations02.size());        assertEquals("There shall be 3 source annotations at the third page", 3, targetAnnotations02.size());        assertTrue("The annotations shall match to each other", testAnnotationsMatch(sourceAnnotations02, targetAnnotations02));        mergedPDF.close();    }}
private boolean pdfbox_f8032_0(List<PDAnnotation> sourceAnnots, List<PDAnnotation> targetAnnots)
{    Map<String, PDAnnotation> targetAnnotsByName = new HashMap<>();    COSName destinationName;        for (PDAnnotation targetAnnot : targetAnnots) {        destinationName = (COSName) targetAnnot.getCOSObject().getDictionaryObject(COSName.DEST);        targetAnnotsByName.put(destinationName.getName(), targetAnnot);    }        for (PDAnnotation sourceAnnot : sourceAnnots) {        destinationName = (COSName) sourceAnnot.getCOSObject().getDictionaryObject(COSName.DEST);        if (targetAnnotsByName.get("annoRef_" + destinationName.getName()) == null) {            return false;        }    }    return true;}
private void pdfbox_f8035_0(PDDocument doc)
{    if (doc != null) {        try {            doc.close();        } catch (Exception e) {        /* Can't do much about this... */        }    }}
public void pdfbox_f8036_0() throws Exception
{    PDDocument sourcePdf = null;    PDDocument result = null;    try {                sourcePdf = PDDocument.load(new File("src/test/resources/input/cweb.pdf"));        PageExtractor instance = new PageExtractor(sourcePdf);        result = instance.extract();        assertEquals(sourcePdf.getNumberOfPages(), result.getNumberOfPages());        closeDoc(result);        instance = new PageExtractor(sourcePdf, 1, 1);        result = instance.extract();        assertEquals(1, result.getNumberOfPages());        closeDoc(result);        instance = new PageExtractor(sourcePdf, 1, 5);        result = instance.extract();        assertEquals(5, result.getNumberOfPages());        closeDoc(result);        instance = new PageExtractor(sourcePdf, 5, 10);        result = instance.extract();        assertEquals(6, result.getNumberOfPages());        closeDoc(result);        instance = new PageExtractor(sourcePdf, 2, 1);        result = instance.extract();        assertEquals(0, result.getNumberOfPages());        closeDoc(result);    } finally {        closeDoc(sourcePdf);        closeDoc(result);    }}
public void pdfbox_f8037_0() throws IOException
{    try (PDDocument srcDoc = new PDDocument();        PDDocument dstDoc = new PDDocument()) {        PDPage pdPage = new PDPage();        srcDoc.addPage(pdPage);        new PDPageContentStream(srcDoc, pdPage, AppendMode.APPEND, true).close();        new PDPageContentStream(srcDoc, pdPage, AppendMode.APPEND, true).close();        new PDFCloneUtility(dstDoc).cloneForNewDocument(pdPage.getCOSObject());    }}
public void pdfbox_f8038_0() throws IOException
{    final String TESTDIR = "target/test-output/clone/";    final String CLONESRC = "clone-src.pdf";    final String CLONEDST = "clone-dst.pdf";    new File(TESTDIR).mkdirs();    PDDocument srcDoc = new PDDocument();    PDPage pdPage = new PDPage();    srcDoc.addPage(pdPage);    try (PDPageContentStream pdPageContentStream1 = new PDPageContentStream(srcDoc, pdPage, AppendMode.APPEND, false)) {        pdPageContentStream1.setNonStrokingColor(Color.black);        pdPageContentStream1.addRect(100, 600, 300, 100);        pdPageContentStream1.fill();    }    try (PDPageContentStream pdPageContentStream2 = new PDPageContentStream(srcDoc, pdPage, AppendMode.APPEND, false)) {        pdPageContentStream2.setNonStrokingColor(Color.red);        pdPageContentStream2.addRect(100, 500, 300, 100);        pdPageContentStream2.fill();    }    try (PDPageContentStream pdPageContentStream3 = new PDPageContentStream(srcDoc, pdPage, AppendMode.APPEND, false)) {        pdPageContentStream3.setNonStrokingColor(Color.yellow);        pdPageContentStream3.addRect(100, 400, 300, 100);        pdPageContentStream3.fill();    }    srcDoc.save(TESTDIR + CLONESRC);    PDFMergerUtility merger = new PDFMergerUtility();    PDDocument dstDoc = new PDDocument();            merger.appendDocument(dstDoc, srcDoc);        dstDoc.save(TESTDIR + CLONEDST);    PDDocument.load(new File(TESTDIR + CLONESRC)).close();    PDDocument.load(new File(TESTDIR + CLONESRC), (String) null).close();    PDDocument.load(new File(TESTDIR + CLONEDST)).close();    PDDocument.load(new File(TESTDIR + CLONEDST), (String) null).close();}
protected void pdfbox_f8039_0() throws Exception
{    super.setUp();    new File(TARGETTESTDIR).mkdirs();    if (!new File(TARGETTESTDIR).exists()) {        throw new IOException("could not create output directory");    }}
public void pdfbox_f8040_0() throws IOException
{    checkMergeIdentical("PDFBox.GlobalResourceMergeTest.Doc01.decoded.pdf", "PDFBox.GlobalResourceMergeTest.Doc02.decoded.pdf", "GlobalResourceMergeTestResult.pdf", MemoryUsageSetting.setupMainMemoryOnly());        checkMergeIdentical("PDFBox.GlobalResourceMergeTest.Doc01.decoded.pdf", "PDFBox.GlobalResourceMergeTest.Doc02.decoded.pdf", "GlobalResourceMergeTestResult2.pdf", MemoryUsageSetting.setupTempFileOnly());}
public void pdfbox_f8041_0() throws IOException
{    checkMergeIdentical("jpegrgb.pdf", "multitiff.pdf", "JpegMultiMergeTestResult.pdf", MemoryUsageSetting.setupMainMemoryOnly());        checkMergeIdentical("jpegrgb.pdf", "multitiff.pdf", "JpegMultiMergeTestResult.pdf", MemoryUsageSetting.setupTempFileOnly());}
public void pdfbox_f8042_0() throws IOException
{    checkMergeIdentical("PDFBox.GlobalResourceMergeTest.Doc01.pdf", "PDFBox.GlobalResourceMergeTest.Doc02.pdf", "GlobalResourceMergeTestResult.pdf", MemoryUsageSetting.setupMainMemoryOnly());        checkMergeIdentical("PDFBox.GlobalResourceMergeTest.Doc01.pdf", "PDFBox.GlobalResourceMergeTest.Doc02.pdf", "GlobalResourceMergeTestResult2.pdf", MemoryUsageSetting.setupTempFileOnly());}
public void pdfbox_f8043_0() throws IOException
{    try (PDDocument doc1 = new PDDocument()) {        doc1.addPage(new PDPage());        doc1.addPage(new PDPage());        doc1.addPage(new PDPage());        doc1.save(new File(TARGETTESTDIR, "MergerOpenActionTest1.pdf"));    }    PDPageDestination dest;    try (PDDocument doc2 = new PDDocument()) {        doc2.addPage(new PDPage());        doc2.addPage(new PDPage());        doc2.addPage(new PDPage());        dest = new PDPageFitDestination();        dest.setPage(doc2.getPage(1));        doc2.getDocumentCatalog().setOpenAction(dest);        doc2.save(new File(TARGETTESTDIR, "MergerOpenActionTest2.pdf"));    }    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();    pdfMergerUtility.addSource(new File(TARGETTESTDIR, "MergerOpenActionTest1.pdf"));    pdfMergerUtility.addSource(new File(TARGETTESTDIR, "MergerOpenActionTest2.pdf"));    pdfMergerUtility.setDestinationFileName(TARGETTESTDIR + "MergerOpenActionTestResult.pdf");    pdfMergerUtility.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());    try (PDDocument mergedDoc = PDDocument.load(new File(TARGETTESTDIR, "MergerOpenActionTestResult.pdf"))) {        PDDocumentCatalog documentCatalog = mergedDoc.getDocumentCatalog();        dest = (PDPageDestination) documentCatalog.getOpenAction();        assertEquals(4, documentCatalog.getPages().indexOf(dest.getPage()));    }}
public void pdfbox_f8044_0() throws IOException
{    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();    PDDocument src = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-3999-GeneralForbearance.pdf"));    ElementCounter elementCounter = new ElementCounter();    elementCounter.walk(src.getDocumentCatalog().getStructureTreeRoot().getK());    int singleCnt = elementCounter.cnt;    int singleSetSize = elementCounter.set.size();    assertEquals(134, singleCnt);    assertEquals(134, singleSetSize);    PDDocument dst = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-3999-GeneralForbearance.pdf"));    pdfMergerUtility.appendDocument(dst, src);    src.close();    dst.save(new File(TARGETTESTDIR, "PDFBOX-3999-GeneralForbearance-merged.pdf"));    dst.close();    PDDocument doc = PDDocument.load(new File(TARGETTESTDIR, "PDFBOX-3999-GeneralForbearance-merged.pdf"));        elementCounter = new ElementCounter();    elementCounter.walk(doc.getDocumentCatalog().getStructureTreeRoot().getK());    assertEquals(singleCnt * 2, elementCounter.cnt);    assertEquals(singleSetSize * 2, elementCounter.set.size());    checkForPageOrphans(doc);    doc.close();}
public void pdfbox_f8045_0() throws IOException
{    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();    PDDocument doc = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-3999-GeneralForbearance.pdf"));    doc.getDocumentCatalog().getAcroForm().flatten();    doc.save(new File(TARGETTESTDIR, "PDFBOX-3999-GeneralForbearance-flattened.pdf"));    ElementCounter elementCounter = new ElementCounter();    elementCounter.walk(doc.getDocumentCatalog().getStructureTreeRoot().getK());    int singleCnt = elementCounter.cnt;    int singleSetSize = elementCounter.set.size();    assertEquals(134, singleCnt);    assertEquals(134, singleSetSize);    doc.close();    PDDocument src = PDDocument.load(new File(TARGETTESTDIR, "PDFBOX-3999-GeneralForbearance-flattened.pdf"));    PDDocument dst = PDDocument.load(new File(TARGETTESTDIR, "PDFBOX-3999-GeneralForbearance-flattened.pdf"));    pdfMergerUtility.appendDocument(dst, src);            src.close();    dst.save(new File(TARGETTESTDIR, "PDFBOX-3999-GeneralForbearance-flattened-merged.pdf"));    dst.close();    doc = PDDocument.load(new File(TARGETTESTDIR, "PDFBOX-3999-GeneralForbearance-flattened-merged.pdf"));    checkForPageOrphans(doc);        elementCounter = new ElementCounter();    elementCounter.walk(doc.getDocumentCatalog().getStructureTreeRoot().getK());    assertEquals(singleCnt * 2, elementCounter.cnt);    assertEquals(singleSetSize * 2, elementCounter.set.size());    doc.close();}
public void pdfbox_f8046_0() throws IOException
{    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();    PDDocument src = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-4408.pdf"));    ElementCounter elementCounter = new ElementCounter();    elementCounter.walk(src.getDocumentCatalog().getStructureTreeRoot().getK());    int singleCnt = elementCounter.cnt;    int singleSetSize = elementCounter.set.size();    assertEquals(25, singleCnt);    assertEquals(25, singleSetSize);    PDDocument dst = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-4408.pdf"));    pdfMergerUtility.appendDocument(dst, src);    src.close();    dst.save(new File(TARGETTESTDIR, "PDFBOX-4408-merged.pdf"));    dst.close();    dst = PDDocument.load(new File(TARGETTESTDIR, "PDFBOX-4408-merged.pdf"));        elementCounter = new ElementCounter();    elementCounter.walk(dst.getDocumentCatalog().getStructureTreeRoot().getK());    assertEquals(singleCnt * 2, elementCounter.cnt);    assertEquals(singleSetSize * 2, elementCounter.set.size());    checkWithNumberTree(dst);    checkForPageOrphans(dst);    dst.close();    checkStructTreeRootCount(new File(TARGETTESTDIR, "PDFBOX-4408-merged.pdf"));}
public void pdfbox_f8047_0() throws IOException
{    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();    PDDocument src = PDDocument.load(new File(SRCDIR, "PDFBOX-4417-001031.pdf"));    ElementCounter elementCounter = new ElementCounter();    elementCounter.walk(src.getDocumentCatalog().getStructureTreeRoot().getK());    int singleCnt = elementCounter.cnt;    int singleSetSize = elementCounter.set.size();    assertEquals(104, singleCnt);    assertEquals(104, singleSetSize);    PDDocument dst = PDDocument.load(new File(SRCDIR, "PDFBOX-4417-001031.pdf"));    pdfMergerUtility.appendDocument(dst, src);    src.close();    dst.save(new File(TARGETTESTDIR, "PDFBOX-4417-001031-merged.pdf"));    dst.close();    dst = PDDocument.load(new File(TARGETTESTDIR, "PDFBOX-4417-001031-merged.pdf"));        elementCounter = new ElementCounter();    elementCounter.walk(dst.getDocumentCatalog().getStructureTreeRoot().getK());    assertEquals(singleCnt * 2, elementCounter.cnt);    assertEquals(singleSetSize * 2, elementCounter.set.size());    checkWithNumberTree(dst);    checkForPageOrphans(dst);    dst.close();    checkStructTreeRootCount(new File(TARGETTESTDIR, "PDFBOX-4417-001031-merged.pdf"));}
public void pdfbox_f8048_0() throws IOException
{    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();    PDDocument src = PDDocument.load(new File(SRCDIR, "PDFBOX-4417-054080.pdf"));    ElementCounter elementCounter = new ElementCounter();    elementCounter.walk(src.getDocumentCatalog().getStructureTreeRoot().getK());    int singleCnt = elementCounter.cnt;    int singleSetSize = elementCounter.set.size();    PDDocument dst = PDDocument.load(new File(SRCDIR, "PDFBOX-4417-054080.pdf"));    pdfMergerUtility.appendDocument(dst, src);    src.close();    dst.save(new File(TARGETTESTDIR, "PDFBOX-4417-054080-merged.pdf"));    dst.close();    dst = PDDocument.load(new File(TARGETTESTDIR, "PDFBOX-4417-054080-merged.pdf"));    checkWithNumberTree(dst);    checkForPageOrphans(dst);        elementCounter = new ElementCounter();    elementCounter.walk(dst.getDocumentCatalog().getStructureTreeRoot().getK());    assertEquals(singleCnt * 2, elementCounter.cnt);    assertEquals(singleSetSize * 2, elementCounter.set.size());    dst.close();    checkStructTreeRootCount(new File(TARGETTESTDIR, "PDFBOX-4417-054080-merged.pdf"));}
public void pdfbox_f8049_0() throws IOException
{    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();    PDDocument src = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-4418-000671.pdf"));    PDStructureTreeRoot structureTreeRoot = src.getDocumentCatalog().getStructureTreeRoot();    PDNumberTreeNode parentTree = structureTreeRoot.getParentTree();    Map<Integer, COSObjectable> numberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(parentTree);    assertEquals(381, numberTreeAsMap.size());    assertEquals(743, Collections.max(numberTreeAsMap.keySet()) + 1);    assertEquals(0, (int) Collections.min(numberTreeAsMap.keySet()));    assertEquals(743, structureTreeRoot.getParentTreeNextKey());    PDDocument dst = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-4418-000314.pdf"));    structureTreeRoot = dst.getDocumentCatalog().getStructureTreeRoot();    parentTree = structureTreeRoot.getParentTree();    numberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(parentTree);    assertEquals(7, numberTreeAsMap.size());    assertEquals(328, Collections.max(numberTreeAsMap.keySet()) + 1);    assertEquals(321, (int) Collections.min(numberTreeAsMap.keySet()));        assertEquals(408, structureTreeRoot.getParentTreeNextKey());    pdfMergerUtility.appendDocument(dst, src);    src.close();    dst.save(new File(TARGETTESTDIR, "PDFBOX-4418-merged.pdf"));    dst.close();    dst = PDDocument.load(new File(TARGETTESTDIR, "PDFBOX-4418-merged.pdf"));    checkWithNumberTree(dst);    checkForPageOrphans(dst);    structureTreeRoot = dst.getDocumentCatalog().getStructureTreeRoot();    parentTree = structureTreeRoot.getParentTree();    numberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(parentTree);    assertEquals(381 + 7, numberTreeAsMap.size());    assertEquals(408 + 743, Collections.max(numberTreeAsMap.keySet()) + 1);    assertEquals(321, (int) Collections.min(numberTreeAsMap.keySet()));    assertEquals(408 + 743, structureTreeRoot.getParentTreeNextKey());    dst.close();    checkStructTreeRootCount(new File(TARGETTESTDIR, "PDFBOX-4418-merged.pdf"));}
public void pdfbox_f8050_0() throws IOException
{    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();    PDDocument src = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-4423-000746.pdf"));    PDStructureTreeRoot structureTreeRoot = src.getDocumentCatalog().getStructureTreeRoot();    PDNumberTreeNode parentTree = structureTreeRoot.getParentTree();    Map<Integer, COSObjectable> numberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(parentTree);    assertEquals(33, numberTreeAsMap.size());    assertEquals(64, Collections.max(numberTreeAsMap.keySet()) + 1);    assertEquals(31, (int) Collections.min(numberTreeAsMap.keySet()));    assertEquals(126, structureTreeRoot.getParentTreeNextKey());    PDDocument dst = new PDDocument();    pdfMergerUtility.appendDocument(dst, src);    src.close();    dst.save(new File(TARGETTESTDIR, "PDFBOX-4423-merged.pdf"));    dst.close();    dst = PDDocument.load(new File(TARGETTESTDIR, "PDFBOX-4423-merged.pdf"));    checkWithNumberTree(dst);    checkForPageOrphans(dst);    structureTreeRoot = dst.getDocumentCatalog().getStructureTreeRoot();    parentTree = structureTreeRoot.getParentTree();    numberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(parentTree);    assertEquals(33, numberTreeAsMap.size());    assertEquals(64, Collections.max(numberTreeAsMap.keySet()) + 1);    assertEquals(31, (int) Collections.min(numberTreeAsMap.keySet()));    assertEquals(64, structureTreeRoot.getParentTreeNextKey());    dst.close();    checkStructTreeRootCount(new File(TARGETTESTDIR, "PDFBOX-4423-merged.pdf"));}
public void pdfbox_f8051_0() throws IOException
{    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();    PDDocument src = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-4418-000314.pdf"));    PDDocument dst = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-4418-000314.pdf"));                        dst.getDocumentCatalog().getStructureTreeRoot().getCOSObject().removeItem(COSName.PARENT_TREE_NEXT_KEY);    pdfMergerUtility.appendDocument(dst, src);    src.close();    dst.save(new File(TARGETTESTDIR, "PDFBOX-4418-000314-merged.pdf"));    dst.close();    dst = PDDocument.load(new File(TARGETTESTDIR, "PDFBOX-4418-000314-merged.pdf"));    assertEquals(656, dst.getDocumentCatalog().getStructureTreeRoot().getParentTreeNextKey());    dst.close();}
public void pdfbox_f8052_0() throws IOException
{    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();    PDDocument src = PDDocument.load(new File(SRCDIR, "PDFBOX-4417-001031.pdf"));    PDDocument dst = PDDocument.load(new File(SRCDIR, "PDFBOX-4417-054080.pdf"));    PDNameTreeNode<PDStructureElement> srcIDTree = src.getDocumentCatalog().getStructureTreeRoot().getIDTree();    Map<String, PDStructureElement> srcIDTreeMap = PDFMergerUtility.getIDTreeAsMap(srcIDTree);    PDNameTreeNode<PDStructureElement> dstIDTree = dst.getDocumentCatalog().getStructureTreeRoot().getIDTree();    Map<String, PDStructureElement> dstIDTreeMap = PDFMergerUtility.getIDTreeAsMap(dstIDTree);    int expectedTotal = srcIDTreeMap.size() + dstIDTreeMap.size();    assertEquals(192, expectedTotal);            PDDocument emptyDest = new PDDocument();    pdfMergerUtility.appendDocument(emptyDest, src);    src.close();    src = emptyDest;    assertEquals(4, src.getDocumentCatalog().getStructureTreeRoot().getParentTreeNextKey());    pdfMergerUtility.appendDocument(dst, src);    src.close();    dst.save(new File(TARGETTESTDIR, "PDFBOX-4416-IDTree-merged.pdf"));    dst.close();    dst = PDDocument.load(new File(TARGETTESTDIR, "PDFBOX-4416-IDTree-merged.pdf"));    checkWithNumberTree(dst);    checkForPageOrphans(dst);    dstIDTree = dst.getDocumentCatalog().getStructureTreeRoot().getIDTree();    dstIDTreeMap = PDFMergerUtility.getIDTreeAsMap(dstIDTree);    assertEquals(expectedTotal, dstIDTreeMap.size());    dst.close();    checkStructTreeRootCount(new File(TARGETTESTDIR, "PDFBOX-4416-IDTree-merged.pdf"));}
public void pdfbox_f8053_0() throws IOException
{    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();    PDDocument src = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-4408.pdf"));    PDDocument dst = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-4408.pdf"));    dst.getDocumentCatalog().setStructureTreeRoot(null);    dst.getPage(0).setStructParents(9999);    dst.getPage(0).getAnnotations().get(0).setStructParent(9998);    pdfMergerUtility.appendDocument(dst, src);    checkWithNumberTree(dst);    checkForPageOrphans(dst);    src.close();    dst.close();}
public void pdfbox_f8054_0() throws IOException
{    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();    PDDocument src = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-4408.pdf"));    PDDocument dst = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-4408.pdf"));    src.getDocumentCatalog().setStructureTreeRoot(null);    src.getPage(0).setStructParents(9999);    src.getPage(0).getAnnotations().get(0).setStructParent(9998);    pdfMergerUtility.appendDocument(dst, src);    checkWithNumberTree(dst);    checkForPageOrphans(dst);    src.close();    dst.close();}
public void pdfbox_f8055_0() throws IOException
{    PDDocument doc = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-3999-GeneralForbearance.pdf"));    PDStructureTreeRoot structureTreeRoot = doc.getDocumentCatalog().getStructureTreeRoot();    PDNumberTreeNode parentTree = structureTreeRoot.getParentTree();    parentTree.getValue(0);    Map<Integer, COSObjectable> numberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(parentTree);    assertEquals(31, numberTreeAsMap.size());    assertEquals(31, Collections.max(numberTreeAsMap.keySet()) + 1);    assertEquals(0, (int) Collections.min(numberTreeAsMap.keySet()));    assertEquals(31, structureTreeRoot.getParentTreeNextKey());    doc.close();}
private void pdfbox_f8056_0(File file) throws IOException
{    int count = 0;    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {        String line;        while ((line = br.readLine()) != null) {            if (line.equals("/Type /StructTreeRoot")) {                ++count;            }        }    }    assertEquals(1, count);}
 void pdfbox_f8057_0(PDDocument document) throws IOException
{    PDDocumentCatalog documentCatalog = document.getDocumentCatalog();    PDNumberTreeNode parentTree = documentCatalog.getStructureTreeRoot().getParentTree();    Map<Integer, COSObjectable> numberTreeAsMap = PDFMergerUtility.getNumberTreeAsMap(parentTree);    Set<Integer> keySet = numberTreeAsMap.keySet();    PDAcroForm acroForm = documentCatalog.getAcroForm();    if (acroForm != null) {        for (PDField field : acroForm.getFieldTree()) {            for (PDAnnotationWidget widget : field.getWidgets()) {                if (widget.getStructParent() >= 0) {                    assertTrue("field '" + field.getFullyQualifiedName() + "' /StructParent " + widget.getStructParent() + " missing in /ParentTree", keySet.contains(widget.getStructParent()));                }            }        }    }    for (PDPage page : document.getPages()) {        if (page.getStructParents() >= 0) {            assertTrue(keySet.contains(page.getStructParents()));        }        for (PDAnnotation ann : page.getAnnotations()) {            if (ann.getStructParent() >= 0) {                assertTrue("/StructParent " + ann.getStructParent() + " missing in /ParentTree", keySet.contains(ann.getStructParent()));            }        }    }}
public void pdfbox_f8058_0() throws IOException
{    File outFile = new File(TARGETTESTDIR, "PDFBOX-4383-result.pdf");    File inFile1 = new File(TARGETTESTDIR, "PDFBOX-4383-src1.pdf");    File inFile2 = new File(TARGETTESTDIR, "PDFBOX-4383-src2.pdf");    createSimpleFile(inFile1);    createSimpleFile(inFile2);    try (OutputStream out = new FileOutputStream(outFile)) {        PDFMergerUtility merger = new PDFMergerUtility();        merger.setDestinationStream(out);        merger.addSource(inFile1);        merger.addSource(inFile2);        merger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());    }    Files.delete(inFile1.toPath());    Files.delete(inFile2.toPath());    Files.delete(outFile.toPath());}
private void pdfbox_f8059_0(PDDocument doc) throws IOException
{            PDPageTree pageTree = doc.getPages();    PDStructureTreeRoot structureTreeRoot = doc.getDocumentCatalog().getStructureTreeRoot();    checkElement(pageTree, structureTreeRoot.getParentTree().getCOSObject());    checkElement(pageTree, structureTreeRoot.getK());    checkForIDTreeOrphans(pageTree, structureTreeRoot);}
private void pdfbox_f8060_0(PDPageTree pageTree, PDStructureTreeRoot structureTreeRoot) throws IOException
{    PDNameTreeNode<PDStructureElement> idTree = structureTreeRoot.getIDTree();    if (idTree == null) {        return;    }    Map<String, PDStructureElement> map = PDFMergerUtility.getIDTreeAsMap(idTree);    for (PDStructureElement element : map.values()) {        if (element.getPage() != null) {            checkForPage(pageTree, element);        }        if (!element.getKids().isEmpty()) {            checkElement(pageTree, element.getCOSObject().getDictionaryObject(COSName.K));        }    }}
private void pdfbox_f8061_0(File file) throws IOException
{    try (PDDocument doc = new PDDocument()) {        doc.addPage(new PDPage());        doc.save(file);    }}
 void pdfbox_f8062_0(COSBase base)
{    if (base instanceof COSArray) {        for (COSBase base2 : (COSArray) base) {            if (base2 instanceof COSObject) {                base2 = ((COSObject) base2).getObject();            }            walk(base2);        }    } else if (base instanceof COSDictionary) {        COSDictionary kdict = (COSDictionary) base;        if (kdict.containsKey(COSName.PG)) {            ++cnt;            set.add(kdict);        }        if (kdict.containsKey(COSName.K)) {            walk(kdict.getDictionaryObject(COSName.K));        }    }}
private void pdfbox_f8063_0(PDPageTree pageTree, COSBase base) throws IOException
{    if (base instanceof COSArray) {        for (COSBase base2 : (COSArray) base) {            if (base2 instanceof COSObject) {                base2 = ((COSObject) base2).getObject();            }            checkElement(pageTree, base2);        }    } else if (base instanceof COSDictionary) {        COSDictionary kdict = (COSDictionary) base;        if (kdict.containsKey(COSName.PG)) {            PDStructureElement structureElement = new PDStructureElement(kdict);            checkForPage(pageTree, structureElement);        }        if (kdict.containsKey(COSName.K)) {            checkElement(pageTree, kdict.getDictionaryObject(COSName.K));            return;        }                if (kdict.containsKey(COSName.KIDS)) {            checkElement(pageTree, kdict.getDictionaryObject(COSName.KIDS));        } else if (kdict.containsKey(COSName.NUMS)) {            checkElement(pageTree, kdict.getDictionaryObject(COSName.NUMS));        }                if (kdict.containsKey(COSName.OBJ)) {            COSDictionary obj = (COSDictionary) kdict.getDictionaryObject(COSName.OBJ);            COSBase type = obj.getDictionaryObject(COSName.TYPE);            if (COSName.ANNOT.equals(type)) {                PDAnnotation annotation = PDAnnotation.createAnnotation(obj);                PDPage page = annotation.getPage();                if (page != null) {                    if (pageTree.indexOf(page) == -1) {                        COSBase item = kdict.getItem(COSName.OBJ);                        if (item instanceof COSObject) {                            assertTrue("Annotation page is not in the page tree: " + item, pageTree.indexOf(page) != -1);                        } else {                                                        assertTrue("Annotation page is not in the page tree", pageTree.indexOf(page) != -1);                        }                    }                }            } else {                                                fail("Other type: " + type);            }        }    }}
private void pdfbox_f8064_0(String filename1, String filename2, String mergeFilename, MemoryUsageSetting memUsageSetting) throws IOException
{    int src1PageCount;    BufferedImage[] src1ImageTab;    try (PDDocument srcDoc1 = PDDocument.load(new File(SRCDIR, filename1), (String) null)) {        src1PageCount = srcDoc1.getNumberOfPages();        PDFRenderer src1PdfRenderer = new PDFRenderer(srcDoc1);        src1ImageTab = new BufferedImage[src1PageCount];        for (int page = 0; page < src1PageCount; ++page) {            src1ImageTab[page] = src1PdfRenderer.renderImageWithDPI(page, DPI);        }    }    int src2PageCount;    BufferedImage[] src2ImageTab;    try (PDDocument srcDoc2 = PDDocument.load(new File(SRCDIR, filename2), (String) null)) {        src2PageCount = srcDoc2.getNumberOfPages();        PDFRenderer src2PdfRenderer = new PDFRenderer(srcDoc2);        src2ImageTab = new BufferedImage[src2PageCount];        for (int page = 0; page < src2PageCount; ++page) {            src2ImageTab[page] = src2PdfRenderer.renderImageWithDPI(page, DPI);        }    }    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();    pdfMergerUtility.addSource(new File(SRCDIR, filename1));    pdfMergerUtility.addSource(new File(SRCDIR, filename2));    pdfMergerUtility.setDestinationFileName(TARGETTESTDIR + mergeFilename);    pdfMergerUtility.mergeDocuments(memUsageSetting);    try (PDDocument mergedDoc = PDDocument.load(new File(TARGETTESTDIR, mergeFilename), (String) null)) {        PDFRenderer mergePdfRenderer = new PDFRenderer(mergedDoc);        int mergePageCount = mergedDoc.getNumberOfPages();        assertEquals(src1PageCount + src2PageCount, mergePageCount);        for (int page = 0; page < src1PageCount; ++page) {            BufferedImage bim = mergePdfRenderer.renderImageWithDPI(page, DPI);            checkImagesIdentical(bim, src1ImageTab[page]);        }        for (int page = 0; page < src2PageCount; ++page) {            int mergePage = page + src1PageCount;            BufferedImage bim = mergePdfRenderer.renderImageWithDPI(mergePage, DPI);            checkImagesIdentical(bim, src2ImageTab[page]);        }    }}
private void pdfbox_f8065_0(BufferedImage bim1, BufferedImage bim2)
{    assertEquals(bim1.getHeight(), bim2.getHeight());    assertEquals(bim1.getWidth(), bim2.getWidth());    int w = bim1.getWidth();    int h = bim1.getHeight();    for (int i = 0; i < w; ++i) {        for (int j = 0; j < h; ++j) {            assertEquals(bim1.getRGB(i, j), bim2.getRGB(i, j));        }    }}
private void pdfbox_f8066_0(PDPageTree pageTree, PDStructureElement structureElement)
{    PDPage page = structureElement.getPage();    if (page != null) {        assertTrue("Page is not in the page tree", pageTree.indexOf(page) != -1);    }}
protected void pdfbox_f8067_0() throws Exception
{    super.setUp();    testResultsDir.mkdirs();}
public void pdfbox_f8068_0() throws Exception
{    File mainPDF = createMainPDF();    File overlay1 = createOverlay1();    File targetFile = new File(testResultsDir, "text-with-form-overlay.pdf");    try (PDDocument targetDoc = PDDocument.load(mainPDF);        PDDocument overlay1Doc = PDDocument.load(overlay1)) {        LayerUtility layerUtil = new LayerUtility(targetDoc);        PDFormXObject form = layerUtil.importPageAsForm(overlay1Doc, 0);        PDPage targetPage = targetDoc.getPage(0);        layerUtil.wrapInSaveRestore(targetPage);        AffineTransform at = new AffineTransform();        layerUtil.appendFormAsLayer(targetPage, form, at, "overlay");        targetDoc.save(targetFile.getAbsolutePath());    }    try (PDDocument doc = PDDocument.load(targetFile)) {        PDDocumentCatalog catalog = doc.getDocumentCatalog();                assertEquals(1.5f, doc.getVersion());        PDPage page = doc.getPage(0);        PDOptionalContentGroup ocg = (PDOptionalContentGroup) page.getResources().getProperties(COSName.getPDFName("oc1"));        assertNotNull(ocg);        assertEquals("overlay", ocg.getName());        PDOptionalContentProperties ocgs = catalog.getOCProperties();        PDOptionalContentGroup overlay = ocgs.getGroup("overlay");        assertEquals(ocg.getName(), overlay.getName());    }}
private File pdfbox_f8069_0() throws IOException
{    File targetFile = new File(testResultsDir, "text-doc.pdf");    try (PDDocument doc = new PDDocument()) {                PDPage page = new PDPage();        doc.addPage(page);        PDResources resources = page.getResources();        if (resources == null) {            resources = new PDResources();            page.setResources(resources);        }        final String[] text = new String[] { "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer fermentum lacus in eros", "condimentum eget tristique risus viverra. Sed ac sem et lectus ultrices placerat. Nam", "fringilla tincidunt nulla id euismod. Vivamus eget mauris dui. Mauris luctus ullamcorper", "leo, et laoreet diam suscipit et. Nulla viverra commodo sagittis. Integer vitae rhoncus velit.", "Mauris porttitor ipsum in est sagittis non luctus purus molestie. Sed placerat aliquet", "vulputate." };        try (PDPageContentStream contentStream = new PDPageContentStream(doc, page, AppendMode.OVERWRITE, false)) {                        PDFont font = PDType1Font.HELVETICA_BOLD;            contentStream.beginText();            contentStream.newLineAtOffset(50, 720);            contentStream.setFont(font, 14);            contentStream.showText("Simple test document with text.");            contentStream.endText();            font = PDType1Font.HELVETICA;            contentStream.beginText();            int fontSize = 12;            contentStream.setFont(font, fontSize);            contentStream.newLineAtOffset(50, 700);            for (String line : text) {                contentStream.newLineAtOffset(0, -fontSize * 1.2f);                contentStream.showText(line);            }            contentStream.endText();        }        doc.save(targetFile.getAbsolutePath());    }    return targetFile;}
private File pdfbox_f8070_0() throws IOException
{    File targetFile = new File(testResultsDir, "overlay1.pdf");    try (PDDocument doc = new PDDocument()) {                PDPage page = new PDPage();        doc.addPage(page);        PDResources resources = page.getResources();        if (resources == null) {            resources = new PDResources();            page.setResources(resources);        }        try (PDPageContentStream contentStream = new PDPageContentStream(doc, page, AppendMode.OVERWRITE, false)) {                        PDFont font = PDType1Font.HELVETICA_BOLD;            contentStream.setNonStrokingColor(Color.LIGHT_GRAY);            contentStream.beginText();            float fontSize = 96;            contentStream.setFont(font, fontSize);            String text = "OVERLAY";                                    PDRectangle crop = page.getCropBox();            float cx = crop.getWidth() / 2f;            float cy = crop.getHeight() / 2f;            Matrix transform = new Matrix();            transform.translate(cx, cy);            transform.rotate(Math.toRadians(45));            transform.translate(-190, /* sw/2 */            0);            contentStream.setTextMatrix(transform);            contentStream.showText(text);            contentStream.endText();        }        doc.save(targetFile.getAbsolutePath());    }    return targetFile;}
public void pdfbox_f8071_0()
{    executorService.shutdown();    try {        executorService.awaitTermination(timeoutSeconds, TimeUnit.SECONDS);    } catch (InterruptedException exc) {        throw new RuntimeException(exc);    }}
public void pdfbox_f8072_0(Runnable childStatement)
{    executorService.submit(childStatement);}
public void pdfbox_f8073_0() throws IOException
{    ByteArrayOutputStream baos = new ByteArrayOutputStream();    EndstreamOutputStream feos = new EndstreamOutputStream(baos);    byte[] tab1 = { 1, 2, 3, 4 };    byte[] tab2 = { 5, 6, 7, '\r', '\n' };    byte[] tab3 = { 8, 9, '\r', '\n' };    feos.write(tab1, 0, tab1.length);    feos.write(tab2, 0, tab2.length);    feos.write(tab3, 0, tab3.length);    feos.flush();    byte[] expectedResult1 = { 1, 2, 3, 4, 5, 6, 7, '\r', '\n', 8, 9 };    Assert.assertArrayEquals(expectedResult1, baos.toByteArray());    baos = new ByteArrayOutputStream();    feos = new EndstreamOutputStream(baos);    byte[] tab4 = { 1, 2, 3, 4 };    byte[] tab5 = { 5, 6, 7, '\r' };    byte[] tab6 = { 8, 9, '\n' };    feos.write(tab4, 0, tab4.length);    feos.write(tab5, 0, tab5.length);    feos.write(tab6, 0, tab6.length);    feos.flush();    byte[] expectedResult2 = { 1, 2, 3, 4, 5, 6, 7, '\r', 8, 9 };    Assert.assertArrayEquals(expectedResult2, baos.toByteArray());    baos = new ByteArrayOutputStream();    feos = new EndstreamOutputStream(baos);    byte[] tab7 = { 1, 2, 3, 4, '\r' };    byte[] tab8 = { '\n', 5, 6, 7, '\n' };        byte[] tab9 = { 8, 9, '\r' };    feos.write(tab7, 0, tab7.length);    feos.write(tab8, 0, tab8.length);    feos.write(tab9, 0, tab9.length);    feos.flush();    byte[] expectedResult3 = { 1, 2, 3, 4, '\r', '\n', 5, 6, 7, '\n', 8, 9, '\r' };    Assert.assertArrayEquals(expectedResult3, baos.toByteArray());    baos = new ByteArrayOutputStream();    feos = new EndstreamOutputStream(baos);    byte[] tab10 = { 1, 2, 3, 4, '\r' };    byte[] tab11 = { '\n', 5, 6, 7, '\r' };    byte[] tab12 = { 8, 9, '\r' };        byte[] tab13 = { '\n' };    feos.write(tab10, 0, tab10.length);    feos.write(tab11, 0, tab11.length);    feos.write(tab12, 0, tab12.length);    feos.write(tab13, 0, tab13.length);    feos.flush();    byte[] expectedResult4 = { 1, 2, 3, 4, '\r', '\n', 5, 6, 7, '\r', 8, 9 };    Assert.assertArrayEquals(expectedResult4, baos.toByteArray());    baos = new ByteArrayOutputStream();    feos = new EndstreamOutputStream(baos);    byte[] tab14 = { 1, 2, 3, 4, '\r' };    byte[] tab15 = { '\n', 5, 6, 7, '\r' };    byte[] tab16 = { 8, 9, '\n' };        byte[] tab17 = { '\r' };    feos.write(tab14, 0, tab14.length);    feos.write(tab15, 0, tab15.length);    feos.write(tab16, 0, tab16.length);    feos.write(tab17, 0, tab17.length);    feos.flush();    byte[] expectedResult5 = { 1, 2, 3, 4, '\r', '\n', 5, 6, 7, '\r', 8, 9, '\n', '\r' };    Assert.assertArrayEquals(expectedResult5, baos.toByteArray());}
public void pdfbox_f8074_0() throws IOException
{        try (PDDocument doc = PDDocument.load(new File("src/test/resources/org/apache/pdfbox/pdfparser", "embedded_zip.pdf"))) {        PDDocumentCatalog catalog = doc.getDocumentCatalog();        PDDocumentNameDictionary names = catalog.getNames();        PDEmbeddedFilesNameTreeNode node = names.getEmbeddedFiles();        Map<String, PDComplexFileSpecification> map = node.getNames();        Assert.assertEquals(1, map.size());        PDComplexFileSpecification spec = map.get("My first attachment");        PDEmbeddedFile file = spec.getEmbeddedFile();        InputStream input = file.createInputStream();        File d = new File("target/test-output");        d.mkdirs();        File f = new File(d, spec.getFile());        try (OutputStream os = new FileOutputStream(f)) {            IOUtils.copy(input, os);        }        Assert.assertEquals(17660, f.length());    }}
public void pdfbox_f8075_0() throws IOException
{    testInlineImage2ops("ID\n12345EI Q", "12345", "Q");    testInlineImage2ops("ID\n12345EI EMC", "12345", "EMC");    testInlineImage2ops("ID\n12345EI Q ", "12345", "Q");    testInlineImage2ops("ID\n12345EI EMC ", "12345", "EMC");    testInlineImage2ops("ID\n12345EI  Q", "12345", "Q");    testInlineImage2ops("ID\n12345EI  EMC", "12345", "EMC");    testInlineImage2ops("ID\n12345EI  Q ", "12345", "Q");    testInlineImage2ops("ID\n12345EI  EMC ", "12345", "EMC");    testInlineImage2ops("ID\n12345EI \000Q", "12345", "Q");    testInlineImage2ops("ID\n12345EI Q                             ", "12345", "Q");    testInlineImage2ops("ID\n12345EI EMC                           ", "12345", "EMC");    testInlineImage1op("ID\n12345EI", "12345");    testInlineImage1op("ID\n12345EI                               ", "12345");    testInlineImage2ops("ID\n12345EI                               Q ", "12345", "Q");    testInlineImage2ops("ID\n12345EI                               EMC ", "12345", "EMC");    testInlineImage2ops("ID\n12345EI                               Q", "12345", "Q");    testInlineImage2ops("ID\n12345EI                               EMC", "12345", "EMC");    testInlineImage1op("ID\n12EI5EI", "12EI5");    testInlineImage1op("ID\n12EI5EI ", "12EI5");    testInlineImage1op("ID\n12EI5EIQEI", "12EI5EIQ");    testInlineImage2ops("ID\n12EI5EIQEI Q", "12EI5EIQ", "Q");    testInlineImage2ops("ID\n12EI5EI Q", "12EI5", "Q");    testInlineImage2ops("ID\n12EI5EI Q ", "12EI5", "Q");    testInlineImage2ops("ID\n12EI5EI EMC", "12EI5", "EMC");    testInlineImage2ops("ID\n12EI5EI EMC ", "12EI5", "EMC");    testInlineImage2ops("ID\n12EI5EI                                Q", "12EI5", "Q");    testInlineImage2ops("ID\n12EI5EI                                Q ", "12EI5", "Q");    testInlineImage2ops("ID\n12EI5EI                                EMC", "12EI5", "EMC");    testInlineImage2ops("ID\n12EI5EI                                EMC ", "12EI5", "EMC");            testInlineImage2ops("ID\n12EI5EI       EMC ", "12EI5", "EMC");    testInlineImage2ops("ID\n12EI5EI        EMC ", "12EI5", "EMC");    testInlineImage2ops("ID\n12EI5EI         EMC ", "12EI5", "EMC");    testInlineImage2ops("ID\n12EI5EI          EMC ", "12EI5", "EMC");    testInlineImage2ops("ID\n12EI5EI       Q   ", "12EI5", "Q");    testInlineImage2ops("ID\n12EI5EI        Q   ", "12EI5", "Q");    testInlineImage2ops("ID\n12EI5EI         Q   ", "12EI5", "Q");    testInlineImage2ops("ID\n12EI5EI          Q   ", "12EI5", "Q");}
private void pdfbox_f8076_0(String s, String imageDataString, String opName) throws IOException
{    List<Object> tokens = parseTokenString(s);    assertEquals(2, tokens.size());    assertEquals(OperatorName.BEGIN_INLINE_IMAGE_DATA, ((Operator) tokens.get(0)).getName());    assertEquals(imageDataString.length(), ((Operator) tokens.get(0)).getImageData().length);    assertArrayEquals(imageDataString.getBytes(), ((Operator) tokens.get(0)).getImageData());    assertEquals(opName, ((Operator) tokens.get(1)).getName());}
private void pdfbox_f8077_0(String s, String imageDataString) throws IOException
{    List<Object> tokens = parseTokenString(s);    assertEquals(1, tokens.size());    assertEquals(OperatorName.BEGIN_INLINE_IMAGE_DATA, ((Operator) tokens.get(0)).getName());    assertEquals(imageDataString.length(), ((Operator) tokens.get(0)).getImageData().length);    assertArrayEquals(imageDataString.getBytes(), ((Operator) tokens.get(0)).getImageData());}
private List<Object> pdfbox_f8078_0(String s) throws IOException
{    PDFStreamParser pdfStreamParser = new PDFStreamParser(s.getBytes());    pdfStreamParser.parse();    return pdfStreamParser.getTokens();}
public void pdfbox_f8079_0() throws Exception
{    numberOfTmpFiles = getNumberOfTempFile();}
private int pdfbox_f8080_0()
{    int result = 0;    File[] tmpPdfs = tmpDirectory.listFiles(new FilenameFilter() {        @Override        public boolean accept(File dir, String name) {            return name.startsWith(COSParser.TMP_FILE_PREFIX) && name.endsWith("pdf");        }    });    if (tmpPdfs != null) {        result = tmpPdfs.length;    }    return result;}
public boolean pdfbox_f8081_0(File dir, String name)
{    return name.startsWith(COSParser.TMP_FILE_PREFIX) && name.endsWith("pdf");}
public void pdfbox_f8082_0() throws IOException
{    executeParserTest(new RandomAccessBufferedFileInputStream(new File(PATH_OF_PDF)), MemoryUsageSetting.setupMainMemoryOnly());}
public void pdfbox_f8083_0() throws IOException
{    executeParserTest(new RandomAccessBufferedFileInputStream(new FileInputStream(PATH_OF_PDF)), MemoryUsageSetting.setupMainMemoryOnly());}
public void pdfbox_f8084_0() throws IOException
{    executeParserTest(new RandomAccessBufferedFileInputStream(new File(PATH_OF_PDF)), MemoryUsageSetting.setupTempFileOnly());}
public void pdfbox_f8085_0() throws IOException
{    executeParserTest(new RandomAccessBufferedFileInputStream(new FileInputStream(PATH_OF_PDF)), MemoryUsageSetting.setupTempFileOnly());}
public void pdfbox_f8086_0() throws IOException, URISyntaxException
{        PDDocument.load(new File(TestPDFParser.class.getResource("MissingCatalog.pdf").toURI())).close();}
public void pdfbox_f8087_0() throws IOException
{    try (PDDocument doc = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-3208-L33MUTT2SVCWGCS6UIYL5TH3PNPXHIS6.pdf"))) {        PDDocumentInformation di = doc.getDocumentInformation();        assertEquals("Liquent Enterprise Services", di.getAuthor());        assertEquals("Liquent services server", di.getCreator());        assertEquals("Amyuni PDF Converter version 4.0.0.9", di.getProducer());        assertEquals("", di.getKeywords());        assertEquals("", di.getSubject());        assertEquals("892B77DE781B4E71A1BEFB81A51A5ABC_20140326022424.docx", di.getTitle());        assertEquals(DateConverter.toCalendar("D:20140326142505-02'00'"), di.getCreationDate());        assertEquals(DateConverter.toCalendar("20140326172513Z"), di.getModificationDate());    }}
public void pdfbox_f8088_0() throws IOException
{    try (PDDocument doc = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-3940-079977.pdf"))) {        PDDocumentInformation di = doc.getDocumentInformation();        assertEquals("Unknown", di.getAuthor());        assertEquals("C:REGULA~1IREGSFR_EQ_EM.WP", di.getCreator());        assertEquals("Acrobat PDFWriter 3.02 for Windows", di.getProducer());        assertEquals("", di.getKeywords());        assertEquals("", di.getSubject());        assertEquals("C:REGULA~1IREGSFR_EQ_EM.PDF", di.getTitle());        assertEquals(DateConverter.toCalendar("Tuesday, July 28, 1998 4:00:09 PM"), di.getCreationDate());    }}
public void pdfbox_f8089_0() throws IOException
{    PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-3783-72GLBIGUC6LB46ELZFBARRJTLN4RBSQM.pdf")).close();}
public void pdfbox_f8090_0() throws IOException
{    try (PDDocument doc = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-3785-202097.pdf"))) {        assertEquals(11, doc.getNumberOfPages());    }}
public void pdfbox_f8091_0() throws IOException
{    PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-3947-670064.pdf")).close();}
public void pdfbox_f8092_0() throws IOException
{    PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-3948-EUWO6SQS5TM4VGOMRD3FLXZHU35V2CP2.pdf")).close();}
public void pdfbox_f8093_0() throws IOException
{    PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-3949-MKFYUGZWS3OPXLLVU2Z4LWCTVA5WNOGF.pdf")).close();}
public void pdfbox_f8094_0() throws IOException
{    try (PDDocument doc = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-3950-23EGDHXSBBYQLKYOKGZUOVYVNE675PRD.pdf"))) {        assertEquals(4, doc.getNumberOfPages());        PDFRenderer renderer = new PDFRenderer(doc);        for (int i = 0; i < doc.getNumberOfPages(); ++i) {            try {                renderer.renderImage(i);            } catch (IOException ex) {                if (i == 3 && ex.getMessage().equals("Missing descendant font array")) {                    continue;                }                throw ex;            }        }    }}
public void pdfbox_f8095_0() throws IOException
{    try (PDDocument doc = PDDocument.load(new File(TARGETPDFDIR, "PDFBOX-3951-FIHUZWDDL2VGPOE34N6YHWSIGSH5LVGZ.pdf"))) {        assertEquals(143, doc.getNumberOfPages());    }}
