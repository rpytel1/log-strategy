public int pdfbox_f4044_0()
{    return dictionary.getInt(COSName.R, DEFAULT_VERSION);}
public void pdfbox_f4045_0(byte[] o) throws IOException
{    dictionary.setItem(COSName.O, new COSString(o));}
public byte[] pdfbox_f4046_0() throws IOException
{    byte[] o = null;    COSString owner = (COSString) dictionary.getDictionaryObject(COSName.O);    if (owner != null) {        o = owner.getBytes();    }    return o;}
public void pdfbox_f4047_0(byte[] u) throws IOException
{    dictionary.setItem(COSName.U, new COSString(u));}
public byte[] pdfbox_f4048_0() throws IOException
{    byte[] u = null;    COSString user = (COSString) dictionary.getDictionaryObject(COSName.U);    if (user != null) {        u = user.getBytes();    }    return u;}
public void pdfbox_f4049_0(byte[] oe) throws IOException
{    dictionary.setItem(COSName.OE, new COSString(oe));}
public byte[] pdfbox_f4050_0() throws IOException
{    byte[] oe = null;    COSString ownerEncryptionKey = (COSString) dictionary.getDictionaryObject(COSName.OE);    if (ownerEncryptionKey != null) {        oe = ownerEncryptionKey.getBytes();    }    return oe;}
public void pdfbox_f4051_0(byte[] ue) throws IOException
{    dictionary.setItem(COSName.UE, new COSString(ue));}
public byte[] pdfbox_f4052_0() throws IOException
{    byte[] ue = null;    COSString userEncryptionKey = (COSString) dictionary.getDictionaryObject(COSName.UE);    if (userEncryptionKey != null) {        ue = userEncryptionKey.getBytes();    }    return ue;}
public void pdfbox_f4053_0(int permissions)
{    dictionary.setInt(COSName.P, permissions);}
public int pdfbox_f4054_0()
{    return dictionary.getInt(COSName.P, 0);}
public boolean pdfbox_f4055_0()
{        boolean encryptMetaData = true;    COSBase value = dictionary.getDictionaryObject(COSName.ENCRYPT_META_DATA);    if (value instanceof COSBoolean) {        encryptMetaData = ((COSBoolean) value).getValue();    }    return encryptMetaData;}
public void pdfbox_f4056_0(byte[][] recipients) throws IOException
{    COSArray array = new COSArray();    for (byte[] recipient : recipients) {        COSString recip = new COSString(recipient);        array.add(recip);    }    dictionary.setItem(COSName.RECIPIENTS, array);    array.setDirect(true);}
public int pdfbox_f4057_0()
{    COSArray array = (COSArray) dictionary.getItem(COSName.RECIPIENTS);    return array.size();}
public COSString pdfbox_f4058_0(int i)
{    COSArray array = (COSArray) dictionary.getItem(COSName.RECIPIENTS);    return (COSString) array.get(i);}
public PDCryptFilterDictionary pdfbox_f4059_0()
{    return getCryptFilterDictionary(COSName.STD_CF);}
public PDCryptFilterDictionary pdfbox_f4060_0()
{    return getCryptFilterDictionary(COSName.DEFAULT_CRYPT_FILTER);}
public PDCryptFilterDictionary pdfbox_f4061_0(COSName cryptFilterName)
{        COSBase base = dictionary.getDictionaryObject(COSName.CF);    if (base instanceof COSDictionary) {        COSBase base2 = ((COSDictionary) base).getDictionaryObject(cryptFilterName);        if (base2 instanceof COSDictionary) {            return new PDCryptFilterDictionary((COSDictionary) base2);        }    }    return null;}
public void pdfbox_f4062_0(COSName cryptFilterName, PDCryptFilterDictionary cryptFilterDictionary)
{    COSDictionary cfDictionary = dictionary.getCOSDictionary(COSName.CF);    if (cfDictionary == null) {        cfDictionary = new COSDictionary();        dictionary.setItem(COSName.CF, cfDictionary);    }        cfDictionary.setDirect(true);    cfDictionary.setItem(cryptFilterName, cryptFilterDictionary.getCOSObject());}
public void pdfbox_f4063_0(PDCryptFilterDictionary cryptFilterDictionary)
{        cryptFilterDictionary.getCOSObject().setDirect(true);    setCryptFilterDictionary(COSName.STD_CF, cryptFilterDictionary);}
public void pdfbox_f4064_0(PDCryptFilterDictionary defaultFilterDictionary)
{        defaultFilterDictionary.getCOSObject().setDirect(true);    setCryptFilterDictionary(COSName.DEFAULT_CRYPT_FILTER, defaultFilterDictionary);}
public COSName pdfbox_f4065_0()
{    COSName stmF = (COSName) dictionary.getDictionaryObject(COSName.STM_F);    if (stmF == null) {        stmF = COSName.IDENTITY;    }    return stmF;}
public void pdfbox_f4066_0(COSName streamFilterName)
{    dictionary.setItem(COSName.STM_F, streamFilterName);}
public COSName pdfbox_f4067_0()
{    COSName strF = (COSName) dictionary.getDictionaryObject(COSName.STR_F);    if (strF == null) {        strF = COSName.IDENTITY;    }    return strF;}
public void pdfbox_f4068_0(COSName stringFilterName)
{    dictionary.setItem(COSName.STR_F, stringFilterName);}
public void pdfbox_f4069_0(byte[] perms) throws IOException
{    dictionary.setItem(COSName.PERMS, new COSString(perms));}
public byte[] pdfbox_f4070_0() throws IOException
{    byte[] perms = null;    COSString permsCosString = (COSString) dictionary.getDictionaryObject(COSName.PERMS);    if (permsCosString != null) {        perms = permsCosString.getBytes();    }    return perms;}
public void pdfbox_f4071_0()
{    dictionary.setItem(COSName.CF, null);    dictionary.setItem(COSName.STM_F, null);    dictionary.setItem(COSName.STR_F, null);}
public void pdfbox_f4072_0(int l)
{    if (l != 40 && l != 128 && l != 256) {        throw new IllegalArgumentException("Invalid key length '" + l + "' value must be 40, 128 or 256!");    }    encryptionKeyLength = l;}
public int pdfbox_f4073_0()
{    return encryptionKeyLength;}
public X509Certificate pdfbox_f4074_0() throws KeyStoreException
{    if (keyStore.size() == 1) {        Enumeration<String> aliases = keyStore.aliases();        String keyStoreAlias = aliases.nextElement();        return (X509Certificate) keyStore.getCertificate(keyStoreAlias);    } else {        if (keyStore.containsAlias(alias)) {            return (X509Certificate) keyStore.getCertificate(alias);        }        throw new KeyStoreException("the keystore does not contain the given alias");    }}
public String pdfbox_f4075_0()
{    return password;}
public Key pdfbox_f4076_0() throws KeyStoreException
{    try {        if (keyStore.size() == 1) {            Enumeration<String> aliases = keyStore.aliases();            String keyStoreAlias = aliases.nextElement();            return keyStore.getKey(keyStoreAlias, password.toCharArray());        } else {            if (keyStore.containsAlias(alias)) {                return keyStore.getKey(alias, password.toCharArray());            }            throw new KeyStoreException("the keystore does not contain the given alias");        }    } catch (UnrecoverableKeyException ex) {        throw new KeyStoreException("the private key is not recoverable", ex);    } catch (NoSuchAlgorithmException ex) {        throw new KeyStoreException("the algorithm necessary to recover the key is not available", ex);    }}
public void pdfbox_f4077_0(PublicKeyRecipient recipient)
{    recipients.add(recipient);}
public boolean pdfbox_f4078_0(PublicKeyRecipient recipient)
{    return recipients.remove(recipient);}
public Iterator<PublicKeyRecipient> pdfbox_f4079_0()
{    return recipients.iterator();}
public X509Certificate pdfbox_f4080_0()
{    return decryptionCertificate;}
public void pdfbox_f4081_0(X509Certificate decryptionCertificate)
{    this.decryptionCertificate = decryptionCertificate;}
public int pdfbox_f4082_0()
{    return recipients.size();}
public X509Certificate pdfbox_f4083_0()
{    return x509;}
public void pdfbox_f4084_0(X509Certificate aX509)
{    this.x509 = aX509;}
public AccessPermission pdfbox_f4085_0()
{    return permission;}
public void pdfbox_f4086_0(AccessPermission permissions)
{    this.permission = permissions;}
public void pdfbox_f4087_0(PDEncryption encryption, COSArray documentIDArray, DecryptionMaterial decryptionMaterial) throws IOException
{    if (!(decryptionMaterial instanceof PublicKeyDecryptionMaterial)) {        throw new IOException("Provided decryption material is not compatible with the document");    }    setDecryptMetadata(encryption.isEncryptMetaData());    if (encryption.getLength() != 0) {        this.keyLength = encryption.getLength();    }    PublicKeyDecryptionMaterial material = (PublicKeyDecryptionMaterial) decryptionMaterial;    try {        boolean foundRecipient = false;        X509Certificate certificate = material.getCertificate();        X509CertificateHolder materialCert = null;        if (certificate != null) {            materialCert = new X509CertificateHolder(certificate.getEncoded());        }                        byte[] envelopedData = null;                COSArray array = (COSArray) encryption.getCOSObject().getItem(COSName.RECIPIENTS);        if (array == null) {            PDCryptFilterDictionary defaultCryptFilterDictionary = encryption.getDefaultCryptFilterDictionary();            array = (COSArray) defaultCryptFilterDictionary.getCOSObject().getItem(COSName.RECIPIENTS);        }        byte[][] recipientFieldsBytes = new byte[array.size()][];                int recipientFieldsLength = 0;        StringBuilder extraInfo = new StringBuilder();        for (int i = 0; i < array.size(); i++) {            COSString recipientFieldString = (COSString) array.getObject(i);            byte[] recipientBytes = recipientFieldString.getBytes();            CMSEnvelopedData data = new CMSEnvelopedData(recipientBytes);            Collection<RecipientInformation> recipCertificatesIt = data.getRecipientInfos().getRecipients();            int j = 0;            for (RecipientInformation ri : recipCertificatesIt) {                                                RecipientId rid = ri.getRID();                if (!foundRecipient && rid.match(materialCert)) {                    foundRecipient = true;                    PrivateKey privateKey = (PrivateKey) material.getPrivateKey();                                                            envelopedData = ri.getContent(new JceKeyTransEnvelopedRecipient(privateKey));                    break;                }                j++;                if (certificate != null) {                    extraInfo.append('\n');                    extraInfo.append(j);                    extraInfo.append(": ");                    if (rid instanceof KeyTransRecipientId) {                        appendCertInfo(extraInfo, (KeyTransRecipientId) rid, certificate, materialCert);                    }                }            }            recipientFieldsBytes[i] = recipientBytes;            recipientFieldsLength += recipientBytes.length;        }        if (!foundRecipient || envelopedData == null) {            throw new IOException("The certificate matches none of " + array.size() + " recipient entries" + extraInfo.toString());        }        if (envelopedData.length != 24) {            throw new IOException("The enveloped data does not contain 24 bytes");        }                                byte[] accessBytes = new byte[4];        System.arraycopy(envelopedData, 20, accessBytes, 0, 4);        AccessPermission currentAccessPermission = new AccessPermission(accessBytes);        currentAccessPermission.setReadOnly();        setCurrentAccessPermission(currentAccessPermission);                byte[] sha1Input = new byte[recipientFieldsLength + 20];                System.arraycopy(envelopedData, 0, sha1Input, 0, 20);                int sha1InputOffset = 20;        for (byte[] recipientFieldsByte : recipientFieldsBytes) {            System.arraycopy(recipientFieldsByte, 0, sha1Input, sha1InputOffset, recipientFieldsByte.length);            sha1InputOffset += recipientFieldsByte.length;        }        byte[] mdResult;        if (encryption.getVersion() == 4 || encryption.getVersion() == 5) {            mdResult = MessageDigests.getSHA256().digest(sha1Input);                                                PDCryptFilterDictionary defaultCryptFilterDictionary = encryption.getDefaultCryptFilterDictionary();            if (defaultCryptFilterDictionary != null) {                COSName cryptFilterMethod = defaultCryptFilterDictionary.getCryptFilterMethod();                setAES(COSName.AESV2.equals(cryptFilterMethod) || COSName.AESV3.equals(cryptFilterMethod));            }        } else {            mdResult = MessageDigests.getSHA1().digest(sha1Input);        }                encryptionKey = new byte[this.keyLength / 8];        System.arraycopy(mdResult, 0, encryptionKey, 0, this.keyLength / 8);    } catch (CMSException | KeyStoreException | CertificateEncodingException e) {        throw new IOException(e);    }}
private void pdfbox_f4088_0(StringBuilder extraInfo, KeyTransRecipientId ktRid, X509Certificate certificate, X509CertificateHolder materialCert)
{    BigInteger ridSerialNumber = ktRid.getSerialNumber();    if (ridSerialNumber != null) {        String certSerial = "unknown";        BigInteger certSerialNumber = certificate.getSerialNumber();        if (certSerialNumber != null) {            certSerial = certSerialNumber.toString(16);        }        extraInfo.append("serial-#: rid ");        extraInfo.append(ridSerialNumber.toString(16));        extraInfo.append(" vs. cert ");        extraInfo.append(certSerial);        extraInfo.append(" issuer: rid \'");        extraInfo.append(ktRid.getIssuer());        extraInfo.append("\' vs. cert \'");        extraInfo.append(materialCert == null ? "null" : materialCert.getIssuer());        extraInfo.append("\' ");    }}
public void pdfbox_f4089_0(PDDocument doc) throws IOException
{    try {        PDEncryption dictionary = doc.getEncryption();        if (dictionary == null) {            dictionary = new PDEncryption();        }        dictionary.setFilter(FILTER);        dictionary.setLength(this.keyLength);        int version = computeVersionNumber();        dictionary.setVersion(version);                dictionary.removeV45filters();                byte[] seed = new byte[20];        KeyGenerator key;        try {            key = KeyGenerator.getInstance("AES");        } catch (NoSuchAlgorithmException e) {                        throw new RuntimeException(e);        }        key.init(192, new SecureRandom());        SecretKey sk = key.generateKey();                System.arraycopy(sk.getEncoded(), 0, seed, 0, 20);        byte[][] recipientsFields = computeRecipientsField(seed);        int shaInputLength = seed.length;        for (byte[] field : recipientsFields) {            shaInputLength += field.length;        }        byte[] shaInput = new byte[shaInputLength];        System.arraycopy(seed, 0, shaInput, 0, 20);        int shaInputOffset = 20;        for (byte[] recipientsField : recipientsFields) {            System.arraycopy(recipientsField, 0, shaInput, shaInputOffset, recipientsField.length);            shaInputOffset += recipientsField.length;        }        byte[] mdResult;        if (version == 4 || version == 5) {            dictionary.setSubFilter(SUBFILTER5);            mdResult = MessageDigests.getSHA256().digest(shaInput);            COSName aesVName = version == 5 ? COSName.AESV3 : COSName.AESV2;            prepareEncryptionDictAES(dictionary, aesVName, recipientsFields);        } else {            dictionary.setSubFilter(SUBFILTER4);            mdResult = MessageDigests.getSHA1().digest(shaInput);            dictionary.setRecipients(recipientsFields);        }        this.encryptionKey = new byte[this.keyLength / 8];        System.arraycopy(mdResult, 0, this.encryptionKey, 0, this.keyLength / 8);        doc.setEncryptionDictionary(dictionary);        doc.getDocument().setEncryptionDictionary(dictionary.getCOSObject());    } catch (GeneralSecurityException e) {        throw new IOException(e);    }}
private int pdfbox_f4090_0()
{    switch(keyLength) {        case 40:            return 1;        case 128:                        return 2;                case 256:            return 5;        default:            throw new IllegalArgumentException("key length must be 40, 128 or 256");    }}
private void pdfbox_f4091_0(PDEncryption encryptionDictionary, COSName aesVName, byte[][] recipients)
{    PDCryptFilterDictionary cryptFilterDictionary = new PDCryptFilterDictionary();    cryptFilterDictionary.setCryptFilterMethod(aesVName);    cryptFilterDictionary.setLength(keyLength);    COSArray array = new COSArray();    for (byte[] recipient : recipients) {        array.add(new COSString(recipient));    }    cryptFilterDictionary.getCOSObject().setItem(COSName.RECIPIENTS, array);    array.setDirect(true);    encryptionDictionary.setDefaultCryptFilterDictionary(cryptFilterDictionary);    encryptionDictionary.setStreamFilterName(COSName.DEFAULT_CRYPT_FILTER);    encryptionDictionary.setStringFilterName(COSName.DEFAULT_CRYPT_FILTER);    cryptFilterDictionary.getCOSObject().setDirect(true);    setAES(true);}
private byte[][] pdfbox_f4092_0(byte[] seed) throws GeneralSecurityException, IOException
{    byte[][] recipientsField = new byte[policy.getNumberOfRecipients()][];    Iterator<PublicKeyRecipient> it = policy.getRecipientsIterator();    int i = 0;    while (it.hasNext()) {        PublicKeyRecipient recipient = it.next();        X509Certificate certificate = recipient.getX509();        int permission = recipient.getPermission().getPermissionBytesForPublicKey();        byte[] pkcs7input = new byte[24];        byte one = (byte) (permission);        byte two = (byte) (permission >>> 8);        byte three = (byte) (permission >>> 16);        byte four = (byte) (permission >>> 24);                System.arraycopy(seed, 0, pkcs7input, 0, 20);        pkcs7input[20] = four;        pkcs7input[21] = three;        pkcs7input[22] = two;        pkcs7input[23] = one;        ASN1Primitive obj = createDERForRecipient(pkcs7input, certificate);        ByteArrayOutputStream baos = new ByteArrayOutputStream();        obj.encodeTo(baos, ASN1Encoding.DER);        recipientsField[i] = baos.toByteArray();        i++;    }    return recipientsField;}
private ASN1Primitive pdfbox_f4093_0(byte[] in, X509Certificate cert) throws IOException, GeneralSecurityException
{    String algorithm = PKCSObjectIdentifiers.RC2_CBC.getId();    AlgorithmParameterGenerator apg;    KeyGenerator keygen;    Cipher cipher;    try {        apg = AlgorithmParameterGenerator.getInstance(algorithm, SecurityProvider.getProvider());        keygen = KeyGenerator.getInstance(algorithm, SecurityProvider.getProvider());        cipher = Cipher.getInstance(algorithm, SecurityProvider.getProvider());    } catch (NoSuchAlgorithmException e) {                throw new IOException("Could not find a suitable javax.crypto provider for algorithm " + algorithm + "; possible reason: using an unsigned .jar file", e);    } catch (NoSuchPaddingException e) {                throw new RuntimeException("Could not find a suitable javax.crypto provider", e);    }    AlgorithmParameters parameters = apg.generateParameters();    ASN1Primitive object;    try (ASN1InputStream input = new ASN1InputStream(parameters.getEncoded("ASN.1"))) {        object = input.readObject();    }    keygen.init(128);    SecretKey secretkey = keygen.generateKey();    cipher.init(1, secretkey, parameters);    byte[] bytes = cipher.doFinal(in);    KeyTransRecipientInfo recipientInfo = computeRecipientInfo(cert, secretkey.getEncoded());    DERSet set = new DERSet(new RecipientInfo(recipientInfo));    AlgorithmIdentifier algorithmId = new AlgorithmIdentifier(new ASN1ObjectIdentifier(algorithm), object);    EncryptedContentInfo encryptedInfo = new EncryptedContentInfo(PKCSObjectIdentifiers.data, algorithmId, new DEROctetString(bytes));    EnvelopedData enveloped = new EnvelopedData(null, set, encryptedInfo, (ASN1Set) null);    ContentInfo contentInfo = new ContentInfo(PKCSObjectIdentifiers.envelopedData, enveloped);    return contentInfo.toASN1Primitive();}
private KeyTransRecipientInfo pdfbox_f4094_0(X509Certificate x509certificate, byte[] abyte0) throws IOException, CertificateEncodingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
{    TBSCertificate certificate;    try (ASN1InputStream input = new ASN1InputStream(x509certificate.getTBSCertificate())) {        certificate = TBSCertificate.getInstance(input.readObject());    }    AlgorithmIdentifier algorithmId = certificate.getSubjectPublicKeyInfo().getAlgorithm();    IssuerAndSerialNumber serial = new IssuerAndSerialNumber(certificate.getIssuer(), certificate.getSerialNumber().getValue());    Cipher cipher;    try {        cipher = Cipher.getInstance(algorithmId.getAlgorithm().getId(), SecurityProvider.getProvider());    } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {                throw new RuntimeException("Could not find a suitable javax.crypto provider", e);    }    cipher.init(1, x509certificate.getPublicKey());    DEROctetString octets = new DEROctetString(cipher.doFinal(abyte0));    RecipientIdentifier recipientId = new RecipientIdentifier(serial);    return new KeyTransRecipientInfo(recipientId, algorithmId, octets);}
public boolean pdfbox_f4095_0()
{    return policy != null;}
public void pdfbox_f4096_0(byte[] key)
{    b = 0;    c = 0;    if (key.length < 1 || key.length > 32) {        throw new IllegalArgumentException("number of bytes must be between 1 and 32");    }    for (int i = 0; i < salt.length; i++) {        salt[i] = i;    }    int keyIndex = 0;    int saltIndex = 0;    for (int i = 0; i < salt.length; i++) {        saltIndex = (fixByte(key[keyIndex]) + salt[i] + saltIndex) % 256;        swap(salt, i, saltIndex);        keyIndex = (keyIndex + 1) % key.length;    }}
private static int pdfbox_f4097_0(byte aByte)
{    return aByte < 0 ? 256 + aByte : aByte;}
private static void pdfbox_f4098_0(int[] data, int firstIndex, int secondIndex)
{    int tmp = data[firstIndex];    data[firstIndex] = data[secondIndex];    data[secondIndex] = tmp;}
public void pdfbox_f4099_0(byte aByte, OutputStream output) throws IOException
{    b = (b + 1) % 256;    c = (salt[b] + c) % 256;    swap(salt, b, c);    int saltIndex = (salt[b] + salt[c]) % 256;    output.write(aByte ^ (byte) salt[saltIndex]);}
public void pdfbox_f4100_0(byte[] data, OutputStream output) throws IOException
{    for (byte aData : data) {        write(aData, output);    }}
public void pdfbox_f4101_0(InputStream data, OutputStream output) throws IOException
{    byte[] buffer = new byte[1024];    int amountRead;    while ((amountRead = data.read(buffer)) != -1) {        write(buffer, 0, amountRead, output);    }}
public void pdfbox_f4102_0(byte[] data, int offset, int len, OutputStream output) throws IOException
{    for (int i = offset; i < offset + len; i++) {        write(data[i], output);    }}
 static String pdfbox_f4103_0(String str)
{    return saslPrep(str, true);}
 static String pdfbox_f4104_0(String str)
{    return saslPrep(str, false);}
private static String pdfbox_f4105_0(String str, boolean allowUnassigned)
{    char[] chars = str.toCharArray();        for (int i = 0; i < str.length(); i++) {        char ch = str.charAt(i);        if (nonAsciiSpace(ch)) {            chars[i] = ' ';        }    }    int length = 0;    for (int i = 0; i < str.length(); i++) {        char ch = chars[i];        if (!mappedToNothing(ch)) {            chars[length++] = ch;        }    }        String normalized = Normalizer.normalize(CharBuffer.wrap(chars, 0, length), Normalizer.Form.NFKC);    boolean containsRandALCat = false;    boolean containsLCat = false;    boolean initialRandALCat = false;    int i = 0;    while (i < normalized.length()) {        final int codepoint = normalized.codePointAt(i);                if (prohibited(codepoint)) {            throw new IllegalArgumentException("Prohibited character '" + Character.getName(codepoint) + "' at position " + i);        }                final byte directionality = Character.getDirectionality(codepoint);        final boolean isRandALcat = directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT || directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;        containsRandALCat |= isRandALcat;        containsLCat |= directionality == Character.DIRECTIONALITY_LEFT_TO_RIGHT;        initialRandALCat |= i == 0 && isRandALcat;        if (!allowUnassigned && !Character.isDefined(codepoint)) {            throw new IllegalArgumentException("Character at position " + i + " is unassigned");        }        i += Character.charCount(codepoint);        if (initialRandALCat && i >= normalized.length() && !isRandALcat) {            throw new IllegalArgumentException("First character is RandALCat, but last character is not");        }    }    if (containsRandALCat && containsLCat) {        throw new IllegalArgumentException("Contains both RandALCat characters and LCat characters");    }    return normalized;}
 static boolean pdfbox_f4106_0(int codepoint)
{    return nonAsciiSpace((char) codepoint) || asciiControl((char) codepoint) || nonAsciiControl(codepoint) || privateUse(codepoint) || nonCharacterCodePoint(codepoint) || surrogateCodePoint(codepoint) || inappropriateForPlainText(codepoint) || inappropriateForCanonical(codepoint) || changeDisplayProperties(codepoint) || tagging(codepoint);}
private static boolean pdfbox_f4107_0(int codepoint)
{    return codepoint == 0xE0001 || 0xE0020 <= codepoint && codepoint <= 0xE007F;}
private static boolean pdfbox_f4108_0(int codepoint)
{    return codepoint == 0x0340 || codepoint == 0x0341 || codepoint == 0x200E || codepoint == 0x200F || codepoint == 0x202A || codepoint == 0x202B || codepoint == 0x202C || codepoint == 0x202D || codepoint == 0x202E || codepoint == 0x206A || codepoint == 0x206B || codepoint == 0x206C || codepoint == 0x206D || codepoint == 0x206E || codepoint == 0x206F;}
private static boolean pdfbox_f4109_0(int codepoint)
{    return 0x2FF0 <= codepoint && codepoint <= 0x2FFB;}
private static boolean pdfbox_f4110_0(int codepoint)
{    return codepoint == 0xFFF9 || codepoint == 0xFFFA || codepoint == 0xFFFB || codepoint == 0xFFFC || codepoint == 0xFFFD;}
private static boolean pdfbox_f4111_0(int codepoint)
{    return 0xD800 <= codepoint && codepoint <= 0xDFFF;}
private static boolean pdfbox_f4112_0(int codepoint)
{    return 0xFDD0 <= codepoint && codepoint <= 0xFDEF || 0xFFFE <= codepoint && codepoint <= 0xFFFF || 0x1FFFE <= codepoint && codepoint <= 0x1FFFF || 0x2FFFE <= codepoint && codepoint <= 0x2FFFF || 0x3FFFE <= codepoint && codepoint <= 0x3FFFF || 0x4FFFE <= codepoint && codepoint <= 0x4FFFF || 0x5FFFE <= codepoint && codepoint <= 0x5FFFF || 0x6FFFE <= codepoint && codepoint <= 0x6FFFF || 0x7FFFE <= codepoint && codepoint <= 0x7FFFF || 0x8FFFE <= codepoint && codepoint <= 0x8FFFF || 0x9FFFE <= codepoint && codepoint <= 0x9FFFF || 0xAFFFE <= codepoint && codepoint <= 0xAFFFF || 0xBFFFE <= codepoint && codepoint <= 0xBFFFF || 0xCFFFE <= codepoint && codepoint <= 0xCFFFF || 0xDFFFE <= codepoint && codepoint <= 0xDFFFF || 0xEFFFE <= codepoint && codepoint <= 0xEFFFF || 0xFFFFE <= codepoint && codepoint <= 0xFFFFF || 0x10FFFE <= codepoint && codepoint <= 0x10FFFF;}
private static boolean pdfbox_f4113_0(int codepoint)
{    return 0xE000 <= codepoint && codepoint <= 0xF8FF || 0xF0000 <= codepoint && codepoint <= 0xFFFFD || 0x100000 <= codepoint && codepoint <= 0x10FFFD;}
private static boolean pdfbox_f4114_0(int codepoint)
{    return 0x0080 <= codepoint && codepoint <= 0x009F || codepoint == 0x06DD || codepoint == 0x070F || codepoint == 0x180E || codepoint == 0x200C || codepoint == 0x200D || codepoint == 0x2028 || codepoint == 0x2029 || codepoint == 0x2060 || codepoint == 0x2061 || codepoint == 0x2062 || codepoint == 0x2063 || 0x206A <= codepoint && codepoint <= 0x206F || codepoint == 0xFEFF || 0xFFF9 <= codepoint && codepoint <= 0xFFFC || 0x1D173 <= codepoint && codepoint <= 0x1D17A;}
private static boolean pdfbox_f4115_0(char ch)
{    return '\u0000' <= ch && ch <= '\u001F' || ch == '\u007F';}
private static boolean pdfbox_f4116_0(char ch)
{    return ch == '\u00A0' || ch == '\u1680' || '\u2000' <= ch && ch <= '\u200B' || ch == '\u202F' || ch == '\u205F' || ch == '\u3000';}
private static boolean pdfbox_f4117_0(char ch)
{    return ch == '\u00AD' || ch == '\u034F' || ch == '\u1806' || ch == '\u180B' || ch == '\u180C' || ch == '\u180D' || ch == '\u200B' || ch == '\u200C' || ch == '\u200D' || ch == '\u2060' || '\uFE00' <= ch && ch <= '\uFE0F' || ch == '\uFEFF';}
protected void pdfbox_f4118_0(boolean decryptMetadata)
{    this.decryptMetadata = decryptMetadata;}
protected void pdfbox_f4119_0(COSName stringFilterName)
{    this.stringFilterName = stringFilterName;}
protected void pdfbox_f4120_0(COSName streamFilterName)
{    this.streamFilterName = streamFilterName;}
private void pdfbox_f4121_0(long objectNumber, long genNumber, InputStream data, OutputStream output, boolean decrypt) throws IOException
{        if (useAES && encryptionKey.length == 32) {        encryptDataAES256(data, output, decrypt);    } else {        byte[] finalKey = calcFinalKey(objectNumber, genNumber);        if (useAES) {            encryptDataAESother(finalKey, data, output, decrypt);        } else {            encryptDataRC4(finalKey, data, output);        }    }    output.flush();}
private byte[] pdfbox_f4122_0(long objectNumber, long genNumber)
{    byte[] newKey = new byte[encryptionKey.length + 5];    System.arraycopy(encryptionKey, 0, newKey, 0, encryptionKey.length);                    newKey[newKey.length - 5] = (byte) (objectNumber & 0xff);    newKey[newKey.length - 4] = (byte) (objectNumber >> 8 & 0xff);    newKey[newKey.length - 3] = (byte) (objectNumber >> 16 & 0xff);    newKey[newKey.length - 2] = (byte) (genNumber & 0xff);    newKey[newKey.length - 1] = (byte) (genNumber >> 8 & 0xff);        MessageDigest md = MessageDigests.getMD5();    md.update(newKey);    if (useAES) {        md.update(AES_SALT);    }    byte[] digestedKey = md.digest();        int length = Math.min(newKey.length, 16);    byte[] finalKey = new byte[length];    System.arraycopy(digestedKey, 0, finalKey, 0, length);    return finalKey;}
protected void pdfbox_f4123_0(byte[] finalKey, InputStream input, OutputStream output) throws IOException
{    rc4.setKey(finalKey);    rc4.write(input, output);}
protected void pdfbox_f4124_0(byte[] finalKey, byte[] input, OutputStream output) throws IOException
{    rc4.setKey(finalKey);    rc4.write(input, output);}
private void pdfbox_f4125_0(byte[] finalKey, InputStream data, OutputStream output, boolean decrypt) throws IOException
{    byte[] iv = new byte[16];    if (!prepareAESInitializationVector(decrypt, iv, data, output)) {        return;    }    try {        Cipher decryptCipher;        try {            decryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");        } catch (NoSuchAlgorithmException e) {                        throw new RuntimeException(e);        }        SecretKey aesKey = new SecretKeySpec(finalKey, "AES");        IvParameterSpec ips = new IvParameterSpec(iv);        decryptCipher.init(decrypt ? Cipher.DECRYPT_MODE : Cipher.ENCRYPT_MODE, aesKey, ips);        byte[] buffer = new byte[256];        int n;        while ((n = data.read(buffer)) != -1) {            byte[] dst = decryptCipher.update(buffer, 0, n);            if (dst != null) {                output.write(dst);            }        }        output.write(decryptCipher.doFinal());    } catch (InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {        throw new IOException(e);    }}
private void pdfbox_f4126_1(InputStream data, OutputStream output, boolean decrypt) throws IOException
{    byte[] iv = new byte[16];    if (!prepareAESInitializationVector(decrypt, iv, data, output)) {        return;    }    Cipher cipher;    try {        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");        SecretKeySpec keySpec = new SecretKeySpec(encryptionKey, "AES");        IvParameterSpec ivSpec = new IvParameterSpec(iv);        cipher.init(decrypt ? Cipher.DECRYPT_MODE : Cipher.ENCRYPT_MODE, keySpec, ivSpec);    } catch (GeneralSecurityException e) {        throw new IOException(e);    }    try (CipherInputStream cis = new CipherInputStream(data, cipher)) {        IOUtils.copy(cis, output);    } catch (IOException exception) {                if (!(exception.getCause() instanceof GeneralSecurityException)) {            throw exception;        }            }}
private boolean pdfbox_f4127_0(boolean decrypt, byte[] iv, InputStream data, OutputStream output) throws IOException
{    if (decrypt) {                int ivSize = data.read(iv);        if (ivSize == -1) {            return false;        }        if (ivSize != iv.length) {            throw new IOException("AES initialization vector not fully read: only " + ivSize + " bytes read instead of " + iv.length);        }    } else {                SecureRandom rnd = new SecureRandom();        rnd.nextBytes(iv);        output.write(iv);    }    return true;}
public void pdfbox_f4128_0(COSBase obj, long objNum, long genNum) throws IOException
{    if (!(obj instanceof COSString || obj instanceof COSDictionary || obj instanceof COSArray)) {        return;    }        if (obj instanceof COSString) {        if (objects.contains(obj)) {            return;        }        objects.add(obj);        decryptString((COSString) obj, objNum, genNum);    } else if (obj instanceof COSStream) {        if (objects.contains(obj)) {            return;        }        objects.add(obj);        decryptStream((COSStream) obj, objNum, genNum);    } else if (obj instanceof COSDictionary) {        decryptDictionary((COSDictionary) obj, objNum, genNum);    } else if (obj instanceof COSArray) {        decryptArray((COSArray) obj, objNum, genNum);    }}
public void pdfbox_f4129_1(COSStream stream, long objNum, long genNum) throws IOException
{        if (COSName.IDENTITY.equals(streamFilterName)) {        return;    }    COSBase type = stream.getCOSName(COSName.TYPE);    if (!decryptMetadata && COSName.METADATA.equals(type)) {        return;    }        if (COSName.XREF.equals(type)) {        return;    }    if (COSName.METADATA.equals(type)) {        byte[] buf;                try (InputStream is = stream.createRawInputStream()) {            buf = new byte[10];            long isResult = is.read(buf);            if (Long.compare(isResult, buf.length) != 0) {                            }        }        if (Arrays.equals(buf, "<?xpacket ".getBytes(Charsets.ISO_8859_1))) {                                    return;        }    }    decryptDictionary(stream, objNum, genNum);    byte[] encrypted = IOUtils.toByteArray(stream.createRawInputStream());    ByteArrayInputStream encryptedStream = new ByteArrayInputStream(encrypted);    try (OutputStream output = stream.createRawOutputStream()) {        encryptData(objNum, genNum, encryptedStream, output, true);    }}
public void pdfbox_f4130_0(COSStream stream, long objNum, int genNum) throws IOException
{    byte[] rawData = IOUtils.toByteArray(stream.createRawInputStream());    ByteArrayInputStream encryptedStream = new ByteArrayInputStream(rawData);    try (OutputStream output = stream.createRawOutputStream()) {        encryptData(objNum, genNum, encryptedStream, output, false);    }}
private void pdfbox_f4131_0(COSDictionary dictionary, long objNum, long genNum) throws IOException
{    if (dictionary.getItem(COSName.CF) != null) {                return;    }    COSBase type = dictionary.getDictionaryObject(COSName.TYPE);    boolean isSignature = COSName.SIG.equals(type) || COSName.DOC_TIME_STAMP.equals(type) ||     (dictionary.getDictionaryObject(COSName.CONTENTS) instanceof COSString && dictionary.getDictionaryObject(COSName.BYTERANGE) instanceof COSArray);    for (Map.Entry<COSName, COSBase> entry : dictionary.entrySet()) {        if (isSignature && COSName.CONTENTS.equals(entry.getKey())) {                        continue;        }        COSBase value = entry.getValue();                if (value instanceof COSString || value instanceof COSArray || value instanceof COSDictionary) {            decrypt(value, objNum, genNum);        }    }}
private void pdfbox_f4132_1(COSString string, long objNum, long genNum) throws IOException
{        if (COSName.IDENTITY.equals(stringFilterName)) {        return;    }    ByteArrayInputStream data = new ByteArrayInputStream(string.getBytes());    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();    try {        encryptData(objNum, genNum, data, outputStream, true);        string.setValue(outputStream.toByteArray());    } catch (IOException ex) {            }}
public void pdfbox_f4133_0(COSString string, long objNum, int genNum) throws IOException
{    ByteArrayInputStream data = new ByteArrayInputStream(string.getBytes());    ByteArrayOutputStream buffer = new ByteArrayOutputStream();    encryptData(objNum, genNum, data, buffer, false);    string.setValue(buffer.toByteArray());}
private void pdfbox_f4134_0(COSArray array, long objNum, long genNum) throws IOException
{    for (int i = 0; i < array.size(); i++) {        decrypt(array.get(i), objNum, genNum);    }}
public int pdfbox_f4135_0()
{    return keyLength;}
public void pdfbox_f4136_0(int keyLen)
{    this.keyLength = keyLen;}
public void pdfbox_f4137_0(AccessPermission currentAccessPermission)
{    this.currentAccessPermission = currentAccessPermission;}
public AccessPermission pdfbox_f4138_0()
{    return currentAccessPermission;}
public boolean pdfbox_f4139_0()
{    return useAES;}
public void pdfbox_f4140_0(boolean aesValue)
{    useAES = aesValue;}
public void pdfbox_f4141_0(String name, Class<? extends SecurityHandler> securityHandler, Class<? extends ProtectionPolicy> protectionPolicy)
{    if (nameToHandler.containsKey(name)) {        throw new IllegalStateException("The security handler name is already registered");    }    nameToHandler.put(name, securityHandler);    policyToHandler.put(protectionPolicy, securityHandler);}
public SecurityHandler pdfbox_f4142_0(ProtectionPolicy policy)
{    Class<? extends SecurityHandler> handlerClass = policyToHandler.get(policy.getClass());    if (handlerClass == null) {        return null;    }    Class<?>[] argsClasses = { policy.getClass() };    Object[] args = { policy };    return newSecurityHandler(handlerClass, argsClasses, args);}
public SecurityHandler pdfbox_f4143_0(String name)
{    Class<? extends SecurityHandler> handlerClass = nameToHandler.get(name);    if (handlerClass == null) {        return null;    }    Class<?>[] argsClasses = {};    Object[] args = {};    return newSecurityHandler(handlerClass, argsClasses, args);}
private SecurityHandler pdfbox_f4144_0(Class<? extends SecurityHandler> handlerClass, Class<?>[] argsClasses, Object[] args)
{    try {        Constructor<? extends SecurityHandler> ctor = handlerClass.getDeclaredConstructor(argsClasses);        return ctor.newInstance(args);    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {                throw new RuntimeException(e);    }}
public static Provider pdfbox_f4145_0() throws IOException
{        if (provider == null) {        try {            Class<Provider> providerClass = (Class<Provider>) Class.forName("org.bouncycastle.jce.provider.BouncyCastleProvider");            provider = providerClass.getDeclaredConstructor().newInstance();        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {            throw new IOException(ex);        }    }    return provider;}
public static void pdfbox_f4146_0(Provider provider)
{    SecurityProvider.provider = provider;}
public String pdfbox_f4147_0()
{    return password;}
public AccessPermission pdfbox_f4148_0()
{    return permissions;}
public void pdfbox_f4149_0(AccessPermission permissions)
{    this.permissions = permissions;}
public String pdfbox_f4150_0()
{    return ownerPassword;}
public void pdfbox_f4151_0(String ownerPassword)
{    this.ownerPassword = ownerPassword;}
public String pdfbox_f4152_0()
{    return userPassword;}
public void pdfbox_f4153_0(String userPassword)
{    this.userPassword = userPassword;}
public boolean pdfbox_f4154_0()
{    return this.preferAES;}
public void pdfbox_f4155_0(boolean preferAES)
{    this.preferAES = preferAES;}
private int pdfbox_f4156_0()
{    if (keyLength == 40) {        return DEFAULT_VERSION;    } else if (keyLength == 128 && policy.isPreferAES()) {        return 4;    } else if (keyLength == 256) {        return 5;    }    return 2;}
private int pdfbox_f4157_0(int version)
{    if (version < 2 && !policy.getPermissions().hasAnyRevision3PermissionSet()) {        return 2;    }    if (version == 5) {                return 6;    }    if (version == 4) {        return 4;    }    if (version == 2 || version == 3 || policy.getPermissions().hasAnyRevision3PermissionSet()) {        return 3;    }    return 4;}
public void pdfbox_f4158_0(PDEncryption encryption, COSArray documentIDArray, DecryptionMaterial decryptionMaterial) throws IOException
{    if (!(decryptionMaterial instanceof StandardDecryptionMaterial)) {        throw new IOException("Decryption material is not compatible with the document");    }        if (encryption.getVersion() >= 4) {        setStreamFilterName(encryption.getStreamFilterName());        setStringFilterName(encryption.getStreamFilterName());    }    setDecryptMetadata(encryption.isEncryptMetaData());    StandardDecryptionMaterial material = (StandardDecryptionMaterial) decryptionMaterial;    String password = material.getPassword();    if (password == null) {        password = "";    }    int dicPermissions = encryption.getPermissions();    int dicRevision = encryption.getRevision();    int dicLength = encryption.getVersion() == 1 ? 5 : encryption.getLength() / 8;    byte[] documentIDBytes = getDocumentIDBytes(documentIDArray);        boolean encryptMetadata = encryption.isEncryptMetaData();    byte[] userKey = encryption.getUserKey();    byte[] ownerKey = encryption.getOwnerKey();    byte[] ue = null, oe = null;    Charset passwordCharset = Charsets.ISO_8859_1;    if (dicRevision == 6 || dicRevision == 5) {        passwordCharset = Charsets.UTF_8;        ue = encryption.getUserEncryptionKey();        oe = encryption.getOwnerEncryptionKey();    }    if (dicRevision == 6) {                password = SaslPrep.saslPrepQuery(password);    }    AccessPermission currentAccessPermission;    if (isOwnerPassword(password.getBytes(passwordCharset), userKey, ownerKey, dicPermissions, documentIDBytes, dicRevision, dicLength, encryptMetadata)) {        currentAccessPermission = AccessPermission.getOwnerAccessPermission();        setCurrentAccessPermission(currentAccessPermission);        byte[] computedPassword;        if (dicRevision == 6 || dicRevision == 5) {            computedPassword = password.getBytes(passwordCharset);        } else {            computedPassword = getUserPassword(password.getBytes(passwordCharset), ownerKey, dicRevision, dicLength);        }        encryptionKey = computeEncryptedKey(computedPassword, ownerKey, userKey, oe, ue, dicPermissions, documentIDBytes, dicRevision, dicLength, encryptMetadata, true);    } else if (isUserPassword(password.getBytes(passwordCharset), userKey, ownerKey, dicPermissions, documentIDBytes, dicRevision, dicLength, encryptMetadata)) {        currentAccessPermission = new AccessPermission(dicPermissions);        currentAccessPermission.setReadOnly();        setCurrentAccessPermission(currentAccessPermission);        encryptionKey = computeEncryptedKey(password.getBytes(passwordCharset), ownerKey, userKey, oe, ue, dicPermissions, documentIDBytes, dicRevision, dicLength, encryptMetadata, false);    } else {        throw new InvalidPasswordException("Cannot decrypt PDF, the password is incorrect");    }    if (dicRevision == 6 || dicRevision == 5) {        validatePerms(encryption, dicPermissions, encryptMetadata);    }    if (encryption.getVersion() == 4 || encryption.getVersion() == 5) {                                PDCryptFilterDictionary stdCryptFilterDictionary = encryption.getStdCryptFilterDictionary();        if (stdCryptFilterDictionary != null) {            COSName cryptFilterMethod = stdCryptFilterDictionary.getCryptFilterMethod();            setAES(COSName.AESV2.equals(cryptFilterMethod) || COSName.AESV3.equals(cryptFilterMethod));        }    }}
private byte[] pdfbox_f4159_0(COSArray documentIDArray)
{            byte[] documentIDBytes;    if (documentIDArray != null && documentIDArray.size() >= 1) {        COSString id = (COSString) documentIDArray.getObject(0);        documentIDBytes = id.getBytes();    } else {        documentIDBytes = new byte[0];    }    return documentIDBytes;}
private void pdfbox_f4160_1(PDEncryption encryption, int dicPermissions, boolean encryptMetadata) throws IOException
{    try {                        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(encryptionKey, "AES"));        byte[] perms = cipher.doFinal(encryption.getPerms());                if (perms[9] != 'a' || perms[10] != 'd' || perms[11] != 'b') {                    }                        int permsP = perms[0] & 0xFF | (perms[1] & 0xFF) << 8 | (perms[2] & 0xFF) << 16 | (perms[3] & 0xFF) << 24;        if (permsP != dicPermissions) {                    }        if (encryptMetadata && perms[8] != 'T' || !encryptMetadata && perms[8] != 'F') {                    }    } catch (GeneralSecurityException e) {        logIfStrongEncryptionMissing();        throw new IOException(e);    }}
public void pdfbox_f4161_0(PDDocument document) throws IOException
{    PDEncryption encryptionDictionary = document.getEncryption();    if (encryptionDictionary == null) {        encryptionDictionary = new PDEncryption();    }    int version = computeVersionNumber();    int revision = computeRevisionNumber(version);    encryptionDictionary.setFilter(FILTER);    encryptionDictionary.setVersion(version);    if (version != 4 && version != 5) {                encryptionDictionary.removeV45filters();    }    encryptionDictionary.setRevision(revision);    encryptionDictionary.setLength(keyLength);    String ownerPassword = policy.getOwnerPassword();    String userPassword = policy.getUserPassword();    if (ownerPassword == null) {        ownerPassword = "";    }    if (userPassword == null) {        userPassword = "";    }        if (ownerPassword.isEmpty()) {        ownerPassword = userPassword;    }    int permissionInt = policy.getPermissions().getPermissionBytes();    encryptionDictionary.setPermissions(permissionInt);    int length = keyLength / 8;    if (revision == 6) {                ownerPassword = SaslPrep.saslPrepStored(ownerPassword);        userPassword = SaslPrep.saslPrepStored(userPassword);        prepareEncryptionDictRev6(ownerPassword, userPassword, encryptionDictionary, permissionInt);    } else {        prepareEncryptionDictRev2345(ownerPassword, userPassword, encryptionDictionary, permissionInt, document, revision, length);    }    document.setEncryptionDictionary(encryptionDictionary);    document.getDocument().setEncryptionDictionary(encryptionDictionary.getCOSObject());}
private void pdfbox_f4162_0(String ownerPassword, String userPassword, PDEncryption encryptionDictionary, int permissionInt) throws IOException
{    try {        SecureRandom rnd = new SecureRandom();        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");                encryptionKey = new byte[32];        rnd.nextBytes(encryptionKey);                byte[] userPasswordBytes = truncate127(userPassword.getBytes(Charsets.UTF_8));        byte[] userValidationSalt = new byte[8];        byte[] userKeySalt = new byte[8];        rnd.nextBytes(userValidationSalt);        rnd.nextBytes(userKeySalt);        byte[] hashU = computeHash2B(concat(userPasswordBytes, userValidationSalt), userPasswordBytes, null);        byte[] u = concat(hashU, userValidationSalt, userKeySalt);                byte[] hashUE = computeHash2B(concat(userPasswordBytes, userKeySalt), userPasswordBytes, null);        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(hashUE, "AES"),         new IvParameterSpec(new byte[16]));        byte[] ue = cipher.doFinal(encryptionKey);                byte[] ownerPasswordBytes = truncate127(ownerPassword.getBytes(Charsets.UTF_8));        byte[] ownerValidationSalt = new byte[8];        byte[] ownerKeySalt = new byte[8];        rnd.nextBytes(ownerValidationSalt);        rnd.nextBytes(ownerKeySalt);        byte[] hashO = computeHash2B(concat(ownerPasswordBytes, ownerValidationSalt, u), ownerPasswordBytes, u);        byte[] o = concat(hashO, ownerValidationSalt, ownerKeySalt);                byte[] hashOE = computeHash2B(concat(ownerPasswordBytes, ownerKeySalt, u), ownerPasswordBytes, u);        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(hashOE, "AES"),         new IvParameterSpec(new byte[16]));        byte[] oe = cipher.doFinal(encryptionKey);                encryptionDictionary.setUserKey(u);        encryptionDictionary.setUserEncryptionKey(ue);        encryptionDictionary.setOwnerKey(o);        encryptionDictionary.setOwnerEncryptionKey(oe);        prepareEncryptionDictAES(encryptionDictionary, COSName.AESV3);                byte[] perms = new byte[16];        perms[0] = (byte) permissionInt;        perms[1] = (byte) (permissionInt >>> 8);        perms[2] = (byte) (permissionInt >>> 16);        perms[3] = (byte) (permissionInt >>> 24);        perms[4] = (byte) 0xFF;        perms[5] = (byte) 0xFF;        perms[6] = (byte) 0xFF;        perms[7] = (byte) 0xFF;                perms[8] = 'T';        perms[9] = 'a';        perms[10] = 'd';        perms[11] = 'b';        for (int i = 12; i <= 15; i++) {            perms[i] = (byte) rnd.nextInt();        }        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptionKey, "AES"),         new IvParameterSpec(new byte[16]));        byte[] permsEnc = cipher.doFinal(perms);        encryptionDictionary.setPerms(permsEnc);    } catch (GeneralSecurityException e) {        logIfStrongEncryptionMissing();        throw new IOException(e);    }}
private void pdfbox_f4163_0(String ownerPassword, String userPassword, PDEncryption encryptionDictionary, int permissionInt, PDDocument document, int revision, int length) throws IOException
{    COSArray idArray = document.getDocument().getDocumentID();        if (idArray == null || idArray.size() < 2) {        MessageDigest md = MessageDigests.getMD5();        BigInteger time = BigInteger.valueOf(System.currentTimeMillis());        md.update(time.toByteArray());        md.update(ownerPassword.getBytes(Charsets.ISO_8859_1));        md.update(userPassword.getBytes(Charsets.ISO_8859_1));        md.update(document.getDocument().toString().getBytes(Charsets.ISO_8859_1));        byte[] id = md.digest(this.toString().getBytes(Charsets.ISO_8859_1));        COSString idString = new COSString(id);        idArray = new COSArray();        idArray.add(idString);        idArray.add(idString);        document.getDocument().setDocumentID(idArray);    }    COSString id = (COSString) idArray.getObject(0);    byte[] ownerBytes = computeOwnerPassword(ownerPassword.getBytes(Charsets.ISO_8859_1), userPassword.getBytes(Charsets.ISO_8859_1), revision, length);    byte[] userBytes = computeUserPassword(userPassword.getBytes(Charsets.ISO_8859_1), ownerBytes, permissionInt, id.getBytes(), revision, length, true);    encryptionKey = computeEncryptedKey(userPassword.getBytes(Charsets.ISO_8859_1), ownerBytes, null, null, null, permissionInt, id.getBytes(), revision, length, true, false);    encryptionDictionary.setOwnerKey(ownerBytes);    encryptionDictionary.setUserKey(userBytes);    if (revision == 4) {        prepareEncryptionDictAES(encryptionDictionary, COSName.AESV2);    }}
private void pdfbox_f4164_0(PDEncryption encryptionDictionary, COSName aesVName)
{    PDCryptFilterDictionary cryptFilterDictionary = new PDCryptFilterDictionary();    cryptFilterDictionary.setCryptFilterMethod(aesVName);    cryptFilterDictionary.setLength(keyLength);    encryptionDictionary.setStdCryptFilterDictionary(cryptFilterDictionary);    encryptionDictionary.setStreamFilterName(COSName.STD_CF);    encryptionDictionary.setStringFilterName(COSName.STD_CF);    setAES(true);}
public boolean pdfbox_f4165_0(byte[] ownerPassword, byte[] user, byte[] owner, int permissions, byte[] id, int encRevision, int keyLengthInBytes, boolean encryptMetadata) throws IOException
{    if (encRevision == 6 || encRevision == 5) {        byte[] truncatedOwnerPassword = truncate127(ownerPassword);        byte[] oHash = new byte[32];        byte[] oValidationSalt = new byte[8];        System.arraycopy(owner, 0, oHash, 0, 32);        System.arraycopy(owner, 32, oValidationSalt, 0, 8);        byte[] hash;        if (encRevision == 5) {            hash = computeSHA256(truncatedOwnerPassword, oValidationSalt, user);        } else {            hash = computeHash2A(truncatedOwnerPassword, oValidationSalt, user);        }        return Arrays.equals(hash, oHash);    } else {        byte[] userPassword = getUserPassword(ownerPassword, owner, encRevision, keyLengthInBytes);        return isUserPassword(userPassword, user, owner, permissions, id, encRevision, keyLengthInBytes, encryptMetadata);    }}
public byte[] pdfbox_f4166_0(byte[] ownerPassword, byte[] owner, int encRevision, int length) throws IOException
{    ByteArrayOutputStream result = new ByteArrayOutputStream();    byte[] rc4Key = computeRC4key(ownerPassword, encRevision, length);    if (encRevision == 2) {        encryptDataRC4(rc4Key, owner, result);    } else if (encRevision == 3 || encRevision == 4) {        byte[] iterationKey = new byte[rc4Key.length];        byte[] otemp = new byte[owner.length];        System.arraycopy(owner, 0, otemp, 0, owner.length);        for (int i = 19; i >= 0; i--) {            System.arraycopy(rc4Key, 0, iterationKey, 0, rc4Key.length);            for (int j = 0; j < iterationKey.length; j++) {                iterationKey[j] = (byte) (iterationKey[j] ^ (byte) i);            }            result.reset();            encryptDataRC4(iterationKey, otemp, result);            otemp = result.toByteArray();        }    }    return result.toByteArray();}
public byte[] pdfbox_f4167_0(byte[] password, byte[] o, byte[] u, byte[] oe, byte[] ue, int permissions, byte[] id, int encRevision, int keyLengthInBytes, boolean encryptMetadata, boolean isOwnerPassword) throws IOException
{    if (encRevision == 6 || encRevision == 5) {        return computeEncryptedKeyRev56(password, isOwnerPassword, o, u, oe, ue, encRevision);    } else {        return computeEncryptedKeyRev234(password, o, permissions, id, encryptMetadata, keyLengthInBytes, encRevision);    }}
private byte[] pdfbox_f4168_0(byte[] password, byte[] o, int permissions, byte[] id, boolean encryptMetadata, int length, int encRevision)
{            byte[] padded = truncateOrPad(password);    MessageDigest md = MessageDigests.getMD5();    md.update(padded);    md.update(o);    md.update((byte) permissions);    md.update((byte) (permissions >>> 8));    md.update((byte) (permissions >>> 16));    md.update((byte) (permissions >>> 24));    md.update(id);        if (encRevision == 4 && !encryptMetadata) {        md.update(new byte[] { (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff });    }    byte[] digest = md.digest();    if (encRevision == 3 || encRevision == 4) {        for (int i = 0; i < 50; i++) {            md.update(digest, 0, length);            digest = md.digest();        }    }    byte[] result = new byte[length];    System.arraycopy(digest, 0, result, 0, length);    return result;}
private byte[] pdfbox_f4169_0(byte[] password, boolean isOwnerPassword, byte[] o, byte[] u, byte[] oe, byte[] ue, int encRevision) throws IOException
{    byte[] hash, fileKeyEnc;    if (isOwnerPassword) {        byte[] oKeySalt = new byte[8];        System.arraycopy(o, 40, oKeySalt, 0, 8);        if (encRevision == 5) {            hash = computeSHA256(password, oKeySalt, u);        } else {            hash = computeHash2A(password, oKeySalt, u);        }        fileKeyEnc = oe;    } else {        byte[] uKeySalt = new byte[8];        System.arraycopy(u, 40, uKeySalt, 0, 8);        if (encRevision == 5) {            hash = computeSHA256(password, uKeySalt, null);        } else {            hash = computeHash2A(password, uKeySalt, null);        }        fileKeyEnc = ue;    }    try {        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(hash, "AES"), new IvParameterSpec(new byte[16]));        return cipher.doFinal(fileKeyEnc);    } catch (GeneralSecurityException e) {        logIfStrongEncryptionMissing();        throw new IOException(e);    }}
public byte[] pdfbox_f4170_0(byte[] password, byte[] owner, int permissions, byte[] id, int encRevision, int keyLengthInBytes, boolean encryptMetadata) throws IOException
{    ByteArrayOutputStream result = new ByteArrayOutputStream();    byte[] encKey = computeEncryptedKey(password, owner, null, null, null, permissions, id, encRevision, keyLengthInBytes, encryptMetadata, true);    if (encRevision == 2) {        encryptDataRC4(encKey, ENCRYPT_PADDING, result);    } else if (encRevision == 3 || encRevision == 4) {        MessageDigest md = MessageDigests.getMD5();        md.update(ENCRYPT_PADDING);        md.update(id);        result.write(md.digest());        byte[] iterationKey = new byte[encKey.length];        for (int i = 0; i < 20; i++) {            System.arraycopy(encKey, 0, iterationKey, 0, iterationKey.length);            for (int j = 0; j < iterationKey.length; j++) {                iterationKey[j] = (byte) (iterationKey[j] ^ i);            }            ByteArrayInputStream input = new ByteArrayInputStream(result.toByteArray());            result.reset();            encryptDataRC4(iterationKey, input, result);        }        byte[] finalResult = new byte[32];        System.arraycopy(result.toByteArray(), 0, finalResult, 0, 16);        System.arraycopy(ENCRYPT_PADDING, 0, finalResult, 16, 16);        result.reset();        result.write(finalResult);    }    return result.toByteArray();}
public byte[] pdfbox_f4171_0(byte[] ownerPassword, byte[] userPassword, int encRevision, int length) throws IOException
{    if (encRevision == 2 && length != 5) {        throw new IOException("Expected length=5 actual=" + length);    }    byte[] rc4Key = computeRC4key(ownerPassword, encRevision, length);    byte[] paddedUser = truncateOrPad(userPassword);    ByteArrayOutputStream encrypted = new ByteArrayOutputStream();    encryptDataRC4(rc4Key, new ByteArrayInputStream(paddedUser), encrypted);    if (encRevision == 3 || encRevision == 4) {        byte[] iterationKey = new byte[rc4Key.length];        for (int i = 1; i < 20; i++) {            System.arraycopy(rc4Key, 0, iterationKey, 0, rc4Key.length);            for (int j = 0; j < iterationKey.length; j++) {                iterationKey[j] = (byte) (iterationKey[j] ^ (byte) i);            }            ByteArrayInputStream input = new ByteArrayInputStream(encrypted.toByteArray());            encrypted.reset();            encryptDataRC4(iterationKey, input, encrypted);        }    }    return encrypted.toByteArray();}
private byte[] pdfbox_f4172_0(byte[] ownerPassword, int encRevision, int length)
{    MessageDigest md = MessageDigests.getMD5();    byte[] digest = md.digest(truncateOrPad(ownerPassword));    if (encRevision == 3 || encRevision == 4) {        for (int i = 0; i < 50; i++) {                                                md.update(digest, 0, length);            digest = md.digest();        }    }    byte[] rc4Key = new byte[length];    System.arraycopy(digest, 0, rc4Key, 0, length);    return rc4Key;}
private byte[] pdfbox_f4173_0(byte[] password)
{    byte[] padded = new byte[ENCRYPT_PADDING.length];    int bytesBeforePad = Math.min(password.length, padded.length);    System.arraycopy(password, 0, padded, 0, bytesBeforePad);    System.arraycopy(ENCRYPT_PADDING, 0, padded, bytesBeforePad, ENCRYPT_PADDING.length - bytesBeforePad);    return padded;}
public boolean pdfbox_f4174_0(byte[] password, byte[] user, byte[] owner, int permissions, byte[] id, int encRevision, int keyLengthInBytes, boolean encryptMetadata) throws IOException
{    switch(encRevision) {        case 2:        case 3:        case 4:            return isUserPassword234(password, user, owner, permissions, id, encRevision, keyLengthInBytes, encryptMetadata);        case 5:        case 6:            return isUserPassword56(password, user, encRevision);        default:            throw new IOException("Unknown Encryption Revision " + encRevision);    }}
private boolean pdfbox_f4175_0(byte[] password, byte[] user, byte[] owner, int permissions, byte[] id, int encRevision, int length, boolean encryptMetadata) throws IOException
{    byte[] passwordBytes = computeUserPassword(password, owner, permissions, id, encRevision, length, encryptMetadata);    if (encRevision == 2) {        return Arrays.equals(user, passwordBytes);    } else {                return Arrays.equals(Arrays.copyOf(user, 16), Arrays.copyOf(passwordBytes, 16));    }}
private boolean pdfbox_f4176_0(byte[] password, byte[] user, int encRevision) throws IOException
{    byte[] truncatedPassword = truncate127(password);    byte[] uHash = new byte[32];    byte[] uValidationSalt = new byte[8];    System.arraycopy(user, 0, uHash, 0, 32);    System.arraycopy(user, 32, uValidationSalt, 0, 8);    byte[] hash;    if (encRevision == 5) {        hash = computeSHA256(truncatedPassword, uValidationSalt, null);    } else {        hash = computeHash2A(truncatedPassword, uValidationSalt, null);    }    return Arrays.equals(hash, uHash);}
public boolean pdfbox_f4177_0(String password, byte[] user, byte[] owner, int permissions, byte[] id, int encRevision, int keyLengthInBytes, boolean encryptMetadata) throws IOException
{    if (encRevision == 6 || encRevision == 5) {        return isUserPassword(password.getBytes(Charsets.UTF_8), user, owner, permissions, id, encRevision, keyLengthInBytes, encryptMetadata);    } else {        return isUserPassword(password.getBytes(Charsets.ISO_8859_1), user, owner, permissions, id, encRevision, keyLengthInBytes, encryptMetadata);    }}
public boolean pdfbox_f4178_0(String password, byte[] user, byte[] owner, int permissions, byte[] id, int encRevision, int keyLengthInBytes, boolean encryptMetadata) throws IOException
{    return isOwnerPassword(password.getBytes(Charsets.ISO_8859_1), user, owner, permissions, id, encRevision, keyLengthInBytes, encryptMetadata);}
private byte[] pdfbox_f4179_0(byte[] password, byte[] salt, byte[] u) throws IOException
{    byte[] userKey;    if (u == null) {        userKey = new byte[0];    } else if (u.length < 48) {        throw new IOException("Bad U length");    } else if (u.length > 48) {                userKey = new byte[48];        System.arraycopy(u, 0, userKey, 0, 48);    } else {        userKey = u;    }    byte[] truncatedPassword = truncate127(password);    byte[] input = concat(truncatedPassword, salt, userKey);    return computeHash2B(input, truncatedPassword, userKey);}
private static byte[] pdfbox_f4180_0(byte[] input, byte[] password, byte[] userKey) throws IOException
{    try {        MessageDigest md = MessageDigest.getInstance("SHA-256");        byte[] k = md.digest(input);        byte[] e = null;        for (int round = 0; round < 64 || ((int) e[e.length - 1] & 0xFF) > round - 32; round++) {            byte[] k1;            if (userKey != null && userKey.length >= 48) {                k1 = new byte[64 * (password.length + k.length + 48)];            } else {                k1 = new byte[64 * (password.length + k.length)];            }            int pos = 0;            for (int i = 0; i < 64; i++) {                System.arraycopy(password, 0, k1, pos, password.length);                pos += password.length;                System.arraycopy(k, 0, k1, pos, k.length);                pos += k.length;                if (userKey != null && userKey.length >= 48) {                    System.arraycopy(userKey, 0, k1, pos, 48);                    pos += 48;                }            }            byte[] kFirst = new byte[16];            byte[] kSecond = new byte[16];            System.arraycopy(k, 0, kFirst, 0, 16);            System.arraycopy(k, 16, kSecond, 0, 16);            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");            SecretKeySpec keySpec = new SecretKeySpec(kFirst, "AES");            IvParameterSpec ivSpec = new IvParameterSpec(kSecond);            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);            e = cipher.doFinal(k1);            byte[] eFirst = new byte[16];            System.arraycopy(e, 0, eFirst, 0, 16);            BigInteger bi = new BigInteger(1, eFirst);            BigInteger remainder = bi.mod(new BigInteger("3"));            String nextHash = HASHES_2B[remainder.intValue()];            md = MessageDigest.getInstance(nextHash);            k = md.digest(e);        }        if (k.length > 32) {            byte[] kTrunc = new byte[32];            System.arraycopy(k, 0, kTrunc, 0, 32);            return kTrunc;        } else {            return k;        }    } catch (GeneralSecurityException e) {        logIfStrongEncryptionMissing();        throw new IOException(e);    }}
private static byte[] pdfbox_f4181_0(byte[] input, byte[] password, byte[] userKey) throws IOException
{    try {        MessageDigest md = MessageDigest.getInstance("SHA-256");        md.update(input);        md.update(password);        return userKey == null ? md.digest() : md.digest(userKey);    } catch (NoSuchAlgorithmException e) {        throw new IOException(e);    }}
private static byte[] pdfbox_f4182_0(byte[] a, byte[] b)
{    byte[] o = new byte[a.length + b.length];    System.arraycopy(a, 0, o, 0, a.length);    System.arraycopy(b, 0, o, a.length, b.length);    return o;}
private static byte[] pdfbox_f4183_0(byte[] a, byte[] b, byte[] c)
{    byte[] o = new byte[a.length + b.length + c.length];    System.arraycopy(a, 0, o, 0, a.length);    System.arraycopy(b, 0, o, a.length, b.length);    System.arraycopy(c, 0, o, a.length + b.length, c.length);    return o;}
private static byte[] pdfbox_f4184_0(byte[] in)
{    if (in.length <= 127) {        return in;    }    byte[] trunc = new byte[127];    System.arraycopy(in, 0, trunc, 0, 127);    return trunc;}
private static void pdfbox_f4185_1()
{    try {        if (Cipher.getMaxAllowedKeyLength("AES") != Integer.MAX_VALUE) {                    }    } catch (NoSuchAlgorithmException ex) {            }}
public boolean pdfbox_f4186_0()
{    return policy != null;}
public static FDFAnnotation pdfbox_f4187_1(COSDictionary fdfDic) throws IOException
{    FDFAnnotation retval = null;    if (fdfDic != null) {        if (FDFAnnotationText.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationText(fdfDic);        } else if (FDFAnnotationCaret.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationCaret(fdfDic);        } else if (FDFAnnotationFreeText.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationFreeText(fdfDic);        } else if (FDFAnnotationFileAttachment.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationFileAttachment(fdfDic);        } else if (FDFAnnotationHighlight.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationHighlight(fdfDic);        } else if (FDFAnnotationInk.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationInk(fdfDic);        } else if (FDFAnnotationLine.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationLine(fdfDic);        } else if (FDFAnnotationLink.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationLink(fdfDic);        } else if (FDFAnnotationCircle.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationCircle(fdfDic);        } else if (FDFAnnotationSquare.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationSquare(fdfDic);        } else if (FDFAnnotationPolygon.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationPolygon(fdfDic);        } else if (FDFAnnotationPolyline.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationPolyline(fdfDic);        } else if (FDFAnnotationSound.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationSound(fdfDic);        } else if (FDFAnnotationSquiggly.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationSquiggly(fdfDic);        } else if (FDFAnnotationStamp.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationStamp(fdfDic);        } else if (FDFAnnotationStrikeOut.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationStrikeOut(fdfDic);        } else if (FDFAnnotationUnderline.SUBTYPE.equals(fdfDic.getNameAsString(COSName.SUBTYPE))) {            retval = new FDFAnnotationUnderline(fdfDic);        } else {                    }    }    return retval;}
public COSDictionary pdfbox_f4188_0()
{    return annot;}
public Integer pdfbox_f4189_0()
{    Integer retval = null;    COSNumber page = (COSNumber) annot.getDictionaryObject(COSName.PAGE);    if (page != null) {        retval = page.intValue();    }    return retval;}
public final void pdfbox_f4190_0(int page)
{    annot.setInt(COSName.PAGE, page);}
public Color pdfbox_f4191_0()
{    Color retval = null;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.C);    if (array != null) {        float[] rgb = array.toFloatArray();        if (rgb.length >= 3) {            retval = new Color(rgb[0], rgb[1], rgb[2]);        }    }    return retval;}
public final void pdfbox_f4192_0(Color c)
{    COSArray color = null;    if (c != null) {        float[] colors = c.getRGBColorComponents(null);        color = new COSArray();        color.setFloatArray(colors);    }    annot.setItem(COSName.C, color);}
public String pdfbox_f4193_0()
{    return annot.getString(COSName.M);}
public final void pdfbox_f4194_0(String date)
{    annot.setString(COSName.M, date);}
public boolean pdfbox_f4195_0()
{    return annot.getFlag(COSName.F, FLAG_INVISIBLE);}
public final void pdfbox_f4196_0(boolean invisible)
{    annot.setFlag(COSName.F, FLAG_INVISIBLE, invisible);}
public boolean pdfbox_f4197_0()
{    return annot.getFlag(COSName.F, FLAG_HIDDEN);}
public final void pdfbox_f4198_0(boolean hidden)
{    annot.setFlag(COSName.F, FLAG_HIDDEN, hidden);}
public boolean pdfbox_f4199_0()
{    return annot.getFlag(COSName.F, FLAG_PRINTED);}
public final void pdfbox_f4200_0(boolean printed)
{    annot.setFlag(COSName.F, FLAG_PRINTED, printed);}
public boolean pdfbox_f4201_0()
{    return annot.getFlag(COSName.F, FLAG_NO_ZOOM);}
public final void pdfbox_f4202_0(boolean noZoom)
{    annot.setFlag(COSName.F, FLAG_NO_ZOOM, noZoom);}
public boolean pdfbox_f4203_0()
{    return annot.getFlag(COSName.F, FLAG_NO_ROTATE);}
public final void pdfbox_f4204_0(boolean noRotate)
{    annot.setFlag(COSName.F, FLAG_NO_ROTATE, noRotate);}
public boolean pdfbox_f4205_0()
{    return annot.getFlag(COSName.F, FLAG_NO_VIEW);}
public final void pdfbox_f4206_0(boolean noView)
{    annot.setFlag(COSName.F, FLAG_NO_VIEW, noView);}
public boolean pdfbox_f4207_0()
{    return annot.getFlag(COSName.F, FLAG_READ_ONLY);}
public final void pdfbox_f4208_0(boolean readOnly)
{    annot.setFlag(COSName.F, FLAG_READ_ONLY, readOnly);}
public boolean pdfbox_f4209_0()
{    return annot.getFlag(COSName.F, FLAG_LOCKED);}
public final void pdfbox_f4210_0(boolean locked)
{    annot.setFlag(COSName.F, FLAG_LOCKED, locked);}
public boolean pdfbox_f4211_0()
{    return annot.getFlag(COSName.F, FLAG_TOGGLE_NO_VIEW);}
public final void pdfbox_f4212_0(boolean toggleNoView)
{    annot.setFlag(COSName.F, FLAG_TOGGLE_NO_VIEW, toggleNoView);}
public final void pdfbox_f4213_0(String name)
{    annot.setString(COSName.NM, name);}
public String pdfbox_f4214_0()
{    return annot.getString(COSName.NM);}
public final void pdfbox_f4215_0(PDRectangle rectangle)
{    annot.setItem(COSName.RECT, rectangle);}
public PDRectangle pdfbox_f4216_0()
{    PDRectangle retval = null;    COSArray rectArray = (COSArray) annot.getDictionaryObject(COSName.RECT);    if (rectArray != null) {        retval = new PDRectangle(rectArray);    }    return retval;}
public final void pdfbox_f4217_0(String contents)
{    annot.setString(COSName.CONTENTS, contents);}
public String pdfbox_f4218_0()
{    return annot.getString(COSName.CONTENTS);}
public final void pdfbox_f4219_0(String title)
{    annot.setString(COSName.T, title);}
public String pdfbox_f4220_0()
{    return annot.getString(COSName.T);}
public Calendar pdfbox_f4221_0() throws IOException
{    return annot.getDate(COSName.CREATION_DATE);}
public final void pdfbox_f4222_0(Calendar date)
{    annot.setDate(COSName.CREATION_DATE, date);}
public final void pdfbox_f4223_0(float opacity)
{    annot.setFloat(COSName.CA, opacity);}
public float pdfbox_f4224_0()
{    return annot.getFloat(COSName.CA, 1f);}
public final void pdfbox_f4225_0(String subject)
{    annot.setString(COSName.SUBJ, subject);}
public String pdfbox_f4226_0()
{    return annot.getString(COSName.SUBJ);}
public final void pdfbox_f4227_0(String intent)
{    annot.setName(COSName.IT, intent);}
public String pdfbox_f4228_0()
{    return annot.getNameAsString(COSName.IT);}
public String pdfbox_f4229_0()
{    return getStringOrStream(annot.getDictionaryObject(COSName.RC));}
public final void pdfbox_f4230_0(String rc)
{    annot.setItem(COSName.RC, new COSString(rc));}
public final void pdfbox_f4231_0(PDBorderStyleDictionary bs)
{    annot.setItem(COSName.BS, bs);}
public PDBorderStyleDictionary pdfbox_f4232_0()
{    COSDictionary bs = (COSDictionary) annot.getDictionaryObject(COSName.BS);    if (bs != null) {        return new PDBorderStyleDictionary(bs);    } else {        return null;    }}
public final void pdfbox_f4233_0(PDBorderEffectDictionary be)
{    annot.setItem(COSName.BE, be);}
public PDBorderEffectDictionary pdfbox_f4234_0()
{    COSDictionary be = (COSDictionary) annot.getDictionaryObject(COSName.BE);    if (be != null) {        return new PDBorderEffectDictionary(be);    } else {        return null;    }}
protected final String pdfbox_f4235_0(COSBase base)
{    if (base == null) {        return "";    } else if (base instanceof COSString) {        return ((COSString) base).getString();    } else if (base instanceof COSStream) {        return ((COSStream) base).toTextString();    } else {        return "";    }}
private String pdfbox_f4236_0(Node node, boolean root)
{    String subString = "";    NodeList nodelist = node.getChildNodes();    for (int i = 0; i < nodelist.getLength(); i++) {        Node child = nodelist.item(i);        if (child instanceof Element) {            subString += richContentsToString(child, false);        } else if (child instanceof CDATASection) {            subString += "<![CDATA[" + ((CDATASection) child).getData() + "]]>";        } else if (child instanceof Text) {            String cdata = ((Text) child).getData();            if (cdata != null) {                cdata = cdata.replace("&", "&amp;").replace("<", "&lt;");            }            subString += cdata;        }    }    if (root) {        return subString;    }    NamedNodeMap attributes = node.getAttributes();    StringBuilder builder = new StringBuilder();    for (int i = 0; i < attributes.getLength(); i++) {        Node attribute = attributes.item(i);        String attributeNodeValue = attribute.getNodeValue();        if (attributeNodeValue != null) {            attributeNodeValue = attributeNodeValue.replace("\"", "&quot;");        }        builder.append(String.format(" %s=\"%s\"", attribute.getNodeName(), attributeNodeValue));    }    return String.format("<%s%s>%s</%s>", node.getNodeName(), builder.toString(), subString, node.getNodeName());}
private void pdfbox_f4237_0(Element element) throws IOException
{    String fringe = element.getAttribute("fringe");    if (fringe != null && !fringe.isEmpty()) {        String[] fringeValues = fringe.split(",");        if (fringeValues.length != 4) {            throw new IOException("Error: wrong amount of numbers in attribute 'fringe'");        }        PDRectangle rect = new PDRectangle();        rect.setLowerLeftX(Float.parseFloat(fringeValues[0]));        rect.setLowerLeftY(Float.parseFloat(fringeValues[1]));        rect.setUpperRightX(Float.parseFloat(fringeValues[2]));        rect.setUpperRightY(Float.parseFloat(fringeValues[3]));        setFringe(rect);    }}
public final void pdfbox_f4238_0(PDRectangle fringe)
{    annot.setItem(COSName.RD, fringe);}
public PDRectangle pdfbox_f4239_0()
{    COSArray rd = (COSArray) annot.getDictionaryObject(COSName.RD);    if (rd != null) {        return new PDRectangle(rd);    } else {        return null;    }}
public final void pdfbox_f4240_0(String symbol)
{    String newSymbol = "None";    if ("paragraph".equals(symbol)) {        newSymbol = "P";    }    annot.setString(COSName.SY, newSymbol);}
public String pdfbox_f4241_0()
{    return annot.getString(COSName.SY);}
private void pdfbox_f4242_0(Element element) throws IOException
{    String fringe = element.getAttribute("fringe");    if (fringe != null && !fringe.isEmpty()) {        String[] fringeValues = fringe.split(",");        if (fringeValues.length != 4) {            throw new IOException("Error: wrong amount of numbers in attribute 'fringe'");        }        PDRectangle rect = new PDRectangle();        rect.setLowerLeftX(Float.parseFloat(fringeValues[0]));        rect.setLowerLeftY(Float.parseFloat(fringeValues[1]));        rect.setUpperRightX(Float.parseFloat(fringeValues[2]));        rect.setUpperRightY(Float.parseFloat(fringeValues[3]));        setFringe(rect);    }}
public final void pdfbox_f4243_0(Color color)
{    COSArray array = null;    if (color != null) {        float[] colors = color.getRGBColorComponents(null);        array = new COSArray();        array.setFloatArray(colors);    }    annot.setItem(COSName.IC, array);}
public Color pdfbox_f4244_0()
{    Color retval = null;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.IC);    if (array != null) {        float[] rgb = array.toFloatArray();        if (rgb.length >= 3) {            retval = new Color(rgb[0], rgb[1], rgb[2]);        }    }    return retval;}
public final void pdfbox_f4245_0(PDRectangle fringe)
{    annot.setItem(COSName.RD, fringe);}
public PDRectangle pdfbox_f4246_0()
{    COSArray rd = (COSArray) annot.getDictionaryObject(COSName.RD);    if (rd != null) {        return new PDRectangle(rd);    } else {        return null;    }}
private void pdfbox_f4247_0(Element element) throws IOException
{    String fringe = element.getAttribute("fringe");    if (fringe != null && !fringe.isEmpty()) {        String[] fringeValues = fringe.split(",");        if (fringeValues.length != 4) {            throw new IOException("Error: wrong amount of numbers in attribute 'fringe'");        }        PDRectangle rect = new PDRectangle();        rect.setLowerLeftX(Float.parseFloat(fringeValues[0]));        rect.setLowerLeftY(Float.parseFloat(fringeValues[1]));        rect.setUpperRightX(Float.parseFloat(fringeValues[2]));        rect.setUpperRightY(Float.parseFloat(fringeValues[3]));        setFringe(rect);    }}
private void pdfbox_f4248_0(Element element) throws IOException
{    String callout = element.getAttribute("callout");    if (callout != null && !callout.isEmpty()) {        String[] calloutValues = callout.split(",");        float[] values = new float[calloutValues.length];        for (int i = 0; i < calloutValues.length; i++) {            values[i] = Float.parseFloat(calloutValues[i]);        }        setCallout(values);    }}
public final void pdfbox_f4249_0(float[] callout)
{    COSArray newCallout = new COSArray();    newCallout.setFloatArray(callout);    annot.setItem(COSName.CL, newCallout);}
public float[] pdfbox_f4250_0()
{    COSArray array = (COSArray) annot.getDictionaryObject(COSName.CL);    if (array != null) {        return array.toFloatArray();    } else {        return null;    }}
public final void pdfbox_f4251_0(String justification)
{    int quadding = 0;    if ("centered".equals(justification)) {        quadding = 1;    } else if ("right".equals(justification)) {        quadding = 2;    }    annot.setInt(COSName.Q, quadding);}
public String pdfbox_f4252_0()
{    return "" + annot.getInt(COSName.Q, 0);}
public final void pdfbox_f4253_0(int rotation)
{    annot.setInt(COSName.ROTATE, rotation);}
public String pdfbox_f4254_0()
{    return annot.getString(COSName.ROTATE);}
public final void pdfbox_f4255_0(String appearance)
{    annot.setString(COSName.DA, appearance);}
public String pdfbox_f4256_0()
{    return annot.getString(COSName.DA);}
public final void pdfbox_f4257_0(String style)
{    annot.setString(COSName.DS, style);}
public String pdfbox_f4258_0()
{    return annot.getString(COSName.DS);}
public final void pdfbox_f4259_0(PDRectangle fringe)
{    annot.setItem(COSName.RD, fringe);}
public PDRectangle pdfbox_f4260_0()
{    COSArray rd = (COSArray) annot.getDictionaryObject(COSName.RD);    if (rd != null) {        return new PDRectangle(rd);    } else {        return null;    }}
public final void pdfbox_f4261_0(String style)
{    annot.setName(COSName.LE, style);}
public String pdfbox_f4262_0()
{    return annot.getNameAsString(COSName.LE);}
public final void pdfbox_f4263_0(List<float[]> inklist)
{    COSArray newInklist = new COSArray();    for (float[] array : inklist) {        COSArray newArray = new COSArray();        newArray.setFloatArray(array);        newInklist.add(newArray);    }    annot.setItem(COSName.INKLIST, newInklist);}
public List<float[]> pdfbox_f4264_0()
{    COSArray array = (COSArray) annot.getDictionaryObject(COSName.INKLIST);    if (array != null) {        List<float[]> retval = new ArrayList<>();        for (COSBase entry : array) {            retval.add(((COSArray) entry).toFloatArray());        }        return retval;    } else {                return null;    }}
public final void pdfbox_f4265_0(float[] line)
{    COSArray newLine = new COSArray();    newLine.setFloatArray(line);    annot.setItem(COSName.L, newLine);}
public float[] pdfbox_f4266_0()
{    COSArray array = (COSArray) annot.getDictionaryObject(COSName.L);    if (array != null) {        return array.toFloatArray();    } else {                return null;    }}
public final void pdfbox_f4267_0(String style)
{    String actualStyle = style == null ? PDAnnotationLine.LE_NONE : style;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.LE);    if (array == null) {        array = new COSArray();        array.add(COSName.getPDFName(actualStyle));        array.add(COSName.getPDFName(PDAnnotationLine.LE_NONE));        annot.setItem(COSName.LE, array);    } else {        array.setName(0, actualStyle);    }}
public String pdfbox_f4268_0()
{    String retval = PDAnnotationLine.LE_NONE;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.LE);    if (array != null) {        retval = array.getName(0);    }    return retval;}
public final void pdfbox_f4269_0(String style)
{    String actualStyle = style == null ? PDAnnotationLine.LE_NONE : style;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.LE);    if (array == null) {        array = new COSArray();        array.add(COSName.getPDFName(PDAnnotationLine.LE_NONE));        array.add(COSName.getPDFName(actualStyle));        annot.setItem(COSName.LE, array);    } else {        array.setName(1, actualStyle);    }}
public String pdfbox_f4270_0()
{    String retval = PDAnnotationLine.LE_NONE;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.LE);    if (array != null) {        retval = array.getName(1);    }    return retval;}
public final void pdfbox_f4271_0(Color color)
{    COSArray array = null;    if (color != null) {        float[] colors = color.getRGBColorComponents(null);        array = new COSArray();        array.setFloatArray(colors);    }    annot.setItem(COSName.IC, array);}
public Color pdfbox_f4272_0()
{    Color retval = null;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.IC);    if (array != null) {        float[] rgb = array.toFloatArray();        if (rgb.length >= 3) {            retval = new Color(rgb[0], rgb[1], rgb[2]);        }    }    return retval;}
public final void pdfbox_f4273_0(boolean cap)
{    annot.setBoolean(COSName.CAP, cap);}
public boolean pdfbox_f4274_0()
{    return annot.getBoolean(COSName.CAP, false);}
public float pdfbox_f4275_0()
{    return annot.getFloat(COSName.LL);}
public final void pdfbox_f4276_0(float leaderLength)
{    annot.setFloat(COSName.LL, leaderLength);}
public float pdfbox_f4277_0()
{    return annot.getFloat(COSName.LLE);}
public final void pdfbox_f4278_0(float leaderExtend)
{    annot.setFloat(COSName.LLE, leaderExtend);}
public float pdfbox_f4279_0()
{    return annot.getFloat(COSName.LLO);}
public final void pdfbox_f4280_0(float leaderOffset)
{    annot.setFloat(COSName.LLO, leaderOffset);}
public String pdfbox_f4281_0()
{    return annot.getString(COSName.CP);}
public final void pdfbox_f4282_0(String captionStyle)
{    annot.setString(COSName.CP, captionStyle);}
public final void pdfbox_f4283_0(float offset)
{    COSArray array = (COSArray) annot.getDictionaryObject(COSName.CO);    if (array == null) {        array = new COSArray();        array.setFloatArray(new float[] { offset, 0.f });        annot.setItem(COSName.CO, array);    } else {        array.set(0, new COSFloat(offset));    }}
public float pdfbox_f4284_0()
{    float retval = 0.f;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.CO);    if (array != null) {        retval = array.toFloatArray()[0];    }    return retval;}
public final void pdfbox_f4285_0(float offset)
{    COSArray array = (COSArray) annot.getDictionaryObject(COSName.CO);    if (array == null) {        array = new COSArray();        array.setFloatArray(new float[] { 0.f, offset });        annot.setItem(COSName.CO, array);    } else {        array.set(1, new COSFloat(offset));    }}
public float pdfbox_f4286_0()
{    float retval = 0.f;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.CO);    if (array != null) {        retval = array.toFloatArray()[1];    }    return retval;}
private void pdfbox_f4287_1(Element element) throws IOException
{    XPath xpath = XPathFactory.newInstance().newXPath();    try {        String vertices = xpath.evaluate("vertices", element);        if (vertices == null || vertices.isEmpty()) {            throw new IOException("Error: missing element 'vertices'");        }        String[] verticesValues = vertices.split(",|;");        float[] values = new float[verticesValues.length];        for (int i = 0; i < verticesValues.length; i++) {            values[i] = Float.parseFloat(verticesValues[i]);        }        setVertices(values);    } catch (XPathExpressionException e) {            }}
public final void pdfbox_f4288_0(float[] vertices)
{    COSArray newVertices = new COSArray();    newVertices.setFloatArray(vertices);    annot.setItem(COSName.VERTICES, newVertices);}
public float[] pdfbox_f4289_0()
{    COSArray array = (COSArray) annot.getDictionaryObject(COSName.VERTICES);    if (array != null) {        return array.toFloatArray();    } else {                return null;    }}
public final void pdfbox_f4290_0(Color color)
{    COSArray array = null;    if (color != null) {        float[] colors = color.getRGBColorComponents(null);        array = new COSArray();        array.setFloatArray(colors);    }    annot.setItem(COSName.IC, array);}
public Color pdfbox_f4291_0()
{    Color retval = null;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.IC);    if (array != null) {        float[] rgb = array.toFloatArray();        if (rgb.length >= 3) {            retval = new Color(rgb[0], rgb[1], rgb[2]);        }    }    return retval;}
private void pdfbox_f4292_1(Element element) throws IOException
{    XPath xpath = XPathFactory.newInstance().newXPath();    try {        String vertices = xpath.evaluate("vertices[1]", element);        if (vertices == null || vertices.isEmpty()) {            throw new IOException("Error: missing element 'vertices'");        }        String[] verticesValues = vertices.split(",|;");        float[] values = new float[verticesValues.length];        for (int i = 0; i < verticesValues.length; i++) {            values[i] = Float.parseFloat(verticesValues[i]);        }        setVertices(values);    } catch (XPathExpressionException e) {            }}
private void pdfbox_f4293_0(Element element)
{    String startStyle = element.getAttribute("head");    if (startStyle != null && !startStyle.isEmpty()) {        setStartPointEndingStyle(startStyle);    }    String endStyle = element.getAttribute("tail");    if (endStyle != null && !endStyle.isEmpty()) {        setEndPointEndingStyle(endStyle);    }    String color = element.getAttribute("interior-color");    if (color != null && color.length() == 7 && color.charAt(0) == '#') {        int colorValue = Integer.parseInt(color.substring(1, 7), 16);        setInteriorColor(new Color(colorValue));    }}
public void pdfbox_f4294_0(float[] vertices)
{    COSArray newVertices = new COSArray();    newVertices.setFloatArray(vertices);    annot.setItem(COSName.VERTICES, newVertices);}
public float[] pdfbox_f4295_0()
{    COSArray array = (COSArray) annot.getDictionaryObject(COSName.VERTICES);    if (array != null) {        return array.toFloatArray();    } else {                return null;    }}
public void pdfbox_f4296_0(String style)
{    String actualStyle = style == null ? PDAnnotationLine.LE_NONE : style;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.LE);    if (array == null) {        array = new COSArray();        array.add(COSName.getPDFName(actualStyle));        array.add(COSName.getPDFName(PDAnnotationLine.LE_NONE));        annot.setItem(COSName.LE, array);    } else {        array.setName(0, actualStyle);    }}
public String pdfbox_f4297_0()
{    String retval = PDAnnotationLine.LE_NONE;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.LE);    if (array != null) {        retval = array.getName(0);    }    return retval;}
public void pdfbox_f4298_0(String style)
{    String actualStyle = style == null ? PDAnnotationLine.LE_NONE : style;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.LE);    if (array == null) {        array = new COSArray();        array.add(COSName.getPDFName(PDAnnotationLine.LE_NONE));        array.add(COSName.getPDFName(actualStyle));        annot.setItem(COSName.LE, array);    } else {        array.setName(1, actualStyle);    }}
public String pdfbox_f4299_0()
{    String retval = PDAnnotationLine.LE_NONE;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.LE);    if (array != null) {        retval = array.getName(1);    }    return retval;}
public void pdfbox_f4300_0(Color color)
{    COSArray array = null;    if (color != null) {        float[] colors = color.getRGBColorComponents(null);        array = new COSArray();        array.setFloatArray(colors);    }    annot.setItem(COSName.IC, array);}
public Color pdfbox_f4301_0()
{    Color retval = null;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.IC);    if (array != null) {        float[] rgb = array.toFloatArray();        if (rgb.length >= 3) {            retval = new Color(rgb[0], rgb[1], rgb[2]);        }    }    return retval;}
private void pdfbox_f4302_0(Element element) throws IOException
{    String fringe = element.getAttribute("fringe");    if (fringe != null && !fringe.isEmpty()) {        String[] fringeValues = fringe.split(",");        if (fringeValues.length != 4) {            throw new IOException("Error: wrong amount of numbers in attribute 'fringe'");        }        PDRectangle rect = new PDRectangle();        rect.setLowerLeftX(Float.parseFloat(fringeValues[0]));        rect.setLowerLeftY(Float.parseFloat(fringeValues[1]));        rect.setUpperRightX(Float.parseFloat(fringeValues[2]));        rect.setUpperRightY(Float.parseFloat(fringeValues[3]));        setFringe(rect);    }}
public final void pdfbox_f4303_0(Color color)
{    COSArray array = null;    if (color != null) {        float[] colors = color.getRGBColorComponents(null);        array = new COSArray();        array.setFloatArray(colors);    }    annot.setItem(COSName.IC, array);}
public Color pdfbox_f4304_0()
{    Color retval = null;    COSArray array = (COSArray) annot.getDictionaryObject(COSName.IC);    if (array != null) {        float[] rgb = array.toFloatArray();        if (rgb.length >= 3) {            retval = new Color(rgb[0], rgb[1], rgb[2]);        }    }    return retval;}
public final void pdfbox_f4305_0(PDRectangle fringe)
{    annot.setItem(COSName.RD, fringe);}
public PDRectangle pdfbox_f4306_0()
{    COSArray rd = (COSArray) annot.getDictionaryObject(COSName.RD);    if (rd != null) {        return new PDRectangle(rd);    } else {        return null;    }}
private COSDictionary pdfbox_f4307_1(Element appearanceXML) throws IOException
{    COSDictionary dictionary = new COSDictionary();        dictionary.setItem(COSName.N, new COSStream());        NodeList nodeList = appearanceXML.getChildNodes();    String parentAttrKey = appearanceXML.getAttribute("KEY");            if (!"AP".equals(appearanceXML.getAttribute("KEY"))) {                return dictionary;    }    for (int i = 0; i < nodeList.getLength(); i++) {        Node node = nodeList.item(i);        if (node instanceof Element) {            Element child = (Element) node;            if ("STREAM".equalsIgnoreCase(child.getTagName())) {                                dictionary.setItem(child.getAttribute("KEY"), parseStreamElement(child));                            } else {                            }        }    }    return dictionary;}
private COSStream pdfbox_f4308_1(Element streamEl) throws IOException
{        COSStream stream = new COSStream();    NodeList nodeList = streamEl.getChildNodes();    String parentAttrKey = streamEl.getAttribute("KEY");    for (int i = 0; i < nodeList.getLength(); i++) {        Node node = nodeList.item(i);        if (node instanceof Element) {            Element child = (Element) node;            String childAttrKey = child.getAttribute("KEY");            String childAttrVal = child.getAttribute("VAL");                        if ("INT".equalsIgnoreCase(child.getTagName())) {                if (!"Length".equals(childAttrKey)) {                    stream.setInt(COSName.getPDFName(childAttrKey), Integer.parseInt(childAttrVal));                                    }            } else if ("FIXED".equalsIgnoreCase(child.getTagName())) {                stream.setFloat(COSName.getPDFName(childAttrKey), Float.parseFloat(childAttrVal));                            } else if ("NAME".equalsIgnoreCase(child.getTagName())) {                stream.setName(COSName.getPDFName(childAttrKey), childAttrVal);                            } else if ("BOOL".equalsIgnoreCase(child.getTagName())) {                stream.setBoolean(COSName.getPDFName(childAttrKey), Boolean.parseBoolean(childAttrVal));                            } else if ("ARRAY".equalsIgnoreCase(child.getTagName())) {                stream.setItem(COSName.getPDFName(childAttrKey), parseArrayElement(child));                            } else if ("DICT".equalsIgnoreCase(child.getTagName())) {                stream.setItem(COSName.getPDFName(childAttrKey), parseDictElement(child));                            } else if ("STREAM".equalsIgnoreCase(child.getTagName())) {                stream.setItem(COSName.getPDFName(childAttrKey), parseStreamElement(child));                            } else if ("DATA".equalsIgnoreCase(child.getTagName())) {                                if ("HEX".equals(child.getAttribute("ENCODING"))) {                    try (OutputStream os = stream.createRawOutputStream()) {                        os.write(Hex.decodeHex(child.getTextContent()));                                            }                } else if ("ASCII".equals(child.getAttribute("ENCODING"))) {                    try (OutputStream os = stream.createOutputStream()) {                                                os.write(child.getTextContent().getBytes());                                            }                } else {                                    }            } else {                            }        }    }    return stream;}
private COSArray pdfbox_f4309_1(Element arrayEl) throws IOException
{        COSArray array = new COSArray();    NodeList nodeList = arrayEl.getChildNodes();    String parentAttrKey = arrayEl.getAttribute("KEY");    if ("BBox".equals(parentAttrKey)) {        if (nodeList.getLength() < 4) {            throw new IOException("BBox does not have enough coordinates, only has: " + nodeList.getLength());        }    } else if ("Matrix".equals(parentAttrKey)) {        if (nodeList.getLength() < 6) {            throw new IOException("Matrix does not have enough coordinates, only has: " + nodeList.getLength());        }    }    for (int i = 0; i < nodeList.getLength(); i++) {        Node node = nodeList.item(i);        if (node instanceof Element) {            Element child = (Element) node;            String childAttrKey = child.getAttribute("KEY");            String childAttrVal = child.getAttribute("VAL");                        if ("INT".equalsIgnoreCase(child.getTagName())) {                                array.add(COSFloat.get(childAttrVal));            } else if ("FIXED".equalsIgnoreCase(child.getTagName())) {                                array.add(COSInteger.get(childAttrVal));            } else if ("NAME".equalsIgnoreCase(child.getTagName())) {                                array.add(COSName.getPDFName(childAttrVal));            } else if ("BOOL".equalsIgnoreCase(child.getTagName())) {                                array.add(COSBoolean.getBoolean(Boolean.parseBoolean(childAttrVal)));            } else if ("DICT".equalsIgnoreCase(child.getTagName())) {                                array.add(parseDictElement(child));            } else if ("STREAM".equalsIgnoreCase(child.getTagName())) {                                array.add(parseStreamElement(child));            } else if ("ARRAY".equalsIgnoreCase(child.getTagName())) {                                array.add(parseArrayElement(child));            } else {                            }        }    }    return array;}
private COSDictionary pdfbox_f4310_1(Element dictEl) throws IOException
{        COSDictionary dict = new COSDictionary();    NodeList nodeList = dictEl.getChildNodes();    String parentAttrKey = dictEl.getAttribute("KEY");    for (int i = 0; i < nodeList.getLength(); i++) {        Node node = nodeList.item(i);        if (node instanceof Element) {            Element child = (Element) node;            String childAttrKey = child.getAttribute("KEY");            String childAttrVal = child.getAttribute("VAL");            if ("DICT".equals(child.getTagName())) {                                dict.setItem(COSName.getPDFName(childAttrKey), parseDictElement(child));                            } else if ("STREAM".equals(child.getTagName())) {                                dict.setItem(COSName.getPDFName(childAttrKey), parseStreamElement(child));            } else if ("NAME".equals(child.getTagName())) {                                dict.setName(COSName.getPDFName(childAttrKey), childAttrVal);                            } else if ("INT".equalsIgnoreCase(child.getTagName())) {                dict.setInt(COSName.getPDFName(childAttrKey), Integer.parseInt(childAttrVal));                            } else if ("FIXED".equalsIgnoreCase(child.getTagName())) {                dict.setFloat(COSName.getPDFName(childAttrKey), Float.parseFloat(childAttrVal));                            } else if ("BOOL".equalsIgnoreCase(child.getTagName())) {                dict.setBoolean(COSName.getPDFName(childAttrKey), Boolean.parseBoolean(childAttrVal));                            } else if ("ARRAY".equalsIgnoreCase(child.getTagName())) {                dict.setItem(COSName.getPDFName(childAttrKey), parseArrayElement(child));                            } else {                            }        }    }    return dict;}
public final void pdfbox_f4311_0(String icon)
{    annot.setName(COSName.NAME, icon);}
public String pdfbox_f4312_0()
{    return annot.getNameAsString(COSName.NAME, PDAnnotationText.NAME_NOTE);}
public String pdfbox_f4313_0()
{    return annot.getString(COSName.STATE);}
public final void pdfbox_f4314_0(String state)
{    annot.setString(COSName.STATE, state);}
public String pdfbox_f4315_0()
{    return annot.getString(COSName.STATE_MODEL);}
public final void pdfbox_f4316_0(String stateModel)
{    annot.setString(COSName.STATE_MODEL, stateModel);}
public void pdfbox_f4317_0(float[] coords)
{    COSArray newQuadPoints = new COSArray();    newQuadPoints.setFloatArray(coords);    annot.setItem(COSName.QUADPOINTS, newQuadPoints);}
public float[] pdfbox_f4318_0()
{    COSArray quadPoints = (COSArray) annot.getItem(COSName.QUADPOINTS);    if (quadPoints != null) {        return quadPoints.toFloatArray();    } else {                return null;    }}
public void pdfbox_f4319_0(Writer output) throws IOException
{    FDFDictionary fdf = getFDF();    fdf.writeXML(output);}
public COSDictionary pdfbox_f4320_0()
{    return catalog;}
public String pdfbox_f4321_0()
{    return catalog.getNameAsString(COSName.VERSION);}
public void pdfbox_f4322_0(String version)
{    catalog.setName(COSName.VERSION, version);}
public FDFDictionary pdfbox_f4323_0()
{    COSDictionary fdf = (COSDictionary) catalog.getDictionaryObject(COSName.FDF);    FDFDictionary retval;    if (fdf != null) {        retval = new FDFDictionary(fdf);    } else {        retval = new FDFDictionary();        setFDF(retval);    }    return retval;}
public final void pdfbox_f4324_0(FDFDictionary fdf)
{    catalog.setItem(COSName.FDF, fdf);}
public PDSignature pdfbox_f4325_0()
{    PDSignature signature = null;    COSDictionary sig = (COSDictionary) catalog.getDictionaryObject(COSName.SIG);    if (sig != null) {        signature = new PDSignature(sig);    }    return signature;}
public void pdfbox_f4326_0(PDSignature sig)
{    catalog.setItem(COSName.SIG, sig);}
public void pdfbox_f4327_0(Writer output) throws IOException
{    PDFileSpecification fs = this.getFile();    if (fs != null) {        output.write("<f href=\"" + fs.getFile() + "\" />\n");    }    COSArray ids = this.getID();    if (ids != null) {        COSString original = (COSString) ids.getObject(0);        COSString modified = (COSString) ids.getObject(1);        output.write("<ids original=\"" + original.toHexString() + "\" ");        output.write("modified=\"" + modified.toHexString() + "\" />\n");    }    List<FDFField> fields = getFields();    if (fields != null && fields.size() > 0) {        output.write("<fields>\n");        for (FDFField field : fields) {            field.writeXML(output);        }        output.write("</fields>\n");    }}
public COSDictionary pdfbox_f4328_0()
{    return fdf;}
public PDFileSpecification pdfbox_f4329_0() throws IOException
{    return PDFileSpecification.createFS(fdf.getDictionaryObject(COSName.F));}
public final void pdfbox_f4330_0(PDFileSpecification fs)
{    fdf.setItem(COSName.F, fs);}
public COSArray pdfbox_f4331_0()
{    return (COSArray) fdf.getDictionaryObject(COSName.ID);}
public final void pdfbox_f4332_0(COSArray id)
{    fdf.setItem(COSName.ID, id);}
public List<FDFField> pdfbox_f4333_0()
{    List<FDFField> retval = null;    COSArray fieldArray = (COSArray) fdf.getDictionaryObject(COSName.FIELDS);    if (fieldArray != null) {        List<FDFField> fields = new ArrayList<>();        for (int i = 0; i < fieldArray.size(); i++) {            fields.add(new FDFField((COSDictionary) fieldArray.getObject(i)));        }        retval = new COSArrayList<>(fields, fieldArray);    }    return retval;}
public final void pdfbox_f4334_0(List<FDFField> fields)
{    fdf.setItem(COSName.FIELDS, COSArrayList.converterToCOSArray(fields));}
public String pdfbox_f4335_0()
{    return fdf.getString(COSName.STATUS);}
public void pdfbox_f4336_0(String status)
{    fdf.setString(COSName.STATUS, status);}
public List<FDFPage> pdfbox_f4337_0()
{    List<FDFPage> retval = null;    COSArray pageArray = (COSArray) fdf.getDictionaryObject(COSName.PAGES);    if (pageArray != null) {        List<FDFPage> pages = new ArrayList<>();        for (int i = 0; i < pageArray.size(); i++) {            pages.add(new FDFPage((COSDictionary) pageArray.get(i)));        }        retval = new COSArrayList<>(pages, pageArray);    }    return retval;}
public void pdfbox_f4338_0(List<FDFPage> pages)
{    fdf.setItem(COSName.PAGES, COSArrayList.converterToCOSArray(pages));}
public String pdfbox_f4339_0()
{    String encoding = fdf.getNameAsString(COSName.ENCODING);    if (encoding == null) {        encoding = "PDFDocEncoding";    }    return encoding;}
public void pdfbox_f4340_0(String encoding)
{    fdf.setName(COSName.ENCODING, encoding);}
public List<FDFAnnotation> pdfbox_f4341_0() throws IOException
{    List<FDFAnnotation> retval = null;    COSArray annotArray = (COSArray) fdf.getDictionaryObject(COSName.ANNOTS);    if (annotArray != null) {        List<FDFAnnotation> annots = new ArrayList<>();        for (int i = 0; i < annotArray.size(); i++) {            annots.add(FDFAnnotation.create((COSDictionary) annotArray.getObject(i)));        }        retval = new COSArrayList<>(annots, annotArray);    }    return retval;}
public final void pdfbox_f4342_0(List<FDFAnnotation> annots)
{    fdf.setItem(COSName.ANNOTS, COSArrayList.converterToCOSArray(annots));}
public COSStream pdfbox_f4343_0()
{    return (COSStream) fdf.getDictionaryObject(COSName.DIFFERENCES);}
public void pdfbox_f4344_0(COSStream diff)
{    fdf.setItem(COSName.DIFFERENCES, diff);}
public String pdfbox_f4345_0()
{    return fdf.getString(COSName.TARGET);}
public void pdfbox_f4346_0(String target)
{    fdf.setString(COSName.TARGET, target);}
public List<PDFileSpecification> pdfbox_f4347_0() throws IOException
{    List<PDFileSpecification> retval = null;    COSArray embeddedArray = (COSArray) fdf.getDictionaryObject(COSName.EMBEDDED_FDFS);    if (embeddedArray != null) {        List<PDFileSpecification> embedded = new ArrayList<>();        for (int i = 0; i < embeddedArray.size(); i++) {            embedded.add(PDFileSpecification.createFS(embeddedArray.get(i)));        }        retval = new COSArrayList<>(embedded, embeddedArray);    }    return retval;}
public void pdfbox_f4348_0(List<PDFileSpecification> embedded)
{    fdf.setItem(COSName.EMBEDDED_FDFS, COSArrayList.converterToCOSArray(embedded));}
public FDFJavaScript pdfbox_f4349_0()
{    FDFJavaScript fs = null;    COSDictionary dic = (COSDictionary) fdf.getDictionaryObject(COSName.JAVA_SCRIPT);    if (dic != null) {        fs = new FDFJavaScript(dic);    }    return fs;}
public void pdfbox_f4350_0(FDFJavaScript js)
{    fdf.setItem(COSName.JAVA_SCRIPT, js);}
public void pdfbox_f4351_0(Writer output) throws IOException
{    output.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");    output.write("<xfdf xmlns=\"http://ns.adobe.com/xfdf/\" xml:space=\"preserve\">\n");    getCatalog().writeXML(output);    output.write("</xfdf>\n");}
public COSDocument pdfbox_f4352_0()
{    return document;}
public FDFCatalog pdfbox_f4353_0()
{    FDFCatalog retval = null;    COSDictionary trailer = document.getTrailer();    COSDictionary root = trailer.getCOSDictionary(COSName.ROOT);    if (root == null) {        retval = new FDFCatalog();        setCatalog(retval);    } else {        retval = new FDFCatalog(root);    }    return retval;}
public final void pdfbox_f4354_0(FDFCatalog cat)
{    COSDictionary trailer = document.getTrailer();    trailer.setItem(COSName.ROOT, cat);}
public static FDFDocument pdfbox_f4355_0(String filename) throws IOException
{    FDFParser parser = new FDFParser(filename);    parser.parse();    return new FDFDocument(parser.getDocument());}
public static FDFDocument pdfbox_f4356_0(File file) throws IOException
{    FDFParser parser = new FDFParser(file);    parser.parse();    return new FDFDocument(parser.getDocument());}
public static FDFDocument pdfbox_f4357_0(InputStream input) throws IOException
{    FDFParser parser = new FDFParser(input);    parser.parse();    return new FDFDocument(parser.getDocument());}
public static FDFDocument pdfbox_f4358_0(String filename) throws IOException
{    return loadXFDF(new BufferedInputStream(new FileInputStream(filename)));}
public static FDFDocument pdfbox_f4359_0(File file) throws IOException
{    return loadXFDF(new BufferedInputStream(new FileInputStream(file)));}
public static FDFDocument pdfbox_f4360_0(InputStream input) throws IOException
{    return new FDFDocument(XMLUtil.parse(input));}
public void pdfbox_f4361_0(File fileName) throws IOException
{    save(new FileOutputStream(fileName));}
public void pdfbox_f4362_0(String fileName) throws IOException
{    save(new FileOutputStream(fileName));}
public void pdfbox_f4363_0(OutputStream output) throws IOException
{    try (COSWriter writer = new COSWriter(output)) {        writer.write(this);    }}
public void pdfbox_f4364_0(File fileName) throws IOException
{    saveXFDF(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8")));}
public void pdfbox_f4365_0(String fileName) throws IOException
{    saveXFDF(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8")));}
public void pdfbox_f4366_0(Writer output) throws IOException
{    try {        writeXML(output);    } finally {        if (output != null) {            output.close();        }    }}
public void pdfbox_f4367_0() throws IOException
{    document.close();}
public void pdfbox_f4368_0(Writer output) throws IOException
{    output.write("<field name=\"" + getPartialFieldName() + "\">\n");    Object value = getValue();    if (value instanceof String) {        output.write("<value>" + escapeXML((String) value) + "</value>\n");    } else if (value instanceof List) {        List<String> items = (List<String>) value;        for (String item : items) {            output.write("<value>" + escapeXML((String) item) + "</value>\n");        }    }    String rt = getRichText();    if (rt != null) {        output.write("<value-richtext>" + escapeXML(rt) + "</value-richtext>\n");    }    List<FDFField> kids = getKids();    if (kids != null) {        for (FDFField kid : kids) {            kid.writeXML(output);        }    }    output.write("</field>\n");}
public COSDictionary pdfbox_f4369_0()
{    return field;}
public List<FDFField> pdfbox_f4370_0()
{    COSArray kids = (COSArray) field.getDictionaryObject(COSName.KIDS);    List<FDFField> retval = null;    if (kids != null) {        List<FDFField> actuals = new ArrayList<>();        for (int i = 0; i < kids.size(); i++) {            actuals.add(new FDFField((COSDictionary) kids.getObject(i)));        }        retval = new COSArrayList<>(actuals, kids);    }    return retval;}
public final void pdfbox_f4371_0(List<FDFField> kids)
{    field.setItem(COSName.KIDS, COSArrayList.converterToCOSArray(kids));}
public String pdfbox_f4372_0()
{    return field.getString(COSName.T);}
public void pdfbox_f4373_0(String partial)
{    field.setString(COSName.T, partial);}
public Object pdfbox_f4374_0() throws IOException
{    COSBase value = field.getDictionaryObject(COSName.V);    if (value instanceof COSName) {        return ((COSName) value).getName();    } else if (value instanceof COSArray) {        return COSArrayList.convertCOSStringCOSArrayToList((COSArray) value);    } else if (value instanceof COSString) {        return ((COSString) value).getString();    } else if (value instanceof COSStream) {        return ((COSStream) value).toTextString();    } else if (value != null) {        throw new IOException("Error:Unknown type for field import" + value);    } else {        return null;    }}
public COSBase pdfbox_f4375_0() throws IOException
{    COSBase value = field.getDictionaryObject(COSName.V);    if (value instanceof COSName) {        return value;    } else if (value instanceof COSArray) {        return value;    } else if (value instanceof COSString || value instanceof COSStream) {        return value;    } else if (value != null) {        throw new IOException("Error:Unknown type for field import" + value);    } else {        return null;    }}
public void pdfbox_f4376_0(Object value) throws IOException
{    COSBase cos = null;    if (value instanceof List) {        cos = COSArrayList.convertStringListToCOSStringCOSArray((List<String>) value);    } else if (value instanceof String) {        cos = new COSString((String) value);    } else if (value instanceof COSObjectable) {        cos = ((COSObjectable) value).getCOSObject();    } else if (value != null) {        throw new IOException("Error:Unknown type for field import" + value);    }    field.setItem(COSName.V, cos);}
public void pdfbox_f4377_0(COSBase value)
{    field.setItem(COSName.V, value);}
public Integer pdfbox_f4378_0()
{    Integer retval = null;    COSNumber ff = (COSNumber) field.getDictionaryObject(COSName.FF);    if (ff != null) {        retval = ff.intValue();    }    return retval;}
public void pdfbox_f4379_0(Integer ff)
{    COSInteger value = null;    if (ff != null) {        value = COSInteger.get(ff);    }    field.setItem(COSName.FF, value);}
public void pdfbox_f4380_0(int ff)
{    field.setInt(COSName.FF, ff);}
public Integer pdfbox_f4381_0()
{    Integer retval = null;    COSNumber ff = (COSNumber) field.getDictionaryObject(COSName.SET_FF);    if (ff != null) {        retval = ff.intValue();    }    return retval;}
public void pdfbox_f4382_0(Integer ff)
{    COSInteger value = null;    if (ff != null) {        value = COSInteger.get(ff);    }    field.setItem(COSName.SET_FF, value);}
public void pdfbox_f4383_0(int ff)
{    field.setInt(COSName.SET_FF, ff);}
public Integer pdfbox_f4384_0()
{    Integer retval = null;    COSNumber ff = (COSNumber) field.getDictionaryObject(COSName.CLR_FF);    if (ff != null) {        retval = ff.intValue();    }    return retval;}
public void pdfbox_f4385_0(Integer ff)
{    COSInteger value = null;    if (ff != null) {        value = COSInteger.get(ff);    }    field.setItem(COSName.CLR_FF, value);}
public void pdfbox_f4386_0(int ff)
{    field.setInt(COSName.CLR_FF, ff);}
public Integer pdfbox_f4387_0()
{    Integer retval = null;    COSNumber f = (COSNumber) field.getDictionaryObject("F");    if (f != null) {        retval = f.intValue();    }    return retval;}
public void pdfbox_f4388_0(Integer f)
{    COSInteger value = null;    if (f != null) {        value = COSInteger.get(f);    }    field.setItem(COSName.F, value);}
public void pdfbox_f4389_0(int f)
{    field.setInt(COSName.F, f);}
public Integer pdfbox_f4390_0()
{    Integer retval = null;    COSNumber ff = (COSNumber) field.getDictionaryObject(COSName.SET_F);    if (ff != null) {        retval = ff.intValue();    }    return retval;}
public void pdfbox_f4391_0(Integer ff)
{    COSInteger value = null;    if (ff != null) {        value = COSInteger.get(ff);    }    field.setItem(COSName.SET_F, value);}
public void pdfbox_f4392_0(int ff)
{    field.setInt(COSName.SET_F, ff);}
public Integer pdfbox_f4393_0()
{    Integer retval = null;    COSNumber ff = (COSNumber) field.getDictionaryObject(COSName.CLR_F);    if (ff != null) {        retval = ff.intValue();    }    return retval;}
public void pdfbox_f4394_0(Integer ff)
{    COSInteger value = null;    if (ff != null) {        value = COSInteger.get(ff);    }    field.setItem(COSName.CLR_F, value);}
public void pdfbox_f4395_0(int ff)
{    field.setInt(COSName.CLR_F, ff);}
public PDAppearanceDictionary pdfbox_f4396_0()
{    PDAppearanceDictionary retval = null;    COSDictionary dict = (COSDictionary) field.getDictionaryObject(COSName.AP);    if (dict != null) {        retval = new PDAppearanceDictionary(dict);    }    return retval;}
public void pdfbox_f4397_0(PDAppearanceDictionary ap)
{    field.setItem(COSName.AP, ap);}
public FDFNamedPageReference pdfbox_f4398_0()
{    FDFNamedPageReference retval = null;    COSDictionary ref = (COSDictionary) field.getDictionaryObject(COSName.AP_REF);    if (ref != null) {        retval = new FDFNamedPageReference(ref);    }    return retval;}
public void pdfbox_f4399_0(FDFNamedPageReference ref)
{    field.setItem(COSName.AP_REF, ref);}
public FDFIconFit pdfbox_f4400_0()
{    FDFIconFit retval = null;    COSDictionary dic = (COSDictionary) field.getDictionaryObject(COSName.IF);    if (dic != null) {        retval = new FDFIconFit(dic);    }    return retval;}
public void pdfbox_f4401_0(FDFIconFit fit)
{    field.setItem(COSName.IF, fit);}
public List<Object> pdfbox_f4402_0()
{    List<Object> retval = null;    COSArray array = (COSArray) field.getDictionaryObject(COSName.OPT);    if (array != null) {        List<Object> objects = new ArrayList<>();        for (int i = 0; i < array.size(); i++) {            COSBase next = array.getObject(i);            if (next instanceof COSString) {                objects.add(((COSString) next).getString());            } else {                COSArray value = (COSArray) next;                objects.add(new FDFOptionElement(value));            }        }        retval = new COSArrayList<>(objects, array);    }    return retval;}
public void pdfbox_f4403_0(List<Object> options)
{    COSArray value = COSArrayList.converterToCOSArray(options);    field.setItem(COSName.OPT, value);}
public PDAction pdfbox_f4404_0()
{    return PDActionFactory.createAction((COSDictionary) field.getDictionaryObject(COSName.A));}
public void pdfbox_f4405_0(PDAction a)
{    field.setItem(COSName.A, a);}
public PDAdditionalActions pdfbox_f4406_0()
{    PDAdditionalActions retval = null;    COSDictionary dict = (COSDictionary) field.getDictionaryObject(COSName.AA);    if (dict != null) {        retval = new PDAdditionalActions(dict);    }    return retval;}
public void pdfbox_f4407_0(PDAdditionalActions aa)
{    field.setItem(COSName.AA, aa);}
public String pdfbox_f4408_0()
{    COSBase rv = field.getDictionaryObject(COSName.RV);    if (rv == null) {        return null;    } else if (rv instanceof COSString) {        return ((COSString) rv).getString();    } else {        return ((COSStream) rv).toTextString();    }}
public void pdfbox_f4409_0(COSString rv)
{    field.setItem(COSName.RV, rv);}
public void pdfbox_f4410_0(COSStream rv)
{    field.setItem(COSName.RV, rv);}
private String pdfbox_f4411_0(String input)
{    StringBuilder escapedXML = new StringBuilder();    for (int i = 0; i < input.length(); i++) {        char c = input.charAt(i);        switch(c) {            case '<':                escapedXML.append("&lt;");                break;            case '>':                escapedXML.append("&gt;");                break;            case '\"':                escapedXML.append("&quot;");                break;            case '&':                escapedXML.append("&amp;");                break;            case '\'':                escapedXML.append("&apos;");                break;            default:                if (c > 0x7e) {                    escapedXML.append("&#").append((int) c).append(";");                } else {                    escapedXML.append(c);                }        }    }    return escapedXML.toString();}
public COSDictionary pdfbox_f4412_0()
{    return fit;}
public String pdfbox_f4413_0()
{    String retval = fit.getNameAsString(COSName.SW);    if (retval == null) {        retval = SCALE_OPTION_ALWAYS;    }    return retval;}
public void pdfbox_f4414_0(String option)
{    fit.setName(COSName.SW, option);}
public String pdfbox_f4415_0()
{    String retval = fit.getNameAsString(COSName.S);    if (retval == null) {        retval = SCALE_TYPE_PROPORTIONAL;    }    return retval;}
public void pdfbox_f4416_0(String scale)
{    fit.setName(COSName.S, scale);}
public PDRange pdfbox_f4417_0()
{    PDRange retval = null;    COSArray array = (COSArray) fit.getDictionaryObject(COSName.A);    if (array == null) {        retval = new PDRange();        retval.setMin(.5f);        retval.setMax(.5f);        setFractionalSpaceToAllocate(retval);    } else {        retval = new PDRange(array);    }    return retval;}
public void pdfbox_f4418_0(PDRange space)
{    fit.setItem(COSName.A, space);}
public boolean pdfbox_f4419_0()
{    return fit.getBoolean(COSName.FB, false);}
public void pdfbox_f4420_0(boolean value)
{    fit.setBoolean(COSName.FB, value);}
public COSDictionary pdfbox_f4421_0()
{    return dictionary;}
public String pdfbox_f4422_0()
{    COSBase base = dictionary.getDictionaryObject(COSName.BEFORE);    if (base instanceof COSString) {        return ((COSString) base).getString();    } else if (base instanceof COSStream) {        return ((COSStream) base).toTextString();    } else {        return null;    }}
public void pdfbox_f4423_0(String before)
{    dictionary.setItem(COSName.BEFORE, new COSString(before));}
public String pdfbox_f4424_0()
{    COSBase base = dictionary.getDictionaryObject(COSName.AFTER);    if (base instanceof COSString) {        return ((COSString) base).getString();    } else if (base instanceof COSStream) {        return ((COSStream) base).toTextString();    } else {        return null;    }}
public void pdfbox_f4425_0(String after)
{    dictionary.setItem(COSName.AFTER, new COSString(after));}
public Map<String, PDActionJavaScript> pdfbox_f4426_0()
{    Map<String, PDActionJavaScript> map = new LinkedHashMap<>();    COSArray array = (COSArray) dictionary.getDictionaryObject(COSName.DOC);    if (array == null) {        return null;    }    for (int i = 0; i < array.size(); i++) {        PDActionFactory.createAction((COSDictionary) array.getObject(i));    }    return map;}
public void pdfbox_f4427_0(Map<String, PDActionJavaScript> map)
{    COSArray array = new COSArray();    for (Map.Entry<String, PDActionJavaScript> entry : map.entrySet()) {        array.add(new COSString(entry.getKey()));        array.add(entry.getValue());    }    dictionary.setItem(COSName.DOC, array);}
public COSDictionary pdfbox_f4428_0()
{    return ref;}
public String pdfbox_f4429_0()
{    return ref.getString(COSName.NAME);}
public void pdfbox_f4430_0(String name)
{    ref.setString(COSName.NAME, name);}
public PDFileSpecification pdfbox_f4431_0() throws IOException
{    return PDFileSpecification.createFS(ref.getDictionaryObject(COSName.F));}
public void pdfbox_f4432_0(PDFileSpecification fs)
{    ref.setItem(COSName.F, fs);}
public COSBase pdfbox_f4433_0()
{    return option;}
public COSArray pdfbox_f4434_0()
{    return option;}
public String pdfbox_f4435_0()
{    return ((COSString) option.getObject(0)).getString();}
public void pdfbox_f4436_0(String opt)
{    option.set(0, new COSString(opt));}
public String pdfbox_f4437_0()
{    return ((COSString) option.getObject(1)).getString();}
public void pdfbox_f4438_0(String da)
{    option.set(1, new COSString(da));}
public COSDictionary pdfbox_f4439_0()
{    return page;}
public List<FDFTemplate> pdfbox_f4440_0()
{    List<FDFTemplate> retval = null;    COSArray array = (COSArray) page.getDictionaryObject(COSName.TEMPLATES);    if (array != null) {        List<FDFTemplate> objects = new ArrayList<>();        for (int i = 0; i < array.size(); i++) {            objects.add(new FDFTemplate((COSDictionary) array.getObject(i)));        }        retval = new COSArrayList<>(objects, array);    }    return retval;}
public void pdfbox_f4441_0(List<FDFTemplate> templates)
{    page.setItem(COSName.TEMPLATES, COSArrayList.converterToCOSArray(templates));}
public FDFPageInfo pdfbox_f4442_0()
{    FDFPageInfo retval = null;    COSDictionary dict = page.getCOSDictionary(COSName.INFO);    if (dict != null) {        retval = new FDFPageInfo(dict);    }    return retval;}
public void pdfbox_f4443_0(FDFPageInfo info)
{    page.setItem(COSName.INFO, info);}
public COSDictionary pdfbox_f4444_0()
{    return pageInfo;}
public COSDictionary pdfbox_f4445_0()
{    return template;}
public FDFNamedPageReference pdfbox_f4446_0()
{    FDFNamedPageReference retval = null;    COSDictionary dict = (COSDictionary) template.getDictionaryObject(COSName.TREF);    if (dict != null) {        retval = new FDFNamedPageReference(dict);    }    return retval;}
public void pdfbox_f4447_0(FDFNamedPageReference tRef)
{    template.setItem(COSName.TREF, tRef);}
public List<FDFField> pdfbox_f4448_0()
{    List<FDFField> retval = null;    COSArray array = (COSArray) template.getDictionaryObject(COSName.FIELDS);    if (array != null) {        List<FDFField> fields = new ArrayList<>();        for (int i = 0; i < array.size(); i++) {            fields.add(new FDFField((COSDictionary) array.getObject(i)));        }        retval = new COSArrayList<>(fields, array);    }    return retval;}
public void pdfbox_f4449_0(List<FDFField> fields)
{    template.setItem(COSName.FIELDS, COSArrayList.converterToCOSArray(fields));}
public boolean pdfbox_f4450_0()
{    return template.getBoolean(COSName.RENAME, false);}
public void pdfbox_f4451_0(boolean value)
{    template.setBoolean(COSName.RENAME, value);}
public FontBoxFont pdfbox_f4452_0()
{    return ttf;}
public boolean pdfbox_f4453_0()
{    return getFont() != null;}
public String pdfbox_f4454_0()
{    return registry;}
public String pdfbox_f4455_0()
{    return ordering;}
public int pdfbox_f4456_0()
{    return supplement;}
public String pdfbox_f4457_0()
{    return getRegistry() + "-" + getOrdering() + "-" + getSupplement();}
public static CMap pdfbox_f4458_0(String cMapName) throws IOException
{    CMap cmap = cMapCache.get(cMapName);    if (cmap != null) {        return cmap;    }    CMapParser parser = new CMapParser();    CMap targetCmap = parser.parsePredefined(cMapName);        cMapCache.put(targetCmap.getName(), targetCmap);    return targetCmap;}
public static CMap pdfbox_f4459_0(InputStream cMapStream) throws IOException
{    CMap targetCmap = null;    if (cMapStream != null) {        CMapParser parser = new CMapParser();        targetCmap = parser.parse(cMapStream);    }    return targetCmap;}
public COSBase pdfbox_f4460_0()
{    throw new UnsupportedOperationException("Built-in encodings cannot be serialized");}
public String pdfbox_f4461_0()
{    return "built-in (TTF)";}
private void pdfbox_f4462_0()
{        COSBase base = encoding.getDictionaryObject(COSName.DIFFERENCES);    if (!(base instanceof COSArray)) {        return;    }    COSArray diffArray = (COSArray) base;    int currentIndex = -1;    for (int i = 0; i < diffArray.size(); i++) {        COSBase next = diffArray.getObject(i);        if (next instanceof COSNumber) {            currentIndex = ((COSNumber) next).intValue();        } else if (next instanceof COSName) {            COSName name = (COSName) next;            overwrite(currentIndex, name.getName());            this.differences.put(currentIndex, name.getName());            currentIndex++;        }    }}
public Encoding pdfbox_f4463_0()
{    return baseEncoding;}
public Map<Integer, String> pdfbox_f4464_0()
{    return differences;}
public COSBase pdfbox_f4465_0()
{    return encoding;}
public String pdfbox_f4466_0()
{    return baseEncoding.getEncodingName() + " with differences";}
public static Encoding pdfbox_f4467_0(COSName name)
{    if (COSName.STANDARD_ENCODING.equals(name)) {        return StandardEncoding.INSTANCE;    } else if (COSName.WIN_ANSI_ENCODING.equals(name)) {        return WinAnsiEncoding.INSTANCE;    } else if (COSName.MAC_ROMAN_ENCODING.equals(name)) {        return MacRomanEncoding.INSTANCE;    } else if (COSName.MAC_EXPERT_ENCODING.equals(name)) {        return MacExpertEncoding.INSTANCE;    } else {        return null;    }}
public Map<Integer, String> pdfbox_f4468_0()
{    return Collections.unmodifiableMap(codeToName);}
public Map<String, Integer> pdfbox_f4469_0()
{    return Collections.unmodifiableMap(inverted);}
protected void pdfbox_f4470_0(int code, String name)
{    codeToName.put(code, name);    if (!inverted.containsKey(name)) {        inverted.put(name, code);    }}
protected void pdfbox_f4471_0(int code, String name)
{        String oldName = codeToName.get(code);    if (oldName != null) {        Integer oldCode = inverted.get(oldName);        if (oldCode != null && oldCode == code) {            inverted.remove(oldName);        }    }    inverted.put(name, code);    codeToName.put(code, name);}
public boolean pdfbox_f4472_0(String name)
{        if (names == null) {        synchronized (this) {                        Set<String> tmpSet = new HashSet<>(codeToName.values());                        names = tmpSet;                }        }    return names.contains(name);}
public boolean pdfbox_f4473_0(int code)
{    return codeToName.containsKey(code);}
public String pdfbox_f4474_0(int code)
{    String name = codeToName.get(code);    if (name != null) {        return name;    }    return ".notdef";}
private static GlyphList pdfbox_f4475_0(String filename, int numberOfEntries)
{    String path = "/org/apache/pdfbox/resources/glyphlist/";    try {        return new GlyphList(GlyphList.class.getResourceAsStream(path + filename), numberOfEntries);    } catch (IOException e) {        throw new RuntimeException(e);    }}
public static GlyphList pdfbox_f4476_0()
{    return DEFAULT;}
public static GlyphList pdfbox_f4477_0()
{    return ZAPF_DINGBATS;}
private void pdfbox_f4478_1(InputStream input) throws IOException
{    try (BufferedReader in = new BufferedReader(new InputStreamReader(input, "ISO-8859-1"))) {        while (in.ready()) {            String line = in.readLine();            if (line != null && !line.startsWith("#")) {                String[] parts = line.split(";");                if (parts.length < 2) {                    throw new IOException("Invalid glyph list entry: " + line);                }                String name = parts[0];                String[] unicodeList = parts[1].split(" ");                if (nameToUnicode.containsKey(name)) {                                    }                int[] codePoints = new int[unicodeList.length];                int index = 0;                for (String hex : unicodeList) {                    codePoints[index++] = Integer.parseInt(hex, 16);                }                String string = new String(codePoints, 0, codePoints.length);                                nameToUnicode.put(name, string);                                                                final boolean forceOverride = WinAnsiEncoding.INSTANCE.contains(name) || MacRomanEncoding.INSTANCE.contains(name) || MacExpertEncoding.INSTANCE.contains(name) || SymbolEncoding.INSTANCE.contains(name) || ZapfDingbatsEncoding.INSTANCE.contains(name);                if (!unicodeToName.containsKey(string) || forceOverride) {                    unicodeToName.put(string, name);                }            }        }    }}
public String pdfbox_f4479_0(int codePoint)
{    String name = unicodeToName.get(new String(new int[] { codePoint }, 0, 1));    if (name == null) {        return ".notdef";    }    return name;}
public String pdfbox_f4480_0(String unicodeSequence)
{    String name = unicodeToName.get(unicodeSequence);    if (name == null) {        return ".notdef";    }    return name;}
public String pdfbox_f4481_1(String name)
{    if (name == null) {        return null;    }    String unicode = nameToUnicode.get(name);    if (unicode != null) {        return unicode;    }        unicode = uniNameToUnicodeCache.get(name);    if (unicode == null) {                if (name.indexOf('.') > 0) {            unicode = toUnicode(name.substring(0, name.indexOf('.')));        } else if (name.startsWith("uni") && name.length() == 7) {                        int nameLength = name.length();            StringBuilder uniStr = new StringBuilder();            try {                for (int chPos = 3; chPos + 4 <= nameLength; chPos += 4) {                    int codePoint = Integer.parseInt(name.substring(chPos, chPos + 4), 16);                    if (codePoint > 0xD7FF && codePoint < 0xE000) {                                            } else {                        uniStr.append((char) codePoint);                    }                }                unicode = uniStr.toString();            } catch (NumberFormatException nfe) {                            }        } else if (name.startsWith("u") && name.length() == 5) {                        try {                int codePoint = Integer.parseInt(name.substring(1), 16);                if (codePoint > 0xD7FF && codePoint < 0xE000) {                                    } else {                    unicode = String.valueOf((char) codePoint);                }            } catch (NumberFormatException nfe) {                            }        }        if (unicode != null) {                        uniNameToUnicodeCache.put(name, unicode);        }    }    return unicode;}
public COSBase pdfbox_f4482_0()
{    return COSName.MAC_EXPERT_ENCODING;}
public String pdfbox_f4483_0()
{    return "MacExpertEncoding";}
public COSBase pdfbox_f4484_0()
{    return null;}
public COSBase pdfbox_f4485_0()
{    return COSName.MAC_ROMAN_ENCODING;}
public String pdfbox_f4486_0()
{    return "MacRomanEncoding";}
public COSBase pdfbox_f4487_0()
{    return COSName.STANDARD_ENCODING;}
public String pdfbox_f4488_0()
{    return "StandardEncoding";}
public COSBase pdfbox_f4489_0()
{    return COSName.getPDFName("SymbolEncoding");}
public String pdfbox_f4490_0()
{    return "SymbolEncoding";}
public static Type1Encoding pdfbox_f4491_0(org.apache.fontbox.encoding.Encoding encoding)
{        Map<Integer, String> codeToName = encoding.getCodeToNameMap();    Type1Encoding enc = new Type1Encoding();    for (Map.Entry<Integer, String> entry : codeToName.entrySet()) {        enc.add(entry.getKey(), entry.getValue());    }    return enc;}
public COSBase pdfbox_f4492_0()
{    return null;}
public String pdfbox_f4493_0()
{    return "built-in (Type 1)";}
public COSBase pdfbox_f4494_0()
{    return COSName.WIN_ANSI_ENCODING;}
public String pdfbox_f4495_0()
{    return "WinAnsiEncoding";}
public COSBase pdfbox_f4496_0()
{    return COSName.getPDFName("ZapfDingbatsEncoding");}
public String pdfbox_f4497_0()
{    return "ZapfDingbatsEncoding";}
public String pdfbox_f4498_0()
{    return postScriptName;}
public FontFormat pdfbox_f4499_0()
{    return format;}
public CIDSystemInfo pdfbox_f4500_0()
{    return cidSystemInfo;}
public FontBoxFont pdfbox_f4501_0()
{    FontBoxFont cached = parent.cache.getFont(this);    if (cached != null) {        return cached;    } else {        FontBoxFont font;        switch(format) {            case PFB:                font = getType1Font(postScriptName, file);                break;            case TTF:                font = getTrueTypeFont(postScriptName, file);                break;            case OTF:                font = getOTFFont(postScriptName, file);                break;            default:                throw new RuntimeException("can't happen");        }        if (font != null) {            parent.cache.addFont(this, font);        }        return font;    }}
public int pdfbox_f4502_0()
{    return sFamilyClass;}
public int pdfbox_f4503_0()
{    return usWeightClass;}
public int pdfbox_f4504_0()
{    return ulCodePageRange1;}
public int pdfbox_f4505_0()
{    return ulCodePageRange2;}
public int pdfbox_f4506_0()
{    return macStyle;}
public PDPanoseClassification pdfbox_f4507_0()
{    return panose;}
public String pdfbox_f4508_0()
{    return super.toString() + " " + file;}
private TrueTypeFont pdfbox_f4509_1(String postScriptName, File file)
{    try {        TrueTypeFont ttf = readTrueTypeFont(postScriptName, file);        if (LOG.isDebugEnabled()) {                    }        return ttf;    } catch (NullPointerException | IOException e) {                    }    return null;}
private TrueTypeFont pdfbox_f4510_0(String postScriptName, File file) throws IOException
{    if (file.getName().toLowerCase().endsWith(".ttc")) {        @SuppressWarnings("squid:S2095")        TrueTypeCollection         ttc = new TrueTypeCollection(file);        TrueTypeFont ttf = ttc.getFontByName(postScriptName);        if (ttf == null) {            ttc.close();            throw new IOException("Font " + postScriptName + " not found in " + file);        }        return ttf;    } else {        TTFParser ttfParser = new TTFParser(false, true);        return ttfParser.parse(file);    }}
private OpenTypeFont pdfbox_f4511_1(String postScriptName, File file)
{    try {                OTFParser parser = new OTFParser(false, true);        OpenTypeFont otf = parser.parse(file);        if (LOG.isDebugEnabled()) {                    }        return otf;    } catch (IOException e) {            }    return null;}
private Type1Font pdfbox_f4512_1(String postScriptName, File file)
{    try (InputStream input = new FileInputStream(file)) {        Type1Font type1 = Type1Font.createWithPFB(input);        if (LOG.isDebugEnabled()) {                    }        return type1;    } catch (IOException e) {            }    return null;}
private void pdfbox_f4513_1(List<File> files)
{    for (File file : files) {        try {            if (file.getPath().toLowerCase().endsWith(".ttf") || file.getPath().toLowerCase().endsWith(".otf")) {                addTrueTypeFont(file);            } else if (file.getPath().toLowerCase().endsWith(".ttc") || file.getPath().toLowerCase().endsWith(".otc")) {                addTrueTypeCollection(file);            } else if (file.getPath().toLowerCase().endsWith(".pfb")) {                addType1Font(file);            }        } catch (IOException e) {                    }    }}
private File pdfbox_f4514_0()
{    String path = System.getProperty("pdfbox.fontcache");    if (path == null || !new File(path).isDirectory() || !new File(path).canWrite()) {        path = System.getProperty("user.home");        if (path == null || !new File(path).isDirectory() || !new File(path).canWrite()) {            path = System.getProperty("java.io.tmpdir");        }    }    return new File(path, ".pdfbox.cache");}
private void pdfbox_f4515_1()
{    try {        File file = getDiskCacheFile();        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {            for (FSFontInfo fontInfo : fontInfoList) {                writeFontInfo(writer, fontInfo);            }        } catch (IOException e) {                                            }    } catch (SecurityException e) {            }}
private void pdfbox_f4516_0(BufferedWriter writer, FSFontInfo fontInfo) throws IOException
{    writer.write(fontInfo.postScriptName.trim());    writer.write("|");    writer.write(fontInfo.format.toString());    writer.write("|");    if (fontInfo.cidSystemInfo != null) {        writer.write(fontInfo.cidSystemInfo.getRegistry() + '-' + fontInfo.cidSystemInfo.getOrdering() + '-' + fontInfo.cidSystemInfo.getSupplement());    }    writer.write("|");    if (fontInfo.usWeightClass > -1) {        writer.write(Integer.toHexString(fontInfo.usWeightClass));    }    writer.write("|");    if (fontInfo.sFamilyClass > -1) {        writer.write(Integer.toHexString(fontInfo.sFamilyClass));    }    writer.write("|");    writer.write(Integer.toHexString(fontInfo.ulCodePageRange1));    writer.write("|");    writer.write(Integer.toHexString(fontInfo.ulCodePageRange2));    writer.write("|");    if (fontInfo.macStyle > -1) {        writer.write(Integer.toHexString(fontInfo.macStyle));    }    writer.write("|");    if (fontInfo.panose != null) {        byte[] bytes = fontInfo.panose.getBytes();        for (int i = 0; i < 10; i++) {            String str = Integer.toHexString(bytes[i]);            if (str.length() == 1) {                writer.write('0');            }            writer.write(str);        }    }    writer.write("|");    writer.write(fontInfo.file.getAbsolutePath());    writer.newLine();}
private List<FSFontInfo> pdfbox_f4517_1(List<File> files)
{    Set<String> pending = new HashSet<>();    for (File file : files) {        pending.add(file.getAbsolutePath());    }    List<FSFontInfo> results = new ArrayList<>();        File file = null;    boolean fileExists = false;    try {        file = getDiskCacheFile();        fileExists = file.exists();    } catch (SecurityException e) {            }    if (fileExists) {        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {            String line;            while ((line = reader.readLine()) != null) {                String[] parts = line.split("\\|", 10);                if (parts.length < 10) {                                        continue;                }                String postScriptName;                FontFormat format;                CIDSystemInfo cidSystemInfo = null;                int usWeightClass = -1;                int sFamilyClass = -1;                int ulCodePageRange1;                int ulCodePageRange2;                int macStyle = -1;                byte[] panose = null;                File fontFile;                postScriptName = parts[0];                format = FontFormat.valueOf(parts[1]);                if (parts[2].length() > 0) {                    String[] ros = parts[2].split("-");                    cidSystemInfo = new CIDSystemInfo(ros[0], ros[1], Integer.parseInt(ros[2]));                }                if (parts[3].length() > 0) {                    usWeightClass = (int) Long.parseLong(parts[3], 16);                }                if (parts[4].length() > 0) {                    sFamilyClass = (int) Long.parseLong(parts[4], 16);                }                ulCodePageRange1 = (int) Long.parseLong(parts[5], 16);                ulCodePageRange2 = (int) Long.parseLong(parts[6], 16);                if (parts[7].length() > 0) {                    macStyle = (int) Long.parseLong(parts[7], 16);                }                if (parts[8].length() > 0) {                    panose = new byte[10];                    for (int i = 0; i < 10; i++) {                        String str = parts[8].substring(i * 2, i * 2 + 2);                        int b = Integer.parseInt(str, 16);                        panose[i] = (byte) (b & 0xff);                    }                }                fontFile = new File(parts[9]);                if (fontFile.exists()) {                    FSFontInfo info = new FSFontInfo(fontFile, format, postScriptName, cidSystemInfo, usWeightClass, sFamilyClass, ulCodePageRange1, ulCodePageRange2, macStyle, panose, this);                    results.add(info);                } else {                                    }                pending.remove(fontFile.getAbsolutePath());            }        } catch (IOException e) {                        return null;        }    }    if (!pending.isEmpty()) {                        return null;    }    return results;}
private void pdfbox_f4518_1(final File ttcFile) throws IOException
{    try (TrueTypeCollection ttc = new TrueTypeCollection(ttcFile)) {        ttc.processAllFonts(ttf -> addTrueTypeFontImpl(ttf, ttcFile));    } catch (NullPointerException | IOException e) {                    }}
private void pdfbox_f4519_1(File ttfFile) throws IOException
{    try {        if (ttfFile.getPath().endsWith(".otf")) {            OTFParser parser = new OTFParser(false, true);            OpenTypeFont otf = parser.parse(ttfFile);            addTrueTypeFontImpl(otf, ttfFile);        } else {            TTFParser parser = new TTFParser(false, true);            TrueTypeFont ttf = parser.parse(ttfFile);            addTrueTypeFontImpl(ttf, ttfFile);        }    } catch (NullPointerException | IOException e) {                    }}
private void pdfbox_f4520_1(TrueTypeFont ttf, File file) throws IOException
{    try {                if (ttf.getName() != null && ttf.getName().contains("|")) {            fontInfoList.add(new FSIgnored(file, FontFormat.TTF, "*skippipeinname*"));                    } else if (ttf.getName() != null) {                        if (ttf.getHeader() == null) {                fontInfoList.add(new FSIgnored(file, FontFormat.TTF, ttf.getName()));                return;            }            int macStyle = ttf.getHeader().getMacStyle();            int sFamilyClass = -1;            int usWeightClass = -1;            int ulCodePageRange1 = 0;            int ulCodePageRange2 = 0;            byte[] panose = null;                        if (ttf.getOS2Windows() != null) {                sFamilyClass = ttf.getOS2Windows().getFamilyClass();                usWeightClass = ttf.getOS2Windows().getWeightClass();                ulCodePageRange1 = (int) ttf.getOS2Windows().getCodePageRange1();                ulCodePageRange2 = (int) ttf.getOS2Windows().getCodePageRange2();                panose = ttf.getOS2Windows().getPanose();            }            String format;            if (ttf instanceof OpenTypeFont && ((OpenTypeFont) ttf).isPostScript()) {                format = "OTF";                CFFFont cff = ((OpenTypeFont) ttf).getCFF().getFont();                CIDSystemInfo ros = null;                if (cff instanceof CFFCIDFont) {                    CFFCIDFont cidFont = (CFFCIDFont) cff;                    String registry = cidFont.getRegistry();                    String ordering = cidFont.getOrdering();                    int supplement = cidFont.getSupplement();                    ros = new CIDSystemInfo(registry, ordering, supplement);                }                fontInfoList.add(new FSFontInfo(file, FontFormat.OTF, ttf.getName(), ros, usWeightClass, sFamilyClass, ulCodePageRange1, ulCodePageRange2, macStyle, panose, this));            } else {                CIDSystemInfo ros = null;                if (ttf.getTableMap().containsKey("gcid")) {                                        byte[] bytes = ttf.getTableBytes(ttf.getTableMap().get("gcid"));                    String reg = new String(bytes, 10, 64, Charsets.US_ASCII);                    String registryName = reg.substring(0, reg.indexOf('\0'));                    String ord = new String(bytes, 76, 64, Charsets.US_ASCII);                    String orderName = ord.substring(0, ord.indexOf('\0'));                    int supplementVersion = bytes[140] << 8 & (bytes[141] & 0xFF);                    ros = new CIDSystemInfo(registryName, orderName, supplementVersion);                }                format = "TTF";                fontInfoList.add(new FSFontInfo(file, FontFormat.TTF, ttf.getName(), ros, usWeightClass, sFamilyClass, ulCodePageRange1, ulCodePageRange2, macStyle, panose, this));            }            if (LOG.isTraceEnabled()) {                NamingTable name = ttf.getNaming();                if (name != null) {                    LOG.trace(format + ": '" + name.getPostScriptName() + "' / '" + name.getFontFamily() + "' / '" + name.getFontSubFamily() + "'");                }            }        } else {            fontInfoList.add(new FSIgnored(file, FontFormat.TTF, "*skipnoname*"));                    }    } catch (IOException e) {        fontInfoList.add(new FSIgnored(file, FontFormat.TTF, "*skipexception*"));            } finally {        ttf.close();    }}
private void pdfbox_f4521_1(File pfbFile) throws IOException
{    try (InputStream input = new FileInputStream(pfbFile)) {        Type1Font type1 = Type1Font.createWithPFB(input);        if (type1.getName() != null && type1.getName().contains("|")) {            fontInfoList.add(new FSIgnored(pfbFile, FontFormat.PFB, "*skippipeinname*"));                        return;        }        fontInfoList.add(new FSFontInfo(pfbFile, FontFormat.PFB, type1.getName(), null, -1, -1, 0, 0, -1, null, this));        if (LOG.isTraceEnabled()) {            LOG.trace("PFB: '" + type1.getName() + "' / '" + type1.getFamilyName() + "' / '" + type1.getWeight() + "'");        }    } catch (IOException e) {            }}
public String pdfbox_f4522_0()
{    StringBuilder sb = new StringBuilder();    for (FSFontInfo info : fontInfoList) {        sb.append(info.getFormat());        sb.append(": ");        sb.append(info.getPostScriptName());        sb.append(": ");        sb.append(info.file.getPath());        sb.append('\n');    }    return sb.toString();}
public List<? extends FontInfo> pdfbox_f4523_0()
{    return fontInfoList;}
public void pdfbox_f4524_0(FontInfo info, FontBoxFont font)
{    cache.put(info, new SoftReference<>(font));}
public FontBoxFont pdfbox_f4525_0(FontInfo info)
{    SoftReference<FontBoxFont> reference = cache.get(info);    return reference != null ? reference.get() : null;}
 final int pdfbox_f4526_0()
{    int usWeightClass = getWeightClass();    switch(usWeightClass) {        case -1:            return 0;        case 0:            return 0;        case 100:            return 2;        case 200:            return 3;        case 300:            return 4;        case 400:            return 5;        case 500:            return 6;        case 600:            return 7;        case 700:            return 8;        case 800:            return 9;        case 900:            return 10;        default:            return 0;    }}
 final long pdfbox_f4527_0()
{    long range1 = getCodePageRange1() & 0x00000000ffffffffL;    long range2 = getCodePageRange2() & 0x00000000ffffffffL;    return range2 << 32 | range1;}
public String pdfbox_f4528_0()
{    return getPostScriptName() + " (" + getFormat() + ", mac: 0x" + Integer.toHexString(getMacStyle()) + ", os/2: 0x" + Integer.toHexString(getFamilyClass()) + ", cid: " + getCIDSystemInfo() + ")";}
public synchronized void pdfbox_f4529_0(FontProvider fontProvider)
{    fontInfoByName = createFontInfoByName(fontProvider.getFontInfo());    this.fontProvider = fontProvider;}
public synchronized FontProvider pdfbox_f4530_0()
{    if (fontProvider == null) {        setProvider(DefaultFontProvider.INSTANCE);    }    return fontProvider;}
public FontCache pdfbox_f4531_0()
{    return fontCache;}
private Map<String, FontInfo> pdfbox_f4532_0(List<? extends FontInfo> fontInfoList)
{    Map<String, FontInfo> map = new LinkedHashMap<>();    for (FontInfo info : fontInfoList) {        for (String name : getPostScriptNames(info.getPostScriptName())) {            map.put(name, info);        }    }    return map;}
private Set<String> pdfbox_f4533_0(String postScriptName)
{    Set<String> names = new HashSet<>();        names.add(postScriptName);        names.add(postScriptName.replaceAll("-", ""));    return names;}
private List<String> pdfbox_f4534_0(String postScriptName)
{    return new ArrayList<>(substitutes.get(postScriptName));}
public void pdfbox_f4535_0(String match, String replace)
{    if (!substitutes.containsKey(match)) {        substitutes.put(match, new ArrayList<String>());    }    substitutes.get(match).add(replace);}
private List<String> pdfbox_f4536_0(String postScriptName)
{    List<String> subs = substitutes.get(postScriptName.replaceAll(" ", ""));    if (subs != null) {        return subs;    } else {        return Collections.emptyList();    }}
private String pdfbox_f4537_0(PDFontDescriptor fontDescriptor)
{    String fontName;    if (fontDescriptor != null) {                boolean isBold = false;        String name = fontDescriptor.getFontName();        if (name != null) {            String lower = fontDescriptor.getFontName().toLowerCase();            isBold = lower.contains("bold") || lower.contains("black") || lower.contains("heavy");        }                if (fontDescriptor.isFixedPitch()) {            fontName = "Courier";            if (isBold && fontDescriptor.isItalic()) {                fontName += "-BoldOblique";            } else if (isBold) {                fontName += "-Bold";            } else if (fontDescriptor.isItalic()) {                fontName += "-Oblique";            }        } else if (fontDescriptor.isSerif()) {            fontName = "Times";            if (isBold && fontDescriptor.isItalic()) {                fontName += "-BoldItalic";            } else if (isBold) {                fontName += "-Bold";            } else if (fontDescriptor.isItalic()) {                fontName += "-Italic";            } else {                fontName += "-Roman";            }        } else {            fontName = "Helvetica";            if (isBold && fontDescriptor.isItalic()) {                fontName += "-BoldOblique";            } else if (isBold) {                fontName += "-Bold";            } else if (fontDescriptor.isItalic()) {                fontName += "-Oblique";            }        }    } else {                fontName = "Times-Roman";    }    return fontName;}
public FontMapping<TrueTypeFont> pdfbox_f4538_0(String baseFont, PDFontDescriptor fontDescriptor)
{    TrueTypeFont ttf = (TrueTypeFont) findFont(FontFormat.TTF, baseFont);    if (ttf != null) {        return new FontMapping<>(ttf, false);    } else {                String fontName = getFallbackFontName(fontDescriptor);        ttf = (TrueTypeFont) findFont(FontFormat.TTF, fontName);        if (ttf == null) {                        ttf = lastResortFont;        }        return new FontMapping<>(ttf, true);    }}
public FontMapping<FontBoxFont> pdfbox_f4539_0(String baseFont, PDFontDescriptor fontDescriptor)
{    FontBoxFont font = findFontBoxFont(baseFont);    if (font != null) {        return new FontMapping<>(font, false);    } else {                String fallbackName = getFallbackFontName(fontDescriptor);        font = findFontBoxFont(fallbackName);        if (font == null) {                        font = lastResortFont;        }        return new FontMapping<>(font, true);    }}
private FontBoxFont pdfbox_f4540_0(String postScriptName)
{    Type1Font t1 = (Type1Font) findFont(FontFormat.PFB, postScriptName);    if (t1 != null) {        return t1;    }    TrueTypeFont ttf = (TrueTypeFont) findFont(FontFormat.TTF, postScriptName);    if (ttf != null) {        return ttf;    }    OpenTypeFont otf = (OpenTypeFont) findFont(FontFormat.OTF, postScriptName);    if (otf != null) {        return otf;    }    return null;}
private FontBoxFont pdfbox_f4541_0(FontFormat format, String postScriptName)
{        if (postScriptName == null) {        return null;    }        if (fontProvider == null) {        getProvider();    }        FontInfo info = getFont(format, postScriptName);    if (info != null) {        return info.getFont();    }        info = getFont(format, postScriptName.replaceAll("-", ""));    if (info != null) {        return info.getFont();    }        for (String substituteName : getSubstitutes(postScriptName)) {        info = getFont(format, substituteName);        if (info != null) {            return info.getFont();        }    }        info = getFont(format, postScriptName.replaceAll(",", "-"));    if (info != null) {        return info.getFont();    }        info = getFont(format, postScriptName + "-Regular");    if (info != null) {        return info.getFont();    }        return null;}
private FontInfo pdfbox_f4542_0(FontFormat format, String postScriptName)
{        if (postScriptName.contains("+")) {        postScriptName = postScriptName.substring(postScriptName.indexOf('+') + 1);    }        FontInfo info = fontInfoByName.get(postScriptName);    if (info != null && info.getFormat() == format) {        return info;    }    return null;}
public CIDFontMapping pdfbox_f4543_0(String baseFont, PDFontDescriptor fontDescriptor, PDCIDSystemInfo cidSystemInfo)
{        OpenTypeFont otf1 = (OpenTypeFont) findFont(FontFormat.OTF, baseFont);    if (otf1 != null) {        return new CIDFontMapping(otf1, null, false);    }        TrueTypeFont ttf = (TrueTypeFont) findFont(FontFormat.TTF, baseFont);    if (ttf != null) {        return new CIDFontMapping(null, ttf, false);    }    if (cidSystemInfo != null) {                                String collection = cidSystemInfo.getRegistry() + "-" + cidSystemInfo.getOrdering();        if (collection.equals("Adobe-GB1") || collection.equals("Adobe-CNS1") || collection.equals("Adobe-Japan1") || collection.equals("Adobe-Korea1")) {                        PriorityQueue<FontMatch> queue = getFontMatches(fontDescriptor, cidSystemInfo);            FontMatch bestMatch = queue.poll();            if (bestMatch != null) {                FontBoxFont font = bestMatch.info.getFont();                if (font instanceof OpenTypeFont) {                    return new CIDFontMapping((OpenTypeFont) font, null, true);                } else if (font != null) {                    return new CIDFontMapping(null, font, true);                }            }        }    }        return new CIDFontMapping(null, lastResortFont, true);}
private PriorityQueue<FontMatch> pdfbox_f4544_0(PDFontDescriptor fontDescriptor, PDCIDSystemInfo cidSystemInfo)
{    PriorityQueue<FontMatch> queue = new PriorityQueue<>(20);    for (FontInfo info : fontInfoByName.values()) {                if (cidSystemInfo != null && !isCharSetMatch(cidSystemInfo, info)) {            continue;        }        FontMatch match = new FontMatch(info);                if (fontDescriptor.getPanose() != null && info.getPanose() != null) {            PDPanoseClassification panose = fontDescriptor.getPanose().getPanose();            if (panose.getFamilyKind() == info.getPanose().getFamilyKind()) {                if (panose.getFamilyKind() == 0 && (info.getPostScriptName().toLowerCase().contains("barcode") || info.getPostScriptName().startsWith("Code")) && !probablyBarcodeFont(fontDescriptor)) {                                        continue;                }                                if (panose.getSerifStyle() == info.getPanose().getSerifStyle()) {                                        match.score += 2;                } else if (panose.getSerifStyle() >= 2 && panose.getSerifStyle() <= 5 && info.getPanose().getSerifStyle() >= 2 && info.getPanose().getSerifStyle() <= 5) {                                        match.score += 1;                } else if (panose.getSerifStyle() >= 11 && panose.getSerifStyle() <= 13 && info.getPanose().getSerifStyle() >= 11 && info.getPanose().getSerifStyle() <= 13) {                                        match.score += 1;                } else if (panose.getSerifStyle() != 0 && info.getPanose().getSerifStyle() != 0) {                                        match.score -= 1;                }                                int weight = info.getPanose().getWeight();                int weightClass = info.getWeightClassAsPanose();                if (Math.abs(weight - weightClass) > 2) {                                        weight = weightClass;                }                if (panose.getWeight() == weight) {                                        match.score += 2;                } else if (panose.getWeight() > 1 && weight > 1) {                    float dist = Math.abs(panose.getWeight() - weight);                    match.score += 1 - dist * 0.5;                }                                    }        } else if (fontDescriptor.getFontWeight() > 0 && info.getWeightClass() > 0) {                        float dist = Math.abs(fontDescriptor.getFontWeight() - info.getWeightClass());            match.score += 1 - (dist / 100) * 0.5;        }                        queue.add(match);    }    return queue;}
private boolean pdfbox_f4545_0(PDFontDescriptor fontDescriptor)
{    String ff = fontDescriptor.getFontFamily();    if (ff == null) {        ff = "";    }    String fn = fontDescriptor.getFontName();    if (fn == null) {        fn = "";    }    return ff.startsWith("Code") || ff.toLowerCase().contains("barcode") || fn.startsWith("Code") || fn.toLowerCase().contains("barcode");}
private boolean pdfbox_f4546_0(PDCIDSystemInfo cidSystemInfo, FontInfo info)
{    if (info.getCIDSystemInfo() != null) {        return info.getCIDSystemInfo().getRegistry().equals(cidSystemInfo.getRegistry()) && info.getCIDSystemInfo().getOrdering().equals(cidSystemInfo.getOrdering());    } else {        long codePageRange = info.getCodePageRange();        long JIS_JAPAN = 1 << 17;        long CHINESE_SIMPLIFIED = 1 << 18;        long KOREAN_WANSUNG = 1 << 19;        long CHINESE_TRADITIONAL = 1 << 20;        long KOREAN_JOHAB = 1 << 21;        if (cidSystemInfo.getOrdering().equals("GB1") && (codePageRange & CHINESE_SIMPLIFIED) == CHINESE_SIMPLIFIED) {            return true;        } else if (cidSystemInfo.getOrdering().equals("CNS1") && (codePageRange & CHINESE_TRADITIONAL) == CHINESE_TRADITIONAL) {            return true;        } else if (cidSystemInfo.getOrdering().equals("Japan1") && (codePageRange & JIS_JAPAN) == JIS_JAPAN) {            return true;        } else {            return cidSystemInfo.getOrdering().equals("Korea1") && (codePageRange & KOREAN_WANSUNG) == KOREAN_WANSUNG || (codePageRange & KOREAN_JOHAB) == KOREAN_JOHAB;        }    }}
public int pdfbox_f4547_0(FontMatch match)
{    return Double.compare(match.score, this.score);}
private FontMatch pdfbox_f4548_0(PriorityQueue<FontMatch> queue)
{    FontMatch bestMatch = queue.peek();    System.out.println("-------");    while (!queue.isEmpty()) {        FontMatch match = queue.poll();        FontInfo info = match.info;        System.out.println(match.score + " | " + info.getMacStyle() + " " + info.getFamilyClass() + " " + info.getPanose() + " " + info.getCIDSystemInfo() + " " + info.getPostScriptName() + " " + info.getFormat());    }    System.out.println("-------");    return bestMatch;}
public static FontMapper pdfbox_f4549_0()
{    if (instance == null) {        instance = DefaultFontMapper.INSTANCE;    }    return instance;}
public static synchronized void pdfbox_f4550_0(FontMapper fontMapper)
{    instance = fontMapper;}
public T pdfbox_f4551_0()
{    return font;}
public boolean pdfbox_f4552_0()
{    return isFallback;}
private void pdfbox_f4553_0()
{    widths = new HashMap<>();    COSBase wBase = dict.getDictionaryObject(COSName.W);    if (wBase instanceof COSArray) {        COSArray wArray = (COSArray) wBase;        int size = wArray.size();        int counter = 0;        while (counter < size) {            COSNumber firstCode = (COSNumber) wArray.getObject(counter++);            COSBase next = wArray.getObject(counter++);            if (next instanceof COSArray) {                COSArray array = (COSArray) next;                int startRange = firstCode.intValue();                int arraySize = array.size();                for (int i = 0; i < arraySize; i++) {                    COSNumber width = (COSNumber) array.getObject(i);                    widths.put(startRange + i, width.floatValue());                }            } else {                COSNumber secondCode = (COSNumber) next;                COSNumber rangeWidth = (COSNumber) wArray.getObject(counter++);                int startRange = firstCode.intValue();                int endRange = secondCode.intValue();                float width = rangeWidth.floatValue();                for (int i = startRange; i <= endRange; i++) {                    widths.put(i, width);                }            }        }    }}
private void pdfbox_f4554_0()
{        COSBase dw2Base = dict.getDictionaryObject(COSName.DW2);    if (dw2Base instanceof COSArray) {        COSArray dw2Array = (COSArray) dw2Base;        COSBase base0 = dw2Array.getObject(0);        COSBase base1 = dw2Array.getObject(1);        if (base0 instanceof COSNumber && base1 instanceof COSNumber) {            dw2[0] = ((COSNumber) base0).floatValue();            dw2[1] = ((COSNumber) base1).floatValue();        }    }        COSBase w2Base = dict.getDictionaryObject(COSName.W2);    if (w2Base instanceof COSArray) {        COSArray w2Array = (COSArray) w2Base;        for (int i = 0; i < w2Array.size(); i++) {            COSNumber c = (COSNumber) w2Array.getObject(i);            COSBase next = w2Array.getObject(++i);            if (next instanceof COSArray) {                COSArray array = (COSArray) next;                for (int j = 0; j < array.size(); j++) {                    int cid = c.intValue() + j / 3;                    COSNumber w1y = (COSNumber) array.getObject(j);                    COSNumber v1x = (COSNumber) array.getObject(++j);                    COSNumber v1y = (COSNumber) array.getObject(++j);                    verticalDisplacementY.put(cid, w1y.floatValue());                    positionVectors.put(cid, new Vector(v1x.floatValue(), v1y.floatValue()));                }            } else {                int first = c.intValue();                int last = ((COSNumber) next).intValue();                COSNumber w1y = (COSNumber) w2Array.getObject(++i);                COSNumber v1x = (COSNumber) w2Array.getObject(++i);                COSNumber v1y = (COSNumber) w2Array.getObject(++i);                for (int cid = first; cid <= last; cid++) {                    verticalDisplacementY.put(cid, w1y.floatValue());                    positionVectors.put(cid, new Vector(v1x.floatValue(), v1y.floatValue()));                }            }        }    }}
public COSDictionary pdfbox_f4555_0()
{    return dict;}
public String pdfbox_f4556_0()
{    return dict.getNameAsString(COSName.BASE_FONT);}
public String pdfbox_f4557_0()
{    return getBaseFont();}
public PDFontDescriptor pdfbox_f4558_0()
{    if (fontDescriptor == null) {        COSDictionary fd = (COSDictionary) dict.getDictionaryObject(COSName.FONT_DESC);        if (fd != null) {            fontDescriptor = new PDFontDescriptor(fd);        }    }    return fontDescriptor;}
public final PDType0Font pdfbox_f4559_0()
{    return parent;}
private float pdfbox_f4560_0()
{    if (Float.compare(defaultWidth, 0) == 0) {        COSBase base = dict.getDictionaryObject(COSName.DW);        if (base instanceof COSNumber) {            defaultWidth = ((COSNumber) base).floatValue();        } else {            defaultWidth = 1000;        }    }    return defaultWidth;}
private Vector pdfbox_f4561_0(int cid)
{    return new Vector(getWidthForCID(cid) / 2, dw2[0]);}
private float pdfbox_f4562_0(int cid)
{    Float width = widths.get(cid);    if (width == null) {        width = getDefaultWidth();    }    return width;}
public boolean pdfbox_f4563_0(int code) throws IOException
{    return widths.get(codeToCID(code)) != null;}
public Vector pdfbox_f4564_0(int code)
{    int cid = codeToCID(code);    Vector v = positionVectors.get(cid);    if (v == null) {        v = getDefaultPositionVector(cid);    }    return v;}
public float pdfbox_f4565_0(int code)
{    int cid = codeToCID(code);    Float w1y = verticalDisplacementY.get(cid);    if (w1y == null) {        w1y = dw2[1];    }    return w1y;}
public float pdfbox_f4566_0(int code) throws IOException
{        return getWidthForCID(codeToCID(code));}
public float pdfbox_f4567_0()
{    if (Float.compare(averageWidth, 0) == 0) {        float totalWidths = 0.0f;        int characterCount = 0;        if (widths != null) {            for (Float width : widths.values()) {                if (width > 0) {                    totalWidths += width;                    ++characterCount;                }            }        }        averageWidth = totalWidths / characterCount;        if (averageWidth <= 0 || Float.isNaN(averageWidth)) {            averageWidth = getDefaultWidth();        }    }    return averageWidth;}
public PDCIDSystemInfo pdfbox_f4568_0()
{    COSBase base = dict.getDictionaryObject(COSName.CIDSYSTEMINFO);    if (base instanceof COSDictionary) {        return new PDCIDSystemInfo((COSDictionary) base);    }    return null;}
 final int[] pdfbox_f4569_0() throws IOException
{    int[] cid2gid = null;    COSBase map = dict.getDictionaryObject(COSName.CID_TO_GID_MAP);    if (map instanceof COSStream) {        COSStream stream = (COSStream) map;        InputStream is = stream.createInputStream();        byte[] mapAsBytes = IOUtils.toByteArray(is);        IOUtils.closeQuietly(is);        int numberOfInts = mapAsBytes.length / 2;        cid2gid = new int[numberOfInts];        int offset = 0;        for (int index = 0; index < numberOfInts; index++) {            int gid = (mapAsBytes[offset] & 0xff) << 8 | mapAsBytes[offset + 1] & 0xff;            cid2gid[index] = gid;            offset += 2;        }    }    return cid2gid;}
public final Matrix pdfbox_f4570_1()
{    if (fontMatrix == null) {        List<Number> numbers;        if (cidFont != null) {            numbers = cidFont.getFontMatrix();        } else {            try {                numbers = t1Font.getFontMatrix();            } catch (IOException e) {                                return new Matrix(0.001f, 0, 0, 0.001f, 0, 0);            }        }        if (numbers != null && numbers.size() == 6) {            fontMatrix = new Matrix(numbers.get(0).floatValue(), numbers.get(1).floatValue(), numbers.get(2).floatValue(), numbers.get(3).floatValue(), numbers.get(4).floatValue(), numbers.get(5).floatValue());        } else {            fontMatrix = new Matrix(0.001f, 0, 0, 0.001f, 0, 0);        }    }    return fontMatrix;}
public BoundingBox pdfbox_f4571_0()
{    if (fontBBox == null) {        fontBBox = generateBoundingBox();    }    return fontBBox;}
private BoundingBox pdfbox_f4572_1()
{    if (getFontDescriptor() != null) {        PDRectangle bbox = getFontDescriptor().getFontBoundingBox();        if (bbox != null && (Float.compare(bbox.getLowerLeftX(), 0) != 0 || Float.compare(bbox.getLowerLeftY(), 0) != 0 || Float.compare(bbox.getUpperRightX(), 0) != 0 || Float.compare(bbox.getUpperRightY(), 0) != 0)) {            return new BoundingBox(bbox.getLowerLeftX(), bbox.getLowerLeftY(), bbox.getUpperRightX(), bbox.getUpperRightY());        }    }    if (cidFont != null) {        return cidFont.getFontBBox();    } else {        try {            return t1Font.getFontBBox();        } catch (IOException e) {                        return new BoundingBox();        }    }}
public CFFFont pdfbox_f4573_0()
{    if (cidFont != null) {        return cidFont;    } else if (t1Font instanceof CFFType1Font) {        return (CFFType1Font) t1Font;    } else {        return null;    }}
public FontBoxFont pdfbox_f4574_0()
{    if (cidFont != null) {        return cidFont;    } else {        return t1Font;    }}
public Type2CharString pdfbox_f4575_0(int cid) throws IOException
{    if (cidFont != null) {        return cidFont.getType2CharString(cid);    } else if (t1Font instanceof CFFType1Font) {        return ((CFFType1Font) t1Font).getType2CharString(cid);    } else {        return null;    }}
private String pdfbox_f4576_0(int code) throws IOException
{    String unicodes = parent.toUnicode(code);    if (unicodes == null) {        return ".notdef";    }    return getUniNameOfCodePoint(unicodes.codePointAt(0));}
public GeneralPath pdfbox_f4577_0(int code) throws IOException
{    int cid = codeToCID(code);    if (cid2gid != null && isEmbedded) {                cid = cid2gid[cid];    }    Type2CharString charstring = getType2CharString(cid);    if (charstring != null) {        return charstring.getPath();    } else if (isEmbedded && t1Font instanceof CFFType1Font) {        return ((CFFType1Font) t1Font).getType2CharString(cid).getPath();    } else {        return t1Font.getPath(getGlyphName(code));    }}
public GeneralPath pdfbox_f4578_0(int code) throws IOException
{    return getPath(code);}
public boolean pdfbox_f4579_0(int code) throws IOException
{    int cid = codeToCID(code);    Type2CharString charstring = getType2CharString(cid);    if (charstring != null) {        return charstring.getGID() != 0;    } else if (isEmbedded && t1Font instanceof CFFType1Font) {        return ((CFFType1Font) t1Font).getType2CharString(cid).getGID() != 0;    } else {        return t1Font.hasGlyph(getGlyphName(code));    }}
public int pdfbox_f4580_0(int code)
{    return parent.getCMap().toCID(code);}
public int pdfbox_f4581_0(int code)
{    int cid = codeToCID(code);    if (cidFont != null) {                return cidFont.getCharset().getGIDForCID(cid);    } else {                return cid;    }}
public byte[] pdfbox_f4582_0(int unicode)
{        throw new UnsupportedOperationException();}
public byte[] pdfbox_f4583_0(int glyphId)
{    throw new UnsupportedOperationException();}
public float pdfbox_f4584_0(int code) throws IOException
{    int cid = codeToCID(code);    float width;    if (cidFont != null) {        width = getType2CharString(cid).getWidth();    } else if (isEmbedded && t1Font instanceof CFFType1Font) {        width = ((CFFType1Font) t1Font).getType2CharString(cid).getWidth();    } else {        width = t1Font.getWidth(getGlyphName(code));    }    Point2D p = new Point2D.Float(width, 0);    fontMatrixTransform.transform(p, p);    return (float) p.getX();}
public boolean pdfbox_f4585_0()
{    return isEmbedded;}
public boolean pdfbox_f4586_0()
{    return isDamaged;}
public float pdfbox_f4587_0(int code) throws IOException
{    int cid = codeToCID(code);    float height;    if (!glyphHeights.containsKey(cid)) {        height = (float) getType2CharString(cid).getBounds().getHeight();        glyphHeights.put(cid, height);    } else {        height = glyphHeights.get(cid);    }    return height;}
public float pdfbox_f4588_0()
{    if (avgWidth == null) {        avgWidth = getAverageCharacterWidth();    }    return avgWidth;}
private float pdfbox_f4589_0()
{        return 500;}
public byte[] pdfbox_f4590_0() throws IOException
{    return getFontDescriptor().getFontFile3().toByteArray();}
private TrueTypeFont pdfbox_f4591_1() throws IOException
{    TrueTypeFont ttfFont;    CIDFontMapping mapping = FontMappers.instance().getCIDFont(getBaseFont(), getFontDescriptor(), getCIDSystemInfo());    if (mapping.isCIDFont()) {        ttfFont = mapping.getFont();    } else {        ttfFont = (TrueTypeFont) mapping.getTrueTypeFont();    }    if (mapping.isFallback()) {            }    return ttfFont;}
public Matrix pdfbox_f4592_0()
{    if (fontMatrix == null) {                fontMatrix = new Matrix(0.001f, 0, 0, 0.001f, 0, 0);    }    return fontMatrix;}
public BoundingBox pdfbox_f4593_0() throws IOException
{    if (fontBBox == null) {        fontBBox = generateBoundingBox();    }    return fontBBox;}
private BoundingBox pdfbox_f4594_0() throws IOException
{    if (getFontDescriptor() != null) {        PDRectangle bbox = getFontDescriptor().getFontBoundingBox();        if (bbox != null && (Float.compare(bbox.getLowerLeftX(), 0) != 0 || Float.compare(bbox.getLowerLeftY(), 0) != 0 || Float.compare(bbox.getUpperRightX(), 0) != 0 || Float.compare(bbox.getUpperRightY(), 0) != 0)) {            return new BoundingBox(bbox.getLowerLeftX(), bbox.getLowerLeftY(), bbox.getUpperRightX(), bbox.getUpperRightY());        }    }    return ttf.getFontBBox();}
public int pdfbox_f4595_0(int code)
{    CMap cMap = parent.getCMap();        if (!cMap.hasCIDMappings() && cMap.hasUnicodeMappings()) {                return cMap.toUnicode(code).codePointAt(0);    }    return cMap.toCID(code);}
public int pdfbox_f4596_1(int code) throws IOException
{    if (!isEmbedded) {                if (cid2gid != null && !isDamaged) {                                    int cid = codeToCID(code);            return cid2gid[cid];        } else {                        String unicode = parent.toUnicode(code);            if (unicode == null) {                if (!noMapping.contains(code)) {                                        noMapping.add(code);                                    }                                return codeToCID(code);            } else if (unicode.length() > 1) {                            }                        return cmap.getGlyphId(unicode.codePointAt(0));        }    } else {                                int cid = codeToCID(code);        if (cid2gid != null) {                        if (cid < cid2gid.length) {                return cid2gid[cid];            } else {                return 0;            }        } else {                        if (cid < ttf.getNumberOfGlyphs()) {                return cid;            } else {                                return 0;            }        }    }}
public float pdfbox_f4597_0(int code) throws IOException
{        return (ttf.getHorizontalHeader().getAscender() + -ttf.getHorizontalHeader().getDescender()) /     ttf.getUnitsPerEm();}
public float pdfbox_f4598_0(int code) throws IOException
{    int gid = codeToGID(code);    int width = ttf.getAdvanceWidth(gid);    int unitsPerEM = ttf.getUnitsPerEm();    if (unitsPerEM != 1000) {        width *= 1000f / unitsPerEM;    }    return width;}
public byte[] pdfbox_f4599_0(int unicode)
{    int cid = -1;    if (isEmbedded) {                if (parent.getCMap().getName().startsWith("Identity-")) {            if (cmap != null) {                cid = cmap.getGlyphId(unicode);            }        } else {                        if (parent.getCMapUCS2() != null) {                cid = parent.getCMapUCS2().toCID(unicode);            }        }                if (cid == -1) {                                    cid = 0;        }    } else {                cid = cmap.getGlyphId(unicode);    }    if (cid == 0) {        throw new IllegalArgumentException(String.format("No glyph for U+%04X (%c) in font %s", unicode, (char) unicode, getName()));    }    return encodeGlyphId(cid);}
public byte[] pdfbox_f4600_0(int glyphId)
{        return new byte[] { (byte) (glyphId >> 8 & 0xff), (byte) (glyphId & 0xff) };}
public boolean pdfbox_f4601_0()
{    return isEmbedded;}
public boolean pdfbox_f4602_0()
{    return isDamaged;}
public TrueTypeFont pdfbox_f4603_0()
{    return ttf;}
public GeneralPath pdfbox_f4604_0(int code) throws IOException
{    if (ttf instanceof OpenTypeFont && ((OpenTypeFont) ttf).isPostScript()) {                        int cid = codeToGID(code);        Type2CharString charstring = ((OpenTypeFont) ttf).getCFF().getFont().getType2CharString(cid);        return charstring.getPath();    } else {        int gid = codeToGID(code);        GlyphData glyph = ttf.getGlyph().getGlyph(gid);        if (glyph != null) {            return glyph.getPath();        }        return new GeneralPath();    }}
public GeneralPath pdfbox_f4605_0(int code) throws IOException
{    boolean hasScaling = ttf.getUnitsPerEm() != 1000;    float scale = 1000f / ttf.getUnitsPerEm();    int gid = codeToGID(code);    GeneralPath path = getPath(code);        if (gid == 0 && !isEmbedded()) {        path = null;    }    if (path == null) {                return new GeneralPath();    } else {        if (hasScaling) {            path.transform(AffineTransform.getScaleInstance(scale, scale));        }        return path;    }}
public boolean pdfbox_f4606_0(int code) throws IOException
{    return codeToGID(code) != 0;}
protected void pdfbox_f4607_0(InputStream ttfSubset, String tag, Map<Integer, Integer> gidToCid) throws IOException
{        Map<Integer, Integer> cidToGid = new HashMap<>(gidToCid.size());    for (Map.Entry<Integer, Integer> entry : gidToCid.entrySet()) {        int newGID = entry.getKey();        int oldGID = entry.getValue();        cidToGid.put(oldGID, newGID);    }        buildToUnicodeCMap(gidToCid);        if (vertical) {        buildVerticalMetrics(cidToGid);    }        buildFontFile2(ttfSubset);    addNameTag(tag);    buildWidths(cidToGid);    buildCIDToGIDMap(cidToGid);    buildCIDSet(cidToGid);}
private void pdfbox_f4608_0(Map<Integer, Integer> newGIDToOldCID) throws IOException
{    ToUnicodeWriter toUniWriter = new ToUnicodeWriter();    boolean hasSurrogates = false;    for (int gid = 1, max = ttf.getMaximumProfile().getNumGlyphs(); gid <= max; gid++) {                int cid;        if (newGIDToOldCID != null) {            if (!newGIDToOldCID.containsKey(gid)) {                continue;            } else {                cid = newGIDToOldCID.get(gid);            }        } else {            cid = gid;        }                        List<Integer> codes = cmapLookup.getCharCodes(cid);        if (codes != null) {                        int codePoint = codes.get(0);            if (codePoint > 0xFFFF) {                hasSurrogates = true;            }            toUniWriter.add(cid, new String(new int[] { codePoint }, 0, 1));        }    }    ByteArrayOutputStream out = new ByteArrayOutputStream();    toUniWriter.writeTo(out);    InputStream cMapStream = new ByteArrayInputStream(out.toByteArray());    PDStream stream = new PDStream(document, cMapStream, COSName.FLATE_DECODE);        if (hasSurrogates) {        float version = document.getVersion();        if (version < 1.5) {            document.setVersion(1.5f);        }    }    dict.setItem(COSName.TO_UNICODE, stream);}
private COSDictionary pdfbox_f4609_0(String registry, String ordering, int supplement)
{    COSDictionary info = new COSDictionary();    info.setString(COSName.REGISTRY, registry);    info.setString(COSName.ORDERING, ordering);    info.setInt(COSName.SUPPLEMENT, supplement);    return info;}
private COSDictionary pdfbox_f4610_0() throws IOException
{    COSDictionary cidFont = new COSDictionary();        cidFont.setItem(COSName.TYPE, COSName.FONT);    cidFont.setItem(COSName.SUBTYPE, COSName.CID_FONT_TYPE2);        cidFont.setName(COSName.BASE_FONT, fontDescriptor.getFontName());        COSDictionary info = toCIDSystemInfo("Adobe", "Identity", 0);    cidFont.setItem(COSName.CIDSYSTEMINFO, info);        cidFont.setItem(COSName.FONT_DESC, fontDescriptor.getCOSObject());        buildWidths(cidFont);        if (vertical) {        buildVerticalMetrics(cidFont);    }        cidFont.setItem(COSName.CID_TO_GID_MAP, COSName.IDENTITY);    return cidFont;}
private void pdfbox_f4611_0(String tag) throws IOException
{    String name = fontDescriptor.getFontName();    String newName = tag + name;    dict.setName(COSName.BASE_FONT, newName);    fontDescriptor.setFontName(newName);    cidFont.setName(COSName.BASE_FONT, newName);}
private void pdfbox_f4612_0(Map<Integer, Integer> cidToGid) throws IOException
{    ByteArrayOutputStream out = new ByteArrayOutputStream();    int cidMax = Collections.max(cidToGid.keySet());    for (int i = 0; i <= cidMax; i++) {        int gid;        if (cidToGid.containsKey(i)) {            gid = cidToGid.get(i);        } else {            gid = 0;        }        out.write(new byte[] { (byte) (gid >> 8 & 0xff), (byte) (gid & 0xff) });    }    InputStream input = new ByteArrayInputStream(out.toByteArray());    PDStream stream = new PDStream(document, input, COSName.FLATE_DECODE);    cidFont.setItem(COSName.CID_TO_GID_MAP, stream);}
private void pdfbox_f4613_0(Map<Integer, Integer> cidToGid) throws IOException
{    int cidMax = Collections.max(cidToGid.keySet());    byte[] bytes = new byte[cidMax / 8 + 1];    for (int cid = 0; cid <= cidMax; cid++) {        int mask = 1 << 7 - cid % 8;        bytes[cid / 8] |= mask;    }    InputStream input = new ByteArrayInputStream(bytes);    PDStream stream = new PDStream(document, input, COSName.FLATE_DECODE);    fontDescriptor.setCIDSet(stream);}
private void pdfbox_f4614_0(Map<Integer, Integer> cidToGid) throws IOException
{    float scaling = 1000f / ttf.getHeader().getUnitsPerEm();    COSArray widths = new COSArray();    COSArray ws = new COSArray();    int prev = Integer.MIN_VALUE;        Set<Integer> keys = new TreeSet<>(cidToGid.keySet());    for (int cid : keys) {        int gid = cidToGid.get(cid);        long width = Math.round(ttf.getHorizontalMetrics().getAdvanceWidth(gid) * scaling);        if (width == 1000) {                        continue;        }                if (prev != cid - 1) {            ws = new COSArray();                        widths.add(COSInteger.get(cid));            widths.add(ws);        }                ws.add(COSInteger.get(width));        prev = cid;    }    cidFont.setItem(COSName.W, widths);}
private boolean pdfbox_f4615_1(COSDictionary cidFont) throws IOException
{    VerticalHeaderTable vhea = ttf.getVerticalHeader();    if (vhea == null) {                return false;    }    float scaling = 1000f / ttf.getHeader().getUnitsPerEm();    long v = Math.round(vhea.getAscender() * scaling);    long w1 = Math.round(-vhea.getAdvanceHeightMax() * scaling);    if (v != 880 || w1 != -1000) {        COSArray cosDw2 = new COSArray();        cosDw2.add(COSInteger.get(v));        cosDw2.add(COSInteger.get(w1));        cidFont.setItem(COSName.DW2, cosDw2);    }    return true;}
private void pdfbox_f4616_0(Map<Integer, Integer> cidToGid) throws IOException
{    if (!buildVerticalHeader(cidFont)) {        return;    }    float scaling = 1000f / ttf.getHeader().getUnitsPerEm();    VerticalHeaderTable vhea = ttf.getVerticalHeader();    VerticalMetricsTable vmtx = ttf.getVerticalMetrics();    GlyphTable glyf = ttf.getGlyph();    HorizontalMetricsTable hmtx = ttf.getHorizontalMetrics();    long v_y = Math.round(vhea.getAscender() * scaling);    long w1 = Math.round(-vhea.getAdvanceHeightMax() * scaling);    COSArray heights = new COSArray();    COSArray w2 = new COSArray();    int prev = Integer.MIN_VALUE;        Set<Integer> keys = new TreeSet<>(cidToGid.keySet());    for (int cid : keys) {                        GlyphData glyph = glyf.getGlyph(cid);        if (glyph == null) {            continue;        }        long height = Math.round((glyph.getYMaximum() + vmtx.getTopSideBearing(cid)) * scaling);        long advance = Math.round(-vmtx.getAdvanceHeight(cid) * scaling);        if (height == v_y && advance == w1) {                        continue;        }                if (prev != cid - 1) {            w2 = new COSArray();                        heights.add(COSInteger.get(cid));            heights.add(w2);        }                w2.add(COSInteger.get(advance));        long width = Math.round(hmtx.getAdvanceWidth(cid) * scaling);                w2.add(COSInteger.get(width / 2));                w2.add(COSInteger.get(height));        prev = cid;    }    cidFont.setItem(COSName.W2, heights);}
private void pdfbox_f4617_0(COSDictionary cidFont) throws IOException
{    int cidMax = ttf.getNumberOfGlyphs();    int[] gidwidths = new int[cidMax * 2];    for (int cid = 0; cid < cidMax; cid++) {        gidwidths[cid * 2] = cid;        gidwidths[cid * 2 + 1] = ttf.getHorizontalMetrics().getAdvanceWidth(cid);    }    cidFont.setItem(COSName.W, getWidths(gidwidths));}
private COSArray pdfbox_f4618_0(int[] widths) throws IOException
{    if (widths.length == 0) {        throw new IllegalArgumentException("length of widths must be > 0");    }    float scaling = 1000f / ttf.getHeader().getUnitsPerEm();    long lastCid = widths[0];    long lastValue = Math.round(widths[1] * scaling);    COSArray inner = new COSArray();    COSArray outer = new COSArray();    outer.add(COSInteger.get(lastCid));    State state = State.FIRST;    for (int i = 2; i < widths.length; i += 2) {        long cid = widths[i];        long value = Math.round(widths[i + 1] * scaling);        switch(state) {            case FIRST:                if (cid == lastCid + 1 && value == lastValue) {                    state = State.SERIAL;                } else if (cid == lastCid + 1) {                    state = State.BRACKET;                    inner = new COSArray();                    inner.add(COSInteger.get(lastValue));                } else {                    inner = new COSArray();                    inner.add(COSInteger.get(lastValue));                    outer.add(inner);                    outer.add(COSInteger.get(cid));                }                break;            case BRACKET:                if (cid == lastCid + 1 && value == lastValue) {                    state = State.SERIAL;                    outer.add(inner);                    outer.add(COSInteger.get(lastCid));                } else if (cid == lastCid + 1) {                    inner.add(COSInteger.get(lastValue));                } else {                    state = State.FIRST;                    inner.add(COSInteger.get(lastValue));                    outer.add(inner);                    outer.add(COSInteger.get(cid));                }                break;            case SERIAL:                if (cid != lastCid + 1 || value != lastValue) {                    outer.add(COSInteger.get(lastCid));                    outer.add(COSInteger.get(lastValue));                    outer.add(COSInteger.get(cid));                    state = State.FIRST;                }                break;        }        lastValue = value;        lastCid = cid;    }    switch(state) {        case FIRST:            inner = new COSArray();            inner.add(COSInteger.get(lastValue));            outer.add(inner);            break;        case BRACKET:            inner.add(COSInteger.get(lastValue));            outer.add(inner);            break;        case SERIAL:            outer.add(COSInteger.get(lastCid));            outer.add(COSInteger.get(lastValue));            break;    }    return outer;}
private void pdfbox_f4619_0(COSDictionary cidFont) throws IOException
{    if (!buildVerticalHeader(cidFont)) {        return;    }    int cidMax = ttf.getNumberOfGlyphs();    int[] gidMetrics = new int[cidMax * 4];    for (int cid = 0; cid < cidMax; cid++) {        GlyphData glyph = ttf.getGlyph().getGlyph(cid);        if (glyph == null) {            gidMetrics[cid * 4] = Integer.MIN_VALUE;        } else {            gidMetrics[cid * 4] = cid;            gidMetrics[cid * 4 + 1] = ttf.getVerticalMetrics().getAdvanceHeight(cid);            gidMetrics[cid * 4 + 2] = ttf.getHorizontalMetrics().getAdvanceWidth(cid);            gidMetrics[cid * 4 + 3] = glyph.getYMaximum() + ttf.getVerticalMetrics().getTopSideBearing(cid);        }    }    cidFont.setItem(COSName.W2, getVerticalMetrics(gidMetrics));}
private COSArray pdfbox_f4620_0(int[] values) throws IOException
{    if (values.length == 0) {        throw new IllegalArgumentException("length of values must be > 0");    }    float scaling = 1000f / ttf.getHeader().getUnitsPerEm();    long lastCid = values[0];    long lastW1Value = Math.round(-values[1] * scaling);    long lastVxValue = Math.round(values[2] * scaling / 2f);    long lastVyValue = Math.round(values[3] * scaling);    COSArray inner = new COSArray();    COSArray outer = new COSArray();    outer.add(COSInteger.get(lastCid));    State state = State.FIRST;    for (int i = 4; i < values.length; i += 4) {        long cid = values[i];        if (cid == Integer.MIN_VALUE) {                        continue;        }        long w1Value = Math.round(-values[i + 1] * scaling);        long vxValue = Math.round(values[i + 2] * scaling / 2);        long vyValue = Math.round(values[i + 3] * scaling);        switch(state) {            case FIRST:                if (cid == lastCid + 1 && w1Value == lastW1Value && vxValue == lastVxValue && vyValue == lastVyValue) {                    state = State.SERIAL;                } else if (cid == lastCid + 1) {                    state = State.BRACKET;                    inner = new COSArray();                    inner.add(COSInteger.get(lastW1Value));                    inner.add(COSInteger.get(lastVxValue));                    inner.add(COSInteger.get(lastVyValue));                } else {                    inner = new COSArray();                    inner.add(COSInteger.get(lastW1Value));                    inner.add(COSInteger.get(lastVxValue));                    inner.add(COSInteger.get(lastVyValue));                    outer.add(inner);                    outer.add(COSInteger.get(cid));                }                break;            case BRACKET:                if (cid == lastCid + 1 && w1Value == lastW1Value && vxValue == lastVxValue && vyValue == lastVyValue) {                    state = State.SERIAL;                    outer.add(inner);                    outer.add(COSInteger.get(lastCid));                } else if (cid == lastCid + 1) {                    inner.add(COSInteger.get(lastW1Value));                    inner.add(COSInteger.get(lastVxValue));                    inner.add(COSInteger.get(lastVyValue));                } else {                    state = State.FIRST;                    inner.add(COSInteger.get(lastW1Value));                    inner.add(COSInteger.get(lastVxValue));                    inner.add(COSInteger.get(lastVyValue));                    outer.add(inner);                    outer.add(COSInteger.get(cid));                }                break;            case SERIAL:                if (cid != lastCid + 1 || w1Value != lastW1Value || vxValue != lastVxValue || vyValue != lastVyValue) {                    outer.add(COSInteger.get(lastCid));                    outer.add(COSInteger.get(lastW1Value));                    outer.add(COSInteger.get(lastVxValue));                    outer.add(COSInteger.get(lastVyValue));                    outer.add(COSInteger.get(cid));                    state = State.FIRST;                }                break;        }        lastW1Value = w1Value;        lastVxValue = vxValue;        lastVyValue = vyValue;        lastCid = cid;    }    switch(state) {        case FIRST:            inner = new COSArray();            inner.add(COSInteger.get(lastW1Value));            inner.add(COSInteger.get(lastVxValue));            inner.add(COSInteger.get(lastVyValue));            outer.add(inner);            break;        case BRACKET:            inner.add(COSInteger.get(lastW1Value));            inner.add(COSInteger.get(lastVxValue));            inner.add(COSInteger.get(lastVyValue));            outer.add(inner);            break;        case SERIAL:            outer.add(COSInteger.get(lastCid));            outer.add(COSInteger.get(lastW1Value));            outer.add(COSInteger.get(lastVxValue));            outer.add(COSInteger.get(lastVyValue));            break;    }    return outer;}
public PDCIDFont pdfbox_f4621_0() throws IOException
{    return new PDCIDFontType2(cidFont, parent, ttf);}
public String pdfbox_f4622_0()
{    return dictionary.getNameAsString(COSName.REGISTRY);}
public String pdfbox_f4623_0()
{    return dictionary.getNameAsString(COSName.ORDERING);}
public int pdfbox_f4624_0()
{    return dictionary.getInt(COSName.SUPPLEMENT);}
public COSBase pdfbox_f4625_0()
{    return dictionary;}
public String pdfbox_f4626_0()
{    return getRegistry() + "-" + getOrdering() + "-" + getSupplement();}
private PDFontDescriptor pdfbox_f4627_0()
{    COSDictionary fd = (COSDictionary) dict.getDictionaryObject(COSName.FONT_DESC);    if (fd != null) {        return new PDFontDescriptor(fd);    } else if (afmStandard14 != null) {                return PDType1FontEmbedder.buildFontDescriptor(afmStandard14);    } else {        return null;    }}
private CMap pdfbox_f4628_1()
{    COSBase toUnicode = dict.getDictionaryObject(COSName.TO_UNICODE);    if (toUnicode == null) {        return null;    }    CMap cmap = null;    try {        cmap = readCMap(toUnicode);        if (cmap != null && !cmap.hasUnicodeMappings()) {                        String cmapName = cmap.getName() != null ? cmap.getName() : "";            String ordering = cmap.getOrdering() != null ? cmap.getOrdering() : "";            COSBase encoding = dict.getDictionaryObject(COSName.ENCODING);            if (            cmapName.contains("Identity") ||             ordering.contains("Identity") ||             COSName.IDENTITY_H.equals(encoding) || COSName.IDENTITY_V.equals(encoding)) {                                cmap = CMapManager.getPredefinedCMap(COSName.IDENTITY_H.getName());            }        }    } catch (IOException ex) {            }    return cmap;}
protected final FontMetrics pdfbox_f4629_0()
{    return afmStandard14;}
public PDFontDescriptor pdfbox_f4630_0()
{    return fontDescriptor;}
protected final void pdfbox_f4631_0(PDFontDescriptor fontDescriptor)
{    this.fontDescriptor = fontDescriptor;}
protected final CMap pdfbox_f4632_0(COSBase base) throws IOException
{    if (base instanceof COSName) {                String name = ((COSName) base).getName();        return CMapManager.getPredefinedCMap(name);    } else if (base instanceof COSStream) {                InputStream input = null;        try {            input = ((COSStream) base).createInputStream();            return CMapManager.parseCMap(input);        } finally {            IOUtils.closeQuietly(input);        }    } else {        throw new IOException("Expected Name or Stream");    }}
public COSDictionary pdfbox_f4633_0()
{    return dict;}
public Vector pdfbox_f4634_0(int code)
{    throw new UnsupportedOperationException("Horizontal fonts have no position vector");}
public Vector pdfbox_f4635_0(int code) throws IOException
{    return new Vector(getWidth(code) / 1000, 0);}
public float pdfbox_f4636_0(int code) throws IOException
{    Float width = codeToWidthMap.get(code);    if (width != null) {        return width;    }        if (dict.getDictionaryObject(COSName.WIDTHS) != null || dict.containsKey(COSName.MISSING_WIDTH)) {        int firstChar = dict.getInt(COSName.FIRST_CHAR, -1);        int lastChar = dict.getInt(COSName.LAST_CHAR, -1);        int siz = getWidths().size();        int idx = code - firstChar;        if (siz > 0 && code >= firstChar && code <= lastChar && idx < siz) {            width = getWidths().get(idx);            if (width == null) {                width = 0f;            }            codeToWidthMap.put(code, width);            return width;        }        PDFontDescriptor fd = getFontDescriptor();        if (fd != null) {                        width = fd.getMissingWidth();            codeToWidthMap.put(code, width);            return width;        }    }        if (isStandard14()) {        width = getStandard14Width(code);        codeToWidthMap.put(code, width);        return width;    }        width = getWidthFromFont(code);    codeToWidthMap.put(code, width);    return width;}
public final byte[] pdfbox_f4637_0(String text) throws IOException
{    ByteArrayOutputStream out = new ByteArrayOutputStream();    int offset = 0;    while (offset < text.length()) {        int codePoint = text.codePointAt(offset);                byte[] bytes = encode(codePoint);        out.write(bytes);        offset += Character.charCount(codePoint);    }    return out.toByteArray();}
public float pdfbox_f4638_0(String text) throws IOException
{    byte[] bytes = encode(text);    ByteArrayInputStream in = new ByteArrayInputStream(bytes);    float width = 0;    while (in.available() > 0) {        int code = readCode(in);        width += getWidth(code);    }    return width;}
public float pdfbox_f4639_0()
{    float average;    if (Float.compare(avgFontWidth, 0.0f) != 0) {        average = avgFontWidth;    } else {        float totalWidth = 0.0f;        float characterCount = 0.0f;        COSArray widths = (COSArray) dict.getDictionaryObject(COSName.WIDTHS);        if (widths != null) {            for (int i = 0; i < widths.size(); i++) {                COSNumber fontWidth = (COSNumber) widths.getObject(i);                if (fontWidth.floatValue() > 0) {                    totalWidth += fontWidth.floatValue();                    characterCount += 1;                }            }        }        if (totalWidth > 0) {            average = totalWidth / characterCount;        } else {            average = 0;        }        avgFontWidth = average;    }    return average;}
public String pdfbox_f4640_0(int code, GlyphList customGlyphList) throws IOException
{    return toUnicode(code);}
public String pdfbox_f4641_0(int code) throws IOException
{        if (toUnicodeCMap != null) {        if (toUnicodeCMap.getName() != null && toUnicodeCMap.getName().startsWith("Identity-") && (dict.getDictionaryObject(COSName.TO_UNICODE) instanceof COSName || !toUnicodeCMap.hasUnicodeMappings())) {                        return new String(new char[] { (char) code });        } else {                        return toUnicodeCMap.toUnicode(code);        }    }        return null;}
public String pdfbox_f4642_0()
{    return dict.getNameAsString(COSName.TYPE);}
public String pdfbox_f4643_0()
{    return dict.getNameAsString(COSName.SUBTYPE);}
protected final List<Float> pdfbox_f4644_0()
{    if (widths == null) {        COSArray array = (COSArray) dict.getDictionaryObject(COSName.WIDTHS);        if (array != null) {            widths = COSArrayList.convertFloatCOSArrayToList(array);        } else {            widths = Collections.emptyList();        }    }    return widths;}
public Matrix pdfbox_f4645_0()
{    return DEFAULT_FONT_MATRIX;}
public float pdfbox_f4646_1()
{    if (Float.compare(fontWidthOfSpace, -1f) == 0) {        COSBase toUnicode = dict.getDictionaryObject(COSName.TO_UNICODE);        try {            if (toUnicode != null && toUnicodeCMap != null) {                int spaceMapping = toUnicodeCMap.getSpaceMapping();                if (spaceMapping > -1) {                    fontWidthOfSpace = getWidth(spaceMapping);                }            } else {                fontWidthOfSpace = getWidth(32);            }                        if (fontWidthOfSpace <= 0) {                fontWidthOfSpace = getWidthFromFont(32);            }                        if (fontWidthOfSpace <= 0) {                fontWidthOfSpace = getAverageFontWidth();            }        } catch (Exception e) {                        fontWidthOfSpace = 250f;        }    }    return fontWidthOfSpace;}
public boolean pdfbox_f4647_0()
{        if (isEmbedded()) {        return false;    }        return Standard14Fonts.containsName(getName());}
public boolean pdfbox_f4648_0(Object other)
{    return other instanceof PDFont && ((PDFont) other).getCOSObject() == this.getCOSObject();}
public int pdfbox_f4649_0()
{    return this.getCOSObject().hashCode();}
public String pdfbox_f4650_0()
{    return getClass().getSimpleName() + " " + getName();}
public boolean pdfbox_f4651_0()
{    return isFlagBitOn(FLAG_FIXED_PITCH);}
public void pdfbox_f4652_0(boolean flag)
{    setFlagBit(FLAG_FIXED_PITCH, flag);}
public boolean pdfbox_f4653_0()
{    return isFlagBitOn(FLAG_SERIF);}
public void pdfbox_f4654_0(boolean flag)
{    setFlagBit(FLAG_SERIF, flag);}
public boolean pdfbox_f4655_0()
{    return isFlagBitOn(FLAG_SYMBOLIC);}
public void pdfbox_f4656_0(boolean flag)
{    setFlagBit(FLAG_SYMBOLIC, flag);}
public boolean pdfbox_f4657_0()
{    return isFlagBitOn(FLAG_SCRIPT);}
public void pdfbox_f4658_0(boolean flag)
{    setFlagBit(FLAG_SCRIPT, flag);}
public boolean pdfbox_f4659_0()
{    return isFlagBitOn(FLAG_NON_SYMBOLIC);}
public void pdfbox_f4660_0(boolean flag)
{    setFlagBit(FLAG_NON_SYMBOLIC, flag);}
public boolean pdfbox_f4661_0()
{    return isFlagBitOn(FLAG_ITALIC);}
public void pdfbox_f4662_0(boolean flag)
{    setFlagBit(FLAG_ITALIC, flag);}
public boolean pdfbox_f4663_0()
{    return isFlagBitOn(FLAG_ALL_CAP);}
public void pdfbox_f4664_0(boolean flag)
{    setFlagBit(FLAG_ALL_CAP, flag);}
public boolean pdfbox_f4665_0()
{    return isFlagBitOn(FLAG_SMALL_CAP);}
public void pdfbox_f4666_0(boolean flag)
{    setFlagBit(FLAG_SMALL_CAP, flag);}
public boolean pdfbox_f4667_0()
{    return isFlagBitOn(FLAG_FORCE_BOLD);}
public void pdfbox_f4668_0(boolean flag)
{    setFlagBit(FLAG_FORCE_BOLD, flag);}
private boolean pdfbox_f4669_0(int bit)
{    return (getFlags() & bit) != 0;}
private void pdfbox_f4670_0(int bit, boolean value)
{    int flags = getFlags();    if (value) {        flags = flags | bit;    } else {        flags = flags & (~bit);    }    setFlags(flags);}
public COSDictionary pdfbox_f4671_0()
{    return dic;}
public String pdfbox_f4672_0()
{    String retval = null;    COSBase base = dic.getDictionaryObject(COSName.FONT_NAME);    if (base instanceof COSName) {        retval = ((COSName) base).getName();    }    return retval;}
public void pdfbox_f4673_0(String fontName)
{    COSName name = null;    if (fontName != null) {        name = COSName.getPDFName(fontName);    }    dic.setItem(COSName.FONT_NAME, name);}
public String pdfbox_f4674_0()
{    String retval = null;    COSString name = (COSString) dic.getDictionaryObject(COSName.FONT_FAMILY);    if (name != null) {        retval = name.getString();    }    return retval;}
public void pdfbox_f4675_0(String fontFamily)
{    COSString name = null;    if (fontFamily != null) {        name = new COSString(fontFamily);    }    dic.setItem(COSName.FONT_FAMILY, name);}
public float pdfbox_f4676_0()
{    return dic.getFloat(COSName.FONT_WEIGHT, 0);}
public void pdfbox_f4677_0(float fontWeight)
{    dic.setFloat(COSName.FONT_WEIGHT, fontWeight);}
public String pdfbox_f4678_0()
{    String retval = null;    COSName name = (COSName) dic.getDictionaryObject(COSName.FONT_STRETCH);    if (name != null) {        retval = name.getName();    }    return retval;}
public void pdfbox_f4679_0(String fontStretch)
{    COSName name = null;    if (fontStretch != null) {        name = COSName.getPDFName(fontStretch);    }    dic.setItem(COSName.FONT_STRETCH, name);}
public int pdfbox_f4680_0()
{    if (flags == -1) {        flags = dic.getInt(COSName.FLAGS, 0);    }    return flags;}
public void pdfbox_f4681_0(int flags)
{    dic.setInt(COSName.FLAGS, flags);    this.flags = flags;}
public PDRectangle pdfbox_f4682_0()
{    COSArray rect = (COSArray) dic.getDictionaryObject(COSName.FONT_BBOX);    PDRectangle retval = null;    if (rect != null) {        retval = new PDRectangle(rect);    }    return retval;}
public void pdfbox_f4683_0(PDRectangle rect)
{    COSArray array = null;    if (rect != null) {        array = rect.getCOSArray();    }    dic.setItem(COSName.FONT_BBOX, array);}
public float pdfbox_f4684_0()
{    return dic.getFloat(COSName.ITALIC_ANGLE, 0);}
public void pdfbox_f4685_0(float angle)
{    dic.setFloat(COSName.ITALIC_ANGLE, angle);}
public float pdfbox_f4686_0()
{    return dic.getFloat(COSName.ASCENT, 0);}
public void pdfbox_f4687_0(float ascent)
{    dic.setFloat(COSName.ASCENT, ascent);}
public float pdfbox_f4688_0()
{    return dic.getFloat(COSName.DESCENT, 0);}
public void pdfbox_f4689_0(float descent)
{    dic.setFloat(COSName.DESCENT, descent);}
public float pdfbox_f4690_0()
{    return dic.getFloat(COSName.LEADING, 0);}
public void pdfbox_f4691_0(float leading)
{    dic.setFloat(COSName.LEADING, leading);}
public float pdfbox_f4692_0()
{    if (Float.compare(capHeight, Float.NEGATIVE_INFINITY) == 0) {        /* We observed a negative value being returned with             * the Scheherazade font. PDFBOX-429 was logged for this.             * We are not sure if returning the absolute value             * is the correct fix, but it seems to work.  */        capHeight = java.lang.Math.abs(dic.getFloat(COSName.CAP_HEIGHT, 0));    }    return capHeight;}
public void pdfbox_f4693_0(float capHeight)
{    dic.setFloat(COSName.CAP_HEIGHT, capHeight);    this.capHeight = capHeight;}
public float pdfbox_f4694_0()
{    if (Float.compare(xHeight, Float.NEGATIVE_INFINITY) == 0) {        /* We observed a negative value being returned with             * the Scheherazade font. PDFBOX-429 was logged for this.             * We are not sure if returning the absolute value             * is the correct fix, but it seems to work.  */        xHeight = java.lang.Math.abs(dic.getFloat(COSName.XHEIGHT, 0));    }    return xHeight;}
public void pdfbox_f4695_0(float xHeight)
{    dic.setFloat(COSName.XHEIGHT, xHeight);    this.xHeight = xHeight;}
public float pdfbox_f4696_0()
{    return dic.getFloat(COSName.STEM_V, 0);}
public void pdfbox_f4697_0(float stemV)
{    dic.setFloat(COSName.STEM_V, stemV);}
public float pdfbox_f4698_0()
{    return dic.getFloat(COSName.STEM_H, 0);}
public void pdfbox_f4699_0(float stemH)
{    dic.setFloat(COSName.STEM_H, stemH);}
public float pdfbox_f4700_0()
{    return dic.getFloat(COSName.AVG_WIDTH, 0);}
public void pdfbox_f4701_0(float averageWidth)
{    dic.setFloat(COSName.AVG_WIDTH, averageWidth);}
public float pdfbox_f4702_0()
{    return dic.getFloat(COSName.MAX_WIDTH, 0);}
public void pdfbox_f4703_0(float maxWidth)
{    dic.setFloat(COSName.MAX_WIDTH, maxWidth);}
public boolean pdfbox_f4704_0()
{    return dic.containsKey(COSName.WIDTHS) || dic.containsKey(COSName.MISSING_WIDTH);}
public boolean pdfbox_f4705_0()
{    return dic.containsKey(COSName.MISSING_WIDTH);}
public float pdfbox_f4706_0()
{    return dic.getFloat(COSName.MISSING_WIDTH, 0);}
public void pdfbox_f4707_0(float missingWidth)
{    dic.setFloat(COSName.MISSING_WIDTH, missingWidth);}
public String pdfbox_f4708_0()
{    String retval = null;    COSString name = (COSString) dic.getDictionaryObject(COSName.CHAR_SET);    if (name != null) {        retval = name.getString();    }    return retval;}
public void pdfbox_f4709_0(String charSet)
{    COSString name = null;    if (charSet != null) {        name = new COSString(charSet);    }    dic.setItem(COSName.CHAR_SET, name);}
public PDStream pdfbox_f4710_0()
{    PDStream retval = null;    COSBase obj = dic.getDictionaryObject(COSName.FONT_FILE);    if (obj instanceof COSStream) {        retval = new PDStream((COSStream) obj);    }    return retval;}
public void pdfbox_f4711_0(PDStream type1Stream)
{    dic.setItem(COSName.FONT_FILE, type1Stream);}
public PDStream pdfbox_f4712_0()
{    PDStream retval = null;    COSBase obj = dic.getDictionaryObject(COSName.FONT_FILE2);    if (obj instanceof COSStream) {        retval = new PDStream((COSStream) obj);    }    return retval;}
public void pdfbox_f4713_0(PDStream ttfStream)
{    dic.setItem(COSName.FONT_FILE2, ttfStream);}
public PDStream pdfbox_f4714_0()
{    PDStream retval = null;    COSBase obj = dic.getDictionaryObject(COSName.FONT_FILE3);    if (obj instanceof COSStream) {        retval = new PDStream((COSStream) obj);    }    return retval;}
public void pdfbox_f4715_0(PDStream stream)
{    dic.setItem(COSName.FONT_FILE3, stream);}
public PDStream pdfbox_f4716_0()
{    COSObjectable cidSet = dic.getDictionaryObject(COSName.CID_SET);    if (cidSet instanceof COSStream) {        return new PDStream((COSStream) cidSet);    }    return null;}
public void pdfbox_f4717_0(PDStream stream)
{    dic.setItem(COSName.CID_SET, stream);}
public PDPanose pdfbox_f4718_0()
{    COSDictionary style = (COSDictionary) dic.getDictionaryObject(COSName.STYLE);    if (style != null) {        COSString panose = (COSString) style.getDictionaryObject(COSName.PANOSE);        byte[] bytes = panose.getBytes();        return new PDPanose(bytes);    }    return null;}
public static PDFont pdfbox_f4719_0(COSDictionary dictionary) throws IOException
{    return createFont(dictionary, null);}
public static PDFont pdfbox_f4720_1(COSDictionary dictionary, ResourceCache resourceCache) throws IOException
{    COSName type = dictionary.getCOSName(COSName.TYPE, COSName.FONT);    if (!COSName.FONT.equals(type)) {            }    COSName subType = dictionary.getCOSName(COSName.SUBTYPE);    if (COSName.TYPE1.equals(subType)) {        COSBase fd = dictionary.getDictionaryObject(COSName.FONT_DESC);        if (fd instanceof COSDictionary && ((COSDictionary) fd).containsKey(COSName.FONT_FILE3)) {            return new PDType1CFont(dictionary);        }        return new PDType1Font(dictionary);    } else if (COSName.MM_TYPE1.equals(subType)) {        COSBase fd = dictionary.getDictionaryObject(COSName.FONT_DESC);        if (fd instanceof COSDictionary && ((COSDictionary) fd).containsKey(COSName.FONT_FILE3)) {            return new PDType1CFont(dictionary);        }        return new PDMMType1Font(dictionary);    } else if (COSName.TRUE_TYPE.equals(subType)) {        return new PDTrueTypeFont(dictionary);    } else if (COSName.TYPE3.equals(subType)) {        return new PDType3Font(dictionary, resourceCache);    } else if (COSName.TYPE0.equals(subType)) {        return new PDType0Font(dictionary);    } else if (COSName.CID_FONT_TYPE0.equals(subType)) {        throw new IllegalArgumentException("Type 0 descendant font not allowed");    } else if (COSName.CID_FONT_TYPE2.equals(subType)) {        throw new IllegalArgumentException("Type 2 descendant font not allowed");    } else {                                return new PDType1Font(dictionary);    }}
 static PDCIDFont pdfbox_f4721_0(COSDictionary dictionary, PDType0Font parent) throws IOException
{    COSName type = dictionary.getCOSName(COSName.TYPE, COSName.FONT);    if (!COSName.FONT.equals(type)) {        throw new IllegalArgumentException("Expected 'Font' dictionary but found '" + type.getName() + "'");    }    COSName subType = dictionary.getCOSName(COSName.SUBTYPE);    if (COSName.CID_FONT_TYPE0.equals(subType)) {        return new PDCIDFontType0(dictionary, parent);    } else if (COSName.CID_FONT_TYPE2.equals(subType)) {        return new PDCIDFontType2(dictionary, parent);    } else {        throw new IOException("Invalid font type: " + type);    }}
public static PDFont pdfbox_f4722_0() throws IOException
{    COSDictionary dict = new COSDictionary();    dict.setItem(COSName.TYPE, COSName.FONT);    dict.setItem(COSName.SUBTYPE, COSName.TRUE_TYPE);    dict.setString(COSName.BASE_FONT, "Arial");    return createFont(dict);}
public int pdfbox_f4723_0()
{    return bytes[0] << 8 | bytes[1];}
public PDPanoseClassification pdfbox_f4724_0()
{    byte[] panose = Arrays.copyOfRange(bytes, 2, 12);    return new PDPanoseClassification(panose);}
public int pdfbox_f4725_0()
{    return bytes[0];}
public int pdfbox_f4726_0()
{    return bytes[1];}
public int pdfbox_f4727_0()
{    return bytes[2];}
public int pdfbox_f4728_0()
{    return bytes[3];}
public int pdfbox_f4729_0()
{    return bytes[4];}
public int pdfbox_f4730_0()
{    return bytes[5];}
public int pdfbox_f4731_0()
{    return bytes[6];}
public int pdfbox_f4732_0()
{    return bytes[7];}
public int pdfbox_f4733_0()
{    return bytes[8];}
public int pdfbox_f4734_0()
{    return bytes[9];}
public byte[] pdfbox_f4735_0()
{    return bytes;}
public String pdfbox_f4736_0()
{    return "{ FamilyKind = " + getFamilyKind() + ", " + "SerifStyle = " + getSerifStyle() + ", " + "Weight = " + getWeight() + ", " + "Proportion = " + getProportion() + ", " + "Contrast = " + getContrast() + ", " + "StrokeVariation = " + getStrokeVariation() + ", " + "ArmStyle = " + getArmStyle() + ", " + "Letterform = " + getLetterform() + ", " + "Midline = " + getMidline() + ", " + "XHeight = " + getXHeight() + "}";}
protected void pdfbox_f4737_1() throws IOException
{    COSBase encoding = dict.getDictionaryObject(COSName.ENCODING);    if (encoding != null) {        if (encoding instanceof COSName) {            COSName encodingName = (COSName) encoding;            this.encoding = Encoding.getInstance(encodingName);            if (this.encoding == null) {                                                this.encoding = readEncodingFromFont();            }        } else if (encoding instanceof COSDictionary) {            COSDictionary encodingDict = (COSDictionary) encoding;            Encoding builtIn = null;            Boolean symbolic = getSymbolicFlag();            boolean isFlaggedAsSymbolic = symbolic != null && symbolic;            COSName baseEncoding = encodingDict.getCOSName(COSName.BASE_ENCODING);            boolean hasValidBaseEncoding = baseEncoding != null && Encoding.getInstance(baseEncoding) != null;            if (!hasValidBaseEncoding && isFlaggedAsSymbolic) {                builtIn = readEncodingFromFont();            }            if (symbolic == null) {                symbolic = false;            }            this.encoding = new DictionaryEncoding(encodingDict, !symbolic, builtIn);        }    } else {        this.encoding = readEncodingFromFont();    }        String standard14Name = Standard14Fonts.getMappedFontName(getName());        if ("ZapfDingbats".equals(standard14Name)) {        glyphList = GlyphList.getZapfDingbats();    } else {                glyphList = GlyphList.getAdobeGlyphList();    }}
public Encoding pdfbox_f4738_0()
{    return encoding;}
public GlyphList pdfbox_f4739_0()
{    return glyphList;}
public final boolean pdfbox_f4740_0()
{    if (isSymbolic == null) {        Boolean result = isFontSymbolic();        if (result != null) {            isSymbolic = result;        } else {                        isSymbolic = true;        }    }    return isSymbolic;}
protected Boolean pdfbox_f4741_0()
{    Boolean result = getSymbolicFlag();    if (result != null) {        return result;    } else if (isStandard14()) {        String mappedName = Standard14Fonts.getMappedFontName(getName());        return mappedName.equals("Symbol") || mappedName.equals("ZapfDingbats");    } else {        if (encoding == null) {                        if (!(this instanceof PDTrueTypeFont)) {                throw new IllegalStateException("PDFBox bug: encoding should not be null!");            }                        return true;        } else if (encoding instanceof WinAnsiEncoding || encoding instanceof MacRomanEncoding || encoding instanceof StandardEncoding) {            return false;        } else if (encoding instanceof DictionaryEncoding) {                        for (String name : ((DictionaryEncoding) encoding).getDifferences().values()) {                if (".notdef".equals(name)) {                                } else if (!(WinAnsiEncoding.INSTANCE.contains(name) && MacRomanEncoding.INSTANCE.contains(name) && StandardEncoding.INSTANCE.contains(name))) {                    return true;                }            }            return false;        } else {                        return null;        }    }}
protected final Boolean pdfbox_f4742_0()
{    if (getFontDescriptor() != null) {                return getFontDescriptor().isSymbolic();    }    return null;}
public String pdfbox_f4743_0(int code) throws IOException
{    return toUnicode(code, GlyphList.getAdobeGlyphList());}
public String pdfbox_f4744_1(int code, GlyphList customGlyphList) throws IOException
{            GlyphList unicodeGlyphList;    if (this.glyphList == GlyphList.getAdobeGlyphList()) {        unicodeGlyphList = customGlyphList;    } else {        unicodeGlyphList = this.glyphList;    }        String unicode = super.toUnicode(code);    if (unicode != null) {        return unicode;    }                        String name = null;    if (encoding != null) {        name = encoding.getName(code);        unicode = unicodeGlyphList.toUnicode(name);        if (unicode != null) {            return unicode;        }    }        if (LOG.isWarnEnabled() && !noUnicode.contains(code)) {                noUnicode.add(code);        if (name != null) {                    } else {                    }    }    return null;}
public boolean pdfbox_f4745_0()
{    return false;}
protected final float pdfbox_f4746_0(int code)
{    if (getStandard14AFM() != null) {        String nameInAFM = getEncoding().getName(code);                if (".notdef".equals(nameInAFM)) {            return 250f;        }        return getStandard14AFM().getCharacterWidth(nameInAFM);    }    throw new IllegalStateException("No AFM");}
public boolean pdfbox_f4747_0()
{        if (getEncoding() instanceof DictionaryEncoding) {        DictionaryEncoding dictionary = (DictionaryEncoding) getEncoding();        if (dictionary.getDifferences().size() > 0) {                                    Encoding baseEncoding = dictionary.getBaseEncoding();            for (Map.Entry<Integer, String> entry : dictionary.getDifferences().entrySet()) {                if (!entry.getValue().equals(baseEncoding.getName(entry.getKey()))) {                    return false;                }            }        }    }    return super.isStandard14();}
protected boolean pdfbox_f4748_0(PDRectangle bbox)
{    return bbox != null && (Float.compare(bbox.getLowerLeftX(), 0) != 0 || Float.compare(bbox.getLowerLeftY(), 0) != 0 || Float.compare(bbox.getUpperRightX(), 0) != 0 || Float.compare(bbox.getUpperRightY(), 0) != 0);}
public void pdfbox_f4749_0(int codePoint)
{    throw new UnsupportedOperationException();}
public void pdfbox_f4750_0() throws IOException
{        throw new UnsupportedOperationException();}
public boolean pdfbox_f4751_0()
{    return false;}
public boolean pdfbox_f4752_0(int code) throws IOException
{    if (dict.containsKey(COSName.WIDTHS)) {        int firstChar = dict.getInt(COSName.FIRST_CHAR, -1);        if (code >= firstChar && code - firstChar < getWidths().size()) {            return true;        }    }    return false;}
public static PDTrueTypeFont pdfbox_f4753_0(PDDocument doc, File file, Encoding encoding) throws IOException
{    return new PDTrueTypeFont(doc, new TTFParser().parse(file), encoding, true);}
public static PDTrueTypeFont pdfbox_f4754_0(PDDocument doc, InputStream input, Encoding encoding) throws IOException
{    return new PDTrueTypeFont(doc, new TTFParser().parse(input), encoding, true);}
public static PDTrueTypeFont pdfbox_f4755_0(PDDocument doc, TrueTypeFont ttf, Encoding encoding) throws IOException
{    return new PDTrueTypeFont(doc, ttf, encoding, false);}
public final String pdfbox_f4756_0()
{    return dict.getNameAsString(COSName.BASE_FONT);}
protected Encoding pdfbox_f4757_0() throws IOException
{    if (!isEmbedded() && getStandard14AFM() != null) {                return new Type1Encoding(getStandard14AFM());    } else {                if (getSymbolicFlag() != null && !getSymbolicFlag()) {            return StandardEncoding.INSTANCE;        }                String standard14Name = Standard14Fonts.getMappedFontName(getName());                if (isStandard14() && !standard14Name.equals("Symbol") && !standard14Name.equals("ZapfDingbats")) {            return StandardEncoding.INSTANCE;        }                PostScriptTable post = ttf.getPostScript();        Map<Integer, String> codeToName = new HashMap<>();        for (int code = 0; code <= 256; code++) {            int gid = codeToGID(code);            if (gid > 0) {                String name = null;                if (post != null) {                    name = post.getName(gid);                }                if (name == null) {                                        name = Integer.toString(gid);                }                codeToName.put(code, name);            }        }        return new BuiltInEncoding(codeToName);    }}
public int pdfbox_f4758_0(InputStream in) throws IOException
{    return in.read();}
public String pdfbox_f4759_0()
{    return getBaseFont();}
public BoundingBox pdfbox_f4760_0() throws IOException
{    if (fontBBox == null) {        fontBBox = generateBoundingBox();    }    return fontBBox;}
private BoundingBox pdfbox_f4761_0() throws IOException
{    if (getFontDescriptor() != null) {        PDRectangle bbox = getFontDescriptor().getFontBoundingBox();        if (bbox != null) {            return new BoundingBox(bbox.getLowerLeftX(), bbox.getLowerLeftY(), bbox.getUpperRightX(), bbox.getUpperRightY());        }    }    return ttf.getFontBBox();}
public boolean pdfbox_f4762_0()
{    return isDamaged;}
public TrueTypeFont pdfbox_f4763_0()
{    return ttf;}
public float pdfbox_f4764_0(int code) throws IOException
{    int gid = codeToGID(code);    float width = ttf.getAdvanceWidth(gid);    float unitsPerEM = ttf.getUnitsPerEm();    if (Float.compare(unitsPerEM, 1000) != 0) {        width *= 1000f / unitsPerEM;    }    return width;}
public float pdfbox_f4765_0(int code) throws IOException
{    int gid = codeToGID(code);    GlyphData glyph = ttf.getGlyph().getGlyph(gid);    if (glyph != null) {        return glyph.getBoundingBox().getHeight();    }    return 0;}
protected byte[] pdfbox_f4766_0(int unicode) throws IOException
{    if (encoding != null) {        if (!encoding.contains(getGlyphList().codePointToName(unicode))) {            throw new IllegalArgumentException(String.format("U+%04X is not available in this font's encoding: %s", unicode, encoding.getEncodingName()));        }        String name = getGlyphList().codePointToName(unicode);        Map<String, Integer> inverted = encoding.getNameToCodeMap();        if (!ttf.hasGlyph(name)) {                        String uniName = getUniNameOfCodePoint(unicode);            if (!ttf.hasGlyph(uniName)) {                throw new IllegalArgumentException(String.format("No glyph for U+%04X in font %s", unicode, getName()));            }        }        int code = inverted.get(name);        return new byte[] { (byte) code };    } else {                String name = getGlyphList().codePointToName(unicode);        if (!ttf.hasGlyph(name)) {            throw new IllegalArgumentException(String.format("No glyph for U+%04X in font %s", unicode, getName()));        }        int gid = ttf.nameToGID(name);        Integer code = getGIDToCode().get(gid);        if (code == null) {            throw new IllegalArgumentException(String.format("U+%04X is not available in this font's Encoding", unicode));        }        return new byte[] { (byte) (int) code };    }}
protected Map<Integer, Integer> pdfbox_f4767_0() throws IOException
{    if (gidToCode != null) {        return gidToCode;    }    gidToCode = new HashMap<>();    for (int code = 0; code <= 255; code++) {        int gid = codeToGID(code);        if (!gidToCode.containsKey(gid)) {            gidToCode.put(gid, code);        }    }    return gidToCode;}
public boolean pdfbox_f4768_0()
{    return isEmbedded;}
public GeneralPath pdfbox_f4769_0(int code) throws IOException
{    int gid = codeToGID(code);    GlyphData glyph = ttf.getGlyph().getGlyph(gid);        if (glyph == null) {        return new GeneralPath();    } else {        return glyph.getPath();    }}
public GeneralPath pdfbox_f4770_0(String name) throws IOException
{        int gid = ttf.nameToGID(name);    if (gid == 0) {        try {                        gid = Integer.parseInt(name);            if (gid > ttf.getNumberOfGlyphs()) {                gid = 0;            }        } catch (NumberFormatException e) {            gid = 0;        }    }        if (gid == 0) {        return new GeneralPath();    }    GlyphData glyph = ttf.getGlyph().getGlyph(gid);    if (glyph != null) {        return glyph.getPath();    } else {        return new GeneralPath();    }}
public GeneralPath pdfbox_f4771_0(int code) throws IOException
{    boolean hasScaling = ttf.getUnitsPerEm() != 1000;    float scale = 1000f / ttf.getUnitsPerEm();    int gid = codeToGID(code);    GeneralPath path = getPath(code);        if (gid == 0 && !isEmbedded() && !isStandard14()) {        path = null;    }    if (path == null) {                return new GeneralPath();    } else {        if (hasScaling) {            path.transform(AffineTransform.getScaleInstance(scale, scale));        }        return path;    }}
public boolean pdfbox_f4772_0(String name) throws IOException
{    int gid = ttf.nameToGID(name);    return !(gid == 0 || gid >= ttf.getMaximumProfile().getNumGlyphs());}
public FontBoxFont pdfbox_f4773_0()
{    return ttf;}
public boolean pdfbox_f4774_0(int code) throws IOException
{    return codeToGID(code) != 0;}
public int pdfbox_f4775_0(int code) throws IOException
{    extractCmapTable();    int gid = 0;    if (    !isSymbolic()) {        String name = encoding.getName(code);        if (".notdef".equals(name)) {            return 0;        } else {                        if (cmapWinUnicode != null) {                String unicode = GlyphList.getAdobeGlyphList().toUnicode(name);                if (unicode != null) {                    int uni = unicode.codePointAt(0);                    gid = cmapWinUnicode.getGlyphId(uni);                }            }                        if (gid == 0 && cmapMacRoman != null) {                Integer macCode = INVERTED_MACOS_ROMAN.get(name);                if (macCode != null) {                    gid = cmapMacRoman.getGlyphId(macCode);                }            }                        if (gid == 0) {                gid = ttf.nameToGID(name);            }        }    } else     {                if (cmapWinSymbol != null) {            gid = cmapWinSymbol.getGlyphId(code);            if (code >= 0 && code <= 0xFF) {                                if (gid == 0) {                                        gid = cmapWinSymbol.getGlyphId(code + START_RANGE_F000);                }                if (gid == 0) {                                        gid = cmapWinSymbol.getGlyphId(code + START_RANGE_F100);                }                if (gid == 0) {                                        gid = cmapWinSymbol.getGlyphId(code + START_RANGE_F200);                }            }        }                if (gid == 0 && cmapMacRoman != null) {            gid = cmapMacRoman.getGlyphId(code);        }                if (gid == 0 && cmapWinUnicode != null && encoding != null) {            String name = encoding.getName(code);            if (".notdef".equals(name)) {                return 0;            }            String unicode = GlyphList.getAdobeGlyphList().toUnicode(name);            if (unicode != null) {                int uni = unicode.codePointAt(0);                gid = cmapWinUnicode.getGlyphId(uni);            }        }    }    return gid;}
private void pdfbox_f4776_0() throws IOException
{    if (cmapInitialized) {        return;    }    CmapTable cmapTable = ttf.getCmap();    if (cmapTable != null) {                CmapSubtable[] cmaps = cmapTable.getCmaps();        for (CmapSubtable cmap : cmaps) {            if (CmapTable.PLATFORM_WINDOWS == cmap.getPlatformId()) {                if (CmapTable.ENCODING_WIN_UNICODE_BMP == cmap.getPlatformEncodingId()) {                    cmapWinUnicode = cmap;                } else if (CmapTable.ENCODING_WIN_SYMBOL == cmap.getPlatformEncodingId()) {                    cmapWinSymbol = cmap;                }            } else if (CmapTable.PLATFORM_MACINTOSH == cmap.getPlatformId() && CmapTable.ENCODING_MAC_ROMAN == cmap.getPlatformEncodingId()) {                cmapMacRoman = cmap;            }        }    }    cmapInitialized = true;}
private void pdfbox_f4777_0(COSDictionary font, GlyphList glyphList) throws IOException
{    float scaling = 1000f / ttf.getHeader().getUnitsPerEm();    HorizontalMetricsTable hmtx = ttf.getHorizontalMetrics();    Map<Integer, String> codeToName = getFontEncoding().getCodeToNameMap();    int firstChar = Collections.min(codeToName.keySet());    int lastChar = Collections.max(codeToName.keySet());    List<Integer> widths = new ArrayList<>(lastChar - firstChar + 1);    for (int i = 0; i < lastChar - firstChar + 1; i++) {        widths.add(0);    }        for (Map.Entry<Integer, String> entry : codeToName.entrySet()) {        int code = entry.getKey();        String name = entry.getValue();        if (code >= firstChar && code <= lastChar) {            String uni = glyphList.toUnicode(name);            int charCode = uni.codePointAt(0);            int gid = cmapLookup.getGlyphId(charCode);            widths.set(entry.getKey() - firstChar, Math.round(hmtx.getAdvanceWidth(gid) * scaling));        }    }    font.setInt(COSName.FIRST_CHAR, firstChar);    font.setInt(COSName.LAST_CHAR, lastChar);    font.setItem(COSName.WIDTHS, COSArrayList.converterToCOSArray(widths));}
public Encoding pdfbox_f4778_0()
{    return fontEncoding;}
protected void pdfbox_f4779_0(InputStream ttfSubset, String tag, Map<Integer, Integer> gidToCid) throws IOException
{        throw new UnsupportedOperationException();}
public static PDType0Font pdfbox_f4780_0(PDDocument doc, File file) throws IOException
{    return new PDType0Font(doc, new TTFParser().parse(file), true, true, false);}
public static PDType0Font pdfbox_f4781_0(PDDocument doc, InputStream input) throws IOException
{    return new PDType0Font(doc, new TTFParser().parse(input), true, true, false);}
public static PDType0Font pdfbox_f4782_0(PDDocument doc, InputStream input, boolean embedSubset) throws IOException
{    return new PDType0Font(doc, new TTFParser().parse(input), embedSubset, true, false);}
public static PDType0Font pdfbox_f4783_0(PDDocument doc, TrueTypeFont ttf, boolean embedSubset) throws IOException
{    return new PDType0Font(doc, ttf, embedSubset, false, false);}
public static PDType0Font pdfbox_f4784_0(PDDocument doc, File file) throws IOException
{    return new PDType0Font(doc, new TTFParser().parse(file), true, true, true);}
public static PDType0Font pdfbox_f4785_0(PDDocument doc, InputStream input) throws IOException
{    return new PDType0Font(doc, new TTFParser().parse(input), true, true, true);}
public static PDType0Font pdfbox_f4786_0(PDDocument doc, InputStream input, boolean embedSubset) throws IOException
{    return new PDType0Font(doc, new TTFParser().parse(input), embedSubset, true, true);}
public static PDType0Font pdfbox_f4787_0(PDDocument doc, TrueTypeFont ttf, boolean embedSubset) throws IOException
{    return new PDType0Font(doc, ttf, embedSubset, false, true);}
public void pdfbox_f4788_0(int codePoint)
{    if (!willBeSubset()) {        throw new IllegalStateException("This font was created with subsetting disabled");    }    embedder.addToSubset(codePoint);}
public void pdfbox_f4789_0(Set<Integer> glyphIds)
{    if (!willBeSubset()) {        throw new IllegalStateException("This font was created with subsetting disabled");    }    embedder.addGlyphIds(glyphIds);}
public void pdfbox_f4790_0() throws IOException
{    if (!willBeSubset()) {        throw new IllegalStateException("This font was created with subsetting disabled");    }    embedder.subset();    if (ttf != null) {        ttf.close();        ttf = null;    }}
public boolean pdfbox_f4791_0()
{    return embedder != null && embedder.needsSubset();}
private void pdfbox_f4792_1() throws IOException
{    COSBase encoding = dict.getDictionaryObject(COSName.ENCODING);    if (encoding instanceof COSName) {                COSName encodingName = (COSName) encoding;        cMap = CMapManager.getPredefinedCMap(encodingName.getName());        if (cMap != null) {            isCMapPredefined = true;        } else {            throw new IOException("Missing required CMap");        }    } else if (encoding != null) {        cMap = readCMap(encoding);        if (cMap == null) {            throw new IOException("Missing required CMap");        } else if (!cMap.hasCIDMappings()) {                    }    }        PDCIDSystemInfo ros = descendantFont.getCIDSystemInfo();    if (ros != null) {        isDescendantCJK = "Adobe".equals(ros.getRegistry()) && ("GB1".equals(ros.getOrdering()) || "CNS1".equals(ros.getOrdering()) || "Japan1".equals(ros.getOrdering()) || "Korea1".equals(ros.getOrdering()));    }}
private void pdfbox_f4793_0() throws IOException
{                COSName name = dict.getCOSName(COSName.ENCODING);    if (isCMapPredefined && !(name == COSName.IDENTITY_H || name == COSName.IDENTITY_V) || isDescendantCJK) {                                                        String strName = null;        if (isDescendantCJK) {            strName = descendantFont.getCIDSystemInfo().getRegistry() + "-" + descendantFont.getCIDSystemInfo().getOrdering() + "-" + descendantFont.getCIDSystemInfo().getSupplement();        } else if (name != null) {            strName = name.getName();        }                if (strName != null) {            CMap prdCMap = CMapManager.getPredefinedCMap(strName);            String ucs2Name = prdCMap.getRegistry() + "-" + prdCMap.getOrdering() + "-UCS2";            cMapUCS2 = CMapManager.getPredefinedCMap(ucs2Name);        }    }}
public String pdfbox_f4794_0()
{    return dict.getNameAsString(COSName.BASE_FONT);}
public PDCIDFont pdfbox_f4795_0()
{    return descendantFont;}
public CMap pdfbox_f4796_0()
{    return cMap;}
public CMap pdfbox_f4797_0()
{    return cMapUCS2;}
public PDFontDescriptor pdfbox_f4798_0()
{    return descendantFont.getFontDescriptor();}
public Matrix pdfbox_f4799_0()
{    return descendantFont.getFontMatrix();}
public boolean pdfbox_f4800_0()
{    return cMap.getWMode() == 1;}
public float pdfbox_f4801_0(int code) throws IOException
{    return descendantFont.getHeight(code);}
protected byte[] pdfbox_f4802_0(int unicode) throws IOException
{    return descendantFont.encode(unicode);}
public boolean pdfbox_f4803_0(int code) throws IOException
{    return descendantFont.hasExplicitWidth(code);}
public float pdfbox_f4804_0()
{    return descendantFont.getAverageFontWidth();}
public Vector pdfbox_f4805_0(int code)
{        return descendantFont.getPositionVector(code).scale(-1 / 1000f);}
public Vector pdfbox_f4806_0(int code) throws IOException
{    if (isVertical()) {        return new Vector(0, descendantFont.getVerticalDisplacementVectorY(code) / 1000f);    } else {        return super.getDisplacement(code);    }}
public float pdfbox_f4807_0(int code) throws IOException
{    return descendantFont.getWidth(code);}
protected float pdfbox_f4808_0(int code)
{    throw new UnsupportedOperationException("not suppported");}
public float pdfbox_f4809_0(int code) throws IOException
{    return descendantFont.getWidthFromFont(code);}
public boolean pdfbox_f4810_0()
{    return descendantFont.isEmbedded();}
public String pdfbox_f4811_1(int code) throws IOException
{        String unicode = super.toUnicode(code);    if (unicode != null) {        return unicode;    }    if ((isCMapPredefined || isDescendantCJK) && cMapUCS2 != null) {                                int cid = codeToCID(code);                return cMapUCS2.toUnicode(cid);    } else {        if (LOG.isWarnEnabled() && !noUnicode.contains(code)) {                        String cid = "CID+" + codeToCID(code);                                    noUnicode.add(code);        }        return null;    }}
public String pdfbox_f4812_0()
{    return getBaseFont();}
public BoundingBox pdfbox_f4813_0() throws IOException
{        return descendantFont.getBoundingBox();}
public int pdfbox_f4814_0(InputStream in) throws IOException
{    return cMap.readCode(in);}
public int pdfbox_f4815_0(int code)
{    return descendantFont.codeToCID(code);}
public int pdfbox_f4816_0(int code) throws IOException
{    return descendantFont.codeToGID(code);}
public boolean pdfbox_f4817_0()
{    return false;}
public boolean pdfbox_f4818_0()
{    return descendantFont.isDamaged();}
public String pdfbox_f4819_0()
{    String descendant = null;    if (getDescendantFont() != null) {        descendant = getDescendantFont().getClass().getSimpleName();    }    return getClass().getSimpleName() + "/" + descendant + ", PostScript name: " + getBaseFont();}
public GeneralPath pdfbox_f4820_0(int code) throws IOException
{    return descendantFont.getPath(code);}
public GeneralPath pdfbox_f4821_0(int code) throws IOException
{    return descendantFont.getNormalizedPath(code);}
public boolean pdfbox_f4822_0(int code) throws IOException
{    return descendantFont.hasGlyph(code);}
public GsubData pdfbox_f4823_0()
{    return gsubData;}
public byte[] pdfbox_f4824_0(int glyphId)
{    return descendantFont.encodeGlyphId(glyphId);}
public CmapLookup pdfbox_f4825_0()
{    return cmapLookup;}
public FontBoxFont pdfbox_f4826_0()
{    return genericFont;}
public final String pdfbox_f4827_0()
{    return dict.getNameAsString(COSName.BASE_FONT);}
public GeneralPath pdfbox_f4828_0(String name) throws IOException
{        if (name.equals(".notdef") && !isEmbedded() && !isStandard14()) {        return new GeneralPath();    } else {        return genericFont.getPath(name);    }}
public boolean pdfbox_f4829_0(int code) throws IOException
{    String name = getEncoding().getName(code);    name = getNameInFont(name);    return hasGlyph(name);}
public GeneralPath pdfbox_f4830_0(int code) throws IOException
{    String name = getEncoding().getName(code);    name = getNameInFont(name);    return getPath(name);}
public GeneralPath pdfbox_f4831_0(int code) throws IOException
{    String name = getEncoding().getName(code);    name = getNameInFont(name);    GeneralPath path = getPath(name);    if (path == null) {        return getPath(".notdef");    }    return path;}
public boolean pdfbox_f4832_0(String name) throws IOException
{    return genericFont.hasGlyph(name);}
public final String pdfbox_f4833_0()
{    return getBaseFont();}
public BoundingBox pdfbox_f4834_0() throws IOException
{    if (fontBBox == null) {        fontBBox = generateBoundingBox();    }    return fontBBox;}
private BoundingBox pdfbox_f4835_0() throws IOException
{    if (getFontDescriptor() != null) {        PDRectangle bbox = getFontDescriptor().getFontBoundingBox();        if (isNonZeroBoundingBox(bbox)) {            return new BoundingBox(bbox.getLowerLeftX(), bbox.getLowerLeftY(), bbox.getUpperRightX(), bbox.getUpperRightY());        }    }    return genericFont.getFontBBox();}
public String pdfbox_f4836_0(int code)
{    return getEncoding().getName(code);}
protected Encoding pdfbox_f4837_0() throws IOException
{    if (!isEmbedded() && getStandard14AFM() != null) {                return new Type1Encoding(getStandard14AFM());    } else {                if (genericFont instanceof EncodedFont) {            return Type1Encoding.fromFontBox(((EncodedFont) genericFont).getEncoding());        } else {                        return StandardEncoding.INSTANCE;        }    }}
public int pdfbox_f4838_0(InputStream in) throws IOException
{    return in.read();}
public final Matrix pdfbox_f4839_1()
{    if (fontMatrix == null) {        List<Number> numbers = null;        try {            numbers = genericFont.getFontMatrix();        } catch (IOException e) {                        fontMatrix = DEFAULT_FONT_MATRIX;        }        if (numbers != null && numbers.size() == 6) {            fontMatrix = new Matrix(numbers.get(0).floatValue(), numbers.get(1).floatValue(), numbers.get(2).floatValue(), numbers.get(3).floatValue(), numbers.get(4).floatValue(), numbers.get(5).floatValue());        } else {            return super.getFontMatrix();        }    }    return fontMatrix;}
public boolean pdfbox_f4840_0()
{    return isDamaged;}
public float pdfbox_f4841_0(int code) throws IOException
{    String name = codeToName(code);    name = getNameInFont(name);    float width = genericFont.getWidth(name);    Point2D p = new Point2D.Float(width, 0);    fontMatrixTransform.transform(p, p);    return (float) p.getX();}
public boolean pdfbox_f4842_0()
{    return isEmbedded;}
public float pdfbox_f4843_0(int code) throws IOException
{    String name = codeToName(code);    float height;    if (!glyphHeights.containsKey(name)) {                height = (float) cffFont.getType1CharString(name).getBounds().getHeight();        glyphHeights.put(name, height);    } else {        height = glyphHeights.get(name);    }    return height;}
protected byte[] pdfbox_f4844_0(int unicode) throws IOException
{    String name = getGlyphList().codePointToName(unicode);    if (!encoding.contains(name)) {        throw new IllegalArgumentException(String.format("U+%04X ('%s') is not available in this font's encoding: %s", unicode, name, encoding.getEncodingName()));    }    String nameInFont = getNameInFont(name);    Map<String, Integer> inverted = encoding.getNameToCodeMap();    if (nameInFont.equals(".notdef") || !genericFont.hasGlyph(nameInFont)) {        throw new IllegalArgumentException(String.format("No glyph for U+%04X in font %s", unicode, getName()));    }    int code = inverted.get(name);    return new byte[] { (byte) code };}
public float pdfbox_f4845_0(String string) throws IOException
{    float width = 0;    for (int i = 0; i < string.length(); i++) {        int codePoint = string.codePointAt(i);        String name = getGlyphList().codePointToName(codePoint);        width += cffFont.getType1CharString(name).getWidth();    }    return width;}
public float pdfbox_f4846_0()
{    if (avgWidth == null) {        avgWidth = getAverageCharacterWidth();    }    return avgWidth;}
public CFFType1Font pdfbox_f4847_0()
{    return cffFont;}
private float pdfbox_f4848_0()
{        return 500;}
private String pdfbox_f4849_0(String name) throws IOException
{    if (isEmbedded() || genericFont.hasGlyph(name)) {        return name;    } else {                String unicodes = getGlyphList().toUnicode(name);        if (unicodes != null && unicodes.length() == 1) {            String uniName = getUniNameOfCodePoint(unicodes.codePointAt(0));            if (genericFont.hasGlyph(uniName)) {                return uniName;            }        }    }    return ".notdef";}
public byte[] pdfbox_f4850_0() throws IOException
{    return getFontDescriptor().getFontFile3().toByteArray();}
private int pdfbox_f4851_1(byte[] bytes, int length1)
{        int offset = Math.max(0, length1 - 4);    if (offset <= 0 || offset > bytes.length - 4) {        offset = bytes.length - 4;    }    offset = findBinaryOffsetAfterExec(bytes, offset);    if (offset == 0 && length1 > 0) {                offset = findBinaryOffsetAfterExec(bytes, bytes.length - 4);    }    if (length1 - offset != 0 && offset > 0) {        if (LOG.isWarnEnabled()) {                    }        return offset;    }    return length1;}
private static int pdfbox_f4852_0(byte[] bytes, int startOffset)
{    int offset = startOffset;    while (offset > 0) {        if (bytes[offset + 0] == 'e' && bytes[offset + 1] == 'x' && bytes[offset + 2] == 'e' && bytes[offset + 3] == 'c') {            offset += 4;                        while (offset < bytes.length && (bytes[offset] == '\r' || bytes[offset] == '\n' || bytes[offset] == ' ' || bytes[offset] == '\t')) {                offset++;            }            break;        }        offset--;    }    return offset;}
private int pdfbox_f4853_1(byte[] bytes, int length1, int length2)
{        if (length2 < 0 || length2 > bytes.length - length1) {                return bytes.length - length1;    }    return length2;}
public final String pdfbox_f4854_0()
{    return dict.getNameAsString(COSName.BASE_FONT);}
public float pdfbox_f4855_0(int code) throws IOException
{    String name = codeToName(code);    if (getStandard14AFM() != null) {        String afmName = getEncoding().getName(code);                return getStandard14AFM().getCharacterHeight(afmName);    } else {                return (float) genericFont.getPath(name).getBounds().getHeight();    }}
protected byte[] pdfbox_f4856_0(int unicode) throws IOException
{    byte[] bytes = codeToBytesMap.get(unicode);    if (bytes != null) {        return bytes;    }    String name = getGlyphList().codePointToName(unicode);    if (isStandard14()) {                if (!encoding.contains(name)) {            throw new IllegalArgumentException(String.format("U+%04X ('%s') is not available in this font %s encoding: %s", unicode, name, getName(), encoding.getEncodingName()));        }        if (".notdef".equals(name)) {            throw new IllegalArgumentException(String.format("No glyph for U+%04X in font %s", unicode, getName()));        }    } else {        if (!encoding.contains(name)) {            throw new IllegalArgumentException(String.format("U+%04X ('%s') is not available in this font %s (generic: %s) encoding: %s", unicode, name, getName(), genericFont.getName(), encoding.getEncodingName()));        }        String nameInFont = getNameInFont(name);        if (".notdef".equals(nameInFont) || !genericFont.hasGlyph(nameInFont)) {            throw new IllegalArgumentException(String.format("No glyph for U+%04X in font %s (generic: %s)", unicode, getName(), genericFont.getName()));        }    }    Map<String, Integer> inverted = encoding.getNameToCodeMap();    int code = inverted.get(name);    bytes = new byte[] { (byte) code };    codeToBytesMap.put(unicode, bytes);    return bytes;}
public float pdfbox_f4857_0(int code) throws IOException
{    String name = codeToName(code);        if (!isEmbedded && name.equals(".notdef")) {        return 250;    }    float width = genericFont.getWidth(name);    Point2D p = new Point2D.Float(width, 0);    fontMatrixTransform.transform(p, p);    return (float) p.getX();}
public boolean pdfbox_f4858_0()
{    return isEmbedded;}
public float pdfbox_f4859_0()
{    if (getStandard14AFM() != null) {        return getStandard14AFM().getAverageCharacterWidth();    } else {        return super.getAverageFontWidth();    }}
public int pdfbox_f4860_0(InputStream in) throws IOException
{    return in.read();}
protected Encoding pdfbox_f4861_0() throws IOException
{    if (!isEmbedded() && getStandard14AFM() != null) {                return new Type1Encoding(getStandard14AFM());    } else {                if (genericFont instanceof EncodedFont) {            return Type1Encoding.fromFontBox(((EncodedFont) genericFont).getEncoding());        } else {                        return StandardEncoding.INSTANCE;        }    }}
public Type1Font pdfbox_f4862_0()
{    return type1font;}
public FontBoxFont pdfbox_f4863_0()
{    return genericFont;}
public String pdfbox_f4864_0()
{    return getBaseFont();}
public BoundingBox pdfbox_f4865_0() throws IOException
{    if (fontBBox == null) {        fontBBox = generateBoundingBox();    }    return fontBBox;}
private BoundingBox pdfbox_f4866_0() throws IOException
{    if (getFontDescriptor() != null) {        PDRectangle bbox = getFontDescriptor().getFontBoundingBox();        if (isNonZeroBoundingBox(bbox)) {            return new BoundingBox(bbox.getLowerLeftX(), bbox.getLowerLeftY(), bbox.getUpperRightX(), bbox.getUpperRightY());        }    }    return genericFont.getFontBBox();}
public String pdfbox_f4867_0(int code) throws IOException
{    String name = getEncoding().getName(code);    return getNameInFont(name);}
private String pdfbox_f4868_0(String name) throws IOException
{    if (isEmbedded() || genericFont.hasGlyph(name)) {        return name;    }        String altName = ALT_NAMES.get(name);    if (altName != null && !name.equals(".notdef") && genericFont.hasGlyph(altName)) {        return altName;    }        String unicodes = getGlyphList().toUnicode(name);    if (unicodes != null && unicodes.length() == 1) {        String uniName = getUniNameOfCodePoint(unicodes.codePointAt(0));        if (genericFont.hasGlyph(uniName)) {            return uniName;        }                if ("SymbolMT".equals(genericFont.getName())) {            Integer code = SymbolEncoding.INSTANCE.getNameToCodeMap().get(name);            if (code != null) {                uniName = getUniNameOfCodePoint(code + 0xF000);                if (genericFont.hasGlyph(uniName)) {                    return uniName;                }            }        }    }    return ".notdef";}
public GeneralPath pdfbox_f4869_0(String name) throws IOException
{        if (name.equals(".notdef") && !isEmbedded) {        return new GeneralPath();    } else {        return genericFont.getPath(getNameInFont(name));    }}
public GeneralPath pdfbox_f4870_0(int code) throws IOException
{    String name = getEncoding().getName(code);    return getPath(name);}
public GeneralPath pdfbox_f4871_0(int code) throws IOException
{    String name = getEncoding().getName(code);    GeneralPath path = getPath(name);    if (path == null) {        return getPath(".notdef");    }    return path;}
public boolean pdfbox_f4872_0(String name) throws IOException
{    return genericFont.hasGlyph(getNameInFont(name));}
public boolean pdfbox_f4873_0(int code) throws IOException
{    return !getEncoding().getName(code).equals(".notdef");}
public final Matrix pdfbox_f4874_1()
{    if (fontMatrix == null) {                        List<Number> numbers = null;        try {            numbers = genericFont.getFontMatrix();        } catch (IOException e) {                        fontMatrix = DEFAULT_FONT_MATRIX;        }        if (numbers != null && numbers.size() == 6) {            fontMatrix = new Matrix(numbers.get(0).floatValue(), numbers.get(1).floatValue(), numbers.get(2).floatValue(), numbers.get(3).floatValue(), numbers.get(4).floatValue(), numbers.get(5).floatValue());        } else {            return super.getFontMatrix();        }    }    return fontMatrix;}
public boolean pdfbox_f4875_0()
{    return isDamaged;}
 static PDFontDescriptor pdfbox_f4876_0(Type1Font type1)
{    boolean isSymbolic = type1.getEncoding() instanceof org.apache.fontbox.encoding.BuiltInEncoding;    PDFontDescriptor fd = new PDFontDescriptor();    fd.setFontName(type1.getName());    fd.setFontFamily(type1.getFamilyName());    fd.setNonSymbolic(!isSymbolic);    fd.setSymbolic(isSymbolic);    fd.setFontBoundingBox(new PDRectangle(type1.getFontBBox()));    fd.setItalicAngle(type1.getItalicAngle());    fd.setAscent(type1.getFontBBox().getUpperRightY());    fd.setDescent(type1.getFontBBox().getLowerLeftY());    fd.setCapHeight(type1.getBlueValues().get(2).floatValue());        fd.setStemV(0);    return fd;}
 static PDFontDescriptor pdfbox_f4877_0(FontMetrics metrics)
{    boolean isSymbolic = metrics.getEncodingScheme().equals("FontSpecific");    PDFontDescriptor fd = new PDFontDescriptor();    fd.setFontName(metrics.getFontName());    fd.setFontFamily(metrics.getFamilyName());    fd.setNonSymbolic(!isSymbolic);    fd.setSymbolic(isSymbolic);    fd.setFontBoundingBox(new PDRectangle(metrics.getFontBBox()));    fd.setItalicAngle(metrics.getItalicAngle());    fd.setAscent(metrics.getAscender());    fd.setDescent(metrics.getDescender());    fd.setCapHeight(metrics.getCapHeight());    fd.setXHeight(metrics.getXHeight());    fd.setAverageWidth(metrics.getAverageCharacterWidth());    fd.setCharacterSet(metrics.getCharacterSet());        fd.setStemV(0);    return fd;}
public Encoding pdfbox_f4878_0()
{    return fontEncoding;}
public GlyphList pdfbox_f4879_0()
{    return GlyphList.getAdobeGlyphList();}
public Type1Font pdfbox_f4880_0()
{    return type1;}
public COSStream pdfbox_f4881_0()
{    return charStream;}
public PDType3Font pdfbox_f4882_0()
{    return font;}
public PDStream pdfbox_f4883_0()
{    return new PDStream(charStream);}
public InputStream pdfbox_f4884_0() throws IOException
{    return charStream.createInputStream();}
public PDResources pdfbox_f4885_0()
{    return font.getResources();}
public PDRectangle pdfbox_f4886_0()
{    return font.getFontBBox();}
public PDRectangle pdfbox_f4887_0() throws IOException
{    List<COSBase> arguments = new ArrayList<>();    PDFStreamParser parser = new PDFStreamParser(getContents());    Object token = parser.parseNextToken();    while (token != null) {        if (token instanceof COSObject) {            arguments.add(((COSObject) token).getObject());        } else if (token instanceof Operator) {            if (((Operator) token).getName().equals("d1") && arguments.size() == 6) {                for (int i = 0; i < 6; ++i) {                    if (!(arguments.get(i) instanceof COSNumber)) {                        return null;                    }                }                return new PDRectangle(((COSNumber) arguments.get(2)).floatValue(), ((COSNumber) arguments.get(3)).floatValue(), ((COSNumber) arguments.get(4)).floatValue() - ((COSNumber) arguments.get(2)).floatValue(), ((COSNumber) arguments.get(5)).floatValue() - ((COSNumber) arguments.get(3)).floatValue());            } else {                return null;            }        } else {            arguments.add((COSBase) token);        }        token = parser.parseNextToken();    }    return null;}
public Matrix pdfbox_f4888_0()
{    return font.getFontMatrix();}
public float pdfbox_f4889_0() throws IOException
{    List<COSBase> arguments = new ArrayList<>();    PDFStreamParser parser = new PDFStreamParser(getContents());    Object token = parser.parseNextToken();    while (token != null) {        if (token instanceof COSObject) {            arguments.add(((COSObject) token).getObject());        } else if (token instanceof Operator) {            return parseWidth((Operator) token, arguments);        } else {            arguments.add((COSBase) token);        }        token = parser.parseNextToken();    }    throw new IOException("Unexpected end of stream");}
private float pdfbox_f4890_0(Operator operator, List<COSBase> arguments) throws IOException
{    if (operator.getName().equals("d0") || operator.getName().equals("d1")) {        COSBase obj = arguments.get(0);        if (obj instanceof COSNumber) {            return ((COSNumber) obj).floatValue();        }        throw new IOException("Unexpected argument type: " + obj.getClass().getName());    } else {        throw new IOException("First operator must be d0 or d1");    }}
public String pdfbox_f4891_0()
{    return dict.getNameAsString(COSName.NAME);}
protected final void pdfbox_f4892_1() throws IOException
{    COSBase encodingBase = dict.getDictionaryObject(COSName.ENCODING);    if (encodingBase instanceof COSName) {        COSName encodingName = (COSName) encodingBase;        encoding = Encoding.getInstance(encodingName);        if (encoding == null) {                    }    } else if (encodingBase instanceof COSDictionary) {        encoding = new DictionaryEncoding((COSDictionary) encodingBase);    }    glyphList = GlyphList.getAdobeGlyphList();}
protected Encoding pdfbox_f4893_0() throws IOException
{        throw new UnsupportedOperationException("not supported for Type 3 fonts");}
protected Boolean pdfbox_f4894_0()
{    return false;}
public GeneralPath pdfbox_f4895_0(String name) throws IOException
{        throw new UnsupportedOperationException("not supported for Type 3 fonts");}
public boolean pdfbox_f4896_0(String name) throws IOException
{    COSBase base = getCharProcs().getDictionaryObject(COSName.getPDFName(name));    return base instanceof COSStream;}
public FontBoxFont pdfbox_f4897_0()
{        throw new UnsupportedOperationException("not supported for Type 3 fonts");}
public Vector pdfbox_f4898_0(int code) throws IOException
{    return getFontMatrix().transform(new Vector(getWidth(code), 0));}
public float pdfbox_f4899_0(int code) throws IOException
{    int firstChar = dict.getInt(COSName.FIRST_CHAR, -1);    int lastChar = dict.getInt(COSName.LAST_CHAR, -1);    if (!getWidths().isEmpty() && code >= firstChar && code <= lastChar) {        Float w = getWidths().get(code - firstChar);        return w == null ? 0 : w;    } else {        PDFontDescriptor fd = getFontDescriptor();        if (fd != null) {            return fd.getMissingWidth();        } else {            return getWidthFromFont(code);        }    }}
public float pdfbox_f4900_0(int code) throws IOException
{    PDType3CharProc charProc = getCharProc(code);    if (charProc == null || charProc.getContentStream() == null || charProc.getContentStream().getLength() == 0) {        return 0;    }    return charProc.getWidth();}
public boolean pdfbox_f4901_0()
{    return true;}
public float pdfbox_f4902_0(int code) throws IOException
{    PDFontDescriptor desc = getFontDescriptor();    if (desc != null) {                                PDRectangle bbox = desc.getFontBoundingBox();        float retval = 0;        if (bbox != null) {            retval = bbox.getHeight() / 2;        }        if (Float.compare(retval, 0) == 0) {            retval = desc.getCapHeight();        }        if (Float.compare(retval, 0) == 0) {            retval = desc.getAscent();        }        if (Float.compare(retval, 0) == 0) {            retval = desc.getXHeight();            if (retval > 0) {                retval -= desc.getDescent();            }        }        return retval;    }    return 0;}
protected byte[] pdfbox_f4903_0(int unicode) throws IOException
{    throw new UnsupportedOperationException("Not implemented: Type3");}
public int pdfbox_f4904_0(InputStream in) throws IOException
{    return in.read();}
public Matrix pdfbox_f4905_0()
{    if (fontMatrix == null) {        COSBase base = dict.getDictionaryObject(COSName.FONT_MATRIX);        if (base instanceof COSArray) {            fontMatrix = new Matrix((COSArray) base);        } else {            return super.getFontMatrix();        }    }    return fontMatrix;}
public boolean pdfbox_f4906_0()
{        return false;}
public PDResources pdfbox_f4907_0()
{    if (resources == null) {        COSBase base = dict.getDictionaryObject(COSName.RESOURCES);        if (base instanceof COSDictionary) {            this.resources = new PDResources((COSDictionary) base, resourceCache);        }    }    return resources;}
public PDRectangle pdfbox_f4908_0()
{    COSBase base = dict.getDictionaryObject(COSName.FONT_BBOX);    PDRectangle retval = null;    if (base instanceof COSArray) {        retval = new PDRectangle((COSArray) base);    }    return retval;}
public BoundingBox pdfbox_f4909_0()
{    if (fontBBox == null) {        fontBBox = generateBoundingBox();    }    return fontBBox;}
private BoundingBox pdfbox_f4910_1()
{    PDRectangle rect = getFontBBox();    if (!isNonZeroBoundingBox(rect)) {                COSDictionary cp = getCharProcs();        for (COSName name : cp.keySet()) {            COSBase base = cp.getDictionaryObject(name);            if (base instanceof COSStream) {                PDType3CharProc charProc = new PDType3CharProc(this, (COSStream) base);                try {                    PDRectangle glyphBBox = charProc.getGlyphBBox();                    if (glyphBBox == null) {                        continue;                    }                    rect.setLowerLeftX(Math.min(rect.getLowerLeftX(), glyphBBox.getLowerLeftX()));                    rect.setLowerLeftY(Math.min(rect.getLowerLeftY(), glyphBBox.getLowerLeftY()));                    rect.setUpperRightX(Math.max(rect.getUpperRightX(), glyphBBox.getUpperRightX()));                    rect.setUpperRightY(Math.max(rect.getUpperRightY(), glyphBBox.getUpperRightY()));                } catch (IOException ex) {                                                        }            }        }    }    return new BoundingBox(rect.getLowerLeftX(), rect.getLowerLeftY(), rect.getUpperRightX(), rect.getUpperRightY());}
public COSDictionary pdfbox_f4911_0()
{    if (charProcs == null) {        charProcs = (COSDictionary) dict.getDictionaryObject(COSName.CHAR_PROCS);    }    return charProcs;}
public PDType3CharProc pdfbox_f4912_0(int code)
{    String name = getEncoding().getName(code);    COSBase base = getCharProcs().getDictionaryObject(COSName.getPDFName(name));    if (base instanceof COSStream) {        return new PDType3CharProc(this, (COSStream) base);    }    return null;}
private static void pdfbox_f4913_0(String fontName) throws IOException
{    addAFM(fontName, fontName);}
private static void pdfbox_f4914_0(String fontName, String afmName) throws IOException
{    STANDARD_14_NAMES.add(fontName);    STANDARD_14_MAPPING.put(fontName, afmName);    if (STANDARD14_AFM_MAP.containsKey(afmName)) {        STANDARD14_AFM_MAP.put(fontName, STANDARD14_AFM_MAP.get(afmName));    }    String resourceName = "/org/apache/pdfbox/resources/afm/" + afmName + ".afm";    try (InputStream afmStream = PDType1Font.class.getResourceAsStream(resourceName)) {        if (afmStream == null) {            throw new IOException(resourceName + " not found");        }        AFMParser parser = new AFMParser(afmStream);        FontMetrics metric = parser.parse(true);        STANDARD14_AFM_MAP.put(fontName, metric);    }}
public static FontMetrics pdfbox_f4915_0(String baseName)
{    return STANDARD14_AFM_MAP.get(baseName);}
public static boolean pdfbox_f4916_0(String baseName)
{    return STANDARD_14_NAMES.contains(baseName);}
public static Set<String> pdfbox_f4917_0()
{    return Collections.unmodifiableSet(STANDARD_14_NAMES);}
public static String pdfbox_f4918_0(String baseName)
{    return STANDARD_14_MAPPING.get(baseName);}
public void pdfbox_f4919_0(int wMode)
{    this.wMode = wMode;}
public void pdfbox_f4920_0(int cid, String text)
{    if (cid < 0 || cid > 0xFFFF) {        throw new IllegalArgumentException("CID is not valid");    }    if (text == null || text.isEmpty()) {        throw new IllegalArgumentException("Text is null or empty");    }    cidToUnicode.put(cid, text);}
public void pdfbox_f4921_0(OutputStream out) throws IOException
{    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, Charsets.US_ASCII));    writeLine(writer, "/CIDInit /ProcSet findresource begin");    writeLine(writer, "12 dict begin\n");    writeLine(writer, "begincmap");    writeLine(writer, "/CIDSystemInfo");    writeLine(writer, "<< /Registry (Adobe)");    writeLine(writer, "/Ordering (UCS)");    writeLine(writer, "/Supplement 0");    writeLine(writer, ">> def\n");    writeLine(writer, "/CMapName /Adobe-Identity-UCS" + " def");        writeLine(writer, "/CMapType 2 def\n");    if (wMode != 0) {        writeLine(writer, "/WMode /" + wMode + " def");    }        writeLine(writer, "1 begincodespacerange");    writeLine(writer, "<0000> <FFFF>");    writeLine(writer, "endcodespacerange\n");        List<Integer> srcFrom = new ArrayList<>();    List<Integer> srcTo = new ArrayList<>();    List<String> dstString = new ArrayList<>();    int srcPrev = -1;    String dstPrev = "";    int srcCode1 = -1;    for (Map.Entry<Integer, String> entry : cidToUnicode.entrySet()) {        int cid = entry.getKey();        String text = entry.getValue();        if (        cid == srcPrev + 1 &&         dstPrev.codePointCount(0, dstPrev.length()) == 1 &&         text.codePointAt(0) == dstPrev.codePointAt(0) + 1 &&         dstPrev.codePointAt(0) + 1 <= 255 - (cid - srcCode1)) {                        srcTo.set(srcTo.size() - 1, cid);        } else {                        srcCode1 = cid;            srcFrom.add(cid);            srcTo.add(cid);            dstString.add(text);        }        srcPrev = cid;        dstPrev = text;    }        int batchCount = (int) Math.ceil(srcFrom.size() / (double) MAX_ENTRIES_PER_OPERATOR);    for (int batch = 0; batch < batchCount; batch++) {        int count = batch == batchCount - 1 ? srcFrom.size() - MAX_ENTRIES_PER_OPERATOR * batch : MAX_ENTRIES_PER_OPERATOR;        writer.write(count + " beginbfrange\n");        for (int j = 0; j < count; j++) {            int index = batch * MAX_ENTRIES_PER_OPERATOR + j;            writer.write('<');            writer.write(Hex.getChars(srcFrom.get(index).shortValue()));            writer.write("> ");            writer.write('<');            writer.write(Hex.getChars(srcTo.get(index).shortValue()));            writer.write("> ");            writer.write('<');            writer.write(Hex.getCharsUTF16BE(dstString.get(index)));            writer.write(">\n");        }        writeLine(writer, "endbfrange\n");    }        writeLine(writer, "endcmap");    writeLine(writer, "CMapName currentdict /CMap defineresource pop");    writeLine(writer, "end");    writeLine(writer, "end");    writer.flush();}
private void pdfbox_f4922_0(BufferedWriter writer, String text) throws IOException
{    writer.write(text);    writer.write('\n');}
public final void pdfbox_f4923_0(InputStream ttfStream) throws IOException
{    PDStream stream = new PDStream(document, ttfStream, COSName.FLATE_DECODE);        try (InputStream input = stream.createInputStream()) {        ttf = new TTFParser().parseEmbedded(input);        if (!isEmbeddingPermitted(ttf)) {            throw new IOException("This font does not permit embedding");        }        if (fontDescriptor == null) {            fontDescriptor = createFontDescriptor(ttf);        }    }    stream.getCOSObject().setLong(COSName.LENGTH1, ttf.getOriginalDataSize());    fontDescriptor.setFontFile2(stream);}
private boolean pdfbox_f4924_0(TrueTypeFont ttf) throws IOException
{    if (ttf.getOS2Windows() != null) {        int fsType = ttf.getOS2Windows().getFsType();                int exclusive = fsType & 0x8;        if ((exclusive & OS2WindowsMetricsTable.FSTYPE_RESTRICTED) == OS2WindowsMetricsTable.FSTYPE_RESTRICTED) {                        return false;        } else if ((exclusive & OS2WindowsMetricsTable.FSTYPE_BITMAP_ONLY) == OS2WindowsMetricsTable.FSTYPE_BITMAP_ONLY) {                        return false;        }    }    return true;}
private boolean pdfbox_f4925_0(TrueTypeFont ttf) throws IOException
{    if (ttf.getOS2Windows() != null) {        int fsType = ttf.getOS2Windows().getFsType();        if ((fsType & OS2WindowsMetricsTable.FSTYPE_NO_SUBSETTING) == OS2WindowsMetricsTable.FSTYPE_NO_SUBSETTING) {            return false;        }    }    return true;}
private PDFontDescriptor pdfbox_f4926_0(TrueTypeFont ttf) throws IOException
{    PDFontDescriptor fd = new PDFontDescriptor();    fd.setFontName(ttf.getName());    OS2WindowsMetricsTable os2 = ttf.getOS2Windows();    PostScriptTable post = ttf.getPostScript();        fd.setFixedPitch(post.getIsFixedPitch() > 0 || ttf.getHorizontalHeader().getNumberOfHMetrics() == 1);    int fsSelection = os2.getFsSelection();    fd.setItalic(((fsSelection & (ITALIC | OBLIQUE)) != 0));    switch(os2.getFamilyClass()) {        case OS2WindowsMetricsTable.FAMILY_CLASS_CLAREDON_SERIFS:        case OS2WindowsMetricsTable.FAMILY_CLASS_FREEFORM_SERIFS:        case OS2WindowsMetricsTable.FAMILY_CLASS_MODERN_SERIFS:        case OS2WindowsMetricsTable.FAMILY_CLASS_OLDSTYLE_SERIFS:        case OS2WindowsMetricsTable.FAMILY_CLASS_SLAB_SERIFS:            fd.setSerif(true);            break;        case OS2WindowsMetricsTable.FAMILY_CLASS_SCRIPTS:            fd.setScript(true);            break;        default:            break;    }    fd.setFontWeight(os2.getWeightClass());    fd.setSymbolic(true);    fd.setNonSymbolic(false);        fd.setItalicAngle(post.getItalicAngle());        HeaderTable header = ttf.getHeader();    PDRectangle rect = new PDRectangle();    float scaling = 1000f / header.getUnitsPerEm();    rect.setLowerLeftX(header.getXMin() * scaling);    rect.setLowerLeftY(header.getYMin() * scaling);    rect.setUpperRightX(header.getXMax() * scaling);    rect.setUpperRightY(header.getYMax() * scaling);    fd.setFontBoundingBox(rect);        HorizontalHeaderTable hHeader = ttf.getHorizontalHeader();    fd.setAscent(hHeader.getAscender() * scaling);    fd.setDescent(hHeader.getDescender() * scaling);        if (os2.getVersion() >= 1.2) {        fd.setCapHeight(os2.getCapHeight() * scaling);        fd.setXHeight(os2.getHeight() * scaling);    } else {        GeneralPath capHPath = ttf.getPath("H");        if (capHPath != null) {            fd.setCapHeight(Math.round(capHPath.getBounds2D().getMaxY()) * scaling);        } else {                        fd.setCapHeight((os2.getTypoAscender() + os2.getTypoDescender()) * scaling);        }        GeneralPath xPath = ttf.getPath("x");        if (xPath != null) {            fd.setXHeight(Math.round(xPath.getBounds2D().getMaxY()) * scaling);        } else {                        fd.setXHeight(os2.getTypoAscender() / 2.0f * scaling);        }    }        fd.setStemV(fd.getFontBoundingBox().getWidth() * .13f);    return fd;}
public TrueTypeFont pdfbox_f4927_0()
{    return ttf;}
public PDFontDescriptor pdfbox_f4928_0()
{    return fontDescriptor;}
public void pdfbox_f4929_0(int codePoint)
{    subsetCodePoints.add(codePoint);}
public void pdfbox_f4930_0(Set<Integer> glyphIds)
{    allGlyphIds.addAll(glyphIds);}
public void pdfbox_f4931_0() throws IOException
{    if (!isSubsettingPermitted(ttf)) {        throw new IOException("This font does not permit subsetting");    }    if (!embedSubset) {        throw new IllegalStateException("Subsetting is disabled");    }        List<String> tables = new ArrayList<>();    tables.add("head");    tables.add("hhea");    tables.add("loca");    tables.add("maxp");    tables.add("cvt ");    tables.add("prep");    tables.add("glyf");    tables.add("hmtx");    tables.add("fpgm");        tables.add("gasp");        TTFSubsetter subsetter = new TTFSubsetter(ttf, tables);    subsetter.addAll(subsetCodePoints);    if (!allGlyphIds.isEmpty()) {        subsetter.addGlyphIds(allGlyphIds);    }        Map<Integer, Integer> gidToCid = subsetter.getGIDMap();    String tag = getTag(gidToCid);    subsetter.setPrefix(tag);        ByteArrayOutputStream out = new ByteArrayOutputStream();    subsetter.writeToStream(out);        buildSubset(new ByteArrayInputStream(out.toByteArray()), tag, gidToCid);    ttf.close();}
public boolean pdfbox_f4932_0()
{    return embedSubset;}
public String pdfbox_f4933_0(Map<Integer, Integer> gidToCid)
{        long num = gidToCid.hashCode();        StringBuilder sb = new StringBuilder();    do {        long div = num / 25;        int mod = (int) (num % 25);        sb.append(BASE25.charAt(mod));        num = div;    } while (num != 0 && sb.length() < 6);        while (sb.length() < 6) {        sb.insert(0, 'A');    }    sb.append('+');    return sb.toString();}
 static String pdfbox_f4934_0(int codePoint)
{    String hex = Integer.toString(codePoint, 16).toUpperCase(Locale.US);    switch(hex.length()) {        case 1:            return "uni000" + hex;        case 2:            return "uni00" + hex;        case 3:            return "uni0" + hex;        default:            return "uni" + hex;    }}
public static Composite pdfbox_f4935_1(BlendMode blendMode, float constantAlpha)
{    if (constantAlpha < 0) {                constantAlpha = 0;    } else if (constantAlpha > 1) {                constantAlpha = 1;    }    if (blendMode == BlendMode.NORMAL) {        return AlphaComposite.getInstance(AlphaComposite.SRC_OVER, constantAlpha);    } else {        return new BlendComposite(blendMode, constantAlpha);    }}
public CompositeContext pdfbox_f4936_0(ColorModel srcColorModel, ColorModel dstColorModel, RenderingHints hints)
{    return new BlendCompositeContext(srcColorModel, dstColorModel, hints);}
public void pdfbox_f4938_0(Raster src, Raster dstIn, WritableRaster dstOut)
{    int x0 = src.getMinX();    int y0 = src.getMinY();    int width = Math.min(Math.min(src.getWidth(), dstIn.getWidth()), dstOut.getWidth());    int height = Math.min(Math.min(src.getHeight(), dstIn.getHeight()), dstOut.getHeight());    int x1 = x0 + width;    int y1 = y0 + height;    int dstInXShift = dstIn.getMinX() - x0;    int dstInYShift = dstIn.getMinY() - y0;    int dstOutXShift = dstOut.getMinX() - x0;    int dstOutYShift = dstOut.getMinY() - y0;    ColorSpace srcColorSpace = srcColorModel.getColorSpace();    int numSrcColorComponents = srcColorModel.getNumColorComponents();    int numSrcComponents = src.getNumBands();    boolean srcHasAlpha = (numSrcComponents > numSrcColorComponents);    ColorSpace dstColorSpace = dstColorModel.getColorSpace();    int numDstColorComponents = dstColorModel.getNumColorComponents();    int numDstComponents = dstIn.getNumBands();    boolean dstHasAlpha = (numDstComponents > numDstColorComponents);    int srcColorSpaceType = srcColorSpace.getType();    int dstColorSpaceType = dstColorSpace.getType();    boolean subtractive = (dstColorSpaceType != ColorSpace.TYPE_RGB) && (dstColorSpaceType != ColorSpace.TYPE_GRAY);    boolean blendModeIsSeparable = blendMode instanceof SeparableBlendMode;    SeparableBlendMode separableBlendMode = blendModeIsSeparable ? (SeparableBlendMode) blendMode : null;    NonSeparableBlendMode nonSeparableBlendMode = !blendModeIsSeparable ? (NonSeparableBlendMode) blendMode : null;    boolean needsColorConversion = !srcColorSpace.equals(dstColorSpace);    Object srcPixel = null;    Object dstPixel = null;    float[] srcComponents = new float[numSrcComponents];            float[] dstComponents = null;    float[] srcColor = new float[numSrcColorComponents];    float[] srcConverted;    float[] dstConverted;    float[] rgbResult = blendModeIsSeparable ? null : new float[dstHasAlpha ? 4 : 3];    for (int y = y0; y < y1; y++) {        for (int x = x0; x < x1; x++) {            srcPixel = src.getDataElements(x, y, srcPixel);            dstPixel = dstIn.getDataElements(dstInXShift + x, dstInYShift + y, dstPixel);            srcComponents = srcColorModel.getNormalizedComponents(srcPixel, srcComponents, 0);            dstComponents = dstColorModel.getNormalizedComponents(dstPixel, dstComponents, 0);            float srcAlpha = srcHasAlpha ? srcComponents[numSrcColorComponents] : 1.0f;            float dstAlpha = dstHasAlpha ? dstComponents[numDstColorComponents] : 1.0f;            srcAlpha = srcAlpha * constantAlpha;            float resultAlpha = dstAlpha + srcAlpha - srcAlpha * dstAlpha;            float srcAlphaRatio = (resultAlpha > 0) ? srcAlpha / resultAlpha : 0;            if (separableBlendMode != null) {                                System.arraycopy(srcComponents, 0, srcColor, 0, numSrcColorComponents);                if (needsColorConversion) {                                        float[] cieXYZ = srcColorSpace.toCIEXYZ(srcColor);                    srcConverted = dstColorSpace.fromCIEXYZ(cieXYZ);                } else {                    srcConverted = srcColor;                }                for (int k = 0; k < numDstColorComponents; k++) {                    float srcValue = srcConverted[k];                    float dstValue = dstComponents[k];                    if (subtractive) {                        srcValue = 1 - srcValue;                        dstValue = 1 - dstValue;                    }                    float value = separableBlendMode.blendChannel(srcValue, dstValue);                    value = srcValue + dstAlpha * (value - srcValue);                    value = dstValue + srcAlphaRatio * (value - dstValue);                    if (subtractive) {                        value = 1 - value;                    }                    dstComponents[k] = value;                }            } else {                if (srcColorSpaceType == ColorSpace.TYPE_RGB) {                    srcConverted = srcComponents;                } else {                    srcConverted = srcColorSpace.toRGB(srcComponents);                }                if (dstColorSpaceType == ColorSpace.TYPE_RGB) {                    dstConverted = dstComponents;                } else {                    dstConverted = dstColorSpace.toRGB(dstComponents);                }                nonSeparableBlendMode.blend(srcConverted, dstConverted, rgbResult);                for (int k = 0; k < 3; k++) {                    float srcValue = srcConverted[k];                    float dstValue = dstConverted[k];                    float value = rgbResult[k];                    value = Math.max(Math.min(value, 1.0f), 0.0f);                    value = srcValue + dstAlpha * (value - srcValue);                    value = dstValue + srcAlphaRatio * (value - dstValue);                    rgbResult[k] = value;                }                if (dstColorSpaceType == ColorSpace.TYPE_RGB) {                    System.arraycopy(rgbResult, 0, dstComponents, 0, dstComponents.length);                } else {                    float[] temp = dstColorSpace.fromRGB(rgbResult);                    System.arraycopy(temp, 0, dstComponents, 0, Math.min(dstComponents.length, temp.length));                }            }            if (dstHasAlpha) {                dstComponents[numDstColorComponents] = resultAlpha;            }            dstPixel = dstColorModel.getDataElements(dstComponents, 0, dstPixel);            dstOut.setDataElements(dstOutXShift + x, dstOutYShift + y, dstPixel);        }    }}
public float pdfbox_f4939_0(float srcValue, float dstValue)
{    return srcValue;}
public float pdfbox_f4940_0(float srcValue, float dstValue)
{    return srcValue * dstValue;}
public float pdfbox_f4941_0(float srcValue, float dstValue)
{    return srcValue + dstValue - srcValue * dstValue;}
public float pdfbox_f4942_0(float srcValue, float dstValue)
{    return (dstValue <= 0.5) ? 2 * dstValue * srcValue : 2 * (srcValue + dstValue - srcValue * dstValue) - 1;}
public float pdfbox_f4943_0(float srcValue, float dstValue)
{    return Math.min(srcValue, dstValue);}
public float pdfbox_f4944_0(float srcValue, float dstValue)
{    return Math.max(srcValue, dstValue);}
public float pdfbox_f4945_0(float srcValue, float dstValue)
{        if (Float.compare(dstValue, 0) == 0) {        return 0;    }    if (dstValue >= 1 - srcValue) {        return 1;    }    return dstValue / (1 - srcValue);}
public float pdfbox_f4946_0(float srcValue, float dstValue)
{        if (Float.compare(dstValue, 1) == 0) {        return 1;    }    if (1 - dstValue >= srcValue) {        return 0;    }    return 1 - (1 - dstValue) / srcValue;}
public float pdfbox_f4947_0(float srcValue, float dstValue)
{    return (srcValue <= 0.5) ? 2 * dstValue * srcValue : 2 * (srcValue + dstValue - srcValue * dstValue) - 1;}
public float pdfbox_f4948_0(float srcValue, float dstValue)
{    if (srcValue <= 0.5) {        return dstValue - (1 - 2 * srcValue) * dstValue * (1 - dstValue);    } else {        float d = (dstValue <= 0.25) ? ((16 * dstValue - 12) * dstValue + 4) * dstValue : (float) Math.sqrt(dstValue);        return dstValue + (2 * srcValue - 1) * (d - dstValue);    }}
public float pdfbox_f4949_0(float srcValue, float dstValue)
{    return Math.abs(dstValue - srcValue);}
public float pdfbox_f4950_0(float srcValue, float dstValue)
{    return dstValue + srcValue - 2 * dstValue * srcValue;}
public void pdfbox_f4951_0(float[] srcValues, float[] dstValues, float[] result)
{    float[] temp = new float[3];    getSaturationRGB(dstValues, srcValues, temp);    getLuminosityRGB(dstValues, temp, result);}
public void pdfbox_f4952_0(float[] srcValues, float[] dstValues, float[] result)
{    getSaturationRGB(srcValues, dstValues, result);}
public void pdfbox_f4953_0(float[] srcValues, float[] dstValues, float[] result)
{    getLuminosityRGB(dstValues, srcValues, result);}
public void pdfbox_f4954_0(float[] srcValues, float[] dstValues, float[] result)
{    getLuminosityRGB(srcValues, dstValues, result);}
public static BlendMode pdfbox_f4955_0(COSBase cosBlendMode)
{    BlendMode result = null;    if (cosBlendMode instanceof COSName) {        result = BLEND_MODES.get(cosBlendMode);    } else if (cosBlendMode instanceof COSArray) {        COSArray cosBlendModeArray = (COSArray) cosBlendMode;        for (int i = 0; i < cosBlendModeArray.size(); i++) {            result = BLEND_MODES.get(cosBlendModeArray.getObject(i));            if (result != null) {                break;            }        }    }    if (result != null) {        return result;    }    return BlendMode.NORMAL;}
public static COSName pdfbox_f4956_0(BlendMode bm)
{    return BLEND_MODE_NAMES.get(bm);}
private static int pdfbox_f4957_0(float val)
{    return (int) Math.floor(val >= 1.0 ? 255 : val * 255.0);}
private static void pdfbox_f4958_0(float[] srcValues, float[] dstValues, float[] result)
{    int minb;    int maxb;    int mins;    int maxs;    int y;    int scale;    int r;    int g;    int b;    int rd = get255Value(dstValues[0]);    int gd = get255Value(dstValues[1]);    int bd = get255Value(dstValues[2]);    int rs = get255Value(srcValues[0]);    int gs = get255Value(srcValues[1]);    int bs = get255Value(srcValues[2]);    minb = Math.min(rd, Math.min(gd, bd));    maxb = Math.max(rd, Math.max(gd, bd));    if (minb == maxb) {        /* backdrop has zero saturation, avoid divide by 0 */        result[0] = gd / 255.0f;        result[1] = gd / 255.0f;        result[2] = gd / 255.0f;        return;    }    mins = Math.min(rs, Math.min(gs, bs));    maxs = Math.max(rs, Math.max(gs, bs));    scale = ((maxs - mins) << 16) / (maxb - minb);    y = (rd * 77 + gd * 151 + bd * 28 + 0x80) >> 8;    r = y + ((((rd - y) * scale) + 0x8000) >> 16);    g = y + ((((gd - y) * scale) + 0x8000) >> 16);    b = y + ((((bd - y) * scale) + 0x8000) >> 16);    if (((r | g | b) & 0x100) == 0x100) {        int scalemin;        int scalemax;        int min;        int max;        min = Math.min(r, Math.min(g, b));        max = Math.max(r, Math.max(g, b));        if (min < 0) {            scalemin = (y << 16) / (y - min);        } else {            scalemin = 0x10000;        }        if (max > 255) {            scalemax = ((255 - y) << 16) / (max - y);        } else {            scalemax = 0x10000;        }        scale = Math.min(scalemin, scalemax);        r = y + (((r - y) * scale + 0x8000) >> 16);        g = y + (((g - y) * scale + 0x8000) >> 16);        b = y + (((b - y) * scale + 0x8000) >> 16);    }    result[0] = r / 255.0f;    result[1] = g / 255.0f;    result[2] = b / 255.0f;}
private static void pdfbox_f4959_0(float[] srcValues, float[] dstValues, float[] result)
{    int delta;    int scale;    int r;    int g;    int b;    int y;    int rd = get255Value(dstValues[0]);    int gd = get255Value(dstValues[1]);    int bd = get255Value(dstValues[2]);    int rs = get255Value(srcValues[0]);    int gs = get255Value(srcValues[1]);    int bs = get255Value(srcValues[2]);    delta = ((rs - rd) * 77 + (gs - gd) * 151 + (bs - bd) * 28 + 0x80) >> 8;    r = rd + delta;    g = gd + delta;    b = bd + delta;    if (((r | g | b) & 0x100) == 0x100) {        y = (rs * 77 + gs * 151 + bs * 28 + 0x80) >> 8;        if (delta > 0) {            int max;            max = Math.max(r, Math.max(g, b));            scale = max == y ? 0 : ((255 - y) << 16) / (max - y);        } else {            int min;            min = Math.min(r, Math.min(g, b));            scale = y == min ? 0 : (y << 16) / (y - min);        }        r = y + (((r - y) * scale + 0x8000) >> 16);        g = y + (((g - y) * scale + 0x8000) >> 16);        b = y + (((b - y) * scale + 0x8000) >> 16);    }    result[0] = r / 255.0f;    result[1] = g / 255.0f;    result[2] = b / 255.0f;}
private static Map<COSName, BlendMode> pdfbox_f4960_0()
{    Map<COSName, BlendMode> map = new HashMap<>(13);    map.put(COSName.NORMAL, BlendMode.NORMAL);        map.put(COSName.COMPATIBLE, BlendMode.NORMAL);    map.put(COSName.MULTIPLY, BlendMode.MULTIPLY);    map.put(COSName.SCREEN, BlendMode.SCREEN);    map.put(COSName.OVERLAY, BlendMode.OVERLAY);    map.put(COSName.DARKEN, BlendMode.DARKEN);    map.put(COSName.LIGHTEN, BlendMode.LIGHTEN);    map.put(COSName.COLOR_DODGE, BlendMode.COLOR_DODGE);    map.put(COSName.COLOR_BURN, BlendMode.COLOR_BURN);    map.put(COSName.HARD_LIGHT, BlendMode.HARD_LIGHT);    map.put(COSName.SOFT_LIGHT, BlendMode.SOFT_LIGHT);    map.put(COSName.DIFFERENCE, BlendMode.DIFFERENCE);    map.put(COSName.EXCLUSION, BlendMode.EXCLUSION);    map.put(COSName.HUE, BlendMode.HUE);    map.put(COSName.SATURATION, BlendMode.SATURATION);    map.put(COSName.LUMINOSITY, BlendMode.LUMINOSITY);    map.put(COSName.COLOR, BlendMode.COLOR);    return map;}
private static Map<BlendMode, COSName> pdfbox_f4961_0()
{    Map<BlendMode, COSName> map = new HashMap<>(13);    map.put(BlendMode.NORMAL, COSName.NORMAL);        map.put(BlendMode.COMPATIBLE, COSName.NORMAL);    map.put(BlendMode.MULTIPLY, COSName.MULTIPLY);    map.put(BlendMode.SCREEN, COSName.SCREEN);    map.put(BlendMode.OVERLAY, COSName.OVERLAY);    map.put(BlendMode.DARKEN, COSName.DARKEN);    map.put(BlendMode.LIGHTEN, COSName.LIGHTEN);    map.put(BlendMode.COLOR_DODGE, COSName.COLOR_DODGE);    map.put(BlendMode.COLOR_BURN, COSName.COLOR_BURN);    map.put(BlendMode.HARD_LIGHT, COSName.HARD_LIGHT);    map.put(BlendMode.SOFT_LIGHT, COSName.SOFT_LIGHT);    map.put(BlendMode.DIFFERENCE, COSName.DIFFERENCE);    map.put(BlendMode.EXCLUSION, COSName.EXCLUSION);    map.put(BlendMode.HUE, COSName.HUE);    map.put(BlendMode.SATURATION, COSName.SATURATION);    map.put(BlendMode.LUMINOSITY, COSName.LUMINOSITY);    map.put(BlendMode.COLOR, COSName.COLOR);    return map;}
public String pdfbox_f4962_0()
{    return COSName.CALGRAY.getName();}
public int pdfbox_f4963_0()
{    return 1;}
public float[] pdfbox_f4964_0(int bitsPerComponent)
{    return new float[] { 0, 1 };}
public PDColor pdfbox_f4965_0()
{    return initialColor;}
public float[] pdfbox_f4966_0(float[] value)
{        if (isWhitePoint()) {        float a = value[0];        float[] result = map1.get(a);        if (result != null) {            return result.clone();        }        float gamma = getGamma();        float powAG = (float) Math.pow(a, gamma);        result = convXYZtoRGB(powAG, powAG, powAG);        map1.put(a, result.clone());        return result;    } else {        return new float[] { value[0], value[0], value[0] };    }}
public float pdfbox_f4967_0()
{    float retval = 1.0f;    COSNumber gamma = (COSNumber) dictionary.getDictionaryObject(COSName.GAMMA);    if (gamma != null) {        retval = gamma.floatValue();    }    return retval;}
public void pdfbox_f4968_0(float value)
{    dictionary.setItem(COSName.GAMMA, new COSFloat(value));}
public String pdfbox_f4969_0()
{    return COSName.CALRGB.getName();}
public int pdfbox_f4970_0()
{    return 3;}
public float[] pdfbox_f4971_0(int bitsPerComponent)
{    return new float[] { 0, 1, 0, 1, 0, 1 };}
public PDColor pdfbox_f4972_0()
{    return initialColor;}
public float[] pdfbox_f4973_0(float[] value)
{    if (isWhitePoint()) {        float a = value[0];        float b = value[1];        float c = value[2];        PDGamma gamma = getGamma();        float powAR = (float) Math.pow(a, gamma.getR());        float powBG = (float) Math.pow(b, gamma.getG());        float powCB = (float) Math.pow(c, gamma.getB());        float[] matrix = getMatrix();        float mXA = matrix[0];        float mYA = matrix[1];        float mZA = matrix[2];        float mXB = matrix[3];        float mYB = matrix[4];        float mZB = matrix[5];        float mXC = matrix[6];        float mYC = matrix[7];        float mZC = matrix[8];        float x = mXA * powAR + mXB * powBG + mXC * powCB;        float y = mYA * powAR + mYB * powBG + mYC * powCB;        float z = mZA * powAR + mZB * powBG + mZC * powCB;        return convXYZtoRGB(x, y, z);    } else {                return new float[] { value[0], value[1], value[2] };    }}
public final PDGamma pdfbox_f4974_0()
{    COSArray gammaArray = (COSArray) dictionary.getDictionaryObject(COSName.GAMMA);    if (gammaArray == null) {        gammaArray = new COSArray();        gammaArray.add(new COSFloat(1.0f));        gammaArray.add(new COSFloat(1.0f));        gammaArray.add(new COSFloat(1.0f));        dictionary.setItem(COSName.GAMMA, gammaArray);    }    return new PDGamma(gammaArray);}
public final float[] pdfbox_f4975_0()
{    COSArray matrix = (COSArray) dictionary.getDictionaryObject(COSName.MATRIX);    if (matrix == null) {        return new float[] { 1, 0, 0, 0, 1, 0, 0, 0, 1 };    } else {        return matrix.toFloatArray();    }}
public final void pdfbox_f4976_0(PDGamma gamma)
{    COSArray gammaArray = null;    if (gamma != null) {        gammaArray = gamma.getCOSArray();    }    dictionary.setItem(COSName.GAMMA, gammaArray);}
public final void pdfbox_f4977_0(Matrix matrix)
{    COSArray matrixArray = null;    if (matrix != null) {                float[][] values = matrix.getValues();        matrixArray = new COSArray();        matrixArray.add(new COSFloat(values[0][0]));        matrixArray.add(new COSFloat(values[0][1]));        matrixArray.add(new COSFloat(values[0][2]));        matrixArray.add(new COSFloat(values[1][0]));        matrixArray.add(new COSFloat(values[1][1]));        matrixArray.add(new COSFloat(values[1][2]));        matrixArray.add(new COSFloat(values[2][0]));        matrixArray.add(new COSFloat(values[2][1]));        matrixArray.add(new COSFloat(values[2][2]));    }    dictionary.setItem(COSName.MATRIX, matrixArray);}
public BufferedImage pdfbox_f4978_0(WritableRaster raster) throws IOException
{                int width = raster.getWidth();    int height = raster.getHeight();    BufferedImage rgbImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);    WritableRaster rgbRaster = rgbImage.getRaster();        float[] abc = new float[3];    for (int y = 0; y < height; y++) {        for (int x = 0; x < width; x++) {            raster.getPixel(x, y, abc);                        abc[0] /= 255;            abc[1] /= 255;            abc[2] /= 255;            float[] rgb = toRGB(abc);                        rgb[0] *= 255;            rgb[1] *= 255;            rgb[2] *= 255;            rgbRaster.setPixel(x, y, rgb);        }    }    return rgbImage;}
public String pdfbox_f4979_0()
{        return getName();}
protected boolean pdfbox_f4980_0()
{    return Float.compare(wpX, 1) == 0 && Float.compare(wpY, 1) == 0 && Float.compare(wpZ, 1) == 0;}
private void pdfbox_f4981_0(PDTristimulus whitepoint)
{    wpX = whitepoint.getX();    wpY = whitepoint.getY();    wpZ = whitepoint.getZ();}
protected float[] pdfbox_f4982_0(float x, float y, float z)
{        if (x < 0) {        x = 0;    }    if (y < 0) {        y = 0;    }    if (z < 0) {        z = 0;    }    return CIEXYZ.toRGB(new float[] { x, y, z });}
public final PDTristimulus pdfbox_f4983_0()
{    COSArray wp = (COSArray) dictionary.getDictionaryObject(COSName.WHITE_POINT);    if (wp == null) {        wp = new COSArray();        wp.add(new COSFloat(1.0f));        wp.add(new COSFloat(1.0f));        wp.add(new COSFloat(1.0f));    }    return new PDTristimulus(wp);}
public final PDTristimulus pdfbox_f4984_0()
{    COSArray bp = (COSArray) dictionary.getDictionaryObject(COSName.BLACK_POINT);    if (bp == null) {        bp = new COSArray();        bp.add(new COSFloat(0.0f));        bp.add(new COSFloat(0.0f));        bp.add(new COSFloat(0.0f));    }    return new PDTristimulus(bp);}
public void pdfbox_f4985_0(PDTristimulus whitepoint)
{    COSBase wpArray = whitepoint.getCOSObject();    if (wpArray != null) {        dictionary.setItem(COSName.WHITE_POINT, wpArray);    }    fillWhitepointCache(whitepoint);}
public void pdfbox_f4986_0(PDTristimulus blackpoint)
{    COSBase bpArray = null;    if (blackpoint != null) {        bpArray = blackpoint.getCOSObject();    }    dictionary.setItem(COSName.BLACK_POINT, bpArray);}
public float[] pdfbox_f4987_0()
{    if (colorSpace instanceof PDPattern || colorSpace == null) {                return components.clone();    }        return Arrays.copyOf(components, colorSpace.getNumberOfComponents());}
public COSName pdfbox_f4988_0()
{    return patternName;}
public boolean pdfbox_f4989_0()
{    return patternName != null;}
public int pdfbox_f4990_0() throws IOException
{    float[] floats = colorSpace.toRGB(components);    int r = Math.round(floats[0] * 255);    int g = Math.round(floats[1] * 255);    int b = Math.round(floats[2] * 255);    int rgb = r;    rgb = (rgb << 8) + g;    rgb = (rgb << 8) + b;    return rgb;}
public COSArray pdfbox_f4991_0()
{    COSArray array = new COSArray();    array.setFloatArray(components);    if (patternName != null) {        array.add(patternName);    }    return array;}
public PDColorSpace pdfbox_f4992_0()
{    return colorSpace;}
public String pdfbox_f4993_0()
{    return "PDColor{components=" + Arrays.toString(components) + ", patternName=" + patternName + ", colorSpace=" + colorSpace + '}';}
public static PDColorSpace pdfbox_f4994_0(COSBase colorSpace) throws IOException
{    return create(colorSpace, null);}
public static PDColorSpace pdfbox_f4995_0(COSBase colorSpace, PDResources resources) throws IOException
{    return create(colorSpace, resources, false);}
public static PDColorSpace pdfbox_f4996_0(COSBase colorSpace, PDResources resources, boolean wasDefault) throws IOException
{    if (colorSpace instanceof COSObject) {        return createFromCOSObject((COSObject) colorSpace, resources);    } else if (colorSpace instanceof COSName) {        COSName name = (COSName) colorSpace;                if (resources != null) {            COSName defaultName = null;            if (name.equals(COSName.DEVICECMYK) && resources.hasColorSpace(COSName.DEFAULT_CMYK)) {                defaultName = COSName.DEFAULT_CMYK;            } else if (name.equals(COSName.DEVICERGB) && resources.hasColorSpace(COSName.DEFAULT_RGB)) {                defaultName = COSName.DEFAULT_RGB;            } else if (name.equals(COSName.DEVICEGRAY) && resources.hasColorSpace(COSName.DEFAULT_GRAY)) {                defaultName = COSName.DEFAULT_GRAY;            }            if (resources.hasColorSpace(defaultName) && !wasDefault) {                return resources.getColorSpace(defaultName, true);            }        }                if (name == COSName.DEVICECMYK) {            return PDDeviceCMYK.INSTANCE;        } else if (name == COSName.DEVICERGB) {            return PDDeviceRGB.INSTANCE;        } else if (name == COSName.DEVICEGRAY) {            return PDDeviceGray.INSTANCE;        } else if (name == COSName.PATTERN) {            return new PDPattern(resources);        } else if (resources != null) {            if (!resources.hasColorSpace(name)) {                throw new MissingResourceException("Missing color space: " + name.getName());            }            return resources.getColorSpace(name);        } else {            throw new MissingResourceException("Unknown color space: " + name.getName());        }    } else if (colorSpace instanceof COSArray) {        COSArray array = (COSArray) colorSpace;        if (array.size() == 0) {            throw new IOException("Colorspace array is empty");        }        COSBase base = array.getObject(0);        if (!(base instanceof COSName)) {            throw new IOException("First element in colorspace array must be a name");        }        COSName name = (COSName) base;        if (name == COSName.CALGRAY) {            return new PDCalGray(array);        } else if (name == COSName.CALRGB) {            return new PDCalRGB(array);        } else if (name == COSName.DEVICEN) {            return new PDDeviceN(array);        } else if (name == COSName.INDEXED) {            return new PDIndexed(array, resources);        } else if (name == COSName.SEPARATION) {            return new PDSeparation(array);        } else if (name == COSName.ICCBASED) {            return PDICCBased.create(array, resources);        } else if (name == COSName.LAB) {            return new PDLab(array);        } else if (name == COSName.PATTERN) {            if (array.size() == 1) {                return new PDPattern(resources);            } else {                return new PDPattern(resources, PDColorSpace.create(array.get(1)));            }        } else if (name == COSName.DEVICECMYK || name == COSName.DEVICERGB || name == COSName.DEVICEGRAY) {                        return create(name, resources, wasDefault);        } else {            throw new IOException("Invalid color space kind: " + name);        }    } else {        throw new IOException("Expected a name or array but got: " + colorSpace);    }}
private static PDColorSpace pdfbox_f4997_0(COSObject colorSpace, PDResources resources) throws IOException
{    PDColorSpace cs;    if (resources != null && resources.getResourceCache() != null) {        ResourceCache resourceCache = resources.getResourceCache();        cs = resourceCache.getColorSpace(colorSpace);        if (cs != null) {            return cs;        }    }    cs = create(colorSpace.getObject(), resources);    if (resources != null && resources.getResourceCache() != null && cs != null) {        ResourceCache resourceCache = resources.getResourceCache();        resourceCache.put(colorSpace, cs);    }    return cs;}
protected BufferedImage pdfbox_f4998_0(WritableRaster raster, ColorSpace colorSpace)
{                    ColorModel colorModel = new ComponentColorModel(colorSpace, false, false, Transparency.OPAQUE, raster.getDataBuffer().getDataType());    BufferedImage src = new BufferedImage(colorModel, raster, false, null);    BufferedImage dest = new BufferedImage(raster.getWidth(), raster.getHeight(), BufferedImage.TYPE_INT_RGB);    ColorConvertOp op = new ColorConvertOp(null);    op.filter(src, dest);    return dest;}
public COSBase pdfbox_f4999_0()
{    return array;}
protected void pdfbox_f5000_0() throws IOException
{        if (awtColorSpace != null) {        return;    }    synchronized (this) {                if (awtColorSpace != null) {            return;        }                ICC_Profile iccProfile = getICCProfile();        if (iccProfile == null) {            throw new IOException("Default CMYK color profile could not be loaded");        }        awtColorSpace = new ICC_ColorSpace(iccProfile);                                awtColorSpace.toRGB(new float[] { 0, 0, 0, 0 });        usePureJavaCMYKConversion = System.getProperty("org.apache.pdfbox.rendering.UsePureJavaCMYKConversion") != null;    }}
protected ICC_Profile pdfbox_f5001_0() throws IOException
{                    String name = "/org/apache/pdfbox/resources/icc/ISOcoated_v2_300_bas.icc";    try (InputStream is = PDDeviceCMYK.class.getResourceAsStream(name)) {        if (is == null) {            throw new IOException("Error loading resource: " + name);        }        return ICC_Profile.getInstance(is);    }}
public String pdfbox_f5002_0()
{    return COSName.DEVICECMYK.getName();}
public int pdfbox_f5003_0()
{    return 4;}
public float[] pdfbox_f5004_0(int bitsPerComponent)
{    return new float[] { 0, 1, 0, 1, 0, 1, 0, 1 };}
public PDColor pdfbox_f5005_0()
{    return initialColor;}
public float[] pdfbox_f5006_0(float[] value) throws IOException
{    init();    return awtColorSpace.toRGB(value);}
public BufferedImage pdfbox_f5007_0(WritableRaster raster) throws IOException
{    init();    return toRGBImageAWT(raster, awtColorSpace);}
protected BufferedImage pdfbox_f5008_0(WritableRaster raster, ColorSpace colorSpace)
{    if (usePureJavaCMYKConversion) {        BufferedImage dest = new BufferedImage(raster.getWidth(), raster.getHeight(), BufferedImage.TYPE_INT_RGB);        ColorSpace destCS = dest.getColorModel().getColorSpace();        WritableRaster destRaster = dest.getRaster();        float[] srcValues = new float[4];        float[] lastValues = new float[] { -1.0f, -1.0f, -1.0f, -1.0f };        float[] destValues = new float[3];        int width = raster.getWidth();        int startX = raster.getMinX();        int height = raster.getHeight();        int startY = raster.getMinY();        for (int x = startX; x < width + startX; x++) {            for (int y = startY; y < height + startY; y++) {                raster.getPixel(x, y, srcValues);                                if (!Arrays.equals(lastValues, srcValues)) {                    for (int k = 0; k < 4; k++) {                        lastValues[k] = srcValues[k];                        srcValues[k] = srcValues[k] / 255f;                    }                                        destValues = destCS.fromCIEXYZ(colorSpace.toCIEXYZ(srcValues));                    for (int k = 0; k < destValues.length; k++) {                        destValues[k] = destValues[k] * 255f;                    }                }                destRaster.setPixel(x, y, destValues);            }        }        return dest;    } else {        return super.toRGBImageAWT(raster, colorSpace);    }}
public String pdfbox_f5009_0()
{    return getName();}
public COSBase pdfbox_f5010_0()
{    return COSName.getPDFName(getName());}
public String pdfbox_f5011_0()
{    return COSName.DEVICEGRAY.getName();}
public int pdfbox_f5012_0()
{    return 1;}
public float[] pdfbox_f5013_0(int bitsPerComponent)
{    return new float[] { 0, 1 };}
public PDColor pdfbox_f5014_0()
{    return initialColor;}
public float[] pdfbox_f5015_0(float[] value)
{    return new float[] { value[0], value[0], value[0] };}
public BufferedImage pdfbox_f5016_0(WritableRaster raster) throws IOException
{    int width = raster.getWidth();    int height = raster.getHeight();    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);    int[] gray = new int[1];    int[] rgb = new int[3];    for (int y = 0; y < height; y++) {        for (int x = 0; x < width; x++) {            raster.getPixel(x, y, gray);            rgb[0] = gray[0];            rgb[1] = gray[0];            rgb[2] = gray[0];            image.getRaster().setPixel(x, y, rgb);        }    }    return image;}
private void pdfbox_f5017_0() throws IOException
{        if (attributes == null) {        return;    }        List<String> colorantNames = getColorantNames();    numColorants = colorantNames.size();        colorantToComponent = new int[numColorants];    for (int c = 0; c < numColorants; c++) {        colorantToComponent[c] = -1;    }    if (attributes.getProcess() != null) {        List<String> components = attributes.getProcess().getComponents();                for (int c = 0; c < numColorants; c++) {            colorantToComponent[c] = components.indexOf(colorantNames.get(c));        }                processColorSpace = attributes.getProcess().getColorSpace();    }        spotColorSpaces = new PDSeparation[numColorants];        Map<String, PDSeparation> spotColorants = attributes.getColorants();        for (int c = 0; c < numColorants; c++) {        String name = colorantNames.get(c);        PDSeparation spot = spotColorants.get(name);        if (spot != null) {                        spotColorSpaces[c] = spot;                        if (!isNChannel()) {                colorantToComponent[c] = -1;            }        } else {                        spotColorSpaces[c] = null;        }    }}
public BufferedImage pdfbox_f5018_0(WritableRaster raster) throws IOException
{    if (attributes != null) {        return toRGBWithAttributes(raster);    } else {        return toRGBWithTintTransform(raster);    }}
private BufferedImage pdfbox_f5019_0(WritableRaster raster) throws IOException
{    int width = raster.getWidth();    int height = raster.getHeight();    BufferedImage rgbImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);    WritableRaster rgbRaster = rgbImage.getRaster();        Graphics2D g = rgbImage.createGraphics();    g.setBackground(Color.WHITE);    g.clearRect(0, 0, width, height);    g.dispose();        for (int c = 0; c < numColorants; c++) {        PDColorSpace componentColorSpace;        if (colorantToComponent[c] >= 0) {                        componentColorSpace = processColorSpace;        } else if (spotColorSpaces[c] == null) {                        return toRGBWithTintTransform(raster);        } else {                        componentColorSpace = spotColorSpaces[c];        }                WritableRaster componentRaster = Raster.createBandedRaster(DataBuffer.TYPE_BYTE, width, height, componentColorSpace.getNumberOfComponents(), new Point(0, 0));        int[] samples = new int[numColorants];        int[] componentSamples = new int[componentColorSpace.getNumberOfComponents()];        boolean isProcessColorant = colorantToComponent[c] >= 0;        int componentIndex = colorantToComponent[c];        for (int y = 0; y < height; y++) {            for (int x = 0; x < width; x++) {                raster.getPixel(x, y, samples);                if (isProcessColorant) {                                        componentSamples[componentIndex] = samples[c];                } else {                                        componentSamples[0] = samples[c];                }                componentRaster.setPixel(x, y, componentSamples);            }        }                BufferedImage rgbComponentImage = componentColorSpace.toRGBImage(componentRaster);        WritableRaster rgbComponentRaster = rgbComponentImage.getRaster();                int[] rgbChannel = new int[3];        int[] rgbComposite = new int[3];        for (int y = 0; y < height; y++) {            for (int x = 0; x < width; x++) {                rgbComponentRaster.getPixel(x, y, rgbChannel);                rgbRaster.getPixel(x, y, rgbComposite);                                rgbChannel[0] = rgbChannel[0] * rgbComposite[0] >> 8;                rgbChannel[1] = rgbChannel[1] * rgbComposite[1] >> 8;                rgbChannel[2] = rgbChannel[2] * rgbComposite[2] >> 8;                rgbRaster.setPixel(x, y, rgbChannel);            }        }    }    return rgbImage;}
private BufferedImage pdfbox_f5020_0(WritableRaster raster) throws IOException
{        Map<String, int[]> map1 = new HashMap<>();    String key;    int width = raster.getWidth();    int height = raster.getHeight();            BufferedImage rgbImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);    WritableRaster rgbRaster = rgbImage.getRaster();    int[] rgb = new int[3];    int numSrcComponents = getColorantNames().size();    float[] src = new float[numSrcComponents];    for (int y = 0; y < height; y++) {        for (int x = 0; x < width; x++) {            raster.getPixel(x, y, src);                        key = Float.toString(src[0]);            for (int s = 1; s < numSrcComponents; s++) {                key += "#" + Float.toString(src[s]);            }            int[] pxl = map1.get(key);            if (pxl != null) {                rgbRaster.setPixel(x, y, pxl);                continue;            }                        for (int s = 0; s < numSrcComponents; s++) {                src[s] = src[s] / 255;            }                        float[] result = tintTransform.eval(src);                        float[] rgbFloat = alternateColorSpace.toRGB(result);            for (int s = 0; s < 3; s++) {                                rgb[s] = (int) (rgbFloat[s] * 255f);            }                        map1.put(key, rgb.clone());            rgbRaster.setPixel(x, y, rgb);        }    }    return rgbImage;}
public float[] pdfbox_f5021_0(float[] value) throws IOException
{    if (attributes != null) {        return toRGBWithAttributes(value);    } else {        return toRGBWithTintTransform(value);    }}
private float[] pdfbox_f5022_0(float[] value) throws IOException
{    float[] rgbValue = new float[] { 1, 1, 1 };        for (int c = 0; c < numColorants; c++) {        PDColorSpace componentColorSpace;        if (colorantToComponent[c] >= 0) {                        componentColorSpace = processColorSpace;        } else if (spotColorSpaces[c] == null) {                        return toRGBWithTintTransform(value);        } else {                        componentColorSpace = spotColorSpaces[c];        }                boolean isProcessColorant = colorantToComponent[c] >= 0;        float[] componentSamples = new float[componentColorSpace.getNumberOfComponents()];        int componentIndex = colorantToComponent[c];        if (isProcessColorant) {                        componentSamples[componentIndex] = value[c];        } else {                        componentSamples[0] = value[c];        }                float[] rgbComponent = componentColorSpace.toRGB(componentSamples);                        rgbValue[0] *= rgbComponent[0];        rgbValue[1] *= rgbComponent[1];        rgbValue[2] *= rgbComponent[2];    }    return rgbValue;}
private float[] pdfbox_f5023_0(float[] value) throws IOException
{            float[] altValue = tintTransform.eval(value);        return alternateColorSpace.toRGB(altValue);}
public boolean pdfbox_f5024_0()
{    return attributes != null && attributes.isNChannel();}
public String pdfbox_f5025_0()
{    return COSName.DEVICEN.getName();}
public final int pdfbox_f5026_0()
{    return getColorantNames().size();}
public float[] pdfbox_f5027_0(int bitsPerComponent)
{    int n = getNumberOfComponents();    float[] decode = new float[n * 2];    for (int i = 0; i < n; i++) {        decode[i * 2 + 1] = 1;    }    return decode;}
public PDColor pdfbox_f5028_0()
{    return initialColor;}
public List<String> pdfbox_f5029_0()
{    COSArray names = (COSArray) array.getObject(COLORANT_NAMES);    return COSArrayList.convertCOSNameCOSArrayToList(names);}
public PDDeviceNAttributes pdfbox_f5030_0()
{    return attributes;}
public void pdfbox_f5031_0(List<String> names)
{    COSArray namesArray = COSArrayList.convertStringListToCOSNameCOSArray(names);    array.set(COLORANT_NAMES, namesArray);}
public void pdfbox_f5032_0(PDDeviceNAttributes attributes)
{    this.attributes = attributes;    if (attributes == null) {        array.remove(DEVICEN_ATTRIBUTES);    } else {                while (array.size() <= DEVICEN_ATTRIBUTES) {            array.add(COSNull.NULL);        }        array.set(DEVICEN_ATTRIBUTES, attributes.getCOSDictionary());    }}
public PDColorSpace pdfbox_f5033_0() throws IOException
{    if (alternateColorSpace == null) {        alternateColorSpace = PDColorSpace.create(array.getObject(ALTERNATE_CS));    }    return alternateColorSpace;}
public void pdfbox_f5034_0(PDColorSpace cs)
{    alternateColorSpace = cs;    COSBase space = null;    if (cs != null) {        space = cs.getCOSObject();    }    array.set(ALTERNATE_CS, space);}
public PDFunction pdfbox_f5035_0() throws IOException
{    if (tintTransform == null) {        tintTransform = PDFunction.create(array.getObject(TINT_TRANSFORM));    }    return tintTransform;}
public void pdfbox_f5036_0(PDFunction tint)
{    tintTransform = tint;    array.set(TINT_TRANSFORM, tint);}
public String pdfbox_f5037_0()
{    StringBuilder sb = new StringBuilder(getName());    sb.append('{');    for (String col : getColorantNames()) {        sb.append('\"');        sb.append(col);        sb.append("\" ");    }    sb.append(alternateColorSpace.getName());    sb.append(' ');    sb.append(tintTransform);    sb.append(' ');    if (attributes != null) {        sb.append(attributes);    }    sb.append('}');    return sb.toString();}
public COSDictionary pdfbox_f5038_0()
{    return dictionary;}
public Map<String, PDSeparation> pdfbox_f5039_0() throws IOException
{    Map<String, PDSeparation> actuals = new HashMap<>();    COSDictionary colorants = dictionary.getCOSDictionary(COSName.COLORANTS);    if (colorants == null) {        colorants = new COSDictionary();        dictionary.setItem(COSName.COLORANTS, colorants);    }    for (COSName name : colorants.keySet()) {        COSBase value = colorants.getDictionaryObject(name);        actuals.put(name.getName(), (PDSeparation) PDColorSpace.create(value));    }    return new COSDictionaryMap<>(actuals, colorants);}
public PDDeviceNProcess pdfbox_f5040_0()
{    COSDictionary process = dictionary.getCOSDictionary(COSName.PROCESS);    if (process == null) {        return null;    }    return new PDDeviceNProcess(process);}
public boolean pdfbox_f5041_0()
{    return "NChannel".equals(dictionary.getNameAsString(COSName.SUBTYPE));}
public void pdfbox_f5042_0(Map<String, PDColorSpace> colorants)
{    COSDictionary colorantDict = null;    if (colorants != null) {        colorantDict = COSDictionaryMap.convert(colorants);    }    dictionary.setItem(COSName.COLORANTS, colorantDict);}
public String pdfbox_f5043_1()
{    StringBuilder sb = new StringBuilder(dictionary.getNameAsString(COSName.SUBTYPE));    sb.append('{');    PDDeviceNProcess process = getProcess();    if (process != null) {        sb.append(getProcess());        sb.append(' ');    }    Map<String, PDSeparation> colorants;    try {        colorants = getColorants();        sb.append("Colorants{");        for (Map.Entry<String, PDSeparation> col : colorants.entrySet()) {            sb.append('\"');            sb.append(col.getKey());            sb.append("\": ");            sb.append(col.getValue());            sb.append(' ');        }        sb.append('}');    } catch (IOException e) {                sb.append("ERROR");    }    sb.append('}');    return sb.toString();}
public COSDictionary pdfbox_f5044_0()
{    return dictionary;}
public PDColorSpace pdfbox_f5045_0() throws IOException
{    COSBase cosColorSpace = dictionary.getDictionaryObject(COSName.COLORSPACE);    if (cosColorSpace == null) {                return null;    }    return PDColorSpace.create(cosColorSpace);}
