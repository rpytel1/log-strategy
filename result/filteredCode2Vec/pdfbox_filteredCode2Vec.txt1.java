public void pdfbox_f1023_0(float descenderValue)
{    descender = descenderValue;}
public String pdfbox_f1024_0()
{    return fontVersion;}
public void pdfbox_f1025_0(String fontVersionValue)
{    fontVersion = fontVersionValue;}
public float pdfbox_f1026_0()
{    return underlinePosition;}
public void pdfbox_f1027_0(float underlinePositionValue)
{    underlinePosition = underlinePositionValue;}
public float pdfbox_f1028_0()
{    return underlineThickness;}
public void pdfbox_f1029_0(float underlineThicknessValue)
{    underlineThickness = underlineThicknessValue;}
public float pdfbox_f1030_0()
{    return italicAngle;}
public void pdfbox_f1031_0(float italicAngleValue)
{    italicAngle = italicAngleValue;}
public float[] pdfbox_f1032_0()
{    return this.charWidth;}
public void pdfbox_f1033_0(float[] charWidthValue)
{    charWidth = charWidthValue;}
public boolean pdfbox_f1034_0()
{    return isFixedPitch;}
public void pdfbox_f1035_0(boolean isFixedPitchValue)
{    isFixedPitch = isFixedPitchValue;}
public List<CharMetric> pdfbox_f1036_0()
{    return Collections.unmodifiableList(charMetrics);}
public void pdfbox_f1037_0(List<CharMetric> charMetricsValue)
{    charMetrics = charMetricsValue;    charMetricsMap = new HashMap<>(charMetrics.size());    charMetricsValue.forEach(metric -> charMetricsMap.put(metric.getName(), metric));}
public void pdfbox_f1038_0(CharMetric metric)
{    charMetrics.add(metric);    charMetricsMap.put(metric.getName(), metric);}
public List<TrackKern> pdfbox_f1039_0()
{    return Collections.unmodifiableList(trackKern);}
public void pdfbox_f1040_0(List<TrackKern> trackKernValue)
{    trackKern = trackKernValue;}
public void pdfbox_f1041_0(TrackKern kern)
{    trackKern.add(kern);}
public List<Composite> pdfbox_f1042_0()
{    return Collections.unmodifiableList(composites);}
public void pdfbox_f1043_0(List<Composite> compositesList)
{    composites = compositesList;}
public void pdfbox_f1044_0(Composite composite)
{    composites.add(composite);}
public List<KernPair> pdfbox_f1045_0()
{    return Collections.unmodifiableList(kernPairs);}
public void pdfbox_f1046_0(KernPair kernPair)
{    kernPairs.add(kernPair);}
public void pdfbox_f1047_0(List<KernPair> kernPairsList)
{    kernPairs = kernPairsList;}
public List<KernPair> pdfbox_f1048_0()
{    return Collections.unmodifiableList(kernPairs0);}
public void pdfbox_f1049_0(KernPair kernPair)
{    kernPairs0.add(kernPair);}
public void pdfbox_f1050_0(List<KernPair> kernPairs0List)
{    kernPairs0 = kernPairs0List;}
public List<KernPair> pdfbox_f1051_0()
{    return Collections.unmodifiableList(kernPairs1);}
public void pdfbox_f1052_0(KernPair kernPair)
{    kernPairs1.add(kernPair);}
public void pdfbox_f1053_0(List<KernPair> kernPairs1List)
{    kernPairs1 = kernPairs1List;}
public float pdfbox_f1054_0()
{    return standardHorizontalWidth;}
public void pdfbox_f1055_0(float standardHorizontalWidthValue)
{    standardHorizontalWidth = standardHorizontalWidthValue;}
public float pdfbox_f1056_0()
{    return standardVerticalWidth;}
public void pdfbox_f1057_0(float standardVerticalWidthValue)
{    standardVerticalWidth = standardVerticalWidthValue;}
public java.lang.String pdfbox_f1058_0()
{    return firstKernCharacter;}
public void pdfbox_f1059_0(String firstKernCharacterValue)
{    firstKernCharacter = firstKernCharacterValue;}
public java.lang.String pdfbox_f1060_0()
{    return secondKernCharacter;}
public void pdfbox_f1061_0(String secondKernCharacterValue)
{    secondKernCharacter = secondKernCharacterValue;}
public float pdfbox_f1062_0()
{    return x;}
public void pdfbox_f1063_0(float xValue)
{    x = xValue;}
public float pdfbox_f1064_0()
{    return y;}
public void pdfbox_f1065_0(float yValue)
{    y = yValue;}
public String pdfbox_f1066_0()
{    return ligature;}
public void pdfbox_f1067_0(String lig)
{    ligature = lig;}
public String pdfbox_f1068_0()
{    return successor;}
public void pdfbox_f1069_0(String successorValue)
{    successor = successorValue;}
public int pdfbox_f1070_0()
{    return degree;}
public void pdfbox_f1071_0(int degreeValue)
{    degree = degreeValue;}
public float pdfbox_f1072_0()
{    return maxKern;}
public void pdfbox_f1073_0(float maxKernValue)
{    maxKern = maxKernValue;}
public float pdfbox_f1074_0()
{    return maxPointSize;}
public void pdfbox_f1075_0(float maxPointSizeValue)
{    maxPointSize = maxPointSizeValue;}
public float pdfbox_f1076_0()
{    return minKern;}
public void pdfbox_f1077_0(float minKernValue)
{    minKern = minKernValue;}
public float pdfbox_f1078_0()
{    return minPointSize;}
public void pdfbox_f1079_0(float minPointSizeValue)
{    minPointSize = minPointSizeValue;}
public boolean pdfbox_f1080_0()
{    return isCIDFont;}
public void pdfbox_f1081_0(int gid, int sid, String name)
{    if (isCIDFont) {        throw new IllegalStateException("Not a Type 1-equivalent font");    }    sidOrCidToGid.put(sid, gid);    gidToSid.put(gid, sid);    nameToSid.put(name, sid);    gidToName.put(gid, name);}
public void pdfbox_f1082_0(int gid, int cid)
{    if (!isCIDFont) {        throw new IllegalStateException("Not a CIDFont");    }    sidOrCidToGid.put(cid, gid);    gidToCid.put(gid, cid);}
 int pdfbox_f1083_0(int sid)
{    if (isCIDFont) {        throw new IllegalStateException("Not a Type 1-equivalent font");    }    Integer gid = gidToSid.get(sid);    if (gid == null) {        return 0;    }    return gid;}
 int pdfbox_f1084_0(int sid)
{    if (isCIDFont) {        throw new IllegalStateException("Not a Type 1-equivalent font");    }    Integer gid = sidOrCidToGid.get(sid);    if (gid == null) {        return 0;    }    return gid;}
public int pdfbox_f1085_0(int cid)
{    if (!isCIDFont) {        throw new IllegalStateException("Not a CIDFont");    }    Integer gid = sidOrCidToGid.get(cid);    if (gid == null) {        return 0;    }    return gid;}
 int pdfbox_f1086_0(String name)
{    if (isCIDFont) {        throw new IllegalStateException("Not a Type 1-equivalent font");    }    Integer sid = nameToSid.get(name);    if (sid == null) {        return 0;    }    return sid;}
public String pdfbox_f1087_0(int gid)
{    if (isCIDFont) {        throw new IllegalStateException("Not a Type 1-equivalent font");    }    return gidToName.get(gid);}
public int pdfbox_f1088_0(int gid)
{    if (!isCIDFont) {        throw new IllegalStateException("Not a CIDFont");    }    Integer cid = gidToCid.get(gid);    if (cid != null) {        return cid;    }    return 0;}
public String pdfbox_f1089_0()
{    return registry;}
 void pdfbox_f1090_0(String registry)
{    this.registry = registry;}
public String pdfbox_f1091_0()
{    return ordering;}
 void pdfbox_f1092_0(String ordering)
{    this.ordering = ordering;}
public int pdfbox_f1093_0()
{    return supplement;}
 void pdfbox_f1094_0(int supplement)
{    this.supplement = supplement;}
public List<Map<String, Object>> pdfbox_f1095_0()
{    return fontDictionaries;}
 void pdfbox_f1096_0(List<Map<String, Object>> fontDict)
{    this.fontDictionaries = fontDict;}
public List<Map<String, Object>> pdfbox_f1097_0()
{    return privateDictionaries;}
 void pdfbox_f1098_0(List<Map<String, Object>> privDict)
{    this.privateDictionaries = privDict;}
public FDSelect pdfbox_f1099_0()
{    return fdSelect;}
 void pdfbox_f1100_0(FDSelect fdSelect)
{    this.fdSelect = fdSelect;}
private int pdfbox_f1101_0(int gid)
{    int fdArrayIndex = this.fdSelect.getFDIndex(gid);    if (fdArrayIndex == -1) {        return 1000;    }    Map<String, Object> privDict = this.privateDictionaries.get(fdArrayIndex);    return privDict.containsKey("defaultWidthX") ? ((Number) privDict.get("defaultWidthX")).intValue() : 1000;}
private int pdfbox_f1102_0(int gid)
{    int fdArrayIndex = this.fdSelect.getFDIndex(gid);    if (fdArrayIndex == -1) {        return 0;    }    Map<String, Object> privDict = this.privateDictionaries.get(fdArrayIndex);    return privDict.containsKey("nominalWidthX") ? ((Number) privDict.get("nominalWidthX")).intValue() : 0;}
private byte[][] pdfbox_f1103_0(int gid)
{    int fdArrayIndex = this.fdSelect.getFDIndex(gid);    if (fdArrayIndex == -1) {        return null;    }    Map<String, Object> privDict = this.privateDictionaries.get(fdArrayIndex);    return (byte[][]) privDict.get("Subrs");}
public CIDKeyedType2CharString pdfbox_f1104_0(int cid) throws IOException
{    CIDKeyedType2CharString type2 = charStringCache.get(cid);    if (type2 == null) {        int gid = charset.getGIDForCID(cid);        byte[] bytes = charStrings[gid];        if (bytes == null) {                        bytes = charStrings[0];        }        Type2CharStringParser parser = new Type2CharStringParser(fontName, cid);        List<Object> type2seq = parser.parse(bytes, globalSubrIndex, getLocalSubrIndex(gid));        type2 = new CIDKeyedType2CharString(reader, fontName, cid, gid, type2seq, getDefaultWidthX(gid), getNominalWidthX(gid));        charStringCache.put(cid, type2);    }    return type2;}
public List<Number> pdfbox_f1105_0()
{        return (List<Number>) topDict.get("FontMatrix");}
public GeneralPath pdfbox_f1106_0(String selector) throws IOException
{    int cid = selectorToCID(selector);    return getType2CharString(cid).getPath();}
public float pdfbox_f1107_0(String selector) throws IOException
{    int cid = selectorToCID(selector);    return getType2CharString(cid).getWidth();}
public boolean pdfbox_f1108_0(String selector) throws IOException
{    int cid = selectorToCID(selector);    return cid != 0;}
private int pdfbox_f1109_0(String selector)
{    if (!selector.startsWith("\\")) {        throw new IllegalArgumentException("Invalid selector");    }    return Integer.parseInt(selector.substring(1));}
public Type1CharString pdfbox_f1110_0(String name) throws IOException
{        return CFFCIDFont.this.getType2CharString(0);}
public int pdfbox_f1111_0() throws IOException
{    return readUnsignedByte();}
public int pdfbox_f1112_0() throws IOException
{    return readUnsignedShort();}
public int pdfbox_f1113_0(int offSize) throws IOException
{    int value = 0;    for (int i = 0; i < offSize; i++) {        value = value << 8 | readUnsignedByte();    }    return value;}
public int pdfbox_f1114_0() throws IOException
{    return readUnsignedByte();}
public int pdfbox_f1115_0() throws IOException
{    return readUnsignedShort();}
public String pdfbox_f1116_0(int code)
{    String name = codeToName.get(code);    if (name == null) {        return ".notdef";    }    return name;}
public void pdfbox_f1117_0(int code, int sid, String name)
{    codeToName.put(code, name);    addCharacterEncoding(code, name);}
protected void pdfbox_f1118_0(int code, int sid)
{    String name = CFFStandardString.getName(sid);    codeToName.put(code, name);    addCharacterEncoding(code, name);}
public static CFFExpertCharset pdfbox_f1119_0()
{    return CFFExpertCharset.INSTANCE;}
public static CFFExpertEncoding pdfbox_f1120_0()
{    return CFFExpertEncoding.INSTANCE;}
public static CFFExpertSubsetCharset pdfbox_f1121_0()
{    return CFFExpertSubsetCharset.INSTANCE;}
public String pdfbox_f1122_0()
{    return fontName;}
 void pdfbox_f1123_0(String name)
{    fontName = name;}
public void pdfbox_f1124_0(String name, Object value)
{    if (value != null) {        topDict.put(name, value);    }}
public Map<String, Object> pdfbox_f1125_0()
{    return topDict;}
public BoundingBox pdfbox_f1126_0()
{    List<Number> numbers = (List<Number>) topDict.get("FontBBox");    return new BoundingBox(numbers);}
public CFFCharset pdfbox_f1127_0()
{    return charset;}
 void pdfbox_f1128_0(CFFCharset charset)
{    this.charset = charset;}
public final List<byte[]> pdfbox_f1129_0()
{    return Arrays.asList(charStrings);}
 final void pdfbox_f1130_0(CFFParser.ByteSource source)
{    this.source = source;}
public byte[] pdfbox_f1131_0() throws IOException
{    return source.getBytes();}
public int pdfbox_f1132_0()
{    return charStrings.length;}
 void pdfbox_f1133_0(byte[][] globalSubrIndexValue)
{    globalSubrIndex = globalSubrIndexValue;}
public List<byte[]> pdfbox_f1134_0()
{    return Arrays.asList(globalSubrIndex);}
public String pdfbox_f1135_0()
{    return getClass().getSimpleName() + "[name=" + fontName + ", topDict=" + topDict + ", charset=" + charset + ", charStrings=" + Arrays.deepToString(charStrings) + "]";}
public static CFFISOAdobeCharset pdfbox_f1136_0()
{    return CFFISOAdobeCharset.INSTANCE;}
public Key pdfbox_f1137_0()
{    return operatorKey;}
private void pdfbox_f1138_0(Key key)
{    operatorKey = key;}
public String pdfbox_f1139_0()
{    return operatorName;}
private void pdfbox_f1140_0(String name)
{    operatorName = name;}
public String pdfbox_f1141_0()
{    return getName();}
public int pdfbox_f1142_0()
{    return getKey().hashCode();}
public boolean pdfbox_f1143_0(Object object)
{    if (object instanceof CFFOperator) {        CFFOperator that = (CFFOperator) object;        return getKey().equals(that.getKey());    }    return false;}
private static void pdfbox_f1144_0(Key key, String name)
{    CFFOperator operator = new CFFOperator(key, name);    keyMap.put(key, operator);    nameMap.put(name, operator);}
public static CFFOperator pdfbox_f1145_0(Key key)
{    return keyMap.get(key);}
public static CFFOperator pdfbox_f1146_0(String name)
{    return nameMap.get(name);}
public int[] pdfbox_f1147_0()
{    return value;}
private void pdfbox_f1148_0(int[] value)
{    this.value = value;}
public String pdfbox_f1149_0()
{    return Arrays.toString(getValue());}
public int pdfbox_f1150_0()
{    return Arrays.hashCode(getValue());}
public boolean pdfbox_f1151_0(Object object)
{    if (object instanceof Key) {        Key that = (Key) object;        return Arrays.equals(getValue(), that.getValue());    }    return false;}
public List<CFFFont> pdfbox_f1152_0(byte[] bytes, ByteSource source) throws IOException
{    this.source = source;    return parse(bytes);}
public List<CFFFont> pdfbox_f1153_0(byte[] bytes) throws IOException
{    CFFDataInput input = new CFFDataInput(bytes);    String firstTag = readTagName(input);        switch(firstTag) {        case TAG_OTTO:            input = createTaggedCFFDataInput(input, bytes);            break;        case TAG_TTCF:            throw new IOException("True Type Collection fonts are not supported.");        case TAG_TTFONLY:            throw new IOException("OpenType fonts containing a true type font are not supported.");        default:            input.setPosition(0);            break;    }    @SuppressWarnings("unused")    Header header = readHeader(input);    String[] nameIndex = readStringIndexData(input);    if (nameIndex == null) {        throw new IOException("Name index missing in CFF font");    }    byte[][] topDictIndex = readIndexData(input);    if (topDictIndex == null) {        throw new IOException("Top DICT INDEX missing in CFF font");    }    stringIndex = readStringIndexData(input);    byte[][] globalSubrIndex = readIndexData(input);    List<CFFFont> fonts = new ArrayList<>();    for (int i = 0; i < nameIndex.length; i++) {        CFFFont font = parseFont(input, nameIndex[i], topDictIndex[i]);        font.setGlobalSubrIndex(globalSubrIndex);        font.setData(source);        fonts.add(font);    }    return fonts;}
private CFFDataInput pdfbox_f1154_0(CFFDataInput input, byte[] bytes) throws IOException
{            short numTables = input.readShort();    @SuppressWarnings({ "unused", "squid:S1854" })    short searchRange = input.readShort();    @SuppressWarnings({ "unused", "squid:S1854" })    short entrySelector = input.readShort();    @SuppressWarnings({ "unused", "squid:S1854" })    short rangeShift = input.readShort();    for (int q = 0; q < numTables; q++) {        String tagName = readTagName(input);        @SuppressWarnings("unused")        long checksum = readLong(input);        long offset = readLong(input);        long length = readLong(input);        if ("CFF ".equals(tagName)) {            byte[] bytes2 = Arrays.copyOfRange(bytes, (int) offset, (int) (offset + length));            return new CFFDataInput(bytes2);        }    }    throw new IOException("CFF tag not found in this OpenType font.");}
private static String pdfbox_f1155_0(CFFDataInput input) throws IOException
{    byte[] b = input.readBytes(4);    return new String(b, Charsets.ISO_8859_1);}
private static long pdfbox_f1156_0(CFFDataInput input) throws IOException
{    return (input.readCard16() << 16) | input.readCard16();}
private static Header pdfbox_f1157_0(CFFDataInput input) throws IOException
{    Header cffHeader = new Header();    cffHeader.major = input.readCard8();    cffHeader.minor = input.readCard8();    cffHeader.hdrSize = input.readCard8();    cffHeader.offSize = input.readOffSize();    return cffHeader;}
private static int[] pdfbox_f1158_0(CFFDataInput input) throws IOException
{    int count = input.readCard16();    if (count == 0) {        return null;    }    int offSize = input.readOffSize();    int[] offsets = new int[count + 1];    for (int i = 0; i <= count; i++) {        int offset = input.readOffset(offSize);        if (offset > input.length()) {            throw new IOException("illegal offset value " + offset + " in CFF font");        }        offsets[i] = offset;    }    return offsets;}
private static byte[][] pdfbox_f1159_0(CFFDataInput input) throws IOException
{    int[] offsets = readIndexDataOffsets(input);    if (offsets == null) {        return null;    }    int count = offsets.length - 1;    byte[][] indexDataValues = new byte[count][];    for (int i = 0; i < count; i++) {        int length = offsets[i + 1] - offsets[i];        indexDataValues[i] = input.readBytes(length);    }    return indexDataValues;}
private static String[] pdfbox_f1160_0(CFFDataInput input) throws IOException
{    int[] offsets = readIndexDataOffsets(input);    if (offsets == null) {        return null;    }    int count = offsets.length - 1;    String[] indexDataValues = new String[count];    for (int i = 0; i < count; i++) {        int length = offsets[i + 1] - offsets[i];        if (length < 0) {            throw new IOException("Negative index data length + " + length + " at " + i + ": offsets[" + (i + 1) + "]=" + offsets[i + 1] + ", offsets[" + i + "]=" + offsets[i]);        }        indexDataValues[i] = new String(input.readBytes(length), Charsets.ISO_8859_1);    }    return indexDataValues;}
private static DictData pdfbox_f1161_0(CFFDataInput input) throws IOException
{    DictData dict = new DictData();    while (input.hasRemaining()) {        dict.add(readEntry(input));    }    return dict;}
private static DictData pdfbox_f1162_0(CFFDataInput input, int dictSize) throws IOException
{    DictData dict = new DictData();    int endPosition = input.getPosition() + dictSize;    while (input.getPosition() < endPosition) {        dict.add(readEntry(input));    }    return dict;}
private static DictData.Entry pdfbox_f1163_0(CFFDataInput input) throws IOException
{    DictData.Entry entry = new DictData.Entry();    while (true) {        int b0 = input.readUnsignedByte();        if (b0 >= 0 && b0 <= 21) {            entry.operator = readOperator(input, b0);            break;        } else if (b0 == 28 || b0 == 29) {            entry.operands.add(readIntegerNumber(input, b0));        } else if (b0 == 30) {            entry.operands.add(readRealNumber(input, b0));        } else if (b0 >= 32 && b0 <= 254) {            entry.operands.add(readIntegerNumber(input, b0));        } else {            throw new IOException("invalid DICT data b0 byte: " + b0);        }    }    return entry;}
private static CFFOperator pdfbox_f1164_0(CFFDataInput input, int b0) throws IOException
{    CFFOperator.Key key = readOperatorKey(input, b0);    return CFFOperator.getOperator(key);}
private static CFFOperator.Key pdfbox_f1165_0(CFFDataInput input, int b0) throws IOException
{    if (b0 == 12) {        int b1 = input.readUnsignedByte();        return new CFFOperator.Key(b0, b1);    }    return new CFFOperator.Key(b0);}
private static Integer pdfbox_f1166_0(CFFDataInput input, int b0) throws IOException
{    if (b0 == 28) {        return (int) input.readShort();    } else if (b0 == 29) {        return input.readInt();    } else if (b0 >= 32 && b0 <= 246) {        return b0 - 139;    } else if (b0 >= 247 && b0 <= 250) {        int b1 = input.readUnsignedByte();        return (b0 - 247) * 256 + b1 + 108;    } else if (b0 >= 251 && b0 <= 254) {        int b1 = input.readUnsignedByte();        return -(b0 - 251) * 256 - b1 - 108;    } else {        throw new IllegalArgumentException();    }}
private static Double pdfbox_f1167_1(CFFDataInput input, int b0) throws IOException
{    StringBuilder sb = new StringBuilder();    boolean done = false;    boolean exponentMissing = false;    boolean hasExponent = false;    while (!done) {        int b = input.readUnsignedByte();        int[] nibbles = { b / 16, b % 16 };        for (int nibble : nibbles) {            switch(nibble) {                case 0x0:                case 0x1:                case 0x2:                case 0x3:                case 0x4:                case 0x5:                case 0x6:                case 0x7:                case 0x8:                case 0x9:                    sb.append(nibble);                    exponentMissing = false;                    break;                case 0xa:                    sb.append(".");                    break;                case 0xb:                    if (hasExponent) {                                                break;                    }                    sb.append("E");                    exponentMissing = true;                    hasExponent = true;                    break;                case 0xc:                    if (hasExponent) {                                                break;                    }                    sb.append("E-");                    exponentMissing = true;                    hasExponent = true;                    break;                case 0xd:                    break;                case 0xe:                    sb.append("-");                    break;                case 0xf:                    done = true;                    break;                default:                    throw new IllegalArgumentException();            }        }    }    if (exponentMissing) {                                sb.append("0");    }    if (sb.length() == 0) {        return 0d;    }    return Double.valueOf(sb.toString());}
private CFFFont pdfbox_f1168_1(CFFDataInput input, String name, byte[] topDictIndex) throws IOException
{        CFFDataInput topDictInput = new CFFDataInput(topDictIndex);    DictData topDict = readDictData(topDictInput);        DictData.Entry syntheticBaseEntry = topDict.getEntry("SyntheticBase");    if (syntheticBaseEntry != null) {        throw new IOException("Synthetic Fonts are not supported");    }        CFFFont font;    boolean isCIDFont = topDict.getEntry("ROS") != null;    if (isCIDFont) {        font = new CFFCIDFont();        DictData.Entry rosEntry = topDict.getEntry("ROS");        ((CFFCIDFont) font).setRegistry(readString(rosEntry.getNumber(0).intValue()));        ((CFFCIDFont) font).setOrdering(readString(rosEntry.getNumber(1).intValue()));        ((CFFCIDFont) font).setSupplement(rosEntry.getNumber(2).intValue());    } else {        font = new CFFType1Font();    }        debugFontName = name;    font.setName(name);        font.addValueToTopDict("version", getString(topDict, "version"));    font.addValueToTopDict("Notice", getString(topDict, "Notice"));    font.addValueToTopDict("Copyright", getString(topDict, "Copyright"));    font.addValueToTopDict("FullName", getString(topDict, "FullName"));    font.addValueToTopDict("FamilyName", getString(topDict, "FamilyName"));    font.addValueToTopDict("Weight", getString(topDict, "Weight"));    font.addValueToTopDict("isFixedPitch", topDict.getBoolean("isFixedPitch", false));    font.addValueToTopDict("ItalicAngle", topDict.getNumber("ItalicAngle", 0));    font.addValueToTopDict("UnderlinePosition", topDict.getNumber("UnderlinePosition", -100));    font.addValueToTopDict("UnderlineThickness", topDict.getNumber("UnderlineThickness", 50));    font.addValueToTopDict("PaintType", topDict.getNumber("PaintType", 0));    font.addValueToTopDict("CharstringType", topDict.getNumber("CharstringType", 2));    font.addValueToTopDict("FontMatrix", topDict.getArray("FontMatrix", Arrays.<Number>asList(0.001, (double) 0, (double) 0, 0.001, (double) 0, (double) 0)));    font.addValueToTopDict("UniqueID", topDict.getNumber("UniqueID", null));    font.addValueToTopDict("FontBBox", topDict.getArray("FontBBox", Arrays.<Number>asList(0, 0, 0, 0)));    font.addValueToTopDict("StrokeWidth", topDict.getNumber("StrokeWidth", 0));    font.addValueToTopDict("XUID", topDict.getArray("XUID", null));        DictData.Entry charStringsEntry = topDict.getEntry("CharStrings");    int charStringsOffset = charStringsEntry.getNumber(0).intValue();    input.setPosition(charStringsOffset);    byte[][] charStringsIndex = readIndexData(input);        DictData.Entry charsetEntry = topDict.getEntry("charset");    CFFCharset charset;    if (charsetEntry != null) {        int charsetId = charsetEntry.getNumber(0).intValue();        if (!isCIDFont && charsetId == 0) {            charset = CFFISOAdobeCharset.getInstance();        } else if (!isCIDFont && charsetId == 1) {            charset = CFFExpertCharset.getInstance();        } else if (!isCIDFont && charsetId == 2) {            charset = CFFExpertSubsetCharset.getInstance();        } else if (charStringsIndex != null) {            input.setPosition(charsetId);            charset = readCharset(input, charStringsIndex.length, isCIDFont);        } else         {                        charset = new EmptyCharset(0);        }    } else {        if (isCIDFont) {                        int numEntries = charStringsIndex == null ? 0 : charStringsIndex.length;                        charset = new EmptyCharset(numEntries);        } else {            charset = CFFISOAdobeCharset.getInstance();        }    }    font.setCharset(charset);        font.charStrings = charStringsIndex;        if (isCIDFont) {                int numEntries = 0;        if (charStringsIndex == null) {                    } else {            numEntries = charStringsIndex.length;        }        parseCIDFontDicts(input, topDict, (CFFCIDFont) font, numEntries);        List<Number> privMatrix = null;        List<Map<String, Object>> fontDicts = ((CFFCIDFont) font).getFontDicts();        if (!fontDicts.isEmpty() && fontDicts.get(0).containsKey("FontMatrix")) {            privMatrix = (List<Number>) fontDicts.get(0).get("FontMatrix");        }                List<Number> matrix = topDict.getArray("FontMatrix", null);        if (matrix == null) {            if (privMatrix != null) {                font.addValueToTopDict("FontMatrix", privMatrix);            } else {                                font.addValueToTopDict("FontMatrix", topDict.getArray("FontMatrix", Arrays.<Number>asList(0.001, (double) 0, (double) 0, 0.001, (double) 0, (double) 0)));            }        } else if (privMatrix != null) {                                                concatenateMatrix(matrix, privMatrix);        }    } else {        parseType1Dicts(input, topDict, (CFFType1Font) font, charset);    }    return font;}
private void pdfbox_f1169_0(List<Number> matrixDest, List<Number> matrixConcat)
{                    double a1 = matrixDest.get(0).doubleValue();    double b1 = matrixDest.get(1).doubleValue();    double c1 = matrixDest.get(2).doubleValue();    double d1 = matrixDest.get(3).doubleValue();    double x1 = matrixDest.get(4).doubleValue();    double y1 = matrixDest.get(5).doubleValue();    double a2 = matrixConcat.get(0).doubleValue();    double b2 = matrixConcat.get(1).doubleValue();    double c2 = matrixConcat.get(2).doubleValue();    double d2 = matrixConcat.get(3).doubleValue();    double x2 = matrixConcat.get(4).doubleValue();    double y2 = matrixConcat.get(5).doubleValue();    matrixDest.set(0, a1 * a2 + b1 * c2);    matrixDest.set(1, a1 * b2 + b1 * d1);    matrixDest.set(2, c1 * a2 + d1 * c2);    matrixDest.set(3, c1 * b2 + d1 * d2);    matrixDest.set(4, x1 * a2 + y1 * c2 + x2);    matrixDest.set(5, x1 * b2 + y1 * d2 + y2);}
private void pdfbox_f1170_0(CFFDataInput input, DictData topDict, CFFCIDFont font, int nrOfcharStrings) throws IOException
{            DictData.Entry fdArrayEntry = topDict.getEntry("FDArray");    if (fdArrayEntry == null) {        throw new IOException("FDArray is missing for a CIDKeyed Font.");    }        int fontDictOffset = fdArrayEntry.getNumber(0).intValue();    input.setPosition(fontDictOffset);    byte[][] fdIndex = readIndexData(input);    List<Map<String, Object>> privateDictionaries = new LinkedList<>();    List<Map<String, Object>> fontDictionaries = new LinkedList<>();    for (byte[] bytes : fdIndex) {        CFFDataInput fontDictInput = new CFFDataInput(bytes);        DictData fontDict = readDictData(fontDictInput);                DictData.Entry privateEntry = fontDict.getEntry("Private");        if (privateEntry == null) {            throw new IOException("Font DICT invalid without \"Private\" entry");        }                Map<String, Object> fontDictMap = new LinkedHashMap<>(4);        fontDictMap.put("FontName", getString(fontDict, "FontName"));        fontDictMap.put("FontType", fontDict.getNumber("FontType", 0));        fontDictMap.put("FontBBox", fontDict.getArray("FontBBox", null));        fontDictMap.put("FontMatrix", fontDict.getArray("FontMatrix", null));                fontDictionaries.add(fontDictMap);        int privateOffset = privateEntry.getNumber(1).intValue();        input.setPosition(privateOffset);        int privateSize = privateEntry.getNumber(0).intValue();        DictData privateDict = readDictData(input, privateSize);                Map<String, Object> privDict = readPrivateDict(privateDict);        privateDictionaries.add(privDict);                int localSubrOffset = (Integer) privateDict.getNumber("Subrs", 0);        if (localSubrOffset > 0) {            input.setPosition(privateOffset + localSubrOffset);            privDict.put("Subrs", readIndexData(input));        }    }        DictData.Entry fdSelectEntry = topDict.getEntry("FDSelect");    int fdSelectPos = fdSelectEntry.getNumber(0).intValue();    input.setPosition(fdSelectPos);    FDSelect fdSelect = readFDSelect(input, nrOfcharStrings, font);                font.setFontDict(fontDictionaries);    font.setPrivDict(privateDictionaries);    font.setFdSelect(fdSelect);}
private Map<String, Object> pdfbox_f1171_0(DictData privateDict)
{    Map<String, Object> privDict = new LinkedHashMap<>(17);    privDict.put("BlueValues", privateDict.getDelta("BlueValues", null));    privDict.put("OtherBlues", privateDict.getDelta("OtherBlues", null));    privDict.put("FamilyBlues", privateDict.getDelta("FamilyBlues", null));    privDict.put("FamilyOtherBlues", privateDict.getDelta("FamilyOtherBlues", null));    privDict.put("BlueScale", privateDict.getNumber("BlueScale", 0.039625));    privDict.put("BlueShift", privateDict.getNumber("BlueShift", 7));    privDict.put("BlueFuzz", privateDict.getNumber("BlueFuzz", 1));    privDict.put("StdHW", privateDict.getNumber("StdHW", null));    privDict.put("StdVW", privateDict.getNumber("StdVW", null));    privDict.put("StemSnapH", privateDict.getDelta("StemSnapH", null));    privDict.put("StemSnapV", privateDict.getDelta("StemSnapV", null));    privDict.put("ForceBold", privateDict.getBoolean("ForceBold", false));    privDict.put("LanguageGroup", privateDict.getNumber("LanguageGroup", 0));    privDict.put("ExpansionFactor", privateDict.getNumber("ExpansionFactor", 0.06));    privDict.put("initialRandomSeed", privateDict.getNumber("initialRandomSeed", 0));    privDict.put("defaultWidthX", privateDict.getNumber("defaultWidthX", 0));    privDict.put("nominalWidthX", privateDict.getNumber("nominalWidthX", 0));    return privDict;}
private void pdfbox_f1172_0(CFFDataInput input, DictData topDict, CFFType1Font font, CFFCharset charset) throws IOException
{        DictData.Entry encodingEntry = topDict.getEntry("Encoding");    CFFEncoding encoding;    int encodingId = encodingEntry != null ? encodingEntry.getNumber(0).intValue() : 0;    switch(encodingId) {        case 0:            encoding = CFFStandardEncoding.getInstance();            break;        case 1:            encoding = CFFExpertEncoding.getInstance();            break;        default:            input.setPosition(encodingId);            encoding = readEncoding(input, charset);            break;    }    font.setEncoding(encoding);        DictData.Entry privateEntry = topDict.getEntry("Private");    if (privateEntry == null) {        throw new IOException("Private dictionary entry missing for font " + font.fontName);    }    int privateOffset = privateEntry.getNumber(1).intValue();    input.setPosition(privateOffset);    int privateSize = privateEntry.getNumber(0).intValue();    DictData privateDict = readDictData(input, privateSize);        Map<String, Object> privDict = readPrivateDict(privateDict);    for (Map.Entry<String, Object> entry : privDict.entrySet()) {        font.addToPrivateDict(entry.getKey(), entry.getValue());    }        int localSubrOffset = (Integer) privateDict.getNumber("Subrs", 0);    if (localSubrOffset > 0) {        input.setPosition(privateOffset + localSubrOffset);        font.addToPrivateDict("Subrs", readIndexData(input));    }}
private String pdfbox_f1173_0(int index) throws IOException
{    if (index >= 0 && index <= 390) {        return CFFStandardString.getName(index);    }    if (index - 391 < stringIndex.length) {        return stringIndex[index - 391];    } else {                return "SID" + index;    }}
private String pdfbox_f1174_0(DictData dict, String name) throws IOException
{    DictData.Entry entry = dict.getEntry(name);    return entry != null ? readString(entry.getNumber(0).intValue()) : null;}
private CFFEncoding pdfbox_f1175_0(CFFDataInput dataInput, CFFCharset charset) throws IOException
{    int format = dataInput.readCard8();    int baseFormat = format & 0x7f;    switch(baseFormat) {        case 0:            return readFormat0Encoding(dataInput, charset, format);        case 1:            return readFormat1Encoding(dataInput, charset, format);        default:            throw new IllegalArgumentException();    }}
private Format0Encoding pdfbox_f1176_0(CFFDataInput dataInput, CFFCharset charset, int format) throws IOException
{    Format0Encoding encoding = new Format0Encoding();    encoding.format = format;    encoding.nCodes = dataInput.readCard8();    encoding.add(0, 0, ".notdef");    for (int gid = 1; gid <= encoding.nCodes; gid++) {        int code = dataInput.readCard8();        int sid = charset.getSIDForGID(gid);        encoding.add(code, sid, readString(sid));    }    if ((format & 0x80) != 0) {        readSupplement(dataInput, encoding);    }    return encoding;}
private Format1Encoding pdfbox_f1177_0(CFFDataInput dataInput, CFFCharset charset, int format) throws IOException
{    Format1Encoding encoding = new Format1Encoding();    encoding.format = format;    encoding.nRanges = dataInput.readCard8();    encoding.add(0, 0, ".notdef");    int gid = 1;    for (int i = 0; i < encoding.nRanges; i++) {        int rangeFirst = dataInput.readCard8();        int rangeLeft = dataInput.readCard8();        for (int j = 0; j < 1 + rangeLeft; j++) {            int sid = charset.getSIDForGID(gid);            int code = rangeFirst + j;            encoding.add(code, sid, readString(sid));            gid++;        }    }    if ((format & 0x80) != 0) {        readSupplement(dataInput, encoding);    }    return encoding;}
private void pdfbox_f1178_0(CFFDataInput dataInput, CFFBuiltInEncoding encoding) throws IOException
{    encoding.nSups = dataInput.readCard8();    encoding.supplement = new CFFBuiltInEncoding.Supplement[encoding.nSups];    for (int i = 0; i < encoding.supplement.length; i++) {        CFFBuiltInEncoding.Supplement supplement = new CFFBuiltInEncoding.Supplement();        supplement.code = dataInput.readCard8();        supplement.sid = dataInput.readSID();        supplement.name = readString(supplement.sid);        encoding.supplement[i] = supplement;        encoding.add(supplement.code, supplement.sid, readString(supplement.sid));    }}
private static FDSelect pdfbox_f1179_0(CFFDataInput dataInput, int nGlyphs, CFFCIDFont ros) throws IOException
{    int format = dataInput.readCard8();    switch(format) {        case 0:            return readFormat0FDSelect(dataInput, format, nGlyphs, ros);        case 3:            return readFormat3FDSelect(dataInput, format, nGlyphs, ros);        default:            throw new IllegalArgumentException();    }}
private static Format0FDSelect pdfbox_f1180_0(CFFDataInput dataInput, int format, int nGlyphs, CFFCIDFont ros) throws IOException
{    Format0FDSelect fdselect = new Format0FDSelect(ros);    fdselect.format = format;    fdselect.fds = new int[nGlyphs];    for (int i = 0; i < fdselect.fds.length; i++) {        fdselect.fds[i] = dataInput.readCard8();    }    return fdselect;}
private static Format3FDSelect pdfbox_f1181_0(CFFDataInput dataInput, int format, int nGlyphs, CFFCIDFont ros) throws IOException
{    Format3FDSelect fdselect = new Format3FDSelect(ros);    fdselect.format = format;    fdselect.nbRanges = dataInput.readCard16();    fdselect.range3 = new Range3[fdselect.nbRanges];    for (int i = 0; i < fdselect.nbRanges; i++) {        Range3 r3 = new Range3();        r3.first = dataInput.readCard16();        r3.fd = dataInput.readCard8();        fdselect.range3[i] = r3;    }    fdselect.sentinel = dataInput.readCard16();    return fdselect;}
public int pdfbox_f1182_0(int gid)
{    for (int i = 0; i < nbRanges; ++i) {        if (range3[i].first <= gid) {            if (i + 1 < nbRanges) {                if (range3[i + 1].first > gid) {                    return range3[i].fd;                }                        } else {                                if (sentinel > gid) {                    return range3[i].fd;                }                return -1;            }        }    }    return 0;}
public String pdfbox_f1183_0()
{    return getClass().getName() + "[format=" + format + " nbRanges=" + nbRanges + ", range3=" + Arrays.toString(range3) + " sentinel=" + sentinel + "]";}
public String pdfbox_f1184_0()
{    return getClass().getName() + "[first=" + first + ", fd=" + fd + "]";}
public int pdfbox_f1185_0(int gid)
{    if (gid < fds.length) {        return fds[gid];    }    return 0;}
public String pdfbox_f1186_0()
{    return getClass().getName() + "[fds=" + Arrays.toString(fds) + "]";}
private CFFCharset pdfbox_f1187_0(CFFDataInput dataInput, int nGlyphs, boolean isCIDFont) throws IOException
{    int format = dataInput.readCard8();    switch(format) {        case 0:            return readFormat0Charset(dataInput, format, nGlyphs, isCIDFont);        case 1:            return readFormat1Charset(dataInput, format, nGlyphs, isCIDFont);        case 2:            return readFormat2Charset(dataInput, format, nGlyphs, isCIDFont);        default:            throw new IllegalArgumentException();    }}
private Format0Charset pdfbox_f1188_0(CFFDataInput dataInput, int format, int nGlyphs, boolean isCIDFont) throws IOException
{    Format0Charset charset = new Format0Charset(isCIDFont);    charset.format = format;    if (isCIDFont) {        charset.addCID(0, 0);    } else {        charset.addSID(0, 0, ".notdef");    }    for (int gid = 1; gid < nGlyphs; gid++) {        int sid = dataInput.readSID();        if (isCIDFont) {            charset.addCID(gid, sid);        } else {            charset.addSID(gid, sid, readString(sid));        }    }    return charset;}
private Format1Charset pdfbox_f1189_0(CFFDataInput dataInput, int format, int nGlyphs, boolean isCIDFont) throws IOException
{    Format1Charset charset = new Format1Charset(isCIDFont);    charset.format = format;    if (isCIDFont) {        charset.addCID(0, 0);        charset.rangesCID2GID = new ArrayList<>();    } else {        charset.addSID(0, 0, ".notdef");    }    for (int gid = 1; gid < nGlyphs; gid++) {        int rangeFirst = dataInput.readSID();        int rangeLeft = dataInput.readCard8();        if (!isCIDFont) {            for (int j = 0; j < 1 + rangeLeft; j++) {                int sid = rangeFirst + j;                charset.addSID(gid + j, sid, readString(sid));            }        } else {            charset.rangesCID2GID.add(new RangeMapping(gid, rangeFirst, rangeLeft));        }        gid += rangeLeft;    }    return charset;}
private Format2Charset pdfbox_f1190_0(CFFDataInput dataInput, int format, int nGlyphs, boolean isCIDFont) throws IOException
{    Format2Charset charset = new Format2Charset(isCIDFont);    charset.format = format;    if (isCIDFont) {        charset.addCID(0, 0);        charset.rangesCID2GID = new ArrayList<>();    } else {        charset.addSID(0, 0, ".notdef");    }    for (int gid = 1; gid < nGlyphs; gid++) {        int first = dataInput.readSID();        int nLeft = dataInput.readCard16();        if (!isCIDFont) {            for (int j = 0; j < 1 + nLeft; j++) {                int sid = first + j;                charset.addSID(gid + j, sid, readString(sid));            }        } else {            charset.rangesCID2GID.add(new RangeMapping(gid, first, nLeft));        }        gid += nLeft;    }    return charset;}
public String pdfbox_f1191_0()
{    return getClass().getName() + "[major=" + major + ", minor=" + minor + ", hdrSize=" + hdrSize + ", offSize=" + offSize + "]";}
public void pdfbox_f1192_0(Entry entry)
{    if (entry.operator != null) {        entries.put(entry.operator.getName(), entry);    }}
public Entry pdfbox_f1193_0(String name)
{    return entries.get(name);}
public Boolean pdfbox_f1194_0(String name, boolean defaultValue)
{    Entry entry = getEntry(name);    return entry != null && !entry.getArray().isEmpty() ? entry.getBoolean(0) : defaultValue;}
public List<Number> pdfbox_f1195_0(String name, List<Number> defaultValue)
{    Entry entry = getEntry(name);    return entry != null && !entry.getArray().isEmpty() ? entry.getArray() : defaultValue;}
public Number pdfbox_f1196_0(String name, Number defaultValue)
{    Entry entry = getEntry(name);    return entry != null && !entry.getArray().isEmpty() ? entry.getNumber(0) : defaultValue;}
public List<Number> pdfbox_f1197_0(String name, List<Number> defaultValue)
{    Entry entry = getEntry(name);    return entry != null && !entry.getArray().isEmpty() ? entry.getDelta() : defaultValue;}
public String pdfbox_f1198_0()
{    return getClass().getName() + "[entries=" + entries + "]";}
public Number pdfbox_f1199_0(int index)
{    return operands.get(index);}
public Boolean pdfbox_f1200_0(int index)
{    Number operand = operands.get(index);    if (operand instanceof Integer) {        switch(operand.intValue()) {            case 0:                return Boolean.FALSE;            case 1:                return Boolean.TRUE;            default:                break;        }    }    throw new IllegalArgumentException();}
public List<Number> pdfbox_f1201_0()
{    return operands;}
public List<Number> pdfbox_f1202_0()
{    List<Number> result = new ArrayList<>(operands);    for (int i = 1; i < result.size(); i++) {        Number previous = result.get(i - 1);        Number current = result.get(i);        Integer sum = previous.intValue() + current.intValue();        result.set(i, sum);    }    return result;}
public String pdfbox_f1203_0()
{    return getClass().getName() + "[operands=" + operands + ", operator=" + operator + "]";}
public int pdfbox_f1204_0()
{    return code;}
public int pdfbox_f1205_0()
{    return sid;}
public String pdfbox_f1206_0()
{    return name;}
public String pdfbox_f1207_0()
{    return getClass().getName() + "[code=" + code + ", sid=" + sid + "]";}
public String pdfbox_f1208_0()
{    return getClass().getName() + "[format=" + format + ", nCodes=" + nCodes + ", supplement=" + Arrays.toString(super.supplement) + "]";}
public String pdfbox_f1209_0()
{    return getClass().getName() + "[format=" + format + ", nRanges=" + nRanges + ", supplement=" + Arrays.toString(super.supplement) + "]";}
public String pdfbox_f1210_0()
{    return getClass().getName();}
public String pdfbox_f1211_0()
{    return getClass().getName() + "[format=" + format + "]";}
public int pdfbox_f1212_0(int gid)
{    if (isCIDFont()) {        for (RangeMapping mapping : rangesCID2GID) {            if (mapping.isInRange(gid)) {                return mapping.mapValue(gid);            }        }    }    return super.getCIDForGID(gid);}
public int pdfbox_f1213_0(int cid)
{    if (isCIDFont()) {        for (RangeMapping mapping : rangesCID2GID) {            if (mapping.isInReverseRange(cid)) {                return mapping.mapReverseValue(cid);            }        }    }    return super.getGIDForCID(cid);}
public String pdfbox_f1214_0()
{    return getClass().getName() + "[format=" + format + "]";}
public int pdfbox_f1215_0(int gid)
{    for (RangeMapping mapping : rangesCID2GID) {        if (mapping.isInRange(gid)) {            return mapping.mapValue(gid);        }    }    return super.getCIDForGID(gid);}
public int pdfbox_f1216_0(int cid)
{    for (RangeMapping mapping : rangesCID2GID) {        if (mapping.isInReverseRange(cid)) {            return mapping.mapReverseValue(cid);        }    }    return super.getGIDForCID(cid);}
public String pdfbox_f1217_0()
{    return getClass().getName() + "[format=" + format + "]";}
 boolean pdfbox_f1218_0(int value)
{    return value >= startValue && value <= endValue;}
 boolean pdfbox_f1219_0(int value)
{    return value >= startMappedValue && value <= endMappedValue;}
 int pdfbox_f1220_0(int value)
{    if (isInRange(value)) {        return startMappedValue + (value - startValue);    } else {        return 0;    }}
 int pdfbox_f1221_0(int value)
{    if (isInReverseRange(value)) {        return startValue + (value - startMappedValue);    } else {        return 0;    }}
public String pdfbox_f1222_0()
{    return getClass().getName() + "[start value=" + startValue + ", end value=" + endValue + ", start mapped-value=" + startMappedValue + ", end mapped-value=" + endMappedValue + "]";}
public String pdfbox_f1223_0()
{    return getClass().getSimpleName() + "[" + debugFontName + "]";}
public static CFFStandardEncoding pdfbox_f1224_0()
{    return CFFStandardEncoding.INSTANCE;}
public static String pdfbox_f1225_0(int sid)
{    return SID2STR[sid];}
public Type1CharString pdfbox_f1226_0(String name) throws IOException
{    return CFFType1Font.this.getType1CharString(name);}
public GeneralPath pdfbox_f1227_0(String name) throws IOException
{    return getType1CharString(name).getPath();}
public float pdfbox_f1228_0(String name) throws IOException
{    return getType1CharString(name).getWidth();}
public boolean pdfbox_f1229_0(String name)
{    int sid = charset.getSID(name);    int gid = charset.getGIDForSID(sid);    return gid != 0;}
public List<Number> pdfbox_f1230_0()
{    return (List<Number>) topDict.get("FontMatrix");}
public Type1CharString pdfbox_f1231_0(String name) throws IOException
{        int gid = nameToGID(name);        return getType2CharString(gid, name);}
public int pdfbox_f1232_0(String name)
{        int sid = charset.getSID(name);    return charset.getGIDForSID(sid);}
public Type2CharString pdfbox_f1233_0(int gid) throws IOException
{        String name = "GID+" + gid;    return getType2CharString(gid, name);}
private Type2CharString pdfbox_f1234_0(int gid, String name) throws IOException
{    Type2CharString type2 = charStringCache.get(gid);    if (type2 == null) {        byte[] bytes = null;        if (gid < charStrings.length) {            bytes = charStrings[gid];        }        if (bytes == null) {                        bytes = charStrings[0];        }        Type2CharStringParser parser = new Type2CharStringParser(fontName, name);        List<Object> type2seq = parser.parse(bytes, globalSubrIndex, getLocalSubrIndex());        type2 = new Type2CharString(reader, fontName, name, gid, type2seq, getDefaultWidthX(), getNominalWidthX());        charStringCache.put(gid, type2);    }    return type2;}
public Map<String, Object> pdfbox_f1235_0()
{    return privateDict;}
 void pdfbox_f1236_0(String name, Object value)
{    if (value != null) {        privateDict.put(name, value);    }}
public CFFEncoding pdfbox_f1237_0()
{    return encoding;}
 void pdfbox_f1238_0(CFFEncoding encoding)
{    this.encoding = encoding;}
private byte[][] pdfbox_f1239_0()
{    return (byte[][]) privateDict.get("Subrs");}
private Object pdfbox_f1240_0(String name)
{    Object topDictValue = topDict.get(name);    if (topDictValue != null) {        return topDictValue;    }    Object privateDictValue = privateDict.get(name);    if (privateDictValue != null) {        return privateDictValue;    }    return null;}
private int pdfbox_f1241_0()
{    Number num = (Number) getProperty("defaultWidthX");    if (num == null) {        return 1000;    }    return num.intValue();}
private int pdfbox_f1242_0()
{    Number num = (Number) getProperty("nominalWidthX");    if (num == null) {        return 0;    }    return num.intValue();}
public Key pdfbox_f1243_0()
{    return commandKey;}
private void pdfbox_f1244_0(Key key)
{    commandKey = key;}
public String pdfbox_f1245_0()
{    String str = TYPE2_VOCABULARY.get(getKey());    if (str == null) {        str = TYPE1_VOCABULARY.get(getKey());    }    if (str == null) {        return getKey().toString() + '|';    }    return str + '|';}
public int pdfbox_f1246_0()
{    return getKey().hashCode();}
public boolean pdfbox_f1247_0(Object object)
{    if (object instanceof CharStringCommand) {        CharStringCommand that = (CharStringCommand) object;        return getKey().equals(that.getKey());    }    return false;}
public int[] pdfbox_f1248_0()
{    return keyValues;}
private void pdfbox_f1249_0(int[] value)
{    keyValues = value;}
public String pdfbox_f1250_0()
{    return Arrays.toString(getValue());}
public int pdfbox_f1251_0()
{    if (keyValues[0] == 12 && keyValues.length > 1) {        return keyValues[0] ^ keyValues[1];    }    return keyValues[0];}
public boolean pdfbox_f1252_0(Object object)
{    if (object instanceof Key) {        Key that = (Key) object;        if (keyValues[0] == 12 && that.keyValues[0] == 12) {            if (keyValues.length > 1 && that.keyValues.length > 1) {                return keyValues[1] == that.keyValues[1];            }            return keyValues.length == that.keyValues.length;        }        return keyValues[0] == that.keyValues[0];    }    return false;}
 List<Number> pdfbox_f1253_0(List<Object> sequence)
{    Stack<Number> stack = new Stack<>();    sequence.forEach(obj -> {        if (obj instanceof CharStringCommand) {            List<Number> results = handleCommand(stack, (CharStringCommand) obj);                        stack.clear();            stack.addAll(results);        } else {            stack.push((Number) obj);        }    });    return stack;}
public int pdfbox_f1254_0()
{    return cid;}
public boolean pdfbox_f1255_0()
{    return bufferPosition < inputBuffer.length;}
public int pdfbox_f1256_0()
{    return bufferPosition;}
public void pdfbox_f1257_0(int position)
{    bufferPosition = position;}
public String pdfbox_f1258_0() throws IOException
{    return new String(inputBuffer, Charsets.ISO_8859_1);}
public byte pdfbox_f1259_1() throws IOException
{    try {        byte value = inputBuffer[bufferPosition];        bufferPosition++;        return value;    } catch (RuntimeException re) {                return -1;    }}
public int pdfbox_f1260_0() throws IOException
{    int b = read();    if (b < 0) {        throw new EOFException();    }    return b;}
public int pdfbox_f1261_0(int offset) throws IOException
{    int b = peek(offset);    if (b < 0) {        throw new EOFException();    }    return b;}
public short pdfbox_f1262_0() throws IOException
{    return (short) readUnsignedShort();}
public int pdfbox_f1263_0() throws IOException
{    int b1 = read();    int b2 = read();    if ((b1 | b2) < 0) {        throw new EOFException();    }    return b1 << 8 | b2;}
public int pdfbox_f1264_0() throws IOException
{    int b1 = read();    int b2 = read();    int b3 = read();    int b4 = read();    if ((b1 | b2 | b3 | b4) < 0) {        throw new EOFException();    }    return b1 << 24 | b2 << 16 | b3 << 8 | b4;}
public byte[] pdfbox_f1265_0(int length) throws IOException
{    if (inputBuffer.length - bufferPosition < length) {        throw new EOFException();    }    byte[] bytes = new byte[length];    System.arraycopy(inputBuffer, bufferPosition, bytes, 0, length);    bufferPosition += length;    return bytes;}
private int pdfbox_f1266_1()
{    try {        int value = inputBuffer[bufferPosition] & 0xff;        bufferPosition++;        return value;    } catch (RuntimeException re) {                return -1;    }}
private int pdfbox_f1267_1(int offset)
{    try {        return inputBuffer[bufferPosition + offset] & 0xff;    } catch (RuntimeException re) {                return -1;    }}
public int pdfbox_f1268_0()
{    return inputBuffer.length;}
public byte[] pdfbox_f1269_0()
{    return outputBuffer.toByteArray();}
public void pdfbox_f1270_0(int value)
{    outputBuffer.write(value);}
public void pdfbox_f1271_0(byte[] buffer)
{    outputBuffer.write(buffer, 0, buffer.length);}
public void pdfbox_f1272_0(byte[] buffer, int offset, int length)
{    outputBuffer.write(buffer, offset, length);}
public void pdfbox_f1273_0(String string) throws IOException
{    write(string.getBytes(outputEncoding));}
public void pdfbox_f1274_0(String string) throws IOException
{    write(string.getBytes(outputEncoding));    write('\n');}
public void pdfbox_f1275_0()
{    write('\n');}
public String pdfbox_f1276_0()
{    return glyphName;}
public Rectangle2D pdfbox_f1277_0()
{    synchronized (LOG) {        if (path == null) {            render();        }    }    return path.getBounds2D();}
public int pdfbox_f1278_0()
{    synchronized (LOG) {        if (path == null) {            render();        }    }    return width;}
public GeneralPath pdfbox_f1279_0()
{    synchronized (LOG) {        if (path == null) {            render();        }    }    return path;}
public List<Object> pdfbox_f1280_0()
{    return type1Sequence;}
private void pdfbox_f1281_0()
{    path = new GeneralPath();    leftSideBearing = new Point2D.Float(0, 0);    width = 0;    CharStringHandler handler = Type1CharString.this::handleCommand;    handler.handleSequence(type1Sequence);}
private List<Number> pdfbox_f1282_1(List<Number> numbers, CharStringCommand command)
{    commandCount++;    String name = CharStringCommand.TYPE1_VOCABULARY.get(command.getKey());    if ("rmoveto".equals(name)) {        if (numbers.size() >= 2) {            if (isFlex) {                flexPoints.add(new Point2D.Float(numbers.get(0).floatValue(), numbers.get(1).floatValue()));            } else {                rmoveTo(numbers.get(0), numbers.get(1));            }        }    } else if ("vmoveto".equals(name)) {        if (numbers.size() >= 1) {            if (isFlex) {                                flexPoints.add(new Point2D.Float(0f, numbers.get(0).floatValue()));            } else {                rmoveTo(0, numbers.get(0));            }        }    } else if ("hmoveto".equals(name)) {        if (numbers.size() >= 1) {            if (isFlex) {                                flexPoints.add(new Point2D.Float(numbers.get(0).floatValue(), 0f));            } else {                rmoveTo(numbers.get(0), 0);            }        }    } else if ("rlineto".equals(name)) {        if (numbers.size() >= 2) {            rlineTo(numbers.get(0), numbers.get(1));        }    } else if ("hlineto".equals(name)) {        if (numbers.size() >= 1) {            rlineTo(numbers.get(0), 0);        }    } else if ("vlineto".equals(name)) {        if (numbers.size() >= 1) {            rlineTo(0, numbers.get(0));        }    } else if ("rrcurveto".equals(name)) {        if (numbers.size() >= 6) {            rrcurveTo(numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), numbers.get(4), numbers.get(5));        }    } else if ("closepath".equals(name)) {        closepath();    } else if ("sbw".equals(name)) {        if (numbers.size() >= 3) {            leftSideBearing = new Point2D.Float(numbers.get(0).floatValue(), numbers.get(1).floatValue());            width = numbers.get(2).intValue();            current.setLocation(leftSideBearing);        }    } else if ("hsbw".equals(name)) {        if (numbers.size() >= 2) {            leftSideBearing = new Point2D.Float(numbers.get(0).floatValue(), 0);            width = numbers.get(1).intValue();            current.setLocation(leftSideBearing);        }    } else if ("vhcurveto".equals(name)) {        if (numbers.size() >= 4) {            rrcurveTo(0, numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), 0);        }    } else if ("hvcurveto".equals(name)) {        if (numbers.size() >= 4) {            rrcurveTo(numbers.get(0), 0, numbers.get(1), numbers.get(2), 0, numbers.get(3));        }    } else if ("seac".equals(name)) {        if (numbers.size() >= 5) {            seac(numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), numbers.get(4));        }    } else if ("setcurrentpoint".equals(name)) {        if (numbers.size() >= 2) {            setcurrentpoint(numbers.get(0), numbers.get(1));        }    } else if ("callothersubr".equals(name)) {        if (numbers.size() >= 1) {            callothersubr(numbers.get(0).intValue());        }    } else if ("div".equals(name)) {        float b = numbers.get(numbers.size() - 1).floatValue();        float a = numbers.get(numbers.size() - 2).floatValue();        float result = a / b;        List<Number> list = new ArrayList<>(numbers);        list.remove(list.size() - 1);        list.remove(list.size() - 1);        list.add(result);        return list;    } else if ("hstem".equals(name) || "vstem".equals(name) || "hstem3".equals(name) || "vstem3".equals(name) || "dotsection".equals(name)) {        } else if ("endchar".equals(name)) {        } else if ("return".equals(name)) {                    } else if (name != null) {                throw new IllegalArgumentException("Unhandled command: " + name);    } else {                    }    return Collections.emptyList();}
private void pdfbox_f1283_0(Number x, Number y)
{    current.setLocation(x.floatValue(), y.floatValue());}
private void pdfbox_f1284_1(int num)
{    if (num == 0) {                isFlex = false;        if (flexPoints.size() < 7) {                        return;        }                Point.Float reference = flexPoints.get(0);        reference.setLocation(current.getX() + reference.getX(), current.getY() + reference.getY());                Point.Float first = flexPoints.get(1);        first.setLocation(reference.getX() + first.getX(), reference.getY() + first.getY());                first.setLocation(first.getX() - current.getX(), first.getY() - current.getY());        rrcurveTo(flexPoints.get(1).getX(), flexPoints.get(1).getY(), flexPoints.get(2).getX(), flexPoints.get(2).getY(), flexPoints.get(3).getX(), flexPoints.get(3).getY());        rrcurveTo(flexPoints.get(4).getX(), flexPoints.get(4).getY(), flexPoints.get(5).getX(), flexPoints.get(5).getY(), flexPoints.get(6).getX(), flexPoints.get(6).getY());        flexPoints.clear();    } else if (num == 1) {                isFlex = true;    } else {                throw new IllegalArgumentException("Unexpected other subroutine: " + num);    }}
private void pdfbox_f1285_0(Number dx, Number dy)
{    float x = (float) current.getX() + dx.floatValue();    float y = (float) current.getY() + dy.floatValue();    path.moveTo(x, y);    current.setLocation(x, y);}
private void pdfbox_f1286_1(Number dx, Number dy)
{    float x = (float) current.getX() + dx.floatValue();    float y = (float) current.getY() + dy.floatValue();    if (path.getCurrentPoint() == null) {                path.moveTo(x, y);    } else {        path.lineTo(x, y);    }    current.setLocation(x, y);}
private void pdfbox_f1287_1(Number dx1, Number dy1, Number dx2, Number dy2, Number dx3, Number dy3)
{    float x1 = (float) current.getX() + dx1.floatValue();    float y1 = (float) current.getY() + dy1.floatValue();    float x2 = x1 + dx2.floatValue();    float y2 = y1 + dy2.floatValue();    float x3 = x2 + dx3.floatValue();    float y3 = y2 + dy3.floatValue();    if (path.getCurrentPoint() == null) {                path.moveTo(x3, y3);    } else {        path.curveTo(x1, y1, x2, y2, x3, y3);    }    current.setLocation(x3, y3);}
private void pdfbox_f1288_1()
{    if (path.getCurrentPoint() == null) {            } else {        path.closePath();    }    path.moveTo(current.getX(), current.getY());}
private void pdfbox_f1289_1(Number asb, Number adx, Number ady, Number bchar, Number achar)
{        String baseName = StandardEncoding.INSTANCE.getName(bchar.intValue());    try {        Type1CharString base = font.getType1CharString(baseName);        path.append(base.getPath().getPathIterator(null), false);    } catch (IOException e) {            }        String accentName = StandardEncoding.INSTANCE.getName(achar.intValue());    try {        Type1CharString accent = font.getType1CharString(accentName);        AffineTransform at = AffineTransform.getTranslateInstance(leftSideBearing.getX() + adx.floatValue() - asb.floatValue(), leftSideBearing.getY() + ady.floatValue());        path.append(accent.getPath().getPathIterator(at), false);    } catch (IOException e) {            }}
public String pdfbox_f1290_0()
{    return type1Sequence.toString().replace("|", "\n").replace(",", " ");}
public List<Object> pdfbox_f1291_0(byte[] bytes, List<byte[]> subrs) throws IOException
{    return parse(bytes, subrs, new ArrayList<>());}
private List<Object> pdfbox_f1292_1(byte[] bytes, List<byte[]> subrs, List<Object> sequence) throws IOException
{    DataInput input = new DataInput(bytes);    while (input.hasRemaining()) {        int b0 = input.readUnsignedByte();        if (b0 == CALLSUBR) {                        Object obj = sequence.remove(sequence.size() - 1);            if (!(obj instanceof Integer)) {                                continue;            }            Integer operand = (Integer) obj;            if (operand >= 0 && operand < subrs.size()) {                byte[] subrBytes = subrs.get(operand);                parse(subrBytes, subrs, sequence);                Object lastItem = sequence.get(sequence.size() - 1);                if (lastItem instanceof CharStringCommand && ((CharStringCommand) lastItem).getKey().getValue()[0] == RETURN) {                                        sequence.remove(sequence.size() - 1);                }            } else {                                                while (sequence.get(sequence.size() - 1) instanceof Integer) {                    sequence.remove(sequence.size() - 1);                }            }        } else if (b0 == TWO_BYTE && input.peekUnsignedByte(0) == CALLOTHERSUBR) {                        input.readByte();            Integer othersubrNum = (Integer) sequence.remove(sequence.size() - 1);            Integer numArgs = (Integer) sequence.remove(sequence.size() - 1);                        Stack<Integer> results = new Stack<>();            switch(othersubrNum) {                case 0:                    results.push(removeInteger(sequence));                    results.push(removeInteger(sequence));                    sequence.remove(sequence.size() - 1);                                        sequence.add(0);                    sequence.add(new CharStringCommand(TWO_BYTE, CALLOTHERSUBR));                    break;                case 1:                                        sequence.add(1);                    sequence.add(new CharStringCommand(TWO_BYTE, CALLOTHERSUBR));                    break;                case 3:                                        results.push(removeInteger(sequence));                    break;                default:                                        for (int i = 0; i < numArgs; i++) {                        results.push(removeInteger(sequence));                    }                    break;            }                        while (input.peekUnsignedByte(0) == TWO_BYTE && input.peekUnsignedByte(1) == POP) {                                input.readByte();                                input.readByte();                sequence.add(results.pop());            }            if (results.size() > 0) {                            }        } else if (b0 >= 0 && b0 <= 31) {            sequence.add(readCommand(input, b0));        } else if (b0 >= 32 && b0 <= 255) {            sequence.add(readNumber(input, b0));        } else {            throw new IllegalArgumentException();        }    }    return sequence;}
private static Integer pdfbox_f1293_0(List<Object> sequence) throws IOException
{    Object item = sequence.remove(sequence.size() - 1);    if (item instanceof Integer) {        return (Integer) item;    }    CharStringCommand command = (CharStringCommand) item;        if (command.getKey().getValue()[0] == 12 && command.getKey().getValue()[1] == 12) {        int a = (Integer) sequence.remove(sequence.size() - 1);        int b = (Integer) sequence.remove(sequence.size() - 1);        return b / a;    }    throw new IOException("Unexpected char string command: " + command.getKey());}
private CharStringCommand pdfbox_f1294_0(DataInput input, int b0) throws IOException
{    if (b0 == 12) {        int b1 = input.readUnsignedByte();        return new CharStringCommand(b0, b1);    }    return new CharStringCommand(b0);}
private Integer pdfbox_f1295_0(DataInput input, int b0) throws IOException
{    if (b0 >= 32 && b0 <= 246) {        return b0 - 139;    } else if (b0 >= 247 && b0 <= 250) {        int b1 = input.readUnsignedByte();        return (b0 - 247) * 256 + b1 + 108;    } else if (b0 >= 251 && b0 <= 254) {        int b1 = input.readUnsignedByte();        return -(b0 - 251) * 256 - b1 - 108;    } else if (b0 == 255) {        return input.readInt();    } else {        throw new IllegalArgumentException();    }}
public static String pdfbox_f1296_0(byte[] bytes)
{    StringBuilder sb = new StringBuilder();    for (byte aByte : bytes) {        String string = Integer.toHexString(aByte & 0xff);        if (string.length() == 1) {            sb.append("0");        }        sb.append(string.toUpperCase(Locale.US));    }    return sb.toString();}
public static byte[] pdfbox_f1297_0(String string)
{    if (string.length() % 2 != 0) {        throw new IllegalArgumentException();    }    byte[] bytes = new byte[string.length() / 2];    for (int i = 0; i < string.length(); i += 2) {        bytes[i / 2] = (byte) Integer.parseInt(string.substring(i, i + 2), 16);    }    return bytes;}
public static byte[] pdfbox_f1298_0(byte[] buffer)
{    return encrypt(buffer, 55665, 4);}
public static byte[] pdfbox_f1299_0(byte[] buffer, int n)
{    return encrypt(buffer, 4330, n);}
private static byte[] pdfbox_f1300_0(byte[] plaintextBytes, int r, int n)
{    byte[] buffer = new byte[plaintextBytes.length + n];    for (int i = 0; i < n; i++) {        buffer[i] = 0;    }    System.arraycopy(plaintextBytes, 0, buffer, n, buffer.length - n);    int c1 = 52845;    int c2 = 22719;    byte[] ciphertextBytes = new byte[buffer.length];    for (int i = 0; i < buffer.length; i++) {        int plain = buffer[i] & 0xff;        int cipher = plain ^ r >> 8;        ciphertextBytes[i] = (byte) cipher;        r = (cipher + r) * c1 + c2 & 0xffff;    }    return ciphertextBytes;}
public static byte[] pdfbox_f1301_0(byte[] buffer)
{    return decrypt(buffer, 55665, 4);}
public static byte[] pdfbox_f1302_0(byte[] buffer, int n)
{    return decrypt(buffer, 4330, n);}
private static byte[] pdfbox_f1303_0(byte[] ciphertextBytes, int r, int n)
{    byte[] buffer = new byte[ciphertextBytes.length];    int c1 = 52845;    int c2 = 22719;    for (int i = 0; i < ciphertextBytes.length; i++) {        int cipher = ciphertextBytes[i] & 0xff;        int plain = cipher ^ r >> 8;        buffer[i] = (byte) plain;        r = (cipher + r) * c1 + c2 & 0xffff;    }    byte[] plaintextBytes = new byte[ciphertextBytes.length - n];    System.arraycopy(buffer, n, plaintextBytes, 0, plaintextBytes.length);    return plaintextBytes;}
public int pdfbox_f1304_0()
{    return gid;}
public List<Object> pdfbox_f1305_0()
{    return type2sequence;}
private void pdfbox_f1306_0(List<Object> sequence)
{    type1Sequence = new ArrayList<>();    pathCount = 0;    CharStringHandler handler = Type2CharString.this::handleCommand;    handler.handleSequence(sequence);}
private List<Number> pdfbox_f1307_0(List<Number> numbers, CharStringCommand command)
{    commandCount++;    String name = CharStringCommand.TYPE2_VOCABULARY.get(command.getKey());    if (name == null) {        addCommand(numbers, command);        return Collections.emptyList();    }    switch(name) {        case "hstem":            numbers = clearStack(numbers, numbers.size() % 2 != 0);            expandStemHints(numbers, true);            break;        case "vstem":            numbers = clearStack(numbers, numbers.size() % 2 != 0);            expandStemHints(numbers, false);            break;        case "vmoveto":            numbers = clearStack(numbers, numbers.size() > 1);            markPath();            addCommand(numbers, command);            break;        case "rlineto":            addCommandList(split(numbers, 2), command);            break;        case "hlineto":            drawAlternatingLine(numbers, true);            break;        case "vlineto":            drawAlternatingLine(numbers, false);            break;        case "rrcurveto":            addCommandList(split(numbers, 6), command);            break;        case "endchar":            numbers = clearStack(numbers, numbers.size() == 5 || numbers.size() == 1);            closePath();            if (numbers.size() == 4) {                                numbers.add(0, 0);                addCommand(numbers, new CharStringCommand(12, 6));            } else {                addCommand(numbers, command);            }            break;        case "rmoveto":            numbers = clearStack(numbers, numbers.size() > 2);            markPath();            addCommand(numbers, command);            break;        case "hmoveto":            numbers = clearStack(numbers, numbers.size() > 1);            markPath();            addCommand(numbers, command);            break;        case "vhcurveto":            drawAlternatingCurve(numbers, false);            break;        case "hvcurveto":            drawAlternatingCurve(numbers, true);            break;        case "hflex":            {                List<Number> first = Arrays.asList(numbers.get(0), 0, numbers.get(1), numbers.get(2), numbers.get(3), 0);                List<Number> second = Arrays.asList(numbers.get(4), 0, numbers.get(5), -(numbers.get(2).floatValue()), numbers.get(6), 0);                addCommandList(Arrays.asList(first, second), new CharStringCommand(8));                break;            }        case "flex":            {                List<Number> first = numbers.subList(0, 6);                List<Number> second = numbers.subList(6, 12);                addCommandList(Arrays.asList(first, second), new CharStringCommand(8));                break;            }        case "hflex1":            {                List<Number> first = Arrays.asList(numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), numbers.get(4), 0);                List<Number> second = Arrays.asList(numbers.get(5), 0, numbers.get(6), numbers.get(7), numbers.get(8), 0);                addCommandList(Arrays.asList(first, second), new CharStringCommand(8));                break;            }        case "flex1":            {                int dx = 0;                int dy = 0;                for (int i = 0; i < 5; i++) {                    dx += numbers.get(i * 2).intValue();                    dy += numbers.get(i * 2 + 1).intValue();                }                List<Number> first = numbers.subList(0, 6);                List<Number> second = Arrays.asList(numbers.get(6), numbers.get(7), numbers.get(8), numbers.get(9), (Math.abs(dx) > Math.abs(dy) ? numbers.get(10) : -dx), (Math.abs(dx) > Math.abs(dy) ? -dy : numbers.get(10)));                addCommandList(Arrays.asList(first, second), new CharStringCommand(8));                break;            }        case "hstemhm":            numbers = clearStack(numbers, numbers.size() % 2 != 0);            expandStemHints(numbers, true);            break;        case "hintmask":        case "cntrmask":            numbers = clearStack(numbers, numbers.size() % 2 != 0);            if (numbers.size() > 0) {                expandStemHints(numbers, false);            }            break;        case "vstemhm":            numbers = clearStack(numbers, numbers.size() % 2 != 0);            expandStemHints(numbers, false);            break;        case "rcurveline":            if (numbers.size() >= 2) {                addCommandList(split(numbers.subList(0, numbers.size() - 2), 6), new CharStringCommand(8));                addCommand(numbers.subList(numbers.size() - 2, numbers.size()), new CharStringCommand(5));            }            break;        case "rlinecurve":            if (numbers.size() >= 6) {                addCommandList(split(numbers.subList(0, numbers.size() - 6), 2), new CharStringCommand(5));                addCommand(numbers.subList(numbers.size() - 6, numbers.size()), new CharStringCommand(8));            }            break;        case "vvcurveto":            drawCurve(numbers, false);            break;        case "hhcurveto":            drawCurve(numbers, true);            break;        default:            addCommand(numbers, command);            break;    }    return Collections.emptyList();}
private List<Number> pdfbox_f1308_0(List<Number> numbers, boolean flag)
{    if (type1Sequence.isEmpty()) {        if (flag) {            addCommand(Arrays.asList((Number) 0f, numbers.get(0).floatValue() + nominalWidthX), new CharStringCommand(13));            numbers = numbers.subList(1, numbers.size());        } else {            addCommand(Arrays.asList((Number) 0f, defWidthX), new CharStringCommand(13));        }    }    return numbers;}
private void pdfbox_f1310_0()
{    if (pathCount > 0) {        closePath();    }    pathCount++;}
private void pdfbox_f1311_0()
{    CharStringCommand command = pathCount > 0 ? (CharStringCommand) type1Sequence.get(type1Sequence.size() - 1) : null;    CharStringCommand closepathCommand = new CharStringCommand(9);    if (command != null && !closepathCommand.equals(command)) {        addCommand(Collections.<Number>emptyList(), closepathCommand);    }}
private void pdfbox_f1312_0(List<Number> numbers, boolean horizontal)
{    while (numbers.size() > 0) {        addCommand(numbers.subList(0, 1), new CharStringCommand(horizontal ? 6 : 7));        numbers = numbers.subList(1, numbers.size());        horizontal = !horizontal;    }}
private void pdfbox_f1313_0(List<Number> numbers, boolean horizontal)
{    while (numbers.size() >= 4) {        boolean last = numbers.size() == 5;        if (horizontal) {            addCommand(Arrays.asList(numbers.get(0), 0, numbers.get(1), numbers.get(2), last ? numbers.get(4) : 0, numbers.get(3)), new CharStringCommand(8));        } else {            addCommand(Arrays.asList(0, numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3), last ? numbers.get(4) : 0), new CharStringCommand(8));        }        numbers = numbers.subList(last ? 5 : 4, numbers.size());        horizontal = !horizontal;    }}
private void pdfbox_f1314_0(List<Number> numbers, boolean horizontal)
{    while (numbers.size() >= 4) {        boolean first = numbers.size() % 4 == 1;        if (horizontal) {            addCommand(Arrays.asList(numbers.get(first ? 1 : 0), first ? numbers.get(0) : 0, numbers.get(first ? 2 : 1), numbers.get(first ? 3 : 2), numbers.get(first ? 4 : 3), 0), new CharStringCommand(8));        } else {            addCommand(Arrays.asList(first ? numbers.get(0) : 0, numbers.get(first ? 1 : 0), numbers.get(first ? 2 : 1), numbers.get(first ? 3 : 2), 0, numbers.get(first ? 4 : 3)), new CharStringCommand(8));        }        numbers = numbers.subList(first ? 5 : 4, numbers.size());    }}
private void pdfbox_f1315_0(List<List<Number>> numbers, CharStringCommand command)
{    numbers.forEach(ns -> addCommand(ns, command));}
private void pdfbox_f1316_0(List<Number> numbers, CharStringCommand command)
{    type1Sequence.addAll(numbers);    type1Sequence.add(command);}
private static List<List<E>> pdfbox_f1317_0(List<E> list, int size)
{    List<List<E>> result = new ArrayList<>();    for (int i = 0; i < list.size() / size; i++) {        result.add(list.subList(i * size, (i + 1) * size));    }    return result;}
public List<Object> pdfbox_f1318_0(byte[] bytes, byte[][] globalSubrIndex, byte[][] localSubrIndex) throws IOException
{    return parse(bytes, globalSubrIndex, localSubrIndex, true);}
private List<Object> pdfbox_f1319_0(byte[] bytes, byte[][] globalSubrIndex, byte[][] localSubrIndex, boolean init) throws IOException
{    if (init) {        hstemCount = 0;        vstemCount = 0;        sequence = new ArrayList<>();    }    DataInput input = new DataInput(bytes);    boolean localSubroutineIndexProvided = localSubrIndex != null && localSubrIndex.length > 0;    boolean globalSubroutineIndexProvided = globalSubrIndex != null && globalSubrIndex.length > 0;    while (input.hasRemaining()) {        int b0 = input.readUnsignedByte();        if (b0 == 10 && localSubroutineIndexProvided) {                        Integer operand = (Integer) sequence.remove(sequence.size() - 1);                        int bias = 0;            int nSubrs = localSubrIndex.length;            if (nSubrs < 1240) {                bias = 107;            } else if (nSubrs < 33900) {                bias = 1131;            } else {                bias = 32768;            }            int subrNumber = bias + operand;            if (subrNumber < localSubrIndex.length) {                byte[] subrBytes = localSubrIndex[subrNumber];                parse(subrBytes, globalSubrIndex, localSubrIndex, false);                Object lastItem = sequence.get(sequence.size() - 1);                if (lastItem instanceof CharStringCommand && ((CharStringCommand) lastItem).getKey().getValue()[0] == 11) {                                        sequence.remove(sequence.size() - 1);                }            }        } else if (b0 == 29 && globalSubroutineIndexProvided) {                        Integer operand = (Integer) sequence.remove(sequence.size() - 1);                        int bias;            int nSubrs = globalSubrIndex.length;            if (nSubrs < 1240) {                bias = 107;            } else if (nSubrs < 33900) {                bias = 1131;            } else {                bias = 32768;            }            int subrNumber = bias + operand;            if (subrNumber < globalSubrIndex.length) {                byte[] subrBytes = globalSubrIndex[subrNumber];                parse(subrBytes, globalSubrIndex, localSubrIndex, false);                Object lastItem = sequence.get(sequence.size() - 1);                if (lastItem instanceof CharStringCommand && ((CharStringCommand) lastItem).getKey().getValue()[0] == 11) {                                        sequence.remove(sequence.size() - 1);                }            }        } else if (b0 >= 0 && b0 <= 27) {            sequence.add(readCommand(b0, input));        } else if (b0 == 28) {            sequence.add(readNumber(b0, input));        } else if (b0 >= 29 && b0 <= 31) {            sequence.add(readCommand(b0, input));        } else if (b0 >= 32 && b0 <= 255) {            sequence.add(readNumber(b0, input));        } else {            throw new IllegalArgumentException();        }    }    return sequence;}
private CharStringCommand pdfbox_f1320_0(int b0, DataInput input) throws IOException
{    if (b0 == 1 || b0 == 18) {        hstemCount += peekNumbers().size() / 2;    } else if (b0 == 3 || b0 == 19 || b0 == 20 || b0 == 23) {        vstemCount += peekNumbers().size() / 2;    }    if (b0 == 12) {        int b1 = input.readUnsignedByte();        return new CharStringCommand(b0, b1);    } else if (b0 == 19 || b0 == 20) {        int[] value = new int[1 + getMaskLength()];        value[0] = b0;        for (int i = 1; i < value.length; i++) {            value[i] = input.readUnsignedByte();        }        return new CharStringCommand(value);    }    return new CharStringCommand(b0);}
private Number pdfbox_f1321_0(int b0, DataInput input) throws IOException
{    if (b0 == 28) {        return (int) input.readShort();    } else if (b0 >= 32 && b0 <= 246) {        return b0 - 139;    } else if (b0 >= 247 && b0 <= 250) {        int b1 = input.readUnsignedByte();        return (b0 - 247) * 256 + b1 + 108;    } else if (b0 >= 251 && b0 <= 254) {        int b1 = input.readUnsignedByte();        return -(b0 - 251) * 256 - b1 - 108;    } else if (b0 == 255) {        short value = input.readShort();                double fraction = input.readUnsignedShort() / 65535d;        return value + fraction;    } else {        throw new IllegalArgumentException();    }}
private int pdfbox_f1322_0()
{    int hintCount = hstemCount + vstemCount;    int length = hintCount / 8;    if (hintCount % 8 > 0) {        length++;    }    return length;}
private List<Number> pdfbox_f1323_0()
{    List<Number> numbers = new ArrayList<>();    for (int i = sequence.size() - 1; i > -1; i--) {        Object object = sequence.get(i);        if (!(object instanceof Number)) {            return numbers;        }        numbers.add(0, (Number) object);    }    return numbers;}
public int pdfbox_f1324_0(char ch)
{    if (from <= ch && ch <= to) {        return cid + (ch - from);    }    return -1;}
public int pdfbox_f1325_0(int code)
{    if (cid <= code && code <= cid + (to - from)) {        return from + (code - cid);    }    return -1;}
public boolean pdfbox_f1326_0(char newFrom, char newTo, int newCid)
{    if ((newFrom == to + 1) && (newCid == cid + to - from + 1)) {        to = newTo;        return true;    }    return false;}
public boolean pdfbox_f1327_0()
{    return !codeToCid.isEmpty() || !codeToCidRanges.isEmpty();}
public boolean pdfbox_f1328_0()
{    return !charToUnicode.isEmpty();}
public String pdfbox_f1329_0(int code)
{    return charToUnicode.get(code);}
public int pdfbox_f1330_1(InputStream in) throws IOException
{    byte[] bytes = new byte[maxCodeLength];    in.read(bytes, 0, minCodeLength);    for (int i = minCodeLength - 1; i < maxCodeLength; i++) {        final int byteCount = i + 1;        for (CodespaceRange range : codespaceRanges) {            if (range.isFullMatch(bytes, byteCount)) {                return toInt(bytes, byteCount);            }        }        if (byteCount < maxCodeLength) {            bytes[byteCount] = (byte) in.read();        }    }    String seq = "";    for (int i = 0; i < maxCodeLength; ++i) {        seq += String.format("0x%02X (%04o) ", bytes[i], bytes[i]);    }        return 0;}
 static int pdfbox_f1331_0(byte[] data, int dataLen)
{    int code = 0;    for (int i = 0; i < dataLen; ++i) {        code <<= 8;        code |= (data[i] & 0xFF);    }    return code;}
public int pdfbox_f1332_0(int code)
{    Integer cid = codeToCid.get(code);    if (cid != null) {        return cid;    }    for (CIDRange range : codeToCidRanges) {        int ch = range.map((char) code);        if (ch != -1) {            return ch;        }    }    return 0;}
private int pdfbox_f1333_0(byte[] data, int offset, int length)
{    int code = 0;    for (int i = 0; i < length; i++) {        code <<= 8;        code |= (data[offset + i] + 256) % 256;    }    return code;}
 void pdfbox_f1334_0(byte[] codes, String unicode)
{    int code = getCodeFromArray(codes, 0, codes.length);    charToUnicode.put(code, unicode);        if (SPACE.equals(unicode)) {        spaceMapping = code;    }}
 void pdfbox_f1335_0(int code, int cid)
{    codeToCid.put(cid, code);}
 void pdfbox_f1336_0(char from, char to, int cid)
{    CIDRange lastRange = null;    if (!codeToCidRanges.isEmpty()) {        lastRange = codeToCidRanges.get(codeToCidRanges.size() - 1);    }    if (lastRange == null || !lastRange.extend(from, to, cid)) {        codeToCidRanges.add(new CIDRange(from, to, cid));    }}
 void pdfbox_f1337_0(CodespaceRange range)
{    codespaceRanges.add(range);    maxCodeLength = Math.max(maxCodeLength, range.getCodeLength());    minCodeLength = Math.min(minCodeLength, range.getCodeLength());}
 void pdfbox_f1338_0(CMap cmap)
{    cmap.codespaceRanges.forEach(this::addCodespaceRange);    charToUnicode.putAll(cmap.charToUnicode);    codeToCid.putAll(cmap.codeToCid);    codeToCidRanges.addAll(cmap.codeToCidRanges);}
public int pdfbox_f1339_0()
{    return wmode;}
public void pdfbox_f1340_0(int newWMode)
{    wmode = newWMode;}
public String pdfbox_f1341_0()
{    return cmapName;}
public void pdfbox_f1342_0(String name)
{    cmapName = name;}
public String pdfbox_f1343_0()
{    return cmapVersion;}
public void pdfbox_f1344_0(String version)
{    cmapVersion = version;}
public int pdfbox_f1345_0()
{    return cmapType;}
public void pdfbox_f1346_0(int type)
{    cmapType = type;}
public String pdfbox_f1347_0()
{    return registry;}
public void pdfbox_f1348_0(String newRegistry)
{    registry = newRegistry;}
public String pdfbox_f1349_0()
{    return ordering;}
public void pdfbox_f1350_0(String newOrdering)
{    ordering = newOrdering;}
public int pdfbox_f1351_0()
{    return supplement;}
public void pdfbox_f1352_0(int newSupplement)
{    supplement = newSupplement;}
public int pdfbox_f1353_0()
{    return spaceMapping;}
public String pdfbox_f1354_0()
{    return cmapName;}
public CMap pdfbox_f1355_0(File file) throws IOException
{    try (FileInputStream input = new FileInputStream(file)) {        return parse(input);    }}
public CMap pdfbox_f1356_0(String name) throws IOException
{    try (InputStream input = getExternalCMap(name)) {        return parse(input);    }}
public CMap pdfbox_f1357_0(InputStream input) throws IOException
{    PushbackInputStream cmapStream = new PushbackInputStream(input);    CMap result = new CMap();    Object previousToken = null;    Object token;    while ((token = parseNextToken(cmapStream)) != null) {        if (token instanceof Operator) {            Operator op = (Operator) token;            if (op.op.equals("endcmap")) {                                break;            }            switch(op.op) {                case "usecmap":                    parseUsecmap((LiteralName) previousToken, result);                    break;                case "begincodespacerange":                    parseBegincodespacerange((Number) previousToken, cmapStream, result);                    break;                case "beginbfchar":                    parseBeginbfchar((Number) previousToken, cmapStream, result);                    break;                case "beginbfrange":                    parseBeginbfrange((Number) previousToken, cmapStream, result);                    break;                case "begincidchar":                    parseBegincidchar((Number) previousToken, cmapStream, result);                    break;                case "begincidrange":                    parseBegincidrange((Integer) previousToken, cmapStream, result);                    break;                default:                    break;            }        } else if (token instanceof LiteralName) {            parseLiteralName((LiteralName) token, cmapStream, result);        }        previousToken = token;    }    return result;}
private void pdfbox_f1358_0(LiteralName useCmapName, CMap result) throws IOException
{    InputStream useStream = getExternalCMap(useCmapName.name);    CMap useCMap = parse(useStream);    result.useCmap(useCMap);}
private void pdfbox_f1359_0(LiteralName literal, PushbackInputStream cmapStream, CMap result) throws IOException
{    switch(literal.name) {        case "WMode":            {                Object next = parseNextToken(cmapStream);                if (next instanceof Integer) {                    result.setWMode((Integer) next);                }                break;            }        case "CMapName":            {                Object next = parseNextToken(cmapStream);                if (next instanceof LiteralName) {                    result.setName(((LiteralName) next).name);                }                break;            }        case "CMapVersion":            {                Object next = parseNextToken(cmapStream);                if (next instanceof Number) {                    result.setVersion(next.toString());                } else if (next instanceof String) {                    result.setVersion((String) next);                }                break;            }        case "CMapType":            {                Object next = parseNextToken(cmapStream);                if (next instanceof Integer) {                    result.setType((Integer) next);                }                break;            }        case "Registry":            {                Object next = parseNextToken(cmapStream);                if (next instanceof String) {                    result.setRegistry((String) next);                }                break;            }        case "Ordering":            {                Object next = parseNextToken(cmapStream);                if (next instanceof String) {                    result.setOrdering((String) next);                }                break;            }        case "Supplement":            {                Object next = parseNextToken(cmapStream);                if (next instanceof Integer) {                    result.setSupplement((Integer) next);                }                break;            }        default:            break;    }}
private void pdfbox_f1360_0(Number cosCount, PushbackInputStream cmapStream, CMap result) throws IOException
{    for (int j = 0; j < cosCount.intValue(); j++) {        Object nextToken = parseNextToken(cmapStream);        if (nextToken instanceof Operator) {            if (!((Operator) nextToken).op.equals("endcodespacerange")) {                throw new IOException("Error : ~codespacerange contains an unexpected operator : " + ((Operator) nextToken).op);            }            break;        }        byte[] startRange = (byte[]) nextToken;        byte[] endRange = (byte[]) parseNextToken(cmapStream);        CodespaceRange range = new CodespaceRange();        range.setStart(startRange);        range.setEnd(endRange);        result.addCodespaceRange(range);    }}
private void pdfbox_f1361_0(Number cosCount, PushbackInputStream cmapStream, CMap result) throws IOException
{    for (int j = 0; j < cosCount.intValue(); j++) {        Object nextToken = parseNextToken(cmapStream);        if (nextToken instanceof Operator) {            if (!((Operator) nextToken).op.equals("endbfchar")) {                throw new IOException("Error : ~bfchar contains an unexpected operator : " + ((Operator) nextToken).op);            }            break;        }        byte[] inputCode = (byte[]) nextToken;        nextToken = parseNextToken(cmapStream);        if (nextToken instanceof byte[]) {            byte[] bytes = (byte[]) nextToken;            String value = createStringFromBytes(bytes);            result.addCharMapping(inputCode, value);        } else if (nextToken instanceof LiteralName) {            result.addCharMapping(inputCode, ((LiteralName) nextToken).name);        } else {            throw new IOException("Error parsing CMap beginbfchar, expected{COSString " + "or COSName} and not " + nextToken);        }    }}
private void pdfbox_f1362_0(int numberOfLines, PushbackInputStream cmapStream, CMap result) throws IOException
{    for (int n = 0; n < numberOfLines; n++) {        Object nextToken = parseNextToken(cmapStream);        if (nextToken instanceof Operator) {            if (!((Operator) nextToken).op.equals("endcidrange")) {                throw new IOException("Error : ~cidrange contains an unexpected operator : " + ((Operator) nextToken).op);            }            break;        }        byte[] startCode = (byte[]) nextToken;        int start = createIntFromBytes(startCode);        byte[] endCode = (byte[]) parseNextToken(cmapStream);        int end = createIntFromBytes(endCode);        int mappedCode = (Integer) parseNextToken(cmapStream);        if (startCode.length <= 2 && endCode.length <= 2) {                        if (end == start) {                result.addCIDMapping(mappedCode, start);            } else {                result.addCIDRange((char) start, (char) end, mappedCode);            }        } else {                        int endOfMappings = mappedCode + end - start;            while (mappedCode <= endOfMappings) {                int mappedCID = createIntFromBytes(startCode);                result.addCIDMapping(mappedCode++, mappedCID);                increment(startCode);            }        }    }}
private void pdfbox_f1363_0(Number cosCount, PushbackInputStream cmapStream, CMap result) throws IOException
{    for (int j = 0; j < cosCount.intValue(); j++) {        Object nextToken = parseNextToken(cmapStream);        if (nextToken instanceof Operator) {            if (!((Operator) nextToken).op.equals("endcidchar")) {                throw new IOException("Error : ~cidchar contains an unexpected operator : " + ((Operator) nextToken).op);            }            break;        }        byte[] inputCode = (byte[]) nextToken;        int mappedCode = (Integer) parseNextToken(cmapStream);        int mappedCID = createIntFromBytes(inputCode);        result.addCIDMapping(mappedCode, mappedCID);    }}
private void pdfbox_f1364_0(Number cosCount, PushbackInputStream cmapStream, CMap result) throws IOException
{    for (int j = 0; j < cosCount.intValue(); j++) {        Object nextToken = parseNextToken(cmapStream);        if (nextToken instanceof Operator) {            if (!((Operator) nextToken).op.equals("endbfrange")) {                throw new IOException("Error : ~bfrange contains an unexpected operator : " + ((Operator) nextToken).op);            }            break;        }        byte[] startCode = (byte[]) nextToken;        byte[] endCode = (byte[]) parseNextToken(cmapStream);        int start = CMap.toInt(startCode, startCode.length);        int end = CMap.toInt(endCode, endCode.length);                if (end < start) {                        break;        }        nextToken = parseNextToken(cmapStream);        if (nextToken instanceof List<?>) {            List<byte[]> array = (List<byte[]>) nextToken;                        if (!array.isEmpty() && array.size() >= end - start) {                addMappingFrombfrange(result, startCode, array);            }        } else         if (nextToken instanceof byte[]) {            byte[] tokenBytes = (byte[]) nextToken;                        if (tokenBytes.length > 0) {                                int values = Math.min(end - start, 255 - (tokenBytes[tokenBytes.length - 1] & 0xFF)) + 1;                addMappingFrombfrange(result, startCode, values, tokenBytes);            }        }    }}
private void pdfbox_f1365_0(CMap cmap, byte[] startCode, List<byte[]> tokenBytesList)
{    for (byte[] tokenBytes : tokenBytesList) {        String value = createStringFromBytes(tokenBytes);        cmap.addCharMapping(startCode, value);        increment(startCode);    }}
private void pdfbox_f1366_0(CMap cmap, byte[] startCode, int values, byte[] tokenBytes)
{    for (int i = 0; i < values; i++) {        String value = createStringFromBytes(tokenBytes);        cmap.addCharMapping(startCode, value);        increment(startCode);        increment(tokenBytes);    }}
protected InputStream pdfbox_f1367_0(String name) throws IOException
{    InputStream is = getClass().getResourceAsStream(name);    if (is == null) {        throw new IOException("Error: Could not find referenced cmap stream " + name);    }    return is;}
private Object pdfbox_f1368_0(PushbackInputStream is) throws IOException
{    Object retval = null;    int nextByte = is.read();        while (nextByte == 0x09 || nextByte == 0x20 || nextByte == 0x0D || nextByte == 0x0A) {        nextByte = is.read();    }    switch(nextByte) {        case '%':            {                                                StringBuilder buffer = new StringBuilder();                buffer.append((char) nextByte);                readUntilEndOfLine(is, buffer);                retval = buffer.toString();                break;            }        case '(':            {                StringBuilder buffer = new StringBuilder();                int stringByte = is.read();                while (stringByte != -1 && stringByte != ')') {                    buffer.append((char) stringByte);                    stringByte = is.read();                }                retval = buffer.toString();                break;            }        case '>':            {                int secondCloseBrace = is.read();                if (secondCloseBrace == '>') {                    retval = MARK_END_OF_DICTIONARY;                } else {                    throw new IOException("Error: expected the end of a dictionary.");                }                break;            }        case ']':            {                retval = MARK_END_OF_ARRAY;                break;            }        case '[':            {                List<Object> list = new ArrayList<>();                Object nextToken = parseNextToken(is);                while (nextToken != null && !MARK_END_OF_ARRAY.equals(nextToken)) {                    list.add(nextToken);                    nextToken = parseNextToken(is);                }                retval = list;                break;            }        case '<':            {                int theNextByte = is.read();                if (theNextByte == '<') {                    Map<String, Object> result = new HashMap<>();                                        Object key = parseNextToken(is);                    while (key instanceof LiteralName && !MARK_END_OF_DICTIONARY.equals(key)) {                        Object value = parseNextToken(is);                        result.put(((LiteralName) key).name, value);                        key = parseNextToken(is);                    }                    retval = result;                } else {                                        int multiplyer = 16;                    int bufferIndex = -1;                    while (theNextByte != -1 && theNextByte != '>') {                        int intValue = 0;                        if (theNextByte >= '0' && theNextByte <= '9') {                            intValue = theNextByte - '0';                        } else if (theNextByte >= 'A' && theNextByte <= 'F') {                            intValue = 10 + theNextByte - 'A';                        } else if (theNextByte >= 'a' && theNextByte <= 'f') {                            intValue = 10 + theNextByte - 'a';                        } else                         if (isWhitespaceOrEOF(theNextByte)) {                                                        theNextByte = is.read();                            continue;                        } else {                            throw new IOException("Error: expected hex character and not " + (char) theNextByte + ":" + theNextByte);                        }                        intValue *= multiplyer;                        if (multiplyer == 16) {                            bufferIndex++;                            tokenParserByteBuffer[bufferIndex] = 0;                            multiplyer = 1;                        } else {                            multiplyer = 16;                        }                        tokenParserByteBuffer[bufferIndex] += intValue;                        theNextByte = is.read();                    }                    byte[] finalResult = new byte[bufferIndex + 1];                    System.arraycopy(tokenParserByteBuffer, 0, finalResult, 0, bufferIndex + 1);                    retval = finalResult;                }                break;            }        case '/':            {                StringBuilder buffer = new StringBuilder();                int stringByte = is.read();                while (!isWhitespaceOrEOF(stringByte) && !isDelimiter(stringByte)) {                    buffer.append((char) stringByte);                    stringByte = is.read();                }                if (isDelimiter(stringByte)) {                    is.unread(stringByte);                }                retval = new LiteralName(buffer.toString());                break;            }        case -1:            {                                break;            }        case '0':        case '1':        case '2':        case '3':        case '4':        case '5':        case '6':        case '7':        case '8':        case '9':            {                StringBuilder buffer = new StringBuilder();                buffer.append((char) nextByte);                nextByte = is.read();                while (!isWhitespaceOrEOF(nextByte) && (Character.isDigit((char) nextByte) || nextByte == '.')) {                    buffer.append((char) nextByte);                    nextByte = is.read();                }                is.unread(nextByte);                String value = buffer.toString();                if (value.indexOf('.') >= 0) {                    retval = Double.valueOf(value);                } else {                    retval = Integer.valueOf(value);                }                break;            }        default:            {                StringBuilder buffer = new StringBuilder();                buffer.append((char) nextByte);                nextByte = is.read();                                while (!isWhitespaceOrEOF(nextByte) && !isDelimiter(nextByte) && !Character.isDigit(nextByte)) {                    buffer.append((char) nextByte);                    nextByte = is.read();                }                if (isDelimiter(nextByte) || Character.isDigit(nextByte)) {                    is.unread(nextByte);                }                retval = new Operator(buffer.toString());                break;            }    }    return retval;}
private void pdfbox_f1369_0(InputStream is, StringBuilder buf) throws IOException
{    int nextByte = is.read();    while (nextByte != -1 && nextByte != 0x0D && nextByte != 0x0A) {        buf.append((char) nextByte);        nextByte = is.read();    }}
private boolean pdfbox_f1370_0(int aByte)
{    return aByte == -1 || aByte == 0x20 || aByte == 0x0D || aByte == 0x0A;}
private boolean pdfbox_f1371_0(int aByte)
{    switch(aByte) {        case '(':        case ')':        case '<':        case '>':        case '[':        case ']':        case '{':        case '}':        case '/':        case '%':            return true;        default:            return false;    }}
private void pdfbox_f1372_0(byte[] data)
{    increment(data, data.length - 1);}
private void pdfbox_f1373_0(byte[] data, int position)
{    if (position > 0 && (data[position] & 0xFF) == 255) {        data[position] = 0;        increment(data, position - 1);    } else {        data[position] = (byte) (data[position] + 1);    }}
private int pdfbox_f1374_0(byte[] bytes)
{    int intValue = bytes[0] & 0xFF;    if (bytes.length == 2) {        intValue <<= 8;        intValue += bytes[1] & 0xFF;    }    return intValue;}
private String pdfbox_f1375_0(byte[] bytes)
{    return new String(bytes, bytes.length == 1 ? Charsets.ISO_8859_1 : Charsets.UTF_16BE);}
public int pdfbox_f1376_0()
{    return codeLength;}
public byte[] pdfbox_f1377_0()
{    return end;}
 void pdfbox_f1378_0(byte[] endBytes)
{    end = endBytes;    endInt = toInt(endBytes, endBytes.length);}
public byte[] pdfbox_f1379_0()
{    return start;}
 void pdfbox_f1380_0(byte[] startBytes)
{    start = startBytes;    codeLength = start.length;    startInt = toInt(startBytes, startBytes.length);}
public boolean pdfbox_f1381_0(byte[] code)
{    return isFullMatch(code, code.length);}
public boolean pdfbox_f1382_0(byte[] code, int codeLen)
{        if (codeLen == codeLength) {        int value = toInt(code, codeLen);        if (value >= startInt && value <= endInt) {            return true;        }    }    return false;}
protected void pdfbox_f1383_0(int code, String name)
{    codeToName.put(code, name);    nameToCode.put(name, code);}
public Integer pdfbox_f1384_0(String name)
{    return nameToCode.get(name);}
public String pdfbox_f1385_0(int code)
{    String name = codeToName.get(code);    if (name != null) {        return name;    }    return ".notdef";}
public Map<Integer, String> pdfbox_f1386_0()
{    return Collections.unmodifiableMap(codeToName);}
private void pdfbox_f1387_0(final byte[] pfb) throws IOException
{    ByteArrayInputStream in = new ByteArrayInputStream(pfb);    pfbdata = new byte[pfb.length - PFB_HEADER_LENGTH];    lengths = new int[PFB_RECORDS.length];    int pointer = 0;    for (int records = 0; records < PFB_RECORDS.length; records++) {        if (in.read() != START_MARKER) {            throw new IOException("Start marker missing");        }        if (in.read() != PFB_RECORDS[records]) {            throw new IOException("Incorrect record type");        }        int size = in.read();        size += in.read() << 8;        size += in.read() << 16;        size += in.read() << 24;        lengths[records] = size;        if (pointer >= pfbdata.length) {            throw new EOFException("attempted to read past EOF");        }        int got = in.read(pfbdata, pointer, size);        if (got < 0) {            throw new EOFException();        }        pointer += got;    }}
private byte[] pdfbox_f1388_0(final InputStream in) throws IOException
{        ByteArrayOutputStream out = new ByteArrayOutputStream();    byte[] tmpbuf = new byte[BUFFER_SIZE];    int amountRead = -1;    while ((amountRead = in.read(tmpbuf)) != -1) {        out.write(tmpbuf, 0, amountRead);    }    return out.toByteArray();}
public int[] pdfbox_f1389_0()
{    return lengths;}
public byte[] pdfbox_f1390_0()
{    return pfbdata;}
public InputStream pdfbox_f1391_0()
{    return new ByteArrayInputStream(pfbdata);}
public int pdfbox_f1392_0()
{    return pfbdata.length;}
public byte[] pdfbox_f1393_0()
{    return Arrays.copyOfRange(pfbdata, 0, lengths[0]);}
public byte[] pdfbox_f1394_0()
{    return Arrays.copyOfRange(pfbdata, lengths[0], lengths[0] + lengths[1]);}
public final int pdfbox_f1395_0() throws IOException
{    if (bufpos >= bufend && fillBuffer() < 0) {        return -1;    }    if (bufend == 0) {        return -1;    }        return (buffer[bufpos++] + 256) & 0xFF;}
private int pdfbox_f1396_0() throws IOException
{    int n = super.read(buffer, 0, BUFSIZE);    if (n >= 0) {        realpos += n;        bufend = n;        bufpos = 0;    }    return n;}
private void pdfbox_f1397_0() throws IOException
{    bufend = 0;    bufpos = 0;    realpos = super.getFilePointer();}
public int pdfbox_f1398_0(byte[] b, int off, int len) throws IOException
{    int leftover = bufend - bufpos;    if (len <= leftover) {        System.arraycopy(buffer, bufpos, b, off, len);        bufpos += len;        return len;    }    System.arraycopy(buffer, bufpos, b, off, leftover);    bufpos += leftover;    if (fillBuffer() > 0) {        int bytesRead = read(b, off + leftover, len - leftover);        if (bytesRead > 0) {            leftover += bytesRead;        }    }    return leftover > 0 ? leftover : -1;}
public long pdfbox_f1399_0() throws IOException
{    return realpos - bufend + bufpos;}
public void pdfbox_f1400_0(long pos) throws IOException
{    int n = (int) (realpos - pos);    if (n >= 0 && n <= bufend) {        bufpos = bufend - n;    } else {        super.seek(pos);        invalidate();    }}
 void pdfbox_f1401_0(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    byte[] bytes = data.read((int) getLength());    CFFParser parser = new CFFParser();    cffFont = parser.parse(bytes, new CFFBytesource(font)).get(0);    initialized = true;}
