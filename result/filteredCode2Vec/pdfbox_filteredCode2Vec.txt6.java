public int pdfbox_f6081_0()
{    return getCOSObject().getInt(COSName.Q, 0);}
public void pdfbox_f6082_0(int q)
{    getCOSObject().setInt(COSName.Q, q);}
public void pdfbox_f6083_0(float difference)
{    setRectDifferences(difference, difference, difference, difference);}
public void pdfbox_f6084_0(float differenceLeft, float differenceTop, float differenceRight, float differenceBottom)
{    COSArray margins = new COSArray();    margins.add(new COSFloat(differenceLeft));    margins.add(new COSFloat(differenceTop));    margins.add(new COSFloat(differenceRight));    margins.add(new COSFloat(differenceBottom));    getCOSObject().setItem(COSName.RD, margins);}
public float[] pdfbox_f6085_0()
{    COSBase margin = getCOSObject().getItem(COSName.RD);    if (margin instanceof COSArray) {        return ((COSArray) margin).toFloatArray();    }    return new float[] {};}
public final void pdfbox_f6086_0(float[] callout)
{    COSArray newCallout = new COSArray();    newCallout.setFloatArray(callout);    getCOSObject().setItem(COSName.CL, newCallout);}
public float[] pdfbox_f6087_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.CL);    if (base instanceof COSArray) {        return ((COSArray) base).toFloatArray();    }    return null;}
public final void pdfbox_f6088_0(String style)
{    getCOSObject().setName(COSName.LE, style);}
public String pdfbox_f6089_0()
{    return getCOSObject().getNameAsString(COSName.LE, PDAnnotationLine.LE_NONE);}
public void pdfbox_f6090_0(PDBorderEffectDictionary be)
{    getCOSObject().setItem(COSName.BE, be);}
public PDBorderEffectDictionary pdfbox_f6091_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.BE);    if (base instanceof COSDictionary) {        return new PDBorderEffectDictionary((COSDictionary) base);    }    return null;}
public void pdfbox_f6092_0(PDRectangle rd)
{    getCOSObject().setItem(COSName.RD, rd);}
public PDRectangle pdfbox_f6093_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.RD);    if (base instanceof COSArray) {        return new PDRectangle((COSArray) base);    }    return null;}
public void pdfbox_f6094_0(PDAppearanceHandler appearanceHandler)
{    customAppearanceHandler = appearanceHandler;}
public void pdfbox_f6095_0()
{    this.constructAppearances(null);}
public void pdfbox_f6096_0(PDDocument document)
{    if (customAppearanceHandler == null) {        PDFreeTextAppearanceHandler appearanceHandler = new PDFreeTextAppearanceHandler(this, document);        appearanceHandler.generateAppearanceStreams();    } else {        customAppearanceHandler.generateAppearanceStreams();    }}
public void pdfbox_f6097_0(PDAppearanceHandler appearanceHandler)
{    customAppearanceHandler = appearanceHandler;}
public void pdfbox_f6098_0()
{    this.constructAppearances(null);}
public void pdfbox_f6099_0(PDDocument document)
{    if (customAppearanceHandler == null) {        PDHighlightAppearanceHandler appearanceHandler = new PDHighlightAppearanceHandler(this, document);        appearanceHandler.generateAppearanceStreams();    } else {        customAppearanceHandler.generateAppearanceStreams();    }}
public void pdfbox_f6100_0(float[][] inkList)
{    if (inkList == null) {        getCOSObject().removeItem(COSName.INKLIST);        return;    }    COSArray array = new COSArray();    for (float[] path : inkList) {        COSArray innerArray = new COSArray();        innerArray.setFloatArray(path);        array.add(innerArray);    }    getCOSObject().setItem(COSName.INKLIST, array);}
public float[][] pdfbox_f6101_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.INKLIST);    if (base instanceof COSArray) {        COSArray array = (COSArray) base;        float[][] inkList = new float[array.size()][];        for (int i = 0; i < array.size(); ++i) {            COSBase base2 = array.getObject(i);            if (base2 instanceof COSArray) {                inkList[i] = ((COSArray) array.getObject(i)).toFloatArray();            } else {                inkList[i] = new float[0];            }        }        return inkList;    }    return new float[0][0];}
public void pdfbox_f6102_0(PDAppearanceHandler appearanceHandler)
{    customAppearanceHandler = appearanceHandler;}
public void pdfbox_f6103_0()
{    this.constructAppearances(null);}
public void pdfbox_f6104_0(PDDocument document)
{    if (customAppearanceHandler == null) {        PDInkAppearanceHandler appearanceHandler = new PDInkAppearanceHandler(this, document);        appearanceHandler.generateAppearanceStreams();    } else {        customAppearanceHandler.generateAppearanceStreams();    }}
public void pdfbox_f6105_0(float[] l)
{    COSArray newL = new COSArray();    newL.setFloatArray(l);    getCOSObject().setItem(COSName.L, newL);}
public float[] pdfbox_f6106_0()
{    COSArray l = (COSArray) getCOSObject().getDictionaryObject(COSName.L);    return l.toFloatArray();}
public void pdfbox_f6107_0(String style)
{    String actualStyle = style == null ? PDAnnotationLine.LE_NONE : style;    COSBase base = getCOSObject().getDictionaryObject(COSName.LE);    COSArray array;    if (!(base instanceof COSArray) || ((COSArray) base).size() == 0) {        array = new COSArray();        array.add(COSName.getPDFName(actualStyle));        array.add(COSName.getPDFName(PDAnnotationLine.LE_NONE));        getCOSObject().setItem(COSName.LE, array);    } else {        array = (COSArray) base;        array.setName(0, actualStyle);    }}
public String pdfbox_f6108_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.LE);    if (base instanceof COSArray && ((COSArray) base).size() >= 2) {        return ((COSArray) base).getName(0, LE_NONE);    }    return LE_NONE;}
public void pdfbox_f6109_0(String style)
{    String actualStyle = style == null ? PDAnnotationLine.LE_NONE : style;    COSBase base = getCOSObject().getDictionaryObject(COSName.LE);    COSArray array;    if (!(base instanceof COSArray) || ((COSArray) base).size() < 2) {        array = new COSArray();        array.add(COSName.getPDFName(PDAnnotationLine.LE_NONE));        array.add(COSName.getPDFName(actualStyle));        getCOSObject().setItem(COSName.LE, array);    } else {        array = (COSArray) base;        array.setName(1, actualStyle);    }}
public String pdfbox_f6110_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.LE);    if (base instanceof COSArray && ((COSArray) base).size() >= 2) {        return ((COSArray) base).getName(1, LE_NONE);    }    return LE_NONE;}
public void pdfbox_f6111_0(PDColor ic)
{    getCOSObject().setItem(COSName.IC, ic.toCOSArray());}
public PDColor pdfbox_f6112_0()
{    return getColor(COSName.IC);}
public void pdfbox_f6113_0(boolean cap)
{    getCOSObject().setBoolean(COSName.CAP, cap);}
public boolean pdfbox_f6114_0()
{    return getCOSObject().getBoolean(COSName.CAP, false);}
public float pdfbox_f6115_0()
{    return this.getCOSObject().getFloat(COSName.LL, 0);}
public void pdfbox_f6116_0(float leaderLineLength)
{    this.getCOSObject().setFloat(COSName.LL, leaderLineLength);}
public float pdfbox_f6117_0()
{    return this.getCOSObject().getFloat(COSName.LLE, 0);}
public void pdfbox_f6118_0(float leaderLineExtensionLength)
{    this.getCOSObject().setFloat(COSName.LLE, leaderLineExtensionLength);}
public float pdfbox_f6119_0()
{    return this.getCOSObject().getFloat(COSName.LLO, 0);}
public void pdfbox_f6120_0(float leaderLineOffsetLength)
{    this.getCOSObject().setFloat(COSName.LLO, leaderLineOffsetLength);}
public String pdfbox_f6121_0()
{    return this.getCOSObject().getNameAsString(COSName.CP);}
public void pdfbox_f6122_0(String captionPositioning)
{    this.getCOSObject().setName(COSName.CP, captionPositioning);}
public void pdfbox_f6123_0(float offset)
{    COSArray array = (COSArray) this.getCOSObject().getDictionaryObject(COSName.CO);    if (array == null) {        array = new COSArray();        array.setFloatArray(new float[] { offset, 0.f });        this.getCOSObject().setItem(COSName.CO, array);    } else {        array.set(0, new COSFloat(offset));    }}
public float pdfbox_f6124_0()
{    float retval = 0.f;    COSArray array = (COSArray) this.getCOSObject().getDictionaryObject(COSName.CO);    if (array != null) {        retval = array.toFloatArray()[0];    }    return retval;}
public void pdfbox_f6125_0(float offset)
{    COSArray array = (COSArray) this.getCOSObject().getDictionaryObject(COSName.CO);    if (array == null) {        array = new COSArray();        array.setFloatArray(new float[] { 0.f, offset });        this.getCOSObject().setItem(COSName.CO, array);    } else {        array.set(1, new COSFloat(offset));    }}
public float pdfbox_f6126_0()
{    float retval = 0.f;    COSArray array = (COSArray) this.getCOSObject().getDictionaryObject(COSName.CO);    if (array != null) {        retval = array.toFloatArray()[1];    }    return retval;}
public void pdfbox_f6127_0(PDAppearanceHandler appearanceHandler)
{    customAppearanceHandler = appearanceHandler;}
public void pdfbox_f6128_0()
{    this.constructAppearances(null);}
public void pdfbox_f6129_0(PDDocument document)
{    if (customAppearanceHandler == null) {        PDLineAppearanceHandler appearanceHandler = new PDLineAppearanceHandler(this, document);        appearanceHandler.generateAppearanceStreams();    } else {        customAppearanceHandler.generateAppearanceStreams();    }}
public PDAction pdfbox_f6130_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.A);    if (base instanceof COSDictionary) {        return PDActionFactory.createAction((COSDictionary) base);    }    return null;}
public void pdfbox_f6131_0(PDAction action)
{    this.getCOSObject().setItem(COSName.A, action);}
public void pdfbox_f6132_0(PDBorderStyleDictionary bs)
{    this.getCOSObject().setItem(COSName.BS, bs);}
public PDBorderStyleDictionary pdfbox_f6133_0()
{    COSBase bs = getCOSObject().getDictionaryObject(COSName.BS);    if (bs instanceof COSDictionary) {        return new PDBorderStyleDictionary((COSDictionary) bs);    }    return null;}
public PDDestination pdfbox_f6134_0() throws IOException
{    COSBase base = getCOSObject().getDictionaryObject(COSName.DEST);    return PDDestination.create(base);}
public void pdfbox_f6135_0(PDDestination dest)
{    getCOSObject().setItem(COSName.DEST, dest);}
public String pdfbox_f6136_0()
{    return getCOSObject().getNameAsString(COSName.H, HIGHLIGHT_MODE_INVERT);}
public void pdfbox_f6137_0(String mode)
{    getCOSObject().setName(COSName.H, mode);}
public void pdfbox_f6138_0(PDActionURI pa)
{    getCOSObject().setItem("PA", pa);}
public PDActionURI pdfbox_f6139_0()
{    COSBase base = getCOSObject().getDictionaryObject("PA");    if (base instanceof COSDictionary) {        return new PDActionURI((COSDictionary) base);    }    return null;}
public void pdfbox_f6140_0(float[] quadPoints)
{    COSArray newQuadPoints = new COSArray();    newQuadPoints.setFloatArray(quadPoints);    getCOSObject().setItem(COSName.QUADPOINTS, newQuadPoints);}
public float[] pdfbox_f6141_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.QUADPOINTS);    if (base instanceof COSArray) {        return ((COSArray) base).toFloatArray();    }    return null;}
public void pdfbox_f6142_0(PDAppearanceHandler appearanceHandler)
{    customAppearanceHandler = appearanceHandler;}
public void pdfbox_f6143_0()
{    this.constructAppearances(null);}
public void pdfbox_f6144_0(PDDocument document)
{    if (customAppearanceHandler == null) {        PDLinkAppearanceHandler appearanceHandler = new PDLinkAppearanceHandler(this, document);        appearanceHandler.generateAppearanceStreams();    } else {        customAppearanceHandler.generateAppearanceStreams();    }}
public String pdfbox_f6145_0()
{    return getCOSObject().getString(COSName.T);}
public void pdfbox_f6146_0(String t)
{    getCOSObject().setString(COSName.T, t);}
public PDAnnotationPopup pdfbox_f6147_0()
{    COSDictionary popup = (COSDictionary) getCOSObject().getDictionaryObject("Popup");    if (popup != null) {        return new PDAnnotationPopup(popup);    } else {        return null;    }}
public void pdfbox_f6148_0(PDAnnotationPopup popup)
{    getCOSObject().setItem("Popup", popup);}
public float pdfbox_f6149_0()
{    return getCOSObject().getFloat(COSName.CA, 1);}
public void pdfbox_f6150_0(float ca)
{    getCOSObject().setFloat(COSName.CA, ca);}
public String pdfbox_f6151_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.RC);    if (base instanceof COSString) {        return ((COSString) base).getString();    } else if (base instanceof COSStream) {        return ((COSStream) base).toTextString();    } else {        return null;    }}
public void pdfbox_f6152_0(String rc)
{    getCOSObject().setItem(COSName.RC, new COSString(rc));}
public Calendar pdfbox_f6153_0()
{    return getCOSObject().getDate(COSName.CREATION_DATE);}
public void pdfbox_f6154_0(Calendar creationDate)
{    getCOSObject().setDate(COSName.CREATION_DATE, creationDate);}
public PDAnnotation pdfbox_f6155_0() throws IOException
{    COSBase base = getCOSObject().getDictionaryObject("IRT");    if (base instanceof COSDictionary) {        return PDAnnotation.createAnnotation(base);    }    return null;}
public void pdfbox_f6156_0(PDAnnotation irt)
{    getCOSObject().setItem("IRT", irt);}
public String pdfbox_f6157_0()
{    return getCOSObject().getString(COSName.SUBJ);}
public void pdfbox_f6158_0(String subj)
{    getCOSObject().setString(COSName.SUBJ, subj);}
public String pdfbox_f6159_0()
{    return getCOSObject().getNameAsString("RT", RT_REPLY);}
public void pdfbox_f6160_0(String rt)
{    getCOSObject().setName("RT", rt);}
public String pdfbox_f6161_0()
{    return getCOSObject().getNameAsString(COSName.IT);}
public void pdfbox_f6162_0(String it)
{    getCOSObject().setName(COSName.IT, it);}
public PDExternalDataDictionary pdfbox_f6163_0()
{    COSBase exData = this.getCOSObject().getDictionaryObject("ExData");    if (exData instanceof COSDictionary) {        return new PDExternalDataDictionary((COSDictionary) exData);    }    return null;}
public void pdfbox_f6164_0(PDExternalDataDictionary externalData)
{    this.getCOSObject().setItem("ExData", externalData);}
public void pdfbox_f6165_0(PDBorderStyleDictionary bs)
{    this.getCOSObject().setItem(COSName.BS, bs);}
public PDBorderStyleDictionary pdfbox_f6166_0()
{    COSBase bs = getCOSObject().getDictionaryObject(COSName.BS);    if (bs instanceof COSDictionary) {        return new PDBorderStyleDictionary((COSDictionary) bs);    }    return null;}
public void pdfbox_f6167_0(PDColor ic)
{    getCOSObject().setItem(COSName.IC, ic.toCOSArray());}
public PDColor pdfbox_f6168_0()
{    return getColor(COSName.IC);}
public void pdfbox_f6169_0(PDBorderEffectDictionary be)
{    getCOSObject().setItem(COSName.BE, be);}
public PDBorderEffectDictionary pdfbox_f6170_0()
{    COSDictionary be = (COSDictionary) getCOSObject().getDictionaryObject(COSName.BE);    if (be != null) {        return new PDBorderEffectDictionary(be);    } else {        return null;    }}
public float[] pdfbox_f6171_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.VERTICES);    if (base instanceof COSArray) {        return ((COSArray) base).toFloatArray();    }    return null;}
public void pdfbox_f6172_0(float[] points)
{    COSArray ar = new COSArray();    ar.setFloatArray(points);    getCOSObject().setItem(COSName.VERTICES, ar);}
public float[][] pdfbox_f6173_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.PATH);    if (base instanceof COSArray) {        COSArray array = (COSArray) base;        float[][] pathArray = new float[array.size()][];        for (int i = 0; i < array.size(); ++i) {            COSBase base2 = array.getObject(i);            if (base2 instanceof COSArray) {                pathArray[i] = ((COSArray) array.getObject(i)).toFloatArray();            } else {                pathArray[i] = new float[0];            }        }        return pathArray;    }    return null;}
public void pdfbox_f6174_0(PDAppearanceHandler appearanceHandler)
{    customAppearanceHandler = appearanceHandler;}
public void pdfbox_f6175_0()
{    this.constructAppearances(null);}
public void pdfbox_f6176_0(PDDocument document)
{    if (customAppearanceHandler == null) {        PDPolygonAppearanceHandler appearanceHandler = new PDPolygonAppearanceHandler(this, document);        appearanceHandler.generateAppearanceStreams();    } else {        customAppearanceHandler.generateAppearanceStreams();    }}
public void pdfbox_f6177_0(String style)
{    String actualStyle = style == null ? PDAnnotationLine.LE_NONE : style;    COSBase base = getCOSObject().getDictionaryObject(COSName.LE);    COSArray array;    if (!(base instanceof COSArray) || ((COSArray) base).size() == 0) {        array = new COSArray();        array.add(COSName.getPDFName(actualStyle));        array.add(COSName.getPDFName(PDAnnotationLine.LE_NONE));        getCOSObject().setItem(COSName.LE, array);    } else {        array = (COSArray) base;        array.setName(0, actualStyle);    }}
public String pdfbox_f6178_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.LE);    if (base instanceof COSArray && ((COSArray) base).size() >= 2) {        return ((COSArray) base).getName(0, PDAnnotationLine.LE_NONE);    }    return PDAnnotationLine.LE_NONE;}
public void pdfbox_f6179_0(String style)
{    String actualStyle = style == null ? PDAnnotationLine.LE_NONE : style;    COSBase base = getCOSObject().getDictionaryObject(COSName.LE);    COSArray array;    if (!(base instanceof COSArray) || ((COSArray) base).size() < 2) {        array = new COSArray();        array.add(COSName.getPDFName(PDAnnotationLine.LE_NONE));        array.add(COSName.getPDFName(actualStyle));        getCOSObject().setItem(COSName.LE, array);    } else {        array = (COSArray) base;        array.setName(1, actualStyle);    }}
public String pdfbox_f6180_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.LE);    if (base instanceof COSArray && ((COSArray) base).size() >= 2) {        return ((COSArray) base).getName(1, PDAnnotationLine.LE_NONE);    }    return PDAnnotationLine.LE_NONE;}
public void pdfbox_f6181_0(PDColor ic)
{    getCOSObject().setItem(COSName.IC, ic.toCOSArray());}
public PDColor pdfbox_f6182_0()
{    return getColor(COSName.IC);}
public float[] pdfbox_f6183_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.VERTICES);    if (base instanceof COSArray) {        return ((COSArray) base).toFloatArray();    }    return null;}
public void pdfbox_f6184_0(float[] points)
{    COSArray ar = new COSArray();    ar.setFloatArray(points);    getCOSObject().setItem(COSName.VERTICES, ar);}
public void pdfbox_f6185_0(PDAppearanceHandler appearanceHandler)
{    customAppearanceHandler = appearanceHandler;}
public void pdfbox_f6186_0()
{    this.constructAppearances(null);}
public void pdfbox_f6187_0(PDDocument document)
{    if (customAppearanceHandler == null) {        PDPolylineAppearanceHandler appearanceHandler = new PDPolylineAppearanceHandler(this, document);        appearanceHandler.generateAppearanceStreams();    } else {        customAppearanceHandler.generateAppearanceStreams();    }}
public void pdfbox_f6188_0(boolean open)
{    getCOSObject().setBoolean("Open", open);}
public boolean pdfbox_f6189_0()
{    return getCOSObject().getBoolean("Open", false);}
public void pdfbox_f6190_0(PDAnnotationMarkup annot)
{    getCOSObject().setItem(COSName.PARENT, annot.getCOSObject());}
public PDAnnotationMarkup pdfbox_f6191_1()
{    PDAnnotationMarkup am = null;    try {        am = (PDAnnotationMarkup) PDAnnotation.createAnnotation(getCOSObject().getDictionaryObject(COSName.PARENT, COSName.P));    } catch (IOException ioe) {                }    return am;}
public void pdfbox_f6192_0(String name)
{    getCOSObject().setName(COSName.NAME, name);}
public String pdfbox_f6193_0()
{    return getCOSObject().getNameAsString(COSName.NAME, NAME_DRAFT);}
public void pdfbox_f6194_0(PDAppearanceHandler appearanceHandler)
{    customAppearanceHandler = appearanceHandler;}
public void pdfbox_f6195_0()
{    this.constructAppearances(null);}
public void pdfbox_f6196_0(PDDocument document)
{    if (customAppearanceHandler == null) {        PDSoundAppearanceHandler appearanceHandler = new PDSoundAppearanceHandler(this, document);        appearanceHandler.generateAppearanceStreams();    } else {        customAppearanceHandler.generateAppearanceStreams();    }}
public void pdfbox_f6197_0(PDAppearanceHandler appearanceHandler)
{    customAppearanceHandler = appearanceHandler;}
public void pdfbox_f6198_0()
{    this.constructAppearances(null);}
public void pdfbox_f6199_0(PDDocument document)
{    if (customAppearanceHandler == null) {        PDSquareAppearanceHandler appearanceHandler = new PDSquareAppearanceHandler(this, document);        appearanceHandler.generateAppearanceStreams();    } else {        customAppearanceHandler.generateAppearanceStreams();    }}
public void pdfbox_f6200_0(PDColor ic)
{    getCOSObject().setItem(COSName.IC, ic.toCOSArray());}
public PDColor pdfbox_f6201_0()
{    return getColor(COSName.IC);}
public void pdfbox_f6202_0(PDBorderEffectDictionary be)
{    getCOSObject().setItem(COSName.BE, be);}
public PDBorderEffectDictionary pdfbox_f6203_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.BE);    if (base instanceof COSDictionary) {        return new PDBorderEffectDictionary((COSDictionary) base);    }    return null;}
public void pdfbox_f6204_0(PDRectangle rd)
{    getCOSObject().setItem(COSName.RD, rd);}
public PDRectangle pdfbox_f6205_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.RD);    if (base instanceof COSArray) {        return new PDRectangle((COSArray) base);    }    return null;}
public void pdfbox_f6206_0(float difference)
{    setRectDifferences(difference, difference, difference, difference);}
public void pdfbox_f6207_0(float differenceLeft, float differenceTop, float differenceRight, float differenceBottom)
{    COSArray margins = new COSArray();    margins.add(new COSFloat(differenceLeft));    margins.add(new COSFloat(differenceTop));    margins.add(new COSFloat(differenceRight));    margins.add(new COSFloat(differenceBottom));    getCOSObject().setItem(COSName.RD, margins);}
public float[] pdfbox_f6208_0()
{    COSBase margin = getCOSObject().getItem(COSName.RD);    if (margin instanceof COSArray) {        return ((COSArray) margin).toFloatArray();    }    return new float[] {};}
public void pdfbox_f6209_0(PDAppearanceHandler appearanceHandler)
{    customAppearanceHandler = appearanceHandler;}
public void pdfbox_f6210_0()
{    this.constructAppearances(null);}
public void pdfbox_f6211_0(PDDocument document)
{    if (customAppearanceHandler == null) {        PDSquigglyAppearanceHandler appearanceHandler = new PDSquigglyAppearanceHandler(this, document);        appearanceHandler.generateAppearanceStreams();    } else {        customAppearanceHandler.generateAppearanceStreams();    }}
public void pdfbox_f6212_0(PDAppearanceHandler appearanceHandler)
{    customAppearanceHandler = appearanceHandler;}
public void pdfbox_f6213_0()
{    this.constructAppearances(null);}
public void pdfbox_f6214_0(PDDocument document)
{    if (customAppearanceHandler == null) {        PDStrikeoutAppearanceHandler appearanceHandler = new PDStrikeoutAppearanceHandler(this, document);        appearanceHandler.generateAppearanceStreams();    } else {        customAppearanceHandler.generateAppearanceStreams();    }}
public void pdfbox_f6215_0(boolean open)
{    getCOSObject().setBoolean(COSName.getPDFName("Open"), open);}
public boolean pdfbox_f6216_0()
{    return getCOSObject().getBoolean(COSName.getPDFName("Open"), false);}
public void pdfbox_f6217_0(String name)
{    getCOSObject().setName(COSName.NAME, name);}
public String pdfbox_f6218_0()
{    return getCOSObject().getNameAsString(COSName.NAME, NAME_NOTE);}
public String pdfbox_f6219_0()
{    return this.getCOSObject().getString(COSName.STATE);}
public void pdfbox_f6220_0(String state)
{    this.getCOSObject().setString(COSName.STATE, state);}
public String pdfbox_f6221_0()
{    return this.getCOSObject().getString(COSName.STATE_MODEL);}
public void pdfbox_f6222_0(String stateModel)
{    this.getCOSObject().setString(COSName.STATE_MODEL, stateModel);}
public void pdfbox_f6223_0(PDAppearanceHandler appearanceHandler)
{    customAppearanceHandler = appearanceHandler;}
public void pdfbox_f6224_0()
{    this.constructAppearances(null);}
public void pdfbox_f6225_0(PDDocument document)
{    if (customAppearanceHandler == null) {        PDTextAppearanceHandler appearanceHandler = new PDTextAppearanceHandler(this, document);        appearanceHandler.generateAppearanceStreams();    } else {        customAppearanceHandler.generateAppearanceStreams();    }}
public final void pdfbox_f6226_0(float[] quadPoints)
{    COSArray newQuadPoints = new COSArray();    newQuadPoints.setFloatArray(quadPoints);    getCOSObject().setItem(COSName.QUADPOINTS, newQuadPoints);}
public float[] pdfbox_f6227_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.QUADPOINTS);    if (base instanceof COSArray) {        return ((COSArray) base).toFloatArray();    }        return null;}
public void pdfbox_f6228_0(PDAppearanceHandler appearanceHandler)
{    customAppearanceHandler = appearanceHandler;}
public void pdfbox_f6229_0()
{    this.constructAppearances(null);}
public void pdfbox_f6230_0(PDDocument document)
{    if (customAppearanceHandler == null) {        PDUnderlineAppearanceHandler appearanceHandler = new PDUnderlineAppearanceHandler(this, document);        appearanceHandler.generateAppearanceStreams();    } else {        customAppearanceHandler.generateAppearanceStreams();    }}
public String pdfbox_f6231_0()
{    return this.getCOSObject().getNameAsString(COSName.H, "I");}
public void pdfbox_f6232_0(String highlightingMode)
{    if ((highlightingMode == null) || "N".equals(highlightingMode) || "I".equals(highlightingMode) || "O".equals(highlightingMode) || "P".equals(highlightingMode) || "T".equals(highlightingMode)) {        this.getCOSObject().setName(COSName.H, highlightingMode);    } else {        throw new IllegalArgumentException("Valid values for highlighting mode are " + "'N', 'N', 'O', 'P' or 'T'");    }}
public PDAppearanceCharacteristicsDictionary pdfbox_f6233_0()
{    COSBase mk = this.getCOSObject().getDictionaryObject(COSName.MK);    if (mk instanceof COSDictionary) {        return new PDAppearanceCharacteristicsDictionary((COSDictionary) mk);    }    return null;}
public void pdfbox_f6234_0(PDAppearanceCharacteristicsDictionary appearanceCharacteristics)
{    this.getCOSObject().setItem(COSName.MK, appearanceCharacteristics);}
public PDAction pdfbox_f6235_0()
{    COSBase base = this.getCOSObject().getDictionaryObject(COSName.A);    if (base instanceof COSDictionary) {        return PDActionFactory.createAction((COSDictionary) base);    }    return null;}
public void pdfbox_f6236_0(PDAction action)
{    this.getCOSObject().setItem(COSName.A, action);}
public PDAnnotationAdditionalActions pdfbox_f6237_0()
{    COSBase base = this.getCOSObject().getDictionaryObject(COSName.AA);    if (base instanceof COSDictionary) {        return new PDAnnotationAdditionalActions((COSDictionary) base);    }    return null;}
public void pdfbox_f6238_0(PDAnnotationAdditionalActions actions)
{    this.getCOSObject().setItem(COSName.AA, actions);}
public void pdfbox_f6239_0(PDBorderStyleDictionary bs)
{    this.getCOSObject().setItem(COSName.BS, bs);}
public PDBorderStyleDictionary pdfbox_f6240_0()
{    COSBase bs = getCOSObject().getDictionaryObject(COSName.BS);    if (bs instanceof COSDictionary) {        return new PDBorderStyleDictionary((COSDictionary) bs);    }    return null;}
public void pdfbox_f6241_0(PDTerminalField field)
{    if (this.getCOSObject().equals(field.getCOSObject())) {        throw new IllegalArgumentException("setParent() is not to be called for a field that shares a dictionary with its only widget");    }    this.getCOSObject().setItem(COSName.PARENT, field);}
public COSDictionary pdfbox_f6242_0()
{    return this.dictionary;}
public int pdfbox_f6243_0()
{    return this.getCOSObject().getInt(COSName.R, 0);}
public void pdfbox_f6244_0(int rotation)
{    this.getCOSObject().setInt(COSName.R, rotation);}
public PDColor pdfbox_f6245_0()
{    return getColor(COSName.BC);}
public void pdfbox_f6246_0(PDColor c)
{    this.getCOSObject().setItem(COSName.BC, c.toCOSArray());}
public PDColor pdfbox_f6247_0()
{    return getColor(COSName.BG);}
public void pdfbox_f6248_0(PDColor c)
{    this.getCOSObject().setItem(COSName.BG, c.toCOSArray());}
public String pdfbox_f6249_0()
{    return this.getCOSObject().getString(COSName.CA);}
public void pdfbox_f6250_0(String caption)
{    this.getCOSObject().setString(COSName.CA, caption);}
public String pdfbox_f6251_0()
{    return this.getCOSObject().getString(COSName.RC);}
public void pdfbox_f6252_0(String caption)
{    this.getCOSObject().setString(COSName.RC, caption);}
public String pdfbox_f6253_0()
{    return this.getCOSObject().getString(COSName.AC);}
public void pdfbox_f6254_0(String caption)
{    this.getCOSObject().setString(COSName.AC, caption);}
public PDFormXObject pdfbox_f6255_0()
{    COSBase i = this.getCOSObject().getDictionaryObject(COSName.I);    if (i instanceof COSStream) {        return new PDFormXObject((COSStream) i);    }    return null;}
public PDFormXObject pdfbox_f6256_0()
{    COSBase i = this.getCOSObject().getDictionaryObject(COSName.RI);    if (i instanceof COSStream) {        return new PDFormXObject((COSStream) i);    }    return null;}
public PDFormXObject pdfbox_f6257_0()
{    COSBase i = this.getCOSObject().getDictionaryObject(COSName.IX);    if (i instanceof COSStream) {        return new PDFormXObject((COSStream) i);    }    return null;}
private PDColor pdfbox_f6258_0(COSName itemName)
{    COSBase c = this.getCOSObject().getItem(itemName);    if (c instanceof COSArray) {        PDColorSpace colorSpace;        switch(((COSArray) c).size()) {            case 1:                colorSpace = PDDeviceGray.INSTANCE;                break;            case 3:                colorSpace = PDDeviceRGB.INSTANCE;                break;            case 4:                colorSpace = PDDeviceCMYK.INSTANCE;                break;            default:                return null;        }        return new PDColor((COSArray) c, colorSpace);    }    return null;}
public COSDictionary pdfbox_f6259_0()
{    return dictionary;}
public PDAppearanceEntry pdfbox_f6260_0()
{    COSBase entry = dictionary.getDictionaryObject(COSName.N);    if (entry instanceof COSDictionary) {        return new PDAppearanceEntry((COSDictionary) entry);    }    return null;}
public void pdfbox_f6261_0(PDAppearanceEntry entry)
{    dictionary.setItem(COSName.N, entry);}
public void pdfbox_f6262_0(PDAppearanceStream ap)
{    dictionary.setItem(COSName.N, ap);}
public PDAppearanceEntry pdfbox_f6263_0()
{    COSBase entry = dictionary.getDictionaryObject(COSName.R);    if (entry instanceof COSDictionary) {        return new PDAppearanceEntry((COSDictionary) entry);    } else {        return getNormalAppearance();    }}
public void pdfbox_f6264_0(PDAppearanceEntry entry)
{    dictionary.setItem(COSName.R, entry);}
public void pdfbox_f6265_0(PDAppearanceStream ap)
{    dictionary.setItem(COSName.R, ap);}
public PDAppearanceEntry pdfbox_f6266_0()
{    COSBase entry = dictionary.getDictionaryObject(COSName.D);    if (entry instanceof COSDictionary) {        return new PDAppearanceEntry((COSDictionary) entry);    } else {        return getNormalAppearance();    }}
public void pdfbox_f6267_0(PDAppearanceEntry entry)
{    dictionary.setItem(COSName.D, entry);}
public void pdfbox_f6268_0(PDAppearanceStream ap)
{    dictionary.setItem(COSName.D, ap);}
public COSDictionary pdfbox_f6269_0()
{    return entry;}
public boolean pdfbox_f6270_0()
{    return !(this.entry instanceof COSStream);}
public boolean pdfbox_f6271_0()
{    return this.entry instanceof COSStream;}
public PDAppearanceStream pdfbox_f6272_0()
{    if (!isStream()) {        throw new IllegalStateException("This entry is not an appearance stream");    }    return new PDAppearanceStream((COSStream) entry);}
public Map<COSName, PDAppearanceStream> pdfbox_f6273_0()
{    if (!isSubDictionary()) {        throw new IllegalStateException("This entry is not an appearance subdictionary");    }    COSDictionary dict = entry;    Map<COSName, PDAppearanceStream> map = new HashMap<>();    for (COSName name : dict.keySet()) {        COSBase value = dict.getDictionaryObject(name);                if (value instanceof COSStream) {            map.put(name, new PDAppearanceStream((COSStream) value));        }    }    return new COSDictionaryMap<>(map, dict);}
public COSDictionary pdfbox_f6274_0()
{    return dictionary;}
public void pdfbox_f6275_0(float i)
{    getCOSObject().setFloat("I", i);}
public float pdfbox_f6276_0()
{    return getCOSObject().getFloat("I", 0);}
public void pdfbox_f6277_0(String s)
{    getCOSObject().setName("S", s);}
public String pdfbox_f6278_0()
{    return getCOSObject().getNameAsString("S", STYLE_SOLID);}
public COSDictionary pdfbox_f6279_0()
{    return dictionary;}
public void pdfbox_f6280_0(float w)
{        if (Float.compare(w, (int) w) == 0) {        getCOSObject().setInt(COSName.W, (int) w);    } else {        getCOSObject().setFloat(COSName.W, w);    }}
public float pdfbox_f6281_0()
{    if (getCOSObject().getDictionaryObject(COSName.W) instanceof COSName) {                return 0;    }    return getCOSObject().getFloat(COSName.W, 1);}
public void pdfbox_f6282_0(String s)
{    getCOSObject().setName(COSName.S, s);}
public String pdfbox_f6283_0()
{    return getCOSObject().getNameAsString(COSName.S, STYLE_SOLID);}
public void pdfbox_f6284_0(COSArray dashArray)
{    COSArray array = null;    if (dashArray != null) {        array = dashArray;    }    getCOSObject().setItem(COSName.D, array);}
public PDLineDashPattern pdfbox_f6285_0()
{    COSArray d = (COSArray) getCOSObject().getDictionaryObject(COSName.D);    if (d == null) {        d = new COSArray();        d.add(COSInteger.THREE);        getCOSObject().setItem(COSName.D, d);    }    return new PDLineDashPattern(d, 0);}
public COSDictionary pdfbox_f6286_0()
{    return this.dataDictionary;}
public String pdfbox_f6287_0()
{    return this.getCOSObject().getNameAsString(COSName.TYPE, "ExData");}
public String pdfbox_f6288_0()
{    return this.getCOSObject().getNameAsString(COSName.SUBTYPE);}
public void pdfbox_f6289_0(String subtype)
{    this.getCOSObject().setName(COSName.SUBTYPE, subtype);}
public int pdfbox_f6290_0() throws IOException
{    nextAvailable();    int i = super.read();    if (i > -1) {        ++position;    }    return i;}
public int pdfbox_f6291_0(byte[] b) throws IOException
{    return read(b, 0, b.length);}
public int pdfbox_f6292_1(byte[] b, int off, int len) throws IOException
{    if (len == 0) {        return 0;    }    int c = read();    if (c == -1) {        return -1;    }    b[off] = (byte) c;    int i = 1;    try {        for (; i < len; i++) {            c = read();            if (c == -1) {                break;            }            b[off + i] = (byte) c;        }    } catch (IOException ee) {            }    return i;}
private boolean pdfbox_f6293_0() throws IOException
{    long pos = position;    for (int i = 0; i < byteRange.length / 2; ++i) {        if (byteRange[i * 2] <= pos && byteRange[i * 2] + byteRange[i * 2 + 1] > pos) {            return true;        }    }    return false;}
private void pdfbox_f6294_0() throws IOException
{    while (!inRange()) {        ++position;        if (super.read() < 0) {            break;        }    }}
public byte[] pdfbox_f6295_0() throws IOException
{    return IOUtils.toByteArray(this);}
public COSDictionary pdfbox_f6296_0()
{    return dictionary;}
public PDPropBuildDataDict pdfbox_f6297_0()
{    PDPropBuildDataDict filter = null;    COSDictionary filterDic = dictionary.getCOSDictionary(COSName.FILTER);    if (filterDic != null) {        filter = new PDPropBuildDataDict(filterDic);    }    return filter;}
public void pdfbox_f6298_0(PDPropBuildDataDict filter)
{    dictionary.setItem(COSName.FILTER, filter);}
public PDPropBuildDataDict pdfbox_f6299_0()
{    PDPropBuildDataDict pubSec = null;    COSDictionary pubSecDic = dictionary.getCOSDictionary(COSName.PUB_SEC);    if (pubSecDic != null) {        pubSec = new PDPropBuildDataDict(pubSecDic);    }    return pubSec;}
public void pdfbox_f6300_0(PDPropBuildDataDict pubSec)
{    dictionary.setItem(COSName.PUB_SEC, pubSec);}
public PDPropBuildDataDict pdfbox_f6301_0()
{    PDPropBuildDataDict app = null;    COSDictionary appDic = dictionary.getCOSDictionary(COSName.APP);    if (appDic != null) {        app = new PDPropBuildDataDict(appDic);    }    return app;}
public void pdfbox_f6302_0(PDPropBuildDataDict app)
{    dictionary.setItem(COSName.APP, app);}
public COSDictionary pdfbox_f6303_0()
{    return dictionary;}
public String pdfbox_f6304_0()
{    return dictionary.getNameAsString(COSName.NAME);}
public void pdfbox_f6305_0(String name)
{    dictionary.setName(COSName.NAME, name);}
public String pdfbox_f6306_0()
{    return dictionary.getString(COSName.DATE);}
public void pdfbox_f6307_0(String date)
{    dictionary.setString(COSName.DATE, date);}
public void pdfbox_f6308_0(String applicationVersion)
{    dictionary.setString("REx", applicationVersion);}
public String pdfbox_f6309_0()
{    return dictionary.getString("REx");}
public long pdfbox_f6310_0()
{    return dictionary.getLong(COSName.R);}
public void pdfbox_f6311_0(long revision)
{    dictionary.setLong(COSName.R, revision);}
public long pdfbox_f6312_0()
{    return dictionary.getLong(COSName.V);}
public void pdfbox_f6313_0(long revision)
{    dictionary.setLong(COSName.V, revision);}
public boolean pdfbox_f6314_0()
{    return dictionary.getBoolean(COSName.PRE_RELEASE, false);}
public void pdfbox_f6315_0(boolean preRelease)
{    dictionary.setBoolean(COSName.PRE_RELEASE, preRelease);}
public String pdfbox_f6316_0()
{    final COSBase cosBase = dictionary.getItem(COSName.OS);    if (cosBase instanceof COSArray) {        return ((COSArray) cosBase).getName(0);    }        return dictionary.getString(COSName.OS);}
public void pdfbox_f6317_0(String os)
{    if (os == null) {        dictionary.removeItem(COSName.OS);    } else {        COSBase osArray = dictionary.getItem(COSName.OS);        if (!(osArray instanceof COSArray)) {            osArray = new COSArray();            osArray.setDirect(true);            dictionary.setItem(COSName.OS, osArray);        }        ((COSArray) osArray).add(0, COSName.getPDFName(os));    }}
public boolean pdfbox_f6318_0()
{    return dictionary.getBoolean(COSName.NON_EFONT_NO_WARN, true);}
public boolean pdfbox_f6319_0()
{    return dictionary.getBoolean(COSName.TRUSTED_MODE, false);}
public void pdfbox_f6320_0(boolean trustedMode)
{    dictionary.setBoolean(COSName.TRUSTED_MODE, trustedMode);}
public COSDictionary pdfbox_f6321_0()
{    return dictionary;}
public boolean pdfbox_f6322_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_FILTER);}
public void pdfbox_f6323_0(boolean flag)
{    getCOSObject().setFlag(COSName.FF, FLAG_FILTER, flag);}
public boolean pdfbox_f6324_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_SUBFILTER);}
public void pdfbox_f6325_0(boolean flag)
{    getCOSObject().setFlag(COSName.FF, FLAG_SUBFILTER, flag);}
public boolean pdfbox_f6326_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_DIGEST_METHOD);}
public void pdfbox_f6327_0(boolean flag)
{    getCOSObject().setFlag(COSName.FF, FLAG_DIGEST_METHOD, flag);}
public boolean pdfbox_f6328_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_V);}
public void pdfbox_f6329_0(boolean flag)
{    getCOSObject().setFlag(COSName.FF, FLAG_V, flag);}
public boolean pdfbox_f6330_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_REASON);}
public void pdfbox_f6331_0(boolean flag)
{    getCOSObject().setFlag(COSName.FF, FLAG_REASON, flag);}
public boolean pdfbox_f6332_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_LEGAL_ATTESTATION);}
public void pdfbox_f6333_0(boolean flag)
{    getCOSObject().setFlag(COSName.FF, FLAG_LEGAL_ATTESTATION, flag);}
public boolean pdfbox_f6334_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_ADD_REV_INFO);}
public void pdfbox_f6335_0(boolean flag)
{    getCOSObject().setFlag(COSName.FF, FLAG_ADD_REV_INFO, flag);}
public String pdfbox_f6336_0()
{    return dictionary.getNameAsString(COSName.FILTER);}
public void pdfbox_f6337_0(COSName filter)
{    dictionary.setItem(COSName.FILTER, filter);}
public List<String> pdfbox_f6338_0()
{    List<String> retval = null;    COSArray fields = (COSArray) dictionary.getDictionaryObject(COSName.SUB_FILTER);    if (fields != null) {        List<String> actuals = new ArrayList<>();        for (int i = 0; i < fields.size(); i++) {            String element = fields.getName(i);            if (element != null) {                actuals.add(element);            }        }        retval = new COSArrayList<>(actuals, fields);    }    return retval;}
public void pdfbox_f6339_0(List<COSName> subfilter)
{    dictionary.setItem(COSName.SUB_FILTER, COSArrayList.converterToCOSArray(subfilter));}
public List<String> pdfbox_f6340_0()
{    List<String> retval = null;    COSArray fields = (COSArray) dictionary.getDictionaryObject(COSName.DIGEST_METHOD);    if (fields != null) {        List<String> actuals = new ArrayList<>();        for (int i = 0; i < fields.size(); i++) {            String element = fields.getName(i);            if (element != null) {                actuals.add(element);            }        }        retval = new COSArrayList<>(actuals, fields);    }    return retval;}
public void pdfbox_f6341_0(List<COSName> digestMethod)
{        for (COSName cosName : digestMethod) {        if (!(cosName.equals(COSName.DIGEST_SHA1) || cosName.equals(COSName.DIGEST_SHA256) || cosName.equals(COSName.DIGEST_SHA384) || cosName.equals(COSName.DIGEST_SHA512) || cosName.equals(COSName.DIGEST_RIPEMD160))) {            throw new IllegalArgumentException("Specified digest " + cosName.getName() + " isn't allowed.");        }    }    dictionary.setItem(COSName.DIGEST_METHOD, COSArrayList.converterToCOSArray(digestMethod));}
public float pdfbox_f6342_0()
{    return dictionary.getFloat(COSName.V);}
public void pdfbox_f6343_0(float minimumRequiredCapability)
{    dictionary.setFloat(COSName.V, minimumRequiredCapability);}
public List<String> pdfbox_f6344_0()
{    List<String> retval = null;    COSArray fields = (COSArray) dictionary.getDictionaryObject(COSName.REASONS);    if (fields != null) {        List<String> actuals = new ArrayList<>();        for (int i = 0; i < fields.size(); i++) {            String element = fields.getString(i);            if (element != null) {                actuals.add(element);            }        }        retval = new COSArrayList<>(actuals, fields);    }    return retval;}
public void pdfbox_f6345_0(List<String> reasons)
{    dictionary.setItem(COSName.REASONS, COSArrayList.converterToCOSArray(reasons));}
public PDSeedValueMDP pdfbox_f6346_0()
{    COSDictionary dict = dictionary.getCOSDictionary(COSName.MDP);    PDSeedValueMDP mdp = null;    if (dict != null) {        mdp = new PDSeedValueMDP(dict);    }    return mdp;}
public void pdfbox_f6347_0(PDSeedValueMDP mdp)
{    if (mdp != null) {        dictionary.setItem(COSName.MDP, mdp.getCOSObject());    }}
public PDSeedValueCertificate pdfbox_f6348_0()
{    COSBase base = dictionary.getDictionaryObject(COSName.CERT);    PDSeedValueCertificate certificate = null;    if (base instanceof COSDictionary) {        COSDictionary dict = (COSDictionary) base;        certificate = new PDSeedValueCertificate(dict);    }    return certificate;}
public void pdfbox_f6349_0(PDSeedValueCertificate certificate)
{    dictionary.setItem(COSName.CERT, certificate);}
public PDSeedValueTimeStamp pdfbox_f6350_0()
{    COSDictionary dict = dictionary.getCOSDictionary(COSName.TIME_STAMP);    PDSeedValueTimeStamp timestamp = null;    if (dict != null) {        timestamp = new PDSeedValueTimeStamp(dict);    }    return timestamp;}
public void pdfbox_f6351_0(PDSeedValueTimeStamp timestamp)
{    if (timestamp != null) {        dictionary.setItem(COSName.TIME_STAMP, timestamp.getCOSObject());    }}
public List<String> pdfbox_f6352_0()
{    List<String> retval = null;    COSArray fields = (COSArray) dictionary.getDictionaryObject(COSName.LEGAL_ATTESTATION);    if (fields != null) {        List<String> actuals = new ArrayList<>();        for (int i = 0; i < fields.size(); i++) {            String element = fields.getString(i);            if (element != null) {                actuals.add(element);            }        }        retval = new COSArrayList<>(actuals, fields);    }    return retval;}
public void pdfbox_f6353_0(List<String> legalAttestation)
{    dictionary.setItem(COSName.LEGAL_ATTESTATION, COSArrayList.converterToCOSArray(legalAttestation));}
public COSDictionary pdfbox_f6354_0()
{    return dictionary;}
public boolean pdfbox_f6355_0()
{    return this.getCOSObject().getFlag(COSName.FF, FLAG_SUBJECT);}
public void pdfbox_f6356_0(boolean flag)
{    this.getCOSObject().setFlag(COSName.FF, FLAG_SUBJECT, flag);}
public boolean pdfbox_f6357_0()
{    return this.getCOSObject().getFlag(COSName.FF, FLAG_ISSUER);}
public void pdfbox_f6358_0(boolean flag)
{    this.getCOSObject().setFlag(COSName.FF, FLAG_ISSUER, flag);}
public boolean pdfbox_f6359_0()
{    return this.getCOSObject().getFlag(COSName.FF, FLAG_OID);}
public void pdfbox_f6360_0(boolean flag)
{    this.getCOSObject().setFlag(COSName.FF, FLAG_OID, flag);}
public boolean pdfbox_f6361_0()
{    return this.getCOSObject().getFlag(COSName.FF, FLAG_SUBJECT_DN);}
public void pdfbox_f6362_0(boolean flag)
{    this.getCOSObject().setFlag(COSName.FF, FLAG_SUBJECT_DN, flag);}
public boolean pdfbox_f6363_0()
{    return this.getCOSObject().getFlag(COSName.FF, FLAG_KEY_USAGE);}
public void pdfbox_f6364_0(boolean flag)
{    this.getCOSObject().setFlag(COSName.FF, FLAG_KEY_USAGE, flag);}
public boolean pdfbox_f6365_0()
{    return this.getCOSObject().getFlag(COSName.FF, FLAG_URL);}
public void pdfbox_f6366_0(boolean flag)
{    this.getCOSObject().setFlag(COSName.FF, FLAG_URL, flag);}
public List<byte[]> pdfbox_f6367_0()
{    COSBase base = this.dictionary.getDictionaryObject(COSName.SUBJECT);    if (base instanceof COSArray) {        COSArray array = (COSArray) base;        return getListOfByteArraysFromCOSArray(array);    }    return null;}
public void pdfbox_f6368_0(List<byte[]> subjects)
{    COSArray array = new COSArray();    for (byte[] subject : subjects) {        array.add(new COSString(subject));    }    this.dictionary.setItem(COSName.SUBJECT, array);}
public void pdfbox_f6369_0(byte[] subject)
{    COSBase base = this.dictionary.getDictionaryObject(COSName.SUBJECT);    COSArray array;    if (base instanceof COSArray) {        array = (COSArray) base;    } else {        array = new COSArray();    }    COSString string = new COSString(subject);    array.add(string);    this.dictionary.setItem(COSName.SUBJECT, array);}
public void pdfbox_f6370_0(byte[] subject)
{    COSBase base = this.dictionary.getDictionaryObject(COSName.SUBJECT);    if (base instanceof COSArray) {        COSArray array = (COSArray) base;        array.remove(new COSString(subject));    }}
public List<Map<String, String>> pdfbox_f6371_0()
{    COSBase base = this.dictionary.getDictionaryObject(COSName.SUBJECT_DN);    if (base instanceof COSArray) {        COSArray cosArray = (COSArray) base;        List subjectDNList = cosArray.toList();        List<Map<String, String>> result = new LinkedList<>();        for (Object subjectDNItem : subjectDNList) {            if (subjectDNItem instanceof COSDictionary) {                COSDictionary subjectDNItemDict = (COSDictionary) subjectDNItem;                Map<String, String> subjectDNMap = new HashMap<>();                for (COSName key : subjectDNItemDict.keySet()) {                    subjectDNMap.put(key.getName(), subjectDNItemDict.getString(key));                }                result.add(subjectDNMap);            }        }        return result;    }    return null;}
public void pdfbox_f6372_0(List<Map<String, String>> subjectDN)
{    List<COSDictionary> subjectDNDict = new LinkedList<>();    for (Map<String, String> subjectDNItem : subjectDN) {        COSDictionary dict = new COSDictionary();        for (Map.Entry<String, String> entry : subjectDNItem.entrySet()) {            dict.setItem(entry.getKey(), new COSString(entry.getValue()));        }        subjectDNDict.add(dict);    }    this.dictionary.setItem(COSName.SUBJECT_DN, COSArrayList.converterToCOSArray(subjectDNDict));}
public List<String> pdfbox_f6373_0()
{    COSBase base = this.dictionary.getDictionaryObject(COSName.KEY_USAGE);    if (base instanceof COSArray) {        COSArray array = (COSArray) base;        List<String> keyUsageExtensions = new LinkedList<>();        for (COSBase item : array) {            if (item instanceof COSString) {                keyUsageExtensions.add(((COSString) item).getString());            }        }        return keyUsageExtensions;    }    return null;}
public void pdfbox_f6374_0(List<String> keyUsageExtensions)
{    this.dictionary.setItem(COSName.KEY_USAGE, COSArrayList.converterToCOSArray(keyUsageExtensions));}
public void pdfbox_f6375_0(String keyUsageExtension)
{    String allowedChars = "01X";    for (int c = 0; c < keyUsageExtension.length(); c++) {        if (allowedChars.indexOf(keyUsageExtension.charAt(c)) == -1) {            throw new IllegalArgumentException("characters can only be 0, 1, X");        }    }    COSBase base = this.dictionary.getDictionaryObject(COSName.KEY_USAGE);    COSArray array;    if (base instanceof COSArray) {        array = (COSArray) base;    } else {        array = new COSArray();    }    COSString string = new COSString(keyUsageExtension);    array.add(string);    this.dictionary.setItem(COSName.KEY_USAGE, array);}
public void pdfbox_f6376_0(char digitalSignature, char nonRepudiation, char keyEncipherment, char dataEncipherment, char keyAgreement, char keyCertSign, char cRLSign, char encipherOnly, char decipherOnly)
{    StringBuilder builder = new StringBuilder();    builder.append(digitalSignature);    builder.append(nonRepudiation);    builder.append(keyEncipherment);    builder.append(dataEncipherment);    builder.append(keyAgreement);    builder.append(keyCertSign);    builder.append(cRLSign);    builder.append(encipherOnly);    builder.append(decipherOnly);    addKeyUsage(builder.toString());}
public void pdfbox_f6377_0(String keyUsageExtension)
{    COSBase base = this.dictionary.getDictionaryObject(COSName.KEY_USAGE);    if (base instanceof COSArray) {        COSArray array = (COSArray) base;        array.remove(new COSString(keyUsageExtension));    }}
public List<byte[]> pdfbox_f6378_0()
{    COSBase base = this.dictionary.getDictionaryObject(COSName.ISSUER);    if (base instanceof COSArray) {        COSArray array = (COSArray) base;        return getListOfByteArraysFromCOSArray(array);    }    return null;}
public void pdfbox_f6379_0(List<byte[]> issuers)
{    COSArray array = new COSArray();    for (byte[] issuer : issuers) {        array.add(new COSString(issuer));    }    this.dictionary.setItem(COSName.ISSUER, array);}
public void pdfbox_f6380_0(byte[] issuer)
{    COSBase base = this.dictionary.getDictionaryObject(COSName.ISSUER);    COSArray array;    if (base instanceof COSArray) {        array = (COSArray) base;    } else {        array = new COSArray();    }    COSString string = new COSString(issuer);    array.add(string);    this.dictionary.setItem(COSName.ISSUER, array);}
public void pdfbox_f6381_0(byte[] issuer)
{    COSBase base = this.dictionary.getDictionaryObject(COSName.ISSUER);    if (base instanceof COSArray) {        COSArray array = (COSArray) base;        array.remove(new COSString(issuer));    }}
public List<byte[]> pdfbox_f6382_0()
{    COSBase base = this.dictionary.getDictionaryObject(COSName.OID);    if (base instanceof COSArray) {        COSArray array = (COSArray) base;        return getListOfByteArraysFromCOSArray(array);    }    return null;}
public void pdfbox_f6383_0(List<byte[]> oidByteStrings)
{    COSArray array = new COSArray();    for (byte[] oid : oidByteStrings) {        array.add(new COSString(oid));    }    this.dictionary.setItem(COSName.OID, array);}
public void pdfbox_f6384_0(byte[] oid)
{    COSBase base = this.dictionary.getDictionaryObject(COSName.OID);    COSArray array;    if (base instanceof COSArray) {        array = (COSArray) base;    } else {        array = new COSArray();    }    COSString string = new COSString(oid);    array.add(string);    this.dictionary.setItem(COSName.OID, array);}
public void pdfbox_f6385_0(byte[] oid)
{    COSBase base = this.dictionary.getDictionaryObject(COSName.OID);    if (base instanceof COSArray) {        COSArray array = (COSArray) base;        array.remove(new COSString(oid));    }}
public String pdfbox_f6386_0()
{    return this.dictionary.getString(COSName.URL);}
public void pdfbox_f6387_0(String url)
{    this.dictionary.setString(COSName.URL, url);}
public String pdfbox_f6388_0()
{    return this.dictionary.getNameAsString(COSName.URL_TYPE);}
public void pdfbox_f6389_0(String urlType)
{    this.dictionary.setName(COSName.URL_TYPE, urlType);}
private static List<byte[]> pdfbox_f6390_0(COSArray array)
{    List<byte[]> result = new LinkedList<>();    for (COSBase item : array) {        if (item instanceof COSString) {            result.add(((COSString) item).getBytes());        }    }    return result;}
public COSDictionary pdfbox_f6391_0()
{    return dictionary;}
public int pdfbox_f6392_0()
{    return dictionary.getInt(COSName.P);}
public void pdfbox_f6393_0(int p)
{    if (p < 0 || p > 3) {        throw new IllegalArgumentException("Only values between 0 and 3 nare allowed.");    }    dictionary.setInt(COSName.P, p);}
public COSDictionary pdfbox_f6394_0()
{    return dictionary;}
public String pdfbox_f6395_0()
{    return dictionary.getString(COSName.URL);}
public void pdfbox_f6396_0(String url)
{    dictionary.setString(COSName.URL, url);}
public boolean pdfbox_f6397_0()
{    return dictionary.getInt(COSName.FT, 0) != 0;}
public void pdfbox_f6398_0(boolean flag)
{    dictionary.setInt(COSName.FT, flag ? 1 : 0);}
public COSDictionary pdfbox_f6399_0()
{    return dictionary;}
public void pdfbox_f6400_0(COSName type)
{    dictionary.setItem(COSName.TYPE, type);}
public void pdfbox_f6401_0(COSName filter)
{    dictionary.setItem(COSName.FILTER, filter);}
public void pdfbox_f6402_0(COSName subfilter)
{    dictionary.setItem(COSName.SUB_FILTER, subfilter);}
public void pdfbox_f6403_0(String name)
{    dictionary.setString(COSName.NAME, name);}
public void pdfbox_f6404_0(String location)
{    dictionary.setString(COSName.LOCATION, location);}
public void pdfbox_f6405_0(String reason)
{    dictionary.setString(COSName.REASON, reason);}
public void pdfbox_f6406_0(String contactInfo)
{    dictionary.setString(COSName.CONTACT_INFO, contactInfo);}
public void pdfbox_f6407_0(Calendar cal)
{    dictionary.setDate(COSName.M, cal);}
public String pdfbox_f6408_0()
{    return dictionary.getNameAsString(COSName.FILTER);}
public String pdfbox_f6409_0()
{    return dictionary.getNameAsString(COSName.SUB_FILTER);}
public String pdfbox_f6410_0()
{    return dictionary.getString(COSName.NAME);}
public String pdfbox_f6411_0()
{    return dictionary.getString(COSName.LOCATION);}
public String pdfbox_f6412_0()
{    return dictionary.getString(COSName.REASON);}
public String pdfbox_f6413_0()
{    return dictionary.getString(COSName.CONTACT_INFO);}
public Calendar pdfbox_f6414_0()
{    return dictionary.getDate(COSName.M);}
public void pdfbox_f6415_0(int[] range)
{    if (range.length != 4) {        return;    }    COSArray ary = new COSArray();    for (int i : range) {        ary.add(COSInteger.get(i));    }    dictionary.setItem(COSName.BYTERANGE, ary);    ary.setDirect(true);}
public int[] pdfbox_f6416_0()
{    COSArray byteRange = (COSArray) dictionary.getDictionaryObject(COSName.BYTERANGE);    int[] ary = new int[byteRange.size()];    for (int i = 0; i < ary.length; ++i) {        ary[i] = byteRange.getInt(i);    }    return ary;}
public byte[] pdfbox_f6417_0(InputStream pdfFile) throws IOException
{    int[] byteRange = getByteRange();    int begin = byteRange[0] + byteRange[1] + 1;    int len = byteRange[2] - begin;    return getConvertedContents(new COSFilterInputStream(pdfFile, new int[] { begin, len }));}
public byte[] pdfbox_f6418_0(byte[] pdfFile) throws IOException
{    int[] byteRange = getByteRange();    int begin = byteRange[0] + byteRange[1] + 1;    int len = byteRange[2] - begin;    return getConvertedContents(new COSFilterInputStream(pdfFile, new int[] { begin, len }));}
private byte[] pdfbox_f6419_0(InputStream is) throws IOException
{    ByteArrayOutputStream byteOS = new ByteArrayOutputStream(1024);    byte[] buffer = new byte[1024];    int c;    while ((c = is.read(buffer)) != -1) {                if (buffer[0] == 0x3C || buffer[0] == 0x28) {            byteOS.write(buffer, 1, c);        } else         if (buffer[c - 1] == 0x3E || buffer[c - 1] == 0x29) {            byteOS.write(buffer, 0, c - 1);        } else {            byteOS.write(buffer, 0, c);        }    }    is.close();    return COSString.parseHex(byteOS.toString("ISO-8859-1")).getBytes();}
public void pdfbox_f6420_0(byte[] bytes)
{    COSString string = new COSString(bytes);    string.setForceHexForm(true);    dictionary.setItem(COSName.CONTENTS, string);}
public byte[] pdfbox_f6421_0(InputStream pdfFile) throws IOException
{    try (COSFilterInputStream fis = new COSFilterInputStream(pdfFile, getByteRange())) {        return fis.toByteArray();    }}
public byte[] pdfbox_f6422_0(byte[] pdfFile) throws IOException
{    try (COSFilterInputStream fis = new COSFilterInputStream(pdfFile, getByteRange())) {        return fis.toByteArray();    }}
public PDPropBuild pdfbox_f6423_0()
{    PDPropBuild propBuild = null;    COSDictionary propBuildDic = dictionary.getCOSDictionary(COSName.PROP_BUILD);    if (propBuildDic != null) {        propBuild = new PDPropBuild(propBuildDic);    }    return propBuild;}
public void pdfbox_f6424_0(PDPropBuild propBuild)
{    dictionary.setItem(COSName.PROP_BUILD, propBuild);}
public void pdfbox_f6425_0(int pageNo)
{    this.pageNo = pageNo;}
public int pdfbox_f6426_0()
{    return pageNo;}
public void pdfbox_f6427_0(File file) throws IOException
{    initFromRandomAccessRead(new RandomAccessBufferedFileInputStream(file));}
public void pdfbox_f6428_0(InputStream is) throws IOException
{    initFromRandomAccessRead(new RandomAccessBuffer(is));}
private void pdfbox_f6429_0(RandomAccessRead rar) throws IOException
{    pdfSource = rar;    PDFParser parser = new PDFParser(pdfSource);    parser.parse();    visualSignature = parser.getDocument();}
public void pdfbox_f6430_0(PDVisibleSigProperties visSignatureProperties) throws IOException
{    setVisualSignature(visSignatureProperties.getVisibleSignature());}
public COSDocument pdfbox_f6431_0()
{    return visualSignature;}
public int pdfbox_f6432_0()
{    return preferredSignatureSize;}
public void pdfbox_f6433_0(int size)
{    if (size > 0) {        preferredSignatureSize = size;    }}
public void pdfbox_f6434_0() throws IOException
{    if (visualSignature != null) {        visualSignature.close();    }    if (pdfSource != null) {        pdfSource.close();    }}
public InputStream pdfbox_f6435_0() throws IOException
{    return cosWriter.getDataToSign();}
public void pdfbox_f6436_0(byte[] signature) throws IOException
{    cosWriter.writeExternalSignature(signature);}
public void pdfbox_f6437_0() throws IOException
{    if (cosWriter != null) {        try {            cosWriter.close();        } finally {            cosWriter = null;        }    }}
public PDFTemplateStructure pdfbox_f6438_0()
{    return pdfBuilder.getStructure();}
public InputStream pdfbox_f6439_1(PDVisibleSignDesigner properties) throws IOException
{        PDFTemplateStructure pdfStructure = pdfBuilder.getStructure();        pdfBuilder.createProcSetArray();        pdfBuilder.createPage(properties);    PDPage page = pdfStructure.getPage();        pdfBuilder.createTemplate(page);    try (PDDocument template = pdfStructure.getTemplate()) {                pdfBuilder.createAcroForm(template);        PDAcroForm acroForm = pdfStructure.getAcroForm();                pdfBuilder.createSignatureField(acroForm);        PDSignatureField pdSignatureField = pdfStructure.getSignatureField();                                                pdfBuilder.createSignature(pdSignatureField, page, "");                pdfBuilder.createAcroFormDictionary(acroForm, pdSignatureField);                pdfBuilder.createAffineTransform(properties.getTransform());        AffineTransform transform = pdfStructure.getAffineTransform();                pdfBuilder.createSignatureRectangle(pdSignatureField, properties);        pdfBuilder.createFormatterRectangle(properties.getFormatterRectangleParameters());        PDRectangle bbox = pdfStructure.getFormatterRectangle();        pdfBuilder.createSignatureImage(template, properties.getImage());                pdfBuilder.createHolderFormStream(template);        PDStream holderFormStream = pdfStructure.getHolderFormStream();        pdfBuilder.createHolderFormResources();        PDResources holderFormResources = pdfStructure.getHolderFormResources();        pdfBuilder.createHolderForm(holderFormResources, holderFormStream, bbox);                pdfBuilder.createAppearanceDictionary(pdfStructure.getHolderForm(), pdSignatureField);                pdfBuilder.createInnerFormStream(template);        pdfBuilder.createInnerFormResource();        PDResources innerFormResource = pdfStructure.getInnerFormResources();        pdfBuilder.createInnerForm(innerFormResource, pdfStructure.getInnerFormStream(), bbox);        PDFormXObject innerForm = pdfStructure.getInnerForm();                pdfBuilder.insertInnerFormToHolderResources(innerForm, holderFormResources);                pdfBuilder.createImageFormStream(template);        PDStream imageFormStream = pdfStructure.getImageFormStream();        pdfBuilder.createImageFormResources();        PDResources imageFormResources = pdfStructure.getImageFormResources();        pdfBuilder.createImageForm(imageFormResources, innerFormResource, imageFormStream, bbox, transform, pdfStructure.getImage());        pdfBuilder.createBackgroundLayerForm(innerFormResource, bbox);                pdfBuilder.injectProcSetArray(innerForm, page, innerFormResource, imageFormResources, holderFormResources, pdfStructure.getProcSet());        COSName imageFormName = pdfStructure.getImageFormName();        COSName imageName = pdfStructure.getImageName();        COSName innerFormName = pdfStructure.getInnerFormName();                pdfBuilder.injectAppearanceStreams(holderFormStream, imageFormStream, imageFormStream, imageFormName, imageName, innerFormName, properties);        pdfBuilder.createVisualSignature(template);        pdfBuilder.createWidgetDictionary(pdSignatureField, holderFormResources);        InputStream in = getVisualSignatureAsStream(pdfStructure.getVisualSignature());                        return in;    }}
private InputStream pdfbox_f6440_0(COSDocument visualSignature) throws IOException
{    ByteArrayOutputStream baos = new ByteArrayOutputStream();    try (COSWriter writer = new COSWriter(baos)) {        writer.write(visualSignature);    }    return new ByteArrayInputStream(baos.toByteArray());}
public PDPage pdfbox_f6441_0()
{    return page;}
public void pdfbox_f6442_0(PDPage page)
{    this.page = page;}
public PDDocument pdfbox_f6443_0()
{    return template;}
public void pdfbox_f6444_0(PDDocument template)
{    this.template = template;}
public PDAcroForm pdfbox_f6445_0()
{    return acroForm;}
public void pdfbox_f6446_0(PDAcroForm acroForm)
{    this.acroForm = acroForm;}
public PDSignatureField pdfbox_f6447_0()
{    return signatureField;}
public void pdfbox_f6448_0(PDSignatureField signatureField)
{    this.signatureField = signatureField;}
public PDSignature pdfbox_f6449_0()
{    return pdSignature;}
public void pdfbox_f6450_0(PDSignature pdSignature)
{    this.pdSignature = pdSignature;}
public COSDictionary pdfbox_f6451_0()
{    return acroFormDictionary;}
public void pdfbox_f6452_0(COSDictionary acroFormDictionary)
{    this.acroFormDictionary = acroFormDictionary;}
public PDRectangle pdfbox_f6453_0()
{    return signatureRectangle;}
public void pdfbox_f6454_0(PDRectangle signatureRectangle)
{    this.signatureRectangle = signatureRectangle;}
public AffineTransform pdfbox_f6455_0()
{    return affineTransform;}
public void pdfbox_f6456_0(AffineTransform affineTransform)
{    this.affineTransform = affineTransform;}
public COSArray pdfbox_f6457_0()
{    return procSet;}
public void pdfbox_f6458_0(COSArray procSet)
{    this.procSet = procSet;}
public PDImageXObject pdfbox_f6459_0()
{    return image;}
public void pdfbox_f6460_0(PDImageXObject image)
{    this.image = image;}
public PDRectangle pdfbox_f6461_0()
{    return formatterRectangle;}
public void pdfbox_f6462_0(PDRectangle formatterRectangle)
{    this.formatterRectangle = formatterRectangle;}
public PDStream pdfbox_f6463_0()
{    return holderFormStream;}
public void pdfbox_f6464_0(PDStream holderFormStream)
{    this.holderFormStream = holderFormStream;}
public PDFormXObject pdfbox_f6465_0()
{    return holderForm;}
public void pdfbox_f6466_0(PDFormXObject holderForm)
{    this.holderForm = holderForm;}
public PDResources pdfbox_f6467_0()
{    return holderFormResources;}
public void pdfbox_f6468_0(PDResources holderFormResources)
{    this.holderFormResources = holderFormResources;}
public PDAppearanceDictionary pdfbox_f6469_0()
{    return appearanceDictionary;}
public void pdfbox_f6470_0(PDAppearanceDictionary appearanceDictionary)
{    this.appearanceDictionary = appearanceDictionary;}
public PDStream pdfbox_f6471_0()
{    return innerFormStream;}
public void pdfbox_f6472_0(PDStream innerFormStream)
{    this.innerFormStream = innerFormStream;}
public PDResources pdfbox_f6473_0()
{    return innerFormResources;}
public void pdfbox_f6474_0(PDResources innerFormResources)
{    this.innerFormResources = innerFormResources;}
public PDFormXObject pdfbox_f6475_0()
{    return innerForm;}
public void pdfbox_f6476_0(PDFormXObject innerForm)
{    this.innerForm = innerForm;}
public COSName pdfbox_f6477_0()
{    return innerFormName;}
public void pdfbox_f6478_0(COSName innerFormName)
{    this.innerFormName = innerFormName;}
public PDStream pdfbox_f6479_0()
{    return imageFormStream;}
public void pdfbox_f6480_0(PDStream imageFormStream)
{    this.imageFormStream = imageFormStream;}
public PDResources pdfbox_f6481_0()
{    return imageFormResources;}
public void pdfbox_f6482_0(PDResources imageFormResources)
{    this.imageFormResources = imageFormResources;}
public PDFormXObject pdfbox_f6483_0()
{    return imageForm;}
public void pdfbox_f6484_0(PDFormXObject imageForm)
{    this.imageForm = imageForm;}
public COSName pdfbox_f6485_0()
{    return imageFormName;}
public void pdfbox_f6486_0(COSName imageFormName)
{    this.imageFormName = imageFormName;}
public COSName pdfbox_f6487_0()
{    return imageName;}
public void pdfbox_f6488_0(COSName imageName)
{    this.imageName = imageName;}
public COSDocument pdfbox_f6489_0()
{    return visualSignature;}
public void pdfbox_f6490_0(COSDocument visualSignature)
{    this.visualSignature = visualSignature;}
public List<PDField> pdfbox_f6491_0()
{    return acroFormFields;}
public void pdfbox_f6492_0(List<PDField> acroFormFields)
{    this.acroFormFields = acroFormFields;}
public COSDictionary pdfbox_f6493_0()
{    return widgetDictionary;}
public void pdfbox_f6494_0(COSDictionary widgetDictionary)
{    this.widgetDictionary = widgetDictionary;}
public void pdfbox_f6495_1(PDVisibleSignDesigner properties)
{    PDPage page = new PDPage(new PDRectangle(properties.getPageWidth(), properties.getPageHeight()));    pdfStructure.setPage(page);    }
public void pdfbox_f6496_0(PDPage page) throws IOException
{    PDDocument template = new PDDocument();    template.addPage(page);    pdfStructure.setTemplate(template);}
public void pdfbox_f6497_1(PDDocument template)
{    PDAcroForm theAcroForm = new PDAcroForm(template);    template.getDocumentCatalog().setAcroForm(theAcroForm);    pdfStructure.setAcroForm(theAcroForm);    }
public PDFTemplateStructure pdfbox_f6498_0()
{    return pdfStructure;}
public void pdfbox_f6499_1(PDAcroForm acroForm) throws IOException
{    PDSignatureField sf = new PDSignatureField(acroForm);    pdfStructure.setSignatureField(sf);    }
public void pdfbox_f6500_1(PDSignatureField pdSignatureField, PDPage page, String signerName) throws IOException
{    PDSignature pdSignature = new PDSignature();    PDAnnotationWidget widget = pdSignatureField.getWidgets().get(0);    pdSignatureField.setValue(pdSignature);    widget.setPage(page);    page.getAnnotations().add(widget);    if (!signerName.isEmpty()) {        pdSignature.setName(signerName);    }    pdfStructure.setPdSignature(pdSignature);    }
public void pdfbox_f6501_1(PDAcroForm acroForm, PDSignatureField signatureField) throws IOException
{    @SuppressWarnings("unchecked")    List<PDField> acroFormFields = acroForm.getFields();    COSDictionary acroFormDict = acroForm.getCOSObject();    acroForm.setSignaturesExist(true);    acroForm.setAppendOnly(true);    acroFormDict.setDirect(true);    acroFormFields.add(signatureField);        acroForm.setDefaultAppearance("/sylfaen 0 Tf 0 g");    pdfStructure.setAcroFormFields(acroFormFields);    pdfStructure.setAcroFormDictionary(acroFormDict);    }
public void pdfbox_f6502_1(PDSignatureField signatureField, PDVisibleSignDesigner properties) throws IOException
{    PDRectangle rect = new PDRectangle();    rect.setUpperRightX(properties.getxAxis() + properties.getWidth());    rect.setUpperRightY(properties.getTemplateHeight() - properties.getyAxis());    rect.setLowerLeftY(properties.getTemplateHeight() - properties.getyAxis() - properties.getHeight());    rect.setLowerLeftX(properties.getxAxis());    signatureField.getWidgets().get(0).setRectangle(rect);    pdfStructure.setSignatureRectangle(rect);    }
public void pdfbox_f6503_1(AffineTransform affineTransform)
{    pdfStructure.setAffineTransform(affineTransform);    }
public void pdfbox_f6504_1()
{    COSArray procSetArr = new COSArray();    procSetArr.add(COSName.getPDFName("PDF"));    procSetArr.add(COSName.getPDFName("Text"));    procSetArr.add(COSName.getPDFName("ImageB"));    procSetArr.add(COSName.getPDFName("ImageC"));    procSetArr.add(COSName.getPDFName("ImageI"));    pdfStructure.setProcSet(procSetArr);    }
public void pdfbox_f6505_1(PDDocument template, BufferedImage image) throws IOException
{    pdfStructure.setImage(LosslessFactory.createFromImage(template, image));    }
public void pdfbox_f6506_1(int[] params)
{    PDRectangle formatterRectangle = new PDRectangle();    formatterRectangle.setLowerLeftX(Math.min(params[0], params[2]));    formatterRectangle.setLowerLeftY(Math.min(params[1], params[3]));    formatterRectangle.setUpperRightX(Math.max(params[0], params[2]));    formatterRectangle.setUpperRightY(Math.max(params[1], params[3]));    pdfStructure.setFormatterRectangle(formatterRectangle);    }
public void pdfbox_f6507_1(PDDocument template)
{    PDStream holderForm = new PDStream(template);    pdfStructure.setHolderFormStream(holderForm);    }
public void pdfbox_f6508_1()
{    PDResources holderFormResources = new PDResources();    pdfStructure.setHolderFormResources(holderFormResources);    }
public void pdfbox_f6509_1(PDResources holderFormResources, PDStream holderFormStream, PDRectangle bbox)
{    PDFormXObject holderForm = new PDFormXObject(holderFormStream);    holderForm.setResources(holderFormResources);    holderForm.setBBox(bbox);    holderForm.setFormType(1);    pdfStructure.setHolderForm(holderForm);    }
public void pdfbox_f6510_1(PDFormXObject holderForml, PDSignatureField signatureField) throws IOException
{    PDAppearanceDictionary appearance = new PDAppearanceDictionary();    appearance.getCOSObject().setDirect(true);    PDAppearanceStream appearanceStream = new PDAppearanceStream(holderForml.getCOSObject());    appearance.setNormalAppearance(appearanceStream);    signatureField.getWidgets().get(0).setAppearance(appearance);    pdfStructure.setAppearanceDictionary(appearance);    }
public void pdfbox_f6511_1(PDDocument template)
{    PDStream innerFormStream = new PDStream(template);    pdfStructure.setInnterFormStream(innerFormStream);    }
public void pdfbox_f6512_1()
{    PDResources innerFormResources = new PDResources();    pdfStructure.setInnerFormResources(innerFormResources);    }
public void pdfbox_f6513_1(PDResources innerFormResources, PDStream innerFormStream, PDRectangle bbox)
{    PDFormXObject innerForm = new PDFormXObject(innerFormStream);    innerForm.setResources(innerFormResources);    innerForm.setBBox(bbox);    innerForm.setFormType(1);    pdfStructure.setInnerForm(innerForm);    }
public void pdfbox_f6514_1(PDFormXObject innerForm, PDResources holderFormResources)
{    holderFormResources.put(COSName.FRM, innerForm);    pdfStructure.setInnerFormName(COSName.FRM);    }
public void pdfbox_f6515_1(PDDocument template)
{    PDStream imageFormStream = new PDStream(template);    pdfStructure.setImageFormStream(imageFormStream);    }
public void pdfbox_f6516_1()
{    PDResources imageFormResources = new PDResources();    pdfStructure.setImageFormResources(imageFormResources);    }
public void pdfbox_f6517_1(PDResources imageFormResources, PDResources innerFormResource, PDStream imageFormStream, PDRectangle bbox, AffineTransform at, PDImageXObject img) throws IOException
{    PDFormXObject imageForm = new PDFormXObject(imageFormStream);    imageForm.setBBox(bbox);    imageForm.setMatrix(at);    imageForm.setResources(imageFormResources);    imageForm.setFormType(1);    imageFormResources.getCOSObject().setDirect(true);    COSName imageFormName = COSName.getPDFName("n2");    innerFormResource.put(imageFormName, imageForm);    COSName imageName = imageFormResources.add(img, "img");    pdfStructure.setImageForm(imageForm);    pdfStructure.setImageFormName(imageFormName);    pdfStructure.setImageName(imageName);    }
public void pdfbox_f6518_1(PDResources innerFormResource, PDRectangle bbox) throws IOException
{        PDFormXObject n0Form = new PDFormXObject(pdfStructure.getTemplate().getDocument().createCOSStream());    n0Form.setBBox(bbox);    n0Form.setResources(new PDResources());    n0Form.setFormType(1);    innerFormResource.put(COSName.getPDFName("n0"), n0Form);    }
public void pdfbox_f6519_1(PDFormXObject innerForm, PDPage page, PDResources innerFormResources, PDResources imageFormResources, PDResources holderFormResources, COSArray procSet)
{    innerForm.getResources().getCOSObject().setItem(COSName.PROC_SET, procSet);    page.getCOSObject().setItem(COSName.PROC_SET, procSet);    innerFormResources.getCOSObject().setItem(COSName.PROC_SET, procSet);    imageFormResources.getCOSObject().setItem(COSName.PROC_SET, procSet);    holderFormResources.getCOSObject().setItem(COSName.PROC_SET, procSet);    }
public void pdfbox_f6520_1(PDStream holderFormStream, PDStream innerFormStream, PDStream imageFormStream, COSName imageFormName, COSName imageName, COSName innerFormName, PDVisibleSignDesigner properties) throws IOException
{        int width = (int) this.getStructure().getFormatterRectangle().getWidth();    int height = (int) this.getStructure().getFormatterRectangle().getHeight();    String imgFormContent = "q " + width + " 0 0 " + height + " 0 0 cm /" + imageName.getName() + " Do Q\n";    String holderFormContent = "q 1 0 0 1 0 0 cm /" + innerFormName.getName() + " Do Q\n";    String innerFormContent = "q 1 0 0 1 0 0 cm /n0 Do Q q 1 0 0 1 0 0 cm /" + imageFormName.getName() + " Do Q\n";    appendRawCommands(pdfStructure.getHolderFormStream().createOutputStream(), holderFormContent);    appendRawCommands(pdfStructure.getInnerFormStream().createOutputStream(), innerFormContent);    appendRawCommands(pdfStructure.getImageFormStream().createOutputStream(), imgFormContent);    }
public void pdfbox_f6521_0(OutputStream os, String commands) throws IOException
{    os.write(commands.getBytes("UTF-8"));    os.close();}
public void pdfbox_f6522_1(PDDocument template)
{    pdfStructure.setVisualSignature(template.getDocument());    }
public void pdfbox_f6523_1(PDSignatureField signatureField, PDResources holderFormResources) throws IOException
{    COSDictionary widgetDict = signatureField.getWidgets().get(0).getCOSObject();    widgetDict.setNeedToBeUpdated(true);    widgetDict.setItem(COSName.DR, holderFormResources.getCOSObject());    pdfStructure.setWidgetDictionary(widgetDict);    }
public void pdfbox_f6524_0(PDDocument template) throws IOException
{    template.close();    pdfStructure.getTemplate().close();}
private void pdfbox_f6525_0(String filename, int page) throws IOException
{    try (PDDocument document = PDDocument.load(new File(filename))) {                calculatePageSize(document, page);    }}
private void pdfbox_f6526_0(InputStream documentStream, int page) throws IOException
{    try (PDDocument document = PDDocument.load(documentStream)) {                calculatePageSize(document, page);    }}
private void pdfbox_f6527_0(PDDocument document, int page)
{    if (page < 1) {        throw new IllegalArgumentException("First page of pdf is 1, not " + page);    }    PDPage firstPage = document.getPage(page - 1);    PDRectangle mediaBox = firstPage.getMediaBox();    pageHeight(mediaBox.getHeight());    pageWidth = mediaBox.getWidth();    imageSizeInPercents = 100;    rotation = firstPage.getRotation() % 360;}
public PDVisibleSignDesigner pdfbox_f6528_0()
{    switch(rotation) {        case 90:                        float temp = yAxis;            yAxis = pageHeight - xAxis - imageWidth;            xAxis = temp;            affineTransform = new AffineTransform(0, imageHeight / imageWidth, -imageWidth / imageHeight, 0, imageWidth, 0);            temp = imageHeight;            imageHeight = imageWidth;            imageWidth = temp;            break;        case 180:            float newX = pageWidth - xAxis - imageWidth;            float newY = pageHeight - yAxis - imageHeight;            xAxis = newX;            yAxis = newY;            affineTransform = new AffineTransform(-1, 0, 0, -1, imageWidth, imageHeight);            break;        case 270:            temp = xAxis;            xAxis = pageWidth - yAxis - imageHeight;            yAxis = temp;            affineTransform = new AffineTransform(0, -imageHeight / imageWidth, imageWidth / imageHeight, 0, 0, imageHeight);            temp = imageHeight;            imageHeight = imageWidth;            imageWidth = temp;            break;        case 0:        default:            break;    }    return this;}
public PDVisibleSignDesigner pdfbox_f6529_0(String path) throws IOException
{    try (InputStream in = new BufferedInputStream(new FileInputStream(path))) {        readImageStream(in);    }    return this;}
public PDVisibleSignDesigner pdfbox_f6530_0(float percent)
{    imageHeight += (imageHeight * percent) / 100;    imageWidth += (imageWidth * percent) / 100;    formatterRectangleParameters[2] = (int) imageWidth.floatValue();    formatterRectangleParameters[3] = (int) imageHeight.floatValue();    return this;}
public PDVisibleSignDesigner pdfbox_f6531_0(float x, float y)
{    xAxis(x);    yAxis(y);    return this;}
public float pdfbox_f6532_0()
{    return xAxis;}
public PDVisibleSignDesigner pdfbox_f6533_0(float xAxis)
{    this.xAxis = xAxis;    return this;}
public float pdfbox_f6534_0()
{    return yAxis;}
public PDVisibleSignDesigner pdfbox_f6535_0(float yAxis)
{    this.yAxis = yAxis;    return this;}
public float pdfbox_f6536_0()
{    return imageWidth;}
public PDVisibleSignDesigner pdfbox_f6537_0(float width)
{    this.imageWidth = width;    this.formatterRectangleParameters[2] = (int) width;    return this;}
public float pdfbox_f6538_0()
{    return imageHeight;}
public PDVisibleSignDesigner pdfbox_f6539_0(float height)
{    this.imageHeight = height;    this.formatterRectangleParameters[3] = (int) height;    return this;}
protected float pdfbox_f6540_0()
{    return getPageHeight();}
private PDVisibleSignDesigner pdfbox_f6541_0(float templateHeight)
{    this.pageHeight = templateHeight;    return this;}
public String pdfbox_f6542_0()
{    return signatureFieldName;}
public PDVisibleSignDesigner pdfbox_f6543_0(String signatureFieldName)
{    this.signatureFieldName = signatureFieldName;    return this;}
public BufferedImage pdfbox_f6544_0()
{    return image;}
private void pdfbox_f6545_0(InputStream stream) throws IOException
{    ImageIO.setUseCache(false);    setImage(ImageIO.read(stream));}
private void pdfbox_f6546_0(BufferedImage image)
{    this.image = image;    imageHeight = (float) image.getHeight();    imageWidth = (float) image.getWidth();    formatterRectangleParameters[2] = image.getWidth();    formatterRectangleParameters[3] = image.getHeight();}
public AffineTransform pdfbox_f6547_0()
{    return affineTransform;}
public PDVisibleSignDesigner pdfbox_f6548_0(AffineTransform affineTransform)
{    this.affineTransform = new AffineTransform(affineTransform);    return this;}
public int[] pdfbox_f6549_0()
{    return formatterRectangleParameters;}
public PDVisibleSignDesigner pdfbox_f6550_0(int[] formatterRectangleParameters)
{    this.formatterRectangleParameters = formatterRectangleParameters;    return this;}
public float pdfbox_f6551_0()
{    return pageWidth;}
public PDVisibleSignDesigner pdfbox_f6552_0(float pageWidth)
{    this.pageWidth = pageWidth;    return this;}
public float pdfbox_f6553_0()
{    return pageHeight;}
public float pdfbox_f6554_0()
{    return imageSizeInPercents;}
public void pdfbox_f6555_0(float imageSizeInPercents)
{    this.imageSizeInPercents = imageSizeInPercents;}
public String pdfbox_f6556_0()
{    throw new UnsupportedOperationException("That method is not yet implemented");}
public PDVisibleSignDesigner pdfbox_f6557_0(String signatureText)
{    throw new UnsupportedOperationException("That method is not yet implemented");}
public void pdfbox_f6558_0() throws IOException
{    PDFTemplateBuilder builder = new PDVisibleSigBuilder();    PDFTemplateCreator creator = new PDFTemplateCreator(builder);    setVisibleSignature(creator.buildPDF(getPdVisibleSignature()));}
public String pdfbox_f6559_0()
{    return signerName;}
public PDVisibleSigProperties pdfbox_f6560_0(String signerName)
{    this.signerName = signerName;    return this;}
public String pdfbox_f6561_0()
{    return signerLocation;}
public PDVisibleSigProperties pdfbox_f6562_0(String signerLocation)
{    this.signerLocation = signerLocation;    return this;}
public String pdfbox_f6563_0()
{    return signatureReason;}
public PDVisibleSigProperties pdfbox_f6564_0(String signatureReason)
{    this.signatureReason = signatureReason;    return this;}
public int pdfbox_f6565_0()
{    return page;}
public PDVisibleSigProperties pdfbox_f6566_0(int page)
{    this.page = page;    return this;}
public int pdfbox_f6567_0()
{    return preferredSize;}
public PDVisibleSigProperties pdfbox_f6568_0(int preferredSize)
{    this.preferredSize = preferredSize;    return this;}
public boolean pdfbox_f6569_0()
{    return visualSignEnabled;}
public PDVisibleSigProperties pdfbox_f6570_0(boolean visualSignEnabled)
{    this.visualSignEnabled = visualSignEnabled;    return this;}
public PDVisibleSignDesigner pdfbox_f6571_0()
{    return pdVisibleSignature;}
public PDVisibleSigProperties pdfbox_f6572_0(PDVisibleSignDesigner pdVisibleSignature)
{    this.pdVisibleSignature = pdVisibleSignature;    return this;}
public InputStream pdfbox_f6573_0()
{    return visibleSignature;}
public void pdfbox_f6574_0(InputStream visibleSignature)
{    this.visibleSignature = visibleSignature;}
public static PDDestination pdfbox_f6575_0(COSBase base) throws IOException
{    PDDestination retval = null;    if (base == null) {        } else if (base instanceof COSArray && ((COSArray) base).size() > 1 && ((COSArray) base).getObject(1) instanceof COSName) {        COSArray array = (COSArray) base;        COSName type = (COSName) array.getObject(1);        String typeString = type.getName();        switch(typeString) {            case PDPageFitDestination.TYPE:            case PDPageFitDestination.TYPE_BOUNDED:                retval = new PDPageFitDestination(array);                break;            case PDPageFitHeightDestination.TYPE:            case PDPageFitHeightDestination.TYPE_BOUNDED:                retval = new PDPageFitHeightDestination(array);                break;            case PDPageFitRectangleDestination.TYPE:                retval = new PDPageFitRectangleDestination(array);                break;            case PDPageFitWidthDestination.TYPE:            case PDPageFitWidthDestination.TYPE_BOUNDED:                retval = new PDPageFitWidthDestination(array);                break;            case PDPageXYZDestination.TYPE:                retval = new PDPageXYZDestination(array);                break;            default:                throw new IOException("Unknown destination type: " + type.getName());        }    } else if (base instanceof COSString) {        retval = new PDNamedDestination((COSString) base);    } else if (base instanceof COSName) {        retval = new PDNamedDestination((COSName) base);    } else {        throw new IOException("Error: can't convert to Destination " + base);    }    return retval;}
public COSBase pdfbox_f6576_0()
{    return namedDestination;}
public String pdfbox_f6577_0()
{    String retval = null;    if (namedDestination instanceof COSString) {        retval = ((COSString) namedDestination).getString();    } else if (namedDestination instanceof COSName) {        retval = ((COSName) namedDestination).getName();    }    return retval;}
public void pdfbox_f6578_0(String dest) throws IOException
{    if (dest == null) {        namedDestination = null;    } else {        namedDestination = new COSString(dest);    }}
public PDPage pdfbox_f6579_0()
{    PDPage retval = null;    if (array.size() > 0) {        COSBase page = array.getObject(0);        if (page instanceof COSDictionary) {            retval = new PDPage((COSDictionary) page);        }    }    return retval;}
public void pdfbox_f6580_0(PDPage page)
{    array.set(0, page);}
public int pdfbox_f6581_0()
{    int retval = -1;    if (array.size() > 0) {        COSBase page = array.getObject(0);        if (page instanceof COSNumber) {            retval = ((COSNumber) page).intValue();        }    }    return retval;}
public int pdfbox_f6582_0()
{    int retval = -1;    if (array.size() > 0) {        COSBase page = array.getObject(0);        if (page instanceof COSNumber) {            retval = ((COSNumber) page).intValue();        } else if (page instanceof COSDictionary) {            return indexOfPageTree((COSDictionary) page);        }    }    return retval;}
private int pdfbox_f6583_0(COSDictionary pageDict)
{    COSDictionary parent = pageDict;    while (parent.getDictionaryObject(COSName.PARENT, COSName.P) instanceof COSDictionary) {        parent = (COSDictionary) parent.getDictionaryObject(COSName.PARENT, COSName.P);    }    if (parent.containsKey(COSName.KIDS) && COSName.PAGES.equals(parent.getItem(COSName.TYPE))) {                PDPageTree pages = new PDPageTree(parent);        return pages.indexOf(new PDPage(pageDict));    }    return -1;}
public void pdfbox_f6584_0(int pageNumber)
{    array.set(0, pageNumber);}
public COSArray pdfbox_f6585_0()
{    return array;}
public boolean pdfbox_f6586_0()
{    return TYPE_BOUNDED.equals(array.getName(1));}
public void pdfbox_f6587_0(boolean fitBoundingBox)
{    array.growToSize(2);    if (fitBoundingBox) {        array.setName(1, TYPE_BOUNDED);    } else {        array.setName(1, TYPE);    }}
public int pdfbox_f6588_0()
{    return array.getInt(2);}
public void pdfbox_f6589_0(int x)
{    array.growToSize(3);    if (x == -1) {        array.set(2, null);    } else {        array.setInt(2, x);    }}
public boolean pdfbox_f6590_0()
{    return TYPE_BOUNDED.equals(array.getName(1));}
public void pdfbox_f6591_0(boolean fitBoundingBox)
{    array.growToSize(2);    if (fitBoundingBox) {        array.setName(1, TYPE_BOUNDED);    } else {        array.setName(1, TYPE);    }}
public int pdfbox_f6592_0()
{    return array.getInt(2);}
public void pdfbox_f6593_0(int x)
{    array.growToSize(3);    if (x == -1) {        array.set(2, null);    } else {        array.setInt(2, x);    }}
public int pdfbox_f6594_0()
{    return array.getInt(3);}
public void pdfbox_f6595_0(int y)
{    array.growToSize(6);    if (y == -1) {        array.set(3, null);    } else {        array.setInt(3, y);    }}
public int pdfbox_f6596_0()
{    return array.getInt(4);}
public void pdfbox_f6597_0(int x)
{    array.growToSize(6);    if (x == -1) {        array.set(4, null);    } else {        array.setInt(4, x);    }}
public int pdfbox_f6598_0()
{    return array.getInt(5);}
public void pdfbox_f6599_0(int y)
{    array.growToSize(6);    if (y == -1) {        array.set(5, null);    } else {        array.setInt(5, y);    }}
public int pdfbox_f6600_0()
{    return array.getInt(2);}
public void pdfbox_f6601_0(int y)
{    array.growToSize(3);    if (y == -1) {        array.set(2, null);    } else {        array.setInt(2, y);    }}
public boolean pdfbox_f6602_0()
{    return TYPE_BOUNDED.equals(array.getName(1));}
public void pdfbox_f6603_0(boolean fitBoundingBox)
{    array.growToSize(2);    if (fitBoundingBox) {        array.setName(1, TYPE_BOUNDED);    } else {        array.setName(1, TYPE);    }}
public int pdfbox_f6604_0()
{    return array.getInt(2);}
public void pdfbox_f6605_0(int x)
{    array.growToSize(3);    if (x == -1) {        array.set(2, null);    } else {        array.setInt(2, x);    }}
public int pdfbox_f6606_0()
{    return array.getInt(3);}
public void pdfbox_f6607_0(int y)
{    array.growToSize(4);    if (y == -1) {        array.set(3, null);    } else {        array.setInt(3, y);    }}
public float pdfbox_f6608_0()
{    COSBase obj = array.getObject(4);    if (obj instanceof COSNumber) {        return ((COSNumber) obj).floatValue();    }    return -1;}
public void pdfbox_f6609_0(float zoom)
{    array.growToSize(5);    if (Float.compare(zoom, -1) == 0) {        array.set(4, null);    } else {        array.set(4, new COSFloat(zoom));    }}
public boolean pdfbox_f6610_0()
{    return true;}
public void pdfbox_f6613_0(PDOutlineItem newSibling)
{    requireSingleNode(newSibling);    PDOutlineNode parent = getParent();    newSibling.setParent(parent);    PDOutlineItem next = getNextSibling();    setNextSibling(newSibling);    newSibling.setPreviousSibling(this);    if (next != null) {        newSibling.setNextSibling(next);        next.setPreviousSibling(newSibling);    } else if (parent != null) {        getParent().setLastChild(newSibling);    }    updateParentOpenCountForAddedChild(newSibling);}
public void pdfbox_f6614_0(PDOutlineItem newSibling)
{    requireSingleNode(newSibling);    PDOutlineNode parent = getParent();    newSibling.setParent(parent);    PDOutlineItem previous = getPreviousSibling();    setPreviousSibling(newSibling);    newSibling.setNextSibling(this);    if (previous != null) {        previous.setNextSibling(newSibling);        newSibling.setPreviousSibling(previous);    } else if (parent != null) {        getParent().setFirstChild(newSibling);    }    updateParentOpenCountForAddedChild(newSibling);}
public PDOutlineItem pdfbox_f6615_0()
{    return getOutlineItem(COSName.PREV);}
 void pdfbox_f6616_0(PDOutlineNode outlineNode)
{    getCOSObject().setItem(COSName.PREV, outlineNode);}
public PDOutlineItem pdfbox_f6617_0()
{    return getOutlineItem(COSName.NEXT);}
 void pdfbox_f6618_0(PDOutlineNode outlineNode)
{    getCOSObject().setItem(COSName.NEXT, outlineNode);}
public String pdfbox_f6619_0()
{    return getCOSObject().getString(COSName.TITLE);}
public void pdfbox_f6620_0(String title)
{    getCOSObject().setString(COSName.TITLE, title);}
public PDDestination pdfbox_f6621_0() throws IOException
{    return PDDestination.create(getCOSObject().getDictionaryObject(COSName.DEST));}
public void pdfbox_f6622_0(PDDestination dest)
{    getCOSObject().setItem(COSName.DEST, dest);}
public void pdfbox_f6623_0(PDPage page)
{    PDPageXYZDestination dest = null;    if (page != null) {        dest = new PDPageXYZDestination();        dest.setPage(page);    }    setDestination(dest);}
public PDPage pdfbox_f6624_0(PDDocument doc) throws IOException
{    PDDestination dest = getDestination();    if (dest == null) {        PDAction outlineAction = getAction();        if (outlineAction instanceof PDActionGoTo) {            dest = ((PDActionGoTo) outlineAction).getDestination();        }    }    if (dest == null) {        return null;    }    PDPageDestination pageDestination = null;    if (dest instanceof PDNamedDestination) {        pageDestination = doc.getDocumentCatalog().findNamedDestinationPage((PDNamedDestination) dest);        if (pageDestination == null) {            return null;        }    } else if (dest instanceof PDPageDestination) {        pageDestination = (PDPageDestination) dest;    } else {        throw new IOException("Error: Unknown destination type " + dest);    }    PDPage page = pageDestination.getPage();    if (page == null) {                        int pageNumber = pageDestination.getPageNumber();        if (pageNumber != -1) {            page = doc.getPage(pageNumber);        }    }    return page;}
public PDAction pdfbox_f6625_0()
{    return PDActionFactory.createAction((COSDictionary) getCOSObject().getDictionaryObject(COSName.A));}
public void pdfbox_f6626_0(PDAction action)
{    getCOSObject().setItem(COSName.A, action);}
public PDStructureElement pdfbox_f6627_0()
{    PDStructureElement se = null;    COSDictionary dic = (COSDictionary) getCOSObject().getDictionaryObject(COSName.SE);    if (dic != null) {        se = new PDStructureElement(dic);    }    return se;}
public void pdfbox_f6628_0(PDStructureElement structureElement)
{    getCOSObject().setItem(COSName.SE, structureElement);}
public PDColor pdfbox_f6629_0()
{    COSArray csValues = (COSArray) getCOSObject().getDictionaryObject(COSName.C);    if (csValues == null) {        csValues = new COSArray();        csValues.growToSize(3, new COSFloat(0));        getCOSObject().setItem(COSName.C, csValues);    }    return new PDColor(csValues, PDDeviceRGB.INSTANCE);}
public void pdfbox_f6630_0(PDColor textColor)
{    getCOSObject().setItem(COSName.C, textColor.toCOSArray());}
public void pdfbox_f6631_0(Color textColor)
{    COSArray array = new COSArray();    array.add(new COSFloat(textColor.getRed() / 255f));    array.add(new COSFloat(textColor.getGreen() / 255f));    array.add(new COSFloat(textColor.getBlue() / 255f));    getCOSObject().setItem(COSName.C, array);}
public boolean pdfbox_f6632_0()
{    return getCOSObject().getFlag(COSName.F, ITALIC_FLAG);}
public void pdfbox_f6633_0(boolean italic)
{    getCOSObject().setFlag(COSName.F, ITALIC_FLAG, italic);}
public boolean pdfbox_f6634_0()
{    return getCOSObject().getFlag(COSName.F, BOLD_FLAG);}
public void pdfbox_f6635_0(boolean bold)
{    getCOSObject().setFlag(COSName.F, BOLD_FLAG, bold);}
public boolean pdfbox_f6636_0()
{    return startingItem != null && (currentItem == null || (currentItem.getNextSibling() != null && !startingItem.equals(currentItem.getNextSibling())));}
public PDOutlineItem pdfbox_f6637_0()
{    if (currentItem == null) {        currentItem = startingItem;    } else {        currentItem = currentItem.getNextSibling();    }    return currentItem;}
public void pdfbox_f6638_0()
{    throw new UnsupportedOperationException();}
 PDOutlineNode pdfbox_f6639_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.PARENT);    if (base instanceof COSDictionary) {        COSDictionary parent = (COSDictionary) base;        if (COSName.OUTLINES.equals(parent.getCOSName(COSName.TYPE))) {            return new PDDocumentOutline(parent);        }        return new PDOutlineItem(parent);    }    return null;}
 void pdfbox_f6640_0(PDOutlineNode parent)
{    getCOSObject().setItem(COSName.PARENT, parent);}
public void pdfbox_f6641_0(PDOutlineItem newChild)
{    requireSingleNode(newChild);    append(newChild);    updateParentOpenCountForAddedChild(newChild);}
public void pdfbox_f6642_0(PDOutlineItem newChild)
{    requireSingleNode(newChild);    prepend(newChild);    updateParentOpenCountForAddedChild(newChild);}
 void pdfbox_f6643_0(PDOutlineItem node)
{    if (node.getNextSibling() != null || node.getPreviousSibling() != null) {        throw new IllegalArgumentException("A single node with no siblings is required");    }}
private void pdfbox_f6644_0(PDOutlineItem newChild)
{    newChild.setParent(this);    if (!hasChildren()) {        setFirstChild(newChild);    } else {        PDOutlineItem previousLastChild = getLastChild();        previousLastChild.setNextSibling(newChild);        newChild.setPreviousSibling(previousLastChild);    }    setLastChild(newChild);}
private void pdfbox_f6645_0(PDOutlineItem newChild)
{    newChild.setParent(this);    if (!hasChildren()) {        setLastChild(newChild);    } else {        PDOutlineItem previousFirstChild = getFirstChild();        newChild.setNextSibling(previousFirstChild);        previousFirstChild.setPreviousSibling(newChild);    }    setFirstChild(newChild);}
 void pdfbox_f6646_0(PDOutlineItem newChild)
{    int delta = 1;    if (newChild.isNodeOpen()) {        delta += newChild.getOpenCount();    }    newChild.updateParentOpenCount(delta);}
public boolean pdfbox_f6647_0()
{    return getFirstChild() != null;}
 PDOutlineItem pdfbox_f6648_0(COSName name)
{    COSBase base = getCOSObject().getDictionaryObject(name);    if (base instanceof COSDictionary) {        return new PDOutlineItem((COSDictionary) base);    }    return null;}
public PDOutlineItem pdfbox_f6649_0()
{    return getOutlineItem(COSName.FIRST);}
 void pdfbox_f6650_0(PDOutlineNode outlineNode)
{    getCOSObject().setItem(COSName.FIRST, outlineNode);}
public PDOutlineItem pdfbox_f6651_0()
{    return getOutlineItem(COSName.LAST);}
 void pdfbox_f6652_0(PDOutlineNode outlineNode)
{    getCOSObject().setItem(COSName.LAST, outlineNode);}
public int pdfbox_f6653_0()
{    return getCOSObject().getInt(COSName.COUNT, 0);}
 void pdfbox_f6654_0(int openCount)
{    getCOSObject().setInt(COSName.COUNT, openCount);}
public void pdfbox_f6655_0()
{        if (!isNodeOpen()) {        switchNodeCount();    }}
public void pdfbox_f6656_0()
{    if (isNodeOpen()) {        switchNodeCount();    }}
private void pdfbox_f6657_0()
{    int openCount = getOpenCount();    setOpenCount(-openCount);    updateParentOpenCount(-openCount);}
public boolean pdfbox_f6658_0()
{    return getOpenCount() > 0;}
 void pdfbox_f6659_0(int delta)
{    PDOutlineNode parent = getParent();    if (parent != null) {        if (parent.isNodeOpen()) {            parent.setOpenCount(parent.getOpenCount() + delta);            parent.updateParentOpenCount(delta);        } else {            parent.setOpenCount(parent.getOpenCount() - delta);        }    }}
public Iterable<PDOutlineItem> pdfbox_f6660_0()
{    return () -> new PDOutlineItemIterator(getFirstChild());}
private void pdfbox_f6661_1()
{        if (field.getAcroForm().getDefaultResources() == null) {        return;    }    PDResources acroFormResources = field.getAcroForm().getDefaultResources();    for (PDAnnotationWidget widget : field.getWidgets()) {        if (widget.getNormalAppearanceStream() != null && widget.getNormalAppearanceStream().getResources() != null) {            PDResources widgetResources = widget.getNormalAppearanceStream().getResources();            for (COSName fontResourceName : widgetResources.getFontNames()) {                try {                    if (acroFormResources.getFont(fontResourceName) == null) {                                                acroFormResources.put(fontResourceName, widgetResources.getFont(fontResourceName));                    }                } catch (IOException e) {                                    }            }        }    }}
public void pdfbox_f6662_1(String apValue) throws IOException
{    value = apValue;        if (field instanceof PDTextField && !((PDTextField) field).isMultiline()) {        value = apValue.replaceAll("\\u000D\\u000A|[\\u000A\\u000B\\u000C\\u000D\\u0085\\u2028\\u2029]", " ");    }    for (PDAnnotationWidget widget : field.getWidgets()) {                        PDDefaultAppearanceString acroFormAppearance = defaultAppearance;        if (widget.getCOSObject().getDictionaryObject(COSName.DA) != null) {            defaultAppearance = getWidgetDefaultAppearanceString(widget);        }        PDRectangle rect = widget.getRectangle();        if (rect == null) {            widget.getCOSObject().removeItem(COSName.AP);                        continue;        }        PDFormFieldAdditionalActions actions = field.getActions();                if (actions == null || actions.getF() == null || widget.getCOSObject().getDictionaryObject(COSName.AP) != null) {            PDAppearanceDictionary appearanceDict = widget.getAppearance();            if (appearanceDict == null) {                appearanceDict = new PDAppearanceDictionary();                widget.setAppearance(appearanceDict);            }            PDAppearanceEntry appearance = appearanceDict.getNormalAppearance();                        PDAppearanceStream appearanceStream;            if (isValidAppearanceStream(appearance)) {                appearanceStream = appearance.getAppearanceStream();            } else {                appearanceStream = prepareNormalAppearanceStream(widget);                appearanceDict.setNormalAppearance(appearanceStream);                        }            /*                 * Adobe Acrobat always recreates the complete appearance stream if there is an appearance characteristics                 * entry (the widget dictionaries MK entry). In addition if there is no content yet also create the appearance                 * stream from the entries.                 *                  */            if (widget.getAppearanceCharacteristics() != null || appearanceStream.getContentStream().getLength() == 0) {                initializeAppearanceContent(widget, appearanceStream);            }            setAppearanceContent(widget, appearanceStream);        }                defaultAppearance = acroFormAppearance;    }}
private static boolean pdfbox_f6663_0(PDAppearanceEntry appearance)
{    if (appearance == null) {        return false;    }    if (!appearance.isStream()) {        return false;    }    PDRectangle bbox = appearance.getAppearanceStream().getBBox();    if (bbox == null) {        return false;    }    return Math.abs(bbox.getWidth()) > 0 && Math.abs(bbox.getHeight()) > 0;}
private PDAppearanceStream pdfbox_f6664_0(PDAnnotationWidget widget)
{    PDAppearanceStream appearanceStream = new PDAppearanceStream(field.getAcroForm().getDocument());            int rotation = resolveRotation(widget);    PDRectangle rect = widget.getRectangle();    Matrix matrix = Matrix.getRotateInstance(Math.toRadians(rotation), 0, 0);    Point2D.Float point2D = matrix.transformPoint(rect.getWidth(), rect.getHeight());    PDRectangle bbox = new PDRectangle(Math.abs((float) point2D.getX()), Math.abs((float) point2D.getY()));    appearanceStream.setBBox(bbox);    AffineTransform at = calculateMatrix(bbox, rotation);    if (!at.isIdentity()) {        appearanceStream.setMatrix(at);    }    appearanceStream.setFormType(1);    appearanceStream.setResources(new PDResources());    return appearanceStream;}
private PDDefaultAppearanceString pdfbox_f6665_0(PDAnnotationWidget widget) throws IOException
{    COSString da = (COSString) widget.getCOSObject().getDictionaryObject(COSName.DA);    PDResources dr = field.getAcroForm().getDefaultResources();    return new PDDefaultAppearanceString(da, dr);}
private int pdfbox_f6666_0(PDAnnotationWidget widget)
{    PDAppearanceCharacteristicsDictionary characteristicsDictionary = widget.getAppearanceCharacteristics();    if (characteristicsDictionary != null) {                return characteristicsDictionary.getRotation();    }    return 0;}
private void pdfbox_f6667_0(PDAnnotationWidget widget, PDAppearanceStream appearanceStream) throws IOException
{    try (ByteArrayOutputStream output = new ByteArrayOutputStream();        PDAppearanceContentStream contents = new PDAppearanceContentStream(appearanceStream, output)) {        PDAppearanceCharacteristicsDictionary appearanceCharacteristics = widget.getAppearanceCharacteristics();                if (appearanceCharacteristics != null) {            PDColor backgroundColour = appearanceCharacteristics.getBackground();            if (backgroundColour != null) {                contents.setNonStrokingColor(backgroundColour);                PDRectangle bbox = resolveBoundingBox(widget, appearanceStream);                contents.addRect(bbox.getLowerLeftX(), bbox.getLowerLeftY(), bbox.getWidth(), bbox.getHeight());                contents.fill();            }            float lineWidth = 0f;            PDColor borderColour = appearanceCharacteristics.getBorderColour();            if (borderColour != null) {                contents.setStrokingColor(borderColour);                lineWidth = 1f;            }            PDBorderStyleDictionary borderStyle = widget.getBorderStyle();            if (borderStyle != null && borderStyle.getWidth() > 0) {                lineWidth = borderStyle.getWidth();            }            if (lineWidth > 0 && borderColour != null) {                if (Float.compare(lineWidth, 1) != 0) {                    contents.setLineWidth(lineWidth);                }                PDRectangle bbox = resolveBoundingBox(widget, appearanceStream);                PDRectangle clipRect = applyPadding(bbox, Math.max(DEFAULT_PADDING, lineWidth / 2));                contents.addRect(clipRect.getLowerLeftX(), clipRect.getLowerLeftY(), clipRect.getWidth(), clipRect.getHeight());                contents.closeAndStroke();            }        }        writeToStream(output.toByteArray(), appearanceStream);    }}
private List<Object> pdfbox_f6668_0(PDAppearanceStream appearanceStream) throws IOException
{    PDFStreamParser parser = new PDFStreamParser(appearanceStream.getContents());    parser.parse();    return parser.getTokens();}
private void pdfbox_f6669_0(PDAnnotationWidget widget, PDAppearanceStream appearanceStream) throws IOException
{            defaultAppearance.copyNeededResourcesTo(appearanceStream);        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {        ContentStreamWriter writer = new ContentStreamWriter(output);        List<Object> tokens = tokenize(appearanceStream);        int bmcIndex = tokens.indexOf(BMC);        if (bmcIndex == -1) {                        writer.writeTokens(tokens);            writer.writeTokens(COSName.TX, BMC);        } else {                        writer.writeTokens(tokens.subList(0, bmcIndex + 1));        }                insertGeneratedAppearance(widget, appearanceStream, output);        int emcIndex = tokens.indexOf(EMC);        if (emcIndex == -1) {                        writer.writeTokens(EMC);        } else {                        writer.writeTokens(tokens.subList(emcIndex, tokens.size()));        }        writeToStream(output.toByteArray(), appearanceStream);    }}
private AffineTransform pdfbox_f6671_0(PDRectangle bbox, int rotation)
{    if (rotation == 0) {        return new AffineTransform();    }    float tx = 0, ty = 0;    switch(rotation) {        case 90:            tx = bbox.getUpperRightY();            break;        case 180:            tx = bbox.getUpperRightY();            ty = bbox.getUpperRightX();            break;        case 270:            ty = bbox.getUpperRightX();            break;        default:            break;    }    Matrix matrix = Matrix.getRotateInstance(Math.toRadians(rotation), tx, ty);    return matrix.createAffineTransform();}
private boolean pdfbox_f6672_0()
{    return field instanceof PDTextField && ((PDTextField) field).isMultiline();}
private boolean pdfbox_f6673_0()
{    return field instanceof PDTextField && ((PDTextField) field).isComb() && !((PDTextField) field).isMultiline() && !((PDTextField) field).isPassword() && !((PDTextField) field).isFileSelect();}
private void pdfbox_f6674_0(PDAppearanceContentStream contents, PDAppearanceStream appearanceStream, PDFont font, float fontSize) throws IOException
{            int maxLen = ((PDTextField) field).getMaxLen();    int numChars = Math.min(value.length(), maxLen);    PDRectangle paddingEdge = applyPadding(appearanceStream.getBBox(), 1);    float combWidth = appearanceStream.getBBox().getWidth() / maxLen;    float ascentAtFontSize = font.getFontDescriptor().getAscent() / FONTSCALE * fontSize;    float baselineOffset = paddingEdge.getLowerLeftY() + (appearanceStream.getBBox().getHeight() - ascentAtFontSize) / 2;    float prevCharWidth = 0f;    float xOffset = combWidth / 2;    for (int i = 0; i < numChars; i++) {        String combString = value.substring(i, i + 1);        float currCharWidth = font.getStringWidth(combString) / FONTSCALE * fontSize / 2;        xOffset = xOffset + prevCharWidth / 2 - currCharWidth / 2;        contents.newLineAtOffset(xOffset, baselineOffset);        contents.showText(combString);        baselineOffset = 0;        prevCharWidth = currCharWidth;        xOffset = combWidth;    }}
private void pdfbox_f6675_0(PDAppearanceContentStream contents, PDAppearanceStream appearanceStream, PDFont font, float fontSize) throws IOException
{    List<Integer> indexEntries = ((PDListBox) field).getSelectedOptionsIndex();    List<String> values = ((PDListBox) field).getValue();    List<String> options = ((PDListBox) field).getOptionsExportValues();    if (!values.isEmpty() && !options.isEmpty() && indexEntries.isEmpty()) {                indexEntries = new ArrayList<>();        for (String v : values) {            indexEntries.add(options.indexOf(v));        }    }                int topIndex = ((PDListBox) field).getTopIndex();    float highlightBoxHeight = font.getBoundingBox().getHeight() * fontSize / FONTSCALE;        PDRectangle paddingEdge = applyPadding(appearanceStream.getBBox(), 1);    for (int selectedIndex : indexEntries) {        contents.setNonStrokingColor(HIGHLIGHT_COLOR[0], HIGHLIGHT_COLOR[1], HIGHLIGHT_COLOR[2]);        contents.addRect(paddingEdge.getLowerLeftX(), paddingEdge.getUpperRightY() - highlightBoxHeight * (selectedIndex - topIndex + 1) + 2, paddingEdge.getWidth(), highlightBoxHeight);        contents.fill();    }    contents.setNonStrokingColor(0);}
private void pdfbox_f6676_0(PDAppearanceContentStream contents, PDAppearanceStream appearanceStream, PDRectangle contentRect, PDFont font, float fontSize) throws IOException
{    contents.setNonStrokingColor(0);    int q = field.getQ();    if (q == PDVariableText.QUADDING_CENTERED || q == PDVariableText.QUADDING_RIGHT) {        float fieldWidth = appearanceStream.getBBox().getWidth();        float stringWidth = (font.getStringWidth(value) / FONTSCALE) * fontSize;        float adjustAmount = fieldWidth - stringWidth - 4;        if (q == PDVariableText.QUADDING_CENTERED) {            adjustAmount = adjustAmount / 2.0f;        }        contents.newLineAtOffset(adjustAmount, 0);    } else if (q != PDVariableText.QUADDING_LEFT) {        throw new IOException("Error: Unknown justification value:" + q);    }    List<String> options = ((PDListBox) field).getOptionsDisplayValues();    int numOptions = options.size();    float yTextPos = contentRect.getUpperRightY();    int topIndex = ((PDListBox) field).getTopIndex();    for (int i = topIndex; i < numOptions; i++) {        if (i == topIndex) {            yTextPos = yTextPos - font.getFontDescriptor().getAscent() / FONTSCALE * fontSize;        } else {            yTextPos = yTextPos - font.getBoundingBox().getHeight() / FONTSCALE * fontSize;            contents.beginText();        }        contents.newLineAtOffset(contentRect.getLowerLeftX(), yTextPos);        contents.showText(options.get(i));        if (i != (numOptions - 1)) {            contents.endText();        }    }}
private void pdfbox_f6677_0(byte[] data, PDAppearanceStream appearanceStream) throws IOException
{    try (OutputStream out = appearanceStream.getCOSObject().createOutputStream()) {        out.write(data);    }}
private float pdfbox_f6678_0(PDFont font, PDRectangle contentRect) throws IOException
{    float fontSize = defaultAppearance.getFontSize();        if (Float.compare(fontSize, 0) == 0) {        if (isMultiLine()) {                        return DEFAULT_FONT_SIZE;        } else {            float yScalingFactor = FONTSCALE * font.getFontMatrix().getScaleY();            float xScalingFactor = FONTSCALE * font.getFontMatrix().getScaleX();                        float width = font.getStringWidth(value) * font.getFontMatrix().getScaleX();            float widthBasedFontSize = contentRect.getWidth() / width * xScalingFactor;                        float height = (font.getFontDescriptor().getCapHeight() + -font.getFontDescriptor().getDescent()) * font.getFontMatrix().getScaleY();            if (height <= 0) {                height = font.getBoundingBox().getHeight() * font.getFontMatrix().getScaleY();            }            float heightBasedFontSize = contentRect.getHeight() / height * yScalingFactor;            return Math.min(heightBasedFontSize, widthBasedFontSize);        }    }    return fontSize;}
private PDRectangle pdfbox_f6679_0(PDAnnotationWidget fieldWidget, PDAppearanceStream appearanceStream)
{    PDRectangle boundingBox = appearanceStream.getBBox();    if (boundingBox == null) {        boundingBox = fieldWidget.getRectangle().createRetranslatedRectangle();    }    return boundingBox;}
private PDRectangle pdfbox_f6680_0(PDRectangle box, float padding)
{    return new PDRectangle(box.getLowerLeftX() + padding, box.getLowerLeftY() + padding, box.getWidth() - 2 * padding, box.getHeight() - 2 * padding);}
 PDFont pdfbox_f6681_0()
{    return font;}
 void pdfbox_f6682_0(PDFont font)
{    this.font = font;}
 float pdfbox_f6683_0()
{    return fontSize;}
 void pdfbox_f6684_0(float fontSize)
{    this.fontSize = fontSize;    leading = fontSize * 1.2f;}
 float pdfbox_f6685_0()
{    return leading;}
 void pdfbox_f6686_0(float leading)
{    this.leading = leading;}
public String pdfbox_f6687_0()
{    return this.key;}
public String pdfbox_f6688_0()
{    return this.value;}
public String pdfbox_f6689_0()
{    return "(" + this.key + ", " + this.value + ")";}
public int pdfbox_f6690_0(KeyValue o1, KeyValue o2)
{    return o1.key.compareTo(o2.key);}
public int pdfbox_f6691_0(KeyValue o1, KeyValue o2)
{    return o1.value.compareTo(o2.value);}
 static List<KeyValue> pdfbox_f6692_0(List<String> key, List<String> value)
{    List<KeyValue> list = new ArrayList<>();    for (int i = 0; i < key.size(); i++) {        list.add(new FieldUtils.KeyValue(key.get(i), value.get(i)));    }    return list;}
 static void pdfbox_f6693_0(List<KeyValue> pairs)
{    Collections.sort(pairs, new FieldUtils.KeyValueValueComparator());}
 static void pdfbox_f6694_0(List<KeyValue> pairs)
{    Collections.sort(pairs, new FieldUtils.KeyValueKeyComparator());}
 static List<String> pdfbox_f6695_0(COSBase items, int pairIdx)
{    if (pairIdx < 0 || pairIdx > 1) {        throw new IllegalArgumentException("Only 0 and 1 are allowed as an index into two-element arrays");    }    if (items instanceof COSString) {        List<String> array = new ArrayList<>();        array.add(((COSString) items).getString());        return array;    } else if (items instanceof COSArray) {        List<String> entryList = new ArrayList<>();        for (COSBase entry : (COSArray) items) {            if (entry instanceof COSString) {                entryList.add(((COSString) entry).getString());            } else if (entry instanceof COSArray) {                COSArray cosArray = (COSArray) entry;                if (cosArray.size() >= pairIdx + 1 && cosArray.get(pairIdx) instanceof COSString) {                    entryList.add(((COSString) cosArray.get(pairIdx)).getString());                }            }        }        return entryList;    }    return Collections.emptyList();}
private void pdfbox_f6696_0()
{    final String adobeDefaultAppearanceString = "/Helv 0 Tf 0 g ";        if (getDefaultAppearance().length() == 0) {        setDefaultAppearance(adobeDefaultAppearanceString);        dictionary.setNeedToBeUpdated(true);    }        PDResources defaultResources = getDefaultResources();    if (defaultResources == null) {        defaultResources = new PDResources();        setDefaultResources(defaultResources);        dictionary.setNeedToBeUpdated(true);    }                            COSDictionary fontDict = defaultResources.getCOSObject().getCOSDictionary(COSName.FONT);    if (fontDict == null) {        fontDict = new COSDictionary();        defaultResources.getCOSObject().setItem(COSName.FONT, fontDict);    }    if (!fontDict.containsKey(COSName.HELV)) {        defaultResources.put(COSName.HELV, PDType1Font.HELVETICA);        defaultResources.getCOSObject().setNeedToBeUpdated(true);        fontDict.setNeedToBeUpdated(true);    }    if (!fontDict.containsKey(COSName.ZA_DB)) {        defaultResources.put(COSName.ZA_DB, PDType1Font.ZAPF_DINGBATS);        defaultResources.getCOSObject().setNeedToBeUpdated(true);        fontDict.setNeedToBeUpdated(true);    }}
 PDDocument pdfbox_f6697_0()
{    return document;}
public COSDictionary pdfbox_f6698_0()
{    return dictionary;}
public void pdfbox_f6699_0(FDFDocument fdf) throws IOException
{    List<FDFField> fields = fdf.getCatalog().getFDF().getFields();    if (fields != null) {        for (FDFField field : fields) {            FDFField fdfField = field;            PDField docField = getField(fdfField.getPartialFieldName());            if (docField != null) {                docField.importFDF(fdfField);            }        }    }}
public FDFDocument pdfbox_f6700_0() throws IOException
{    FDFDocument fdf = new FDFDocument();    FDFCatalog catalog = fdf.getCatalog();    FDFDictionary fdfDict = new FDFDictionary();    catalog.setFDF(fdfDict);    List<FDFField> fdfFields = new ArrayList<>();    List<PDField> fields = getFields();    for (PDField field : fields) {        fdfFields.add(field.exportFDF());    }    fdfDict.setID(document.getDocument().getDocumentID());    if (!fdfFields.isEmpty()) {        fdfDict.setFields(fdfFields);    }    return fdf;}
public void pdfbox_f6701_1() throws IOException
{        if (xfaIsDynamic()) {                return;    }    List<PDField> fields = new ArrayList<>();    for (PDField field : getFieldTree()) {        fields.add(field);    }    flatten(fields, false);}
public void pdfbox_f6702_1(List<PDField> fields, boolean refreshAppearances) throws IOException
{        if (fields.isEmpty()) {        return;    }    if (!refreshAppearances && getNeedAppearances()) {                    }        if (xfaIsDynamic()) {                return;    }        if (refreshAppearances) {        refreshAppearances(fields);    }        PDPageContentStream contentStream;    Map<COSDictionary, Set<COSDictionary>> pagesWidgetsMap = buildPagesWidgetsMap(fields);        for (PDPage page : document.getPages()) {        Set<COSDictionary> widgetsForPageMap = pagesWidgetsMap.get(page.getCOSObject());                        boolean isContentStreamWrapped = false;        List<PDAnnotation> annotations = new ArrayList<>();        for (PDAnnotation annotation : page.getAnnotations()) {            if (widgetsForPageMap != null && !widgetsForPageMap.contains(annotation.getCOSObject())) {                annotations.add(annotation);            } else if (!annotation.isInvisible() && !annotation.isHidden() && annotation.getNormalAppearanceStream() != null && annotation.getNormalAppearanceStream().getBBox() != null) {                contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, true, !isContentStreamWrapped);                isContentStreamWrapped = true;                PDAppearanceStream appearanceStream = annotation.getNormalAppearanceStream();                PDFormXObject fieldObject = new PDFormXObject(appearanceStream.getCOSObject());                contentStream.saveGraphicsState();                                                boolean needsTranslation = resolveNeedsTranslation(appearanceStream);                                                boolean needsScaling = resolveNeedsScaling(annotation, page.getRotation());                Matrix transformationMatrix = new Matrix();                boolean transformed = false;                if (needsTranslation) {                    transformationMatrix.translate(annotation.getRectangle().getLowerLeftX(), annotation.getRectangle().getLowerLeftY());                    transformed = true;                }                if (needsScaling) {                    PDRectangle bbox = appearanceStream.getBBox();                    PDRectangle fieldRect = annotation.getRectangle();                    float xScale;                    float yScale;                    if (page.getRotation() == 90 || page.getRotation() == 270) {                        xScale = fieldRect.getWidth() / bbox.getHeight();                        yScale = fieldRect.getHeight() / bbox.getWidth();                    } else {                        xScale = fieldRect.getWidth() / bbox.getWidth();                        yScale = fieldRect.getHeight() / bbox.getHeight();                    }                    Matrix scalingMatrix = Matrix.getScaleInstance(xScale, yScale);                    transformationMatrix.concatenate(scalingMatrix);                    transformed = true;                }                if (transformed) {                    contentStream.transform(transformationMatrix);                }                contentStream.drawForm(fieldObject);                contentStream.restoreGraphicsState();                contentStream.close();            }        }        page.setAnnotations(annotations);    }        removeFields(fields);        dictionary.removeItem(COSName.XFA);}
public void pdfbox_f6703_0() throws IOException
{    for (PDField field : getFieldTree()) {        if (field instanceof PDTerminalField) {            ((PDTerminalField) field).constructAppearances();        }    }}
public void pdfbox_f6704_0(List<PDField> fields) throws IOException
{    for (PDField field : fields) {        if (field instanceof PDTerminalField) {            ((PDTerminalField) field).constructAppearances();        }    }}
public List<PDField> pdfbox_f6705_0()
{    COSArray cosFields = (COSArray) dictionary.getDictionaryObject(COSName.FIELDS);    if (cosFields == null) {        return Collections.emptyList();    }    List<PDField> pdFields = new ArrayList<>();    for (int i = 0; i < cosFields.size(); i++) {        COSDictionary element = (COSDictionary) cosFields.getObject(i);        if (element != null) {            PDField field = PDField.fromDictionary(this, element, null);            if (field != null) {                pdFields.add(field);            }        }    }    return new COSArrayList<>(pdFields, cosFields);}
public void pdfbox_f6706_0(List<PDField> fields)
{    dictionary.setItem(COSName.FIELDS, COSArrayList.converterToCOSArray(fields));}
public Iterator<PDField> pdfbox_f6707_0()
{    return new PDFieldTree(this).iterator();}
public PDFieldTree pdfbox_f6708_0()
{    return new PDFieldTree(this);}
public void pdfbox_f6709_0(boolean cache)
{    if (cache) {        fieldCache = new HashMap<>();        for (PDField field : getFieldTree()) {            fieldCache.put(field.getFullyQualifiedName(), field);        }    } else {        fieldCache = null;    }}
public boolean pdfbox_f6710_0()
{    return fieldCache != null;}
public PDField pdfbox_f6711_0(String fullyQualifiedName)
{        if (fieldCache != null) {        return fieldCache.get(fullyQualifiedName);    }        for (PDField field : getFieldTree()) {        if (field.getFullyQualifiedName().equals(fullyQualifiedName)) {            return field;        }    }    return null;}
public String pdfbox_f6712_0()
{    return dictionary.getString(COSName.DA, "");}
public void pdfbox_f6713_0(String daValue)
{    dictionary.setString(COSName.DA, daValue);}
public boolean pdfbox_f6714_0()
{    return dictionary.getBoolean(COSName.NEED_APPEARANCES, false);}
public void pdfbox_f6715_0(Boolean value)
{    dictionary.setBoolean(COSName.NEED_APPEARANCES, value);}
public PDResources pdfbox_f6716_0()
{    PDResources retval = null;    COSBase base = dictionary.getDictionaryObject(COSName.DR);    if (base instanceof COSDictionary) {        retval = new PDResources((COSDictionary) base, document.getResourceCache());    }    return retval;}
public void pdfbox_f6717_0(PDResources dr)
{    dictionary.setItem(COSName.DR, dr);}
public boolean pdfbox_f6718_0()
{    return dictionary.containsKey(COSName.XFA);}
public boolean pdfbox_f6719_0()
{    return hasXFA() && getFields().isEmpty();}
public PDXFAResource pdfbox_f6720_0()
{    PDXFAResource xfa = null;    COSBase base = dictionary.getDictionaryObject(COSName.XFA);    if (base != null) {        xfa = new PDXFAResource(base);    }    return xfa;}
public void pdfbox_f6721_0(PDXFAResource xfa)
{    dictionary.setItem(COSName.XFA, xfa);}
public int pdfbox_f6722_0()
{    int retval = 0;    COSNumber number = (COSNumber) dictionary.getDictionaryObject(COSName.Q);    if (number != null) {        retval = number.intValue();    }    return retval;}
public void pdfbox_f6723_0(int q)
{    dictionary.setInt(COSName.Q, q);}
public boolean pdfbox_f6724_0()
{    return dictionary.getFlag(COSName.SIG_FLAGS, FLAG_SIGNATURES_EXIST);}
public void pdfbox_f6725_0(boolean signaturesExist)
{    dictionary.setFlag(COSName.SIG_FLAGS, FLAG_SIGNATURES_EXIST, signaturesExist);}
public boolean pdfbox_f6726_0()
{    return dictionary.getFlag(COSName.SIG_FLAGS, FLAG_APPEND_ONLY);}
public void pdfbox_f6727_0(boolean appendOnly)
{    dictionary.setFlag(COSName.SIG_FLAGS, FLAG_APPEND_ONLY, appendOnly);}
private boolean pdfbox_f6728_1(PDAppearanceStream appearanceStream)
{            boolean needsTranslation = true;    PDResources resources = appearanceStream.getResources();    if (resources != null && resources.getXObjectNames().iterator().hasNext()) {        Iterator<COSName> xObjectNames = resources.getXObjectNames().iterator();        while (xObjectNames.hasNext()) {            try {                                                PDXObject xObject = resources.getXObject(xObjectNames.next());                if (xObject instanceof PDFormXObject) {                    PDRectangle bbox = ((PDFormXObject) xObject).getBBox();                    float llX = bbox.getLowerLeftX();                    float llY = bbox.getLowerLeftY();                    if (Float.compare(llX, 0) != 0 && Float.compare(llY, 0) != 0) {                        needsTranslation = false;                    }                }            } catch (IOException e) {                                                            }        }        return needsTranslation;    }    return true;}
private boolean pdfbox_f6729_0(PDAnnotation annotation, int rotation)
{    PDAppearanceStream appearanceStream = annotation.getNormalAppearanceStream();        PDResources resources = appearanceStream.getResources();    if (resources != null && resources.getXObjectNames().iterator().hasNext()) {        return true;    }    PDRectangle bbox = appearanceStream.getBBox();    PDRectangle fieldRect = annotation.getRectangle();    if (rotation == 90 || rotation == 270) {        return Float.compare(bbox.getWidth(), fieldRect.getHeight()) != 0 || Float.compare(bbox.getHeight(), fieldRect.getWidth()) != 0;    } else {        return Float.compare(bbox.getWidth(), fieldRect.getWidth()) != 0 || Float.compare(bbox.getHeight(), fieldRect.getHeight()) != 0;    }}
private Map<COSDictionary, Set<COSDictionary>> pdfbox_f6730_1(List<PDField> fields) throws IOException
{    Map<COSDictionary, Set<COSDictionary>> pagesAnnotationsMap = new HashMap<>();    boolean hasMissingPageRef = false;    for (PDField field : fields) {        List<PDAnnotationWidget> widgets = field.getWidgets();        for (PDAnnotationWidget widget : widgets) {            PDPage page = widget.getPage();            if (page != null) {                fillPagesAnnotationMap(pagesAnnotationsMap, page, widget);            } else {                hasMissingPageRef = true;            }        }    }    if (!hasMissingPageRef) {        return pagesAnnotationsMap;    }                for (PDPage page : document.getPages()) {        for (PDAnnotation annotation : page.getAnnotations()) {            if (annotation instanceof PDAnnotationWidget) {                fillPagesAnnotationMap(pagesAnnotationsMap, page, (PDAnnotationWidget) annotation);            }        }    }    return pagesAnnotationsMap;}
private void pdfbox_f6731_0(Map<COSDictionary, Set<COSDictionary>> pagesAnnotationsMap, PDPage page, PDAnnotationWidget widget)
{    if (pagesAnnotationsMap.get(page.getCOSObject()) == null) {        Set<COSDictionary> widgetsForPage = new HashSet<>();        widgetsForPage.add(widget.getCOSObject());        pagesAnnotationsMap.put(page.getCOSObject(), widgetsForPage);    } else {        Set<COSDictionary> widgetsForPage = pagesAnnotationsMap.get(page.getCOSObject());        widgetsForPage.add(widget.getCOSObject());    }}
private void pdfbox_f6732_0(List<PDField> fields)
{    for (PDField field : fields) {        COSArray array;        if (field.getParent() == null) {                        array = (COSArray) dictionary.getDictionaryObject(COSName.FIELDS);        } else {                        array = (COSArray) field.getParent().getCOSObject().getDictionaryObject(COSName.KIDS);        }        array.removeObject(field.getCOSObject());    }}
public boolean pdfbox_f6733_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_PUSHBUTTON);}
public void pdfbox_f6734_0(boolean pushbutton)
{    getCOSObject().setFlag(COSName.FF, FLAG_PUSHBUTTON, pushbutton);}
public boolean pdfbox_f6735_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_RADIO);}
public void pdfbox_f6736_0(boolean radiobutton)
{    getCOSObject().setFlag(COSName.FF, FLAG_RADIO, radiobutton);}
public String pdfbox_f6737_0()
{    COSBase value = getInheritableAttribute(COSName.V);    if (value instanceof COSName) {        return ((COSName) value).getName();    } else {                return "Off";    }}
public void pdfbox_f6738_0(String value) throws IOException
{    checkValue(value);            boolean hasExportValues = getExportValues().size() > 0;    if (hasExportValues) {        updateByOption(value);    } else {        updateByValue(value);    }    applyChange();}
public String pdfbox_f6739_0()
{    COSBase value = getInheritableAttribute(COSName.DV);    if (value instanceof COSName) {        return ((COSName) value).getName();    } else {        return "";    }}
public void pdfbox_f6740_0(String value)
{    checkValue(value);    getCOSObject().setName(COSName.DV, value);}
public String pdfbox_f6741_0()
{    return getValue();}
public List<String> pdfbox_f6742_0()
{    COSBase value = getInheritableAttribute(COSName.OPT);    if (value instanceof COSString) {        List<String> array = new ArrayList<>();        array.add(((COSString) value).getString());        return array;    } else if (value instanceof COSArray) {        return COSArrayList.convertCOSStringCOSArrayToList((COSArray) value);    }    return Collections.emptyList();}
public void pdfbox_f6743_0(List<String> values)
{    COSArray cosValues;    if (values != null && !values.isEmpty()) {        cosValues = COSArrayList.convertStringListToCOSStringCOSArray(values);        getCOSObject().setItem(COSName.OPT, cosValues);    } else {        getCOSObject().removeItem(COSName.OPT);    }}
 void pdfbox_f6744_0() throws IOException
{    List<String> exportValues = getExportValues();    if (exportValues.size() > 0) {                try {            int optionsIndex = Integer.parseInt(getValue());            if (optionsIndex < exportValues.size()) {                updateByOption(exportValues.get(optionsIndex));            }        } catch (NumberFormatException e) {                        }    } else {        updateByValue(getValue());    }}
public Set<String> pdfbox_f6745_0()
{        Set<String> onValues = new LinkedHashSet<>();    if (getExportValues().size() > 0) {        onValues.addAll(getExportValues());        return onValues;    }    List<PDAnnotationWidget> widgets = this.getWidgets();    for (PDAnnotationWidget widget : widgets) {        onValues.add(getOnValueForWidget(widget));    }    return onValues;}
private String pdfbox_f6746_0(int index)
{    List<PDAnnotationWidget> widgets = this.getWidgets();    if (index < widgets.size()) {        return getOnValueForWidget(widgets.get(index));    }    return "";}
private String pdfbox_f6747_0(PDAnnotationWidget widget)
{    PDAppearanceDictionary apDictionary = widget.getAppearance();    if (apDictionary != null) {        PDAppearanceEntry normalAppearance = apDictionary.getNormalAppearance();        if (normalAppearance != null) {            Set<COSName> entries = normalAppearance.getSubDictionary().keySet();            for (COSName entry : entries) {                if (COSName.Off.compareTo(entry) != 0) {                    return entry.getName();                }            }        }    }    return "";}
 void pdfbox_f6748_0(String value) throws IllegalArgumentException
{    Set<String> onValues = getOnValues();    if (COSName.Off.getName().compareTo(value) != 0 && !onValues.contains(value)) {        throw new IllegalArgumentException("value '" + value + "' is not a valid option for the field " + getFullyQualifiedName() + ", valid values are: " + onValues + " and " + COSName.Off.getName());    }}
private void pdfbox_f6749_0(String value)
{    getCOSObject().setName(COSName.V, value);        for (PDAnnotationWidget widget : getWidgets()) {        if (widget.getAppearance() == null) {            continue;        }        PDAppearanceEntry appearanceEntry = widget.getAppearance().getNormalAppearance();        if (appearanceEntry.getCOSObject().containsKey(value)) {            widget.setAppearanceState(value);        } else {            widget.setAppearanceState(COSName.Off.getName());        }    }}
private void pdfbox_f6750_0(String value)
{    List<PDAnnotationWidget> widgets = getWidgets();    List<String> options = getExportValues();    if (widgets.size() != options.size()) {        throw new IllegalArgumentException("The number of options doesn't match the number of widgets");    }    if (value.equals(COSName.Off.getName())) {        updateByValue(value);    } else {                int optionsIndex = options.indexOf(value);                if (optionsIndex != -1) {            updateByValue(getOnValue(optionsIndex));        }    }}
public boolean pdfbox_f6751_0()
{    return getValue().compareTo(getOnValue()) == 0;}
public void pdfbox_f6752_0() throws IOException
{    setValue(getOnValue());}
public void pdfbox_f6753_0() throws IOException
{    setValue(COSName.Off.getName());}
public String pdfbox_f6754_0()
{    PDAnnotationWidget widget = this.getWidgets().get(0);    PDAppearanceDictionary apDictionary = widget.getAppearance();    String onValue = "";    if (apDictionary != null) {        PDAppearanceEntry normalAppearance = apDictionary.getNormalAppearance();        if (normalAppearance != null) {            Set<COSName> entries = normalAppearance.getSubDictionary().keySet();            for (COSName entry : entries) {                if (COSName.Off.compareTo(entry) != 0) {                    onValue = entry.getName();                }            }        }    }    return onValue;}
public List<String> pdfbox_f6755_0()
{    COSBase values = getCOSObject().getDictionaryObject(COSName.OPT);    return FieldUtils.getPairableItems(values, 0);}
public void pdfbox_f6756_0(List<String> displayValues)
{    if (displayValues != null && !displayValues.isEmpty()) {        if (isSort()) {            Collections.sort(displayValues);        }        getCOSObject().setItem(COSName.OPT, COSArrayList.convertStringListToCOSStringCOSArray(displayValues));    } else {        getCOSObject().removeItem(COSName.OPT);    }}
public void pdfbox_f6757_0(List<String> exportValues, List<String> displayValues)
{    if (exportValues != null && displayValues != null && !exportValues.isEmpty() && !displayValues.isEmpty()) {        if (exportValues.size() != displayValues.size()) {            throw new IllegalArgumentException("The number of entries for exportValue and displayValue shall be the same.");        } else {            List<KeyValue> keyValuePairs = FieldUtils.toKeyValueList(exportValues, displayValues);            if (isSort()) {                FieldUtils.sortByValue(keyValuePairs);            }            COSArray options = new COSArray();            for (int i = 0; i < exportValues.size(); i++) {                COSArray entry = new COSArray();                entry.add(new COSString(keyValuePairs.get(i).getKey()));                entry.add(new COSString(keyValuePairs.get(i).getValue()));                options.add(entry);            }            getCOSObject().setItem(COSName.OPT, options);        }    } else {        getCOSObject().removeItem(COSName.OPT);    }}
public List<String> pdfbox_f6758_0()
{    COSBase values = getCOSObject().getDictionaryObject(COSName.OPT);    return FieldUtils.getPairableItems(values, 1);}
public List<String> pdfbox_f6759_0()
{    return getOptions();}
public List<Integer> pdfbox_f6760_0()
{    COSBase value = getCOSObject().getDictionaryObject(COSName.I);    if (value instanceof COSArray) {        return COSArrayList.convertIntegerCOSArrayToList((COSArray) value);    }    return Collections.emptyList();}
public void pdfbox_f6761_0(List<Integer> values)
{    if (values != null && !values.isEmpty()) {        if (!isMultiSelect()) {            throw new IllegalArgumentException("Setting the indices is not allowed for choice fields not allowing multiple selections.");        }        getCOSObject().setItem(COSName.I, COSArrayList.converterToCOSArray(values));    } else {        getCOSObject().removeItem(COSName.I);    }}
public boolean pdfbox_f6762_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_SORT);}
public void pdfbox_f6763_0(boolean sort)
{    getCOSObject().setFlag(COSName.FF, FLAG_SORT, sort);}
public boolean pdfbox_f6764_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_MULTI_SELECT);}
public void pdfbox_f6765_0(boolean multiSelect)
{    getCOSObject().setFlag(COSName.FF, FLAG_MULTI_SELECT, multiSelect);}
public boolean pdfbox_f6766_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_DO_NOT_SPELL_CHECK);}
public void pdfbox_f6767_0(boolean doNotSpellCheck)
{    getCOSObject().setFlag(COSName.FF, FLAG_DO_NOT_SPELL_CHECK, doNotSpellCheck);}
public boolean pdfbox_f6768_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_COMMIT_ON_SEL_CHANGE);}
public void pdfbox_f6769_0(boolean commitOnSelChange)
{    getCOSObject().setFlag(COSName.FF, FLAG_COMMIT_ON_SEL_CHANGE, commitOnSelChange);}
public boolean pdfbox_f6770_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_COMBO);}
public void pdfbox_f6771_0(boolean combo)
{    getCOSObject().setFlag(COSName.FF, FLAG_COMBO, combo);}
public void pdfbox_f6772_0(String value) throws IOException
{    getCOSObject().setString(COSName.V, value);        setSelectedOptionsIndex(null);    applyChange();}
public void pdfbox_f6773_0(String value)
{    getCOSObject().setString(COSName.DV, value);}
public void pdfbox_f6774_0(List<String> values) throws IOException
{    if (values != null && !values.isEmpty()) {        if (!isMultiSelect()) {            throw new IllegalArgumentException("The list box does not allow multiple selections.");        }        if (!getOptions().containsAll(values)) {            throw new IllegalArgumentException("The values are not contained in the selectable options.");        }        getCOSObject().setItem(COSName.V, COSArrayList.convertStringListToCOSStringCOSArray(values));        updateSelectedOptionsIndex(values);    } else {        getCOSObject().removeItem(COSName.V);        getCOSObject().removeItem(COSName.I);    }    applyChange();}
public List<String> pdfbox_f6775_0()
{    return getValueFor(COSName.V);}
public List<String> pdfbox_f6776_0()
{    return getValueFor(COSName.DV);}
private List<String> pdfbox_f6777_0(COSName name)
{    COSBase value = getCOSObject().getDictionaryObject(name);    if (value instanceof COSString) {        List<String> array = new ArrayList<>();        array.add(((COSString) value).getString());        return array;    } else if (value instanceof COSArray) {        return COSArrayList.convertCOSStringCOSArrayToList((COSArray) value);    }    return Collections.emptyList();}
public String pdfbox_f6778_0()
{    return Arrays.toString(getValue().toArray());}
private void pdfbox_f6779_0(List<String> values)
{    List<String> options = getOptions();    List<Integer> indices = new ArrayList<>();    for (String value : values) {        indices.add(options.indexOf(value));    }        Collections.sort(indices);    setSelectedOptionsIndex(indices);}
public boolean pdfbox_f6780_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_EDIT);}
public void pdfbox_f6781_0(boolean edit)
{    getCOSObject().setFlag(COSName.FF, FLAG_EDIT, edit);}
 void pdfbox_f6782_0() throws IOException
{    AppearanceGeneratorHelper apHelper;    apHelper = new AppearanceGeneratorHelper(this);    List<String> values = getValue();    if (!values.isEmpty()) {        apHelper.setAppearanceValue(values.get(0));    } else {        apHelper.setAppearanceValue("");    }}
private void pdfbox_f6783_0(byte[] content) throws IOException
{    List<COSBase> arguments = new ArrayList<>();    PDFStreamParser parser = new PDFStreamParser(content);    Object token = parser.parseNextToken();    while (token != null) {        if (token instanceof COSObject) {            arguments.add(((COSObject) token).getObject());        } else if (token instanceof Operator) {            processOperator((Operator) token, arguments);            arguments = new ArrayList<>();        } else {            arguments.add((COSBase) token);        }        token = parser.parseNextToken();    }}
private void pdfbox_f6784_0(Operator operator, List<COSBase> operands) throws IOException
{    switch(operator.getName()) {        case OperatorName.SET_FONT_AND_SIZE:            processSetFont(operands);            break;        case OperatorName.NON_STROKING_GRAY:        case OperatorName.NON_STROKING_RGB:        case OperatorName.NON_STROKING_CMYK:            processSetFontColor(operands);            break;        default:            break;    }}
private void pdfbox_f6785_0(List<COSBase> operands) throws IOException
{    if (operands.size() < 2) {        throw new IOException("Missing operands for set font operator " + Arrays.toString(operands.toArray()));    }    COSBase base0 = operands.get(0);    COSBase base1 = operands.get(1);    if (!(base0 instanceof COSName)) {        return;    }    if (!(base1 instanceof COSNumber)) {        return;    }    COSName fontName = (COSName) base0;    PDFont font = defaultResources.getFont(fontName);    float fontSize = ((COSNumber) base1).floatValue();        if (font == null) {        throw new IOException("Could not find font: /" + fontName.getName());    }    setFontName(fontName);    setFont(font);    setFontSize(fontSize);}
private void pdfbox_f6786_0(List<COSBase> operands) throws IOException
{    PDColorSpace colorSpace;    switch(operands.size()) {        case 1:            colorSpace = PDDeviceGray.INSTANCE;            break;        case 3:            colorSpace = PDDeviceRGB.INSTANCE;            break;        case 4:            colorSpace = PDDeviceCMYK.INSTANCE;            break;        default:            throw new IOException("Missing operands for set non stroking color operator " + Arrays.toString(operands.toArray()));    }    COSArray array = new COSArray();    array.addAll(operands);    setFontColor(new PDColor(array, colorSpace));}
 COSName pdfbox_f6787_0()
{    return fontName;}
 void pdfbox_f6788_0(COSName fontName)
{    this.fontName = fontName;}
 PDFont pdfbox_f6789_0() throws IOException
{    return font;}
 void pdfbox_f6790_0(PDFont font)
{    this.font = font;}
public float pdfbox_f6791_0()
{    return fontSize;}
 void pdfbox_f6792_0(float fontSize)
{    this.fontSize = fontSize;}
 PDColor pdfbox_f6793_0()
{    return fontColor;}
 void pdfbox_f6794_0(PDColor fontColor)
{    this.fontColor = fontColor;}
 void pdfbox_f6795_0(PDAppearanceContentStream contents, float zeroFontSize) throws IOException
{    float fontSize = getFontSize();    if (Float.compare(fontSize, 0) == 0) {        fontSize = zeroFontSize;    }    contents.setFont(getFont(), fontSize);    if (getFontColor() != null) {        contents.setNonStrokingColor(getFontColor());    }}
 void pdfbox_f6796_0(PDAppearanceStream appearanceStream) throws IOException
{        PDResources streamResources = appearanceStream.getResources();    if (streamResources == null) {        streamResources = new PDResources();        appearanceStream.setResources(streamResources);    }    if (streamResources.getFont(fontName) == null) {        streamResources.put(fontName, getFont());    }}
 static PDField pdfbox_f6797_0(PDAcroForm form, COSDictionary field, PDNonTerminalField parent)
{    return PDFieldFactory.createField(form, field, parent);}
protected COSBase pdfbox_f6798_0(COSName key)
{    if (dictionary.containsKey(key)) {        return dictionary.getDictionaryObject(key);    } else if (parent != null) {        return parent.getInheritableAttribute(key);    } else {        return acroForm.getCOSObject().getDictionaryObject(key);    }}
public void pdfbox_f6799_0(boolean readonly)
{    dictionary.setFlag(COSName.FF, FLAG_READ_ONLY, readonly);}
public boolean pdfbox_f6800_0()
{    return dictionary.getFlag(COSName.FF, FLAG_READ_ONLY);}
public void pdfbox_f6801_0(boolean required)
{    dictionary.setFlag(COSName.FF, FLAG_REQUIRED, required);}
public boolean pdfbox_f6802_0()
{    return dictionary.getFlag(COSName.FF, FLAG_REQUIRED);}
public void pdfbox_f6803_0(boolean noExport)
{    dictionary.setFlag(COSName.FF, FLAG_NO_EXPORT, noExport);}
public boolean pdfbox_f6804_0()
{    return dictionary.getFlag(COSName.FF, FLAG_NO_EXPORT);}
public void pdfbox_f6805_0(int flags)
{    dictionary.setInt(COSName.FF, flags);}
public PDFormFieldAdditionalActions pdfbox_f6806_0()
{    COSDictionary aa = (COSDictionary) dictionary.getDictionaryObject(COSName.AA);    if (aa != null) {        return new PDFormFieldAdditionalActions(aa);    }    return null;}
 void pdfbox_f6807_0(FDFField fdfField) throws IOException
{    COSBase fieldValue = fdfField.getCOSValue();    if (fieldValue != null && this instanceof PDTerminalField) {        PDTerminalField currentField = (PDTerminalField) this;        if (fieldValue instanceof COSName) {            currentField.setValue(((COSName) fieldValue).getName());        } else if (fieldValue instanceof COSString) {            currentField.setValue(((COSString) fieldValue).getString());        } else if (fieldValue instanceof COSStream) {            currentField.setValue(((COSStream) fieldValue).toTextString());        } else if (fieldValue instanceof COSArray && this instanceof PDChoice) {            ((PDChoice) this).setValue(COSArrayList.convertCOSStringCOSArrayToList((COSArray) fieldValue));        } else {            throw new IOException("Error:Unknown type for field import" + fieldValue);        }    } else if (fieldValue != null) {        dictionary.setItem(COSName.V, fieldValue);    }    Integer ff = fdfField.getFieldFlags();    if (ff != null) {        setFieldFlags(ff);    } else {                Integer setFf = fdfField.getSetFieldFlags();        int fieldFlags = getFieldFlags();        if (setFf != null) {            int setFfInt = setFf;            fieldFlags = fieldFlags | setFfInt;            setFieldFlags(fieldFlags);        }        Integer clrFf = fdfField.getClearFieldFlags();        if (clrFf != null) {                                                                                                            int clrFfValue = clrFf;            clrFfValue ^= 0xFFFFFFFF;            fieldFlags = fieldFlags & clrFfValue;            setFieldFlags(fieldFlags);        }    }}
public PDNonTerminalField pdfbox_f6808_0()
{    return parent;}
 PDField pdfbox_f6809_0(String[] name, int nameIndex)
{    PDField retval = null;    COSArray kids = (COSArray) dictionary.getDictionaryObject(COSName.KIDS);    if (kids != null) {        for (int i = 0; retval == null && i < kids.size(); i++) {            COSDictionary kidDictionary = (COSDictionary) kids.getObject(i);            if (name[nameIndex].equals(kidDictionary.getString(COSName.T))) {                retval = PDField.fromDictionary(acroForm, kidDictionary, (PDNonTerminalField) this);                if (retval != null && name.length > nameIndex + 1) {                    retval = retval.findKid(name, nameIndex + 1);                }            }        }    }    return retval;}
public PDAcroForm pdfbox_f6810_0()
{    return acroForm;}
public COSDictionary pdfbox_f6811_0()
{    return dictionary;}
public String pdfbox_f6812_0()
{    return dictionary.getString(COSName.T);}
public void pdfbox_f6813_0(String name)
{    dictionary.setString(COSName.T, name);}
public String pdfbox_f6814_0()
{    String finalName = getPartialName();    String parentName = parent != null ? parent.getFullyQualifiedName() : null;    if (parentName != null) {        if (finalName != null) {            finalName = parentName + "." + finalName;        } else {            finalName = parentName;        }    }    return finalName;}
public String pdfbox_f6815_0()
{    return dictionary.getString(COSName.TU);}
public void pdfbox_f6816_0(String alternateFieldName)
{    dictionary.setString(COSName.TU, alternateFieldName);}
public String pdfbox_f6817_0()
{    return dictionary.getString(COSName.TM);}
public void pdfbox_f6818_0(String mappingName)
{    dictionary.setString(COSName.TM, mappingName);}
public String pdfbox_f6819_0()
{    return getFullyQualifiedName() + "{type: " + getClass().getSimpleName() + " value: " + getInheritableAttribute(COSName.V) + "}";}
 static PDField pdfbox_f6820_0(PDAcroForm form, COSDictionary field, PDNonTerminalField parent)
{    String fieldType = findFieldType(field);        if (field.containsKey(COSName.KIDS)) {        COSArray kids = (COSArray) field.getDictionaryObject(COSName.KIDS);        if (kids != null && kids.size() > 0) {            for (int i = 0; i < kids.size(); i++) {                COSBase kid = kids.getObject(i);                if (kid instanceof COSDictionary && ((COSDictionary) kid).getString(COSName.T) != null) {                    return new PDNonTerminalField(form, field, parent);                }            }        }    }    if (FIELD_TYPE_CHOICE.equals(fieldType)) {        return createChoiceSubType(form, field, parent);    } else if (FIELD_TYPE_TEXT.equals(fieldType)) {        return new PDTextField(form, field, parent);    } else if (FIELD_TYPE_SIGNATURE.equals(fieldType)) {        return new PDSignatureField(form, field, parent);    } else if (FIELD_TYPE_BUTTON.equals(fieldType)) {        return createButtonSubType(form, field, parent);    } else {                return null;    }}
private static PDField pdfbox_f6821_0(PDAcroForm form, COSDictionary field, PDNonTerminalField parent)
{    int flags = field.getInt(COSName.FF, 0);    if ((flags & PDChoice.FLAG_COMBO) != 0) {        return new PDComboBox(form, field, parent);    } else {        return new PDListBox(form, field, parent);    }}
private static PDField pdfbox_f6822_0(PDAcroForm form, COSDictionary field, PDNonTerminalField parent)
{    int flags = field.getInt(COSName.FF, 0);        if ((flags & PDButton.FLAG_RADIO) != 0) {        return new PDRadioButton(form, field, parent);    } else if ((flags & PDButton.FLAG_PUSHBUTTON) != 0) {        return new PDPushButton(form, field, parent);    } else {        return new PDCheckBox(form, field, parent);    }}
private static String pdfbox_f6823_0(COSDictionary dic)
{    String retval = dic.getNameAsString(COSName.FT);    if (retval == null) {        COSBase base = dic.getDictionaryObject(COSName.PARENT, COSName.P);        if (base instanceof COSDictionary) {            retval = findFieldType((COSDictionary) base);        }    }    return retval;}
public Iterator<PDField> pdfbox_f6824_0()
{    return new FieldIterator(acroForm);}
public boolean pdfbox_f6825_0()
{    return !queue.isEmpty();}
public PDField pdfbox_f6826_0()
{    if (!hasNext()) {        throw new NoSuchElementException();    }    return queue.poll();}
public void pdfbox_f6827_0()
{    throw new UnsupportedOperationException();}
private void pdfbox_f6828_0(PDField node)
{    queue.add(node);    if (node instanceof PDNonTerminalField) {        List<PDField> kids = ((PDNonTerminalField) node).getChildren();        for (PDField kid : kids) {            enqueueKids(kid);        }    }}
public int pdfbox_f6829_0()
{    return getCOSObject().getInt(COSName.TI, 0);}
public void pdfbox_f6830_0(Integer topIndex)
{    if (topIndex != null) {        getCOSObject().setInt(COSName.TI, topIndex);    } else {        getCOSObject().removeItem(COSName.TI);    }}
 void pdfbox_f6831_0() throws IOException
{    AppearanceGeneratorHelper apHelper;    apHelper = new AppearanceGeneratorHelper(this);    apHelper.setAppearanceValue("");}
public int pdfbox_f6832_0()
{    int retval = 0;    COSInteger ff = (COSInteger) getCOSObject().getDictionaryObject(COSName.FF);    if (ff != null) {        retval = ff.intValue();    }        return retval;}
 void pdfbox_f6833_0(FDFField fdfField) throws IOException
{    super.importFDF(fdfField);    List<FDFField> fdfKids = fdfField.getKids();    List<PDField> children = getChildren();    for (int i = 0; fdfKids != null && i < fdfKids.size(); i++) {        for (COSObjectable pdKid : children) {            if (pdKid instanceof PDField) {                PDField pdChild = (PDField) pdKid;                FDFField fdfChild = fdfKids.get(i);                String fdfName = fdfChild.getPartialFieldName();                if (fdfName != null && fdfName.equals(pdChild.getPartialName())) {                    pdChild.importFDF(fdfChild);                }            }        }    }}
 FDFField pdfbox_f6834_0() throws IOException
{    FDFField fdfField = new FDFField();    fdfField.setPartialFieldName(getPartialName());    fdfField.setValue(getValue());    List<PDField> children = getChildren();    List<FDFField> fdfChildren = new ArrayList<>();    for (PDField child : children) {        fdfChildren.add(child.exportFDF());    }    fdfField.setKids(fdfChildren);    return fdfField;}
public List<PDField> pdfbox_f6835_1()
{        List<PDField> children = new ArrayList<>();    COSArray kids = (COSArray) getCOSObject().getDictionaryObject(COSName.KIDS);    for (int i = 0; i < kids.size(); i++) {        COSBase kid = kids.getObject(i);        if (kid instanceof COSDictionary) {            if (kid.getCOSObject() == this.getCOSObject()) {                                continue;            }            PDField field = PDField.fromDictionary(getAcroForm(), (COSDictionary) kid, this);            if (field != null) {                children.add(field);            }        }    }    return children;}
public void pdfbox_f6836_0(List<PDField> children)
{    COSArray kidsArray = COSArrayList.converterToCOSArray(children);    getCOSObject().setItem(COSName.KIDS, kidsArray);}
public String pdfbox_f6837_0()
{    return getCOSObject().getNameAsString(COSName.FT);}
public COSBase pdfbox_f6838_0()
{    return getCOSObject().getDictionaryObject(COSName.V);}
public String pdfbox_f6839_0()
{    COSBase fieldValue = getCOSObject().getDictionaryObject(COSName.V);    return fieldValue != null ? fieldValue.toString() : "";}
public void pdfbox_f6840_0(COSBase object) throws IOException
{    getCOSObject().setItem(COSName.V, object);}
public void pdfbox_f6841_0(String value) throws IOException
{    getCOSObject().setString(COSName.V, value);}
public COSBase pdfbox_f6842_0()
{    return getCOSObject().getDictionaryObject(COSName.DV);}
public void pdfbox_f6843_0(COSBase value)
{    getCOSObject().setItem(COSName.V, value);}
public List<PDAnnotationWidget> pdfbox_f6844_0()
{    List<PDAnnotationWidget> emptyList = Collections.emptyList();    return Collections.unmodifiableList(emptyList);}
public List<String> pdfbox_f6845_0()
{    return Collections.emptyList();}
public void pdfbox_f6846_0(List<String> values)
{    if (values != null && !values.isEmpty()) {        throw new IllegalArgumentException("A PDPushButton shall not use the Opt entry in the field dictionary");    }}
public String pdfbox_f6847_0()
{    return "";}
public String pdfbox_f6848_0()
{    return "";}
public String pdfbox_f6849_0()
{    return getValue();}
public void pdfbox_f6851_0(boolean radiosInUnison)
{    getCOSObject().setFlag(COSName.FF, FLAG_RADIOS_IN_UNISON, radiosInUnison);}
public boolean pdfbox_f6852_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_RADIOS_IN_UNISON);}
public List<String> pdfbox_f6853_0()
{    Set<String> onValues = getOnValues();    List<String> exportValues = getExportValues();    List<String> selectedExportValues = new ArrayList<>();    if (exportValues.isEmpty()) {        selectedExportValues.add(getValue());        return selectedExportValues;    } else {        String fieldValue = getValue();        int idx = 0;        for (String onValue : onValues) {            if (onValue.compareTo(fieldValue) == 0) {                selectedExportValues.add(exportValues.get(idx));            }        }        return selectedExportValues;    }}
private String pdfbox_f6854_0()
{    String fieldName = "Signature";    Set<String> sigNames = new HashSet<>();    for (PDField field : getAcroForm().getFieldTree()) {        if (field instanceof PDSignatureField) {            sigNames.add(field.getPartialName());        }    }    int i = 1;    while (sigNames.contains(fieldName + i)) {        ++i;    }    return fieldName + i;}
public void pdfbox_f6855_0(PDSignature value) throws IOException
{    setValue(value);}
public PDSignature pdfbox_f6856_0()
{    return getValue();}
public void pdfbox_f6857_0(PDSignature value) throws IOException
{    getCOSObject().setItem(COSName.V, value);    applyChange();}
public void pdfbox_f6858_0(String value) throws UnsupportedOperationException
{    throw new UnsupportedOperationException("Signature fields don't support setting the value as String " + "- use setValue(PDSignature value) instead");}
public void pdfbox_f6859_0(PDSignature value)
{    getCOSObject().setItem(COSName.DV, value);}
public PDSignature pdfbox_f6860_0()
{    COSBase value = getCOSObject().getDictionaryObject(COSName.V);    if (value instanceof COSDictionary) {        return new PDSignature((COSDictionary) value);    }    return null;}
public PDSignature pdfbox_f6861_0()
{    COSBase value = getCOSObject().getDictionaryObject(COSName.DV);    if (value == null) {        return null;    }    return new PDSignature((COSDictionary) value);}
public String pdfbox_f6862_0()
{    PDSignature signature = getValue();    return signature != null ? signature.toString() : "";}
public PDSeedValue pdfbox_f6863_0()
{    COSDictionary dict = (COSDictionary) getCOSObject().getDictionaryObject(COSName.SV);    PDSeedValue sv = null;    if (dict != null) {        sv = new PDSeedValue(dict);    }    return sv;}
public void pdfbox_f6864_0(PDSeedValue sv)
{    if (sv != null) {        getCOSObject().setItem(COSName.SV, sv);    }}
 void pdfbox_f6865_1() throws IOException
{    PDAnnotationWidget widget = this.getWidgets().get(0);    if (widget != null) {                if (widget.getRectangle() == null || Float.compare(widget.getRectangle().getHeight(), 0) == 0 && Float.compare(widget.getRectangle().getWidth(), 0) == 0 || widget.isNoView() || widget.isHidden()) {            return;        }                    }}
public void pdfbox_f6866_0(PDFormFieldAdditionalActions actions)
{    getCOSObject().setItem(COSName.AA, actions);}
public int pdfbox_f6867_0()
{    int retval = 0;    COSInteger ff = (COSInteger) getCOSObject().getDictionaryObject(COSName.FF);    if (ff != null) {        retval = ff.intValue();    } else if (getParent() != null) {        retval = getParent().getFieldFlags();    }    return retval;}
public String pdfbox_f6868_0()
{    String fieldType = getCOSObject().getNameAsString(COSName.FT);    if (fieldType == null && getParent() != null) {        fieldType = getParent().getFieldType();    }    return fieldType;}
public void pdfbox_f6869_0(FDFField fdfField) throws IOException
{    super.importFDF(fdfField);        PDAnnotationWidget widget = getWidgets().get(0);    if (widget != null) {        int annotFlags = widget.getAnnotationFlags();        Integer f = fdfField.getWidgetFieldFlags();        if (f != null) {            widget.setAnnotationFlags(f);        } else {                        Integer setF = fdfField.getSetWidgetFieldFlags();            if (setF != null) {                annotFlags = annotFlags | setF;                widget.setAnnotationFlags(annotFlags);            }            Integer clrF = fdfField.getClearWidgetFieldFlags();            if (clrF != null) {                                                                                                                                                int clrFValue = clrF;                clrFValue ^= 0xFFFFFFFFL;                annotFlags = annotFlags & clrFValue;                widget.setAnnotationFlags(annotFlags);            }        }    }}
 FDFField pdfbox_f6870_0() throws IOException
{    FDFField fdfField = new FDFField();    fdfField.setPartialFieldName(getPartialName());    fdfField.setValue(getCOSObject().getDictionaryObject(COSName.V));    return fdfField;}
public List<PDAnnotationWidget> pdfbox_f6871_0()
{    List<PDAnnotationWidget> widgets = new ArrayList<>();    COSArray kids = (COSArray) getCOSObject().getDictionaryObject(COSName.KIDS);    if (kids == null) {                widgets.add(new PDAnnotationWidget(getCOSObject()));    } else if (kids.size() > 0) {                for (int i = 0; i < kids.size(); i++) {            COSBase kid = kids.getObject(i);            if (kid instanceof COSDictionary) {                widgets.add(new PDAnnotationWidget((COSDictionary) kid));            }        }    }    return widgets;}
public void pdfbox_f6872_0(List<PDAnnotationWidget> children)
{    COSArray kidsArray = COSArrayList.converterToCOSArray(children);    getCOSObject().setItem(COSName.KIDS, kidsArray);    for (PDAnnotationWidget widget : children) {        widget.getCOSObject().setItem(COSName.PARENT, this);    }}
public PDAnnotationWidget pdfbox_f6873_0()
{    return getWidgets().get(0);}
protected final void pdfbox_f6874_0() throws IOException
{    constructAppearances();}
public boolean pdfbox_f6875_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_MULTILINE);}
public void pdfbox_f6876_0(boolean multiline)
{    getCOSObject().setFlag(COSName.FF, FLAG_MULTILINE, multiline);}
public boolean pdfbox_f6877_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_PASSWORD);}
public void pdfbox_f6878_0(boolean password)
{    getCOSObject().setFlag(COSName.FF, FLAG_PASSWORD, password);}
public boolean pdfbox_f6879_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_FILE_SELECT);}
public void pdfbox_f6880_0(boolean fileSelect)
{    getCOSObject().setFlag(COSName.FF, FLAG_FILE_SELECT, fileSelect);}
public boolean pdfbox_f6881_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_DO_NOT_SPELL_CHECK);}
public void pdfbox_f6882_0(boolean doNotSpellCheck)
{    getCOSObject().setFlag(COSName.FF, FLAG_DO_NOT_SPELL_CHECK, doNotSpellCheck);}
public boolean pdfbox_f6883_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_DO_NOT_SCROLL);}
public void pdfbox_f6884_0(boolean doNotScroll)
{    getCOSObject().setFlag(COSName.FF, FLAG_DO_NOT_SCROLL, doNotScroll);}
public boolean pdfbox_f6885_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_COMB);}
public void pdfbox_f6886_0(boolean comb)
{    getCOSObject().setFlag(COSName.FF, FLAG_COMB, comb);}
public boolean pdfbox_f6887_0()
{    return getCOSObject().getFlag(COSName.FF, FLAG_RICH_TEXT);}
public void pdfbox_f6888_0(boolean richText)
{    getCOSObject().setFlag(COSName.FF, FLAG_RICH_TEXT, richText);}
public int pdfbox_f6889_0()
{    return getCOSObject().getInt(COSName.MAX_LEN);}
public void pdfbox_f6890_0(int maxLen)
{    getCOSObject().setInt(COSName.MAX_LEN, maxLen);}
public void pdfbox_f6891_0(String value) throws IOException
{    getCOSObject().setString(COSName.V, value);    applyChange();}
public void pdfbox_f6892_0(String value)
{    getCOSObject().setString(COSName.DV, value);}
public String pdfbox_f6893_0()
{    return getStringOrStream(getInheritableAttribute(COSName.V));}
public String pdfbox_f6894_0()
{    return getStringOrStream(getInheritableAttribute(COSName.DV));}
public String pdfbox_f6895_0()
{    return getValue();}
 void pdfbox_f6896_0() throws IOException
{    AppearanceGeneratorHelper apHelper;    apHelper = new AppearanceGeneratorHelper(this);    apHelper.setAppearanceValue(getValue());}
public String pdfbox_f6897_0()
{    COSString defaultAppearance = (COSString) getInheritableAttribute(COSName.DA);    return defaultAppearance.getString();}
 PDDefaultAppearanceString pdfbox_f6898_0() throws IOException
{    COSString da = (COSString) getInheritableAttribute(COSName.DA);    PDResources dr = getAcroForm().getDefaultResources();    return new PDDefaultAppearanceString(da, dr);}
public void pdfbox_f6899_0(String daValue)
{    getCOSObject().setString(COSName.DA, daValue);}
public String pdfbox_f6900_0()
{    COSString defaultStyleString = (COSString) getCOSObject().getDictionaryObject(COSName.DS);    return defaultStyleString.getString();}
public void pdfbox_f6901_0(String defaultStyleString)
{    if (defaultStyleString != null) {        getCOSObject().setItem(COSName.DS, new COSString(defaultStyleString));    } else {        getCOSObject().removeItem(COSName.DS);    }}
public int pdfbox_f6902_0()
{    int retval = 0;    COSNumber number = (COSNumber) getInheritableAttribute(COSName.Q);    if (number != null) {        retval = number.intValue();    }    return retval;}
public void pdfbox_f6903_0(int q)
{    getCOSObject().setInt(COSName.Q, q);}
public String pdfbox_f6904_0()
{    return getStringOrStream(getInheritableAttribute(COSName.RV));}
public void pdfbox_f6905_0(String richTextValue)
{    if (richTextValue != null) {        getCOSObject().setItem(COSName.RV, new COSString(richTextValue));    } else {        getCOSObject().removeItem(COSName.RV);    }}
protected final String pdfbox_f6906_0(COSBase base)
{    if (base instanceof COSString) {        return ((COSString) base).getString();    } else if (base instanceof COSStream) {        return ((COSStream) base).toTextString();    }    return "";}
public COSBase pdfbox_f6907_0()
{    return xfa;}
public byte[] pdfbox_f6908_0() throws IOException
{        if (this.getCOSObject() instanceof COSArray) {        return getBytesFromPacket((COSArray) this.getCOSObject());    } else if (xfa.getCOSObject() instanceof COSStream) {        return getBytesFromStream((COSStream) this.getCOSObject());    }    return new byte[0];}
private static byte[] pdfbox_f6909_0(final COSArray cosArray) throws IOException
{    try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {        for (int i = 1; i < cosArray.size(); i += 2) {            COSBase cosObj = cosArray.getObject(i);            if (cosObj instanceof COSStream) {                baos.write(getBytesFromStream((COSStream) cosObj.getCOSObject()));            }        }        return baos.toByteArray();    }}
private static byte[] pdfbox_f6910_0(final COSStream stream) throws IOException
{    try (final InputStream is = stream.createInputStream()) {        return IOUtils.toByteArray(is);    }}
public Document pdfbox_f6911_0() throws IOException
{    return     org.apache.pdfbox.util.XMLUtil.parse(new ByteArrayInputStream(this.getBytes()), true);}
 List<Paragraph> pdfbox_f6912_0()
{    return paragraphs;}
 String pdfbox_f6913_0()
{    return textContent;}
 List<Line> pdfbox_f6914_0(PDFont font, float fontSize, float width) throws IOException
{    BreakIterator iterator = BreakIterator.getLineInstance();    iterator.setText(textContent);    final float scale = fontSize / FONTSCALE;    int start = iterator.first();    int end = iterator.next();    float lineWidth = 0;    List<Line> textLines = new ArrayList<>();    Line textLine = new Line();    while (end != BreakIterator.DONE) {        String word = textContent.substring(start, end);        float wordWidth = font.getStringWidth(word) * scale;        lineWidth = lineWidth + wordWidth;                if (lineWidth >= width && Character.isWhitespace(word.charAt(word.length() - 1))) {            float whitespaceWidth = font.getStringWidth(word.substring(word.length() - 1)) * scale;            lineWidth = lineWidth - whitespaceWidth;        }        if (lineWidth >= width) {            textLine.setWidth(textLine.calculateWidth(font, fontSize));            textLines.add(textLine);            textLine = new Line();            lineWidth = font.getStringWidth(word) * scale;        }        AttributedString as = new AttributedString(word);        as.addAttribute(TextAttribute.WIDTH, wordWidth);        Word wordInstance = new Word(word);        wordInstance.setAttributes(as);        textLine.addWord(wordInstance);        start = end;        end = iterator.next();    }    textLine.setWidth(textLine.calculateWidth(font, fontSize));    textLines.add(textLine);    return textLines;}
 float pdfbox_f6915_0()
{    return lineWidth;}
 void pdfbox_f6916_0(float width)
{    lineWidth = width;}
 float pdfbox_f6917_0(PDFont font, float fontSize) throws IOException
{    final float scale = fontSize / FONTSCALE;    float calculatedWidth = 0f;    for (Word word : words) {        calculatedWidth = calculatedWidth + (Float) word.getAttributes().getIterator().getAttribute(TextAttribute.WIDTH);        String text = word.getText();        if (words.indexOf(word) == words.size() - 1 && Character.isWhitespace(text.charAt(text.length() - 1))) {            float whitespaceWidth = font.getStringWidth(text.substring(text.length() - 1)) * scale;            calculatedWidth = calculatedWidth - whitespaceWidth;        }    }    return calculatedWidth;}
 List<Word> pdfbox_f6918_0()
{    return words;}
 float pdfbox_f6919_0(float width)
{    return (width - lineWidth) / (words.size() - 1);}
 void pdfbox_f6920_0(Word word)
{    words.add(word);}
 String pdfbox_f6921_0()
{    return textContent;}
 AttributedString pdfbox_f6922_0()
{    return attributedString;}
 void pdfbox_f6923_0(AttributedString as)
{    this.attributedString = as;}
 int pdfbox_f6924_0()
{    return alignment;}
public static TextAlign pdfbox_f6925_0(int alignment)
{    for (TextAlign textAlignment : TextAlign.values()) {        if (textAlignment.getTextAlign() == alignment) {            return textAlignment;        }    }    return TextAlign.LEFT;}
 Builder pdfbox_f6926_0(AppearanceStyle appearanceStyle)
{    this.appearanceStyle = appearanceStyle;    return this;}
 Builder pdfbox_f6927_0(boolean wrapLines)
{    this.wrapLines = wrapLines;    return this;}
 Builder pdfbox_f6928_0(float width)
{    this.width = width;    return this;}
 Builder pdfbox_f6929_0(int alignment)
{    this.textAlignment = TextAlign.valueOf(alignment);    return this;}
 Builder pdfbox_f6930_0(TextAlign alignment)
{    this.textAlignment = alignment;    return this;}
 Builder pdfbox_f6931_0(PlainText textContent)
{    this.textContent = textContent;    return this;}
 Builder pdfbox_f6932_0(float horizontalOffset, float verticalOffset)
{    this.horizontalOffset = horizontalOffset;    this.verticalOffset = verticalOffset;    return this;}
 PlainTextFormatter pdfbox_f6933_0()
{    return new PlainTextFormatter(this);}
public void pdfbox_f6934_0() throws IOException
{    if (textContent != null && !textContent.getParagraphs().isEmpty()) {        boolean isFirstParagraph = true;        for (Paragraph paragraph : textContent.getParagraphs()) {            if (wrapLines) {                List<Line> lines = paragraph.getLines(appearanceStyle.getFont(), appearanceStyle.getFontSize(), width);                processLines(lines, isFirstParagraph);                isFirstParagraph = false;            } else {                float startOffset = 0f;                float lineWidth = appearanceStyle.getFont().getStringWidth(paragraph.getText()) * appearanceStyle.getFontSize() / FONTSCALE;                if (lineWidth < width) {                    switch(textAlignment) {                        case CENTER:                            startOffset = (width - lineWidth) / 2;                            break;                        case RIGHT:                            startOffset = width - lineWidth;                            break;                        case JUSTIFY:                        default:                            startOffset = 0f;                    }                }                contents.newLineAtOffset(horizontalOffset + startOffset, verticalOffset);                contents.showText(paragraph.getText());            }        }    }}
private void pdfbox_f6935_0(List<Line> lines, boolean isFirstParagraph) throws IOException
{    float wordWidth;    float lastPos = 0f;    float startOffset = 0f;    float interWordSpacing = 0f;    for (Line line : lines) {        switch(textAlignment) {            case CENTER:                startOffset = (width - line.getWidth()) / 2;                break;            case RIGHT:                startOffset = width - line.getWidth();                break;            case JUSTIFY:                if (lines.indexOf(line) != lines.size() - 1) {                    interWordSpacing = line.getInterWordSpacing(width);                }                break;            default:                startOffset = 0f;        }        float offset = -lastPos + startOffset + horizontalOffset;        if (lines.indexOf(line) == 0 && isFirstParagraph) {            contents.newLineAtOffset(offset, verticalOffset);        } else {                        verticalOffset = verticalOffset - appearanceStyle.getLeading();            contents.newLineAtOffset(offset, -appearanceStyle.getLeading());        }        lastPos += offset;        List<Word> words = line.getWords();        for (Word word : words) {            contents.showText(word.getText());            wordWidth = (Float) word.getAttributes().getIterator().getAttribute(TextAttribute.WIDTH);            if (words.indexOf(word) != words.size() - 1) {                contents.newLineAtOffset(wordWidth + interWordSpacing, 0f);                lastPos = lastPos + wordWidth + interWordSpacing;            }        }    }    horizontalOffset = horizontalOffset - lastPos;}
public COSDictionary pdfbox_f6936_0()
{    return this.measureDictionary;}
public String pdfbox_f6937_0()
{    return TYPE;}
public String pdfbox_f6938_0()
{    return this.getCOSObject().getNameAsString(COSName.SUBTYPE, PDRectlinearMeasureDictionary.SUBTYPE);}
protected void pdfbox_f6939_0(String subtype)
{    this.getCOSObject().setName(COSName.SUBTYPE, subtype);}
public COSDictionary pdfbox_f6940_0()
{    return this.numberFormatDictionary;}
public String pdfbox_f6941_0()
{    return TYPE;}
public String pdfbox_f6942_0()
{    return this.getCOSObject().getString("U");}
public void pdfbox_f6943_0(String units)
{    this.getCOSObject().setString("U", units);}
public float pdfbox_f6944_0()
{    return this.getCOSObject().getFloat("C");}
public void pdfbox_f6945_0(float conversionFactor)
{    this.getCOSObject().setFloat("C", conversionFactor);}
public String pdfbox_f6946_0()
{    return this.getCOSObject().getString("F", FRACTIONAL_DISPLAY_DECIMAL);}
public void pdfbox_f6947_0(String fractionalDisplay)
{    if ((fractionalDisplay == null) || FRACTIONAL_DISPLAY_DECIMAL.equals(fractionalDisplay) || FRACTIONAL_DISPLAY_FRACTION.equals(fractionalDisplay) || FRACTIONAL_DISPLAY_ROUND.equals(fractionalDisplay) || FRACTIONAL_DISPLAY_TRUNCATE.equals(fractionalDisplay)) {        this.getCOSObject().setString("F", fractionalDisplay);    } else {        throw new IllegalArgumentException("Value must be \"D\", \"F\", \"R\", or \"T\", (or null).");    }}
public int pdfbox_f6948_0()
{    return this.getCOSObject().getInt("D");}
public void pdfbox_f6949_0(int denominator)
{    this.getCOSObject().setInt("D", denominator);}
public boolean pdfbox_f6950_0()
{    return this.getCOSObject().getBoolean("FD", false);}
public void pdfbox_f6951_0(boolean fd)
{    this.getCOSObject().setBoolean("FD", fd);}
public String pdfbox_f6952_0()
{    return this.getCOSObject().getString("RT", ",");}
public void pdfbox_f6953_0(String thousandsSeparator)
{    this.getCOSObject().setString("RT", thousandsSeparator);}
public String pdfbox_f6954_0()
{    return this.getCOSObject().getString("RD", ".");}
public void pdfbox_f6955_0(String decimalSeparator)
{    this.getCOSObject().setString("RD", decimalSeparator);}
public String pdfbox_f6956_0()
{    return this.getCOSObject().getString("PS", " ");}
public void pdfbox_f6957_0(String labelPrefixString)
{    this.getCOSObject().setString("PS", labelPrefixString);}
public String pdfbox_f6958_0()
{    return this.getCOSObject().getString("SS", " ");}
public void pdfbox_f6959_0(String labelSuffixString)
{    this.getCOSObject().setString("SS", labelSuffixString);}
public String pdfbox_f6960_0()
{    return this.getCOSObject().getString("O", LABEL_SUFFIX_TO_VALUE);}
public void pdfbox_f6961_0(String labelPositionToValue)
{    if ((labelPositionToValue == null) || LABEL_PREFIX_TO_VALUE.equals(labelPositionToValue) || LABEL_SUFFIX_TO_VALUE.equals(labelPositionToValue)) {        this.getCOSObject().setString("O", labelPositionToValue);    } else {        throw new IllegalArgumentException("Value must be \"S\", or \"P\" (or null).");    }}
public String pdfbox_f6962_0()
{    return this.getCOSObject().getString(COSName.R);}
public void pdfbox_f6963_0(String scaleRatio)
{    this.getCOSObject().setString(COSName.R, scaleRatio);}
public PDNumberFormatDictionary[] pdfbox_f6964_0()
{    COSArray x = (COSArray) this.getCOSObject().getDictionaryObject("X");    if (x != null) {        PDNumberFormatDictionary[] retval = new PDNumberFormatDictionary[x.size()];        for (int i = 0; i < x.size(); i++) {            COSDictionary dic = (COSDictionary) x.get(i);            retval[i] = new PDNumberFormatDictionary(dic);        }        return retval;    }    return null;}
public void pdfbox_f6965_0(PDNumberFormatDictionary[] changeXs)
{    COSArray array = new COSArray();    for (PDNumberFormatDictionary changeX : changeXs) {        array.add(changeX);    }    this.getCOSObject().setItem("X", array);}
public PDNumberFormatDictionary[] pdfbox_f6966_0()
{    COSArray y = (COSArray) this.getCOSObject().getDictionaryObject("Y");    if (y != null) {        PDNumberFormatDictionary[] retval = new PDNumberFormatDictionary[y.size()];        for (int i = 0; i < y.size(); i++) {            COSDictionary dic = (COSDictionary) y.get(i);            retval[i] = new PDNumberFormatDictionary(dic);        }        return retval;    }    return null;}
public void pdfbox_f6967_0(PDNumberFormatDictionary[] changeYs)
{    COSArray array = new COSArray();    for (PDNumberFormatDictionary changeY : changeYs) {        array.add(changeY);    }    this.getCOSObject().setItem("Y", array);}
public PDNumberFormatDictionary[] pdfbox_f6968_0()
{    COSArray d = (COSArray) this.getCOSObject().getDictionaryObject("D");    if (d != null) {        PDNumberFormatDictionary[] retval = new PDNumberFormatDictionary[d.size()];        for (int i = 0; i < d.size(); i++) {            COSDictionary dic = (COSDictionary) d.get(i);            retval[i] = new PDNumberFormatDictionary(dic);        }        return retval;    }    return null;}
public void pdfbox_f6969_0(PDNumberFormatDictionary[] distances)
{    COSArray array = new COSArray();    for (PDNumberFormatDictionary distance : distances) {        array.add(distance);    }    this.getCOSObject().setItem("D", array);}
public PDNumberFormatDictionary[] pdfbox_f6970_0()
{    COSArray a = (COSArray) this.getCOSObject().getDictionaryObject(COSName.A);    if (a != null) {        PDNumberFormatDictionary[] retval = new PDNumberFormatDictionary[a.size()];        for (int i = 0; i < a.size(); i++) {            COSDictionary dic = (COSDictionary) a.get(i);            retval[i] = new PDNumberFormatDictionary(dic);        }        return retval;    }    return null;}
public void pdfbox_f6971_0(PDNumberFormatDictionary[] areas)
{    COSArray array = new COSArray();    for (PDNumberFormatDictionary area : areas) {        array.add(area);    }    this.getCOSObject().setItem(COSName.A, array);}
public PDNumberFormatDictionary[] pdfbox_f6972_0()
{    COSArray t = (COSArray) this.getCOSObject().getDictionaryObject("T");    if (t != null) {        PDNumberFormatDictionary[] retval = new PDNumberFormatDictionary[t.size()];        for (int i = 0; i < t.size(); i++) {            COSDictionary dic = (COSDictionary) t.get(i);            retval[i] = new PDNumberFormatDictionary(dic);        }        return retval;    }    return null;}
public void pdfbox_f6973_0(PDNumberFormatDictionary[] angles)
{    COSArray array = new COSArray();    for (PDNumberFormatDictionary angle : angles) {        array.add(angle);    }    this.getCOSObject().setItem("T", array);}
public PDNumberFormatDictionary[] pdfbox_f6974_0()
{    COSArray s = (COSArray) this.getCOSObject().getDictionaryObject("S");    if (s != null) {        PDNumberFormatDictionary[] retval = new PDNumberFormatDictionary[s.size()];        for (int i = 0; i < s.size(); i++) {            COSDictionary dic = (COSDictionary) s.get(i);            retval[i] = new PDNumberFormatDictionary(dic);        }        return retval;    }    return null;}
public void pdfbox_f6975_0(PDNumberFormatDictionary[] lineSloaps)
{    COSArray array = new COSArray();    for (PDNumberFormatDictionary lineSloap : lineSloaps) {        array.add(lineSloap);    }    this.getCOSObject().setItem("S", array);}
public float[] pdfbox_f6976_0()
{    COSArray o = (COSArray) this.getCOSObject().getDictionaryObject("O");    if (o != null) {        return o.toFloatArray();    }    return null;}
public void pdfbox_f6977_0(float[] coordSystemOrigin)
{    COSArray array = new COSArray();    array.setFloatArray(coordSystemOrigin);    this.getCOSObject().setItem("O", array);}
public float pdfbox_f6978_0()
{    return this.getCOSObject().getFloat("CYX");}
public void pdfbox_f6979_0(float cyx)
{    this.getCOSObject().setFloat("CYX", cyx);}
public COSDictionary pdfbox_f6980_0()
{    return this.viewportDictionary;}
public String pdfbox_f6981_0()
{    return TYPE;}
public PDRectangle pdfbox_f6982_0()
{    COSBase bbox = this.getCOSObject().getDictionaryObject(COSName.BBOX);    if (bbox instanceof COSArray) {        return new PDRectangle((COSArray) bbox);    }    return null;}
public void pdfbox_f6983_0(PDRectangle rectangle)
{    this.getCOSObject().setItem(COSName.BBOX, rectangle);}
public String pdfbox_f6984_0()
{    return this.getCOSObject().getNameAsString(COSName.NAME);}
public void pdfbox_f6985_0(String name)
{    this.getCOSObject().setName(COSName.NAME, name);}
public PDMeasureDictionary pdfbox_f6986_0()
{    COSBase base = this.getCOSObject().getDictionaryObject(COSName.MEASURE);    if (base instanceof COSDictionary) {        return new PDMeasureDictionary((COSDictionary) base);    }    return null;}
public void pdfbox_f6987_0(PDMeasureDictionary measure)
{    this.getCOSObject().setItem(COSName.MEASURE, measure);}
public COSDictionary pdfbox_f6988_0()
{    return thread;}
public PDDocumentInformation pdfbox_f6989_0()
{    PDDocumentInformation retval = null;    COSDictionary info = (COSDictionary) thread.getDictionaryObject("I");    if (info != null) {        retval = new PDDocumentInformation(info);    }    return retval;}
public void pdfbox_f6990_0(PDDocumentInformation info)
{    thread.setItem("I", info);}
public PDThreadBead pdfbox_f6991_0()
{    PDThreadBead retval = null;    COSDictionary bead = (COSDictionary) thread.getDictionaryObject("F");    if (bead != null) {        retval = new PDThreadBead(bead);    }    return retval;}
public void pdfbox_f6992_0(PDThreadBead bead)
{    if (bead != null) {        bead.setThread(this);    }    thread.setItem("F", bead);}
public COSDictionary pdfbox_f6993_0()
{    return bead;}
public PDThread pdfbox_f6994_0()
{    PDThread retval = null;    COSDictionary dic = (COSDictionary) bead.getDictionaryObject("T");    if (dic != null) {        retval = new PDThread(dic);    }    return retval;}
public void pdfbox_f6995_0(PDThread thread)
{    bead.setItem("T", thread);}
public PDThreadBead pdfbox_f6996_0()
{    return new PDThreadBead((COSDictionary) bead.getDictionaryObject("N"));}
protected final void pdfbox_f6997_0(PDThreadBead next)
{    bead.setItem("N", next);}
public PDThreadBead pdfbox_f6998_0()
{    return new PDThreadBead((COSDictionary) bead.getDictionaryObject("V"));}
protected final void pdfbox_f6999_0(PDThreadBead previous)
{    bead.setItem("V", previous);}
public void pdfbox_f7000_0(PDThreadBead append)
{    PDThreadBead nextBead = getNextBead();    nextBead.setPreviousBead(append);    append.setNextBead(nextBead);    setNextBead(append);    append.setPreviousBead(this);}
public PDPage pdfbox_f7001_0()
{    PDPage page = null;    COSDictionary dic = (COSDictionary) bead.getDictionaryObject("P");    if (dic != null) {        page = new PDPage(dic);    }    return page;}
public void pdfbox_f7002_0(PDPage page)
{    bead.setItem("P", page);}
public PDRectangle pdfbox_f7003_0()
{    PDRectangle rect = null;    COSArray array = (COSArray) bead.getDictionaryObject(COSName.R);    if (array != null) {        rect = new PDRectangle(array);    }    return rect;}
public void pdfbox_f7004_0(PDRectangle rect)
{    bead.setItem(COSName.R, rect);}
public String pdfbox_f7005_0()
{    return getCOSObject().getNameAsString(COSName.S, PDTransitionStyle.R.name());}
public String pdfbox_f7006_0()
{    return getCOSObject().getNameAsString(COSName.DM, PDTransitionDimension.H.name());}
public void pdfbox_f7007_0(PDTransitionDimension dimension)
{    getCOSObject().setName(COSName.DM, dimension.name());}
public String pdfbox_f7008_0()
{    return getCOSObject().getNameAsString(COSName.M, PDTransitionMotion.I.name());}
public void pdfbox_f7009_0(PDTransitionMotion motion)
{    getCOSObject().setName(COSName.M, motion.name());}
public COSBase pdfbox_f7010_0()
{    COSBase item = getCOSObject().getItem(COSName.DI);    if (item == null) {        return COSInteger.ZERO;    }    return item;}
public void pdfbox_f7011_0(PDTransitionDirection direction)
{    getCOSObject().setItem(COSName.DI, direction.getCOSBase());}
public float pdfbox_f7012_0()
{    return getCOSObject().getFloat(COSName.D, 1);}
public void pdfbox_f7013_0(float duration)
{    getCOSObject().setItem(COSName.D, new COSFloat(duration));}
public float pdfbox_f7014_0()
{    return getCOSObject().getFloat(COSName.SS, 1);}
public void pdfbox_f7015_0(float scale)
{    getCOSObject().setItem(COSName.SS, new COSFloat(scale));}
public boolean pdfbox_f7016_0()
{    return getCOSObject().getBoolean(COSName.B, false);}
public void pdfbox_f7017_0(boolean opaque)
{    getCOSObject().setItem(COSName.B, COSBoolean.getBoolean(opaque));}
public COSBase pdfbox_f7018_0()
{    return COSInteger.get(degrees);}
public COSBase pdfbox_f7019_0()
{    return COSName.NONE;}
public COSDictionary pdfbox_f7020_0()
{    return prefs;}
public boolean pdfbox_f7021_0()
{    return prefs.getBoolean(COSName.HIDE_TOOLBAR, false);}
public void pdfbox_f7022_0(boolean value)
{    prefs.setBoolean(COSName.HIDE_TOOLBAR, value);}
public boolean pdfbox_f7023_0()
{    return prefs.getBoolean(COSName.HIDE_MENUBAR, false);}
public void pdfbox_f7024_0(boolean value)
{    prefs.setBoolean(COSName.HIDE_MENUBAR, value);}
public boolean pdfbox_f7025_0()
{    return prefs.getBoolean(COSName.HIDE_WINDOWUI, false);}
public void pdfbox_f7026_0(boolean value)
{    prefs.setBoolean(COSName.HIDE_WINDOWUI, value);}
public boolean pdfbox_f7027_0()
{    return prefs.getBoolean(COSName.FIT_WINDOW, false);}
public void pdfbox_f7028_0(boolean value)
{    prefs.setBoolean(COSName.FIT_WINDOW, value);}
public boolean pdfbox_f7029_0()
{    return prefs.getBoolean(COSName.CENTER_WINDOW, false);}
public void pdfbox_f7030_0(boolean value)
{    prefs.setBoolean(COSName.CENTER_WINDOW, value);}
public boolean pdfbox_f7031_0()
{    return prefs.getBoolean(COSName.DISPLAY_DOC_TITLE, false);}
public void pdfbox_f7032_0(boolean value)
{    prefs.setBoolean(COSName.DISPLAY_DOC_TITLE, value);}
public String pdfbox_f7033_0()
{    return prefs.getNameAsString(COSName.NON_FULL_SCREEN_PAGE_MODE, NON_FULL_SCREEN_PAGE_MODE.UseNone.toString());}
public void pdfbox_f7034_0(NON_FULL_SCREEN_PAGE_MODE value)
{    prefs.setName(COSName.NON_FULL_SCREEN_PAGE_MODE, value.toString());}
public String pdfbox_f7035_0()
{    return prefs.getNameAsString(COSName.DIRECTION, READING_DIRECTION.L2R.toString());}
public void pdfbox_f7036_0(READING_DIRECTION value)
{    prefs.setName(COSName.DIRECTION, value.toString());}
public String pdfbox_f7037_0()
{    return prefs.getNameAsString(COSName.VIEW_AREA, BOUNDARY.CropBox.toString());}
public void pdfbox_f7038_0(BOUNDARY value)
{    prefs.setName(COSName.VIEW_AREA, value.toString());}
public String pdfbox_f7039_0()
{    return prefs.getNameAsString(COSName.VIEW_CLIP, BOUNDARY.CropBox.toString());}
public void pdfbox_f7040_0(BOUNDARY value)
{    prefs.setName(COSName.VIEW_CLIP, value.toString());}
public String pdfbox_f7041_0()
{    return prefs.getNameAsString(COSName.PRINT_AREA, BOUNDARY.CropBox.toString());}
public void pdfbox_f7042_0(BOUNDARY value)
{    prefs.setName(COSName.PRINT_AREA, value.toString());}
public String pdfbox_f7043_0()
{    return prefs.getNameAsString(COSName.PRINT_CLIP, BOUNDARY.CropBox.toString());}
public void pdfbox_f7044_0(BOUNDARY value)
{    prefs.setName(COSName.PRINT_CLIP, value.toString());}
public String pdfbox_f7045_0()
{    return prefs.getNameAsString(COSName.DUPLEX);}
public void pdfbox_f7046_0(DUPLEX value)
{    prefs.setName(COSName.DUPLEX, value.toString());}
public String pdfbox_f7047_0()
{    return prefs.getNameAsString(COSName.PRINT_SCALING, PRINT_SCALING.AppDefault.toString());}
public void pdfbox_f7048_0(PRINT_SCALING value)
{    prefs.setName(COSName.PRINT_SCALING, value.toString());}
public static PageLayout pdfbox_f7049_0(String value)
{    for (PageLayout instance : PageLayout.values()) {        if (instance.value.equals(value)) {            return instance;        }    }    throw new IllegalArgumentException(value);}
public String pdfbox_f7050_0()
{    return value;}
public static PageMode pdfbox_f7051_0(String value)
{    for (PageMode instance : PageMode.values()) {        if (instance.value.equals(value)) {            return instance;        }    }    throw new IllegalArgumentException(value);}
public String pdfbox_f7052_0()
{    return value;}
protected void pdfbox_f7053_0(int fractionDigitsNumber)
{    formatDecimal.setMaximumFractionDigits(fractionDigitsNumber);}
public void pdfbox_f7054_0() throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: Nested beginText() calls are not allowed.");    }    writeOperator(OperatorName.BEGIN_TEXT);    inTextMode = true;}
public void pdfbox_f7055_0() throws IOException
{    if (!inTextMode) {        throw new IllegalStateException("Error: You must call beginText() before calling endText.");    }    writeOperator(OperatorName.END_TEXT);    inTextMode = false;}
public void pdfbox_f7056_1(PDFont font, float fontSize) throws IOException
{    if (fontStack.isEmpty()) {        fontStack.add(font);    } else {        fontStack.pop();        fontStack.push(font);    }        if (font.willBeSubset()) {        if (document != null) {            document.getFontsToSubset().add(font);        } else {                    }    }        if (font instanceof PDType0Font) {        PDType0Font pdType0Font = (PDType0Font) font;        GsubData gsubData = pdType0Font.getGsubData();        if (gsubData != GsubData.NO_DATA_FOUND) {            GsubWorker gsubWorker = gsubWorkerFactory.getGsubWorker(pdType0Font.getCmapLookup(), gsubData);            gsubWorkers.put((PDType0Font) font, gsubWorker);        }    }    writeOperand(resources.add(font));    writeOperand(fontSize);    writeOperator(OperatorName.SET_FONT_AND_SIZE);}
public void pdfbox_f7057_0(Object[] textWithPositioningArray) throws IOException
{    write("[");    for (Object obj : textWithPositioningArray) {        if (obj instanceof String) {            showTextInternal((String) obj);        } else if (obj instanceof Float) {            writeOperand((Float) obj);        } else {            throw new IllegalArgumentException("Argument must consist of array of Float and String types");        }    }    write("] ");    writeOperator(OperatorName.SHOW_TEXT_ADJUSTED);}
public void pdfbox_f7058_0(String text) throws IOException
{    showTextInternal(text);    write(" ");    writeOperator(OperatorName.SHOW_TEXT);}
protected void pdfbox_f7059_0(String text) throws IOException
{    if (!inTextMode) {        throw new IllegalStateException("Must call beginText() before showText()");    }    if (fontStack.isEmpty()) {        throw new IllegalStateException("Must call setFont() before showText()");    }    PDFont font = fontStack.peek();        byte[] encodedText = null;    if (font instanceof PDType0Font) {        GsubWorker gsubWorker = gsubWorkers.get(font);        if (gsubWorker != null) {            PDType0Font pdType0Font = (PDType0Font) font;            Set<Integer> glyphIds = new HashSet<>();            encodedText = encodeForGsub(gsubWorker, glyphIds, pdType0Font, text);            if (pdType0Font.willBeSubset()) {                pdType0Font.addGlyphsToSubset(glyphIds);            }        }    }    if (encodedText == null) {        encodedText = font.encode(text);    }        if (font.willBeSubset()) {        int offset = 0;        while (offset < text.length()) {            int codePoint = text.codePointAt(offset);            font.addToSubset(codePoint);            offset += Character.charCount(codePoint);        }    }    COSWriter.writeString(encodedText, outputStream);}
public void pdfbox_f7060_0(float leading) throws IOException
{    writeOperand(leading);    writeOperator(OperatorName.SET_TEXT_LEADING);}
public void pdfbox_f7061_0() throws IOException
{    if (!inTextMode) {        throw new IllegalStateException("Must call beginText() before newLine()");    }    writeOperator(OperatorName.NEXT_LINE);}
public void pdfbox_f7062_0(float tx, float ty) throws IOException
{    if (!inTextMode) {        throw new IllegalStateException("Error: must call beginText() before newLineAtOffset()");    }    writeOperand(tx);    writeOperand(ty);    writeOperator(OperatorName.MOVE_TEXT);}
public void pdfbox_f7063_0(Matrix matrix) throws IOException
{    if (!inTextMode) {        throw new IllegalStateException("Error: must call beginText() before setTextMatrix");    }    writeAffineTransform(matrix.createAffineTransform());    writeOperator(OperatorName.SET_MATRIX);}
public void pdfbox_f7064_0(PDImageXObject image, float x, float y) throws IOException
{    drawImage(image, x, y, image.getWidth(), image.getHeight());}
public void pdfbox_f7065_0(PDImageXObject image, float x, float y, float width, float height) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: drawImage is not allowed within a text block.");    }    saveGraphicsState();    AffineTransform transform = new AffineTransform(width, 0, 0, height, x, y);    transform(new Matrix(transform));    writeOperand(resources.add(image));    writeOperator(OperatorName.DRAW_OBJECT);    restoreGraphicsState();}
public void pdfbox_f7066_0(PDImageXObject image, Matrix matrix) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: drawImage is not allowed within a text block.");    }    saveGraphicsState();    AffineTransform transform = matrix.createAffineTransform();    transform(new Matrix(transform));    writeOperand(resources.add(image));    writeOperator(OperatorName.DRAW_OBJECT);    restoreGraphicsState();}
public void pdfbox_f7067_0(PDInlineImage inlineImage, float x, float y) throws IOException
{    drawImage(inlineImage, x, y, inlineImage.getWidth(), inlineImage.getHeight());}
public void pdfbox_f7068_0(PDInlineImage inlineImage, float x, float y, float width, float height) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: drawImage is not allowed within a text block.");    }    saveGraphicsState();    transform(new Matrix(width, 0, 0, height, x, y));        StringBuilder sb = new StringBuilder();    sb.append(OperatorName.BEGIN_INLINE_IMAGE);    sb.append("\n /W ");    sb.append(inlineImage.getWidth());    sb.append("\n /H ");    sb.append(inlineImage.getHeight());    sb.append("\n /CS ");    sb.append("/");    sb.append(inlineImage.getColorSpace().getName());    if (inlineImage.getDecode() != null && inlineImage.getDecode().size() > 0) {        sb.append("\n /D ");        sb.append("[");        for (COSBase base : inlineImage.getDecode()) {            sb.append(((COSNumber) base).intValue());            sb.append(" ");        }        sb.append("]");    }    if (inlineImage.isStencil()) {        sb.append("\n /IM true");    }    sb.append("\n /BPC ");    sb.append(inlineImage.getBitsPerComponent());        write(sb.toString());    writeLine();        writeOperator(OperatorName.BEGIN_INLINE_IMAGE_DATA);    writeBytes(inlineImage.getData());    writeLine();    writeOperator(OperatorName.END_INLINE_IMAGE);    restoreGraphicsState();}
public void pdfbox_f7069_0(PDFormXObject form) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: drawForm is not allowed within a text block.");    }    writeOperand(resources.add(form));    writeOperator(OperatorName.DRAW_OBJECT);}
public void pdfbox_f7070_0(Matrix matrix) throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: Modifying the current transformation matrix is not allowed within text objects.");    }    writeAffineTransform(matrix.createAffineTransform());    writeOperator(OperatorName.CONCAT);}
public void pdfbox_f7071_0() throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: Saving the graphics state is not allowed within text objects.");    }    if (!fontStack.isEmpty()) {        fontStack.push(fontStack.peek());    }    if (!strokingColorSpaceStack.isEmpty()) {        strokingColorSpaceStack.push(strokingColorSpaceStack.peek());    }    if (!nonStrokingColorSpaceStack.isEmpty()) {        nonStrokingColorSpaceStack.push(nonStrokingColorSpaceStack.peek());    }    writeOperator(OperatorName.SAVE);}
public void pdfbox_f7072_0() throws IOException
{    if (inTextMode) {        throw new IllegalStateException("Error: Restoring the graphics state is not allowed within text objects.");    }    if (!fontStack.isEmpty()) {        fontStack.pop();    }    if (!strokingColorSpaceStack.isEmpty()) {        strokingColorSpaceStack.pop();    }    if (!nonStrokingColorSpaceStack.isEmpty()) {        nonStrokingColorSpaceStack.pop();    }    writeOperator(OperatorName.RESTORE);}
protected COSName pdfbox_f7073_0(PDColorSpace colorSpace)
{    if (colorSpace instanceof PDDeviceGray || colorSpace instanceof PDDeviceRGB || colorSpace instanceof PDDeviceCMYK) {        return COSName.getPDFName(colorSpace.getName());    } else {        return resources.add(colorSpace);    }}
public void pdfbox_f7074_0(PDColor color) throws IOException
{    if (strokingColorSpaceStack.isEmpty() || strokingColorSpaceStack.peek() != color.getColorSpace()) {        writeOperand(getName(color.getColorSpace()));        writeOperator(OperatorName.STROKING_COLORSPACE);        setStrokingColorSpaceStack(color.getColorSpace());    }    for (float value : color.getComponents()) {        writeOperand(value);    }    if (color.getColorSpace() instanceof PDPattern) {        writeOperand(color.getPatternName());    }    if (color.getColorSpace() instanceof PDPattern || color.getColorSpace() instanceof PDSeparation || color.getColorSpace() instanceof PDDeviceN || color.getColorSpace() instanceof PDICCBased) {        writeOperator(OperatorName.STROKING_COLOR_N);    } else {        writeOperator(OperatorName.STROKING_COLOR);    }}
public void pdfbox_f7075_0(Color color) throws IOException
{    float[] components = new float[] { color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f };    PDColor pdColor = new PDColor(components, PDDeviceRGB.INSTANCE);    setStrokingColor(pdColor);}
public void pdfbox_f7076_0(int r, int g, int b) throws IOException
{    if (isOutside255Interval(r) || isOutside255Interval(g) || isOutside255Interval(b)) {        throw new IllegalArgumentException("Parameters must be within 0..255, but are " + String.format("(%d,%d,%d)", r, g, b));    }    writeOperand(r / 255f);    writeOperand(g / 255f);    writeOperand(b / 255f);    writeOperator(OperatorName.STROKING_COLOR_RGB);    setStrokingColorSpaceStack(PDDeviceRGB.INSTANCE);}
public void pdfbox_f7077_0(float c, float m, float y, float k) throws IOException
{    if (isOutsideOneInterval(c) || isOutsideOneInterval(m) || isOutsideOneInterval(y) || isOutsideOneInterval(k)) {        throw new IllegalArgumentException("Parameters must be within 0..1, but are " + String.format("(%.2f,%.2f,%.2f,%.2f)", c, m, y, k));    }    writeOperand(c);    writeOperand(m);    writeOperand(y);    writeOperand(k);    writeOperator(OperatorName.STROKING_COLOR_CMYK);    setStrokingColorSpaceStack(PDDeviceCMYK.INSTANCE);}
public void pdfbox_f7078_0(float g) throws IOException
{    if (isOutsideOneInterval(g)) {        throw new IllegalArgumentException("Parameter must be within 0..1, but is " + g);    }    writeOperand(g);    writeOperator(OperatorName.STROKING_COLOR_GRAY);    setStrokingColorSpaceStack(PDDeviceGray.INSTANCE);}
public void pdfbox_f7079_0(PDColor color) throws IOException
{    if (nonStrokingColorSpaceStack.isEmpty() || nonStrokingColorSpaceStack.peek() != color.getColorSpace()) {        writeOperand(getName(color.getColorSpace()));        writeOperator(OperatorName.NON_STROKING_COLORSPACE);        setNonStrokingColorSpaceStack(color.getColorSpace());    }    for (float value : color.getComponents()) {        writeOperand(value);    }    if (color.getColorSpace() instanceof PDPattern) {        writeOperand(color.getPatternName());    }    if (color.getColorSpace() instanceof PDPattern || color.getColorSpace() instanceof PDSeparation || color.getColorSpace() instanceof PDDeviceN || color.getColorSpace() instanceof PDICCBased) {        writeOperator(OperatorName.NON_STROKING_COLOR_N);    } else {        writeOperator(OperatorName.NON_STROKING_COLOR);    }}
public void pdfbox_f7080_0(Color color) throws IOException
{    float[] components = new float[] { color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f };    PDColor pdColor = new PDColor(components, PDDeviceRGB.INSTANCE);    setNonStrokingColor(pdColor);}
public void pdfbox_f7081_0(int r, int g, int b) throws IOException
{    if (isOutside255Interval(r) || isOutside255Interval(g) || isOutside255Interval(b)) {        throw new IllegalArgumentException("Parameters must be within 0..255, but are " + String.format("(%d,%d,%d)", r, g, b));    }    writeOperand(r / 255f);    writeOperand(g / 255f);    writeOperand(b / 255f);    writeOperator(OperatorName.NON_STROKING_RGB);    setNonStrokingColorSpaceStack(PDDeviceRGB.INSTANCE);}
public void pdfbox_f7082_0(int c, int m, int y, int k) throws IOException
{    if (isOutside255Interval(c) || isOutside255Interval(m) || isOutside255Interval(y) || isOutside255Interval(k)) {        throw new IllegalArgumentException("Parameters must be within 0..255, but are " + String.format("(%d,%d,%d,%d)", c, m, y, k));    }    setNonStrokingColor(c / 255f, m / 255f, y / 255f, k / 255f);}
public void pdfbox_f7083_0(float c, float m, float y, float k) throws IOException
{    if (isOutsideOneInterval(c) || isOutsideOneInterval(m) || isOutsideOneInterval(y) || isOutsideOneInterval(k)) {        throw new IllegalArgumentException("Parameters must be within 0..1, but are " + String.format("(%.2f,%.2f,%.2f,%.2f)", c, m, y, k));    }    writeOperand(c);    writeOperand(m);    writeOperand(y);    writeOperand(k);    writeOperator(OperatorName.NON_STROKING_CMYK);    setNonStrokingColorSpaceStack(PDDeviceCMYK.INSTANCE);}
public void pdfbox_f7084_0(int g) throws IOException
{    if (isOutside255Interval(g)) {        throw new IllegalArgumentException("Parameter must be within 0..255, but is " + g);    }    setNonStrokingColor(g / 255f);}
public void pdfbox_f7085_0(float g) throws IOException
{    if (isOutsideOneInterval(g)) {        throw new IllegalArgumentException("Parameter must be within 0..1, but is " + g);    }    writeOperand(g);    writeOperator(OperatorName.NON_STROKING_GRAY);    setNonStrokingColorSpaceStack(PDDeviceGray.INSTANCE);}
