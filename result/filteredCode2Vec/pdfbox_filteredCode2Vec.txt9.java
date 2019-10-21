protected PDActionURI pdfbox_f9109_0()
{    PDActionURI action = new PDActionURI();    action.setURI("http://www.apache.org");    return action;}
public void pdfbox_f9110_0() throws Exception
{    PDAction action = createAction();    valid(action, true);}
public void pdfbox_f9111_0() throws Exception
{    PDActionURI action = new PDActionURI();    valid(action, false, PreflightConstants.ERROR_ACTION_MISING_KEY);}
public void pdfbox_f9112_0() throws Exception
{    PDActionURI action = new PDActionURI();    action.getCOSObject().setBoolean(COSName.URI, true);    valid(action, false, PreflightConstants.ERROR_ACTION_INVALID_TYPE);}
public void pdfbox_f9113_0() throws Exception
{    PDActionURI action = createAction();    action.setNext(Arrays.asList(createAction()));    valid(action, true);}
public void pdfbox_f9114_0() throws Exception
{    PDActionURI action = createAction();    action.setNext(Arrays.asList(new PDActionJavaScript()));    valid(action, false, PreflightConstants.ERROR_ACTION_FORBIDDEN_ACTIONS_EXPLICITLY_FORBIDDEN);}
public static void pdfbox_f9115_0(String[] args) throws Exception
{    if (args.length < 3) {        System.err.println("Usage : Benchmark loop resultFile <file1 ... filen|dir>");        System.exit(255);    }    Integer loop = Integer.parseInt(args[0]);    FileWriter resFile = new FileWriter(new File(args[1]));    List<File> lfd = new ArrayList<>();    for (int i = 2; i < args.length; ++i) {        File fi = new File(args[i]);        if (fi.isDirectory()) {                        Collection<File> cf = FileUtils.listFiles(fi, null, true);            lfd.addAll(cf);        } else {            lfd.add(fi);        }    }    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.Z");    long startGTime = System.currentTimeMillis();    int size = lfd.size();    for (int i = 0; i < loop; i++) {        File file = lfd.get(i % size);        long startLTime = System.currentTimeMillis();        PreflightParser parser = new PreflightParser(file);        parser.parse();        try (PreflightDocument document = parser.getPreflightDocument()) {            document.validate();            ValidationResult result = document.getResult();            if (!result.isValid()) {                resFile.write(file.getAbsolutePath() + " isn't PDF/A\n");                for (ValidationError error : result.getErrorsList()) {                    resFile.write(error.getErrorCode() + " : " + error.getDetails() + "\n");                }            }        }        long endLTime = System.currentTimeMillis();        resFile.write(file.getName() + " (ms) : " + (endLTime - startLTime) + "\n");        resFile.flush();    }    long endGTime = System.currentTimeMillis();    resFile.write("Start : " + sdf.format(new Date(startGTime)) + "\n");    resFile.write("End : " + sdf.format(new Date(endGTime)) + "\n");    resFile.write("Duration (ms) : " + (endGTime - startGTime) + "\n");    resFile.write("Average (ms) : " + (int) ((endGTime - startGTime) / loop) + "\n");    System.out.println("Start : " + sdf.format(new Date(startGTime)));    System.out.println("End : " + sdf.format(new Date(endGTime)));    System.out.println("Duration (ms) : " + (endGTime - startGTime));    System.out.println("Average (ms) : " + (int) ((endGTime - startGTime) / loop));    resFile.flush();    IOUtils.closeQuietly(resFile);}
public final void pdfbox_f9116_1() throws Exception
{    if (path == null) {                return;    }    PreflightDocument document = null;    try {        PreflightParser parser = new PreflightParser(path);        parser.parse();        document = parser.getPreflightDocument();        document.validate();        ValidationResult result = document.getResult();        Assert.assertFalse(path + " : Isartor file should be invalid (" + path + ")", result.isValid());        Assert.assertTrue(path + " : Should find at least one error", result.getErrorsList().size() > 0);                boolean found = false;        if (this.expectedError != null) {            for (ValidationError error : result.getErrorsList()) {                if (error.getErrorCode().equals(this.expectedError)) {                    found = true;                    if (outputResult == null) {                        break;                    }                }                if (outputResult != null) {                    String log = path.getName().replace(".pdf", "") + "#" + error.getErrorCode() + "#" + error.getDetails() + "\n";                    outputResult.write(log.getBytes());                }            }        }        if (result.getErrorsList().size() > 0) {            if (this.expectedError == null) {                            } else if (!found) {                StringBuilder message = new StringBuilder(100);                message.append(path).append(" : Invalid error code returned. Expected ");                message.append(this.expectedError).append(", found ");                for (ValidationError error : result.getErrorsList()) {                    message.append(error.getErrorCode()).append(" ");                }                Assert.fail(message.toString());            }        } else {            Assert.assertEquals(path + " : Invalid error code returned.", this.expectedError, result.getErrorsList().get(0).getErrorCode());        }    } catch (ValidationException e) {        throw new Exception(path + " :" + e.getMessage(), e);    } finally {        if (document != null) {            document.close();        }    }}
public void pdfbox_f9117_0() throws Exception
{    String irp = System.getProperty(getResultFileKey());    if (irp == null) {                outputResult = System.err;    } else {        outputResult = new FileOutputStream(irp);    }}
public void pdfbox_f9118_0() throws Exception
{    IOUtils.closeQuietly(outputResult);}
protected static Collection<Object[]> pdfbox_f9119_0() throws Exception
{    List<Object[]> ret = new ArrayList<>();    ret.add(new Object[] { null, null });    return ret;}
protected String pdfbox_f9121_0()
{    return RESULTS_FILE;}
protected static Collection<Object[]> pdfbox_f9122_0() throws Exception
{    List<Object[]> ret = new ArrayList<>();    ret.add(new Object[] { null, null });    return ret;}
protected String pdfbox_f9124_0()
{    return RESULTS_FILE;}
protected static Collection<Object[]> pdfbox_f9125_0() throws Exception
{        List<Object[]> ret = new ArrayList<>();    ret.add(new Object[] { null });    return ret;}
public static void pdfbox_f9127_0() throws Exception
{    String irp = System.getProperty(RESULTS_FILE);    if (irp == null) {                System.err.println("No result file defined, will use standard error");        isartorResultFile = System.err;    } else {        isartorResultFile = new FileOutputStream(irp);    }}
public static void pdfbox_f9128_0() throws Exception
{    IOUtils.closeQuietly(isartorResultFile);}
public void pdfbox_f9129_1() throws Exception
{    if (path == null) {                return;    }    PreflightDocument document = null;    try {        PreflightParser parser = new PreflightParser(path);        parser.parse();        document = parser.getPreflightDocument();        document.validate();        ValidationResult result = document.getResult();        Assert.assertFalse(path + " : Isartor file should be invalid (" + path + ")", result.isValid());        Assert.assertTrue(path + " : Should find at least one error", result.getErrorsList().size() > 0);                if (result.getErrorsList().size() > 0) {            Assert.fail("File expected valid : " + path.getAbsolutePath());        }    } catch (ValidationException e) {        throw new Exception(path + " :" + e.getMessage(), e);    } finally {        if (document != null) {            document.close();        }    }}
public void pdfbox_f9130_0() throws Exception
{    String testfileDirectory = "src/test/resources/org/apache/pdfbox/preflight/metadata/";    File validFile = new File(testfileDirectory + "PDFAMetaDataValidationTestTrailingNul.pdf");    assertTrue("Metadata test file " + validFile + " has to be valid ", checkPDF(validFile));    File invalidFile1 = new File(testfileDirectory + "PDFAMetaDataValidationTestTrailingSpaces.pdf");    assertFalse("Metadata test file " + invalidFile1 + " has to be invalid ", checkPDF(invalidFile1));    File invalidFile2 = new File(testfileDirectory + "PDFAMetaDataValidationTestTrailingControlChar.pdf");    assertFalse("Metadata test file " + invalidFile2 + " has to be invalid ", checkPDF(invalidFile2));    File invalidFile3 = new File(testfileDirectory + "PDFAMetaDataValidationTestMiddleNul.pdf");    assertFalse("Metadata test file " + invalidFile3 + " has to be invalid ", checkPDF(invalidFile3));    File invalidFile4 = new File(testfileDirectory + "PDFAMetaDataValidationTestMiddleControlChar.pdf");    assertFalse("Metadata test file " + invalidFile4 + " has to be invalid ", checkPDF(invalidFile4));}
private boolean pdfbox_f9131_0(File pdf)
{    PreflightDocument document = null;    boolean testResult = false;    if (pdf.exists()) {        ValidationResult result = null;        try {            PreflightParser parser = new PreflightParser(pdf);            parser.parse();            document = (PreflightDocument) parser.getPDDocument();            document.validate();            result = document.getResult();        } catch (SyntaxValidationException e) {            result = e.getResult();        } catch (IOException e) {            fail("An exception occured while parsing the PDF " + pdf + ": " + e);        }        if (result != null) {            testResult = result.isValid();        }        if (document != null) {            try {                document.close();            } catch (IOException e) {                        }        }    } else {        fail("Can't find the given file " + pdf);    }    return testResult;}
public static void pdfbox_f9132_0()
{    sync = new SynchronizedMetaDataValidation();}
public void pdfbox_f9133_0() throws Exception
{    doc = new PDDocument();    dico = doc.getDocumentInformation();    metadata = XMPMetadata.createXMPMetadata();}
public void pdfbox_f9134_0() throws ValidationException
{    sync.validateMetadataSynchronization(null, metadata);}
public void pdfbox_f9135_0() throws ValidationException
{    sync.validateMetadataSynchronization(doc, null);}
public void pdfbox_f9136_0() throws Exception
{    try {        ve = sync.validateMetadataSynchronization(doc, metadata);                Assert.assertEquals(0, ve.size());    } catch (ValidationException e) {        throw new Exception(e.getMessage());    }}
public void pdfbox_f9137_0() throws Exception
{    initValues();            dico.setTitle(title);        dico.setAuthor(author);        dico.setSubject(subject);        dico.setKeywords(keywords);        dico.setCreator(creator);        dico.setProducer(producer);        dico.setCreationDate(creationDate);        dico.setModificationDate(modifyDate);    try {        ve = sync.validateMetadataSynchronization(doc, metadata);                for (ValidationError valid : ve) {            Assert.assertEquals(PreflightConstants.ERROR_METADATA_MISMATCH, valid.getErrorCode());        }    } catch (ValidationException e) {        throw new Exception(e.getMessage());    }}
public void pdfbox_f9138_0() throws Exception
{    initValues();        metadata.createAndAddDublinCoreSchema();    metadata.createAndAddAdobePDFSchema();    metadata.createAndAddXMPBasicSchema();            dico.setTitle(title);        dico.setAuthor(author);        dico.setSubject(subject);        dico.setKeywords(keywords);        dico.setCreator(creator);        dico.setProducer(producer);        dico.setCreationDate(creationDate);        dico.setModificationDate(modifyDate);    try {        ve = sync.validateMetadataSynchronization(doc, metadata);                Assert.assertEquals(8, ve.size());    } catch (ValidationException e) {        throw new Exception(e.getMessage());    }}
public void pdfbox_f9139_0() throws Exception
{        DublinCoreSchema dc = metadata.createAndAddDublinCoreSchema();        dico.setAuthor("dicoAuthor");    dc.addCreator(null);        dico.setSubject("dicoSubj");    dc.addSubject(null);        try {        ve = sync.validateMetadataSynchronization(doc, metadata);                Assert.assertEquals(2, ve.size());    } catch (ValidationException e) {        throw new Exception(e.getMessage());    }}
public void pdfbox_f9140_0() throws Exception
{        DublinCoreSchema dc = metadata.createAndAddDublinCoreSchema();    AdobePDFSchema pdf = metadata.createAndAddAdobePDFSchema();    XMPBasicSchema xmp = metadata.createAndAddXMPBasicSchema();            dico.setTitle("dicoTitle");    dc.setTitle("x-default", "XMPTitle");        dico.setAuthor("dicoAuthor");    dc.addCreator("XMPAuthor");    dc.addCreator("2ndCreator");        dico.setSubject("dicoSubj");    dc.addSubject("XMPSubj");    dc.addSubject("2ndSubj");        dico.setKeywords("DicoKeywords");    pdf.setKeywords("XMPkeywords");        dico.setCreator("DicoCreator");    xmp.setCreatorTool("XMPCreator");        dico.setProducer("DicoProducer");    pdf.setProducer("XMPProducer");        dico.setCreationDate(Calendar.getInstance());    GregorianCalendar XMPCreate = new GregorianCalendar(2008, 11, 05);    xmp.setCreateDate(XMPCreate);        dico.setModificationDate(Calendar.getInstance());    GregorianCalendar XMPModify = new GregorianCalendar(2009, 10, 15);    xmp.setModifyDate(XMPModify);        try {        ve = sync.validateMetadataSynchronization(doc, metadata);                Assert.assertEquals(8, ve.size());    } catch (ValidationException e) {        throw new Exception(e.getMessage());    }}
public void pdfbox_f9141_0() throws Exception
{        DublinCoreSchema dc = metadata.createAndAddDublinCoreSchema();    AdobePDFSchema pdf = metadata.createAndAddAdobePDFSchema();    XMPBasicSchema xmp = metadata.createAndAddXMPBasicSchema();            dico.setTitle("dicoTitle");    dc.setTitle("x-default", "XMPTitle");        dico.setAuthor("dicoAuthor");    dc.addCreator("XMPAuthor");        dico.setSubject("dicoSubj");    dc.addSubject("XMPSubj");        dico.setKeywords("DicoKeywords");    pdf.setKeywords("XMPkeywords");        dico.setCreator("DicoCreator");    xmp.setCreatorTool("XMPCreator");        dico.setProducer("DicoProducer");    pdf.setProducer("XMPProducer");        dico.setCreationDate(Calendar.getInstance());    GregorianCalendar XMPCreate = new GregorianCalendar(2008, 11, 05);    xmp.setCreateDate(XMPCreate);        dico.setModificationDate(Calendar.getInstance());    GregorianCalendar XMPModify = new GregorianCalendar(2009, 10, 15);    xmp.setModifyDate(XMPModify);        try {        ve = sync.validateMetadataSynchronization(doc, metadata);                Assert.assertEquals(8, ve.size());    } catch (ValidationException e) {        throw new Exception(e.getMessage());    }}
public void pdfbox_f9142_0() throws Exception
{    initValues();        DublinCoreSchema dc = metadata.createAndAddDublinCoreSchema();    XMPBasicSchema xmp = metadata.createAndAddXMPBasicSchema();    AdobePDFSchema pdf = metadata.createAndAddAdobePDFSchema();            dico.setTitle(title);    dc.setTitle("x-default", title);        dico.setAuthor(author);    dc.addCreator(author);        dico.setSubject(subject);    dc.addDescription("x-default", subject);        dico.setKeywords(keywords);    pdf.setKeywords(keywords);        dico.setCreator(creator);    xmp.setCreatorTool(creator);        dico.setProducer(producer);    pdf.setProducer(producer);        dico.setCreationDate(creationDate);    xmp.setCreateDate(creationDate);        dico.setModificationDate(modifyDate);    xmp.setModifyDate(modifyDate);        try {        ve = sync.validateMetadataSynchronization(doc, metadata);                Assert.assertEquals(0, ve.size());    } catch (ValidationException e) {        throw new Exception(e.getMessage());    }}
public void pdfbox_f9143_0() throws Exception
{    Throwable cause = new Throwable();    Assert.assertSame(cause, sync.schemaAccessException("test", cause).getCause());}
public void pdfbox_f9144_0() throws Exception
{    initValues();        DublinCoreSchema dc = new DublinCoreSchema(metadata, "dctest");    metadata.addSchema(dc);    XMPBasicSchema xmp = new XMPBasicSchema(metadata, "xmptest");    metadata.addSchema(xmp);    AdobePDFSchema pdf = new AdobePDFSchema(metadata, "pdftest");    metadata.addSchema(pdf);            dico.setTitle(title);    dc.setTitle("x-default", title);        dico.setAuthor(author);    dc.addCreator(author);        dico.setSubject(subject);    dc.addDescription("x-default", subject);        dico.setKeywords(keywords);    pdf.setKeywords(keywords);        dico.setCreator(creator);    xmp.setCreatorTool(creator);        dico.setProducer(producer);    pdf.setProducer(producer);        dico.setCreationDate(creationDate);    xmp.setCreateDate(creationDate);        dico.setModificationDate(modifyDate);    xmp.setModifyDate(modifyDate);        try {        ve = sync.validateMetadataSynchronization(doc, metadata);        for (ValidationError valid : ve) {            Assert.assertEquals(PreflightConstants.ERROR_METADATA_WRONG_NS_PREFIX, valid.getErrorCode());        }    } catch (ValidationException e) {        throw new Exception(e.getMessage());    }}
public void pdfbox_f9145_0() throws Exception
{    initValues();        DublinCoreSchema dc = metadata.createAndAddDublinCoreSchema();    DublinCoreSchema dc2 = new DublinCoreSchema(metadata, "dctest");    metadata.addSchema(dc2);    XMPBasicSchema xmp = metadata.createAndAddXMPBasicSchema();    XMPBasicSchema xmp2 = new XMPBasicSchema(metadata, "xmptest");    metadata.addSchema(xmp2);    AdobePDFSchema pdf = metadata.createAndAddAdobePDFSchema();    AdobePDFSchema pdf2 = new AdobePDFSchema(metadata, "pdftest");    metadata.addSchema(pdf2);        dc2.setCoverage("tmpcover");    xmp2.setCreatorTool("tmpcreator");    pdf2.setKeywords("tmpkeys");            dico.setTitle(title);    dc.setTitle("x-default", title);        dico.setAuthor(author);    dc.addCreator(author);        dico.setSubject(subject);    dc.addDescription("x-default", subject);        dico.setKeywords(keywords);    pdf.setKeywords(keywords);        dico.setCreator(creator);    xmp.setCreatorTool(creator);        dico.setProducer(producer);    pdf.setProducer(producer);        dico.setCreationDate(creationDate);    xmp.setCreateDate(creationDate);        dico.setModificationDate(modifyDate);    xmp.setModifyDate(modifyDate);        try {        ve = sync.validateMetadataSynchronization(doc, metadata);        Assert.assertTrue(ve.isEmpty());    } catch (ValidationException e) {        throw new Exception(e.getMessage());    }}
public void pdfbox_f9146_0() throws Exception
{    initValues();    Calendar cal1 = org.apache.pdfbox.util.DateConverter.toCalendar("20180817115837+02'00'");    Calendar cal2 = org.apache.xmpbox.DateConverter.toCalendar("2018-08-17T09:58:37Z");    XMPBasicSchema xmp = metadata.createAndAddXMPBasicSchema();    dico.setCreationDate(cal1);    xmp.setCreateDate(cal2);    dico.setModificationDate(cal1);    xmp.setModifyDate(cal2);        try {        ve = sync.validateMetadataSynchronization(doc, metadata);                Assert.assertEquals(0, ve.size());    } catch (ValidationException e) {        throw new Exception(e.getMessage());    }}
public void pdfbox_f9147_0() throws Exception
{    try {        doc.close();    } catch (IOException e) {        throw new Exception("Error while closing PDF Document");    }/*         * Iterator<ValidationError> it=ve.iterator(); while(it.hasNext()){ ValidationError tmp=it.next();         * System.out.println("Error:"+ tmp.getDetails()+"\n code: "+tmp.getErrorCode()); }         */}
private void pdfbox_f9148_0()
{    title = "TITLE";    author = "AUTHOR(S)";    subject = "SUBJECTS";    keywords = "KEYWORD(S)";    creator = "CREATOR";    producer = "PRODUCER";    creationDate = Calendar.getInstance();    modifyDate = Calendar.getInstance();                creationDate.set(Calendar.MILLISECOND, 0);    modifyDate.set(Calendar.MILLISECOND, 0);}
public void pdfbox_f9149_0() throws Exception
{    PreflightConfiguration configuration = PreflightConfiguration.createPdfA1BConfiguration();    configuration.getInstanceOfProcess("unknownProcess");}
public void pdfbox_f9150_0() throws Exception
{    PreflightConfiguration configuration = PreflightConfiguration.createPdfA1BConfiguration();    configuration.setErrorOnMissingProcess(false);    configuration.getInstanceOfProcess("unknownProcess");}
public void pdfbox_f9151_0() throws Exception
{    PreflightConfiguration configuration = PreflightConfiguration.createPdfA1BConfiguration();    String processName = "mock-process";    configuration.replaceProcess(processName, MockProcess.class);    assertEquals(MockProcess.class, configuration.getInstanceOfProcess(processName).getClass());    configuration.replaceProcess(processName, MockProcess2.class);    assertEquals(MockProcess2.class, configuration.getInstanceOfProcess(processName).getClass());}
public void pdfbox_f9154_0() throws Exception
{    document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();    preflight = parser.generateResponseSkeleton(document, "myname", 14);    xpath = XPathFactory.newInstance().newXPath();}
public void pdfbox_f9155_0() throws Exception
{    ValidationResult result = new ValidationResult(false);    result.addError(new ValidationResult.ValidationError("7"));    parser.createResponseWithError(document, "pdftype", result, preflight);    Assert.assertNotNull(xpath.evaluate("errors[@count='1']", preflight, XPathConstants.NODE));    NodeList nl = (NodeList) xpath.evaluate("errors/error[@count='1']", preflight, XPathConstants.NODESET);    Assert.assertEquals(1, nl.getLength());}
public void pdfbox_f9156_0() throws Exception
{    ValidationResult result = new ValidationResult(false);    result.addError(new ValidationResult.ValidationError("7"));    result.addError(new ValidationResult.ValidationError(ERROR_CODE));    parser.createResponseWithError(document, "pdftype", result, preflight);    Assert.assertNotNull(xpath.evaluate("errors[@count='2']", preflight, XPathConstants.NODE));    NodeList nl = (NodeList) xpath.evaluate("errors/error[@count='1']", preflight, XPathConstants.NODESET);    Assert.assertEquals(2, nl.getLength());}
public void pdfbox_f9157_0() throws Exception
{    ValidationResult result = new ValidationResult(false);    result.addError(new ValidationResult.ValidationError(ERROR_CODE));    result.addError(new ValidationResult.ValidationError(ERROR_CODE));    parser.createResponseWithError(document, "pdftype", result, preflight);    Assert.assertNotNull(xpath.evaluate("errors[@count='2']", preflight, XPathConstants.NODE));    Assert.assertNotNull(xpath.evaluate("errors/error[@count='2']", preflight, XPathConstants.NODE));    Element code = (Element) xpath.evaluate("errors/error[@count='2']/code", preflight, XPathConstants.NODE);    Assert.assertNotNull(code);    Assert.assertEquals(ERROR_CODE, code.getTextContent());}
public void pdfbox_f9158_0() throws Exception
{    ValidationResult result = new ValidationResult(false);    result.addError(new ValidationResult.ValidationError(ERROR_CODE, "message 1"));    result.addError(new ValidationResult.ValidationError(ERROR_CODE, "message 2"));    parser.createResponseWithError(document, "pdftype", result, preflight);    Assert.assertNotNull(xpath.evaluate("errors[@count='2']", preflight, XPathConstants.NODE));    NodeList nl = (NodeList) xpath.evaluate("errors/error[@count='1']", preflight, XPathConstants.NODESET);    Assert.assertEquals(2, nl.getLength());}
public void pdfbox_f9159_0() throws Exception
{    PreflightDocument document = null;    System.out.println(target);    ValidationResult result = null;    try {        PreflightParser parser = new PreflightParser(target);        parser.parse();        document = (PreflightDocument) parser.getPDDocument();        document.validate();        result = document.getResult();    } catch (SyntaxValidationException e) {        result = e.getResult();    } finally {        if (document != null) {            document.close();        }    }    Assert.assertFalse("Test of " + target, result.isValid());}
public static Collection<Object[]> pdfbox_f9160_0() throws Exception
{        File directory = null;    String pdfPath = System.getProperty("pdfa.invalid", null);    if ("${user.pdfa.invalid}".equals(pdfPath)) {        pdfPath = null;    }    if (pdfPath != null) {        directory = new File(pdfPath);        if (!directory.exists())            throw new Exception("directory does not exists : " + directory.getAbsolutePath());        if (!directory.isDirectory())            throw new Exception("not a directory : " + directory.getAbsolutePath());    } else {        System.err.println("System property 'pdfa.invalid' not defined, will not run TestValidaDirectory");    }        if (directory == null) {        return new ArrayList<>(0);    } else {        File[] files = directory.listFiles();        List<Object[]> data = new ArrayList<>(files.length);        for (File file : files) {            if (file.isFile()) {                data.add(new Object[] { file });            }        }        return data;    }}
public static Collection<Object[]> pdfbox_f9161_0() throws Exception
{    String filter = System.getProperty(FILTER_FILE);    String skipBavaria = System.getProperty(SKIP_BAVARIA);        File f = new File("src/test/resources/expected_errors.txt");    InputStream expected = new FileInputStream(f);    Properties props = new Properties();    props.load(expected);    IOUtils.closeQuietly(expected);        List<Object[]> data = new ArrayList<>();    File isartor = new File("target/pdfs/Isartor testsuite/PDFA-1b");    if (isartor.isDirectory()) {        Collection<?> pdfFiles = FileUtils.listFiles(isartor, new String[] { "pdf", "PDF" }, true);        for (Object pdfFile : pdfFiles) {            String fn = ((File) pdfFile).getName();            if (filter == null || fn.contains(filter)) {                String path = props.getProperty(fn);                String error = new StringTokenizer(path, "//").nextToken().trim();                String[] errTab = error.split(",");                Set<String> errorSet = new HashSet<>(Arrays.asList(errTab));                data.add(new Object[] { pdfFile, errorSet });            }        }    } else {        fail("Isartor data set has not been downloaded! Try running Maven?");    }    if ("false".equals(skipBavaria)) {        File bavaria = new File("target/pdfs/Bavaria testsuite");        if (bavaria.isDirectory()) {            Collection<?> pdfFiles = FileUtils.listFiles(bavaria, new String[] { "pdf", "PDF" }, true);            for (Object pdfFile : pdfFiles) {                String fn = ((File) pdfFile).getName();                if (filter == null || fn.contains(filter)) {                    String path = props.getProperty(fn);                    Set<String> errorSet = new HashSet<>();                    if (!path.isEmpty()) {                        String error = new StringTokenizer(path, "//").nextToken().trim();                        errorSet.addAll(Arrays.asList(error.split(",")));                    }                    data.add(new Object[] { pdfFile, errorSet });                }            }        } else {            fail("Bavaria data set has not been downloaded! Try running Maven?");        }    } else {        System.out.println("Bavaria tests are skipped. You can enable them in Maven with -Dskip-bavaria=false");        System.out.println("About the tests: http://www.pdflib.com/knowledge-base/pdfa/validation-report/");    }    return data;}
public static void pdfbox_f9162_0() throws Exception
{    String irp = System.getProperty("isartor.results.path");    if (irp != null) {        File f = new File(irp);        if (f.exists() && f.isFile()) {            f.delete();            isartorResultFile = new FileOutputStream(f);        } else if (!f.exists()) {            isartorResultFile = new FileOutputStream(f);        } else {            throw new IllegalArgumentException("Invalid result file : " + irp);        }    }}
public static void pdfbox_f9163_0() throws Exception
{    if (isartorResultFile != null) {        IOUtils.closeQuietly(isartorResultFile);    }}
public void pdfbox_f9164_0() throws Exception
{    PreflightDocument document = null;    try {        ValidationResult result;        try {            PreflightParser parser = new PreflightParser(file);            parser.parse();            document = (PreflightDocument) parser.getPDDocument();                        if (document.getNumberOfPages() < 8191) {                document.validate();            }            result = document.getResult();        } catch (SyntaxValidationException e) {            result = e.getResult();        }        if (this.expectedErrorSet.isEmpty()) {            Set<String> errorSet = new HashSet<>();            for (ValidationError error : result.getErrorsList()) {                errorSet.add(error.getErrorCode());            }            StringBuilder message = new StringBuilder();            message.append(file.getName());            message.append(" : PDF/A file should be valid, but has error");            if (errorSet.size() > 1) {                message.append('s');            }            message.append(':');            for (String errMsg : errorSet) {                message.append(' ');                message.append(errMsg);            }            assertTrue(message.toString(), result.isValid());            assertTrue(message.toString(), result.getErrorsList().isEmpty());        } else {            assertFalse(file.getName() + " : PDF/A file should be invalid (expected " + this.expectedErrorSet + ")",             result.isValid());            assertTrue(file.getName() + " : Should find at least one error", result.getErrorsList().size() > 0);                        boolean logged = false;            boolean allFound = true;            for (String expectedError : this.expectedErrorSet) {                boolean oneFound = false;                for (ValidationError error : result.getErrorsList()) {                    if (error.getErrorCode().equals(expectedError)) {                        oneFound = true;                    }                    if (isartorResultFile != null && !logged) {                        String log = file.getName().replace(".pdf", "") + "#" + error.getErrorCode() + "#" + error.getDetails() + "\n";                        isartorResultFile.write(log.getBytes());                    }                }                if (!oneFound) {                    allFound = false;                    break;                }                                logged = true;            }            if (!allFound) {                Set<String> errorSet = new HashSet<>();                for (ValidationError error : result.getErrorsList()) {                    errorSet.add(error.getErrorCode());                }                StringBuilder message = new StringBuilder();                for (String errMsg : errorSet) {                    if (message.length() > 0) {                        message.append(", ");                    }                    message.append(errMsg);                }                fail(String.format("%s : Invalid error code returned. Expected %s, found [%s]", file.getName(), expectedErrorSet, message.toString().trim()));            }                }    } finally {        if (document != null) {            document.close();        }    }}
public void pdfbox_f9165_0() throws IOException
{    PreflightParser parser = new PreflightParser(new File("src/test/resources/PDFBOX-3741.pdf"));    parser.parse();    ValidationResult result;    try (PreflightDocument document = parser.getPreflightDocument()) {        document.validate();        result = document.getResult();    }            Assert.assertFalse("File PDFBOX-3741.pdf should be detected as not PDF/A-1b", result.isValid());    Assert.assertEquals("List should contain one result", 1, result.getErrorsList().size());    Assert.assertEquals("2.4.3", result.getErrorsList().get(0).getErrorCode());}
public void pdfbox_f9166_0() throws Exception
{    PreflightConfiguration confg = PreflightConfiguration.createPdfA1BConfiguration();    ValidationProcess vp = confg.getInstanceOfProcess(PreflightConfiguration.BOOKMARK_PROCESS);    Assert.assertNotNull(vp);    Assert.assertTrue(vp instanceof BookmarkValidationProcess);}
public void pdfbox_f9167_0() throws Exception
{    PreflightConfiguration confg = PreflightConfiguration.createPdfA1BConfiguration();    ValidationProcess vp = confg.getInstanceOfProcess(PreflightConfiguration.RESOURCES_PROCESS);    Assert.assertNotNull(vp);    Assert.assertTrue(vp instanceof ResourcesValidationProcess);}
public void pdfbox_f9168_0() throws Exception
{    PreflightConfiguration confg = PreflightConfiguration.createPdfA1BConfiguration();    confg.setErrorOnMissingProcess(false);    confg.removeProcess(PreflightConfiguration.BOOKMARK_PROCESS);    ValidationProcess vp = confg.getInstanceOfProcess(PreflightConfiguration.BOOKMARK_PROCESS);    Assert.assertNotNull(vp);    Assert.assertTrue(vp instanceof EmptyValidationProcess);}
public void pdfbox_f9169_0() throws Exception
{    PreflightConfiguration confg = PreflightConfiguration.createPdfA1BConfiguration();    confg.setErrorOnMissingProcess(false);    confg.removePageProcess(PreflightConfiguration.RESOURCES_PROCESS);    ValidationProcess vp = confg.getInstanceOfProcess(PreflightConfiguration.RESOURCES_PROCESS);    Assert.assertNotNull(vp);    Assert.assertTrue(vp instanceof EmptyValidationProcess);}
public void pdfbox_f9170_0() throws Exception
{    PreflightConfiguration confg = PreflightConfiguration.createPdfA1BConfiguration();    confg.removeProcess(PreflightConfiguration.BOOKMARK_PROCESS);    confg.getInstanceOfProcess(PreflightConfiguration.BOOKMARK_PROCESS);    Assert.fail();}
public void pdfbox_f9171_0() throws Exception
{    PreflightConfiguration confg = PreflightConfiguration.createPdfA1BConfiguration();    confg.removePageProcess(PreflightConfiguration.RESOURCES_PROCESS);    confg.getInstanceOfProcess(PreflightConfiguration.RESOURCES_PROCESS);    Assert.fail();}
public void pdfbox_f9172_0() throws Exception
{    PreflightConfiguration confg = PreflightConfiguration.createPdfA1BConfiguration();    confg.replaceProcess(PreflightConfiguration.BOOKMARK_PROCESS, null);    confg.getInstanceOfProcess(PreflightConfiguration.BOOKMARK_PROCESS);    Assert.fail();}
public void pdfbox_f9173_0() throws Exception
{    PreflightConfiguration confg = PreflightConfiguration.createPdfA1BConfiguration();    confg.replacePageProcess(PreflightConfiguration.RESOURCES_PROCESS, null);    confg.getInstanceOfProcess(PreflightConfiguration.RESOURCES_PROCESS);    Assert.fail();}
public void pdfbox_f9174_0()
{    PreflightPath path = new PreflightPath();    assertTrue(path.isEmpty());    assertEquals(0, path.size());    path.pushObject("a");    assertEquals(1, path.size());    assertFalse(path.isEmpty());    int position = path.getClosestTypePosition(String.class);    assertEquals(0, position);    path.pushObject(6);    assertEquals(2, path.size());    position = path.getClosestTypePosition(String.class);    assertEquals(0, position);    position = path.getClosestTypePosition(Integer.class);    assertEquals(1, position);    path.pushObject("b");    assertEquals(3, path.size());    position = path.getClosestTypePosition(String.class);    assertEquals(2, position);    position = path.getClosestTypePosition(Integer.class);    assertEquals(1, position);    Integer i = path.getPathElement(position, Integer.class);    assertEquals(Integer.valueOf(6), i);    Object str = path.peek();    assertEquals(3, path.size());    assertEquals(String.class, str.getClass());    assertEquals("b", str);    str = path.pop();    assertEquals(2, path.size());    assertEquals(String.class, str.getClass());    assertEquals("b", str);    path.clear();    assertTrue(path.isEmpty());    assertEquals(0, path.size());}
public void pdfbox_f9175_0()
{    PreflightPath path = new PreflightPath();    assertTrue(path.pushObject("a"));    assertFalse(path.pushObject(null));}
public void pdfbox_f9176_0() throws Exception
{    PreflightDocument document = null;    System.out.println(target);    ValidationResult result = null;    try {        PreflightParser parser = new PreflightParser(target);        parser.parse();        document = (PreflightDocument) parser.getPDDocument();        document.validate();        result = document.getResult();    } catch (SyntaxValidationException e) {        result = e.getResult();    } finally {        if (document != null) {            document.close();        }    }    Assert.assertTrue("Validation of " + target, result.isValid());}
public static Collection<Object[]> pdfbox_f9177_0() throws Exception
{        File directory = null;    String pdfPath = System.getProperty("pdfa.valid", null);    if ("${user.pdfa.valid}".equals(pdfPath)) {        pdfPath = null;    }    if (pdfPath != null) {        directory = new File(pdfPath);        if (!directory.exists())            throw new Exception("directory does not exists : " + directory.getAbsolutePath());        if (!directory.isDirectory())            throw new Exception("not a directory : " + directory.getAbsolutePath());    } else {        System.err.println("System property 'pdfa.valid' not defined, will not run TestValidaDirectory");    }        if (directory == null) {        return new ArrayList<>(0);    } else {        File[] files = directory.listFiles();        List<Object[]> data = new ArrayList<>(files.length);        for (File file : files) {            if (file.isFile()) {                data.add(new Object[] { file });            }        }        return data;    }}
public static void pdfbox_f9178_0(String[] args)
{        System.setProperty("apple.awt.UIElement", "true");    if (args.length < 1) {        usage();    }    String inputFilename = args[0];    String outputFilename;    if (args.length > 1) {        outputFilename = args[1];    } else {        if (inputFilename.matches(".*\\.[pP][dD][fF]$")) {            outputFilename = inputFilename.replaceAll("\\.[pP][dD][fF]$", ".unc.pdf");        } else {            outputFilename = inputFilename + ".unc.pdf";        }    }    PDDocument doc = null;    try {        doc = PDDocument.load(new File(inputFilename));        for (COSObject objStream : doc.getDocument().getObjectsByType(COSName.OBJ_STM)) {            COSStream stream = (COSStream) objStream.getObject();            PDFObjectStreamParser sp = new PDFObjectStreamParser(stream, doc.getDocument());            sp.parse();            for (COSObject next : sp.getObjects()) {                COSObjectKey key = new COSObjectKey(next);                COSObject obj = doc.getDocument().getObjectFromPool(key);                obj.setObject(next.getObject());            }            doc.getDocument().removeObject(new COSObjectKey(objStream));        }        doc.save(outputFilename);    } catch (Exception e) {        System.err.println("Error processing file: " + e.getMessage());    } finally {        IOUtils.closeQuietly(doc);    }}
private static void pdfbox_f9179_0()
{    String message = "Usage: java -cp pdfbox-app-x.y.z.jar " + "org.apache.pdfbox.tools.DecompressObjectstreams <inputfile> [<outputfile>]\n" + "\nOptions:\n" + "  <inputfile>  : The PDF document to decompress\n" + "  <outputfile> : The output filename (default is to replace .pdf with .unc.pdf)";    System.err.println(message);    System.exit(1);}
public static void pdfbox_f9180_0(String[] args) throws IOException
{        System.setProperty("apple.awt.UIElement", "true");    Decrypt decrypt = new Decrypt();    decrypt.parseCommandLine(args);    decrypt.decrypt();}
private void pdfbox_f9181_0(String[] args)
{    Options options = defineOptions();    CommandLine commandLine = parseArguments(options, args);    this.alias = commandLine.getOptionValue(ALIAS);    this.password = commandLine.getOptionValue(PASSWORD, "");    this.keyStore = commandLine.getOptionValue(KEYSTORE);            List<String> fileNames = commandLine.getArgList();    if (fileNames.isEmpty() || fileNames.size() > 2) {        usage(options);    }    this.infile = fileNames.get(0);    if (fileNames.size() == 1) {        this.outfile = fileNames.get(0);    } else {        this.outfile = fileNames.get(1);    }}
private static Options pdfbox_f9182_0()
{    Options options = new Options();    options.addOption(Option.builder(ALIAS).hasArg().desc("The alias of the key in the certificate file (mandatory if several keys are available).").build());    options.addOption(Option.builder(PASSWORD).hasArg().desc("The password to open the certificate and extract the private key from it.").build());    options.addOption(Option.builder(KEYSTORE).hasArg().desc("The KeyStore that holds the certificate.").build());    return options;}
private static CommandLine pdfbox_f9183_0(Options options, String[] commandLineArguments)
{    CommandLineParser cmdLineParser = new DefaultParser();    CommandLine commandLine = null;    try {        commandLine = cmdLineParser.parse(options, commandLineArguments);    } catch (ParseException parseException) {        System.out.println(parseException.getMessage());        usage(options);    }    return commandLine;}
private void pdfbox_f9184_0() throws IOException
{    PDDocument document = null;    InputStream keyStoreStream = null;    try {        if (keyStore != null) {            keyStoreStream = new FileInputStream(keyStore);        }        document = PDDocument.load(new File(infile), password, keyStoreStream, alias);        if (document.isEncrypted()) {            AccessPermission ap = document.getCurrentAccessPermission();            if (ap.isOwnerPermission()) {                document.setAllSecurityToBeRemoved(true);                document.save(outfile);            } else {                throw new IOException("Error: You are only allowed to decrypt a document with the owner password.");            }        } else {            System.err.println("Error: Document is not encrypted.");        }    } finally {        if (document != null) {            document.close();        }        IOUtils.closeQuietly(keyStoreStream);    }}
private static void pdfbox_f9185_0(Options options)
{    HelpFormatter formatter = new HelpFormatter();    String syntax = "java -jar pdfbox-app-x.y.z.jar Decrypt [options] <inputfile> [outputfile]";    String header = "\nOptions";    formatter.setWidth(132);    formatter.printHelp(syntax, header, options, "");    System.exit(1);}
public static void pdfbox_f9186_0(String[] args) throws IOException, CertificateException
{        System.setProperty("apple.awt.UIElement", "true");    Encrypt encrypt = new Encrypt();    encrypt.encrypt(args);}
private void pdfbox_f9187_0(String[] args) throws IOException, CertificateException
{    if (args.length < 1) {        usage();    } else {        AccessPermission ap = new AccessPermission();        String infile = null;        String outfile = null;        String certFile = null;        @SuppressWarnings({ "squid:S2068" })        String userPassword = "";        @SuppressWarnings({ "squid:S2068" })        String ownerPassword = "";        int keyLength = 256;        PDDocument document = null;        try {            for (int i = 0; i < args.length; i++) {                String key = args[i];                if (key.equals("-O")) {                    ownerPassword = args[++i];                } else if (key.equals("-U")) {                    userPassword = args[++i];                } else if (key.equals("-canAssemble")) {                    ap.setCanAssembleDocument(args[++i].equalsIgnoreCase("true"));                } else if (key.equals("-canExtractContent")) {                    ap.setCanExtractContent(args[++i].equalsIgnoreCase("true"));                } else if (key.equals("-canExtractForAccessibility")) {                    ap.setCanExtractForAccessibility(args[++i].equalsIgnoreCase("true"));                } else if (key.equals("-canFillInForm")) {                    ap.setCanFillInForm(args[++i].equalsIgnoreCase("true"));                } else if (key.equals("-canModify")) {                    ap.setCanModify(args[++i].equalsIgnoreCase("true"));                } else if (key.equals("-canModifyAnnotations")) {                    ap.setCanModifyAnnotations(args[++i].equalsIgnoreCase("true"));                } else if (key.equals("-canPrint")) {                    ap.setCanPrint(args[++i].equalsIgnoreCase("true"));                } else if (key.equals("-canPrintDegraded")) {                    ap.setCanPrintDegraded(args[++i].equalsIgnoreCase("true"));                } else if (key.equals("-certFile")) {                    certFile = args[++i];                } else if (key.equals("-keyLength")) {                    try {                        keyLength = Integer.parseInt(args[++i]);                    } catch (NumberFormatException e) {                        throw new NumberFormatException("Error: -keyLength is not an integer '" + args[i] + "'");                    }                } else if (infile == null) {                    infile = key;                } else if (outfile == null) {                    outfile = key;                } else {                    usage();                }            }            if (infile == null) {                usage();            }            if (outfile == null) {                outfile = infile;            }            document = PDDocument.load(new File(infile));            if (!document.isEncrypted()) {                if (certFile != null) {                    PublicKeyProtectionPolicy ppp = new PublicKeyProtectionPolicy();                    PublicKeyRecipient recip = new PublicKeyRecipient();                    recip.setPermission(ap);                    CertificateFactory cf = CertificateFactory.getInstance("X.509");                    try (InputStream inStream = new FileInputStream(certFile)) {                        X509Certificate certificate = (X509Certificate) cf.generateCertificate(inStream);                        recip.setX509(certificate);                    }                    ppp.addRecipient(recip);                    ppp.setEncryptionKeyLength(keyLength);                    document.protect(ppp);                } else {                    StandardProtectionPolicy spp = new StandardProtectionPolicy(ownerPassword, userPassword, ap);                    spp.setEncryptionKeyLength(keyLength);                    document.protect(spp);                }                document.save(outfile);            } else {                System.err.println("Error: Document is already encrypted.");            }        } finally {            if (document != null) {                document.close();            }        }    }}
private static void pdfbox_f9188_0()
{    String message = "Usage: java -jar pdfbox-app-x.y.z.jar Encrypt [options] <inputfile> [outputfile]\n" + "\nOptions:\n" + "  -O <password>                            : Set the owner password (ignored if certFile is set)\n" + "  -U <password>                            : Set the user password (ignored if certFile is set)\n" + "  -certFile <path to cert>                 : Path to X.509 certificate\n" + "  -canAssemble <true|false>                : Set the assemble permission\n" + "  -canExtractContent <true|false>          : Set the extraction permission\n" + "  -canExtractForAccessibility <true|false> : Set the extraction permission\n" + "  -canFillInForm <true|false>              : Set the fill in form permission\n" + "  -canModify <true|false>                  : Set the modify permission\n" + "  -canModifyAnnotations <true|false>       : Set the modify annots permission\n" + "  -canPrint <true|false>                   : Set the print permission\n" + "  -canPrintDegraded <true|false>           : Set the print degraded permission\n" + "  -keyLength <length>                      : Key length in bits " + "(valid values: 40, 128 or 256, default is 256)\n" + "\nNote: By default all permissions are set to true!";    System.err.println(message);    System.exit(1);}
public static void pdfbox_f9189_0(String[] args) throws IOException
{        System.setProperty("apple.awt.UIElement", "true");    ExportFDF exporter = new ExportFDF();    exporter.exportFDF(args);}
private void pdfbox_f9190_0(String[] args) throws IOException
{    if (args.length != 1 && args.length != 2) {        usage();    } else {        try (PDDocument pdf = PDDocument.load(new File(args[0]))) {            PDAcroForm form = pdf.getDocumentCatalog().getAcroForm();            if (form == null) {                System.err.println("Error: This PDF does not contain a form.");            } else {                String fdfName = null;                if (args.length == 2) {                    fdfName = args[1];                } else {                    if (args[0].length() > 4) {                        fdfName = args[0].substring(0, args[0].length() - 4) + ".fdf";                    }                }                try (FDFDocument fdf = form.exportFDF()) {                    fdf.save(fdfName);                }            }        }    }}
private static void pdfbox_f9191_0()
{    String message = "Usage: org.apache.pdfbox.ExportFDF <inputfile> [output-fdf-file]\n" + "\nOptions:\n" + "  [output-fdf-file] : Default is pdf name, test.pdf->test.fdf";    System.err.println(message);    System.exit(1);}
public static void pdfbox_f9192_0(String[] args) throws IOException
{        System.setProperty("apple.awt.UIElement", "true");    ExportXFDF exporter = new ExportXFDF();    exporter.exportXFDF(args);}
private void pdfbox_f9193_0(String[] args) throws IOException
{    if (args.length != 1 && args.length != 2) {        usage();    } else {        try (PDDocument pdf = PDDocument.load(new File(args[0]))) {            PDAcroForm form = pdf.getDocumentCatalog().getAcroForm();            if (form == null) {                System.err.println("Error: This PDF does not contain a form.");            } else {                String fdfName = null;                if (args.length == 2) {                    fdfName = args[1];                } else {                    if (args[0].length() > 4) {                        fdfName = args[0].substring(0, args[0].length() - 4) + ".xfdf";                    }                }                try (FDFDocument fdf = form.exportFDF()) {                    fdf.saveXFDF(fdfName);                }            }        }    }}
private static void pdfbox_f9194_0()
{    String message = "Usage: org.apache.pdfbox.ExportXFDF <inputfile> [output-xfdf-file]\n" + "\nOptions:\n" + "  [output-xfdf-file] : Default is pdf name, test.pdf->test.xfdf";    System.err.println(message);    System.exit(1);}
public static void pdfbox_f9195_0(String[] args) throws IOException
{        System.setProperty("apple.awt.UIElement", "true");    ExtractImages extractor = new ExtractImages();    extractor.run(args);}
private void pdfbox_f9196_0(String[] args) throws IOException
{    if (args.length < 1 || args.length > 4) {        usage();    } else {        String pdfFile = null;        @SuppressWarnings({ "squid:S2068" })        String password = "";        for (int i = 0; i < args.length; i++) {            switch(args[i]) {                case PASSWORD:                    i++;                    if (i >= args.length) {                        usage();                    }                    password = args[i];                    break;                case PREFIX:                    i++;                    if (i >= args.length) {                        usage();                    }                    prefix = args[i];                    break;                case DIRECTJPEG:                    directJPEG = true;                    break;                default:                    if (pdfFile == null) {                        pdfFile = args[i];                    }                    break;            }        }        if (pdfFile == null) {            usage();        } else {            if (prefix == null && pdfFile.length() > 4) {                prefix = pdfFile.substring(0, pdfFile.length() - 4);            }            extract(pdfFile, password);        }    }}
private static void pdfbox_f9197_0()
{    String message = "Usage: java " + ExtractImages.class.getName() + " [options] <inputfile>\n" + "\nOptions:\n" + "  -password <password>   : Password to decrypt document\n" + "  -prefix <image-prefix> : Image prefix (default to pdf name)\n" + "  -directJPEG            : Forces the direct extraction of JPEG/JPX images " + "                           regardless of colorspace or masking\n" + "  <inputfile>            : The PDF document to use\n";    System.err.println(message);    System.exit(1);}
private void pdfbox_f9198_0(String pdfFile, String password) throws IOException
{    try (PDDocument document = PDDocument.load(new File(pdfFile), password)) {        AccessPermission ap = document.getCurrentAccessPermission();        if (!ap.canExtractContent()) {            throw new IOException("You do not have permission to extract images");        }        for (PDPage page : document.getPages()) {            ImageGraphicsEngine extractor = new ImageGraphicsEngine(page);            extractor.run();        }    }}
public void pdfbox_f9199_0() throws IOException
{    PDPage page = getPage();    processPage(page);    PDResources res = page.getResources();    for (COSName name : res.getExtGStateNames()) {        PDSoftMask softMask = res.getExtGState(name).getSoftMask();        if (softMask != null) {            PDTransparencyGroup group = softMask.getGroup();            if (group != null) {                                res.getExtGState(name).copyIntoGraphicsState(getGraphicsState());                processSoftMask(group);            }        }    }}
public void pdfbox_f9200_0(PDImage pdImage) throws IOException
{    if (pdImage instanceof PDImageXObject) {        if (pdImage.isStencil()) {            processColor(getGraphicsState().getNonStrokingColor());        }        PDImageXObject xobject = (PDImageXObject) pdImage;        if (seen.contains(xobject.getCOSObject())) {                        return;        }        seen.add(xobject.getCOSObject());    }        String name = prefix + "-" + imageCounter;    imageCounter++;    System.out.println("Writing image: " + name);    write2file(pdImage, name, directJPEG);}
public Point2D pdfbox_f9206_0() throws IOException
{    return new Point2D.Float(0, 0);}
protected void pdfbox_f9209_0(Matrix textRenderingMatrix, PDFont font, int code, String unicode, Vector displacement) throws IOException
{    RenderingMode renderingMode = getGraphicsState().getTextState().getRenderingMode();    if (renderingMode.isFill()) {        processColor(getGraphicsState().getNonStrokingColor());    }    if (renderingMode.isStroke()) {        processColor(getGraphicsState().getStrokingColor());    }}
public void pdfbox_f9210_0() throws IOException
{    processColor(getGraphicsState().getStrokingColor());}
public void pdfbox_f9211_0(int windingRule) throws IOException
{    processColor(getGraphicsState().getNonStrokingColor());}
public void pdfbox_f9212_0(int windingRule) throws IOException
{    processColor(getGraphicsState().getNonStrokingColor());}
private void pdfbox_f9214_0(PDColor color) throws IOException
{    if (color.getColorSpace() instanceof PDPattern) {        PDPattern pattern = (PDPattern) color.getColorSpace();        PDAbstractPattern abstractPattern = pattern.getPattern(color);        if (abstractPattern instanceof PDTilingPattern) {            processTilingPattern((PDTilingPattern) abstractPattern, null, null);        }    }}
private boolean pdfbox_f9215_0(PDImage pdImage) throws IOException
{    if (pdImage instanceof PDImageXObject) {        PDImageXObject ximg = (PDImageXObject) pdImage;        return ximg.getMask() != null || ximg.getSoftMask() != null;    }    return false;}
private void pdfbox_f9216_0(PDImage pdImage, String prefix, boolean directJPEG) throws IOException
{    String suffix = pdImage.getSuffix();    if (suffix == null || "jb2".equals(suffix)) {        suffix = "png";    } else if ("jpx".equals(suffix)) {                suffix = "jp2";    }    try (FileOutputStream out = new FileOutputStream(prefix + "." + suffix)) {        BufferedImage image = pdImage.getImage();        if (image != null) {            if ("jpg".equals(suffix)) {                String colorSpaceName = pdImage.getColorSpace().getName();                if (directJPEG || !hasMasks(pdImage) && (PDDeviceGray.INSTANCE.getName().equals(colorSpaceName) || PDDeviceRGB.INSTANCE.getName().equals(colorSpaceName))) {                                        InputStream data = pdImage.createInputStream(JPEG);                    IOUtils.copy(data, out);                    IOUtils.closeQuietly(data);                } else {                                        ImageIOUtil.writeImage(image, suffix, out);                }            } else if ("jp2".equals(suffix)) {                String colorSpaceName = pdImage.getColorSpace().getName();                if (directJPEG || !hasMasks(pdImage) && (PDDeviceGray.INSTANCE.getName().equals(colorSpaceName) || PDDeviceRGB.INSTANCE.getName().equals(colorSpaceName))) {                                        InputStream data = pdImage.createInputStream(Arrays.asList(COSName.JPX_DECODE.getName()));                    IOUtils.copy(data, out);                    IOUtils.closeQuietly(data);                } else {                                        ImageIOUtil.writeImage(image, "jpeg2000", out);                }            } else {                ImageIOUtil.writeImage(image, suffix, out);            }        }        out.flush();    }}
public static void pdfbox_f9217_0(String[] args) throws IOException
{        System.setProperty("apple.awt.UIElement", "true");    ExtractText extractor = new ExtractText();    extractor.startExtraction(args);}
public void pdfbox_f9218_0(String[] args) throws IOException
{    boolean toConsole = false;    boolean toHTML = false;    boolean sort = false;    boolean separateBeads = true;    boolean alwaysNext = false;    boolean rotationMagic = false;    @SuppressWarnings({ "squid:S2068" })    String password = "";    String encoding = STD_ENCODING;    String pdfFile = null;    String outputFile = null;        String ext = ".txt";    int startPage = 1;    int endPage = Integer.MAX_VALUE;    for (int i = 0; i < args.length; i++) {        if (args[i].equals(PASSWORD)) {            i++;            if (i >= args.length) {                usage();            }            password = args[i];        } else if (args[i].equals(ENCODING)) {            i++;            if (i >= args.length) {                usage();            }            encoding = args[i];        } else if (args[i].equals(START_PAGE)) {            i++;            if (i >= args.length) {                usage();            }            startPage = Integer.parseInt(args[i]);        } else if (args[i].equals(HTML)) {            toHTML = true;            ext = ".html";        } else if (args[i].equals(SORT)) {            sort = true;        } else if (args[i].equals(IGNORE_BEADS)) {            separateBeads = false;        } else if (args[i].equals(DEBUG)) {            debug = true;        } else if (args[i].equals(ALWAYSNEXT)) {            alwaysNext = true;        } else if (args[i].equals(ROTATION_MAGIC)) {            rotationMagic = true;        } else if (args[i].equals(END_PAGE)) {            i++;            if (i >= args.length) {                usage();            }            endPage = Integer.parseInt(args[i]);        } else if (args[i].equals(CONSOLE)) {            toConsole = true;        } else {            if (pdfFile == null) {                pdfFile = args[i];            } else {                outputFile = args[i];            }        }    }    if (pdfFile == null) {        usage();    } else {        Writer output = null;        PDDocument document = null;        try {            long startTime = startProcessing("Loading PDF " + pdfFile);            if (outputFile == null && pdfFile.length() > 4) {                outputFile = new File(pdfFile.substring(0, pdfFile.length() - 4) + ext).getAbsolutePath();            }            document = PDDocument.load(new File(pdfFile), password);            AccessPermission ap = document.getCurrentAccessPermission();            if (!ap.canExtractContent()) {                throw new IOException("You do not have permission to extract text");            }            stopProcessing("Time for loading: ", startTime);            if (toConsole) {                output = new OutputStreamWriter(System.out, encoding);            } else {                if (toHTML && !STD_ENCODING.equals(encoding)) {                    encoding = STD_ENCODING;                    System.out.println("The encoding parameter is ignored when writing html output.");                }                output = new OutputStreamWriter(new FileOutputStream(outputFile), encoding);            }            startTime = startProcessing("Starting text extraction");            if (debug) {                System.err.println("Writing to " + outputFile);            }            PDFTextStripper stripper;            if (toHTML) {                                stripper = new PDFText2HTML();                stripper.setSortByPosition(sort);                stripper.setShouldSeparateByBeads(separateBeads);                stripper.setStartPage(startPage);                stripper.setEndPage(endPage);                                stripper.writeText(document, output);            } else {                if (rotationMagic) {                    stripper = new FilteredTextStripper();                } else {                    stripper = new PDFTextStripper();                }                stripper.setSortByPosition(sort);                stripper.setShouldSeparateByBeads(separateBeads);                                extractPages(startPage, Math.min(endPage, document.getNumberOfPages()), stripper, document, output, rotationMagic, alwaysNext);            }                        PDDocumentCatalog catalog = document.getDocumentCatalog();            PDDocumentNameDictionary names = catalog.getNames();            if (names != null) {                PDEmbeddedFilesNameTreeNode embeddedFiles = names.getEmbeddedFiles();                if (embeddedFiles != null) {                    Map<String, PDComplexFileSpecification> embeddedFileNames = embeddedFiles.getNames();                    if (embeddedFileNames != null) {                        for (Map.Entry<String, PDComplexFileSpecification> ent : embeddedFileNames.entrySet()) {                            if (debug) {                                System.err.println("Processing embedded file " + ent.getKey() + ":");                            }                            PDComplexFileSpecification spec = ent.getValue();                            PDEmbeddedFile file = spec.getEmbeddedFile();                            if (file != null && "application/pdf".equals(file.getSubtype())) {                                if (debug) {                                    System.err.println("  is PDF (size=" + file.getSize() + ")");                                }                                try (InputStream fis = file.createInputStream();                                    PDDocument subDoc = PDDocument.load(fis)) {                                    if (toHTML) {                                                                                stripper.writeText(subDoc, output);                                    } else {                                        extractPages(1, subDoc.getNumberOfPages(), stripper, subDoc, output, rotationMagic, alwaysNext);                                    }                                }                            }                        }                    }                }            }            stopProcessing("Time for extraction: ", startTime);        } finally {            IOUtils.closeQuietly(output);            IOUtils.closeQuietly(document);        }    }}
private void pdfbox_f9219_1(int startPage, int endPage, PDFTextStripper stripper, PDDocument document, Writer output, boolean rotationMagic, boolean alwaysNext) throws IOException
{    for (int p = startPage; p <= endPage; ++p) {        stripper.setStartPage(p);        stripper.setEndPage(p);        try {            if (rotationMagic) {                PDPage page = document.getPage(p - 1);                int rotation = page.getRotation();                page.setRotation(0);                AngleCollector angleCollector = new AngleCollector();                angleCollector.setStartPage(p);                angleCollector.setEndPage(p);                angleCollector.writeText(document, new NullWriter());                                for (int angle : angleCollector.getAngles()) {                                        try (PDPageContentStream cs = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.PREPEND, false)) {                        cs.transform(Matrix.getRotateInstance(-Math.toRadians(angle), 0, 0));                    }                    stripper.writeText(document, output);                                        ((COSArray) page.getCOSObject().getItem(COSName.CONTENTS)).remove(0);                }                page.setRotation(rotation);            } else {                stripper.writeText(document, output);            }        } catch (IOException ex) {            if (!alwaysNext) {                throw ex;            }                    }    }}
private long pdfbox_f9220_0(String message)
{    if (debug) {        System.err.println(message);    }    return System.currentTimeMillis();}
private void pdfbox_f9221_0(String message, long startTime)
{    if (debug) {        long stopTime = System.currentTimeMillis();        float elapsedTime = ((float) (stopTime - startTime)) / 1000;        System.err.println(message + elapsedTime + " seconds");    }}
 static int pdfbox_f9222_0(TextPosition text)
{        Matrix m = text.getTextMatrix().clone();    m.concatenate(text.getFont().getFontMatrix());    return (int) Math.round(Math.toDegrees(Math.atan2(m.getShearY(), m.getScaleY())));}
private static void pdfbox_f9223_0()
{    String message = "Usage: java -jar pdfbox-app-x.y.z.jar ExtractText [options] <inputfile> [output-text-file]\n" + "\nOptions:\n" + "  -password <password>        : Password to decrypt document\n" + "  -encoding <output encoding> : UTF-8 (default) or ISO-8859-1, UTF-16BE,\n" + "                                UTF-16LE, etc.\n" + "  -console                    : Send text to console instead of file\n" + "  -html                       : Output in HTML format instead of raw text\n" + "  -sort                       : Sort the text before writing\n" + "  -ignoreBeads                : Disables the separation by beads\n" + "  -debug                      : Enables debug output about the time consumption\n" + "                                of every stage\n" + "  -alwaysNext                 : Process next page (if applicable) despite\n" + "                                IOException (ignored when -html)\n" + "  -rotationMagic              : Analyze each page for rotated/skewed text,\n" + "                                rotate to 0° and extract separately\n" + "                                (slower, and ignored when -html)\n" + "  -startPage <number>         : The first page to start extraction (1 based)\n" + "  -endPage <number>           : The last page to extract (1 based, inclusive)\n" + "  <inputfile>                 : The PDF document to use\n" + "  [output-text-file]          : The file to write the text to";    System.err.println(message);    System.exit(1);}
 Set<Integer> pdfbox_f9224_0()
{    return angles;}
protected void pdfbox_f9225_0(TextPosition text)
{    int angle = ExtractText.getAngle(text);    angle = (angle + 360) % 360;    angles.add(angle);}
protected void pdfbox_f9226_0(TextPosition text)
{    int angle = ExtractText.getAngle(text);    if (angle == 0) {        super.processTextPosition(text);    }}
public static boolean pdfbox_f9230_0(BufferedImage image, String filename, int dpi) throws IOException
{    float compressionQuality = 1f;    String formatName = filename.substring(filename.lastIndexOf('.') + 1);    if ("png".equalsIgnoreCase(formatName)) {                compressionQuality = 0f;    }    return writeImage(image, filename, dpi, compressionQuality);}
public static boolean pdfbox_f9231_0(BufferedImage image, String filename, int dpi, float compressionQuality) throws IOException
{    try (OutputStream output = new BufferedOutputStream(new FileOutputStream(filename))) {        String formatName = filename.substring(filename.lastIndexOf('.') + 1);        return writeImage(image, formatName, output, dpi, compressionQuality);    }}
public static boolean pdfbox_f9232_0(BufferedImage image, String formatName, String filename, int dpi) throws IOException
{    try (OutputStream output = new BufferedOutputStream(new FileOutputStream(filename + "." + formatName))) {        return writeImage(image, formatName, output, dpi);    }}
public static boolean pdfbox_f9233_0(BufferedImage image, String formatName, OutputStream output) throws IOException
{    return writeImage(image, formatName, output, 72);}
public static boolean pdfbox_f9234_0(BufferedImage image, String formatName, OutputStream output, int dpi) throws IOException
{    float compressionQuality = 1f;    if ("png".equalsIgnoreCase(formatName)) {                compressionQuality = 0f;    }    return writeImage(image, formatName, output, dpi, compressionQuality);}
public static boolean pdfbox_f9235_0(BufferedImage image, String formatName, OutputStream output, int dpi, float compressionQuality) throws IOException
{    return writeImage(image, formatName, output, dpi, compressionQuality, "");}
public static boolean pdfbox_f9236_1(BufferedImage image, String formatName, OutputStream output, int dpi, float compressionQuality, String compressionType) throws IOException
{    ImageOutputStream imageOutput = null;    ImageWriter writer = null;    try {                Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(formatName);        ImageWriteParam param = null;        IIOMetadata metadata = null;                while (writers.hasNext()) {            if (writer != null) {                writer.dispose();            }            writer = writers.next();            if (writer != null) {                param = writer.getDefaultWriteParam();                metadata = writer.getDefaultImageMetadata(new ImageTypeSpecifier(image), param);                if (metadata != null && !metadata.isReadOnly() && metadata.isStandardMetadataFormatSupported()) {                    break;                }            }        }        if (writer == null) {                                    return false;        }                if (param != null && param.canWriteCompressed()) {            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);            if (formatName.toLowerCase().startsWith("tif")) {                if ("".equals(compressionType)) {                                        TIFFUtil.setCompressionType(param, image);                } else {                    param.setCompressionType(compressionType);                    if (compressionType != null) {                        param.setCompressionQuality(compressionQuality);                    }                }            } else {                param.setCompressionType(param.getCompressionTypes()[0]);                param.setCompressionQuality(compressionQuality);            }        }        if (formatName.toLowerCase().startsWith("tif")) {                        TIFFUtil.updateMetadata(metadata, image, dpi);        } else if ("jpeg".equalsIgnoreCase(formatName) || "jpg".equalsIgnoreCase(formatName)) {                                                            JPEGUtil.updateMetadata(metadata, dpi);        } else {                        if (metadata != null && !metadata.isReadOnly() && metadata.isStandardMetadataFormatSupported()) {                setDPI(metadata, dpi, formatName);            }        }                imageOutput = ImageIO.createImageOutputStream(output);        writer.setOutput(imageOutput);        writer.write(null, new IIOImage(image, null, metadata), param);    } finally {        if (writer != null) {            writer.dispose();        }        if (imageOutput != null) {            imageOutput.close();        }    }    return true;}
private static IIOMetadataNode pdfbox_f9237_0(IIOMetadataNode parentNode, String name)
{    NodeList nodeList = parentNode.getElementsByTagName(name);    if (nodeList.getLength() > 0) {        return (IIOMetadataNode) nodeList.item(0);    }    IIOMetadataNode childNode = new IIOMetadataNode(name);    parentNode.appendChild(childNode);    return childNode;}
private static void pdfbox_f9238_0(IIOMetadata metadata, int dpi, String formatName) throws IIOInvalidTreeException
{    IIOMetadataNode root = (IIOMetadataNode) metadata.getAsTree(MetaUtil.STANDARD_METADATA_FORMAT);    IIOMetadataNode dimension = getOrCreateChildNode(root, "Dimension");                float res = "PNG".equalsIgnoreCase(formatName) ? dpi / 25.4f : 25.4f / dpi;    IIOMetadataNode child;    child = getOrCreateChildNode(dimension, "HorizontalPixelSize");    child.setAttribute("value", Double.toString(res));    child = getOrCreateChildNode(dimension, "VerticalPixelSize");    child.setAttribute("value", Double.toString(res));    metadata.mergeTree(MetaUtil.STANDARD_METADATA_FORMAT, root);}
 static void pdfbox_f9239_0(IIOMetadata metadata, int dpi) throws IIOInvalidTreeException
{    MetaUtil.debugLogMetadata(metadata, MetaUtil.JPEG_NATIVE_FORMAT);            Element root = (Element) metadata.getAsTree(MetaUtil.JPEG_NATIVE_FORMAT);    NodeList jvarNodeList = root.getElementsByTagName("JPEGvariety");    Element jvarChild;    if (jvarNodeList.getLength() == 0) {        jvarChild = new IIOMetadataNode("JPEGvariety");        root.appendChild(jvarChild);    } else {        jvarChild = (Element) jvarNodeList.item(0);    }    NodeList jfifNodeList = jvarChild.getElementsByTagName("app0JFIF");    Element jfifChild;    if (jfifNodeList.getLength() == 0) {        jfifChild = new IIOMetadataNode("app0JFIF");        jvarChild.appendChild(jfifChild);    } else {        jfifChild = (Element) jfifNodeList.item(0);    }    if (jfifChild.getAttribute("majorVersion").isEmpty()) {        jfifChild.setAttribute("majorVersion", "1");    }    if (jfifChild.getAttribute("minorVersion").isEmpty()) {        jfifChild.setAttribute("minorVersion", "2");    }        jfifChild.setAttribute("resUnits", "1");    jfifChild.setAttribute("Xdensity", Integer.toString(dpi));    jfifChild.setAttribute("Ydensity", Integer.toString(dpi));    if (jfifChild.getAttribute("thumbWidth").isEmpty()) {        jfifChild.setAttribute("thumbWidth", "0");    }    if (jfifChild.getAttribute("thumbHeight").isEmpty()) {        jfifChild.setAttribute("thumbHeight", "0");    }        metadata.setFromTree(MetaUtil.JPEG_NATIVE_FORMAT, root);}
 static void pdfbox_f9240_1(IIOMetadata metadata, String format)
{    if (!LOG.isDebugEnabled()) {        return;    }            IIOMetadataNode root = (IIOMetadataNode) metadata.getAsTree(format);    try {        StringWriter xmlStringWriter = new StringWriter();        StreamResult streamResult = new StreamResult(xmlStringWriter);        Transformer transformer = TransformerFactory.newInstance().newTransformer();                transformer.setOutputProperty(OutputKeys.INDENT, "yes");        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");        DOMSource domSource = new DOMSource(root);        transformer.transform(domSource, streamResult);            } catch (IllegalArgumentException | TransformerException ex) {            }}
public static void pdfbox_f9241_0(ImageWriteParam param, BufferedImage image)
{        if (image.getType() == BufferedImage.TYPE_BYTE_BINARY && image.getColorModel().getPixelSize() == 1) {        param.setCompressionType("CCITT T.6");    } else {        param.setCompressionType("LZW");    }}
 static void pdfbox_f9242_1(IIOMetadata metadata, BufferedImage image, int dpi) throws IIOInvalidTreeException
{    String metaDataFormat = metadata.getNativeMetadataFormatName();    if (metaDataFormat == null) {                return;    }    debugLogMetadata(metadata, metaDataFormat);    IIOMetadataNode root = new IIOMetadataNode(metaDataFormat);    IIOMetadataNode ifd;    if (root.getElementsByTagName("TIFFIFD").getLength() == 0) {        ifd = new IIOMetadataNode("TIFFIFD");        root.appendChild(ifd);    } else {        ifd = (IIOMetadataNode) root.getElementsByTagName("TIFFIFD").item(0);    }        ifd.appendChild(createRationalField(282, "XResolution", dpi, 1));    ifd.appendChild(createRationalField(283, "YResolution", dpi, 1));        ifd.appendChild(createShortField(296, "ResolutionUnit", 2));    ifd.appendChild(createLongField(278, "RowsPerStrip", image.getHeight()));    ifd.appendChild(createAsciiField(305, "Software", "PDFBOX"));    if (image.getType() == BufferedImage.TYPE_BYTE_BINARY && image.getColorModel().getPixelSize() == 1) {                        ifd.appendChild(createShortField(262, "PhotometricInterpretation", 0));    }    metadata.mergeTree(metaDataFormat, root);    debugLogMetadata(metadata, metaDataFormat);}
private static IIOMetadataNode pdfbox_f9243_0(int tiffTagNumber, String name, int val)
{    IIOMetadataNode field, arrayNode, valueNode;    field = new IIOMetadataNode("TIFFField");    field.setAttribute("number", Integer.toString(tiffTagNumber));    field.setAttribute("name", name);    arrayNode = new IIOMetadataNode("TIFFShorts");    field.appendChild(arrayNode);    valueNode = new IIOMetadataNode("TIFFShort");    arrayNode.appendChild(valueNode);    valueNode.setAttribute("value", Integer.toString(val));    return field;}
private static IIOMetadataNode pdfbox_f9244_0(int number, String name, String val)
{    IIOMetadataNode field, arrayNode, valueNode;    field = new IIOMetadataNode("TIFFField");    field.setAttribute("number", Integer.toString(number));    field.setAttribute("name", name);    arrayNode = new IIOMetadataNode("TIFFAsciis");    field.appendChild(arrayNode);    valueNode = new IIOMetadataNode("TIFFAscii");    arrayNode.appendChild(valueNode);    valueNode.setAttribute("value", val);    return field;}
private static IIOMetadataNode pdfbox_f9245_0(int number, String name, long val)
{    IIOMetadataNode field, arrayNode, valueNode;    field = new IIOMetadataNode("TIFFField");    field.setAttribute("number", Integer.toString(number));    field.setAttribute("name", name);    arrayNode = new IIOMetadataNode("TIFFLongs");    field.appendChild(arrayNode);    valueNode = new IIOMetadataNode("TIFFLong");    arrayNode.appendChild(valueNode);    valueNode.setAttribute("value", Long.toString(val));    return field;}
private static IIOMetadataNode pdfbox_f9246_0(int number, String name, int numerator, int denominator)
{    IIOMetadataNode field, arrayNode, valueNode;    field = new IIOMetadataNode("TIFFField");    field.setAttribute("number", Integer.toString(number));    field.setAttribute("name", name);    arrayNode = new IIOMetadataNode("TIFFRationals");    field.appendChild(arrayNode);    valueNode = new IIOMetadataNode("TIFFRational");    arrayNode.appendChild(valueNode);    valueNode.setAttribute("value", numerator + "/" + denominator);    return field;}
public static void pdfbox_f9247_0(String[] args) throws IOException
{        System.setProperty("apple.awt.UIElement", "true");    ImageToPDF app = new ImageToPDF();    if (args.length < 2) {        app.usage();    }    List<String> imageFilenames = new ArrayList<>();    String pdfPath = args[args.length - 1];    if (!pdfPath.endsWith(".pdf")) {        System.err.println("Last argument must be the destination .pdf file");        System.exit(1);    }    for (int i = 0; i < args.length - 1; i++) {        if (args[i].startsWith("-")) {            if ("-resize".equals(args[i])) {                                app.resize = true;            } else if ("-landscape".equals(args[i])) {                app.setLandscape(true);            } else if ("-autoOrientation".equals(args[i])) {                app.setAutoOrientation(true);            } else if ("-pageSize".equals(args[i])) {                i++;                PDRectangle rectangle = createRectangle(args[i]);                if (rectangle == null) {                    throw new IOException("Unknown argument: " + args[i]);                }                app.setMediaBox(rectangle);            } else {                throw new IOException("Unknown argument: " + args[i]);            }        } else {            imageFilenames.add(args[i]);        }    }    try (PDDocument doc = new PDDocument()) {        app.createPDFFromImages(doc, imageFilenames);        doc.save(pdfPath);    }}
 void pdfbox_f9248_0(PDDocument doc, List<String> imageFilenames) throws IOException
{    for (String imageFileName : imageFilenames) {        PDImageXObject pdImage = PDImageXObject.createFromFile(imageFileName, doc);        PDRectangle actualMediaBox = mediaBox;        if ((autoOrientation && pdImage.getWidth() > pdImage.getHeight()) || landscape) {            actualMediaBox = new PDRectangle(mediaBox.getHeight(), mediaBox.getWidth());        }        PDPage page = new PDPage(actualMediaBox);        doc.addPage(page);        try (PDPageContentStream contents = new PDPageContentStream(doc, page)) {            if (resize) {                contents.drawImage(pdImage, 0, 0, actualMediaBox.getWidth(), actualMediaBox.getHeight());            } else {                contents.drawImage(pdImage, 0, 0, pdImage.getWidth(), pdImage.getHeight());            }        }    }}
private static PDRectangle pdfbox_f9249_0(String paperSize)
{    if ("letter".equalsIgnoreCase(paperSize)) {        return PDRectangle.LETTER;    } else if ("legal".equalsIgnoreCase(paperSize)) {        return PDRectangle.LEGAL;    } else if ("A0".equalsIgnoreCase(paperSize)) {        return PDRectangle.A0;    } else if ("A1".equalsIgnoreCase(paperSize)) {        return PDRectangle.A1;    } else if ("A2".equalsIgnoreCase(paperSize)) {        return PDRectangle.A2;    } else if ("A3".equalsIgnoreCase(paperSize)) {        return PDRectangle.A3;    } else if ("A4".equalsIgnoreCase(paperSize)) {        return PDRectangle.A4;    } else if ("A5".equalsIgnoreCase(paperSize)) {        return PDRectangle.A5;    } else if ("A6".equalsIgnoreCase(paperSize)) {        return PDRectangle.A6;    } else {        return null;    }}
public PDRectangle pdfbox_f9250_0()
{    return mediaBox;}
public void pdfbox_f9251_0(PDRectangle mediaBox)
{    this.mediaBox = mediaBox;}
public boolean pdfbox_f9252_0()
{    return landscape;}
public void pdfbox_f9253_0(boolean landscape)
{    this.landscape = landscape;}
public boolean pdfbox_f9254_0()
{    return autoOrientation;}
public void pdfbox_f9255_0(boolean autoOrientation)
{    this.autoOrientation = autoOrientation;}
private void pdfbox_f9256_0()
{    StringBuilder message = new StringBuilder();    message.append("Usage: jar -jar pdfbox-app-x.y.z.jar ImageToPDF [options] <image-file>..<image-file> <output-file>\n");    message.append("\nOptions:\n");    message.append("  -resize              : resize to page size\n");    message.append("  -pageSize <pageSize> : Letter (default)\n");    message.append("                         Legal\n");    message.append("                         A0\n");    message.append("                         A1\n");    message.append("                         A2\n");    message.append("                         A3\n");    message.append("                         A4\n");    message.append("                         A5\n");    message.append("                         A6\n");    message.append("  -landscape           : sets orientation to landscape\n");    message.append("  -autoOrientation     : sets orientation depending of image proportion\n");    System.err.println(message.toString());    System.exit(1);}
public void pdfbox_f9257_0(PDDocument pdfDocument, FDFDocument fdfDocument) throws IOException
{    PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();    PDAcroForm acroForm = docCatalog.getAcroForm();    if (acroForm == null) {        return;    }    acroForm.setCacheFields(true);    acroForm.importFDF(fdfDocument);        acroForm.setNeedAppearances(true);}
public static void pdfbox_f9258_0(String[] args) throws IOException
{        System.setProperty("apple.awt.UIElement", "true");    ImportFDF importer = new ImportFDF();    importer.importFDF(args);}
private void pdfbox_f9259_0(String[] args) throws IOException
{    if (args.length != 3) {        usage();    } else {        ImportFDF importer = new ImportFDF();        try (PDDocument pdf = PDDocument.load(new File(args[0]));            FDFDocument fdf = FDFDocument.load(args[1])) {            importer.importFDF(pdf, fdf);            pdf.save(args[2]);        }    }}
private static void pdfbox_f9260_0()
{    System.err.println("usage: org.apache.pdfbox.tools.ImportFDF <pdf-file> <fdf-file> <output-file>");    System.exit(1);}
public void pdfbox_f9261_0(PDDocument pdfDocument, FDFDocument fdfDocument) throws IOException
{    PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();    PDAcroForm acroForm = docCatalog.getAcroForm();    acroForm.setCacheFields(true);    acroForm.importFDF(fdfDocument);}
public static void pdfbox_f9262_0(String[] args) throws IOException
{        System.setProperty("apple.awt.UIElement", "true");    ImportXFDF importer = new ImportXFDF();    importer.importXFDF(args);}
private void pdfbox_f9263_0(String[] args) throws IOException
{    if (args.length != 3) {        usage();    } else {        ImportFDF importer = new ImportFDF();        try (PDDocument pdf = PDDocument.load(new File(args[0]));            FDFDocument fdf = FDFDocument.loadXFDF(args[1])) {            importer.importFDF(pdf, fdf);            pdf.save(args[2]);        }    }}
private static void pdfbox_f9264_0()
{    System.err.println("usage: org.apache.pdfbox.tools.ImportXFDF <pdf-file> <fdf-file> <output-file>");    System.exit(1);}
public static void pdfbox_f9265_1(final String[] args) throws IOException
{        System.setProperty("apple.awt.UIElement", "true");    String outputFilename = null;    Overlay overlayer = new Overlay();    Map<Integer, String> specificPageOverlayFile = new HashMap<>();        for (int i = 0; i < args.length; i++) {        String arg = args[i].trim();        if (i == 0) {            overlayer.setInputFile(arg);        } else if (i == (args.length - 1)) {            outputFilename = arg;        } else if (arg.equals(POSITION) && ((i + 1) < args.length)) {            if (Position.FOREGROUND.toString().equalsIgnoreCase(args[i + 1].trim())) {                overlayer.setOverlayPosition(Position.FOREGROUND);            } else if (Position.BACKGROUND.toString().equalsIgnoreCase(args[i + 1].trim())) {                overlayer.setOverlayPosition(Position.BACKGROUND);            } else {                usage();            }            i += 1;        } else if (arg.equals(ODD) && ((i + 1) < args.length)) {            overlayer.setOddPageOverlayFile(args[i + 1].trim());            i += 1;        } else if (arg.equals(EVEN) && ((i + 1) < args.length)) {            overlayer.setEvenPageOverlayFile(args[i + 1].trim());            i += 1;        } else if (arg.equals(FIRST) && ((i + 1) < args.length)) {            overlayer.setFirstPageOverlayFile(args[i + 1].trim());            i += 1;        } else if (arg.equals(LAST) && ((i + 1) < args.length)) {            overlayer.setLastPageOverlayFile(args[i + 1].trim());            i += 1;        } else if (arg.equals(USEALLPAGES) && ((i + 1) < args.length)) {            overlayer.setAllPagesOverlayFile(args[i + 1].trim());            i += 1;        } else if (arg.equals(PAGE) && ((i + 2) < args.length) && (isInteger(args[i + 1].trim()))) {            specificPageOverlayFile.put(Integer.parseInt(args[i + 1].trim()), args[i + 2].trim());            i += 2;        } else if (overlayer.getDefaultOverlayFile() == null) {            overlayer.setDefaultOverlayFile(arg);        } else {            usage();        }    }    if (overlayer.getInputFile() == null || outputFilename == null) {        usage();    }    try {        try (PDDocument result = overlayer.overlay(specificPageOverlayFile)) {            result.save(outputFilename);        }    } catch (IOException e) {                throw e;    } finally {                        overlayer.close();    }}
private static void pdfbox_f9266_0()
{    String message = "Usage: java -jar pdfbox-app-x.y.z.jar OverlayPDF <inputfile> [options] <outputfile>\n" + "\nOptions:\n" + "  <inputfile>                                  : input file\n" + "  <defaultOverlay.pdf>                         : default overlay file\n" + "  -odd <oddPageOverlay.pdf>                    : overlay file used for odd pages\n" + "  -even <evenPageOverlay.pdf>                  : overlay file used for even pages\n" + "  -first <firstPageOverlay.pdf>                : overlay file used for the first page\n" + "  -last <lastPageOverlay.pdf>                  : overlay file used for the last page\n" + "  -useAllPages <allPagesOverlay.pdf>           : overlay file used for overlay, all pages" + " are used by simply repeating them\n" + "  -page <pageNumber> <specificPageOverlay.pdf> : overlay file used for " + "the given page number, may occur more than once\n" + "  -position foreground|background              : where to put the overlay " + "file: foreground or background\n" + "  <outputfile>                                 : output file";    System.err.println(message);    System.exit(1);}
private static boolean pdfbox_f9267_0(String str)
{    try {        Integer.parseInt(str);    } catch (NumberFormatException nfe) {        return false;    }    return true;}
public static void pdfbox_f9268_0(String[] args) throws Exception
{        System.setProperty("apple.awt.UIElement", "true");    if (args.length > 0) {        String command = args[0];        String[] arguments = new String[args.length - 1];        System.arraycopy(args, 1, arguments, 0, arguments.length);        boolean exitAfterCallingMain = true;        switch(command) {            case "Decrypt":                Decrypt.main(arguments);                break;            case "Encrypt":                Encrypt.main(arguments);                break;            case "ExtractText":                ExtractText.main(arguments);                break;            case "ExtractImages":                ExtractImages.main(arguments);                break;            case "OverlayPDF":                OverlayPDF.main(arguments);                break;            case "PrintPDF":                PrintPDF.main(arguments);                break;            case "PDFDebugger":            case "PDFReader":                PDFDebugger.main(arguments);                exitAfterCallingMain = false;                break;            case "PDFMerger":                PDFMerger.main(arguments);                break;            case "PDFSplit":                PDFSplit.main(arguments);                break;            case "PDFToImage":                PDFToImage.main(arguments);                break;            case "ImageToPDF":                ImageToPDF.main(arguments);                break;            case "TextToPDF":                TextToPDF.main(arguments);                break;            case "WriteDecodedDoc":                WriteDecodedDoc.main(arguments);                break;            default:                showMessageAndExit();                break;        }        if (exitAfterCallingMain) {            System.exit(0);        }    } else {        showMessageAndExit();    }}
private static void pdfbox_f9269_0()
{    String message = "PDFBox version: \"" + Version.getVersion() + "\"" + "\nUsage: java -jar pdfbox-app-x.y.z.jar <command> <args..>\n" + "\nPossible commands are:\n" + "  Decrypt\n" + "  Encrypt\n" + "  ExtractText\n" + "  ExtractImages\n" + "  ImageToPDF\n" + "  OverlayPDF\n" + "  PrintPDF\n" + "  PDFDebugger\n" + "  PDFMerger\n" + "  PDFReader\n" + "  PDFSplit\n" + "  PDFToImage\n" + "  TextToPDF\n" + "  WriteDecodedDoc";    System.err.println(message);    System.exit(1);}
public static void pdfbox_f9270_0(String[] args) throws IOException
{        System.setProperty("apple.awt.UIElement", "true");    PDFMerger merge = new PDFMerger();    merge.merge(args);}
private void pdfbox_f9271_0(String[] args) throws IOException
{    int firstFileArgPos = 0;    if (args.length - firstFileArgPos < 3) {        usage();    }    PDFMergerUtility merger = new PDFMergerUtility();    for (int i = firstFileArgPos; i < args.length - 1; i++) {        String sourceFileName = args[i];        merger.addSource(sourceFileName);    }    String destinationFileName = args[args.length - 1];    merger.setDestinationFileName(destinationFileName);    merger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());}
private static void pdfbox_f9272_0()
{    String message = "Usage: java -jar pdfbox-app-x.y.z.jar PDFMerger " + "<inputfiles 2..n> <outputfile>\n" + "\nOptions:\n" + "  <inputfiles 2..n> : 2 or more source PDF documents to merge\n" + "  <outputfile>      : The PDF document to save the merged documents to\n";    System.err.println(message);    System.exit(1);}
public static void pdfbox_f9273_0(String[] args) throws IOException
{        System.setProperty("apple.awt.UIElement", "true");    PDFSplit split = new PDFSplit();    split.split(args);}
private void pdfbox_f9274_0(String[] args) throws IOException
{    @SuppressWarnings({ "squid:S2068" })    String password = "";    String split = null;    String startPage = null;    String endPage = null;    Splitter splitter = new Splitter();    String pdfFile = null;    String outputPrefix = null;    for (int i = 0; i < args.length; i++) {        switch(args[i]) {            case PASSWORD:                i++;                if (i >= args.length) {                    usage();                }                password = args[i];                break;            case SPLIT:                i++;                if (i >= args.length) {                    usage();                }                split = args[i];                break;            case START_PAGE:                i++;                if (i >= args.length) {                    usage();                }                startPage = args[i];                break;            case END_PAGE:                i++;                if (i >= args.length) {                    usage();                }                endPage = args[i];                break;            case OUTPUT_PREFIX:                i++;                outputPrefix = args[i];                break;            default:                if (pdfFile == null) {                    pdfFile = args[i];                }                break;        }    }    if (pdfFile == null) {        usage();    } else {        if (outputPrefix == null) {            outputPrefix = pdfFile.substring(0, pdfFile.lastIndexOf('.'));        }        PDDocument document = null;        List<PDDocument> documents = null;        try {            document = PDDocument.load(new File(pdfFile), password);            int numberOfPages = document.getNumberOfPages();            boolean startEndPageSet = false;            if (startPage != null) {                splitter.setStartPage(Integer.parseInt(startPage));                startEndPageSet = true;                if (split == null) {                    splitter.setSplitAtPage(numberOfPages);                }            }            if (endPage != null) {                splitter.setEndPage(Integer.parseInt(endPage));                startEndPageSet = true;                if (split == null) {                    splitter.setSplitAtPage(Integer.parseInt(endPage));                }            }            if (split != null) {                splitter.setSplitAtPage(Integer.parseInt(split));            } else {                if (!startEndPageSet) {                    splitter.setSplitAtPage(1);                }            }            documents = splitter.split(document);            for (int i = 0; i < documents.size(); i++) {                try (PDDocument doc = documents.get(i)) {                    doc.save(outputPrefix + "-" + (i + 1) + ".pdf");                }            }        } finally {            if (document != null) {                document.close();            }            for (int i = 0; documents != null && i < documents.size(); i++) {                PDDocument doc = documents.get(i);                doc.close();            }        }    }}
private static void pdfbox_f9275_0()
{    String message = "Usage: java -jar pdfbox-app-x.y.z.jar PDFSplit [options] <inputfile>\n" + "\nOptions:\n" + "  -password  <password>  : Password to decrypt document\n" + "  -split     <integer>   : split after this many pages (default 1, if startPage and endPage are unset)\n" + "  -startPage <integer>   : start page\n" + "  -endPage   <integer>   : end page\n" + "  -outputPrefix <prefix> : Filename prefix for splitted files\n" + "  <inputfile>            : The PDF document to use\n";    System.err.println(message);    System.exit(1);}
protected void pdfbox_f9277_0(PDDocument document) throws IOException
{    StringBuilder buf = new StringBuilder(INITIAL_PDF_TO_HTML_BYTES);    buf.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\n" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n");    buf.append("<html><head>");    buf.append("<title>").append(escape(getTitle())).append("</title>\n");    buf.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=\"UTF-8\">\n");    buf.append("</head>\n");    buf.append("<body>\n");    super.writeString(buf.toString());}
public void pdfbox_f9278_0(PDDocument document) throws IOException
{    super.writeString("</body></html>");}
protected String pdfbox_f9279_0()
{    String titleGuess = document.getDocumentInformation().getTitle();    if (titleGuess != null && titleGuess.length() > 0) {        return titleGuess;    } else {        Iterator<List<TextPosition>> textIter = getCharactersByArticle().iterator();        float lastFontSize = -1.0f;        StringBuilder titleText = new StringBuilder();        while (textIter.hasNext()) {            for (TextPosition position : textIter.next()) {                float currentFontSize = position.getFontSize();                                if (Float.compare(currentFontSize, lastFontSize) != 0 || titleText.length() > 64) {                    if (titleText.length() > 0) {                        return titleText.toString();                    }                    lastFontSize = currentFontSize;                }                if (currentFontSize > 13.0f) {                                        titleText.append(position.getUnicode());                }            }        }    }    return "";}
protected void pdfbox_f9280_0(boolean isLTR) throws IOException
{    if (isLTR) {        super.writeString("<div>");    } else {        super.writeString("<div dir=\"RTL\">");    }}
protected void pdfbox_f9281_0() throws IOException
{    super.endArticle();    super.writeString("</div>");}
protected void pdfbox_f9282_0(String text, List<TextPosition> textPositions) throws IOException
{    super.writeString(fontState.push(text, textPositions));}
protected void pdfbox_f9283_0(String chars) throws IOException
{    super.writeString(escape(chars));}
protected void pdfbox_f9284_0() throws IOException
{        super.writeString(fontState.clear());    super.writeParagraphEnd();}
private static String pdfbox_f9285_0(String chars)
{    StringBuilder builder = new StringBuilder(chars.length());    for (int i = 0; i < chars.length(); i++) {        appendEscaped(builder, chars.charAt(i));    }    return builder.toString();}
private static void pdfbox_f9286_0(StringBuilder builder, char character)
{        if ((character < 32) || (character > 126)) {        int charAsInt = character;        builder.append("&#").append(charAsInt).append(";");    } else {        switch(character) {            case 34:                builder.append("&quot;");                break;            case 38:                builder.append("&amp;");                break;            case 60:                builder.append("&lt;");                break;            case 62:                builder.append("&gt;");                break;            default:                builder.append(String.valueOf(character));        }    }}
public String pdfbox_f9287_0(String text, List<TextPosition> textPositions)
{    StringBuilder buffer = new StringBuilder();    if (text.length() == textPositions.size()) {                for (int i = 0; i < text.length(); i++) {            push(buffer, text.charAt(i), textPositions.get(i));        }    } else if (!text.isEmpty()) {                if (textPositions.isEmpty()) {            return text;        }        push(buffer, text.charAt(0), textPositions.get(0));        buffer.append(escape(text.substring(1)));    }    return buffer.toString();}
public String pdfbox_f9288_0()
{    StringBuilder buffer = new StringBuilder();    closeUntil(buffer, null);    stateList.clear();    stateSet.clear();    return buffer.toString();}
protected String pdfbox_f9289_0(StringBuilder buffer, char character, TextPosition textPosition)
{    boolean bold = false;    boolean italics = false;    PDFontDescriptor descriptor = textPosition.getFont().getFontDescriptor();    if (descriptor != null) {        bold = isBold(descriptor);        italics = isItalic(descriptor);    }    buffer.append(bold ? open("b") : close("b"));    buffer.append(italics ? open("i") : close("i"));    appendEscaped(buffer, character);    return buffer.toString();}
private String pdfbox_f9290_0(String tag)
{    if (stateSet.contains(tag)) {        return "";    }    stateList.add(tag);    stateSet.add(tag);    return openTag(tag);}
private String pdfbox_f9291_0(String tag)
{    if (!stateSet.contains(tag)) {        return "";    }        StringBuilder tagsBuilder = new StringBuilder();    int index = closeUntil(tagsBuilder, tag);        stateList.remove(index);    stateSet.remove(tag);        for (; index < stateList.size(); index++) {        tagsBuilder.append(openTag(stateList.get(index)));    }    return tagsBuilder.toString();}
private int pdfbox_f9292_0(StringBuilder tagsBuilder, String endTag)
{    for (int i = stateList.size(); i-- > 0; ) {        String tag = stateList.get(i);        tagsBuilder.append(closeTag(tag));        if (endTag != null && tag.equals(endTag)) {            return i;        }    }    return -1;}
private String pdfbox_f9293_0(String tag)
{    return "<" + tag + ">";}
private String pdfbox_f9294_0(String tag)
{    return "</" + tag + ">";}
private boolean pdfbox_f9295_0(PDFontDescriptor descriptor)
{    if (descriptor.isForceBold()) {        return true;    }    return descriptor.getFontName().contains("Bold");}
private boolean pdfbox_f9296_0(PDFontDescriptor descriptor)
{    if (descriptor.isItalic()) {        return true;    }    return descriptor.getFontName().contains("Italic");}
public static void pdfbox_f9297_0(String[] args) throws IOException
{        System.setProperty("apple.awt.UIElement", "true");    @SuppressWarnings({ "squid:S2068" })    String password = "";    String pdfFile = null;    String outputPrefix = null;    String imageFormat = "jpg";    int startPage = 1;    int endPage = Integer.MAX_VALUE;    String color = "rgb";    int dpi;    float quality = -1;    float cropBoxLowerLeftX = 0;    float cropBoxLowerLeftY = 0;    float cropBoxUpperRightX = 0;    float cropBoxUpperRightY = 0;    boolean showTime = false;    boolean subsampling = false;    try {        dpi = Toolkit.getDefaultToolkit().getScreenResolution();    } catch (HeadlessException e) {        dpi = 96;    }    for (int i = 0; i < args.length; i++) {        switch(args[i]) {            case PASSWORD:                i++;                if (i >= args.length) {                    usage();                }                password = args[i];                break;            case START_PAGE:                i++;                if (i >= args.length) {                    usage();                }                startPage = Integer.parseInt(args[i]);                break;            case END_PAGE:                i++;                if (i >= args.length) {                    usage();                }                endPage = Integer.parseInt(args[i]);                break;            case PAGE:                i++;                if (i >= args.length) {                    usage();                }                startPage = Integer.parseInt(args[i]);                endPage = Integer.parseInt(args[i]);                break;            case IMAGE_TYPE:            case FORMAT:                i++;                imageFormat = args[i];                break;            case OUTPUT_PREFIX:            case PREFIX:                i++;                outputPrefix = args[i];                break;            case COLOR:                i++;                color = args[i];                break;            case RESOLUTION:            case DPI:                i++;                dpi = Integer.parseInt(args[i]);                break;            case QUALITY:                i++;                quality = Float.parseFloat(args[i]);                break;            case CROPBOX:                i++;                cropBoxLowerLeftX = Float.valueOf(args[i]);                i++;                cropBoxLowerLeftY = Float.valueOf(args[i]);                i++;                cropBoxUpperRightX = Float.valueOf(args[i]);                i++;                cropBoxUpperRightY = Float.valueOf(args[i]);                break;            case TIME:                showTime = true;                break;            case SUBSAMPLING:                subsampling = true;                break;            default:                if (pdfFile == null) {                    pdfFile = args[i];                }                break;        }    }    if (pdfFile == null) {        usage();    } else {        if (outputPrefix == null) {            outputPrefix = pdfFile.substring(0, pdfFile.lastIndexOf('.'));        }        if (quality < 0) {            quality = "png".equals(imageFormat) ? 0f : 1f;        }        try (PDDocument document = PDDocument.load(new File(pdfFile), password)) {            PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();            if (acroForm != null && acroForm.getNeedAppearances()) {                acroForm.refreshAppearances();            }            ImageType imageType = null;            if ("bilevel".equalsIgnoreCase(color)) {                imageType = ImageType.BINARY;            } else if ("gray".equalsIgnoreCase(color)) {                imageType = ImageType.GRAY;            } else if ("rgb".equalsIgnoreCase(color)) {                imageType = ImageType.RGB;            } else if ("rgba".equalsIgnoreCase(color)) {                imageType = ImageType.ARGB;            }            if (imageType == null) {                System.err.println("Error: Invalid color.");                System.exit(2);            }                        if (Float.compare(cropBoxLowerLeftX, 0) != 0 || Float.compare(cropBoxLowerLeftY, 0) != 0 || Float.compare(cropBoxUpperRightX, 0) != 0 || Float.compare(cropBoxUpperRightY, 0) != 0) {                changeCropBox(document, cropBoxLowerLeftX, cropBoxLowerLeftY, cropBoxUpperRightX, cropBoxUpperRightY);            }            long startTime = System.nanoTime();                        boolean success = true;            endPage = Math.min(endPage, document.getNumberOfPages());            PDFRenderer renderer = new PDFRenderer(document);            renderer.setSubsamplingAllowed(subsampling);            for (int i = startPage - 1; i < endPage; i++) {                BufferedImage image = renderer.renderImageWithDPI(i, dpi, imageType);                String fileName = outputPrefix + (i + 1) + "." + imageFormat;                success &= ImageIOUtil.writeImage(image, fileName, dpi, quality);            }                        long endTime = System.nanoTime();            long duration = endTime - startTime;            int count = 1 + endPage - startPage;            if (showTime) {                System.err.printf("Rendered %d page%s in %dms\n", count, count == 1 ? "" : "s", duration / 1000000);            }            if (!success) {                System.err.println("Error: no writer found for image format '" + imageFormat + "'");                System.exit(1);            }        }    }}
private static void pdfbox_f9298_0()
{    String message = "Usage: java -jar pdfbox-app-x.y.z.jar PDFToImage [options] <inputfile>\n" + "\nOptions:\n" + "  -password  <password>            : Password to decrypt document\n" + "  -format <string>                 : Available image formats: " + getImageFormats() + "\n" + "  -prefix <string>                 : Filename prefix for image files\n" + "  -page <int>                      : The only page to extract (1-based)\n" + "  -startPage <int>                 : The first page to start extraction (1-based)\n" + "  -endPage <int>                   : The last page to extract (inclusive)\n" + "  -color <string>                  : The color depth (valid: bilevel, gray, rgb (default), rgba)\n" + "  -dpi <int>                       : The DPI of the output image, default: screen resolution or 96 if unknown\n" + "  -quality <float>                 : The quality to be used when compressing the image (0 <= quality <= 1)\n" + "                                     (default: 0 for PNG and 1 for the other formats)\n" + "  -cropbox <int> <int> <int> <int> : The page area to export\n" + "  -time                            : Prints timing information to stdout\n" + "  -subsampling                     : Activate subsampling (for PDFs with huge images)\n" + "  <inputfile>                      : The PDF document to use\n";    System.err.println(message);    System.exit(1);}
private static String pdfbox_f9299_0()
{    StringBuilder retval = new StringBuilder();    String[] formats = ImageIO.getWriterFormatNames();    for (int i = 0; i < formats.length; i++) {        if (formats[i].equalsIgnoreCase(formats[i])) {            retval.append(formats[i]);            if (i + 1 < formats.length) {                retval.append(", ");            }        }    }    return retval.toString();}
private static void pdfbox_f9300_0(PDDocument document, float a, float b, float c, float d)
{    for (PDPage page : document.getPages()) {        System.out.println("resizing page");        PDRectangle rectangle = new PDRectangle();        rectangle.setLowerLeftX(a);        rectangle.setLowerLeftY(b);        rectangle.setUpperRightX(c);        rectangle.setUpperRightY(d);        page.setCropBox(rectangle);    }}
public static void pdfbox_f9301_0(String[] args) throws PrinterException, IOException
{        System.setProperty("apple.awt.UIElement", "true");    @SuppressWarnings({ "squid:S2068" })    String password = "";    String pdfFile = null;    boolean silentPrint = false;    String printerName = null;    Orientation orientation = Orientation.AUTO;    boolean showPageBorder = false;    int dpi = 0;    Map<String, Orientation> orientationMap = new HashMap<>();    orientationMap.put("auto", Orientation.AUTO);    orientationMap.put("landscape", Orientation.LANDSCAPE);    orientationMap.put("portrait", Orientation.PORTRAIT);    RenderingHints renderingHints = null;    for (int i = 0; i < args.length; i++) {        switch(args[i]) {            case PASSWORD:                i++;                if (i >= args.length) {                    usage();                }                password = args[i];                break;            case PRINTER_NAME:                i++;                if (i >= args.length) {                    usage();                }                printerName = args[i];                break;            case SILENT:                silentPrint = true;                break;            case ORIENTATION:                i++;                if (i >= args.length) {                    usage();                }                orientation = orientationMap.get(args[i]);                if (orientation == null) {                    usage();                }                break;            case BORDER:                showPageBorder = true;                break;            case DPI:                i++;                if (i >= args.length) {                    usage();                }                dpi = Integer.parseInt(args[i]);                break;            case NOCOLOROPT:                renderingHints = new RenderingHints(null);                renderingHints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);                renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);                renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);                break;            default:                pdfFile = args[i];                break;        }    }    if (pdfFile == null) {        usage();    }    try (PDDocument document = PDDocument.load(new File(pdfFile), password)) {        AccessPermission ap = document.getCurrentAccessPermission();        if (!ap.canPrint()) {            throw new IOException("You do not have permission to print");        }        PrinterJob printJob = PrinterJob.getPrinterJob();        printJob.setJobName(new File(pdfFile).getName());        if (printerName != null) {            PrintService[] printServices = PrinterJob.lookupPrintServices();            boolean printerFound = false;            for (int i = 0; !printerFound && i < printServices.length; i++) {                if (printServices[i].getName().equals(printerName)) {                    printJob.setPrintService(printServices[i]);                    printerFound = true;                }            }            if (!printerFound) {                System.err.println("printer '" + printerName + "' not found, using default");                showAvailablePrinters();            }        }        PDFPageable pageable = new PDFPageable(document, orientation, showPageBorder, dpi);        pageable.setRenderingHints(renderingHints);        printJob.setPageable(pageable);        if (silentPrint || printJob.printDialog()) {            printJob.print();        }    }}
private static void pdfbox_f9302_0()
{    String message = "Usage: java -jar pdfbox-app-x.y.z.jar PrintPDF [options] <inputfile>\n" + "\nOptions:\n" + "  -password  <password>                : Password to decrypt document\n" + "  -printerName <name>                  : Print to specific printer\n" + "  -orientation auto|portrait|landscape : Print using orientation\n" + "                                           (default: auto)\n" + "  -border                              : Print with border\n" + "  -dpi                                 : Render into intermediate image with\n" + "                                           specific dpi and then print\n" + "  -noColorOpt                          : Disable color optimizations\n" + "                                           (useful when printing barcodes)\n" + "  -silentPrint                         : Print without printer dialog box\n";    System.err.println(message);    showAvailablePrinters();    System.exit(1);}
private static void pdfbox_f9303_0()
{    System.err.println("Available printer names:");    PrintService[] printServices = PrinterJob.lookupPrintServices();    for (PrintService printService : printServices) {        System.err.println("    " + printService.getName());    }}
public PDDocument pdfbox_f9304_0(Reader text) throws IOException
{    PDDocument doc = new PDDocument();    createPDFFromText(doc, text);    return doc;}
public void pdfbox_f9305_0(PDDocument doc, Reader text) throws IOException
{    try {        final int margin = 40;        float height = font.getBoundingBox().getHeight() / FONTSCALE;        PDRectangle actualMediaBox = mediaBox;        if (landscape) {            actualMediaBox = new PDRectangle(mediaBox.getHeight(), mediaBox.getWidth());        }                height = height * fontSize * LINE_HEIGHT_FACTOR;        BufferedReader data = new BufferedReader(text);        String nextLine;        PDPage page = new PDPage(actualMediaBox);        PDPageContentStream contentStream = null;        float y = -1;        float maxStringLength = page.getMediaBox().getWidth() - 2 * margin;                boolean textIsEmpty = true;        while ((nextLine = data.readLine()) != null) {                                                textIsEmpty = false;            String[] lineWords = nextLine.replaceAll("[\\n\\r]+$", "").split(" ");            int lineIndex = 0;            while (lineIndex < lineWords.length) {                StringBuilder nextLineToDraw = new StringBuilder();                float lengthIfUsingNextWord = 0;                boolean ff = false;                do {                    String word1, word2 = "";                    int indexFF = lineWords[lineIndex].indexOf('\f');                    if (indexFF == -1) {                        word1 = lineWords[lineIndex];                    } else {                        ff = true;                        word1 = lineWords[lineIndex].substring(0, indexFF);                        if (indexFF < lineWords[lineIndex].length()) {                            word2 = lineWords[lineIndex].substring(indexFF + 1);                        }                    }                                        if (word1.length() > 0 || !ff) {                        nextLineToDraw.append(word1);                        nextLineToDraw.append(" ");                    }                    if (!ff || word2.length() == 0) {                        lineIndex++;                    } else {                        lineWords[lineIndex] = word2;                    }                    if (ff) {                        break;                    }                    if (lineIndex < lineWords.length) {                                                String nextWord = lineWords[lineIndex];                        indexFF = nextWord.indexOf('\f');                        if (indexFF != -1) {                            nextWord = nextWord.substring(0, indexFF);                        }                        String lineWithNextWord = nextLineToDraw.toString() + " " + nextWord;                        lengthIfUsingNextWord = (font.getStringWidth(lineWithNextWord) / FONTSCALE) * fontSize;                    }                } while (lineIndex < lineWords.length && lengthIfUsingNextWord < maxStringLength);                if (y < margin) {                                                            page = new PDPage(actualMediaBox);                    doc.addPage(page);                    if (contentStream != null) {                        contentStream.endText();                        contentStream.close();                    }                    contentStream = new PDPageContentStream(doc, page);                    contentStream.setFont(font, fontSize);                    contentStream.beginText();                    y = page.getMediaBox().getHeight() - margin + height;                    contentStream.newLineAtOffset(margin, y);                }                if (contentStream == null) {                    throw new IOException("Error:Expected non-null content stream.");                }                contentStream.newLineAtOffset(0, -height);                y -= height;                contentStream.showText(nextLineToDraw.toString());                if (ff) {                    page = new PDPage(actualMediaBox);                    doc.addPage(page);                    contentStream.endText();                    contentStream.close();                    contentStream = new PDPageContentStream(doc, page);                    contentStream.setFont(font, fontSize);                    contentStream.beginText();                    y = page.getMediaBox().getHeight() - margin + height;                    contentStream.newLineAtOffset(margin, y);                }            }        }                if (textIsEmpty) {            doc.addPage(page);        }        if (contentStream != null) {            contentStream.endText();            contentStream.close();        }    } catch (IOException io) {        if (doc != null) {            doc.close();        }        throw io;    }}
public static void pdfbox_f9306_0(String[] args) throws IOException
{        System.setProperty("apple.awt.UIElement", "true");    TextToPDF app = new TextToPDF();    try (PDDocument doc = new PDDocument()) {        if (args.length < 2) {            app.usage();        } else {            for (int i = 0; i < args.length - 2; i++) {                switch(args[i]) {                    case "-standardFont":                        i++;                        app.setFont(getStandardFont(args[i]));                        break;                    case "-ttf":                        i++;                        PDFont font = PDType0Font.load(doc, new File(args[i]));                        app.setFont(font);                        break;                    case "-fontSize":                        i++;                        app.setFontSize(Integer.parseInt(args[i]));                        break;                    case "-pageSize":                        i++;                        PDRectangle rectangle = createRectangle(args[i]);                        if (rectangle == null) {                            throw new IOException("Unknown argument: " + args[i]);                        }                        app.setMediaBox(rectangle);                        break;                    case "-landscape":                        app.setLandscape(true);                        break;                    default:                        throw new IOException("Unknown argument: " + args[i]);                }            }            try (FileReader fileReader = new FileReader(args[args.length - 1])) {                app.createPDFFromText(doc, fileReader);            }            doc.save(args[args.length - 2]);        }    }}
private static PDRectangle pdfbox_f9307_0(String paperSize)
{    if ("letter".equalsIgnoreCase(paperSize)) {        return PDRectangle.LETTER;    } else if ("legal".equalsIgnoreCase(paperSize)) {        return PDRectangle.LEGAL;    } else if ("A0".equalsIgnoreCase(paperSize)) {        return PDRectangle.A0;    } else if ("A1".equalsIgnoreCase(paperSize)) {        return PDRectangle.A1;    } else if ("A2".equalsIgnoreCase(paperSize)) {        return PDRectangle.A2;    } else if ("A3".equalsIgnoreCase(paperSize)) {        return PDRectangle.A3;    } else if ("A4".equalsIgnoreCase(paperSize)) {        return PDRectangle.A4;    } else if ("A5".equalsIgnoreCase(paperSize)) {        return PDRectangle.A5;    } else if ("A6".equalsIgnoreCase(paperSize)) {        return PDRectangle.A6;    } else {        return null;    }}
private void pdfbox_f9308_0()
{    String[] std14 = getStandard14Names();    StringBuilder message = new StringBuilder();    message.append("Usage: jar -jar pdfbox-app-x.y.z.jar TextToPDF [options] <outputfile> <textfile>\n");    message.append("\nOptions:\n");    message.append("  -standardFont <name> : ").append(DEFAULT_FONT.getBaseFont()).append(" (default)\n");    for (String std14String : std14) {        message.append("                         ").append(std14String).append("\n");    }    message.append("  -ttf <ttf file>      : The TTF font to use.\n");    message.append("  -fontSize <fontSize> : default: ").append(DEFAULT_FONT_SIZE).append("\n");    message.append("  -pageSize <pageSize> : Letter (default)\n");    message.append("                         Legal\n");    message.append("                         A0\n");    message.append("                         A1\n");    message.append("                         A2\n");    message.append("                         A3\n");    message.append("                         A4\n");    message.append("                         A5\n");    message.append("                         A6\n");    message.append("  -landscape           : sets orientation to landscape");    System.err.println(message.toString());    System.exit(1);}
private static PDType1Font pdfbox_f9309_0(String name)
{    return STANDARD_14.get(name);}
private static String[] pdfbox_f9310_0()
{    return STANDARD_14.keySet().toArray(new String[14]);}
public PDFont pdfbox_f9311_0()
{    return font;}
public void pdfbox_f9312_0(PDFont aFont)
{    this.font = aFont;}
public int pdfbox_f9313_0()
{    return fontSize;}
public void pdfbox_f9314_0(int aFontSize)
{    this.fontSize = aFontSize;}
public PDRectangle pdfbox_f9315_0()
{    return mediaBox;}
public void pdfbox_f9316_0(PDRectangle mediaBox)
{    this.mediaBox = mediaBox;}
public boolean pdfbox_f9317_0()
{    return landscape;}
public void pdfbox_f9318_0(boolean landscape)
{    this.landscape = landscape;}
public static String pdfbox_f9319_0()
{    String version = org.apache.pdfbox.util.Version.getVersion();    if (version != null) {        return version;    } else {        return "unknown";    }}
public static void pdfbox_f9320_0(String[] args)
{        System.setProperty("apple.awt.UIElement", "true");    if (args.length != 0) {        usage();        return;    }    System.out.println("Version:" + getVersion());}
private static void pdfbox_f9321_0()
{    System.err.println("Usage: " + Version.class.getName());    System.exit(1);}
public void pdfbox_f9322_0(String in, String out, String password, boolean skipImages) throws IOException
{    try (PDDocument doc = PDDocument.load(new File(in), password)) {        doc.setAllSecurityToBeRemoved(true);        for (COSObject cosObject : doc.getDocument().getObjects()) {            COSBase base = cosObject.getObject();            if (base instanceof COSStream) {                COSStream stream = (COSStream) base;                if (skipImages && COSName.XOBJECT.equals(stream.getItem(COSName.TYPE)) && COSName.IMAGE.equals(stream.getItem(COSName.SUBTYPE))) {                    continue;                }                byte[] bytes;                try {                    bytes = new PDStream(stream).toByteArray();                } catch (IOException ex) {                    System.err.println("skip " + cosObject.getObjectNumber() + " " + cosObject.getGenerationNumber() + " obj: " + ex.getMessage());                    continue;                }                stream.removeItem(COSName.FILTER);                try (OutputStream streamOut = stream.createOutputStream()) {                    streamOut.write(bytes);                }            }        }        doc.getDocumentCatalog();        doc.save(out);    }}
public static void pdfbox_f9323_0(String[] args) throws IOException
{        System.setProperty("apple.awt.UIElement", "true");    WriteDecodedDoc app = new WriteDecodedDoc();    @SuppressWarnings({ "squid:S2068" })    String password = "";    String pdfFile = null;    String outputFile = null;    boolean skipImages = false;    for (int i = 0; i < args.length; i++) {        switch(args[i]) {            case PASSWORD:                i++;                if (i >= args.length) {                    usage();                }                password = args[i];                break;            case SKIPIMAGES:                skipImages = true;                break;            default:                if (pdfFile == null) {                    pdfFile = args[i];                } else {                    outputFile = args[i];                }                break;        }    }    if (pdfFile == null) {        usage();    } else {        if (outputFile == null) {            outputFile = calculateOutputFilename(pdfFile);        }        app.doIt(pdfFile, outputFile, password, skipImages);    }}
private static String pdfbox_f9324_0(String filename)
{    String outputFilename;    if (filename.toLowerCase().endsWith(".pdf")) {        outputFilename = filename.substring(0, filename.length() - 4);    } else {        outputFilename = filename;    }    outputFilename += "_unc.pdf";    return outputFilename;}
private static void pdfbox_f9325_0()
{    String message = "Usage: java -jar pdfbox-app-x.y.z.jar WriteDecodedDoc [options] <inputfile> [outputfile]\n" + "\nOptions:\n" + "  -password <password> : Password to decrypt the document\n" + "  -skipImages          : Don't uncompress images\n" + "  <inputfile>          : The PDF document to be decompressed\n" + "  [outputfile]         : The filename for the decompressed pdf\n";    System.err.println(message);    System.exit(1);}
 void pdfbox_f9326_0(PDResources resources) throws IOException
{    if (resources == null) {        return;    }    for (COSName name : resources.getXObjectNames()) {        PDXObject xobject = resources.getXObject(name);        if (xobject instanceof PDImageXObject) {            PDImageXObject imageObject = (PDImageXObject) xobject;            String suffix = imageObject.getSuffix();            if (suffix != null) {                if ("jpx".equals(suffix)) {                    suffix = "JPEG2000";                }                if ("jb2".equals(suffix)) {                                        suffix = "PNG";                }                boolean writeOK = ImageIOUtil.writeImage(imageObject.getImage(), suffix, new ByteArrayOutputStream());                assertTrue(writeOK);            }        } else if (xobject instanceof PDFormXObject) {            checkSaveResources(((PDFormXObject) xobject).getResources());        }    }}
private void pdfbox_f9327_1(File file, String outDir) throws IOException
{    PDDocument document = null;        try {                float dpi = 36;        document = PDDocument.load(file);                checkSaveResources(document.getPage(0).getResources());                String imageType = "png";        writeImage(document, imageType, outDir + file.getName() + "-", ImageType.RGB, dpi, 0, "");        checkResolution(outDir + file.getName() + "-1." + imageType, (int) dpi);        checkFileTypeByContent(outDir + file.getName() + "-1." + imageType, FileType.PNG);                imageType = "jpg";        writeImage(document, imageType, outDir + file.getName() + "-", ImageType.RGB, dpi, 0.5f, "");        checkResolution(outDir + file.getName() + "-1." + imageType, (int) dpi);        checkFileTypeByContent(outDir + file.getName() + "-1." + imageType, FileType.JPEG);                imageType = "bmp";        writeImage(document, imageType, outDir + file.getName() + "-", ImageType.RGB, dpi, 1, "");        checkResolution(outDir + file.getName() + "-1." + imageType, (int) dpi);        checkFileTypeByContent(outDir + file.getName() + "-1." + imageType, FileType.BMP);                imageType = "gif";        writeImage(document, imageType, outDir + file.getName() + "-", ImageType.RGB, dpi, 1, "");                checkFileTypeByContent(outDir + file.getName() + "-1." + imageType, FileType.GIF);                imageType = "wbmp";        writeImage(document, imageType, outDir + file.getName() + "-", ImageType.BINARY, dpi, 1, "");                        imageType = "tif";        writeImage(document, imageType, outDir + file.getName() + "-bw-", ImageType.BINARY, dpi, 1, "");        checkResolution(outDir + file.getName() + "-bw-1." + imageType, (int) dpi);        checkTiffCompression(outDir + file.getName() + "-bw-1." + imageType, "CCITT T.6");        checkFileTypeByContent(outDir + file.getName() + "-bw-1." + imageType, FileType.TIFF);        writeImage(document, imageType, outDir + file.getName() + "-coLZW-", ImageType.RGB, dpi, 1, "");        checkResolution(outDir + file.getName() + "-coLZW-1." + imageType, (int) dpi);        checkTiffCompression(outDir + file.getName() + "-coLZW-1." + imageType, "LZW");        checkFileTypeByContent(outDir + file.getName() + "-coLZW-1." + imageType, FileType.TIFF);        writeImage(document, imageType, outDir + file.getName() + "-coJPEG-", ImageType.RGB, dpi, 0.5f, "JPEG");        checkResolution(outDir + file.getName() + "-coJPEG-1." + imageType, (int) dpi);        checkTiffCompression(outDir + file.getName() + "-coJPEG-1." + imageType, "JPEG");        checkFileTypeByContent(outDir + file.getName() + "-coJPEG-1." + imageType, FileType.TIFF);        writeImage(document, imageType, outDir + file.getName() + "-coNone-", ImageType.RGB, dpi, 1, null);        checkResolution(outDir + file.getName() + "-coNone-1." + imageType, (int) dpi);        checkTiffCompression(outDir + file.getName() + "-coNone-1." + imageType, "None");        checkFileTypeByContent(outDir + file.getName() + "-coNone-1." + imageType, FileType.TIFF);    } finally {        if (document != null) {            document.close();        }    }}
private void pdfbox_f9328_0(String filename, BufferedImage image) throws IOException
{    BufferedImage newImage = ImageIO.read(new File(filename));    assertNotNull("File '" + filename + "' could not be read", newImage);    checkNotBlank(filename, newImage);    checkBufferedImageSize(filename, image, newImage);    for (int x = 0; x < image.getWidth(); ++x) {        for (int y = 0; y < image.getHeight(); ++y) {            if (image.getRGB(x, y) != newImage.getRGB(x, y)) {                assertEquals("\"File '" + filename + "' has different pixel at (" + x + "," + y + ")", new Color(image.getRGB(x, y)), new Color(newImage.getRGB(x, y)));            }        }    }}
private void pdfbox_f9329_0(String filename, BufferedImage image) throws IOException
{    BufferedImage newImage = ImageIO.read(new File(filename));    assertNotNull("File '" + filename + "' could not be read", newImage);    checkNotBlank(filename, newImage);    checkBufferedImageSize(filename, image, newImage);}
private void pdfbox_f9330_0(String filename, BufferedImage image, BufferedImage newImage) throws IOException
{    assertEquals("File '" + filename + "' has different height after read", image.getHeight(), newImage.getHeight());    assertEquals("File '" + filename + "' has different width after read", image.getWidth(), newImage.getWidth());}
private void pdfbox_f9331_0(String filename, BufferedImage newImage)
{        Set<Integer> colors = new HashSet<>();    int w = newImage.getWidth();    int h = newImage.getHeight();    for (int x = 0; x < w; x++) {        for (int y = 0; y < h; y++) {            colors.add(newImage.getRGB(x, y));        }    }    assertFalse("File '" + filename + "' has less than two colors", colors.size() < 2);}
private void pdfbox_f9332_1(PDDocument document, String imageFormat, String outputPrefix, ImageType imageType, float dpi, float compressionQuality, String compressionType) throws IOException
{    PDFRenderer renderer = new PDFRenderer(document);    BufferedImage image = renderer.renderImageWithDPI(0, dpi, imageType);    String fileName = outputPrefix + 1;            System.out.println("  " + fileName + "." + imageFormat);    try (OutputStream os = new FileOutputStream(fileName + "." + imageFormat)) {        boolean res = ImageIOUtil.writeImage(image, imageFormat, os, Math.round(dpi), compressionQuality, compressionType);        assertTrue("ImageIOUtil.writeImage() failed for file " + fileName, res);    }    if ("jpg".equals(imageFormat) || "gif".equals(imageFormat) || "JPEG".equals(compressionType)) {                        checkImageFileSize(fileName + "." + imageFormat, image);    } else {        checkImageFileSizeAndContent(fileName + "." + imageFormat, image);    }}
public void pdfbox_f9333_0() throws Exception
{    String inDir = "src/test/resources/input/ImageIOUtil";    String outDir = "target/test-output/ImageIOUtil/";    new File(outDir).mkdirs();    if (!new File(outDir).exists()) {        throw new IOException("could not create output directory");    }    File[] testFiles = new File(inDir).listFiles((dir, name) -> (name.endsWith(".pdf") || name.endsWith(".ai")));    for (File file : testFiles) {        doTestFile(file, outDir);    }}
private void pdfbox_f9334_0(String filename, int expectedResolution) throws IOException
{    assertFalse("Empty file " + filename, new File(filename).length() == 0);    String suffix = filename.substring(filename.lastIndexOf('.') + 1);    if ("BMP".equals(suffix.toUpperCase())) {                checkBmpResolution(filename, expectedResolution);        return;    }    Iterator readers = ImageIO.getImageReadersBySuffix(suffix);    assertTrue("No image reader found for suffix " + suffix, readers.hasNext());    ImageReader reader = (ImageReader) readers.next();    try (ImageInputStream iis = ImageIO.createImageInputStream(new File(filename))) {        assertNotNull("No ImageInputStream created for file " + filename, iis);        reader.setInput(iis);        IIOMetadata imageMetadata = reader.getImageMetadata(0);        Element root = (Element) imageMetadata.getAsTree(STANDARD_METADATA_FORMAT);        NodeList dimensionNodes = root.getElementsByTagName("Dimension");        assertTrue("No resolution found in image file " + filename, dimensionNodes.getLength() > 0);        Element dimensionElement = (Element) dimensionNodes.item(0);        NodeList pixelSizeNodes = dimensionElement.getElementsByTagName("HorizontalPixelSize");        assertTrue("No X resolution found in image file " + filename, pixelSizeNodes.getLength() > 0);        Node pixelSizeNode = pixelSizeNodes.item(0);        String val = pixelSizeNode.getAttributes().getNamedItem("value").getNodeValue();        int actualResolution = (int) Math.round(25.4 / Double.parseDouble(val));        assertEquals("X resolution doesn't match in image file " + filename, expectedResolution, actualResolution);        pixelSizeNodes = dimensionElement.getElementsByTagName("VerticalPixelSize");        assertTrue("No Y resolution found in image file " + filename, pixelSizeNodes.getLength() > 0);        pixelSizeNode = pixelSizeNodes.item(0);        val = pixelSizeNode.getAttributes().getNamedItem("value").getNodeValue();        actualResolution = (int) Math.round(25.4 / Double.parseDouble(val));        assertEquals("Y resolution doesn't match", expectedResolution, actualResolution);    }    reader.dispose();}
private void pdfbox_f9335_0(String filename, int expectedResolution) throws FileNotFoundException, IOException
{        try (DataInputStream dis = new DataInputStream(new FileInputStream(new File(filename)))) {        int skipped = dis.skipBytes(38);        assertEquals("Can't skip 38 bytes in image file " + filename, 38, skipped);        int pixelsPerMeter = Integer.reverseBytes(dis.readInt());        int actualResolution = (int) Math.round(pixelsPerMeter / 100.0 * 2.54);        assertEquals("X resolution doesn't match in image file " + filename, expectedResolution, actualResolution);        pixelsPerMeter = Integer.reverseBytes(dis.readInt());        actualResolution = (int) Math.round(pixelsPerMeter / 100.0 * 2.54);        assertEquals("Y resolution doesn't match in image file " + filename, expectedResolution, actualResolution);    }}
 void pdfbox_f9336_0(String filename, String expectedCompression) throws IOException
{    Iterator readers = ImageIO.getImageReadersBySuffix("tiff");    ImageReader reader = (ImageReader) readers.next();    try (ImageInputStream iis = ImageIO.createImageInputStream(new File(filename))) {        reader.setInput(iis);        IIOMetadata imageMetadata = reader.getImageMetadata(0);        Element root = (Element) imageMetadata.getAsTree(STANDARD_METADATA_FORMAT);        Element comprElement = (Element) root.getElementsByTagName("Compression").item(0);        Node comprTypeNode = comprElement.getElementsByTagName("CompressionTypeName").item(0);        String actualCompression = comprTypeNode.getAttributes().getNamedItem("value").getNodeValue();        assertEquals("Incorrect TIFF compression in file " + filename, expectedCompression, actualCompression);    }    reader.dispose();}
private void pdfbox_f9337_0(String filename, FileType fileType) throws IOException
{    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filename));    assertEquals(fileType, FileTypeDetector.detectFileType(bis));    IOUtils.closeQuietly(bis);}
public void pdfbox_f9338_0() throws Exception
{    ByteArrayOutputStream outBytes = new ByteArrayOutputStream();    PrintStream stdout = System.out;    System.setOut(new PrintStream(outBytes));    try {        ExtractText.main(new String[] { "src/test/resources/org/apache/pdfbox/testPDFPackage.pdf", "-console", "-encoding UTF-8" });    } finally {                System.setOut(stdout);    }    String result = outBytes.toString("UTF-8");    assertTrue(result.contains("PDF1"));    assertTrue(result.contains("PDF2"));}
private PDDocument pdfbox_f9339_0(String title, PDFont font, String text) throws IOException
{    PDDocument doc = new PDDocument();    doc.getDocumentInformation().setTitle(title);    PDPage page = new PDPage();    doc.addPage(page);    try (PDPageContentStream contentStream = new PDPageContentStream(doc, page)) {        contentStream.beginText();        contentStream.setFont(font, 12);        contentStream.newLineAtOffset(100, 700);        contentStream.showText(text);        contentStream.endText();    }    return doc;}
public void pdfbox_f9340_0() throws IOException
{    PDFTextStripper stripper = new PDFText2HTML();    PDDocument doc = createDocument("<script>\u3042", PDType1Font.HELVETICA, "<foo>");    String text = stripper.getText(doc);    Matcher m = Pattern.compile("<title>(.*?)</title>").matcher(text);    assertTrue(m.find());    assertEquals("&lt;script&gt;&#12354;", m.group(1));    assertTrue(text.contains("&lt;foo&gt;"));}
public void pdfbox_f9341_0() throws IOException
{    PDFTextStripper stripper = new PDFText2HTML();    PDDocument doc = createDocument("t", PDType1Font.HELVETICA_BOLD, "<bold>");    String text = stripper.getText(doc);    Matcher bodyMatcher = Pattern.compile("<p>(.*?)</p>").matcher(text);    assertTrue("body p exists", bodyMatcher.find());    assertEquals("body p", "<b>&lt;bold&gt;</b>", bodyMatcher.group(1));}
public void pdfbox_f9342_0() throws Exception
{    TextToPDF pdfCreator = new TextToPDF();    PDDocument pdfDoc;    try (StringReader reader = new StringReader("")) {        pdfDoc = pdfCreator.createPDFFromText(reader);    }            int pageCount = pdfDoc.getNumberOfPages();    assertNotNull("All Pages was unexpectedly zero.", pageCount);    assertEquals("Wrong number of pages.", 1, pageCount);    pdfDoc.close();}
public static Test pdfbox_f9343_0()
{    return new TestSuite(TestTextToPdf.class);}
public static void pdfbox_f9344_0(String[] args)
{    String[] arg = { TestTextToPdf.class.getName() };    junit.textui.TestRunner.main(arg);}
public static Calendar pdfbox_f9345_0(String date) throws IOException
{    Calendar retval = null;    if ((date != null) && (date.trim().length() > 0)) {                int month = 1;        int day = 1;        int hour = 0;        int minute = 0;        int second = 0;                try {            SimpleTimeZone zone = null;            if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}T.*", date)) {                                return fromISO8601(date);            } else if (date.startsWith("D:")) {                date = date.substring(2, date.length());            }            date = date.replaceAll("[-:T]", "");            if (date.length() < 4) {                throw new IOException("Error: Invalid date format '" + date + "'");            }            int year = Integer.parseInt(date.substring(0, 4));            if (date.length() >= 6) {                month = Integer.parseInt(date.substring(4, 6));            }            if (date.length() >= 8) {                day = Integer.parseInt(date.substring(6, 8));            }            if (date.length() >= 10) {                hour = Integer.parseInt(date.substring(8, 10));            }            if (date.length() >= 12) {                minute = Integer.parseInt(date.substring(10, 12));            }            int timeZonePos = 12;            if (date.length() - 12 > 5 || (date.length() - 12 == 3 && date.endsWith("Z"))) {                if (date.length() >= 14) {                    second = Integer.parseInt(date.substring(12, 14));                }                timeZonePos = 14;            } else {                second = 0;            }            if (date.length() >= (timeZonePos + 1)) {                char sign = date.charAt(timeZonePos);                if (sign == 'Z') {                    zone = new SimpleTimeZone(0, "Unknown");                } else {                    int hours = 0;                    int minutes = 0;                    if (date.length() >= (timeZonePos + 3)) {                        if (sign == '+') {                                                        hours = Integer.parseInt(date.substring((timeZonePos + 1), (timeZonePos + 3)));                        } else {                            hours = -Integer.parseInt(date.substring(timeZonePos, (timeZonePos + 2)));                        }                    }                    if (sign == '+') {                        if (date.length() >= (timeZonePos + 5)) {                            minutes = Integer.parseInt(date.substring((timeZonePos + 3), (timeZonePos + 5)));                        }                    } else {                        if (date.length() >= (timeZonePos + 4)) {                            minutes = Integer.parseInt(date.substring((timeZonePos + 2), (timeZonePos + 4)));                        }                    }                    zone = new SimpleTimeZone(hours * 60 * 60 * 1000 + minutes * 60 * 1000, "Unknown");                }            }            if (zone == null) {                retval = new GregorianCalendar();            } else {                updateZoneId(zone);                retval = new GregorianCalendar(zone);            }            retval.clear();            retval.set(year, month - 1, day, hour, minute, second);        } catch (NumberFormatException e) {                        if (date.substring(date.length() - 3, date.length() - 2).equals(":") && (date.substring(date.length() - 6, date.length() - 5).equals("+") || date.substring(date.length() - 6, date.length() - 5).equals("-"))) {                                date = date.substring(0, date.length() - 3) + date.substring(date.length() - 2);            }            for (int i = 0; (retval == null) && (i < POTENTIAL_FORMATS.length); i++) {                try {                    Date utilDate = POTENTIAL_FORMATS[i].parse(date);                    retval = new GregorianCalendar();                    retval.setTime(utilDate);                } catch (ParseException pe) {                                }            }            if (retval == null) {                                throw new IOException("Error converting date:" + date, e);            }        }    }    return retval;}
private static void pdfbox_f9346_0(TimeZone tz)
{    int offset = tz.getRawOffset();    char pm = '+';    if (offset < 0) {        pm = '-';        offset = -offset;    }    int hh = offset / 3600000;    int mm = offset % 3600000 / 60000;    if (offset == 0) {        tz.setID("GMT");    } else if (pm == '+' && hh <= 12) {        tz.setID(String.format(Locale.US, "GMT+%02d:%02d", hh, mm));    } else if (pm == '-' && hh <= 14) {        tz.setID(String.format(Locale.US, "GMT-%02d:%02d", hh, mm));    } else {        tz.setID("unknown");    }}
public static String pdfbox_f9347_0(Calendar cal)
{    return toISO8601(cal, false);}
public static String pdfbox_f9348_0(Calendar cal, boolean printMillis)
{    StringBuilder retval = new StringBuilder();    retval.append(cal.get(Calendar.YEAR));    retval.append("-");    retval.append(String.format(Locale.US, "%02d", cal.get(Calendar.MONTH) + 1));    retval.append("-");    retval.append(String.format(Locale.US, "%02d", cal.get(Calendar.DAY_OF_MONTH)));    retval.append("T");    retval.append(String.format(Locale.US, "%02d", cal.get(Calendar.HOUR_OF_DAY)));    retval.append(":");    retval.append(String.format(Locale.US, "%02d", cal.get(Calendar.MINUTE)));    retval.append(":");    retval.append(String.format(Locale.US, "%02d", cal.get(Calendar.SECOND)));    if (printMillis) {        retval.append(".");        retval.append(String.format(Locale.US, "%03d", cal.get(Calendar.MILLISECOND)));    }    int timeZone = cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET);    if (timeZone < 0) {        retval.append("-");    } else {        retval.append("+");    }    timeZone = Math.abs(timeZone);            int hours = timeZone / 1000 / 60 / 60;    int minutes = (timeZone - (hours * 1000 * 60 * 60)) / 1000 / 1000;    if (hours < 10) {        retval.append("0");    }    retval.append(Integer.toString(hours));    retval.append(":");    if (minutes < 10) {        retval.append("0");    }    retval.append(Integer.toString(minutes));    return retval.toString();}
private static Calendar pdfbox_f9349_0(String dateString)
{        Pattern timeZonePattern = Pattern.compile("[\\d-]*T?[\\d-\\.]([A-Z]{1,4})$|(.*\\d*)([A-Z][a-z]+\\/[A-Z][a-z]+)$");    Matcher timeZoneMatcher = timeZonePattern.matcher(dateString);    String timeZoneString = null;    while (timeZoneMatcher.find()) {        for (int i = 1; i <= timeZoneMatcher.groupCount(); i++) {            if (timeZoneMatcher.group(i) != null) {                timeZoneString = timeZoneMatcher.group(i);            }        }    }    if (timeZoneString != null) {                int teeIndex = dateString.indexOf('T');        int tzIndex = dateString.indexOf(timeZoneString);        String toParse = dateString.substring(0, tzIndex);        if (tzIndex - teeIndex == 6) {            toParse = dateString.substring(0, tzIndex) + ":00";        }        Calendar cal = javax.xml.bind.DatatypeConverter.parseDateTime(toParse);        TimeZone z = TimeZone.getTimeZone(timeZoneString);        cal.setTimeZone(z);        return cal;    } else {                int teeIndex = dateString.indexOf('T');        if (teeIndex == -1) {            return javax.xml.bind.DatatypeConverter.parseDateTime(dateString);        }        int plusIndex = dateString.indexOf('+', teeIndex + 1);        int minusIndex = dateString.indexOf('-', teeIndex + 1);        if (plusIndex == -1 && minusIndex == -1) {            return javax.xml.bind.DatatypeConverter.parseDateTime(dateString);        }        plusIndex = Math.max(plusIndex, minusIndex);        if (plusIndex - teeIndex == 6) {            String toParse = dateString.substring(0, plusIndex) + ":00" + dateString.substring(plusIndex);            return javax.xml.bind.DatatypeConverter.parseDateTime(toParse);        }        return javax.xml.bind.DatatypeConverter.parseDateTime(dateString);    }}
public void pdfbox_f9350_0(String value)
{    TextType keywords;    keywords = createTextType(KEYWORDS, value);    addProperty(keywords);}
public void pdfbox_f9351_0(TextType keywords)
{    addProperty(keywords);}
public void pdfbox_f9352_0(String value)
{    TextType version;    version = createTextType(PDF_VERSION, value);    addProperty(version);}
public void pdfbox_f9353_0(TextType version)
{    addProperty(version);}
public void pdfbox_f9354_0(String value)
{    TextType producer;    producer = createTextType(PRODUCER, value);    addProperty(producer);}
public void pdfbox_f9355_0(TextType producer)
{    addProperty(producer);}
public TextType pdfbox_f9356_0()
{    AbstractField tmp = getProperty(KEYWORDS);    if (tmp instanceof TextType) {        return (TextType) tmp;    }    return null;}
public String pdfbox_f9357_0()
{    AbstractField tmp = getProperty(KEYWORDS);    if (tmp instanceof TextType) {        return ((TextType) tmp).getStringValue();    }    return null;}
public TextType pdfbox_f9358_0()
{    AbstractField tmp = getProperty(PDF_VERSION);    if (tmp instanceof TextType) {        return (TextType) tmp;    }    return null;}
public String pdfbox_f9359_0()
{    AbstractField tmp = getProperty(PDF_VERSION);    if (tmp instanceof TextType) {        return ((TextType) tmp).getStringValue();    }    return null;}
public TextType pdfbox_f9360_0()
{    AbstractField tmp = getProperty(PRODUCER);    if (tmp instanceof TextType) {        return (TextType) tmp;    }    return null;}
public String pdfbox_f9361_0()
{    AbstractField tmp = getProperty(PRODUCER);    if (tmp instanceof TextType) {        return ((TextType) tmp).getStringValue();    }    return null;}
public void pdfbox_f9362_0(String properName)
{    addQualifiedBagValue(CONTRIBUTOR, properName);}
public void pdfbox_f9363_0(String properName)
{    removeUnqualifiedBagValue(CONTRIBUTOR, properName);}
public void pdfbox_f9364_0(String text)
{    addProperty(createTextType(COVERAGE, text));}
public void pdfbox_f9365_0(TextType text)
{    addProperty(text);}
public void pdfbox_f9366_0(String properName)
{    addUnqualifiedSequenceValue(CREATOR, properName);}
public void pdfbox_f9367_0(String name)
{    removeUnqualifiedSequenceValue(CREATOR, name);}
public void pdfbox_f9368_0(Calendar date)
{    addUnqualifiedSequenceDateValue(DATE, date);}
public void pdfbox_f9369_0(Calendar date)
{    removeUnqualifiedSequenceDateValue(DATE, date);}
public void pdfbox_f9370_0(String lang, String value)
{    setUnqualifiedLanguagePropertyValue(DESCRIPTION, lang, value);}
public void pdfbox_f9371_0(String value)
{    addDescription(null, value);}
public void pdfbox_f9372_0(String mimeType)
{    addProperty(createTextType(FORMAT, mimeType));}
public void pdfbox_f9373_0(String text)
{    addProperty(createTextType(IDENTIFIER, text));}
public void pdfbox_f9374_0(TextType text)
{    addProperty(text);}
public void pdfbox_f9375_0(String locale)
{    addQualifiedBagValue(LANGUAGE, locale);}
public void pdfbox_f9376_0(String locale)
{    removeUnqualifiedBagValue(LANGUAGE, locale);}
public void pdfbox_f9377_0(String properName)
{    addQualifiedBagValue(PUBLISHER, properName);}
public void pdfbox_f9378_0(String name)
{    removeUnqualifiedBagValue(PUBLISHER, name);}
public void pdfbox_f9379_0(String text)
{    addQualifiedBagValue(RELATION, text);}
public void pdfbox_f9380_0(String text)
{    removeUnqualifiedBagValue(RELATION, text);}
public void pdfbox_f9381_0(String lang, String value)
{    setUnqualifiedLanguagePropertyValue(RIGHTS, lang, value);}
public void pdfbox_f9382_0(String text)
{    addProperty(createTextType(SOURCE, text));}
public void pdfbox_f9383_0(TextType text)
{    addProperty(text);}
public void pdfbox_f9384_0(MIMEType text)
{    addProperty(text);}
public void pdfbox_f9385_0(String text)
{    addQualifiedBagValue(SUBJECT, text);}
public void pdfbox_f9386_0(String text)
{    removeUnqualifiedBagValue(SUBJECT, text);}
public void pdfbox_f9387_0(String lang, String value)
{    setUnqualifiedLanguagePropertyValue(TITLE, lang, value);}
public void pdfbox_f9388_0(String value)
{    setTitle(null, value);}
public void pdfbox_f9389_0(String lang, String value)
{    setTitle(lang, value);}
public void pdfbox_f9390_0(String type)
{    addQualifiedBagValue(TYPE, type);}
public ArrayProperty pdfbox_f9391_0()
{    return (ArrayProperty) getProperty(CONTRIBUTOR);}
public List<String> pdfbox_f9392_0()
{    return getUnqualifiedBagValueList(CONTRIBUTOR);}
public TextType pdfbox_f9393_0()
{    return (TextType) getProperty(COVERAGE);}
public String pdfbox_f9394_0()
{    TextType tt = (TextType) getProperty(COVERAGE);    return tt == null ? null : tt.getStringValue();}
public ArrayProperty pdfbox_f9395_0()
{    return (ArrayProperty) getProperty(CREATOR);}
public List<String> pdfbox_f9396_0()
{    return getUnqualifiedSequenceValueList(CREATOR);}
public ArrayProperty pdfbox_f9397_0()
{    return (ArrayProperty) getProperty(DATE);}
public List<Calendar> pdfbox_f9398_0()
{    return getUnqualifiedSequenceDateValueList(DATE);}
public ArrayProperty pdfbox_f9399_0()
{    return (ArrayProperty) getProperty(DESCRIPTION);}
public List<String> pdfbox_f9400_0()
{    return getUnqualifiedLanguagePropertyLanguagesValue(DESCRIPTION);}
public String pdfbox_f9401_0(String lang)
{    return getUnqualifiedLanguagePropertyValue(DESCRIPTION, lang);}
public String pdfbox_f9402_0()
{    return getDescription(null);}
public TextType pdfbox_f9403_0()
{    return (TextType) getProperty(FORMAT);}
public String pdfbox_f9404_0()
{    TextType tt = (TextType) getProperty(FORMAT);    return tt == null ? null : tt.getStringValue();}
public TextType pdfbox_f9405_0()
{    return (TextType) getProperty(IDENTIFIER);}
public String pdfbox_f9406_0()
{    TextType tt = (TextType) getProperty(IDENTIFIER);    return tt == null ? null : tt.getStringValue();}
public ArrayProperty pdfbox_f9407_0()
{    return (ArrayProperty) getProperty(LANGUAGE);}
public List<String> pdfbox_f9408_0()
{    return getUnqualifiedBagValueList(LANGUAGE);}
public ArrayProperty pdfbox_f9409_0()
{    return (ArrayProperty) getProperty(PUBLISHER);}
public List<String> pdfbox_f9410_0()
{    return getUnqualifiedBagValueList(PUBLISHER);}
public ArrayProperty pdfbox_f9411_0()
{    return (ArrayProperty) getProperty(RELATION);}
public List<String> pdfbox_f9412_0()
{    return getUnqualifiedBagValueList(RELATION);}
public ArrayProperty pdfbox_f9413_0()
{    return (ArrayProperty) getProperty(RIGHTS);}
public List<String> pdfbox_f9414_0()
{    return getUnqualifiedLanguagePropertyLanguagesValue(RIGHTS);}
public String pdfbox_f9415_0(String lang)
{    return getUnqualifiedLanguagePropertyValue(RIGHTS, lang);}
public String pdfbox_f9416_0()
{    return getRights(null);}
public TextType pdfbox_f9417_0()
{    return (TextType) getProperty(SOURCE);}
public String pdfbox_f9418_0()
{    TextType tt = (TextType) getProperty(SOURCE);    return tt == null ? null : tt.getStringValue();}
public ArrayProperty pdfbox_f9419_0()
{    return (ArrayProperty) getProperty(SUBJECT);}
public List<String> pdfbox_f9420_0()
{    return getUnqualifiedBagValueList(SUBJECT);}
public ArrayProperty pdfbox_f9421_0()
{    return (ArrayProperty) getProperty(TITLE);}
public List<String> pdfbox_f9422_0()
{    return getUnqualifiedLanguagePropertyLanguagesValue(TITLE);}
public String pdfbox_f9423_0(String lang)
{    return getUnqualifiedLanguagePropertyValue(TITLE, lang);}
public String pdfbox_f9424_0()
{    return getTitle(null);}
public ArrayProperty pdfbox_f9425_0()
{    return (ArrayProperty) getProperty(TYPE);}
public List<String> pdfbox_f9426_0()
{    return getUnqualifiedBagValueList(TYPE);}
public void pdfbox_f9427_0(String type)
{    removeUnqualifiedBagValue(TYPE, type);}
public ArrayProperty pdfbox_f9428_0()
{    return (ArrayProperty) getProperty(USER_COMMENT);}
public List<String> pdfbox_f9429_0()
{    return getUnqualifiedLanguagePropertyLanguagesValue(USER_COMMENT);}
public String pdfbox_f9430_0(String lang)
{    return getUnqualifiedLanguagePropertyValue(USER_COMMENT, lang);}
public String pdfbox_f9431_0()
{    return getUserComment(null);}
public ArrayProperty pdfbox_f9432_0()
{    return (ArrayProperty) getProperty(SCHEMAS);}
public void pdfbox_f9433_0(String value)
{    IntegerType part = (IntegerType) instanciateSimple(PART, value);    addProperty(part);}
public void pdfbox_f9434_0(int value)
{    IntegerType part = (IntegerType) instanciateSimple(PART, value);    addProperty(part);}
public void pdfbox_f9435_0(Integer value)
{    setPartValueWithInt(value);}
public void pdfbox_f9436_0(IntegerType part)
{    addProperty(part);}
public void pdfbox_f9437_0(String value)
{    TextType amd = createTextType(AMD, value);    addProperty(amd);}
public void pdfbox_f9438_0(TextType amd)
{    addProperty(amd);}
public void pdfbox_f9439_0(String value) throws BadFieldValueException
{    if (value.equals("A") || value.equals("B") || value.equals("U")) {        TextType conf = createTextType(CONFORMANCE, value);        addProperty(conf);    } else {        throw new BadFieldValueException("The property given not seems to be a PDF/A conformance level (must be A, B or U)");    }}
public void pdfbox_f9440_0(TextType conf) throws BadFieldValueException
{    String value = conf.getStringValue();    if (value.equals("A") || value.equals("B") || value.equals("U")) {        addProperty(conf);    } else {        throw new BadFieldValueException("The property given not seems to be a PDF/A conformance level (must be A, B or U)");    }}
public Integer pdfbox_f9441_0()
{    IntegerType tmp = getPartProperty();    if (tmp == null) {        return null;    }    return tmp.getValue();}
public IntegerType pdfbox_f9442_0()
{    AbstractField tmp = getProperty(PART);    if (tmp instanceof IntegerType) {        return (IntegerType) tmp;    }    return null;}
public String pdfbox_f9443_0()
{    AbstractField tmp = getProperty(AMD);    if (tmp instanceof TextType) {        return ((TextType) tmp).getStringValue();    }    return null;}
public TextType pdfbox_f9444_0()
{    AbstractField tmp = getProperty(AMD);    if (tmp instanceof TextType) {        return (TextType) tmp;    }    return null;}
public String pdfbox_f9445_0()
{    TextType tmp = getAmdProperty();    if (tmp == null) {        for (Attribute attribute : getAllAttributes()) {            if (attribute.getName().equals(AMD)) {                return attribute.getValue();            }        }        return null;    } else {        return tmp.getStringValue();    }}
public TextType pdfbox_f9446_0()
{    AbstractField tmp = getProperty(CONFORMANCE);    if (tmp instanceof TextType) {        return (TextType) tmp;    }    return null;}
public String pdfbox_f9447_0()
{    TextType tt = getConformanceProperty();    if (tt == null) {        for (Attribute attribute : getAllAttributes()) {            if (attribute.getName().equals(CONFORMANCE)) {                return attribute.getValue();            }        }        return null;    } else {        return tt.getStringValue();    }}
public URIType pdfbox_f9448_0()
{    return (URIType) getProperty(ANCESTORID);}
public String pdfbox_f9449_0()
{    TextType tt = ((TextType) getProperty(ANCESTORID));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9450_0(String text)
{    URIType tt = (URIType) instanciateSimple(ANCESTORID, text);    setAncestorIDProperty(tt);}
public void pdfbox_f9451_0(URIType text)
{    addProperty(text);}
public TextType pdfbox_f9452_0()
{    return (TextType) getProperty(AUTHORS_POSITION);}
public String pdfbox_f9453_0()
{    TextType tt = ((TextType) getProperty(AUTHORS_POSITION));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9454_0(String text)
{    TextType tt = (TextType) instanciateSimple(AUTHORS_POSITION, text);    setAuthorsPositionProperty(tt);}
public void pdfbox_f9455_0(TextType text)
{    addProperty(text);}
public TextType pdfbox_f9456_0()
{    return (TextType) getProperty(CAPTION_WRITER);}
public String pdfbox_f9457_0()
{    TextType tt = ((TextType) getProperty(CAPTION_WRITER));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9458_0(String text)
{    ProperNameType tt = (ProperNameType) instanciateSimple(CAPTION_WRITER, text);    setCaptionWriterProperty(tt);}
public void pdfbox_f9459_0(ProperNameType text)
{    addProperty(text);}
public TextType pdfbox_f9460_0()
{    return (TextType) getProperty(CATEGORY);}
public String pdfbox_f9461_0()
{    TextType tt = ((TextType) getProperty(CATEGORY));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9462_0(String text)
{    TextType tt = (TextType) instanciateSimple(CATEGORY, text);    setCategoryProperty(tt);}
public void pdfbox_f9463_0(TextType text)
{    addProperty(text);}
public TextType pdfbox_f9464_0()
{    return (TextType) getProperty(CITY);}
public String pdfbox_f9465_0()
{    TextType tt = ((TextType) getProperty(CITY));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9466_0(String text)
{    TextType tt = (TextType) instanciateSimple(CITY, text);    setCityProperty(tt);}
public void pdfbox_f9467_0(TextType text)
{    addProperty(text);}
public IntegerType pdfbox_f9468_0()
{    return (IntegerType) getProperty(COLOR_MODE);}
public Integer pdfbox_f9469_0()
{    IntegerType tt = ((IntegerType) getProperty(COLOR_MODE));    return tt == null ? null : tt.getValue();}
public void pdfbox_f9470_0(String text)
{    IntegerType tt = (IntegerType) instanciateSimple(COLOR_MODE, text);    setColorModeProperty(tt);}
public void pdfbox_f9471_0(IntegerType text)
{    addProperty(text);}
public TextType pdfbox_f9472_0()
{    return (TextType) getProperty(COUNTRY);}
public String pdfbox_f9473_0()
{    TextType tt = ((TextType) getProperty(COUNTRY));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9474_0(String text)
{    TextType tt = (TextType) instanciateSimple(COUNTRY, text);    setCountryProperty(tt);}
public void pdfbox_f9475_0(TextType text)
{    addProperty(text);}
public TextType pdfbox_f9476_0()
{    return (TextType) getProperty(CREDIT);}
public String pdfbox_f9477_0()
{    TextType tt = ((TextType) getProperty(CREDIT));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9478_0(String text)
{    TextType tt = (TextType) instanciateSimple(CREDIT, text);    setCreditProperty(tt);}
public void pdfbox_f9479_0(TextType text)
{    addProperty(text);}
public DateType pdfbox_f9480_0()
{    return (DateType) getProperty(DATE_CREATED);}
public String pdfbox_f9481_0()
{    TextType tt = ((TextType) getProperty(DATE_CREATED));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9482_0(String text)
{    DateType tt = (DateType) instanciateSimple(DATE_CREATED, text);    setDateCreatedProperty(tt);}
public void pdfbox_f9483_0(DateType text)
{    addProperty(text);}
public void pdfbox_f9484_0(String text)
{    addQualifiedBagValue(DOCUMENT_ANCESTORS, text);}
public ArrayProperty pdfbox_f9485_0()
{    return (ArrayProperty) getProperty(DOCUMENT_ANCESTORS);}
public List<String> pdfbox_f9486_0()
{    return getUnqualifiedBagValueList(DOCUMENT_ANCESTORS);}
public TextType pdfbox_f9487_0()
{    return (TextType) getProperty(HEADLINE);}
public String pdfbox_f9488_0()
{    TextType tt = ((TextType) getProperty(HEADLINE));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9489_0(String text)
{    TextType tt = (TextType) instanciateSimple(HEADLINE, text);    setHeadlineProperty(tt);}
public void pdfbox_f9490_0(TextType text)
{    addProperty(text);}
public TextType pdfbox_f9491_0()
{    return (TextType) getProperty(HISTORY);}
public String pdfbox_f9492_0()
{    TextType tt = ((TextType) getProperty(HISTORY));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9493_0(String text)
{    TextType tt = (TextType) instanciateSimple(HISTORY, text);    setHistoryProperty(tt);}
public void pdfbox_f9494_0(TextType text)
{    addProperty(text);}
public TextType pdfbox_f9495_0()
{    return (TextType) getProperty(ICC_PROFILE);}
public String pdfbox_f9496_0()
{    TextType tt = ((TextType) getProperty(ICC_PROFILE));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9497_0(String text)
{    TextType tt = (TextType) instanciateSimple(ICC_PROFILE, text);    setICCProfileProperty(tt);}
public void pdfbox_f9498_0(TextType text)
{    addProperty(text);}
public TextType pdfbox_f9499_0()
{    return (TextType) getProperty(INSTRUCTIONS);}
public String pdfbox_f9500_0()
{    TextType tt = ((TextType) getProperty(INSTRUCTIONS));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9501_0(String text)
{    TextType tt = (TextType) instanciateSimple(INSTRUCTIONS, text);    setInstructionsProperty(tt);}
public void pdfbox_f9502_0(TextType text)
{    addProperty(text);}
public TextType pdfbox_f9503_0()
{    return (TextType) getProperty(SOURCE);}
public String pdfbox_f9504_0()
{    TextType tt = ((TextType) getProperty(SOURCE));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9505_0(String text)
{    TextType source = (TextType) instanciateSimple(SOURCE, text);    setSourceProperty(source);}
public void pdfbox_f9506_0(TextType text)
{    addProperty(text);}
public TextType pdfbox_f9507_0()
{    return (TextType) getProperty(STATE);}
public String pdfbox_f9508_0()
{    TextType tt = ((TextType) getProperty(STATE));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9509_0(String text)
{    TextType tt = (TextType) instanciateSimple(STATE, text);    setStateProperty(tt);}
public void pdfbox_f9510_0(TextType text)
{    addProperty(text);}
public TextType pdfbox_f9511_0()
{    return (TextType) getProperty(SUPPLEMENTAL_CATEGORIES);}
public String pdfbox_f9512_0()
{    TextType tt = ((TextType) getProperty(SUPPLEMENTAL_CATEGORIES));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9513_0(String text)
{    TextType tt = (TextType) instanciateSimple(SUPPLEMENTAL_CATEGORIES, text);    setSupplementalCategoriesProperty(tt);}
public void pdfbox_f9514_0(TextType text)
{    addProperty(text);}
public void pdfbox_f9515_0(String layerName, String layerText)
{    if (seqLayer == null) {        seqLayer = createArrayProperty(TEXT_LAYERS, Cardinality.Seq);        addProperty(seqLayer);    }    LayerType layer = new LayerType(getMetadata());    layer.setLayerName(layerName);    layer.setLayerText(layerText);    seqLayer.getContainer().addProperty(layer);}
public List<LayerType> pdfbox_f9516_0() throws BadFieldValueException
{    List<AbstractField> tmp = getUnqualifiedArrayList(TEXT_LAYERS);    if (tmp != null) {        List<LayerType> layers = new ArrayList<>();        for (AbstractField abstractField : tmp) {            if (abstractField instanceof LayerType) {                layers.add((LayerType) abstractField);            } else {                throw new BadFieldValueException("Layer expected and " + abstractField.getClass().getName() + " found.");            }        }        return layers;    }    return null;}
public TextType pdfbox_f9517_0()
{    return (TextType) getProperty(TRANSMISSION_REFERENCE);}
public String pdfbox_f9518_0()
{    TextType tt = ((TextType) getProperty(TRANSMISSION_REFERENCE));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9519_0(String text)
{    TextType tt = (TextType) instanciateSimple(TRANSMISSION_REFERENCE, text);    setTransmissionReferenceProperty(tt);}
public void pdfbox_f9520_0(TextType text)
{    addProperty(text);}
public IntegerType pdfbox_f9521_0()
{    return (IntegerType) getProperty(URGENCY);}
public Integer pdfbox_f9522_0()
{    IntegerType tt = ((IntegerType) getProperty(URGENCY));    return tt == null ? null : tt.getValue();}
public void pdfbox_f9523_0(String s)
{    IntegerType tt = (IntegerType) instanciateSimple(URGENCY, s);    setUrgencyProperty(tt);}
public void pdfbox_f9524_0(Integer s)
{    IntegerType tt = (IntegerType) instanciateSimple(URGENCY, s);    setUrgencyProperty(tt);}
public void pdfbox_f9525_0(IntegerType text)
{    addProperty(text);}
public ProperNameType pdfbox_f9526_0()
{    return (ProperNameType) getProperty(ARTIST);}
public String pdfbox_f9527_0()
{    ProperNameType tt = (ProperNameType) getProperty(ARTIST);    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9528_0(String text)
{    addProperty(createTextType(ARTIST, text));}
public ArrayProperty pdfbox_f9529_0()
{    return (ArrayProperty) getProperty(IMAGE_DESCRIPTION);}
public List<String> pdfbox_f9530_0()
{    return getUnqualifiedLanguagePropertyLanguagesValue(IMAGE_DESCRIPTION);}
public String pdfbox_f9531_0(String lang)
{    return getUnqualifiedLanguagePropertyValue(IMAGE_DESCRIPTION, lang);}
public String pdfbox_f9532_0()
{    return getImageDescription(null);}
public void pdfbox_f9533_0(String lang, String value)
{    setUnqualifiedLanguagePropertyValue(IMAGE_DESCRIPTION, lang, value);}
public ArrayProperty pdfbox_f9534_0()
{    return (ArrayProperty) getProperty(COPYRIGHT);}
public List<String> pdfbox_f9535_0()
{    return getUnqualifiedLanguagePropertyLanguagesValue(COPYRIGHT);}
public String pdfbox_f9536_0(String lang)
{    return getUnqualifiedLanguagePropertyValue(COPYRIGHT, lang);}
public String pdfbox_f9537_0()
{    return getCopyRight(null);}
public void pdfbox_f9538_0(String lang, String value)
{    setUnqualifiedLanguagePropertyValue(COPYRIGHT, lang, value);}
public void pdfbox_f9539_0(String id, String name, String url)
{    addJob(id, name, url, null);}
public void pdfbox_f9540_0(String id, String name, String url, String fieldPrefix)
{    JobType job = new JobType(getMetadata(), fieldPrefix);    job.setId(id);    job.setName(name);    job.setUrl(url);    addJob(job);}
public void pdfbox_f9541_0(JobType job)
{    String prefix = getNamespacePrefix(job.getNamespace());    if (prefix != null) {                job.setPrefix(prefix);    } else {                addNamespace(job.getNamespace(), job.getPrefix());    }        if (bagJobs == null) {        bagJobs = createArrayProperty(JOB_REF, Cardinality.Bag);        addProperty(bagJobs);    }        bagJobs.getContainer().addProperty(job);}
public List<JobType> pdfbox_f9542_0() throws BadFieldValueException
{    List<AbstractField> tmp = getUnqualifiedArrayList(JOB_REF);    if (tmp != null) {        List<JobType> layers = new ArrayList<>();        for (AbstractField abstractField : tmp) {            if (abstractField instanceof JobType) {                layers.add((JobType) abstractField);            } else {                throw new BadFieldValueException("Job expected and " + abstractField.getClass().getName() + " found.");            }        }        return layers;    }    return null;}
public void pdfbox_f9543_0(Integer height, Integer width, String format, String img)
{    if (altThumbs == null) {        altThumbs = createArrayProperty(THUMBNAILS, Cardinality.Alt);        addProperty(altThumbs);    }    ThumbnailType thumb = new ThumbnailType(getMetadata());    thumb.setHeight(height);    thumb.setWidth(width);    thumb.setFormat(format);    thumb.setImage(img);    altThumbs.getContainer().addProperty(thumb);}
public void pdfbox_f9544_0(String xpath)
{    addQualifiedBagValue(ADVISORY, xpath);}
public void pdfbox_f9545_0(String xpath)
{    removeUnqualifiedBagValue(ADVISORY, xpath);}
public void pdfbox_f9546_0(String url)
{    URLType tt = (URLType) instanciateSimple(BASEURL, url);    setBaseURLProperty(tt);}
public void pdfbox_f9547_0(URLType url)
{    addProperty(url);}
public void pdfbox_f9548_0(Calendar date)
{    DateType tt = (DateType) instanciateSimple(CREATEDATE, date);    setCreateDateProperty(tt);}
public void pdfbox_f9549_0(DateType date)
{    addProperty(date);}
public void pdfbox_f9550_0(String creatorTool)
{    AgentNameType tt = (AgentNameType) instanciateSimple(CREATORTOOL, creatorTool);    setCreatorToolProperty(tt);}
public void pdfbox_f9551_0(AgentNameType creatorTool)
{    addProperty(creatorTool);}
public void pdfbox_f9552_0(String text)
{    addQualifiedBagValue(IDENTIFIER, text);}
public void pdfbox_f9553_0(String text)
{    removeUnqualifiedBagValue(IDENTIFIER, text);}
public void pdfbox_f9554_0(String text)
{    TextType tt = (TextType) instanciateSimple(LABEL, text);    setLabelProperty(tt);}
public void pdfbox_f9555_0(TextType text)
{    addProperty(text);}
public void pdfbox_f9556_0(Calendar date)
{    DateType tt = (DateType) instanciateSimple(METADATADATE, date);    setMetadataDateProperty(tt);}
public void pdfbox_f9557_0(DateType date)
{    addProperty(date);}
public void pdfbox_f9558_0(Calendar date)
{    DateType tt = (DateType) instanciateSimple(MODIFYDATE, date);    setModifyDateProperty(tt);}
public void pdfbox_f9559_0(Calendar date)
{    DateType tt = (DateType) instanciateSimple(MODIFIER_DATE, date);    setModifierDateProperty(tt);}
public void pdfbox_f9560_0(DateType date)
{    addProperty(date);}
public void pdfbox_f9561_0(DateType date)
{    addProperty(date);}
public void pdfbox_f9562_0(String text)
{    TextType tt = (TextType) instanciateSimple(NICKNAME, text);    setNicknameProperty(tt);}
public void pdfbox_f9563_0(TextType text)
{    addProperty(text);}
public void pdfbox_f9564_0(Integer rate)
{    IntegerType tt = (IntegerType) instanciateSimple(RATING, rate);    setRatingProperty(tt);}
public void pdfbox_f9565_0(IntegerType rate)
{    addProperty(rate);}
public ArrayProperty pdfbox_f9566_0()
{    return (ArrayProperty) getProperty(ADVISORY);}
public List<String> pdfbox_f9567_0()
{    return getUnqualifiedBagValueList(ADVISORY);}
public TextType pdfbox_f9568_0()
{    return (TextType) getProperty(BASEURL);}
public String pdfbox_f9569_0()
{    TextType tt = ((TextType) getProperty(BASEURL));    return tt == null ? null : tt.getStringValue();}
public DateType pdfbox_f9570_0()
{    return (DateType) getProperty(CREATEDATE);}
public Calendar pdfbox_f9571_0()
{    DateType createDate = (DateType) getProperty(CREATEDATE);    if (createDate != null) {        return createDate.getValue();    }    return null;}
public TextType pdfbox_f9572_0()
{    return (TextType) getProperty(CREATORTOOL);}
public String pdfbox_f9573_0()
{    TextType tt = ((TextType) getProperty(CREATORTOOL));    return tt == null ? null : tt.getStringValue();}
public ArrayProperty pdfbox_f9574_0()
{    return (ArrayProperty) getProperty(IDENTIFIER);}
public List<String> pdfbox_f9575_0()
{    return getUnqualifiedBagValueList(IDENTIFIER);}
public TextType pdfbox_f9576_0()
{    return (TextType) getProperty(LABEL);}
public String pdfbox_f9577_0()
{    TextType tt = ((TextType) getProperty(LABEL));    return tt == null ? null : tt.getStringValue();}
public DateType pdfbox_f9578_0()
{    return (DateType) getProperty(METADATADATE);}
public Calendar pdfbox_f9579_0()
{    DateType dt = ((DateType) getProperty(METADATADATE));    return dt == null ? null : dt.getValue();}
public DateType pdfbox_f9580_0()
{    return (DateType) getProperty(MODIFYDATE);}
public DateType pdfbox_f9581_0()
{    return (DateType) getProperty(MODIFIER_DATE);}
public Calendar pdfbox_f9582_0()
{    DateType modifyDate = (DateType) getProperty(MODIFYDATE);    if (modifyDate != null) {        return modifyDate.getValue();    }    return null;}
public Calendar pdfbox_f9583_0()
{    DateType modifierDate = (DateType) getProperty(MODIFIER_DATE);    if (modifierDate != null) {        return modifierDate.getValue();    }    return null;}
public TextType pdfbox_f9584_0()
{    return (TextType) getProperty(NICKNAME);}
public String pdfbox_f9585_0()
{    TextType tt = ((TextType) getProperty(NICKNAME));    return tt == null ? null : tt.getStringValue();}
public IntegerType pdfbox_f9586_0()
{    return ((IntegerType) getProperty(RATING));}
public Integer pdfbox_f9587_0()
{    IntegerType it = ((IntegerType) getProperty(RATING));    return it == null ? null : it.getValue();}
public List<ThumbnailType> pdfbox_f9588_0() throws BadFieldValueException
{    List<AbstractField> tmp = getUnqualifiedArrayList(THUMBNAILS);    if (tmp != null) {        List<ThumbnailType> thumbs = new ArrayList<>();        for (AbstractField abstractField : tmp) {            if (abstractField instanceof ThumbnailType) {                thumbs.add((ThumbnailType) abstractField);            } else {                throw new BadFieldValueException("Thumbnail expected and " + abstractField.getClass().getName() + " found.");            }        }        return thumbs;    }    return null;}
public void pdfbox_f9589_0(ResourceRefType tt)
{    addProperty(tt);}
public ResourceRefType pdfbox_f9590_0()
{    return (ResourceRefType) getProperty(DERIVED_FROM);}
public void pdfbox_f9591_0(String url)
{    URIType tt = (URIType) instanciateSimple(DOCUMENTID, url);    setDocumentIDProperty(tt);}
public void pdfbox_f9592_0(URIType tt)
{    addProperty(tt);}
public TextType pdfbox_f9593_0()
{    return (TextType) getProperty(DOCUMENTID);}
public String pdfbox_f9594_0()
{    TextType tt = getDocumentIDProperty();    return tt != null ? tt.getStringValue() : null;}
public void pdfbox_f9595_0(String url)
{    URLType tt = (URLType) instanciateSimple(LAST_URL, url);    setLastURLProperty(tt);}
public void pdfbox_f9596_0(URLType tt)
{    addProperty(tt);}
public URLType pdfbox_f9597_0()
{    return (URLType) getProperty(LAST_URL);}
public String pdfbox_f9598_0()
{    URLType tt = getLastURLProperty();    return tt != null ? tt.getStringValue() : null;}
public void pdfbox_f9599_0(Integer url)
{    IntegerType tt = (IntegerType) instanciateSimple(SAVE_ID, url);    setSaveIDProperty(tt);}
public void pdfbox_f9600_0(IntegerType tt)
{    addProperty(tt);}
public IntegerType pdfbox_f9601_0()
{    return (IntegerType) getProperty(SAVE_ID);}
public Integer pdfbox_f9602_0()
{    IntegerType tt = getSaveIDProperty();    return tt != null ? tt.getValue() : null;}
public void pdfbox_f9603_0(String value)
{    AgentNameType tt = (AgentNameType) instanciateSimple(MANAGER, value);    setManagerProperty(tt);}
public void pdfbox_f9604_0(AgentNameType tt)
{    addProperty(tt);}
public TextType pdfbox_f9605_0()
{    return (TextType) getProperty(MANAGER);}
public String pdfbox_f9606_0()
{    TextType tt = getManagerProperty();    return tt != null ? tt.getStringValue() : null;}
public void pdfbox_f9607_0(String value)
{    URIType tt = (URIType) instanciateSimple(MANAGETO, value);    setManageToProperty(tt);}
public void pdfbox_f9608_0(URIType tt)
{    addProperty(tt);}
public TextType pdfbox_f9609_0()
{    return (TextType) getProperty(MANAGETO);}
public String pdfbox_f9610_0()
{    TextType tt = getManageToProperty();    return tt != null ? tt.getStringValue() : null;}
public void pdfbox_f9611_0(String value)
{    URIType tt = (URIType) instanciateSimple(MANAGEUI, value);    setManageUIProperty(tt);}
public void pdfbox_f9612_0(URIType tt)
{    addProperty(tt);}
public TextType pdfbox_f9613_0()
{    return (TextType) getProperty(MANAGEUI);}
public String pdfbox_f9614_0()
{    TextType tt = getManageUIProperty();    return tt != null ? tt.getStringValue() : null;}
public void pdfbox_f9615_0(String value)
{    TextType tt = (TextType) instanciateSimple(MANAGERVARIANT, value);    setManagerVariantProperty(tt);}
public void pdfbox_f9616_0(TextType tt)
{    addProperty(tt);}
public TextType pdfbox_f9617_0()
{    return (TextType) getProperty(MANAGERVARIANT);}
public String pdfbox_f9618_0()
{    TextType tt = getManagerVariantProperty();    return tt != null ? tt.getStringValue() : null;}
public void pdfbox_f9619_0(String value)
{    URIType tt = (URIType) instanciateSimple(INSTANCEID, value);    setInstanceIDProperty(tt);}
public void pdfbox_f9620_0(URIType tt)
{    addProperty(tt);}
public TextType pdfbox_f9621_0()
{    return (TextType) getProperty(INSTANCEID);}
public String pdfbox_f9622_0()
{    TextType tt = getInstanceIDProperty();    return tt != null ? tt.getStringValue() : null;}
public void pdfbox_f9623_0(ResourceRefType resourceRef)
{    addProperty(resourceRef);}
public ResourceRefType pdfbox_f9624_0()
{    return (ResourceRefType) getProperty(MANAGED_FROM);}
public void pdfbox_f9625_0(String url)
{    TextType tt = (TextType) instanciateSimple(ORIGINALDOCUMENTID, url);    setOriginalDocumentIDProperty(tt);}
public void pdfbox_f9626_0(TextType tt)
{    addProperty(tt);}
public TextType pdfbox_f9627_0()
{    return (TextType) getProperty(ORIGINALDOCUMENTID);}
public String pdfbox_f9628_0()
{    TextType tt = getOriginalDocumentIDProperty();    return tt != null ? tt.getStringValue() : null;}
public void pdfbox_f9629_0(String value)
{    RenditionClassType tt = (RenditionClassType) instanciateSimple(RENDITIONCLASS, value);    setRenditionClassProperty(tt);}
public void pdfbox_f9630_0(RenditionClassType tt)
{    addProperty(tt);}
public TextType pdfbox_f9631_0()
{    return (TextType) getProperty(RENDITIONCLASS);}
public String pdfbox_f9632_0()
{    TextType tt = getRenditionClassProperty();    return tt != null ? tt.getStringValue() : null;}
public void pdfbox_f9633_0(String url)
{    TextType tt = (TextType) instanciateSimple(RENDITIONPARAMS, url);    setRenditionParamsProperty(tt);}
public void pdfbox_f9634_0(TextType tt)
{    addProperty(tt);}
public TextType pdfbox_f9635_0()
{    return (TextType) getProperty(RENDITIONPARAMS);}
public String pdfbox_f9636_0()
{    TextType tt = getRenditionParamsProperty();    return tt != null ? tt.getStringValue() : null;}
public void pdfbox_f9637_0(String value)
{    TextType tt = (TextType) instanciateSimple(VERSIONID, value);    setVersionIDProperty(tt);}
public void pdfbox_f9638_0(TextType tt)
{    addProperty(tt);}
public TextType pdfbox_f9639_0()
{    return (TextType) getProperty(VERSIONID);}
public String pdfbox_f9640_0()
{    TextType tt = getVersionIDProperty();    return tt != null ? tt.getStringValue() : null;}
public void pdfbox_f9641_0(String value)
{    addQualifiedBagValue(VERSIONS, value);}
public ArrayProperty pdfbox_f9642_0()
{    return (ArrayProperty) getProperty(VERSIONS);}
public List<String> pdfbox_f9643_0()
{    return getUnqualifiedBagValueList(VERSIONS);}
public void pdfbox_f9644_0(String history)
{    addUnqualifiedSequenceValue(HISTORY, history);}
public ArrayProperty pdfbox_f9645_0()
{    return (ArrayProperty) getProperty(HISTORY);}
public List<String> pdfbox_f9646_0()
{    return getUnqualifiedSequenceValueList(HISTORY);}
public void pdfbox_f9647_0(String ingredients)
{    addQualifiedBagValue(INGREDIENTS, ingredients);}
public ArrayProperty pdfbox_f9648_0()
{    return (ArrayProperty) getProperty(INGREDIENTS);}
public List<String> pdfbox_f9649_0()
{    return getUnqualifiedBagValueList(INGREDIENTS);}
public void pdfbox_f9650_0(String value)
{    addQualifiedBagValue(OWNER, value);}
public void pdfbox_f9651_0(String value)
{    removeUnqualifiedBagValue(OWNER, value);}
public ArrayProperty pdfbox_f9652_0()
{    return (ArrayProperty) getProperty(OWNER);}
public List<String> pdfbox_f9653_0()
{    return getUnqualifiedBagValueList(OWNER);}
public void pdfbox_f9654_0(Boolean marked)
{    BooleanType tt = (BooleanType) instanciateSimple(MARKED, marked ? BooleanType.TRUE : BooleanType.FALSE);    setMarkedProperty(tt);}
public void pdfbox_f9655_0(BooleanType marked)
{    addProperty(marked);}
public BooleanType pdfbox_f9656_0()
{    return (BooleanType) getProperty(MARKED);}
public Boolean pdfbox_f9657_0()
{    BooleanType bt = ((BooleanType) getProperty(MARKED));    return bt == null ? null : bt.getValue();}
public void pdfbox_f9658_0(String lang, String value)
{    setUnqualifiedLanguagePropertyValue(USAGETERMS, lang, value);}
public void pdfbox_f9659_0(String terms)
{    addUsageTerms(null, terms);}
public ArrayProperty pdfbox_f9660_0()
{    return (ArrayProperty) getProperty(USAGETERMS);}
public List<String> pdfbox_f9661_0()
{    return getUnqualifiedLanguagePropertyLanguagesValue(USAGETERMS);}
public String pdfbox_f9662_0(String lang)
{    return getUnqualifiedLanguagePropertyValue(USAGETERMS, lang);}
public String pdfbox_f9663_0()
{    return getUsageTerms(null);}
public TextType pdfbox_f9664_0()
{    return ((TextType) getProperty(WEBSTATEMENT));}
public String pdfbox_f9665_0()
{    TextType tt = ((TextType) getProperty(WEBSTATEMENT));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9666_0(String url)
{    URLType tt = (URLType) instanciateSimple(WEBSTATEMENT, url);    setWebStatementProperty(tt);}
public void pdfbox_f9667_0(URLType url)
{    addProperty(url);}
public TextType pdfbox_f9668_0()
{    return ((TextType) getProperty(CERTIFICATE));}
public String pdfbox_f9669_0()
{    TextType tt = ((TextType) getProperty(CERTIFICATE));    return tt == null ? null : tt.getStringValue();}
public void pdfbox_f9670_0(String url)
{    URLType tt = (URLType) instanciateSimple(CERTIFICATE, url);    setCertificateProperty(tt);}
public void pdfbox_f9671_0(URLType url)
{    addProperty(url);}
public AbstractField pdfbox_f9672_0(String qualifiedName)
{    for (AbstractField child : getContainer().getAllProperties()) {        if (child.getPropertyName().equals(qualifiedName)) {            return child;        }    }    return null;}
public Attribute pdfbox_f9673_0()
{    return getAttribute(XmpConstants.ABOUT_NAME);}
public String pdfbox_f9674_0()
{    Attribute prop = getAttribute(XmpConstants.ABOUT_NAME);    if (prop != null) {        return prop.getValue();    }        return "";}
public void pdfbox_f9675_0(Attribute about) throws BadFieldValueException
{    if (XmpConstants.RDF_NAMESPACE.equals(about.getNamespace()) && XmpConstants.ABOUT_NAME.equals(about.getName())) {        setAttribute(about);        return;    }    throw new BadFieldValueException("Attribute 'about' must be named 'rdf:about' or 'about'");}
public void pdfbox_f9676_0(String about)
{    if (about == null) {        removeAttribute(XmpConstants.ABOUT_NAME);    } else {        setAttribute(new Attribute(XmpConstants.RDF_NAMESPACE, XmpConstants.ABOUT_NAME, about));    }}
private void pdfbox_f9677_0(Types type, String qualifiedName, Object propertyValue)
{    if (propertyValue == null) {                for (AbstractField child : getContainer().getAllProperties()) {            if (child.getPropertyName().equals(qualifiedName)) {                getContainer().removeProperty(child);                return;            }        }    } else {        AbstractSimpleProperty specifiedTypeProperty;        try {            TypeMapping tm = getMetadata().getTypeMapping();            specifiedTypeProperty = tm.instanciateSimpleProperty(null, getPrefix(), qualifiedName, propertyValue, type);        } catch (Exception e) {            throw new IllegalArgumentException("Failed to create property with the specified type given in parameters", e);        }                for (AbstractField child : getAllProperties()) {            if (child.getPropertyName().equals(qualifiedName)) {                removeProperty(child);                addProperty(specifiedTypeProperty);                return;            }        }        addProperty(specifiedTypeProperty);    }}
private void pdfbox_f9678_0(AbstractSimpleProperty prop)
{        for (AbstractField child : getAllProperties()) {        if (child.getPropertyName().equals(prop.getPropertyName())) {            removeProperty(child);            addProperty(prop);            return;        }    }    addProperty(prop);}
public void pdfbox_f9679_0(TextType prop)
{    setSpecifiedSimpleTypeProperty(prop);}
public void pdfbox_f9680_0(String qualifiedName, String propertyValue)
{    setSpecifiedSimpleTypeProperty(Types.Text, qualifiedName, propertyValue);}
public void pdfbox_f9681_0(String simpleName, String propertyValue)
{    this.setTextPropertyValue(simpleName, propertyValue);}
public TextType pdfbox_f9682_0(String name)
{    AbstractField prop = getAbstractProperty(name);    if (prop != null) {        if (prop instanceof TextType) {            return (TextType) prop;        } else {            throw new IllegalArgumentException("Property asked is not a Text Property");        }    }    return null;}
public String pdfbox_f9683_0(String name)
{    TextType tt = getUnqualifiedTextProperty(name);    return tt == null ? null : tt.getStringValue();}
public DateType pdfbox_f9684_0(String qualifiedName)
{    AbstractField prop = getAbstractProperty(qualifiedName);    if (prop != null) {        if (prop instanceof DateType) {            return (DateType) prop;        } else {            throw new IllegalArgumentException("Property asked is not a Date Property");        }    }    return null;}
public Calendar pdfbox_f9685_0(String simpleName)
{    return this.getDatePropertyValue(simpleName);}
public Calendar pdfbox_f9686_0(String qualifiedName)
{    AbstractField prop = getAbstractProperty(qualifiedName);    if (prop != null) {        if (prop instanceof DateType) {            return ((DateType) prop).getValue();        } else {            throw new IllegalArgumentException("Property asked is not a Date Property");        }    }    return null;}
public void pdfbox_f9687_0(DateType date)
{    setSpecifiedSimpleTypeProperty(date);}
public void pdfbox_f9688_0(String simpleName, Calendar date)
{    this.setDatePropertyValue(simpleName, date);}
public void pdfbox_f9689_0(String qualifiedName, Calendar date)
{    setSpecifiedSimpleTypeProperty(Types.Date, qualifiedName, date);}
public BooleanType pdfbox_f9690_0(String qualifiedName)
{    AbstractField prop = getAbstractProperty(qualifiedName);    if (prop != null) {        if (prop instanceof BooleanType) {            return (BooleanType) prop;        } else {            throw new IllegalArgumentException("Property asked is not a Boolean Property");        }    }    return null;}
public Boolean pdfbox_f9691_0(String simpleName)
{    return this.getBooleanPropertyValue(simpleName);}
public Boolean pdfbox_f9692_0(String qualifiedName)
{    AbstractField prop = getAbstractProperty(qualifiedName);    if (prop != null) {        if (prop instanceof BooleanType) {            return ((BooleanType) prop).getValue();        } else {            throw new IllegalArgumentException("Property asked is not a Boolean Property");        }    }    return null;}
public void pdfbox_f9693_0(BooleanType bool)
{    setSpecifiedSimpleTypeProperty(bool);}
public void pdfbox_f9694_0(String simpleName, Boolean bool)
{    this.setBooleanPropertyValue(simpleName, bool);}
public void pdfbox_f9695_0(String qualifiedName, Boolean bool)
{    setSpecifiedSimpleTypeProperty(Types.Boolean, qualifiedName, bool);}
public IntegerType pdfbox_f9696_0(String qualifiedName)
{    AbstractField prop = getAbstractProperty(qualifiedName);    if (prop != null) {        if (prop instanceof IntegerType) {            return ((IntegerType) prop);        } else {            throw new IllegalArgumentException("Property asked is not an Integer Property");        }    }    return null;}
public Integer pdfbox_f9697_0(String simpleName)
{    return this.getIntegerPropertyValue(simpleName);}
public Integer pdfbox_f9698_0(String qualifiedName)
{    AbstractField prop = getAbstractProperty(qualifiedName);    if (prop != null) {        if (prop instanceof IntegerType) {            return ((IntegerType) prop).getValue();        } else {            throw new IllegalArgumentException("Property asked is not an Integer Property");        }    }    return null;}
public void pdfbox_f9699_0(IntegerType prop)
{    setSpecifiedSimpleTypeProperty(prop);}
public void pdfbox_f9700_0(String simpleName, Integer intValue)
{    this.setIntegerPropertyValue(simpleName, intValue);}
public void pdfbox_f9701_0(String qualifiedName, Integer intValue)
{    setSpecifiedSimpleTypeProperty(Types.Integer, qualifiedName, intValue);}
private void pdfbox_f9702_0(String arrayName, String fieldValue)
{    ArrayProperty array = (ArrayProperty) getAbstractProperty(arrayName);    if (array != null) {        List<AbstractField> toDelete = new ArrayList<>();        for (AbstractField abstractField : array.getContainer().getAllProperties()) {            AbstractSimpleProperty tmp = (AbstractSimpleProperty) abstractField;            if (tmp.getStringValue().equals(fieldValue)) {                toDelete.add(tmp);            }        }        for (AbstractField aToDelete : toDelete) {            array.getContainer().removeProperty(aToDelete);        }    }}
public void pdfbox_f9703_0(String bagName, String bagValue)
{    removeUnqualifiedArrayValue(bagName, bagValue);}
public void pdfbox_f9704_0(String simpleName, String bagValue)
{    this.internalAddBagValue(simpleName, bagValue);}
private void pdfbox_f9705_0(String qualifiedBagName, String bagValue)
{    ArrayProperty bag = (ArrayProperty) getAbstractProperty(qualifiedBagName);    TextType li = createTextType(XmpConstants.LIST_NAME, bagValue);    if (bag != null) {        bag.getContainer().addProperty(li);    } else {        ArrayProperty newBag = createArrayProperty(qualifiedBagName, Cardinality.Bag);        newBag.getContainer().addProperty(li);        addProperty(newBag);    }}
public void pdfbox_f9706_0(String simpleName, String bagValue)
{    internalAddBagValue(simpleName, bagValue);}
public List<String> pdfbox_f9707_0(String bagName)
{    ArrayProperty array = (ArrayProperty) getAbstractProperty(bagName);    if (array != null) {        return array.getElementsAsString();    } else {        return null;    }}
public void pdfbox_f9708_0(String qualifiedSeqName, String seqValue)
{    removeUnqualifiedArrayValue(qualifiedSeqName, seqValue);}
public void pdfbox_f9709_0(String arrayName, AbstractField fieldValue)
{    ArrayProperty array = (ArrayProperty) getAbstractProperty(arrayName);    if (array != null) {        List<AbstractField> toDelete = new ArrayList<>();        for (AbstractField abstractField : array.getContainer().getAllProperties()) {            AbstractSimpleProperty tmp = (AbstractSimpleProperty) abstractField;            if (tmp.equals(fieldValue)) {                toDelete.add(tmp);            }        }        for (AbstractField aToDelete : toDelete) {            array.getContainer().removeProperty(aToDelete);        }    }}
public void pdfbox_f9710_0(String qualifiedSeqName, AbstractField seqValue)
{    removeUnqualifiedArrayValue(qualifiedSeqName, seqValue);}
public void pdfbox_f9711_0(String simpleSeqName, String seqValue)
{    ArrayProperty seq = (ArrayProperty) getAbstractProperty(simpleSeqName);    TextType li = createTextType(XmpConstants.LIST_NAME, seqValue);    if (seq != null) {        seq.getContainer().addProperty(li);    } else {        ArrayProperty newSeq = createArrayProperty(simpleSeqName, Cardinality.Seq);        newSeq.getContainer().addProperty(li);        addProperty(newSeq);    }}
public void pdfbox_f9712_0(String qualifiedSeqName, AbstractField seqValue)
{    ArrayProperty bag = (ArrayProperty) getAbstractProperty(qualifiedSeqName);    if (bag != null) {        bag.getContainer().addProperty(seqValue);    } else {        ArrayProperty newBag = createArrayProperty(qualifiedSeqName, Cardinality.Bag);        newBag.getContainer().addProperty(seqValue);        addProperty(newBag);    }}
public void pdfbox_f9713_0(String seqName, AbstractField seqValue)
{    ArrayProperty seq = (ArrayProperty) getAbstractProperty(seqName);    if (seq != null) {        seq.getContainer().addProperty(seqValue);    } else {        ArrayProperty newSeq = createArrayProperty(seqName, Cardinality.Seq);        newSeq.getContainer().addProperty(seqValue);        addProperty(newSeq);    }}
public List<String> pdfbox_f9714_0(String seqName)
{    ArrayProperty array = (ArrayProperty) getAbstractProperty(seqName);    if (array != null) {        return array.getElementsAsString();    } else {        return null;    }}
public void pdfbox_f9715_0(String seqName, Calendar date)
{    ArrayProperty seq = (ArrayProperty) getAbstractProperty(seqName);    if (seq != null) {        List<AbstractField> toDelete = new ArrayList<>();        for (AbstractField tmp : seq.getContainer().getAllProperties()) {            if (tmp instanceof DateType && ((DateType) tmp).getValue().equals(date)) {                toDelete.add(tmp);            }        }        for (AbstractField aToDelete : toDelete) {            seq.getContainer().removeProperty(aToDelete);        }    }}
public void pdfbox_f9716_0(String simpleName, Calendar date)
{    addUnqualifiedSequenceDateValue(simpleName, date);}
public void pdfbox_f9717_0(String seqName, Calendar date)
{    addUnqualifiedSequenceValue(seqName, getMetadata().getTypeMapping().createDate(null, XmpConstants.DEFAULT_RDF_LOCAL_NAME, XmpConstants.LIST_NAME, date));}
public List<Calendar> pdfbox_f9718_0(String seqName)
{    List<Calendar> retval = null;    ArrayProperty seq = (ArrayProperty) getAbstractProperty(seqName);    if (seq != null) {        retval = new ArrayList<>();        for (AbstractField child : seq.getContainer().getAllProperties()) {            if (child instanceof DateType) {                retval.add(((DateType) child).getValue());            }        }    }    return retval;}
public void pdfbox_f9719_0(ComplexPropertyContainer alt)
{    Iterator<AbstractField> it = alt.getAllProperties().iterator();    AbstractField xdefault = null;    boolean xdefaultFound = false;        if (it.hasNext() && it.next().getAttribute(XmpConstants.LANG_NAME).getValue().equals(XmpConstants.X_DEFAULT)) {        return;    }        while (it.hasNext() && !xdefaultFound) {        xdefault = it.next();        if (xdefault.getAttribute(XmpConstants.LANG_NAME).getValue().equals(XmpConstants.X_DEFAULT)) {            alt.removeProperty(xdefault);            xdefaultFound = true;        }    }    if (xdefaultFound) {        it = alt.getAllProperties().iterator();        List<AbstractField> reordered = new ArrayList<>();        List<AbstractField> toDelete = new ArrayList<>();        reordered.add(xdefault);        while (it.hasNext()) {            AbstractField tmp = it.next();            reordered.add(tmp);            toDelete.add(tmp);        }        for (AbstractField aToDelete : toDelete) {            alt.removeProperty(aToDelete);        }        it = reordered.iterator();        while (it.hasNext()) {            alt.addProperty(it.next());        }    }}
public void pdfbox_f9720_0(String name, String language, String value)
{    if (language == null || language.isEmpty()) {        language = XmpConstants.X_DEFAULT;    }    AbstractField property = getAbstractProperty(name);    ArrayProperty arrayProp;    if (property != null) {                if (property instanceof ArrayProperty) {            arrayProp = (ArrayProperty) property;                        for (AbstractField child : arrayProp.getContainer().getAllProperties()) {                                if (child.getAttribute(XmpConstants.LANG_NAME).getValue().equals(language)) {                                        arrayProp.getContainer().removeProperty(child);                    if (value != null) {                        TextType langValue = createTextType(XmpConstants.LIST_NAME, value);                        langValue.setAttribute(new Attribute(XMLConstants.XML_NS_URI, XmpConstants.LANG_NAME, language));                        arrayProp.getContainer().addProperty(langValue);                    }                    reorganizeAltOrder(arrayProp.getContainer());                    return;                }            }                        TextType langValue = createTextType(XmpConstants.LIST_NAME, value);            langValue.setAttribute(new Attribute(XMLConstants.XML_NS_URI, XmpConstants.LANG_NAME, language));            arrayProp.getContainer().addProperty(langValue);            reorganizeAltOrder(arrayProp.getContainer());        }    } else {        arrayProp = createArrayProperty(name, Cardinality.Alt);        TextType langValue = createTextType(XmpConstants.LIST_NAME, value);        langValue.setAttribute(new Attribute(XMLConstants.XML_NS_URI, XmpConstants.LANG_NAME, language));        arrayProp.getContainer().addProperty(langValue);        addProperty(arrayProp);    }}
public String pdfbox_f9721_0(String name, String expectedLanguage)
{    String language = (expectedLanguage != null) ? expectedLanguage : XmpConstants.X_DEFAULT;    AbstractField property = getAbstractProperty(name);    if (property != null) {        if (property instanceof ArrayProperty) {            ArrayProperty arrayProp = (ArrayProperty) property;            for (AbstractField child : arrayProp.getContainer().getAllProperties()) {                Attribute text = child.getAttribute(XmpConstants.LANG_NAME);                if (text != null && text.getValue().equals(language)) {                    return ((TextType) child).getStringValue();                }            }            return null;        } else {            throw new IllegalArgumentException("The property '" + name + "' is not of Lang Alt type");        }    }    return null;}
public List<String> pdfbox_f9722_0(String name)
{    AbstractField property = getAbstractProperty(name);    if (property != null) {        if (property instanceof ArrayProperty) {            List<String> retval = new ArrayList<>();            ArrayProperty arrayProp = (ArrayProperty) property;            for (AbstractField child : arrayProp.getContainer().getAllProperties()) {                Attribute text = child.getAttribute(XmpConstants.LANG_NAME);                if (text != null) {                    retval.add(text.getValue());                } else {                    retval.add(XmpConstants.X_DEFAULT);                }            }            return retval;        } else {            throw new IllegalArgumentException("The property '" + name + "' is not of Lang Alt type");        }    }        return null;}
public void pdfbox_f9723_0(XMPSchema xmpSchema) throws IOException
{    if (!xmpSchema.getClass().equals(this.getClass())) {        throw new IOException("Can only merge schemas of the same type.");    }    for (Attribute att : xmpSchema.getAllAttributes()) {        if (att.getNamespace().equals(getNamespace())) {            setAttribute(att);        }    }    String analyzedPropQualifiedName;    for (AbstractField child : xmpSchema.getContainer().getAllProperties()) {        if (child.getPrefix().equals(getPrefix())) {            if (child instanceof ArrayProperty) {                analyzedPropQualifiedName = child.getPropertyName();                for (AbstractField tmpEmbeddedProperty : getAllProperties()) {                    if (tmpEmbeddedProperty instanceof ArrayProperty && tmpEmbeddedProperty.getPropertyName().equals(analyzedPropQualifiedName)) {                        Iterator<AbstractField> itNewValues = ((ArrayProperty) child).getContainer().getAllProperties().iterator();                        if (mergeComplexProperty(itNewValues, (ArrayProperty) tmpEmbeddedProperty)) {                            return;                        }                    }                }            } else {                addProperty(child);            }        }    }}
private boolean pdfbox_f9724_0(Iterator<AbstractField> itNewValues, ArrayProperty arrayProperty)
{    while (itNewValues.hasNext()) {        TextType tmpNewValue = (TextType) itNewValues.next();        for (AbstractField abstractField : arrayProperty.getContainer().getAllProperties()) {            TextType tmpOldValue = (TextType) abstractField;            if (tmpOldValue.getStringValue().equals(tmpNewValue.getStringValue())) {                return true;            }        }        arrayProperty.getContainer().addProperty(tmpNewValue);    }    return false;}
public List<AbstractField> pdfbox_f9725_0(String name) throws BadFieldValueException
{    ArrayProperty array = null;    for (AbstractField child : getAllProperties()) {        if (child.getPropertyName().equals(name)) {            if (child instanceof ArrayProperty) {                array = (ArrayProperty) child;                break;            }            throw new BadFieldValueException("Property asked is not an array");        }    }    if (array != null) {        return new ArrayList<>(array.getContainer().getAllProperties());    }    return null;}
protected AbstractSimpleProperty pdfbox_f9726_0(String propertyName, Object value)
{    TypeMapping tm = getMetadata().getTypeMapping();    return tm.instanciateSimpleField(getClass(), null, getPrefix(), propertyName, value);}
public String pdfbox_f9727_0()
{    return namespace;}
public PropertyType pdfbox_f9728_0(String name)
{    return propDef.getPropertyType(name);}
public XMPSchema pdfbox_f9729_0(XMPMetadata metadata, String prefix) throws XmpSchemaException
{    XMPSchema schema;    Class<?>[] argsClass;    Object[] schemaArgs;    if (schemaClass == XMPSchema.class) {        argsClass = new Class[] { XMPMetadata.class, String.class, String.class };        schemaArgs = new Object[] { metadata, namespace, nsName };    } else if (prefix != null && !"".equals(prefix)) {        argsClass = new Class[] { XMPMetadata.class, String.class };        schemaArgs = new Object[] { metadata, prefix };    } else {        argsClass = new Class[] { XMPMetadata.class };        schemaArgs = new Object[] { metadata };    }    try {        schema = schemaClass.getDeclaredConstructor(argsClass).newInstance(schemaArgs);        if (schema != null) {            metadata.addSchema(schema);        }        return schema;    } catch (Exception e) {        throw new XmpSchemaException("Cannot instanciate specified object schema", e);    }}
public PropertiesDescription pdfbox_f9730_0()
{    return this.propDef;}
public void pdfbox_f9731_0(String namespace, String prefix)
{    this.namespaceToPrefix.put(namespace, prefix);}
public String pdfbox_f9732_0(String namespace)
{    return this.namespaceToPrefix.get(namespace);}
public Map<String, String> pdfbox_f9733_0()
{    return this.namespaceToPrefix;}
public final void pdfbox_f9734_0(AbstractField obj)
{        if (!(this instanceof ArrayProperty)) {        container.removePropertiesByName(obj.getPropertyName());    }    container.addProperty(obj);}
public final void pdfbox_f9735_0(AbstractField property)
{    container.removeProperty(property);}
public final ComplexPropertyContainer pdfbox_f9736_0()
{    return container;}
public final List<AbstractField> pdfbox_f9737_0()
{    return container.getAllProperties();}
public final AbstractField pdfbox_f9738_0(String fieldName)
{    List<AbstractField> list = container.getPropertiesByLocalName(fieldName);        if (list == null) {        return null;    }        return list.get(0);}
public final ArrayProperty pdfbox_f9739_0(String fieldName)
{    List<AbstractField> list = container.getPropertiesByLocalName(fieldName);        if (list == null) {        return null;    }        return (ArrayProperty) list.get(0);}
protected final AbstractField pdfbox_f9740_0(String localName, Class<? extends AbstractField> type)
{    return container.getFirstEquivalentProperty(localName, type);}
public final String pdfbox_f9741_0()
{    return propertyName;}
public final void pdfbox_f9742_0(String value)
{    this.propertyName = value;}
public final void pdfbox_f9743_0(Attribute value)
{    if (attributes.containsKey(value.getName())) {                attributes.remove(value.getName());    }    attributes.put(value.getName(), value);}
public final boolean pdfbox_f9744_0(String qualifiedName)
{    return attributes.containsKey(qualifiedName);}
public final Attribute pdfbox_f9745_0(String qualifiedName)
{    return attributes.get(qualifiedName);}
public final List<Attribute> pdfbox_f9746_0()
{    return new ArrayList<>(attributes.values());}
public final void pdfbox_f9747_0(String qualifiedName)
{    if (containsAttribute(qualifiedName)) {        attributes.remove(qualifiedName);    }}
public final XMPMetadata pdfbox_f9748_0()
{    return metadata;}
public Object pdfbox_f9749_0()
{    return rawValue;}
public String pdfbox_f9750_0()
{    return "[" + this.getClass().getSimpleName() + ":" + getStringValue() + "]";}
public final String pdfbox_f9751_0()
{    return namespace;}
public String pdfbox_f9752_0()
{    return prefix;}
public final String pdfbox_f9753_0()
{    return namespace;}
public final void pdfbox_f9754_0(String ns)
{    this.namespace = ns;}
public final String pdfbox_f9755_0()
{    return prefix;}
public final void pdfbox_f9756_0(String pf)
{    this.prefix = pf;}
public final String pdfbox_f9757_0()
{    return preferedPrefix;}
protected void pdfbox_f9758_0(String propertyName, Object value)
{    TypeMapping tm = getMetadata().getTypeMapping();    AbstractSimpleProperty asp = tm.instanciateSimpleField(getClass(), null, getPrefix(), propertyName, value);    addProperty(asp);}
protected String pdfbox_f9759_0(String fieldName)
{    AbstractSimpleProperty absProp = (AbstractSimpleProperty) getProperty(fieldName);    if (absProp == null) {        return null;    } else {        return absProp.getStringValue();    }}
protected Calendar pdfbox_f9760_0(String fieldName)
{    DateType absProp = (DateType) getFirstEquivalentProperty(fieldName, DateType.class);    if (absProp != null) {        return absProp.getValue();    } else {        return null;    }}
public TextType pdfbox_f9761_0(String propertyName, String value)
{    return getMetadata().getTypeMapping().createText(getNamespace(), getPrefix(), propertyName, value);}
public ArrayProperty pdfbox_f9762_0(String propertyName, Cardinality type)
{    return getMetadata().getTypeMapping().createArrayProperty(getNamespace(), getPrefix(), propertyName, type);}
public Cardinality pdfbox_f9763_0()
{    return arrayType;}
public List<String> pdfbox_f9764_0()
{    List<String> retval;    retval = new ArrayList<>();    Iterator<AbstractField> it = getContainer().getAllProperties().iterator();    AbstractSimpleProperty tmp;    while (it.hasNext()) {        tmp = (AbstractSimpleProperty) it.next();        retval.add(tmp.getStringValue());    }    retval = Collections.unmodifiableList(retval);    return retval;}
public final String pdfbox_f9765_0()
{    return namespace;}
public String pdfbox_f9766_0()
{    return prefix;}
public String pdfbox_f9767_0()
{    return name;}
public void pdfbox_f9768_0(String lname)
{    name = lname;}
public String pdfbox_f9769_0()
{    return nsURI;}
public void pdfbox_f9770_0(String nsURI)
{    this.nsURI = nsURI;}
public String pdfbox_f9771_0()
{    return value;}
public void pdfbox_f9772_0(String value)
{    this.value = value;}
public String pdfbox_f9773_0()
{    return "[attr:{" + nsURI + "}" + name + "=" + value + "]";}
public Boolean pdfbox_f9774_0()
{    return booleanValue;}
public void pdfbox_f9775_0(Object value)
{    if (value instanceof Boolean) {        booleanValue = (Boolean) value;    } else if (value instanceof String) {                String s = value.toString().trim().toUpperCase();        if ("TRUE".equals(s)) {            booleanValue = true;        } else if ("FALSE".equals(s)) {            booleanValue = false;        } else {                        throw new IllegalArgumentException("Not a valid boolean value : '" + value + "'");        }    } else {                throw new IllegalArgumentException("Value given is not allowed for the Boolean type.");    }}
public String pdfbox_f9776_0()
{    return booleanValue ? TRUE : FALSE;}
public boolean pdfbox_f9777_0()
{    return this.array;}
protected AbstractField pdfbox_f9778_0(String localName, Class<? extends AbstractField> type)
{    List<AbstractField> list = getPropertiesByLocalName(localName);    if (list != null) {        for (AbstractField abstractField : list) {            if (abstractField.getClass().equals(type)) {                return abstractField;            }        }    }    return null;}
public void pdfbox_f9779_0(AbstractField obj)
{    if (containsProperty(obj)) {        removeProperty(obj);    }    properties.add(obj);}
public List<AbstractField> pdfbox_f9780_0()
{    return properties;}
public List<AbstractField> pdfbox_f9781_0(String localName)
{    List<AbstractField> absFields = getAllProperties();    if (absFields != null) {        List<AbstractField> list = new ArrayList<>();        for (AbstractField abstractField : absFields) {            if (abstractField.getPropertyName().equals(localName)) {                list.add(abstractField);            }        }        if (list.isEmpty()) {            return null;        } else {            return list;        }    }    return null;}
public boolean pdfbox_f9782_0(AbstractField prop1, AbstractField prop2)
{    if (prop1.getClass().equals(prop2.getClass())) {        String pn1 = prop1.getPropertyName();        String pn2 = prop2.getPropertyName();        if (pn1 == null) {            return pn2 == null;        } else {            if (pn1.equals(pn2)) {                return prop1.equals(prop2);            }        }    }    return false;}
public boolean pdfbox_f9783_0(AbstractField property)
{    Iterator<AbstractField> it = getAllProperties().iterator();    AbstractField tmp;    while (it.hasNext()) {        tmp = it.next();        if (isSameProperty(tmp, property)) {            return true;        }    }    return false;}
public void pdfbox_f9784_0(AbstractField property)
{    if (containsProperty(property)) {        properties.remove(property);    }}
public void pdfbox_f9785_0(String localName)
{    if (properties.isEmpty()) {        return;    }    List<AbstractField> propList = getPropertiesByLocalName(localName);    if (propList == null) {        return;    }    for (AbstractField field : propList) {        properties.remove(field);    }}
private void pdfbox_f9786_0(Calendar value)
{    dateValue = value;}
public Calendar pdfbox_f9787_0()
{    return dateValue;}
private boolean pdfbox_f9788_0(Object value)
{    if (value instanceof Calendar) {        return true;    } else if (value instanceof String) {        try {            DateConverter.toCalendar((String) value);            return true;        } catch (IOException e) {            return false;        }    }    return false;}
public void pdfbox_f9789_0(Object value)
{    if (!isGoodType(value)) {        if (value == null) {            throw new IllegalArgumentException("Value null is not allowed for the Date type");        }        throw new IllegalArgumentException("Value given is not allowed for the Date type: " + value.getClass() + ", value: " + value);    } else {                if (value instanceof String) {            setValueFromString((String) value);        } else {                        setValueFromCalendar((Calendar) value);        }    }}
public String pdfbox_f9790_0()
{    return DateConverter.toISO8601(dateValue);}
private void pdfbox_f9791_0(String value)
{    try {        setValueFromCalendar(DateConverter.toCalendar(value));    } catch (IOException e) {                throw new IllegalArgumentException(e);    }}
public void pdfbox_f9792_0(String name, PropertyType type)
{    definedProperties.put(name, type);}
public Map<String, PropertyType> pdfbox_f9793_0()
{    return definedProperties;}
public Integer pdfbox_f9794_0()
{    return integerValue;}
public void pdfbox_f9795_0(Object value)
{    if (value instanceof Integer) {        integerValue = (Integer) value;    } else if (value instanceof String) {        integerValue = Integer.parseInt((String) value);        } else {                throw new IllegalArgumentException("Value given is not allowed for the Integer type: " + value);    }}
public String pdfbox_f9796_0()
{    return Integer.toString(integerValue);}
public void pdfbox_f9797_0(String id)
{    addSimpleProperty(ID, id);}
public void pdfbox_f9798_0(String name)
{    addSimpleProperty(NAME, name);}
public void pdfbox_f9799_0(String name)
{    addSimpleProperty(URL, name);}
public String pdfbox_f9800_0()
{    return getPropertyValueAsString(ID);}
public String pdfbox_f9801_0()
{    return getPropertyValueAsString(NAME);}
public String pdfbox_f9802_0()
{    return getPropertyValueAsString(URL);}
public String pdfbox_f9803_0()
{    AbstractField absProp = getFirstEquivalentProperty(LAYER_NAME, TextType.class);    if (absProp != null) {        return ((TextType) absProp).getStringValue();    }    return null;}
public void pdfbox_f9804_0(String image)
{    this.addProperty(createTextType(LAYER_NAME, image));}
public String pdfbox_f9805_0()
{    AbstractField absProp = getFirstEquivalentProperty(LAYER_TEXT, TextType.class);    if (absProp != null) {        return ((TextType) absProp).getStringValue();    }    return null;}
public void pdfbox_f9806_0(String image)
{    this.addProperty(createTextType(LAYER_TEXT, image));}
public String pdfbox_f9807_0()
{    TextType tt = (TextType) getProperty(NAME);    return tt == null ? null : tt.getStringValue();}
public String pdfbox_f9808_0()
{    TextType tt = (TextType) getProperty(VALUETYPE);    return tt == null ? null : tt.getStringValue();}
public String pdfbox_f9809_0()
{    TextType tt = (TextType) getProperty(DESCRIPTION);    return tt == null ? null : tt.getStringValue();}
public String pdfbox_f9810_0()
{    TextType tt = (TextType) getProperty(NAME);    return tt == null ? null : tt.getStringValue();}
public String pdfbox_f9811_0()
{    ChoiceType tt = (ChoiceType) getProperty(VALUETYPE);    return tt == null ? null : tt.getStringValue();}
public String pdfbox_f9812_0()
{    TextType tt = (TextType) getProperty(DESCRIPTION);    return tt == null ? null : tt.getStringValue();}
public String pdfbox_f9813_0()
{    ChoiceType tt = (ChoiceType) getProperty(CATEGORY);    return tt == null ? null : tt.getStringValue();}
public String pdfbox_f9814_0()
{    URIType tt = (URIType) getProperty(NAMESPACE_URI);    return tt == null ? null : tt.getStringValue();}
public String pdfbox_f9815_0()
{    TextType tt = (TextType) getProperty(PREFIX);    return tt == null ? null : tt.getStringValue();}
public ArrayProperty pdfbox_f9816_0()
{    return getArrayProperty(PROPERTY);}
public ArrayProperty pdfbox_f9817_0()
{    return getArrayProperty(VALUE_TYPE);}
public String pdfbox_f9818_0()
{    URIType tt = (URIType) getProperty(NS_URI);    return tt == null ? null : tt.getStringValue();}
public String pdfbox_f9819_0()
{    TextType tt = (TextType) getProperty(TYPE);    return tt == null ? null : tt.getStringValue();}
public String pdfbox_f9820_0()
{    TextType tt = (TextType) getProperty(PREFIX);    return tt == null ? null : tt.getStringValue();}
public String pdfbox_f9821_0()
{    TextType tt = (TextType) getProperty(DESCRIPTION);    return tt == null ? null : tt.getStringValue();}
public ArrayProperty pdfbox_f9822_0()
{    return getArrayProperty(FIELD);}
public List<String> pdfbox_f9823_0()
{    return new ArrayList<>(types.keySet());}
public void pdfbox_f9824_0(String name, PropertyType type)
{    types.put(name, type);}
public PropertyType pdfbox_f9825_0(String name)
{    return types.get(name);}
public Float pdfbox_f9826_0()
{    return realValue;}
public void pdfbox_f9827_0(Object value)
{    if (value instanceof Float) {        realValue = (Float) value;    } else if (value instanceof String) {                realValue = Float.valueOf((String) value);    } else {                throw new IllegalArgumentException("Value given is not allowed for the Real type: " + value);    }}
public String pdfbox_f9828_0()
{    return Float.toString(realValue);}
public String pdfbox_f9829_0()
{    return getPropertyValueAsString(INSTANCE_ID);}
public void pdfbox_f9830_0(String value)
{    addSimpleProperty(INSTANCE_ID, value);}
public String pdfbox_f9831_0()
{    return getPropertyValueAsString(SOFTWARE_AGENT);}
public void pdfbox_f9832_0(String value)
{    addSimpleProperty(SOFTWARE_AGENT, value);}
public Calendar pdfbox_f9833_0()
{    return getDatePropertyAsCalendar(WHEN);}
public void pdfbox_f9834_0(Calendar value)
{    addSimpleProperty(WHEN, value);}
public String pdfbox_f9835_0()
{    return getPropertyValueAsString(ACTION);}
public void pdfbox_f9836_0(String value)
{    addSimpleProperty(ACTION, value);}
public String pdfbox_f9837_0()
{    return getPropertyValueAsString(CHANGED);}
public void pdfbox_f9838_0(String value)
{    addSimpleProperty(CHANGED, value);}
public String pdfbox_f9839_0()
{    return getPropertyValueAsString(PARAMETERS);}
public void pdfbox_f9840_0(String value)
{    addSimpleProperty(PARAMETERS, value);}
public String pdfbox_f9841_0()
{    TextType absProp = (TextType) getFirstEquivalentProperty(DOCUMENT_ID, URIType.class);    if (absProp != null) {        return absProp.getStringValue();    } else {        return null;    }}
public void pdfbox_f9842_0(String value)
{    addSimpleProperty(DOCUMENT_ID, value);}
public String pdfbox_f9843_0()
{    TextType absProp = (TextType) getFirstEquivalentProperty(FILE_PATH, URIType.class);    if (absProp != null) {        return absProp.getStringValue();    } else {        return null;    }}
public void pdfbox_f9844_0(String value)
{    addSimpleProperty(FILE_PATH, value);}
public String pdfbox_f9845_0()
{    TextType absProp = (TextType) getFirstEquivalentProperty(INSTANCE_ID, URIType.class);    if (absProp != null) {        return absProp.getStringValue();    } else {        return null;    }}
public void pdfbox_f9846_0(String value)
{    addSimpleProperty(INSTANCE_ID, value);}
public Calendar pdfbox_f9847_0()
{    DateType absProp = (DateType) getFirstEquivalentProperty(LAST_MODIFY_DATE, DateType.class);    if (absProp != null) {        return absProp.getValue();    } else {        return null;    }}
public void pdfbox_f9848_0(Calendar value)
{    addSimpleProperty(LAST_MODIFY_DATE, value);}
public String pdfbox_f9849_0()
{    TextType absProp = (TextType) getFirstEquivalentProperty(MANAGE_UI, URIType.class);    if (absProp != null) {        return absProp.getStringValue();    } else {        return null;    }}
public void pdfbox_f9850_0(String value)
{    addSimpleProperty(MANAGE_UI, value);}
public String pdfbox_f9851_0()
{    TextType absProp = (TextType) getFirstEquivalentProperty(MANAGE_TO, URIType.class);    if (absProp != null) {        return absProp.getStringValue();    } else {        return null;    }}
public void pdfbox_f9852_0(String value)
{    addSimpleProperty(MANAGE_TO, value);}
public String pdfbox_f9853_0()
{    TextType absProp = (TextType) getFirstEquivalentProperty(MANAGER, AgentNameType.class);    if (absProp != null) {        return absProp.getStringValue();    } else {        return null;    }}
public void pdfbox_f9854_0(String value)
{    addSimpleProperty(MANAGER, value);}
public String pdfbox_f9855_0()
{    TextType absProp = (TextType) getFirstEquivalentProperty(MANAGER_VARIANT, TextType.class);    if (absProp != null) {        return absProp.getStringValue();    } else {        return null;    }}
public void pdfbox_f9856_0(String value)
{    addSimpleProperty(MANAGER_VARIANT, value);}
public String pdfbox_f9857_0()
{    TextType absProp = (TextType) getFirstEquivalentProperty(PART_MAPPING, TextType.class);    if (absProp != null) {        return absProp.getStringValue();    } else {        return null;    }}
public void pdfbox_f9858_0(String value)
{    addSimpleProperty(PART_MAPPING, value);}
public String pdfbox_f9859_0()
{    TextType absProp = (TextType) getFirstEquivalentProperty(RENDITION_PARAMS, TextType.class);    if (absProp != null) {        return absProp.getStringValue();    } else {        return null;    }}
public void pdfbox_f9860_0(String value)
{    addSimpleProperty(RENDITION_PARAMS, value);}
public String pdfbox_f9861_0()
{    TextType absProp = (TextType) getFirstEquivalentProperty(VERSION_ID, TextType.class);    if (absProp != null) {        return absProp.getStringValue();    } else {        return null;    }}
public void pdfbox_f9862_0(String value)
{    addSimpleProperty(VERSION_ID, value);}
public String pdfbox_f9863_0()
{    TextType absProp = (TextType) getFirstEquivalentProperty(MASK_MARKERS, ChoiceType.class);    if (absProp != null) {        return absProp.getStringValue();    } else {        return null;    }}
public void pdfbox_f9864_0(String value)
{    addSimpleProperty(MASK_MARKERS, value);}
public String pdfbox_f9865_0()
{    TextType absProp = (TextType) getFirstEquivalentProperty(RENDITION_CLASS, RenditionClassType.class);    if (absProp != null) {        return absProp.getStringValue();    } else {        return null;    }}
public void pdfbox_f9866_0(String value)
{    addSimpleProperty(RENDITION_CLASS, value);}
public String pdfbox_f9867_0()
{    TextType absProp = (TextType) getFirstEquivalentProperty(FROM_PART, PartType.class);    if (absProp != null) {        return absProp.getStringValue();    } else {        return null;    }}
public void pdfbox_f9868_0(String value)
{    addSimpleProperty(FROM_PART, value);}
public String pdfbox_f9869_0()
{    TextType absProp = (TextType) getFirstEquivalentProperty(TO_PART, PartType.class);    if (absProp != null) {        return absProp.getStringValue();    } else {        return null;    }}
public void pdfbox_f9870_0(String value)
{    addSimpleProperty(TO_PART, value);}
public void pdfbox_f9871_0(String value)
{    ArrayProperty seq = (ArrayProperty) getFirstEquivalentProperty(ALTERNATE_PATHS, ArrayProperty.class);    if (seq == null) {        seq = getMetadata().getTypeMapping().createArrayProperty(null, getPreferedPrefix(), ALTERNATE_PATHS, Cardinality.Seq);        addProperty(seq);    }    TypeMapping tm = getMetadata().getTypeMapping();    TextType tt = (TextType) tm.instanciateSimpleProperty(null, "rdf", "li", value, Types.Text);    seq.addProperty(tt);}
public ArrayProperty pdfbox_f9872_0()
{    return (ArrayProperty) getFirstEquivalentProperty(ALTERNATE_PATHS, ArrayProperty.class);}
public List<String> pdfbox_f9873_0()
{    ArrayProperty seq = (ArrayProperty) getFirstEquivalentProperty(ALTERNATE_PATHS, ArrayProperty.class);    if (seq != null) {        return seq.getElementsAsString();    } else {        return null;    }}
public void pdfbox_f9874_0(Object value)
{    if (!(value instanceof String)) {        throw new IllegalArgumentException("Value given is not allowed for the Text type : '" + value + "'");    } else {        textValue = (String) value;    }}
public String pdfbox_f9875_0()
{    return textValue;}
public Object pdfbox_f9876_0()
{    return textValue;}
public Integer pdfbox_f9877_0()
{    AbstractField absProp = getFirstEquivalentProperty(HEIGHT, IntegerType.class);    if (absProp != null) {        return ((IntegerType) absProp).getValue();    }    return null;}
public void pdfbox_f9878_0(Integer height)
{    addSimpleProperty(HEIGHT, height);}
public Integer pdfbox_f9879_0()
{    AbstractField absProp = getFirstEquivalentProperty(WIDTH, IntegerType.class);    if (absProp != null) {        return ((IntegerType) absProp).getValue();    }    return null;}
public void pdfbox_f9880_0(Integer width)
{    addSimpleProperty(WIDTH, width);}
public String pdfbox_f9881_0()
{    AbstractField absProp = getFirstEquivalentProperty(IMAGE, TextType.class);    if (absProp != null) {        return ((TextType) absProp).getStringValue();    }    return null;}
public void pdfbox_f9882_0(String image)
{    addSimpleProperty(IMAGE, image);}
public String pdfbox_f9883_0()
{    AbstractField absProp = getFirstEquivalentProperty(FORMAT, ChoiceType.class);    if (absProp != null) {        return ((TextType) absProp).getStringValue();    }    return null;}
public void pdfbox_f9884_0(String format)
{    addSimpleProperty(FORMAT, format);}
private void pdfbox_f9885_0()
{        structuredMappings = new EnumMap<>(Types.class);    structuredNamespaces = new HashMap<>();    for (Types type : Types.values()) {        if (type.isStructured()) {            Class<? extends AbstractStructuredType> clz = type.getImplementingClass().asSubclass(AbstractStructuredType.class);            StructuredType st = clz.getAnnotation(StructuredType.class);            String ns = st.namespace();            PropertiesDescription pm = initializePropMapping(clz);            structuredNamespaces.put(ns, type);            structuredMappings.put(type, pm);        }    }        definedStructuredNamespaces = new HashMap<>();    definedStructuredMappings = new HashMap<>();        schemaMap = new HashMap<>();    addNameSpace(XMPBasicSchema.class);    addNameSpace(DublinCoreSchema.class);    addNameSpace(PDFAExtensionSchema.class);    addNameSpace(XMPMediaManagementSchema.class);    addNameSpace(AdobePDFSchema.class);    addNameSpace(PDFAIdentificationSchema.class);    addNameSpace(XMPRightsManagementSchema.class);    addNameSpace(PhotoshopSchema.class);    addNameSpace(XMPBasicJobTicketSchema.class);    addNameSpace(ExifSchema.class);    addNameSpace(TiffSchema.class);    addNameSpace(XMPageTextSchema.class);}
public void pdfbox_f9886_0(String typeName, String ns, PropertiesDescription pm)
{    definedStructuredNamespaces.put(ns, typeName);    definedStructuredMappings.put(typeName, pm);}
public PropertiesDescription pdfbox_f9887_0(String namespace)
{    String dt = definedStructuredNamespaces.get(namespace);    return this.definedStructuredMappings.get(dt);}
public AbstractStructuredType pdfbox_f9888_0(Types type, String propertyName) throws BadFieldValueException
{    try {        Class<? extends AbstractStructuredType> propertyTypeClass = type.getImplementingClass().asSubclass(AbstractStructuredType.class);        Constructor<? extends AbstractStructuredType> construct = propertyTypeClass.getDeclaredConstructor(XMPMetadata.class);        AbstractStructuredType tmp = construct.newInstance(metadata);        tmp.setPropertyName(propertyName);        return tmp;    } catch (InvocationTargetException | IllegalArgumentException | InstantiationException | IllegalAccessException | SecurityException | NoSuchMethodException e) {        throw new BadFieldValueException("Failed to instanciate structured type : " + type, e);    }}
public AbstractStructuredType pdfbox_f9889_0(String propertyName, String namespace)
{    return new DefinedStructuredType(metadata, namespace, null, propertyName);}
public AbstractSimpleProperty pdfbox_f9890_0(String nsuri, String prefix, String name, Object value, Types type)
{        Object[] params = new Object[] { metadata, nsuri, prefix, name, value };        Class<? extends AbstractSimpleProperty> clz = type.getImplementingClass().asSubclass(AbstractSimpleProperty.class);    try {        Constructor<? extends AbstractSimpleProperty> cons = clz.getDeclaredConstructor(SIMPLEPROPERTYCONSTPARAMS);        return cons.newInstance(params);    } catch (NoSuchMethodError | IllegalArgumentException | InstantiationException | IllegalAccessException | InvocationTargetException | SecurityException | NoSuchMethodException e) {        throw new IllegalArgumentException("Failed to instanciate " + clz.getSimpleName() + " property with value " + value, e);    }}
public AbstractSimpleProperty pdfbox_f9891_0(Class<?> clz, String nsuri, String prefix, String propertyName, Object value)
{    PropertiesDescription pm = initializePropMapping(clz);    PropertyType simpleType = pm.getPropertyType(propertyName);    Types type = simpleType.type();    return instanciateSimpleProperty(nsuri, prefix, propertyName, value, type);}
public boolean pdfbox_f9892_0(String namespace)
{    return structuredNamespaces.containsKey(namespace);}
public boolean pdfbox_f9893_0(String namespace)
{    return definedStructuredNamespaces.containsKey(namespace);}
public boolean pdfbox_f9894_0(String name)
{    return this.definedStructuredMappings.containsKey(name);}
private void pdfbox_f9895_0(Class<? extends XMPSchema> classSchem)
{    StructuredType st = classSchem.getAnnotation(StructuredType.class);    String ns = st.namespace();    schemaMap.put(ns, new XMPSchemaFactory(ns, classSchem, initializePropMapping(classSchem)));}
public void pdfbox_f9896_0(String ns, String prefered)
{    PropertiesDescription mapping = new PropertiesDescription();    schemaMap.put(ns, new XMPSchemaFactory(ns, XMPSchema.class, mapping));}
public PropertiesDescription pdfbox_f9897_0(Types type)
{    return structuredMappings.get(type);}
public XMPSchema pdfbox_f9898_0(XMPMetadata metadata, String namespace, String prefix) throws XmpSchemaException
{    if (schemaMap.containsKey(namespace)) {        XMPSchemaFactory factory = schemaMap.get(namespace);        return factory.createXMPSchema(metadata, prefix);    } else {        XMPSchemaFactory factory = getSchemaFactory(namespace);        return factory != null ? factory.createXMPSchema(metadata, prefix) : null;    }}
public XMPSchemaFactory pdfbox_f9899_0(String namespace)
{    return schemaMap.get(namespace);}
public boolean pdfbox_f9900_0(String namespace)
{    return schemaMap.containsKey(namespace);}
public boolean pdfbox_f9901_0(String namespace)
{    return isDefinedSchema(namespace) || isStructuredTypeNamespace(namespace) || isDefinedTypeNamespace(namespace);}
public PropertyType pdfbox_f9902_0(QName name) throws BadFieldValueException
{    XMPSchemaFactory factory = getSchemaFactory(name.getNamespaceURI());    if (factory != null) {                return factory.getPropertyType(name.getLocalPart());    } else {                Types st = structuredNamespaces.get(name.getNamespaceURI());        if (st != null) {            return createPropertyType(st, Cardinality.Simple);        } else {                        String dt = definedStructuredNamespaces.get(name.getNamespaceURI());            if (dt == null) {                                throw new BadFieldValueException("No descriptor found for " + name);            } else {                return createPropertyType(Types.DefinedType, Cardinality.Simple);            }        }    }}
public PropertiesDescription pdfbox_f9903_0(Class<?> classSchem)
{    PropertiesDescription propMap = new PropertiesDescription();    Field[] fields = classSchem.getFields();    String propName = null;    for (Field field : fields) {        if (field.isAnnotationPresent(PropertyType.class)) {            try {                propName = (String) field.get(propName);            } catch (Exception e) {                throw new IllegalArgumentException("couldn't read one type declaration, please check accessibility and declaration of fields annoted in " + classSchem.getName(), e);            }            PropertyType propType = field.getAnnotation(PropertyType.class);            propMap.addNewProperty(propName, propType);        }    }    return propMap;}
public BooleanType pdfbox_f9904_0(String namespaceURI, String prefix, String propertyName, boolean value)
{    return new BooleanType(metadata, namespaceURI, prefix, propertyName, value);}
public DateType pdfbox_f9905_0(String namespaceURI, String prefix, String propertyName, Calendar value)
{    return new DateType(metadata, namespaceURI, prefix, propertyName, value);}
public IntegerType pdfbox_f9906_0(String namespaceURI, String prefix, String propertyName, int value)
{    return new IntegerType(metadata, namespaceURI, prefix, propertyName, value);}
public RealType pdfbox_f9907_0(String namespaceURI, String prefix, String propertyName, float value)
{    return new RealType(metadata, namespaceURI, prefix, propertyName, value);}
public TextType pdfbox_f9908_0(String namespaceURI, String prefix, String propertyName, String value)
{    return new TextType(metadata, namespaceURI, prefix, propertyName, value);}
public ProperNameType pdfbox_f9909_0(String namespaceURI, String prefix, String propertyName, String value)
{    return new ProperNameType(metadata, namespaceURI, prefix, propertyName, value);}
public URIType pdfbox_f9910_0(String namespaceURI, String prefix, String propertyName, String value)
{    return new URIType(metadata, namespaceURI, prefix, propertyName, value);}
public URLType pdfbox_f9911_0(String namespaceURI, String prefix, String propertyName, String value)
{    return new URLType(metadata, namespaceURI, prefix, propertyName, value);}
public RenditionClassType pdfbox_f9912_0(String namespaceURI, String prefix, String propertyName, String value)
{    return new RenditionClassType(metadata, namespaceURI, prefix, propertyName, value);}
public PartType pdfbox_f9913_0(String namespaceURI, String prefix, String propertyName, String value)
{    return new PartType(metadata, namespaceURI, prefix, propertyName, value);}
public MIMEType pdfbox_f9914_0(String namespaceURI, String prefix, String propertyName, String value)
{    return new MIMEType(metadata, namespaceURI, prefix, propertyName, value);}
public LocaleType pdfbox_f9915_0(String namespaceURI, String prefix, String propertyName, String value)
{    return new LocaleType(metadata, namespaceURI, prefix, propertyName, value);}
public GUIDType pdfbox_f9916_0(String namespaceURI, String prefix, String propertyName, String value)
{    return new GUIDType(metadata, namespaceURI, prefix, propertyName, value);}
public ChoiceType pdfbox_f9917_0(String namespaceURI, String prefix, String propertyName, String value)
{    return new ChoiceType(metadata, namespaceURI, prefix, propertyName, value);}
public AgentNameType pdfbox_f9918_0(String namespaceURI, String prefix, String propertyName, String value)
{    return new AgentNameType(metadata, namespaceURI, prefix, propertyName, value);}
public XPathType pdfbox_f9919_0(String namespaceURI, String prefix, String propertyName, String value)
{    return new XPathType(metadata, namespaceURI, prefix, propertyName, value);}
public ArrayProperty pdfbox_f9920_0(String namespace, String prefix, String propertyName, Cardinality type)
{    return new ArrayProperty(metadata, namespace, prefix, propertyName, type);}
public static PropertyType pdfbox_f9921_0(final Types type, final Cardinality card)
{    return new PropertyType() {        @Override        public Class<? extends Annotation> annotationType() {            return null;        }        @Override        public Types type() {            return type;        }        @Override        public Cardinality card() {            return card;        }    };}
public Class<? extends Annotation> pdfbox_f9922_0()
{    return null;}
public Types pdfbox_f9923_0()
{    return type;}
public Cardinality pdfbox_f9924_0()
{    return card;}
public boolean pdfbox_f9925_0()
{    return simple;}
public boolean pdfbox_f9926_0()
{    return basic == null;}
public boolean pdfbox_f9927_0()
{    return basic == Structured;}
public boolean pdfbox_f9928_0()
{    return this == DefinedType;}
public Types pdfbox_f9929_0()
{    return basic;}
public Class<? extends AbstractField> pdfbox_f9930_0()
{    return clz;}
public String pdfbox_f9931_0()
{    return getPropertyValueAsString(COMMENTS);}
public void pdfbox_f9932_0(String value)
{    addSimpleProperty(COMMENTS, value);}
public ResourceEventType pdfbox_f9933_0()
{    return (ResourceEventType) getFirstEquivalentProperty(EVENT, ResourceEventType.class);}
public void pdfbox_f9934_0(ResourceEventType value)
{    this.addProperty(value);}
public Calendar pdfbox_f9935_0()
{    return getDatePropertyAsCalendar(MODIFY_DATE);}
public void pdfbox_f9936_0(Calendar value)
{    addSimpleProperty(MODIFY_DATE, value);}
public String pdfbox_f9937_0()
{    return getPropertyValueAsString(VERSION);}
public void pdfbox_f9938_0(String value)
{    addSimpleProperty(VERSION, value);}
public String pdfbox_f9939_0()
{    return getPropertyValueAsString(MODIFIER);}
public void pdfbox_f9940_0(String value)
{    addSimpleProperty(MODIFIER, value);}
public static Element pdfbox_f9941_0(Element description) throws XmpParsingException
{    NodeList nl = description.getChildNodes();    int pos = -1;    for (int i = 0; i < nl.getLength(); i++) {        if (nl.item(i) instanceof Element) {            if (pos >= 0) {                                throw new XmpParsingException(ErrorType.Undefined, "Found two child elements in " + description);            } else {                pos = i;            }        }    }    return (Element) nl.item(pos);}
public static Element pdfbox_f9942_0(Element description) throws XmpParsingException
{    NodeList nl = description.getChildNodes();    for (int i = 0; i < nl.getLength(); i++) {        if (nl.item(i) instanceof Element) {            return (Element) nl.item(i);        }    }    return null;}
public static List<Element> pdfbox_f9943_0(Element description) throws XmpParsingException
{    NodeList nl = description.getChildNodes();    List<Element> ret = new ArrayList<>(nl.getLength());    for (int i = 0; i < nl.getLength(); i++) {        if (nl.item(i) instanceof Element) {            ret.add((Element) nl.item(i));        }    }    return ret;}
public static QName pdfbox_f9944_0(Element element)
{    return new QName(element.getNamespaceURI(), element.getLocalName(), element.getPrefix());}
public static boolean pdfbox_f9945_0(Element element)
{    return (XmpConstants.DEFAULT_RDF_PREFIX.equals(element.getPrefix()) && XmpConstants.DESCRIPTION_NAME.equals(element.getLocalName()));}
public static boolean pdfbox_f9946_0(Element element)
{    Attr parseType = element.getAttributeNodeNS(XmpConstants.RDF_NAMESPACE, XmpConstants.PARSE_TYPE);    return parseType != null && XmpConstants.RESOURCE_NAME.equals(parseType.getValue());}
public boolean pdfbox_f9947_0()
{    return strictParsing;}
public void pdfbox_f9948_0(boolean strictParsing)
{    this.strictParsing = strictParsing;}
public XMPMetadata pdfbox_f9949_0(byte[] xmp) throws XmpParsingException
{    ByteArrayInputStream input = new ByteArrayInputStream(xmp);    return parse(input);}
public XMPMetadata pdfbox_f9950_0(InputStream input) throws XmpParsingException
{    Document document = null;    try {                dBuilder.setErrorHandler(null);        document = dBuilder.parse(input);    } catch (SAXException | IOException e) {        throw new XmpParsingException(ErrorType.Undefined, "Failed to parse", e);    }    XMPMetadata xmp = null;        removeComments(document);    Node node = document.getFirstChild();        if (!(node instanceof ProcessingInstruction)) {        throw new XmpParsingException(ErrorType.XpacketBadStart, "xmp should start with a processing instruction");    } else {        xmp = parseInitialXpacket((ProcessingInstruction) node);        node = node.getNextSibling();    }        while (node instanceof ProcessingInstruction) {        node = node.getNextSibling();    }        Element root = null;    if (!(node instanceof Element)) {        throw new XmpParsingException(ErrorType.NoRootElement, "xmp should contain a root element");    } else {                root = (Element) node;        node = node.getNextSibling();    }        if (!(node instanceof ProcessingInstruction)) {        throw new XmpParsingException(ErrorType.XpacketBadEnd, "xmp should end with a processing instruction");    } else {        parseEndPacket(xmp, (ProcessingInstruction) node);        node = node.getNextSibling();    }        if (node != null) {        throw new XmpParsingException(ErrorType.XpacketBadEnd, "xmp should end after xpacket end processing instruction");    }            Element rdfRdf = findDescriptionsParent(root);    List<Element> descriptions = DomHelper.getElementChildren(rdfRdf);    List<Element> dataDescriptions = new ArrayList<>(descriptions.size());    for (Element description : descriptions) {        Element first = DomHelper.getFirstChildElement(description);        if (first != null && "pdfaExtension".equals(first.getPrefix())) {            PdfaExtensionHelper.validateNaming(xmp, description);            parseDescriptionRoot(xmp, description);        } else {            dataDescriptions.add(description);        }    }        PdfaExtensionHelper.populateSchemaMapping(xmp);        for (Element description : dataDescriptions) {        parseDescriptionRoot(xmp, description);    }    return xmp;}
private void pdfbox_f9951_0(XMPMetadata xmp, Element description) throws XmpParsingException
{    nsFinder.push(description);    TypeMapping tm = xmp.getTypeMapping();    try {        List<Element> properties = DomHelper.getElementChildren(description);                NamedNodeMap nnm = description.getAttributes();        for (int i = 0; i < nnm.getLength(); i++) {            Attr attr = (Attr) nnm.item(i);            if (XMLConstants.XMLNS_ATTRIBUTE.equals(attr.getPrefix())) {                        } else if (XmpConstants.DEFAULT_RDF_PREFIX.equals(attr.getPrefix()) && XmpConstants.ABOUT_NAME.equals(attr.getLocalName())) {                        } else if (attr.getPrefix() == null && XmpConstants.ABOUT_NAME.equals(attr.getLocalName())) {                        } else {                parseDescriptionRootAttr(xmp, description, attr, tm);            }        }        parseChildrenAsProperties(xmp, properties, tm, description);    } catch (XmpSchemaException e) {        throw new XmpParsingException(ErrorType.Undefined, "Parsing failed", e);    } finally {        nsFinder.pop();    }}
private void pdfbox_f9952_0(XMPMetadata xmp, Element description, Attr attr, TypeMapping tm) throws XmpSchemaException, XmpParsingException
{    String namespace = attr.getNamespaceURI();    XMPSchema schema = xmp.getSchema(namespace);    if (schema == null && tm.getSchemaFactory(namespace) != null) {        schema = tm.getSchemaFactory(namespace).createXMPSchema(xmp, attr.getPrefix());        loadAttributes(schema, description);    }        if (schema != null) {        ComplexPropertyContainer container = schema.getContainer();        PropertyType type = checkPropertyDefinition(xmp, new QName(attr.getNamespaceURI(), attr.getLocalName()));                if (type == null) {            type = TypeMapping.createPropertyType(Types.Text, Cardinality.Simple);        }        try {            AbstractSimpleProperty sp = tm.instanciateSimpleProperty(namespace, schema.getPrefix(), attr.getLocalName(), attr.getValue(), type.type());            container.addProperty(sp);        } catch (IllegalArgumentException e) {            throw new XmpParsingException(ErrorType.Format, e.getMessage() + " in " + schema.getPrefix() + ":" + attr.getLocalName(), e);        }    }}
private void pdfbox_f9953_0(XMPMetadata xmp, List<Element> properties, TypeMapping tm, Element description) throws XmpParsingException, XmpSchemaException
{        for (Element property : properties) {        String namespace = property.getNamespaceURI();        PropertyType type = checkPropertyDefinition(xmp, DomHelper.getQName(property));                if (!tm.isDefinedSchema(namespace)) {            throw new XmpParsingException(ErrorType.NoSchema, "This namespace is not a schema or a structured type : " + namespace);        }        XMPSchema schema = xmp.getSchema(namespace);        if (schema == null) {            schema = tm.getSchemaFactory(namespace).createXMPSchema(xmp, property.getPrefix());            loadAttributes(schema, description);        }        ComplexPropertyContainer container = schema.getContainer();                createProperty(xmp, property, type, container);    }}
private void pdfbox_f9954_0(XMPMetadata xmp, Element property, PropertyType type, ComplexPropertyContainer container) throws XmpParsingException
{    String prefix = property.getPrefix();    String name = property.getLocalName();    String namespace = property.getNamespaceURI();        nsFinder.push(property);    try {        if (type == null) {            if (strictParsing) {                throw new XmpParsingException(ErrorType.InvalidType, "No type defined for {" + namespace + "}" + name);            } else {                                manageSimpleType(xmp, property, Types.Text, container);            }        } else if (type.type() == Types.LangAlt) {            manageLangAlt(xmp, property, container);        } else if (type.card().isArray()) {            manageArray(xmp, property, type, container);        } else if (type.type().isSimple()) {            manageSimpleType(xmp, property, type.type(), container);        } else if (type.type().isStructured()) {            manageStructuredType(xmp, property, prefix, container);        } else if (type.type() == Types.DefinedType) {            manageDefinedType(xmp, property, prefix, container);        }    } catch (IllegalArgumentException e) {        throw new XmpParsingException(ErrorType.Format, e.getMessage() + " in " + prefix + ":" + name, e);    } finally {        nsFinder.pop();    }}
private void pdfbox_f9955_0(XMPMetadata xmp, Element property, String prefix, ComplexPropertyContainer container) throws XmpParsingException
{    if (DomHelper.isParseTypeResource(property)) {        AbstractStructuredType ast = parseLiDescription(xmp, DomHelper.getQName(property), property);        ast.setPrefix(prefix);        container.addProperty(ast);    } else {        Element inner = DomHelper.getFirstChildElement(property);        if (inner == null) {            throw new XmpParsingException(ErrorType.Format, "property should contain child element : " + property);        }        AbstractStructuredType ast = parseLiDescription(xmp, DomHelper.getQName(property), inner);        ast.setPrefix(prefix);        container.addProperty(ast);    }}
private void pdfbox_f9956_0(XMPMetadata xmp, Element property, String prefix, ComplexPropertyContainer container) throws XmpParsingException
{    if (DomHelper.isParseTypeResource(property)) {        AbstractStructuredType ast = parseLiDescription(xmp, DomHelper.getQName(property), property);        if (ast != null) {            ast.setPrefix(prefix);            container.addProperty(ast);        }    } else {        Element inner = DomHelper.getFirstChildElement(property);        if (inner != null) {            nsFinder.push(inner);            AbstractStructuredType ast = parseLiDescription(xmp, DomHelper.getQName(property), inner);            ast.setPrefix(prefix);            container.addProperty(ast);        }    }}
private void pdfbox_f9957_0(XMPMetadata xmp, Element property, Types type, ComplexPropertyContainer container) throws XmpParsingException
{    TypeMapping tm = xmp.getTypeMapping();    String prefix = property.getPrefix();    String name = property.getLocalName();    String namespace = property.getNamespaceURI();    AbstractSimpleProperty sp = tm.instanciateSimpleProperty(namespace, prefix, name, property.getTextContent(), type);    loadAttributes(sp, property);    container.addProperty(sp);}
private void pdfbox_f9958_0(XMPMetadata xmp, Element property, PropertyType type, ComplexPropertyContainer container) throws XmpParsingException
{    TypeMapping tm = xmp.getTypeMapping();    String prefix = property.getPrefix();    String name = property.getLocalName();    String namespace = property.getNamespaceURI();    Element bagOrSeq = DomHelper.getUniqueElementChild(property);        if (bagOrSeq == null) {                String whatFound = "nothing";        if (property.getFirstChild() != null) {            whatFound = property.getFirstChild().getClass().getName();        }        throw new XmpParsingException(ErrorType.Format, "Invalid array definition, expecting " + type.card() + " and found " + whatFound + " [prefix=" + prefix + "; name=" + name + "]");    }    if (!bagOrSeq.getLocalName().equals(type.card().name())) {                throw new XmpParsingException(ErrorType.Format, "Invalid array type, expecting " + type.card() + " and found " + bagOrSeq.getLocalName() + " [prefix=" + prefix + "; name=" + name + "]");    }    ArrayProperty array = tm.createArrayProperty(namespace, prefix, name, type.card());    container.addProperty(array);    List<Element> lis = DomHelper.getElementChildren(bagOrSeq);    for (Element element : lis) {        QName propertyQName = new QName(element.getLocalName());        AbstractField ast = parseLiElement(xmp, propertyQName, element, type.type());        if (ast != null) {            array.addProperty(ast);        }    }}
private void pdfbox_f9959_0(XMPMetadata xmp, Element property, ComplexPropertyContainer container) throws XmpParsingException
{    manageArray(xmp, property, TypeMapping.createPropertyType(Types.LangAlt, Cardinality.Alt), container);}
private void pdfbox_f9960_0(XMPMetadata xmp, Element description, ComplexPropertyContainer parentContainer) throws XmpParsingException
{    nsFinder.push(description);    TypeMapping tm = xmp.getTypeMapping();    try {        List<Element> properties = DomHelper.getElementChildren(description);        for (Element property : properties) {            String name = property.getLocalName();            PropertyType dtype = checkPropertyDefinition(xmp, DomHelper.getQName(property));            PropertyType ptype = tm.getStructuredPropMapping(dtype.type()).getPropertyType(name);                        createProperty(xmp, property, ptype, parentContainer);        }    } finally {        nsFinder.pop();    }}
private AbstractField pdfbox_f9961_0(XMPMetadata xmp, QName descriptor, Element liElement, Types type) throws XmpParsingException
{    if (DomHelper.isParseTypeResource(liElement)) {        return parseLiDescription(xmp, descriptor, liElement);    }        Element liChild = DomHelper.getUniqueElementChild(liElement);    if (liChild != null) {        nsFinder.push(liChild);        return parseLiDescription(xmp, descriptor, liChild);    } else {                String text = liElement.getTextContent();        TypeMapping tm = xmp.getTypeMapping();        if (type.isSimple()) {            AbstractField af = tm.instanciateSimpleProperty(descriptor.getNamespaceURI(), descriptor.getPrefix(), descriptor.getLocalPart(), text, type);            loadAttributes(af, liElement);            return af;        } else {                        AbstractField af;            try {                af = tm.instanciateStructuredType(type, descriptor.getLocalPart());            } catch (BadFieldValueException ex) {                throw new XmpParsingException(ErrorType.InvalidType, "Parsing of structured type failed", ex);            }            loadAttributes(af, liElement);            return af;        }    }}
private void pdfbox_f9962_0(AbstractField sp, Element element)
{    NamedNodeMap nnm = element.getAttributes();    for (int i = 0; i < nnm.getLength(); i++) {        Attr attr = (Attr) nnm.item(i);        if (XMLConstants.XMLNS_ATTRIBUTE.equals(attr.getPrefix())) {                } else if (XmpConstants.DEFAULT_RDF_PREFIX.equals(attr.getPrefix()) && XmpConstants.ABOUT_NAME.equals(attr.getLocalName())) {                        if (sp instanceof XMPSchema) {                ((XMPSchema) sp).setAboutAsSimple(attr.getValue());            }        } else {            Attribute attribute = new Attribute(XMLConstants.XML_NS_URI, attr.getLocalName(), attr.getValue());            sp.setAttribute(attribute);        }    }}
private AbstractStructuredType pdfbox_f9963_0(XMPMetadata xmp, QName descriptor, Element liElement) throws XmpParsingException
{    TypeMapping tm = xmp.getTypeMapping();    List<Element> elements = DomHelper.getElementChildren(liElement);    if (elements.isEmpty()) {                return null;    }        Element first = elements.get(0);    PropertyType ctype = checkPropertyDefinition(xmp, DomHelper.getQName(first));    Types tt = ctype.type();    AbstractStructuredType ast = instanciateStructured(tm, tt, descriptor.getLocalPart(), first.getNamespaceURI());    ast.setNamespace(descriptor.getNamespaceURI());    ast.setPrefix(descriptor.getPrefix());    PropertiesDescription pm;    if (tt.isStructured()) {        pm = tm.getStructuredPropMapping(tt);    } else {        pm = tm.getDefinedDescriptionByNamespace(first.getNamespaceURI());    }    for (Element element : elements) {        String prefix = element.getPrefix();        String name = element.getLocalName();        String namespace = element.getNamespaceURI();        PropertyType type = pm.getPropertyType(name);        if (type == null) {                        throw new XmpParsingException(ErrorType.NoType, "Type '" + name + "' not defined in " + element.getNamespaceURI());        } else if (type.card().isArray()) {            ArrayProperty array = tm.createArrayProperty(namespace, prefix, name, type.card());            ast.getContainer().addProperty(array);            Element bagOrSeq = DomHelper.getUniqueElementChild(element);            List<Element> lis = DomHelper.getElementChildren(bagOrSeq);            for (Element element2 : lis) {                AbstractField ast2 = parseLiElement(xmp, descriptor, element2, type.type());                if (ast2 != null) {                    array.addProperty(ast2);                }            }        } else if (type.type().isSimple()) {            AbstractSimpleProperty sp = tm.instanciateSimpleProperty(namespace, prefix, name, element.getTextContent(), type.type());            loadAttributes(sp, element);            ast.getContainer().addProperty(sp);        } else if (type.type().isStructured()) {                        AbstractStructuredType inner = instanciateStructured(tm, type.type(), name, null);            inner.setNamespace(namespace);            inner.setPrefix(prefix);            ast.getContainer().addProperty(inner);            ComplexPropertyContainer cpc = inner.getContainer();            if (DomHelper.isParseTypeResource(element)) {                parseDescriptionInner(xmp, element, cpc);            } else {                Element descElement = DomHelper.getFirstChildElement(element);                if (descElement != null) {                    parseDescriptionInner(xmp, descElement, cpc);                }            }        } else {            throw new XmpParsingException(ErrorType.NoType, "Unidentified element to parse " + element + " (type=" + type + ")");        }    }    return ast;}
private XMPMetadata pdfbox_f9964_0(ProcessingInstruction pi) throws XmpParsingException
{    if (!"xpacket".equals(pi.getNodeName())) {        throw new XmpParsingException(ErrorType.XpacketBadStart, "Bad processing instruction name : " + pi.getNodeName());    }    String data = pi.getData();    StringTokenizer tokens = new StringTokenizer(data, " ");    String id = null;    String begin = null;    String bytes = null;    String encoding = null;    while (tokens.hasMoreTokens()) {        String token = tokens.nextToken();        if (!token.endsWith("\"") && !token.endsWith("\'")) {            throw new XmpParsingException(ErrorType.XpacketBadStart, "Cannot understand PI data part : '" + token + "' in '" + data + "'");        }        String quote = token.substring(token.length() - 1);        int pos = token.indexOf("=" + quote);        if (pos <= 0) {            throw new XmpParsingException(ErrorType.XpacketBadStart, "Cannot understand PI data part : '" + token + "' in '" + data + "'");        }        String name = token.substring(0, pos);        if (token.length() - 1 < pos + 2) {            throw new XmpParsingException(ErrorType.XpacketBadStart, "Cannot understand PI data part : '" + token + "' in '" + data + "'");        }        String value = token.substring(pos + 2, token.length() - 1);        switch(name) {            case "id":                id = value;                break;            case "begin":                begin = value;                break;            case "bytes":                bytes = value;                break;            case "encoding":                encoding = value;                break;            default:                throw new XmpParsingException(ErrorType.XpacketBadStart, "Unknown attribute in xpacket PI : '" + token + "'");        }    }    return XMPMetadata.createXMPMetadata(begin, id, bytes, encoding);}
private void pdfbox_f9965_0(XMPMetadata metadata, ProcessingInstruction pi) throws XmpParsingException
{    String xpackData = pi.getData();        if (xpackData.startsWith("end=")) {        char end = xpackData.charAt(5);                if (end != 'r' && end != 'w') {            throw new XmpParsingException(ErrorType.XpacketBadEnd, "Excepted xpacket 'end' attribute with value 'r' or 'w' ");        } else {            metadata.setEndXPacket(Character.toString(end));        }    } else {                throw new XmpParsingException(ErrorType.XpacketBadEnd, "Excepted xpacket 'end' attribute (must be present and placed in first)");    }}
private Element pdfbox_f9966_0(Element root) throws XmpParsingException
{        expectNaming(root, "adobe:ns:meta/", "x", "xmpmeta");        NodeList nl = root.getChildNodes();    if (nl.getLength() == 0) {                throw new XmpParsingException(ErrorType.Format, "No rdf description found in xmp");    } else if (nl.getLength() > 1) {                throw new XmpParsingException(ErrorType.Format, "More than one element found in x:xmpmeta");    } else if (!(root.getFirstChild() instanceof Element)) {                throw new XmpParsingException(ErrorType.Format, "x:xmpmeta does not contains rdf:RDF element");    }        Element rdfRdf = (Element) root.getFirstChild();            expectNaming(rdfRdf, XmpConstants.RDF_NAMESPACE, XmpConstants.DEFAULT_RDF_PREFIX, XmpConstants.DEFAULT_RDF_LOCAL_NAME);        return rdfRdf;}
private void pdfbox_f9967_0(Element element, String ns, String prefix, String ln) throws XmpParsingException
{    if ((ns != null) && !(ns.equals(element.getNamespaceURI()))) {        throw new XmpParsingException(ErrorType.Format, "Expecting namespace '" + ns + "' and found '" + element.getNamespaceURI() + "'");    } else if ((prefix != null) && !(prefix.equals(element.getPrefix()))) {        throw new XmpParsingException(ErrorType.Format, "Expecting prefix '" + prefix + "' and found '" + element.getPrefix() + "'");    } else if ((ln != null) && !(ln.equals(element.getLocalName()))) {        throw new XmpParsingException(ErrorType.Format, "Expecting local name '" + ln + "' and found '" + element.getLocalName() + "'");    }}
private void pdfbox_f9968_0(Node root)
{        List<Node> forDeletion = new ArrayList<>();    NodeList nl = root.getChildNodes();    if (nl.getLength() <= 1) {                return;    }    for (int i = 0; i < nl.getLength(); i++) {        Node node = nl.item(i);        if (node instanceof Comment) {                        forDeletion.add(node);        } else if (node instanceof Text) {            if (node.getTextContent().trim().isEmpty()) {                                                forDeletion.add(node);            }        } else if (node instanceof Element) {                        removeComments(node);        }        }        for (Node node : forDeletion) {        root.removeChild(node);    }}
private AbstractStructuredType pdfbox_f9969_0(TypeMapping tm, Types type, String name, String structuredNamespace) throws XmpParsingException
{    try {        if (type.isStructured()) {            return tm.instanciateStructuredType(type, name);        } else if (type.isDefined()) {            return tm.instanciateDefinedType(name, structuredNamespace);        } else {            throw new XmpParsingException(ErrorType.InvalidType, "Type not structured : " + type);        }    } catch (BadFieldValueException e) {        throw new XmpParsingException(ErrorType.InvalidType, "Parsing failed", e);    }}
private PropertyType pdfbox_f9970_0(XMPMetadata xmp, QName prop) throws XmpParsingException
{    TypeMapping tm = xmp.getTypeMapping();        if (!nsFinder.containsNamespace(prop.getNamespaceURI())) {        throw new XmpParsingException(ErrorType.NoSchema, "Schema is not set in this document : " + prop.getNamespaceURI());    }        String nsuri = prop.getNamespaceURI();    if (!tm.isDefinedNamespace(nsuri)) {        throw new XmpParsingException(ErrorType.NoSchema, "Cannot find a definition for the namespace " + prop.getNamespaceURI());    }    try {        return tm.getSpecifiedPropertyType(prop);    } catch (BadFieldValueException e) {        throw new XmpParsingException(ErrorType.InvalidType, "Failed to retrieve property definition", e);    }}
protected void pdfbox_f9971_0(Element description)
{    NamedNodeMap nnm = description.getAttributes();    Map<String, String> map = new HashMap<>(nnm.getLength());    for (int j = 0; j < nnm.getLength(); j++) {        Attr no = (Attr) nnm.item(j);                if (XMLConstants.XMLNS_ATTRIBUTE_NS_URI.equals(no.getNamespaceURI())) {            map.put(no.getLocalName(), no.getValue());        }    }    stack.push(map);}
protected Map<String, String> pdfbox_f9972_0()
{    return stack.pop();}
protected boolean pdfbox_f9973_0(String namespace)
{    for (int i = stack.size() - 1; i >= 0; i--) {        Map<String, String> map = stack.get(i);        if (map.containsValue(namespace)) {            return true;        }    }        return false;}
public static void pdfbox_f9974_0(XMPMetadata meta, Element description) throws XmpParsingException
{    NamedNodeMap nnm = description.getAttributes();    for (int i = 0; i < nnm.getLength(); i++) {        Attr attr = (Attr) nnm.item(i);        checkNamespaceDeclaration(attr, PDFAExtensionSchema.class);        checkNamespaceDeclaration(attr, PDFAFieldType.class);        checkNamespaceDeclaration(attr, PDFAPropertyType.class);        checkNamespaceDeclaration(attr, PDFASchemaType.class);        checkNamespaceDeclaration(attr, PDFATypeType.class);    }}
private static void pdfbox_f9975_0(Attr attr, Class<? extends AbstractStructuredType> clz) throws XmpParsingException
{    String prefix = attr.getLocalName();    String namespace = attr.getValue();    String cprefix = clz.getAnnotation(StructuredType.class).preferedPrefix();    String cnamespace = clz.getAnnotation(StructuredType.class).namespace();        if (cprefix.equals(prefix) && !cnamespace.equals(namespace)) {        throw new XmpParsingException(ErrorType.InvalidPdfaSchema, "Invalid PDF/A namespace definition");    }    if (cnamespace.equals(namespace) && !cprefix.equals(prefix)) {        throw new XmpParsingException(ErrorType.InvalidPdfaSchema, "Invalid PDF/A namespace definition");    }}
public static void pdfbox_f9976_0(XMPMetadata meta) throws XmpParsingException
{    List<XMPSchema> schems = meta.getAllSchemas();    TypeMapping tm = meta.getTypeMapping();    StructuredType stPdfaExt = PDFAExtensionSchema.class.getAnnotation(StructuredType.class);    for (XMPSchema xmpSchema : schems) {        if (xmpSchema.getNamespace().equals(stPdfaExt.namespace())) {                        if (!xmpSchema.getPrefix().equals(stPdfaExt.preferedPrefix())) {                throw new XmpParsingException(ErrorType.InvalidPrefix, "Found invalid prefix for PDF/A extension, found '" + xmpSchema.getPrefix() + "', should be '" + stPdfaExt.preferedPrefix() + "'");            }                        PDFAExtensionSchema pes = (PDFAExtensionSchema) xmpSchema;            ArrayProperty sp = pes.getSchemasProperty();            for (AbstractField af : sp.getAllProperties()) {                if (af instanceof PDFASchemaType) {                    populatePDFASchemaType(meta, (PDFASchemaType) af, tm);                }                        }        }    }}
private static void pdfbox_f9977_0(XMPMetadata meta, PDFASchemaType st, TypeMapping tm) throws XmpParsingException
{    String namespaceUri = st.getNamespaceURI().trim();    String prefix = st.getPrefixValue();    ArrayProperty properties = st.getProperty();    ArrayProperty valueTypes = st.getValueType();    XMPSchemaFactory xsf = tm.getSchemaFactory(namespaceUri);        if (xsf == null) {                tm.addNewNameSpace(namespaceUri, prefix);        xsf = tm.getSchemaFactory(namespaceUri);    }        if (valueTypes != null) {        for (AbstractField af2 : valueTypes.getAllProperties()) {            if (af2 instanceof PDFATypeType) {                populatePDFAType(meta, (PDFATypeType) af2, tm);            }        }    }        if (properties == null) {        throw new XmpParsingException(ErrorType.RequiredProperty, "Missing pdfaSchema:property in type definition");    }    for (AbstractField af2 : properties.getAllProperties()) {        if (af2 instanceof PDFAPropertyType) {            populatePDFAPropertyType((PDFAPropertyType) af2, tm, xsf);        }        }}
private static void pdfbox_f9978_0(PDFAPropertyType property, TypeMapping tm, XMPSchemaFactory xsf) throws XmpParsingException
{    String pname = property.getName();    String ptype = property.getValueType();    String pdescription = property.getDescription();    String pCategory = property.getCategory();        if (pname == null || ptype == null || pdescription == null || pCategory == null) {                throw new XmpParsingException(ErrorType.RequiredProperty, "Missing field in property definition");    }        PropertyType pt = transformValueType(tm, ptype);    if (pt == null) {        throw new XmpParsingException(ErrorType.NoValueType, "Unknown property value type : " + ptype);    }    if (pt.type() == null) {        throw new XmpParsingException(ErrorType.NoValueType, "Type not defined : " + ptype);    } else if (pt.type().isSimple() || pt.type().isStructured() || pt.type() == Types.DefinedType) {        xsf.getPropertyDefinition().addNewProperty(pname, pt);    } else {        throw new XmpParsingException(ErrorType.NoValueType, "Type not defined : " + ptype);    }}
private static void pdfbox_f9979_0(XMPMetadata meta, PDFATypeType type, TypeMapping tm) throws XmpParsingException
{    String ttype = type.getType();    String tns = type.getNamespaceURI();    String tprefix = type.getPrefixValue();    String tdescription = type.getDescription();    ArrayProperty fields = type.getFields();    if (ttype == null || tns == null || tprefix == null || tdescription == null) {                throw new XmpParsingException(ErrorType.RequiredProperty, "Missing field in type definition");    }            DefinedStructuredType structuredType = new DefinedStructuredType(meta, tns, tprefix, null);        if (fields != null) {        List<AbstractField> definedFields = fields.getAllProperties();        for (AbstractField af3 : definedFields) {            if (af3 instanceof PDFAFieldType) {                populatePDFAFieldType((PDFAFieldType) af3, structuredType);            }                }    }        PropertiesDescription pm = new PropertiesDescription();    for (Map.Entry<String, PropertyType> entry : structuredType.getDefinedProperties().entrySet()) {        pm.addNewProperty(entry.getKey(), entry.getValue());    }    tm.addToDefinedStructuredTypes(ttype, tns, pm);}
private static void pdfbox_f9980_0(PDFAFieldType field, DefinedStructuredType structuredType) throws XmpParsingException
{    String fName = field.getName();    String fDescription = field.getDescription();    String fValueType = field.getValueType();    if (fName == null || fDescription == null || fValueType == null) {        throw new XmpParsingException(ErrorType.RequiredProperty, "Missing field in field definition");    }    try {        Types fValue = Types.valueOf(fValueType);        structuredType.addProperty(fName, TypeMapping.createPropertyType(fValue, Cardinality.Simple));    } catch (IllegalArgumentException e) {        throw new XmpParsingException(ErrorType.NoValueType, "Type not defined : " + fValueType, e);        }}
private static PropertyType pdfbox_f9981_0(TypeMapping tm, String valueType) throws XmpParsingException
{    if ("Lang Alt".equals(valueType)) {        return TypeMapping.createPropertyType(Types.LangAlt, Cardinality.Simple);    }        if (valueType.startsWith(CLOSED_CHOICE)) {        valueType = valueType.substring(CLOSED_CHOICE.length());    } else if (valueType.startsWith(OPEN_CHOICE)) {        valueType = valueType.substring(OPEN_CHOICE.length());    }    int pos = valueType.indexOf(' ');    Cardinality card = Cardinality.Simple;    if (pos > 0) {        String scard = valueType.substring(0, pos);        if ("seq".equals(scard)) {            card = Cardinality.Seq;        } else if ("bag".equals(scard)) {            card = Cardinality.Bag;        } else if ("alt".equals(scard)) {            card = Cardinality.Alt;        } else {            return null;        }    }    String vt = valueType.substring(pos + 1);    Types type = null;    try {        type = pos < 0 ? Types.valueOf(valueType) : Types.valueOf(vt);    } catch (IllegalArgumentException e) {        if (tm.isDefinedType(vt)) {            type = Types.DefinedType;        }    }    return TypeMapping.createPropertyType(type, card);}
public ErrorType pdfbox_f9982_0()
{    return errorType;}
public void pdfbox_f9983_0(XMPMetadata metadata, OutputStream os, boolean withXpacket) throws TransformerException
{    Document doc = documentBuilder.newDocument();        Element rdf = createRdfElement(doc, metadata, withXpacket);    for (XMPSchema schema : metadata.getAllSchemas()) {        rdf.appendChild(serializeSchema(doc, schema));    }        save(doc, os, "UTF-8");}
protected Element pdfbox_f9984_0(Document doc, XMPSchema schema)
{        Element selem = doc.createElementNS(XmpConstants.RDF_NAMESPACE, "rdf:Description");    selem.setAttributeNS(XmpConstants.RDF_NAMESPACE, "rdf:about", schema.getAboutValue());    selem.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:" + schema.getPrefix(), schema.getNamespace());        fillElementWithAttributes(selem, schema);        List<AbstractField> fields = schema.getAllProperties();    serializeFields(doc, selem, fields, schema.getPrefix(), null, true);        return selem;}
public void pdfbox_f9985_0(Document doc, Element parent, List<AbstractField> fields, String resourceNS, String prefix, boolean wrapWithProperty)
{    for (AbstractField field : fields) {        if (field instanceof AbstractSimpleProperty) {            AbstractSimpleProperty simple = (AbstractSimpleProperty) field;            String localPrefix;            if (prefix != null && !prefix.isEmpty()) {                localPrefix = prefix;            } else {                localPrefix = simple.getPrefix();            }            Element esimple = doc.createElement(localPrefix + ":" + simple.getPropertyName());            esimple.setTextContent(simple.getStringValue());            List<Attribute> attributes = simple.getAllAttributes();            for (Attribute attribute : attributes) {                esimple.setAttributeNS(attribute.getNamespace(), attribute.getName(), attribute.getValue());            }            parent.appendChild(esimple);        } else if (field instanceof ArrayProperty) {            ArrayProperty array = (ArrayProperty) field;                        Element asimple = doc.createElement(array.getPrefix() + ":" + array.getPropertyName());            parent.appendChild(asimple);                        fillElementWithAttributes(asimple, array);                        Element econtainer = doc.createElement(XmpConstants.DEFAULT_RDF_PREFIX + ":" + array.getArrayType());            asimple.appendChild(econtainer);                        List<AbstractField> innerFields = array.getAllProperties();            serializeFields(doc, econtainer, innerFields, resourceNS, XmpConstants.DEFAULT_RDF_PREFIX, false);        } else if (field instanceof AbstractStructuredType) {            AbstractStructuredType structured = (AbstractStructuredType) field;            List<AbstractField> innerFields = structured.getAllProperties();                        Element listParent = parent;            if (wrapWithProperty) {                Element nstructured = doc.createElement(resourceNS + ":" + structured.getPropertyName());                parent.appendChild(nstructured);                listParent = nstructured;            }                        Element estructured = doc.createElement(XmpConstants.DEFAULT_RDF_PREFIX + ":" + XmpConstants.LIST_NAME);            listParent.appendChild(estructured);            if (parseTypeResourceForLi) {                estructured.setAttribute("rdf:parseType", "Resource");                                serializeFields(doc, estructured, innerFields, resourceNS, null, true);            } else {                                Element econtainer = doc.createElement(XmpConstants.DEFAULT_RDF_PREFIX + ":" + "Description");                estructured.appendChild(econtainer);                                serializeFields(doc, econtainer, innerFields, resourceNS, null, true);            }        } else {                        System.err.println(">> TODO >> " + field.getClass());        }    }}
private void pdfbox_f9986_0(Element target, AbstractComplexProperty property)
{        List<Attribute> toSerialize = normalizeAttributes(property);    for (Attribute attribute : toSerialize) {        if (XmpConstants.RDF_NAMESPACE.equals(attribute.getNamespace())) {            target.setAttribute(XmpConstants.DEFAULT_RDF_PREFIX + ":" + attribute.getName(), attribute.getValue());        } else {            target.setAttribute(attribute.getName(), attribute.getValue());        }    }    for (Map.Entry<String, String> ns : property.getAllNamespacesWithPrefix().entrySet()) {        target.setAttribute(XMLConstants.XMLNS_ATTRIBUTE + ":" + ns.getValue(), ns.getKey());    }}
private List<Attribute> pdfbox_f9987_0(AbstractComplexProperty property)
{    List<Attribute> attributes = property.getAllAttributes();    List<Attribute> toSerialize = new ArrayList<>();    List<AbstractField> fields = property.getAllProperties();    for (Attribute attribute : attributes) {        boolean matchesField = false;        for (AbstractField field : fields) {            if (attribute.getName().compareTo(field.getPropertyName()) == 0) {                matchesField = true;                break;            }        }        if (!matchesField) {            toSerialize.add(attribute);        }    }    return toSerialize;}
protected Element pdfbox_f9988_0(Document doc, XMPMetadata metadata, boolean withXpacket)
{        if (withXpacket) {        ProcessingInstruction beginXPacket = doc.createProcessingInstruction("xpacket", "begin=\"" + metadata.getXpacketBegin() + "\" id=\"" + metadata.getXpacketId() + "\"");        doc.appendChild(beginXPacket);    }        Element xmpmeta = doc.createElementNS("adobe:ns:meta/", "x:xmpmeta");    xmpmeta.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:x", "adobe:ns:meta/");    doc.appendChild(xmpmeta);        if (withXpacket) {        ProcessingInstruction endXPacket = doc.createProcessingInstruction("xpacket", "end=\"" + metadata.getEndXPacket() + "\"");        doc.appendChild(endXPacket);    }        Element rdf = doc.createElementNS(XmpConstants.RDF_NAMESPACE, "rdf:RDF");        xmpmeta.appendChild(rdf);        return rdf;}
private void pdfbox_f9989_0(Node doc, OutputStream outStream, String encoding) throws TransformerException
{    Transformer transformer = TransformerFactory.newInstance().newTransformer();        transformer.setOutputProperty(OutputKeys.INDENT, "yes");        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");        transformer.setOutputProperty(OutputKeys.ENCODING, encoding);    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");        Result result = new StreamResult(outStream);    DOMSource source = new DOMSource(doc);        transformer.transform(source, result);}
public static XMPMetadata pdfbox_f9990_0()
{    return new XMPMetadata();}
public static XMPMetadata pdfbox_f9991_0(String xpacketBegin, String xpacketId, String xpacketBytes, String xpacketEncoding)
{    return new XMPMetadata(xpacketBegin, xpacketId, xpacketBytes, xpacketEncoding);}
public TypeMapping pdfbox_f9992_0()
{    return this.typeMapping;}
public String pdfbox_f9993_0()
{    return xpacketBytes;}
public String pdfbox_f9994_0()
{    return xpacketEncoding;}
public String pdfbox_f9995_0()
{    return xpacketBegin;}
public String pdfbox_f9996_0()
{    return xpacketId;}
public List<XMPSchema> pdfbox_f9997_0()
{    List<XMPSchema> schem = new ArrayList<>();    for (XMPSchema schema : schemas) {        schem.add(schema);    }    return schem;}
public void pdfbox_f9998_0(String data)
{    xpacketEndData = data;}
public String pdfbox_f9999_0()
{    return xpacketEndData;}
public XMPSchema pdfbox_f10000_0(String nsURI)
{    Iterator<XMPSchema> it = schemas.iterator();    XMPSchema tmp;    while (it.hasNext()) {        tmp = it.next();        if (tmp.getNamespace().equals(nsURI)) {            return tmp;        }    }    return null;}
public XMPSchema pdfbox_f10001_0(Class<? extends XMPSchema> clz)
{    StructuredType st = clz.getAnnotation(StructuredType.class);    return getSchema(st.namespace());}
public XMPSchema pdfbox_f10002_0(String prefix, String nsURI)
{    Iterator<XMPSchema> it = getAllSchemas().iterator();    XMPSchema tmp;    while (it.hasNext()) {        tmp = it.next();        if (tmp.getNamespace().equals(nsURI) && tmp.getPrefix().equals(prefix)) {            return tmp;        }    }    return null;}
public XMPSchema pdfbox_f10003_0(String nsPrefix, String nsURI)
{    XMPSchema schem = new XMPSchema(this, nsURI, nsPrefix);    schem.setAboutAsSimple("");    addSchema(schem);    return schem;}
public PDFAExtensionSchema pdfbox_f10004_0()
{    PDFAExtensionSchema pdfAExt = new PDFAExtensionSchema(this);    pdfAExt.setAboutAsSimple("");    addSchema(pdfAExt);    return pdfAExt;}
public PDFAExtensionSchema pdfbox_f10005_0(Map<String, String> namespaces) throws XmpSchemaException
{    PDFAExtensionSchema pdfAExt = new PDFAExtensionSchema(this);    pdfAExt.setAboutAsSimple("");    addSchema(pdfAExt);    return pdfAExt;}
public PDFAExtensionSchema pdfbox_f10006_0()
{    return (PDFAExtensionSchema) getSchema(PDFAExtensionSchema.class);}
public PDFAIdentificationSchema pdfbox_f10007_0()
{    PDFAIdentificationSchema pdfAId = new PDFAIdentificationSchema(this);    pdfAId.setAboutAsSimple("");    addSchema(pdfAId);    return pdfAId;}
public PDFAIdentificationSchema pdfbox_f10008_0()
{    return (PDFAIdentificationSchema) getSchema(PDFAIdentificationSchema.class);}
public DublinCoreSchema pdfbox_f10009_0()
{    DublinCoreSchema dc = new DublinCoreSchema(this);    dc.setAboutAsSimple("");    addSchema(dc);    return dc;}
public DublinCoreSchema pdfbox_f10010_0()
{    return (DublinCoreSchema) getSchema(DublinCoreSchema.class);}
public XMPBasicJobTicketSchema pdfbox_f10011_0()
{    XMPBasicJobTicketSchema sc = new XMPBasicJobTicketSchema(this);    sc.setAboutAsSimple("");    addSchema(sc);    return sc;}
public XMPBasicJobTicketSchema pdfbox_f10012_0()
{    return (XMPBasicJobTicketSchema) getSchema(XMPBasicJobTicketSchema.class);}
public XMPRightsManagementSchema pdfbox_f10013_0()
{    XMPRightsManagementSchema rights = new XMPRightsManagementSchema(this);    rights.setAboutAsSimple("");    addSchema(rights);    return rights;}
public XMPRightsManagementSchema pdfbox_f10014_0()
{    return (XMPRightsManagementSchema) getSchema(XMPRightsManagementSchema.class);}
public XMPBasicSchema pdfbox_f10015_0()
{    XMPBasicSchema xmpB = new XMPBasicSchema(this);    xmpB.setAboutAsSimple("");    addSchema(xmpB);    return xmpB;}
public XMPBasicSchema pdfbox_f10016_0()
{    return (XMPBasicSchema) getSchema(XMPBasicSchema.class);}
public XMPMediaManagementSchema pdfbox_f10017_0()
{    XMPMediaManagementSchema xmpMM = new XMPMediaManagementSchema(this);    xmpMM.setAboutAsSimple("");    addSchema(xmpMM);    return xmpMM;}
public PhotoshopSchema pdfbox_f10018_0()
{    PhotoshopSchema photoshop = new PhotoshopSchema(this);    photoshop.setAboutAsSimple("");    addSchema(photoshop);    return photoshop;}
public PhotoshopSchema pdfbox_f10019_0()
{    return (PhotoshopSchema) getSchema(PhotoshopSchema.class);}
public XMPMediaManagementSchema pdfbox_f10020_0()
{    return (XMPMediaManagementSchema) getSchema(XMPMediaManagementSchema.class);}
public AdobePDFSchema pdfbox_f10021_0()
{    AdobePDFSchema pdf = new AdobePDFSchema(this);    pdf.setAboutAsSimple("");    addSchema(pdf);    return pdf;}
public AdobePDFSchema pdfbox_f10022_0()
{    return (AdobePDFSchema) getSchema(AdobePDFSchema.class);}
public void pdfbox_f10023_0(XMPSchema obj)
{    schemas.add(obj);}
public void pdfbox_f10024_0(XMPSchema schema)
{    schemas.remove(schema);}
public void pdfbox_f10025_0()
{    schemas.clear();}
public void pdfbox_f10026_0() throws Exception
{    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");    Calendar jaxbCal;        Calendar convDate = DateConverter.toCalendar("2015-02-02");    assertEquals(2015, convDate.get(Calendar.YEAR));        assertEquals(DateConverter.toCalendar("2015-12-08T12:07:00-05:00"), DateConverter.toCalendar("2015-12-08T12:07-05:00"));    assertEquals(DateConverter.toCalendar("2011-11-20T10:09:00Z"), DateConverter.toCalendar("2011-11-20T10:09Z"));        jaxbCal = javax.xml.bind.DatatypeConverter.parseDateTime("2015-02-02T16:37:19.192Z");    convDate = DateConverter.toCalendar("2015-02-02T16:37:19.192Z");    assertEquals(dateFormat.format(jaxbCal.getTime()), dateFormat.format(convDate.getTime()));    jaxbCal = javax.xml.bind.DatatypeConverter.parseDateTime("2015-02-02T16:37:19.192+00:00");    convDate = DateConverter.toCalendar("2015-02-02T16:37:19.192Z");    assertEquals(dateFormat.format(jaxbCal.getTime()), dateFormat.format(convDate.getTime()));    jaxbCal = javax.xml.bind.DatatypeConverter.parseDateTime("2015-02-02T16:37:19.192+02:00");    convDate = DateConverter.toCalendar("2015-02-02T16:37:19.192+02:00");    assertEquals(dateFormat.format(jaxbCal.getTime()), dateFormat.format(convDate.getTime()));    jaxbCal = javax.xml.bind.DatatypeConverter.parseDateTime("2015-02-02T16:37:19.192Z");    convDate = DateConverter.toCalendar("2015-02-02T08:37:19.192PST");    assertEquals(dateFormat.format(jaxbCal.getTime()), dateFormat.format(convDate.getTime()));    jaxbCal = javax.xml.bind.DatatypeConverter.parseDateTime("2015-02-02T16:37:19.192+01:00");    convDate = DateConverter.toCalendar("2015-02-02T16:37:19.192Europe/Berlin");    assertEquals(dateFormat.format(jaxbCal.getTime()), dateFormat.format(convDate.getTime()));}
public void pdfbox_f10027_0() throws Exception
{    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");    Calendar cal = DateConverter.toCalendar("2015-02-02T16:37:19.192Z");    assertEquals(dateFormat.format(cal.getTime()), dateFormat.format(DateConverter.toCalendar(DateConverter.toISO8601(cal, true)).getTime()));}
public void pdfbox_f10028_0() throws Exception
{    metadata = XMPMetadata.createXMPMetadata();}
public void pdfbox_f10029_0() throws Exception
{    DublinCoreSchema dc1 = metadata.createAndAddDublinCoreSchema();    String ownPrefix = "test";    DublinCoreSchema dc2 = new DublinCoreSchema(metadata, ownPrefix);    metadata.addSchema(dc2);    List<String> creators = new ArrayList<>();    creators.add("creator1");    creators.add("creator2");    String format = "application/pdf";    dc1.setFormat(format);    dc1.addCreator(creators.get(0));    dc1.addCreator(creators.get(1));    String coverage = "Coverage";    dc2.setCoverage(coverage);    dc2.addCreator(creators.get(0));    dc2.addCreator(creators.get(1));    StructuredType stDub = DublinCoreSchema.class.getAnnotation(StructuredType.class);            Assert.assertEquals(format, ((DublinCoreSchema) metadata.getSchema(stDub.preferedPrefix(), stDub.namespace())).getFormat());    Assert.assertEquals(coverage, ((DublinCoreSchema) metadata.getSchema(ownPrefix, stDub.namespace())).getCoverage());    List<XMPSchema> schems = metadata.getAllSchemas();    DublinCoreSchema dc;    for (XMPSchema xmpSchema : schems) {        dc = (DublinCoreSchema) xmpSchema;        Assert.assertTrue(dc.getCreators().containsAll(creators));    }}
public void pdfbox_f10030_0() throws Exception
{    bos = new ByteArrayOutputStream();    serializer = new XmpSerializer();}
public void pdfbox_f10031_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/org/apache/xmpbox/parser/structured_recursive.xml");    DomXmpParser xdb = new DomXmpParser();    xdb.parse(fis);}
public void pdfbox_f10032_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/org/apache/xmpbox/parser/empty_list.xml");    DomXmpParser xdb = new DomXmpParser();    xdb.parse(fis);}
public void pdfbox_f10033_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/validxmp/emptyli.xml");    DomXmpParser xdb = new DomXmpParser();    XMPMetadata meta = xdb.parse(fis);    DublinCoreSchema dc = meta.getDublinCoreSchema();    dc.getCreatorsProperty();}
public void pdfbox_f10034_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/validxmp/emptyli.xml");    DomXmpParser xdb = new DomXmpParser();    XMPMetadata meta = xdb.parse(fis);    DublinCoreSchema dc = meta.getDublinCoreSchema();    String s = dc.getTitle(null);    Assert.assertEquals("title value", s);}
public void pdfbox_f10035_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/org/apache/xmpbox/parser/AltBagSeqTest.xml");    DomXmpParser xdb = new DomXmpParser();    xdb.parse(fis);}
public void pdfbox_f10036_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/org/apache/xmpbox/parser/ThumbisartorStyle.xml");    DomXmpParser xdb = new DomXmpParser();    XMPMetadata metadata = xdb.parse(fis);        Assert.assertEquals("uuid:09C78666-2F91-3A9C-92AF-3691A6D594F7", metadata.getXMPMediaManagementSchema().getDocumentID());                Assert.assertEquals(DateConverter.toCalendar("2008-01-18T16:59:54+01:00"), metadata.getXMPBasicSchema().getCreateDate());    Assert.assertEquals(DateConverter.toCalendar("2008-01-18T16:59:54+01:00"), metadata.getXMPBasicSchema().getModifyDate());    Assert.assertEquals(DateConverter.toCalendar("2008-01-18T16:59:54+01:00"), metadata.getXMPBasicSchema().getMetadataDate());        List<ThumbnailType> thumbs = metadata.getXMPBasicSchema().getThumbnailsProperty();    Assert.assertNotNull(thumbs);    Assert.assertEquals(2, thumbs.size());    ThumbnailType thumb = thumbs.get(0);    Assert.assertEquals(Integer.valueOf(162), thumb.getHeight());    Assert.assertEquals(Integer.valueOf(216), thumb.getWidth());    Assert.assertEquals("JPEG", thumb.getFormat());    Assert.assertEquals("/9j/4AAQSkZJRgABAgEASABIAAD", thumb.getImage());    thumb = thumbs.get(1);    Assert.assertEquals(Integer.valueOf(162), thumb.getHeight());    Assert.assertEquals(Integer.valueOf(216), thumb.getWidth());    Assert.assertEquals("JPEG", thumb.getFormat());    Assert.assertEquals("/9j/4AAQSkZJRgABAgEASABIAAD", thumb.getImage());}
public void pdfbox_f10037_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/invalidxmp/noxpacket.xml");    DomXmpParser xdb = new DomXmpParser();    try {        xdb.parse(fis);        Assert.fail("Should fail during parse");    } catch (XmpParsingException e) {        Assert.assertEquals(ErrorType.XpacketBadStart, e.getErrorType());    }}
public void pdfbox_f10038_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/invalidxmp/noxpacketend.xml");    DomXmpParser xdb = new DomXmpParser();    try {        xdb.parse(fis);        Assert.fail("Should fail during parse");    } catch (XmpParsingException e) {        Assert.assertEquals(ErrorType.XpacketBadEnd, e.getErrorType());    }}
public void pdfbox_f10039_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/invalidxmp/noroot.xml");    DomXmpParser xdb = new DomXmpParser();    try {        xdb.parse(fis);        Assert.fail("Should fail during parse");    } catch (XmpParsingException e) {        Assert.assertEquals(ErrorType.Format, e.getErrorType());    }}
public void pdfbox_f10040_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/invalidxmp/tworoot.xml");    DomXmpParser xdb = new DomXmpParser();    try {        xdb.parse(fis);        Assert.fail("Should fail during parse");    } catch (XmpParsingException e) {        Assert.assertEquals(ErrorType.Format, e.getErrorType());    }}
public void pdfbox_f10041_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/invalidxmp/invalidroot2.xml");    DomXmpParser xdb = new DomXmpParser();    try {        xdb.parse(fis);        Assert.fail("Should fail during parse");    } catch (XmpParsingException e) {        Assert.assertEquals(ErrorType.Format, e.getErrorType());    }}
public void pdfbox_f10042_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/invalidxmp/invalidroot.xml");    DomXmpParser xdb = new DomXmpParser();    try {        xdb.parse(fis);        Assert.fail("Should fail during parse");    } catch (XmpParsingException e) {        Assert.assertEquals(ErrorType.Format, e.getErrorType());    }}
public void pdfbox_f10043_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/invalidxmp/undefinedschema.xml");    DomXmpParser xdb = new DomXmpParser();    try {        xdb.parse(fis);        Assert.fail("Should fail during parse");    } catch (XmpParsingException e) {        Assert.assertEquals(ErrorType.NoSchema, e.getErrorType());    }}
public void pdfbox_f10044_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/invalidxmp/undefinedpropertyindefinedschema.xml");    DomXmpParser xdb = new DomXmpParser();    try {        xdb.parse(fis);        Assert.fail("Should fail during parse");    } catch (XmpParsingException e) {        Assert.assertEquals(ErrorType.NoType, e.getErrorType());    }}
public void pdfbox_f10045_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/invalidxmp/undefinedstructuredindefinedschema.xml");    DomXmpParser xdb = new DomXmpParser();    try {        xdb.parse(fis);        Assert.fail("Should fail during parse");    } catch (XmpParsingException e) {        Assert.assertEquals(ErrorType.NoValueType, e.getErrorType());    }}
public void pdfbox_f10046_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/validxmp/emptyli.xml");    DomXmpParser xdb = new DomXmpParser();    XMPMetadata meta = xdb.parse(fis);    List<XMPSchema> schemas = meta.getAllSchemas();    for (XMPSchema xmpSchema : schemas) {        Assert.assertNotNull(xmpSchema.getAboutAttribute());    }}
public void pdfbox_f10047_0() throws Exception
{    InputStream fis = DomXmpParser.class.getResourceAsStream("/validxmp/attr_as_props.xml");    DomXmpParser xdb = new DomXmpParser();    XMPMetadata meta = xdb.parse(fis);    AdobePDFSchema pdf = meta.getAdobePDFSchema();    Assert.assertEquals("GPL Ghostscript 8.64", pdf.getProducer());    DublinCoreSchema dc = meta.getDublinCoreSchema();    Assert.assertEquals("application/pdf", dc.getFormat());    XMPBasicSchema basic = meta.getXMPBasicSchema();    Assert.assertNotNull(basic.getCreateDate());}
public void pdfbox_f10048_0() throws Exception
{            InputStream is = DomXmpParser.class.getResourceAsStream("/validxmp/only_space_fields.xmp");    DomXmpParser xdb = new DomXmpParser();    XMPMetadata meta = xdb.parse(is);        Assert.assertEquals(" ", meta.getAdobePDFSchema().getProducer());        Assert.assertEquals("Canon ", meta.getXMPBasicSchema().getCreatorTool());}
public void pdfbox_f10049_0()
{    propMap = new PropertiesDescription();}
public void pdfbox_f10050_0() throws Exception
{    DublinCoreSchema dc = new DublinCoreSchema(XMPMetadata.createXMPMetadata());    dc.setCoverage("coverage");    dc.addContributor("contributor1");    dc.addContributor("contributor2");    dc.addDescription("x-default", "Description");}
public void pdfbox_f10051_0() throws Exception
{    XMPMetadata meta = XMPMetadata.createXMPMetadata();    DublinCoreSchema dc = meta.createAndAddDublinCoreSchema();    dc.setCoverage("coverage");    dc.addContributor("contributor1");    dc.addContributor("contributor2");    dc.addDescription("x-default", "Description");    AdobePDFSchema pdf = meta.createAndAddAdobePDFSchema();    pdf.setProducer("Producer");    pdf.setPDFVersion("1.4");}
public void pdfbox_f10052_0() throws Exception
{    builder = new DomXmpParser();    xmp = XMPMetadata.createXMPMetadata();    typeMapping = xmp.getTypeMapping();}
protected Class<? extends XMPSchema> pdfbox_f10053_0()
{    return getSchema().getClass();}
public void pdfbox_f10054_0() throws Exception
{    XMPSchema schema = getSchema();        Assert.assertNull(schema.getProperty(fieldName));        if (cardinality == Cardinality.Simple) {        String getter = calculateSimpleGetter(fieldName);        Method get = getSchemaClass().getMethod(getter);        Object result = get.invoke(schema);        Assert.assertNull(result);    } else {                String getter = calculateArrayGetter(fieldName);        Method get = getSchemaClass().getMethod(getter);        Object result = get.invoke(schema);        Assert.assertNull(result);    }}
public void pdfbox_f10055_0() throws Exception
{    internalTestSettingValue();}
public void pdfbox_f10056_0() throws Exception
{    initializeSeed(new Random());    for (int i = 0; i < RAND_LOOP_COUNT; i++) {        internalTestSettingValue();    }}
private void pdfbox_f10057_0() throws Exception
{    if (cardinality != Cardinality.Simple) {        return;    }    XMPSchema schema = getSchema();        Object value = getJavaValue(type);    AbstractSimpleProperty property = schema.instanciateSimple(fieldName, value);    schema.addProperty(property);    String qn = getPropertyQualifiedName(fieldName);    Assert.assertNotNull(schema.getProperty(fieldName));        List<Field> fields = getXmpFields(getSchemaClass());    for (Field field : fields) {                String fqn = getPropertyQualifiedName(field.get(null).toString());        if (!fqn.equals(qn)) {            Assert.assertNull(schema.getProperty(fqn));        }    }}
public void pdfbox_f10058_0() throws Exception
{    internalTestSettingValueInArray();}
public void pdfbox_f10059_0() throws Exception
{    initializeSeed(new Random());    for (int i = 0; i < RAND_LOOP_COUNT; i++) {        internalTestSettingValueInArray();    }}
private void pdfbox_f10060_0() throws Exception
{    if (cardinality == Cardinality.Simple) {        return;    }    XMPSchema schema = getSchema();        Object value = getJavaValue(type);    AbstractSimpleProperty property = schema.instanciateSimple(fieldName, value);    switch(cardinality) {        case Seq:            schema.addUnqualifiedSequenceValue(property.getPropertyName(), property);            break;        case Bag:            schema.addBagValue(property.getPropertyName(), property);            break;        default:            throw new Exception("Unexpected case in test : " + cardinality.name());    }    String qn = getPropertyQualifiedName(fieldName);    Assert.assertNotNull(schema.getProperty(fieldName));        List<Field> fields = getXmpFields(getSchemaClass());    for (Field field : fields) {                String fqn = getPropertyQualifiedName(field.get(null).toString());        if (!fqn.equals(qn)) {            Assert.assertNull(schema.getProperty(fqn));        }    }}
public void pdfbox_f10061_0() throws Exception
{    internalTestPropertySetterSimple();}
public void pdfbox_f10062_0() throws Exception
{    initializeSeed(new Random());    for (int i = 0; i < RAND_LOOP_COUNT; i++) {        internalTestPropertySetterSimple();    }}
private void pdfbox_f10063_0() throws Exception
{    if (cardinality != Cardinality.Simple) {        return;    }    XMPSchema schema = getSchema();    String setter = calculateSimpleSetter(fieldName) + "Property";    Object value = getJavaValue(type);    AbstractSimpleProperty asp = typeMapping.instanciateSimpleProperty(schema.getNamespace(), schema.getPrefix(), fieldName, value, type);    Method set = getSchemaClass().getMethod(setter, type.getImplementingClass());    set.invoke(schema, asp);        AbstractSimpleProperty stored = (AbstractSimpleProperty) schema.getProperty(fieldName);    Assert.assertEquals(value, stored.getValue());        String getter = calculateSimpleGetter(fieldName) + "Property";    Method get = getSchemaClass().getMethod(getter);    Object result = get.invoke(schema);    Assert.assertTrue(type.getImplementingClass().isAssignableFrom(result.getClass()));    Assert.assertEquals(asp, result);}
public void pdfbox_f10064_0() throws Exception
{    internalTestPropertySetterInArray();}
public void pdfbox_f10065_0() throws Exception
{    initializeSeed(new Random());    for (int i = 0; i < RAND_LOOP_COUNT; i++) {        internalTestPropertySetterInArray();    }}
private void pdfbox_f10066_0() throws Exception
{    if (cardinality == Cardinality.Simple) {        return;    }    XMPSchema schema = getSchema();        String setter = "add" + calculateFieldNameForMethod(fieldName);            Object value1 = getJavaValue(type);    Method set = getSchemaClass().getMethod(setter, getJavaType(type));    set.invoke(schema, value1);        String getter = calculateArrayGetter(fieldName) + "Property";    Method getcp = getSchemaClass().getMethod(getter);    Object ocp = getcp.invoke(schema);    Assert.assertTrue(ocp instanceof ArrayProperty);    ArrayProperty cp = (ArrayProperty) ocp;        Assert.assertEquals(1, cp.getContainer().getAllProperties().size());        Object value2 = getJavaValue(type);    set.invoke(schema, value2);    Assert.assertEquals(2, cp.getContainer().getAllProperties().size());        String remover = "remove" + calculateFieldNameForMethod(fieldName);    Method remove = getSchemaClass().getMethod(remover, getJavaType(type));    remove.invoke(schema, value1);    Assert.assertEquals(1, cp.getContainer().getAllProperties().size());}
protected String pdfbox_f10067_0(String name)
{    StringBuilder sb = new StringBuilder();    sb.append(getSchema().getPrefix()).append(":").append(name);    return sb.toString();}
public static Object[] pdfbox_f10068_0(String name, Types type, Object value)
{    return wrapProperty(name, type, Cardinality.Simple, value);}
public static Object[] pdfbox_f10069_0(String name, Types type, Cardinality card, Object value)
{        return new Object[] { name, TypeMapping.createPropertyType(type, card), value };}
public void pdfbox_f10070_0() throws Exception
{    if (type.type() == Types.Text && type.card() == Cardinality.Simple) {        testGetSetTextValue();    } else if (type.type() == Types.Boolean && type.card() == Cardinality.Simple) {        testGetSetBooleanValue();    } else if (type.type() == Types.Integer && type.card() == Cardinality.Simple) {        testGetSetIntegerValue();    } else if (type.type() == Types.Date && type.card() == Cardinality.Simple) {        testGetSetDateValue();    } else if (type.type() == Types.URI && type.card() == Cardinality.Simple) {        testGetSetTextValue();    } else if (type.type() == Types.URL && type.card() == Cardinality.Simple) {        testGetSetTextValue();    } else if (type.type() == Types.AgentName && type.card() == Cardinality.Simple) {        testGetSetTextValue();    } else if (type.type() == Types.LangAlt && type.card() == Cardinality.Simple) {        } else if (type.type() == Types.ResourceRef && type.card() == Cardinality.Simple) {        } else if (type.card() != Cardinality.Simple) {        } else {        throw new Exception("Unknown type : " + type);    }}
public void pdfbox_f10071_0() throws Exception
{    if (type.type() == Types.Text && type.card() == Cardinality.Simple) {        testGetSetTextProperty();    } else if (type.type() == Types.URI && type.card() == Cardinality.Simple) {        testGetSetURIProperty();    } else if (type.type() == Types.URL && type.card() == Cardinality.Simple) {        testGetSetURLProperty();    } else if (type.type() == Types.AgentName && type.card() == Cardinality.Simple) {        testGetSetAgentNameProperty();    } else if (type.type() == Types.Boolean && type.card() == Cardinality.Simple) {        testGetSetBooleanProperty();    } else if (type.type() == Types.Integer && type.card() == Cardinality.Simple) {        testGetSetIntegerProperty();    } else if (type.type() == Types.Date && type.card() == Cardinality.Simple) {        testGetSetDateProperty();    } else if (type.type() == Types.Text && type.card() == Cardinality.Seq) {        testGetSetTextListValue("seq");    } else if (type.type() == Types.Version && type.card() == Cardinality.Seq) {        testGetSetTextListValue("seq");    } else if (type.type() == Types.Text && type.card() == Cardinality.Bag) {        testGetSetTextListValue("bag");    } else if (type.type() == Types.ProperName && type.card() == Cardinality.Bag) {        testGetSetTextListValue("bag");    } else if (type.type() == Types.XPath && type.card() == Cardinality.Bag) {        testGetSetTextListValue("bag");    } else if (type.type() == Types.Date && type.card() == Cardinality.Seq) {        testGetSetDateListValue("seq");    } else if (type.type() == Types.LangAlt && type.card() == Cardinality.Simple) {        testGetSetLangAltValue();    } else if (type.type() == Types.Thumbnail && type.card() == Cardinality.Alt) {        testGetSetThumbnail();    } else {        throw new Exception("Unknown type : " + type);    }    Field[] fields = schemaClass.getFields();    for (Field field : fields) {        if (field.isAnnotationPresent(PropertyType.class)) {            if (!field.get(schema).equals(property)) {                PropertyType pt = field.getAnnotation(PropertyType.class);                if (pt.type() == Types.LangAlt) {                                } else if (pt.type() == Types.Thumbnail && pt.card() == Cardinality.Alt) {                                } else if (pt.type() == Types.ResourceRef) {                                } else if (pt.type() == Types.Version && pt.card() == Cardinality.Seq) {                                } else {                                        PropertyType spt = retrievePropertyType(field.get(schema).toString());                    String getNameProperty = "get" + prepareName(field.get(schema).toString(), spt) + "Property";                    Method getMethod = schemaClass.getMethod(getNameProperty);                    Assert.assertNull(getNameProperty + " should return null when testing " + property, getMethod.invoke(schema));                                        String getNameValue = "get" + prepareName(field.get(schema).toString(), spt);                    getMethod = schemaClass.getMethod(getNameValue);                    Assert.assertNotNull(getNameValue + " method should exist", getMethod);                    Assert.assertNull(getNameValue + " should return null when testing " + property, getMethod.invoke(schema));                }            }        }    }}
protected PropertyType pdfbox_f10072_0(String prop) throws IllegalArgumentException, IllegalAccessException
{    Field[] fields = schemaClass.getFields();    for (Field field : fields) {        if (field.isAnnotationPresent(PropertyType.class)) {            PropertyType pt = field.getAnnotation(PropertyType.class);            if (field.get(schema).equals(prop)) {                return pt;            }        }    }    return type;}
protected String pdfbox_f10073_0(String name)
{    StringBuilder sb = new StringBuilder(name.length());    sb.append(name.substring(0, 1).toUpperCase());    sb.append(name.substring(1));    return sb.toString();}
protected String pdfbox_f10074_0(String prop, PropertyType type)
{    String fu = firstUpper(prop);    StringBuilder sb = new StringBuilder(fu.length() + 1);    sb.append(fu);    if (fu.endsWith("s")) {        } else if (fu.endsWith("y")) {        } else if (type.card() != Cardinality.Simple) {        sb.append("s");    }    return sb.toString();}
protected String pdfbox_f10075_0(String prop)
{    StringBuilder sb = new StringBuilder(3 + prop.length());    sb.append("set").append(prepareName(prop, type)).append("Property");    return sb.toString();}
protected String pdfbox_f10076_0(String prop)
{    String fu = firstUpper(prop);    StringBuilder sb = new StringBuilder(3 + prop.length());    sb.append("add").append(fu);    return sb.toString();}
protected String pdfbox_f10077_0(String prop)
{    String fu = firstUpper(prop);    StringBuilder sb = new StringBuilder(3 + prop.length());    sb.append("get").append(fu).append("Property");    return sb.toString();}
protected String pdfbox_f10078_0(String prop)
{    String fu = firstUpper(prop);    StringBuilder sb = new StringBuilder(8 + prop.length());    sb.append("set").append(fu);    return sb.toString();}
protected String pdfbox_f10079_0(String prop)
{    StringBuilder sb = new StringBuilder(8 + prop.length());    sb.append("get").append(prepareName(prop, type));    return sb.toString();}
protected String pdfbox_f10080_0(String prop)
{    String fu = firstUpper(prop);    StringBuilder sb = new StringBuilder(10 + prop.length());    sb.append("add").append(fu);    return sb.toString();}
protected void pdfbox_f10081_0() throws Exception
{    String setName = setMethod(property);    String getName = getMethod(property);    BooleanType bt = new BooleanType(metadata, null, schema.getPrefix(), property, value);    Method setMethod = schemaClass.getMethod(setName, BooleanType.class);    Method getMethod = schemaClass.getMethod(getName);    setMethod.invoke(schema, bt);    Boolean found = ((BooleanType) getMethod.invoke(schema)).getValue();    Assert.assertEquals(value, found);}
protected void pdfbox_f10082_0() throws Exception
{    String setName = setMethod(property);    String getName = getMethod(property);    DateType dt = new DateType(metadata, null, schema.getPrefix(), property, value);    Method setMethod = schemaClass.getMethod(setName, DateType.class);    Method getMethod = schemaClass.getMethod(getName);    setMethod.invoke(schema, dt);    Calendar found = ((DateType) getMethod.invoke(schema)).getValue();    Assert.assertEquals(value, found);}
protected void pdfbox_f10083_0() throws Exception
{    String setName = setMethod(property);    String getName = getMethod(property);    IntegerType it = new IntegerType(metadata, null, schema.getPrefix(), property, value);    Method setMethod = schemaClass.getMethod(setName, IntegerType.class);    Method getMethod = schemaClass.getMethod(getName);    setMethod.invoke(schema, it);    Integer found = ((IntegerType) getMethod.invoke(schema)).getValue();    Assert.assertEquals(value, found);}
protected void pdfbox_f10084_0() throws Exception
{    String setName = setMethod(property);    String getName = getMethod(property);    TextType tt = metadata.getTypeMapping().createText(null, schema.getPrefix(), property, (String) value);    Method setMethod = schemaClass.getMethod(setName, TextType.class);    Method getMethod = schemaClass.getMethod(getName);    setMethod.invoke(schema, tt);    String found = ((TextType) getMethod.invoke(schema)).getStringValue();    Assert.assertEquals(value, found);}
protected void pdfbox_f10085_0() throws Exception
{    String setName = setMethod(property);    String getName = getMethod(property);    URIType tt = metadata.getTypeMapping().createURI(null, schema.getPrefix(), property, (String) value);    Method setMethod = schemaClass.getMethod(setName, URIType.class);    Method getMethod = schemaClass.getMethod(getName);    setMethod.invoke(schema, tt);    String found = ((TextType) getMethod.invoke(schema)).getStringValue();    Assert.assertEquals(value, found);}
protected void pdfbox_f10086_0() throws Exception
{    String setName = setMethod(property);    String getName = getMethod(property);    URLType tt = metadata.getTypeMapping().createURL(null, schema.getPrefix(), property, (String) value);    Method setMethod = schemaClass.getMethod(setName, URLType.class);    Method getMethod = schemaClass.getMethod(getName);    setMethod.invoke(schema, tt);    String found = ((TextType) getMethod.invoke(schema)).getStringValue();    Assert.assertEquals(value, found);}
protected void pdfbox_f10087_0() throws Exception
{    String setName = setMethod(property);    String getName = getMethod(property);    AgentNameType tt = metadata.getTypeMapping().createAgentName(null, schema.getPrefix(), property, (String) value);    Method setMethod = schemaClass.getMethod(setName, AgentNameType.class);    Method getMethod = schemaClass.getMethod(getName);    setMethod.invoke(schema, tt);    String found = ((AgentNameType) getMethod.invoke(schema)).getStringValue();    Assert.assertEquals(value, found);}
protected void pdfbox_f10088_0(String tp) throws Exception
{    String setName = addToValueMethod(property);    String getName = getValueMethod(property);    String[] svalue = (String[]) value;    Arrays.sort(svalue);        Method setMethod = schemaClass.getMethod(setName, String.class);    for (String string : svalue) {        setMethod.invoke(schema, string);    }        Method getMethod = schemaClass.getMethod(getName);    List<String> fields = (List<String>) getMethod.invoke(schema);    for (String field : fields) {        Assert.assertTrue(field + " should be found in list", Arrays.binarySearch(svalue, field) >= 0);    }}
protected void pdfbox_f10089_0(String tp) throws Exception
{    String setName = addToValueMethod(property);    String getName = getValueMethod(property);    Calendar[] svalue = (Calendar[]) value;    Arrays.sort(svalue);        Method setMethod = schemaClass.getMethod(setName, Calendar.class);    for (Calendar inst : svalue) {        setMethod.invoke(schema, inst);    }        Method getMethod = schemaClass.getMethod(getName);    List<Calendar> fields = (List<Calendar>) getMethod.invoke(schema);    for (Calendar field : fields) {        Assert.assertTrue(field + " should be found in list", Arrays.binarySearch(svalue, field) >= 0);    }}
protected void pdfbox_f10090_0() throws Exception
{    String addName = addMethod(property);    String getName = getMethod(property);    Method setMethod = schemaClass.getMethod(addName, Integer.class, Integer.class, String.class, String.class);    Method getMethod = schemaClass.getMethod(getName);    Integer height = 162;    Integer width = 400;    String format = "JPEG";    String img = "/9j/4AAQSkZJRgABAgEASABIAAD";    setMethod.invoke(schema, height, width, format, img);    List<ThumbnailType> found = ((List<ThumbnailType>) getMethod.invoke(schema));    Assert.assertTrue(found.size() == 1);    ThumbnailType t1 = found.get(0);    Assert.assertEquals(height, t1.getHeight());    Assert.assertEquals(width, t1.getWidth());    Assert.assertEquals(format, t1.getFormat());    Assert.assertEquals(img, t1.getImage());}
protected void pdfbox_f10091_0() throws Exception
{    String setName = addToValueMethod(property);    String getName = getValueMethod(property);    Map<String, String> svalue = (Map<String, String>) value;        Method setMethod = schemaClass.getMethod(setName, String.class, String.class);    for (Map.Entry<String, String> inst : svalue.entrySet()) {        setMethod.invoke(schema, inst.getKey(), inst.getValue());    }        String getLanguagesName = "get" + firstUpper(property) + "Languages";    Method getLanguages = schemaClass.getMethod(getLanguagesName);    List<String> lgs = (List<String>) getLanguages.invoke(schema);    for (String string : lgs) {        Method getMethod = schemaClass.getMethod(getName, String.class);        String res = (String) getMethod.invoke(schema, string);        Assert.assertEquals(res, svalue.get(string));    }}
protected void pdfbox_f10092_0() throws Exception
{    String setName = addToValueMethod(property);    String getName = getValueMethod(property);    String svalue = (String) value;        Method setMethod = schemaClass.getMethod(setName, String.class, String.class);    setMethod.invoke(schema, property, svalue);        String getLanguagesName = "get" + firstUpper(property) + "Languages";    Method getLanguages = schemaClass.getMethod(getLanguagesName);    List<String> lgs = (List<String>) getLanguages.invoke(schema);    for (String string : lgs) {        Method getMethod = schemaClass.getMethod(getName, String.class);        String res = (String) getMethod.invoke(schema, string);        Assert.assertEquals(res, svalue);    }}
protected void pdfbox_f10093_0() throws Exception
{    String setName = setValueMethod(property);    String getName = getValueMethod(property);    Method setMethod = schemaClass.getMethod(setName, String.class);    Method getMethod = schemaClass.getMethod(getName);    setMethod.invoke(schema, value);    String found = (String) getMethod.invoke(schema);    Assert.assertEquals(value, found);}
protected void pdfbox_f10094_0() throws Exception
{    String setName = setValueMethod(property);    String getName = getValueMethod(property);    Method setMethod = schemaClass.getMethod(setName, Boolean.class);    Method getMethod = schemaClass.getMethod(getName);    setMethod.invoke(schema, value);    Boolean found = (Boolean) getMethod.invoke(schema);    Assert.assertEquals(value, found);}
protected void pdfbox_f10095_0() throws Exception
{    String setName = setValueMethod(property);    String getName = getValueMethod(property);    Method setMethod = schemaClass.getMethod(setName, Calendar.class);    Method getMethod = schemaClass.getMethod(getName);    setMethod.invoke(schema, value);    Calendar found = (Calendar) getMethod.invoke(schema);    Assert.assertEquals(value, found);}
protected void pdfbox_f10096_0() throws Exception
{    String setName = setValueMethod(property);    String getName = getValueMethod(property);    Method setMethod = schemaClass.getMethod(setName, Integer.class);    Method getMethod = schemaClass.getMethod(getName);    setMethod.invoke(schema, value);    Integer found = (Integer) getMethod.invoke(schema);    Assert.assertEquals(value, found);}
public void pdfbox_f10097_0() throws Exception
{    builder = new DomXmpParser();    metadata = XMPMetadata.createXMPMetadata();}
public void pdfbox_f10098_0() throws Exception
{    AdobePDFSchema schem = metadata.createAndAddAdobePDFSchema();    String keywords = "keywords ihih";    String pdfVersion = "1.4";    String producer = "producer";    schem.setKeywords(keywords);    schem.setPDFVersion(pdfVersion);        Assert.assertNull(schem.getProducer());    schem.setProducer(producer);    Assert.assertEquals("Keywords", schem.getKeywordsProperty().getPropertyName());    Assert.assertEquals(keywords, schem.getKeywords());    Assert.assertEquals("PDFVersion", schem.getPDFVersionProperty().getPropertyName());    Assert.assertEquals(pdfVersion, schem.getPDFVersion());    Assert.assertEquals("Producer", schem.getProducerProperty().getPropertyName());    Assert.assertEquals(producer, schem.getProducer());        Assert.assertEquals(schem, metadata.getAdobePDFSchema());}
public void pdfbox_f10099_0() throws Exception
{    PDFAIdentificationSchema pdfaid = metadata.createAndAddPFAIdentificationSchema();    String conformance = "kiohiohiohiohio";    pdfaid.setConformance(conformance);}
public void pdfbox_f10100_0() throws Exception
{    PDFAIdentificationSchema pdfaid = metadata.createAndAddPFAIdentificationSchema();    pdfaid.setPartValueWithString("1");    pdfaid.setPartValueWithString("ojoj");}
public void pdfbox_f10101_0() throws Exception
{    metadata = XMPMetadata.createXMPMetadata();    schema = metadata.createAndAddAdobePDFSchema();    schemaClass = AdobePDFSchema.class;}
public static Collection<Object[]> pdfbox_f10102_0() throws Exception
{    List<Object[]> data = new ArrayList<>();    data.add(wrapProperty("Keywords", Types.Text, "kw1 kw2 kw3"));    data.add(wrapProperty("PDFVersion", Types.Text, "1.4"));    data.add(wrapProperty("Producer", Types.Text, "testcase"));    return data;}
public void pdfbox_f10103_0() throws Exception
{    AdobePDFSchema schem = metadata.createAndAddAdobePDFSchema();    String keywords = "keywords ihih";    String pdfVersion = "1.4";    String producer = "producer";    schem.setKeywords(keywords);    schem.setPDFVersion(pdfVersion);        Assert.assertNull(schem.getProducer());    schem.setProducer(producer);    Assert.assertEquals("pdf", schem.getKeywordsProperty().getPrefix());    Assert.assertEquals("Keywords", schem.getKeywordsProperty().getPropertyName());    Assert.assertEquals(keywords, schem.getKeywords());    Assert.assertEquals("pdf", schem.getPDFVersionProperty().getPrefix());    Assert.assertEquals("PDFVersion", schem.getPDFVersionProperty().getPropertyName());    Assert.assertEquals(pdfVersion, schem.getPDFVersion());    Assert.assertEquals("pdf", schem.getProducerProperty().getPrefix());    Assert.assertEquals("Producer", schem.getProducerProperty().getPropertyName());    Assert.assertEquals(producer, schem.getProducer());}
public void pdfbox_f10104_0() throws BadFieldValueException
{    PDFAIdentificationSchema pdfaid = metadata.createAndAddPFAIdentificationSchema();    String conformance = "kiohiohiohiohio";    pdfaid.setConformance(conformance);}
public static void pdfbox_f10105_0() throws Exception
{    builder = new DomXmpParser();}
public void pdfbox_f10106_0() throws Exception
{    metadata = XMPMetadata.createXMPMetadata();    serializer = new XmpSerializer();}
public void pdfbox_f10107_0() throws Exception
{    XMPBasicJobTicketSchema basic = metadata.createAndAddBasicJobTicketSchema();    basic.addJob("zeid1", "zename1", "zeurl1", "aaa");    basic.addJob("zeid2", "zename2", "zeurl2");        ByteArrayOutputStream bos = new ByteArrayOutputStream();    serializer.serialize(metadata, bos, true);    XMPMetadata rxmp = builder.parse(bos.toByteArray());    XMPBasicJobTicketSchema jt = rxmp.getBasicJobTicketSchema();    Assert.assertNotNull(jt);    Assert.assertEquals(2, jt.getJobs().size());}
public void pdfbox_f10108_0() throws Exception
{    XMPBasicJobTicketSchema basic = metadata.createAndAddBasicJobTicketSchema();    basic.addJob("zeid2", "zename2", "zeurl2");        ByteArrayOutputStream bos = new ByteArrayOutputStream();    serializer.serialize(metadata, bos, true);    XMPMetadata rxmp = builder.parse(bos.toByteArray());    XMPBasicJobTicketSchema jt = rxmp.getBasicJobTicketSchema();    Assert.assertNotNull(jt);    Assert.assertEquals(1, jt.getJobs().size());    StructuredType stjob = JobType.class.getAnnotation(StructuredType.class);    JobType job = jt.getJobs().get(0);    Assert.assertEquals("zeid2", job.getId());    Assert.assertEquals("zename2", job.getName());    Assert.assertEquals("zeurl2", job.getUrl());}
public void pdfbox_f10109_0() throws Exception
{    XMPBasicJobTicketSchema basic = metadata.createAndAddBasicJobTicketSchema();    basic.addJob("zeid2", "zename2", "zeurl2", "aaa");            ByteArrayOutputStream bos = new ByteArrayOutputStream();    serializer.serialize(metadata, bos, true);    XMPMetadata rxmp = builder.parse(bos.toByteArray());    XMPBasicJobTicketSchema jt = rxmp.getBasicJobTicketSchema();    Assert.assertNotNull(jt);    Assert.assertEquals(1, jt.getJobs().size());    JobType job = jt.getJobs().get(0);                Assert.assertEquals("zeid2", job.getId());    Assert.assertEquals("zename2", job.getName());    Assert.assertEquals("zeurl2", job.getUrl());}
public DublinCoreSchema pdfbox_f10110_0()
{    return xmp.createAndAddDublinCoreSchema();}
public void pdfbox_f10111_0() throws Exception
{    super.before();}
public static Collection<Object[]> pdfbox_f10112_0() throws Exception
{    Collection<Object[]> result = new ArrayList<>();    result.add(new Object[] { "contributor", Types.ProperName, Cardinality.Bag });    result.add(new Object[] { "coverage", Types.Text, Cardinality.Simple });    result.add(new Object[] { "creator", Types.ProperName, Cardinality.Seq });    result.add(new Object[] { "date", Types.Date, Cardinality.Seq });    result.add(new Object[] { "format", Types.MIMEType, Cardinality.Simple });    result.add(new Object[] { "identifier", Types.Text, Cardinality.Simple });    result.add(new Object[] { "language", Types.Locale, Cardinality.Bag });    result.add(new Object[] { "publisher", Types.ProperName, Cardinality.Bag });    result.add(new Object[] { "relation", Types.Text, Cardinality.Bag });    result.add(new Object[] { "source", Types.Text, Cardinality.Simple });    result.add(new Object[] { "subject", Types.Text, Cardinality.Bag });    result.add(new Object[] { "type", Types.Text, Cardinality.Bag });    return result;}
public void pdfbox_f10113_0() throws Exception
{    metadata = XMPMetadata.createXMPMetadata();}
public void pdfbox_f10114_0() throws Exception
{    PDFAIdentificationSchema pdfaid = metadata.createAndAddPFAIdentificationSchema();    Integer versionId = 1;    String amdId = "2005";    String conformance = "B";    pdfaid.setPartValueWithInt(versionId);    pdfaid.setAmd(amdId);    pdfaid.setConformance(conformance);    Assert.assertEquals(versionId, pdfaid.getPart());    Assert.assertEquals(amdId, pdfaid.getAmendment());    Assert.assertEquals(conformance, pdfaid.getConformance());    Assert.assertEquals("" + versionId, pdfaid.getPartProperty().getStringValue());    Assert.assertEquals(amdId, pdfaid.getAmdProperty().getStringValue());    Assert.assertEquals(conformance, pdfaid.getConformanceProperty().getStringValue());        Assert.assertEquals(pdfaid, metadata.getPDFIdentificationSchema());}
public void pdfbox_f10115_0() throws BadFieldValueException
{    PDFAIdentificationSchema pdfaid = metadata.createAndAddPFAIdentificationSchema();    String conformance = "kiohiohiohiohio";    pdfaid.setConformance(conformance);}
public void pdfbox_f10116_0() throws Exception
{    PDFAIdentificationSchema pdfaid = metadata.createAndAddPFAIdentificationSchema();    pdfaid.setPartValueWithString("1");    pdfaid.setPartValueWithString("ojoj");}
public void pdfbox_f10117_0() throws Exception
{    metadata = XMPMetadata.createXMPMetadata();    schema = metadata.createAndAddPFAIdentificationSchema();    schemaClass = PDFAIdentificationSchema.class;}
public static Collection<Object[]> pdfbox_f10118_0() throws Exception
{    List<Object[]> data = new ArrayList<>();    data.add(wrapProperty("part", Types.Integer, 1));    data.add(wrapProperty("amd", Types.Text, "2005"));    data.add(wrapProperty("conformance", Types.Text, "B"));    return data;}
public PhotoshopSchema pdfbox_f10119_0()
{    return xmp.createAndAddPhotoshopSchema();}
public void pdfbox_f10120_0() throws Exception
{    super.before();}
public static Collection<Object[]> pdfbox_f10121_0() throws Exception
{    Collection<Object[]> result = new ArrayList<>();    result.add(new Object[] { "AncestorID", Types.URI, Cardinality.Simple });    result.add(new Object[] { "AuthorsPosition", Types.Text, Cardinality.Simple });    result.add(new Object[] { "CaptionWriter", Types.ProperName, Cardinality.Simple });    result.add(new Object[] { "Category", Types.Text, Cardinality.Simple });    result.add(new Object[] { "City", Types.Text, Cardinality.Simple });    result.add(new Object[] { "ColorMode", Types.Integer, Cardinality.Simple });    result.add(new Object[] { "Country", Types.Text, Cardinality.Simple });    result.add(new Object[] { "Credit", Types.Text, Cardinality.Simple });    result.add(new Object[] { "DateCreated", Types.Date, Cardinality.Simple });    result.add(new Object[] { "Headline", Types.Text, Cardinality.Simple });    result.add(new Object[] { "History", Types.Text, Cardinality.Simple });    result.add(new Object[] { "ICCProfile", Types.Text, Cardinality.Simple });    result.add(new Object[] { "Instructions", Types.Text, Cardinality.Simple });    result.add(new Object[] { "Source", Types.Text, Cardinality.Simple });    result.add(new Object[] { "State", Types.Text, Cardinality.Simple });    result.add(new Object[] { "SupplementalCategories", Types.Text, Cardinality.Simple });    result.add(new Object[] { "TransmissionReference", Types.Text, Cardinality.Simple });    result.add(new Object[] { "Urgency", Types.Integer, Cardinality.Simple });    return result;}
public void pdfbox_f10122_0() throws Exception
{    InputStream is = this.getClass().getResourceAsStream("/validxmp/exif.xmp");    DomXmpParser builder = new DomXmpParser();    builder.setStrictParsing(false);    XMPMetadata rxmp = builder.parse(is);    ExifSchema schema = (ExifSchema) rxmp.getSchema(ExifSchema.class);    TextType ss = (TextType) schema.getProperty(ExifSchema.SPECTRAL_SENSITIVITY);    Assert.assertNotNull(ss);    Assert.assertEquals("spectral sens value", ss.getValue());}
public void pdfbox_f10123_0() throws Exception
{    XMPMetadata metadata = XMPMetadata.createXMPMetadata();    TypeMapping tmapping = metadata.getTypeMapping();    ExifSchema exif = new ExifSchema(metadata);    metadata.addSchema(exif);    OECFType oecf = new OECFType(metadata);    oecf.addProperty(tmapping.createInteger(oecf.getNamespace(), oecf.getPrefix(), OECFType.COLUMNS, 14));    oecf.setPropertyName(ExifSchema.OECF);    exif.addProperty(oecf);    XmpSerializer serializer = new XmpSerializer();    serializer.serialize(metadata, new ByteArrayOutputStream(), false);}
public void pdfbox_f10124_0() throws Exception
{    metadata = XMPMetadata.createXMPMetadata();    schema = metadata.createAndAddXMPBasicSchema();    schemaClass = XMPBasicSchema.class;}
public static Collection<Object[]> pdfbox_f10125_0() throws Exception
{    List<Object[]> data = new ArrayList<>();    data.add(wrapProperty("Advisory", Types.XPath, Cardinality.Bag, new String[] { "xpath1", "xpath2" }));    data.add(wrapProperty("BaseURL", Types.URL, "URL"));    data.add(wrapProperty("CreateDate", Types.Date, Calendar.getInstance()));    data.add(wrapProperty("CreatorTool", Types.AgentName, "CreatorTool"));    data.add(wrapProperty("Identifier", Types.Text, Cardinality.Bag, new String[] { "id1", "id2" }));    data.add(wrapProperty("Label", Types.Text, "label"));    data.add(wrapProperty("MetadataDate", Types.Date, Calendar.getInstance()));    data.add(wrapProperty("ModifyDate", Types.Date, Calendar.getInstance()));    data.add(wrapProperty("Nickname", Types.Text, "nick name"));    data.add(wrapProperty("Rating", Types.Integer, 7));    data.add(wrapProperty("Thumbnails", Types.Thumbnail, Cardinality.Alt, null));    return data;}
public void pdfbox_f10126_0() throws Exception
{    metadata = XMPMetadata.createXMPMetadata();    schema = metadata.createAndAddXMPMediaManagementSchema();    schemaClass = XMPMediaManagementSchema.class;}