public CFFFont pdfbox_f1402_0()
{    return cffFont;}
public byte[] pdfbox_f1403_0() throws IOException
{    return ttf.getTableBytes(ttf.getTableMap().get(CFFTable.TAG));}
 void pdfbox_f1404_0(TTFDataStream data) throws IOException
{    platformId = data.readUnsignedShort();    platformEncodingId = data.readUnsignedShort();    subTableOffset = data.readUnsignedInt();}
 void pdfbox_f1405_0(CmapTable cmap, int numGlyphs, TTFDataStream data) throws IOException
{    data.seek(cmap.getOffset() + subTableOffset);    int subtableFormat = data.readUnsignedShort();    long length;    long version;    if (subtableFormat < 8) {        length = data.readUnsignedShort();        version = data.readUnsignedShort();    } else {                data.readUnsignedShort();        length = data.readUnsignedInt();        version = data.readUnsignedInt();    }    switch(subtableFormat) {        case 0:            processSubtype0(data);            break;        case 2:            processSubtype2(data, numGlyphs);            break;        case 4:            processSubtype4(data, numGlyphs);            break;        case 6:            processSubtype6(data, numGlyphs);            break;        case 8:            processSubtype8(data, numGlyphs);            break;        case 10:            processSubtype10(data, numGlyphs);            break;        case 12:            processSubtype12(data, numGlyphs);            break;        case 13:            processSubtype13(data, numGlyphs);            break;        case 14:            processSubtype14(data, numGlyphs);            break;        default:            throw new IOException("Unknown cmap format:" + subtableFormat);    }}
 void pdfbox_f1406_1(TTFDataStream data, int numGlyphs) throws IOException
{        int[] is32 = data.readUnsignedByteArray(8192);    long nbGroups = data.readUnsignedInt();        if (nbGroups > 65536) {        throw new IOException("CMap ( Subtype8 ) is invalid");    }    glyphIdToCharacterCode = newGlyphIdToCharacterCode(numGlyphs);    characterCodeToGlyphId = new HashMap<>(numGlyphs);    if (numGlyphs == 0) {                return;    }        for (long i = 0; i < nbGroups; ++i) {        long firstCode = data.readUnsignedInt();        long endCode = data.readUnsignedInt();        long startGlyph = data.readUnsignedInt();                if (firstCode > endCode || 0 > firstCode) {            throw new IOException("Range invalid");        }        for (long j = firstCode; j <= endCode; ++j) {                        if (j > Integer.MAX_VALUE) {                throw new IOException("[Sub Format 8] Invalid character code " + j);            }            if ((int) j / 8 >= is32.length) {                throw new IOException("[Sub Format 8] Invalid character code " + j);            }            int currentCharCode;            if ((is32[(int) j / 8] & (1 << ((int) j % 8))) == 0) {                currentCharCode = (int) j;            } else {                                                long lead = LEAD_OFFSET + (j >> 10);                long trail = 0xDC00 + (j & 0x3FF);                long codepoint = (lead << 10) + trail + SURROGATE_OFFSET;                if (codepoint > Integer.MAX_VALUE) {                    throw new IOException("[Sub Format 8] Invalid character code " + codepoint);                }                currentCharCode = (int) codepoint;            }            long glyphIndex = startGlyph + (j - firstCode);            if (glyphIndex > numGlyphs || glyphIndex > Integer.MAX_VALUE) {                throw new IOException("CMap contains an invalid glyph index");            }            glyphIdToCharacterCode[(int) glyphIndex] = currentCharCode;            characterCodeToGlyphId.put(currentCharCode, (int) glyphIndex);        }    }}
 void pdfbox_f1407_0(TTFDataStream data, int numGlyphs) throws IOException
{    long startCode = data.readUnsignedInt();    long numChars = data.readUnsignedInt();    if (numChars > Integer.MAX_VALUE) {        throw new IOException("Invalid number of Characters");    }    if (startCode < 0 || startCode > 0x0010FFFF || (startCode + numChars) > 0x0010FFFF || ((startCode + numChars) >= 0x0000D800 && (startCode + numChars) <= 0x0000DFFF)) {        throw new IOException("Invalid Characters codes");    }}
 void pdfbox_f1408_1(TTFDataStream data, int numGlyphs) throws IOException
{    long nbGroups = data.readUnsignedInt();    glyphIdToCharacterCode = newGlyphIdToCharacterCode(numGlyphs);    characterCodeToGlyphId = new HashMap<>(numGlyphs);    if (numGlyphs == 0) {                return;    }    for (long i = 0; i < nbGroups; ++i) {        long firstCode = data.readUnsignedInt();        long endCode = data.readUnsignedInt();        long startGlyph = data.readUnsignedInt();        if (firstCode < 0 || firstCode > 0x0010FFFF || firstCode >= 0x0000D800 && firstCode <= 0x0000DFFF) {            throw new IOException("Invalid characters codes");        }        if (endCode > 0 && endCode < firstCode || endCode > 0x0010FFFF || endCode >= 0x0000D800 && endCode <= 0x0000DFFF) {            throw new IOException("Invalid characters codes");        }        for (long j = 0; j <= endCode - firstCode; ++j) {            long glyphIndex = startGlyph + j;            if (glyphIndex >= numGlyphs) {                                break;            }            if (firstCode + j > 0x10FFFF) {                            }            glyphIdToCharacterCode[(int) glyphIndex] = (int) (firstCode + j);            characterCodeToGlyphId.put((int) (firstCode + j), (int) glyphIndex);        }    }}
 void pdfbox_f1409_1(TTFDataStream data, int numGlyphs) throws IOException
{    long nbGroups = data.readUnsignedInt();    glyphIdToCharacterCode = newGlyphIdToCharacterCode(numGlyphs);    characterCodeToGlyphId = new HashMap<>(numGlyphs);    if (numGlyphs == 0) {                return;    }    for (long i = 0; i < nbGroups; ++i) {        long firstCode = data.readUnsignedInt();        long endCode = data.readUnsignedInt();        long glyphId = data.readUnsignedInt();        if (glyphId > numGlyphs) {                        break;        }        if (firstCode < 0 || firstCode > 0x0010FFFF || (firstCode >= 0x0000D800 && firstCode <= 0x0000DFFF)) {            throw new IOException("Invalid Characters codes");        }        if ((endCode > 0 && endCode < firstCode) || endCode > 0x0010FFFF || (endCode >= 0x0000D800 && endCode <= 0x0000DFFF)) {            throw new IOException("Invalid Characters codes");        }        for (long j = 0; j <= endCode - firstCode; ++j) {            if (firstCode + j > Integer.MAX_VALUE) {                throw new IOException("Character Code greater than Integer.MAX_VALUE");            }            if (firstCode + j > 0x10FFFF) {                            }            glyphIdToCharacterCode[(int) glyphId] = (int) (firstCode + j);            characterCodeToGlyphId.put((int) (firstCode + j), (int) glyphId);        }    }}
 void pdfbox_f1410_1(TTFDataStream data, int numGlyphs) throws IOException
{            }
 void pdfbox_f1411_0(TTFDataStream data, int numGlyphs) throws IOException
{    int firstCode = data.readUnsignedShort();    int entryCount = data.readUnsignedShort();        if (entryCount == 0) {        return;    }    characterCodeToGlyphId = new HashMap<>(numGlyphs);    int[] glyphIdArray = data.readUnsignedShortArray(entryCount);    int maxGlyphId = 0;    for (int i = 0; i < entryCount; i++) {        maxGlyphId = Math.max(maxGlyphId, glyphIdArray[i]);        characterCodeToGlyphId.put(firstCode + i, glyphIdArray[i]);    }    buildGlyphIdToCharacterCodeLookup(maxGlyphId);}
 void pdfbox_f1412_1(TTFDataStream data, int numGlyphs) throws IOException
{    int segCountX2 = data.readUnsignedShort();    int segCount = segCountX2 / 2;    int searchRange = data.readUnsignedShort();    int entrySelector = data.readUnsignedShort();    int rangeShift = data.readUnsignedShort();    int[] endCount = data.readUnsignedShortArray(segCount);    int reservedPad = data.readUnsignedShort();    int[] startCount = data.readUnsignedShortArray(segCount);    int[] idDelta = data.readUnsignedShortArray(segCount);    long idRangeOffsetPosition = data.getCurrentPosition();    int[] idRangeOffset = data.readUnsignedShortArray(segCount);    characterCodeToGlyphId = new HashMap<>(numGlyphs);    int maxGlyphId = 0;    for (int i = 0; i < segCount; i++) {        int start = startCount[i];        int end = endCount[i];        int delta = idDelta[i];        int rangeOffset = idRangeOffset[i];        long segmentRangeOffset = idRangeOffsetPosition + (i * 2) + rangeOffset;        if (start != 65535 && end != 65535) {            for (int j = start; j <= end; j++) {                if (rangeOffset == 0) {                    int glyphid = (j + delta) & 0xFFFF;                    maxGlyphId = Math.max(glyphid, maxGlyphId);                    characterCodeToGlyphId.put(j, glyphid);                } else {                    long glyphOffset = segmentRangeOffset + ((j - start) * 2);                    data.seek(glyphOffset);                    int glyphIndex = data.readUnsignedShort();                    if (glyphIndex != 0) {                        glyphIndex = (glyphIndex + delta) & 0xFFFF;                        maxGlyphId = Math.max(glyphIndex, maxGlyphId);                        characterCodeToGlyphId.put(j, glyphIndex);                    }                }            }        }    }    /*         * this is the final result key=glyphId, value is character codes Create an array that contains MAX(GlyphIds)         * element, or -1         */    if (characterCodeToGlyphId.isEmpty()) {                return;    }    buildGlyphIdToCharacterCodeLookup(maxGlyphId);}
private void pdfbox_f1413_0(int maxGlyphId)
{    glyphIdToCharacterCode = newGlyphIdToCharacterCode(maxGlyphId + 1);    for (Entry<Integer, Integer> entry : characterCodeToGlyphId.entrySet()) {        if (glyphIdToCharacterCode[entry.getValue()] == -1) {                        glyphIdToCharacterCode[entry.getValue()] = entry.getKey();        } else {                        List<Integer> mappedValues = glyphIdToCharacterCodeMultiple.get(entry.getValue());            if (mappedValues == null) {                mappedValues = new ArrayList<>();                glyphIdToCharacterCodeMultiple.put(entry.getValue(), mappedValues);                mappedValues.add(glyphIdToCharacterCode[entry.getValue()]);                                glyphIdToCharacterCode[entry.getValue()] = Integer.MIN_VALUE;            }            mappedValues.add(entry.getKey());        }    }}
 void pdfbox_f1414_1(TTFDataStream data, int numGlyphs) throws IOException
{    int[] subHeaderKeys = new int[256];        int maxSubHeaderIndex = 0;    for (int i = 0; i < 256; i++) {        subHeaderKeys[i] = data.readUnsignedShort();        maxSubHeaderIndex = Math.max(maxSubHeaderIndex, subHeaderKeys[i] / 8);    }        SubHeader[] subHeaders = new SubHeader[maxSubHeaderIndex + 1];    for (int i = 0; i <= maxSubHeaderIndex; ++i) {        int firstCode = data.readUnsignedShort();        int entryCount = data.readUnsignedShort();        short idDelta = data.readSignedShort();        int idRangeOffset = data.readUnsignedShort() - (maxSubHeaderIndex + 1 - i - 1) * 8 - 2;        subHeaders[i] = new SubHeader(firstCode, entryCount, idDelta, idRangeOffset);    }    long startGlyphIndexOffset = data.getCurrentPosition();    glyphIdToCharacterCode = newGlyphIdToCharacterCode(numGlyphs);    characterCodeToGlyphId = new HashMap<>(numGlyphs);    if (numGlyphs == 0) {                return;    }    for (int i = 0; i <= maxSubHeaderIndex; ++i) {        SubHeader sh = subHeaders[i];        int firstCode = sh.getFirstCode();        int idRangeOffset = sh.getIdRangeOffset();        int idDelta = sh.getIdDelta();        int entryCount = sh.getEntryCount();        data.seek(startGlyphIndexOffset + idRangeOffset);        for (int j = 0; j < entryCount; ++j) {                        int charCode = i;            charCode = (charCode << 8) + (firstCode + j);                                                            int p = data.readUnsignedShort();                        if (p > 0) {                p = (p + idDelta) % 65536;                if (p < 0) {                    p += 65536;                }            }            if (p >= numGlyphs) {                                continue;            }            glyphIdToCharacterCode[p] = charCode;            characterCodeToGlyphId.put(charCode, p);        }    }}
 void pdfbox_f1415_0(TTFDataStream data) throws IOException
{    byte[] glyphMapping = data.read(256);    glyphIdToCharacterCode = newGlyphIdToCharacterCode(256);    characterCodeToGlyphId = new HashMap<>(glyphMapping.length);    for (int i = 0; i < glyphMapping.length; i++) {        int glyphIndex = glyphMapping[i] & 0xFF;        glyphIdToCharacterCode[glyphIndex] = i;        characterCodeToGlyphId.put(i, glyphIndex);    }}
private int[] pdfbox_f1416_0(int size)
{    int[] gidToCode = new int[size];    Arrays.fill(gidToCode, -1);    return gidToCode;}
public int pdfbox_f1417_0()
{    return platformEncodingId;}
public void pdfbox_f1418_0(int platformEncodingIdValue)
{    platformEncodingId = platformEncodingIdValue;}
public int pdfbox_f1419_0()
{    return platformId;}
public void pdfbox_f1420_0(int platformIdValue)
{    platformId = platformIdValue;}
public int pdfbox_f1421_0(int characterCode)
{    Integer glyphId = characterCodeToGlyphId.get(characterCode);    return glyphId == null ? 0 : glyphId;}
public Integer pdfbox_f1422_0(int gid)
{    int code = getCharCode(gid);    if (code == -1) {        return null;    }        if (code == Integer.MIN_VALUE) {        List<Integer> mappedValues = glyphIdToCharacterCodeMultiple.get(gid);        if (mappedValues != null) {                        return mappedValues.get(0);        }    }    return code;}
private int pdfbox_f1423_0(int gid)
{    if (gid < 0 || gid >= glyphIdToCharacterCode.length) {        return -1;    }    return glyphIdToCharacterCode[gid];}
public List<Integer> pdfbox_f1424_0(int gid)
{    int code = getCharCode(gid);    if (code == -1) {        return null;    }    List<Integer> codes = null;    if (code == Integer.MIN_VALUE) {        List<Integer> mappedValues = glyphIdToCharacterCodeMultiple.get(gid);        if (mappedValues != null) {            codes = new ArrayList<>(mappedValues);                        Collections.sort(codes);        }    } else {        codes = new ArrayList<>(1);        codes.add(code);    }    return codes;}
public String pdfbox_f1425_0()
{    return "{" + getPlatformId() + " " + getPlatformEncodingId() + "}";}
private int pdfbox_f1426_0()
{    return firstCode;}
private int pdfbox_f1427_0()
{    return entryCount;}
private short pdfbox_f1428_0()
{    return idDelta;}
private int pdfbox_f1429_0()
{    return idRangeOffset;}
 void pdfbox_f1430_0(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    @SuppressWarnings({ "unused", "squid:S1854", "squid:S1481" })    int version = data.readUnsignedShort();    int numberOfTables = data.readUnsignedShort();    cmaps = new CmapSubtable[numberOfTables];    for (int i = 0; i < numberOfTables; i++) {        CmapSubtable cmap = new CmapSubtable();        cmap.initData(data);        cmaps[i] = cmap;    }    for (int i = 0; i < numberOfTables; i++) {        cmaps[i].initSubtable(this, ttf.getNumberOfGlyphs(), data);    }    initialized = true;}
