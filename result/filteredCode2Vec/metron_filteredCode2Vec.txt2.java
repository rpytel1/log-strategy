public void metron_f2089_0() throws Exception
{    processBuilder = mock(ProcessBuilder.class);    environment = mock(Environment.class);    process = mock(Process.class);    stormCLIWrapper = new StormCLIWrapper();    stormCLIWrapper.setEnvironment(environment);}
public void metron_f2090_0() throws Exception
{    whenNew(ProcessBuilder.class).withParameterTypes(String[].class).withArguments(anyVararg()).thenReturn(processBuilder);    when(processBuilder.start()).thenReturn(process);    when(environment.getProperty(MetronRestConstants.PARSER_SCRIPT_PATH_SPRING_PROPERTY)).thenReturn("/start_parser");    when(environment.getProperty(MetronRestConstants.KAFKA_BROKER_URL_SPRING_PROPERTY)).thenReturn("kafka_broker_url");    when(environment.getProperty(MetronRestConstants.ZK_URL_SPRING_PROPERTY)).thenReturn("zookeeper_url");    when(environment.getProperty(MetronRestConstants.KERBEROS_ENABLED_SPRING_PROPERTY, Boolean.class, false)).thenReturn(false);    when(environment.getProperty(MetronRestConstants.KAFKA_SECURITY_PROTOCOL_SPRING_PROPERTY)).thenReturn("kafka_security_protocol");    when(process.exitValue()).thenReturn(0);    assertEquals(0, stormCLIWrapper.startParserTopology("bro"));    verify(process).waitFor();    verifyNew(ProcessBuilder.class).withArguments("/start_parser", "-s", "bro", "-z", "zookeeper_url", "-k", "kafka_broker_url", "-ksp", "kafka_security_protocol");}
public void metron_f2091_0() throws Exception
{    whenNew(ProcessBuilder.class).withParameterTypes(String[].class).withArguments(anyVararg()).thenReturn(processBuilder);    when(processBuilder.start()).thenReturn(process);    when(environment.getProperty(MetronRestConstants.PARSER_SCRIPT_PATH_SPRING_PROPERTY)).thenReturn("/start_parser");    when(environment.getProperty(MetronRestConstants.KAFKA_BROKER_URL_SPRING_PROPERTY)).thenReturn("kafka_broker_url");    when(environment.getProperty(MetronRestConstants.ZK_URL_SPRING_PROPERTY)).thenReturn("zookeeper_url");    when(environment.getProperty(MetronRestConstants.KERBEROS_ENABLED_SPRING_PROPERTY, Boolean.class, false)).thenReturn(true);    when(environment.getProperty(MetronRestConstants.KAFKA_SECURITY_PROTOCOL_SPRING_PROPERTY)).thenReturn("kafka_security_protocol");    when(environment.getProperty(MetronRestConstants.PARSER_TOPOLOGY_OPTIONS_SPRING_PROPERTY)).thenReturn("parser_topology_options");    when(process.exitValue()).thenReturn(0);    assertEquals(0, stormCLIWrapper.startParserTopology("bro"));    verify(process, times(2)).waitFor();    verifyNew(ProcessBuilder.class).withArguments("/start_parser", "-s", "bro", "-z", "zookeeper_url", "-k", "kafka_broker_url", "-ksp", "kafka_security_protocol", "-e", "parser_topology_options");}
public void metron_f2092_0() throws Exception
{    whenNew(ProcessBuilder.class).withParameterTypes(String[].class).withArguments(anyVararg()).thenReturn(processBuilder);    when(processBuilder.start()).thenReturn(process);    when(environment.getProperty(MetronRestConstants.KERBEROS_ENABLED_SPRING_PROPERTY, Boolean.class, false)).thenReturn(false);    when(process.exitValue()).thenReturn(0);    assertEquals(0, stormCLIWrapper.stopParserTopology("bro", false));    verify(process).waitFor();    verifyNew(ProcessBuilder.class).withArguments("storm", "kill", "bro");}
public void metron_f2093_0() throws Exception
{    whenNew(ProcessBuilder.class).withParameterTypes(String[].class).withArguments(anyVararg()).thenReturn(processBuilder);    when(processBuilder.start()).thenReturn(process);    when(environment.getProperty(MetronRestConstants.KERBEROS_ENABLED_SPRING_PROPERTY, Boolean.class, false)).thenReturn(false);    when(process.exitValue()).thenReturn(0);    assertEquals(0, stormCLIWrapper.stopParserTopology("bro", true));    verify(process).waitFor();    verifyNew(ProcessBuilder.class).withArguments("storm", "kill", "bro", "-w", "0");}
public void metron_f2094_0() throws Exception
{    whenNew(ProcessBuilder.class).withParameterTypes(String[].class).withArguments(anyVararg()).thenReturn(processBuilder);    when(processBuilder.start()).thenReturn(process);    when(environment.getProperty(MetronRestConstants.ENRICHMENT_SCRIPT_PATH_SPRING_PROPERTY)).thenReturn("/start_enrichment");    when(environment.getProperty(MetronRestConstants.KERBEROS_ENABLED_SPRING_PROPERTY, Boolean.class, false)).thenReturn(false);    when(process.exitValue()).thenReturn(0);    assertEquals(0, stormCLIWrapper.startEnrichmentTopology());    verify(process).waitFor();    verifyNew(ProcessBuilder.class).withArguments("/start_enrichment");}
public void metron_f2095_0() throws Exception
{    whenNew(ProcessBuilder.class).withParameterTypes(String[].class).withArguments(anyVararg()).thenReturn(processBuilder);    when(processBuilder.start()).thenReturn(process);    when(environment.getProperty(MetronRestConstants.KERBEROS_ENABLED_SPRING_PROPERTY, Boolean.class, false)).thenReturn(false);    when(process.exitValue()).thenReturn(0);    assertEquals(0, stormCLIWrapper.stopEnrichmentTopology(false));    verify(process).waitFor();    verifyNew(ProcessBuilder.class).withArguments("storm", "kill", MetronRestConstants.ENRICHMENT_TOPOLOGY_NAME);}
public void metron_f2096_0() throws Exception
{    whenNew(ProcessBuilder.class).withParameterTypes(String[].class).withArguments(anyVararg()).thenReturn(processBuilder);    when(processBuilder.start()).thenReturn(process);    when(environment.getProperty(MetronRestConstants.RANDOM_ACCESS_INDEXING_SCRIPT_PATH_SPRING_PROPERTY)).thenReturn("/start_indexing");    when(environment.getProperty(MetronRestConstants.KERBEROS_ENABLED_SPRING_PROPERTY, Boolean.class, false)).thenReturn(false);    when(process.exitValue()).thenReturn(0);    assertEquals(0, stormCLIWrapper.startIndexingTopology(MetronRestConstants.RANDOM_ACCESS_INDEXING_SCRIPT_PATH_SPRING_PROPERTY));    verify(process).waitFor();    verifyNew(ProcessBuilder.class).withArguments("/start_indexing");}
public void metron_f2097_0() throws Exception
{    whenNew(ProcessBuilder.class).withParameterTypes(String[].class).withArguments(anyVararg()).thenReturn(processBuilder);    when(processBuilder.start()).thenReturn(process);    when(environment.getProperty(MetronRestConstants.KERBEROS_ENABLED_SPRING_PROPERTY, Boolean.class, false)).thenReturn(false);    when(process.exitValue()).thenReturn(0);    assertEquals(0, stormCLIWrapper.stopIndexingTopology("random_access_indexing", false));    verify(process).waitFor();    verifyNew(ProcessBuilder.class).withArguments("storm", "kill", MetronRestConstants.RANDOM_ACCESS_INDEXING_TOPOLOGY_NAME);}
public void metron_f2098_0() throws Exception
{    whenNew(ProcessBuilder.class).withParameterTypes(String[].class).withArguments(anyVararg()).thenReturn(processBuilder);    Process process = mock(Process.class);    InputStream inputStream = new ByteArrayInputStream("\nStorm 1.1".getBytes(UTF_8));    when(processBuilder.start()).thenReturn(process);    when(process.getInputStream()).thenReturn(inputStream);    when(environment.getProperty(MetronRestConstants.PARSER_SCRIPT_PATH_SPRING_PROPERTY)).thenReturn("/start_parser");    when(environment.getProperty(MetronRestConstants.ENRICHMENT_SCRIPT_PATH_SPRING_PROPERTY)).thenReturn("/start_enrichment");    when(environment.getProperty(MetronRestConstants.RANDOM_ACCESS_INDEXING_SCRIPT_PATH_SPRING_PROPERTY)).thenReturn("/start_elasticsearch");    when(environment.getProperty(MetronRestConstants.BATCH_INDEXING_SCRIPT_PATH_SPRING_PROPERTY)).thenReturn("/start_hdfs");    Map<String, String> actual = stormCLIWrapper.getStormClientStatus();    assertEquals(new HashMap<String, String>() {        {            put("randomAccessIndexingScriptPath", "/start_elasticsearch");            put("enrichmentScriptPath", "/start_enrichment");            put("stormClientVersionInstalled", "1.1");            put("parserScriptPath", "/start_parser");            put("batchIndexingScriptPath", "/start_hdfs");        }    }, actual);    verifyNew(ProcessBuilder.class).withArguments("storm", "version");}
public void metron_f2099_0() throws Exception
{    whenNew(ProcessBuilder.class).withParameterTypes(String[].class).withArguments(anyVararg()).thenReturn(processBuilder);    Process process = mock(Process.class);    InputStream inputStream = new ByteArrayInputStream("".getBytes(UTF_8));    when(processBuilder.start()).thenReturn(process);    when(process.getInputStream()).thenReturn(inputStream);    assertEquals("Storm client is not installed", stormCLIWrapper.stormClientVersionInstalled());}
public void metron_f2100_0() throws Exception
{    exception.expect(RestException.class);    whenNew(ProcessBuilder.class).withParameterTypes(String[].class).withArguments(anyVararg()).thenReturn(processBuilder);    when(processBuilder.start()).thenThrow(new IOException());    stormCLIWrapper.runCommand(new String[] { "storm", "kill" });}
public void metron_f2101_0() throws Exception
{    exception.expect(RestException.class);    whenNew(ProcessBuilder.class).withParameterTypes(String[].class).withArguments(anyVararg()).thenReturn(processBuilder);    when(processBuilder.start()).thenThrow(new IOException());    stormCLIWrapper.stormClientVersionInstalled();}
public void metron_f2102_0() throws Exception
{    whenNew(ProcessBuilder.class).withParameterTypes(String[].class).withArguments(anyVararg()).thenReturn(processBuilder);    when(processBuilder.start()).thenReturn(process);    when(environment.getProperty(MetronRestConstants.KERBEROS_ENABLED_SPRING_PROPERTY, Boolean.class, false)).thenReturn(true);    when(environment.getProperty(MetronRestConstants.KERBEROS_KEYTAB_SPRING_PROPERTY)).thenReturn("metron keytabLocation");    when(environment.getProperty(MetronRestConstants.KERBEROS_PRINCIPLE_SPRING_PROPERTY)).thenReturn("metron principal");    when(process.exitValue()).thenReturn(0);    stormCLIWrapper.kinit();    verify(process, times(1)).waitFor();    verifyNew(ProcessBuilder.class).withArguments("kinit", "-kt", "metron keytabLocation", "metron principal");}
public void metron_f2103_0() throws Exception
{    environment = mock(Environment.class);    restTemplate = mock(RestTemplate.class);    sensorParserGroupService = mock(SensorParserGroupService.class);    stormStatusService = new StormStatusServiceImpl(environment, restTemplate, sensorParserGroupService);}
public void metron_f2104_0()
{    when(environment.getProperty(STORM_UI_SPRING_PROPERTY)).thenReturn(HTTP_STORM_UI);    StormStatusServiceImpl serviceImpl = (StormStatusServiceImpl) stormStatusService;    assertEquals(HTTP_STORM_UI, serviceImpl.getStormUiProperty());}
public void metron_f2105_0()
{    when(environment.getProperty(STORM_UI_SPRING_PROPERTY)).thenReturn(HTTPS_STORM_UI);    StormStatusServiceImpl serviceImpl = (StormStatusServiceImpl) stormStatusService;    assertEquals(HTTPS_STORM_UI, serviceImpl.getStormUiProperty());}
public void metron_f2106_0()
{    when(environment.getProperty(STORM_UI_SPRING_PROPERTY)).thenReturn(NO_PROTOCOL_STORM_UI);    StormStatusServiceImpl serviceImpl = (StormStatusServiceImpl) stormStatusService;    assertEquals(HTTP_STORM_UI, serviceImpl.getStormUiProperty());}
public void metron_f2107_0() throws Exception
{    final TopologyStatus topologyStatus = new TopologyStatus();    topologyStatus.setStatus(TopologyStatusCode.STARTED);    topologyStatus.setName("bro");    topologyStatus.setId("bro_id");    final TopologySummary topologySummary = new TopologySummary();    topologySummary.setTopologies(new TopologyStatus[] { topologyStatus });    when(environment.getProperty(STORM_UI_SPRING_PROPERTY)).thenReturn(HTTP_STORM_UI);    when(restTemplate.getForObject(HTTP_STORM_UI + TOPOLOGY_SUMMARY_URL, TopologySummary.class)).thenReturn(topologySummary);    TopologyStatus expectedStatus = new TopologyStatus();    expectedStatus.setStatus(TopologyStatusCode.STARTED);    expectedStatus.setName("bro");    expectedStatus.setId("bro_id");    TopologySummary expected = new TopologySummary();    expected.setTopologies(new TopologyStatus[] { expectedStatus });    TopologySummary actual = stormStatusService.getTopologySummary();    assertEquals(expected, actual);    assertEquals(expected.hashCode(), actual.hashCode());}
public void metron_f2108_0() throws Exception
{    final TopologyStatus topologyStatus = new TopologyStatus();    topologyStatus.setStatus(TopologyStatusCode.STARTED);    topologyStatus.setName("bro");    topologyStatus.setId("bro_id");    final TopologySummary topologySummary = new TopologySummary();    topologySummary.setTopologies(new TopologyStatus[] { topologyStatus });    when(environment.getProperty(STORM_UI_SPRING_PROPERTY)).thenReturn(HTTP_STORM_UI);    when(restTemplate.getForObject(HTTP_STORM_UI + TOPOLOGY_SUMMARY_URL, TopologySummary.class)).thenReturn(topologySummary);    when(restTemplate.getForObject(HTTP_STORM_UI + TOPOLOGY_URL + "/bro_id", TopologyStatus.class)).thenReturn(topologyStatus);    TopologyStatus expected = new TopologyStatus();    expected.setStatus(TopologyStatusCode.STARTED);    expected.setName("bro");    expected.setId("bro_id");    TopologyStatus actual = stormStatusService.getTopologyStatus("bro");    assertEquals(expected, actual);    assertEquals(expected.hashCode(), actual.hashCode());}
public void metron_f2109_0() throws Exception
{    final TopologyStatus topologyStatus = new TopologyStatus();    topologyStatus.setStatus(TopologyStatusCode.STARTED);    topologyStatus.setName("bro__snort");    topologyStatus.setId("bro_snort_id");    final TopologySummary topologySummary = new TopologySummary();    topologySummary.setTopologies(new TopologyStatus[] { topologyStatus });    SensorParserGroup group = new SensorParserGroup();    group.setName("group");    group.setSensors(new HashSet<String>() {        {            add("bro");            add("snort");        }    });    when(sensorParserGroupService.findOne("group")).thenReturn(group);    when(environment.getProperty(STORM_UI_SPRING_PROPERTY)).thenReturn(HTTP_STORM_UI);    when(restTemplate.getForObject(HTTP_STORM_UI + TOPOLOGY_SUMMARY_URL, TopologySummary.class)).thenReturn(topologySummary);    when(restTemplate.getForObject(HTTP_STORM_UI + TOPOLOGY_URL + "/bro_snort_id", TopologyStatus.class)).thenReturn(topologyStatus);    TopologyStatus expected = new TopologyStatus();    expected.setStatus(TopologyStatusCode.STARTED);    expected.setName("bro__snort");    expected.setId("bro_snort_id");    TopologyStatus actual = stormStatusService.getTopologyStatus("group");    assertEquals(expected, actual);    assertEquals(expected.hashCode(), actual.hashCode());}
public void metron_f2110_0() throws Exception
{    final TopologyStatus topologyStatus = new TopologyStatus();    topologyStatus.setStatus(TopologyStatusCode.STARTED);    topologyStatus.setName("bro");    topologyStatus.setId("bro_id");    final TopologySummary topologySummary = new TopologySummary();    topologySummary.setTopologies(new TopologyStatus[] { topologyStatus });    when(environment.getProperty(STORM_UI_SPRING_PROPERTY)).thenReturn(HTTP_STORM_UI);    when(restTemplate.getForObject(HTTP_STORM_UI + TOPOLOGY_SUMMARY_URL, TopologySummary.class)).thenReturn(topologySummary);    when(restTemplate.getForObject(HTTP_STORM_UI + TOPOLOGY_URL + "/bro_id", TopologyStatus.class)).thenReturn(topologyStatus);    TopologyStatus expected = new TopologyStatus();    expected.setStatus(TopologyStatusCode.STARTED);    expected.setName("bro");    expected.setId("bro_id");    assertEquals(new ArrayList() {        {            add(expected);        }    }, stormStatusService.getAllTopologyStatus());}
public void metron_f2111_0() throws Exception
{    final TopologyStatus topologyStatus = new TopologyStatus();    topologyStatus.setName("bro");    topologyStatus.setId("bro_id");    final TopologySummary topologySummary = new TopologySummary();    topologySummary.setTopologies(new TopologyStatus[] { topologyStatus });    when(environment.getProperty(STORM_UI_SPRING_PROPERTY)).thenReturn(HTTP_STORM_UI);    when(restTemplate.getForObject(HTTP_STORM_UI + TOPOLOGY_SUMMARY_URL, TopologySummary.class)).thenReturn(topologySummary);    when(restTemplate.postForObject(HTTP_STORM_UI + TOPOLOGY_URL + "/bro_id/activate", null, Map.class)).thenReturn(new HashMap() {        {            put("status", "success");        }    });    TopologyResponse expected = new TopologyResponse();    expected.setSuccessMessage(TopologyStatusCode.ACTIVE.toString());    assertEquals(expected, stormStatusService.activateTopology("bro"));}
public void metron_f2112_0() throws Exception
{    final TopologyStatus topologyStatus = new TopologyStatus();    topologyStatus.setName("bro");    topologyStatus.setId("bro_id");    final TopologySummary topologySummary = new TopologySummary();    topologySummary.setTopologies(new TopologyStatus[] { topologyStatus });    when(environment.getProperty(STORM_UI_SPRING_PROPERTY)).thenReturn(HTTP_STORM_UI);    when(restTemplate.getForObject(HTTP_STORM_UI + TOPOLOGY_SUMMARY_URL, TopologySummary.class)).thenReturn(topologySummary);    when(restTemplate.postForObject(HTTP_STORM_UI + TOPOLOGY_URL + "/bro_id/activate", null, Map.class)).thenReturn(new HashMap() {        {            put("status", "error message");        }    });    TopologyResponse expected = new TopologyResponse();    expected.setErrorMessage("error message");    assertEquals(expected, stormStatusService.activateTopology("bro"));}
public void metron_f2113_0() throws Exception
{    when(environment.getProperty(STORM_UI_SPRING_PROPERTY)).thenReturn(HTTP_STORM_UI);    when(restTemplate.getForObject(HTTP_STORM_UI + TOPOLOGY_SUMMARY_URL, TopologySummary.class)).thenReturn(new TopologySummary());    TopologyResponse expected = new TopologyResponse();    expected.setErrorMessage(TopologyStatusCode.TOPOLOGY_NOT_FOUND.toString());    assertEquals(expected, stormStatusService.activateTopology("bro"));}
public void metron_f2114_0() throws Exception
{    final TopologyStatus topologyStatus = new TopologyStatus();    topologyStatus.setName("bro");    topologyStatus.setId("bro_id");    final TopologySummary topologySummary = new TopologySummary();    topologySummary.setTopologies(new TopologyStatus[] { topologyStatus });    when(environment.getProperty(STORM_UI_SPRING_PROPERTY)).thenReturn(HTTP_STORM_UI);    when(restTemplate.getForObject(HTTP_STORM_UI + TOPOLOGY_SUMMARY_URL, TopologySummary.class)).thenReturn(topologySummary);    when(restTemplate.postForObject(HTTP_STORM_UI + TOPOLOGY_URL + "/bro_id/deactivate", null, Map.class)).thenReturn(new HashMap() {        {            put("status", "success");        }    });    TopologyResponse expected = new TopologyResponse();    expected.setSuccessMessage(TopologyStatusCode.INACTIVE.toString());    assertEquals(expected, stormStatusService.deactivateTopology("bro"));}
public void metron_f2115_0() throws Exception
{    final TopologyStatus topologyStatus = new TopologyStatus();    topologyStatus.setName("bro");    topologyStatus.setId("bro_id");    final TopologySummary topologySummary = new TopologySummary();    topologySummary.setTopologies(new TopologyStatus[] { topologyStatus });    when(environment.getProperty(STORM_UI_SPRING_PROPERTY)).thenReturn(HTTP_STORM_UI);    when(restTemplate.getForObject(HTTP_STORM_UI + TOPOLOGY_SUMMARY_URL, TopologySummary.class)).thenReturn(topologySummary);    when(restTemplate.postForObject(HTTP_STORM_UI + TOPOLOGY_URL + "/bro_id/deactivate", null, Map.class)).thenReturn(new HashMap() {        {            put("status", "error message");        }    });    TopologyResponse expected = new TopologyResponse();    expected.setErrorMessage("error message");    assertEquals(expected, stormStatusService.deactivateTopology("bro"));}
public void metron_f2116_0() throws Exception
{    when(environment.getProperty(STORM_UI_SPRING_PROPERTY)).thenReturn(HTTP_STORM_UI);    when(restTemplate.getForObject(HTTP_STORM_UI + TOPOLOGY_SUMMARY_URL, TopologySummary.class)).thenReturn(new TopologySummary());    TopologyResponse expected = new TopologyResponse();    expected.setErrorMessage(TopologyStatusCode.TOPOLOGY_NOT_FOUND.toString());    assertEquals(expected, stormStatusService.deactivateTopology("bro"));}
public void metron_f2117_0() throws Exception
{    userSettingsTable = mock(Table.class);    globalConfigSupplier = () -> new HashMap<String, Object>() {        {            put(USER_SETTINGS_HBASE_CF, "cf");        }    };}
public void metron_f2118_0() throws Exception
{    Result result = mock(Result.class);    when(result.getValue(cf, Bytes.toBytes("type"))).thenReturn("userSettings1String".getBytes(StandardCharsets.UTF_8));    Get get = new Get("user1".getBytes(StandardCharsets.UTF_8));    get.addFamily(cf);    when(userSettingsTable.get(get)).thenReturn(result);    UserSettingsClient userSettingsClient = new UserSettingsClient(userSettingsTable, cf);    assertEquals("userSettings1String", userSettingsClient.findOne("user1", "type").get());    assertFalse(userSettingsClient.findOne("missingUser", "type").isPresent());}
public void metron_f2119_0() throws Exception
{    ResultScanner resultScanner = mock(ResultScanner.class);    Result result1 = mock(Result.class);    Result result2 = mock(Result.class);    when(result1.getRow()).thenReturn("user1".getBytes(StandardCharsets.UTF_8));    when(result2.getRow()).thenReturn("user2".getBytes(StandardCharsets.UTF_8));    when(result1.getValue(cf, Bytes.toBytes("type"))).thenReturn("userSettings1String".getBytes(StandardCharsets.UTF_8));    when(result2.getValue(cf, Bytes.toBytes("type"))).thenReturn("userSettings2String".getBytes(StandardCharsets.UTF_8));    when(resultScanner.iterator()).thenReturn(Arrays.asList(result1, result2).iterator());    when(userSettingsTable.getScanner(any(Scan.class))).thenReturn(resultScanner);    UserSettingsClient userSettingsClient = new UserSettingsClient(userSettingsTable, cf);    assertEquals(new HashMap<String, Optional<String>>() {        {            put("user1", Optional.of("userSettings1String"));            put("user2", Optional.of("userSettings2String"));        }    }, userSettingsClient.findAll("type"));}
public String metron_f2120_0()
{    return message;}
public void metron_f2121_0(String message)
{    this.message = message;}
public int metron_f2122_0()
{    return code;}
public void metron_f2123_0(int code)
{    this.code = code;}
public String metron_f2124_0()
{    return path;}
public void metron_f2125_0(String path)
{    this.path = path;}
public String metron_f2126_0()
{    return description;}
public void metron_f2127_0(String description)
{    this.description = description;}
public RequestMethod metron_f2128_0()
{    return method;}
public void metron_f2129_0(RequestMethod method)
{    this.method = method;}
public List<Response> metron_f2130_0()
{    return responses;}
public void metron_f2131_0(String message, int code)
{    Response response = new Response();    response.setMessage(message);    response.setCode(code);    this.responses.add(response);}
public Map<String, String> metron_f2132_0()
{    return parameterDescriptions;}
public void metron_f2133_0(String name, String description)
{    parameterDescriptions.put(name, description);}
public String metron_f2134_1(Object savedSearches)
{    try {        return JSONUtils.INSTANCE.toJSON(savedSearches, false);    } catch (JsonProcessingException e) {            }    return null;}
public Object metron_f2135_1(String savedSearches)
{    try {        return JSONUtils.INSTANCE.load(savedSearches, Object.class);    } catch (IOException e) {            }    return null;}
public String metron_f2136_0()
{    return user;}
public void metron_f2137_0(String user)
{    this.user = user;}
public List<String> metron_f2138_0()
{    return tableColumns;}
public void metron_f2139_0(List<String> tableColumns)
{    this.tableColumns = tableColumns;}
public List<SavedSearch> metron_f2140_0()
{    return savedSearches;}
public void metron_f2141_0(List<SavedSearch> savedSearches)
{    this.savedSearches = savedSearches;}
public List<String> metron_f2142_0()
{    return facetFields;}
public void metron_f2143_0(List<String> facetFields)
{    this.facetFields = facetFields;}
public boolean metron_f2144_0(Object o)
{    if (this == o) {        return true;    }    if (o == null || getClass() != o.getClass()) {        return false;    }    AlertsUIUserSettings that = (AlertsUIUserSettings) o;    return (user != null ? user.equals(that.user) : that.user == null) && (tableColumns != null ? tableColumns.equals(that.tableColumns) : that.tableColumns == null) && (savedSearches != null ? savedSearches.equals(that.savedSearches) : that.savedSearches == null) && (facetFields != null ? facetFields.equals(that.facetFields) : that.facetFields == null);}
public int metron_f2145_0()
{    int result = user != null ? user.hashCode() : 0;    result = 31 * result + (tableColumns != null ? tableColumns.hashCode() : 0);    result = 31 * result + (savedSearches != null ? savedSearches.hashCode() : 0);    result = 31 * result + (facetFields != null ? facetFields.hashCode() : 0);    return result;}
public String metron_f2146_0()
{    return patternLabel;}
public void metron_f2147_0(String patternLabel)
{    this.patternLabel = patternLabel;}
public String metron_f2148_0()
{    return statement;}
public void metron_f2149_0(String statement)
{    this.statement = statement;}
public String metron_f2150_0()
{    return sampleData;}
public void metron_f2151_0(String sampleData)
{    this.sampleData = sampleData;}
public Map<String, Object> metron_f2152_0()
{    if (results == null) {        return new HashMap<>();    }    return results;}
public void metron_f2153_0(Map<String, Object> results)
{    this.results = results;}
public boolean metron_f2154_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    GrokValidation that = (GrokValidation) o;    if (patternLabel != null ? !patternLabel.equals(that.patternLabel) : that.patternLabel != null)        return false;    if (statement != null ? !statement.equals(that.statement) : that.statement != null)        return false;    if (sampleData != null ? !sampleData.equals(that.sampleData) : that.sampleData != null)        return false;    return results != null ? results.equals(that.results) : that.results == null;}
public int metron_f2155_0()
{    int result = patternLabel != null ? patternLabel.hashCode() : 0;    result = 31 * result + (statement != null ? statement.hashCode() : 0);    result = 31 * result + (sampleData != null ? sampleData.hashCode() : 0);    result = 31 * result + (results != null ? results.hashCode() : 0);    return result;}
public String metron_f2156_0()
{    return name;}
public void metron_f2157_0(String name)
{    this.name = name;}
public int metron_f2158_0()
{    return numPartitions;}
public void metron_f2159_0(int numPartitions)
{    this.numPartitions = numPartitions;}
public int metron_f2160_0()
{    return replicationFactor;}
public void metron_f2161_0(int replicationFactor)
{    this.replicationFactor = replicationFactor;}
public Properties metron_f2162_0()
{    return properties;}
public void metron_f2163_0(Properties properties)
{    this.properties = properties;}
public boolean metron_f2164_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    KafkaTopic that = (KafkaTopic) o;    if (numPartitions != that.numPartitions)        return false;    if (replicationFactor != that.replicationFactor)        return false;    if (name != null ? !name.equals(that.name) : that.name != null)        return false;    return properties != null ? properties.equals(that.properties) : that.properties == null;}
public int metron_f2165_0()
{    int result = name != null ? name.hashCode() : 0;    result = 31 * result + numPartitions;    result = 31 * result + replicationFactor;    result = 31 * result + (properties != null ? properties.hashCode() : 0);    return result;}
public SensorParserConfig metron_f2166_0()
{    return sensorParserConfig;}
public void metron_f2167_0(SensorParserConfig sensorParserConfig)
{    this.sensorParserConfig = sensorParserConfig;}
public String metron_f2168_0()
{    return grokStatement;}
public void metron_f2169_0(String grokStatement)
{    this.grokStatement = grokStatement;}
public String metron_f2170_0()
{    return sampleData;}
public void metron_f2171_0(String sampleData)
{    this.sampleData = sampleData;}
public String metron_f2172_0()
{    return name;}
public void metron_f2173_0(String name)
{    this.name = name;}
public String metron_f2174_0()
{    return pos;}
public void metron_f2175_0(String pos)
{    this.pos = pos;}
public String metron_f2176_0()
{    return showname;}
public void metron_f2177_0(String showname)
{    this.showname = showname;}
public String metron_f2178_0()
{    return size;}
public void metron_f2179_0(String size)
{    this.size = size;}
public String metron_f2180_0()
{    return value;}
public void metron_f2181_0(String value)
{    this.value = value;}
public String metron_f2182_0()
{    return show;}
public void metron_f2183_0(String show)
{    this.show = show;}
public String metron_f2184_0()
{    return unmaskedvalue;}
public void metron_f2185_0(String unmaskedvalue)
{    this.unmaskedvalue = unmaskedvalue;}
public String metron_f2186_0()
{    return hide;}
public void metron_f2187_0(String hide)
{    this.hide = hide;}
public List<Field> metron_f2188_0()
{    return fields;}
public void metron_f2189_0(List<Field> fields)
{    this.fields = fields;}
public List<Proto> metron_f2190_0()
{    return protos;}
public void metron_f2191_0(List<Proto> protos)
{    this.protos = protos;}
public boolean metron_f2192_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    Field field = (Field) o;    return Objects.equals(name, field.name) && Objects.equals(pos, field.pos) && Objects.equals(showname, field.showname) && Objects.equals(size, field.size) && Objects.equals(value, field.value) && Objects.equals(show, field.show) && Objects.equals(unmaskedvalue, field.unmaskedvalue) && Objects.equals(hide, field.hide) && Objects.equals(fields, field.fields) && Objects.equals(protos, field.protos);}
public int metron_f2193_0()
{    return Objects.hash(name, pos, showname, size, value, show, unmaskedvalue, hide, fields, protos);}
public String metron_f2194_0()
{    return key;}
public String metron_f2195_0()
{    return FixedPcapOptions.IP_SRC_ADDR.get(this, String.class);}
public void metron_f2196_0(String ipSrcAddr)
{    FixedPcapOptions.IP_SRC_ADDR.put(this, ipSrcAddr);}
public String metron_f2197_0()
{    return FixedPcapOptions.IP_DST_ADDR.get(this, String.class);}
public void metron_f2198_0(String ipDstAddr)
{    FixedPcapOptions.IP_DST_ADDR.put(this, ipDstAddr);}
public Integer metron_f2199_0()
{    return FixedPcapOptions.IP_SRC_PORT.get(this, Integer.class);}
public void metron_f2200_0(Integer ipSrcPort)
{    FixedPcapOptions.IP_SRC_PORT.put(this, ipSrcPort);}
public Integer metron_f2201_0()
{    return FixedPcapOptions.IP_DST_PORT.get(this, Integer.class);}
public void metron_f2202_0(Integer ipDstPort)
{    FixedPcapOptions.IP_DST_PORT.put(this, ipDstPort);}
public String metron_f2203_0()
{    return FixedPcapOptions.PROTOCOL.get(this, String.class);}
public void metron_f2204_0(String protocol)
{    FixedPcapOptions.PROTOCOL.put(this, protocol);}
public String metron_f2205_0()
{    return FixedPcapOptions.PACKET_FILTER.get(this, String.class);}
public void metron_f2206_0(String packetFilter)
{    FixedPcapOptions.PACKET_FILTER.put(this, packetFilter);}
public Boolean metron_f2207_0()
{    return FixedPcapOptions.INCLUDE_REVERSE.get(this, Boolean.class);}
public void metron_f2208_0(Boolean includeReverse)
{    FixedPcapOptions.INCLUDE_REVERSE.put(this, includeReverse);}
public void metron_f2209_0()
{    Map<String, String> fields = new HashMap<>();    if (getIpSrcAddr() != null) {        fields.put(Constants.Fields.SRC_ADDR.getName(), getIpSrcAddr());    }    if (getIpDstAddr() != null) {        fields.put(Constants.Fields.DST_ADDR.getName(), getIpDstAddr());    }    if (getIpSrcPort() != null) {        fields.put(Constants.Fields.SRC_PORT.getName(), getIpSrcPort().toString());    }    if (getIpDstPort() != null) {        fields.put(Constants.Fields.DST_PORT.getName(), getIpDstPort().toString());    }    if (getProtocol() != null) {        fields.put(Constants.Fields.PROTOCOL.getName(), getProtocol());    }    if (getIncludeReverse() != null) {        fields.put(Constants.Fields.INCLUDES_REVERSE_TRAFFIC.getName(), getIncludeReverse().toString());    }    if (getPacketFilter() != null) {        fields.put(PcapHelper.PacketFields.PACKET_FILTER.getName(), getPacketFilter());    }    PcapOptions.FIELDS.put(this, fields);}
public List<Proto> metron_f2210_0()
{    return protos;}
public void metron_f2211_0(List<Proto> protos)
{    this.protos = protos;}
public boolean metron_f2212_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    Packet packet = (Packet) o;    return Objects.equals(protos, packet.protos);}
public int metron_f2213_0()
{    return Objects.hash(protos);}
public String metron_f2214_0()
{    return PcapOptions.BASE_PATH.get(this, String.class);}
public void metron_f2215_0(String basePath)
{    PcapOptions.BASE_PATH.put(this, basePath);}
public String metron_f2216_0()
{    return PcapOptions.BASE_INTERIM_RESULT_PATH.get(this, String.class);}
public void metron_f2217_0(String baseInterimResultPath)
{    PcapOptions.BASE_INTERIM_RESULT_PATH.put(this, baseInterimResultPath);}
public String metron_f2218_0()
{    return PcapOptions.FINAL_OUTPUT_PATH.get(this, String.class);}
public void metron_f2219_0(String finalOutputPath)
{    PcapOptions.FINAL_OUTPUT_PATH.put(this, finalOutputPath);}
public Long metron_f2220_0()
{    return PcapOptions.START_TIME_MS.get(this, Long.class);}
public void metron_f2221_0(Long startTime)
{    PcapOptions.START_TIME_MS.put(this, startTime);}
public Long metron_f2222_0()
{    return PcapOptions.END_TIME_MS.get(this, Long.class);}
public void metron_f2223_0(Long endTime)
{    PcapOptions.END_TIME_MS.put(this, endTime);}
public Integer metron_f2224_0()
{    return PcapOptions.NUM_REDUCERS.get(this, Integer.class);}
public void metron_f2225_0(Integer numReducers)
{    PcapOptions.NUM_REDUCERS.put(this, numReducers);}
public String metron_f2226_0()
{    return jobId;}
public void metron_f2227_0(String jobId)
{    this.jobId = jobId;}
public String metron_f2228_0()
{    return jobStatus;}
public void metron_f2229_0(String jobStatus)
{    this.jobStatus = jobStatus;}
public String metron_f2230_0()
{    return description;}
public void metron_f2231_0(String description)
{    this.description = description;}
public Double metron_f2232_0()
{    return percentComplete;}
public void metron_f2233_0(Double percentComplete)
{    this.percentComplete = percentComplete;}
public Integer metron_f2234_0()
{    return pageTotal;}
public void metron_f2235_0(Integer size)
{    this.pageTotal = size;}
public boolean metron_f2236_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    PcapStatus that = (PcapStatus) o;    return Objects.equals(jobId, that.jobId) && Objects.equals(jobStatus, that.jobStatus) && Objects.equals(description, that.description) && Objects.equals(percentComplete, that.percentComplete) && Objects.equals(pageTotal, that.pageTotal);}
public int metron_f2237_0()
{    return Objects.hash(jobId, jobStatus, description, percentComplete, pageTotal);}
public String metron_f2238_0()
{    return version;}
public void metron_f2239_0(String version)
{    this.version = version;}
public String metron_f2240_0()
{    return creator;}
public void metron_f2241_0(String creator)
{    this.creator = creator;}
public String metron_f2242_0()
{    return time;}
public void metron_f2243_0(String time)
{    this.time = time;}
public String metron_f2244_0()
{    return captureFile;}
public void metron_f2245_0(String captureFile)
{    this.captureFile = captureFile;}
public List<Packet> metron_f2246_0()
{    return packets;}
public void metron_f2247_0(List<Packet> packets)
{    this.packets = packets;}
public boolean metron_f2248_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    Pdml pdml = (Pdml) o;    return Objects.equals(version, pdml.version) && Objects.equals(creator, pdml.creator) && Objects.equals(time, pdml.time) && Objects.equals(captureFile, pdml.captureFile) && Objects.equals(packets, pdml.packets);}
public int metron_f2249_0()
{    return Objects.hash(version, creator, time, captureFile, packets);}
public String metron_f2250_0()
{    return name;}
public void metron_f2251_0(String name)
{    this.name = name;}
public String metron_f2252_0()
{    return pos;}
public void metron_f2253_0(String pos)
{    this.pos = pos;}
public String metron_f2254_0()
{    return showname;}
public void metron_f2255_0(String showname)
{    this.showname = showname;}
public String metron_f2256_0()
{    return size;}
public void metron_f2257_0(String size)
{    this.size = size;}
public String metron_f2258_0()
{    return hide;}
public void metron_f2259_0(String hide)
{    this.hide = hide;}
public List<Field> metron_f2260_0()
{    return fields;}
public void metron_f2261_0(List<Field> fields)
{    this.fields = fields;}
public boolean metron_f2262_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    Proto proto = (Proto) o;    return Objects.equals(name, proto.name) && Objects.equals(pos, proto.pos) && Objects.equals(showname, proto.showname) && Objects.equals(size, proto.size) && Objects.equals(hide, proto.hide) && Objects.equals(fields, proto.fields);}
public int metron_f2263_0()
{    return Objects.hash(name, pos, showname, size, hide, fields);}
public String metron_f2264_0()
{    return key;}
public String metron_f2265_0()
{    return QueryPcapOptions.QUERY.get(this, String.class);}
public void metron_f2266_0(String query)
{    QueryPcapOptions.QUERY.put(this, query);}
public void metron_f2267_0()
{    PcapOptions.FIELDS.put(this, getQuery());}
public List<byte[]> metron_f2268_0()
{    if (pcaps == null) {        return new ArrayList<>();    } else {        return pcaps;    }}
public void metron_f2269_0(List<byte[]> pcaps)
{    this.pcaps = pcaps;}
public int metron_f2270_0()
{    return responseCode;}
public String metron_f2271_0()
{    return message;}
public String metron_f2272_0()
{    return fullMessage;}
public String metron_f2273_0()
{    return name;}
public void metron_f2274_0(String name)
{    this.name = name;}
public SearchRequest metron_f2275_0()
{    return searchRequest;}
public void metron_f2276_0(SearchRequest searchRequest)
{    this.searchRequest = searchRequest;}
public boolean metron_f2277_0(Object o)
{    if (this == o) {        return true;    }    if (o == null || getClass() != o.getClass()) {        return false;    }    SavedSearch that = (SavedSearch) o;    return name != null ? name.equals(that.name) : that.name == null && (searchRequest != null ? searchRequest.equals(that.searchRequest) : that.searchRequest == null);}
public int metron_f2278_0()
{    int result = name != null ? name.hashCode() : 0;    result = 31 * result + (searchRequest != null ? searchRequest.hashCode() : 0);    return result;}
public Map<String, Object> metron_f2279_0()
{    if (sampleData == null) {        return new HashMap<>();    }    return sampleData;}
public void metron_f2280_0(Map<String, Object> sampleData)
{    this.sampleData = sampleData;}
public SensorParserConfig metron_f2281_0()
{    if (sensorParserConfig == null) {        return new SensorParserConfig();    }    return sensorParserConfig;}
public void metron_f2282_0(SensorParserConfig sensorParserConfig)
{    this.sensorParserConfig = sensorParserConfig;}
public String metron_f2283_0()
{    return name;}
public String metron_f2284_0()
{    return description;}
public String[] metron_f2285_0()
{    if (params == null) {        return new String[0];    }    return params;}
public String metron_f2286_0()
{    return returns;}
public String metron_f2287_0()
{    return id;}
public void metron_f2288_0(String id)
{    this.id = id;}
public String metron_f2289_0()
{    return host;}
public void metron_f2290_0(String host)
{    this.host = host;}
public String metron_f2291_0()
{    return uptime;}
public void metron_f2292_0(String upTime)
{    this.uptime = upTime;}
public int metron_f2293_0()
{    return slotsTotal;}
public void metron_f2294_0(int slotsTotal)
{    this.slotsTotal = slotsTotal;}
public int metron_f2295_0()
{    return slotsUsed;}
public void metron_f2296_0(int slotsUsed)
{    this.slotsUsed = slotsUsed;}
public boolean metron_f2297_0(Object o)
{    if (this == o) {        return true;    }    if (o == null || getClass() != o.getClass()) {        return false;    }    SupervisorStatus that = (SupervisorStatus) o;    if (getSlotsTotal() != that.getSlotsTotal()) {        return false;    }    if (getSlotsUsed() != that.getSlotsUsed()) {        return false;    }    if (!getId().equals(that.getId())) {        return false;    }    if (!getHost().equals(that.getHost())) {        return false;    }    return getUptime().equals(that.getUptime());}
public int metron_f2298_0()
{    int result = id != null ? id.hashCode() : 0;    result = 31 * result + (host != null ? host.hashCode() : 0);    result = 31 * result + (uptime != null ? uptime.hashCode() : 0);    result = 31 * result + getSlotsTotal();    result = 31 * result + getSlotsUsed();    return result;}
public SupervisorStatus[] metron_f2299_0()
{    return supervisors;}
public void metron_f2300_0(SupervisorStatus[] supervisors)
{    this.supervisors = supervisors;}
public boolean metron_f2301_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    SupervisorSummary that = (SupervisorSummary) o;    return supervisors != null ? Arrays.equals(supervisors, that.supervisors) : that.supervisors != null;}
public int metron_f2302_0()
{    return supervisors != null ? Arrays.hashCode(supervisors) : 0;}
public TopologyResponseCode metron_f2303_0()
{    return status;}
public String metron_f2304_0()
{    return message;}
public void metron_f2305_0(String message)
{    this.status = TopologyResponseCode.SUCCESS;    this.message = message;}
public void metron_f2306_0(String message)
{    this.status = TopologyResponseCode.ERROR;    this.message = message;}
public boolean metron_f2307_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    TopologyResponse that = (TopologyResponse) o;    if (status != null ? !status.equals(that.status) : that.status != null)        return false;    return message != null ? message.equals(that.message) : that.message == null;}
public int metron_f2308_0()
{    int result = status != null ? status.hashCode() : 0;    result = 31 * result + (message != null ? message.hashCode() : 0);    return result;}
public String metron_f2309_0()
{    return id;}
public void metron_f2310_0(String id)
{    this.id = id;}
public String metron_f2311_0()
{    return name;}
public void metron_f2312_0(String name)
{    this.name = name;}
public TopologyStatusCode metron_f2313_0()
{    return status;}
public void metron_f2314_0(TopologyStatusCode status)
{    this.status = status;}
public double metron_f2315_0()
{    return latency;}
public double metron_f2316_0()
{    return throughput;}
public Integer metron_f2317_0()
{    return emitted;}
public long metron_f2318_0()
{    return acked;}
public void metron_f2319_0(List<Map<String, Object>> topologyStats)
{    for (Map<String, Object> topologyStatsItem : topologyStats) {        if ("600".equals(topologyStatsItem.get("window"))) {            latency = Double.parseDouble((String) topologyStatsItem.get("completeLatency"));            if (topologyStatsItem.get("acked") != null) {                acked = (int) topologyStatsItem.get("acked");            }            if (topologyStatsItem.get("emitted") != null) {                emitted = (int) topologyStatsItem.get("emitted");            }            throughput = acked / 600.00;        }    }}
public boolean metron_f2320_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    TopologyStatus that = (TopologyStatus) o;    if (id != null ? !id.equals(that.id) : that.id != null)        return false;    if (name != null ? !name.equals(that.name) : that.name != null)        return false;    if (status != null ? !status.equals(that.status) : that.status != null)        return false;    if (!latency.equals(that.latency))        return false;    return throughput.equals(that.throughput);}
public int metron_f2321_0()
{    int result = id != null ? id.hashCode() : 0;    result = 31 * result + (name != null ? name.hashCode() : 0);    result = 31 * result + (status != null ? status.hashCode() : 0);    result = 31 * result + (latency != null ? latency.hashCode() : 0);    result = 31 * result + (throughput != null ? throughput.hashCode() : 0);    return result;}
public TopologyStatus[] metron_f2322_0()
{    if (topologies == null) {        return new TopologyStatus[0];    }    return topologies;}
public void metron_f2323_0(TopologyStatus[] topologies)
{    this.topologies = topologies;}
public boolean metron_f2324_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    TopologySummary that = (TopologySummary) o;    return topologies != null ? Arrays.equals(topologies, that.topologies) : that.topologies != null;}
public int metron_f2325_0()
{    return topologies != null ? Arrays.hashCode(topologies) : 0;}
public static int metron_f2326_0()
{    return NettyRuntime.availableProcessors();}
public Aggregator metron_f2327_0()
{    return aggregator;}
private static double metron_f2328_0(List<Number> list, Map<String, Object> config)
{    Double ret = 0d;    int num = 0;    boolean negValuesTrump = doNegativeValuesTrump(config);    for (Number n : list) {        if (n.doubleValue() < 0) {            if (negValuesTrump) {                return Double.NEGATIVE_INFINITY;            }        } else if (n.doubleValue() > 0) {            ret += n.doubleValue();            num++;        }    }    return num > 0 ? ret / num : 0d;}
private static boolean metron_f2329_0(Map<String, Object> config)
{    boolean negativeValuesTrump = true;    Object negValuesObj = config.get(NEGATIVE_VALUES_TRUMP_CONF);    if (negValuesObj != null) {        Boolean b = ConversionUtils.convert(negValuesObj, Boolean.class);        if (b != null) {            negativeValuesTrump = b;        }    }    return negativeValuesTrump;}
private static double metron_f2330_0(double initial, BinaryOperator<Number> op, List<Number> list, Map<String, Object> config)
{    if (list.isEmpty()) {        return 0d;    }    boolean negativeValuesTrump = doNegativeValuesTrump(config);    BinaryOperator<Number> binOp = op;    if (negativeValuesTrump) {        binOp = (x, y) -> {            if (y.doubleValue() < 0 || x.doubleValue() < 0) {                return Double.NEGATIVE_INFINITY;            } else {                return op.apply(x, y);            }        };    }    return list.stream().reduce(initial, binOp).doubleValue();}
private static double metron_f2331_0(double numberToScale, List<Number> list, Predicate<Number> filterFunc)
{    double scale = list.stream().filter(filterFunc).count();    if (scale < 1e-5) {        scale = 1;    }    return numberToScale / scale;}
public Double metron_f2332_0(List<Number> scores, Map<String, Object> config)
{    return aggregator.aggregate(scores, config);}
public boolean metron_f2333_0(CommandLine cli)
{    return cli.hasOption(shortCode);}
public String metron_f2334_0(CommandLine cli)
{    return cli.getOptionValue(shortCode);}
public static CommandLine metron_f2335_0(CommandLineParser parser, String[] args)
{    try {        CommandLine cli = parser.parse(getOptions(), args);        if (ConfigurationOptions.HELP.has(cli)) {            printHelp();            System.exit(0);        }        return cli;    } catch (ParseException e) {        System.err.println("Unable to parse args: " + Joiner.on(' ').join(args));        e.printStackTrace(System.err);        printHelp();        System.exit(-1);        return null;    }}
public static void metron_f2336_0()
{    HelpFormatter formatter = new HelpFormatter();    formatter.printHelp("configuration_manager", getOptions());}
public static Options metron_f2337_0()
{    Options ret = new Options();    for (ConfigurationOptions o : ConfigurationOptions.values()) {        ret.addOption(o.option);    }    return ret;}
public void metron_f2338_0(CuratorFramework client) throws Exception
{    ConfigurationsUtils.dumpConfigs(System.out, client);}
public void metron_f2339_0(CuratorFramework client, ConfigurationType type, Optional<String> configName) throws Exception
{    ConfigurationsUtils.dumpConfigs(System.out, client, type, configName);}
public void metron_f2340_0(CuratorFramework client, String outFileStr, final boolean force) throws Exception
{    final File outputDir = new File(outFileStr);    if (!outputDir.exists()) {        if (!outputDir.mkdirs()) {            throw new IllegalStateException("Unable to make directories: " + outputDir.getAbsolutePath());        }    }    ConfigurationsUtils.visitConfigs(client, new ConfigurationsUtils.ConfigurationVisitor() {        @Override        public void visit(ConfigurationType configurationType, String name, String data) {            File out = getFile(outputDir, configurationType, name);            if (!out.exists() || force) {                if (!out.exists()) {                    out.getParentFile().mkdirs();                }                try {                    Files.write(data, out, Charset.defaultCharset());                } catch (IOException e) {                    throw new RuntimeException("Sorry, something bad happened writing the config to " + out.getAbsolutePath() + ": " + e.getMessage(), e);                }            } else if (out.exists() && !force) {                throw new IllegalStateException("Unable to overwrite existing file (" + out.getAbsolutePath() + ") without the force flag (-f or --force) being set.");            }        }    });}
public void metron_f2341_0(ConfigurationType configurationType, String name, String data)
{    File out = getFile(outputDir, configurationType, name);    if (!out.exists() || force) {        if (!out.exists()) {            out.getParentFile().mkdirs();        }        try {            Files.write(data, out, Charset.defaultCharset());        } catch (IOException e) {            throw new RuntimeException("Sorry, something bad happened writing the config to " + out.getAbsolutePath() + ": " + e.getMessage(), e);        }    } else if (out.exists() && !force) {        throw new IllegalStateException("Unable to overwrite existing file (" + out.getAbsolutePath() + ") without the force flag (-f or --force) being set.");    }}
public void metron_f2342_0(String inputDirStr, CuratorFramework client) throws Exception
{    final File inputDir = new File(inputDirStr);    if (!inputDir.exists() || !inputDir.isDirectory()) {        throw new IllegalStateException("Input directory: " + inputDir + " does not exist or is not a directory.");    }    ConfigurationsUtils.uploadConfigsToZookeeper(inputDirStr, client);}
public void metron_f2343_0(String inputDirStr, CuratorFramework client, ConfigurationType type, Optional<String> configName) throws Exception
{    final File inputDir = new File(inputDirStr);    if (!inputDir.exists() || !inputDir.isDirectory()) {        throw new IllegalStateException("Input directory: " + inputDir + " does not exist or is not a directory.");    }    ConfigurationsUtils.uploadConfigsToZookeeper(inputDirStr, client, type, configName);}
public void metron_f2344_0(CommandLine cli) throws Exception
{    try (CuratorFramework client = ConfigurationsUtils.getClient(ConfigurationOptions.ZK_QUORUM.get(cli))) {        client.start();        run(client, cli);    }}
public void metron_f2345_0(CuratorFramework client, CommandLine cli) throws Exception
{    final boolean force = ConfigurationOptions.FORCE.has(cli);    String mode = ConfigurationOptions.MODE.get(cli);    Optional<String> configType = Optional.ofNullable(ConfigurationOptions.CONFIG_TYPE.get(cli));    Optional<String> configName = Optional.ofNullable(ConfigurationOptions.CONFIG_NAME.get(cli));    switch(mode.toLowerCase()) {        case "push":            String inputDirStr = ConfigurationOptions.INPUT.get(cli);            if (StringUtils.isEmpty(inputDirStr)) {                throw new IllegalArgumentException("Input directory is required when performing a PUSH operation.");            }            if (configType.isPresent()) {                push(inputDirStr, client, ConfigurationType.valueOf(configType.get()), configName);            } else {                push(inputDirStr, client);            }            break;        case "dump":            if (configType.isPresent()) {                dump(client, ConfigurationType.valueOf(configType.get()), configName);            } else {                dump(client);            }            break;        case "pull":            pull(client, ConfigurationOptions.OUTPUT.get(cli), force);            break;        case "patch":            if (configType.isPresent()) {                Optional<String> patchPath = Optional.ofNullable(ConfigurationOptions.PATCH_FILE.get(cli));                Optional<String> patchMode = Optional.ofNullable(ConfigurationOptions.PATCH_MODE.get(cli));                Optional<String> patchKey = Optional.ofNullable(ConfigurationOptions.PATCH_KEY.get(cli));                Optional<String> patchValue = Optional.ofNullable(ConfigurationOptions.PATCH_VALUE.get(cli));                patch(client, ConfigurationType.valueOf(configType.get()), configName, patchMode, patchPath, patchKey, patchValue);            } else {                throw new IllegalArgumentException("Patch requires config type");            }            break;        default:            throw new IllegalStateException("Invalid mode: " + mode + " expected DUMP, PULL, PUSH, or PATCH");    }}
private void metron_f2346_1(CuratorFramework client, ConfigurationType configType, Optional<String> configName, Optional<String> patchMode, Optional<String> patchPath, Optional<String> patchKey, Optional<String> patchValue) throws Exception
{    try {        byte[] patchData;        if (patchKey.isPresent()) {            patchData = buildPatch(patchMode, patchKey, patchValue).getBytes(StandardCharsets.UTF_8);        } else {            patchData = java.nio.file.Files.readAllBytes(Paths.get(patchPath.get()));        }        ConfigurationsUtils.applyConfigPatchToZookeeper(configType, configName, patchData, client);    } catch (IOException e) {                throw e;    } catch (Exception e) {                throw e;    }}
private String metron_f2347_0(Optional<String> patchMode, Optional<String> patchKey, Optional<String> patchValue)
{    PatchMode mode = PatchMode.ADD;    if (patchMode.isPresent()) {        mode = PatchMode.valueOf(patchMode.get());    }    String patch = "";    switch(mode) {        case ADD:            if (!patchKey.isPresent() || !patchValue.isPresent()) {                throw new IllegalArgumentException("Key and value are required to apply patches without a file");            }            patch = String.format("[ { \"op\": \"%s\", \"path\": \"%s\", \"value\": %s } ]", patchMode.get().toString().toLowerCase(), patchKey.get(), patchValue.get());            break;        case REMOVE:            if (!patchKey.isPresent()) {                throw new IllegalArgumentException("Key is required to apply a remove patch without a file");            }            patch = String.format("[ { \"op\": \"%s\", \"path\": \"%s\" } ]", patchMode.get().toString().toLowerCase(), patchKey.get());            break;        default:            throw new UnsupportedOperationException("Patch mode not supported: " + mode.toString());    }    return patch;}
private static File metron_f2348_0(File baseDir, ConfigurationType configurationType, String name)
{    return new File(new File(baseDir, configurationType.getDirectory()), name + ".json");}
public static void metron_f2349_0(String... argv) throws Exception
{    CommandLineParser parser = new PosixParser();    CommandLine cli = ConfigurationOptions.parse(parser, argv);    ConfigurationManager manager = new ConfigurationManager();    manager.run(cli);}
 BiFunction<String, Object, Object> metron_f2350_0()
{    return (s, o) -> o;}
 boolean metron_f2351_0(Map<String, Object> map)
{    return map.containsKey(getKey());}
 void metron_f2352_0(Map<String, Object> map, Object value)
{    map.put(getKey(), value);}
 T metron_f2353_0(Map<String, Object> map, Class<T> clazz, T defaultValue)
{    T val;    return ((val = get(map, clazz)) == null ? defaultValue : val);}
 T metron_f2354_0(Map<String, Object> map, Class<T> clazz)
{    Object obj = map.get(getKey());    if (clazz.isInstance(obj)) {        return clazz.cast(obj);    } else {        return ConversionUtils.convert(obj, clazz);    }}
 T metron_f2355_0(Map<String, Object> map, BiFunction<String, Object, T> transform, Class<T> clazz, T defaultValue)
{    T val;    return ((val = get(map, transform, clazz)) == null ? defaultValue : val);}
 T metron_f2356_0(Map<String, Object> map, BiFunction<String, Object, T> transform, Class<T> clazz)
{    return clazz.cast(transform.apply(getKey(), map.get(getKey())));}
 T metron_f2357_0(Map<String, Object> map, Class<T> clazz, T defaultValue)
{    T val;    return ((val = getTransformed(map, clazz)) == null ? defaultValue : val);}
 T metron_f2358_0(Map<String, Object> map, Class<T> clazz)
{    return clazz.cast(transform().apply(getKey(), map.get(getKey())));}
public void metron_f2359_0() throws Exception
{    if (null != curatorFramework) {        ConfigurationsUtils.updateConfigsFromZookeeper(this, this.curatorFramework);    } else {        updateGlobalConfig(ConfigurationsUtils.readGlobalConfigFromFile(configFileRoot.toAbsolutePath().toString()));    }}
 String metron_f2360_0()
{    return getTypeName();}
 String metron_f2361_0()
{    return Constants.ZOOKEEPER_TOPOLOGY_ROOT + "/" + getTypeName();}
public Map<String, Object> metron_f2362_0()
{    return configurations;}
public Map<String, Object> metron_f2363_0()
{    return getGlobalConfig(true);}
public Map<String, Object> metron_f2364_0(boolean emptyMapOnNonExistent)
{    return (Map<String, Object>) getConfigurations().getOrDefault(ConfigurationType.GLOBAL.getTypeName(), emptyMapOnNonExistent ? new HashMap() : null);}
public List<FieldValidator> metron_f2365_0()
{    return validations;}
public void metron_f2366_0(byte[] data) throws IOException
{    if (data == null)        throw new IllegalStateException("global config data cannot be null");    updateGlobalConfig(new ByteArrayInputStream(data));}
public void metron_f2367_0(InputStream io) throws IOException
{    Map<String, Object> globalConfig = JSONUtils.INSTANCE.load(io, JSONUtils.MAP_SUPPLIER);    updateGlobalConfig(globalConfig);}
public void metron_f2368_0(Map<String, Object> globalConfig)
{    if (globalConfig != null) {        getConfigurations().put(ConfigurationType.GLOBAL.getTypeName(), globalConfig);        validations = FieldValidator.readValidations(getGlobalConfig());    }}
public void metron_f2369_0()
{    getConfigurations().remove(ConfigurationType.GLOBAL.getTypeName());}
public static T metron_f2370_0(String key, Map<String, Object> map, T defaultValue, Class<T> clazz)
{    return map == null ? defaultValue : ConversionUtils.convert(map.getOrDefault(key, defaultValue), clazz);}
public boolean metron_f2371_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    Configurations that = (Configurations) o;    if (validations != null ? !validations.equals(that.validations) : that.validations != null)        return false;    return getConfigurations() != null ? getConfigurations().equals(that.getConfigurations()) : that.getConfigurations() == null;}
public int metron_f2372_0()
{    int result = validations != null ? validations.hashCode() : 0;    result = 31 * result + (getConfigurations() != null ? getConfigurations().hashCode() : 0);    return result;}
public String metron_f2373_0()
{    return "Configurations{" + "validations=" + validations + ", configurations=" + getConfigurations() + '}';}
public static CuratorFramework metron_f2374_0(String zookeeperUrl)
{    RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);    return CuratorFrameworkFactory.newClient(zookeeperUrl, retryPolicy);}
public static void metron_f2375_0(Map<String, Object> globalConfig, String zookeeperUrl) throws Exception
{    try (CuratorFramework client = getClient(zookeeperUrl)) {        client.start();        writeGlobalConfigToZookeeper(globalConfig, client);    }}
public static void metron_f2376_0(Map<String, Object> globalConfig, CuratorFramework client) throws Exception
{    writeGlobalConfigToZookeeper(JSONUtils.INSTANCE.toJSONPretty(globalConfig), client);}
public static void metron_f2377_0(byte[] globalConfig, String zookeeperUrl) throws Exception
{    try (CuratorFramework client = getClient(zookeeperUrl)) {        client.start();        writeGlobalConfigToZookeeper(globalConfig, client);    }}
public static void metron_f2378_0(byte[] globalConfig, CuratorFramework client) throws Exception
{    GLOBAL.deserialize(new String(globalConfig, StandardCharsets.UTF_8));    writeToZookeeper(GLOBAL.getZookeeperRoot(), globalConfig, client);}
public static void metron_f2379_0(byte[] config, CuratorFramework client) throws Exception
{    PROFILER.deserialize(new String(config, StandardCharsets.UTF_8));    writeToZookeeper(PROFILER.getZookeeperRoot(), config, client);}
public static void metron_f2380_0(String sensorType, SensorParserConfig sensorParserConfig, String zookeeperUrl) throws Exception
{    writeSensorParserConfigToZookeeper(sensorType, JSONUtils.INSTANCE.toJSONPretty(sensorParserConfig), zookeeperUrl);}
public static void metron_f2381_0(String sensorType, byte[] configData, String zookeeperUrl) throws Exception
{    try (CuratorFramework client = getClient(zookeeperUrl)) {        client.start();        writeSensorParserConfigToZookeeper(sensorType, configData, client);    }}
public static void metron_f2382_0(String sensorType, byte[] configData, CuratorFramework client) throws Exception
{    SensorParserConfig c = (SensorParserConfig) PARSER.deserialize(new String(configData, StandardCharsets.UTF_8));    c.init();    writeToZookeeper(PARSER.getZookeeperRoot() + "/" + sensorType, configData, client);}
public static void metron_f2383_0(String sensorType, Map<String, Object> sensorIndexingConfig, String zookeeperUrl) throws Exception
{    writeSensorIndexingConfigToZookeeper(sensorType, JSONUtils.INSTANCE.toJSONPretty(sensorIndexingConfig), zookeeperUrl);}
public static void metron_f2384_0(String sensorType, byte[] configData, String zookeeperUrl) throws Exception
{    try (CuratorFramework client = getClient(zookeeperUrl)) {        client.start();        writeSensorIndexingConfigToZookeeper(sensorType, configData, client);    }}
public static void metron_f2385_0(String sensorType, byte[] configData, CuratorFramework client) throws Exception
{    INDEXING.deserialize(new String(configData, StandardCharsets.UTF_8));    writeToZookeeper(INDEXING.getZookeeperRoot() + "/" + sensorType, configData, client);}
public static void metron_f2386_0(String sensorType, SensorEnrichmentConfig sensorEnrichmentConfig, String zookeeperUrl) throws Exception
{    writeSensorEnrichmentConfigToZookeeper(sensorType, JSONUtils.INSTANCE.toJSONPretty(sensorEnrichmentConfig), zookeeperUrl);}
public static void metron_f2387_0(String sensorType, byte[] configData, String zookeeperUrl) throws Exception
{    try (CuratorFramework client = getClient(zookeeperUrl)) {        client.start();        writeSensorEnrichmentConfigToZookeeper(sensorType, configData, client);    }}
public static void metron_f2388_0(String sensorType, byte[] configData, CuratorFramework client) throws Exception
{    ENRICHMENT.deserialize(new String(configData, StandardCharsets.UTF_8));    writeToZookeeper(ENRICHMENT.getZookeeperRoot() + "/" + sensorType, configData, client);}
public static void metron_f2389_0(String name, Map<String, Object> config, String zookeeperUrl) throws Exception
{    writeConfigToZookeeper(Constants.ZOOKEEPER_TOPOLOGY_ROOT + "/" + name, JSONUtils.INSTANCE.toJSONPretty(config), zookeeperUrl);}
public static void metron_f2390_0(ConfigurationType configType, byte[] configData, String zookeeperUrl) throws Exception
{    writeConfigToZookeeper(configType, Optional.empty(), configData, zookeeperUrl);}
public static void metron_f2391_0(ConfigurationType configType, Optional<String> configName, byte[] configData, String zookeeperUrl) throws Exception
{    writeConfigToZookeeper(getConfigZKPath(configType, configName), configData, zookeeperUrl);}
public static void metron_f2392_0(ConfigurationType configType, Optional<String> configName, byte[] configData, CuratorFramework client) throws Exception
{    writeToZookeeper(getConfigZKPath(configType, configName), configData, client);}
private static String metron_f2393_0(ConfigurationType configType, Optional<String> configName)
{    String pathSuffix = configName.isPresent() && configType != GLOBAL ? "/" + configName.get() : "";    return configType.getZookeeperRoot() + pathSuffix;}
public static void metron_f2394_0(String configPath, byte[] config, String zookeeperUrl) throws Exception
{    try (CuratorFramework client = getClient(zookeeperUrl)) {        client.start();        writeToZookeeper(configPath, config, client);    }}
public static void metron_f2395_0(String path, byte[] configData, CuratorFramework client) throws Exception
{    try {        client.setData().forPath(path, configData);    } catch (KeeperException.NoNodeException e) {        client.create().creatingParentsIfNeeded().forPath(path, configData);    }}
public static void metron_f2396_0(Configurations configurations, CuratorFramework client) throws Exception
{    configurations.updateGlobalConfig(readGlobalConfigBytesFromZookeeper(client));}
private static void metron_f2397_1(Configurations configurations, ConfigurationType type, Callback callback, CuratorFramework client) throws Exception
{    Exception globalUpdateException = null;    try {        updateConfigsFromZookeeper(configurations, client);    } catch (Exception e) {                globalUpdateException = e;    }    List<String> sensorTypes = client.getChildren().forPath(type.getZookeeperRoot());    for (String sensorType : sensorTypes) {        callback.apply(sensorType);    }    if (globalUpdateException != null) {        throw globalUpdateException;    }}
public static void metron_f2398_0(ParserConfigurations configurations, CuratorFramework client) throws Exception
{    updateConfigsFromZookeeper(configurations, PARSER, sensorType -> configurations.updateSensorParserConfig(sensorType, readSensorParserConfigBytesFromZookeeper(sensorType, client)), client);}
public static void metron_f2399_0(IndexingConfigurations configurations, CuratorFramework client) throws Exception
{    updateConfigsFromZookeeper(configurations, INDEXING, sensorType -> configurations.updateSensorIndexingConfig(sensorType, readSensorIndexingConfigBytesFromZookeeper(sensorType, client)), client);}
public static void metron_f2400_0(EnrichmentConfigurations configurations, CuratorFramework client) throws Exception
{    updateConfigsFromZookeeper(configurations, ENRICHMENT, sensorType -> configurations.updateSensorEnrichmentConfig(sensorType, readSensorEnrichmentConfigBytesFromZookeeper(sensorType, client)), client);}
public static Map<String, Object> metron_f2401_0(CuratorFramework client) throws Exception
{    Map<String, Object> config = null;    Optional<byte[]> bytes = readFromZookeeperSafely(GLOBAL.getZookeeperRoot(), client);    if (bytes.isPresent()) {        InputStream in = new ByteArrayInputStream(bytes.get());        config = JSONUtils.INSTANCE.load(in, JSONUtils.MAP_SUPPLIER);    }    return config;}
public static Map<String, Object> metron_f2402_0(String sensorType, CuratorFramework client) throws Exception
{    Map<String, Object> config = null;    Optional<byte[]> bytes = readFromZookeeperSafely(INDEXING.getZookeeperRoot() + "/" + sensorType, client);    if (bytes.isPresent()) {        InputStream in = new ByteArrayInputStream(bytes.get());        config = JSONUtils.INSTANCE.load(in, JSONUtils.MAP_SUPPLIER);    }    return config;}
public static SensorEnrichmentConfig metron_f2403_0(String sensorType, CuratorFramework client) throws Exception
{    SensorEnrichmentConfig config = null;    Optional<byte[]> bytes = readFromZookeeperSafely(ENRICHMENT.getZookeeperRoot() + "/" + sensorType, client);    if (bytes.isPresent()) {        config = SensorEnrichmentConfig.fromBytes(bytes.get());    }    return config;}
public static SensorParserConfig metron_f2404_0(String sensorType, CuratorFramework client) throws Exception
{    SensorParserConfig config = null;    Optional<byte[]> bytes = readFromZookeeperSafely(PARSER.getZookeeperRoot() + "/" + sensorType, client);    if (bytes.isPresent()) {        config = SensorParserConfig.fromBytes(bytes.get());    }    return config;}
public static ProfilerConfig metron_f2405_0(CuratorFramework client) throws Exception
{    ProfilerConfig config = null;    Optional<byte[]> bytes = readFromZookeeperSafely(PROFILER.getZookeeperRoot(), client);    if (bytes.isPresent()) {        config = ProfilerConfig.fromBytes(bytes.get());    }    return config;}
public static byte[] metron_f2406_0(CuratorFramework client) throws Exception
{    return readFromZookeeper(GLOBAL.getZookeeperRoot(), client);}
public static byte[] metron_f2407_0(CuratorFramework client) throws Exception
{    return readFromZookeeper(PROFILER.getZookeeperRoot(), client);}
public static byte[] metron_f2408_0(String sensorType, CuratorFramework client) throws Exception
{    return readFromZookeeper(INDEXING.getZookeeperRoot() + "/" + sensorType, client);}
public static byte[] metron_f2409_0(String sensorType, CuratorFramework client) throws Exception
{    return readFromZookeeper(PARSER.getZookeeperRoot() + "/" + sensorType, client);}
public static byte[] metron_f2410_0(String sensorType, CuratorFramework client) throws Exception
{    return readFromZookeeper(ENRICHMENT.getZookeeperRoot() + "/" + sensorType, client);}
public static byte[] metron_f2411_0(String name, CuratorFramework client) throws Exception
{    return readFromZookeeper(Constants.ZOOKEEPER_TOPOLOGY_ROOT + "/" + name, client);}
public static byte[] metron_f2412_0(ConfigurationType configType, String zookeeperUrl) throws Exception
{    return readConfigBytesFromZookeeper(configType, Optional.empty(), zookeeperUrl);}
public static byte[] metron_f2413_0(ConfigurationType configType, Optional<String> configName, CuratorFramework client) throws Exception
{    return readFromZookeeper(getConfigZKPath(configType, configName), client);}
public static byte[] metron_f2414_0(ConfigurationType configType, Optional<String> configName, String zookeeperUrl) throws Exception
{    return readFromZookeeper(getConfigZKPath(configType, configName), zookeeperUrl);}
public static byte[] metron_f2415_0(String path, String zookeeperUrl) throws Exception
{    try (CuratorFramework client = getClient(zookeeperUrl)) {        client.start();        return readFromZookeeper(path, client);    }}
public static byte[] metron_f2417_0(String path, CuratorFramework client) throws Exception
{    if (client != null && client.getData() != null && path != null) {        return client.getData().forPath(path);    }    return new byte[] {};}
public static void metron_f2418_0(String globalConfigPath, String parsersConfigPath, String enrichmentsConfigPath, String indexingConfigPath, String profilerConfigPath, String zookeeperUrl) throws Exception
{    try (CuratorFramework client = getClient(zookeeperUrl)) {        client.start();        uploadConfigsToZookeeper(globalConfigPath, parsersConfigPath, enrichmentsConfigPath, indexingConfigPath, profilerConfigPath, client);    }}
public static void metron_f2419_0(String rootFilePath, CuratorFramework client) throws Exception
{    uploadConfigsToZookeeper(rootFilePath, rootFilePath, rootFilePath, rootFilePath, rootFilePath, client);}
public static void metron_f2420_0(String rootFilePath, CuratorFramework client, ConfigurationType type) throws Exception
{    uploadConfigsToZookeeper(rootFilePath, client, type, Optional.empty());}
public static void metron_f2421_0(String rootFilePath, CuratorFramework client, ConfigurationType type, Optional<String> configName) throws Exception
{    switch(type) {        case GLOBAL:            final byte[] globalConfig = readGlobalConfigFromFile(rootFilePath);            if (globalConfig.length > 0) {                setupStellarStatically(client, Optional.of(new String(globalConfig, StandardCharsets.UTF_8)));                writeGlobalConfigToZookeeper(globalConfig, client);            }            break;                case PARSER:                case ENRICHMENT:        case         INDEXING:            {                Map<String, byte[]> configs = readSensorConfigsFromFile(rootFilePath, type, configName);                for (String sensorType : configs.keySet()) {                    byte[] configData = configs.get(sensorType);                    type.writeSensorConfigToZookeeper(sensorType, configData, client);                }                break;            }        case PROFILER:            {                byte[] configData = readProfilerConfigFromFile(rootFilePath);                if (configData.length > 0) {                    ConfigurationsUtils.writeProfilerConfigToZookeeper(configData, client);                }                break;            }        default:            throw new IllegalArgumentException("Configuration type not found: " + type);    }}
public static void metron_f2422_0(String globalConfigPath, String parsersConfigPath, String enrichmentsConfigPath, String indexingConfigPath, String profilerConfigPath, CuratorFramework client) throws Exception
{        if (globalConfigPath != null) {        final byte[] globalConfig = readGlobalConfigFromFile(globalConfigPath);        if (globalConfig.length > 0) {            setupStellarStatically(client, Optional.of(new String(globalConfig, StandardCharsets.UTF_8)));            ConfigurationsUtils.writeGlobalConfigToZookeeper(readGlobalConfigFromFile(globalConfigPath), client);        }    }        if (parsersConfigPath != null) {        Map<String, byte[]> sensorParserConfigs = readSensorParserConfigsFromFile(parsersConfigPath);        for (String sensorType : sensorParserConfigs.keySet()) {            ConfigurationsUtils.writeSensorParserConfigToZookeeper(sensorType, sensorParserConfigs.get(sensorType), client);        }    }        if (indexingConfigPath != null) {        Map<String, byte[]> sensorIndexingConfigs = readSensorIndexingConfigsFromFile(indexingConfigPath);        for (String sensorType : sensorIndexingConfigs.keySet()) {            ConfigurationsUtils.writeSensorIndexingConfigToZookeeper(sensorType, sensorIndexingConfigs.get(sensorType), client);        }    }        if (enrichmentsConfigPath != null) {        Map<String, byte[]> sensorEnrichmentConfigs = readSensorEnrichmentConfigsFromFile(enrichmentsConfigPath);        for (String sensorType : sensorEnrichmentConfigs.keySet()) {            ConfigurationsUtils.writeSensorEnrichmentConfigToZookeeper(sensorType, sensorEnrichmentConfigs.get(sensorType), client);        }    }        if (profilerConfigPath != null) {        byte[] profilerConfig = readProfilerConfigFromFile(profilerConfigPath);        if (profilerConfig.length > 0) {            ConfigurationsUtils.writeProfilerConfigToZookeeper(profilerConfig, client);        }    }}
public static void metron_f2423_0(CuratorFramework client) throws Exception
{    byte[] ret = null;    try {        ret = readGlobalConfigBytesFromZookeeper(client);    } catch (KeeperException.NoNodeException nne) {        }    if (ret == null || ret.length == 0) {        setupStellarStatically(client, Optional.empty());    } else {        setupStellarStatically(client, Optional.of(new String(ret, StandardCharsets.UTF_8)));    }}
public static void metron_f2424_0(CuratorFramework client, Optional<String> globalConfig)
{    /*      In order to validate stellar functions, the function resolver must be initialized.  Otherwise,      those utilities that require validation cannot validate the stellar expressions necessarily.    */    Context.Builder builder = new Context.Builder().with(Context.Capabilities.ZOOKEEPER_CLIENT, () -> client);    if (globalConfig.isPresent()) {        builder = builder.with(Context.Capabilities.GLOBAL_CONFIG, () -> GLOBAL.deserialize(globalConfig.get())).with(Context.Capabilities.STELLAR_CONFIG, () -> GLOBAL.deserialize(globalConfig.get()));    } else {        builder = builder.with(Context.Capabilities.STELLAR_CONFIG, () -> new HashMap<>());    }    Context stellarContext = builder.build();    StellarFunctions.FUNCTION_RESOLVER().initialize(stellarContext);}
public static byte[] metron_f2425_0(String rootPath) throws IOException
{    byte[] globalConfig = new byte[0];    File configPath = new File(rootPath, GLOBAL.getTypeName() + ".json");    if (configPath.exists()) {        globalConfig = Files.readAllBytes(configPath.toPath());    }    return globalConfig;}
public static Map<String, byte[]> metron_f2426_0(String rootPath) throws IOException
{    return readSensorConfigsFromFile(rootPath, PARSER, Optional.empty());}
public static Map<String, byte[]> metron_f2427_0(String rootPath) throws IOException
{    return readSensorConfigsFromFile(rootPath, ENRICHMENT, Optional.empty());}
public static Map<String, byte[]> metron_f2428_0(String rootPath) throws IOException
{    return readSensorConfigsFromFile(rootPath, INDEXING, Optional.empty());}
public static byte[] metron_f2429_0(String rootPath) throws IOException
{    byte[] config = new byte[0];    File configPath = new File(rootPath, PROFILER.getTypeName() + ".json");    if (configPath.exists()) {        config = Files.readAllBytes(configPath.toPath());    }    return config;}
public static Map<String, byte[]> metron_f2430_0(String rootPath, ConfigurationType configType) throws IOException
{    return readSensorConfigsFromFile(rootPath, configType, Optional.empty());}
public static Map<String, byte[]> metron_f2431_0(String rootPath, ConfigurationType configType, Optional<String> configName) throws IOException
{    Map<String, byte[]> sensorConfigs = new HashMap<>();    File configPath = new File(rootPath, configType.getDirectory());    if (configPath.exists() && configPath.isDirectory()) {        File[] children = configPath.listFiles();        if (!configName.isPresent()) {            for (File file : children) {                sensorConfigs.put(FilenameUtils.removeExtension(file.getName()), Files.readAllBytes(file.toPath()));            }        } else {            for (File file : children) {                if (FilenameUtils.removeExtension(file.getName()).equals(configName.get())) {                    sensorConfigs.put(FilenameUtils.removeExtension(file.getName()), Files.readAllBytes(file.toPath()));                }            }            if (sensorConfigs.isEmpty()) {                throw new RuntimeException("Unable to find configuration for " + configName.get());            }        }    }    return sensorConfigs;}
public static void metron_f2432_0(ConfigurationType configurationType, byte[] patchData, String zookeeperUrl) throws Exception
{    applyConfigPatchToZookeeper(configurationType, Optional.empty(), patchData, zookeeperUrl);}
public static void metron_f2433_0(ConfigurationType configurationType, Optional<String> configName, byte[] patchData, String zookeeperUrl) throws Exception
{    try (CuratorFramework client = getClient(zookeeperUrl)) {        client.start();        applyConfigPatchToZookeeper(configurationType, configName, patchData, client);    }}
public static void metron_f2434_0(ConfigurationType configurationType, Optional<String> configName, byte[] patchData, CuratorFramework client) throws Exception
{    byte[] configData = readConfigBytesFromZookeeper(configurationType, configName, client);    byte[] prettyPatchedConfig = JSONUtils.INSTANCE.applyPatch(patchData, configData);        String prettyPatchedConfigStr = new String(prettyPatchedConfig, StandardCharsets.UTF_8);    configurationType.deserialize(prettyPatchedConfigStr);    writeConfigToZookeeper(configurationType, configName, prettyPatchedConfig, client);}
public static void metron_f2435_0(CuratorFramework client, final ConfigurationVisitor callback) throws Exception
{    visitConfigs(client, (type, name, data) -> {        setupStellarStatically(client, Optional.ofNullable(data));        callback.visit(type, name, data);    }, GLOBAL, Optional.empty());    visitConfigs(client, callback, PARSER, Optional.empty());    visitConfigs(client, callback, INDEXING, Optional.empty());    visitConfigs(client, callback, ENRICHMENT, Optional.empty());    visitConfigs(client, callback, PROFILER, Optional.empty());}
public static void metron_f2436_0(CuratorFramework client, ConfigurationVisitor callback, ConfigurationType configType, Optional<String> configName) throws Exception
{    if (client.checkExists().forPath(configType.getZookeeperRoot()) != null) {        if (configType.equals(GLOBAL)) {            byte[] globalConfigData = client.getData().forPath(configType.getZookeeperRoot());            callback.visit(configType, "global", new String(globalConfigData, StandardCharsets.UTF_8));        } else if (configType.equals(PROFILER)) {            byte[] profilerConfigData = client.getData().forPath(configType.getZookeeperRoot());            callback.visit(configType, "profiler", new String(profilerConfigData, StandardCharsets.UTF_8));        } else if (configType.equals(PARSER) || configType.equals(ENRICHMENT) || configType.equals(INDEXING)) {            if (configName.isPresent()) {                byte[] data = readConfigBytesFromZookeeper(configType, configName, client);                callback.visit(configType, configName.get(), new String(data, StandardCharsets.UTF_8));            } else {                List<String> children = client.getChildren().forPath(configType.getZookeeperRoot());                for (String child : children) {                    byte[] data = client.getData().forPath(configType.getZookeeperRoot() + "/" + child);                    callback.visit(configType, child, new String(data, StandardCharsets.UTF_8));                }            }        }    }}
public static void metron_f2437_0(PrintStream out, CuratorFramework client) throws Exception
{    ConfigurationsUtils.visitConfigs(client, (type, name, data) -> {        type.deserialize(data);        out.println(type + " Config: " + name + System.lineSeparator() + data);    });}
public static void metron_f2438_0(PrintStream out, CuratorFramework client, ConfigurationType configType, Optional<String> configName) throws Exception
{    ConfigurationsUtils.visitConfigs(client, (type, name, data) -> {        setupStellarStatically(client, Optional.ofNullable(data));        type.deserialize(data);        out.println(type + " Config: " + name + System.lineSeparator() + data);    }, configType, configName);}
public static String metron_f2439_0(Map<String, Object> globalConfig, String globalConfigKey, String defaultFieldName)
{    if (globalConfig == null) {        return defaultFieldName;    }    return (String) globalConfig.getOrDefault(globalConfigKey, defaultFieldName);}
public String metron_f2440_0()
{    return ops.getTypeName();}
public String metron_f2441_0()
{    return ops.getDirectory();}
public Object metron_f2442_0(String s)
{    try {        return ops.deserialize(s);    } catch (IOException e) {        throw new RuntimeException("Unable to load " + s, e);    }}
public Object metron_f2443_0(String s)
{    return deserialize(s);}
public void metron_f2444_0(String sensorType, byte[] configData, CuratorFramework client) throws Exception
{    ops.writeSensorConfigToZookeeper(sensorType, configData, client);}
public String metron_f2445_0()
{    return ops.getZookeeperRoot();}
public Map<String, Object> metron_f2446_0()
{    return config;}
public void metron_f2447_0(Map<String, Object> config)
{    this.config = config;}
public Map<String, Object> metron_f2448_0()
{    return fieldMap;}
public Map<String, ConfigHandler> metron_f2449_0()
{    return enrichmentConfigs;}
public void metron_f2450_0(Map<String, Object> fieldMap)
{    this.fieldMap = fieldMap;    for (Map.Entry<String, Object> kv : fieldMap.entrySet()) {        if (kv.getValue() instanceof List) {            enrichmentConfigs.put(kv.getKey(), new ConfigHandler((List<String>) kv.getValue()));        } else {            enrichmentConfigs.put(kv.getKey(), new ConfigHandler(kv.getKey(), (Map<String, Object>) kv.getValue()));        }    }}
public Map<String, List<String>> metron_f2451_0()
{    return fieldToTypeMap;}
public void metron_f2452_0(Map<String, List<String>> fieldToTypeMap)
{    this.fieldToTypeMap = fieldToTypeMap;}
public String metron_f2453_0()
{    return "EnrichmentConfig{" + "fieldMap=" + fieldMap + ", fieldToTypeMap=" + fieldToTypeMap + ", config=" + config + '}';}
public boolean metron_f2454_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    EnrichmentConfig that = (EnrichmentConfig) o;    if (getFieldMap() != null ? !getFieldMap().equals(that.getFieldMap()) : that.getFieldMap() != null)        return false;    if (getFieldToTypeMap() != null ? !getFieldToTypeMap().equals(that.getFieldToTypeMap()) : that.getFieldToTypeMap() != null)        return false;    return getConfig() != null ? getConfig().equals(that.getConfig()) : that.getConfig() == null;}
public int metron_f2455_0()
{    int result = getFieldMap() != null ? getFieldMap().hashCode() : 0;    result = 31 * result + (getFieldToTypeMap() != null ? getFieldToTypeMap().hashCode() : 0);    result = 31 * result + (getConfig() != null ? getConfig().hashCode() : 0);    return result;}
 List<JSONObject> metron_f2456_0(JSONObject message, Object fields, Function<String, String> fieldToEnrichmentKey, ConfigHandler handler)
{    return splitByFields(message, fields, fieldToEnrichmentKey, handler.getType().toConfig(handler.getConfig()));}
 List<String> metron_f2457_0(ConfigHandler handler)
{    return getSubgroups(handler.getType().toConfig(handler.getConfig()));}
public Object metron_f2458_0()
{    return config;}
public void metron_f2459_0(Object config)
{    this.config = config;}
public Configs metron_f2460_0()
{    return type;}
public void metron_f2461_0(Configs retriever)
{    this.type = retriever;}
public boolean metron_f2462_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    ConfigHandler that = (ConfigHandler) o;    if (getConfig() != null ? !getConfig().equals(that.getConfig()) : that.getConfig() != null)        return false;    return getType() != null ? getType().equals(that.getType()) : that.getType() == null;}
public int metron_f2463_0()
{    int result = getConfig() != null ? getConfig().hashCode() : 0;    result = 31 * result + (getType() != null ? getType().hashCode() : 0);    return result;}
public List<JSONObject> metron_f2464_0(JSONObject message, Object fields, Function<String, String> fieldToEnrichmentKey, Iterable<Map.Entry<String, Object>> config)
{    return configCreator.splitByFields(message, fields, fieldToEnrichmentKey, config);}
public List<String> metron_f2465_0(Iterable<Map.Entry<String, Object>> config)
{    return configCreator.getSubgroups(config);}
public Iterable<Map.Entry<String, Object>> metron_f2466_0(Object c)
{    return configCreator.toConfig(c);}
public List<JSONObject> metron_f2467_0(JSONObject message, Object fieldsObj, Function<String, String> fieldToEnrichmentKey, Iterable<Map.Entry<String, Object>> config)
{    List<String> fields = (List<String>) fieldsObj;    JSONObject enrichmentObject = new JSONObject();    if (fields != null && fields.size() > 0) {        for (String field : fields) {            enrichmentObject.put(fieldToEnrichmentKey.apply(field), message.get(field));        }    }    return ImmutableList.of(enrichmentObject);}
public List<String> metron_f2468_0(Iterable<Map.Entry<String, Object>> config)
{    return ImmutableList.of("");}
public Iterable<Map.Entry<String, Object>> metron_f2469_0(Object c)
{    if (c instanceof Map) {        return ((Map<String, Object>) c).entrySet();    } else {        return new ArrayList<>();    }}
public List<String> metron_f2470_0(Iterable<Map.Entry<String, Object>> config)
{    boolean includeEmpty = false;    List<String> ret = new ArrayList<>();    for (Map.Entry<String, Object> kv : config) {        if (kv.getValue() instanceof String) {            includeEmpty = true;        } else if (kv.getValue() instanceof Map || kv.getValue() instanceof List) {            ret.add(kv.getKey());        }    }    if (includeEmpty) {        ret.add("");    }    return ret;}
public Iterable<Map.Entry<String, Object>> metron_f2471_0(Object c)
{    if (c instanceof Map) {        return ((Map<String, Object>) c).entrySet();    } else if (c instanceof Collection) {        List<Map.Entry<String, Object>> ret = new ArrayList<>();        for (Object o : (Collection) c) {            if (o instanceof String) {                StellarAssignment assignment = StellarAssignment.from((String) o);                ret.add(assignment);            } else if (o instanceof Map.Entry) {                ret.add((Map.Entry<String, Object>) o);            } else {                throw new IllegalStateException("Expected " + c + " to be a list of strings, but got non-string.");            }        }        return ret;    }    throw new IllegalStateException("Unable to convert config " + c + " to stellar config.  Expected List<String> or Map<String, Object>");}
private Set<String> metron_f2473_0(StellarProcessor processor, List<String> stellarStatementGroup)
{    Set<String> stellarFields = new HashSet<>();    for (String stellarStatementExpr : stellarStatementGroup) {        StellarAssignment assignment = StellarAssignment.from(stellarStatementExpr);        if (assignment.getStatement() != null) {            Set<String> variables = processor.variablesUsed(assignment.getStatement());            if (variables != null) {                stellarFields.addAll(variables);            }        }    }    return stellarFields;}
private Set<String> metron_f2474_0(StellarProcessor processor, Map<String, String> stellarStatementGroup)
{    Set<String> stellarFields = new HashSet<>();    for (String stellarStatement : stellarStatementGroup.values()) {        Set<String> variables = processor.variablesUsed(stellarStatement);        if (variables != null) {            stellarFields.addAll(variables);        }    }    return stellarFields;}
private Map<String, Object> metron_f2475_0(Set<String> stellarFields, JSONObject message)
{    Map<String, Object> messageSegment = new HashMap<>();    if (stellarFields.contains(VariableResolver.ALL_FIELDS)) {                messageSegment.putAll(message);    } else {        for (String variable : stellarFields) {            messageSegment.put(variable, message.get(variable));        }    }    return messageSegment;}
public Map<String, Object> metron_f2476_0()
{    return configuration;}
public void metron_f2477_0(Map<String, Object> configuration)
{    this.configuration = configuration;}
public EnrichmentConfig metron_f2478_0()
{    return enrichment;}
public void metron_f2479_0(EnrichmentConfig enrichment)
{    this.enrichment = enrichment;}
public ThreatIntelConfig metron_f2480_0()
{    return threatIntel;}
public void metron_f2481_0(ThreatIntelConfig threatIntel)
{    this.threatIntel = threatIntel;}
public String metron_f2482_0()
{    return "SensorEnrichmentConfig{" + ", enrichment=" + enrichment + ", threatIntel=" + threatIntel + ", configuration=" + configuration + '}';}
public boolean metron_f2483_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    SensorEnrichmentConfig that = (SensorEnrichmentConfig) o;    if (getEnrichment() != null ? !getEnrichment().equals(that.getEnrichment()) : that.getEnrichment() != null)        return false;    if (getThreatIntel() != null ? !getThreatIntel().equals(that.getThreatIntel()) : that.getThreatIntel() != null)        return false;    return getConfiguration() != null ? getConfiguration().equals(that.getConfiguration()) : that.getConfiguration() == null;}
public int metron_f2484_0()
{    int result = getEnrichment() != null ? getEnrichment().hashCode() : 0;    result = 31 * result + (getEnrichment() != null ? getEnrichment().hashCode() : 0);    result = 31 * result + (getThreatIntel() != null ? getThreatIntel().hashCode() : 0);    result = 31 * result + (getConfiguration() != null ? getConfiguration().hashCode() : 0);    return result;}
public static SensorEnrichmentConfig metron_f2485_0(byte[] config) throws IOException
{    return JSONUtils.INSTANCE.load(new String(config, StandardCharsets.UTF_8), SensorEnrichmentConfig.class);}
public String metron_f2486_0() throws JsonProcessingException
{    return JSONUtils.INSTANCE.toJSON(this, true);}
public Type metron_f2487_0()
{    return type;}
public void metron_f2488_0(Type type)
{    this.type = type;}
public Map<String, List<String>> metron_f2489_0()
{    return fieldToEnrichmentTypes;}
public void metron_f2490_0(Map<String, List<String>> fieldToEnrichmentTypes)
{    this.fieldToEnrichmentTypes = fieldToEnrichmentTypes;}
public String metron_f2491_0()
{    return zkQuorum;}
public void metron_f2492_0(String zkQuorum)
{    this.zkQuorum = zkQuorum;}
public Map<String, FieldList> metron_f2493_0()
{    return sensorToFieldList;}
public void metron_f2494_0(Map<String, FieldList> sensorToFieldList)
{    this.sensorToFieldList = sensorToFieldList;}
public void metron_f2495_0() throws Exception
{    CuratorFramework client = ConfigurationsUtils.getClient(getZkQuorum());    try {        client.start();        updateSensorConfigs(new ZKSourceConfigHandler(client), sensorToFieldList);    } finally {        client.close();    }}
public SensorEnrichmentConfig metron_f2496_0(String sensor) throws Exception
{    SensorEnrichmentConfig sensorEnrichmentConfig = new SensorEnrichmentConfig();    try {        sensorEnrichmentConfig = SensorEnrichmentConfig.fromBytes(ConfigurationsUtils.readSensorEnrichmentConfigBytesFromZookeeper(sensor, client));    } catch (KeeperException.NoNodeException e) {    }    return sensorEnrichmentConfig;}
public void metron_f2497_0(String sensor, SensorEnrichmentConfig config) throws Exception
{    ConfigurationsUtils.writeSensorEnrichmentConfigToZookeeper(sensor, config.toJSON().getBytes(StandardCharsets.UTF_8), client);}
public static void metron_f2498_1(SourceConfigHandler scHandler, Map<String, FieldList> sensorToFieldList) throws Exception
{    Map<String, SensorEnrichmentConfig> sourceConfigsChanged = new HashMap<>();    for (Map.Entry<String, FieldList> kv : sensorToFieldList.entrySet()) {        SensorEnrichmentConfig config = findConfigBySensorType(scHandler, sourceConfigsChanged, kv.getKey());        Map<String, Object> fieldMap = null;        Map<String, List<String>> fieldToTypeMap = null;        List<String> fieldList = null;        if (kv.getValue().type == Type.THREAT_INTEL) {            fieldMap = config.getThreatIntel().getFieldMap();            if (fieldMap != null) {                fieldList = (List<String>) fieldMap.get(Constants.SIMPLE_HBASE_THREAT_INTEL);            } else {                fieldMap = new HashMap<>();            }            if (fieldList == null) {                fieldList = new ArrayList<>();                fieldMap.put(Constants.SIMPLE_HBASE_THREAT_INTEL, fieldList);            }            fieldToTypeMap = config.getThreatIntel().getFieldToTypeMap();            if (fieldToTypeMap == null) {                fieldToTypeMap = new HashMap<>();                config.getThreatIntel().setFieldToTypeMap(fieldToTypeMap);            }        } else if (kv.getValue().type == Type.ENRICHMENT) {            fieldMap = config.getEnrichment().getFieldMap();            if (fieldMap != null) {                fieldList = (List<String>) fieldMap.get(Constants.SIMPLE_HBASE_ENRICHMENT);            } else {                fieldMap = new HashMap<>();            }            if (fieldList == null) {                fieldList = new ArrayList<>();                fieldMap.put(Constants.SIMPLE_HBASE_ENRICHMENT, fieldList);            }            fieldToTypeMap = config.getEnrichment().getFieldToTypeMap();            if (fieldToTypeMap == null) {                fieldToTypeMap = new HashMap<>();                config.getEnrichment().setFieldToTypeMap(fieldToTypeMap);            }        }        if (fieldToTypeMap == null || fieldMap == null) {                        continue;        }                {            HashSet<String> fieldSet = new HashSet<>(fieldList);            List<String> additionalFields = new ArrayList<>();            for (String field : kv.getValue().getFieldToEnrichmentTypes().keySet()) {                if (!fieldSet.contains(field)) {                    additionalFields.add(field);                }            }                        if (additionalFields.size() > 0) {                                fieldList.addAll(additionalFields);                sourceConfigsChanged.put(kv.getKey(), config);            }        }                {            for (Map.Entry<String, List<String>> fieldToType : kv.getValue().getFieldToEnrichmentTypes().entrySet()) {                String field = fieldToType.getKey();                final HashSet<String> types = new HashSet<>(fieldToType.getValue());                int sizeBefore = 0;                if (fieldToTypeMap.containsKey(field)) {                    List<String> typeList = (List<String>) fieldToTypeMap.get(field);                    sizeBefore = new HashSet<>(typeList).size();                    types.addAll(typeList);                }                int sizeAfter = types.size();                boolean changed = sizeBefore != sizeAfter;                if (changed) {                    fieldToTypeMap.put(field, new ArrayList<String>() {                        {                            addAll(types);                        }                    });                    sourceConfigsChanged.put(kv.getKey(), config);                }            }        }    }    for (Map.Entry<String, SensorEnrichmentConfig> kv : sourceConfigsChanged.entrySet()) {        scHandler.persistConfig(kv.getKey(), kv.getValue());    }}
private static SensorEnrichmentConfig metron_f2499_1(SourceConfigHandler scHandler, Map<String, SensorEnrichmentConfig> sourceConfigsChanged, String key) throws Exception
{    SensorEnrichmentConfig config = sourceConfigsChanged.get(key);    if (config == null) {        config = scHandler.readConfig(key);        if (LOG.isDebugEnabled()) {                    }    }    return config;}
public String metron_f2500_0()
{    return name;}
public void metron_f2501_0(String name)
{    this.name = name;}
public String metron_f2502_0()
{    return comment;}
public void metron_f2503_0(String comment)
{    this.comment = comment;}
public String metron_f2504_0()
{    return rule;}
public void metron_f2505_0(String rule)
{    this.rule = rule;}
public String metron_f2506_0()
{    return scoreExpression;}
public void metron_f2507_0(Object scoreExpression)
{    if (scoreExpression instanceof Number) {                scoreExpression = Number.class.cast(scoreExpression).toString();    } else if (scoreExpression instanceof String) {                scoreExpression = String.class.cast(scoreExpression);    } else {        throw new IllegalArgumentException(String.format("Expected 'score' to be number or string, but got '%s'", scoreExpression));    }    this.scoreExpression = scoreExpression.toString();}
public String metron_f2508_0()
{    return reason;}
public void metron_f2509_0(String reason)
{    this.reason = reason;}
public boolean metron_f2510_0(Object o)
{    if (this == o)        return true;    if (!(o instanceof RiskLevelRule))        return false;    RiskLevelRule that = (RiskLevelRule) o;    return Objects.equals(name, that.name) && Objects.equals(comment, that.comment) && Objects.equals(rule, that.rule) && Objects.equals(scoreExpression, that.scoreExpression) && Objects.equals(reason, that.reason);}
public int metron_f2511_0()
{    return Objects.hash(name, comment, rule, scoreExpression, reason);}
public String metron_f2512_0()
{    return "RiskLevelRule{" + "name='" + name + '\'' + ", comment='" + comment + '\'' + ", rule='" + rule + '\'' + ", scoreExpression='" + scoreExpression + '\'' + ", reason='" + reason + '\'' + '}';}
public String metron_f2513_0()
{    return reason;}
public RiskLevelRule metron_f2514_0()
{    return rule;}
public Number metron_f2515_0()
{    return score;}
public boolean metron_f2516_0(Object o)
{    if (this == o) {        return true;    }    if (!(o instanceof RuleScore)) {        return false;    }    RuleScore ruleScore = (RuleScore) o;    return Objects.equals(rule, ruleScore.rule) && Objects.equals(reason, ruleScore.reason) && Objects.equals(score, ruleScore.score);}
public int metron_f2517_0()
{    return Objects.hash(rule, reason, score);}
public String metron_f2518_0()
{    return "RuleScore{" + "rule=" + rule + ", reason='" + reason + '\'' + ", score=" + score + '}';}
public ThreatTriageConfig metron_f2519_0()
{    return triageConfig;}
public void metron_f2520_0(ThreatTriageConfig triageConfig)
{    this.triageConfig = triageConfig;}
public boolean metron_f2521_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    if (!super.equals(o))        return false;    ThreatIntelConfig that = (ThreatIntelConfig) o;    return getTriageConfig() != null ? getTriageConfig().equals(that.getTriageConfig()) : that.getTriageConfig() == null;}
public int metron_f2522_0()
{    int result = super.hashCode();    result = 31 * result + (getTriageConfig() != null ? getTriageConfig().hashCode() : 0);    return result;}
public String metron_f2523_0()
{    return "ThreatIntelConfig{" + "triageConfig=" + triageConfig + '}';}
public Double metron_f2524_0()
{    return score;}
public void metron_f2525_0(Double score)
{    this.score = score;}
public List<RuleScore> metron_f2526_0()
{    return ruleScores;}
public void metron_f2527_0(RuleScore score)
{    this.ruleScores.add(score);}
public boolean metron_f2528_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    ThreatScore that = (ThreatScore) o;    if (score != null ? !score.equals(that.score) : that.score != null)        return false;    return ruleScores != null ? ruleScores.equals(that.ruleScores) : that.ruleScores == null;}
public int metron_f2529_0()
{    int result = score != null ? score.hashCode() : 0;    result = 31 * result + (ruleScores != null ? ruleScores.hashCode() : 0);    return result;}
public String metron_f2530_0()
{    return "ThreatScore{" + "score=" + score + ", ruleScores=" + ruleScores + '}';}
public List<RiskLevelRule> metron_f2531_0()
{    return riskLevelRules;}
public void metron_f2532_0(List<RiskLevelRule> riskLevelRules)
{    List<RiskLevelRule> rules = new ArrayList<>();    Set<String> ruleIndex = new HashSet<>();    StellarPredicateProcessor predicateProcessor = new StellarPredicateProcessor();    StellarProcessor processor = new StellarProcessor();    for (RiskLevelRule rule : riskLevelRules) {        if (rule.getRule() == null || rule.getScoreExpression() == null) {            throw new IllegalStateException("Risk level rules must contain both a rule and a score.");        }        if (ruleIndex.contains(rule.getRule())) {            continue;        } else {            ruleIndex.add(rule.getRule());        }                predicateProcessor.validate(rule.getRule());        if (rule.getReason() != null) {            processor.validate(rule.getReason());        }        rules.add(rule);    }    this.riskLevelRules = rules;}
public Aggregators metron_f2533_0()
{    return aggregator;}
public void metron_f2534_0(String aggregator)
{    try {        this.aggregator = Aggregators.valueOf(aggregator);    } catch (IllegalArgumentException iae) {        throw new IllegalArgumentException("Unable to load aggregator of " + aggregator + ".  Valid aggregators are " + Joiner.on(',').join(Aggregators.values()));    }}
public Map<String, Object> metron_f2535_0()
{    return aggregationConfig;}
public void metron_f2536_0(Map<String, Object> aggregationConfig)
{    this.aggregationConfig = aggregationConfig;}
public String metron_f2537_0()
{    return "ThreatTriageConfig{" + "riskLevelRules=" + riskLevelRules + ", aggregator=" + aggregator + ", aggregationConfig=" + aggregationConfig + '}';}
public boolean metron_f2538_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    ThreatTriageConfig that = (ThreatTriageConfig) o;    if (riskLevelRules != null ? !riskLevelRules.equals(that.riskLevelRules) : that.riskLevelRules != null)        return false;    if (aggregator != that.aggregator)        return false;    return aggregationConfig != null ? aggregationConfig.equals(that.aggregationConfig) : that.aggregationConfig == null;}
public int metron_f2539_0()
{    int result = riskLevelRules != null ? riskLevelRules.hashCode() : 0;    result = 31 * result + (aggregator != null ? aggregator.hashCode() : 0);    result = 31 * result + (aggregationConfig != null ? aggregationConfig.hashCode() : 0);    return result;}
public String metron_f2540_0()
{    return "enrichments";}
public Object metron_f2541_0(String s) throws IOException
{    return JSONUtils.INSTANCE.load(s, SensorEnrichmentConfig.class);}
public void metron_f2542_0(String sensorType, byte[] configData, CuratorFramework client) throws Exception
{    ConfigurationsUtils.writeSensorEnrichmentConfigToZookeeper(sensorType, configData, client);}
public SensorEnrichmentConfig metron_f2543_0(String sensorType)
{    return (SensorEnrichmentConfig) getConfigurations().get(getKey(sensorType));}
public void metron_f2544_0(String sensorType, byte[] data) throws IOException
{    updateSensorEnrichmentConfig(sensorType, new ByteArrayInputStream(data));}
public void metron_f2545_0(String sensorType, InputStream io) throws IOException
{    SensorEnrichmentConfig sensorEnrichmentConfig = JSONUtils.INSTANCE.load(io, SensorEnrichmentConfig.class);    updateSensorEnrichmentConfig(sensorType, sensorEnrichmentConfig);}
public void metron_f2546_0(String sensorType, SensorEnrichmentConfig sensorEnrichmentConfig)
{    getConfigurations().put(getKey(sensorType), sensorEnrichmentConfig);}
public void metron_f2547_0(String sensorType)
{    getConfigurations().remove(getKey(sensorType));}
public int metron_f2548_0()
{    return getAs(BATCH_SIZE_CONF, getGlobalConfig(true), DEFAULT_KAFKA_BATCH_SIZE, Integer.class);}
public int metron_f2549_0()
{    return getAs(BATCH_TIMEOUT_CONF, getGlobalConfig(true), 0, Integer.class);}
public List<String> metron_f2550_0()
{    List<String> ret = new ArrayList<>();    for (String keyedSensor : getConfigurations().keySet()) {        if (!keyedSensor.isEmpty() && keyedSensor.startsWith(ConfigurationType.ENRICHMENT.getTypeName())) {            ret.add(keyedSensor.substring(ConfigurationType.ENRICHMENT.getTypeName().length() + 1));        }    }    return ret;}
public static String metron_f2551_0(String sensorType)
{    return ConfigurationType.ENRICHMENT.getTypeName() + "." + sensorType;}
public List<String> metron_f2552_0()
{    return input;}
public void metron_f2553_0(Object inputFields)
{    if (inputFields instanceof String) {        this.input = ImmutableList.of(inputFields.toString());    } else if (inputFields instanceof List) {        this.input = (List<String>) inputFields;    }}
public List<String> metron_f2554_0()
{    return output;}
public void metron_f2555_0(Object outputField)
{    if (outputField instanceof String) {        this.output = ImmutableList.of(outputField.toString());    } else if (outputField instanceof List) {        this.output = (List<String>) outputField;    }}
public Map<String, Object> metron_f2556_0()
{    return config;}
public void metron_f2557_0(LinkedHashMap<String, Object> config)
{    this.config = config;}
public String metron_f2558_0()
{    return transformationName;}
public FieldTransformation metron_f2559_0()
{    return transformation;}
public void metron_f2560_0(String transformation)
{    this.transformationName = transformation;    this.transformation = FieldTransformations.get(transformation);}
public void metron_f2561_0()
{    if (!initialized) {        if (getTransformation() == null) {            throw new IllegalStateException("Mapping cannot be null.");        }        if (output == null || output.isEmpty()) {            if (input == null || input.isEmpty()) {                                output = null;                input = null;            } else {                output = input;            }        }        initialized = true;    }}
public Map<String, Object> metron_f2562_0(JSONObject input, Context context, Map<String, Object>... sensorConfig)
{    if (getInput() == null || getInput().isEmpty()) {        return transformation.map(input, getOutput(), config, context, sensorConfig);    } else {        Map<String, Object> in = new HashMap<>();        for (String inputField : getInput()) {            in.put(inputField, input.get(inputField));        }        return transformation.map(in, getOutput(), config, context, sensorConfig);    }}
public void metron_f2563_0(JSONObject message, Context context, Map<String, Object>... sensorConfig)
{    Map<String, Object> currentValue = transform(message, context, sensorConfig);    if (currentValue != null) {        for (Map.Entry<String, Object> kv : currentValue.entrySet()) {            if (kv.getValue() == null) {                message.remove(kv.getKey());            } else {                message.put(kv.getKey(), kv.getValue());            }        }    }}
public String metron_f2564_0()
{    return "MappingHandler{" + "input=" + input + ", output='" + output + '\'' + ", transformation=" + transformation + ", config=" + config + '}';}
public boolean metron_f2565_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    FieldTransformer that = (FieldTransformer) o;    if (getInput() != null ? !getInput().equals(that.getInput()) : that.getInput() != null)        return false;    if (getOutput() != null ? !getOutput().equals(that.getOutput()) : that.getOutput() != null)        return false;    if (getTransformation() != null ? !getTransformation().equals(that.getTransformation()) : that.getTransformation() != null)        return false;    return getConfig() != null ? getConfig().equals(that.getConfig()) : that.getConfig() == null;}
public int metron_f2566_0()
{    int result = getInput() != null ? getInput().hashCode() : 0;    result = 31 * result + (getOutput() != null ? getOutput().hashCode() : 0);    result = 31 * result + (getTransformation() != null ? getTransformation().hashCode() : 0);    result = 31 * result + (getConfig() != null ? getConfig().hashCode() : 0);    return result;}
public T metron_f2567_0(Map<String, Object> config, Class<T> clazz)
{    Object o = config.get(key);    if (o == null) {        return null;    }    return clazz.cast(o);}
public FieldValidation metron_f2568_0()
{    return validation;}
public List<String> metron_f2569_0()
{    return input;}
public Map<String, Object> metron_f2570_0()
{    return config;}
public boolean metron_f2571_0(JSONObject inputData, Map<String, Object> globalConfig, Context context)
{    Map<String, Object> in = inputData;    if (input != null && !input.isEmpty()) {        in = new HashMap<>();        for (String i : input) {            Object o = inputData.get(i);            in.put(i, o);        }    }    return validation.isValid(in, config, globalConfig, context);}
public static List<FieldValidator> metron_f2572_0(Map<String, Object> globalConfig)
{    List<FieldValidator> validators = new ArrayList<>();    List<Object> validations = (List<Object>) Config.FIELD_VALIDATIONS.get(globalConfig, List.class);    if (validations != null) {        for (Object o : validations) {            FieldValidator f = new FieldValidator(o);            f.getValidation().initialize(f.getConfig(), globalConfig);            validators.add(new FieldValidator(o));        }    }    return validators;}
public boolean metron_f2573_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    FieldValidator that = (FieldValidator) o;    if (getValidation() != null ? !getValidation().equals(that.getValidation()) : that.getValidation() != null)        return false;    if (getInput() != null ? !getInput().equals(that.getInput()) : that.getInput() != null)        return false;    return getConfig() != null ? getConfig().equals(that.getConfig()) : that.getConfig() == null;}
public int metron_f2574_0()
{    int result = getValidation() != null ? getValidation().hashCode() : 0;    result = 31 * result + (getInput() != null ? getInput().hashCode() : 0);    result = 31 * result + (getConfig() != null ? getConfig().hashCode() : 0);    return result;}
public String metron_f2575_0()
{    return "FieldValidator{" + "validation=" + validation + ", input=" + input + ", config=" + config + '}';}
public String metron_f2576_0()
{    return "global";}
public String metron_f2577_0()
{    return ".";}
public Object metron_f2578_0(String s) throws IOException
{    return JSONUtils.INSTANCE.load(s, JSONUtils.MAP_SUPPLIER);}
public void metron_f2579_0(String sensorType, byte[] configData, CuratorFramework client)
{    throw new UnsupportedOperationException("Global configs are not per-sensor");}
public String metron_f2580_0()
{    return "indexing";}
public Object metron_f2581_0(String s) throws IOException
{    return JSONUtils.INSTANCE.load(s, JSONUtils.MAP_SUPPLIER);}
public void metron_f2582_0(String sensorType, byte[] configData, CuratorFramework client) throws Exception
{    ConfigurationsUtils.writeSensorIndexingConfigToZookeeper(sensorType, configData, client);}
public Map<String, Object> metron_f2583_0(String sensorType, boolean emptyMapOnNonExistent)
{    Map<String, Object> ret = (Map<String, Object>) getConfigurations().get(getKey(sensorType));    if (ret == null) {        return emptyMapOnNonExistent ? new HashMap<>() : null;    } else {        return ret;    }}
public Map<String, Object> metron_f2584_0(String sensorType)
{    return getSensorIndexingConfig(sensorType, true);}
public List<String> metron_f2585_0()
{    List<String> ret = new ArrayList<>();    for (String keyedSensor : getConfigurations().keySet()) {        if (!keyedSensor.isEmpty() && keyedSensor.startsWith(ConfigurationType.INDEXING.getTypeName())) {            ret.add(keyedSensor.substring(ConfigurationType.INDEXING.getTypeName().length() + 1));        }    }    return ret;}
public void metron_f2586_0(String sensorType)
{    getConfigurations().remove(getKey(sensorType));}
public Map<String, Object> metron_f2587_0(String sensorType, String writerName)
{    String key = getKey(sensorType);    Map<String, Object> ret = (Map<String, Object>) getConfigurations().get(key);    if (ret == null) {        return new HashMap();    } else {        Map<String, Object> writerConfig = (Map<String, Object>) ret.get(writerName);        return writerConfig != null ? writerConfig : new HashMap<>();    }}
public void metron_f2588_0(String sensorType, byte[] data) throws IOException
{    updateSensorIndexingConfig(sensorType, new ByteArrayInputStream(data));}
public void metron_f2589_0(String sensorType, InputStream io) throws IOException
{    Map<String, Object> sensorIndexingConfig = JSONUtils.INSTANCE.load(io, JSONUtils.MAP_SUPPLIER);    updateSensorIndexingConfig(sensorType, sensorIndexingConfig);}
public void metron_f2590_0(String sensorType, Map<String, Object> sensorIndexingConfig)
{    getConfigurations().put(getKey(sensorType), sensorIndexingConfig);}
public static String metron_f2591_0(String sensorType)
{    return ConfigurationType.INDEXING.getTypeName() + "." + sensorType;}
public boolean metron_f2592_0(String sensorName, String writerName)
{    Map<String, Object> ret = (Map<String, Object>) getConfigurations().get(getKey(sensorName));    if (ret == null) {        return true;    } else {        Map<String, Object> writerConfig = (Map<String, Object>) ret.get(writerName);        return writerConfig != null ? false : true;    }}
public int metron_f2593_0(String sensorName, String writerName)
{    return getBatchSize(getSensorIndexingConfig(sensorName, writerName));}
public int metron_f2594_0(String sensorName, String writerName)
{    return getBatchTimeout(getSensorIndexingConfig(sensorName, writerName));}
public List<Integer> metron_f2595_0(String writerName)
{                        String keyPrefixString = getKey("");    int prefixStringLength = keyPrefixString.length();    List<Integer> configuredBatchTimeouts = new ArrayList<>();    for (String sensorKeyString : getConfigurations().keySet()) {        if (sensorKeyString.startsWith(keyPrefixString)) {            String configuredSensorName = sensorKeyString.substring(prefixStringLength);            configuredBatchTimeouts.add(getBatchTimeout(configuredSensorName, writerName));        }    }    return configuredBatchTimeouts;}
public String metron_f2596_0(String sensorName, String writerName)
{    return getIndex(getSensorIndexingConfig(sensorName, writerName), sensorName);}
public boolean metron_f2597_0(String sensorName, String writerName)
{    return isEnabled(getSensorIndexingConfig(sensorName, writerName));}
public String metron_f2598_0(String sensorName, String writerName)
{    return getOutputPathFunction(getSensorIndexingConfig(sensorName, writerName), sensorName);}
public String metron_f2599_0(String sensorName, String writerName)
{    return getFieldNameConverter(getSensorIndexingConfig(sensorName, writerName), sensorName);}
public boolean metron_f2600_0(String sensorName, String writerName)
{    return isSetDocumentId(getGlobalConfig(true), getSensorIndexingConfig(sensorName, writerName));}
public static boolean metron_f2601_0(Map<String, Object> conf)
{    return getAs(ENABLED_CONF, conf, true, Boolean.class);}
public static int metron_f2602_0(Map<String, Object> conf)
{    return getAs(BATCH_SIZE_CONF, conf, 1, Integer.class);}
public static int metron_f2603_0(Map<String, Object> conf)
{    return getAs(BATCH_TIMEOUT_CONF, conf, 0, Integer.class);}
public static String metron_f2604_0(Map<String, Object> conf, String sensorName)
{    return getAs(INDEX_CONF, conf, sensorName, String.class);}
public static String metron_f2605_0(Map<String, Object> conf, String sensorName)
{    return getAs(OUTPUT_PATH_FUNCTION_CONF, conf, "", String.class);}
public static String metron_f2606_0(Map<String, Object> conf, String sensorName)
{    return getAs(FIELD_NAME_CONVERTER_CONF, conf, "", String.class);}
public static boolean metron_f2607_0(Map<String, Object> globalConf, Map<String, Object> sensorConf)
{    return getAs(SET_DOCUMENT_ID_CONF, sensorConf, getAs(GLOBAL_ELASTICSEARCH_SET_DOCUMENT_ID_CONF, globalConf, false, Boolean.class), Boolean.class);}
public static Map<String, Object> metron_f2608_0(Map<String, Object> conf, boolean enabled)
{    Map<String, Object> ret = conf == null ? new HashMap<>() : conf;    ret.put(ENABLED_CONF, enabled);    return ret;}
public static Map<String, Object> metron_f2609_0(Map<String, Object> conf, int batchSize)
{    Map<String, Object> ret = conf == null ? new HashMap<>() : conf;    ret.put(BATCH_SIZE_CONF, batchSize);    return ret;}
public static Map<String, Object> metron_f2610_0(Map<String, Object> conf, int batchTimeout)
{    Map<String, Object> ret = conf == null ? new HashMap<>() : conf;    ret.put(BATCH_TIMEOUT_CONF, batchTimeout);    return ret;}
public static Map<String, Object> metron_f2611_0(Map<String, Object> conf, String index)
{    Map<String, Object> ret = conf == null ? new HashMap<>() : conf;    ret.put(INDEX_CONF, index);    return ret;}
public static Map<String, Object> metron_f2612_0(Map<String, Object> conf, String index)
{    Map<String, Object> ret = conf == null ? new HashMap<>() : conf;    ret.put(FIELD_NAME_CONVERTER_CONF, index);    return ret;}
public String metron_f2613_0()
{    return "parsers";}
public Object metron_f2614_0(String s) throws IOException
{    return JSONUtils.INSTANCE.load(s, SensorParserConfig.class);}
public void metron_f2615_0(String sensorType, byte[] configData, CuratorFramework client) throws Exception
{    ConfigurationsUtils.writeSensorParserConfigToZookeeper(sensorType, configData, client);}
public SensorParserConfig metron_f2616_0(String sensorType)
{    return (SensorParserConfig) getConfigurations().get(getKey(sensorType));}
public void metron_f2617_0(String sensorType, byte[] data) throws IOException
{    updateSensorParserConfig(sensorType, new ByteArrayInputStream(data));}
public void metron_f2618_0(String sensorType, InputStream io) throws IOException
{    SensorParserConfig sensorParserConfig = JSONUtils.INSTANCE.load(io, SensorParserConfig.class);    updateSensorParserConfig(sensorType, sensorParserConfig);}
public void metron_f2619_0(String sensorType, SensorParserConfig sensorParserConfig)
{    sensorParserConfig.init();    getConfigurations().put(getKey(sensorType), sensorParserConfig);}
public Map<String, SensorParserGroup> metron_f2620_0()
{    Object groups = getGlobalConfig(true).getOrDefault(PARSER_GROUPS_CONF, new ArrayList<>());    Collection<SensorParserGroup> sensorParserGroups = JSONUtils.INSTANCE.getMapper().convertValue(groups, new TypeReference<Collection<SensorParserGroup>>() {        {        }    });    return sensorParserGroups.stream().collect(Collectors.toMap(SensorParserGroup::getName, sensorParserGroup -> sensorParserGroup));}
public List<String> metron_f2621_0()
{    List<String> ret = new ArrayList<>();    for (String keyedSensor : getConfigurations().keySet()) {        if (!keyedSensor.isEmpty() && keyedSensor.startsWith(ConfigurationType.PARSER.getTypeName())) {            ret.add(keyedSensor.substring(ConfigurationType.PARSER.getTypeName().length() + 1));        }    }    return ret;}
public void metron_f2622_0(String sensorType)
{    getConfigurations().remove(getKey(sensorType));}
public static String metron_f2623_0(String sensorType)
{    return ConfigurationType.PARSER.getTypeName() + "." + sensorType;}
public String metron_f2624_0()
{    return profile;}
public void metron_f2625_0(String profile)
{    this.profile = profile;}
public ProfileConfig metron_f2626_0(String profile)
{    this.profile = profile;    return this;}
public String metron_f2627_0()
{    return foreach;}
public void metron_f2628_0(String foreach)
{    this.foreach = foreach;}
public ProfileConfig metron_f2629_0(String foreach)
{    this.foreach = foreach;    return this;}
public String metron_f2630_0()
{    return onlyif;}
public void metron_f2631_0(String onlyif)
{    this.onlyif = onlyif;}
public ProfileConfig metron_f2632_0(String onlyif)
{    this.onlyif = onlyif;    return this;}
public Map<String, String> metron_f2633_0()
{    return init;}
public void metron_f2634_0(Map<String, String> init)
{    this.init = init;}
public ProfileConfig metron_f2635_0(Map<String, String> init)
{    this.init.putAll(init);    return this;}
public ProfileConfig metron_f2636_0(String var, String expression)
{    this.init.put(var, expression);    return this;}
public Map<String, String> metron_f2637_0()
{    return update;}
public void metron_f2638_0(Map<String, String> update)
{    this.update = update;}
public ProfileConfig metron_f2639_0(Map<String, String> update)
{    this.update.putAll(update);    return this;}
public ProfileConfig metron_f2640_0(String var, String expression)
{    this.update.put(var, expression);    return this;}
public List<String> metron_f2641_0()
{    return groupBy;}
public void metron_f2642_0(List<String> groupBy)
{    this.groupBy = groupBy;}
public ProfileConfig metron_f2643_0(List<String> groupBy)
{    this.groupBy = groupBy;    return this;}
public ProfileResult metron_f2644_0()
{    return result;}
public void metron_f2645_0(ProfileResult result)
{    this.result = result;}
public ProfileConfig metron_f2646_0(String profileExpression)
{    this.result = new ProfileResult(profileExpression);    return this;}
public Long metron_f2647_0()
{    return expires;}
public void metron_f2648_0(Long expiresDays)
{    this.expires = expiresDays;}
public ProfileConfig metron_f2649_0(Long expiresDays)
{    this.expires = TimeUnit.DAYS.toMillis(expiresDays);    return this;}
public boolean metron_f2650_0(Object o)
{    if (this == o) {        return true;    }    if (o == null || getClass() != o.getClass()) {        return false;    }    ProfileConfig that = (ProfileConfig) o;    return new EqualsBuilder().append(profile, that.profile).append(foreach, that.foreach).append(onlyif, that.onlyif).append(init, that.init).append(update, that.update).append(groupBy, that.groupBy).append(result, that.result).append(expires, that.expires).isEquals();}
public int metron_f2651_0()
{    return new HashCodeBuilder(17, 37).append(profile).append(foreach).append(onlyif).append(init).append(update).append(groupBy).append(result).append(expires).toHashCode();}
public String metron_f2652_0()
{    return new ToStringBuilder(this).append("profile", profile).append("foreach", foreach).append("onlyif", onlyif).append("init", init).append("update", update).append("groupBy", groupBy).append("result", result).append("expires", expires).toString();}
public static ProfileConfig metron_f2653_0(byte[] bytes) throws IOException
{    return JSONUtils.INSTANCE.load(new String(bytes, StandardCharsets.UTF_8), ProfileConfig.class);}
public static ProfileConfig metron_f2654_0(String json) throws IOException
{    return JSONUtils.INSTANCE.load(json, ProfileConfig.class);}
public String metron_f2655_0() throws JsonProcessingException
{    return JSONUtils.INSTANCE.toJSON(this, true);}
public List<ProfileConfig> metron_f2656_0()
{    return profiles;}
public void metron_f2657_0(List<ProfileConfig> profiles)
{    this.profiles = profiles;}
public ProfilerConfig metron_f2658_0(ProfileConfig profileConfig)
{    this.profiles.add(profileConfig);    return this;}
public String metron_f2659_0()
{    return timestampField;}
public Optional<String> metron_f2660_0()
{    return Optional.ofNullable(timestampField);}
public void metron_f2661_0(String timestampField)
{    this.timestampField = timestampField;}
public void metron_f2662_0(Optional<String> timestampField)
{    this.timestampField = timestampField.orElse(null);}
public ProfilerConfig metron_f2663_0(Optional<String> timestampField)
{    this.timestampField = timestampField.orElse(null);    return this;}
public String metron_f2664_0()
{    return new ToStringBuilder(this).append("profiles", profiles).append("timestampField", timestampField).toString();}
public boolean metron_f2665_0(Object o)
{    if (this == o) {        return true;    }    if (o == null || getClass() != o.getClass()) {        return false;    }    ProfilerConfig that = (ProfilerConfig) o;    return new EqualsBuilder().append(profiles, that.profiles).append(timestampField, that.timestampField).isEquals();}
public int metron_f2666_0()
{    return new HashCodeBuilder(17, 37).append(profiles).append(timestampField).toHashCode();}
public static ProfilerConfig metron_f2667_0(byte[] bytes) throws IOException
{    return JSONUtils.INSTANCE.load(new String(bytes, StandardCharsets.UTF_8), ProfilerConfig.class);}
public static ProfilerConfig metron_f2668_0(String json) throws IOException
{    return JSONUtils.INSTANCE.load(json, ProfilerConfig.class);}
public String metron_f2669_0() throws JsonProcessingException
{    return JSONUtils.INSTANCE.toJSON(this, true);}
public ProfilerConfig metron_f2670_0()
{    return (ProfilerConfig) getConfigurations().get(getKey());}
public void metron_f2671_0(byte[] data) throws IOException
{    updateProfilerConfig(new ByteArrayInputStream(data));}
public void metron_f2672_0(InputStream io) throws IOException
{    ProfilerConfig config = JSONUtils.INSTANCE.load(io, ProfilerConfig.class);    updateProfilerConfig(config);}
public void metron_f2673_0(ProfilerConfig config)
{    getConfigurations().put(getKey(), config);}
public static String metron_f2674_0()
{    return ConfigurationType.PROFILER.getTypeName();}
public void metron_f2675_0()
{    configurations.remove(getKey());}
public int metron_f2676_0()
{    return getAs(BATCH_SIZE_CONF, getGlobalConfig(true), DEFAULT_KAFKA_BATCH_SIZE, Integer.class);}
public int metron_f2677_0()
{    return getAs(BATCH_TIMEOUT_CONF, getGlobalConfig(true), 0, Integer.class);}
public ProfileResultExpressions metron_f2678_0()
{    return profileExpressions;}
public void metron_f2679_0(ProfileResultExpressions profileExpressions)
{    this.profileExpressions = profileExpressions;}
public ProfileTriageExpressions metron_f2680_0()
{    return triageExpressions;}
public void metron_f2681_0(ProfileTriageExpressions triageExpressions)
{    this.triageExpressions = triageExpressions;}
public String metron_f2682_0()
{    return "ProfileResult{" + "profileExpressions=" + profileExpressions + ", triageExpressions=" + triageExpressions + '}';}
public boolean metron_f2683_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    ProfileResult that = (ProfileResult) o;    if (profileExpressions != null ? !profileExpressions.equals(that.profileExpressions) : that.profileExpressions != null)        return false;    return triageExpressions != null ? triageExpressions.equals(that.triageExpressions) : that.triageExpressions == null;}
public int metron_f2684_0()
{    int result = profileExpressions != null ? profileExpressions.hashCode() : 0;    result = 31 * result + (triageExpressions != null ? triageExpressions.hashCode() : 0);    return result;}
public String metron_f2685_0()
{    return expression;}
public void metron_f2686_0(String expression)
{    this.expression = expression;}
public String metron_f2687_0()
{    return "ProfileResultExpressions{" + "expression='" + expression + '\'' + '}';}
public boolean metron_f2688_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    ProfileResultExpressions that = (ProfileResultExpressions) o;    return expression != null ? expression.equals(that.expression) : that.expression == null;}
public int metron_f2689_0()
{    return expression != null ? expression.hashCode() : 0;}
public String metron_f2690_0(String name)
{    return expressions.get(name);}
public Map<String, String> metron_f2691_0()
{    return expressions;}
public void metron_f2692_0(Map<String, String> expressions)
{    this.expressions = expressions;}
public String metron_f2693_0()
{    return "ProfileTriageExpressions{" + "expressions=" + expressions + '}';}
public boolean metron_f2694_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    ProfileTriageExpressions that = (ProfileTriageExpressions) o;    return getExpressions() != null ? getExpressions().equals(that.getExpressions()) : that.getExpressions() == null;}
public int metron_f2695_0()
{    return getExpressions() != null ? getExpressions().hashCode() : 0;}
public String metron_f2696_0()
{    return "profiler";}
public String metron_f2697_0()
{    return ".";}
public Object metron_f2698_0(String s) throws IOException
{    return JSONUtils.INSTANCE.load(s, ProfilerConfig.class);}
public void metron_f2699_0(String sensorType, byte[] configData, CuratorFramework client) throws Exception
{    throw new UnsupportedOperationException("Profiler configs are not per-sensor");}
public RawMessageStrategy metron_f2700_0()
{    return rawMessageStrategy;}
public void metron_f2701_0(String rawMessageSupplierName)
{    this.rawMessageStrategy = RawMessageStrategies.valueOf(rawMessageSupplierName);}
public Map<String, Object> metron_f2702_0()
{    return rawMessageStrategyConfig;}
public void metron_f2703_0(Map<String, Object> rawMessageStrategyConfig)
{    this.rawMessageStrategyConfig = rawMessageStrategyConfig;}
public Map<String, Object> metron_f2704_0()
{    return cacheConfig;}
public void metron_f2705_0(Map<String, Object> cacheConfig)
{    this.cacheConfig = cacheConfig;}
public Integer metron_f2706_0()
{    return numWorkers;}
public void metron_f2707_0(Integer numWorkers)
{    this.numWorkers = numWorkers;}
public Integer metron_f2708_0()
{    return numAckers;}
public void metron_f2709_0(Integer numAckers)
{    this.numAckers = numAckers;}
public Integer metron_f2710_0()
{    return spoutParallelism;}
public void metron_f2711_0(Integer spoutParallelism)
{    this.spoutParallelism = spoutParallelism;}
public Integer metron_f2712_0()
{    return spoutNumTasks;}
public void metron_f2713_0(Integer spoutNumTasks)
{    this.spoutNumTasks = spoutNumTasks;}
public Integer metron_f2714_0()
{    return parserParallelism;}
public void metron_f2715_0(Integer parserParallelism)
{    this.parserParallelism = parserParallelism;}
public Integer metron_f2716_0()
{    return parserNumTasks;}
public void metron_f2717_0(Integer parserNumTasks)
{    this.parserNumTasks = parserNumTasks;}
public Integer metron_f2718_0()
{    return errorWriterParallelism;}
public void metron_f2719_0(Integer errorWriterParallelism)
{    this.errorWriterParallelism = errorWriterParallelism;}
public Integer metron_f2720_0()
{    return errorWriterNumTasks;}
public void metron_f2721_0(Integer errorWriterNumTasks)
{    this.errorWriterNumTasks = errorWriterNumTasks;}
public Map<String, Object> metron_f2722_0()
{    return spoutConfig;}
public void metron_f2723_0(Map<String, Object> spoutConfig)
{    this.spoutConfig = spoutConfig;}
public String metron_f2724_0()
{    return securityProtocol;}
public void metron_f2725_0(String securityProtocol)
{    this.securityProtocol = securityProtocol;}
public Map<String, Object> metron_f2726_0()
{    return stormConfig;}
public void metron_f2727_0(Map<String, Object> stormConfig)
{    this.stormConfig = stormConfig;}
public Boolean metron_f2728_0()
{    return Optional.ofNullable(mergeMetadata).orElse(getRawMessageStrategy().mergeMetadataDefault());}
public void metron_f2729_0(Boolean mergeMetadata)
{    this.mergeMetadata = mergeMetadata;}
public Boolean metron_f2730_0()
{    return Optional.ofNullable(readMetadata).orElse(getRawMessageStrategy().readMetadataDefault());}
public void metron_f2731_0(Boolean readMetadata)
{    this.readMetadata = readMetadata;}
public String metron_f2732_0()
{    return errorWriterClassName;}
public void metron_f2733_0(String errorWriterClassName)
{    this.errorWriterClassName = errorWriterClassName;}
public String metron_f2734_0()
{    return writerClassName;}
public void metron_f2735_0(String classNames)
{    this.writerClassName = classNames;}
public List<FieldTransformer> metron_f2736_0()
{    return fieldTransformations;}
public void metron_f2737_0(List<FieldTransformer> fieldTransformations)
{    this.fieldTransformations = fieldTransformations;}
public String metron_f2738_0()
{    return filterClassName;}
public void metron_f2739_0(String filterClassName)
{    this.filterClassName = filterClassName;}
public String metron_f2740_0()
{    return parserClassName;}
public void metron_f2741_0(String parserClassName)
{    this.parserClassName = parserClassName;}
public String metron_f2742_0()
{    return sensorTopic;}
public void metron_f2743_0(String sensorTopic)
{    this.sensorTopic = sensorTopic;}
public String metron_f2744_0()
{    return outputTopic;}
public void metron_f2745_0(String outputTopic)
{    this.outputTopic = outputTopic;}
public String metron_f2746_0()
{    return errorTopic;}
public void metron_f2747_0(String errorTopic)
{    this.errorTopic = errorTopic;}
public Map<String, Object> metron_f2748_0()
{    return parserConfig;}
public void metron_f2749_0(Map<String, Object> parserConfig)
{    this.parserConfig = parserConfig;}
public static SensorParserConfig metron_f2750_0(byte[] config) throws IOException
{    SensorParserConfig ret = JSONUtils.INSTANCE.load(new String(config, StandardCharsets.UTF_8), SensorParserConfig.class);    ret.init();    return ret;}
public void metron_f2751_0()
{    for (FieldTransformer h : getFieldTransformations()) {        h.initAndValidate();    }}
public String metron_f2752_0() throws JsonProcessingException
{    return JSONUtils.INSTANCE.toJSON(this, true);}
public boolean metron_f2753_0(Object o)
{    if (this == o) {        return true;    }    if (o == null || getClass() != o.getClass()) {        return false;    }    SensorParserConfig that = (SensorParserConfig) o;    return new EqualsBuilder().append(parserClassName, that.parserClassName).append(filterClassName, that.filterClassName).append(sensorTopic, that.sensorTopic).append(outputTopic, that.outputTopic).append(errorTopic, that.errorTopic).append(writerClassName, that.writerClassName).append(errorWriterClassName, that.errorWriterClassName).append(getReadMetadata(), that.getReadMetadata()).append(getMergeMetadata(), that.getMergeMetadata()).append(numWorkers, that.numWorkers).append(numAckers, that.numAckers).append(spoutParallelism, that.spoutParallelism).append(spoutNumTasks, that.spoutNumTasks).append(parserParallelism, that.parserParallelism).append(parserNumTasks, that.parserNumTasks).append(errorWriterParallelism, that.errorWriterParallelism).append(errorWriterNumTasks, that.errorWriterNumTasks).append(spoutConfig, that.spoutConfig).append(securityProtocol, that.securityProtocol).append(stormConfig, that.stormConfig).append(cacheConfig, that.cacheConfig).append(parserConfig, that.parserConfig).append(fieldTransformations, that.fieldTransformations).append(rawMessageStrategy, that.rawMessageStrategy).append(rawMessageStrategyConfig, that.rawMessageStrategyConfig).isEquals();}
public int metron_f2754_0()
{    return new HashCodeBuilder(17, 37).append(parserClassName).append(filterClassName).append(sensorTopic).append(outputTopic).append(errorTopic).append(writerClassName).append(errorWriterClassName).append(getReadMetadata()).append(getMergeMetadata()).append(numWorkers).append(numAckers).append(spoutParallelism).append(spoutNumTasks).append(parserParallelism).append(parserNumTasks).append(errorWriterParallelism).append(errorWriterNumTasks).append(spoutConfig).append(securityProtocol).append(stormConfig).append(cacheConfig).append(parserConfig).append(fieldTransformations).append(rawMessageStrategy).append(rawMessageStrategyConfig).toHashCode();}
public String metron_f2755_0()
{    return new ToStringBuilder(this).append("parserClassName", parserClassName).append("filterClassName", filterClassName).append("sensorTopic", sensorTopic).append("outputTopic", outputTopic).append("errorTopic", errorTopic).append("writerClassName", writerClassName).append("errorWriterClassName", errorWriterClassName).append("readMetadata", getReadMetadata()).append("mergeMetadata", getMergeMetadata()).append("numWorkers", numWorkers).append("numAckers", numAckers).append("spoutParallelism", spoutParallelism).append("spoutNumTasks", spoutNumTasks).append("parserParallelism", parserParallelism).append("parserNumTasks", parserNumTasks).append("errorWriterParallelism", errorWriterParallelism).append("errorWriterNumTasks", errorWriterNumTasks).append("spoutConfig", spoutConfig).append("securityProtocol", securityProtocol).append("stormConfig", stormConfig).append("cacheConfig", cacheConfig).append("parserConfig", parserConfig).append("fieldTransformations", fieldTransformations).append("rawMessageStrategy", rawMessageStrategy).append("rawMessageStrategyConfig", rawMessageStrategyConfig).toString();}
public String metron_f2756_0()
{    return name;}
public void metron_f2757_0(String name)
{    this.name = name;}
public String metron_f2758_0()
{    return description;}
public void metron_f2759_0(String description)
{    this.description = description;}
public Set<String> metron_f2760_0()
{    return sensors;}
public void metron_f2761_0(Set<String> sensors)
{    this.sensors = sensors;}
public boolean metron_f2762_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    SensorParserGroup that = (SensorParserGroup) o;    return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(sensors, that.sensors);}
public int metron_f2763_0()
{    return Objects.hash(name, description, sensors);}
public String metron_f2764_0()
{    return "SensorParserGroup{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", sensors=" + sensors + '}';}
public WriterConfiguration metron_f2765_0(BulkMessageWriter writer, Configurations configs)
{    return strategy.createWriterConfig(writer, configs);}
public ConfigurationsUpdater metron_f2766_0(Reloadable reloadable, Supplier configSupplier)
{    return strategy.createUpdater(reloadable, configSupplier);}
public WriterConfiguration metron_f2767_0(BulkMessageWriter writer, Configurations configs)
{    if (configs instanceof ParserConfigurations) {        return new ParserWriterConfiguration((ParserConfigurations) configs);    } else {        throw new IllegalArgumentException("Expected config of type ParserConfigurations but found " + configs.getClass());    }}
public ConfigurationsUpdater<ParserConfigurations> metron_f2768_0(Reloadable reloadable, Supplier configSupplier)
{    return new ParserUpdater(reloadable, configSupplier);}
public WriterConfiguration metron_f2769_0(BulkMessageWriter writer, Configurations configs)
{    if (configs instanceof EnrichmentConfigurations) {        return new EnrichmentWriterConfiguration((EnrichmentConfigurations) configs);    } else {        throw new IllegalArgumentException("Expected config of type EnrichmentConfigurations but found " + configs.getClass());    }}
public ConfigurationsUpdater<EnrichmentConfigurations> metron_f2770_0(Reloadable reloadable, Supplier configSupplier)
{    return new EnrichmentUpdater(reloadable, configSupplier);}
public WriterConfiguration metron_f2771_0(BulkMessageWriter writer, Configurations configs)
{    if (configs instanceof IndexingConfigurations) {        return new IndexingWriterConfiguration(writer.getName(), (IndexingConfigurations) configs);    } else {        throw new IllegalArgumentException("Expected config of type IndexingConfigurations but found " + configs.getClass());    }}
public ConfigurationsUpdater<IndexingConfigurations> metron_f2772_0(Reloadable reloadable, Supplier configSupplier)
{    return new IndexingUpdater(reloadable, configSupplier);}
public WriterConfiguration metron_f2773_0(BulkMessageWriter writer, Configurations configs)
{    if (configs instanceof ProfilerConfigurations) {        return new ProfilerWriterConfiguration((ProfilerConfigurations) configs);    } else {        throw new IllegalArgumentException("Expected config of type IndexingConfigurations but found " + configs.getClass());    }}
public ConfigurationsUpdater metron_f2774_0(Reloadable reloadable, Supplier configSupplier)
{    return new ProfilerUpdater(reloadable, configSupplier);}
public int metron_f2775_0(String sensorName)
{    return config.orElse(new EnrichmentConfigurations()).getBatchSize();}
public int metron_f2776_0(String sensorName)
{    return config.orElse(new EnrichmentConfigurations()).getBatchTimeout();}
public List<Integer> metron_f2777_0()
{    return asList(getBatchTimeout(null));}
public String metron_f2778_0(String sensorName)
{    return null;}
public boolean metron_f2779_0(String sensorName)
{    return true;}
public Map<String, Object> metron_f2780_0(String sensorName)
{    return config.orElse(new EnrichmentConfigurations()).getSensorEnrichmentConfig(sensorName).getConfiguration();}
public Map<String, Object> metron_f2781_0()
{    return config.orElse(new EnrichmentConfigurations()).getGlobalConfig();}
public boolean metron_f2782_0(String sensorName)
{    return false;}
public String metron_f2783_0(String sensorName)
{        return null;}
public int metron_f2784_0(String sensorName)
{    return config.orElse(new IndexingConfigurations()).getBatchSize(sensorName, writerName);}
public int metron_f2785_0(String sensorName)
{    return config.orElse(new IndexingConfigurations()).getBatchTimeout(sensorName, writerName);}
public List<Integer> metron_f2786_0()
{    return config.orElse(new IndexingConfigurations()).getAllConfiguredTimeouts(writerName);}
public String metron_f2787_0(String sensorName)
{    return config.orElse(new IndexingConfigurations()).getIndex(sensorName, writerName);}
public boolean metron_f2788_0(String sensorName)
{    return config.orElse(new IndexingConfigurations()).isEnabled(sensorName, writerName);}
public Map<String, Object> metron_f2789_0(String sensorName)
{    return config.orElse(new IndexingConfigurations()).getSensorIndexingConfig(sensorName, writerName);}
public Map<String, Object> metron_f2790_0()
{    return config.orElse(new IndexingConfigurations()).getGlobalConfig();}
public boolean metron_f2791_0(String sensorName)
{    return config.orElse(new IndexingConfigurations()).isDefault(sensorName, writerName);}
public String metron_f2792_0(String sensorName)
{    return config.orElse(new IndexingConfigurations()).getFieldNameConverter(sensorName, writerName);}
public boolean metron_f2793_0(String sensorName)
{    return config.orElse(new IndexingConfigurations()).isSetDocumentId(sensorName, writerName);}
public int metron_f2794_0(String sensorName)
{    if (config != null && config.getSensorParserConfig(sensorName) != null && config.getSensorParserConfig(sensorName).getParserConfig() != null) {        Object batchObj = config.getSensorParserConfig(sensorName).getParserConfig().get(IndexingConfigurations.BATCH_SIZE_CONF);        return batchObj == null ? ParserConfigurations.DEFAULT_KAFKA_BATCH_SIZE : ConversionUtils.convert(batchObj, Integer.class);    }    return 1;}
public int metron_f2795_0(String sensorName)
{    if (config != null && config.getSensorParserConfig(sensorName) != null && config.getSensorParserConfig(sensorName).getParserConfig() != null) {        Object batchObj = config.getSensorParserConfig(sensorName).getParserConfig().get(IndexingConfigurations.BATCH_TIMEOUT_CONF);        return batchObj == null ? 0 : ConversionUtils.convert(batchObj, Integer.class);    }    return 0;}
public List<Integer> metron_f2796_0()
{        return new ArrayList<Integer>();}
public String metron_f2797_0(String sensorName)
{    if (config != null && config.getSensorParserConfig(sensorName) != null && config.getSensorParserConfig(sensorName).getParserConfig() != null) {        Object indexObj = config.getSensorParserConfig(sensorName).getParserConfig().get(IndexingConfigurations.INDEX_CONF);        if (indexObj != null) {            return indexObj.toString();        }        return null;    }    return sensorName;}
public boolean metron_f2798_0(String sensorName)
{    if (config != null && config.getSensorParserConfig(sensorName) != null && config.getSensorParserConfig(sensorName).getParserConfig() != null) {        Object enabledObj = config.getSensorParserConfig(sensorName).getParserConfig().get(IndexingConfigurations.ENABLED_CONF);        return enabledObj == null ? true : ConversionUtils.convert(enabledObj, Boolean.class);    }    return true;}
public Map<String, Object> metron_f2799_0(String sensorName)
{    return config.getSensorParserConfig(sensorName).getParserConfig();}
public Map<String, Object> metron_f2800_0()
{    return config.getGlobalConfig();}
public boolean metron_f2801_0(String sensorName)
{    return false;}
public String metron_f2802_0(String sensorName)
{        return null;}
public int metron_f2803_0(String sensorName)
{    return config.orElse(new ProfilerConfigurations()).getBatchSize();}
public int metron_f2804_0(String sensorName)
{    return config.orElse(new ProfilerConfigurations()).getBatchTimeout();}
public List<Integer> metron_f2805_0()
{    return asList(getBatchTimeout(null));}
public String metron_f2806_0(String sensorName)
{    return null;}
public boolean metron_f2807_0(String sensorName)
{    return true;}
public Map<String, Object> metron_f2808_0(String sensorName)
{    throw new UnsupportedOperationException("Profiler does not have sensor configs");}
public Map<String, Object> metron_f2809_0()
{    return config.orElse(new ProfilerConfigurations()).getGlobalConfig();}
public boolean metron_f2810_0(String sensorName)
{    return false;}
public String metron_f2811_0(String sensorName)
{        return null;}
public int metron_f2812_0(String sensorName)
{    return 1;}
public int metron_f2813_0(String sensorName)
{    return 0;}
public List<Integer> metron_f2814_0()
{        return new ArrayList<Integer>();}
public String metron_f2815_0(String sensorName)
{    return config.getIndex(sensorName);}
public boolean metron_f2816_0(String sensorName)
{    return true;}
public Map<String, Object> metron_f2817_0(String sensorName)
{    return config.getSensorConfig(sensorName);}
public Map<String, Object> metron_f2818_0()
{    return config.getGlobalConfig();}
public boolean metron_f2819_0(String sensorName)
{    return false;}
public String metron_f2820_0(String sensorName)
{        return null;}
 boolean metron_f2821_0(String sensorName)
{    return false;}
public String metron_f2822_0()
{    return name;}
public static Fields metron_f2823_0(String fieldName)
{    return nameToField.get(fieldName);}
public String metron_f2824_0()
{    return name;}
public String metron_f2825_0()
{    return type;}
public Map<String, Integer> metron_f2826_0()
{    return columnMap;}
public CSVParser metron_f2827_0()
{    return parser;}
public Map<String, String> metron_f2828_0(String line) throws IOException
{    if (ignore(line)) {        return null;    }    String[] tokens = parser.parseLine(line);    Map<String, String> values = new HashMap<>();    for (Map.Entry<String, Integer> kv : columnMap.entrySet()) {        values.put(kv.getKey().trim(), tokens[kv.getValue()].trim());    }    return values;}
public void metron_f2829_0(Map<String, Object> config)
{    if (config.containsKey(COLUMNS_KEY)) {        columnMap = getColumnMap(config);    } else {        throw new IllegalStateException("CSVExtractor requires " + COLUMNS_KEY + " configuration");    }    char separator = ',';    if (config.containsKey(SEPARATOR_KEY)) {        separator = config.get(SEPARATOR_KEY).toString().charAt(0);    }    parser = new CSVParserBuilder().withSeparator(separator).build();}
protected boolean metron_f2830_0(String line)
{    if (null == line) {        return true;    }    String trimmedLine = line.trim();    return trimmedLine.startsWith("#") || isEmpty(trimmedLine);}
public static Map.Entry<String, Integer> metron_f2831_0(String column, int i)
{    if (column.contains(":")) {        Iterable<String> tokens = Splitter.on(':').split(column);        String col = Iterables.getFirst(tokens, null);        Integer pos = Integer.parseInt(Iterables.getLast(tokens));        return new AbstractMap.SimpleEntry<>(col, pos);    } else {        return new AbstractMap.SimpleEntry<>(column, i);    }}
public static Map<String, Integer> metron_f2832_0(Map<String, Object> config)
{    Map<String, Integer> columnMap = new HashMap<>();    if (config.containsKey(COLUMNS_KEY)) {        Object columnsObj = config.get(COLUMNS_KEY);        if (columnsObj instanceof String) {            String columns = (String) columnsObj;            int i = 0;            for (String column : Splitter.on(',').split(columns)) {                Map.Entry<String, Integer> e = getColumnMapEntry(column, i++);                columnMap.put(e.getKey(), e.getValue());            }        } else if (columnsObj instanceof List) {            List columns = (List) columnsObj;            int i = 0;            for (Object column : columns) {                Map.Entry<String, Integer> e = getColumnMapEntry(column.toString(), i++);                columnMap.put(e.getKey(), e.getValue());            }        } else if (columnsObj instanceof Map) {            Map<Object, Object> map = (Map<Object, Object>) columnsObj;            for (Map.Entry<Object, Object> e : map.entrySet()) {                columnMap.put(e.getKey().toString(), Integer.parseInt(e.getValue().toString()));            }        }    }    return columnMap;}
public MetronError metron_f2833_0(String message)
{    this.message = message;    return this;}
public MetronError metron_f2834_0(Throwable throwable)
{    this.throwable = throwable;    return this;}
public MetronError metron_f2835_0(Set<String> sensorTypes)
{    this.sensorTypes = sensorTypes;    return this;}
public MetronError metron_f2836_0(ErrorType errorType)
{    this.errorType = errorType;    return this;}
public MetronError metron_f2837_0(Set<String> errorFields)
{    this.errorFields = errorFields;    return this;}
public MetronError metron_f2838_0(Map<String, Object> metadata)
{    this.metadata.putAll(metadata);    return this;}
public MetronError metron_f2839_0(Object rawMessage)
{    if (rawMessage != null) {        if (this.rawMessages == null) {            this.rawMessages = new ArrayList<>();        }        this.rawMessages.add(rawMessage);    }    return this;}
public MetronError metron_f2840_0(List<Object> rawMessages)
{    this.rawMessages = rawMessages;    return this;}
public Optional<Throwable> metron_f2841_0()
{    return throwable != null ? Optional.of(throwable) : Optional.empty();}
public List<Object> metron_f2842_0()
{    return rawMessages;}
public JSONObject metron_f2843_0()
{    JSONObject errorMessage = new JSONObject();    errorMessage.put(Constants.GUID, UUID.randomUUID().toString());    errorMessage.put(Constants.SENSOR_TYPE, Constants.ERROR_TYPE);    errorMessage.put(ErrorFields.ERROR_TYPE.getName(), errorType.getType());    addFailedSensorType(errorMessage);    addMessageString(errorMessage);    addStacktrace(errorMessage);    addTimestamp(errorMessage);    addHostname(errorMessage);    addRawMessages(errorMessage);    addErrorHash(errorMessage);    addMetadata(errorMessage);    return errorMessage;}
private void metron_f2844_0(JSONObject errorMessage)
{    if (sensorTypes.size() == 1) {        errorMessage.put(ErrorFields.FAILED_SENSOR_TYPE.getName(), sensorTypes.iterator().next());    } else {        errorMessage.put(ErrorFields.FAILED_SENSOR_TYPE.getName(), new JSONArray().addAll(sensorTypes));    }}
private void metron_f2845_0(JSONObject errorMessage)
{    if (message != null) {        errorMessage.put(ErrorFields.MESSAGE.getName(), message);    } else if (throwable != null) {        errorMessage.put(ErrorFields.MESSAGE.getName(), throwable.getMessage());    }}
private void metron_f2846_0(JSONObject errorMessage)
{    if (throwable != null) {        String stackTrace = ExceptionUtils.getStackTrace(throwable);        String exception = throwable.toString();        errorMessage.put(ErrorFields.EXCEPTION.getName(), exception);        errorMessage.put(ErrorFields.STACK.getName(), stackTrace);    }}
private void metron_f2847_0(JSONObject errorMessage)
{    errorMessage.put(ErrorFields.TIMESTAMP.getName(), System.currentTimeMillis());}
private void metron_f2848_0(JSONObject errorMessage)
{    try {        errorMessage.put(ErrorFields.HOSTNAME.getName(), InetAddress.getLocalHost().getHostName());    } catch (UnknownHostException ex) {        }}
private void metron_f2849_0(JSONObject errorMessage)
{    if (rawMessages != null) {        for (int i = 0; i < rawMessages.size(); i++) {            Object rawMessage = rawMessages.get(i);                        String rawMessageField = rawMessages.size() == 1 ? ErrorFields.RAW_MESSAGE.getName() : ErrorFields.RAW_MESSAGE.getName() + "_" + i;                        if (rawMessage instanceof byte[]) {                errorMessage.put(rawMessageField, new String((byte[]) rawMessage, UTF_8));                        } else if (rawMessage instanceof JSONObject) {                JSONObject rawMessageJSON = (JSONObject) rawMessage;                String rawMessageJSONString = rawMessageJSON.toJSONString();                errorMessage.put(rawMessageField, rawMessageJSONString);                        } else {                errorMessage.put(rawMessageField, rawMessage.toString());                        }        }    }}
private void metron_f2850_0(JSONObject errorMessage)
{    if (rawMessages != null && rawMessages.size() == 1) {        Object rawMessage = rawMessages.get(0);        if (rawMessage instanceof JSONObject) {            JSONObject rawJSON = (JSONObject) rawMessage;            if (errorFields != null) {                errorMessage.put(ErrorFields.ERROR_FIELDS.getName(), String.join(",", errorFields));                errorMessage.put(ErrorFields.ERROR_HASH.getName(), HashUtils.getMessageHash(rawJSON, errorFields));            } else {                errorMessage.put(ErrorFields.ERROR_HASH.getName(), HashUtils.getMessageHash(rawJSON));            }        } else if (rawMessage instanceof byte[]) {            errorMessage.put(ErrorFields.ERROR_HASH.getName(), HashUtils.getMessageHash((byte[]) rawMessage));        } else {            errorMessage.put(ErrorFields.ERROR_HASH.getName(), HashUtils.getMessageHash(rawMessage.toString().getBytes(UTF_8)));        }    }}
private void metron_f2851_0(JSONObject errorMessage)
{    if (metadata != null && metadata.keySet().size() > 0) {                                errorMessage.putAll(metadata);    }}
public boolean metron_f2852_0(Object o)
{    if (this == o)        return true;    if (!(o instanceof MetronError))        return false;    MetronError that = (MetronError) o;    return Objects.equals(message, that.message) && Objects.equals(throwable, that.throwable) && Objects.equals(sensorTypes, that.sensorTypes) && errorType == that.errorType && Objects.equals(errorFields, that.errorFields) && Objects.equals(rawMessages, that.rawMessages) && Objects.equals(metadata, that.metadata);}
public int metron_f2853_0()
{    return Objects.hash(message, throwable, sensorTypes, errorType, errorFields, rawMessages, metadata);}
public FieldNameConverter metron_f2855_0()
{    return converter;}
public String metron_f2856_0(String originalField)
{    return converter.convert(originalField);}
public String metron_f2858_0(String originalField)
{        return originalField;}
public static FieldTransformation metron_f2859_0(String mapping)
{    try {        return FieldTransformations.valueOf(mapping).mapping;    } catch (Exception ex) {        return ReflectionUtils.createInstance(mapping);    }}
public Class<? extends FieldTransformation> metron_f2860_0()
{    return mapping.getClass();}
public Map<String, Object> metron_f2861_0(Object value, String outputField)
{    Map<String, Object> ret = new HashMap<>();    if (value != null && value instanceof Number) {        int protocolNum = ((Number) value).intValue();        ret.put(outputField, PROTOCOLS.get(protocolNum));    }    return ret;}
public Object metron_f2862_0(List<Object> objects, Context context) throws ParseException
{    Object keyObj = objects.get(0);    if (keyObj == null) {        return keyObj;    }    Integer key = ConversionUtils.convert(keyObj, Integer.class);    if (key == null) {        return keyObj;    }    Object ret = PROTOCOLS.get(key);    if (ret == null) {        return keyObj;    }    return ret;}
public boolean metron_f2864_0()
{    return true;}
public Map<String, Object> metron_f2865_0(Map<String, Object> input, List<String> outputField, LinkedHashMap<String, Object> fieldMappingConfig, Context context, Map<String, Object>... sensorConfig)
{    String outField = null;    if (!(outputField == null || outputField.isEmpty())) {        outField = outputField.get(0);    }    String inVal = null;    if (!(input == null || input.isEmpty() || input.size() > 1)) {        Object inValObj = Iterables.getFirst(input.entrySet(), null).getValue();        if (inValObj != null) {            inVal = inValObj.toString();        }    }    Map<String, Object> ret = new HashMap<>(1);    if (outField == null || inVal == null) {                return ret;    }    for (Map.Entry<String, Object> valToRegex : fieldMappingConfig.entrySet()) {        if (isMatch(valToRegex.getValue(), inVal)) {            ret.put(outField, valToRegex.getKey());            break;        }    }    return ret;}
private static boolean metron_f2866_0(Object regexes, String field)
{    if (regexes instanceof String) {        return isMatch((String) regexes, field);    } else if (regexes instanceof List) {        for (Object regex : (List) regexes) {            if (isMatch(regex.toString(), field)) {                return true;            }        }    }    return false;}
private static boolean metron_f2867_0(String regex, String field)
{    try {        Pattern p = PatternCache.INSTANCE.getPattern(regex);        if (p == null) {            return false;        }        return p.asPredicate().test(field);    } catch (PatternSyntaxException pse) {        return false;    }}
public Boolean metron_f2868_0(String rule, VariableResolver resolver, FunctionResolver functionResolver, Context context)
{    return true;}
public boolean metron_f2869_0(String rule) throws ParseException
{    return true;}
public boolean metron_f2870_0(String rule, boolean throwException, Context context) throws ParseException
{    return true;}
private String metron_f2871_0(Map<String, Object> fieldMappingConfig)
{    Object conditionObj = fieldMappingConfig.get(CONDITION_CONF);    if (conditionObj == null || !(conditionObj instanceof String)) {        return null;    }    return conditionObj.toString();}
private StellarPredicateProcessor metron_f2872_0(String condition)
{    if (condition == null) {        return PASSTHROUGH_PROCESSOR;    } else {        return new StellarPredicateProcessor();    }}
public Map<String, Object> metron_f2873_0(Map<String, Object> input, final List<String> outputFields, LinkedHashMap<String, Object> fieldMappingConfig, Context context, Map<String, Object>... sensorConfig)
{    String condition = getCondition(fieldMappingConfig);    StellarPredicateProcessor processor = getPredicateProcessor(condition);    if (processor.parse(condition, new MapVariableResolver(input), StellarFunctions.FUNCTION_RESOLVER(), context)) {        return new HashMap<String, Object>() {            {                for (String outputField : outputFields) {                    put(outputField, null);                }            }        };    }    return null;}
public Map<String, Object> metron_f2874_0(Map<String, Object> input, List<String> outputField, LinkedHashMap<String, Object> fieldMappingConfig, Context context, Map<String, Object>... sensorConfig)
{    if (fieldMappingConfig == null || fieldMappingConfig.isEmpty()) {        return input;    }    Map<String, Object> ret = new HashMap<>();    for (Map.Entry<String, Object> kv : input.entrySet()) {        Object renamed = fieldMappingConfig.get(kv.getKey());        if (renamed != null) {                        ret.put(renamed.toString(), kv.getValue());                        ret.put(kv.getKey(), null);        } else {            ret.put(kv.getKey(), kv.getValue());        }    }    return ret;}
public Map<String, Object> metron_f2875_0(Map<String, Object> input, List<String> outputField, LinkedHashMap<String, Object> fieldMappingConfig, Context context, Map<String, Object>... sensorConfig)
{                        HashMap<String, Object> output = new HashMap<String, Object>();    for (Entry<String, Object> e : input.entrySet()) {        if (outputField.contains(e.getKey())) {            output.put(e.getKey(), e.getValue());        } else {            if (!systemFields.contains(e.getKey())) {                output.put(e.getKey(), null);            }        }    }    return output;}
public Map<String, Object> metron_f2876_0(Map<String, Object> input, List<String> outputField, LinkedHashMap<String, Object> fieldMappingConfig, Context context, Map<String, Object>... sensorConfig)
{    Object value = (input == null) ? null : Iterables.getFirst(input.values(), null);    return map(value, outputField.get(0));}
public Map<String, Object> metron_f2877_0(Map<String, Object> input, List<String> outputField, LinkedHashMap<String, Object> fieldMappingConfig, Context context, Map<String, Object>... sensorConfig)
{    Map<String, Object> ret = new HashMap<>();    Map<String, Object> intermediateVariables = new HashMap<>();    Set<String> outputs = new HashSet<>(outputField);    MapVariableResolver resolver = new MapVariableResolver(ret, intermediateVariables, input);    resolver.add(sensorConfig);    StellarProcessor processor = new CachingStellarProcessor();    for (Map.Entry<String, Object> kv : fieldMappingConfig.entrySet()) {        String oField = kv.getKey();        Object transformObj = kv.getValue();        if (transformObj != null) {            try {                Object o = processor.parse(transformObj.toString(), resolver, StellarFunctions.FUNCTION_RESOLVER(), context);                if (o != null) {                    if (outputs.contains(oField)) {                        ret.put(oField, o);                    } else {                        intermediateVariables.put(oField, o);                    }                } else {                    if (outputs.contains(oField)) {                        ret.put(oField, o);                    }                    if (o != null) {                        intermediateVariables.put(oField, o);                    } else {                                                intermediateVariables.remove(oField);                    }                }            } catch (Exception ex) {                throw new IllegalStateException("Unable to process transformation: " + transformObj.toString() + " for " + oField + " because " + ex.getMessage(), ex);            }        }    }    return ret;}
public static FieldValidation metron_f2878_0(String validation)
{    try {        return FieldValidations.valueOf(validation).validation;    } catch (Exception ex) {        return ReflectionUtils.createInstance(validation);    }}
public Predicate<Object> metron_f2879_0()
{    return domain -> DomainValidator.getInstance().isValid(domain == null ? null : domain.toString());}
public Predicate<Object> metron_f2880_0()
{    return email -> EmailValidator.getInstance().isValid(email == null ? null : email.toString());}
public boolean metron_f2881_0(String ip)
{    return validationPredicate.test(ip);}
public static IPType metron_f2882_0(String type)
{    if (type == null) {        return DEFAULT;    } else {        try {            return IPType.valueOf(type);        } catch (Exception e) {            return DEFAULT;        }    }}
public List metron_f2883_0(Map<String, Object> config)
{    Object o = config.get(key);    if (o == null) {        return Collections.singletonList("DEFAULT");    }    if (o instanceof ArrayList) {        return (ArrayList) o;    }    return Collections.singletonList(o);}
public boolean metron_f2884_0(List<Object> strings)
{    IPType type = IPType.DEFAULT;    if (strings.isEmpty()) {        return false;    }    Object ip = strings.get(0);    if (ip == null) {        return false;    }    if (strings.size() >= 2) {        Object ipType = strings.get(1);        if (ipType != null) {            try {                type = IPType.get(ipType.toString());            } catch (Exception e) {                type = IPType.DEFAULT;            }        }    }    return type.isValid(ip.toString());}
public boolean metron_f2885_0(Map<String, Object> input, Map<String, Object> validationConfig, Map<String, Object> globalConfig, Context context)
{    List types = Config.TYPE.get(validationConfig);    for (Object typeObject : types) {        IPType type = IPType.get(typeObject.toString());        for (Object o : input.values()) {            if (o == null || type.isValid(o.toString())) {                return true;            }        }    }    return false;}
public Predicate<Object> metron_f2887_0()
{    return url -> UrlValidator.getInstance().isValid(url == null ? null : url.toString());}
public boolean metron_f2888_0(List<Object> strings)
{    if (strings.isEmpty()) {        return false;    }    if (strings.size() >= 2) {        Object date = strings.get(0);        Object format = strings.get(1);        if (date == null || format == null) {            return false;        }        try {            SimpleDateFormat sdf = new SimpleDateFormat(format.toString());            sdf.setLenient(false);            sdf.parse(date.toString());            return true;        } catch (ParseException pe) {            return false;        }    } else {        return false;    }}
public T metron_f2889_0(Map<String, Object> config, Class<T> clazz)
{    Object o = config.get(key);    if (o == null) {        return null;    }    return clazz.cast(o);}
public boolean metron_f2890_0(Map<String, Object> input, Map<String, Object> validationConfig, Map<String, Object> globalConfig, Context context)
{    String format = Config.FORMAT.get(validationConfig, String.class);    if (format == null) {        return false;    }    SimpleDateFormat sdf = new SimpleDateFormat(format);    sdf.setLenient(false);    for (Object o : input.values()) {        if (o == null) {            return true;        }        try {            Date d = sdf.parse(o.toString());        } catch (ParseException e) {            return false;        }    }    return true;}
public void metron_f2891_0(Map<String, Object> validationConfig, Map<String, Object> globalConfig)
{    String format = Config.FORMAT.get(validationConfig, String.class);    if (format == null) {        throw new IllegalStateException("You must specify '" + Config.FORMAT.key + "' in the config");    }    SimpleDateFormat sdf = new SimpleDateFormat(format);    sdf.setLenient(false);    try {        sdf.format(new Date());    } catch (Exception e) {        throw new IllegalStateException("Invalid date format: " + format, e);    }}
public Predicate<Object> metron_f2892_0()
{    return x -> LongValidator.getInstance().isValid(x == null ? null : x.toString());}
public Predicate<Object> metron_f2893_0()
{    return s -> !(s == null || s.toString().trim().isEmpty());}
protected boolean metron_f2894_0()
{    return false;}
public T metron_f2895_0(Map<String, Object> config, Class<T> clazz)
{    Object o = config.get(key);    if (o == null) {        return null;    }    return clazz.cast(o);}
public boolean metron_f2896_0(Map<String, Object> input, Map<String, Object> validationConfig, Map<String, Object> globalConfig, Context context)
{    String regex = Config.REGEX.get(validationConfig, String.class);    if (regex == null) {        return false;    }    for (Object o : input.values()) {        if (o != null && !o.toString().matches(regex)) {            return false;        }    }    return true;}
public void metron_f2897_0(Map<String, Object> validationConfig, Map<String, Object> globalConfig)
{    String regex = Config.REGEX.get(validationConfig, String.class);    if (regex == null) {        throw new IllegalStateException("You must specify '" + Config.REGEX.key + "' in the config");    }}
public T metron_f2898_0(Map<String, Object> config, Class<T> clazz)
{    Object o = config.get(key);    if (o == null) {        return null;    }    return clazz.cast(o);}
public boolean metron_f2899_0(Map<String, Object> input, Map<String, Object> validationConfig, Map<String, Object> globalConfig, Context context)
{    String condition = Config.CONDITION.get(validationConfig, String.class);    if (condition == null) {        return true;    } else {        StellarPredicateProcessor processor = new StellarPredicateProcessor();        return processor.parse(condition, new MapVariableResolver(input, validationConfig, globalConfig), StellarFunctions.FUNCTION_RESOLVER(), context);    }}
public void metron_f2900_0(Map<String, Object> validationConfig, Map<String, Object> globalConfig)
{    String condition = Config.CONDITION.get(validationConfig, String.class);    if (condition == null) {        throw new IllegalStateException("You must specify a condition.");    }    try {        new StellarPredicateProcessor().validate(condition);    } catch (Exception e) {        throw new IllegalStateException("Invalid condition: " + condition, e);    }}
public boolean metron_f2901_0(Map<String, Object> input, Map<String, Object> validationConfig, Map<String, Object> globalConfig, Context context)
{    Predicate<Object> predicate = getPredicate();    if (isNonExistentOk()) {        for (Object o : input.values()) {            if (o != null && !predicate.test(o.toString())) {                return false;            }        }    } else {        for (Object o : input.values()) {            if (o == null || !predicate.test(o.toString())) {                return false;            }        }    }    return true;}
public boolean metron_f2902_0(List<Object> input)
{    if (input.isEmpty()) {        return false;    }    Predicate<Object> predicate = getPredicate();    for (Object o : input) {        if (o == null || !predicate.test(o)) {            return false;        }    }    return true;}
protected boolean metron_f2904_0()
{    return true;}
public Iterator<byte[]> metron_f2905_0()
{    return Iterators.concat(getIterators(files, config));}
private Iterator<byte[]>[] metron_f2906_0(List<Path> files, Configuration config)
{    return files.stream().map(f -> new SequenceFileIterator(f, config)).toArray(Iterator[]::new);}
public boolean metron_f2907_0() throws IOException
{    FileSystem fileSystem = FileSystem.get(config);    boolean success = true;    for (Path file : files) {        success &= fileSystem.delete(file, false);    }    return success;}
public boolean metron_f2908_1()
{    if (!finished && null == reader) {        try {            reader = new SequenceFile.Reader(config, SequenceFile.Reader.file(path));                    } catch (IOException e) {            throw new RuntimeException("Failed to get reader", e);        }    } else {            }    try {                if (!finished) {            if (null == next && reader.next(key, value)) {                next = value.copyBytes();            } else if (null == next) {                close();            }        }    } catch (IOException e) {        close();        throw new RuntimeException("Failed to get next record", e);    }    return (null != next);}
private void metron_f2909_1()
{        finished = true;    try {        if (reader != null) {            reader.close();            reader = null;        }    } catch (IOException e) {                    }}
public byte[] metron_f2910_0()
{    byte[] ret = null;    if (hasNext()) {        ret = next;                next = null;    } else {        throw new NoSuchElementException("No more records");    }    return ret;}
public RawMessage metron_f2911_0(Map<String, Object> rawMetadata, byte[] rawMessage, boolean readMetadata, Map<String, Object> config)
{    return new RawMessage(rawMessage, rawMetadata);}
public void metron_f2912_0(JSONObject message, Map<String, Object> metadata, boolean mergeMetadata, Map<String, Object> config)
{    if (mergeMetadata) {        message.putAll(metadata);    }}
public boolean metron_f2913_0()
{    return false;}
public boolean metron_f2914_0()
{    return false;}
public void metron_f2916_0(JSONObject message, Map<String, Object> metadata, boolean mergeMetadata, Map<String, Object> config)
{        String prefix = MetadataUtil.INSTANCE.getMetadataPrefix(config);    String originalStringFromMetadata = (String) metadata.get(MetadataUtil.INSTANCE.prefixKey(prefix, Constants.Fields.ORIGINAL.getName()));    if (mergeMetadata) {        for (Map.Entry<String, Object> kv : metadata.entrySet()) {                        message.putIfAbsent(kv.getKey(), kv.getValue());        }    }    if (originalStringFromMetadata != null) {        message.put(Constants.Fields.ORIGINAL.getName(), originalStringFromMetadata);    }}
public boolean metron_f2917_0()
{    return true;}
public boolean metron_f2918_0()
{    return true;}
public String metron_f2919_0(Map<String, Object> config)
{    String prefix = (String) config.getOrDefault(METADATA_PREFIX_CONFIG, METADATA_PREFIX);    if (StringUtils.isEmpty(prefix)) {        return null;    }    return prefix;}
public String metron_f2920_0(String prefix, String key)
{    if (StringUtils.isEmpty(prefix)) {        return key;    } else {        return prefix + "." + key;    }}
public byte[] metron_f2921_0()
{    return message;}
public void metron_f2922_0(byte[] message)
{    this.message = message;}
public Map<String, Object> metron_f2923_0()
{    return metadata;}
public void metron_f2924_0(Map<String, Object> metadata)
{    this.metadata = metadata;}
public String metron_f2925_0()
{    return "RawMessage{" + "message=" + Arrays.toString(message) + ", metadata=" + metadata + '}';}
public boolean metron_f2926_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    RawMessage that = (RawMessage) o;    if (!Arrays.equals(getMessage(), that.getMessage()))        return false;    return getMetadata() != null ? getMetadata().equals(that.getMetadata()) : that.getMetadata() == null;}
public int metron_f2927_0()
{    int result = Arrays.hashCode(getMessage());    result = 31 * result + (getMetadata() != null ? getMetadata().hashCode() : 0);    return result;}
public RawMessage metron_f2928_0(Map<String, Object> rawMetadata, byte[] originalMessage, boolean readMetadata, Map<String, Object> config)
{    return this.supplier.get(rawMetadata, originalMessage, readMetadata, config);}
public void metron_f2929_0(JSONObject message, Map<String, Object> metadata, boolean mergeMetadata, Map<String, Object> config)
{    this.supplier.mergeMetadata(message, metadata, mergeMetadata, config);}
public boolean metron_f2930_0()
{    return this.supplier.mergeMetadataDefault();}
public boolean metron_f2931_0()
{    return this.supplier.readMetadataDefault();}
public void metron_f2932_0(String markName)
{    timing.mark(markName);}
public void metron_f2933_0(String markName)
{    if (okToLog()) {        log(markName, "");    }}
public void metron_f2934_1(String markName, String message)
{    if (okToLog()) {        if (timing.exists(markName)) {                    } else {                    }    }}
private boolean metron_f2935_0()
{    return logger.isDebugEnabled() && thresholdCalc.isPast(getPercentThreshold());}
private Integer metron_f2936_0()
{    return ConversionUtils.convert(getProperty(LOG_PERCENT, LOG_PERCENT_DEFAULT), Integer.class);}
private Object metron_f2937_0(String key, Object defaultValue)
{    return configSupplier.get().getOrDefault(key, defaultValue);}
public void metron_f2938_0(String markName, String format, Object arg)
{    if (okToLog()) {        FormattingTuple formattedMessage = MessageFormatter.format(format, arg);        log(markName, formattedMessage.getMessage());    }}
public void metron_f2939_0(String markName, String format, Object arg1, Object arg2)
{    if (okToLog()) {        FormattingTuple formattedMessage = MessageFormatter.format(format, arg1, arg2);        log(markName, formattedMessage.getMessage());    }}
public void metron_f2940_0(String markName, String format, Object... arguments)
{    if (okToLog()) {        FormattingTuple formattedMessage = MessageFormatter.arrayFormat(format, arguments);        log(markName, formattedMessage.getMessage());    }}
public boolean metron_f2941_0()
{    return logger.isDebugEnabled();}
public boolean metron_f2942_0(int percent)
{    double rd = Math.random();    if (rd <= toDecimal(percent)) {        return true;    }    return false;}
private double metron_f2943_0(int percent)
{    return percent / 100.0;}
public void metron_f2944_0(String name)
{    startTimes.put(name, System.nanoTime());}
public long metron_f2945_0(String name)
{    if (startTimes.containsKey(name)) {        return System.nanoTime() - startTimes.get(name);    } else {        return 0;    }}
public boolean metron_f2946_0(String name)
{    return startTimes.containsKey(name);}
public long metron_f2947_0()
{    return System.currentTimeMillis();}
public String metron_f2948_0(String stdDateFormat)
{    SimpleDateFormat format = new SimpleDateFormat(stdDateFormat);    format.setTimeZone(TimeZone.getTimeZone(UTC));    return format.format(new Date(currentTimeMillis()));}
public String metron_f2949_0(String variable)
{    return System.getenv().get(variable);}
public long metron_f2950_0()
{    return now_ms;}
public void metron_f2951_0(long duration_ms)
{    long instant_ms = now_ms + duration_ms;    if (duration_ms < 0) {        throw new IllegalArgumentClockNegative(String.format("Attempted to move backward in time, by %d milliseconds.", duration_ms));    } else if (instant_ms < 0) {        throw new IllegalArgumentClockOverflow(String.format("Attempted to advance beyond the edge of time, to epoch %d + %d.", now_ms, duration_ms));    }    now_ms = instant_ms;}
public void metron_f2952_0(long duration_secs)
{    elapseMillis(TimeUnit.SECONDS.toMillis(duration_secs));}
public void metron_f2953_0(long instant_ms)
{    if (instant_ms < now_ms) {        throw new IllegalArgumentClockNegative(String.format("Attempted to move backward in time, from epoch %d to %d.", now_ms, instant_ms));    }    if (instant_ms == now_ms) {        throw new IllegalArgumentClockZero(String.format("Time was set to current time, with null advance, at epoch %d.", now_ms));    }    now_ms = instant_ms;}
public void metron_f2954_0(long instant_secs)
{    advanceToMillis(TimeUnit.SECONDS.toMillis(instant_secs));}
public Set<String> metron_f2955_0(String domain)
{    Set<String> ret = new HashSet<>();    for (int i = 97; i < 123; ++i) {        char c = Character.toChars(i)[0];        ret.add(domain + c);    }    return ret;}
public String metron_f2956_0()
{    return "Addition";}
public Set<String> metron_f2957_0(String originalString)
{    Set<String> ret = new HashSet<>();    char[] str = originalString.toCharArray();    for (int i = 0; i < str.length; ++i) {        char c = str[i];        for (int j : MASK) {            int maskedNum = (int) c ^ j;            char maskedChar = (char) maskedNum;            if ((maskedNum >= 48 && maskedNum <= 57) || (maskedNum >= 97 && maskedNum <= 122) || maskedNum == 45) {                ret.add(pasteTogether(str, i, maskedChar));            }        }    }    return ret;}
public String metron_f2958_0()
{    return "Bitsquatting";}
private static String metron_f2959_0(char[] str, int replacementPoint, char maskedChar)
{    String ret = "";    for (int i = 0; i < replacementPoint; ++i) {        ret += str[i];    }    ret += maskedChar;    for (int i = replacementPoint + 1; i < str.length; ++i) {        ret += str[i];    }    return ret;}
public Set<String> metron_f2960_1(String originalString)
{    Set<String> result = new HashSet<>();    String domain = originalString;    if (StringUtils.isEmpty(domain)) {        return result;    }    if (isAce(domain)) {                domain = IDN.toUnicode(domain);    }    for (int ws = 0; ws < domain.length(); ws++) {        for (int i = 0; i < domain.length() - ws + 1; ++i) {            String win = domain.substring(i, i + ws);            for (int j = 0; j < ws; j++) {                char c = win.charAt(j);                if (glyphs.containsKey(c)) {                    for (String g : glyphs.get(c)) {                        String winNew = win.replaceAll("" + c, g);                        String d = domain.substring(0, i) + winNew + domain.substring(i + ws);                        result.add(d);                        if (!isAce(d)) {                            try {                                String dAscii = IDN.toASCII(d, IDN.ALLOW_UNASSIGNED);                                if (!d.equals(dAscii)) {                                    result.add(dAscii);                                }                            } catch (IllegalArgumentException iae) {                                                            }                        }                    }                }            }        }    }    return result;}
public static boolean metron_f2961_0(String domainRaw)
{    String domain = domainRaw.toLowerCase();    return domain.startsWith("xn--") || domain.contains(".xn--");}
public String metron_f2962_0()
{    return "Homoglyph";}
public Set<String> metron_f2963_0(String originalString)
{    Set<String> ret = new HashSet<>();    for (int i = 1; i < originalString.length(); ++i) {        ret.add(originalString.substring(0, i) + "-" + originalString.substring(i));    }    return ret;}
public String metron_f2964_0()
{    return "Hyphenation";}
public Set<String> metron_f2965_0(String domain)
{    Set<String> ret = new HashSet<>();    for (int i = 1; i < domain.length() - 1; ++i) {        for (Keyboards keyboard : Keyboards.values()) {            String mapping = keyboard.getMapping().get(domain.charAt(i));            if (mapping != null) {                for (Character c : mapping.toCharArray()) {                    ret.add(domain.substring(0, i) + c + domain.charAt(i) + domain.substring(i + 1, domain.length()));                    ret.add(domain.substring(0, i) + domain.charAt(i) + c + domain.substring(i + 1, domain.length()));                }            }        }    }    return ret;}
public String metron_f2966_0()
{    return "Insertion";}
public Map<Character, String> metron_f2967_0()
{    return mapping;}
public Set<String> metron_f2968_0(String domain)
{    HashSet<String> ret = new HashSet<>();    for (int i = 0; i < domain.length(); ++i) {        ret.add(domain.substring(0, i) + domain.substring(i + 1, domain.length()));    }    return ret;}
public String metron_f2969_0()
{    return "Omission";}
public Set<String> metron_f2970_0(String domain)
{    Set<String> ret = new HashSet<>();    for (int i = 0; i < domain.length(); ++i) {        Character c = domain.charAt(i);        if (Character.isLetter(c)) {            ret.add(domain.substring(0, i) + c + c + domain.substring(i + 1, domain.length()));        }    }    return ret;}
public String metron_f2971_0()
{    return "Repetition";}
public Set<String> metron_f2972_0(String domain)
{    Set<String> ret = new HashSet<>();    for (int i = 0; i < domain.length(); ++i) {        for (Keyboards keyboard : Keyboards.values()) {            String mapping = keyboard.getMapping().get(domain.charAt(i));            if (mapping != null) {                for (Character c : mapping.toCharArray()) {                    ret.add(domain.substring(0, i) + c + domain.substring(i + 1, domain.length()));                }            }        }    }    return ret;}
public String metron_f2973_0()
{    return "Replacement";}
public Set<String> metron_f2974_0(String domain)
{    Set<String> ret = new HashSet<>();    for (int i = 1; i < domain.length(); ++i) {        Character c = domain.charAt(i);        Character prevC = domain.charAt(i - 1);        if (c != '-' && c != '.' && prevC != '-' && prevC != '.') {            ret.add(domain.substring(0, i) + "." + domain.substring(i, domain.length()));        }    }    return ret;}
public String metron_f2975_0()
{    return "Subdomain";}
public Set<String> metron_f2976_0(String domain)
{    Set<String> ret = new HashSet<>();    for (int i = 0; i < domain.length() - 1; ++i) {        char nextC = domain.charAt(i + 1);        char c = domain.charAt(i);        if (nextC != c) {            ret.add(domain.substring(0, i) + nextC + c + domain.substring(i + 2));        }    }    return ret;}
public String metron_f2977_0()
{    return "Transposition";}
public Set<String> metron_f2978_0(String originalString)
{    Set<String> candidates = strategy.generateCandidates(originalString);    candidates.remove(originalString);    return candidates;}
public static Set<String> metron_f2979_0(String originalString)
{    Set<String> ret = new HashSet<>();    for (TyposquattingStrategy s : values()) {        ret.addAll(s.generateCandidates(originalString));    }    return ret;}
public static TyposquattingStrategies metron_f2980_0(String name)
{    for (TyposquattingStrategies s : values()) {        if (s.strategy.name().equals(name)) {            return s;        }    }    return null;}
public Object metron_f2981_0(List<Object> args, Context context) throws ParseException
{    if (args.size() == 0) {        return null;    }    Object dnObj = args.get(0);    if (dnObj == null) {        return null;    }    if (!(dnObj instanceof String)) {        throw new IllegalStateException("Expected a domain without subdomains or a TLD, but got " + dnObj);    }    return TyposquattingStrategies.generateAllCandidates((String) dnObj);}
public boolean metron_f2983_0()
{    return true;}
public Set<String> metron_f2984_0(String domain)
{    HashSet<String> ret = new HashSet<>();    for (int i = 0; i < domain.length(); ++i) {        char c = domain.charAt(i);        for (char vowel : VOWELS) {            if (VOWELS.contains(c)) {                ret.add(domain.substring(0, i) + vowel + domain.substring(i + 1));            }        }    }    return ret;}
public String metron_f2985_0()
{    return "Vowel-swap";}
public Optional<Object> metron_f2986_0(OPT_T option, CommandLine cli)
{    return Optional.empty();}
public static Options metron_f2987_0(CLIOptions[] values)
{    Options ret = new Options();    for (CLIOptions o : values) {        ret.addOption(o.getOption());    }    return ret;}
public static void metron_f2988_0(String name, CLIOptions[] values)
{    HelpFormatter formatter = new HelpFormatter();    formatter.printHelp(name, getOptions(values));}
public static EnumMap<OPT_T, Optional<Object>> metron_f2989_0(CommandLine cli, OPT_T[] values, Class<OPT_T> clazz)
{    EnumMap<OPT_T, Optional<Object>> ret = new EnumMap<>(clazz);    for (OPT_T option : values) {        ret.put(option, option.getHandler().getValue(option, cli));    }    return ret;}
public static CommandLine metron_f2990_0(String name, CommandLineParser parser, String[] args, CLIOptions[] values, CLIOptions helpOption)
{    try {        CommandLine cli = parser.parse(getOptions(values), args);        if (helpOption.has(cli)) {            printHelp(name, values);            System.exit(0);        }        return cli;    } catch (ParseException e) {        System.err.println("Unable to parse args: " + Joiner.on(' ').join(args));        e.printStackTrace(System.err);        printHelp(name, values);        System.exit(-1);        return null;    }}
public void metron_f2991_0(File inFile, File outFile) throws IOException
{    strategy.compress(inFile, outFile);}
public void metron_f2992_0(File inFile, File outFile) throws IOException
{    strategy.decompress(inFile, outFile);}
public boolean metron_f2993_0(File gzipFile)
{    return strategy.test(gzipFile);}
public void metron_f2994_0(File inFile, File outFile) throws IOException
{    try (FileInputStream fis = new FileInputStream(inFile);        FileOutputStream fos = new FileOutputStream(outFile);        GZIPOutputStream gzipOS = new GZIPOutputStream(fos)) {        byte[] buffer = new byte[1024];        int len;        while ((len = fis.read(buffer)) != -1) {            gzipOS.write(buffer, 0, len);        }    }}
public void metron_f2995_0(File inFile, File outFile) throws IOException
{    try (FileInputStream fis = new FileInputStream(inFile);        GZIPInputStream gis = new GZIPInputStream(fis);        FileOutputStream fos = new FileOutputStream(outFile)) {        byte[] buffer = new byte[1024];        int len;        while ((len = gis.read(buffer)) != -1) {            fos.write(buffer, 0, len);        }    }}
public boolean metron_f2996_0(File gzipFile)
{    try (FileInputStream fis = new FileInputStream(gzipFile);        GZIPInputStream gis = new GZIPInputStream(fis)) {        byte[] buffer = new byte[1024];                gis.read(buffer);    } catch (ZipException | EOFException e) {        return false;    } catch (IOException e) {        throw new IllegalStateException("Error occurred while attempting to validate gzip file", e);    }    return true;}
public void metron_f2997_0(Consumer<? super String> action)
{    if (action == null) {        throw new NullPointerException();    }    try {        for (String line = null; (line = reader.readLine()) != null; ) {            action.accept(line);        }    } catch (RuntimeException e) {        throw e;    } catch (Exception e) {        throw new IllegalStateException(e);    }}
public boolean metron_f2998_0(Consumer<? super String> action)
{    if (action == null) {        throw new NullPointerException();    }    try {        final String line = reader.readLine();        if (line == null) {            return false;        }        action.accept(line);        return true;    } catch (RuntimeException e) {        throw e;    } catch (Exception e) {        throw new IllegalStateException(e);    }}
public Spliterator<String> metron_f2999_0()
{    final ConsumerWithLookback holder = new ConsumerWithLookback();    if (!tryAdvance(holder)) {        return null;    }    final String[] batch = new String[batchSize];    int j = 0;    do {        batch[j] = holder.value;    } while (++j < batchSize && tryAdvance(holder));    return spliterator(batch, 0, j, characteristics() | SIZED);}
public long metron_f3000_0()
{    return Long.MAX_VALUE;}
public int metron_f3001_0()
{    return characteristics;}
public void metron_f3002_0(String string)
{    this.value = string;}
public static Stream<String> metron_f3003_0(BufferedReader in, int batchSize)
{    return lineStream(in, batchSize, false);}
public static Stream<String> metron_f3004_0(BufferedReader in, int batchSize, boolean isParallel)
{    return StreamSupport.stream(new ReaderSpliterator(in, batchSize), isParallel).onClose(() -> {        try {            in.close();        } catch (IOException e) {            throw new UncheckedIOException(e);        }    });}
public static String metron_f3005_0(JSONObject message, Collection<String> hashFields)
{    List<String> hashElements = hashFields.stream().map(errorField -> String.format("%s-%s", errorField, message.get(errorField))).collect(Collectors.toList());    return DigestUtils.sha256Hex(String.join("|", hashElements).getBytes(UTF_8));}
public static String metron_f3006_0(JSONObject message)
{    return DigestUtils.sha256Hex(message.toJSONString().getBytes(UTF_8));}
public static String metron_f3007_0(byte[] bytes)
{    return DigestUtils.sha256Hex(bytes);}
public static byte[] metron_f3008_0(String path) throws IOException
{    return readBytes(new Path(path));}
public static byte[] metron_f3009_0(Path inPath) throws IOException
{    FileSystem fs = FileSystem.get(inPath.toUri(), new Configuration());    try (FSDataInputStream inputStream = fs.open(inPath)) {        return IOUtils.toByteArray(inputStream);    }}
public static List<String> metron_f3010_0(String path) throws IOException
{    return readFile(new Configuration(), path);}
public static List<String> metron_f3011_0(Configuration config, String path) throws IOException
{    Path inPath = new Path(path);    FileSystem fs = FileSystem.get(inPath.toUri(), config);    try (FSDataInputStream inputStream = fs.open(inPath)) {        return IOUtils.readLines(inputStream, "UTF-8");    }}
public static void metron_f3012_0(Configuration config, byte[] bytes, String path) throws IOException
{    Path outPath = new Path(path);    FileSystem fs = FileSystem.get(outPath.toUri(), config);    fs.mkdirs(outPath.getParent());    try (FSDataOutputStream outputStream = fs.create(outPath)) {        outputStream.write(bytes);        outputStream.flush();    }}
public TypeReference<T> metron_f3013_0()
{    return new TypeReference<T>() {        @Override        public Type getType() {            return type;        }    };}
public Type metron_f3014_0()
{    return type;}
public T metron_f3015_0(Object original, Class<T> targetClass)
{    return _mapper.get().convertValue(original, targetClass);}
public ObjectMapper metron_f3016_0()
{    return _mapper.get();}
public T metron_f3017_0(InputStream is, ReferenceSupplier<T> ref) throws IOException
{    return _mapper.get().readValue(is, (TypeReference<T>) ref.get());}
public T metron_f3018_0(String is, ReferenceSupplier<T> ref) throws IOException
{    return _mapper.get().readValue(is, (TypeReference<T>) ref.get());}
public T metron_f3019_0(File f, ReferenceSupplier<T> ref) throws IOException
{    try (InputStream is = new BufferedInputStream(new FileInputStream(f))) {        return _mapper.get().readValue(is, (TypeReference<T>) ref.get());    }}
public T metron_f3020_0(InputStream is, Class<T> clazz) throws IOException
{    return _mapper.get().readValue(is, clazz);}
public T metron_f3021_0(File f, Class<T> clazz) throws IOException
{    try (InputStream is = new BufferedInputStream(new FileInputStream(f))) {        return _mapper.get().readValue(is, clazz);    }}
public T metron_f3022_0(String is, Class<T> clazz) throws IOException
{    return _mapper.get().readValue(is, clazz);}
public String metron_f3023_0(Object o, boolean pretty) throws JsonProcessingException
{    if (pretty) {        return _mapper.get().writerWithDefaultPrettyPrinter().writeValueAsString(o);    } else {        return _mapper.get().writeValueAsString(o);    }}
public byte[] metron_f3024_0(String config) throws IOException
{    return toJSONPretty(readTree(config));}
public byte[] metron_f3025_0(Object config) throws JsonProcessingException
{    return _mapper.get().writerWithDefaultPrettyPrinter().writeValueAsBytes(config);}
public JSONObject metron_f3026_0(Object o) throws JsonProcessingException, ParseException
{    return (JSONObject) _parser.get().parse(toJSON(o, false));}
 JsonNode metron_f3027_0(String json) throws IOException
{    return _mapper.get().readTree(json);}
 JsonNode metron_f3028_0(byte[] json) throws IOException
{    return _mapper.get().readTree(json);}
public byte[] metron_f3029_0(String patch, String source) throws IOException
{    JsonNode patchNode = readTree(patch);    JsonNode sourceNode = readTree(source);    return toJSONPretty(JsonPatch.apply(patchNode, sourceNode));}
public byte[] metron_f3030_0(byte[] patch, byte[] source) throws IOException
{    JsonNode patchNode = readTree(patch);    JsonNode sourceNode = readTree(source);    return toJSONPretty(JsonPatch.apply(patchNode, sourceNode));}
public Map<String, Object> metron_f3031_0(List<Map<String, Object>> patch, Map<String, Object> source)
{    JsonNode originalNode = convert(source, JsonNode.class);    JsonNode patchNode = convert(patch, JsonNode.class);    JsonNode patched = JsonPatch.apply(patchNode, originalNode);    return _mapper.get().convertValue(patched, new TypeReference<Map<String, Object>>() {    });}
public List<String> metron_f3032_0(String zkQuorum) throws Exception
{    RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);    CuratorFramework framework = CuratorFrameworkFactory.newClient(zkQuorum, retryPolicy);    framework.start();    try {        return getBrokersFromZookeeper(framework);    } finally {        framework.close();    }}
public List<String> metron_f3033_0(CuratorFramework client) throws Exception
{    List<String> ret = new ArrayList<>();    for (String id : client.getChildren().forPath("/brokers/ids")) {        byte[] data = client.getData().forPath("/brokers/ids/" + id);        String brokerInfoStr = new String(data, StandardCharsets.UTF_8);        Map<String, Object> brokerInfo = JSONUtils.INSTANCE.load(brokerInfoStr, JSONUtils.MAP_SUPPLIER);        String host = (String) brokerInfo.get("host");        if (host != null) {            ret.add(host + ":" + brokerInfo.get("port"));        } else {            Object endpoints = brokerInfo.get("endpoints");            if (endpoints != null && endpoints instanceof List) {                List<String> eps = (List<String>) endpoints;                for (String url : eps) {                    ret.addAll(fromEndpoint(url));                }            }        }    }    return ret;}
public Map<String, Object> metron_f3034_0(Map<String, Object> configs)
{    if (configs.containsKey(SECURITY_PROTOCOL)) {        String protocol = normalizeProtocol((String) configs.get(SECURITY_PROTOCOL));        configs.put(SECURITY_PROTOCOL, protocol);    }    return configs;}
public String metron_f3035_0(String protocol)
{    if (protocol.equalsIgnoreCase("PLAINTEXTSASL") || protocol.equalsIgnoreCase("SASL_PLAINTEXT")) {        if (SecurityProtocol.getNames().contains("PLAINTEXTSASL")) {            return "PLAINTEXTSASL";        } else if (SecurityProtocol.getNames().contains("SASL_PLAINTEXT")) {            return "SASL_PLAINTEXT";        } else {            throw new IllegalStateException("Unable to find the appropriate SASL protocol, " + "viable options are: " + Joiner.on(",").join(SecurityProtocol.getNames()));        }    } else {        return protocol.trim();    }}
 List<String> metron_f3036_0(String url)
{    List<String> ret = new ArrayList<>();    if (url != null) {        Iterable<String> splits = Splitter.on("//").split(url);        if (Iterables.size(splits) == 2) {            String hostPort = Iterables.getLast(splits);            ret.add(hostPort);        }    }    return ret;}
protected HashFunction metron_f3037_0()
{    return Hashing.murmur3_128(SEED);}
public byte[] metron_f3038_0(byte[] key)
{    Hasher hasher = hFunction.get().newHasher();    hasher.putBytes(key);    return hasher.hash().asBytes();}
public byte[] metron_f3039_0(byte[] prefix, byte[] key)
{    byte[] val = new byte[key.length + prefix.length];    int offset = 0;    System.arraycopy(prefix, 0, val, offset, prefix.length);    offset += prefix.length;    System.arraycopy(key, 0, val, offset, key.length);    return val;}
public static LazyLogger metron_f3040_0(String name)
{    final Logger logger = org.slf4j.LoggerFactory.getLogger(name);    if (logger != null) {                return new LazyLoggerImpl(logger);    } else {        throw new NullPointerException(String.format("Logger not returned for class %s", name == null ? "Null String" : name));    }}
public static LazyLogger metron_f3041_0(Class clazz)
{    return getLogger(clazz.getName());}
public static LazyLogger metron_f3042_0(Logger logger)
{    if (logger != null) {        return new LazyLoggerImpl(logger);    } else {        throw new NullPointerException("Null logger passed");    }}
public Logger metron_f3043_0()
{    return logger;}
public String metron_f3044_0()
{    return logger.getName();}
public boolean metron_f3045_0()
{    return logger.isTraceEnabled();}
public void metron_f3046_0(String msg)
{    logger.trace(msg);}
public void metron_f3047_0(String format, Object arg)
{    logger.trace(format, arg);}
public void metron_f3048_0(String format, Supplier<Object> arg)
{    if (logger.isTraceEnabled()) {        logger.trace(format, arg.get());    }}
public void metron_f3049_0(String format, Object arg1, Object arg2)
{    logger.trace(format, arg1, arg2);}
public void metron_f3050_0(String format, Supplier<Object> arg1, Supplier<Object> arg2)
{    if (logger.isTraceEnabled()) {        logger.trace(format, arg1.get(), arg2.get());    }}
public void metron_f3051_0(String format, Object... arguments)
{    logger.trace(format, arguments);}
public final void metron_f3052_0(String format, Supplier<Object>... arguments)
{    if (logger.isTraceEnabled()) {        logger.trace(format, Arrays.stream(arguments).map(Supplier::get).toArray());    }}
public void metron_f3053_0(String msg, Throwable t)
{    logger.trace(msg, t);}
public boolean metron_f3054_0(Marker marker)
{    return logger.isTraceEnabled(marker);}
public void metron_f3055_0(Marker marker, String msg)
{    logger.trace(marker, msg);}
public void metron_f3056_0(Marker marker, String format, Object arg)
{    logger.trace(marker, format, arg);}
public void metron_f3057_0(Marker marker, String format, Supplier<Object> arg)
{    if (logger.isTraceEnabled(marker)) {        logger.trace(marker, format, arg.get());    }}
public void metron_f3058_0(Marker marker, String format, Object arg1, Object arg2)
{    logger.trace(marker, format, arg1, arg2);}
public void metron_f3059_0(Marker marker, String format, Supplier<Object> arg1, Supplier<Object> arg2)
{    if (logger.isTraceEnabled(marker)) {        logger.trace(marker, format, arg1.get(), arg2.get());    }}
public void metron_f3060_0(Marker marker, String format, Object... arguments)
{    logger.trace(marker, format, arguments);}
public final void metron_f3061_0(Marker marker, String format, Supplier<Object>... arguments)
{    if (logger.isTraceEnabled(marker)) {        logger.trace(marker, format, Arrays.stream(arguments).map(Supplier::get).toArray());    }}
public void metron_f3062_0(Marker marker, String msg, Throwable t)
{    logger.trace(marker, msg, t);}
public boolean metron_f3063_0()
{    return logger.isDebugEnabled();}
public void metron_f3064_1(String msg)
{    }
public void metron_f3065_1(String format, Object arg)
{    }
public void metron_f3066_1(String format, Supplier<Object> arg)
{    if (logger.isDebugEnabled()) {            }}
public void metron_f3067_1(String format, Object arg1, Object arg2)
{    }
public void metron_f3068_1(String format, Supplier<Object> arg1, Supplier<Object> arg2)
{    if (logger.isDebugEnabled()) {            }}
public void metron_f3069_1(String format, Object... arguments)
{    }
public final void metron_f3070_1(String format, Supplier<Object>... arguments)
{    if (logger.isDebugEnabled()) {            }}
public void metron_f3071_1(String msg, Throwable t)
{    }
public boolean metron_f3072_0(Marker marker)
{    return logger.isDebugEnabled(marker);}
public void metron_f3073_1(Marker marker, String msg)
{    }
public void metron_f3074_1(Marker marker, String format, Object arg)
{    }
public void metron_f3075_1(Marker marker, String format, Supplier<Object> arg)
{    if (logger.isDebugEnabled(marker)) {            }}
public void metron_f3076_1(Marker marker, String format, Object arg1, Object arg2)
{    }
public void metron_f3077_1(Marker marker, String format, Supplier<Object> arg1, Supplier<Object> arg2)
{    if (logger.isDebugEnabled(marker)) {            }}
public void metron_f3078_1(Marker marker, String format, Object... arguments)
{    }
public final void metron_f3079_1(Marker marker, String format, Supplier<Object>... arguments)
{    if (logger.isDebugEnabled(marker)) {            }}
public void metron_f3080_1(Marker marker, String msg, Throwable t)
{    }
public boolean metron_f3081_0()
{    return logger.isInfoEnabled();}
public void metron_f3082_1(String msg)
{    }
public void metron_f3083_1(String format, Object arg)
{    }
public void metron_f3084_1(String format, Supplier<Object> arg)
{    if (logger.isInfoEnabled()) {            }}
public void metron_f3085_1(String format, Object arg1, Object arg2)
{    }
public void metron_f3086_1(String format, Supplier<Object> arg1, Supplier<Object> arg2)
{    if (logger.isInfoEnabled()) {            }}
public void metron_f3087_1(String format, Object... arguments)
{    }
public final void metron_f3088_1(String format, Supplier<Object>... arguments)
{    if (logger.isInfoEnabled()) {            }}
public void metron_f3089_1(String msg, Throwable t)
{    }
public boolean metron_f3090_0(Marker marker)
{    return logger.isInfoEnabled(marker);}
public void metron_f3091_1(Marker marker, String msg)
{    }
public void metron_f3092_1(Marker marker, String format, Object arg)
{    }
public void metron_f3093_1(Marker marker, String format, Supplier<Object> arg)
{    if (logger.isInfoEnabled(marker)) {            }}
public void metron_f3094_1(Marker marker, String format, Object arg1, Object arg2)
{    }
public void metron_f3095_1(Marker marker, String format, Supplier<Object> arg1, Supplier<Object> arg2)
{    if (logger.isInfoEnabled(marker)) {            }}
public void metron_f3096_1(Marker marker, String format, Object... arguments)
{    }
public final void metron_f3097_1(Marker marker, String format, Supplier<Object>... arguments)
{    if (logger.isInfoEnabled(marker)) {            }}
public void metron_f3098_1(Marker marker, String msg, Throwable t)
{    }