public CmapSubtable[] pdfbox_f1431_0()
{    return cmaps;}
public void pdfbox_f1432_0(CmapSubtable[] cmapsValue)
{    cmaps = cmapsValue;}
public CmapSubtable pdfbox_f1433_0(int platformId, int platformEncodingId)
{    for (CmapSubtable cmap : cmaps) {        if (cmap.getPlatformId() == platformId && cmap.getPlatformEncodingId() == platformEncodingId) {            return cmap;        }    }    return null;}
public void pdfbox_f1434_0(int idx)
{    firstIndex = idx;}
public int pdfbox_f1435_0()
{    return firstIndex;}
public void pdfbox_f1436_0(int idx)
{    firstContour = idx;}
public int pdfbox_f1437_0()
{    return firstContour;}
public short pdfbox_f1438_0()
{    return argument1;}
public short pdfbox_f1439_0()
{    return argument2;}
public short pdfbox_f1440_0()
{    return flags;}
public int pdfbox_f1441_0()
{    return glyphIndex;}
public double pdfbox_f1442_0()
{    return scale01;}
public double pdfbox_f1443_0()
{    return scale10;}
public double pdfbox_f1444_0()
{    return xscale;}
public double pdfbox_f1445_0()
{    return yscale;}
public int pdfbox_f1446_0()
{    return xtranslate;}
public int pdfbox_f1447_0()
{    return ytranslate;}
public int pdfbox_f1448_0(int x, int y)
{    return Math.round((float) (x * xscale + y * scale10));}
public int pdfbox_f1449_0(int x, int y)
{    return Math.round((float) (x * scale01 + y * yscale));}
public void pdfbox_f1450_1()
{    if (resolved) {        return;    }    if (beingResolved) {                return;    }    beingResolved = true;    int firstIndex = 0;    int firstContour = 0;    for (GlyfCompositeComp comp : components) {        comp.setFirstIndex(firstIndex);        comp.setFirstContour(firstContour);        GlyphDescription desc = descriptions.get(comp.getGlyphIndex());        if (desc != null) {            desc.resolve();            firstIndex += desc.getPointCount();            firstContour += desc.getContourCount();        }    }    resolved = true;    beingResolved = false;}
public int pdfbox_f1451_0(int i)
{    GlyfCompositeComp c = getCompositeCompEndPt(i);    if (c != null) {        GlyphDescription gd = descriptions.get(c.getGlyphIndex());        return gd.getEndPtOfContours(i - c.getFirstContour()) + c.getFirstIndex();    }    return 0;}
public byte pdfbox_f1452_0(int i)
{    GlyfCompositeComp c = getCompositeComp(i);    if (c != null) {        GlyphDescription gd = descriptions.get(c.getGlyphIndex());        return gd.getFlags(i - c.getFirstIndex());    }    return 0;}
public short pdfbox_f1453_0(int i)
{    GlyfCompositeComp c = getCompositeComp(i);    if (c != null) {        GlyphDescription gd = descriptions.get(c.getGlyphIndex());        int n = i - c.getFirstIndex();        int x = gd.getXCoordinate(n);        int y = gd.getYCoordinate(n);        short x1 = (short) c.scaleX(x, y);        x1 += c.getXTranslate();        return x1;    }    return 0;}
public short pdfbox_f1454_0(int i)
{    GlyfCompositeComp c = getCompositeComp(i);    if (c != null) {        GlyphDescription gd = descriptions.get(c.getGlyphIndex());        int n = i - c.getFirstIndex();        int x = gd.getXCoordinate(n);        int y = gd.getYCoordinate(n);        short y1 = (short) c.scaleY(x, y);        y1 += c.getYTranslate();        return y1;    }    return 0;}
public boolean pdfbox_f1455_0()
{    return true;}
public int pdfbox_f1456_1()
{    if (!resolved) {            }    if (pointCount < 0) {        GlyfCompositeComp c = components.get(components.size() - 1);        GlyphDescription gd = descriptions.get(c.getGlyphIndex());        if (gd == null) {                        pointCount = 0;        } else {            pointCount = c.getFirstIndex() + gd.getPointCount();        }    }    return pointCount;}
public int pdfbox_f1457_1()
{    if (!resolved) {            }    if (contourCount < 0) {        GlyfCompositeComp c = components.get(components.size() - 1);        contourCount = c.getFirstContour() + descriptions.get(c.getGlyphIndex()).getContourCount();    }    return contourCount;}
public int pdfbox_f1458_0()
{    return components.size();}
private GlyfCompositeComp pdfbox_f1459_0(int i)
{    for (GlyfCompositeComp c : components) {        GlyphDescription gd = descriptions.get(c.getGlyphIndex());        if (c.getFirstIndex() <= i && gd != null && i < (c.getFirstIndex() + gd.getPointCount())) {            return c;        }    }    return null;}
private GlyfCompositeComp pdfbox_f1460_0(int i)
{    for (GlyfCompositeComp c : components) {        GlyphDescription gd = descriptions.get(c.getGlyphIndex());        if (c.getFirstContour() <= i && gd != null && i < (c.getFirstContour() + gd.getContourCount())) {            return c;        }    }    return null;}
private void pdfbox_f1461_1()
{    for (GlyfCompositeComp component : components) {        try {            int index = component.getGlyphIndex();            GlyphData glyph = glyphTable.getGlyph(index);            if (glyph != null) {                descriptions.put(index, glyph.getDescription());            }        } catch (IOException e) {                    }    }}
public int pdfbox_f1463_0()
{    return contourCount;}
public int[] pdfbox_f1464_0()
{    return instructions;}
 void pdfbox_f1465_0(TTFDataStream bais, int count) throws IOException
{    instructions = bais.readUnsignedByteArray(count);}
public int pdfbox_f1466_0(int i)
{    return endPtsOfContours[i];}
public byte pdfbox_f1467_0(int i)
{    return flags[i];}
public short pdfbox_f1468_0(int i)
{    return xCoordinates[i];}
public short pdfbox_f1469_0(int i)
{    return yCoordinates[i];}
public boolean pdfbox_f1470_0()
{    return false;}
public int pdfbox_f1471_0()
{    return pointCount;}
private void pdfbox_f1472_0(int count, TTFDataStream bais, short x0) throws IOException
{    short x = x0;    short y = 0;    for (int i = 0; i < count; i++) {        if ((flags[i] & X_DUAL) != 0) {            if ((flags[i] & X_SHORT_VECTOR) != 0) {                x += (short) bais.readUnsignedByte();            }        } else {            if ((flags[i] & X_SHORT_VECTOR) != 0) {                x += (short) -((short) bais.readUnsignedByte());            } else {                x += bais.readSignedShort();            }        }        xCoordinates[i] = x;    }    for (int i = 0; i < count; i++) {        if ((flags[i] & Y_DUAL) != 0) {            if ((flags[i] & Y_SHORT_VECTOR) != 0) {                y += (short) bais.readUnsignedByte();            }        } else {            if ((flags[i] & Y_SHORT_VECTOR) != 0) {                y += (short) -((short) bais.readUnsignedByte());            } else {                y += bais.readSignedShort();            }        }        yCoordinates[i] = y;    }}
private void pdfbox_f1473_0(int flagCount, TTFDataStream bais) throws IOException
{    for (int index = 0; index < flagCount; index++) {        flags[index] = (byte) bais.readUnsignedByte();        if ((flags[index] & REPEAT) != 0) {            int repeats = bais.readUnsignedByte();            for (int i = 1; i <= repeats && index + i < flags.length; i++) {                flags[index + i] = flags[index];            }            index += repeats;        }    }}
 void pdfbox_f1474_0(GlyphTable glyphTable, TTFDataStream data, int leftSideBearing) throws IOException
{    numberOfContours = data.readSignedShort();    xMin = data.readSignedShort();    yMin = data.readSignedShort();    xMax = data.readSignedShort();    yMax = data.readSignedShort();    boundingBox = new BoundingBox(xMin, yMin, xMax, yMax);    if (numberOfContours >= 0) {                short x0 = (short) (leftSideBearing - xMin);        glyphDescription = new GlyfSimpleDescript(numberOfContours, data, x0);    } else {                glyphDescription = new GlyfCompositeDescript(data, glyphTable);    }}
public BoundingBox pdfbox_f1475_0()
{    return boundingBox;}
public void pdfbox_f1476_0(BoundingBox boundingBoxValue)
{    this.boundingBox = boundingBoxValue;}
public short pdfbox_f1477_0()
{    return numberOfContours;}
public void pdfbox_f1478_0(short numberOfContoursValue)
{    this.numberOfContours = numberOfContoursValue;}
public GlyphDescription pdfbox_f1479_0()
{    return glyphDescription;}
public GeneralPath pdfbox_f1480_0()
{    return new GlyphRenderer(glyphDescription).getPath();}
public short pdfbox_f1481_0()
{    return xMax;}
public short pdfbox_f1482_0()
{    return xMin;}
public short pdfbox_f1483_0()
{    return yMax;}
public short pdfbox_f1484_0()
{    return yMin;}
public GeneralPath pdfbox_f1485_0()
{    Point[] points = describe(glyphDescription);    return calculatePath(points);}
private Point[] pdfbox_f1486_0(GlyphDescription gd)
{    int endPtIndex = 0;    int endPtOfContourIndex = -1;    Point[] points = new Point[gd.getPointCount()];    for (int i = 0; i < gd.getPointCount(); i++) {        if (endPtOfContourIndex == -1) {            endPtOfContourIndex = gd.getEndPtOfContours(endPtIndex);        }        boolean endPt = endPtOfContourIndex == i;        if (endPt) {            endPtIndex++;            endPtOfContourIndex = -1;        }        points[i] = new Point(gd.getXCoordinate(i), gd.getYCoordinate(i), (gd.getFlags(i) & GlyfDescript.ON_CURVE) != 0, endPt);    }    return points;}
private GeneralPath pdfbox_f1487_0(Point[] points)
{    GeneralPath path = new GeneralPath();    int start = 0;    for (int p = 0, len = points.length; p < len; ++p) {        if (points[p].endOfContour) {            Point firstPoint = points[start];            Point lastPoint = points[p];            List<Point> contour = new ArrayList<>();            for (int q = start; q <= p; ++q) {                contour.add(points[q]);            }            if (points[start].onCurve) {                                contour.add(firstPoint);            } else if (points[p].onCurve) {                                contour.add(0, lastPoint);            } else {                                Point pmid = midValue(firstPoint, lastPoint);                contour.add(0, pmid);                contour.add(pmid);            }            moveTo(path, contour.get(0));            for (int j = 1, clen = contour.size(); j < clen; j++) {                Point pnow = contour.get(j);                if (pnow.onCurve) {                    lineTo(path, pnow);                } else if (contour.get(j + 1).onCurve) {                    quadTo(path, pnow, contour.get(j + 1));                    ++j;                } else {                    quadTo(path, pnow, midValue(pnow, contour.get(j + 1)));                }            }            path.closePath();            start = p + 1;        }    }    return path;}
private void pdfbox_f1488_0(GeneralPath path, Point point)
{    path.moveTo(point.x, point.y);    if (LOG.isDebugEnabled()) {        LOG.trace("moveTo: " + String.format(Locale.US, "%d,%d", point.x, point.y));    }}
private void pdfbox_f1489_0(GeneralPath path, Point point)
{    path.lineTo(point.x, point.y);    if (LOG.isDebugEnabled()) {        LOG.trace("lineTo: " + String.format(Locale.US, "%d,%d", point.x, point.y));    }}
private void pdfbox_f1490_0(GeneralPath path, Point ctrlPoint, Point point)
{    path.quadTo(ctrlPoint.x, ctrlPoint.y, point.x, point.y);    if (LOG.isDebugEnabled()) {        LOG.trace("quadTo: " + String.format(Locale.US, "%d,%d %d,%d", ctrlPoint.x, ctrlPoint.y, point.x, point.y));    }}
private int pdfbox_f1491_0(int a, int b)
{    return a + (b - a) / 2;}
private Point pdfbox_f1492_0(Point point1, Point point2)
{    return new Point(midValue(point1.x, point2.x), midValue(point1.y, point2.y));}
public String pdfbox_f1493_0()
{    return String.format(Locale.US, "Point(%d,%d,%s,%s)", x, y, onCurve ? "onCurve" : "", endOfContour ? "endOfContour" : "");}
 void pdfbox_f1494_0(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    long start = data.getCurrentPosition();    @SuppressWarnings({ "unused" })    int majorVersion = data.readUnsignedShort();    int minorVersion = data.readUnsignedShort();    int scriptListOffset = data.readUnsignedShort();    int featureListOffset = data.readUnsignedShort();    int lookupListOffset = data.readUnsignedShort();    @SuppressWarnings({ "unused" })    long featureVariationsOffset = -1L;    if (minorVersion == 1L) {        featureVariationsOffset = data.readUnsignedInt();    }    scriptList = readScriptList(data, start + scriptListOffset);    featureListTable = readFeatureList(data, start + featureListOffset);    lookupListTable = readLookupList(data, start + lookupListOffset);    GlyphSubstitutionDataExtractor glyphSubstitutionDataExtractor = new GlyphSubstitutionDataExtractor();    gsubData = glyphSubstitutionDataExtractor.getGsubData(scriptList, featureListTable, lookupListTable);}
private Map<String, ScriptTable> pdfbox_f1495_0(TTFDataStream data, long offset) throws IOException
{    data.seek(offset);    int scriptCount = data.readUnsignedShort();    ScriptTable[] scriptTables = new ScriptTable[scriptCount];    int[] scriptOffsets = new int[scriptCount];    String[] scriptTags = new String[scriptCount];    for (int i = 0; i < scriptCount; i++) {        scriptTags[i] = data.readString(4);        scriptOffsets[i] = data.readUnsignedShort();    }    for (int i = 0; i < scriptCount; i++) {        scriptTables[i] = readScriptTable(data, offset + scriptOffsets[i]);    }    Map<String, ScriptTable> resultScriptList = new LinkedHashMap<>(scriptCount);    for (int i = 0; i < scriptCount; i++) {        ScriptRecord scriptRecord = new ScriptRecord(scriptTags[i], scriptTables[i]);        resultScriptList.put(scriptRecord.getScriptTag(), scriptRecord.getScriptTable());    }    return Collections.unmodifiableMap(resultScriptList);}
private ScriptTable pdfbox_f1496_1(TTFDataStream data, long offset) throws IOException
{    data.seek(offset);    int defaultLangSys = data.readUnsignedShort();    int langSysCount = data.readUnsignedShort();    LangSysRecord[] langSysRecords = new LangSysRecord[langSysCount];    String[] langSysTags = new String[langSysCount];    int[] langSysOffsets = new int[langSysCount];    for (int i = 0; i < langSysCount; i++) {        langSysTags[i] = data.readString(4);        if (i > 0 && langSysTags[i].compareTo(langSysTags[i - 1]) <= 0) {                                                return new ScriptTable(null, new LinkedHashMap<>());        }        langSysOffsets[i] = data.readUnsignedShort();    }    LangSysTable defaultLangSysTable = null;    if (defaultLangSys != 0) {        defaultLangSysTable = readLangSysTable(data, offset + defaultLangSys);    }    for (int i = 0; i < langSysCount; i++) {        LangSysTable langSysTable = readLangSysTable(data, offset + langSysOffsets[i]);        langSysRecords[i] = new LangSysRecord(langSysTags[i], langSysTable);    }    Map<String, LangSysTable> langSysTables = new LinkedHashMap<>(langSysCount);    for (LangSysRecord langSysRecord : langSysRecords) {        langSysTables.put(langSysRecord.getLangSysTag(), langSysRecord.getLangSysTable());    }    return new ScriptTable(defaultLangSysTable, Collections.unmodifiableMap(langSysTables));}
private LangSysTable pdfbox_f1497_0(TTFDataStream data, long offset) throws IOException
{    data.seek(offset);    int lookupOrder = data.readUnsignedShort();    int requiredFeatureIndex = data.readUnsignedShort();    int featureIndexCount = data.readUnsignedShort();    int[] featureIndices = new int[featureIndexCount];    for (int i = 0; i < featureIndexCount; i++) {        featureIndices[i] = data.readUnsignedShort();    }    return new LangSysTable(lookupOrder, requiredFeatureIndex, featureIndexCount, featureIndices);}
private FeatureListTable pdfbox_f1498_1(TTFDataStream data, long offset) throws IOException
{    data.seek(offset);    int featureCount = data.readUnsignedShort();    FeatureRecord[] featureRecords = new FeatureRecord[featureCount];    int[] featureOffsets = new int[featureCount];    String[] featureTags = new String[featureCount];    for (int i = 0; i < featureCount; i++) {        featureTags[i] = data.readString(4);        if (i > 0 && featureTags[i].compareTo(featureTags[i - 1]) < 0) {                                                return new FeatureListTable(0, new FeatureRecord[0]);        }        featureOffsets[i] = data.readUnsignedShort();    }    for (int i = 0; i < featureCount; i++) {        FeatureTable featureTable = readFeatureTable(data, offset + featureOffsets[i]);        featureRecords[i] = new FeatureRecord(featureTags[i], featureTable);    }    return new FeatureListTable(featureCount, featureRecords);}
private FeatureTable pdfbox_f1499_0(TTFDataStream data, long offset) throws IOException
{    data.seek(offset);    int featureParams = data.readUnsignedShort();    int lookupIndexCount = data.readUnsignedShort();    int[] lookupListIndices = new int[lookupIndexCount];    for (int i = 0; i < lookupIndexCount; i++) {        lookupListIndices[i] = data.readUnsignedShort();    }    return new FeatureTable(featureParams, lookupIndexCount, lookupListIndices);}
private LookupListTable pdfbox_f1500_0(TTFDataStream data, long offset) throws IOException
{    data.seek(offset);    int lookupCount = data.readUnsignedShort();    int[] lookups = new int[lookupCount];    for (int i = 0; i < lookupCount; i++) {        lookups[i] = data.readUnsignedShort();    }    LookupTable[] lookupTables = new LookupTable[lookupCount];    for (int i = 0; i < lookupCount; i++) {        lookupTables[i] = readLookupTable(data, offset + lookups[i]);    }    return new LookupListTable(lookupCount, lookupTables);}
private LookupTable pdfbox_f1501_1(TTFDataStream data, long offset) throws IOException
{    data.seek(offset);    int lookupType = data.readUnsignedShort();    int lookupFlag = data.readUnsignedShort();    int subTableCount = data.readUnsignedShort();    int[] subTableOffets = new int[subTableCount];    for (int i = 0; i < subTableCount; i++) {        subTableOffets[i] = data.readUnsignedShort();    }    int markFilteringSet;    if ((lookupFlag & 0x0010) != 0) {        markFilteringSet = data.readUnsignedShort();    } else {        markFilteringSet = 0;    }    LookupSubTable[] subTables = new LookupSubTable[subTableCount];    switch(lookupType) {        case 1:                        for (int i = 0; i < subTableCount; i++) {                subTables[i] = readLookupSubTable(data, offset + subTableOffets[i]);            }            break;        case 4:                        for (int i = 0; i < subTableCount; i++) {                subTables[i] = readLigatureSubstitutionSubtable(data, offset + subTableOffets[i]);            }            break;        default:                            }    return new LookupTable(lookupType, lookupFlag, markFilteringSet, subTables);}
private LookupSubTable pdfbox_f1502_0(TTFDataStream data, long offset) throws IOException
{    data.seek(offset);    int substFormat = data.readUnsignedShort();    switch(substFormat) {        case 1:            {                                                int coverageOffset = data.readUnsignedShort();                short deltaGlyphID = data.readSignedShort();                CoverageTable coverageTable = readCoverageTable(data, offset + coverageOffset);                return new LookupTypeSingleSubstFormat1(substFormat, coverageTable, deltaGlyphID);            }        case 2:            {                                                int coverageOffset = data.readUnsignedShort();                int glyphCount = data.readUnsignedShort();                int[] substituteGlyphIDs = new int[glyphCount];                for (int i = 0; i < glyphCount; i++) {                    substituteGlyphIDs[i] = data.readUnsignedShort();                }                CoverageTable coverageTable = readCoverageTable(data, offset + coverageOffset);                return new LookupTypeSingleSubstFormat2(substFormat, coverageTable, substituteGlyphIDs);            }        default:            throw new IOException("Unknown substFormat: " + substFormat);    }}
private LookupSubTable pdfbox_f1503_0(TTFDataStream data, long offset) throws IOException
{    data.seek(offset);    int substFormat = data.readUnsignedShort();    if (substFormat != 1) {        throw new IOException("The expected SubstFormat for LigatureSubstitutionTable is 1");    }    int coverage = data.readUnsignedShort();    int ligSetCount = data.readUnsignedShort();    int[] ligatureOffsets = new int[ligSetCount];    for (int i = 0; i < ligSetCount; i++) {        ligatureOffsets[i] = data.readUnsignedShort();    }    CoverageTable coverageTable = readCoverageTable(data, offset + coverage);    if (ligSetCount != coverageTable.getSize()) {        throw new IOException("According to the OpenTypeFont specifications, the coverage count should be equal to the no. of LigatureSetTables");    }    LigatureSetTable[] ligatureSetTables = new LigatureSetTable[ligSetCount];    for (int i = 0; i < ligSetCount; i++) {        int coverageGlyphId = coverageTable.getGlyphId(i);        ligatureSetTables[i] = readLigatureSetTable(data, offset + ligatureOffsets[i], coverageGlyphId);    }    return new LookupTypeLigatureSubstitutionSubstFormat1(substFormat, coverageTable, ligatureSetTables);}
private LigatureSetTable pdfbox_f1504_1(TTFDataStream data, long ligatureSetTableLocation, int coverageGlyphId) throws IOException
{    data.seek(ligatureSetTableLocation);    int ligatureCount = data.readUnsignedShort();        int[] ligatureOffsets = new int[ligatureCount];    LigatureTable[] ligatureTables = new LigatureTable[ligatureCount];    for (int i = 0; i < ligatureOffsets.length; i++) {        ligatureOffsets[i] = data.readUnsignedShort();    }    for (int i = 0; i < ligatureOffsets.length; i++) {        int ligatureOffset = ligatureOffsets[i];        ligatureTables[i] = readLigatureTable(data, ligatureSetTableLocation + ligatureOffset, coverageGlyphId);    }    return new LigatureSetTable(ligatureCount, ligatureTables);}
private LigatureTable pdfbox_f1505_0(TTFDataStream data, long ligatureTableLocation, int coverageGlyphId) throws IOException
{    data.seek(ligatureTableLocation);    int ligatureGlyph = data.readUnsignedShort();    int componentCount = data.readUnsignedShort();    int[] componentGlyphIDs = new int[componentCount];    if (componentCount > 0) {        componentGlyphIDs[0] = coverageGlyphId;    }    for (int i = 1; i <= componentCount - 1; i++) {        componentGlyphIDs[i] = data.readUnsignedShort();    }    return new LigatureTable(ligatureGlyph, componentCount, componentGlyphIDs);}
private CoverageTable pdfbox_f1506_0(TTFDataStream data, long offset) throws IOException
{    data.seek(offset);    int coverageFormat = data.readUnsignedShort();    switch(coverageFormat) {        case 1:            {                int glyphCount = data.readUnsignedShort();                int[] glyphArray = new int[glyphCount];                for (int i = 0; i < glyphCount; i++) {                    glyphArray[i] = data.readUnsignedShort();                }                return new CoverageTableFormat1(coverageFormat, glyphArray);            }        case 2:            {                int rangeCount = data.readUnsignedShort();                RangeRecord[] rangeRecords = new RangeRecord[rangeCount];                for (int i = 0; i < rangeCount; i++) {                    rangeRecords[i] = readRangeRecord(data);                }                return new CoverageTableFormat2(coverageFormat, rangeRecords);            }        default:                        throw new IOException("Unknown coverage format: " + coverageFormat);    }}
private String pdfbox_f1507_0(String[] tags)
{    if (tags.length == 1) {        String tag = tags[0];        if (OpenTypeScript.INHERITED.equals(tag) || (OpenTypeScript.TAG_DEFAULT.equals(tag) && !scriptList.containsKey(tag))) {                        if (lastUsedSupportedScript == null) {                                lastUsedSupportedScript = scriptList.keySet().iterator().next();            }            return lastUsedSupportedScript;        }    }    for (String tag : tags) {        if (scriptList.containsKey(tag)) {                                    lastUsedSupportedScript = tag;            return lastUsedSupportedScript;        }    }    return tags[0];}
private Collection<LangSysTable> pdfbox_f1508_0(String scriptTag)
{    Collection<LangSysTable> result = Collections.emptyList();    ScriptTable scriptTable = scriptList.get(scriptTag);    if (scriptTable != null) {        if (scriptTable.getDefaultLangSysTable() == null) {            result = scriptTable.getLangSysTables().values();        } else {            result = new ArrayList<>(scriptTable.getLangSysTables().values());            result.add(scriptTable.getDefaultLangSysTable());        }    }    return result;}
private List<FeatureRecord> pdfbox_f1509_0(Collection<LangSysTable> langSysTables, final List<String> enabledFeatures)
{    if (langSysTables.isEmpty()) {        return Collections.emptyList();    }    List<FeatureRecord> result = new ArrayList<>();    langSysTables.forEach(langSysTable -> {        int required = langSysTable.getRequiredFeatureIndex();        if (        required != 0xffff) {            result.add(featureListTable.getFeatureRecords()[required]);        }        for (int featureIndex : langSysTable.getFeatureIndices()) {            if (enabledFeatures == null || enabledFeatures.contains(featureListTable.getFeatureRecords()[featureIndex].getFeatureTag())) {                result.add(featureListTable.getFeatureRecords()[featureIndex]);            }        }    });        if (containsFeature(result, "vrt2")) {        removeFeature(result, "vert");    }    if (enabledFeatures != null && result.size() > 1) {        Collections.sort(result, (o1, o2) -> Integer.compare(enabledFeatures.indexOf(o1.getFeatureTag()), enabledFeatures.indexOf(o2.getFeatureTag())));    }    return result;}
private boolean pdfbox_f1510_0(List<FeatureRecord> featureRecords, String featureTag)
{    return featureRecords.stream().anyMatch(featureRecord -> featureRecord.getFeatureTag().equals(featureTag));}
private void pdfbox_f1511_0(List<FeatureRecord> featureRecords, String featureTag)
{    Iterator<FeatureRecord> iter = featureRecords.iterator();    while (iter.hasNext()) {        if (iter.next().getFeatureTag().equals(featureTag)) {            iter.remove();        }    }}
private int pdfbox_f1512_1(FeatureRecord featureRecord, int gid)
{    int lookupResult = gid;    for (int lookupListIndex : featureRecord.getFeatureTable().getLookupListIndices()) {        LookupTable lookupTable = lookupListTable.getLookups()[lookupListIndex];        if (lookupTable.getLookupType() != 1) {                        continue;        }        lookupResult = doLookup(lookupTable, lookupResult);    }    return lookupResult;}
private int pdfbox_f1513_0(LookupTable lookupTable, int gid)
{    for (LookupSubTable lookupSubtable : lookupTable.getSubTables()) {        int coverageIndex = lookupSubtable.getCoverageTable().getCoverageIndex(gid);        if (coverageIndex >= 0) {            return lookupSubtable.doSubstitution(gid, coverageIndex);        }    }    return gid;}
public int pdfbox_f1514_0(int gid, String[] scriptTags, List<String> enabledFeatures)
{    if (gid == -1) {        return -1;    }    Integer cached = lookupCache.get(gid);    if (cached != null) {                return cached;    }    String scriptTag = selectScriptTag(scriptTags);    Collection<LangSysTable> langSysTables = getLangSysTables(scriptTag);    List<FeatureRecord> featureRecords = getFeatureRecords(langSysTables, enabledFeatures);    int sgid = gid;    for (FeatureRecord featureRecord : featureRecords) {        sgid = applyFeature(featureRecord, sgid);    }    lookupCache.put(gid, sgid);    reverseLookup.put(sgid, gid);    return sgid;}
public int pdfbox_f1515_1(int sgid)
{    Integer gid = reverseLookup.get(sgid);    if (gid == null) {                return sgid;    }    return gid;}
public GsubData pdfbox_f1516_0()
{    return gsubData;}
private RangeRecord pdfbox_f1517_0(TTFDataStream data) throws IOException
{    int startGlyphID = data.readUnsignedShort();    int endGlyphID = data.readUnsignedShort();    int startCoverageIndex = data.readUnsignedShort();    return new RangeRecord(startGlyphID, endGlyphID, startCoverageIndex);}
 void pdfbox_f1518_0(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    loca = ttf.getIndexToLocation();    numGlyphs = ttf.getNumberOfGlyphs();    if (numGlyphs < MAX_CACHE_SIZE) {                glyphs = new GlyphData[numGlyphs];    }        this.data = data;    initialized = true;}
public GlyphData[] pdfbox_f1519_0() throws IOException
{        synchronized (data) {                long[] offsets = loca.getOffsets();                                        long endOfGlyphs = offsets[numGlyphs];        long offset = getOffset();        if (glyphs == null) {            glyphs = new GlyphData[numGlyphs];        }        for (int gid = 0; gid < numGlyphs; gid++) {                        if (endOfGlyphs != 0 && endOfGlyphs == offsets[gid]) {                break;            }                        if (offsets[gid + 1] <= offsets[gid]) {                continue;            }            if (glyphs[gid] != null) {                                continue;            }            data.seek(offset + offsets[gid]);            if (glyphs[gid] == null) {                ++cached;            }            glyphs[gid] = getGlyphData(gid);        }        initialized = true;        return glyphs;    }}
public void pdfbox_f1520_0(GlyphData[] glyphsValue)
{    glyphs = glyphsValue;}
public GlyphData pdfbox_f1521_0(int gid) throws IOException
{    if (gid < 0 || gid >= numGlyphs) {        return null;    }    if (glyphs != null && glyphs[gid] != null) {        return glyphs[gid];    }        synchronized (data) {                long[] offsets = loca.getOffsets();        if (offsets[gid] == offsets[gid + 1]) {                        return null;        }                long currentPosition = data.getCurrentPosition();        data.seek(getOffset() + offsets[gid]);        GlyphData glyph = getGlyphData(gid);                data.seek(currentPosition);        if (glyphs != null && glyphs[gid] == null && cached < MAX_CACHED_GLYPHS) {            glyphs[gid] = glyph;            ++cached;        }        return glyph;    }}
private GlyphData pdfbox_f1522_0(int gid) throws IOException
{    GlyphData glyph = new GlyphData();    HorizontalMetricsTable hmt = font.getHorizontalMetrics();    int leftSideBearing = hmt == null ? 0 : hmt.getLeftSideBearing(gid);    glyph.initData(this, data, leftSideBearing);        if (glyph.getDescription().isComposite()) {        glyph.getDescription().resolve();    }    return glyph;}
public List<String> pdfbox_f1523_0(String text)
{    List<String> tokens = new ArrayList<>();    Matcher regexMatcher = regexExpression.matcher(text);    int lastIndexOfPrevMatch = 0;    while (regexMatcher.find()) {        int beginIndexOfNextMatch = regexMatcher.start();        String prevToken = text.substring(lastIndexOfPrevMatch, beginIndexOfNextMatch);        if (prevToken.length() > 0) {            tokens.add(prevToken);        }        String currentMatch = regexMatcher.group();        tokens.add(currentMatch);        lastIndexOfPrevMatch = regexMatcher.end();    }    String tail = text.substring(lastIndexOfPrevMatch, text.length());    if (tail.length() > 0) {        tokens.add(tail);    }    return tokens;}
private String pdfbox_f1524_0(Set<String> compoundWords)
{    StringBuilder sb = new StringBuilder();    for (String compoundWord : compoundWords) {        sb.append("(");        sb.append(compoundWord);        sb.append(")|");    }    sb.setLength(sb.length() - 1);    return sb.toString();}
public List<List<Integer>> pdfbox_f1525_0(List<Integer> glyphIds)
{    String originalGlyphsAsText = convertGlyphIdsToString(glyphIds);    List<String> tokens = compoundCharacterTokenizer.tokenize(originalGlyphsAsText);    List<List<Integer>> modifiedGlyphs = new ArrayList<>();    tokens.forEach(token -> modifiedGlyphs.add(convertGlyphIdsToList(token)));    return modifiedGlyphs;}
private Set<String> pdfbox_f1526_0(Set<List<Integer>> matchers)
{    Set<String> stringMatchers = new HashSet<>(matchers.size());    matchers.forEach(glyphIds -> stringMatchers.add(convertGlyphIdsToString(glyphIds)));    return stringMatchers;}
private String pdfbox_f1527_0(List<Integer> glyphIds)
{    StringBuilder sb = new StringBuilder(20);    sb.append(GLYPH_ID_SEPARATOR);    glyphIds.forEach(glyphId -> sb.append(glyphId).append(GLYPH_ID_SEPARATOR));    return sb.toString();}
private List<Integer> pdfbox_f1528_0(String glyphIdsAsString)
{    List<Integer> gsubProcessedGlyphsIds = new ArrayList<>();    for (String glyphId : glyphIdsAsString.split(GLYPH_ID_SEPARATOR)) {        if (glyphId.trim().length() == 0) {            continue;        }        gsubProcessedGlyphsIds.add(Integer.valueOf(glyphId));    }    return gsubProcessedGlyphsIds;}
public GsubData pdfbox_f1529_0(Map<String, ScriptTable> scriptList, FeatureListTable featureListTable, LookupListTable lookupListTable)
{    ScriptTableDetails scriptTableDetails = getSupportedLanguage(scriptList);    if (scriptTableDetails == null) {        return GsubData.NO_DATA_FOUND;    }    ScriptTable scriptTable = scriptTableDetails.getScriptTable();    Map<String, Map<List<Integer>, Integer>> gsubData = new LinkedHashMap<>();        if (scriptTable.getDefaultLangSysTable() != null) {        populateGsubData(gsubData, scriptTable.getDefaultLangSysTable(), featureListTable, lookupListTable);    }    for (LangSysTable langSysTable : scriptTable.getLangSysTables().values()) {        populateGsubData(gsubData, langSysTable, featureListTable, lookupListTable);    }    return new MapBackedGsubData(scriptTableDetails.getLanguage(), scriptTableDetails.getFeatureName(), gsubData);}
private ScriptTableDetails pdfbox_f1530_0(Map<String, ScriptTable> scriptList)
{    for (Language lang : Language.values()) {        for (String scriptName : lang.getScriptNames()) {            if (scriptList.containsKey(scriptName)) {                return new ScriptTableDetails(lang, scriptName, scriptList.get(scriptName));            }        }    }    return null;}
private void pdfbox_f1531_0(Map<String, Map<List<Integer>, Integer>> gsubData, LangSysTable langSysTable, FeatureListTable featureListTable, LookupListTable lookupListTable)
{    FeatureRecord[] featureRecords = featureListTable.getFeatureRecords();    for (int featureIndex : langSysTable.getFeatureIndices()) {        if (featureIndex < featureRecords.length) {            populateGsubData(gsubData, featureRecords[featureIndex], lookupListTable);        }    }}
private void pdfbox_f1532_1(Map<String, Map<List<Integer>, Integer>> gsubData, FeatureRecord featureRecord, LookupListTable lookupListTable)
{    LookupTable[] lookups = lookupListTable.getLookups();    Map<List<Integer>, Integer> glyphSubstitutionMap = new LinkedHashMap<>();    for (int lookupIndex : featureRecord.getFeatureTable().getLookupListIndices()) {        if (lookupIndex < lookups.length) {            extractData(glyphSubstitutionMap, lookups[lookupIndex]);        }    }        gsubData.put(featureRecord.getFeatureTag(), Collections.unmodifiableMap(glyphSubstitutionMap));}
private void pdfbox_f1533_1(Map<List<Integer>, Integer> glyphSubstitutionMap, LookupTable lookupTable)
{    for (LookupSubTable lookupSubTable : lookupTable.getSubTables()) {        if (lookupSubTable instanceof LookupTypeLigatureSubstitutionSubstFormat1) {            extractDataFromLigatureSubstitutionSubstFormat1Table(glyphSubstitutionMap, (LookupTypeLigatureSubstitutionSubstFormat1) lookupSubTable);        } else if (lookupSubTable instanceof LookupTypeSingleSubstFormat1) {            extractDataFromSingleSubstTableFormat1Table(glyphSubstitutionMap, (LookupTypeSingleSubstFormat1) lookupSubTable);        } else if (lookupSubTable instanceof LookupTypeSingleSubstFormat2) {            extractDataFromSingleSubstTableFormat2Table(glyphSubstitutionMap, (LookupTypeSingleSubstFormat2) lookupSubTable);        } else {                                }    }}
private void pdfbox_f1534_0(Map<List<Integer>, Integer> glyphSubstitutionMap, LookupTypeSingleSubstFormat1 singleSubstTableFormat1)
{    CoverageTable coverageTable = singleSubstTableFormat1.getCoverageTable();    for (int i = 0; i < coverageTable.getSize(); i++) {        int coverageGlyphId = coverageTable.getGlyphId(i);        int substituteGlyphId = coverageGlyphId + singleSubstTableFormat1.getDeltaGlyphID();        putNewSubstitutionEntry(glyphSubstitutionMap, substituteGlyphId, Arrays.asList(coverageGlyphId));    }}
private void pdfbox_f1535_0(Map<List<Integer>, Integer> glyphSubstitutionMap, LookupTypeSingleSubstFormat2 singleSubstTableFormat2)
{    CoverageTable coverageTable = singleSubstTableFormat2.getCoverageTable();    if (coverageTable.getSize() != singleSubstTableFormat2.getSubstituteGlyphIDs().length) {        throw new IllegalArgumentException("The no. coverage table entries should be the same as the size of the substituteGlyphIDs");    }    for (int i = 0; i < coverageTable.getSize(); i++) {        int coverageGlyphId = coverageTable.getGlyphId(i);        int substituteGlyphId = coverageGlyphId + singleSubstTableFormat2.getSubstituteGlyphIDs()[i];        putNewSubstitutionEntry(glyphSubstitutionMap, substituteGlyphId, Arrays.asList(coverageGlyphId));    }}
private void pdfbox_f1536_0(Map<List<Integer>, Integer> glyphSubstitutionMap, LookupTypeLigatureSubstitutionSubstFormat1 ligatureSubstitutionTable)
{    for (LigatureSetTable ligatureSetTable : ligatureSubstitutionTable.getLigatureSetTables()) {        for (LigatureTable ligatureTable : ligatureSetTable.getLigatureTables()) {            extractDataFromLigatureTable(glyphSubstitutionMap, ligatureTable);        }    }}
private void pdfbox_f1537_1(Map<List<Integer>, Integer> glyphSubstitutionMap, LigatureTable ligatureTable)
{    List<Integer> glyphsToBeSubstituted = new ArrayList<>();    for (int componentGlyphID : ligatureTable.getComponentGlyphIDs()) {        glyphsToBeSubstituted.add(componentGlyphID);    }        putNewSubstitutionEntry(glyphSubstitutionMap, ligatureTable.getLigatureGlyph(), glyphsToBeSubstituted);}
private void pdfbox_f1538_1(Map<List<Integer>, Integer> glyphSubstitutionMap, int newGlyph, List<Integer> glyphsToBeSubstituted)
{    Integer oldValue = glyphSubstitutionMap.put(glyphsToBeSubstituted, newGlyph);    if (oldValue != null) {        String message = "For the newGlyph: " + newGlyph + ", newValue: " + glyphsToBeSubstituted + " is trying to override the oldValue: " + oldValue;            }}
public Language pdfbox_f1539_0()
{    return language;}
public String pdfbox_f1540_0()
{    return featureName;}
public ScriptTable pdfbox_f1541_0()
{    return scriptTable;}
public GsubWorker pdfbox_f1542_0(CmapLookup cmapLookup, GsubData gsubData)
{    switch(gsubData.getLanguage()) {        case BENGALI:            return new GsubWorkerForBengali(cmapLookup, gsubData);        default:            throw new UnsupportedOperationException("The language " + gsubData.getLanguage() + " is not yet supported");    }}
public List<Integer> pdfbox_f1543_1(List<Integer> originalGlyphIds)
{    List<Integer> intermediateGlyphsFromGsub = originalGlyphIds;    for (String feature : FEATURES_IN_ORDER) {        if (!gsubData.isFeatureSupported(feature)) {                        continue;        }                ScriptFeature scriptFeature = gsubData.getFeature(feature);        intermediateGlyphsFromGsub = applyGsubFeature(scriptFeature, intermediateGlyphsFromGsub);    }    return Collections.unmodifiableList(repositionGlyphs(intermediateGlyphsFromGsub));}
private List<Integer> pdfbox_f1544_0(List<Integer> originalGlyphIds)
{    List<Integer> glyphsRepositionedByBeforeHalf = repositionBeforeHalfGlyphIds(originalGlyphIds);    return repositionBeforeAndAfterSpanGlyphIds(glyphsRepositionedByBeforeHalf);}
private List<Integer> pdfbox_f1545_0(List<Integer> originalGlyphIds)
{    List<Integer> repositionedGlyphIds = new ArrayList<>(originalGlyphIds);    for (int index = 1; index < originalGlyphIds.size(); index++) {        int glyphId = originalGlyphIds.get(index);        if (beforeHalfGlyphIds.contains(glyphId)) {            int previousGlyphId = originalGlyphIds.get(index - 1);            repositionedGlyphIds.set(index, previousGlyphId);            repositionedGlyphIds.set(index - 1, glyphId);        }    }    return repositionedGlyphIds;}
private List<Integer> pdfbox_f1546_0(List<Integer> originalGlyphIds)
{    List<Integer> repositionedGlyphIds = new ArrayList<>(originalGlyphIds);    for (int index = 1; index < originalGlyphIds.size(); index++) {        int glyphId = originalGlyphIds.get(index);        if (beforeAndAfterSpanGlyphIds.containsKey(glyphId)) {            BeforeAndAfterSpanComponent beforeAndAfterSpanComponent = beforeAndAfterSpanGlyphIds.get(glyphId);            int previousGlyphId = originalGlyphIds.get(index - 1);            repositionedGlyphIds.set(index, previousGlyphId);            repositionedGlyphIds.set(index - 1, getGlyphId(beforeAndAfterSpanComponent.beforeComponentCharacter));            repositionedGlyphIds.add(index + 1, getGlyphId(beforeAndAfterSpanComponent.afterComponentCharacter));        }    }    return repositionedGlyphIds;}
private List<Integer> pdfbox_f1547_1(ScriptFeature scriptFeature, List<Integer> originalGlyphs)
{    GlyphArraySplitter glyphArraySplitter = new GlyphArraySplitterRegexImpl(scriptFeature.getAllGlyphIdsForSubstitution());    List<List<Integer>> tokens = glyphArraySplitter.split(originalGlyphs);    List<Integer> gsubProcessedGlyphs = new ArrayList<>();    for (List<Integer> chunk : tokens) {        if (scriptFeature.canReplaceGlyphs(chunk)) {                        int glyphId = scriptFeature.getReplacementForGlyphs(chunk);            gsubProcessedGlyphs.add(glyphId);        } else {            gsubProcessedGlyphs.addAll(chunk);        }    }        return gsubProcessedGlyphs;}
private List<Integer> pdfbox_f1548_0()
{    List<Integer> glyphIds = new ArrayList<>();    for (char character : BEFORE_HALF_CHARS) {        glyphIds.add(getGlyphId(character));    }    if (gsubData.isFeatureSupported(INIT_FEATURE)) {        ScriptFeature feature = gsubData.getFeature(INIT_FEATURE);        for (List<Integer> glyphCluster : feature.getAllGlyphIdsForSubstitution()) {            glyphIds.add(feature.getReplacementForGlyphs(glyphCluster));        }    }    return Collections.unmodifiableList(glyphIds);}
private Integer pdfbox_f1549_0(char character)
{    return cmapLookup.getGlyphId(character);}
private Map<Integer, BeforeAndAfterSpanComponent> pdfbox_f1550_0()
{    Map<Integer, BeforeAndAfterSpanComponent> result = new HashMap<>();    for (BeforeAndAfterSpanComponent beforeAndAfterSpanComponent : BEFORE_AND_AFTER_SPAN_CHARS) {        result.put(getGlyphId(beforeAndAfterSpanComponent.originalCharacter), beforeAndAfterSpanComponent);    }    return Collections.unmodifiableMap(result);}
 void pdfbox_f1551_0(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    version = data.read32Fixed();    fontRevision = data.read32Fixed();    checkSumAdjustment = data.readUnsignedInt();    magicNumber = data.readUnsignedInt();    flags = data.readUnsignedShort();    unitsPerEm = data.readUnsignedShort();    created = data.readInternationalDate();    modified = data.readInternationalDate();    xMin = data.readSignedShort();    yMin = data.readSignedShort();    xMax = data.readSignedShort();    yMax = data.readSignedShort();    macStyle = data.readUnsignedShort();    lowestRecPPEM = data.readUnsignedShort();    fontDirectionHint = data.readSignedShort();    indexToLocFormat = data.readSignedShort();    glyphDataFormat = data.readSignedShort();    initialized = true;}
public long pdfbox_f1552_0()
{    return checkSumAdjustment;}
public void pdfbox_f1553_0(long checkSumAdjustmentValue)
{    this.checkSumAdjustment = checkSumAdjustmentValue;}
public Calendar pdfbox_f1554_0()
{    return created;}
public void pdfbox_f1555_0(Calendar createdValue)
{    this.created = createdValue;}
public int pdfbox_f1556_0()
{    return flags;}
public void pdfbox_f1557_0(int flagsValue)
{    this.flags = flagsValue;}
public short pdfbox_f1558_0()
{    return fontDirectionHint;}
public void pdfbox_f1559_0(short fontDirectionHintValue)
{    this.fontDirectionHint = fontDirectionHintValue;}
public float pdfbox_f1560_0()
{    return fontRevision;}
public void pdfbox_f1561_0(float fontRevisionValue)
{    this.fontRevision = fontRevisionValue;}
public short pdfbox_f1562_0()
{    return glyphDataFormat;}
public void pdfbox_f1563_0(short glyphDataFormatValue)
{    this.glyphDataFormat = glyphDataFormatValue;}
public short pdfbox_f1564_0()
{    return indexToLocFormat;}
public void pdfbox_f1565_0(short indexToLocFormatValue)
{    this.indexToLocFormat = indexToLocFormatValue;}
public int pdfbox_f1566_0()
{    return lowestRecPPEM;}
public void pdfbox_f1567_0(int lowestRecPPEMValue)
{    this.lowestRecPPEM = lowestRecPPEMValue;}
public int pdfbox_f1568_0()
{    return macStyle;}
public void pdfbox_f1569_0(int macStyleValue)
{    this.macStyle = macStyleValue;}
public long pdfbox_f1570_0()
{    return magicNumber;}
public void pdfbox_f1571_0(long magicNumberValue)
{    this.magicNumber = magicNumberValue;}
public Calendar pdfbox_f1572_0()
{    return modified;}
public void pdfbox_f1573_0(Calendar modifiedValue)
{    this.modified = modifiedValue;}
public int pdfbox_f1574_0()
{    return unitsPerEm;}
public void pdfbox_f1575_0(int unitsPerEmValue)
{    this.unitsPerEm = unitsPerEmValue;}
public float pdfbox_f1576_0()
{    return version;}
public void pdfbox_f1577_0(float versionValue)
{    this.version = versionValue;}
public short pdfbox_f1578_0()
{    return xMax;}
public void pdfbox_f1579_0(short maxValue)
{    xMax = maxValue;}
public short pdfbox_f1580_0()
{    return xMin;}
public void pdfbox_f1581_0(short minValue)
{    xMin = minValue;}
public short pdfbox_f1582_0()
{    return yMax;}
public void pdfbox_f1583_0(short maxValue)
{    yMax = maxValue;}
public short pdfbox_f1584_0()
{    return yMin;}
public void pdfbox_f1585_0(short minValue)
{    yMin = minValue;}
 void pdfbox_f1586_0(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    version = data.read32Fixed();    ascender = data.readSignedShort();    descender = data.readSignedShort();    lineGap = data.readSignedShort();    advanceWidthMax = data.readUnsignedShort();    minLeftSideBearing = data.readSignedShort();    minRightSideBearing = data.readSignedShort();    xMaxExtent = data.readSignedShort();    caretSlopeRise = data.readSignedShort();    caretSlopeRun = data.readSignedShort();    reserved1 = data.readSignedShort();    reserved2 = data.readSignedShort();    reserved3 = data.readSignedShort();    reserved4 = data.readSignedShort();    reserved5 = data.readSignedShort();    metricDataFormat = data.readSignedShort();    numberOfHMetrics = data.readUnsignedShort();    initialized = true;}
public int pdfbox_f1587_0()
{    return advanceWidthMax;}
public void pdfbox_f1588_0(int advanceWidthMaxValue)
{    this.advanceWidthMax = advanceWidthMaxValue;}
public short pdfbox_f1589_0()
{    return ascender;}
public void pdfbox_f1590_0(short ascenderValue)
{    this.ascender = ascenderValue;}
public short pdfbox_f1591_0()
{    return caretSlopeRise;}
public void pdfbox_f1592_0(short caretSlopeRiseValue)
{    this.caretSlopeRise = caretSlopeRiseValue;}
public short pdfbox_f1593_0()
{    return caretSlopeRun;}
public void pdfbox_f1594_0(short caretSlopeRunValue)
{    this.caretSlopeRun = caretSlopeRunValue;}
public short pdfbox_f1595_0()
{    return descender;}
public void pdfbox_f1596_0(short descenderValue)
{    this.descender = descenderValue;}
public short pdfbox_f1597_0()
{    return lineGap;}
public void pdfbox_f1598_0(short lineGapValue)
{    this.lineGap = lineGapValue;}
public short pdfbox_f1599_0()
{    return metricDataFormat;}
public void pdfbox_f1600_0(short metricDataFormatValue)
{    this.metricDataFormat = metricDataFormatValue;}
public short pdfbox_f1601_0()
{    return minLeftSideBearing;}
public void pdfbox_f1602_0(short minLeftSideBearingValue)
{    this.minLeftSideBearing = minLeftSideBearingValue;}
public short pdfbox_f1603_0()
{    return minRightSideBearing;}
public void pdfbox_f1604_0(short minRightSideBearingValue)
{    this.minRightSideBearing = minRightSideBearingValue;}
public int pdfbox_f1605_0()
{    return numberOfHMetrics;}
public void pdfbox_f1606_0(int numberOfHMetricsValue)
{    this.numberOfHMetrics = numberOfHMetricsValue;}
public short pdfbox_f1607_0()
{    return reserved1;}
public void pdfbox_f1608_0(short reserved1Value)
{    this.reserved1 = reserved1Value;}
public short pdfbox_f1609_0()
{    return reserved2;}
public void pdfbox_f1610_0(short reserved2Value)
{    this.reserved2 = reserved2Value;}
public short pdfbox_f1611_0()
{    return reserved3;}
public void pdfbox_f1612_0(short reserved3Value)
{    this.reserved3 = reserved3Value;}
public short pdfbox_f1613_0()
{    return reserved4;}
public void pdfbox_f1614_0(short reserved4Value)
{    this.reserved4 = reserved4Value;}
public short pdfbox_f1615_0()
{    return reserved5;}
public void pdfbox_f1616_0(short reserved5Value)
{    this.reserved5 = reserved5Value;}
public float pdfbox_f1617_0()
{    return version;}
public void pdfbox_f1618_0(float versionValue)
{    this.version = versionValue;}
public short pdfbox_f1619_0()
{    return xMaxExtent;}
public void pdfbox_f1620_0(short maxExtentValue)
{    xMaxExtent = maxExtentValue;}
 void pdfbox_f1621_0(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    HorizontalHeaderTable hHeader = ttf.getHorizontalHeader();    if (hHeader == null) {        throw new IOException("Could not get hhea table");    }    numHMetrics = hHeader.getNumberOfHMetrics();    int numGlyphs = ttf.getNumberOfGlyphs();    int bytesRead = 0;    advanceWidth = new int[numHMetrics];    leftSideBearing = new short[numHMetrics];    for (int i = 0; i < numHMetrics; i++) {        advanceWidth[i] = data.readUnsignedShort();        leftSideBearing[i] = data.readSignedShort();        bytesRead += 4;    }    int numberNonHorizontal = numGlyphs - numHMetrics;        if (numberNonHorizontal < 0) {        numberNonHorizontal = numGlyphs;    }            nonHorizontalLeftSideBearing = new short[numberNonHorizontal];    if (bytesRead < getLength()) {        for (int i = 0; i < numberNonHorizontal; i++) {            if (bytesRead < getLength()) {                nonHorizontalLeftSideBearing[i] = data.readSignedShort();                bytesRead += 2;            }        }    }    initialized = true;}
public int pdfbox_f1622_0(int gid)
{    if (gid < numHMetrics) {        return advanceWidth[gid];    } else {                return advanceWidth[advanceWidth.length - 1];    }}
public int pdfbox_f1623_0(int gid)
{    if (gid < numHMetrics) {        return leftSideBearing[gid];    } else {        return nonHorizontalLeftSideBearing[gid - numHMetrics];    }}
 void pdfbox_f1624_0(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    HeaderTable head = ttf.getHeader();    if (head == null) {        throw new IOException("Could not get head table");    }    int numGlyphs = ttf.getNumberOfGlyphs();    offsets = new long[numGlyphs + 1];    for (int i = 0; i < numGlyphs + 1; i++) {        if (head.getIndexToLocFormat() == SHORT_OFFSETS) {            offsets[i] = data.readUnsignedShort() * 2L;        } else if (head.getIndexToLocFormat() == LONG_OFFSETS) {            offsets[i] = data.readUnsignedInt();        } else {            throw new IOException("Error:TTF.loca unknown offset format: " + head.getIndexToLocFormat());        }    }    initialized = true;}
public long[] pdfbox_f1625_0()
{    return offsets;}
public void pdfbox_f1626_0(long[] offsetsValue)
{    offsets = offsetsValue;}
 void pdfbox_f1627_0(TTFDataStream data, int version) throws IOException
{    if (version == 0) {        readSubtable0(data);    } else if (version == 1) {        readSubtable1(data);    } else {        throw new IllegalStateException();    }}
public boolean pdfbox_f1628_0()
{    return isHorizontalKerning(false);}
public boolean pdfbox_f1629_0(boolean cross)
{    if (!horizontal) {        return false;    } else if (minimums) {        return false;    } else if (cross) {        return crossStream;    } else {        return !crossStream;    }}
public int[] pdfbox_f1630_1(int[] glyphs)
{    int[] kerning = null;    if (pairs != null) {        int ng = glyphs.length;        kerning = new int[ng];        for (int i = 0; i < ng; ++i) {            int l = glyphs[i];            int r = -1;            for (int k = i + 1; k < ng; ++k) {                int g = glyphs[k];                if (g >= 0) {                    r = g;                    break;                }            }            kerning[i] = getKerning(l, r);        }    } else {            }    return kerning;}
public int pdfbox_f1631_1(int l, int r)
{    if (pairs == null) {                return 0;    }    return pairs.getKerning(l, r);}
private void pdfbox_f1632_1(TTFDataStream data) throws IOException
{    int version = data.readUnsignedShort();    if (version != 0) {                return;    }    int length = data.readUnsignedShort();    if (length < 6) {        throw new IOException("Kerning sub-table too short, got " + length + " bytes, expect 6 or more.");    }    int coverage = data.readUnsignedShort();    if (isBitsSet(coverage, COVERAGE_HORIZONTAL, COVERAGE_HORIZONTAL_SHIFT)) {        this.horizontal = true;    }    if (isBitsSet(coverage, COVERAGE_MINIMUMS, COVERAGE_MINIMUMS_SHIFT)) {        this.minimums = true;    }    if (isBitsSet(coverage, COVERAGE_CROSS_STREAM, COVERAGE_CROSS_STREAM_SHIFT)) {        this.crossStream = true;    }    int format = getBits(coverage, COVERAGE_FORMAT, COVERAGE_FORMAT_SHIFT);    if (format == 0) {        readSubtable0Format0(data);    } else if (format == 2) {        readSubtable0Format2(data);    } else {            }}
private void pdfbox_f1633_0(TTFDataStream data) throws IOException
{    pairs = new PairData0Format0();    pairs.read(data);}
private void pdfbox_f1634_1(TTFDataStream data) throws IOException
{    }
private void pdfbox_f1635_1(TTFDataStream data) throws IOException
{    }
private static boolean pdfbox_f1636_0(int bits, int mask, int shift)
{    return getBits(bits, mask, shift) != 0;}
private static int pdfbox_f1637_0(int bits, int mask, int shift)
{    return (bits & mask) >> shift;}
public void pdfbox_f1638_0(TTFDataStream data) throws IOException
{    int numPairs = data.readUnsignedShort();    searchRange = data.readUnsignedShort() / 6;    int entrySelector = data.readUnsignedShort();    int rangeShift = data.readUnsignedShort();    pairs = new int[numPairs][3];    for (int i = 0; i < numPairs; ++i) {        int left = data.readUnsignedShort();        int right = data.readUnsignedShort();        int value = data.readSignedShort();        pairs[i][0] = left;        pairs[i][1] = right;        pairs[i][2] = value;    }}
public int pdfbox_f1639_0(int l, int r)
{    int[] key = new int[] { l, r, 0 };    int index = Arrays.binarySearch(pairs, key, this);    if (index >= 0) {        return pairs[index][2];    }    return 0;}
public int pdfbox_f1640_0(int[] p1, int[] p2)
{    assert p1 != null;    assert p1.length >= 2;    assert p2 != null;    assert p2.length >= 2;    int cmp1 = Integer.compare(p1[0], p2[0]);    if (cmp1 != 0) {        return cmp1;    }    return Integer.compare(p1[1], p2[1]);}
 void pdfbox_f1641_1(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    int version = data.readUnsignedShort();    if (version != 0) {        version = (version << 16) | data.readUnsignedShort();    }    int numSubtables = 0;    if (version == 0) {        numSubtables = data.readUnsignedShort();    } else if (version == 1) {        numSubtables = (int) data.readUnsignedInt();    } else {            }    if (numSubtables > 0) {        subtables = new KerningSubtable[numSubtables];        for (int i = 0; i < numSubtables; ++i) {            KerningSubtable subtable = new KerningSubtable();            subtable.read(data, version);            subtables[i] = subtable;        }    }    initialized = true;}
public KerningSubtable pdfbox_f1642_0()
{    return getHorizontalKerningSubtable(false);}
public KerningSubtable pdfbox_f1643_0(boolean cross)
{    if (subtables != null) {        for (KerningSubtable s : subtables) {            if (s.isHorizontalKerning(cross)) {                return s;            }        }    }    return null;}
public int pdfbox_f1644_0()
{    return maxComponentDepth;}
public void pdfbox_f1645_0(int maxComponentDepthValue)
{    this.maxComponentDepth = maxComponentDepthValue;}
public int pdfbox_f1646_0()
{    return maxComponentElements;}
public void pdfbox_f1647_0(int maxComponentElementsValue)
{    this.maxComponentElements = maxComponentElementsValue;}
public int pdfbox_f1648_0()
{    return maxCompositeContours;}
public void pdfbox_f1649_0(int maxCompositeContoursValue)
{    this.maxCompositeContours = maxCompositeContoursValue;}
public int pdfbox_f1650_0()
{    return maxCompositePoints;}
public void pdfbox_f1651_0(int maxCompositePointsValue)
{    this.maxCompositePoints = maxCompositePointsValue;}
public int pdfbox_f1652_0()
{    return maxContours;}
public void pdfbox_f1653_0(int maxContoursValue)
{    this.maxContours = maxContoursValue;}
public int pdfbox_f1654_0()
{    return maxFunctionDefs;}
public void pdfbox_f1655_0(int maxFunctionDefsValue)
{    this.maxFunctionDefs = maxFunctionDefsValue;}
public int pdfbox_f1656_0()
{    return maxInstructionDefs;}
public void pdfbox_f1657_0(int maxInstructionDefsValue)
{    this.maxInstructionDefs = maxInstructionDefsValue;}
public int pdfbox_f1658_0()
{    return maxPoints;}
public void pdfbox_f1659_0(int maxPointsValue)
{    this.maxPoints = maxPointsValue;}
public int pdfbox_f1660_0()
{    return maxSizeOfInstructions;}
public void pdfbox_f1661_0(int maxSizeOfInstructionsValue)
{    this.maxSizeOfInstructions = maxSizeOfInstructionsValue;}
public int pdfbox_f1662_0()
{    return maxStackElements;}
public void pdfbox_f1663_0(int maxStackElementsValue)
{    this.maxStackElements = maxStackElementsValue;}
public int pdfbox_f1664_0()
{    return maxStorage;}
public void pdfbox_f1665_0(int maxStorageValue)
{    this.maxStorage = maxStorageValue;}
public int pdfbox_f1666_0()
{    return maxTwilightPoints;}
public void pdfbox_f1667_0(int maxTwilightPointsValue)
{    this.maxTwilightPoints = maxTwilightPointsValue;}
public int pdfbox_f1668_0()
{    return maxZones;}
public void pdfbox_f1669_0(int maxZonesValue)
{    this.maxZones = maxZonesValue;}
public int pdfbox_f1670_0()
{    return numGlyphs;}
public void pdfbox_f1671_0(int numGlyphsValue)
{    this.numGlyphs = numGlyphsValue;}
public float pdfbox_f1672_0()
{    return version;}
public void pdfbox_f1673_0(float versionValue)
{    this.version = versionValue;}
 void pdfbox_f1674_0(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    version = data.read32Fixed();    numGlyphs = data.readUnsignedShort();    maxPoints = data.readUnsignedShort();    maxContours = data.readUnsignedShort();    maxCompositePoints = data.readUnsignedShort();    maxCompositeContours = data.readUnsignedShort();    maxZones = data.readUnsignedShort();    maxTwilightPoints = data.readUnsignedShort();    maxStorage = data.readUnsignedShort();    maxFunctionDefs = data.readUnsignedShort();    maxInstructionDefs = data.readUnsignedShort();    maxStackElements = data.readUnsignedShort();    maxSizeOfInstructions = data.readUnsignedShort();    maxComponentElements = data.readUnsignedShort();    maxComponentDepth = data.readUnsignedShort();    initialized = true;}
public long pdfbox_f1675_0() throws IOException
{    return ((long) (readSignedInt()) << 32) + (readSignedInt() & 0xFFFFFFFFL);}
public int pdfbox_f1676_0() throws IOException
{    int ch1 = read();    int ch2 = read();    int ch3 = read();    int ch4 = read();    if ((ch1 | ch2 | ch3 | ch4) < 0) {        throw new EOFException();    }    return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));}
public int pdfbox_f1677_0() throws IOException
{    if (currentPosition >= data.length) {        return -1;    }    int retval = data[currentPosition];    currentPosition++;    return (retval + 256) % 256;}
public int pdfbox_f1678_0() throws IOException
{    int ch1 = this.read();    int ch2 = this.read();    if ((ch1 | ch2) < 0) {        throw new EOFException();    }    return (ch1 << 8) + (ch2 << 0);}
public short pdfbox_f1679_0() throws IOException
{    int ch1 = this.read();    int ch2 = this.read();    if ((ch1 | ch2) < 0) {        throw new EOFException();    }    return (short) ((ch1 << 8) + (ch2 << 0));}
public void pdfbox_f1681_0(long pos) throws IOException
{    if (pos < 0 || pos > Integer.MAX_VALUE) {        throw new IOException("Illegal seek position: " + pos);    }    currentPosition = (int) pos;}
public int pdfbox_f1682_0(byte[] b, int off, int len) throws IOException
{    if (currentPosition < data.length) {        int amountRead = Math.min(len, data.length - currentPosition);        System.arraycopy(data, currentPosition, b, off, amountRead);        currentPosition += amountRead;        return amountRead;    } else {        return -1;    }}
public long pdfbox_f1683_0() throws IOException
{    return currentPosition;}
public InputStream pdfbox_f1684_0() throws IOException
{    return new ByteArrayInputStream(data);}
public long pdfbox_f1685_0()
{    return data.length;}
public boolean pdfbox_f1686_0(String featureName)
{    throw new UnsupportedOperationException();}
public Language pdfbox_f1687_0()
{    throw new UnsupportedOperationException();}
public ScriptFeature pdfbox_f1688_0(String featureName)
{    throw new UnsupportedOperationException();}
public String pdfbox_f1689_0()
{    throw new UnsupportedOperationException();}
public Set<String> pdfbox_f1690_0()
{    throw new UnsupportedOperationException();}
public String[] pdfbox_f1691_0()
{    return scriptNames;}
public Language pdfbox_f1692_0()
{    return language;}
public String pdfbox_f1693_0()
{    return activeScriptName;}
public boolean pdfbox_f1694_0(String featureName)
{    return glyphSubstitutionMap.containsKey(featureName);}
public ScriptFeature pdfbox_f1695_0(String featureName)
{    if (!isFeatureSupported(featureName)) {        throw new UnsupportedOperationException("The feature " + featureName + " is not supported!");    }    return new MapBackedScriptFeature(featureName, glyphSubstitutionMap.get(featureName));}
public Set<String> pdfbox_f1696_0()
{    return glyphSubstitutionMap.keySet();}
public String pdfbox_f1697_0()
{    return name;}
public Set<List<Integer>> pdfbox_f1698_0()
{    return featureMap.keySet();}
public boolean pdfbox_f1699_0(List<Integer> glyphIds)
{    return featureMap.containsKey(glyphIds);}
public Integer pdfbox_f1700_0(List<Integer> glyphIds)
{    if (!canReplaceGlyphs(glyphIds)) {        throw new UnsupportedOperationException("The glyphs " + glyphIds + " cannot be replaced");    }    return featureMap.get(glyphIds);}
public int pdfbox_f1701_0()
{    final int prime = 31;    int result = 1;    result = prime * result + ((featureMap == null) ? 0 : featureMap.hashCode());    result = prime * result + ((name == null) ? 0 : name.hashCode());    return result;}
public boolean pdfbox_f1702_0(Object obj)
{    if (this == obj) {        return true;    }    if (obj == null) {        return false;    }    if (getClass() != obj.getClass()) {        return false;    }    MapBackedScriptFeature other = (MapBackedScriptFeature) obj;    if (featureMap == null) {        if (other.featureMap != null) {            return false;        }    } else if (!featureMap.equals(other.featureMap)) {        return false;    }    if (name == null) {        if (other.name != null) {            return false;        }    } else if (!name.equals(other.name)) {        return false;    }    return true;}
public int pdfbox_f1703_0()
{    return stringLength;}
public void pdfbox_f1704_0(int stringLengthValue)
{    this.stringLength = stringLengthValue;}
public int pdfbox_f1705_0()
{    return stringOffset;}
public void pdfbox_f1706_0(int stringOffsetValue)
{    this.stringOffset = stringOffsetValue;}
public int pdfbox_f1707_0()
{    return languageId;}
public void pdfbox_f1708_0(int languageIdValue)
{    this.languageId = languageIdValue;}
public int pdfbox_f1709_0()
{    return nameId;}
public void pdfbox_f1710_0(int nameIdValue)
{    this.nameId = nameIdValue;}
public int pdfbox_f1711_0()
{    return platformEncodingId;}
public void pdfbox_f1712_0(int platformEncodingIdValue)
{    this.platformEncodingId = platformEncodingIdValue;}
public int pdfbox_f1713_0()
{    return platformId;}
public void pdfbox_f1714_0(int platformIdValue)
{    this.platformId = platformIdValue;}
 void pdfbox_f1715_0(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    platformId = data.readUnsignedShort();    platformEncodingId = data.readUnsignedShort();    languageId = data.readUnsignedShort();    nameId = data.readUnsignedShort();    stringLength = data.readUnsignedShort();    stringOffset = data.readUnsignedShort();}
public String pdfbox_f1716_0()
{    return "platform=" + platformId + " pEncoding=" + platformEncodingId + " language=" + languageId + " name=" + nameId + " " + string;}
public String pdfbox_f1717_0()
{    return string;}
public void pdfbox_f1718_0(String stringValue)
{    this.string = stringValue;}
 void pdfbox_f1719_0(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    int formatSelector = data.readUnsignedShort();    int numberOfNameRecords = data.readUnsignedShort();    int offsetToStartOfStringStorage = data.readUnsignedShort();    nameRecords = new ArrayList<>(numberOfNameRecords);    for (int i = 0; i < numberOfNameRecords; i++) {        NameRecord nr = new NameRecord();        nr.initData(ttf, data);        nameRecords.add(nr);    }    for (NameRecord nr : nameRecords) {                if (nr.getStringOffset() > getLength()) {            nr.setString(null);            continue;        }        data.seek(getOffset() + (2 * 3) + numberOfNameRecords * 2 * 6 + nr.getStringOffset());        int platform = nr.getPlatformId();        int encoding = nr.getPlatformEncodingId();        Charset charset = Charsets.ISO_8859_1;        if (platform == NameRecord.PLATFORM_WINDOWS && (encoding == NameRecord.ENCODING_WINDOWS_SYMBOL || encoding == NameRecord.ENCODING_WINDOWS_UNICODE_BMP)) {            charset = Charsets.UTF_16;        } else if (platform == NameRecord.PLATFORM_UNICODE) {            charset = Charsets.UTF_16;        } else if (platform == NameRecord.PLATFORM_ISO) {            switch(encoding) {                case 0:                    charset = Charsets.US_ASCII;                    break;                case 1:                                        charset = Charsets.ISO_10646;                    break;                case 2:                    charset = Charsets.ISO_8859_1;                    break;                default:                    break;            }        }        String string = data.readString(nr.getStringLength(), charset);        nr.setString(string);    }        lookupTable = new HashMap<>(nameRecords.size());    for (NameRecord nr : nameRecords) {                Map<Integer, Map<Integer, Map<Integer, String>>> platformLookup = lookupTable.get(nr.getNameId());        if (platformLookup == null) {            platformLookup = new HashMap<>();            lookupTable.put(nr.getNameId(), platformLookup);        }                Map<Integer, Map<Integer, String>> encodingLookup = platformLookup.get(nr.getPlatformId());        if (encodingLookup == null) {            encodingLookup = new HashMap<>();            platformLookup.put(nr.getPlatformId(), encodingLookup);        }                Map<Integer, String> languageLookup = encodingLookup.get(nr.getPlatformEncodingId());        if (languageLookup == null) {            languageLookup = new HashMap<>();            encodingLookup.put(nr.getPlatformEncodingId(), languageLookup);        }                languageLookup.put(nr.getLanguageId(), nr.getString());    }        fontFamily = getEnglishName(NameRecord.NAME_FONT_FAMILY_NAME);    fontSubFamily = getEnglishName(NameRecord.NAME_FONT_SUB_FAMILY_NAME);        psName = getName(NameRecord.NAME_POSTSCRIPT_NAME, NameRecord.PLATFORM_MACINTOSH, NameRecord.ENCODING_MACINTOSH_ROMAN, NameRecord.LANGUGAE_MACINTOSH_ENGLISH);    if (psName == null) {        psName = getName(NameRecord.NAME_POSTSCRIPT_NAME, NameRecord.PLATFORM_WINDOWS, NameRecord.ENCODING_WINDOWS_UNICODE_BMP, NameRecord.LANGUGAE_WINDOWS_EN_US);    }    if (psName != null) {        psName = psName.trim();    }    initialized = true;}
private String pdfbox_f1720_0(int nameId)
{        for (int i = 4; i >= 0; i--) {        String nameUni = getName(nameId, NameRecord.PLATFORM_UNICODE, i, NameRecord.LANGUGAE_UNICODE);        if (nameUni != null) {            return nameUni;        }    }        String nameWin = getName(nameId, NameRecord.PLATFORM_WINDOWS, NameRecord.ENCODING_WINDOWS_UNICODE_BMP, NameRecord.LANGUGAE_WINDOWS_EN_US);    if (nameWin != null) {        return nameWin;    }        String nameMac = getName(nameId, NameRecord.PLATFORM_MACINTOSH, NameRecord.ENCODING_MACINTOSH_ROMAN, NameRecord.LANGUGAE_MACINTOSH_ENGLISH);    if (nameMac != null) {        return nameMac;    }    return null;}
public String pdfbox_f1721_0(int nameId, int platformId, int encodingId, int languageId)
{    Map<Integer, Map<Integer, Map<Integer, String>>> platforms = lookupTable.get(nameId);    if (platforms == null) {        return null;    }    Map<Integer, Map<Integer, String>> encodings = platforms.get(platformId);    if (encodings == null) {        return null;    }    Map<Integer, String> languages = encodings.get(encodingId);    if (languages == null) {        return null;    }    return languages.get(languageId);}
public List<NameRecord> pdfbox_f1722_0()
{    return nameRecords;}
public String pdfbox_f1723_0()
{    return fontFamily;}
public String pdfbox_f1724_0()
{    return fontSubFamily;}
public String pdfbox_f1725_0()
{    return psName;}
 void pdfbox_f1726_0(float versionValue)
{        isPostScript = Float.floatToIntBits(versionValue) == 0x469EA8A9;    super.setVersion(versionValue);}
public CFFTable pdfbox_f1727_0() throws IOException
{    if (!isPostScript) {        throw new UnsupportedOperationException("TTF fonts do not have a CFF table");    }    return (CFFTable) getTable(CFFTable.TAG);}
public GlyphTable pdfbox_f1728_0() throws IOException
{    if (isPostScript) {        throw new UnsupportedOperationException("OTF fonts do not have a glyf table");    }    return super.getGlyph();}
public GeneralPath pdfbox_f1729_0(String name) throws IOException
{    int gid = nameToGID(name);    return getCFF().getFont().getType2CharString(gid).getPath();}
public boolean pdfbox_f1730_0()
{    return tables.containsKey(CFFTable.TAG);}
public boolean pdfbox_f1731_0()
{    return tables.containsKey("BASE") || tables.containsKey("GDEF") || tables.containsKey("GPOS") || tables.containsKey("GSUB") || tables.containsKey("JSTF");}
private static void pdfbox_f1732_0(InputStream inputStream) throws IOException
{    Map<int[], String> unicodeRanges = new TreeMap<>((o1, o2) -> Integer.compare(o1[0], o2[0]));    try (LineNumberReader rd = new LineNumberReader(new InputStreamReader(inputStream))) {        int[] lastRange = { Integer.MIN_VALUE, Integer.MIN_VALUE };        String lastScript = null;        do {            String s = rd.readLine();            if (s == null) {                break;            }                        int comment = s.indexOf('#');            if (comment != -1) {                s = s.substring(0, comment);            }            if (s.length() < 2) {                continue;            }            StringTokenizer st = new StringTokenizer(s, ";");            int nFields = st.countTokens();            if (nFields < 2) {                continue;            }            String characters = st.nextToken().trim();            String script = st.nextToken().trim();            int[] range = new int[2];            int rangeDelim = characters.indexOf("..");            if (rangeDelim == -1) {                range[0] = range[1] = Integer.parseInt(characters, 16);            } else {                range[0] = Integer.parseInt(characters.substring(0, rangeDelim), 16);                range[1] = Integer.parseInt(characters.substring(rangeDelim + 2), 16);            }            if (range[0] == lastRange[1] + 1 && script.equals(lastScript)) {                                lastRange[1] = range[1];            } else {                unicodeRanges.put(range, script);                lastRange = range;                lastScript = script;            }        } while (true);    }    unicodeRangeStarts = new int[unicodeRanges.size()];    unicodeRangeScripts = new String[unicodeRanges.size()];    int i = 0;    for (Entry<int[], String> e : unicodeRanges.entrySet()) {        unicodeRangeStarts[i] = e.getKey()[0];        unicodeRangeScripts[i] = e.getValue();        i++;    }}
private static String pdfbox_f1733_0(int codePoint)
{    ensureValidCodePoint(codePoint);    int type = Character.getType(codePoint);    if (type == Character.UNASSIGNED) {        return UNKNOWN;    }    int scriptIndex = Arrays.binarySearch(unicodeRangeStarts, codePoint);    if (scriptIndex < 0) {        scriptIndex = -scriptIndex - 2;    }    return unicodeRangeScripts[scriptIndex];}
public static String[] pdfbox_f1734_0(int codePoint)
{    ensureValidCodePoint(codePoint);    String unicode = getUnicodeScript(codePoint);    return UNICODE_SCRIPT_TO_OPENTYPE_TAG_MAP.get(unicode);}
private static void pdfbox_f1735_0(int codePoint)
{    if (codePoint < Character.MIN_CODE_POINT || codePoint > Character.MAX_CODE_POINT) {        throw new IllegalArgumentException("Invalid codepoint: " + codePoint);    }}
public String pdfbox_f1736_0()
{    return achVendId;}
public void pdfbox_f1737_0(String achVendIdValue)
{    this.achVendId = achVendIdValue;}
public short pdfbox_f1738_0()
{    return averageCharWidth;}
public void pdfbox_f1739_0(short averageCharWidthValue)
{    this.averageCharWidth = averageCharWidthValue;}
public long pdfbox_f1740_0()
{    return codePageRange1;}
public void pdfbox_f1741_0(long codePageRange1Value)
{    this.codePageRange1 = codePageRange1Value;}
public long pdfbox_f1742_0()
{    return codePageRange2;}
public void pdfbox_f1743_0(long codePageRange2Value)
{    this.codePageRange2 = codePageRange2Value;}
public int pdfbox_f1744_0()
{    return familyClass;}
public void pdfbox_f1745_0(int familyClassValue)
{    this.familyClass = familyClassValue;}
public int pdfbox_f1746_0()
{    return firstCharIndex;}
public void pdfbox_f1747_0(int firstCharIndexValue)
{    this.firstCharIndex = firstCharIndexValue;}
public int pdfbox_f1748_0()
{    return fsSelection;}
public void pdfbox_f1749_0(int fsSelectionValue)
{    this.fsSelection = fsSelectionValue;}
public short pdfbox_f1750_0()
{    return fsType;}
public void pdfbox_f1751_0(short fsTypeValue)
{    this.fsType = fsTypeValue;}
public int pdfbox_f1752_0()
{    return lastCharIndex;}
public void pdfbox_f1753_0(int lastCharIndexValue)
{    this.lastCharIndex = lastCharIndexValue;}
public byte[] pdfbox_f1754_0()
{    return panose;}
public void pdfbox_f1755_0(byte[] panoseValue)
{    this.panose = panoseValue;}
public short pdfbox_f1756_0()
{    return strikeoutPosition;}
public void pdfbox_f1757_0(short strikeoutPositionValue)
{    this.strikeoutPosition = strikeoutPositionValue;}
public short pdfbox_f1758_0()
{    return strikeoutSize;}
public void pdfbox_f1759_0(short strikeoutSizeValue)
{    this.strikeoutSize = strikeoutSizeValue;}
public short pdfbox_f1760_0()
{    return subscriptXOffset;}
public void pdfbox_f1761_0(short subscriptXOffsetValue)
{    this.subscriptXOffset = subscriptXOffsetValue;}
public short pdfbox_f1762_0()
{    return subscriptXSize;}
public void pdfbox_f1763_0(short subscriptXSizeValue)
{    this.subscriptXSize = subscriptXSizeValue;}
public short pdfbox_f1764_0()
{    return subscriptYOffset;}
public void pdfbox_f1765_0(short subscriptYOffsetValue)
{    this.subscriptYOffset = subscriptYOffsetValue;}
public short pdfbox_f1766_0()
{    return subscriptYSize;}
public void pdfbox_f1767_0(short subscriptYSizeValue)
{    this.subscriptYSize = subscriptYSizeValue;}
public short pdfbox_f1768_0()
{    return superscriptXOffset;}
public void pdfbox_f1769_0(short superscriptXOffsetValue)
{    this.superscriptXOffset = superscriptXOffsetValue;}
public short pdfbox_f1770_0()
{    return superscriptXSize;}
public void pdfbox_f1771_0(short superscriptXSizeValue)
{    this.superscriptXSize = superscriptXSizeValue;}
public short pdfbox_f1772_0()
{    return superscriptYOffset;}
public void pdfbox_f1773_0(short superscriptYOffsetValue)
{    this.superscriptYOffset = superscriptYOffsetValue;}
public short pdfbox_f1774_0()
{    return superscriptYSize;}
public void pdfbox_f1775_0(short superscriptYSizeValue)
{    this.superscriptYSize = superscriptYSizeValue;}
public int pdfbox_f1776_0()
{    return typoLineGap;}
public void pdfbox_f1777_0(int typeLineGapValue)
{    this.typoLineGap = typeLineGapValue;}
public int pdfbox_f1778_0()
{    return typoAscender;}
public void pdfbox_f1779_0(int typoAscenderValue)
{    this.typoAscender = typoAscenderValue;}
public int pdfbox_f1780_0()
{    return typoDescender;}
public void pdfbox_f1781_0(int typoDescenderValue)
{    this.typoDescender = typoDescenderValue;}
public long pdfbox_f1782_0()
{    return unicodeRange1;}
public void pdfbox_f1783_0(long unicodeRange1Value)
{    this.unicodeRange1 = unicodeRange1Value;}
public long pdfbox_f1784_0()
{    return unicodeRange2;}
public void pdfbox_f1785_0(long unicodeRange2Value)
{    this.unicodeRange2 = unicodeRange2Value;}
public long pdfbox_f1786_0()
{    return unicodeRange3;}
public void pdfbox_f1787_0(long unicodeRange3Value)
{    this.unicodeRange3 = unicodeRange3Value;}
public long pdfbox_f1788_0()
{    return unicodeRange4;}
public void pdfbox_f1789_0(long unicodeRange4Value)
{    this.unicodeRange4 = unicodeRange4Value;}
public int pdfbox_f1790_0()
{    return version;}
public void pdfbox_f1791_0(int versionValue)
{    this.version = versionValue;}
public int pdfbox_f1792_0()
{    return weightClass;}
public void pdfbox_f1793_0(int weightClassValue)
{    this.weightClass = weightClassValue;}
public int pdfbox_f1794_0()
{    return widthClass;}
public void pdfbox_f1795_0(int widthClassValue)
{    this.widthClass = widthClassValue;}
public int pdfbox_f1796_0()
{    return winAscent;}
public void pdfbox_f1797_0(int winAscentValue)
{    this.winAscent = winAscentValue;}
public int pdfbox_f1798_0()
{    return winDescent;}
public void pdfbox_f1799_0(int winDescentValue)
{    this.winDescent = winDescentValue;}
public int pdfbox_f1800_0()
{    return sxHeight;}
public int pdfbox_f1801_0()
{    return sCapHeight;}
public int pdfbox_f1802_0()
{    return usDefaultChar;}
public int pdfbox_f1803_0()
{    return usBreakChar;}
public int pdfbox_f1804_0()
{    return usMaxContext;}
 void pdfbox_f1805_0(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    version = data.readUnsignedShort();    averageCharWidth = data.readSignedShort();    weightClass = data.readUnsignedShort();    widthClass = data.readUnsignedShort();    fsType = data.readSignedShort();    subscriptXSize = data.readSignedShort();    subscriptYSize = data.readSignedShort();    subscriptXOffset = data.readSignedShort();    subscriptYOffset = data.readSignedShort();    superscriptXSize = data.readSignedShort();    superscriptYSize = data.readSignedShort();    superscriptXOffset = data.readSignedShort();    superscriptYOffset = data.readSignedShort();    strikeoutSize = data.readSignedShort();    strikeoutPosition = data.readSignedShort();    familyClass = data.readSignedShort();    panose = data.read(10);    unicodeRange1 = data.readUnsignedInt();    unicodeRange2 = data.readUnsignedInt();    unicodeRange3 = data.readUnsignedInt();    unicodeRange4 = data.readUnsignedInt();    achVendId = data.readString(4);    fsSelection = data.readUnsignedShort();    firstCharIndex = data.readUnsignedShort();    lastCharIndex = data.readUnsignedShort();    typoAscender = data.readSignedShort();    typoDescender = data.readSignedShort();    typoLineGap = data.readSignedShort();    winAscent = data.readUnsignedShort();    winDescent = data.readUnsignedShort();    if (version >= 1) {        codePageRange1 = data.readUnsignedInt();        codePageRange2 = data.readUnsignedInt();    }    if (version >= 1.2) {        sxHeight = data.readSignedShort();        sCapHeight = data.readSignedShort();        usDefaultChar = data.readUnsignedShort();        usBreakChar = data.readUnsignedShort();        usMaxContext = data.readUnsignedShort();    }    initialized = true;}
public OpenTypeFont pdfbox_f1806_0(String file) throws IOException
{    return (OpenTypeFont) super.parse(file);}
public OpenTypeFont pdfbox_f1807_0(File file) throws IOException
{    return (OpenTypeFont) super.parse(file);}
public OpenTypeFont pdfbox_f1808_0(InputStream data) throws IOException
{    return (OpenTypeFont) super.parse(data);}
 OpenTypeFont pdfbox_f1809_0(TTFDataStream raf) throws IOException
{    return (OpenTypeFont) super.parse(raf);}
 OpenTypeFont pdfbox_f1810_0(TTFDataStream raf)
{    return new OpenTypeFont(raf);}
protected TTFTable pdfbox_f1811_0(TrueTypeFont font, String tag)
{        switch(tag) {        case "BASE":        case "GDEF":        case "GPOS":        case "GSUB":        case "JSTF":            return new OTLTable(font);        case "CFF ":            return new CFFTable(font);        default:            return super.readTable(font, tag);    }}
protected boolean pdfbox_f1812_0()
{    return true;}
 void pdfbox_f1813_1(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    formatType = data.read32Fixed();    italicAngle = data.read32Fixed();    underlinePosition = data.readSignedShort();    underlineThickness = data.readSignedShort();    isFixedPitch = data.readUnsignedInt();    minMemType42 = data.readUnsignedInt();    maxMemType42 = data.readUnsignedInt();    mimMemType1 = data.readUnsignedInt();    maxMemType1 = data.readUnsignedInt();    if (Float.compare(formatType, 1.0f) == 0) {        /*             * This TrueType font file contains exactly the 258 glyphs in the standard Macintosh TrueType.             */        glyphNames = new String[WGL4Names.NUMBER_OF_MAC_GLYPHS];        System.arraycopy(WGL4Names.MAC_GLYPH_NAMES, 0, glyphNames, 0, WGL4Names.NUMBER_OF_MAC_GLYPHS);    } else if (Float.compare(formatType, 2.0f) == 0) {        int numGlyphs = data.readUnsignedShort();        int[] glyphNameIndex = new int[numGlyphs];        glyphNames = new String[numGlyphs];        int maxIndex = Integer.MIN_VALUE;        for (int i = 0; i < numGlyphs; i++) {            int index = data.readUnsignedShort();            glyphNameIndex[i] = index;                        if (index <= 32767) {                maxIndex = Math.max(maxIndex, index);            }        }        String[] nameArray = null;        if (maxIndex >= WGL4Names.NUMBER_OF_MAC_GLYPHS) {            nameArray = new String[maxIndex - WGL4Names.NUMBER_OF_MAC_GLYPHS + 1];            for (int i = 0; i < maxIndex - WGL4Names.NUMBER_OF_MAC_GLYPHS + 1; i++) {                int numberOfChars = data.readUnsignedByte();                nameArray[i] = data.readString(numberOfChars);            }        }        for (int i = 0; i < numGlyphs; i++) {            int index = glyphNameIndex[i];            if (index >= 0 && index < WGL4Names.NUMBER_OF_MAC_GLYPHS) {                glyphNames[i] = WGL4Names.MAC_GLYPH_NAMES[index];            } else if (index >= WGL4Names.NUMBER_OF_MAC_GLYPHS && index <= 32767 && nameArray != null) {                glyphNames[i] = nameArray[index - WGL4Names.NUMBER_OF_MAC_GLYPHS];            } else {                                                glyphNames[i] = ".undefined";            }        }    } else if (Float.compare(formatType, 2.5f) == 0) {        int[] glyphNameIndex = new int[ttf.getNumberOfGlyphs()];        for (int i = 0; i < glyphNameIndex.length; i++) {            int offset = data.readSignedByte();            glyphNameIndex[i] = i + 1 + offset;        }        glyphNames = new String[glyphNameIndex.length];        for (int i = 0; i < glyphNames.length; i++) {            int index = glyphNameIndex[i];            if (index >= 0 && index < WGL4Names.NUMBER_OF_MAC_GLYPHS) {                String name = WGL4Names.MAC_GLYPH_NAMES[index];                if (name != null) {                    glyphNames[i] = name;                }            } else {                            }        }    } else if (Float.compare(formatType, 3.0f) == 0) {                    }    initialized = true;}
public float pdfbox_f1814_0()
{    return formatType;}
public void pdfbox_f1815_0(float formatTypeValue)
{    this.formatType = formatTypeValue;}
public long pdfbox_f1816_0()
{    return isFixedPitch;}
public void pdfbox_f1817_0(long isFixedPitchValue)
{    this.isFixedPitch = isFixedPitchValue;}
public float pdfbox_f1818_0()
{    return italicAngle;}
public void pdfbox_f1819_0(float italicAngleValue)
{    this.italicAngle = italicAngleValue;}
public long pdfbox_f1820_0()
{    return maxMemType1;}
public void pdfbox_f1821_0(long maxMemType1Value)
{    this.maxMemType1 = maxMemType1Value;}
public long pdfbox_f1822_0()
{    return maxMemType42;}
public void pdfbox_f1823_0(long maxMemType42Value)
{    this.maxMemType42 = maxMemType42Value;}
public long pdfbox_f1824_0()
{    return mimMemType1;}
public void pdfbox_f1825_0(long mimMemType1Value)
{    this.mimMemType1 = mimMemType1Value;}
public long pdfbox_f1826_0()
{    return minMemType42;}
public void pdfbox_f1827_0(long minMemType42Value)
{    this.minMemType42 = minMemType42Value;}
public short pdfbox_f1828_0()
{    return underlinePosition;}
public void pdfbox_f1829_0(short underlinePositionValue)
{    this.underlinePosition = underlinePositionValue;}
public short pdfbox_f1830_0()
{    return underlineThickness;}
public void pdfbox_f1831_0(short underlineThicknessValue)
{    this.underlineThickness = underlineThicknessValue;}
public String[] pdfbox_f1832_0()
{    return glyphNames;}
public void pdfbox_f1833_0(String[] glyphNamesValue)
{    this.glyphNames = glyphNamesValue;}
public String pdfbox_f1834_0(int gid)
{    if (gid < 0 || glyphNames == null || gid >= glyphNames.length) {        return null;    }    return glyphNames[gid];}
public short pdfbox_f1835_0() throws IOException
{    return raf.readShort();}
public long pdfbox_f1836_0() throws IOException
{    return raf.getFilePointer();}
public void pdfbox_f1837_0() throws IOException
{    if (raf != null) {        raf.close();        raf = null;    }}
public int pdfbox_f1838_0() throws IOException
{    return raf.read();}
public int pdfbox_f1839_0() throws IOException
{    return raf.readUnsignedShort();}
public long pdfbox_f1840_0() throws IOException
{    return raf.readLong();}
public void pdfbox_f1841_0(long pos) throws IOException
{    raf.seek(pos);}
public int pdfbox_f1842_0(byte[] b, int off, int len) throws IOException
{    return raf.read(b, off, len);}
public InputStream pdfbox_f1843_0() throws IOException
{    return new FileInputStream(ttfFile);}
public long pdfbox_f1844_0()
{    return ttfFile.length();}
public int pdfbox_f1845_0(int characterCode)
{    int gid = cmap.getGlyphId(characterCode);    String[] scriptTags = OpenTypeScript.getScriptTags(characterCode);    return gsub.getSubstitution(gid, scriptTags, enabledFeatures);}
public List<Integer> pdfbox_f1846_0(int gid)
{    return cmap.getCharCodes(gsub.getUnsubstitution(gid));}
public int pdfbox_f1847_0()
{    return coverageFormat;}
public int pdfbox_f1848_0(int gid)
{    return Arrays.binarySearch(glyphArray, gid);}
public int pdfbox_f1849_0(int index)
{    return glyphArray[index];}
public int pdfbox_f1850_0()
{    return glyphArray.length;}
public int[] pdfbox_f1851_0()
{    return glyphArray;}
public String pdfbox_f1852_0()
{    return String.format("CoverageTableFormat1[coverageFormat=%d,glyphArray=%s]", getCoverageFormat(), Arrays.toString(glyphArray));}
public RangeRecord[] pdfbox_f1853_0()
{    return rangeRecords;}
private static int[] pdfbox_f1854_0(RangeRecord[] rangeRecords)
{    List<Integer> glyphIds = new ArrayList<>();    for (RangeRecord rangeRecord : rangeRecords) {        for (int glyphId = rangeRecord.getStartGlyphID(); glyphId <= rangeRecord.getEndGlyphID(); glyphId++) {            glyphIds.add(glyphId);        }    }    int[] glyphArray = new int[glyphIds.size()];    for (int i = 0; i < glyphArray.length; i++) {        glyphArray[i] = glyphIds.get(i);    }    return glyphArray;}
public String pdfbox_f1855_0()
{    return String.format("CoverageTableFormat2[coverageFormat=%d]", getCoverageFormat());}
public int pdfbox_f1856_0()
{    return featureCount;}
public FeatureRecord[] pdfbox_f1857_0()
{    return featureRecords;}
public String pdfbox_f1858_0()
{    return String.format("%s[featureCount=%d]", FeatureListTable.class.getSimpleName(), featureCount);}
public String pdfbox_f1859_0()
{    return featureTag;}
public FeatureTable pdfbox_f1860_0()
{    return featureTable;}
public String pdfbox_f1861_0()
{    return String.format("FeatureRecord[featureTag=%s]", featureTag);}
public int pdfbox_f1862_0()
{    return featureParams;}
public int pdfbox_f1863_0()
{    return lookupIndexCount;}
public int[] pdfbox_f1864_0()
{    return lookupListIndices;}
public String pdfbox_f1865_0()
{    return String.format("FeatureTable[lookupListIndiciesCount=%d]", lookupListIndices.length);}
public String pdfbox_f1866_0()
{    return langSysTag;}
public LangSysTable pdfbox_f1867_0()
{    return langSysTable;}
public String pdfbox_f1868_0()
{    return String.format("LangSysRecord[langSysTag=%s]", langSysTag);}
public int pdfbox_f1869_0()
{    return lookupOrder;}
public int pdfbox_f1870_0()
{    return requiredFeatureIndex;}
public int pdfbox_f1871_0()
{    return featureIndexCount;}
public int[] pdfbox_f1872_0()
{    return featureIndices;}
public String pdfbox_f1873_0()
{    return String.format("LangSysTable[requiredFeatureIndex=%d]", requiredFeatureIndex);}
public int pdfbox_f1874_0()
{    return lookupCount;}
public LookupTable[] pdfbox_f1875_0()
{    return lookups;}
public String pdfbox_f1876_0()
{    return String.format("%s[lookupCount=%d]", LookupListTable.class.getSimpleName(), lookupCount);}
public int pdfbox_f1877_0()
{    return substFormat;}
public CoverageTable pdfbox_f1878_0()
{    return coverageTable;}
public int pdfbox_f1879_0()
{    return lookupType;}
public int pdfbox_f1880_0()
{    return lookupFlag;}
public int pdfbox_f1881_0()
{    return markFilteringSet;}
public LookupSubTable[] pdfbox_f1882_0()
{    return subTables;}
public String pdfbox_f1883_0()
{    return String.format("LookupTable[lookupType=%d,lookupFlag=%d,markFilteringSet=%d]", lookupType, lookupFlag, markFilteringSet);}
public int pdfbox_f1884_0()
{    return startGlyphID;}
public int pdfbox_f1885_0()
{    return endGlyphID;}
public int pdfbox_f1886_0()
{    return startCoverageIndex;}
public String pdfbox_f1887_0()
{    return String.format("RangeRecord[startGlyphID=%d,endGlyphID=%d,startCoverageIndex=%d]", startGlyphID, endGlyphID, startCoverageIndex);}
public String pdfbox_f1888_0()
{    return scriptTag;}
public ScriptTable pdfbox_f1889_0()
{    return scriptTable;}
public String pdfbox_f1890_0()
{    return String.format("ScriptRecord[scriptTag=%s]", scriptTag);}
public LangSysTable pdfbox_f1891_0()
{    return defaultLangSysTable;}
public Map<String, LangSysTable> pdfbox_f1892_0()
{    return langSysTables;}
public String pdfbox_f1893_0()
{    return String.format("ScriptTable[hasDefault=%s,langSysRecordsCount=%d]", defaultLangSysTable != null, langSysTables.size());}
public int pdfbox_f1894_0()
{    return ligatureCount;}
public LigatureTable[] pdfbox_f1895_0()
{    return ligatureTables;}
public String pdfbox_f1896_0()
{    return String.format("%s[ligatureCount=%d]", LigatureSetTable.class.getSimpleName(), ligatureCount);}
public int pdfbox_f1897_0()
{    return ligatureGlyph;}
public int pdfbox_f1898_0()
{    return componentCount;}
public int[] pdfbox_f1899_0()
{    return componentGlyphIDs;}
public String pdfbox_f1900_0()
{    return String.format("%s[ligatureGlyph=%d, componentCount=%d]", LigatureTable.class.getSimpleName(), ligatureGlyph, componentCount);}
public int pdfbox_f1901_0(int gid, int coverageIndex)
{    throw new UnsupportedOperationException();}
public LigatureSetTable[] pdfbox_f1902_0()
{    return ligatureSetTables;}
public String pdfbox_f1903_0()
{    return String.format("%s[substFormat=%d]", LookupTypeLigatureSubstitutionSubstFormat1.class.getSimpleName(), getSubstFormat());}
public int pdfbox_f1904_0(int gid, int coverageIndex)
{    return coverageIndex < 0 ? gid : gid + deltaGlyphID;}
public short pdfbox_f1905_0()
{    return deltaGlyphID;}
public String pdfbox_f1906_0()
{    return String.format("LookupTypeSingleSubstFormat1[substFormat=%d,deltaGlyphID=%d]", getSubstFormat(), deltaGlyphID);}
public int pdfbox_f1907_0(int gid, int coverageIndex)
{    return coverageIndex < 0 ? gid : substituteGlyphIDs[coverageIndex];}
public int[] pdfbox_f1908_0()
{    return substituteGlyphIDs;}
public String pdfbox_f1909_0()
{    return String.format("LookupTypeSingleSubstFormat2[substFormat=%d,substituteGlyphIDs=%s]", getSubstFormat(), Arrays.toString(substituteGlyphIDs));}
public void pdfbox_f1910_0(TrueTypeFontProcessor trueTypeFontProcessor) throws IOException
{    for (int i = 0; i < numFonts; i++) {        TrueTypeFont font = getFontAtIndex(i);        trueTypeFontProcessor.process(font);    }}
private TrueTypeFont pdfbox_f1911_0(int idx) throws IOException
{    stream.seek(fontOffsets[idx]);    TTFParser parser;    if (stream.readTag().equals("OTTO")) {        parser = new OTFParser(false, true);    } else {        parser = new TTFParser(false, true);    }    stream.seek(fontOffsets[idx]);    return parser.parse(new TTCDataStream(stream));}
public TrueTypeFont pdfbox_f1912_0(String name) throws IOException
{    for (int i = 0; i < numFonts; i++) {        TrueTypeFont font = getFontAtIndex(i);        if (font.getName().equals(name)) {            return font;        }    }    return null;}
public void pdfbox_f1913_0() throws IOException
{    stream.close();}
public void pdfbox_f1914_0() throws IOException
{    data.close();}
public float pdfbox_f1915_0()
{    return version;}
 void pdfbox_f1916_0(float versionValue)
{    version = versionValue;}
 void pdfbox_f1917_0(TTFTable table)
{    tables.put(table.getTag(), table);}
public Collection<TTFTable> pdfbox_f1918_0()
{    return tables.values();}
public Map<String, TTFTable> pdfbox_f1919_0()
{    return tables;}
public byte[] pdfbox_f1920_0(TTFTable table) throws IOException
{    synchronized (lockReadtable) {                long currentPosition = data.getCurrentPosition();        data.seek(table.getOffset());                byte[] bytes = data.read((int) table.getLength());                data.seek(currentPosition);        return bytes;    }}
protected TTFTable pdfbox_f1921_0(String tag) throws IOException
{            TTFTable ttfTable = tables.get(tag);    if (ttfTable != null) {        if (!ttfTable.initialized) {            synchronized (lockReadtable) {                if (!ttfTable.initialized) {                    readTable(ttfTable);                }            }        }    }    return ttfTable;}
public NamingTable pdfbox_f1922_0() throws IOException
{    return (NamingTable) getTable(NamingTable.TAG);}
public PostScriptTable pdfbox_f1923_0() throws IOException
{    return (PostScriptTable) getTable(PostScriptTable.TAG);}
public OS2WindowsMetricsTable pdfbox_f1924_0() throws IOException
{    return (OS2WindowsMetricsTable) getTable(OS2WindowsMetricsTable.TAG);}
public MaximumProfileTable pdfbox_f1925_0() throws IOException
{    return (MaximumProfileTable) getTable(MaximumProfileTable.TAG);}
public HeaderTable pdfbox_f1926_0() throws IOException
{    return (HeaderTable) getTable(HeaderTable.TAG);}
public HorizontalHeaderTable pdfbox_f1927_0() throws IOException
{    return (HorizontalHeaderTable) getTable(HorizontalHeaderTable.TAG);}
public HorizontalMetricsTable pdfbox_f1928_0() throws IOException
{    return (HorizontalMetricsTable) getTable(HorizontalMetricsTable.TAG);}
public IndexToLocationTable pdfbox_f1929_0() throws IOException
{    return (IndexToLocationTable) getTable(IndexToLocationTable.TAG);}
public GlyphTable pdfbox_f1930_0() throws IOException
{    return (GlyphTable) getTable(GlyphTable.TAG);}
public CmapTable pdfbox_f1931_0() throws IOException
{    return (CmapTable) getTable(CmapTable.TAG);}
public VerticalHeaderTable pdfbox_f1932_0() throws IOException
{    return (VerticalHeaderTable) getTable(VerticalHeaderTable.TAG);}
public VerticalMetricsTable pdfbox_f1933_0() throws IOException
{    return (VerticalMetricsTable) getTable(VerticalMetricsTable.TAG);}
public VerticalOriginTable pdfbox_f1934_0() throws IOException
{    return (VerticalOriginTable) getTable(VerticalOriginTable.TAG);}
public KerningTable pdfbox_f1935_0() throws IOException
{    return (KerningTable) getTable(KerningTable.TAG);}
public GlyphSubstitutionTable pdfbox_f1936_0() throws IOException
{    return (GlyphSubstitutionTable) getTable(GlyphSubstitutionTable.TAG);}
public InputStream pdfbox_f1937_0() throws IOException
{    return data.getOriginalData();}
public long pdfbox_f1938_0()
{    return data.getOriginalDataSize();}
 void pdfbox_f1939_0(TTFTable table) throws IOException
{        synchronized (data) {                long currentPosition = data.getCurrentPosition();        data.seek(table.getOffset());        table.read(this, data);                data.seek(currentPosition);    }}
public int pdfbox_f1940_0() throws IOException
{    if (numberOfGlyphs == -1) {        MaximumProfileTable maximumProfile = getMaximumProfile();        if (maximumProfile != null) {            numberOfGlyphs = maximumProfile.getNumGlyphs();        } else {                        numberOfGlyphs = 0;        }    }    return numberOfGlyphs;}
public int pdfbox_f1941_0() throws IOException
{    if (unitsPerEm == -1) {        HeaderTable header = getHeader();        if (header != null) {            unitsPerEm = header.getUnitsPerEm();        } else {                        unitsPerEm = 0;        }    }    return unitsPerEm;}
public int pdfbox_f1942_0(int gid) throws IOException
{    HorizontalMetricsTable hmtx = getHorizontalMetrics();    if (hmtx != null) {        return hmtx.getAdvanceWidth(gid);    } else {                return 250;    }}
public int pdfbox_f1943_0(int gid) throws IOException
{    VerticalMetricsTable vmtx = getVerticalMetrics();    if (vmtx != null) {        return vmtx.getAdvanceHeight(gid);    } else {                return 250;    }}
public String pdfbox_f1944_0() throws IOException
{    if (getNaming() != null) {        return getNaming().getPostScriptName();    } else {        return null;    }}
private void pdfbox_f1945_0() throws IOException
{    Map<String, Integer> psnames = postScriptNames;    if (psnames == null) {                PostScriptTable post = getPostScript();        synchronized (lockPSNames) {            psnames = postScriptNames;            if (psnames == null) {                String[] names = post != null ? post.getGlyphNames() : null;                if (names != null) {                    psnames = new HashMap<>(names.length);                    for (int i = 0; i < names.length; i++) {                        psnames.put(names[i], i);                    }                } else {                    psnames = new HashMap<>();                }                postScriptNames = psnames;            }        }    }}
public CmapSubtable pdfbox_f1946_0() throws IOException
{    return getUnicodeCmap(true);}
public CmapSubtable pdfbox_f1947_0(boolean isStrict) throws IOException
{    return getUnicodeCmapImpl(isStrict);}
public CmapLookup pdfbox_f1948_0() throws IOException
{    return getUnicodeCmapLookup(true);}
public CmapLookup pdfbox_f1949_0(boolean isStrict) throws IOException
{    CmapSubtable cmap = getUnicodeCmapImpl(isStrict);    if (!enabledGsubFeatures.isEmpty()) {        GlyphSubstitutionTable table = getGsub();        if (table != null) {            return new SubstitutingCmapLookup(cmap, table, Collections.unmodifiableList(enabledGsubFeatures));        }    }    return cmap;}
private CmapSubtable pdfbox_f1950_0(boolean isStrict) throws IOException
{    CmapTable cmapTable = getCmap();    if (cmapTable == null) {        if (isStrict) {            throw new IOException("The TrueType font " + getName() + " does not contain a 'cmap' table");        } else {            return null;        }    }    CmapSubtable cmap = cmapTable.getSubtable(CmapTable.PLATFORM_UNICODE, CmapTable.ENCODING_UNICODE_2_0_FULL);    if (cmap == null) {        cmap = cmapTable.getSubtable(CmapTable.PLATFORM_WINDOWS, CmapTable.ENCODING_WIN_UNICODE_FULL);    }    if (cmap == null) {        cmap = cmapTable.getSubtable(CmapTable.PLATFORM_UNICODE, CmapTable.ENCODING_UNICODE_2_0_BMP);    }    if (cmap == null) {        cmap = cmapTable.getSubtable(CmapTable.PLATFORM_WINDOWS, CmapTable.ENCODING_WIN_UNICODE_BMP);    }    if (cmap == null) {                        cmap = cmapTable.getSubtable(CmapTable.PLATFORM_WINDOWS, CmapTable.ENCODING_WIN_SYMBOL);    }    if (cmap == null) {        if (isStrict) {            throw new IOException("The TrueType font does not contain a Unicode cmap");        } else if (cmapTable.getCmaps().length > 0) {                        cmap = cmapTable.getCmaps()[0];        }    }    return cmap;}
public int pdfbox_f1951_0(String name) throws IOException
{        readPostScriptNames();    if (postScriptNames != null) {        Integer gid = postScriptNames.get(name);        if (gid != null && gid > 0 && gid < getMaximumProfile().getNumGlyphs()) {            return gid;        }    }        int uni = parseUniName(name);    if (uni > -1) {        CmapLookup cmap = getUnicodeCmapLookup(false);        return cmap.getGlyphId(uni);    }    return 0;}
public GsubData pdfbox_f1952_0() throws IOException
{    GlyphSubstitutionTable table = getGsub();    if (table == null) {        return GsubData.NO_DATA_FOUND;    }    return table.getGsubData();}
private int pdfbox_f1953_0(String name) throws IOException
{    if (name.startsWith("uni") && name.length() == 7) {        int nameLength = name.length();        StringBuilder uniStr = new StringBuilder();        try {            for (int chPos = 3; chPos + 4 <= nameLength; chPos += 4) {                int codePoint = Integer.parseInt(name.substring(chPos, chPos + 4), 16);                if (                codePoint <= 0xD7FF || codePoint >= 0xE000) {                    uniStr.append((char) codePoint);                }            }            String unicode = uniStr.toString();            if (unicode.length() == 0) {                return -1;            }            return unicode.codePointAt(0);        } catch (NumberFormatException e) {            return -1;        }    }    return -1;}
public GeneralPath pdfbox_f1954_0(String name) throws IOException
{    int gid = nameToGID(name);        GlyphData glyph = getGlyph().getGlyph(gid);    if (glyph == null) {        return new GeneralPath();    } else {                return glyph.getPath();    }}
public float pdfbox_f1955_0(String name) throws IOException
{    Integer gid = nameToGID(name);    return getAdvanceWidth(gid);}
public boolean pdfbox_f1956_0(String name) throws IOException
{    return nameToGID(name) != 0;}
public BoundingBox pdfbox_f1957_0() throws IOException
{    short xMin = getHeader().getXMin();    short xMax = getHeader().getXMax();    short yMin = getHeader().getYMin();    short yMax = getHeader().getYMax();    float scale = 1000f / getUnitsPerEm();    return new BoundingBox(xMin * scale, yMin * scale, xMax * scale, yMax * scale);}
public List<Number> pdfbox_f1958_0() throws IOException
{    float scale = 1000f / getUnitsPerEm();    return Arrays.<Number>asList(0.001f * scale, 0, 0, 0.001f * scale, 0, 0);}
public void pdfbox_f1959_0(String featureTag)
{    enabledGsubFeatures.add(featureTag);}
public void pdfbox_f1960_0(String featureTag)
{    enabledGsubFeatures.remove(featureTag);}
public void pdfbox_f1961_0()
{    enableGsubFeature("vrt2");    enableGsubFeature("vert");}
public String pdfbox_f1962_1()
{    try {        if (getNaming() != null) {            return getNaming().getPostScriptName();        } else {            return "(null)";        }    } catch (IOException e) {                return "(null - " + e.getMessage() + ")";    }}
public int pdfbox_f1963_0() throws IOException
{    return stream.read();}
public long pdfbox_f1964_0() throws IOException
{    return stream.readLong();}
public int pdfbox_f1965_0() throws IOException
{    return stream.readUnsignedShort();}
public short pdfbox_f1966_0() throws IOException
{    return stream.readSignedShort();}
public void pdfbox_f1968_0(long pos) throws IOException
{    stream.seek(pos);}
public int pdfbox_f1969_0(byte[] b, int off, int len) throws IOException
{    return stream.read(b, off, len);}
public long pdfbox_f1970_0() throws IOException
{    return stream.getCurrentPosition();}
public InputStream pdfbox_f1971_0() throws IOException
{    return stream.getOriginalData();}
public long pdfbox_f1972_0()
{    return stream.getOriginalDataSize();}
public float pdfbox_f1973_0() throws IOException
{    float retval = 0;    retval = readSignedShort();    retval += (readUnsignedShort() / 65536.0);    return retval;}
public String pdfbox_f1974_0(int length) throws IOException
{    return readString(length, Charsets.ISO_8859_1);}
public String pdfbox_f1975_0(int length, String charset) throws IOException
{    byte[] buffer = read(length);    return new String(buffer, charset);}
public String pdfbox_f1976_0(int length, Charset charset) throws IOException
{    byte[] buffer = read(length);    return new String(buffer, charset);}
public int pdfbox_f1977_0() throws IOException
{    int signedByte = read();    return signedByte <= 127 ? signedByte : signedByte - 256;}
public int pdfbox_f1978_0() throws IOException
{    int unsignedByte = read();    if (unsignedByte == -1) {        throw new EOFException("premature EOF");    }    return unsignedByte;}
public long pdfbox_f1979_0() throws IOException
{    long byte1 = read();    long byte2 = read();    long byte3 = read();    long byte4 = read();    if (byte4 < 0) {        throw new EOFException();    }    return (byte1 << 24) + (byte2 << 16) + (byte3 << 8) + (byte4 << 0);}
public int[] pdfbox_f1980_0(int length) throws IOException
{    int[] array = new int[length];    for (int i = 0; i < length; i++) {        array[i] = read();    }    return array;}
public int[] pdfbox_f1981_0(int length) throws IOException
{    int[] array = new int[length];    for (int i = 0; i < length; i++) {        array[i] = readUnsignedShort();    }    return array;}
public Calendar pdfbox_f1982_0() throws IOException
{    long secondsSince1904 = readLong();    Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC"));    cal.set(1904, 0, 1, 0, 0, 0);    cal.set(Calendar.MILLISECOND, 0);    long millisFor1904 = cal.getTimeInMillis();    millisFor1904 += (secondsSince1904 * 1000);    cal.setTimeInMillis(millisFor1904);    return cal;}
public String pdfbox_f1983_0() throws IOException
{    return new String(read(4), Charsets.US_ASCII);}
public byte[] pdfbox_f1984_0(int numberOfBytes) throws IOException
{    byte[] data = new byte[numberOfBytes];    int amountRead = 0;    int totalAmountRead = 0;        while (totalAmountRead < numberOfBytes && (amountRead = read(data, totalAmountRead, numberOfBytes - totalAmountRead)) != -1) {        totalAmountRead += amountRead;    }    if (totalAmountRead == numberOfBytes) {        return data;    } else {        throw new IOException("Unexpected end of TTF stream reached");    }}
public TrueTypeFont pdfbox_f1985_0(String ttfFile) throws IOException
{    return parse(new File(ttfFile));}
public TrueTypeFont pdfbox_f1986_0(File ttfFile) throws IOException
{    RAFDataStream raf = new RAFDataStream(ttfFile, "r");    try {        return parse(raf);    } catch (IOException ex) {                raf.close();        throw ex;    }}
public TrueTypeFont pdfbox_f1987_0(InputStream inputStream) throws IOException
{    return parse(new MemoryTTFDataStream(inputStream));}
public TrueTypeFont pdfbox_f1988_0(InputStream inputStream) throws IOException
{    this.isEmbedded = true;    return parse(new MemoryTTFDataStream(inputStream));}
 TrueTypeFont pdfbox_f1989_0(TTFDataStream raf) throws IOException
{    TrueTypeFont font = newFont(raf);    font.setVersion(raf.read32Fixed());    int numberOfTables = raf.readUnsignedShort();    int searchRange = raf.readUnsignedShort();    int entrySelector = raf.readUnsignedShort();    int rangeShift = raf.readUnsignedShort();    for (int i = 0; i < numberOfTables; i++) {        TTFTable table = readTableDirectory(font, raf);                if (table != null) {            font.addTable(table);        }    }        if (!parseOnDemandOnly) {        parseTables(font);    }    return font;}
 TrueTypeFont pdfbox_f1990_0(TTFDataStream raf)
{    return new TrueTypeFont(raf);}
private void pdfbox_f1991_0(TrueTypeFont font) throws IOException
{    for (TTFTable table : font.getTables()) {        if (!table.getInitialized()) {            font.readTable(table);        }    }    boolean isPostScript = allowCFF() && font.tables.containsKey(CFFTable.TAG);    HeaderTable head = font.getHeader();    if (head == null) {        throw new IOException("head is mandatory");    }    HorizontalHeaderTable hh = font.getHorizontalHeader();    if (hh == null) {        throw new IOException("hhead is mandatory");    }    MaximumProfileTable maxp = font.getMaximumProfile();    if (maxp == null) {        throw new IOException("maxp is mandatory");    }    PostScriptTable post = font.getPostScript();    if (post == null && !isEmbedded) {                throw new IOException("post is mandatory");    }    if (!isPostScript) {        IndexToLocationTable loc = font.getIndexToLocation();        if (loc == null) {            throw new IOException("loca is mandatory");        }        if (font.getGlyph() == null) {            throw new IOException("glyf is mandatory");        }    }    if (font.getNaming() == null && !isEmbedded) {        throw new IOException("name is mandatory");    }    if (font.getHorizontalMetrics() == null) {        throw new IOException("hmtx is mandatory");    }    if (!isEmbedded && font.getCmap() == null) {        throw new IOException("cmap is mandatory");    }}
protected boolean pdfbox_f1992_0()
{    return false;}
private TTFTable pdfbox_f1993_0(TrueTypeFont font, TTFDataStream raf) throws IOException
{    TTFTable table;    String tag = raf.readString(4);    switch(tag) {        case CmapTable.TAG:            table = new CmapTable(font);            break;        case GlyphTable.TAG:            table = new GlyphTable(font);            break;        case HeaderTable.TAG:            table = new HeaderTable(font);            break;        case HorizontalHeaderTable.TAG:            table = new HorizontalHeaderTable(font);            break;        case HorizontalMetricsTable.TAG:            table = new HorizontalMetricsTable(font);            break;        case IndexToLocationTable.TAG:            table = new IndexToLocationTable(font);            break;        case MaximumProfileTable.TAG:            table = new MaximumProfileTable(font);            break;        case NamingTable.TAG:            table = new NamingTable(font);            break;        case OS2WindowsMetricsTable.TAG:            table = new OS2WindowsMetricsTable(font);            break;        case PostScriptTable.TAG:            table = new PostScriptTable(font);            break;        case DigitalSignatureTable.TAG:            table = new DigitalSignatureTable(font);            break;        case KerningTable.TAG:            table = new KerningTable(font);            break;        case VerticalHeaderTable.TAG:            table = new VerticalHeaderTable(font);            break;        case VerticalMetricsTable.TAG:            table = new VerticalMetricsTable(font);            break;        case VerticalOriginTable.TAG:            table = new VerticalOriginTable(font);            break;        case GlyphSubstitutionTable.TAG:            table = new GlyphSubstitutionTable(font);            break;        default:            table = readTable(font, tag);            break;    }    table.setTag(tag);    table.setCheckSum(raf.readUnsignedInt());    table.setOffset(raf.readUnsignedInt());    table.setLength(raf.readUnsignedInt());        if (table.getLength() == 0 && !tag.equals(GlyphTable.TAG)) {        return null;    }    return table;}
protected TTFTable pdfbox_f1994_0(TrueTypeFont font, String tag)
{        return new TTFTable(font);}
public void pdfbox_f1995_0(String prefix)
{    this.prefix = prefix;}
public void pdfbox_f1996_0(int unicode)
{    int gid = unicodeCmap.getGlyphId(unicode);    if (gid != 0) {        uniToGID.put(unicode, gid);        glyphIds.add(gid);    }}
public void pdfbox_f1997_0(Set<Integer> unicodeSet)
{    unicodeSet.forEach(this::add);}
public Map<Integer, Integer> pdfbox_f1998_0() throws IOException
{    addCompoundReferences();    Map<Integer, Integer> newToOld = new HashMap<>();    int newGID = 0;    for (int oldGID : glyphIds) {        newToOld.put(newGID, oldGID);        newGID++;    }    return newToOld;}
private long pdfbox_f1999_0(DataOutputStream out, int nTables) throws IOException
{    out.writeInt(0x00010000);    out.writeShort(nTables);    int mask = Integer.highestOneBit(nTables);    int searchRange = mask * 16;    out.writeShort(searchRange);    int entrySelector = log2(mask);    out.writeShort(entrySelector);        int last = 16 * nTables - searchRange;    out.writeShort(last);    return 0x00010000L + toUInt32(nTables, searchRange) + toUInt32(entrySelector, last);}
private long pdfbox_f2000_0(DataOutputStream out, String tag, long offset, byte[] bytes) throws IOException
{    long checksum = 0;    for (int nup = 0, n = bytes.length; nup < n; nup++) {        checksum += (bytes[nup] & 0xffL) << 24 - nup % 4 * 8;    }    checksum &= 0xffffffffL;    byte[] tagbytes = tag.getBytes("US-ASCII");    out.write(tagbytes, 0, 4);    out.writeInt((int) checksum);    out.writeInt((int) offset);    out.writeInt(bytes.length);        return toUInt32(tagbytes) + checksum + checksum + offset + bytes.length;}
private void pdfbox_f2001_0(OutputStream os, byte[] bytes) throws IOException
{    int n = bytes.length;    os.write(bytes);    if (n % 4 != 0) {        os.write(PAD_BUF, 0, 4 - n % 4);    }}
private byte[] pdfbox_f2002_0() throws IOException
{    ByteArrayOutputStream bos = new ByteArrayOutputStream();    DataOutputStream out = new DataOutputStream(bos);    HeaderTable h = ttf.getHeader();    writeFixed(out, h.getVersion());    writeFixed(out, h.getFontRevision());        writeUint32(out, 0);    writeUint32(out, h.getMagicNumber());    writeUint16(out, h.getFlags());    writeUint16(out, h.getUnitsPerEm());    writeLongDateTime(out, h.getCreated());    writeLongDateTime(out, h.getModified());    writeSInt16(out, h.getXMin());    writeSInt16(out, h.getYMin());    writeSInt16(out, h.getXMax());    writeSInt16(out, h.getYMax());    writeUint16(out, h.getMacStyle());    writeUint16(out, h.getLowestRecPPEM());    writeSInt16(out, h.getFontDirectionHint());            writeSInt16(out, (short) 1);    writeSInt16(out, h.getGlyphDataFormat());    out.flush();    return bos.toByteArray();}
private byte[] pdfbox_f2003_0() throws IOException
{    ByteArrayOutputStream bos = new ByteArrayOutputStream();    DataOutputStream out = new DataOutputStream(bos);    HorizontalHeaderTable h = ttf.getHorizontalHeader();    writeFixed(out, h.getVersion());    writeSInt16(out, h.getAscender());    writeSInt16(out, h.getDescender());    writeSInt16(out, h.getLineGap());    writeUint16(out, h.getAdvanceWidthMax());    writeSInt16(out, h.getMinLeftSideBearing());    writeSInt16(out, h.getMinRightSideBearing());    writeSInt16(out, h.getXMaxExtent());    writeSInt16(out, h.getCaretSlopeRise());    writeSInt16(out, h.getCaretSlopeRun());        writeSInt16(out, h.getReserved1());    writeSInt16(out, h.getReserved2());    writeSInt16(out, h.getReserved3());    writeSInt16(out, h.getReserved4());    writeSInt16(out, h.getReserved5());    writeSInt16(out, h.getMetricDataFormat());            int hmetrics = glyphIds.subSet(0, h.getNumberOfHMetrics()).size();    if (glyphIds.last() >= h.getNumberOfHMetrics() && !glyphIds.contains(h.getNumberOfHMetrics() - 1)) {        ++hmetrics;    }    writeUint16(out, hmetrics);    out.flush();    return bos.toByteArray();}
private boolean pdfbox_f2004_0(NameRecord nr)
{    return nr.getPlatformId() == NameRecord.PLATFORM_WINDOWS && nr.getPlatformEncodingId() == NameRecord.ENCODING_WINDOWS_UNICODE_BMP && nr.getLanguageId() == NameRecord.LANGUGAE_WINDOWS_EN_US && nr.getNameId() >= 0 && nr.getNameId() < 7;}
private byte[] pdfbox_f2005_0() throws IOException
{    ByteArrayOutputStream bos = new ByteArrayOutputStream();    DataOutputStream out = new DataOutputStream(bos);    NamingTable name = ttf.getNaming();    if (name == null || keepTables != null && !keepTables.contains("name")) {        return null;    }    List<NameRecord> nameRecords = name.getNameRecords();    int numRecords = (int) nameRecords.stream().filter(this::shouldCopyNameRecord).count();    writeUint16(out, 0);    writeUint16(out, numRecords);    writeUint16(out, 2 * 3 + 2 * 6 * numRecords);    if (numRecords == 0) {        return null;    }    byte[][] names = new byte[numRecords][];    int j = 0;    for (NameRecord record : nameRecords) {        if (shouldCopyNameRecord(record)) {            int platform = record.getPlatformId();            int encoding = record.getPlatformEncodingId();            String charset = "ISO-8859-1";            if (platform == CmapTable.PLATFORM_WINDOWS && encoding == CmapTable.ENCODING_WIN_UNICODE_BMP) {                charset = "UTF-16BE";            } else if (            platform == 2) {                if (                encoding == 0) {                    charset = "US-ASCII";                } else if (                encoding == 1) {                                        charset = "UTF16-BE";                } else if (                encoding == 2) {                    charset = "ISO-8859-1";                }            }            String value = record.getString();            if (record.getNameId() == 6 && prefix != null) {                value = prefix + value;            }            names[j] = value.getBytes(charset);            j++;        }    }    int offset = 0;    j = 0;    for (NameRecord nr : nameRecords) {        if (shouldCopyNameRecord(nr)) {            writeUint16(out, nr.getPlatformId());            writeUint16(out, nr.getPlatformEncodingId());            writeUint16(out, nr.getLanguageId());            writeUint16(out, nr.getNameId());            writeUint16(out, names[j].length);            writeUint16(out, offset);            offset += names[j].length;            j++;        }    }    for (int i = 0; i < numRecords; i++) {        out.write(names[i]);    }    out.flush();    return bos.toByteArray();}
private byte[] pdfbox_f2006_0() throws IOException
{    ByteArrayOutputStream bos = new ByteArrayOutputStream();    DataOutputStream out = new DataOutputStream(bos);    MaximumProfileTable p = ttf.getMaximumProfile();    writeFixed(out, 1.0);    writeUint16(out, glyphIds.size());    writeUint16(out, p.getMaxPoints());    writeUint16(out, p.getMaxContours());    writeUint16(out, p.getMaxCompositePoints());    writeUint16(out, p.getMaxCompositeContours());    writeUint16(out, p.getMaxZones());    writeUint16(out, p.getMaxTwilightPoints());    writeUint16(out, p.getMaxStorage());    writeUint16(out, p.getMaxFunctionDefs());    writeUint16(out, p.getMaxInstructionDefs());    writeUint16(out, p.getMaxStackElements());    writeUint16(out, p.getMaxSizeOfInstructions());    writeUint16(out, p.getMaxComponentElements());    writeUint16(out, p.getMaxComponentDepth());    out.flush();    return bos.toByteArray();}
private byte[] pdfbox_f2007_0() throws IOException
{    OS2WindowsMetricsTable os2 = ttf.getOS2Windows();    if (os2 == null || uniToGID.isEmpty() || keepTables != null && !keepTables.contains("OS/2")) {        return null;    }    ByteArrayOutputStream bos = new ByteArrayOutputStream();    DataOutputStream out = new DataOutputStream(bos);    writeUint16(out, os2.getVersion());    writeSInt16(out, os2.getAverageCharWidth());    writeUint16(out, os2.getWeightClass());    writeUint16(out, os2.getWidthClass());    writeSInt16(out, os2.getFsType());    writeSInt16(out, os2.getSubscriptXSize());    writeSInt16(out, os2.getSubscriptYSize());    writeSInt16(out, os2.getSubscriptXOffset());    writeSInt16(out, os2.getSubscriptYOffset());    writeSInt16(out, os2.getSuperscriptXSize());    writeSInt16(out, os2.getSuperscriptYSize());    writeSInt16(out, os2.getSuperscriptXOffset());    writeSInt16(out, os2.getSuperscriptYOffset());    writeSInt16(out, os2.getStrikeoutSize());    writeSInt16(out, os2.getStrikeoutPosition());    writeSInt16(out, (short) os2.getFamilyClass());    out.write(os2.getPanose());    writeUint32(out, 0);    writeUint32(out, 0);    writeUint32(out, 0);    writeUint32(out, 0);    out.write(os2.getAchVendId().getBytes("US-ASCII"));    writeUint16(out, os2.getFsSelection());    writeUint16(out, uniToGID.firstKey());    writeUint16(out, uniToGID.lastKey());    writeUint16(out, os2.getTypoAscender());    writeUint16(out, os2.getTypoDescender());    writeUint16(out, os2.getTypoLineGap());    writeUint16(out, os2.getWinAscent());    writeUint16(out, os2.getWinDescent());    out.flush();    return bos.toByteArray();}
private byte[] pdfbox_f2008_0(long[] newOffsets) throws IOException
{    ByteArrayOutputStream bos = new ByteArrayOutputStream();    DataOutputStream out = new DataOutputStream(bos);    for (long offset : newOffsets) {        writeUint32(out, offset);    }    out.flush();    return bos.toByteArray();}
private void pdfbox_f2009_1() throws IOException
{    if (hasAddedCompoundReferences) {        return;    }    hasAddedCompoundReferences = true;    boolean hasNested;    do {        GlyphTable g = ttf.getGlyph();        long[] offsets = ttf.getIndexToLocation().getOffsets();        InputStream is = ttf.getOriginalData();        Set<Integer> glyphIdsToAdd = null;        try {            long isResult = is.skip(g.getOffset());            if (Long.compare(isResult, g.getOffset()) != 0) {                            }            long lastOff = 0L;            for (Integer glyphId : glyphIds) {                long offset = offsets[glyphId];                long len = offsets[glyphId + 1] - offset;                isResult = is.skip(offset - lastOff);                if (Long.compare(isResult, offset - lastOff) != 0) {                                    }                byte[] buf = new byte[(int) len];                isResult = is.read(buf);                if (Long.compare(isResult, len) != 0) {                                    }                                if (buf.length >= 2 && buf[0] == -1 && buf[1] == -1) {                    int off = 2 * 5;                    int flags;                    do {                        flags = (buf[off] & 0xff) << 8 | buf[off + 1] & 0xff;                        off += 2;                        int ogid = (buf[off] & 0xff) << 8 | buf[off + 1] & 0xff;                        if (!glyphIds.contains(ogid)) {                            if (glyphIdsToAdd == null) {                                glyphIdsToAdd = new TreeSet<>();                            }                            glyphIdsToAdd.add(ogid);                        }                        off += 2;                                                if ((flags & 1 << 0) != 0) {                            off += 2 * 2;                        } else {                            off += 2;                        }                                                if ((flags & 1 << 7) != 0) {                            off += 2 * 4;                        } else                         if ((flags & 1 << 6) != 0) {                            off += 2 * 2;                        } else                         if ((flags & 1 << 3) != 0) {                            off += 2;                        }                    } while (                    (flags & 1 << 5) != 0);                }                lastOff = offsets[glyphId + 1];            }        } finally {            is.close();        }        if (glyphIdsToAdd != null) {            glyphIds.addAll(glyphIdsToAdd);        }        hasNested = glyphIdsToAdd != null;    } while (hasNested);}
private byte[] pdfbox_f2010_1(long[] newOffsets) throws IOException
{    ByteArrayOutputStream bos = new ByteArrayOutputStream();    GlyphTable g = ttf.getGlyph();    long[] offsets = ttf.getIndexToLocation().getOffsets();    try (InputStream is = ttf.getOriginalData()) {        long isResult = is.skip(g.getOffset());        if (Long.compare(isResult, g.getOffset()) != 0) {                    }                long prevEnd = 0;                long newOffset = 0;                int newGid = 0;                for (Integer gid : glyphIds) {            long offset = offsets[gid];            long length = offsets[gid + 1] - offset;            newOffsets[newGid++] = newOffset;            isResult = is.skip(offset - prevEnd);            if (Long.compare(isResult, offset - prevEnd) != 0) {                            }            byte[] buf = new byte[(int) length];            isResult = is.read(buf);            if (Long.compare(isResult, length) != 0) {                            }                        if (buf.length >= 2 && buf[0] == -1 && buf[1] == -1) {                                int off = 2 * 5;                int flags;                do {                                        flags = (buf[off] & 0xff) << 8 | buf[off + 1] & 0xff;                    off += 2;                                        int componentGid = (buf[off] & 0xff) << 8 | buf[off + 1] & 0xff;                    if (!glyphIds.contains(componentGid)) {                        glyphIds.add(componentGid);                    }                    int newComponentGid = getNewGlyphId(componentGid);                    buf[off] = (byte) (newComponentGid >>> 8);                    buf[off + 1] = (byte) newComponentGid;                    off += 2;                                        if ((flags & 1 << 0) != 0) {                        off += 2 * 2;                    } else {                        off += 2;                    }                                        if ((flags & 1 << 7) != 0) {                        off += 2 * 4;                    } else                     if ((flags & 1 << 6) != 0) {                        off += 2 * 2;                    } else                     if ((flags & 1 << 3) != 0) {                        off += 2;                    }                } while (                (flags & 1 << 5) != 0);                                if ((flags & 0x0100) == 0x0100) {                                        int numInstr = (buf[off] & 0xff) << 8 | buf[off + 1] & 0xff;                    off += 2;                                        off += numInstr;                }                                bos.write(buf, 0, off);                                newOffset += off;            } else if (buf.length > 0) {                                bos.write(buf, 0, buf.length);                                newOffset += buf.length;            }                        if (newOffset % 4 != 0) {                int len = 4 - (int) (newOffset % 4);                bos.write(PAD_BUF, 0, len);                newOffset += len;            }            prevEnd = offset + length;        }        newOffsets[newGid++] = newOffset;    }    return bos.toByteArray();}
private int pdfbox_f2011_0(Integer oldGid)
{    return glyphIds.headSet(oldGid).size();}
private byte[] pdfbox_f2012_0() throws IOException
{    if (ttf.getCmap() == null || uniToGID.isEmpty() || keepTables != null && !keepTables.contains("cmap")) {        return null;    }    ByteArrayOutputStream bos = new ByteArrayOutputStream();    DataOutputStream out = new DataOutputStream(bos);            writeUint16(out, 0);        writeUint16(out, 1);            writeUint16(out, CmapTable.PLATFORM_WINDOWS);        writeUint16(out, CmapTable.ENCODING_WIN_UNICODE_BMP);        writeUint32(out, 4 * 2 + 4);        Iterator<Entry<Integer, Integer>> it = uniToGID.entrySet().iterator();    Entry<Integer, Integer> lastChar = it.next();    Entry<Integer, Integer> prevChar = lastChar;    int lastGid = getNewGlyphId(lastChar.getValue());        int[] startCode = new int[uniToGID.size() + 1];    int[] endCode = new int[uniToGID.size() + 1];    int[] idDelta = new int[uniToGID.size() + 1];    int segCount = 0;    while (it.hasNext()) {        Entry<Integer, Integer> curChar2Gid = it.next();        int curGid = getNewGlyphId(curChar2Gid.getValue());                if (curChar2Gid.getKey() > 0xFFFF) {            throw new UnsupportedOperationException("non-BMP Unicode character");        }        if (curChar2Gid.getKey() != prevChar.getKey() + 1 || curGid - lastGid != curChar2Gid.getKey() - lastChar.getKey()) {            if (lastGid != 0) {                                                startCode[segCount] = lastChar.getKey();                endCode[segCount] = prevChar.getKey();                idDelta[segCount] = lastGid - lastChar.getKey();                segCount++;            } else if (!lastChar.getKey().equals(prevChar.getKey())) {                                startCode[segCount] = lastChar.getKey() + 1;                endCode[segCount] = prevChar.getKey();                idDelta[segCount] = lastGid - lastChar.getKey();                segCount++;            }            lastGid = curGid;            lastChar = curChar2Gid;        }        prevChar = curChar2Gid;    }        startCode[segCount] = lastChar.getKey();    endCode[segCount] = prevChar.getKey();    idDelta[segCount] = lastGid - lastChar.getKey();    segCount++;        startCode[segCount] = 0xffff;    endCode[segCount] = 0xffff;    idDelta[segCount] = 1;    segCount++;        int searchRange = 2 * (int) Math.pow(2, log2(segCount));        writeUint16(out, 4);        writeUint16(out, 8 * 2 + segCount * 4 * 2);        writeUint16(out, 0);        writeUint16(out, segCount * 2);        writeUint16(out, searchRange);        writeUint16(out, log2(searchRange / 2));        writeUint16(out, 2 * segCount - searchRange);        for (int i = 0; i < segCount; i++) {        writeUint16(out, endCode[i]);    }        writeUint16(out, 0);        for (int i = 0; i < segCount; i++) {        writeUint16(out, startCode[i]);    }        for (int i = 0; i < segCount; i++) {        writeUint16(out, idDelta[i]);    }    for (int i = 0; i < segCount; i++) {        writeUint16(out, 0);    }    return bos.toByteArray();}
private byte[] pdfbox_f2013_0() throws IOException
{    PostScriptTable post = ttf.getPostScript();    if (post == null || keepTables != null && !keepTables.contains("post")) {        return null;    }    ByteArrayOutputStream bos = new ByteArrayOutputStream();    DataOutputStream out = new DataOutputStream(bos);        writeFixed(out, 2.0);    writeFixed(out, post.getItalicAngle());    writeSInt16(out, post.getUnderlinePosition());    writeSInt16(out, post.getUnderlineThickness());    writeUint32(out, post.getIsFixedPitch());    writeUint32(out, post.getMinMemType42());    writeUint32(out, post.getMaxMemType42());    writeUint32(out, post.getMinMemType1());    writeUint32(out, post.getMaxMemType1());            writeUint16(out, glyphIds.size());        Map<String, Integer> names = new LinkedHashMap<>();    for (int gid : glyphIds) {        String name = post.getName(gid);        Integer macId = WGL4Names.MAC_GLYPH_NAMES_INDICES.get(name);        if (macId != null) {                        writeUint16(out, macId);        } else {                        Integer ordinal = names.get(name);            if (ordinal == null) {                ordinal = names.size();                names.put(name, ordinal);            }            writeUint16(out, 258 + ordinal);        }    }        for (String name : names.keySet()) {        byte[] buf = name.getBytes(Charset.forName("US-ASCII"));        writeUint8(out, buf.length);        out.write(buf);    }    out.flush();    return bos.toByteArray();}
private byte[] pdfbox_f2014_1() throws IOException
{    ByteArrayOutputStream bos = new ByteArrayOutputStream();    HorizontalHeaderTable h = ttf.getHorizontalHeader();    HorizontalMetricsTable hm = ttf.getHorizontalMetrics();    InputStream is = ttf.getOriginalData();        int lastgid = h.getNumberOfHMetrics() - 1;        boolean needLastGidWidth = false;    if (glyphIds.last() > lastgid && !glyphIds.contains(lastgid)) {        needLastGidWidth = true;    }    try {        long isResult = is.skip(hm.getOffset());        if (Long.compare(isResult, hm.getOffset()) != 0) {                    }        long lastOffset = 0;        for (Integer glyphId : glyphIds) {                        long offset;            if (glyphId <= lastgid) {                                offset = glyphId * 4;                lastOffset = copyBytes(is, bos, offset, lastOffset, 4);            } else {                if (needLastGidWidth) {                                                            needLastGidWidth = false;                    offset = lastgid * 4;                    lastOffset = copyBytes(is, bos, offset, lastOffset, 2);                                }                                offset = h.getNumberOfHMetrics() * 4 + (glyphId - h.getNumberOfHMetrics()) * 2;                lastOffset = copyBytes(is, bos, offset, lastOffset, 2);            }        }        return bos.toByteArray();    } finally {        is.close();    }}
private long pdfbox_f2015_0(InputStream is, OutputStream os, long newOffset, long lastOffset, int count) throws IOException
{        long nskip = newOffset - lastOffset;    if (nskip != is.skip(nskip)) {        throw new EOFException("Unexpected EOF exception parsing glyphId of hmtx table.");    }    byte[] buf = new byte[count];    if (count != is.read(buf, 0, count)) {        throw new EOFException("Unexpected EOF exception parsing glyphId of hmtx table.");    }    os.write(buf, 0, count);    return newOffset + count;}
public void pdfbox_f2016_1(OutputStream os) throws IOException
{    if (glyphIds.isEmpty() && uniToGID.isEmpty()) {            }    addCompoundReferences();    try (DataOutputStream out = new DataOutputStream(os)) {        long[] newLoca = new long[glyphIds.size() + 1];                byte[] head = buildHeadTable();        byte[] hhea = buildHheaTable();        byte[] maxp = buildMaxpTable();        byte[] name = buildNameTable();        byte[] os2 = buildOS2Table();        byte[] glyf = buildGlyfTable(newLoca);        byte[] loca = buildLocaTable(newLoca);        byte[] cmap = buildCmapTable();        byte[] hmtx = buildHmtxTable();        byte[] post = buildPostTable();                Map<String, byte[]> tables = new TreeMap<>();        if (os2 != null) {            tables.put("OS/2", os2);        }        if (cmap != null) {            tables.put("cmap", cmap);        }        tables.put("glyf", glyf);        tables.put("head", head);        tables.put("hhea", hhea);        tables.put("hmtx", hmtx);        tables.put("loca", loca);        tables.put("maxp", maxp);        if (name != null) {            tables.put("name", name);        }        if (post != null) {            tables.put("post", post);        }                for (Map.Entry<String, TTFTable> entry : ttf.getTableMap().entrySet()) {            String tag = entry.getKey();            TTFTable table = entry.getValue();            if (!tables.containsKey(tag) && (keepTables == null || keepTables.contains(tag))) {                tables.put(tag, ttf.getTableBytes(table));            }        }                long checksum = writeFileHeader(out, tables.size());        long offset = 12L + 16L * tables.size();        for (Map.Entry<String, byte[]> entry : tables.entrySet()) {            checksum += writeTableHeader(out, entry.getKey(), offset, entry.getValue());            offset += (entry.getValue().length + 3) / 4 * 4;        }        checksum = 0xB1B0AFBAL - (checksum & 0xffffffffL);                head[8] = (byte) (checksum >>> 24);        head[9] = (byte) (checksum >>> 16);        head[10] = (byte) (checksum >>> 8);        head[11] = (byte) checksum;        for (byte[] bytes : tables.values()) {            writeTableBody(out, bytes);        }    }}
private void pdfbox_f2017_0(DataOutputStream out, double f) throws IOException
{    double ip = Math.floor(f);    double fp = (f - ip) * 65536.0;    out.writeShort((int) ip);    out.writeShort((int) fp);}
private void pdfbox_f2018_0(DataOutputStream out, long l) throws IOException
{    out.writeInt((int) l);}
private void pdfbox_f2019_0(DataOutputStream out, int i) throws IOException
{    out.writeShort(i);}
private void pdfbox_f2020_0(DataOutputStream out, short i) throws IOException
{    out.writeShort(i);}
private void pdfbox_f2021_0(DataOutputStream out, int i) throws IOException
{    out.writeByte(i);}
private void pdfbox_f2022_0(DataOutputStream out, Calendar calendar) throws IOException
{        Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC"));    cal.set(1904, 0, 1, 0, 0, 0);    cal.set(Calendar.MILLISECOND, 0);    long millisFor1904 = cal.getTimeInMillis();    long secondsSince1904 = (calendar.getTimeInMillis() - millisFor1904) / 1000L;    out.writeLong(secondsSince1904);}
private long pdfbox_f2023_0(int high, int low)
{    return (high & 0xffffL) << 16 | low & 0xffffL;}
private long pdfbox_f2024_0(byte[] bytes)
{    return (bytes[0] & 0xffL) << 24 | (bytes[1] & 0xffL) << 16 | (bytes[2] & 0xffL) << 8 | bytes[3] & 0xffL;}
private int pdfbox_f2025_0(int num)
{    return (int) Math.round(Math.log(num) / Math.log(2));}
public void pdfbox_f2026_0(Set<Integer> allGlyphIds)
{    glyphIds.addAll(allGlyphIds);}
public long pdfbox_f2027_0()
{    return checkSum;}
