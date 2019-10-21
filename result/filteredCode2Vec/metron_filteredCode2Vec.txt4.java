public Optional<Path> metron_f4121_0()
{    if (ElasticsearchClientOptions.KEYSTORE_PATH.containsOption(this)) {        return Optional.of(Paths.get(ElasticsearchClientOptions.KEYSTORE_PATH.get(this, String.class)));    }    return Optional.empty();}
public String metron_f4122_0()
{    return key;}
public static void metron_f4123_0()
{    String newLine = "";    for (ElasticsearchClientOptions opt : ElasticsearchClientOptions.values()) {        System.out.print(newLine);        System.out.print(opt.getKey());        newLine = System.lineSeparator();    }}
private FieldType metron_f4126_0(String type)
{    return elasticsearchTypeMap.getOrDefault(type, FieldType.OTHER);}
public AccessConfig metron_f4127_0()
{    return accessConfig;}
public void metron_f4128_0(AccessConfig accessConfig)
{    this.accessConfig = accessConfig;}
public synchronized void metron_f4129_0(AccessConfig config)
{    if (this.client == null) {        this.client = ElasticsearchClientFactory.create(config.getGlobalConfigSupplier().get());        this.accessConfig = config;        this.columnMetadataDao = new ElasticsearchColumnMetadataDao(this.client);        this.requestSubmitter = new ElasticsearchRequestSubmitter(this.client);        this.searchDao = new ElasticsearchSearchDao(client, accessConfig, columnMetadataDao, requestSubmitter);        this.retrieveLatestDao = new ElasticsearchRetrieveLatestDao(client);        this.updateDao = new ElasticsearchUpdateDao(client, accessConfig, retrieveLatestDao).withRefreshPolicy(refreshPolicy);    }    if (columnMetadataDao == null) {        throw new IllegalArgumentException("No ColumnMetadataDao available");    }    if (requestSubmitter == null) {        throw new IllegalArgumentException("No ElasticsearchRequestSubmitter available");    }}
public SearchResponse metron_f4130_0(SearchRequest searchRequest) throws InvalidSearchException
{    return this.searchDao.search(searchRequest);}
public GroupResponse metron_f4131_0(GroupRequest groupRequest) throws InvalidSearchException
{    return this.searchDao.group(groupRequest);}
public Document metron_f4132_0(final String guid, final String sensorType) throws IOException
{    return retrieveLatestDao.getLatest(guid, sensorType);}
public Iterable<Document> metron_f4133_0(final List<GetRequest> getRequests) throws IOException
{    return retrieveLatestDao.getAllLatest(getRequests);}
public Document metron_f4134_0(Document update, Optional<String> index) throws IOException
{    return updateDao.update(update, index);}
public Map<Document, Optional<String>> metron_f4135_0(Map<Document, Optional<String>> updates) throws IOException
{    return updateDao.batchUpdate(updates);}
public Document metron_f4136_0(RetrieveLatestDao retrieveLatestDao, PatchRequest request, Optional<Long> timestamp) throws OriginalNotFoundException, IOException
{    return updateDao.patch(retrieveLatestDao, request, timestamp);}
public Document metron_f4137_0(CommentAddRemoveRequest request) throws IOException
{    return updateDao.addCommentToAlert(request);}
public Document metron_f4138_0(CommentAddRemoveRequest request) throws IOException
{    return updateDao.removeCommentFromAlert(request);}
public Map<String, FieldType> metron_f4139_0(List<String> indices) throws IOException
{    return this.columnMetadataDao.getColumnMetadata(indices);}
public Optional<Map<String, Object>> metron_f4140_0(GetRequest request) throws IOException
{    return retrieveLatestDao.getLatestResult(request);}
public Document metron_f4141_0(CommentAddRemoveRequest request, Document latest) throws IOException
{    return this.updateDao.addCommentToAlert(request, latest);}
public Document metron_f4142_0(CommentAddRemoveRequest request, Document latest) throws IOException
{    return this.updateDao.removeCommentFromAlert(request, latest);}
public ElasticsearchDao metron_f4143_0(WriteRequest.RefreshPolicy refreshPolicy)
{    this.refreshPolicy = refreshPolicy;    return this;}
protected Optional<String> metron_f4144_0(String guid, String sensorType) throws IOException
{    return updateDao.findIndexNameByGUID(guid, sensorType);}
protected SearchResponse metron_f4145_0(SearchRequest request, QueryBuilder queryBuilder) throws InvalidSearchException
{    return searchDao.search(request, queryBuilder);}
protected GroupResponse metron_f4146_0(GroupRequest groupRequest, QueryBuilder queryBuilder) throws InvalidSearchException
{    return searchDao.group(groupRequest, queryBuilder);}
public ElasticsearchClient metron_f4147_0()
{    return this.client;}
public void metron_f4148_0(IndexDao indexDao, Optional<String> threatSort)
{    if (indexDao instanceof MultiIndexDao) {        this.indexDao = indexDao;        MultiIndexDao multiIndexDao = (MultiIndexDao) indexDao;        for (IndexDao childDao : multiIndexDao.getIndices()) {            if (childDao instanceof ElasticsearchDao) {                this.elasticsearchDao = (ElasticsearchDao) childDao;            }        }    } else if (indexDao instanceof ElasticsearchDao) {        this.indexDao = indexDao;        this.elasticsearchDao = (ElasticsearchDao) indexDao;    } else {        throw new IllegalArgumentException("Need an ElasticsearchDao when using ElasticsearchMetaAlertDao");    }    if (threatSort.isPresent()) {        this.threatSort = threatSort.get();    }    Supplier<Map<String, Object>> globalConfigSupplier = () -> new HashMap<>();    if (elasticsearchDao != null && elasticsearchDao.getAccessConfig() != null) {        globalConfigSupplier = elasticsearchDao.getAccessConfig().getGlobalConfigSupplier();    }    MetaAlertConfig config = new MetaAlertConfig(metaAlertsIndex, this.threatSort, globalConfigSupplier) {        @Override        protected String getDefaultThreatTriageField() {            return THREAT_TRIAGE_FIELD;        }        @Override        protected String getDefaultSourceTypeField() {            return SOURCE_TYPE_FIELD;        }    };    this.metaAlertSearchDao = new ElasticsearchMetaAlertSearchDao(elasticsearchDao, config, pageSize);    this.metaAlertRetrieveLatestDao = new ElasticsearchMetaAlertRetrieveLatestDao(indexDao);    this.metaAlertUpdateDao = new ElasticsearchMetaAlertUpdateDao(elasticsearchDao, metaAlertRetrieveLatestDao, config, pageSize);}
protected String metron_f4149_0()
{    return THREAT_TRIAGE_FIELD;}
protected String metron_f4150_0()
{    return SOURCE_TYPE_FIELD;}
public Map<String, FieldType> metron_f4152_0(List<String> indices) throws IOException
{    return indexDao.getColumnMetadata(indices);}
public Document metron_f4153_0(String guid, String sensorType) throws IOException
{    return indexDao.getLatest(guid, sensorType);}
public Iterable<Document> metron_f4154_0(List<GetRequest> getRequests) throws IOException
{    return indexDao.getAllLatest(getRequests);}
public SearchResponse metron_f4155_0(String guid) throws InvalidSearchException, IOException
{    return metaAlertSearchDao.getAllMetaAlertsForAlert(guid);}
public Document metron_f4156_0(MetaAlertCreateRequest request) throws InvalidCreateException, IOException
{    return metaAlertUpdateDao.createMetaAlert(request);}
public Document metron_f4157_0(String metaAlertGuid, List<GetRequest> alertRequests) throws IOException
{    return metaAlertUpdateDao.addAlertsToMetaAlert(metaAlertGuid, alertRequests);}
public Document metron_f4158_0(String metaAlertGuid, List<GetRequest> alertRequests) throws IOException
{    return metaAlertUpdateDao.removeAlertsFromMetaAlert(metaAlertGuid, alertRequests);}
public Document metron_f4159_0(String metaAlertGuid, MetaAlertStatus status) throws IOException
{    return metaAlertUpdateDao.updateMetaAlertStatus(metaAlertGuid, status);}
public SearchResponse metron_f4160_0(SearchRequest searchRequest) throws InvalidSearchException
{    return metaAlertSearchDao.search(searchRequest);}
public GroupResponse metron_f4161_0(GroupRequest groupRequest) throws InvalidSearchException
{    return metaAlertSearchDao.group(groupRequest);}
public Document metron_f4162_0(Document update, Optional<String> index) throws IOException
{    return metaAlertUpdateDao.update(update, index);}
public Map<Document, Optional<String>> metron_f4163_0(Map<Document, Optional<String>> updates)
{    return metaAlertUpdateDao.batchUpdate(updates);}
public Document metron_f4164_0(CommentAddRemoveRequest request) throws IOException
{    return indexDao.addCommentToAlert(request);}
public Document metron_f4165_0(CommentAddRemoveRequest request) throws IOException
{    return indexDao.removeCommentFromAlert(request);}
public Document metron_f4166_0(CommentAddRemoveRequest request, Document latest) throws IOException
{    return indexDao.addCommentToAlert(request, latest);}
public Document metron_f4167_0(CommentAddRemoveRequest request, Document latest) throws IOException
{    return indexDao.removeCommentFromAlert(request, latest);}
public Document metron_f4168_0(RetrieveLatestDao retrieveLatestDao, PatchRequest request, Optional<Long> timestamp) throws OriginalNotFoundException, IOException
{    return metaAlertUpdateDao.patch(retrieveLatestDao, request, timestamp);}
public void metron_f4169_0(int pageSize)
{    this.pageSize = pageSize;}
public Document metron_f4170_0(String guid, String sensorType) throws IOException
{    return retrieveLatestDao.getLatest(guid, sensorType);}
public Iterable<Document> metron_f4171_0(List<GetRequest> getRequests) throws IOException
{    return retrieveLatestDao.getAllLatest(getRequests);}
public SearchResponse metron_f4172_0(SearchRequest searchRequest) throws InvalidSearchException
{        QueryBuilder qb = constantScoreQuery(boolQuery().must(boolQuery().should(new QueryStringQueryBuilder(searchRequest.getQuery())).should(nestedQuery(MetaAlertConstants.ALERT_FIELD, new QueryStringQueryBuilder(searchRequest.getQuery()), ScoreMode.None))).must(boolQuery().should(termQuery(MetaAlertConstants.STATUS_FIELD, MetaAlertStatus.ACTIVE.getStatusString())).should(boolQuery().mustNot(existsQuery(MetaAlertConstants.STATUS_FIELD)))).mustNot(existsQuery(MetaAlertConstants.METAALERT_FIELD)));    return elasticsearchDao.search(searchRequest, qb);}
public GroupResponse metron_f4173_0(GroupRequest groupRequest) throws InvalidSearchException
{        QueryBuilder qb = QueryBuilders.boolQuery().must(new QueryStringQueryBuilder(groupRequest.getQuery())).mustNot(existsQuery(MetaAlertConstants.METAALERT_FIELD));    return elasticsearchDao.group(groupRequest, qb);}
public SearchResponse metron_f4174_0(String guid) throws InvalidSearchException, IOException
{    if (guid == null || guid.trim().isEmpty()) {        throw new InvalidSearchException("Guid cannot be empty");    }        QueryBuilder qb = boolQuery().must(nestedQuery(MetaAlertConstants.ALERT_FIELD, boolQuery().must(termQuery(MetaAlertConstants.ALERT_FIELD + "." + GUID, guid)), ScoreMode.None).innerHit(new InnerHitBuilder())).must(termQuery(MetaAlertConstants.STATUS_FIELD, MetaAlertStatus.ACTIVE.getStatusString()));    return queryAllResults(elasticsearchDao.getClient().getHighLevelClient(), qb, config.getMetaAlertIndex(), pageSize);}
public Document metron_f4175_0(MetaAlertCreateRequest request) throws InvalidCreateException, IOException
{    List<GetRequest> alertRequests = request.getAlerts();    if (request.getAlerts().isEmpty()) {        throw new InvalidCreateException("MetaAlertCreateRequest must contain alerts");    }    if (request.getGroups().isEmpty()) {        throw new InvalidCreateException("MetaAlertCreateRequest must contain UI groups");    }        Iterable<Document> alerts = retrieveLatestDao.getAllLatest(alertRequests);    Document metaAlert = buildCreateDocument(alerts, request.getGroups(), MetaAlertConstants.ALERT_FIELD);    MetaScores.calculateMetaScores(metaAlert, getConfig().getThreatTriageField(), getConfig().getThreatSort());        metaAlert.getDocument().put(getConfig().getSourceTypeField(), MetaAlertConstants.METAALERT_TYPE);        Map<Document, Optional<String>> updates = new HashMap<>();    updates.put(metaAlert, Optional.of(getConfig().getMetaAlertIndex()));    try {                        Map<String, Optional<String>> guidToIndices = alertRequests.stream().collect(Collectors.toMap(GetRequest::getGuid, GetRequest::getIndex));        Map<String, String> guidToSensorTypes = alertRequests.stream().collect(Collectors.toMap(GetRequest::getGuid, GetRequest::getSensorType));        for (Document alert : alerts) {            if (addMetaAlertToAlert(metaAlert.getGuid(), alert)) {                                Optional<String> index = guidToIndices.get(alert.getGuid());                if (!index.isPresent()) {                                        index = elasticsearchDao.getIndexName(alert.getGuid(), guidToSensorTypes.get(alert.getGuid()));                    if (!index.isPresent()) {                        throw new IllegalArgumentException("Could not find index for " + alert.getGuid());                    }                }                updates.put(alert, index);            }        }                update(updates);        return metaAlert;    } catch (IOException ioe) {        throw new InvalidCreateException("Unable to create meta alert", ioe);    }}
public Document metron_f4176_0(Document update, Optional<String> index) throws IOException
{    if (MetaAlertConstants.METAALERT_TYPE.equals(update.getSensorType())) {                throw new UnsupportedOperationException("Meta alerts cannot be directly updated");    } else {        Map<Document, Optional<String>> updates = new HashMap<>();        updates.put(update, index);        try {                                    SearchResponse response = getMetaAlertsForAlert(update.getGuid());            Collection<Document> metaAlerts = response.getResults().stream().map(result -> toDocument(result, update.getTimestamp())).collect(Collectors.toList());                        for (Document metaAlert : metaAlerts) {                replaceAlertInMetaAlert(metaAlert, update);                updates.put(metaAlert, Optional.of(METAALERTS_INDEX));            }        } catch (IndexNotFoundException e) {            List<String> indicesNotFound = e.getMetadata(INDEX_NOT_FOUND_INDICES_KEY);                        if (indicesNotFound.size() != 1 || !METAALERTS_INDEX.equals(indicesNotFound.get(0))) {                throw e;            }        }                elasticsearchDao.batchUpdate(updates);        return update;    }}
private Document metron_f4177_0(SearchResult result, Long timestamp)
{    Document document = Document.fromJSON(result.getSource());    document.setTimestamp(timestamp);    document.setDocumentID(result.getId());    return document;}
public Document metron_f4178_0(CommentAddRemoveRequest request) throws IOException
{    return getUpdateDao().addCommentToAlert(request);}
public Document metron_f4179_0(CommentAddRemoveRequest request) throws IOException
{    return getUpdateDao().removeCommentFromAlert(request);}
public Document metron_f4180_0(CommentAddRemoveRequest request, Document latest) throws IOException
{    return getUpdateDao().addCommentToAlert(request, latest);}
public Document metron_f4181_0(CommentAddRemoveRequest request, Document latest) throws IOException
{    return getUpdateDao().removeCommentFromAlert(request, latest);}
protected SearchResponse metron_f4182_0(String alertGuid) throws IOException
{    QueryBuilder qb = boolQuery().must(nestedQuery(MetaAlertConstants.ALERT_FIELD, boolQuery().must(termQuery(MetaAlertConstants.ALERT_FIELD + "." + Constants.GUID, alertGuid)), ScoreMode.None).innerHit(new InnerHitBuilder())).must(termQuery(MetaAlertConstants.STATUS_FIELD, MetaAlertStatus.ACTIVE.getStatusString()));    return ElasticsearchUtils.queryAllResults(elasticsearchDao.getClient().getHighLevelClient(), qb, getConfig().getMetaAlertIndex(), pageSize);}
protected void metron_f4183_0(Document metaAlert, Document alert)
{    boolean metaAlertUpdated = removeAlertsFromMetaAlert(metaAlert, Collections.singleton(alert.getGuid()));    if (metaAlertUpdated) {        addAlertsToMetaAlert(metaAlert, Collections.singleton(alert));    }}
public Document metron_f4186_0(String guid, String sensorType) throws IOException
{    Optional<Document> doc = searchByGuid(guid, sensorType, hit -> toDocument(hit));    return doc.orElse(null);}
public Iterable<Document> metron_f4187_0(List<GetRequest> getRequests) throws IOException
{    Collection<String> guids = new HashSet<>();    Collection<String> sensorTypes = new HashSet<>();    for (GetRequest getRequest : getRequests) {        guids.add(getRequest.getGuid());        sensorTypes.add(getRequest.getSensorType());    }    List<Document> documents = searchByGuids(guids, sensorTypes, hit -> toDocument(hit));    return documents;}
 Optional<T> metron_f4188_0(String guid, String sensorType, Function<SearchHit, Optional<T>> callback) throws IOException
{    Collection<String> sensorTypes = sensorType != null ? Collections.singleton(sensorType) : null;    List<T> results = searchByGuids(Collections.singleton(guid), sensorTypes, callback);    if (results.size() > 0) {        return Optional.of(results.get(0));    } else {        return Optional.empty();    }}
 List<T> metron_f4189_0(Collection<String> guids, Collection<String> sensorTypes, Function<SearchHit, Optional<T>> callback) throws IOException
{    if (guids == null || guids.isEmpty()) {        return Collections.emptyList();    }            BoolQueryBuilder guidQuery = boolQuery().must(termsQuery(Constants.GUID, guids));        BoolQueryBuilder sensorQuery = boolQuery();    sensorTypes.forEach(sensorType -> sensorQuery.should(typeQuery(sensorType + "_doc")));        BoolQueryBuilder query = boolQuery().must(guidQuery).must(sensorQuery);        SearchResponse response;    try {        SearchSourceBuilder source = new SearchSourceBuilder().query(query).size(guids.size());        SearchRequest request = new SearchRequest().source(source);        response = submitter.submitSearch(request);    } catch (InvalidSearchException e) {        throw new IOException(e);    }        List<T> results = new ArrayList<>();    for (SearchHit hit : response.getHits()) {        Optional<T> result = callback.apply(hit);        result.ifPresent(r -> results.add(r));    }    return results;}
private Optional<Document> metron_f4190_0(SearchHit hit)
{    Document document = Document.fromJSON(hit.getSource());    document.setDocumentID(hit.getId());    return Optional.of(document);}
public SearchResponse metron_f4191_0(SearchRequest searchRequest) throws InvalidSearchException
{    if (searchRequest.getQuery() == null) {        throw new InvalidSearchException("Search query is invalid: null");    }    return search(searchRequest, new QueryStringQueryBuilder(searchRequest.getQuery()));}
public GroupResponse metron_f4192_0(GroupRequest groupRequest) throws InvalidSearchException
{    return group(groupRequest, new QueryStringQueryBuilder(groupRequest.getQuery()));}
protected SearchResponse metron_f4193_0(SearchRequest request, QueryBuilder queryBuilder) throws InvalidSearchException
{    org.elasticsearch.action.search.SearchRequest esRequest;    org.elasticsearch.action.search.SearchResponse esResponse;    if (client == null) {        throw new InvalidSearchException("Uninitialized Dao!  You must call init() prior to use.");    }    if (request.getSize() > accessConfig.getMaxSearchResults()) {        throw new InvalidSearchException("Search result size must be less than " + accessConfig.getMaxSearchResults());    }    esRequest = buildSearchRequest(request, queryBuilder);    esResponse = requestSubmitter.submitSearch(esRequest);    return buildSearchResponse(request, esResponse);}
private org.elasticsearch.search.sort.SortOrder metron_f4196_0(org.apache.metron.indexing.dao.search.SortOrder sortOrder)
{    return sortOrder == org.apache.metron.indexing.dao.search.SortOrder.DESC ? org.elasticsearch.search.sort.SortOrder.DESC : org.elasticsearch.search.sort.SortOrder.ASC;}
private String metron_f4197_0(String field)
{    return String.format("%s_count", field);}
private String[] metron_f4198_0(List<String> indices)
{    if (indices == null)        return new String[] {};    return indices.stream().map(index -> String.format("%s%s*", index, INDEX_NAME_DELIMITER)).toArray(value -> new String[indices.size()]);}
private SearchResult metron_f4199_0(SearchHit searchHit, List<String> fields)
{    SearchResult searchResult = new SearchResult();    searchResult.setId(searchHit.getId());    Map<String, Object> source;    if (fields != null) {        Map<String, Object> resultSourceAsMap = searchHit.getSourceAsMap();        source = new HashMap<>();        fields.forEach(field -> {            source.put(field, resultSourceAsMap.get(field));        });    } else {        source = searchHit.getSource();    }    searchResult.setSource(source);    searchResult.setScore(searchHit.getScore());    searchResult.setIndex(searchHit.getIndex());    return searchResult;}
private Map<String, Map<String, Long>> metron_f4200_0(List<String> fields, Aggregations aggregations, Map<String, FieldType> commonColumnMetadata)
{    Map<String, Map<String, Long>> fieldCounts = new HashMap<>();    for (String field : fields) {        Map<String, Long> valueCounts = new HashMap<>();        if (aggregations != null) {            Aggregation aggregation = aggregations.get(getFacetAggregationName(field));            if (aggregation instanceof Terms) {                Terms terms = (Terms) aggregation;                terms.getBuckets().stream().forEach(bucket -> valueCounts.put(formatKey(bucket.getKey(), commonColumnMetadata.get(field)), bucket.getDocCount()));            }        }        fieldCounts.put(field, valueCounts);    }    return fieldCounts;}
private String metron_f4201_0(Object key, FieldType type)
{    if (FieldType.IP.equals(type) && key instanceof Long) {        return LegacyIpFieldMapper.longToIp((Long) key);    } else if (FieldType.BOOLEAN.equals(type)) {        return (Long) key == 1 ? "true" : "false";    } else {        return key.toString();    }}
protected GroupResponse metron_f4202_0(GroupRequest groupRequest, QueryBuilder queryBuilder) throws InvalidSearchException
{    org.elasticsearch.action.search.SearchRequest esRequest;    org.elasticsearch.action.search.SearchResponse esResponse;    if (client == null) {        throw new InvalidSearchException("Uninitialized Dao!  You must call init() prior to use.");    }    if (groupRequest.getGroups() == null || groupRequest.getGroups().size() == 0) {        throw new InvalidSearchException("At least 1 group must be provided.");    }    esRequest = buildGroupRequest(groupRequest, queryBuilder);    esResponse = requestSubmitter.submitSearch(esRequest);    GroupResponse response = buildGroupResponse(groupRequest, esResponse);    return response;}
private org.elasticsearch.action.search.SearchRequest metron_f4203_0(GroupRequest groupRequest, QueryBuilder queryBuilder)
{        TermsAggregationBuilder groups = getGroupsTermBuilder(groupRequest, 0);    final SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(queryBuilder).aggregation(groups);        String[] indices = wildcardIndices(groupRequest.getIndices());    return new org.elasticsearch.action.search.SearchRequest().indices(indices).source(searchSourceBuilder);}
private TermsAggregationBuilder metron_f4204_0(GroupRequest groupRequest, int index)
{    List<Group> groups = groupRequest.getGroups();    Group group = groups.get(index);    String aggregationName = getGroupByAggregationName(group.getField());    TermsAggregationBuilder termsBuilder = AggregationBuilders.terms(aggregationName);    termsBuilder.field(group.getField()).size(accessConfig.getMaxSearchGroups()).order(getElasticsearchGroupOrder(group.getOrder()));    if (index < groups.size() - 1) {        termsBuilder.subAggregation(getGroupsTermBuilder(groupRequest, index + 1));    }    Optional<String> scoreField = groupRequest.getScoreField();    if (scoreField.isPresent()) {        SumAggregationBuilder scoreSumAggregationBuilder = AggregationBuilders.sum(getSumAggregationName(scoreField.get())).field(scoreField.get()).missing(0);        termsBuilder.subAggregation(scoreSumAggregationBuilder);    }    return termsBuilder;}
private String metron_f4205_0(String field)
{    return String.format("%s_group", field);}
private String metron_f4206_0(String field)
{    return String.format("%s_score", field);}
private Order metron_f4207_0(GroupOrder groupOrder)
{    if (groupOrder.getGroupOrderType() == GroupOrderType.TERM) {        return groupOrder.getSortOrder() == SortOrder.ASC ? Order.term(true) : Order.term(false);    } else {        return groupOrder.getSortOrder() == SortOrder.ASC ? Order.count(true) : Order.count(false);    }}
private GroupResponse metron_f4208_0(GroupRequest groupRequest, org.elasticsearch.action.search.SearchResponse response) throws InvalidSearchException
{        Map<String, FieldType> commonColumnMetadata;    try {        commonColumnMetadata = columnMetadataDao.getColumnMetadata(groupRequest.getIndices());    } catch (IOException e) {        throw new InvalidSearchException(String.format("Could not get common column metadata for indices %s", Arrays.toString(groupRequest.getIndices().toArray())));    }    GroupResponse groupResponse = new GroupResponse();    groupResponse.setGroupedBy(groupRequest.getGroups().get(0).getField());    groupResponse.setGroupResults(getGroupResults(groupRequest, 0, response.getAggregations(), commonColumnMetadata));    return groupResponse;}
private List<GroupResult> metron_f4209_0(GroupRequest groupRequest, int index, Aggregations aggregations, Map<String, FieldType> commonColumnMetadata)
{    List<Group> groups = groupRequest.getGroups();    String field = groups.get(index).getField();    List<GroupResult> searchResultGroups = new ArrayList<>();    if (aggregations != null) {        Terms terms = aggregations.get(getGroupByAggregationName(field));        for (Bucket bucket : terms.getBuckets()) {            GroupResult groupResult = new GroupResult();            groupResult.setKey(formatKey(bucket.getKey(), commonColumnMetadata.get(field)));            groupResult.setTotal(bucket.getDocCount());            Optional<String> scoreField = groupRequest.getScoreField();            if (scoreField.isPresent()) {                Sum score = bucket.getAggregations().get(getSumAggregationName(scoreField.get()));                groupResult.setScore(score.getValue());            }            if (index < groups.size() - 1) {                groupResult.setGroupedBy(groups.get(index + 1).getField());                groupResult.setGroupResults(getGroupResults(groupRequest, index + 1, bucket.getAggregations(), commonColumnMetadata));            }            searchResultGroups.add(groupResult);        }    }    return searchResultGroups;}
public Document metron_f4210_0(Document update, Optional<String> index) throws IOException
{    Map<Document, Optional<String>> updates = new HashMap<>();    updates.put(update, index);    Map<Document, Optional<String>> results = batchUpdate(updates);    return results.keySet().iterator().next();}
public Map<Document, Optional<String>> metron_f4211_1(Map<Document, Optional<String>> updates) throws IOException
{    Map<String, Object> globalConfig = accessConfig.getGlobalConfigSupplier().get();    String indexPostfix = ElasticsearchUtils.getIndexFormat(globalConfig).format(new Date());    for (Map.Entry<Document, Optional<String>> entry : updates.entrySet()) {        Document document = entry.getKey();        Optional<String> optionalIndex = entry.getValue();        String indexName = optionalIndex.orElse(getIndexName(document, indexPostfix));        documentWriter.addDocument(document, indexName);    }        BulkDocumentWriterResults<Document> results = documentWriter.write();    int failures = results.getFailures().size();    if (failures > 0) {        int successes = results.getSuccesses().size();        String msg = format("Failed to update all documents; %d successes, %d failures", successes, failures);                        for (WriteFailure<Document> failure : results.getFailures()) {                    }                Throwable cause = results.getFailures().get(0).getCause();        throw new IOException(msg, cause);    }    return updates;}
public Document metron_f4212_0(CommentAddRemoveRequest request) throws IOException
{    Document latest = retrieveLatestDao.getLatest(request.getGuid(), request.getSensorType());    return addCommentToAlert(request, latest);}
public Document metron_f4213_0(CommentAddRemoveRequest request, Document latest) throws IOException
{    if (latest == null || latest.getDocument() == null) {        throw new IOException(String.format("Unable to add comment. Document with guid %s cannot be found.", request.getGuid()));    }    List<Map<String, Object>> commentsField = (List<Map<String, Object>>) latest.getDocument().getOrDefault(COMMENTS_FIELD, new ArrayList<>());    List<Map<String, Object>> originalComments = new ArrayList<>(commentsField);    originalComments.add(new AlertComment(request.getComment(), request.getUsername(), request.getTimestamp()).asMap());    Document newVersion = new Document(latest);    newVersion.getDocument().put(COMMENTS_FIELD, originalComments);    return update(newVersion, Optional.empty());}
public Document metron_f4214_0(CommentAddRemoveRequest request) throws IOException
{    Document latest = retrieveLatestDao.getLatest(request.getGuid(), request.getSensorType());    return removeCommentFromAlert(request, latest);}
public Document metron_f4215_0(CommentAddRemoveRequest request, Document latest) throws IOException
{    if (latest == null || latest.getDocument() == null) {        throw new IOException(String.format("Unable to remove comment. Document with guid %s cannot be found.", request.getGuid()));    }    List<Map<String, Object>> commentMap = (List<Map<String, Object>>) latest.getDocument().get(COMMENTS_FIELD);        if (commentMap == null) {        throw new IOException(String.format("Unable to remove comment. Document with guid %s has no comments.", request.getGuid()));    }    List<Map<String, Object>> originalComments = new ArrayList<>(commentMap);    List<AlertComment> alertComments = new ArrayList<>();    for (Map<String, Object> commentRaw : originalComments) {        alertComments.add(new AlertComment(commentRaw));    }    alertComments.remove(new AlertComment(request.getComment(), request.getUsername(), request.getTimestamp()));    List<Map<String, Object>> commentsFinal = alertComments.stream().map(AlertComment::asMap).collect(Collectors.toList());    Document newVersion = new Document(latest);    if (commentsFinal.size() > 0) {        newVersion.getDocument().put(COMMENTS_FIELD, commentsFinal);        update(newVersion, Optional.empty());    } else {        newVersion.getDocument().remove(COMMENTS_FIELD);    }    return update(newVersion, Optional.empty());}
public ElasticsearchUpdateDao metron_f4216_0(WriteRequest.RefreshPolicy refreshPolicy)
{    documentWriter.withRefreshPolicy(refreshPolicy);    return this;}
protected String metron_f4217_0(Document update, String indexPostFix) throws IOException
{    return findIndexNameByGUID(update.getGuid(), update.getSensorType()).orElse(ElasticsearchUtils.getIndexName(update.getSensorType(), indexPostFix, null));}
protected Optional<String> metron_f4218_0(String guid, String sensorType) throws IOException
{    return retrieveLatestDao.searchByGuid(guid, sensorType, hit -> Optional.ofNullable(hit.getIndex()));}
public static SimpleDateFormat metron_f4219_0(Map<String, Object> globalConfig)
{    String format = (String) globalConfig.get("es.date.format");    return DATE_FORMAT_CACHE.get().computeIfAbsent(format, SimpleDateFormat::new);}
public static String metron_f4220_0(String sensorType, String indexPostfix, WriterConfiguration configurations)
{    String indexName = sensorType;    if (configurations != null) {        indexName = configurations.getIndex(sensorType);    }    indexName = indexName + INDEX_NAME_DELIMITER + "_" + indexPostfix;    return indexName;}
public static List<HostnamePort> metron_f4221_0(Map<String, Object> globalConfiguration)
{    Object ipObj = globalConfiguration.get("es.ip");    Object portObj = globalConfiguration.get("es.port");    if (ipObj == null) {        return Collections.emptyList();    }    if (ipObj instanceof String && ipObj.toString().contains(",") && ipObj.toString().contains(":")) {        List<String> ips = Arrays.asList(((String) ipObj).split(","));        List<HostnamePort> ret = new ArrayList<>();        for (String ip : ips) {            Iterable<String> tokens = Splitter.on(":").split(ip);            String host = Iterables.getFirst(tokens, null);            String portStr = Iterables.getLast(tokens, null);            ret.add(new HostnamePort(host, Integer.parseInt(portStr)));        }        return ret;    } else if (ipObj instanceof String && ipObj.toString().contains(",")) {        List<String> ips = Arrays.asList(((String) ipObj).split(","));        List<HostnamePort> ret = new ArrayList<>();        for (String ip : ips) {            ret.add(new HostnamePort(ip, Integer.parseInt(portObj + "")));        }        return ret;    } else if (ipObj instanceof String && !ipObj.toString().contains(":")) {        return ImmutableList.of(new HostnamePort(ipObj.toString(), Integer.parseInt(portObj + "")));    } else if (ipObj instanceof String && ipObj.toString().contains(":")) {        Iterable<String> tokens = Splitter.on(":").split(ipObj.toString());        String host = Iterables.getFirst(tokens, null);        String portStr = Iterables.getLast(tokens, null);        return ImmutableList.of(new HostnamePort(host, Integer.parseInt(portStr)));    } else if (ipObj instanceof List) {        List<String> ips = (List) ipObj;        List<HostnamePort> ret = new ArrayList<>();        for (String ip : ips) {            Iterable<String> tokens = Splitter.on(":").split(ip);            String host = Iterables.getFirst(tokens, null);            String portStr = Iterables.getLast(tokens, null);            ret.add(new HostnamePort(host, Integer.parseInt(portStr)));        }        return ret;    }    throw new IllegalStateException("Unable to read the elasticsearch ips, expected es.ip to be either a list of strings, a string hostname or a host:port string");}
public static Optional<String> metron_f4222_1(org.elasticsearch.action.search.SearchRequest esRequest)
{    Optional<String> json = Optional.empty();    if (esRequest != null && esRequest.source() != null) {        try {            BytesReference requestBytes = esRequest.source().buildAsBytes();            json = Optional.of(XContentHelper.convertToJson(requestBytes, true));        } catch (Throwable t) {                    }    }    return json;}
public static Optional<String> metron_f4223_1(Object request)
{    Optional<String> json = Optional.empty();    if (request != null) {        try {            json = Optional.of(new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(request));        } catch (Throwable t) {                    }    }    return json;}
public static SearchResponse metron_f4224_0(RestHighLevelClient transportClient, QueryBuilder qb, String index, int pageSize) throws IOException
{    org.elasticsearch.action.search.SearchRequest request = new org.elasticsearch.action.search.SearchRequest();    SearchSourceBuilder builder = new SearchSourceBuilder();    builder.query(qb);    builder.size(pageSize);    builder.fetchSource(true);    builder.storedField("*");    request.source(builder);    request.indices(index);    org.elasticsearch.action.search.SearchResponse esResponse = transportClient.search(request);    List<SearchResult> allResults = getSearchResults(esResponse);    long total = esResponse.getHits().getTotalHits();    if (total > pageSize) {        int pages = (int) (total / pageSize) + 1;        for (int i = 1; i < pages; i++) {            int from = i * pageSize;            builder.from(from);            esResponse = transportClient.search(request);            allResults.addAll(getSearchResults(esResponse));        }    }    SearchResponse searchResponse = new SearchResponse();    searchResponse.setTotal(total);    searchResponse.setResults(allResults);    return searchResponse;}
protected static List<SearchResult> metron_f4225_0(org.elasticsearch.action.search.SearchResponse searchResponse)
{    return Arrays.stream(searchResponse.getHits().getHits()).map(searchHit -> {        SearchResult searchResult = new SearchResult();        searchResult.setId(searchHit.getId());        searchResult.setSource(searchHit.getSource());        searchResult.setScore(searchHit.getScore());        searchResult.setIndex(searchHit.getIndex());        return searchResult;    }).collect(Collectors.toList());}
public void metron_f4226_0(Map stormConf, WriterConfiguration configurations)
{    Map<String, Object> globalConfiguration = configurations.getGlobalConfig();    dateFormat = ElasticsearchUtils.getIndexFormat(globalConfiguration);        if (documentWriter == null) {        client = ElasticsearchClientFactory.create(globalConfiguration);        documentWriter = new ElasticsearchBulkDocumentWriter<>(client);    }}
public BulkWriterResponse metron_f4227_0(String sensorType, WriterConfiguration configurations, List<BulkMessage<JSONObject>> messages)
{        FieldNameConverter fieldNameConverter = FieldNameConverters.create(sensorType, configurations);    String indexPostfix = dateFormat.format(new Date());    String indexName = ElasticsearchUtils.getIndexName(sensorType, indexPostfix, configurations);        for (BulkMessage<JSONObject> bulkWriterMessage : messages) {        MessageIdBasedDocument document = createDocument(bulkWriterMessage, sensorType, fieldNameConverter, configurations.isSetDocumentId(sensorType));        documentWriter.addDocument(document, indexName);    }        BulkDocumentWriterResults<MessageIdBasedDocument> results = documentWriter.write();        BulkWriterResponse response = new BulkWriterResponse();    for (WriteSuccess<MessageIdBasedDocument> success : results.getSuccesses()) {        response.addSuccess(success.getDocument().getMessageId());    }    for (WriteFailure<MessageIdBasedDocument> failure : results.getFailures()) {        response.addError(failure.getCause(), failure.getDocument().getMessageId());    }    return response;}
public String metron_f4229_0()
{    return "elasticsearch";}
public void metron_f4230_0() throws Exception
{    if (client != null) {        client.close();    }}
private void metron_f4231_0(String sourceFieldName, JSONObject source, JSONObject destination, FieldNameConverter fieldNameConverter)
{        String destinationFieldName = fieldNameConverter.convert(sourceFieldName);        destination.put(destinationFieldName, source.get(sourceFieldName));}
public void metron_f4232_0(BulkDocumentWriter<MessageIdBasedDocument> documentWriter)
{    this.documentWriter = documentWriter;}
public MessageId metron_f4233_0()
{    return messageId;}
public void metron_f4234_0()
{        highLevelClient = mock(RestHighLevelClient.class);    client = mock(ElasticsearchClient.class);    when(client.getHighLevelClient()).thenReturn(highLevelClient);    writer = new ElasticsearchBulkDocumentWriter<>(client);}
public void metron_f4235_0() throws IOException
{    setupElasticsearchToSucceed();        Document doc = document(message());    String index = "bro_index";    writer.addDocument(doc, index);    BulkDocumentWriterResults<Document> results = writer.write();    assertEquals(1, results.getSuccesses().size());    assertEquals(0, results.getFailures().size());    WriteSuccess<Document> success = results.getSuccesses().get(0);    assertEquals(doc, success.getDocument());}
public void metron_f4236_0() throws IOException
{    setupElasticsearchToFail();        Document doc = document(message());    String index = "bro_index";    writer.addDocument(doc, index);    BulkDocumentWriterResults<Document> results = writer.write();    assertEquals(0, results.getSuccesses().size());    assertEquals(1, results.getFailures().size());    WriteFailure<Document> failure = results.getFailures().get(0);    assertEquals(doc, failure.getDocument());    assertEquals("error message", failure.getMessage());    assertNotNull(failure.getCause());}
public void metron_f4237_0() throws IOException
{    setupElasticsearchToSucceed();    assertEquals(0, writer.size());        String index = "bro_index";    writer.addDocument(document(message()), index);    writer.addDocument(document(message()), index);    writer.addDocument(document(message()), index);    writer.addDocument(document(message()), index);    writer.addDocument(document(message()), index);    assertEquals(5, writer.size());        writer.write();    assertEquals(0, writer.size());}
public void metron_f4238_0() throws IOException
{    setupElasticsearchToFail();    assertEquals(0, writer.size());        String index = "bro_index";    writer.addDocument(document(message()), index);    writer.addDocument(document(message()), index);    writer.addDocument(document(message()), index);    writer.addDocument(document(message()), index);    writer.addDocument(document(message()), index);    assertEquals(5, writer.size());        writer.write();    assertEquals(0, writer.size());}
private void metron_f4239_0() throws IOException
{    final String errorMessage = "error message";    final Exception cause = new Exception("test exception");    final boolean isFailed = true;    final int itemID = 0;        BulkItemResponse.Failure failure = mock(BulkItemResponse.Failure.class);    when(failure.getCause()).thenReturn(cause);    when(failure.getMessage()).thenReturn(errorMessage);        BulkItemResponse itemResponse = mock(BulkItemResponse.class);    when(itemResponse.isFailed()).thenReturn(isFailed);    when(itemResponse.getItemId()).thenReturn(itemID);    when(itemResponse.getFailure()).thenReturn(failure);    when(itemResponse.getFailureMessage()).thenReturn("error message");    List<BulkItemResponse> itemsResponses = Collections.singletonList(itemResponse);        BulkResponse response = mock(BulkResponse.class);    when(response.iterator()).thenReturn(itemsResponses.iterator());    when(response.hasFailures()).thenReturn(isFailed);        when(highLevelClient.bulk(any(BulkRequest.class))).thenReturn(response);}
private void metron_f4240_0() throws IOException
{    final String documentId = UUID.randomUUID().toString();    final boolean isFailed = false;    final int itemID = 0;        DocWriteResponse writeResponse = mock(DocWriteResponse.class);    when(writeResponse.getId()).thenReturn(documentId);        BulkItemResponse itemResponse = mock(BulkItemResponse.class);    when(itemResponse.isFailed()).thenReturn(isFailed);    when(itemResponse.getItemId()).thenReturn(itemID);    when(itemResponse.getResponse()).thenReturn(writeResponse);    List<BulkItemResponse> itemsResponses = Collections.singletonList(itemResponse);        BulkResponse response = mock(BulkResponse.class);    when(response.iterator()).thenReturn(itemsResponses.iterator());    when(response.hasFailures()).thenReturn(isFailed);        when(highLevelClient.bulk(any(BulkRequest.class))).thenReturn(response);}
private Document metron_f4241_0(JSONObject message)
{    String guid = UUID.randomUUID().toString();    String sensorType = "bro";    Long timestamp = System.currentTimeMillis();    return new Document(message, guid, sensorType, timestamp);}
private JSONObject metron_f4242_0()
{    JSONObject message = new JSONObject();    message.put(Constants.GUID, UUID.randomUUID().toString());    message.put(Constants.Fields.TIMESTAMP.getName(), System.currentTimeMillis());    message.put(Constants.Fields.SRC_ADDR.getName(), "192.168.1.1");    return message;}
public void metron_f4243_0() throws Exception
{    tempDir = TestUtils.createTempDir(this.getClass().getName());}
public void metron_f4244_0() throws Exception
{    Path recordsFile = Paths.get(tempDir.getPath(), "inputfile.json");    Path outputFile = Paths.get(tempDir.getPath(), "outputfile.json");    TestUtils.write(recordsFile.toFile(), records);    ElasticsearchImportExport tool = new ElasticsearchImportExport();    tool.bulkify(recordsFile, outputFile);    String actual = TestUtils.read(outputFile.toFile());    assertThat(actual, equalTo(expected));}
public ElasticsearchColumnMetadataDao metron_f4245_0(String[] indices)
{    return setup(indices, new HashMap<>());}
public ElasticsearchColumnMetadataDao metron_f4246_0(String[] indices, Map<String, FieldMapping> mappings)
{    ElasticsearchClient client = new ElasticsearchClient(mock(RestClient.class), mock(RestHighLevelClient.class)) {        @Override        public String[] getIndices() throws IOException {            return indices;        }        @Override        public Map<String, FieldMapping> getMappingByIndex(String[] indices) throws IOException {            return mappings;        }    };    return new ElasticsearchColumnMetadataDao(client);}
public String[] metron_f4247_0() throws IOException
{    return indices;}
public Map<String, FieldMapping> metron_f4248_0(String[] indices) throws IOException
{    return mappings;}
public void metron_f4249_0() throws IOException
{        String[] existingIndices = new String[] { "bro_index_2017.10.03.19", "bro_index_2017.10.03.20", "bro_index_2017.10.03.21", "snort_index_2017.10.03.19", "snort_index_2017.10.03.20", "snort_index_2017.10.03.21" };    ElasticsearchColumnMetadataDao dao = setup(existingIndices);        List<String> args = Collections.singletonList("bro");    String[] actual = dao.getLatestIndices(args);        String[] expected = new String[] { "bro_index_2017.10.03.21" };    assertArrayEquals(expected, actual);}
public void metron_f4250_0() throws IOException
{        String[] existingIndices = new String[] { "bro_index_2017.10.03.19", "bro_index_2017.10.03.20", "bro_index_2017.10.03.21", "snort_index_2017.10.03.19", "snort_index_2017.10.03.19", "snort_index_2017.10.03.21" };    ElasticsearchColumnMetadataDao dao = setup(existingIndices);        List<String> args = Arrays.asList("bro", "snort");    String[] actual = dao.getLatestIndices(args);        String[] expected = new String[] { "bro_index_2017.10.03.21", "snort_index_2017.10.03.21" };    assertArrayEquals(expected, actual);}
public void metron_f4251_0() throws IOException
{        String[] existingIndices = new String[] {};    ElasticsearchColumnMetadataDao dao = setup(existingIndices);        List<String> args = Arrays.asList("bro", "snort");    String[] actual = dao.getLatestIndices(args);        String[] expected = new String[] {};    assertArrayEquals(expected, actual);}
private void metron_f4252_0(RestStatus status, int maxSearchResults, Map<String, FieldType> metadata) throws Exception
{        SearchHit hit1 = mock(SearchHit.class);    when(hit1.getId()).thenReturn("id1");    when(hit1.getSource()).thenReturn(new HashMap<String, Object>() {        {            put("field", "value1");        }    });    when(hit1.getScore()).thenReturn(0.1f);    SearchHit hit2 = mock(SearchHit.class);    when(hit2.getId()).thenReturn("id2");    when(hit2.getSource()).thenReturn(new HashMap<String, Object>() {        {            put("field", "value2");        }    });    when(hit2.getScore()).thenReturn(0.2f);        SearchHit[] hits = { hit1, hit2 };    SearchHits searchHits = mock(SearchHits.class);    when(searchHits.getHits()).thenReturn(hits);    when(searchHits.getTotalHits()).thenReturn(Integer.toUnsignedLong(hits.length));        org.elasticsearch.action.search.SearchResponse response = mock(org.elasticsearch.action.search.SearchResponse.class);    when(response.status()).thenReturn(status);    when(response.getHits()).thenReturn(searchHits);        ElasticsearchColumnMetadataDao columnMetadataDao = mock(ElasticsearchColumnMetadataDao.class);    when(columnMetadataDao.getColumnMetadata(any())).thenReturn(metadata);        requestSubmitter = mock(ElasticsearchRequestSubmitter.class);    when(requestSubmitter.submitSearch(any())).thenReturn(response);    RestHighLevelClient highLevel = mock(RestHighLevelClient.class);    ElasticsearchClient client = new ElasticsearchClient(mock(RestClient.class), highLevel);        AccessConfig config = mock(AccessConfig.class);    when(config.getMaxSearchResults()).thenReturn(maxSearchResults);    ElasticsearchSearchDao elasticsearchSearchDao = new ElasticsearchSearchDao(client, config, columnMetadataDao, requestSubmitter);    ElasticsearchRetrieveLatestDao elasticsearchRetrieveLatestDao = new ElasticsearchRetrieveLatestDao(client);    ElasticsearchUpdateDao elasticsearchUpdateDao = new ElasticsearchUpdateDao(client, config, elasticsearchRetrieveLatestDao);    dao = new ElasticsearchDao(client, config, elasticsearchSearchDao, elasticsearchUpdateDao, elasticsearchRetrieveLatestDao, columnMetadataDao, requestSubmitter);}
private void metron_f4253_0(RestStatus status, int maxSearchResults) throws Exception
{    setup(status, maxSearchResults, new HashMap<>());}
public void metron_f4254_0() throws Exception
{        Map<String, FieldType> columnMetadata = new HashMap<>();    columnMetadata.put("sortByStringDesc", FieldType.TEXT);    columnMetadata.put("sortByIntAsc", FieldType.INTEGER);        setup(RestStatus.OK, 25, columnMetadata);        SortField[] expectedSortFields = { sortBy("sortByStringDesc", SortOrder.DESC), sortBy("sortByIntAsc", SortOrder.ASC), sortBy("sortByUndefinedDesc", SortOrder.DESC) };        final List<String> indices = Arrays.asList("bro", "snort");    SearchRequest searchRequest = new SearchRequest();    searchRequest.setSize(2);    searchRequest.setIndices(indices);    searchRequest.setFrom(5);    searchRequest.setSort(Arrays.asList(expectedSortFields));    searchRequest.setQuery("some query");        SearchResponse searchResponse = dao.search(searchRequest);    assertNotNull(searchResponse);        ArgumentCaptor<org.elasticsearch.action.search.SearchRequest> argument = ArgumentCaptor.forClass(org.elasticsearch.action.search.SearchRequest.class);    verify(requestSubmitter).submitSearch(argument.capture());    org.elasticsearch.action.search.SearchRequest request = argument.getValue();        JSONParser parser = new JSONParser();    JSONObject json = (JSONObject) parser.parse(ElasticsearchUtils.toJSON(request).orElse("???"));        JSONArray sortFields = (JSONArray) json.get("sort");    assertEquals(3, sortFields.size());    {                JSONObject aSortField = (JSONObject) sortFields.get(0);        JSONObject sortBy = (JSONObject) aSortField.get("sortByStringDesc");        assertEquals("desc", sortBy.get("order"));        assertEquals("_last", sortBy.get("missing"));        assertEquals("text", sortBy.get("unmapped_type"));    }    {                JSONObject aSortField = (JSONObject) sortFields.get(1);        JSONObject sortByIntAsc = (JSONObject) aSortField.get("sortByIntAsc");        assertEquals("asc", sortByIntAsc.get("order"));        assertEquals("_first", sortByIntAsc.get("missing"));        assertEquals("integer", sortByIntAsc.get("unmapped_type"));    }    {                JSONObject aSortField = (JSONObject) sortFields.get(2);        JSONObject sortByUndefinedDesc = (JSONObject) aSortField.get("sortByUndefinedDesc");        assertEquals("desc", sortByUndefinedDesc.get("order"));        assertEquals("_last", sortByUndefinedDesc.get("missing"));        assertEquals("other", sortByUndefinedDesc.get("unmapped_type"));    }}
public void metron_f4255_0() throws Exception
{        setup(RestStatus.OK, 25);        SortField[] expectedSortFields = { sortBy("sortByStringDesc", SortOrder.DESC), sortBy("sortByIntAsc", SortOrder.ASC), sortBy("sortByUndefinedDesc", SortOrder.DESC) };        final List<String> indices = Arrays.asList("bro", "snort");    SearchRequest searchRequest = new SearchRequest();    searchRequest.setSize(2);    searchRequest.setIndices(indices);    searchRequest.setFrom(5);    searchRequest.setSort(Arrays.asList(expectedSortFields));    searchRequest.setQuery("some query");        SearchResponse searchResponse = dao.search(searchRequest);    assertNotNull(searchResponse);        ArgumentCaptor<org.elasticsearch.action.search.SearchRequest> argument = ArgumentCaptor.forClass(org.elasticsearch.action.search.SearchRequest.class);    verify(requestSubmitter).submitSearch(argument.capture());    org.elasticsearch.action.search.SearchRequest request = argument.getValue();        JSONParser parser = new JSONParser();    JSONObject json = (JSONObject) parser.parse(ElasticsearchUtils.toJSON(request).orElse("???"));        String[] expected = { "bro_index*", "snort_index*" };    assertArrayEquals(expected, request.indices());}
public void metron_f4256_0() throws Exception
{    int maxSearchResults = 20;    setup(RestStatus.OK, maxSearchResults);    SearchRequest searchRequest = new SearchRequest();    searchRequest.setSize(maxSearchResults + 1);    searchRequest.setQuery("");    dao.search(searchRequest);}
private SortField metron_f4257_0(String field, SortOrder order)
{    SortField sortField = new SortField();    sortField.setField(field);    sortField.setSortOrder(order.toString());    return sortField;}
public void metron_f4258_0()
{    IndexDao dao = new IndexDao() {        @Override        public SearchResponse search(SearchRequest searchRequest) {            return null;        }        @Override        public GroupResponse group(GroupRequest groupRequest) {            return null;        }        @Override        public void init(AccessConfig config) {        }        @Override        public Document getLatest(String guid, String sensorType) {            return null;        }        @Override        public Iterable<Document> getAllLatest(List<GetRequest> getRequests) {            return null;        }        @Override        public Document update(Document update, Optional<String> index) {            return update;        }        @Override        public Map<Document, Optional<String>> batchUpdate(Map<Document, Optional<String>> updates) {            return updates;        }        @Override        public Map<String, FieldType> getColumnMetadata(List<String> indices) {            return null;        }        @Override        public Document addCommentToAlert(CommentAddRemoveRequest request) {            return null;        }        @Override        public Document removeCommentFromAlert(CommentAddRemoveRequest request) {            return null;        }        @Override        public Document addCommentToAlert(CommentAddRemoveRequest request, Document latest) {            return null;        }        @Override        public Document removeCommentFromAlert(CommentAddRemoveRequest request, Document latest) {            return null;        }    };    ElasticsearchMetaAlertDao metaAlertDao = new ElasticsearchMetaAlertDao();    metaAlertDao.init(dao);}
public SearchResponse metron_f4259_0(SearchRequest searchRequest)
{    return null;}
public GroupResponse metron_f4260_0(GroupRequest groupRequest)
{    return null;}
public Document metron_f4262_0(String guid, String sensorType)
{    return null;}
public Iterable<Document> metron_f4263_0(List<GetRequest> getRequests)
{    return null;}
public Document metron_f4264_0(Document update, Optional<String> index)
{    return update;}
public Map<Document, Optional<String>> metron_f4265_0(Map<Document, Optional<String>> updates)
{    return updates;}
public Map<String, FieldType> metron_f4266_0(List<String> indices)
{    return null;}
public Document metron_f4267_0(CommentAddRemoveRequest request)
{    return null;}
public Document metron_f4268_0(CommentAddRemoveRequest request)
{    return null;}
public Document metron_f4269_0(CommentAddRemoveRequest request, Document latest)
{    return null;}
public Document metron_f4270_0(CommentAddRemoveRequest request, Document latest)
{    return null;}
public void metron_f4271_0()
{    HBaseDao dao = new HBaseDao();    ElasticsearchMetaAlertDao esDao = new ElasticsearchMetaAlertDao();    esDao.init(dao, Optional.empty());}
public void metron_f4272_0() throws InvalidCreateException, IOException
{    ElasticsearchDao esDao = new ElasticsearchDao();    ElasticsearchMetaAlertDao emaDao = new ElasticsearchMetaAlertDao();    emaDao.init(esDao);    MetaAlertCreateRequest createRequest = new MetaAlertCreateRequest();    emaDao.createMetaAlert(createRequest);}
public void metron_f4273_0() throws InvalidCreateException, IOException
{    ElasticsearchDao esDao = new ElasticsearchDao();    MultiIndexDao miDao = new MultiIndexDao(esDao);    ElasticsearchMetaAlertDao emaDao = new ElasticsearchMetaAlertDao();    emaDao.init(miDao);    MetaAlertCreateRequest createRequest = new MetaAlertCreateRequest();    createRequest.setAlerts(Collections.singletonList(new GetRequest("don't", "care")));    emaDao.createMetaAlert(createRequest);}
public void metron_f4274_0() throws Exception
{    ElasticsearchDao elasticsearchDao = mock(ElasticsearchDao.class);    ElasticsearchMetaAlertRetrieveLatestDao elasticsearchMetaAlertRetrieveLatestDao = mock(ElasticsearchMetaAlertRetrieveLatestDao.class);    MetaAlertConfig metaAlertConfig = mock(MetaAlertConfig.class);    ElasticsearchMetaAlertUpdateDao emauDao = spy(new ElasticsearchMetaAlertUpdateDao(elasticsearchDao, elasticsearchMetaAlertRetrieveLatestDao, metaAlertConfig, 1));    doThrow(new IndexNotFoundException(ElasticsearchMetaAlertDao.METAALERTS_INDEX)).when(emauDao).getMetaAlertsForAlert("alert_one");    Document update = new Document(new HashMap<>(), "alert_one", "", 0L);    emauDao.update(update, Optional.empty());    Map<Document, Optional<String>> expectedUpdate = new HashMap<Document, Optional<String>>() {        {            put(update, Optional.empty());        }    };    verify(elasticsearchDao).batchUpdate(expectedUpdate);}
public void metron_f4275_0() throws Exception
{    ElasticsearchDao elasticsearchDao = mock(ElasticsearchDao.class);    ElasticsearchMetaAlertRetrieveLatestDao elasticsearchMetaAlertRetrieveLatestDao = mock(ElasticsearchMetaAlertRetrieveLatestDao.class);    MetaAlertConfig metaAlertConfig = mock(MetaAlertConfig.class);    ElasticsearchMetaAlertUpdateDao emauDao = spy(new ElasticsearchMetaAlertUpdateDao(elasticsearchDao, elasticsearchMetaAlertRetrieveLatestDao, metaAlertConfig, 1));    doThrow(new IndexNotFoundException("bro")).when(emauDao).getMetaAlertsForAlert("alert_one");    Document update = new Document(new HashMap<>(), "alert_one", "", 0L);    emauDao.update(update, Optional.empty());}
public ElasticsearchRequestSubmitter metron_f4276_0(SearchResponse response) throws IOException
{        RestHighLevelClient highLevelClient = mock(RestHighLevelClient.class);    ElasticsearchClient client = new ElasticsearchClient(mock(RestClient.class), highLevelClient);        when(highLevelClient.search(any())).thenReturn(response);    return new ElasticsearchRequestSubmitter(client);}
public void metron_f4277_0() throws InvalidSearchException, IOException
{        SearchResponse response = mock(SearchResponse.class);    SearchRequest request = new SearchRequest();        SearchHits hits = mock(SearchHits.class);    when(hits.getTotalHits()).thenReturn(1L);        when(response.status()).thenReturn(RestStatus.OK);    when(response.getFailedShards()).thenReturn(0);    when(response.getTotalShards()).thenReturn(2);    when(response.getHits()).thenReturn(hits);        ElasticsearchRequestSubmitter submitter = setup(response);    SearchResponse actual = submitter.submitSearch(request);    assertNotNull(actual);}
public void metron_f4278_0() throws InvalidSearchException, IOException
{        SearchResponse response = mock(SearchResponse.class);    SearchRequest request = new SearchRequest();        when(response.status()).thenReturn(RestStatus.PARTIAL_CONTENT);    when(response.getFailedShards()).thenReturn(0);    when(response.getTotalShards()).thenReturn(2);        ElasticsearchRequestSubmitter submitter = setup(response);    submitter.submitSearch(request);}
public void metron_f4279_0() throws InvalidSearchException, IOException
{        SearchResponse response = mock(SearchResponse.class);    SearchRequest request = new SearchRequest();    ShardSearchFailure fail = mock(ShardSearchFailure.class);    SearchShardTarget target = new SearchShardTarget("node1", mock(Index.class), 1, "metron");        when(response.status()).thenReturn(RestStatus.OK);        SearchHits hits = mock(SearchHits.class);    when(hits.getTotalHits()).thenReturn(1L);        when(response.getFailedShards()).thenReturn(1);    when(response.getTotalShards()).thenReturn(2);    when(response.getHits()).thenReturn(hits);        ShardSearchFailure[] failures = { fail };    when(response.getShardFailures()).thenReturn(failures);        when(fail.shard()).thenReturn(target);        when(fail.index()).thenReturn("bro_index_2017-10-11");    when(fail.shardId()).thenReturn(1);        ElasticsearchRequestSubmitter submitter = setup(response);    SearchResponse actual = submitter.submitSearch(request);    assertNotNull(actual);}
public void metron_f4280_0()
{    accessConfig = new AccessConfig();    retrieveLatestDao = mock(ElasticsearchRetrieveLatestDao.class);    RestHighLevelClient highLevel = mock(RestHighLevelClient.class);    ElasticsearchClient client = new ElasticsearchClient(mock(RestClient.class), highLevel);    updateDao = new ElasticsearchUpdateDao(client, accessConfig, retrieveLatestDao);}
public UpdateDao metron_f4281_0()
{    return updateDao;}
public Builder metron_f4282_0(String index, String docType, String mapping)
{    mappings.add(new Mapping(index, docType, mapping));    return this;}
public Builder metron_f4283_0(int httpPort)
{    this.httpPort = httpPort;    return this;}
public Builder metron_f4284_0(File indexDir)
{    this.indexDir = indexDir;    return this;}
public Builder metron_f4285_0(Map<String, String> extraElasticSearchSettings)
{    this.extraElasticSearchSettings = extraElasticSearchSettings;    return this;}
public Builder metron_f4286_0(AccessConfig accessConfig)
{    this.accessConfig = accessConfig;    return this;}
public ElasticSearchComponent metron_f4287_0()
{    return new ElasticSearchComponent(httpPort, indexDir, extraElasticSearchSettings, mappings, accessConfig);}
public void metron_f4288_0() throws UnableToStartException
{    File logDir = new File(indexDir, "/logs");    File dataDir = new File(indexDir, "/data");    try {        cleanDir(logDir);        cleanDir(dataDir);    } catch (IOException e) {        throw new UnableToStartException("Unable to clean log or data directories", e);    }    Settings.Builder settingsBuilder = Settings.builder().put("cluster.name", "metron").put("path.logs", logDir.getAbsolutePath()).put("path.data", dataDir.getAbsolutePath()).put("path.home", indexDir.getAbsoluteFile()).put("transport.type", "netty4").put("http.enabled", "true");    if (extraElasticSearchSettings != null) {        settingsBuilder = settingsBuilder.put(extraElasticSearchSettings);    }    node = new TestNode(settingsBuilder.build(), asList(Netty4Plugin.class));    client = node.client();    try {        node.start();    } catch (NodeValidationException e) {        throw new UnableToStartException("Error starting ES node.", e);    }    waitForCluster(client, ClusterHealthStatus.YELLOW, STARTUP_TIMEOUT);    for (Mapping m : Optional.ofNullable(mappings).orElse(new ArrayList<>())) {        client.admin().indices().prepareCreate(m.index).addMapping(m.docType, m.mapping).get();    }    indexDao = new ElasticsearchDao().withRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);    indexDao.init(accessConfig);}
private void metron_f4289_0(File dir) throws IOException
{    if (dir.exists()) {        FileUtils.deleteDirectory(dir);    }    dir.mkdirs();}
public static void metron_f4290_0(Client client, ClusterHealthStatus statusThreshold, String timeout) throws UnableToStartException
{    try {        ClusterHealthResponse healthResponse = (ClusterHealthResponse) client.execute(ClusterHealthAction.INSTANCE, new ClusterHealthRequest().waitForStatus(statusThreshold).timeout(timeout)).actionGet();        if (healthResponse != null && healthResponse.isTimedOut()) {            throw new UnableToStartException("cluster state is " + healthResponse.getStatus().name() + " and not " + statusThreshold.name() + ", from here on, everything will fail!");        }    } catch (ElasticsearchTimeoutException e) {        throw new UnableToStartException("timeout, cluster does not respond to health request, cowardly refusing to continue with operations");    }}
public Client metron_f4291_0()
{    return client;}
public void metron_f4292_0(String indexName, String sensorType, String... docs) throws IOException, ParseException
{    List<String> d = new ArrayList<>();    Collections.addAll(d, docs);    add(indexName, sensorType, d, false);}
public void metron_f4293_0(String indexName, String sensorType, Iterable<String> docs) throws IOException, ParseException
{    add(indexName, sensorType, docs, false);}
public void metron_f4294_0(String indexName, String sensorType, Iterable<String> docs, boolean setDocumentId) throws IOException, ParseException
{        JSONParser parser = new JSONParser();    Map<Document, Optional<String>> documents = new HashMap<>();    for (String json : docs) {        JSONObject message = (JSONObject) parser.parse(json);        documents.put(createDocument(message, sensorType, setDocumentId), Optional.of(indexName));    }        indexDao.batchUpdate(documents);}
private static Document metron_f4295_0(JSONObject message, String docType, boolean setDocumentId) throws IOException
{    Long timestamp = ConversionUtils.convert(message.get("timestamp"), Long.class);    String source = message.toJSONString();    String guid = (String) message.get("guid");    Document document = new Document(source, guid, docType, timestamp);    if (setDocumentId) {        document.setDocumentID(guid);    }    return document;}
public void metron_f4296_0(String indexName, String mappingType, String mappingSource) throws IOException
{    CreateIndexResponse cir = client.admin().indices().prepareCreate(indexName).addMapping(mappingType, mappingSource).get();    if (!cir.isAcknowledged()) {        throw new IOException("Create index was not acknowledged");    }}
public List<Map<String, Object>> metron_f4297_0(String index, String sourceType) throws IOException
{    return getAllIndexedDocs(index, sourceType, null);}
public List<Map<String, Object>> metron_f4298_0(String index, String sourceType, String subMessage) throws IOException
{    getClient().admin().indices().refresh(new RefreshRequest());    SearchResponse response = getClient().prepareSearch(index).setTypes(sourceType).setFrom(0).setSize(1000).execute().actionGet();    List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();    for (SearchHit hit : response.getHits()) {        Object o = null;        if (subMessage == null) {            o = hit.getSource();        } else {            o = hit.getSource().get(subMessage);        }        ret.add((Map<String, Object>) (o));    }    return ret;}
public boolean metron_f4299_0(String indexName)
{    Set<String> indices = getClient().admin().indices().stats(new IndicesStatsRequest()).actionGet().getIndices().keySet();    return indices.contains(indexName);}
public void metron_f4300_0()
{    try {        if (node != null) {            node.close();        }    } catch (IOException e) {        throw new RuntimeException("Unable to stop node.", e);    }    node = null;    client = null;}
public void metron_f4301_0()
{    client.admin().indices().delete(new DeleteIndexRequest("*")).actionGet();}
public static void metron_f4302_0() throws Exception
{    AccessConfig accessConfig = new AccessConfig();    accessConfig.setGlobalConfigSupplier(() -> globals());    elasticsearch = new ElasticSearchComponent.Builder().withHttpPort(9211).withIndexDir(indexDir.getRoot()).withAccessConfig(accessConfig).build();    elasticsearch.start();}
public static void metron_f4303_0()
{    if (elasticsearch != null) {        elasticsearch.stop();    }}
public void metron_f4304_0() throws Exception
{    client = ElasticsearchClientFactory.create(globals());    retrieveDao = new ElasticsearchRetrieveLatestDao(client);    writer = new ElasticsearchBulkDocumentWriter<>(client).withRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);        JSONObject broTemplate = JSONUtils.INSTANCE.load(new File(broTemplatePath), JSONObject.class);    String broTemplateJson = JSONUtils.INSTANCE.toJSON(broTemplate, true);    HttpEntity broEntity = new NStringEntity(broTemplateJson, ContentType.APPLICATION_JSON);    Response response = client.getLowLevelClient().performRequest("PUT", "/_template/bro_template", Collections.emptyMap(), broEntity);    assertThat(response.getStatusLine().getStatusCode(), CoreMatchers.equalTo(200));}
public void metron_f4305_0() throws IOException
{    if (client != null) {        client.close();    }}
public void metron_f4306_0() throws Exception
{        List<Document> documents = new ArrayList<>();    for (int i = 0; i < 10; i++) {        Document document = Document.fromJSON(createMessage());        documents.add(document);    }        for (Document doc : documents) {        writer.addDocument(doc, "bro_index");    }    writer.write();        for (Document expected : documents) {        Document actual = retrieveDao.getLatest(expected.getGuid(), expected.getSensorType());        assertNotNull("No document found", actual);        assertEquals(expected.getGuid(), actual.getGuid());        assertEquals(expected.getSensorType(), actual.getSensorType());        assertEquals(expected.getDocument(), actual.getDocument());        assertTrue(actual.getDocumentID().isPresent());                assertNotEquals(actual.getDocument(), actual.getGuid());    }}
private static Map<String, Object> metron_f4307_0()
{    Map<String, Object> globals = new HashMap<>();    globals.put("es.clustername", "metron");    globals.put("es.ip", "localhost");    globals.put("es.port", "9200");    globals.put("es.date.format", "yyyy.MM.dd.HH");    return globals;}
private JSONObject metron_f4308_0()
{    JSONObject message = new JSONObject();    message.put(Constants.GUID, UUID.randomUUID().toString());    message.put(Constants.Fields.TIMESTAMP.getName(), System.currentTimeMillis());    message.put(Constants.Fields.SRC_ADDR.getName(), "192.168.1.1");    message.put("source:type", "bro");    return message;}
public static Collection<Object[]> metron_f4309_0()
{    Function<List<String>, List<String>> asteriskTransform = x -> ImmutableList.of("*");    Function<List<String>, List<String>> explicitTransform = allIndices -> allIndices.stream().map(x -> x.replace("_index", "")).collect(Collectors.toCollection(ArrayList::new));    return Arrays.asList(new Object[][] { { asteriskTransform }, { explicitTransform } });}
public static void metron_f4310_0() throws Exception
{        MAX_RETRIES = 10;    Map<String, Object> globalConfig = new HashMap<String, Object>() {        {            put("es.clustername", "metron");            put("es.port", "9200");            put("es.ip", "localhost");            put("es.date.format", DATE_FORMAT);        }    };    accessConfig = new AccessConfig();    accessConfig.setMaxSearchResults(1000);    accessConfig.setMaxSearchGroups(100);    accessConfig.setGlobalConfigSupplier(() -> globalConfig);        es = new ElasticSearchComponent.Builder().withHttpPort(9211).withIndexDir(new File(INDEX_DIR)).withAccessConfig(accessConfig).build();    es.start();}
public void metron_f4311_0() throws IOException
{    es.createIndexWithMapping(METAALERTS_INDEX, METAALERT_DOC, template.replace("%MAPPING_NAME%", METAALERT_TYPE));    es.createIndexWithMapping(INDEX, "test_doc", template.replace("%MAPPING_NAME%", "test"));    esDao = new ElasticsearchDao();    esDao.init(accessConfig);    ElasticsearchMetaAlertDao elasticsearchMetaDao = new ElasticsearchMetaAlertDao(esDao);    elasticsearchMetaDao.setPageSize(5);    metaDao = elasticsearchMetaDao;}
public static void metron_f4312_0()
{    if (es != null) {        es.stop();    }}
public void metron_f4313_0()
{    es.reset();}
public void metron_f4314_0() throws Exception
{        List<Map<String, Object>> alerts = buildAlerts(4);    alerts.get(0).put(METAALERT_FIELD, Collections.singletonList("meta_active"));    alerts.get(0).put("ip_src_addr", "192.168.1.1");    alerts.get(0).put("ip_src_port", 8010);    alerts.get(1).put(METAALERT_FIELD, Collections.singletonList("meta_active"));    alerts.get(1).put("ip_src_addr", "192.168.1.2");    alerts.get(1).put("ip_src_port", 8009);    alerts.get(2).put("ip_src_addr", "192.168.1.3");    alerts.get(2).put("ip_src_port", 8008);    alerts.get(3).put("ip_src_addr", "192.168.1.4");    alerts.get(3).put("ip_src_port", 8007);    addRecords(alerts, INDEX, SENSOR_NAME);        setupTypings();        Map<String, Object> activeMetaAlert = buildMetaAlert("meta_active", MetaAlertStatus.ACTIVE, Optional.of(Arrays.asList(alerts.get(0), alerts.get(1))));    Map<String, Object> inactiveMetaAlert = buildMetaAlert("meta_inactive", MetaAlertStatus.INACTIVE, Optional.of(Arrays.asList(alerts.get(2), alerts.get(3))));        addRecords(Arrays.asList(activeMetaAlert, inactiveMetaAlert), METAALERTS_INDEX, METAALERT_TYPE);        findCreatedDocs(Arrays.asList(new GetRequest("message_0", SENSOR_NAME), new GetRequest("message_1", SENSOR_NAME), new GetRequest("message_2", SENSOR_NAME), new GetRequest("message_3", SENSOR_NAME), new GetRequest("meta_active", METAALERT_TYPE), new GetRequest("meta_inactive", METAALERT_TYPE)));    SearchResponse searchResponse = metaDao.search(new SearchRequest() {        {            setQuery("(ip_src_addr:192.168.1.1 AND ip_src_port:8009) OR (metron_alert.ip_src_addr:192.168.1.1 AND metron_alert.ip_src_port:8009)");            setIndices(Collections.singletonList(METAALERT_TYPE));            setFrom(0);            setSize(5);            setSort(Collections.singletonList(new SortField() {                {                    setField(Constants.GUID);                }            }));        }    });        Assert.assertEquals(0, searchResponse.getTotal());            searchResponse = metaDao.search(new SearchRequest() {        {            setQuery("(ip_src_addr:192.168.1.1 AND ip_src_port:8010)" + " OR (metron_alert.ip_src_addr:192.168.1.1 AND metron_alert.ip_src_port:8010)");            setIndices(queryIndices);            setFrom(0);            setSize(5);            setSort(Collections.singletonList(new SortField() {                {                    setField(Constants.GUID);                }            }));        }    });        Assert.assertEquals(1, searchResponse.getTotal());    Assert.assertEquals("meta_active", searchResponse.getResults().get(0).getSource().get("guid"));            searchResponse = metaDao.search(new SearchRequest() {        {            setQuery("(ip_src_addr:192.168.1.3 AND ip_src_port:8008)" + " OR (metron_alert.ip_src_addr:192.168.1.3 AND metron_alert.ip_src_port:8008)");            setIndices(Collections.singletonList("*"));            setFrom(0);            setSize(1);            setSort(Collections.singletonList(new SortField() {                {                    setField(Constants.GUID);                }            }));        }    });        Assert.assertEquals(1, searchResponse.getTotal());    Assert.assertEquals("message_2", searchResponse.getResults().get(0).getSource().get("guid"));}
protected long metron_f4315_0(String fieldName, Object fieldValue) throws IOException, InterruptedException
{    long cnt = 0;    for (int t = 0; t < MAX_RETRIES && cnt == 0; ++t, Thread.sleep(SLEEP_MS)) {        List<Map<String, Object>> docs = es.getAllIndexedDocs(INDEX, SENSOR_NAME + "_doc");        cnt = docs.stream().filter(d -> {            Object newfield = d.get(fieldName);            return newfield != null && newfield.equals(fieldValue);        }).count();    }    return cnt;}
protected long metron_f4316_0(String fieldName, String fieldValue) throws IOException, InterruptedException
{    long cnt = 0;    for (int t = 0; t < MAX_RETRIES && cnt == 0; ++t, Thread.sleep(SLEEP_MS)) {        List<Map<String, Object>> docs = es.getAllIndexedDocs(METAALERTS_INDEX, METAALERT_DOC);        cnt = docs.stream().filter(d -> {            @SuppressWarnings("unchecked")            List<Map<String, Object>> alerts = (List<Map<String, Object>>) d.get(ALERT_FIELD);            for (Map<String, Object> alert : alerts) {                Object newField = alert.get(fieldName);                if (newField != null && newField.equals(fieldValue)) {                    return true;                }            }            return false;        }).count();    }    return cnt;}
protected void metron_f4317_0(List<Map<String, Object>> inputData, String index, String docType) throws IOException, ParseException
{    es.add(index, docType, inputData.stream().map(m -> {        try {            return JSONUtils.INSTANCE.toJSON(m, true);        } catch (JsonProcessingException e) {            throw new IllegalStateException(e.getMessage(), e);        }    }).collect(Collectors.toList()));}
protected void metron_f4318_0() throws IOException
{    ((ElasticsearchDao) esDao).getClient().putMapping(INDEX, "test_doc", nestedAlertMapping);}
protected String metron_f4319_0()
{    return INDEX_RAW;}
protected String metron_f4320_0()
{    return INDEX;}
protected String metron_f4321_0()
{    return METAALERTS_INDEX;}
protected String metron_f4322_0()
{    return ElasticsearchMetaAlertDao.SOURCE_TYPE_FIELD;}
protected void metron_f4323_0(Map<String, Object> docMap)
{    docMap.put(METAALERT_FIELD, new ArrayList<>());}
protected boolean metron_f4324_0()
{    return true;}
protected boolean metron_f4325_0()
{    return true;}
public static void metron_f4326_0() throws Exception
{    globalConfig = new HashMap<String, Object>() {        {            put("es.clustername", "metron");            put("es.port", "9200");            put("es.ip", "localhost");            put("es.date.format", dateFormat);        }    };    accessConfig = new AccessConfig();    accessConfig.setMaxSearchResults(100);    accessConfig.setMaxSearchGroups(100);    accessConfig.setGlobalConfigSupplier(() -> globalConfig);    indexComponent = startIndex();    ElasticsearchClient esClient = ElasticsearchClientFactory.create(globalConfig);    lowLevelClient = esClient.getLowLevelClient();    highLevelClient = esClient.getHighLevelClient();    dao = new ElasticsearchDao();    dao.init(accessConfig);        loadTestData();}
protected static InMemoryComponent metron_f4327_0() throws Exception
{    InMemoryComponent es = new ElasticSearchComponent.Builder().withHttpPort(9211).withIndexDir(new File(indexDir)).withAccessConfig(accessConfig).build();    es.start();    return es;}
protected static void metron_f4328_0() throws Exception
{    ElasticSearchComponent es = (ElasticSearchComponent) indexComponent;        JSONObject broTemplate = JSONUtils.INSTANCE.load(new File(broTemplatePath), JSONObject.class);    addTestFieldMappings(broTemplate, "bro_doc");    String broTemplateJson = JSONUtils.INSTANCE.toJSON(broTemplate, true);    HttpEntity broEntity = new NStringEntity(broTemplateJson, ContentType.APPLICATION_JSON);    Response response = lowLevelClient.performRequest("PUT", "/_template/bro_template", Collections.emptyMap(), broEntity);    assertThat(response.getStatusLine().getStatusCode(), equalTo(200));        JSONObject snortTemplate = JSONUtils.INSTANCE.load(new File(snortTemplatePath), JSONObject.class);    addTestFieldMappings(snortTemplate, "snort_doc");    String snortTemplateJson = JSONUtils.INSTANCE.toJSON(snortTemplate, true);    HttpEntity snortEntity = new NStringEntity(snortTemplateJson, ContentType.APPLICATION_JSON);    response = lowLevelClient.performRequest("PUT", "/_template/snort_template", Collections.emptyMap(), snortEntity);    assertThat(response.getStatusLine().getStatusCode(), equalTo(200));        response = lowLevelClient.performRequest("PUT", BRO_INDEX);    assertThat(response.getStatusLine().getStatusCode(), equalTo(200));        response = lowLevelClient.performRequest("PUT", SNORT_INDEX);    assertThat(response.getStatusLine().getStatusCode(), equalTo(200));        List<String> broDocuments = new ArrayList<>();    for (Object broObject : (JSONArray) new JSONParser().parse(broData)) {        broDocuments.add(((JSONObject) broObject).toJSONString());    }        es.add(BRO_INDEX, "bro", broDocuments.subList(0, 4), true);        es.add(BRO_INDEX, "bro", broDocuments.subList(4, 5), false);        List<String> snortDocuments = new ArrayList<>();    for (Object snortObject : (JSONArray) new JSONParser().parse(snortData)) {        snortDocuments.add(((JSONObject) snortObject).toJSONString());    }    es.add(SNORT_INDEX, "snort", snortDocuments);}
private static void metron_f4329_0(JSONObject template, String docType)
{    Map mappings = (Map) template.get("mappings");    Map docTypeJSON = (Map) mappings.get(docType);    Map properties = (Map) docTypeJSON.get("properties");    Map<String, String> longType = new HashMap<>();    longType.put("type", "long");    properties.put("long_field", longType);    Map<String, String> floatType = new HashMap<>();    floatType.put("type", "float");    properties.put("latitude", floatType);    Map<String, String> doubleType = new HashMap<>();    doubleType.put("type", "double");    properties.put("score", doubleType);}
public void metron_f4330_0() throws Exception
{    thrown.expect(InvalidSearchException.class);    thrown.expectMessage("Failed to execute search");    SearchRequest request = JSONUtils.INSTANCE.load(badFacetQuery, SearchRequest.class);    dao.search(request);}
public void metron_f4331_0() throws Exception
{        {        Map<String, FieldType> fieldTypes = dao.getColumnMetadata(Collections.singletonList("bro"));        Assert.assertEquals(262, fieldTypes.size());        Assert.assertEquals(FieldType.KEYWORD, fieldTypes.get("method"));        Assert.assertEquals(FieldType.KEYWORD, fieldTypes.get("ttl"));        Assert.assertEquals(FieldType.KEYWORD, fieldTypes.get("guid"));        Assert.assertEquals(FieldType.KEYWORD, fieldTypes.get("source:type"));        Assert.assertEquals(FieldType.IP, fieldTypes.get("ip_src_addr"));        Assert.assertEquals(FieldType.INTEGER, fieldTypes.get("ip_src_port"));        Assert.assertEquals(FieldType.LONG, fieldTypes.get("long_field"));        Assert.assertEquals(FieldType.DATE, fieldTypes.get("timestamp"));        Assert.assertEquals(FieldType.FLOAT, fieldTypes.get("latitude"));        Assert.assertEquals(FieldType.DOUBLE, fieldTypes.get("score"));        Assert.assertEquals(FieldType.BOOLEAN, fieldTypes.get("is_alert"));        Assert.assertEquals(FieldType.TEXT, fieldTypes.get("location_point"));        Assert.assertEquals(FieldType.OTHER, fieldTypes.get("metron_alert"));    }        {        Map<String, FieldType> fieldTypes = dao.getColumnMetadata(Collections.singletonList("snort"));        Assert.assertEquals(32, fieldTypes.size());        Assert.assertEquals(FieldType.KEYWORD, fieldTypes.get("sig_generator"));        Assert.assertEquals(FieldType.INTEGER, fieldTypes.get("ttl"));        Assert.assertEquals(FieldType.KEYWORD, fieldTypes.get("guid"));        Assert.assertEquals(FieldType.KEYWORD, fieldTypes.get("source:type"));        Assert.assertEquals(FieldType.IP, fieldTypes.get("ip_src_addr"));        Assert.assertEquals(FieldType.INTEGER, fieldTypes.get("ip_src_port"));        Assert.assertEquals(FieldType.LONG, fieldTypes.get("long_field"));        Assert.assertEquals(FieldType.DATE, fieldTypes.get("timestamp"));        Assert.assertEquals(FieldType.FLOAT, fieldTypes.get("latitude"));        Assert.assertEquals(FieldType.DOUBLE, fieldTypes.get("score"));        Assert.assertEquals(FieldType.BOOLEAN, fieldTypes.get("is_alert"));        Assert.assertEquals(FieldType.TEXT, fieldTypes.get("location_point"));        Assert.assertEquals(FieldType.INTEGER, fieldTypes.get("ttl"));        Assert.assertEquals(FieldType.OTHER, fieldTypes.get("metron_alert"));    }}
public void metron_f4332_0() throws Exception
{    Map<String, FieldType> fieldTypes = dao.getColumnMetadata(Arrays.asList("bro", "snort"));    Assert.assertEquals(277, fieldTypes.size());        Assert.assertEquals(FieldType.KEYWORD, fieldTypes.get("guid"));    Assert.assertEquals(FieldType.KEYWORD, fieldTypes.get("source:type"));    Assert.assertEquals(FieldType.FLOAT, fieldTypes.get("threat:triage:score"));    Assert.assertEquals(FieldType.KEYWORD, fieldTypes.get("alert_status"));    Assert.assertEquals(FieldType.OTHER, fieldTypes.get("metron_alert"));    Assert.assertEquals(FieldType.IP, fieldTypes.get("ip_src_addr"));    Assert.assertEquals(FieldType.INTEGER, fieldTypes.get("ip_src_port"));    Assert.assertEquals(FieldType.LONG, fieldTypes.get("long_field"));    Assert.assertEquals(FieldType.DATE, fieldTypes.get("timestamp"));    Assert.assertEquals(FieldType.FLOAT, fieldTypes.get("latitude"));    Assert.assertEquals(FieldType.DOUBLE, fieldTypes.get("score"));    Assert.assertEquals(FieldType.DOUBLE, fieldTypes.get("suppress_for"));    Assert.assertEquals(FieldType.BOOLEAN, fieldTypes.get("is_alert"));        Assert.assertEquals(FieldType.KEYWORD, fieldTypes.get("method"));        Assert.assertEquals(FieldType.KEYWORD, fieldTypes.get("sig_generator"));        Assert.assertEquals(FieldType.OTHER, fieldTypes.get("ttl"));    Assert.assertEquals(FieldType.OTHER, fieldTypes.get("msg"));}
public void metron_f4333_0() throws Exception
{    thrown.expect(InvalidSearchException.class);    thrown.expectMessage("Failed to execute search");    GroupRequest request = JSONUtils.INSTANCE.load(badGroupQuery, GroupRequest.class);    dao.group(request);}
public void metron_f4334_0() throws Exception
{    SearchRequest request = JSONUtils.INSTANCE.load(differentTypeFilterQuery, SearchRequest.class);    SearchResponse response = dao.search(request);    Assert.assertEquals(1, response.getTotal());    List<SearchResult> results = response.getResults();    Assert.assertEquals("bro", results.get(0).getSource().get("source:type"));    Assert.assertEquals("data 1", results.get(0).getSource().get("ttl"));}
protected String metron_f4335_0()
{    return Constants.SENSOR_TYPE.replace('.', ':');}
protected IndexDao metron_f4336_0()
{    return dao;}
protected String metron_f4337_0(String sensorType)
{    if ("bro".equals(sensorType)) {        return BRO_INDEX;    } else {        return SNORT_INDEX;    }}
protected String metron_f4338_0()
{    return SENSOR_NAME + "_index_" + new SimpleDateFormat(dateFormat).format(new Date());}
public static void metron_f4339_0() throws UnableToStartException, IOException
{    Configuration config = HBaseConfiguration.create();    MockHBaseTableProvider tableProvider = new MockHBaseTableProvider();    MockHBaseTableProvider.addToCache(TABLE_NAME, CF);    table = (MockHTable) tableProvider.getTable(config, TABLE_NAME);    globalConfig = new HashMap<>();    globalConfig.put("es.clustername", "metron");    globalConfig.put("es.port", "9200");    globalConfig.put("es.ip", "localhost");    globalConfig.put("es.date.format", dateFormat);    globalConfig.put(HBaseDao.HBASE_TABLE, TABLE_NAME);    globalConfig.put(HBaseDao.HBASE_CF, CF);    accessConfig = new AccessConfig();    accessConfig.setTableProvider(tableProvider);    accessConfig.setGlobalConfigSupplier(() -> globalConfig);    es = new ElasticSearchComponent.Builder().withHttpPort(9211).withIndexDir(new File(indexDir)).withAccessConfig(accessConfig).build();    es.start();    installIndexTemplate();}
public void metron_f4340_0()
{    elasticsearchDao = new ElasticsearchDao().withRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);    elasticsearchDao.init(accessConfig);    setDao(elasticsearchDao);}
public void metron_f4341_0()
{    es.reset();    table.clear();}
public static void metron_f4342_0()
{    es.stop();}
protected void metron_f4343_0(String indexName, String sensorType, List<Map<String, Object>> docs) throws Exception
{    es.add(index, SENSOR_NAME, Iterables.transform(docs, m -> {        try {            return JSONUtils.INSTANCE.toJSON(m, true);        } catch (JsonProcessingException e) {            throw new IllegalStateException(e.getMessage(), e);        }    }));}
protected List<Map<String, Object>> metron_f4344_0(String indexName, String sensorType) throws Exception
{    return es.getAllIndexedDocs(index, SENSOR_NAME + "_doc");}
private static void metron_f4345_0() throws IOException
{    HttpEntity broEntity = new NStringEntity(indexTemplate, ContentType.APPLICATION_JSON);    ElasticsearchClient client = ElasticsearchClientFactory.create(globalConfig);    Response response = client.getLowLevelClient().performRequest("PUT", "/_template/test_template", Collections.emptyMap(), broEntity);    Assert.assertThat(response.getStatusLine().getStatusCode(), CoreMatchers.equalTo(200));}
public void metron_f4346_0()
{    writerConfiguration = mock(WriterConfiguration.class);    when(writerConfiguration.getGlobalConfig()).thenReturn(globals());    stormConf = new HashMap();}
public void metron_f4347_0()
{        List<BulkMessage<JSONObject>> messages = createMessages(1);        BulkDocumentWriterResults<MessageIdBasedDocument> results = new BulkDocumentWriterResults<>();    results.addSuccess(createDocument(messages.get(0)));    BulkDocumentWriter<MessageIdBasedDocument> docWriter = mock(BulkDocumentWriter.class);    when(docWriter.write()).thenReturn(results);        ElasticsearchWriter esWriter = new ElasticsearchWriter();    esWriter.setDocumentWriter(docWriter);    esWriter.init(stormConf, writerConfiguration);    BulkWriterResponse response = esWriter.write("bro", writerConfiguration, messages);        assertFalse(response.hasErrors());    assertTrue(response.getSuccesses().contains(new MessageId("message1")));}
public void metron_f4348_0()
{        List<BulkMessage<JSONObject>> messages = createMessages(3);        BulkDocumentWriterResults<MessageIdBasedDocument> results = new BulkDocumentWriterResults<>();    results.addSuccess(createDocument(messages.get(0)));    results.addSuccess(createDocument(messages.get(1)));    results.addSuccess(createDocument(messages.get(2)));    BulkDocumentWriter<MessageIdBasedDocument> docWriter = mock(BulkDocumentWriter.class);    when(docWriter.write()).thenReturn(results);        ElasticsearchWriter esWriter = new ElasticsearchWriter();    esWriter.setDocumentWriter(docWriter);    esWriter.init(stormConf, writerConfiguration);    BulkWriterResponse response = esWriter.write("bro", writerConfiguration, messages);        assertFalse(response.hasErrors());    assertTrue(response.getSuccesses().contains(new MessageId("message1")));    assertTrue(response.getSuccesses().contains(new MessageId("message2")));    assertTrue(response.getSuccesses().contains(new MessageId("message3")));}
public void metron_f4349_0()
{        List<BulkMessage<JSONObject>> messages = createMessages(3);    Exception cause = new Exception();        BulkDocumentWriterResults<MessageIdBasedDocument> results = new BulkDocumentWriterResults<>();    results.addFailure(createDocument(messages.get(0)), cause, "error");    BulkDocumentWriter<MessageIdBasedDocument> docWriter = mock(BulkDocumentWriter.class);    when(docWriter.write()).thenReturn(results);        ElasticsearchWriter esWriter = new ElasticsearchWriter();    esWriter.setDocumentWriter(docWriter);    esWriter.init(stormConf, writerConfiguration);    BulkWriterResponse response = esWriter.write("bro", writerConfiguration, messages);        assertEquals(0, response.getSuccesses().size());    assertEquals(1, response.getErrors().size());    Collection<MessageId> errors = response.getErrors().get(cause);    assertTrue(errors.contains(new MessageId("message1")));}
public void metron_f4350_0()
{        int count = 3;    List<BulkMessage<JSONObject>> messages = createMessages(count);    Exception cause = new Exception();        BulkDocumentWriterResults<MessageIdBasedDocument> results = new BulkDocumentWriterResults<>();    results.addFailure(createDocument(messages.get(0)), cause, "error");    results.addFailure(createDocument(messages.get(1)), cause, "error");    results.addFailure(createDocument(messages.get(2)), cause, "error");    BulkDocumentWriter<MessageIdBasedDocument> docWriter = mock(BulkDocumentWriter.class);    when(docWriter.write()).thenReturn(results);        ElasticsearchWriter esWriter = new ElasticsearchWriter();    esWriter.setDocumentWriter(docWriter);    esWriter.init(stormConf, writerConfiguration);    BulkWriterResponse response = esWriter.write("bro", writerConfiguration, messages);        assertEquals(0, response.getSuccesses().size());    assertEquals(1, response.getErrors().size());    Collection<MessageId> errors = response.getErrors().get(cause);    assertTrue(errors.contains(new MessageId("message1")));    assertTrue(errors.contains(new MessageId("message2")));    assertTrue(errors.contains(new MessageId("message3")));}
public void metron_f4351_0()
{        int count = 2;    List<BulkMessage<JSONObject>> messages = createMessages(count);    Exception cause = new Exception();        BulkDocumentWriterResults<MessageIdBasedDocument> results = new BulkDocumentWriterResults<>();    results.addFailure(createDocument(messages.get(0)), cause, "error");    results.addSuccess(createDocument(messages.get(1)));    BulkDocumentWriter<MessageIdBasedDocument> docWriter = mock(BulkDocumentWriter.class);    when(docWriter.write()).thenReturn(results);        ElasticsearchWriter esWriter = new ElasticsearchWriter();    esWriter.setDocumentWriter(docWriter);    esWriter.init(stormConf, writerConfiguration);    BulkWriterResponse response = esWriter.write("bro", writerConfiguration, messages);        assertEquals(1, response.getSuccesses().size());    assertEquals(1, response.getErrors().size());    assertTrue(response.getErrors().get(cause).contains(new MessageId("message1")));    assertTrue(response.getSuccesses().contains(new MessageId("message2")));}
public void metron_f4352_0()
{    List<BulkMessage<JSONObject>> messages = createMessages(1);    JSONObject message = messages.get(0).getMessage();        message.put(Constants.Fields.TIMESTAMP.getName(), new Long(System.currentTimeMillis()).toString());        String timestamp = (String) message.get(Constants.Fields.TIMESTAMP.getName());    String guid = (String) message.get(Constants.GUID);    String sensorType = (String) message.get(Constants.SENSOR_TYPE);    MessageIdBasedDocument document = new MessageIdBasedDocument(message, guid, sensorType, Long.parseLong(timestamp), new MessageId("message1"));        BulkDocumentWriterResults<MessageIdBasedDocument> results = new BulkDocumentWriterResults<>();    results.addSuccess(document);    BulkDocumentWriter<MessageIdBasedDocument> docWriter = mock(BulkDocumentWriter.class);    when(docWriter.write()).thenReturn(results);        ElasticsearchWriter esWriter = new ElasticsearchWriter();    esWriter.setDocumentWriter(docWriter);    esWriter.init(stormConf, writerConfiguration);    BulkWriterResponse response = esWriter.write("bro", writerConfiguration, messages);        assertFalse(response.hasErrors());    assertTrue(response.getSuccesses().contains(new MessageId("message1")));}
public void metron_f4353_0()
{        List<BulkMessage<JSONObject>> messages = createMessages(1);        assertNotNull(messages.get(0).getMessage().remove(Constants.GUID));        BulkDocumentWriterResults<MessageIdBasedDocument> results = new BulkDocumentWriterResults<>();    results.addSuccess(createDocument(messages.get(0)));    BulkDocumentWriter<MessageIdBasedDocument> docWriter = mock(BulkDocumentWriter.class);    when(docWriter.write()).thenReturn(results);        ElasticsearchWriter esWriter = new ElasticsearchWriter();    esWriter.setDocumentWriter(docWriter);    esWriter.init(stormConf, writerConfiguration);    BulkWriterResponse response = esWriter.write("bro", writerConfiguration, messages);        assertFalse(response.hasErrors());    assertTrue(response.getSuccesses().contains(new MessageId("message1")));}
public void metron_f4354_0()
{    when(writerConfiguration.isSetDocumentId("bro")).thenReturn(true);    when(writerConfiguration.getFieldNameConverter("bro")).thenReturn("NOOP");    mockStatic(ElasticsearchUtils.class);    when(ElasticsearchUtils.getIndexFormat(globals())).thenReturn(new SimpleDateFormat());    when(ElasticsearchUtils.getIndexName(eq("bro"), any(), eq(writerConfiguration))).thenReturn("bro_index");        List<BulkMessage<JSONObject>> messages = createMessages(3);        MessageIdBasedDocument document1 = createDocument(messages.get(0));    MessageIdBasedDocument document2 = createDocument(messages.get(1));    MessageIdBasedDocument document3 = createDocument(messages.get(2));        document1.setDocumentID(document1.getGuid());    document2.setDocumentID(document1.getGuid());    document3.setDocumentID(document1.getGuid());        BulkDocumentWriterResults<MessageIdBasedDocument> results = new BulkDocumentWriterResults<>();    results.addSuccess(document1);    results.addSuccess(document2);    results.addSuccess(document3);    BulkDocumentWriter<MessageIdBasedDocument> docWriter = mock(BulkDocumentWriter.class);    when(docWriter.write()).thenReturn(results);        ElasticsearchWriter esWriter = new ElasticsearchWriter();    esWriter.setDocumentWriter(docWriter);    esWriter.init(stormConf, writerConfiguration);    BulkWriterResponse response = esWriter.write("bro", writerConfiguration, messages);        verify(docWriter, times(1)).addDocument(document1, "bro_index");    verify(docWriter, times(1)).addDocument(document1, "bro_index");    verify(docWriter, times(1)).addDocument(document1, "bro_index");        assertFalse(response.hasErrors());    assertTrue(response.getSuccesses().contains(new MessageId("message1")));    assertTrue(response.getSuccesses().contains(new MessageId("message2")));    assertTrue(response.getSuccesses().contains(new MessageId("message3")));}
private MessageIdBasedDocument metron_f4355_0(BulkMessage<JSONObject> bulkWriterMessage)
{    MessageId messageId = bulkWriterMessage.getId();    JSONObject message = bulkWriterMessage.getMessage();    Long timestamp = (Long) bulkWriterMessage.getMessage().get(Constants.Fields.TIMESTAMP.getName());    String guid = (String) message.get(Constants.GUID);    String sensorType = (String) message.get(Constants.SENSOR_TYPE);    return new MessageIdBasedDocument(message, guid, sensorType, timestamp, messageId);}
private JSONObject metron_f4356_0()
{    JSONObject message = new JSONObject();    message.put(Constants.GUID, UUID.randomUUID().toString());    message.put(Constants.Fields.TIMESTAMP.getName(), System.currentTimeMillis());    message.put(Constants.Fields.SRC_ADDR.getName(), "192.168.1.1");    message.put(Constants.SENSOR_TYPE, "bro");    return message;}
private Map<String, Object> metron_f4357_0()
{    Map<String, Object> globals = new HashMap<>();    globals.put("es.date.format", "yyyy.MM.dd.HH");    return globals;}
private List<BulkMessage<JSONObject>> metron_f4358_0(int count)
{    List<BulkMessage<JSONObject>> messages = new ArrayList<>();    for (int i = 0; i < count; i++) {        messages.add(new BulkMessage<>(new MessageId("message" + (i + 1)), message()));    }    return messages;}
public FieldNameConverter metron_f4359_0()
{    return fieldNameConverter;}
public InMemoryComponent metron_f4360_0(final Properties topologyProperties)
{    Map<String, Object> globalConfig = new HashMap<String, Object>() {        {            put("es.clustername", "metron");            put("es.port", "9200");            put("es.ip", "localhost");            put("es.date.format", dateFormat);        }    };    AccessConfig accessConfig = new AccessConfig();    accessConfig.setGlobalConfigSupplier(() -> globalConfig);    return new ElasticSearchComponent.Builder().withHttpPort(9211).withIndexDir(new File(indexDir)).withMapping(index, "yaf_doc", mapping).withAccessConfig(accessConfig).build();}
public Processor<List<Map<String, Object>>> metron_f4361_0(final List<byte[]> inputMessages)
{    return new Processor<List<Map<String, Object>>>() {        List<Map<String, Object>> docs = null;        List<byte[]> errors = null;        final AtomicInteger missCount = new AtomicInteger(0);        @Override        public ReadinessState process(ComponentRunner runner) {            ElasticSearchComponent elasticSearchComponent = runner.getComponent("search", ElasticSearchComponent.class);            KafkaComponent kafkaComponent = runner.getComponent("kafka", KafkaComponent.class);            if (elasticSearchComponent.hasIndex(index)) {                try {                    docs = elasticSearchComponent.getAllIndexedDocs(index, testSensorType + "_doc");                } catch (IOException e) {                    throw new IllegalStateException("Unable to retrieve indexed documents.", e);                }                if (docs.size() < inputMessages.size()) {                    errors = kafkaComponent.readMessages(ERROR_TOPIC);                    if (errors.size() > 0 && errors.size() + docs.size() == inputMessages.size()) {                        return ReadinessState.READY;                    }                    return ReadinessState.NOT_READY;                } else {                    return ReadinessState.READY;                }            } else {                return ReadinessState.NOT_READY;            }        }        @Override        public ProcessorResult<List<Map<String, Object>>> getResult() {            ProcessorResult.Builder<List<Map<String, Object>>> builder = new ProcessorResult.Builder();            return builder.withResult(docs).withProcessErrors(errors).build();        }    };}
public ReadinessState metron_f4362_0(ComponentRunner runner)
{    ElasticSearchComponent elasticSearchComponent = runner.getComponent("search", ElasticSearchComponent.class);    KafkaComponent kafkaComponent = runner.getComponent("kafka", KafkaComponent.class);    if (elasticSearchComponent.hasIndex(index)) {        try {            docs = elasticSearchComponent.getAllIndexedDocs(index, testSensorType + "_doc");        } catch (IOException e) {            throw new IllegalStateException("Unable to retrieve indexed documents.", e);        }        if (docs.size() < inputMessages.size()) {            errors = kafkaComponent.readMessages(ERROR_TOPIC);            if (errors.size() > 0 && errors.size() + docs.size() == inputMessages.size()) {                return ReadinessState.READY;            }            return ReadinessState.NOT_READY;        } else {            return ReadinessState.READY;        }    } else {        return ReadinessState.NOT_READY;    }}
public ProcessorResult<List<Map<String, Object>>> metron_f4363_0()
{    ProcessorResult.Builder<List<Map<String, Object>>> builder = new ProcessorResult.Builder();    return builder.withResult(docs).withProcessErrors(errors).build();}
public void metron_f4364_0(Properties topologyProperties)
{    topologyProperties.setProperty("es.clustername", "metron");    topologyProperties.setProperty("es.port", "9300");    topologyProperties.setProperty("es.ip", "localhost");    topologyProperties.setProperty("ra_indexing_writer_class_name", "org.apache.metron.elasticsearch.writer.ElasticsearchWriter");    topologyProperties.setProperty("ra_indexing_kafka_start", "UNCOMMITTED_EARLIEST");    topologyProperties.setProperty("ra_indexing_workers", "1");    topologyProperties.setProperty("ra_indexing_acker_executors", "0");    topologyProperties.setProperty("ra_indexing_topology_max_spout_pending", "");    topologyProperties.setProperty("ra_indexing_kafka_spout_parallelism", "1");    topologyProperties.setProperty("ra_indexing_writer_parallelism", "1");}
public String metron_f4365_0(String field)
{    return field;}
public String metron_f4366_0()
{    return "./src/main/config/elasticsearch.properties.j2";}
public String metron_f4367_0()
{    return "../../metron-indexing/metron-indexing-storm/src/main/flux/indexing/random_access/remote.yaml";}
public JSONObject metron_f4370_1(CacheKey k)
{    String metadata = k.coerceValue(String.class);    JSONObject output = new JSONObject();        output.putAll(getCIFObject(metadata));    return output;}
protected Map metron_f4371_1(String key)
{        Get get = new Get(key.getBytes(StandardCharsets.UTF_8));    Result rs;    Map output = new HashMap();    try {        rs = table.get(get);        for (KeyValue kv : rs.raw()) output.put(new String(kv.getQualifier(), StandardCharsets.UTF_8), "Y");    } catch (IOException e) {                e.printStackTrace();    }    return output;}
public boolean metron_f4372_1(Map<String, Object> config)
{        Configuration conf = null;    conf = HBaseConfiguration.create();    conf.set("hbase.zookeeper.quorum", _quorum);    conf.set("hbase.zookeeper.property.clientPort", _port);    try {                        Connection connection = ConnectionFactory.createConnection(conf);        table = connection.getTable(TableName.valueOf(_tableName));        return true;    } catch (IOException e) {                e.printStackTrace();    }    return false;}
public String metron_f4374_0(String metadata)
{    return null;}
public String metron_f4375_0(String metadata)
{    return null;}
public String metron_f4376_0(String metadata)
{    return null;}
public String metron_f4378_0(CacheKey value)
{    return value.getField();}
public String metron_f4380_0(CacheKey value)
{    return value.getField();}
public JSONObject metron_f4381_0(CacheKey value)
{    JSONObject enriched = new JSONObject();    Optional<Map<String, String>> result = GeoLiteCityDatabase.INSTANCE.get(value.coerceValue(String.class));    if (!result.isPresent()) {        return new JSONObject();    }    enriched = new JSONObject(result.get());    _LOG.trace("GEO Enrichment success: {}", enriched);    return enriched;}
public boolean metron_f4382_0(Map<String, Object> config)
{    GeoLiteCityDatabase.INSTANCE.update((String) config.get(GeoLiteCityDatabase.GEO_HDFS_FILE));    return true;}
public void metron_f4383_0(Map<String, Object> config)
{    GeoLiteCityDatabase.INSTANCE.updateIfNecessary(config);}
public String metron_f4386_0(CacheKey value)
{    return value.getField();}
public boolean metron_f4387_0(Map<String, Object> config)
{    if (_known_hosts.size() > 0)        return true;    else        return false;}
public JSONObject metron_f4390_0(CacheKey k)
{    String metadata = k.coerceValue(String.class);    if (!_known_hosts.containsKey(metadata))        return new JSONObject();    JSONObject enrichment = new JSONObject();    String prefix = "known_info.";    JSONObject knownInfo = _known_hosts.get(metadata);    for (Object key : knownInfo.keySet()) {        enrichment.put(prefix + key, knownInfo.get(key));    }        return enrichment;}
public boolean metron_f4391_0(Map<String, Object> config)
{    if (_known_hosts.size() > 0)        return true;    else        return false;}
public String metron_f4393_0(CacheKey value)
{    return value.getField();}
public JSONObject metron_f4395_0(CacheKey metadata)
{    if (!_known_hosts.containsKey(metadata.getValue()))        return new JSONObject();    JSONObject enrichment = new JSONObject();    enrichment.put("known_info", (JSONObject) _known_hosts.get(metadata.getValue()));    return enrichment;}
public String metron_f4396_0()
{    return host;}
public void metron_f4397_0(String host)
{    this.host = host;}
public int metron_f4398_0()
{    return port;}
public void metron_f4399_0(int port)
{    this.port = port;}
public String metron_f4400_0()
{    return username;}
public void metron_f4401_0(String username)
{    this.username = username;}
public String metron_f4402_0()
{    return password;}
public void metron_f4403_0(String password)
{    this.password = password;}
public String metron_f4404_0()
{    return table;}
public void metron_f4405_0(String table)
{    this.table = table;}
protected boolean metron_f4406_1()
{    boolean isClosed = statement == null || connection == null;    if (!isClosed) {        try {            isClosed = statement.isClosed() || connection.isClosed();        } catch (SQLException e) {            _            isClosed = true;        }    }    return isClosed;}
protected boolean metron_f4407_0()
{    if (isConnectionClosed()) {        this.cleanup();        return this.initializeAdapter(null);    }    return true;}
public void metron_f4408_0(Statement statement)
{    this.statement = statement;}
public JdbcAdapter metron_f4409_0(JdbcConfig config)
{    this.config = config;    this.host = config.getHost();    return this;}
public String metron_f4412_0()
{    return "com.mysql.jdbc.Driver";}
public String metron_f4413_0()
{    StringBuilder url = new StringBuilder();    url.append("jdbc:mysql://").append(host);    if (port > 0) {        url.append(":").append(port);    }    url.append("/").append(table);    url.append("?user=").append(username);    url.append("&password=").append(password);    return url.toString();}
public String metron_f4414_0()
{    return simpleName;}
public Object metron_f4415_0(Map<String, Object> map)
{    return getter.apply(map);}
public void metron_f4416_0(Map<String, Object> map, Object val)
{    map.put(simpleName, val);}
public String metron_f4417_0()
{    return ASN_HDFS_FILE;}
public String metron_f4418_0()
{    return ASN_HDFS_FILE_DEFAULT;}
public void metron_f4419_0()
{    writeLock.lock();}
public void metron_f4420_0()
{    writeLock.unlock();}
public DatabaseReader metron_f4421_0()
{    return reader;}
public void metron_f4422_0(DatabaseReader reader)
{    GeoLiteAsnDatabase.reader = reader;}
public synchronized void metron_f4423_0(Map<String, Object> globalConfig)
{        LOG.trace("Determining if GeoLiteAsnDatabase update required");    String hdfsFile = ASN_HDFS_FILE_DEFAULT;    if (globalConfig != null) {        hdfsFile = (String) globalConfig.getOrDefault(ASN_HDFS_FILE, ASN_HDFS_FILE_DEFAULT);    }        if (reader == null || !hdfsLoc.equals(hdfsFile)) {                hdfsLoc = hdfsFile;        update(hdfsFile);    } else {        LOG.trace("Update to GeoLiteAsnDatabase unnecessary");    }}
public Optional<Map<String, Object>> metron_f4424_1(String ip)
{    if (MaxMindDbUtilities.invalidIp(ip)) {        return Optional.empty();    }    try {        readLock.lock();        InetAddress addr = InetAddress.getByName(ip);        AsnResponse asnResponse = reader.asn(addr);        HashMap<String, Object> asnInfo = new HashMap<>();        AsnProps.ASN.set(asnInfo, asnResponse.getAutonomousSystemNumber());        AsnProps.ASO.set(asnInfo, MaxMindDbUtilities.convertNullToEmptyString(asnResponse.getAutonomousSystemOrganization()));        AsnProps.NETWORK.set(asnInfo, MaxMindDbUtilities.convertNullToEmptyString(asnResponse.getIpAddress()));        return Optional.of(asnInfo);    } catch (UnknownHostException | AddressNotFoundException e) {            } catch (GeoIp2Exception | IOException e) {            } finally {        readLock.unlock();    }    return Optional.empty();}
public String metron_f4425_0()
{    return simpleName;}
public String metron_f4426_0(Map<String, String> map)
{    return getter.apply(map);}
public void metron_f4427_0(Map<String, String> map, String val)
{    map.put(simpleName, val);}
public String metron_f4428_0()
{    return GEO_HDFS_FILE;}
public String metron_f4429_0()
{    return GEO_HDFS_FILE_DEFAULT;}
public void metron_f4430_0()
{    writeLock.lock();}
public void metron_f4431_0()
{    writeLock.unlock();}
public DatabaseReader metron_f4432_0()
{    return reader;}
public void metron_f4433_0(DatabaseReader reader)
{    GeoLiteCityDatabase.reader = reader;}
public synchronized void metron_f4434_0(Map<String, Object> globalConfig)
{        LOG.trace("Determining if GeoIpDatabase update required");    String hdfsFile = GEO_HDFS_FILE_DEFAULT;    if (globalConfig != null) {        hdfsFile = (String) globalConfig.getOrDefault(GEO_HDFS_FILE, GEO_HDFS_FILE_DEFAULT);        hdfsFile = determineHdfsDirWithFallback(globalConfig, hdfsFile, GEO_HDFS_FILE_DEFAULT_FALLBACK);    }        if (reader == null || !hdfsLoc.equals(hdfsFile)) {                hdfsLoc = hdfsFile;        update(hdfsFile);    } else {        LOG.trace("Update to GeoLiteCity2Database unnecessary");    }}
protected String metron_f4435_1(Map<String, Object> globalConfig, String hdfsFile, String hdfsFallbackFile)
{        if (!globalConfig.containsKey(GEO_HDFS_FILE)) {        FileSystem fs = MaxMindDbUtilities.getFileSystem();        try {                        if (hdfsPathsExist(fs, hdfsFile, hdfsFallbackFile)) {                hdfsFile = hdfsFallbackFile;            }        } catch (IOException e) {                            }    }    return hdfsFile;}
protected boolean metron_f4436_0(FileSystem fs, String hdfsFile, String fallbackFile) throws IOException
{    return !fs.exists(new Path(hdfsFile)) && fs.exists(new Path(fallbackFile));}
public Optional<Map<String, String>> metron_f4437_1(String ip)
{    if (MaxMindDbUtilities.invalidIp(ip)) {        return Optional.empty();    }    try {        readLock.lock();        InetAddress addr = InetAddress.getByName(ip);        CityResponse cityResponse = reader.city(addr);        HashMap<String, String> geoInfo = new HashMap<>();        Country country = cityResponse.getCountry();        City city = cityResponse.getCity();        Postal postal = cityResponse.getPostal();        Location location = cityResponse.getLocation();        GeoProps.LOC_ID.set(geoInfo, MaxMindDbUtilities.convertNullToEmptyString(city.getGeoNameId()));        GeoProps.COUNTRY.set(geoInfo, MaxMindDbUtilities.convertNullToEmptyString(country.getIsoCode()));        GeoProps.CITY.set(geoInfo, MaxMindDbUtilities.convertNullToEmptyString(city.getName()));        GeoProps.POSTAL_CODE.set(geoInfo, MaxMindDbUtilities.convertNullToEmptyString(postal.getCode()));        GeoProps.DMA_CODE.set(geoInfo, MaxMindDbUtilities.convertNullToEmptyString(location.getMetroCode()));        Double latitudeRaw = location.getLatitude();        String latitude = MaxMindDbUtilities.convertNullToEmptyString(latitudeRaw);        GeoProps.LATITUDE.set(geoInfo, latitude);        Double longitudeRaw = location.getLongitude();        String longitude = MaxMindDbUtilities.convertNullToEmptyString(longitudeRaw);        GeoProps.LONGITUDE.set(geoInfo, longitude);        if (latitudeRaw == null || longitudeRaw == null) {            GeoProps.LOCATION_POINT.set(geoInfo, "");        } else {            GeoProps.LOCATION_POINT.set(geoInfo, latitude + "," + longitude);        }        return Optional.of(geoInfo);    } catch (UnknownHostException | AddressNotFoundException e) {            } catch (GeoIp2Exception | IOException e) {            } finally {        readLock.unlock();    }    return Optional.empty();}
public Optional<WGS84Point> metron_f4438_1(Map<String, String> geoInfo)
{    String latitude = GeoProps.LATITUDE.get(geoInfo);    String longitude = GeoProps.LONGITUDE.get(geoInfo);    if (latitude == null || longitude == null) {        return Optional.empty();    }    try {        double latD = Double.parseDouble(latitude);        double longD = Double.parseDouble(longitude);        return Optional.of(new WGS84Point(latD, longD));    } catch (NumberFormatException nfe) {                return Optional.empty();    }}
public double metron_f4439_0(WGS84Point point1, WGS84Point point2)
{    return strat.distance(point1, point2);}
public Optional<String> metron_f4440_0(Double latitude, Double longitude, int precision)
{    if (latitude == null || longitude == null) {        return Optional.empty();    }    return computeHash(new WGS84Point(latitude, longitude), precision);}
public Optional<String> metron_f4441_0(WGS84Point point, int precision)
{    GeoHash hash = GeoHash.withCharacterPrecision(point.getLatitude(), point.getLongitude(), precision);    return Optional.of(hash.toBase32());}
public Optional<String> metron_f4442_0(Map<String, String> geoLoc, int precision)
{    Optional<WGS84Point> point = GeoLiteCityDatabase.INSTANCE.toPoint(geoLoc);    if (point.isPresent()) {        return computeHash(point.get(), precision);    } else {        return Optional.empty();    }}
public Optional<WGS84Point> metron_f4443_0(String hash)
{    if (hash == null) {        return Optional.empty();    }    GeoHash h = GeoHash.fromGeohashString(hash);    return Optional.ofNullable(h == null ? null : h.getPoint());}
public double metron_f4444_0(WGS84Point point1, WGS84Point point2, DistanceStrategy strategy)
{    return strategy.distance(point1, point2);}
public WGS84Point metron_f4445_0(Iterable<String> hashes)
{    Iterable<WGS84Point> points = Iterables.transform(hashes, h -> toPoint(h).orElse(null));    return centroidOfPoints(points);}
public WGS84Point metron_f4446_0(Iterable<WGS84Point> points)
{    Iterable<WGS84Point> nonNullPoints = Iterables.filter(points, p -> p != null);    return centroid(Iterables.transform(nonNullPoints, p -> new AbstractMap.SimpleImmutableEntry<>(p, 1)));}
public WGS84Point metron_f4447_0(Map<String, Number> points)
{    Iterable<Map.Entry<WGS84Point, Number>> weightedPoints = Iterables.transform(points.entrySet(), kv -> {        WGS84Point pt = toPoint(kv.getKey()).orElse(null);        return new AbstractMap.SimpleImmutableEntry<>(pt, kv.getValue());    });    return centroid(Iterables.filter(weightedPoints, kv -> kv.getKey() != null));}
private WGS84Point metron_f4448_0(Iterable<Map.Entry<WGS84Point, Number>> points)
{    double x = 0d, y = 0d, z = 0d, totalWeight = 0d;    int n = 0;    /**     * So, it's first important to realize that long/lat are not cartesian, so simple weighted averaging     * is insufficient here as it denies the fact that we're not living on a flat square, but rather the surface of     * an ellipsoid.  A crow, for instance, does not fly a straight line to an observer outside of Earth, but     * rather flies across the arc tracing the surface of earth, or a "great-earth arc".  When computing the centroid     * you want to find the centroid of the points with distance defined as the great-earth arc.     *     * The general strategy is to:     * 1. Change coordinate systems from degrees on a WGS84 projection (e.g. lat/long)     *    to a 3 dimensional cartesian surface atop a sphere approximating the earth.     * 2. Compute a weighted average of the cartesian coordinates     * 3. Change coordinate systems of the resulting centroid in cartesian space back to lat/long     *     * This is generally detailed at http://www.geomidpoint.com/example.html     */    for (Map.Entry<WGS84Point, Number> weightedPoint : points) {        WGS84Point pt = weightedPoint.getKey();        if (pt == null) {            continue;        }        double latRad = Math.toRadians(pt.getLatitude());        double longRad = Math.toRadians(pt.getLongitude());        double cosLat = Math.cos(latRad);        /*       Convert from lat/long coordinates to cartesian coordinates.  The cartesian coordinate system is a right-hand,       rectangular, three-dimensional, earth-fixed coordinate system       with an origin at (0, 0, 0). The Z-axis, is parrallel to the axis of rotation of the earth. The Z-coordinate       is positive toward the North pole. The X-Y plane lies in the equatorial plane. The X-axis lies along the       intersection of the plane containing the prime meridian and the equatorial plane. The X-coordinate is positive       toward the intersection of the prime meridian and equator.       Please see https://en.wikipedia.org/wiki/Geographic_coordinate_conversion#From_geodetic_to_ECEF_coordinates       for more information about this coordinate transformation.       */        double ptX = cosLat * Math.cos(longRad);        double ptY = cosLat * Math.sin(longRad);        double ptZ = Math.sin(latRad);        double weight = weightedPoint.getValue().doubleValue();        x += ptX * weight;        y += ptY * weight;        z += ptZ * weight;        n++;        totalWeight += weight;    }    if (n == 0) {        return null;    }        x /= totalWeight;    y /= totalWeight;    z /= totalWeight;        double longitude = Math.atan2(y, x);    double hypotenuse = Math.sqrt(x * x + y * y);    double latitude = Math.atan2(z, hypotenuse);        return new WGS84Point(Math.toDegrees(latitude), Math.toDegrees(longitude));}
public double metron_f4449_0(Iterable<String> hashes, DistanceStrategy strategy)
{    Iterable<WGS84Point> points = Iterables.transform(hashes, s -> toPoint(s).orElse(null));    return maxDistancePoints(Iterables.filter(points, p -> p != null), strategy);}
public double metron_f4450_0(Iterable<WGS84Point> points, DistanceStrategy strategy)
{        int i = 0;    double max = Double.NaN;    for (WGS84Point pt1 : points) {        int j = 0;        for (WGS84Point pt2 : points) {            if (j <= i) {                double d = strategy.distance(pt1, pt2);                if (Double.isNaN(max) || d > max) {                    max = d;                }                j++;            } else {                break;            }        }        i++;    }    return max;}
 void metron_f4451_1(String hdfsFile)
{        if (hdfsFile == null || hdfsFile.isEmpty()) {                hdfsFile = getHdfsFileDefault();    }    FileSystem fs = MaxMindDbUtilities.getFileSystem();    if (hdfsFile.endsWith(MaxMindDatabase.EXTENSION_MMDB)) {        lockIfNecessary();        try (BufferedInputStream is = new BufferedInputStream(fs.open(new Path(hdfsFile)))) {            setReader(MaxMindDbUtilities.readNewDatabase(getReader(), hdfsFile, is));        } catch (IOException e) {            MaxMindDbUtilities.handleDatabaseIOException(hdfsFile, e);        } finally {            unlockIfNecessary();        }    } else if (hdfsFile.endsWith(MaxMindDatabase.EXTENSION_MMDB_GZ)) {        lockIfNecessary();        try (GZIPInputStream is = new GZIPInputStream(fs.open(new Path(hdfsFile)))) {            setReader(MaxMindDbUtilities.readNewDatabase(getReader(), hdfsFile, is));        } catch (IOException e) {            MaxMindDbUtilities.handleDatabaseIOException(hdfsFile, e);        } finally {            unlockIfNecessary();        }    } else if (hdfsFile.endsWith(MaxMindDatabase.EXTENSION_TAR_GZ)) {        lockIfNecessary();        try (TarArchiveInputStream is = new TarArchiveInputStream(new GZIPInputStream(fs.open(new Path(hdfsFile))))) {                        TarArchiveEntry entry = is.getNextTarEntry();            while (entry != null) {                if (entry.isFile() && entry.getName().endsWith(MaxMindDatabase.EXTENSION_MMDB)) {                    try (InputStream mmdb = new BufferedInputStream(is)) {                                                setReader(MaxMindDbUtilities.readNewDatabase(getReader(), hdfsFile, mmdb));                                                break;                    }                }                entry = is.getNextTarEntry();            }        } catch (IOException e) {            MaxMindDbUtilities.handleDatabaseIOException(hdfsFile, e);        } finally {            unlockIfNecessary();        }    }}
public static boolean metron_f4452_1(String ip)
{    LOG.trace("Called validateIp({})", ip);    InetAddress addr;    try {        addr = InetAddress.getByName(ip);    } catch (UnknownHostException e) {                return true;    }    if (isIneligibleAddress(ip, addr)) {                return true;    }    return false;}
public static boolean metron_f4453_0(String ipStr, InetAddress addr)
{    return addr.isAnyLocalAddress() || addr.isLoopbackAddress() || addr.isSiteLocalAddress() || addr.isMulticastAddress() || !ipvalidator.isValidInet4Address(ipStr);}
public static void metron_f4454_1(String hdfsFile, IOException e)
{        throw new IllegalStateException("Unable to update MaxMind database");}
public static DatabaseReader metron_f4455_1(DatabaseReader reader, String hdfsFile, InputStream is) throws IOException
{            DatabaseReader newReader = new DatabaseReader.Builder(is).withCache(new CHMCache()).build();        if (reader != null) {        reader.close();    }        return newReader;}
public static FileSystem metron_f4456_1()
{    FileSystem fs;    try {        fs = FileSystem.get(new Configuration());    } catch (IOException e) {                throw new IllegalStateException("Unable to get HDFS FileSystem");    }    return fs;}
public static String metron_f4457_0(Object raw)
{    return raw == null ? "" : String.valueOf(raw);}
public SimpleHBaseAdapter metron_f4458_0(SimpleHBaseConfig config)
{    this.config = config;    return this;}
public boolean metron_f4460_0()
{    return lookup != null && lookup.getTable() != null;}
public JSONObject metron_f4461_1(CacheKey value)
{    JSONObject enriched = new JSONObject();    if (!isInitialized()) {        initializeAdapter(null);    }    List<String> enrichmentTypes = value.getConfig().getEnrichment().getFieldToTypeMap().get(EnrichmentUtils.toTopLevelField(value.getField()));    if (isInitialized() && enrichmentTypes != null && value.getValue() != null) {        try {            for (LookupKV<EnrichmentKey, EnrichmentValue> kv : lookup.get(Iterables.transform(enrichmentTypes, new EnrichmentUtils.TypeToKey(value.coerceValue(String.class), lookup.getTable(), value.getConfig().getEnrichment())), false)) {                if (kv != null && kv.getValue() != null && kv.getValue().getMetadata() != null) {                    for (Map.Entry<String, Object> values : kv.getValue().getMetadata().entrySet()) {                        enriched.put(kv.getKey().type + "." + values.getKey(), values.getValue());                    }                    LOG.trace("Enriched type {} => {}", () -> kv.getKey().type, () -> enriched);                }            }        } catch (IOException e) {                        initializeAdapter(null);            throw new RuntimeException("Unable to retrieve value: " + e.getMessage(), e);        }    }    LOG.trace("SimpleHBaseAdapter succeeded: {}", enriched);    return enriched;}
public boolean metron_f4462_1(Map<String, Object> configuration)
{    String hbaseTable = config.getHBaseTable();    Configuration hbaseConfig = HBaseConfiguration.create();    try {        lookup = new EnrichmentLookup(config.getProvider().getTable(hbaseConfig, hbaseTable), config.getHBaseCF(), new NoopAccessTracker());    } catch (IOException e) {                return false;    }    return true;}
public void metron_f4464_1()
{    try {        lookup.close();    } catch (Exception e) {            }}
public String metron_f4465_0(CacheKey value)
{    return value.getField();}
public String metron_f4466_0()
{    return hBaseTable;}
public String metron_f4467_0()
{    return hBaseCF;}
public TableProvider metron_f4468_0()
{    return provider;}
public SimpleHBaseConfig metron_f4469_0(String connectorImpl)
{    provider = EnrichmentUtils.getTableProvider(connectorImpl, new HTableProvider());    return this;}
public SimpleHBaseConfig metron_f4470_0(String hBaseTable)
{    this.hBaseTable = hBaseTable;    return this;}
public SimpleHBaseConfig metron_f4471_0(String cf)
{    this.hBaseCF = cf;    return this;}
public ConfigHandler metron_f4472_0(SensorEnrichmentConfig cacheKey)
{    return func.apply(cacheKey);}
public StellarAdapter metron_f4473_0(String enrichmentType)
{    this.enrichmentType = enrichmentType;    return this;}
public String metron_f4474_0(CacheKey value)
{    return "";}
public String metron_f4476_0(String enrichmentType, String field)
{    return field;}
public static Iterable<Map.Entry<String, Object>> metron_f4477_0(ConfigHandler handler, String field)
{    if (field.length() == 0) {        return handler.getType().toConfig(handler.getConfig());    } else {        Map<String, Object> groupStatements = (Map<String, Object>) handler.getConfig();        return handler.getType().toConfig(groupStatements.get(field));    }}
public JSONObject metron_f4479_0(CacheKey value)
{    Context stellarContext = (Context) value.getConfig().getConfiguration().get(STELLAR_CONTEXT_CONF);    ConfigHandler handler = getHandler.apply(value.getConfig());    Map<String, Object> globalConfig = value.getConfig().getConfiguration();    Map<String, Object> sensorConfig = value.getConfig().getEnrichment().getConfig();    if (handler == null) {        _LOG.trace("Stellar ConfigHandler is null.");        return new JSONObject();    }    Long slowLogThreshold = null;    if (_PERF_LOG.isDebugEnabled()) {        slowLogThreshold = ConversionUtils.convert(globalConfig.getOrDefault(STELLAR_SLOW_LOG, STELLAR_SLOW_LOG_DEFAULT), Long.class);    }            Map<String, Object> message = new HashMap<>(value.getValue(Map.class));    VariableResolver resolver = new MapVariableResolver(message, sensorConfig, globalConfig);    StellarProcessor processor = new StellarProcessor();    JSONObject enriched = process(message, handler, value.getField(), slowLogThreshold, processor, resolver, stellarContext);    _LOG.trace("Stellar Enrichment Success: {}", enriched);    return enriched;}
public boolean metron_f4480_0(Map<String, Object> config)
{    getHandler = EnrichmentType.valueOf(enrichmentType);    return true;}
public ThreatIntelAdapter metron_f4483_0(ThreatIntelConfig config)
{    this.config = config;    return this;}
public void metron_f4484_0(CacheKey value)
{    List<String> enrichmentTypes = value.getConfig().getThreatIntel().getFieldToTypeMap().get(value.getField());    if (enrichmentTypes != null) {        for (String enrichmentType : enrichmentTypes) {            lookup.getAccessTracker().logAccess(new EnrichmentKey(enrichmentType, value.coerceValue(String.class)));        }    }}
public JSONObject metron_f4485_1(CacheKey value)
{    if (!isInitialized()) {        initializeAdapter(null);    }    JSONObject enriched = new JSONObject();    List<String> enrichmentTypes = value.getConfig().getThreatIntel().getFieldToTypeMap().get(EnrichmentUtils.toTopLevelField(value.getField()));    if (isInitialized() && enrichmentTypes != null) {        int i = 0;        try {            for (Boolean isThreat : lookup.exists(Iterables.transform(enrichmentTypes, new EnrichmentUtils.TypeToKey(value.coerceValue(String.class), lookup.getTable(), value.getConfig().getThreatIntel())), false)) {                String enrichmentType = enrichmentTypes.get(i++);                if (isThreat) {                    enriched.put(enrichmentType, "alert");                    LOG.trace("Theat Intel Enriched value => {}", enriched);                }            }        } catch (IOException e) {                        initializeAdapter(null);            throw new RuntimeException("Theat Intel Unable to retrieve value", e);        }    }    LOG.trace("Threat Intel Enrichment Success: {}", enriched);    return enriched;}
public boolean metron_f4486_0()
{    return lookup != null && lookup.getTable() != null;}
public boolean metron_f4487_1(Map<String, Object> configuration)
{    PersistentAccessTracker accessTracker;    String hbaseTable = config.getHBaseTable();    int expectedInsertions = config.getExpectedInsertions();    double falsePositives = config.getFalsePositiveRate();    String trackerHBaseTable = config.getTrackerHBaseTable();    String trackerHBaseCF = config.getTrackerHBaseCF();    long millisecondsBetweenPersist = config.getMillisecondsBetweenPersists();    BloomAccessTracker bat = new BloomAccessTracker(hbaseTable, expectedInsertions, falsePositives);    Configuration hbaseConfig = HBaseConfiguration.create();    try {        accessTracker = new PersistentAccessTracker(hbaseTable, UUID.randomUUID().toString(), config.getProvider().getTable(hbaseConfig, trackerHBaseTable), trackerHBaseCF, bat, millisecondsBetweenPersist);        lookup = new EnrichmentLookup(config.getProvider().getTable(hbaseConfig, hbaseTable), config.getHBaseCF(), accessTracker);    } catch (IOException e) {                return false;    }    return true;}
public void metron_f4489_0()
{    try {        lookup.close();    } catch (Exception e) {        throw new RuntimeException("Unable to cleanup access tracker", e);    }}
public String metron_f4490_0(CacheKey value)
{    return value.getField();}
public String metron_f4491_0()
{    return hBaseTable;}
public int metron_f4492_0()
{    return expectedInsertions;}
public double metron_f4493_0()
{    return falsePositiveRate;}
public String metron_f4494_0()
{    return trackerHBaseTable;}
public String metron_f4495_0()
{    return trackerHBaseCF;}
public long metron_f4496_0()
{    return millisecondsBetweenPersists;}
public String metron_f4497_0()
{    return hBaseCF;}
public TableProvider metron_f4498_0()
{    return provider;}
public ThreatIntelConfig metron_f4499_0(String connectorImpl)
{    provider = EnrichmentUtils.getTableProvider(connectorImpl, new HTableProvider());    return this;}
public ThreatIntelConfig metron_f4500_0(String hBaseTable)
{    this.trackerHBaseTable = hBaseTable;    return this;}
public ThreatIntelConfig metron_f4501_0(String cf)
{    this.trackerHBaseCF = cf;    return this;}
public ThreatIntelConfig metron_f4502_0(String hBaseTable)
{    this.hBaseTable = hBaseTable;    return this;}
public ThreatIntelConfig metron_f4503_0(String cf)
{    this.hBaseCF = cf;    return this;}
public ThreatIntelConfig metron_f4504_0(double falsePositiveRate)
{    this.falsePositiveRate = falsePositiveRate;    return this;}
public ThreatIntelConfig metron_f4505_0(int expectedInsertions)
{    this.expectedInsertions = expectedInsertions;    return this;}
public ThreatIntelConfig metron_f4506_0(long millisecondsBetweenPersists)
{    this.millisecondsBetweenPersists = millisecondsBetweenPersists;    return this;}
public String metron_f4507_0()
{    return field;}
public Object metron_f4508_0()
{    return value;}
public T metron_f4509_0(Class<T> clazz)
{    return clazz.cast(getValue());}
public T metron_f4510_0(Class<T> clazz)
{    return ConversionUtils.convert(getValue(), clazz);}
public SensorEnrichmentConfig metron_f4511_0()
{    return config;}
public String metron_f4512_0()
{    return "CacheKey{" + "field='" + field + '\'' + ", value='" + value + '\'' + '}';}
public boolean metron_f4513_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    CacheKey cacheKey = (CacheKey) o;    if (getField() != null ? !getField().equals(cacheKey.getField()) : cacheKey.getField() != null)        return false;    if (getValue() != null ? !getValue().equals(cacheKey.getValue()) : cacheKey.getValue() != null)        return false;    return config != null ? config.equals(cacheKey.config) : cacheKey.config == null;}
public int metron_f4514_0()
{    int result = getField() != null ? getField().hashCode() : 0;    result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);    result = 31 * result + (config != null ? config.hashCode() : 0);    return result;}
public Object metron_f4515_1(String s) throws Exception
{        if (StringUtils.isEmpty(s)) {        throw new IllegalArgumentException("Path cannot be empty");    }    Object object = null;    Path p = new Path(s);    if (fs.exists(p)) {        if (fs.getFileStatus(p).getLen() <= objectCacheConfig.getMaxFileSize()) {            try (InputStream is = new BufferedInputStream(fs.open(p))) {                byte[] serialized = IOUtils.toByteArray(is);                if (serialized.length > 0) {                    object = SerDeUtils.fromBytes(serialized, Object.class);                }            }        } else {            throw new IllegalArgumentException(String.format("File at path '%s' is larger than the configured max file size of %s", p, objectCacheConfig.getMaxFileSize()));        }    } else {        throw new IllegalArgumentException(String.format("Path '%s' could not be found in HDFS", s));    }    return object;}
public Object metron_f4516_0(String path)
{    return cache.get(path);}
public void metron_f4517_0(ObjectCacheConfig config)
{    try {        lock.writeLock().lock();        cache = setupCache(config);    } catch (IOException e) {        throw new IllegalStateException("Unable to initialize: " + e.getMessage(), e);    } finally {        lock.writeLock().unlock();    }}
public boolean metron_f4518_0()
{    try {        lock.readLock().lock();        return cache != null;    } finally {        lock.readLock().unlock();    }}
protected LoadingCache<String, Object> metron_f4519_1(ObjectCacheConfig config) throws IOException
{        return Caffeine.newBuilder().maximumSize(config.getCacheSize()).expireAfterWrite(config.getCacheExpiration(), config.getTimeUnit()).removalListener((path, value, removalCause) -> {            }).build(new Loader(new Configuration(), config));}
public boolean metron_f4520_0()
{    return cache == null || cache.estimatedSize() == 0;}
public boolean metron_f4521_0(String key)
{    return cache != null && cache.asMap().containsKey(key);}
public long metron_f4522_0()
{    return cacheSize;}
public void metron_f4523_0(long cacheSize)
{    this.cacheSize = cacheSize;}
public long metron_f4524_0()
{    return cacheExpiration;}
public void metron_f4525_0(long cacheExpiration)
{    this.cacheExpiration = cacheExpiration;}
public TimeUnit metron_f4526_0()
{    return timeUnit;}
public void metron_f4527_0(TimeUnit timeUnit)
{    this.timeUnit = timeUnit;}
public long metron_f4528_0()
{    return maxFileSize;}
public void metron_f4529_0(long maxFileSize)
{    this.maxFileSize = maxFileSize;}
public boolean metron_f4530_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    ObjectCacheConfig that = (ObjectCacheConfig) o;    return cacheSize == that.cacheSize && cacheExpiration == that.cacheExpiration && timeUnit == that.timeUnit && maxFileSize == that.maxFileSize;}
public int metron_f4531_0()
{    return Objects.hash(cacheSize, cacheExpiration, timeUnit, maxFileSize);}
public String metron_f4532_0()
{    return "ObjectCacheConfig{" + "cacheSize=" + cacheSize + ", cacheExpiration=" + cacheExpiration + ", timeUnit=" + timeUnit + ", maxFileSize=" + maxFileSize + '}';}
public void metron_f4533_0(List<String> metrics)
{    this.metrics = metrics;}
public Map<Pair, DescriptiveStatistics> metron_f4534_0(int depth)
{    Map<Pair, DescriptiveStatistics> statsMap = depthMap.get(depth);    if (statsMap == null) {        statsMap = new HashMap<>();        depthMap.put(depth, statsMap);    }    return statsMap;}
public DescriptiveStatistics metron_f4535_0(int depth, Pair p)
{    Map<Pair, DescriptiveStatistics> statsMap = getStatsMap(depth);    DescriptiveStatistics stats = statsMap.get(p);    if (stats == null) {        stats = new DescriptiveStatistics();        statsMap.put(p, stats);    }    return stats;}
public void metron_f4536_0(int depth, Pair p, double val)
{    getStats(depth, p).addValue(val);}
public static void metron_f4537_0(String title, DescriptiveStatistics statistics, PrintStream pw, boolean meanOnly)
{    if (meanOnly) {        pw.println(title + ": " + "\n\tMean: " + statistics.getMean());    } else {        pw.println(title + ": " + "\n\tMean: " + statistics.getMean() + "\n\tMin: " + statistics.getMin() + "\n\t1th: " + statistics.getPercentile(1) + "\n\t5th: " + statistics.getPercentile(5) + "\n\t10th: " + statistics.getPercentile(10) + "\n\t25th: " + statistics.getPercentile(25) + "\n\t50th: " + statistics.getPercentile(50) + "\n\t90th: " + statistics.getPercentile(90) + "\n\t95th: " + statistics.getPercentile(95) + "\n\t99th: " + statistics.getPercentile(99) + "\n\tMax: " + statistics.getMax() + "\n\tStdDev: " + statistics.getStandardDeviation());    }}
public void metron_f4538_0(int depth, boolean meanOnly)
{    Map<Pair, DescriptiveStatistics> statsMap = depthMap.get(depth);    System.out.println("\nDistance " + depth);    System.out.println("----------------\n");    List<Map.Entry<Pair, DescriptiveStatistics>> sortedStats = new ArrayList<>();    for (Map.Entry<Pair, DescriptiveStatistics> stats : statsMap.entrySet()) {        sortedStats.add(stats);    }    Collections.sort(sortedStats, new Comparator<Map.Entry<Pair, DescriptiveStatistics>>() {        @Override        public int compare(Map.Entry<Pair, DescriptiveStatistics> o1, Map.Entry<Pair, DescriptiveStatistics> o2) {            return -1 * Double.compare(o1.getValue().getMean(), o2.getValue().getMean());        }    });    for (Map.Entry<Pair, DescriptiveStatistics> stats : sortedStats) {        summary(stats.getKey().getKey() + " -> " + stats.getKey().getValue(), stats.getValue(), System.out, meanOnly);    }}
public int metron_f4539_0(Map.Entry<Pair, DescriptiveStatistics> o1, Map.Entry<Pair, DescriptiveStatistics> o2)
{    return -1 * Double.compare(o1.getValue().getMean(), o2.getValue().getMean());}
public void metron_f4540_0(boolean meanOnly)
{    System.out.println("Flow:");    System.out.println("\t" + Joiner.on(" -> ").join(metrics));    System.out.println("\nSUMMARY BY DISTANCE\n--------------------------");    for (int depth : depthMap.keySet()) {        printDepthSummary(depth, meanOnly);    }}
public static String metron_f4541_0(String s)
{    Iterable<String> tokenIt = Splitter.on('.').split(s);    int num = Iterables.size(tokenIt);    return Joiner.on('.').join(Iterables.limit(tokenIt, num - 1));}
public static void metron_f4542_0(LatencyStats stats, Map<String, Object> doc)
{    Map<String, Long> latencyMap = new HashMap<>();    NavigableMap<Long, String> latencyInvMap = new TreeMap<>();    for (Map.Entry<String, Object> kv : doc.entrySet()) {        if (kv.getKey().endsWith(".ts")) {            String base = getBaseMetric(kv.getKey());            long latency = Long.parseLong(kv.getValue().toString());            latencyInvMap.put(latency, base);            latencyMap.put(base, latency);        }    }    List<String> metrics = new ArrayList<>();    for (Map.Entry<Long, String> kv : latencyInvMap.entrySet()) {        metrics.add(kv.getValue());    }    stats.updateMetrics(metrics);    for (int i = 0; i < metrics.size(); ++i) {        for (int j = i + 1; j < metrics.size(); ++j) {            Pair p = new Pair(metrics.get(i), metrics.get(j));            long ms = latencyMap.get(metrics.get(j)) - latencyMap.get(metrics.get(i));            stats.put(j - i, p, ms);        }    }}
public static void metron_f4543_0(String... argv) throws IOException
{    Options options = new Options();    {        Option o = new Option("h", "help", false, "This screen");        o.setRequired(false);        options.addOption(o);    }    {        Option o = new Option("m", "mean_only", false, "Print the mean only when we summarize");        o.setRequired(false);        options.addOption(o);    }    CommandLineParser parser = new PosixParser();    CommandLine cmd = null;    try {        cmd = parser.parse(options, argv);    } catch (ParseException pe) {        pe.printStackTrace();        final HelpFormatter usageFormatter = new HelpFormatter();        usageFormatter.printHelp(LatencySummarizer.class.getSimpleName().toLowerCase(), null, options, null, true);        System.exit(-1);    }    if (cmd.hasOption("h")) {        final HelpFormatter usageFormatter = new HelpFormatter();        usageFormatter.printHelp(LatencySummarizer.class.getSimpleName().toLowerCase(), null, options, null, true);        System.exit(0);    }    LatencyStats statsMap = new LatencyStats();    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));    for (String line = null; (line = reader.readLine()) != null; ) {        Map<String, Object> doc = JSONUtils.INSTANCE.load(line, JSONUtils.MAP_SUPPLIER);        updateStats(statsMap, doc);    }    statsMap.printSummary(cmd.hasOption('m'));}
public List<String> metron_f4544_0()
{    return fields;}
public void metron_f4545_0(List<String> fields)
{    this.fields = fields;}
public String metron_f4546_0()
{    return type;}
public void metron_f4547_0(String type)
{    this.type = type;}
public T metron_f4548_0()
{    return adapter;}
public void metron_f4549_0(T adapter)
{    this.adapter = adapter;}
public Map.Entry<byte[], byte[]> metron_f4550_0(@Nullable Cell cell)
{    return new AbstractMap.SimpleEntry<>(cell.getQualifier(), cell.getValue());}
public Put metron_f4551_0(String columnFamily, KEY_T key, VALUE_T values) throws IOException
{    Put put = new Put(key.toBytes());    byte[] cf = Bytes.toBytes(columnFamily);    for (Map.Entry<byte[], byte[]> kv : values.toColumns()) {        put.add(cf, kv.getKey(), kv.getValue());    }    return put;}
public LookupKV<KEY_T, VALUE_T> metron_f4552_0(Put put, String columnFamily, KEY_T key, VALUE_T value) throws IOException
{    key.fromBytes(put.getRow());    byte[] cf = Bytes.toBytes(columnFamily);    value.fromColumns(Iterables.transform(put.getFamilyCellMap().get(cf), CELL_TO_ENTRY));    return new LookupKV<>(key, value);}
public Result metron_f4553_0(String columnFamily, KEY_T key, VALUE_T values) throws IOException
{    Put put = toPut(columnFamily, key, values);    return Result.create(put.getFamilyCellMap().get(Bytes.toBytes(columnFamily)));}
public LookupKV<KEY_T, VALUE_T> metron_f4554_0(Result result, String columnFamily, KEY_T key, VALUE_T value) throws IOException
{    if (result == null || result.getRow() == null) {        return null;    }    key.fromBytes(result.getRow());    byte[] cf = Bytes.toBytes(columnFamily);    NavigableMap<byte[], byte[]> cols = result.getFamilyMap(cf);    value.fromColumns(cols.entrySet());    return new LookupKV<>(key, value);}
public Get metron_f4555_0(String columnFamily, KEY_T key)
{    Get ret = new Get(key.toBytes());    ret.addFamily(Bytes.toBytes(columnFamily));    return ret;}
public static Iterable<Map.Entry<byte[], byte[]>> metron_f4556_0(byte[]... kvs)
{    if (kvs.length % 2 != 0) {        throw new IllegalStateException("Must be an even size");    }    List<Map.Entry<byte[], byte[]>> ret = new ArrayList<>(kvs.length / 2);    for (int i = 0; i < kvs.length; i += 2) {        ret.add(new AbstractMap.SimpleImmutableEntry<>(kvs[i], kvs[i + 1]));    }    return ret;}
public LookupKV<EnrichmentKey, EnrichmentValue> metron_f4557_0(Put put, String columnFamily) throws IOException
{    return fromPut(put, columnFamily, new EnrichmentKey(), new EnrichmentValue());}
public LookupKV<EnrichmentKey, EnrichmentValue> metron_f4558_0(Result result, String columnFamily) throws IOException
{    return fromResult(result, columnFamily, new EnrichmentKey(), new EnrichmentValue());}
public void metron_f4559_0(Table table, String cf, Iterable<LookupKV<EnrichmentKey, EnrichmentValue>> results) throws IOException
{    for (LookupKV<EnrichmentKey, EnrichmentValue> result : results) {        Put put = converter.toPut(cf, result.getKey(), result.getValue());        table.put(put);    }}
private byte[] metron_f4560_0() throws IOException
{    ByteArrayOutputStream baos = new ByteArrayOutputStream();    DataOutputStream w = new DataOutputStream(baos);    w.writeUTF(type);    w.writeUTF(indicator);    w.flush();    return baos.toByteArray();}
public byte[] metron_f4561_0()
{    byte[] indicatorBytes = new byte[0];    try {        indicatorBytes = typedIndicatorToBytes();    } catch (IOException e) {        throw new RuntimeException("Unable to convert type and indicator to bytes", e);    }    byte[] prefix = KeyUtil.INSTANCE.getPrefix(Bytes.toBytes(indicator));    return KeyUtil.INSTANCE.merge(prefix, indicatorBytes);}
public void metron_f4562_0(byte[] row)
{    ByteArrayInputStream baos = new ByteArrayInputStream(row);    baos.skip(KeyUtil.HASH_PREFIX_SIZE);    DataInputStream w = new DataInputStream(baos);    try {        type = w.readUTF();        indicator = w.readUTF();    } catch (IOException e) {        throw new RuntimeException("Unable to convert type and indicator from bytes", e);    }}
public boolean metron_f4563_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    EnrichmentKey that = (EnrichmentKey) o;    if (indicator != null ? !indicator.equals(that.indicator) : that.indicator != null)        return false;    return type != null ? type.equals(that.type) : that.type == null;}
public int metron_f4564_0()
{    int result = indicator != null ? indicator.hashCode() : 0;    result = 31 * result + (type != null ? type.hashCode() : 0);    return result;}
public String metron_f4565_0()
{    return "EnrichmentKey{" + "indicator='" + indicator + '\'' + ", type='" + type + '\'' + '}';}
public String metron_f4566_0()
{    return indicator;}
public void metron_f4567_0(String indicator)
{    this.indicator = indicator;}
protected ObjectMapper metron_f4568_0()
{    return new ObjectMapper();}
public Map<String, Object> metron_f4569_0()
{    return metadata;}
public Iterable<Map.Entry<byte[], byte[]>> metron_f4570_0()
{    return AbstractConverter.toEntries(VALUE_COLUMN_NAME_B, Bytes.toBytes(valueToString(metadata)));}
public void metron_f4571_0(Iterable<Map.Entry<byte[], byte[]>> values)
{    for (Map.Entry<byte[], byte[]> cell : values) {        if (Bytes.equals(cell.getKey(), VALUE_COLUMN_NAME_B)) {            metadata = stringToValue(Bytes.toString(cell.getValue()));        }    }}
public Map<String, Object> metron_f4572_0(String s)
{    try {        return _mapper.get().readValue(s, new TypeReference<Map<String, Object>>() {        });    } catch (IOException e) {        throw new RuntimeException("Unable to convert string to metadata: " + s);    }}
public String metron_f4573_0(Map<String, Object> value)
{    try {        return _mapper.get().writeValueAsString(value);    } catch (IOException e) {        throw new RuntimeException("Unable to convert metadata to string: " + value);    }}
public boolean metron_f4574_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    EnrichmentValue that = (EnrichmentValue) o;    return getMetadata() != null ? getMetadata().equals(that.getMetadata()) : that.getMetadata() == null;}
public int metron_f4575_0()
{    return getMetadata() != null ? getMetadata().hashCode() : 0;}
public String metron_f4576_0()
{    return "EnrichmentValue{" + "metadata=" + metadata + '}';}
 String metron_f4577_0(String enrichmentType, String field)
{    return "";}
public AccessTracker metron_f4578_0(Map<String, Object> config, TableProvider provider) throws IOException
{    return creator.create(config, provider);}
public AccessTracker metron_f4579_0(byte[] bytes) throws IOException, ClassNotFoundException
{    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));    return (AccessTracker) ois.readObject();}
public byte[] metron_f4580_0(AccessTracker tracker) throws IOException
{    ByteArrayOutputStream bos = new ByteArrayOutputStream();    ObjectOutputStream oos = new ObjectOutputStream(bos);    oos.writeObject(tracker);    oos.flush();    oos.close();    return bos.toByteArray();}
public void metron_f4581_0(Table accessTrackerTable, String columnFamily, PersistentAccessTracker.AccessTrackerKey key, AccessTracker underlyingTracker) throws IOException
{    Put put = new Put(key.toRowKey());    put.add(Bytes.toBytes(columnFamily), COLUMN, serializeTracker(underlyingTracker));    accessTrackerTable.put(put);}
public Iterable<AccessTracker> metron_f4582_0(Table accessTrackerTable, final String columnFamily, final String name, final long earliest) throws IOException
{    Scan scan = new Scan(PersistentAccessTracker.AccessTrackerKey.getTimestampScanKey(name, earliest));    ResultScanner scanner = accessTrackerTable.getScanner(scan);    return Iterables.transform(scanner, new Function<Result, AccessTracker>() {        @Nullable        @Override        public AccessTracker apply(@Nullable Result result) {            try {                return deserializeTracker(result.getValue(Bytes.toBytes(columnFamily), COLUMN));            } catch (Exception e) {                throw new RuntimeException("Unable to deserialize " + name + " @ " + earliest);            }        }    });}
public AccessTracker metron_f4583_0(@Nullable Result result)
{    try {        return deserializeTracker(result.getValue(Bytes.toBytes(columnFamily), COLUMN));    } catch (Exception e) {        throw new RuntimeException("Unable to deserialize " + name + " @ " + earliest);    }}
public AccessTracker metron_f4584_0(Iterable<AccessTracker> trackers) throws IOException, ClassNotFoundException
{    AccessTracker tracker = null;    for (AccessTracker t : trackers) {        if (tracker == null) {            tracker = t;        } else {            tracker = tracker.union(t);        }    }    return tracker;}
public byte[] metron_f4585_0(LookupKey lookupKey)
{    return lookupKey.toBytes();}
protected BloomFilter<LookupKey> metron_f4586_0()
{    return filter;}
public void metron_f4587_0(LookupKey key)
{    numInsertions++;    filter.add(key);}
public void metron_f4588_0(Map<String, Object> config)
{    expectedInsertions = toInt(config.get(EXPECTED_INSERTIONS_KEY));    falsePositiveRate = toDouble(config.get(FALSE_POSITIVE_RATE_KEY));    name = config.get(NAME_KEY).toString();    filter = new BloomFilter<LookupKey>(new LookupKeySerializer(), expectedInsertions, falsePositiveRate);}
public boolean metron_f4589_0(LookupKey key)
{    return filter.mightContain(key);}
public void metron_f4590_0()
{    filter = new BloomFilter<LookupKey>(new LookupKeySerializer(), expectedInsertions, falsePositiveRate);}
private static double metron_f4591_0(Object o)
{    if (o instanceof String) {        return Double.parseDouble((String) o);    } else if (o instanceof Number) {        return ((Number) o).doubleValue();    } else {        throw new IllegalStateException("Unable to convert " + o + " to a double.");    }}
private static int metron_f4592_0(Object o)
{    if (o instanceof String) {        return Integer.parseInt((String) o);    } else if (o instanceof Number) {        return ((Number) o).intValue();    } else {        throw new IllegalStateException("Unable to convert " + o + " to a double.");    }}
public String metron_f4593_0()
{    return name;}
public AccessTracker metron_f4594_0(AccessTracker tracker)
{    if (filter == null) {        throw new IllegalStateException("Unable to union access tracker, because this tracker is not initialized.");    }    if (tracker instanceof BloomAccessTracker) {        filter.merge(((BloomAccessTracker) tracker).getFilter());        return this;    } else {        throw new IllegalStateException("Unable to union access tracker, because it's not of the right type (BloomAccessTracker)");    }}
public boolean metron_f4595_0()
{    return numInsertions >= expectedInsertions;}
public boolean metron_f4599_0(LookupKey key)
{    return false;}
public String metron_f4600_0()
{    return "noop";}
public AccessTracker metron_f4601_0(AccessTracker tracker)
{    return null;}
public boolean metron_f4603_0()
{    return false;}
public byte[] metron_f4605_0()
{    ByteArrayOutputStream os = new ByteArrayOutputStream();    DataOutputStream dos = new DataOutputStream(os);    try {        dos.writeUTF(name);        dos.writeLong(timestamp);        dos.writeUTF(containerName);        dos.flush();    } catch (IOException e) {        throw new RuntimeException("Unable to write rowkey: " + this, e);    }    return os.toByteArray();}
public static byte[] metron_f4606_0(String name, long timestamp)
{    ByteArrayOutputStream os = new ByteArrayOutputStream();    DataOutputStream dos = new DataOutputStream(os);    try {        dos.writeUTF(name);        dos.writeLong(timestamp);    } catch (IOException e) {        throw new RuntimeException("Unable to create scan key ", e);    }    return os.toByteArray();}
public static AccessTrackerKey metron_f4607_0(byte[] rowKey)
{    ByteArrayInputStream is = new ByteArrayInputStream(rowKey);    DataInputStream dis = new DataInputStream(is);    try {        String name = dis.readUTF();        long timestamp = dis.readLong();        String containerName = dis.readUTF();        return new AccessTrackerKey(name, containerName, timestamp);    } catch (IOException e) {        throw new RuntimeException("Unable to read rowkey: ", e);    }}
public void metron_f4608_0()
{    tracker.persist(false);}
public void metron_f4609_1(boolean force)
{    synchronized (sync) {        if (force || (System.currentTimeMillis() - timestamp) >= maxMillisecondsBetweenPersists) {                        try {                AccessTrackerUtil.INSTANCE.persistTracker(accessTrackerTable, accessTrackerColumnFamily, new AccessTrackerKey(name, containerName, timestamp), underlyingTracker);                timestamp = System.currentTimeMillis();                reset();            } catch (IOException e) {                            }        }    }}
public void metron_f4610_0(LookupKey key)
{    synchronized (sync) {        underlyingTracker.logAccess(key);        if (isFull()) {            persist(true);        }    }}
public void metron_f4611_0(Map<String, Object> config)
{    underlyingTracker.configure(config);}
public boolean metron_f4612_0(LookupKey key)
{    synchronized (sync) {        return underlyingTracker.hasSeen(key);    }}
public String metron_f4613_0()
{    return underlyingTracker.getName();}
public AccessTracker metron_f4614_0(AccessTracker tracker)
{    PersistentAccessTracker t1 = (PersistentAccessTracker) tracker;    underlyingTracker = underlyingTracker.union(t1.underlyingTracker);    return this;}
public void metron_f4615_0()
{    synchronized (sync) {        underlyingTracker.reset();    }}
public boolean metron_f4616_0()
{    synchronized (sync) {        return underlyingTracker.isFull();    }}
public void metron_f4617_1() throws IOException
{    synchronized (sync) {        try {            persist(true);        } catch (Throwable t) {                    }        underlyingTracker.cleanup();        accessTrackerTable.close();    }}
public String metron_f4618_0()
{    return hBaseTable;}
public String metron_f4619_0()
{    return hBaseCF;}
public double metron_f4620_0()
{    return falsePositiveRate;}
public int metron_f4621_0()
{    return expectedInsertions;}
public long metron_f4622_0()
{    return millisecondsBetweenPersists;}
public AccessTracker metron_f4623_0(Map<String, Object> config, TableProvider provider) throws IOException
{    Config patConfig = new Config(config);    String hbaseTable = patConfig.getHBaseTable();    int expectedInsertions = patConfig.getExpectedInsertions();    double falsePositives = patConfig.getFalsePositiveRate();    long millisecondsBetweenPersist = patConfig.getMillisecondsBetweenPersists();    BloomAccessTracker bat = new BloomAccessTracker(hbaseTable, expectedInsertions, falsePositives);    Configuration hbaseConfig = HBaseConfiguration.create();    AccessTracker ret = new PersistentAccessTracker(hbaseTable, UUID.randomUUID().toString(), provider.getTable(hbaseConfig, hbaseTable), patConfig.getHBaseCF(), bat, millisecondsBetweenPersist);    return ret;}
public Table metron_f4624_0()
{    return table;}
public String metron_f4625_0()
{    return columnFamily;}
private String metron_f4626_0(HBaseContext context)
{    return context.getColumnFamily() == null ? columnFamily : context.getColumnFamily();}
public boolean metron_f4627_0(EnrichmentKey key, HBaseContext context, boolean logAccess) throws IOException
{    return context.getTable().exists(converter.toGet(getColumnFamily(context), key));}
public LookupKV<EnrichmentKey, EnrichmentValue> metron_f4628_0(EnrichmentKey key, HBaseContext context, boolean logAccess) throws IOException
{    return converter.fromResult(context.getTable().get(converter.toGet(getColumnFamily(context), key)), getColumnFamily(context));}
private List<Get> metron_f4629_0(Iterable<KeyWithContext<EnrichmentKey, HBaseContext>> keys)
{    List<Get> ret = new ArrayList<>();    for (KeyWithContext<EnrichmentKey, HBaseContext> key : keys) {        ret.add(converter.toGet(getColumnFamily(key.getContext()), key.getKey()));    }    return ret;}
public Iterable<Boolean> metron_f4630_0(Iterable<KeyWithContext<EnrichmentKey, HBaseContext>> key, boolean logAccess) throws IOException
{    List<Boolean> ret = new ArrayList<>();    if (Iterables.isEmpty(key)) {        return Collections.emptyList();    }    Table table = Iterables.getFirst(key, null).getContext().getTable();    for (boolean b : table.existsAll(keysToGets(key))) {        ret.add(b);    }    return ret;}
public Iterable<LookupKV<EnrichmentKey, EnrichmentValue>> metron_f4631_0(Iterable<KeyWithContext<EnrichmentKey, HBaseContext>> keys, boolean logAccess) throws IOException
{    if (Iterables.isEmpty(keys)) {        return Collections.emptyList();    }    Table table = Iterables.getFirst(keys, null).getContext().getTable();    List<LookupKV<EnrichmentKey, EnrichmentValue>> ret = new ArrayList<>();    Iterator<KeyWithContext<EnrichmentKey, HBaseContext>> keyWithContextIterator = keys.iterator();    for (Result result : table.get(keysToGets(keys))) {        HBaseContext context = keyWithContextIterator.next().getContext();        ret.add(converter.fromResult(result, getColumnFamily(context)));    }    return ret;}
public Table metron_f4633_0()
{    return table;}
public void metron_f4634_0() throws Exception
{    super.close();    table.close();}
public KEY_T metron_f4635_0()
{    return key;}
public CONTEXT_T metron_f4636_0()
{    return context;}
public String metron_f4637_0()
{    return name;}
public void metron_f4638_0(String name)
{    this.name = name;}
public AccessTracker metron_f4639_0()
{    return accessTracker;}
public void metron_f4640_0(AccessTracker accessTracker)
{    this.accessTracker = accessTracker;}
public Handler<CONTEXT_T, KEY_T, RESULT_T> metron_f4641_0()
{    return lookupHandler;}
public void metron_f4642_0(Handler<CONTEXT_T, KEY_T, RESULT_T> lookupHandler)
{    this.lookupHandler = lookupHandler;}
public boolean metron_f4643_0(KEY_T key, CONTEXT_T context, boolean logAccess) throws IOException
{    if (logAccess) {        accessTracker.logAccess(key);    }    return lookupHandler.exists(key, context, logAccess);}
public RESULT_T metron_f4644_0(KEY_T key, CONTEXT_T context, boolean logAccess) throws IOException
{    if (logAccess) {        accessTracker.logAccess(key);    }    return lookupHandler.get(key, context, logAccess);}
public Iterable<Boolean> metron_f4645_0(Iterable<KeyWithContext<KEY_T, CONTEXT_T>> key, boolean logAccess) throws IOException
{    if (logAccess) {        for (KeyWithContext<KEY_T, CONTEXT_T> k : key) {            accessTracker.logAccess(k.getKey());        }    }    return lookupHandler.exists(key, logAccess);}
public Iterable<RESULT_T> metron_f4646_0(Iterable<KeyWithContext<KEY_T, CONTEXT_T>> key, boolean logAccess) throws IOException
{    if (logAccess) {        for (KeyWithContext<KEY_T, CONTEXT_T> k : key) {            accessTracker.logAccess(k.getKey());        }    }    return lookupHandler.get(key, logAccess);}
public void metron_f4647_0() throws Exception
{    accessTracker.cleanup();    lookupHandler.close();}
public KEY_T metron_f4648_0()
{    return key;}
public VALUE_T metron_f4649_0()
{    return value;}
public boolean metron_f4650_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    LookupKV<?, ?> lookupKV = (LookupKV<?, ?>) o;    if (key != null ? !key.equals(lookupKV.key) : lookupKV.key != null)        return false;    return value != null ? value.equals(lookupKV.value) : lookupKV.value == null;}
public int metron_f4651_0()
{    int result = key != null ? key.hashCode() : 0;    result = 31 * result + (value != null ? value.hashCode() : 0);    return result;}
public String metron_f4652_0()
{    return "LookupKV{" + "key=" + key + ", value=" + value + '}';}
public static ConcurrencyContext metron_f4653_0(EnrichmentStrategies strategy)
{    return strategyToInfrastructure.get(strategy);}
public synchronized void metron_f4654_1(int numThreads, long maxCacheSize, long maxTimeRetain, WorkerPoolStrategies poolStrategy, Logger log, boolean logStats)
{    if (executor == null) {        if (log != null) {                    }        executor = (poolStrategy == null ? WorkerPoolStrategies.FIXED : poolStrategy).create(numThreads);    }    if (cache == null) {        if (log != null) {                    }        Caffeine builder = Caffeine.newBuilder().maximumSize(maxCacheSize).expireAfterWrite(maxTimeRetain, TimeUnit.MINUTES).executor(executor);        if (logStats) {            builder = builder.recordStats();        }        cache = builder.build();    }}
public static Executor metron_f4655_0()
{    return executor;}
public Cache<CacheKey, JSONObject> metron_f4656_0()
{    return cache;}
public JSONObject metron_f4657_0() throws Exception
{        adapter.logAccess(key);    return adapter.enrich(key);}
public JSONObject metron_f4658_0(CacheKey cacheKey)
{    adapter.logAccess(key);    return adapter.enrich(cacheKey);}
public FunctionResolver metron_f4659_0()
{    return functionResolver;}
public Context metron_f4660_0()
{    return stellarContext;}
public EnrichmentConfig metron_f4661_0(SensorEnrichmentConfig config)
{    return enrichmentStrategy.getUnderlyingConfig(config);}
public String metron_f4662_0(String type, String field)
{    return enrichmentStrategy.fieldToEnrichmentKey(type, field);}
public JSONObject metron_f4663_0(JSONObject message, SensorEnrichmentConfig config, EnrichmentContext context)
{    return enrichmentStrategy.postProcess(message, config, context);}
public Constants.ErrorType metron_f4664_0()
{    return enrichmentStrategy.getErrorType();}
public EnrichmentConfig metron_f4665_0(SensorEnrichmentConfig config)
{    return config.getEnrichment();}
public Constants.ErrorType metron_f4666_0()
{    return Constants.ErrorType.ENRICHMENT_ERROR;}
public String metron_f4667_0(String type, String field)
{    return EnrichmentUtils.getEnrichmentKey(type, field);}
public EnrichmentConfig metron_f4668_0(SensorEnrichmentConfig config)
{    return config.getThreatIntel();}
public Constants.ErrorType metron_f4669_0()
{    return Constants.ErrorType.THREAT_INTEL_ERROR;}
public String metron_f4670_0(String type, String field)
{    return ThreatIntelUtils.getThreatIntelKey(type, field);}
public JSONObject metron_f4671_0(JSONObject message, SensorEnrichmentConfig config, EnrichmentContext context)
{    return ThreatIntelUtils.triage(message, config, context.getFunctionResolver(), context.getStellarContext());}
 JSONObject metron_f4672_0(JSONObject message, SensorEnrichmentConfig config, EnrichmentContext context)
{    return message;}
public JSONObject metron_f4673_0()
{    return result;}
public List<Map.Entry<Object, Throwable>> metron_f4674_0()
{    return enrichmentErrors;}
public EnrichmentResult metron_f4675_0(JSONObject message, EnrichmentStrategies strategy, SensorEnrichmentConfig config, PerformanceLogger perfLog) throws ExecutionException, InterruptedException
{    if (message == null) {        return null;    }    if (perfLog != null) {        perfLog.mark("execute");        if (perfLog.isDebugEnabled() && !cacheStats.isEmpty()) {            CacheStats before = cacheStats.get(strategy);            CacheStats after = concurrencyContext.getCache().stats();            if (before != null && after != null) {                CacheStats delta = after.minus(before);                perfLog.log("cache", delta.toString());            }            cacheStats.put(strategy, after);        }    }    String sensorType = MessageUtils.getSensorType(message);    message.put(getClass().getSimpleName().toLowerCase() + ".splitter.begin.ts", "" + System.currentTimeMillis());                        Map<String, List<JSONObject>> tasks = splitMessage(message, strategy, config);    message.put(getClass().getSimpleName().toLowerCase() + ".splitter.end.ts", "" + System.currentTimeMillis());    message.put(getClass().getSimpleName().toLowerCase() + ".enrich.begin.ts", "" + System.currentTimeMillis());    if (perfLog != null) {        perfLog.mark("enrich");    }    List<CompletableFuture<JSONObject>> taskList = new ArrayList<>();    List<Map.Entry<Object, Throwable>> errors = Collections.synchronizedList(new ArrayList<>());    for (Map.Entry<String, List<JSONObject>> task : tasks.entrySet()) {                EnrichmentAdapter<CacheKey> adapter = enrichmentsByType.get(task.getKey());        if (adapter == null) {            throw new IllegalStateException("Unable to find an adapter for " + task.getKey() + ", possible adapters are: " + Joiner.on(",").join(enrichmentsByType.keySet()));        }        message.put("adapter." + adapter.getClass().getSimpleName().toLowerCase() + ".begin.ts", "" + System.currentTimeMillis());        for (JSONObject m : task.getValue()) {            /* now for each unit of work (each of these only has one element in them)         * the key is the field name and the value is value associated with that field.         *         * In the case of stellar enrichment, the field name is the subgroup name or empty string.         * The value is the subset of the message needed for the enrichment.         *         * In the case of another enrichment (e.g. hbase), the field name is the field name being enriched.         * The value is the corresponding value.         */            for (Object o : m.keySet()) {                String field = (String) o;                Object value = m.get(o);                if (value == null) {                    message.put("adapter." + adapter.getClass().getSimpleName().toLowerCase() + ".end.ts", "" + System.currentTimeMillis());                    continue;                }                CacheKey cacheKey = new CacheKey(field, value, config);                String prefix = adapter.getOutputPrefix(cacheKey);                Supplier<JSONObject> supplier = () -> {                    try {                        JSONObject ret = concurrencyContext.getCache().get(cacheKey, new EnrichmentCallable(cacheKey, adapter));                        if (ret == null) {                            ret = new JSONObject();                        }                                                JSONObject adjustedKeys = EnrichmentUtils.adjustKeys(new JSONObject(), ret, cacheKey.getField(), prefix);                        adjustedKeys.put("adapter." + adapter.getClass().getSimpleName().toLowerCase() + ".end.ts", "" + System.currentTimeMillis());                        return adjustedKeys;                    } catch (Throwable e) {                        JSONObject errorMessage = new JSONObject();                        errorMessage.putAll(m);                        errorMessage.put(Constants.SENSOR_TYPE, sensorType);                        errors.add(new AbstractMap.SimpleEntry<>(errorMessage, new IllegalStateException(strategy + " error with " + task.getKey() + " failed: " + e.getMessage(), e)));                        return new JSONObject();                    }                };                                taskList.add(CompletableFuture.supplyAsync(supplier, ConcurrencyContext.getExecutor()));            }        }    }    if (taskList.isEmpty()) {        message.put(getClass().getSimpleName().toLowerCase() + ".enrich.end.ts", "" + System.currentTimeMillis());        return new EnrichmentResult(message, errors);    }    EnrichmentResult ret = new EnrichmentResult(all(taskList, message, (left, right) -> join(left, right)).get(), errors);    ret.getResult().put(getClass().getSimpleName().toLowerCase() + ".enrich.end.ts", "" + System.currentTimeMillis());    if (perfLog != null) {        String key = message.get(Constants.GUID) + "";        perfLog.log("enrich", "key={}, elapsed time to enrich", key);        perfLog.log("execute", "key={}, elapsed time to run execute", key);    }    return ret;}
private static JSONObject metron_f4676_0(JSONObject left, JSONObject right)
{    JSONObject message = new JSONObject();    message.putAll(left);    message.putAll(right);    List<Object> emptyKeys = new ArrayList<>();    for (Object key : message.keySet()) {        Object value = message.get(key);        if (value == null || value.toString().length() == 0) {            emptyKeys.add(key);        }    }    for (Object o : emptyKeys) {        message.remove(o);    }    return message;}
public static CompletableFuture<JSONObject> metron_f4677_0(List<CompletableFuture<JSONObject>> futures, JSONObject identity, BinaryOperator<JSONObject> reduceOp)
{    CompletableFuture[] cfs = futures.toArray(new CompletableFuture[futures.size()]);    CompletableFuture<Void> future = CompletableFuture.allOf(cfs);    return future.thenApply(aVoid -> futures.stream().map(CompletableFuture::join).reduce(identity, reduceOp));}
public Map<String, List<JSONObject>> metron_f4678_0(JSONObject message, EnrichmentStrategy enrichmentStrategy, SensorEnrichmentConfig config)
{    Map<String, List<JSONObject>> streamMessageMap = new HashMap<>();    Map<String, Object> enrichmentFieldMap = enrichmentStrategy.getUnderlyingConfig(config).getFieldMap();    Map<String, ConfigHandler> fieldToHandler = enrichmentStrategy.getUnderlyingConfig(config).getEnrichmentConfigs();    Set<String> enrichmentTypes = new HashSet<>(enrichmentFieldMap.keySet());        enrichmentTypes.addAll(fieldToHandler.keySet());        for (String enrichmentType : enrichmentTypes) {        Object fields = enrichmentFieldMap.get(enrichmentType);        ConfigHandler retriever = fieldToHandler.get(enrichmentType);                List<JSONObject> enrichmentObject = retriever.getType().splitByFields(message, fields, field -> enrichmentStrategy.fieldToEnrichmentKey(enrichmentType, field), retriever);        streamMessageMap.put(enrichmentType, enrichmentObject);    }    return streamMessageMap;}
public ExecutorService metron_f4679_0(int numThreads)
{    return creator.apply(numThreads);}
public Object metron_f4680_1(List<Object> args, Context context) throws ParseException
{    if (!initialized) {        return null;    }    if (args.size() > 2) {        throw new IllegalArgumentException("ASN_GET received more arguments than expected: " + args.size());    }    if (args.size() == 1 && args.get(0) instanceof String) {                String ip = (String) args.get(0);        if (ip == null || ip.trim().isEmpty()) {                        return null;        }        Optional<Map<String, Object>> result = GeoLiteAsnDatabase.INSTANCE.get(ip);        return result.orElse(Collections.EMPTY_MAP);    } else if (args.size() == 2 && args.get(1) instanceof List) {                String ip = (String) args.get(0);        @SuppressWarnings("unchecked")        List<String> fields = (List) args.get(1);        Optional<Map<String, Object>> result = GeoLiteAsnDatabase.INSTANCE.get(ip);                if (fields.size() == 1 && result.isPresent()) {            if (!result.get().containsKey(fields.get(0))) {                return null;            }            return result.get().get(fields.get(0));        } else if (result.isPresent()) {                        Map<String, Object> filteredInfo = new HashMap<>();            for (String field : fields) {                Map<String, Object> asnInfo = result.get();                filteredInfo.put(field, asnInfo.get(field));            }            return filteredInfo;        }    }    return null;}
public void metron_f4681_1(Context context)
{        Map<String, Object> config = getConfig(context);    String hdfsDir = (String) config.get(GeoLiteAsnDatabase.ASN_HDFS_FILE);    GeoLiteAsnDatabase.INSTANCE.update(hdfsDir);    initialized = true;}
private static Map<String, Object> metron_f4682_0(Context context)
{    return (Map<String, Object>) context.getCapability(Context.Capabilities.GLOBAL_CONFIG, false).orElse(new HashMap<>());}
public boolean metron_f4683_0()
{    return initialized;}
public Object metron_f4684_1(List<Object> args, Context context) throws ParseException
{    if (args.size() != 2) {        throw new IllegalArgumentException("All parameters are mandatory, submit 'hdfs path', 'indicator'");    }    if (!isInitialized()) {        return null;    }    String path = (String) args.get(0);    String indicator = (String) args.get(1);    if (path == null || indicator == null) {        return null;    }    Object value;    try {        Map cachedMap = (Map) objectCache.get(path);                value = cachedMap.get(indicator);    } catch (ClassCastException e) {        throw new ClassCastException(String.format("The object stored in HDFS at '%s' must be serialized in JSON format.", path));    }    return value;}
public void metron_f4685_0(Context context)
{    Map<String, Object> config = (Map<String, Object>) context.getCapability(Context.Capabilities.GLOBAL_CONFIG, false).orElse(new HashMap<>());    Map<String, Object> enrichmentGetConfig = (Map<String, Object>) config.getOrDefault(ENRICHMENT_OBJECT_GET_SETTINGS, new HashMap<>());    ObjectCacheConfig objectCacheConfig = new ObjectCacheConfig(enrichmentGetConfig);    objectCache = new ObjectCache();    objectCache.initialize(objectCacheConfig);}
public boolean metron_f4686_0()
{    return objectCache != null && objectCache.isInitialized();}
public Object metron_f4687_0(List<Object> args, Context context) throws ParseException
{    if (!initialized) {        return null;    }    if (args.size() > 2) {        throw new IllegalArgumentException("GEO_GET received more arguments than expected: " + args.size());    }    if (args.size() == 1 && args.get(0) instanceof String) {                String ip = (String) args.get(0);        if (ip == null || ip.trim().isEmpty()) {            return null;        }        Optional<Map<String, String>> result = GeoLiteCityDatabase.INSTANCE.get(ip);        return result.orElse(Collections.emptyMap());    } else if (args.size() == 2 && args.get(1) instanceof List) {                String ip = (String) args.get(0);        @SuppressWarnings("unchecked")        List<String> fields = (List) args.get(1);        Optional<Map<String, String>> result = GeoLiteCityDatabase.INSTANCE.get(ip);                if (fields.size() == 1 && result.isPresent()) {            return result.get().get(fields.get(0));        } else if (result.isPresent()) {                        Map<String, String> filteredInfo = new HashMap<>();            for (String field : fields) {                Map<String, String> geoInfo = result.get();                filteredInfo.put(field, geoInfo.get(field));            }            return filteredInfo;        }    }    return null;}
public void metron_f4688_1(Context context)
{        Map<String, Object> config = getConfig(context);    String hdfsDir = (String) config.get(GeoLiteCityDatabase.GEO_HDFS_FILE);    GeoLiteCityDatabase.INSTANCE.update(hdfsDir);    initialized = true;}
private static Map<String, Object> metron_f4689_0(Context context)
{    return (Map<String, Object>) context.getCapability(Context.Capabilities.GLOBAL_CONFIG, false).orElse(new HashMap<>());}
public boolean metron_f4690_0()
{    return initialized;}
public Object metron_f4691_0(List<Object> args, Context context) throws ParseException
{    if (args.size() < 1) {        return null;    }    String hash = (String) args.get(0);    if (hash == null) {        return null;    }    Optional<WGS84Point> point = GeoHashUtil.INSTANCE.toPoint(hash);    if (point.isPresent()) {        Map<String, Object> ret = new HashMap<>();        ret.put(GeoLiteCityDatabase.GeoProps.LONGITUDE.getSimpleName(), point.get().getLongitude());        ret.put(GeoLiteCityDatabase.GeoProps.LATITUDE.getSimpleName(), point.get().getLatitude());        return ret;    }    return null;}
public boolean metron_f4693_0()
{    return true;}
public Object metron_f4694_0(List<Object> args, Context context) throws ParseException
{    if (args.size() < 2) {        return null;    }    Object latObj = args.get(0);    Object longObj = args.get(1);    if (latObj == null || longObj == null) {        return null;    }    Double latitude = ConversionUtils.convert(latObj, Double.class);    Double longitude = ConversionUtils.convert(longObj, Double.class);    int charPrecision = 12;    if (args.size() > 2) {        charPrecision = ConversionUtils.convert(args.get(2), Integer.class);    }    Optional<String> ret = GeoHashUtil.INSTANCE.computeHash(latitude, longitude, charPrecision);    return ret.orElse(null);}
public boolean metron_f4696_0()
{    return true;}
public Object metron_f4697_0(List<Object> args, Context context) throws ParseException
{    if (args.size() < 1) {        return null;    }    Map<String, String> map = (Map<String, String>) args.get(0);    if (map == null) {        return null;    }    int charPrecision = 12;    if (args.size() > 1) {        charPrecision = ConversionUtils.convert(args.get(1), Integer.class);    }    Optional<String> ret = GeoHashUtil.INSTANCE.computeHash(map, charPrecision);    return ret.orElse(null);}
public boolean metron_f4699_0()
{    return true;}
public Object metron_f4700_0(List<Object> args, Context context) throws ParseException
{    if (args.size() < 2) {        return null;    }    String hash1 = (String) args.get(0);    if (hash1 == null) {        return null;    }    Optional<WGS84Point> pt1 = GeoHashUtil.INSTANCE.toPoint(hash1);    String hash2 = (String) args.get(1);    if (hash2 == null) {        return null;    }    Optional<WGS84Point> pt2 = GeoHashUtil.INSTANCE.toPoint(hash2);    DistanceStrategy strat = DistanceStrategies.HAVERSINE;    if (args.size() > 2) {        strat = DistanceStrategies.valueOf((String) args.get(2));    }    if (pt1.isPresent() && pt2.isPresent()) {        return GeoHashUtil.INSTANCE.distance(pt1.get(), pt2.get(), strat);    }    return Double.NaN;}
public boolean metron_f4702_0()
{    return true;}
public Object metron_f4703_0(List<Object> args, Context context) throws ParseException
{    if (args.size() < 1) {        return null;    }    Iterable<String> hashes = (Iterable<String>) args.get(0);    if (hashes == null) {        return null;    }    DistanceStrategy strat = DistanceStrategies.HAVERSINE;    if (args.size() > 1) {        strat = DistanceStrategies.valueOf((String) args.get(1));    }    return GeoHashUtil.INSTANCE.maxDistanceHashes(hashes, strat);}
public boolean metron_f4705_0()
{    return true;}
public Object metron_f4706_0(List<Object> args, Context context) throws ParseException
{    if (args.size() < 1) {        return null;    }    Object o1 = args.get(0);    if (o1 == null) {        return null;    }    WGS84Point centroid = null;    if (o1 instanceof Map) {        centroid = GeoHashUtil.INSTANCE.centroidOfWeightedPoints((Map<String, Number>) o1);    } else if (o1 instanceof Iterable) {        centroid = GeoHashUtil.INSTANCE.centroidOfHashes((Iterable<String>) o1);    }    if (centroid == null) {        return null;    }    Integer precision = 12;    if (args.size() > 1) {        precision = (Integer) args.get(1);    }    return GeoHashUtil.INSTANCE.computeHash(centroid, precision).orElse(null);}
public boolean metron_f4708_0()
{    return true;}
public Object metron_f4709_0(List<Object> args, Context context) throws ParseException
{    if (!isInitialized()) {        return null;    }    if (args.size() < 1) {        return null;    }    Object o = args.get(0);    if (o == null) {        return null;    }    if (o instanceof String) {        return objectCache.get((String) o);    } else {        throw new IllegalStateException("Unable to retrieve " + o + " as it is not a path");    }}
public void metron_f4710_0(Context context)
{    Map<String, Object> config = getConfig(context);    objectCache = new ObjectCache();    objectCache.initialize(new ObjectCacheConfig(config));}
public boolean metron_f4711_0()
{    return objectCache != null && objectCache.isInitialized();}
protected Map<String, Object> metron_f4712_0(Context context)
{    return (Map<String, Object>) context.getCapability(Context.Capabilities.GLOBAL_CONFIG, false).orElse(new HashMap<>());}
public String metron_f4713_0()
{    return "Table{" + "name='" + name + '\'' + ", columnFamily='" + columnFamily + '\'' + '}';}
public boolean metron_f4714_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    WrapperTable table = (WrapperTable) o;    if (name != null ? !name.equals(table.name) : table.name != null)        return false;    return columnFamily != null ? columnFamily.equals(table.columnFamily) : table.columnFamily == null;}
public int metron_f4715_0()
{    int result = name != null ? name.hashCode() : 0;    result = 31 * result + (columnFamily != null ? columnFamily.hashCode() : 0);    return result;}
private static Map<String, Object> metron_f4716_0(Context context)
{    return (Map<String, Object>) context.getCapability(Context.Capabilities.GLOBAL_CONFIG).orElse(new HashMap<>());}
private static synchronized void metron_f4717_0(Map<String, Object> config, TableProvider provider) throws IOException
{    if (tracker == null) {        String accessTrackerType = (String) config.getOrDefault(ACCESS_TRACKER_TYPE_CONF, AccessTrackers.NOOP.toString());        AccessTrackers trackers = AccessTrackers.valueOf(accessTrackerType);        tracker = trackers.create(config, provider);    }}
private static TableProvider metron_f4718_0(String tableProviderClass)
{    try {        Class<? extends TableProvider> providerClazz = (Class<? extends TableProvider>) Class.forName(tableProviderClass);        return providerClazz.getConstructor().newInstance();    } catch (Exception e) {        return new HTableProvider();    }}
private static synchronized void metron_f4719_0(Map<String, Object> config)
{    if (provider != null) {        return;    } else {        String tableProviderClass = (String) config.getOrDefault(TABLE_PROVIDER_TYPE_CONF, HTableProvider.class.getName());        provider = createProvider(tableProviderClass);    }}
public Object metron_f4720_1(List<Object> args, Context context) throws ParseException
{    if (!initialized) {        return false;    }    if (args.size() != 4) {        throw new IllegalStateException("All parameters are mandatory, submit 'enrichment type', 'indicator', 'nosql_table' and 'column_family'");    }    int i = 0;    String enrichmentType = (String) args.get(i++);    String indicator = (String) args.get(i++);    String table = (String) args.get(i++);    String cf = (String) args.get(i++);    if (enrichmentType == null || indicator == null) {        return false;    }    final WrapperTable key = new WrapperTable(table, cf);    EnrichmentLookup lookup = null;    try {        lookup = enrichmentCollateralCache.get(key, () -> {            Table hTable = provider.getTable(HBaseConfiguration.create(), key.name);            return new EnrichmentLookup(hTable, key.columnFamily, tracker);        });    } catch (ExecutionException e) {                return false;    }    EnrichmentLookup.HBaseContext hbaseContext = new EnrichmentLookup.HBaseContext(lookup.getTable(), cf);    try {        return lookup.exists(new EnrichmentKey(enrichmentType, indicator), hbaseContext, true);    } catch (IOException e) {                return false;    }}
public void metron_f4721_1(Context context)
{    try {        Map<String, Object> config = getConfig(context);        initializeProvider(config);        initializeTracker(config, provider);    } catch (IOException e) {            } finally {        initialized = true;    }}
public boolean metron_f4722_0()
{    return initialized;}
public Object metron_f4723_1(List<Object> args, Context context) throws ParseException
{    if (!initialized) {        return false;    }    if (args.size() != 4) {        throw new IllegalStateException("All parameters are mandatory, submit 'enrichment type', 'indicator', 'nosql_table' and 'column_family'");    }    int i = 0;    String enrichmentType = (String) args.get(i++);    String indicator = (String) args.get(i++);    String table = (String) args.get(i++);    String cf = (String) args.get(i++);    if (enrichmentType == null || indicator == null) {        return new HashMap<String, Object>();    }    final WrapperTable key = new WrapperTable(table, cf);    EnrichmentLookup lookup = null;    try {        lookup = enrichmentCollateralCache.get(key, () -> {            Table hTable = provider.getTable(HBaseConfiguration.create(), key.name);            return new EnrichmentLookup(hTable, key.columnFamily, tracker);        });    } catch (ExecutionException e) {                return new HashMap<String, Object>();    }    EnrichmentLookup.HBaseContext hbaseContext = new EnrichmentLookup.HBaseContext(lookup.getTable(), cf);    try {        LookupKV<EnrichmentKey, EnrichmentValue> kv = lookup.get(new EnrichmentKey(enrichmentType, indicator), hbaseContext, true);        if (kv != null && kv.getValue() != null && kv.getValue().getMetadata() != null) {            return kv.getValue().getMetadata();        }        return new HashMap<String, Object>();    } catch (IOException e) {                return new HashMap<String, Object>();    }}
public void metron_f4724_1(Context context)
{    try {        Map<String, Object> config = getConfig(context);        initializeProvider(config);        initializeTracker(config, provider);    } catch (IOException e) {            } finally {        initialized = true;    }}
public boolean metron_f4725_0()
{    return initialized;}
public static String metron_f4726_0(String enrichmentName, String field)
{    return Joiner.on(".").join(new String[] { KEY_PREFIX, enrichmentName, field });}
public KeyWithContext<EnrichmentKey, EnrichmentLookup.HBaseContext> metron_f4727_0(@Nullable String enrichmentType)
{    EnrichmentKey key = new EnrichmentKey(enrichmentType, indicator);    EnrichmentLookup.HBaseContext context = new EnrichmentLookup.HBaseContext(table, getColumnFamily(enrichmentType, config));    return new KeyWithContext<>(key, context);}
protected Map<Object, Map<String, String>> metron_f4728_0()
{    return new HashMap<>();}
public static String metron_f4729_0(String enrichmentType, EnrichmentConfig config)
{    Object o = config.getConfig().get(TYPE_TO_COLUMN_FAMILY_CONF);    if (o == null) {        return null;    } else {        Map<String, String> cfMap = typeToCFs.get().get(o);        if (cfMap == null) {            cfMap = new HashMap<>();            if (o instanceof Map) {                Map map = (Map) o;                for (Object key : map.keySet()) {                    cfMap.put(key.toString(), map.get(key).toString());                }            }            typeToCFs.get().put(o, cfMap);        }        return cfMap.get(enrichmentType);    }}
public static String metron_f4730_0(String field)
{    if (field == null) {        return null;    }    return Iterables.getLast(Splitter.on('.').split(field));}
public static TableProvider metron_f4731_0(String connectorImpl, TableProvider defaultImpl)
{    if (connectorImpl == null || connectorImpl.length() == 0 || connectorImpl.charAt(0) == '$') {        return defaultImpl;    } else {        try {            Class<? extends TableProvider> clazz = (Class<? extends TableProvider>) Class.forName(connectorImpl);            return clazz.getConstructor().newInstance();        } catch (InstantiationException e) {            throw new IllegalStateException("Unable to instantiate connector.", e);        } catch (IllegalAccessException e) {            throw new IllegalStateException("Unable to instantiate connector: illegal access", e);        } catch (InvocationTargetException e) {            throw new IllegalStateException("Unable to instantiate connector", e);        } catch (NoSuchMethodException e) {            throw new IllegalStateException("Unable to instantiate connector: no such method", e);        } catch (ClassNotFoundException e) {            throw new IllegalStateException("Unable to instantiate connector: class not found", e);        }    }}
public static JSONObject metron_f4732_0(JSONObject enrichedMessage, JSONObject enrichedField, String field, String prefix)
{    if (!enrichedField.isEmpty()) {        for (Object enrichedKey : enrichedField.keySet()) {            if (!StringUtils.isEmpty(prefix)) {                enrichedMessage.put(field + "." + enrichedKey, enrichedField.get(enrichedKey));            } else {                enrichedMessage.put(enrichedKey, enrichedField.get(enrichedKey));            }        }    }    return enrichedMessage;}
public static String metron_f4733_0(String threatIntelName, String field)
{    return Joiner.on(".").join(new String[] { KEY_PREFIX, threatIntelName, field });}
public static JSONObject metron_f4734_1(JSONObject ret, SensorEnrichmentConfig config, FunctionResolver functionResolver, Context stellarContext)
{    LOG.trace("Received joined messages: {}", ret);    boolean isAlert = ret.containsKey("is_alert");    if (!isAlert) {        for (Object key : ret.keySet()) {            if (key.toString().startsWith("threatintels") && !key.toString().endsWith(".ts")) {                isAlert = true;                break;            }        }    } else {        Object isAlertObj = ret.get("is_alert");        isAlert = ConversionUtils.convert(isAlertObj, Boolean.class);        if (!isAlert) {            ret.remove("is_alert");        }    }    if (isAlert) {        ret.put("is_alert", "true");        String sourceType = MessageUtils.getSensorType(ret);        ThreatTriageConfig triageConfig = null;        if (config != null) {            triageConfig = config.getThreatIntel().getTriageConfig();            if (LOG.isDebugEnabled()) {                            }        } else {                    }        if (triageConfig != null) {            if (LOG.isDebugEnabled()) {                            }            if (LOG.isDebugEnabled() && (triageConfig.getRiskLevelRules() == null || triageConfig.getRiskLevelRules().isEmpty())) {                            }                        ThreatTriageProcessor threatTriageProcessor = new ThreatTriageProcessor(config, functionResolver, stellarContext);            ThreatScore score = threatTriageProcessor.apply(ret);            if (LOG.isDebugEnabled()) {                String rules = Joiner.on('\n').join(triageConfig.getRiskLevelRules());                            }                        if (score.getRuleScores().size() > 0) {                appendThreatScore(score, ret);            }        } else {                    }    }    return ret;}
private static void metron_f4735_0(ThreatScore threatScore, JSONObject message)
{        message.put(THREAT_TRIAGE_SCORE_KEY, threatScore.getScore());        Joiner joiner = Joiner.on(".");    int i = 0;    for (RuleScore score : threatScore.getRuleScores()) {        message.put(joiner.join(THREAT_TRIAGE_RULES_KEY, i, THREAT_TRIAGE_RULE_NAME), score.getRule().getName());        message.put(joiner.join(THREAT_TRIAGE_RULES_KEY, i, THREAT_TRIAGE_RULE_COMMENT), score.getRule().getComment());        message.put(joiner.join(THREAT_TRIAGE_RULES_KEY, i, THREAT_TRIAGE_RULE_SCORE), score.getRule().getScoreExpression());        message.put(joiner.join(THREAT_TRIAGE_RULES_KEY, i++, THREAT_TRIAGE_RULE_REASON), score.getReason());    }}
public ThreatScore metron_f4736_0(@Nullable Map message)
{    ThreatScore threatScore = new ThreatScore();    StellarPredicateProcessor predicateProcessor = new StellarPredicateProcessor();    StellarProcessor processor = new StellarProcessor();    VariableResolver variableResolver = new MapVariableResolver(message, sensorConfig.getConfiguration(), threatIntelConfig.getConfig());        for (RiskLevelRule rule : threatTriageConfig.getRiskLevelRules()) {        if (predicateProcessor.parse(rule.getRule(), variableResolver, functionResolver, context)) {                        String reason = execute(rule.getReason(), processor, variableResolver, String.class);            Double score = execute(rule.getScoreExpression(), processor, variableResolver, Double.class);            threatScore.addRuleScore(new RuleScore(rule, reason, score));        }    }        List<Number> ruleScores = new ArrayList<>();    for (RuleScore ruleScore : threatScore.getRuleScores()) {        ruleScores.add(ruleScore.getScore());    }    Aggregators aggregators = threatTriageConfig.getAggregator();    Double aggregateScore = aggregators.aggregate(ruleScores, threatTriageConfig.getAggregationConfig());    threatScore.setScore(aggregateScore);    return threatScore;}
private T metron_f4737_0(String expression, StellarProcessor processor, VariableResolver resolver, Class<T> clazz)
{    Object result = processor.parse(expression, resolver, functionResolver, context);    return ConversionUtils.convert(result, clazz);}
public List<RiskLevelRule> metron_f4738_0()
{    return threatTriageConfig.getRiskLevelRules();}
public SensorEnrichmentConfig metron_f4739_0()
{    return sensorConfig;}
public String metron_f4740_0()
{    return String.format("ThreatTriage{%d rule(s)}", threatTriageConfig.getRiskLevelRules().size());}
public void metron_f4741_0() throws ParseException
{    JSONParser jsonParser = new JSONParser();    expectedMessage = (JSONObject) jsonParser.parse(expectedMessageString);}
public void metron_f4742_0() throws Exception
{    HostFromJSONListAdapter hja = new HostFromJSONListAdapter(expectedKnownHostsString);    JSONObject actualMessage = hja.enrich(new CacheKey("dummy", ip, null));    Assert.assertNotNull(actualMessage);    Assert.assertEquals(expectedMessage, actualMessage);    actualMessage = hja.enrich(new CacheKey("dummy", ip1, null));    JSONObject emptyJson = new JSONObject();    Assert.assertEquals(emptyJson, actualMessage);}
public void metron_f4743_0() throws Exception
{    HostFromJSONListAdapter hja = new HostFromJSONListAdapter(expectedKnownHostsString);    JSONObject actualMessage = hja.enrich(new CacheKey("dummy", ip, null));    Assert.assertNotNull(actualMessage);    Assert.assertEquals(expectedMessage, actualMessage);    actualMessage = hja.enrich(new CacheKey("dummy", 10L, null));    JSONObject emptyJson = new JSONObject();    Assert.assertEquals(emptyJson, actualMessage);}
public void metron_f4744_0() throws Exception
{    HostFromJSONListAdapter hja = new HostFromJSONListAdapter(expectedKnownHostsString);    Assert.assertTrue(hja.initializeAdapter(null));}
public void metron_f4745_0() throws ParseException
{    JSONParser jsonParser = new JSONParser();    expectedMessage = (JSONObject) jsonParser.parse(expectedMessageString);}
public void metron_f4746_0() throws Exception
{    Map<String, JSONObject> mapKnownHosts = new HashMap<>();    JSONArray jsonArray = (JSONArray) JSONValue.parse(expectedKnownHostsString);    Iterator jsonArrayIterator = jsonArray.iterator();    while (jsonArrayIterator.hasNext()) {        JSONObject jsonObject = (JSONObject) jsonArrayIterator.next();        String host = (String) jsonObject.remove("ip");        mapKnownHosts.put(host, jsonObject);    }    HostFromPropertiesFileAdapter hfa = new HostFromPropertiesFileAdapter(mapKnownHosts);    JSONObject actualMessage = hfa.enrich(new CacheKey("dummy", ip, null));    Assert.assertNotNull(actualMessage);    Assert.assertEquals(expectedMessage, actualMessage);    actualMessage = hfa.enrich(new CacheKey("dummy", ip1, null));    JSONObject emptyJson = new JSONObject();    Assert.assertEquals(emptyJson, actualMessage);}
public void metron_f4747_0() throws Exception
{    Map<String, JSONObject> mapKnownHosts = new HashMap<>();    HostFromPropertiesFileAdapter hfa = new HostFromPropertiesFileAdapter(mapKnownHosts);    Assert.assertFalse(hfa.initializeAdapter(null));    JSONArray jsonArray = (JSONArray) JSONValue.parse(expectedKnownHostsString);    Iterator jsonArrayIterator = jsonArray.iterator();    while (jsonArrayIterator.hasNext()) {        JSONObject jsonObject = (JSONObject) jsonArrayIterator.next();        String host = (String) jsonObject.remove("ip");        mapKnownHosts.put(host, jsonObject);    }    hfa = new HostFromPropertiesFileAdapter(mapKnownHosts);    Assert.assertTrue(hfa.initializeAdapter(null));}
public void metron_f4748_0()
{    conn = new MySqlConfig();    conn.setHost("10.22.0.214");    conn.setPort(3306);    conn.setTable("GEO");    conn.setUsername("root");    conn.setPassword("hadoop123");}
public void metron_f4749_0() throws Exception
{    Assert.assertEquals(sampleURL, conn.getJdbcUrl());}
public static void metron_f4750_0() throws IOException
{        expectedAsnMessage.put("autonomous_system_organization", "Google LLC");    expectedAsnMessage.put("autonomous_system_number", 15169);    expectedAsnMessage.put("network", "8.8.4.0");    String baseDir = UnitTestHelper.findDir("GeoLite");    asnHdfsFile = new File(new File(baseDir), GEO_ASN_FILE_NAME);    asnHdfsFile_update = new File(new File(baseDir), GEO_ASN_COPY_FILE_NAME);    FileUtils.copyFile(asnHdfsFile, asnHdfsFile_update);}
public static void metron_f4751_0()
{    FileUtils.deleteQuietly(asnHdfsFile_update);}
public void metron_f4752_0() throws Exception
{    testFolder.create();    context = new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> ImmutableMap.of(GeoLiteAsnDatabase.ASN_HDFS_FILE, asnHdfsFile.getAbsolutePath())).build();}
public void metron_f4753_0()
{    GeoLiteAsnDatabase.INSTANCE.update(asnHdfsFile.getAbsolutePath());    Optional<Map<String, Object>> result = GeoLiteAsnDatabase.INSTANCE.get("192.168.0.1");    Assert.assertFalse("Local address result should be empty", result.isPresent());}
public void metron_f4754_0()
{    GeoLiteAsnDatabase.INSTANCE.update(asnHdfsFile.getAbsolutePath());        Optional<Map<String, Object>> result = GeoLiteAsnDatabase.INSTANCE.get("203.0.113.1");    Assert.assertFalse("External address not found", result.isPresent());}
public void metron_f4755_0()
{    GeoLiteAsnDatabase.INSTANCE.update(asnHdfsFile.getAbsolutePath());    Optional<Map<String, Object>> result = GeoLiteAsnDatabase.INSTANCE.get(IP_ADDR);    Assert.assertEquals("Remote Local IP should return result based on DB", expectedAsnMessage, result.get());}
public void metron_f4756_0()
{    GeoLiteAsnDatabase.INSTANCE.update(asnHdfsFile.getAbsolutePath());    GeoLiteAsnDatabase.INSTANCE.update(asnHdfsFile.getAbsolutePath());    Optional<Map<String, Object>> result = GeoLiteAsnDatabase.INSTANCE.get(IP_ADDR);    Assert.assertEquals("Remote Local IP should return result based on DB", expectedAsnMessage, result.get());}
public void metron_f4757_0()
{    HashMap<String, Object> globalConfig = new HashMap<>();    globalConfig.put(GeoLiteAsnDatabase.ASN_HDFS_FILE, asnHdfsFile.getAbsolutePath());    GeoLiteAsnDatabase.INSTANCE.updateIfNecessary(globalConfig);    Optional<Map<String, Object>> result = GeoLiteAsnDatabase.INSTANCE.get(IP_ADDR);    Assert.assertEquals("Remote Local IP should return result based on DB", expectedAsnMessage, result.get());}
public void metron_f4758_0()
{    HashMap<String, Object> globalConfig = new HashMap<>();    globalConfig.put(GeoLiteAsnDatabase.ASN_HDFS_FILE, asnHdfsFile.getAbsolutePath());    GeoLiteAsnDatabase.INSTANCE.updateIfNecessary(globalConfig);    GeoLiteAsnDatabase.INSTANCE.updateIfNecessary(globalConfig);    Optional<Map<String, Object>> result = GeoLiteAsnDatabase.INSTANCE.get(IP_ADDR);    Assert.assertEquals("Remote Local IP should return result based on DB", expectedAsnMessage, result.get());}
public void metron_f4759_0()
{    HashMap<String, Object> globalConfig = new HashMap<>();    globalConfig.put(GeoLiteAsnDatabase.ASN_HDFS_FILE, asnHdfsFile.getAbsolutePath());    GeoLiteAsnDatabase.INSTANCE.updateIfNecessary(globalConfig);    Optional<Map<String, Object>> result = GeoLiteAsnDatabase.INSTANCE.get(IP_ADDR);    Assert.assertEquals("Remote Local IP should return result based on DB", expectedAsnMessage, result.get());    globalConfig.put(GeoLiteAsnDatabase.ASN_HDFS_FILE, asnHdfsFile_update.getAbsolutePath());    GeoLiteAsnDatabase.INSTANCE.updateIfNecessary(globalConfig);    result = GeoLiteAsnDatabase.INSTANCE.get(IP_ADDR);    Assert.assertEquals("Remote Local IP should return result based on DB", expectedAsnMessage, result.get());}
public static void metron_f4760_0() throws ParseException
{    JSONParser jsonParser = new JSONParser();    expectedMessage = (JSONObject) jsonParser.parse(expectedMessageString);    String baseDir = UnitTestHelper.findDir("GeoLite");    geoHdfsFile = new File(new File(baseDir), "GeoLite2-City.mmdb.gz");    geo = new GeoAdapter();    geo.initializeAdapter(ImmutableMap.of(GeoLiteCityDatabase.GEO_HDFS_FILE, geoHdfsFile.getAbsolutePath()));}
public void metron_f4761_0() throws Exception
{    JSONObject actualMessage = geo.enrich(new CacheKey("dummy", IP, null));    Assert.assertNotNull(actualMessage.get("locID"));    Assert.assertEquals(expectedMessage, actualMessage);}
public void metron_f4762_0() throws Exception
{    JSONObject actualMessage = geo.enrich(new CacheKey("dummy", 10L, null));    Assert.assertEquals(new JSONObject(), actualMessage);}
public static void metron_f4763_0() throws ParseException, IOException
{    JSONParser jsonParser = new JSONParser();    expectedNoDmaMessage = (JSONObject) jsonParser.parse(expectedNoDmaMessageString);    expectedDmaMessage = (JSONObject) jsonParser.parse(expectedDmaMessageString);    expectedMessageTarGz = (JSONObject) jsonParser.parse(expectedMessageStringTarGz);    String baseDir = UnitTestHelper.findDir("GeoLite");    geoHdfsFile = new File(new File(baseDir), GEO_CITY_FILE_NAME);    geoHdfsFile_update = new File(new File(baseDir), GEO_CITY_COPY_FILE_NAME);    FileUtils.copyFile(geoHdfsFile, geoHdfsFile_update);    geoHdfsFileTarGz = new File(new File(baseDir), GEO_CITY + EXTENSION_TAR_GZ);    Configuration config = new Configuration();    fs = FileSystem.get(config);}
public static void metron_f4764_0()
{    FileUtils.deleteQuietly(geoHdfsFile_update);}
public void metron_f4765_0() throws Exception
{    testFolder.create();    context = new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> ImmutableMap.of(GeoLiteCityDatabase.GEO_HDFS_FILE, geoHdfsFile.getAbsolutePath())).build();}
public void metron_f4766_0()
{    GeoLiteCityDatabase.INSTANCE.update(geoHdfsFile.getAbsolutePath());    Optional<Map<String, String>> result = GeoLiteCityDatabase.INSTANCE.get("192.168.0.1");    Assert.assertFalse("Local address result should be empty", result.isPresent());}
public void metron_f4767_0()
{    GeoLiteCityDatabase.INSTANCE.update(geoHdfsFile.getAbsolutePath());        Optional<Map<String, String>> result = GeoLiteCityDatabase.INSTANCE.get("203.0.113.1");    Assert.assertFalse("External address not found", result.isPresent());}
public void metron_f4768_0()
{    GeoLiteCityDatabase.INSTANCE.update(geoHdfsFile.getAbsolutePath());    Optional<Map<String, String>> result = GeoLiteCityDatabase.INSTANCE.get(IP_WITH_DMA);    Assert.assertEquals("Remote Local IP should return result based on DB", expectedDmaMessage, result.get());}
public void metron_f4769_0()
{    GeoLiteCityDatabase.INSTANCE.update(geoHdfsFileTarGz.getAbsolutePath());    Optional<Map<String, String>> result = GeoLiteCityDatabase.INSTANCE.get(IP_WITH_DMA);    Assert.assertEquals("Remote Local IP should return result based on DB", expectedMessageTarGz, result.get());}
public void metron_f4770_0()
{    GeoLiteCityDatabase.INSTANCE.update(geoHdfsFile.getAbsolutePath());    Optional<Map<String, String>> result = GeoLiteCityDatabase.INSTANCE.get(IP_NO_DMA);    Assert.assertEquals("Remote Local IP should return result based on DB", expectedNoDmaMessage, result.get());}
public void metron_f4771_0()
{    GeoLiteCityDatabase.INSTANCE.update(geoHdfsFile.getAbsolutePath());    GeoLiteCityDatabase.INSTANCE.update(geoHdfsFile.getAbsolutePath());    Optional<Map<String, String>> result = GeoLiteCityDatabase.INSTANCE.get(IP_NO_DMA);    Assert.assertEquals("Remote Local IP should return result based on DB", expectedNoDmaMessage, result.get());}
public void metron_f4772_0()
{    HashMap<String, Object> globalConfig = new HashMap<>();    globalConfig.put(GeoLiteCityDatabase.GEO_HDFS_FILE, geoHdfsFile.getAbsolutePath());    GeoLiteCityDatabase.INSTANCE.updateIfNecessary(globalConfig);    Optional<Map<String, String>> result = GeoLiteCityDatabase.INSTANCE.get(IP_NO_DMA);    Assert.assertEquals("Remote Local IP should return result based on DB", expectedNoDmaMessage, result.get());}
public void metron_f4773_0()
{    HashMap<String, Object> globalConfig = new HashMap<>();    globalConfig.put(GeoLiteCityDatabase.GEO_HDFS_FILE, geoHdfsFile.getAbsolutePath());    GeoLiteCityDatabase.INSTANCE.updateIfNecessary(globalConfig);    GeoLiteCityDatabase.INSTANCE.updateIfNecessary(globalConfig);    Optional<Map<String, String>> result = GeoLiteCityDatabase.INSTANCE.get(IP_NO_DMA);    Assert.assertEquals("Remote Local IP should return result based on DB", expectedNoDmaMessage, result.get());}
public void metron_f4774_0()
{    HashMap<String, Object> globalConfig = new HashMap<>();    globalConfig.put(GeoLiteCityDatabase.GEO_HDFS_FILE, geoHdfsFile.getAbsolutePath());    GeoLiteCityDatabase.INSTANCE.updateIfNecessary(globalConfig);    Optional<Map<String, String>> result = GeoLiteCityDatabase.INSTANCE.get(IP_NO_DMA);    Assert.assertEquals("Remote Local IP should return result based on DB", expectedNoDmaMessage, result.get());    globalConfig.put(GeoLiteCityDatabase.GEO_HDFS_FILE, geoHdfsFile_update.getAbsolutePath());    GeoLiteCityDatabase.INSTANCE.updateIfNecessary(globalConfig);    result = GeoLiteCityDatabase.INSTANCE.get(IP_NO_DMA);    Assert.assertEquals("Remote Local IP should return result based on DB", expectedNoDmaMessage, result.get());}
public void metron_f4775_0()
{    String fakeFile = "fakefile.geolitecitydbtest";    Map<String, Object> globalConfig = Collections.singletonMap(GeoLiteCityDatabase.GEO_HDFS_FILE, fakeFile);    Assert.assertEquals(GeoLiteCityDatabase.INSTANCE.determineHdfsDirWithFallback(globalConfig, fakeFile, ""), fakeFile);}
public void metron_f4776_0()
{    String defaultFile = GeoLiteCityDatabase.GEO_HDFS_FILE_DEFAULT;    Map<String, Object> globalConfig = Collections.singletonMap(GeoLiteCityDatabase.GEO_HDFS_FILE, defaultFile);    Assert.assertEquals(GeoLiteCityDatabase.INSTANCE.determineHdfsDirWithFallback(globalConfig, defaultFile, ""), defaultFile);}
public void metron_f4777_0()
{    String defaultFile = GeoLiteCityDatabase.GEO_HDFS_FILE_DEFAULT;    Assert.assertEquals(GeoLiteCityDatabase.INSTANCE.determineHdfsDirWithFallback(Collections.emptyMap(), defaultFile, "fallback"), defaultFile);}
public void metron_f4778_0() throws IOException
{    String fakeFile = "fakefile.geolitecitydbtest";    File file = File.createTempFile(this.getClass().getSimpleName(), "testfile");    file.deleteOnExit();    String fileName = file.getAbsolutePath();    Assert.assertEquals(GeoLiteCityDatabase.INSTANCE.determineHdfsDirWithFallback(Collections.emptyMap(), fakeFile, fileName), fileName);}
public void metron_f4779_0() throws Exception
{    final MockHTable trackerTable = (MockHTable) MockHBaseTableProvider.addToCache(atTableName, cf);    final MockHTable hbaseTable = (MockHTable) MockHBaseTableProvider.addToCache(hbaseTableName, cf);    EnrichmentHelper.INSTANCE.load(hbaseTable, cf, new ArrayList<LookupKV<EnrichmentKey, EnrichmentValue>>() {        {            add(new LookupKV<>(new EnrichmentKey(PLAYFUL_CLASSIFICATION_TYPE, "10.0.2.3"), new EnrichmentValue(PLAYFUL_ENRICHMENT)));        }    });    EnrichmentHelper.INSTANCE.load(hbaseTable, cf1, new ArrayList<LookupKV<EnrichmentKey, EnrichmentValue>>() {        {            add(new LookupKV<>(new EnrichmentKey(CF1_CLASSIFICATION_TYPE, "10.0.2.4"), new EnrichmentValue(CF1_ENRICHMENT)));        }    });    BloomAccessTracker bat = new BloomAccessTracker(hbaseTableName, 100, 0.03);    PersistentAccessTracker pat = new PersistentAccessTracker(hbaseTableName, "0", trackerTable, cf, bat, 0L);    lookup = new EnrichmentLookup(hbaseTable, cf, pat);    JSONParser jsonParser = new JSONParser();    expectedMessage = (JSONObject) jsonParser.parse(expectedMessageString);}
public void metron_f4780_0() throws Exception
{    SimpleHBaseAdapter sha = new SimpleHBaseAdapter();    sha.lookup = lookup;    SensorEnrichmentConfig broSc = JSONUtils.INSTANCE.load(sourceConfigStr, SensorEnrichmentConfig.class);    JSONObject actualMessage = sha.enrich(new CacheKey("test", "test", broSc));    Assert.assertEquals(actualMessage, new JSONObject());    actualMessage = sha.enrich(new CacheKey("ip_dst_addr", "10.0.2.3", broSc));    Assert.assertNotNull(actualMessage);    Assert.assertEquals(expectedMessage, actualMessage);}
public void metron_f4781_0() throws Exception
{    SimpleHBaseAdapter sha = new SimpleHBaseAdapter();    sha.lookup = lookup;    SensorEnrichmentConfig broSc = JSONUtils.INSTANCE.load(sourceConfigStr, SensorEnrichmentConfig.class);    JSONObject actualMessage = sha.enrich(new CacheKey("test", "test", broSc));    Assert.assertEquals(actualMessage, new JSONObject());    actualMessage = sha.enrich(new CacheKey("ip_dst_addr", 10L, broSc));    Assert.assertEquals(actualMessage, new JSONObject());}
public void metron_f4782_0() throws Exception
{    SimpleHBaseAdapter sha = new SimpleHBaseAdapter();    sha.lookup = lookup;    SensorEnrichmentConfig broSc = JSONUtils.INSTANCE.load(sourceConfigWithCFStr, SensorEnrichmentConfig.class);    JSONObject actualMessage = sha.enrich(new CacheKey("test", "test", broSc));    Assert.assertEquals(actualMessage, new JSONObject());    actualMessage = sha.enrich(new CacheKey("ip_dst_addr", "10.0.2.4", broSc));    Assert.assertNotNull(actualMessage);    Assert.assertEquals(new JSONObject(ImmutableMap.of("cf1.key", "value")), actualMessage);}
public void metron_f4783_0() throws Exception
{    SimpleHBaseAdapter sha = new SimpleHBaseAdapter();    sha.lookup = lookup;    SensorEnrichmentConfig broSc = JSONUtils.INSTANCE.load(sourceConfigStr, SensorEnrichmentConfig.class);    JSONObject actualMessage = sha.enrich(new CacheKey("test", "test", broSc));    Assert.assertEquals(actualMessage, new JSONObject());    actualMessage = sha.enrich(new CacheKey("ip_dst_addr", "10.0.2.4", broSc));    Assert.assertNotNull(actualMessage);    Assert.assertEquals(new JSONObject(new HashMap<String, Object>()), actualMessage);}
public void metron_f4784_0()
{    SimpleHBaseConfig config = new SimpleHBaseConfig();    SimpleHBaseAdapter sha = new SimpleHBaseAdapter(config);    sha.initializeAdapter(null);}
public void metron_f4785_0()
{    SimpleHBaseConfig shc = new SimpleHBaseConfig();    shc.withHBaseCF(cf);    shc.withHBaseTable(table);    provider = new HTableProvider();    Assert.assertEquals(cf, shc.getHBaseCF());    Assert.assertEquals(table, shc.getHBaseTable());}
private JSONObject metron_f4786_0(JSONObject message, String field, ConfigHandler handler)
{    VariableResolver resolver = new MapVariableResolver(message);    return StellarAdapter.process(message, handler, field, 1000L, processor, resolver, Context.EMPTY_CONTEXT());}
public void metron_f4787_0() throws Exception
{    for (String c : DEFAULT_CONFIGS) {        JSONObject message = getMessage();        EnrichmentConfig enrichmentConfig = JSONUtils.INSTANCE.load(c, EnrichmentConfig.class);        Assert.assertNotNull(enrichmentConfig.getEnrichmentConfigs().get("stellar"));        ConfigHandler handler = enrichmentConfig.getEnrichmentConfigs().get("stellar");        JSONObject enriched = enrich(message, "", handler);        Assert.assertEquals("STELLAR_TEST", enriched.get("stmt1"));        Assert.assertEquals("stellar_test", enriched.get("stmt2"));        Assert.assertEquals("foo", enriched.get("stmt3"));        Assert.assertEquals(3, enriched.size());    }}
public void metron_f4788_0() throws Exception
{    for (String c : GROUPED_CONFIGS) {        JSONObject message = getMessage();        EnrichmentConfig enrichmentConfig = JSONUtils.INSTANCE.load(c, EnrichmentConfig.class);        Assert.assertNotNull(enrichmentConfig.getEnrichmentConfigs().get("stellar"));        ConfigHandler handler = enrichmentConfig.getEnrichmentConfigs().get("stellar");        {            JSONObject enriched = enrich(message, "group1", handler);            Assert.assertEquals("STELLAR_TEST", enriched.get("stmt1"));            Assert.assertEquals("stellar_test", enriched.get("stmt2"));            Assert.assertEquals(2, enriched.size());        }        {            JSONObject enriched = enrich(message, "group2", handler);            Assert.assertEquals("foo", enriched.get("stmt3"));            Assert.assertEquals(1, enriched.size());        }    }}
public void metron_f4789_0() throws Exception
{    for (String c : MIXED_CONFIGS) {        JSONObject message = getMessage();        EnrichmentConfig enrichmentConfig = JSONUtils.INSTANCE.load(c, EnrichmentConfig.class);        Assert.assertNotNull(enrichmentConfig.getEnrichmentConfigs().get("stellar"));        ConfigHandler handler = enrichmentConfig.getEnrichmentConfigs().get("stellar");        {            JSONObject enriched = enrich(message, "group1", handler);            Assert.assertEquals("STELLAR_TEST", enriched.get("stmt1"));            Assert.assertEquals("stellar_test", enriched.get("stmt2"));            Assert.assertEquals(2, enriched.size());        }        {            JSONObject enriched = enrich(message, "group2", handler);            Assert.assertEquals("foo", enriched.get("stmt3"));            Assert.assertEquals(1, enriched.size());        }        {            JSONObject enriched = enrich(message, "", handler);            Assert.assertEquals(2, enriched.get("stmt4"));            Assert.assertEquals("stellar_test", enriched.get("stmt5"));            Assert.assertEquals(2, enriched.size());        }    }}
public void metron_f4790_0() throws Exception
{    JSONObject message = getMessage();    EnrichmentConfig enrichmentConfig = JSONUtils.INSTANCE.load(tempVarStellarConfig_list, EnrichmentConfig.class);    Assert.assertNotNull(enrichmentConfig.getEnrichmentConfigs().get("stellar"));    ConfigHandler handler = enrichmentConfig.getEnrichmentConfigs().get("stellar");    {        JSONObject enriched = enrich(message, "group1", handler);        Assert.assertEquals("stellar_test", enriched.get("stmt2"));        Assert.assertEquals(1, enriched.size());    }    {        JSONObject enriched = enrich(message, "group2", handler);        Assert.assertEquals("foo", enriched.get("stmt3"));        Assert.assertEquals(1, enriched.size());    }    {        JSONObject enriched = enrich(message, "", handler);        Assert.assertEquals(2, enriched.get("stmt4"));        Assert.assertEquals("stellar_test", enriched.get("stmt5"));        Assert.assertEquals(2, enriched.size());    }}
private void metron_f4791_0(String config, String field) throws Exception
{    JSONObject message = getMessage();    EnrichmentConfig enrichmentConfig = JSONUtils.INSTANCE.load(config, EnrichmentConfig.class);    Assert.assertNotNull(enrichmentConfig.getEnrichmentConfigs().get("stellar"));    ConfigHandler handler = enrichmentConfig.getEnrichmentConfigs().get("stellar");    JSONObject enriched = enrich(message, field, handler);    Assert.assertEquals(2, enriched.size());    Assert.assertEquals("stellar_test", enriched.get("stmt2.foo"));    Assert.assertEquals("stellar_test".toUpperCase(), enriched.get("stmt1"));}
public void metron_f4792_0() throws Exception
{    testMapEnrichment(mapConfig_subgroup, "group1");}
public void metron_f4793_0() throws Exception
{    testMapEnrichment(mapConfig_default, "");}
public void metron_f4794_0() throws Exception
{    JSONObject message = getMessage();    EnrichmentConfig enrichmentConfig = JSONUtils.INSTANCE.load(allVariableConfig, EnrichmentConfig.class);    Assert.assertNotNull(enrichmentConfig.getEnrichmentConfigs().get("stellar"));    ConfigHandler handler = enrichmentConfig.getEnrichmentConfigs().get("stellar");    JSONObject enriched = enrich(message, "", handler);    Assert.assertEquals("stellar_test", enriched.get("stmt1"));}
public Table metron_f4795_0(Configuration config, String tableName) throws IOException
{    throw new IOException();}
public void metron_f4796_0() throws Exception
{    final MockHTable trackerTable = (MockHTable) MockHBaseTableProvider.addToCache(atTableName, cf);    final MockHTable threatIntelTable = (MockHTable) MockHBaseTableProvider.addToCache(threatIntelTableName, cf);    EnrichmentHelper.INSTANCE.load(threatIntelTable, cf, new ArrayList<LookupKV<EnrichmentKey, EnrichmentValue>>() {        {            add(new LookupKV<>(new EnrichmentKey("10.0.2.3", "10.0.2.3"), new EnrichmentValue(new HashMap<>())));        }    });    BloomAccessTracker bat = new BloomAccessTracker(threatIntelTableName, 100, 0.03);    PersistentAccessTracker pat = new PersistentAccessTracker(threatIntelTableName, "0", trackerTable, cf, bat, 0L);    lookup = new EnrichmentLookup(threatIntelTable, cf, pat);    JSONParser jsonParser = new JSONParser();    expectedMessage = (JSONObject) jsonParser.parse(expectedMessageString);}
public void metron_f4797_0() throws Exception
{    ThreatIntelAdapter tia = new ThreatIntelAdapter();    tia.lookup = lookup;    SensorEnrichmentConfig broSc = JSONUtils.INSTANCE.load(sourceConfigStr, SensorEnrichmentConfig.class);    JSONObject actualMessage = tia.enrich(new CacheKey("ip_dst_addr", "10.0.2.3", broSc));    Assert.assertNotNull(actualMessage);    Assert.assertEquals(expectedMessage, actualMessage);}
public void metron_f4798_0() throws Exception
{    ThreatIntelAdapter tia = new ThreatIntelAdapter();    tia.lookup = lookup;    SensorEnrichmentConfig broSc = JSONUtils.INSTANCE.load(sourceConfigStr, SensorEnrichmentConfig.class);    JSONObject actualMessage = tia.enrich(new CacheKey("ip_dst_addr", "10.0.2.3", broSc));    Assert.assertNotNull(actualMessage);    Assert.assertEquals(expectedMessage, actualMessage);    actualMessage = tia.enrich(new CacheKey("ip_dst_addr", 10L, broSc));    Assert.assertEquals(actualMessage, new JSONObject());}
public void metron_f4799_0()
{    String cf = "cf";    String table = "threatintel";    String trackCf = "cf";    String trackTable = "Track";    double falsePositive = 0.03;    int expectedInsertion = 1;    long millionseconds = (long) 0.1;    ThreatIntelConfig config = new ThreatIntelConfig();    config.withHBaseCF(cf);    config.withHBaseTable(table);    config.withExpectedInsertions(expectedInsertion);    config.withFalsePositiveRate(falsePositive);    config.withMillisecondsBetweenPersists(millionseconds);    config.withTrackerHBaseCF(trackCf);    config.withTrackerHBaseTable(trackTable);    config.withProviderImpl(ExceptionProvider.class.getName());    ThreatIntelAdapter tia = new ThreatIntelAdapter(config);    UnitTestHelper.setLog4jLevel(ThreatIntelAdapter.class, Level.FATAL);    tia.initializeAdapter(null);    UnitTestHelper.setLog4jLevel(ThreatIntelAdapter.class, Level.ERROR);    Assert.assertFalse(tia.isInitialized());}
public void metron_f4800_0()
{    ThreatIntelConfig tic = new ThreatIntelConfig();    tic.withHBaseCF(cf);    tic.withHBaseTable(table);    tic.withExpectedInsertions(expectedInsertion);    tic.withFalsePositiveRate(falsePositive);    tic.withMillisecondsBetweenPersists(millionseconds);    tic.withTrackerHBaseCF(trackCf);    tic.withTrackerHBaseTable(trackTable);    Assert.assertEquals(cf, tic.getHBaseCF());    Assert.assertEquals(table, tic.getHBaseTable());    Assert.assertEquals(trackCf, tic.getTrackerHBaseCF());    Assert.assertEquals(trackTable, tic.getTrackerHBaseTable());    Assert.assertEquals(expectedInsertion, tic.getExpectedInsertions());    Assert.assertEquals(millionseconds, tic.getMillisecondsBetweenPersists());}
public void metron_f4801_0() throws IOException
{    fs = FileSystem.get(new Configuration());    data = new ArrayList<>();    {        data.add("apache");        data.add("metron");        data.add("is");        data.add("great");    }    cache = new ObjectCache();    tempDir = TestUtils.createTempDir(this.getClass().getName());}
public void metron_f4802_0() throws Exception
{    String filename = "test.ser";    Assert.assertTrue(cache.isEmpty() || !cache.containsKey(filename));    assertDataIsReadCorrectly(filename);}
public void metron_f4803_0(String filename) throws IOException
{    File file = new File(tempDir, filename);    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {        IOUtils.write(SerDeUtils.toBytes(data), bos);    }    cache.initialize(new ObjectCacheConfig(new HashMap<>()));    List<String> readData = (List<String>) cache.get(file.getAbsolutePath());    Assert.assertEquals(readData, data);    Assert.assertTrue(cache.containsKey(file.getAbsolutePath()));}
public void metron_f4804_0() throws Exception
{    String filename = "testmulti.ser";    Assert.assertTrue(cache.isEmpty() || !cache.containsKey(filename));    Thread[] ts = new Thread[10];    for (int i = 0; i < ts.length; ++i) {        ts[i] = new Thread(() -> {            try {                assertDataIsReadCorrectly(filename);            } catch (Exception e) {                throw new IllegalStateException(e.getMessage(), e);            }        });        ts[i].start();    }    for (Thread t : ts) {        t.join();    }}
public void metron_f4805_0() throws Exception
{    String filename = "maxSizeException.ser";    File file = new File(tempDir, filename);    thrown.expect(IllegalArgumentException.class);    thrown.expectMessage(String.format("File at path '%s' is larger than the configured max file size of 1", file.getAbsolutePath()));    try (BufferedOutputStream bos = new BufferedOutputStream(fs.create(new Path(file.getAbsolutePath()), true))) {        IOUtils.write(SerDeUtils.toBytes(data), bos);    }    ObjectCacheConfig objectCacheConfig = new ObjectCacheConfig(new HashMap<>());    objectCacheConfig.setMaxFileSize(1);    cache.initialize(objectCacheConfig);    cache.get(file.getAbsolutePath());}
public void metron_f4806_0()
{    EnrichmentKey k1 = new EnrichmentKey("type", "indicator1");    byte[] serialized = k1.toBytes();    EnrichmentKey k2 = new EnrichmentKey();    k2.fromBytes(serialized);    Assert.assertEquals(k1, k2);}
public void metron_f4807_0() throws IOException
{    EnrichmentConverter converter = new EnrichmentConverter();    EnrichmentKey k1 = new EnrichmentKey("type", "indicator");    EnrichmentValue v1 = new EnrichmentValue(new HashMap<String, Object>() {        {            put("k1", "v1");            put("k2", "v2");        }    });    Put serialized = converter.toPut("cf", k1, v1);    LookupKV<EnrichmentKey, EnrichmentValue> kv = converter.fromPut(serialized, "cf");    Assert.assertEquals(k1, kv.getKey());    Assert.assertEquals(v1, kv.getValue());}
public JSONObject metron_f4809_0(CacheKey value)
{    return null;}
public boolean metron_f4810_0(Map<String, Object> config)
{    return false;}
public String metron_f4813_0(CacheKey value)
{    return null;}
public void metron_f4814_0(CacheKey value)
{    numAccesses.incrementAndGet();}
public static void metron_f4815_0()
{    ConcurrencyContext infrastructure = new ConcurrencyContext();    infrastructure.initialize(5, 100, 10, null, null, false);    stellarContext = new Context.Builder().build();    StellarFunctions.initialize(stellarContext);    StellarAdapter adapter = new AccessLoggingStellarAdapter().ofType("ENRICHMENT");    adapter.initializeAdapter(new HashMap<>());    EnrichmentAdapter<CacheKey> dummy = new DummyEnrichmentAdapter();    enrichmentsByType = ImmutableMap.of("stellar", adapter, "dummy", dummy);    enricher = new ParallelEnricher(enrichmentsByType, infrastructure, false);}
public void metron_f4816_0() throws Exception
{    numAccesses.set(0);    JSONObject message = new JSONObject() {        {            put(Constants.SENSOR_TYPE, "test");        }    };    for (int i = 0; i < 10; ++i) {        SensorEnrichmentConfig config = JSONUtils.INSTANCE.load(goodConfig, SensorEnrichmentConfig.class);        config.getConfiguration().putIfAbsent("stellarContext", stellarContext);        ParallelEnricher.EnrichmentResult result = enricher.apply(message, EnrichmentStrategies.ENRICHMENT, config, null);    }        Assert.assertTrue(2 >= numAccesses.get());}
public void metron_f4817_0() throws Exception
{    SensorEnrichmentConfig config = JSONUtils.INSTANCE.load(goodConfig, SensorEnrichmentConfig.class);    config.getConfiguration().putIfAbsent("stellarContext", stellarContext);    JSONObject message = new JSONObject() {        {            put(Constants.SENSOR_TYPE, "test");        }    };    ParallelEnricher.EnrichmentResult result = enricher.apply(message, EnrichmentStrategies.ENRICHMENT, config, null);    JSONObject ret = result.getResult();    Assert.assertEquals("Got the wrong result count: " + ret, 11, ret.size());    Assert.assertEquals(1, ret.get("map.blah"));    Assert.assertEquals("test", ret.get("source.type"));    Assert.assertEquals(1, ret.get("one"));    Assert.assertEquals(2, ret.get("foo"));    Assert.assertEquals("TEST", ret.get("ALL_CAPS"));    Assert.assertEquals(0, result.getEnrichmentErrors().size());    Assert.assertTrue(result.getResult().containsKey("adapter.accessloggingstellaradapter.begin.ts"));    Assert.assertTrue(result.getResult().containsKey("adapter.accessloggingstellaradapter.end.ts"));    Assert.assertTrue(result.getResult().containsKey("parallelenricher.splitter.begin.ts"));    Assert.assertTrue(result.getResult().containsKey("parallelenricher.splitter.end.ts"));    Assert.assertTrue(result.getResult().containsKey("parallelenricher.enrich.begin.ts"));    Assert.assertTrue(result.getResult().containsKey("parallelenricher.enrich.end.ts"));}
public void metron_f4818_0() throws Exception
{    SensorEnrichmentConfig config = JSONUtils.INSTANCE.load(nullConfig, SensorEnrichmentConfig.class);    config.getConfiguration().putIfAbsent("stellarContext", stellarContext);    JSONObject message = new JSONObject() {        {            put(Constants.SENSOR_TYPE, "test");        }    };    ParallelEnricher.EnrichmentResult result = enricher.apply(message, EnrichmentStrategies.ENRICHMENT, config, null);    JSONObject ret = result.getResult();    Assert.assertEquals("Got the wrong result count: " + ret, 7, ret.size());    Assert.assertTrue(result.getResult().containsKey("adapter.dummyenrichmentadapter.begin.ts"));    Assert.assertTrue(result.getResult().containsKey("adapter.dummyenrichmentadapter.end.ts"));    Assert.assertTrue(result.getResult().containsKey("parallelenricher.splitter.begin.ts"));    Assert.assertTrue(result.getResult().containsKey("parallelenricher.splitter.end.ts"));    Assert.assertTrue(result.getResult().containsKey("parallelenricher.enrich.begin.ts"));    Assert.assertTrue(result.getResult().containsKey("parallelenricher.enrich.end.ts"));}
public void metron_f4819_0() throws Exception
{    SensorEnrichmentConfig config = JSONUtils.INSTANCE.load(badConfig, SensorEnrichmentConfig.class);    config.getConfiguration().putIfAbsent("stellarContext", stellarContext);    JSONObject message = new JSONObject() {        {            put(Constants.SENSOR_TYPE, "test");        }    };    ParallelEnricher.EnrichmentResult result = enricher.apply(message, EnrichmentStrategies.ENRICHMENT, config, null);    JSONObject ret = result.getResult();    Assert.assertEquals(ret + " is not what I expected", 11, ret.size());    Assert.assertEquals(1, ret.get("map.blah"));    Assert.assertEquals("test", ret.get("source.type"));    Assert.assertEquals(1, ret.get("one"));    Assert.assertEquals(2, ret.get("foo"));    Assert.assertEquals("TEST", ret.get("ALL_CAPS"));    Assert.assertEquals(1, result.getEnrichmentErrors().size());    Assert.assertTrue(result.getResult().containsKey("adapter.accessloggingstellaradapter.begin.ts"));    Assert.assertTrue(result.getResult().containsKey("adapter.accessloggingstellaradapter.end.ts"));    Assert.assertTrue(result.getResult().containsKey("parallelenricher.splitter.begin.ts"));    Assert.assertTrue(result.getResult().containsKey("parallelenricher.splitter.end.ts"));    Assert.assertTrue(result.getResult().containsKey("parallelenricher.enrich.begin.ts"));    Assert.assertTrue(result.getResult().containsKey("parallelenricher.enrich.end.ts"));}
public void metron_f4820_0() throws Exception
{    SensorEnrichmentConfig config = JSONUtils.INSTANCE.load(badConfigWrongEnrichmentType, SensorEnrichmentConfig.class);    config.getConfiguration().putIfAbsent("stellarContext", stellarContext);    JSONObject message = new JSONObject() {        {            put(Constants.SENSOR_TYPE, "test");        }    };    try {        enricher.apply(message, EnrichmentStrategies.ENRICHMENT, config, null);        Assert.fail("This is an invalid config, we should have failed.");    } catch (IllegalStateException ise) {        Assert.assertEquals(ise.getMessage(), "Unable to find an adapter for hbaseThreatIntel, possible adapters are: " + Joiner.on(",").join(enrichmentsByType.keySet()));    }}
public static void metron_f4821_0()
{        expectedMessage.put("autonomous_system_organization", "Google LLC");    expectedMessage.put("autonomous_system_number", 15169);    expectedMessage.put("network", "8.8.4.0");    expectedSubsetMessage.put("autonomous_system_organization", "Google LLC");    expectedSubsetMessage.put("autonomous_system_number", 15169);    String baseDir = UnitTestHelper.findDir("GeoLite");    asnHdfsFile = new File(new File(baseDir), "GeoLite2-ASN.tar.gz");}
public void metron_f4822_0() throws Exception
{    context = new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> ImmutableMap.of(GeoLiteAsnDatabase.ASN_HDFS_FILE, asnHdfsFile.getAbsolutePath())).build();}
public Object metron_f4823_0(String rule, Map<String, Object> variables)
{    StellarProcessor processor = new StellarProcessor();    Assert.assertTrue(rule + " not valid.", processor.validate(rule, context));    return processor.parse(rule, new DefaultVariableResolver(variables::get, variables::containsKey), StellarFunctions.FUNCTION_RESOLVER(), context);}
public void metron_f4824_0()
{    context = new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> ImmutableMap.of(GeoLiteAsnDatabase.ASN_HDFS_FILE, "./fakefile.mmdb")).build();    String stellar = "ASN_GET()";    try {        run(stellar, ImmutableMap.of());    } catch (Exception expected) {        Assert.assertTrue(expected.getMessage().contains("File fakefile.mmdb does not exist"));    }}
public void metron_f4825_0()
{    String stellar = "ASN_GET()";    Object result = run(stellar, ImmutableMap.of());    Assert.assertNull("Null IP should return null", result);    try {        GeoLiteAsnDatabase.INSTANCE.updateIfNecessary(Collections.singletonMap(GeoLiteAsnDatabase.ASN_HDFS_FILE, "./fakefile.mmdb"));    } catch (IllegalStateException e) {        }        result = run(stellar, ImmutableMap.of());    Assert.assertNull("Null IP should return null", result);}
public void metron_f4826_0()
{    String stellar = "ASN_GET()";    Object result = run(stellar, ImmutableMap.of());    Assert.assertNull("Empty IP should return null", result);}
public void metron_f4827_0()
{    String stellar = "ASN_GET(null)";    Object result = run(stellar, ImmutableMap.of());    Assert.assertNull("Null IP should return null", result);}
public void metron_f4828_0()
{    String stellar = "ASN_GET(undefined)";    run(stellar, ImmutableMap.of());}
public void metron_f4829_0()
{    String stellar = "ASN_GET('  ')";    Object result = run(stellar, ImmutableMap.of());    Assert.assertNull("Empty IP should return null", result);}
public void metron_f4830_0()
{    String stellar = "ASN_GET('192.168.0.1')";    Object result = run(stellar, ImmutableMap.of());    Assert.assertEquals("Local IP should return empty map", new HashMap<String, String>(), result);}
public void metron_f4831_0() throws Exception
{    String stellar = "ASN_GET('8.8.4.0')";    Object result = run(stellar, ImmutableMap.of());    Assert.assertEquals("Remote IP should return result based on DB", expectedMessage, result);}
public void metron_f4832_0() throws Exception
{    String stellar = "ASN_GET('8.8.4.0', ['autonomous_system_organization'])";    Object result = run(stellar, ImmutableMap.of());    Assert.assertEquals("Remote IP should return country result based on DB", "Google LLC", result);}
public void metron_f4833_0() throws Exception
{    String stellar = "ASN_GET('8.8.4.0', ['autonomous_system_number'])";    Object result = run(stellar, ImmutableMap.of());    Assert.assertEquals("Remote IP should return country result based on DB", 15169, result);}
public void metron_f4834_0() throws Exception
{    String stellar = "ASN_GET('8.8.4.0', ['autonomous_system_organization', 'autonomous_system_number'])";    Object result = run(stellar, ImmutableMap.of());    Assert.assertEquals("Remote IP should return country result based on DB", expectedSubsetMessage, result);}
public void metron_f4835_0() throws Exception
{    String stellar = "ASN_GET('8.8.4.0', ['autonomous_system_organization', 'autonomous_system_number', 'network'], 'garbage')";    run(stellar, ImmutableMap.of());}
public static void metron_f4836_0(String... argv)
{    List<StellarFunctionInfo> functions = Lists.newArrayList(SingletonFunctionResolver.getInstance().getFunctionInfo());    Collections.sort(functions, (o1, o2) -> o1.getName().compareTo(o2.getName()));    for (StellarFunctionInfo info : functions) {        System.out.println("### `" + info.getName() + "`");        System.out.println("  * Description: " + info.getDescription());        System.out.println("  * Input:");        for (String param : info.getParams()) {            System.out.println("    * " + param);        }        System.out.println("  * Returns: " + info.getReturns());        System.out.println("");    }}
public void metron_f4837_0() throws Exception
{    File tempDir = TestUtils.createTempDir(this.getClass().getName());    file = new File(tempDir, "enrichment.ser");    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {        IOUtils.write(SerDeUtils.toBytes(new HashMap<String, Object>() {            {                put("key", "value");            }        }), bos);    }}
public void metron_f4838_0()
{    String expression = String.format("ENRICHMENT_OBJECT_GET('%s', '%s')", file.getAbsolutePath(), "key");    String value = (String) StellarProcessorUtils.run(expression, new HashMap<>());    assertEquals("value", value);}
public void metron_f4839_0()
{    thrown.expect(ParseException.class);    thrown.expectMessage("Unable to parse ENRICHMENT_OBJECT_GET('/some/path', 'key'): Unable to parse: ENRICHMENT_OBJECT_GET('/some/path', 'key') due to: Path '/some/path' could not be found in HDFS");    String expression = String.format("ENRICHMENT_OBJECT_GET('%s', '%s')", "/some/path", "key");    StellarProcessorUtils.run(expression, new HashMap<>());}
public void metron_f4840_0() throws Exception
{    enrichmentObjectGet = new EnrichmentObjectGet();    objectCache = mock(ObjectCache.class);    context = new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, HashMap::new).build();    whenNew(ObjectCache.class).withNoArguments().thenReturn(objectCache);}
public void metron_f4841_0() throws Exception
{    when(objectCache.isInitialized()).thenReturn(true);    enrichmentObjectGet.initialize(context);    ObjectCacheConfig expectedConfig = new ObjectCacheConfig(new HashMap<>());    verify(objectCache, times(1)).initialize(expectedConfig);    assertTrue(enrichmentObjectGet.isInitialized());}
public void metron_f4842_0() throws Exception
{    Map<String, Object> globalConfig = new HashMap<String, Object>() {        {            put(ENRICHMENT_OBJECT_GET_SETTINGS, new HashMap<String, Object>() {                {                    put(OBJECT_CACHE_SIZE_KEY, 1);                    put(OBJECT_CACHE_EXPIRATION_KEY, 2);                    put(OBJECT_CACHE_TIME_UNIT_KEY, "SECONDS");                    put(OBJECT_CACHE_MAX_FILE_SIZE_KEY, 3);                }            });        }    };    when(objectCache.isInitialized()).thenReturn(true);    context = new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> globalConfig).build();    assertFalse(enrichmentObjectGet.isInitialized());    enrichmentObjectGet.initialize(context);    ObjectCacheConfig expectedConfig = new ObjectCacheConfig(new HashMap<>());    expectedConfig.setCacheSize(1);    expectedConfig.setCacheExpiration(2);    expectedConfig.setTimeUnit(TimeUnit.SECONDS);    expectedConfig.setMaxFileSize(3);    verify(objectCache, times(1)).initialize(expectedConfig);    assertTrue(enrichmentObjectGet.isInitialized());}
public void metron_f4843_0()
{    Map<String, Object> enrichment = new HashMap<String, Object>() {        {            put("key", "value");        }    };    when(objectCache.get("/path")).thenReturn(enrichment);    assertNull(enrichmentObjectGet.apply(Arrays.asList("/path", "key"), context));    when(objectCache.isInitialized()).thenReturn(true);    enrichmentObjectGet.initialize(context);    assertNull(enrichmentObjectGet.apply(Arrays.asList(null, null), context));    assertEquals("value", enrichmentObjectGet.apply(Arrays.asList("/path", "key"), context));}
public void metron_f4844_0()
{    thrown.expect(ClassCastException.class);    thrown.expectMessage("The object stored in HDFS at '/path' must be serialized in JSON format.");    when(objectCache.get("/path")).thenReturn("incorrect format");    when(objectCache.isInitialized()).thenReturn(true);    enrichmentObjectGet.initialize(context);    enrichmentObjectGet.apply(Arrays.asList("/path", "key"), context);}
public void metron_f4845_0()
{    thrown.expect(IllegalArgumentException.class);    thrown.expectMessage("All parameters are mandatory, submit 'hdfs path', 'indicator'");    enrichmentObjectGet.apply(new ArrayList<>(), context);}
public static void metron_f4846_0() throws ParseException
{    JSONParser jsonParser = new JSONParser();    expectedMessage = (JSONObject) jsonParser.parse(expectedMessageString);    expectedSubsetMessage = (JSONObject) jsonParser.parse(expectedSubsetString);    String baseDir = UnitTestHelper.findDir("GeoLite");    geoHdfsFile = new File(new File(baseDir), "GeoLite2-City.mmdb.gz");}
public void metron_f4847_0() throws Exception
{    context = new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> ImmutableMap.of(GeoLiteCityDatabase.GEO_HDFS_FILE, geoHdfsFile.getAbsolutePath())).build();}
public Object metron_f4848_0(String rule, Map<String, Object> variables)
{    StellarProcessor processor = new StellarProcessor();    Assert.assertTrue(rule + " not valid.", processor.validate(rule, context));    return processor.parse(rule, new DefaultVariableResolver(x -> variables.get(x), x -> variables.containsKey(x)), StellarFunctions.FUNCTION_RESOLVER(), context);}
public void metron_f4849_0()
{    context = new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> ImmutableMap.of(GeoLiteCityDatabase.GEO_HDFS_FILE, "./fakefile.mmdb")).build();    String stellar = "GEO_GET()";    try {        run(stellar, ImmutableMap.of());    } catch (Exception expected) {        Assert.assertTrue(expected.getMessage().contains("File fakefile.mmdb does not exist"));    }}
public void metron_f4850_0()
{    String stellar = "GEO_GET()";    Object result = run(stellar, ImmutableMap.of());    Assert.assertNull("Null IP should return null", result);    try {        GeoLiteCityDatabase.INSTANCE.updateIfNecessary(Collections.singletonMap(GeoLiteCityDatabase.GEO_HDFS_FILE, "./fakefile.mmdb"));    } catch (IllegalStateException e) {        }        result = run(stellar, ImmutableMap.of());    Assert.assertNull("Null IP should return null", result);}
public void metron_f4851_0()
{    String stellar = "GEO_GET()";    Object result = run(stellar, ImmutableMap.of());    Assert.assertNull("Empty IP should return null", result);}
public void metron_f4852_0()
{    String stellar = "GEO_GET(null)";    Object result = run(stellar, ImmutableMap.of());    Assert.assertNull("Null IP should return null", result);}
public void metron_f4853_0()
{    String stellar = "GEO_GET(undefined)";    Object result = run(stellar, ImmutableMap.of());    Assert.assertNull("Null IP should return null", result);}
public void metron_f4854_0()
{    String stellar = "GEO_GET('  ')";    Object result = run(stellar, ImmutableMap.of());    Assert.assertNull("Empty IP should return null", result);}
public void metron_f4855_0()
{    String stellar = "GEO_GET('192.168.0.1')";    Object result = run(stellar, ImmutableMap.of());    Assert.assertEquals("Local IP should return empty map", new HashMap<String, String>(), result);}
public void metron_f4856_0()
{    String stellar = "GEO_GET('216.160.83.56')";    Object result = run(stellar, ImmutableMap.of());    Assert.assertEquals("Remote IP should return result based on DB", expectedMessage, result);}
public void metron_f4857_0()
{    String stellar = "GEO_GET('216.160.83.56', ['country'])";    Object result = run(stellar, ImmutableMap.of());    Assert.assertEquals("Remote IP should return country result based on DB", "US", result);}
public void metron_f4858_0()
{    String stellar = "GEO_GET('216.160.83.56', ['country', 'city', 'dmaCode', 'location_point'])";    Object result = run(stellar, ImmutableMap.of());    Assert.assertEquals("Remote IP should return country result based on DB", expectedSubsetMessage, result);}
public void metron_f4859_0()
{    String stellar = "GEO_GET('216.160.83.56', ['country', 'city', 'dmaCode', 'location_point'], 'garbage')";    run(stellar, ImmutableMap.of());}
public void metron_f4860_0() throws Exception
{    Map<String, Object> latLong = (Map<String, Object>) StellarProcessorUtils.run("GEOHASH_TO_LATLONG(hash)", ImmutableMap.of("hash", explicitJutlandHash));    Assert.assertEquals(jutlandPoint.getLatitude(), (double) latLong.get("latitude"), 1e-3);    Assert.assertEquals(jutlandPoint.getLongitude(), (double) latLong.get("longitude"), 1e-3);}
public void metron_f4861_0() throws Exception
{    {        Map<String, Object> latLong = (Map<String, Object>) StellarProcessorUtils.run("GEOHASH_TO_LATLONG(hash)", ImmutableMap.of("hash", "u"));        Assert.assertFalse(Double.isNaN((double) latLong.get("latitude")));        Assert.assertFalse(Double.isNaN((double) latLong.get("longitude")));    }    {        Map<String, Object> latLong = (Map<String, Object>) StellarProcessorUtils.run("GEOHASH_TO_LATLONG(hash)", ImmutableMap.of("hash", ""));        Assert.assertEquals(0d, (double) latLong.get("latitude"), 1e-3);        Assert.assertEquals(0d, (double) latLong.get("longitude"), 1e-3);    }    {        Map<String, Object> latLong = (Map<String, Object>) StellarProcessorUtils.run("GEOHASH_TO_LATLONG(null)", new HashMap<>());        Assert.assertNull(latLong);    }}
public void metron_f4862_0() throws Exception
{    Assert.assertEquals("u4pruydqmv", StellarProcessorUtils.run("GEOHASH_FROM_LATLONG(lat, long, 10)", ImmutableMap.of("lat", jutlandPoint.getLatitude(), "long", jutlandPoint.getLongitude())));    Assert.assertEquals("u4pruydqmvpb", StellarProcessorUtils.run("GEOHASH_FROM_LATLONG(lat, long)", ImmutableMap.of("lat", jutlandPoint.getLatitude(), "long", jutlandPoint.getLongitude())));    Assert.assertEquals("u4pruydqmv".substring(0, 6), StellarProcessorUtils.run("GEOHASH_FROM_LATLONG(lat, long, 6)", ImmutableMap.of("lat", jutlandPoint.getLatitude(), "long", jutlandPoint.getLongitude())));    Assert.assertNull(StellarProcessorUtils.run("GEOHASH_FROM_LATLONG(lat)", ImmutableMap.of("lat", jutlandPoint.getLatitude())));    Assert.assertNull(StellarProcessorUtils.run("GEOHASH_FROM_LATLONG(lat, long, 10)", ImmutableMap.of("lat", "blah", "long", jutlandPoint.getLongitude())));}
public void metron_f4863_0() throws Exception
{    Map<String, String> loc = ImmutableMap.of("latitude", "" + jutlandPoint.getLatitude(), "longitude", "" + jutlandPoint.getLongitude());    Assert.assertEquals("u4pruydqmv", StellarProcessorUtils.run("GEOHASH_FROM_LOC(loc, 10)", ImmutableMap.of("loc", loc)));    Assert.assertEquals("u4pruydqmv".substring(0, 6), StellarProcessorUtils.run("GEOHASH_FROM_LOC(loc, 6)", ImmutableMap.of("loc", loc)));    Assert.assertEquals("u4pruydqmvpb", StellarProcessorUtils.run("GEOHASH_FROM_LOC(loc)", ImmutableMap.of("loc", loc)));    Assert.assertNull(StellarProcessorUtils.run("GEOHASH_FROM_LOC(loc)", ImmutableMap.of("loc", ImmutableMap.of("latitude", "57.64911"))));    Assert.assertNull(StellarProcessorUtils.run("GEOHASH_FROM_LOC(loc, 10)", ImmutableMap.of("loc", ImmutableMap.of("latitude", "blah", "longitude", "10.40740"))));}
public void metron_f4864_0() throws Exception
{    testDistance(Optional.empty());    testDistance(Optional.of("HAVERSINE"));}
public void metron_f4865_0() throws Exception
{    testDistance(Optional.of("LAW_OF_COSINES"));}
public void metron_f4866_0() throws Exception
{    testDistance(Optional.of("VICENTY"));}
public void metron_f4867_0() throws Exception
{    Double maxDistance = (double) StellarProcessorUtils.run("GEOHASH_MAX_DIST([empireState, mosconeCenter, jutland])", ImmutableMap.of("empireState", empireStateHash, "mosconeCenter", mosconeCenterHash, "jutland", jutlandHash));    double expectedDistance = 8528;    Assert.assertEquals(expectedDistance, maxDistance, 1d);}
public void metron_f4868_0() throws Exception
{    Double maxDistance = (double) StellarProcessorUtils.run("GEOHASH_MAX_DIST([jutland, mosconeCenter, empireState])", ImmutableMap.of("empireState", empireStateHash, "mosconeCenter", mosconeCenterHash, "jutland", jutlandHash));    double expectedDistance = 8528;    Assert.assertEquals(expectedDistance, maxDistance, 1d);}
public void metron_f4869_0() throws Exception
{    Double maxDistance = (double) StellarProcessorUtils.run("GEOHASH_MAX_DIST([jutland, mosconeCenter, empireState, null])", ImmutableMap.of("empireState", empireStateHash, "mosconeCenter", mosconeCenterHash, "jutland", jutlandHash));    double expectedDistance = 8528;    Assert.assertEquals(expectedDistance, maxDistance, 1d);}
public void metron_f4870_0() throws Exception
{    Double maxDistance = (double) StellarProcessorUtils.run("GEOHASH_MAX_DIST([jutland, jutland, jutland])", ImmutableMap.of("jutland", jutlandHash));    Assert.assertEquals(0, maxDistance, 1e-6d);}
public void metron_f4871_0() throws Exception
{    Double maxDistance = (double) StellarProcessorUtils.run("GEOHASH_MAX_DIST([])", new HashMap<>());    Assert.assertTrue(Double.isNaN(maxDistance));}
public void metron_f4872_0() throws Exception
{    Double maxDistance = (Double) StellarProcessorUtils.run("GEOHASH_MAX_DIST(null)", new HashMap<>());    Assert.assertNull(maxDistance);}
public void metron_f4873_0() throws Exception
{    Double maxDistance = (Double) StellarProcessorUtils.run("GEOHASH_MAX_DIST()", new HashMap<>());    Assert.assertNull(maxDistance);}
public void metron_f4874_0(Optional<String> method) throws Exception
{        double expectedDistance = 4128;    Map<String, Object> vars = ImmutableMap.of("empireState", empireStateHash, "mosconeCenter", mosconeCenterHash);        {        String stellarStatement = getDistStellarStatement(ImmutableList.of("mosconeCenter", "empireState"), method);        Assert.assertEquals(expectedDistance, (double) StellarProcessorUtils.run(stellarStatement, vars), 1D);    }    {        String stellarStatement = getDistStellarStatement(ImmutableList.of("empireState", "mosconeCenter"), method);        Assert.assertEquals(expectedDistance, (double) StellarProcessorUtils.run(stellarStatement, vars), 1D);    }}
private static String metron_f4875_0(List<String> hashVariables, Optional<String> method)
{    if (method.isPresent()) {        List<String> vars = new ArrayList<>();        vars.addAll(hashVariables);        vars.add("\'" + method.get() + "\'");        return "GEOHASH_DIST(" + Joiner.on(",").skipNulls().join(vars) + ")";    } else {        return "GEOHASH_DIST(" + Joiner.on(",").skipNulls().join(hashVariables) + ")";    }}
public void metron_f4876_0() throws Exception
{        {        double         expectedLong = -98.740087, expectedLat = 41.86921;        Map<String, Double> centroid = (Map) StellarProcessorUtils.run("GEOHASH_TO_LATLONG(GEOHASH_CENTROID([empireState, mosconeCenter]))", ImmutableMap.of("empireState", empireStateHash, "mosconeCenter", mosconeCenterHash));        Assert.assertEquals(expectedLong, centroid.get("longitude"), 1e-3);        Assert.assertEquals(expectedLat, centroid.get("latitude"), 1e-3);    }        {        double expectedLong = empireStatePoint.getLongitude(), expectedLat = empireStatePoint.getLatitude();        Map<String, Double> centroid = (Map) StellarProcessorUtils.run("GEOHASH_TO_LATLONG(GEOHASH_CENTROID([empireState, empireState]))", ImmutableMap.of("empireState", empireStateHash));        Assert.assertEquals(expectedLong, centroid.get("longitude"), 1e-3);        Assert.assertEquals(expectedLat, centroid.get("latitude"), 1e-3);    }        {        double expectedLong = empireStatePoint.getLongitude(), expectedLat = empireStatePoint.getLatitude();        Map<String, Double> centroid = (Map) StellarProcessorUtils.run("GEOHASH_TO_LATLONG(GEOHASH_CENTROID([empireState]))", ImmutableMap.of("empireState", empireStateHash));        Assert.assertEquals(expectedLong, centroid.get("longitude"), 1e-3);        Assert.assertEquals(expectedLat, centroid.get("latitude"), 1e-3);    }        {        Map<String, Double> centroid = (Map) StellarProcessorUtils.run("GEOHASH_TO_LATLONG(GEOHASH_CENTROID([]))", new HashMap<>());        Assert.assertNull(centroid);    }}
public void metron_f4877_0() throws Exception
{        {        double         expectedLong = -98.740087, expectedLat = 41.86921;        for (int weight = 1; weight < 10; ++weight) {            Map<Object, Integer> weightedPoints = ImmutableMap.of(empireStateHash, weight, mosconeCenterHash, weight);            Map<String, Double> centroid = (Map) StellarProcessorUtils.run("GEOHASH_TO_LATLONG(GEOHASH_CENTROID(weightedPoints))", ImmutableMap.of("weightedPoints", weightedPoints));            Assert.assertEquals(expectedLong, centroid.get("longitude"), 1e-3);            Assert.assertEquals(expectedLat, centroid.get("latitude"), 1e-3);        }    }        {        double expectedLong = empireStatePoint.getLongitude(), expectedLat = empireStatePoint.getLatitude();        for (int weight = 1; weight < 10; ++weight) {            Map<Object, Integer> weightedPoints = ImmutableMap.of(empireStateHash, weight);            Map<String, Double> centroid = (Map) StellarProcessorUtils.run("GEOHASH_TO_LATLONG(GEOHASH_CENTROID(weightedPoints))", ImmutableMap.of("weightedPoints", weightedPoints));            Assert.assertEquals(expectedLong, centroid.get("longitude"), 1e-3);            Assert.assertEquals(expectedLat, centroid.get("latitude"), 1e-3);        }    }        {        Map<Object, Integer> weightedPoints = new HashMap<>();        Map<String, Double> centroid = (Map) StellarProcessorUtils.run("GEOHASH_TO_LATLONG(GEOHASH_CENTROID(weightedPoints))", ImmutableMap.of("weightedPoints", weightedPoints));        Assert.assertNull(centroid);    }}
public void metron_f4878_0() throws Exception
{    File tempDir = TestUtils.createTempDir(this.getClass().getName());    file = new File(tempDir, "object.ser");    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {        IOUtils.write(SerDeUtils.toBytes("object get data"), bos);    }}
public void metron_f4879_0()
{    String expression = String.format("OBJECT_GET('%s')", file.getAbsolutePath());    String value = (String) StellarProcessorUtils.run(expression, new HashMap<>());    assertEquals("object get data", value);}
public void metron_f4880_0()
{    thrown.expect(ParseException.class);    thrown.expectMessage("Unable to parse OBJECT_GET('/some/path'): Unable to parse: OBJECT_GET('/some/path') due to: Path '/some/path' could not be found in HDFS");    String expression = String.format("OBJECT_GET('%s')", "/some/path");    StellarProcessorUtils.run(expression, new HashMap<>());}
public void metron_f4881_0() throws Exception
{    objectGet = new ObjectGet();    objectCache = mock(ObjectCache.class);    context = new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, HashMap::new).build();    whenNew(ObjectCache.class).withNoArguments().thenReturn(objectCache);}
public void metron_f4882_0() throws Exception
{    when(objectCache.isInitialized()).thenReturn(true);    assertFalse(objectGet.isInitialized());    objectGet.initialize(context);    ObjectCacheConfig expectedConfig = new ObjectCacheConfig(new HashMap<>());    verify(objectCache, times(1)).initialize(expectedConfig);    assertTrue(objectGet.isInitialized());}
public void metron_f4883_0()
{    Object object = mock(Object.class);    when(objectCache.get("/path")).thenReturn(object);    assertNull(objectGet.apply(Collections.singletonList("/path"), context));    when(objectCache.isInitialized()).thenReturn(true);    objectGet.initialize(context);    assertNull(objectGet.apply(new ArrayList<>(), context));    assertNull(objectGet.apply(Collections.singletonList(null), context));    assertEquals(object, objectGet.apply(Collections.singletonList("/path"), context));}
public void metron_f4884_0()
{    thrown.expect(IllegalStateException.class);    thrown.expectMessage("Unable to retrieve 1 as it is not a path");    when(objectCache.isInitialized()).thenReturn(true);    objectGet.initialize(context);    objectGet.apply(Collections.singletonList(1), context);}
public void metron_f4885_0() throws Exception
{    final MockHTable hbaseTable = (MockHTable) MockHBaseTableProvider.addToCache(hbaseTableName, cf);    EnrichmentHelper.INSTANCE.load(hbaseTable, cf, new ArrayList<LookupKV<EnrichmentKey, EnrichmentValue>>() {        {            for (int i = 0; i < 5; ++i) {                add(new LookupKV<>(new EnrichmentKey(ENRICHMENT_TYPE, "indicator" + i), new EnrichmentValue(ImmutableMap.of("key" + i, "value" + i))));            }        }    });    context = new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> ImmutableMap.of(SimpleHBaseEnrichmentFunctions.TABLE_PROVIDER_TYPE_CONF, MockHBaseTableProvider.class.getName())).build();}
public Object metron_f4886_0(String rule, Map<String, Object> variables) throws Exception
{    StellarProcessor processor = new StellarProcessor();    Assert.assertTrue(rule + " not valid.", processor.validate(rule, context));    return processor.parse(rule, new DefaultVariableResolver(x -> variables.get(x), x -> variables.containsKey(x)), StellarFunctions.FUNCTION_RESOLVER(), context);}
public void metron_f4887_0() throws Exception
{    String stellar = "ENRICHMENT_EXISTS('et', indicator, 'enrichments', 'cf')";    Object result = run(stellar, ImmutableMap.of("indicator", "indicator0"));    Assert.assertTrue(result instanceof Boolean);    Assert.assertTrue((Boolean) result);}
public void metron_f4888_0() throws Exception
{    String stellar = "ENRICHMENT_EXISTS('et', indicator, 'enrichments', 'cf')";    Object result = run(stellar, ImmutableMap.of("indicator", "indicator7"));    Assert.assertTrue(result instanceof Boolean);    Assert.assertFalse((Boolean) result);}
public void metron_f4889_0() throws Exception
{    String stellar = "ENRICHMENT_GET('et', indicator, 'enrichments', 'cf')";    Object result = run(stellar, ImmutableMap.of("indicator", "indicator0"));    Assert.assertTrue(result instanceof Map);    Map<String, Object> out = (Map<String, Object>) result;    Assert.assertEquals("value0", out.get("key0"));}
public void metron_f4890_0() throws Exception
{    String stellar = "MAP([ 'indicator0', 'indicator1' ], indicator -> ENRICHMENT_GET('et', indicator, 'enrichments', 'cf') )";    Object result = run(stellar, new HashMap<>());    Assert.assertTrue(result instanceof List);    List<Map<String, Object>> out = (List<Map<String, Object>>) result;    Assert.assertEquals(2, out.size());    for (int i = 0; i < 2; ++i) {        Map<String, Object> map = out.get(i);        Assert.assertEquals("value" + i, map.get("key" + i));    }}
public void metron_f4891_0() throws Exception
{    String stellar = "ENRICHMENT_GET('et', indicator, 'enrichments', 'cf')";    Object result = run(stellar, ImmutableMap.of("indicator", "indicator7"));    Assert.assertTrue(result instanceof Map);    Map<String, Object> out = (Map<String, Object>) result;    Assert.assertTrue(out.isEmpty());}
public void metron_f4892_0() throws Exception
{    String stellar = "ENRICHMENT_GET('et', indicator)";    Object result = run(stellar, ImmutableMap.of("indicator", "indicator7"));}
public void metron_f4893_0() throws Exception
{    ThreatTriageProcessor threatTriageProcessor = getProcessor(smokeTestProcessorConfig);    Assert.assertEquals("Expected a score of 0", 0d, new ThreatTriageProcessor(new SensorEnrichmentConfig(), StellarFunctions.FUNCTION_RESOLVER(), Context.EMPTY_CONTEXT()).apply(new HashMap<Object, Object>() {        {            put("user.type", "admin");            put("asset.type", "web");        }    }).getScore(), 1e-10);    Assert.assertEquals("Expected a score of 10", 10d, threatTriageProcessor.apply(new HashMap<Object, Object>() {        {            put("user.type", "admin");            put("asset.type", "web");        }    }).getScore(), 1e-10);    Assert.assertEquals("Expected a score of 5", 5d, threatTriageProcessor.apply(new HashMap<Object, Object>() {        {            put("user.type", "normal");            put("asset.type", "web");        }    }).getScore(), 1e-10);    Assert.assertEquals("Expected a score of 0", 0d, threatTriageProcessor.apply(new HashMap<Object, Object>() {        {            put("user.type", "foo");            put("asset.type", "bar");        }    }).getScore(), 1e-10);    Assert.assertEquals("Expected a score of -Inf", Double.NEGATIVE_INFINITY, threatTriageProcessor.apply(new HashMap<Object, Object>() {        {            put("user.type", "abnormal");            put("asset.type", "bar");        }    }).getScore(), 1e-10);}
public void metron_f4894_0() throws Exception
{    Map<Object, Object> message = new HashMap<Object, Object>() {        {            put("user.type", "admin");            put("asset.type", "web");        }    };    ThreatScore score = getProcessor(smokeTestProcessorConfig).apply(message);        List<String> expectedNames = ImmutableList.of("rule 1", "rule 2");    Assert.assertEquals(2, score.getRuleScores().size());    score.getRuleScores().forEach(ruleScore -> Assert.assertTrue(expectedNames.contains(ruleScore.getRule().getName())));}
public void metron_f4895_0() throws Exception
{    Map<Object, Object> message = new HashMap<Object, Object>() {        {            put("user.type", "abnormal");            put("asset.type", "invalid");        }    };    ThreatScore score = getProcessor(smokeTestProcessorConfig).apply(message);        List<String> expectedNames = ImmutableList.of("rule 4");    Assert.assertEquals(1, score.getRuleScores().size());    score.getRuleScores().forEach(ruleScore -> Assert.assertTrue(expectedNames.contains(ruleScore.getRule().getName())));}
public void metron_f4896_0() throws Exception
{    Map<Object, Object> message = new HashMap<Object, Object>() {        {            put("user.type", "foo");            put("asset.type", "bar");        }    };    ThreatScore score = getProcessor(smokeTestProcessorConfig).apply(message);        Assert.assertEquals(0, score.getRuleScores().size());}
public void metron_f4897_0() throws Exception
{    ThreatTriageProcessor threatTriageProcessor = getProcessor(positiveMeanProcessorConfig);    Assert.assertEquals("Expected a score of 0", 5d, threatTriageProcessor.apply(new HashMap<Object, Object>() {        {            put("user.type", "normal");            put("asset.type", "web");        }    }).getScore(), 1e-10);    Assert.assertEquals("Expected a score of 7.5", (10 + 5) / 2.0, threatTriageProcessor.apply(new HashMap<Object, Object>() {        {            put("user.type", "admin");            put("asset.type", "web");        }    }).getScore(), 1e-10);    Assert.assertEquals("Expected a score of 0", 0d, threatTriageProcessor.apply(new HashMap<Object, Object>() {        {            put("user.type", "foo");            put("asset.type", "bar");        }    }).getScore(), 1e-10);}
public void metron_f4898_0() throws Exception
{    ThreatTriageProcessor threatTriageProcessor = getProcessor(testWithStellarFunction);    Assert.assertEquals(10d, threatTriageProcessor.apply(new HashMap<Object, Object>() {        {            put("ip_dst_addr", "172.2.2.2");        }    }).getScore(), 1e-10);}
public void metron_f4899_0() throws Exception
{    Map<Object, Object> message = new HashMap<Object, Object>() {        {            put("variable.name", "variable.value");        }    };    ThreatScore score = getProcessor(testReasonConfig).apply(message);    assertEquals(1, score.getRuleScores().size());    for (RuleScore ruleScore : score.getRuleScores()) {                assertEquals("variable.value", ruleScore.getReason());    }}
public void metron_f4900_0() throws Exception
{    Map<Object, Object> message = new HashMap<Object, Object>() {        {                }    };    ThreatScore score = getProcessor(testReasonConfig).apply(message);    assertEquals(1, score.getRuleScores().size());    for (RuleScore ruleScore : score.getRuleScores()) {                assertEquals(null, ruleScore.getReason());    }}
public void metron_f4901_0() throws Exception
{    Map<String, Object> message = new HashMap<>();    ThreatTriageProcessor threatTriageProcessor = getProcessor(shouldAllowNumericRuleScore);    Assert.assertEquals(10d, threatTriageProcessor.apply(message).getScore(), 1e-10);}
public void metron_f4902_0() throws Exception
{        Map<Object, Object> message = new HashMap<Object, Object>() {        {            put("priority", 100);        }    };    ThreatTriageProcessor threatTriageProcessor = getProcessor(shouldAllowScoreAsStellarExpression);    Assert.assertEquals(1010.0d, threatTriageProcessor.apply(message).getScore(), 1e-10);}
private static ThreatTriageProcessor metron_f4903_0(String config) throws IOException
{    SensorEnrichmentConfig c = JSONUtils.INSTANCE.load(config, SensorEnrichmentConfig.class);    return new ThreatTriageProcessor(c, StellarFunctions.FUNCTION_RESOLVER(), Context.EMPTY_CONTEXT());}
public GenericEnrichmentBolt metron_f4904_0(Enrichment enrichment)
{    this.enrichmentType = enrichment.getType();    this.adapter = enrichment.getAdapter();    return this;}
public GenericEnrichmentBolt metron_f4905_0(long maxCacheSize)
{    this.maxCacheSize = maxCacheSize;    return this;}
public GenericEnrichmentBolt metron_f4906_0(long maxTimeRetain)
{    this.maxTimeRetain = maxTimeRetain;    return this;}
public GenericEnrichmentBolt metron_f4907_0(boolean cacheInvalidationOnReload)
{    this.invalidateCacheOnReload = cacheInvalidationOnReload;    return this;}
public void metron_f4908_0(String name, ConfigurationType type)
{    if (invalidateCacheOnReload) {        if (cache != null) {            cache.invalidateAll();        }    }    if (type == ConfigurationType.GLOBAL) {        adapter.updateAdapter(getConfigurations().getGlobalConfig());    }}
public void metron_f4909_1(Map conf, TopologyContext topologyContext, OutputCollector collector)
{    super.prepare(conf, topologyContext, collector);    this.collector = collector;    if (this.maxCacheSize == null)        throw new IllegalStateException("MAX_CACHE_SIZE_OBJECTS_NUM must be specified");    if (this.maxTimeRetain == null)        throw new IllegalStateException("MAX_TIME_RETAIN_MINUTES must be specified");    if (this.adapter == null)        throw new IllegalStateException("Adapter must be specified");    loader = key -> adapter.enrich(key);    cache = Caffeine.newBuilder().maximumSize(maxCacheSize).expireAfterWrite(maxTimeRetain, TimeUnit.MINUTES).build(loader);    boolean success = adapter.initializeAdapter(getConfigurations().getGlobalConfig());    if (!success) {                throw new IllegalStateException("Could not initialize adapter...");    }    perfLog = new PerformanceLogger(() -> getConfigurations().getGlobalConfig(), GenericEnrichmentBolt.Perf.class.getName());    initializeStellar();}
protected void metron_f4910_0()
{    stellarContext = new Context.Builder().with(Context.Capabilities.ZOOKEEPER_CLIENT, () -> client).with(Context.Capabilities.GLOBAL_CONFIG, () -> getConfigurations().getGlobalConfig()).with(Context.Capabilities.STELLAR_CONFIG, () -> getConfigurations().getGlobalConfig()).build();    StellarFunctions.initialize(stellarContext);}
public void metron_f4911_0(OutputFieldsDeclarer declarer)
{    declarer.declareStream(enrichmentType, new Fields("key", "message", "subgroup"));    declarer.declareStream(ERROR_STREAM, new Fields("message"));}
public void metron_f4912_1(Tuple tuple)
{    perfLog.mark("execute");    String key = tuple.getStringByField("key");    JSONObject rawMessage = (JSONObject) tuple.getValueByField("message");    String subGroup = "";    JSONObject enrichedMessage = new JSONObject();    enrichedMessage.put("adapter." + adapter.getClass().getSimpleName().toLowerCase() + ".begin.ts", "" + System.currentTimeMillis());    try {        if (rawMessage == null || rawMessage.isEmpty())            throw new Exception("Could not parse binary stream to JSON");        if (key == null)            throw new Exception("Key is not valid");        String sourceType = null;        if (rawMessage.containsKey(Constants.SENSOR_TYPE)) {            sourceType = rawMessage.get(Constants.SENSOR_TYPE).toString();        } else {            throw new RuntimeException("Source type is missing from enrichment fragment: " + rawMessage.toJSONString());        }        String prefix = null;        for (Object o : rawMessage.keySet()) {            String field = (String) o;            Object value = rawMessage.get(field);            if (field.equals(Constants.SENSOR_TYPE)) {                enrichedMessage.put(Constants.SENSOR_TYPE, value);            } else {                JSONObject enrichedField = new JSONObject();                if (value != null) {                    SensorEnrichmentConfig config = getConfigurations().getSensorEnrichmentConfig(sourceType);                    if (config == null) {                                                MetronError metronError = new MetronError().withErrorType(Constants.ErrorType.ENRICHMENT_ERROR).withMessage("Unable to find SensorEnrichmentConfig for sourceType: " + sourceType).addRawMessage(rawMessage);                        StormErrorUtils.handleError(collector, metronError);                        continue;                    }                    config.getConfiguration().putIfAbsent(STELLAR_CONTEXT_CONF, stellarContext);                    CacheKey cacheKey = new CacheKey(field, value, config);                    try {                        adapter.logAccess(cacheKey);                        prefix = adapter.getOutputPrefix(cacheKey);                        subGroup = adapter.getStreamSubGroup(enrichmentType, field);                        perfLog.mark("enrich");                        enrichedField = cache.get(cacheKey);                        perfLog.log("enrich", "key={}, time to run enrichment type={}", key, enrichmentType);                        if (enrichedField == null)                            throw new Exception("[Metron] Could not enrich string: " + value);                    } catch (Exception e) {                                                MetronError metronError = new MetronError().withErrorType(Constants.ErrorType.ENRICHMENT_ERROR).withThrowable(e).withErrorFields(new HashSet() {                            {                                add(field);                            }                        }).addRawMessage(rawMessage);                        StormErrorUtils.handleError(collector, metronError);                        continue;                    }                }                enrichedMessage = EnrichmentUtils.adjustKeys(enrichedMessage, enrichedField, field, prefix);            }        }        enrichedMessage.put("adapter." + adapter.getClass().getSimpleName().toLowerCase() + ".end.ts", "" + System.currentTimeMillis());        if (!enrichedMessage.isEmpty()) {            collector.emit(enrichmentType, new Values(key, enrichedMessage, subGroup));        }    } catch (Exception e) {        handleError(key, rawMessage, subGroup, enrichedMessage, e);    }    perfLog.log("execute", "key={}, elapsed time to run execute", key);}
protected void metron_f4913_1(String key, JSONObject rawMessage, String subGroup, JSONObject enrichedMessage, Exception e)
{        if (key != null) {        collector.emit(enrichmentType, new Values(key, enrichedMessage, subGroup));    }    MetronError error = new MetronError().withErrorType(Constants.ErrorType.ENRICHMENT_ERROR).withThrowable(e).addRawMessage(rawMessage);    StormErrorUtils.handleError(collector, error);}
public void metron_f4914_0()
{    super.cleanup();    adapter.cleanup();}
public Context metron_f4915_0()
{    return stellarContext;}
public UnifiedEnrichmentBolt metron_f4916_0(List<Enrichment> enrichments)
{    for (Enrichment e : enrichments) {        enrichmentsByType.put(e.getType(), e.getAdapter());    }    return this;}
public UnifiedEnrichmentBolt metron_f4917_0(boolean captureCacheStats)
{    this.captureCacheStats = captureCacheStats;    return this;}
public UnifiedEnrichmentBolt metron_f4918_0(String getter)
{    this.getterStrategy = MessageGetters.valueOf(getter);    return this;}
private static int metron_f4919_0(Object numThreads)
{    if (numThreads instanceof Number) {        return ((Number) numThreads).intValue();    } else if (numThreads instanceof String) {        String numThreadsStr = ((String) numThreads).trim().toUpperCase();        if (numThreadsStr.endsWith("C")) {            Integer factor = Integer.parseInt(numThreadsStr.replace("C", ""));            return factor * Runtime.getRuntime().availableProcessors();        } else {            return Integer.parseInt(numThreadsStr);        }    }    return 2 * Runtime.getRuntime().availableProcessors();}
public UnifiedEnrichmentBolt metron_f4920_0(String strategy)
{    this.strategy = EnrichmentStrategies.valueOf(strategy);    return this;}
public UnifiedEnrichmentBolt metron_f4921_0(long maxCacheSize)
{    this.maxCacheSize = maxCacheSize;    return this;}
public UnifiedEnrichmentBolt metron_f4922_0(long maxTimeRetain)
{    this.maxTimeRetain = maxTimeRetain;    return this;}
public UnifiedEnrichmentBolt metron_f4923_0(boolean cacheInvalidationOnReload)
{    this.invalidateCacheOnReload = cacheInvalidationOnReload;    return this;}
public void metron_f4924_0(String name, ConfigurationType type)
{    if (invalidateCacheOnReload) {        if (strategy != null && ConcurrencyContext.get(strategy).getCache() != null) {            ConcurrencyContext.get(strategy).getCache().invalidateAll();        }    }    if (type == ConfigurationType.GLOBAL && enrichmentsByType != null) {        for (EnrichmentAdapter adapter : enrichmentsByType.values()) {            adapter.updateAdapter(getConfigurations().getGlobalConfig());        }    }}
public void metron_f4925_1(Tuple input)
{    JSONObject message = generateMessage(input);    try {        String sourceType = MessageUtils.getSensorType(message);        SensorEnrichmentConfig config = getConfigurations().getSensorEnrichmentConfig(sourceType);        if (config == null) {                        config = new SensorEnrichmentConfig();        }                        config.getConfiguration().putIfAbsent(STELLAR_CONTEXT_CONF, stellarContext);        String guid = getGUID(input, message);                ParallelEnricher.EnrichmentResult result = enricher.apply(message, strategy, config, perfLog);        JSONObject enriched = result.getResult();        enriched = strategy.postProcess(enriched, config, enrichmentContext);                collector.emit("message", input, new Values(guid, enriched));                for (Map.Entry<Object, Throwable> t : result.getEnrichmentErrors()) {                        MetronError error = new MetronError().withErrorType(strategy.getErrorType()).withMessage(t.getValue().getMessage()).withThrowable(t.getValue()).addRawMessage(t.getKey());            StormErrorUtils.handleError(collector, error);        }    } catch (Exception e) {                                MetronError error = new MetronError().withErrorType(strategy.getErrorType()).withMessage(e.getMessage()).withThrowable(e).addRawMessage(message);        StormErrorUtils.handleError(collector, error);    } finally {        collector.ack(input);    }}
public UnifiedEnrichmentBolt metron_f4926_0(String messageFieldName)
{    this.messageFieldName = messageFieldName;    return this;}
public JSONObject metron_f4927_0(Tuple tuple)
{    return (JSONObject) messageGetter.get(tuple);}
public final void metron_f4928_1(Map map, TopologyContext topologyContext, OutputCollector outputCollector)
{    super.prepare(map, topologyContext, outputCollector);    collector = outputCollector;    if (this.maxCacheSize == null) {        throw new IllegalStateException("MAX_CACHE_SIZE_OBJECTS_NUM must be specified");    }    if (this.maxTimeRetain == null) {        throw new IllegalStateException("MAX_TIME_RETAIN_MINUTES must be specified");    }    if (this.enrichmentsByType.isEmpty()) {        throw new IllegalStateException("Adapter must be specified");    }    for (Map.Entry<String, EnrichmentAdapter<CacheKey>> adapterKv : enrichmentsByType.entrySet()) {        boolean success = adapterKv.getValue().initializeAdapter(getConfigurations().getGlobalConfig());        if (!success) {                        throw new IllegalStateException("Could not initialize adapter: " + adapterKv.getKey());        }    }    WorkerPoolStrategies workerPoolStrategy = WorkerPoolStrategies.FIXED;    if (map.containsKey(THREADPOOL_TYPE_TOPOLOGY_CONF)) {        workerPoolStrategy = WorkerPoolStrategies.valueOf(map.get(THREADPOOL_TYPE_TOPOLOGY_CONF) + "");    }    if (map.containsKey(THREADPOOL_NUM_THREADS_TOPOLOGY_CONF)) {        int numThreads = getNumThreads(map.get(THREADPOOL_NUM_THREADS_TOPOLOGY_CONF));        ConcurrencyContext.get(strategy).initialize(numThreads, maxCacheSize, maxTimeRetain, workerPoolStrategy, LOG, captureCacheStats);    } else {        throw new IllegalStateException("You must pass " + THREADPOOL_NUM_THREADS_TOPOLOGY_CONF + " via storm config.");    }    messageGetter = this.getterStrategy.get(messageFieldName);    enricher = new ParallelEnricher(enrichmentsByType, ConcurrencyContext.get(strategy), captureCacheStats);    perfLog = new PerformanceLogger(() -> getConfigurations().getGlobalConfig(), Perf.class.getName());    GeoLiteCityDatabase.INSTANCE.update((String) getConfigurations().getGlobalConfig().get(GeoLiteCityDatabase.GEO_HDFS_FILE));    GeoLiteAsnDatabase.INSTANCE.update((String) getConfigurations().getGlobalConfig().get(GeoLiteAsnDatabase.ASN_HDFS_FILE));    initializeStellar();    enrichmentContext = new EnrichmentContext(StellarFunctions.FUNCTION_RESOLVER(), stellarContext);}
protected void metron_f4929_0()
{    stellarContext = new Context.Builder().with(Context.Capabilities.ZOOKEEPER_CLIENT, () -> client).with(Context.Capabilities.GLOBAL_CONFIG, () -> getConfigurations().getGlobalConfig()).with(Context.Capabilities.STELLAR_CONFIG, () -> getConfigurations().getGlobalConfig()).build();    StellarFunctions.initialize(stellarContext);}
public String metron_f4930_0(Tuple tuple, JSONObject message)
{    String key = null, guid = null;    try {        key = tuple.getStringByField("key");        guid = (String) message.get(Constants.GUID);    } catch (Throwable t) {        }    if (key != null) {        return key;    } else if (guid != null) {        return guid;    } else {        return UUID.randomUUID().toString();    }}
public void metron_f4931_0(OutputFieldsDeclarer declarer)
{    declarer.declareStream("message", new Fields("key", "message"));    declarer.declareStream("error", new Fields("message"));}
public boolean metron_f4932_0(Object o)
{    Values values = (Values) o;    String actualKey = (String) values.get(0);    JSONObject actualMessage = (JSONObject) values.get(1);    removeTimingFields(actualMessage);    return expectedKey.equals(actualKey) && expectedMessage.equals(actualMessage);}
public void metron_f4933_0(Description description)
{    description.appendText(String.format("[%s]", expectedMessage));}
public void metron_f4934_0() throws ParseException
{    JSONParser parser = new JSONParser();    originalMessage = (JSONObject) parser.parse(originalMessageString);    enrichedField1 = (JSONObject) parser.parse(enrichedField1String);    enrichedField2 = (JSONObject) parser.parse(enrichedField2String);    enrichedMessage = (JSONObject) parser.parse(enrichedMessageString);}
public void metron_f4935_0()
{    MockitoAnnotations.initMocks(this);}
public void metron_f4936_0() throws IOException
{    when(tuple.getSourceComponent()).thenReturn("unit test component");    when(tuple.getSourceStreamId()).thenReturn("unit test stream");    String key = "someKey";    String enrichmentType = "enrichmentType";    Enrichment<EnrichmentAdapter<CacheKey>> testEnrichment = new Enrichment<>();    testEnrichment.setType(enrichmentType);    testEnrichment.setAdapter(enrichmentAdapter);    GenericEnrichmentBolt genericEnrichmentBolt = new GenericEnrichmentBolt("zookeeperUrl") {        @Override        protected void initializeStellar() {                }    };    genericEnrichmentBolt.setCuratorFramework(client);    genericEnrichmentBolt.setZKCache(cache);    genericEnrichmentBolt.getConfigurations().updateSensorEnrichmentConfig(sensorType, new FileInputStream(enrichmentConfigPath));    HashMap<String, Object> globalConfig = new HashMap<>();    String baseDir = UnitTestHelper.findDir(new File("../metron-enrichment-common"), "GeoLite");    File geoHdfsFile = new File(new File(baseDir), "GeoLite2-City.mmdb.gz");    globalConfig.put(GeoLiteCityDatabase.GEO_HDFS_FILE, geoHdfsFile.getAbsolutePath());    genericEnrichmentBolt.getConfigurations().updateGlobalConfig(globalConfig);    try {        genericEnrichmentBolt.prepare(new HashMap(), topologyContext, outputCollector);        fail("Should fail if a maxCacheSize property is not set");    } catch (IllegalStateException e) {    }    genericEnrichmentBolt.withMaxCacheSize(100);    try {        genericEnrichmentBolt.prepare(new HashMap(), topologyContext, outputCollector);        fail("Should fail if a maxTimeRetain property is not set");    } catch (IllegalStateException e) {    }    genericEnrichmentBolt.withMaxTimeRetain(10000);    try {        genericEnrichmentBolt.prepare(new HashMap(), topologyContext, outputCollector);        fail("Should fail if an adapter is not set");    } catch (IllegalStateException e) {    }    genericEnrichmentBolt.withEnrichment(testEnrichment);    when(enrichmentAdapter.initializeAdapter(globalConfig)).thenReturn(true);    genericEnrichmentBolt.prepare(new HashMap(), topologyContext, outputCollector);    verify(enrichmentAdapter, times(1)).initializeAdapter(globalConfig);    when(enrichmentAdapter.initializeAdapter(globalConfig)).thenReturn(false);    UnitTestHelper.setLog4jLevel(GenericEnrichmentBolt.class, Level.FATAL);    try {        genericEnrichmentBolt.prepare(new HashMap(), topologyContext, outputCollector);        fail("An exception should be thrown if enrichment adapter initialization fails");    } catch (IllegalStateException e) {    }    UnitTestHelper.setLog4jLevel(GenericEnrichmentBolt.class, Level.ERROR);    genericEnrichmentBolt.declareOutputFields(declarer);    verify(declarer, times(1)).declareStream(eq(enrichmentType), argThat(new FieldsMatcher("key", "message", "subgroup")));    verify(declarer, times(1)).declareStream(eq("error"), argThat(new FieldsMatcher("message")));    when(tuple.getStringByField("key")).thenReturn(null);    UnitTestHelper.setLog4jLevel(GenericEnrichmentBolt.class, Level.FATAL);    genericEnrichmentBolt.execute(tuple);    UnitTestHelper.setLog4jLevel(GenericEnrichmentBolt.class, Level.ERROR);    MetronError error = new MetronError().withErrorType(Constants.ErrorType.ENRICHMENT_ERROR).withThrowable(new Exception("Could not parse binary stream to JSON"));    verify(outputCollector, times(1)).emit(eq(Constants.ERROR_STREAM), argThat(new MetronErrorJSONMatcher(error.getJSONObject())));    when(tuple.getStringByField("key")).thenReturn(key);    when(tuple.getValueByField("message")).thenReturn(originalMessage);    when(enrichmentAdapter.enrich(any())).thenReturn(new JSONObject());    genericEnrichmentBolt.execute(tuple);    verify(outputCollector, times(1)).emit(eq(enrichmentType), argThat(new EnrichedMessageMatcher(key, new JSONObject(ImmutableMap.of("source.type", "test")))));    reset(enrichmentAdapter);    SensorEnrichmentConfig sensorEnrichmentConfig = SensorEnrichmentConfig.fromBytes(ConfigurationsUtils.readSensorEnrichmentConfigsFromFile(sampleConfigPath).get(sensorType));    sensorEnrichmentConfig.getConfiguration().put(STELLAR_CONTEXT_CONF, genericEnrichmentBolt.getStellarContext());    CacheKey cacheKey1 = new CacheKey("field1", "value1", sensorEnrichmentConfig);    CacheKey cacheKey2 = new CacheKey("field2", "value2", sensorEnrichmentConfig);    genericEnrichmentBolt.cache.invalidateAll();    when(enrichmentAdapter.getOutputPrefix(cacheKey1)).thenReturn("field1");    when(enrichmentAdapter.getOutputPrefix(cacheKey2)).thenReturn("field2");    when(enrichmentAdapter.enrich(cacheKey1)).thenReturn(enrichedField1);    when(enrichmentAdapter.enrich(cacheKey2)).thenReturn(enrichedField2);    genericEnrichmentBolt.execute(tuple);    verify(enrichmentAdapter, times(1)).logAccess(cacheKey1);    verify(enrichmentAdapter, times(1)).logAccess(cacheKey2);    verify(outputCollector, times(1)).emit(eq(enrichmentType), argThat(new EnrichedMessageMatcher(key, enrichedMessage)));    reset(outputCollector);    genericEnrichmentBolt.cache.invalidateAll();    when(enrichmentAdapter.enrich(cacheKey1)).thenReturn(null);    genericEnrichmentBolt.execute(tuple);    error = new MetronError().withErrorType(Constants.ErrorType.ENRICHMENT_ERROR).withErrorFields(new HashSet<String>() {        {            add("field1");        }    }).addRawMessage(new JSONObject() {        {            put("field1", "value1");            put("field2", "value2");            put("source.type", "test");        }    }).withThrowable(new Exception("[Metron] Could not enrich string: value1"));    verify(outputCollector, times(1)).emit(eq(Constants.ERROR_STREAM), argThat(new MetronErrorJSONMatcher(error.getJSONObject())));}
private static List<byte[]> metron_f4938_0(String path)
{    try {        List<byte[]> ret = TestUtils.readSampleData(path);        {                        Map<String, Object> sansDestinationIp = JSONUtils.INSTANCE.load(new String(ret.get(ret.size() - 1), StandardCharsets.UTF_8), JSONUtils.MAP_SUPPLIER);            sansDestinationIp.remove(Constants.Fields.DST_ADDR.getName());            ret.add(JSONUtils.INSTANCE.toJSONPretty(sansDestinationIp));        }        return ret;    } catch (IOException ioe) {        return null;    }}
public static void metron_f4939_0() throws ParseException
{    String baseDir = UnitTestHelper.findDir(new File("../metron-enrichment-common"), "GeoLite");    geoHdfsFile = new File(new File(baseDir), "GeoLite2-City.mmdb.gz");    asnHdfsFile = new File(new File(baseDir), "GeoLite2-ASN.tar.gz");}
public String metron_f4940_0()
{    return "src/main/config/enrichment.properties.j2";}
public String metron_f4941_0()
{    return "src/main/flux/enrichment/remote.yaml";}
public Properties metron_f4942_0()
{    return new Properties() {        {                        setProperty("enrichment_workers", "1");            setProperty("enrichment_acker_executors", "0");            setProperty("enrichment_topology_worker_childopts", "");            setProperty("topology_auto_credentials", "[]");            setProperty("enrichment_topology_max_spout_pending", "500");                        setProperty("kafka_security_protocol", "PLAINTEXT");            setProperty("enrichment_kafka_start", "UNCOMMITTED_EARLIEST");            setProperty("enrichment_input_topic", Constants.ENRICHMENT_TOPIC);            setProperty("enrichment_output_topic", Constants.INDEXING_TOPIC);            setProperty("enrichment_error_topic", ERROR_TOPIC);            setProperty("threatintel_error_topic", ERROR_TOPIC);                        setProperty("enrichment_hbase_provider_impl", "" + MockHBaseTableProvider.class.getName());            setProperty("enrichment_hbase_table", enrichmentsTableName);            setProperty("enrichment_hbase_cf", cf);            setProperty("enrichment_host_known_hosts", "[{\"ip\":\"10.1.128.236\", \"local\":\"YES\", \"type\":\"webserver\", \"asset_value\" : \"important\"}," + "{\"ip\":\"10.1.128.237\", \"local\":\"UNKNOWN\", \"type\":\"unknown\", \"asset_value\" : \"important\"}," + "{\"ip\":\"10.60.10.254\", \"local\":\"YES\", \"type\":\"printer\", \"asset_value\" : \"important\"}," + "{\"ip\":\"10.0.2.15\", \"local\":\"YES\", \"type\":\"printer\", \"asset_value\" : \"important\"}]");                        setProperty("threatintel_hbase_table", threatIntelTableName);            setProperty("threatintel_hbase_cf", cf);                        setProperty("unified_kafka_spout_parallelism", "1");            setProperty("unified_enrichment_parallelism", "1");            setProperty("unified_threat_intel_parallelism", "1");            setProperty("unified_kafka_writer_parallelism", "1");                        setProperty("unified_enrichment_cache_size", "1000");            setProperty("unified_threat_intel_cache_size", "1000");                        setProperty("unified_enrichment_threadpool_size", "1");            setProperty("unified_enrichment_threadpool_type", "FIXED");        }    };}
public void metron_f4943_0() throws Exception
{    final Properties topologyProperties = getTopologyProperties();    final ZKServerComponent zkServerComponent = getZKServerComponent(topologyProperties);    final KafkaComponent kafkaComponent = getKafkaComponent(topologyProperties, new ArrayList<KafkaComponent.Topic>() {        {            add(new KafkaComponent.Topic(Constants.ENRICHMENT_TOPIC, 1));            add(new KafkaComponent.Topic(Constants.INDEXING_TOPIC, 1));            add(new KafkaComponent.Topic(ERROR_TOPIC, 1));        }    });    String globalConfigStr = null;    {        File globalConfig = new File(enrichmentConfigPath, "global.json");        Map<String, Object> config = JSONUtils.INSTANCE.load(globalConfig, JSONUtils.MAP_SUPPLIER);        config.put(SimpleHBaseEnrichmentFunctions.TABLE_PROVIDER_TYPE_CONF, MockHBaseTableProvider.class.getName());        config.put(SimpleHBaseEnrichmentFunctions.ACCESS_TRACKER_TYPE_CONF, "PERSISTENT_BLOOM");        config.put(PersistentBloomTrackerCreator.Config.PERSISTENT_BLOOM_TABLE, trackerHBaseTableName);        config.put(PersistentBloomTrackerCreator.Config.PERSISTENT_BLOOM_CF, cf);        config.put(GeoLiteCityDatabase.GEO_HDFS_FILE, geoHdfsFile.getAbsolutePath());        config.put(GeoLiteAsnDatabase.ASN_HDFS_FILE, asnHdfsFile.getAbsolutePath());        globalConfigStr = JSONUtils.INSTANCE.toJSON(config, true);    }    ConfigUploadComponent configUploadComponent = new ConfigUploadComponent().withTopologyProperties(topologyProperties).withGlobalConfig(globalConfigStr).withEnrichmentConfigsPath(enrichmentConfigPath);        final MockHTable trackerTable = (MockHTable) MockHBaseTableProvider.addToCache(trackerHBaseTableName, cf);    final MockHTable threatIntelTable = (MockHTable) MockHBaseTableProvider.addToCache(threatIntelTableName, cf);    EnrichmentHelper.INSTANCE.load(threatIntelTable, cf, new ArrayList<LookupKV<EnrichmentKey, EnrichmentValue>>() {        {            add(new LookupKV<>(new EnrichmentKey(MALICIOUS_IP_TYPE, "10.0.2.3"), new EnrichmentValue(new HashMap<>())));        }    });    final MockHTable enrichmentTable = (MockHTable) MockHBaseTableProvider.addToCache(enrichmentsTableName, cf);    EnrichmentHelper.INSTANCE.load(enrichmentTable, cf, new ArrayList<LookupKV<EnrichmentKey, EnrichmentValue>>() {        {            add(new LookupKV<>(new EnrichmentKey(PLAYFUL_CLASSIFICATION_TYPE, "10.0.2.3"), new EnrichmentValue(PLAYFUL_ENRICHMENT)));        }    });    FluxTopologyComponent fluxComponent = new FluxTopologyComponent.Builder().withTopologyLocation(new File(fluxPath())).withTopologyName("test").withTemplateLocation(new File(getTemplatePath())).withTopologyProperties(topologyProperties).build();        ComponentRunner runner = new ComponentRunner.Builder().withComponent("zk", zkServerComponent).withComponent("kafka", kafkaComponent).withComponent("config", configUploadComponent).withComponent("storm", fluxComponent).withMillisecondsBetweenAttempts(15000).withCustomShutdownOrder(new String[] { "storm", "config", "kafka", "zk" }).withNumRetries(10).build();    try {        runner.start();        fluxComponent.submitTopology();        kafkaComponent.writeMessages(Constants.ENRICHMENT_TOPIC, inputMessages);        ProcessorResult<Map<String, List<Map<String, Object>>>> result = runner.process(getProcessor());        Map<String, List<Map<String, Object>>> outputMessages = result.getResult();        List<Map<String, Object>> docs = outputMessages.get(Constants.INDEXING_TOPIC);        Assert.assertEquals(inputMessages.size(), docs.size());        validateAll(docs);        List<Map<String, Object>> errors = outputMessages.get(ERROR_TOPIC);        Assert.assertEquals(inputMessages.size(), errors.size());        validateErrors(errors);    } finally {        runner.stop();    }}
public void metron_f4944_0(List<Map<String, Object>> outputMessages, StringBuffer buffer)
{    for (Map<String, Object> map : outputMessages) {        for (String json : map.keySet()) {            buffer.append(json).append("\n");        }    }}
public static void metron_f4945_0(List<Map<String, Object>> docs)
{    for (Map<String, Object> doc : docs) {        baseValidation(doc);        hostEnrichmentValidation(doc);        geoEnrichmentValidation(doc);        threatIntelValidation(doc);        simpleEnrichmentValidation(doc);    }}
protected void metron_f4946_0(List<Map<String, Object>> errors)
{    for (Map<String, Object> error : errors) {        Assert.assertTrue(error.get(Constants.ErrorFields.MESSAGE.getName()).toString(), error.get(Constants.ErrorFields.MESSAGE.getName()).toString().contains("/ by zero"));        Assert.assertTrue(error.get(Constants.ErrorFields.EXCEPTION.getName()).toString().contains("/ by zero"));        Assert.assertEquals(Constants.ErrorType.ENRICHMENT_ERROR.getType(), error.get(Constants.ErrorFields.ERROR_TYPE.getName()));        Assert.assertEquals("{\"error_test\":{},\"source.type\":\"test\"}", error.get(Constants.ErrorFields.RAW_MESSAGE.getName()));    }}
public static void metron_f4947_0(Map<String, Object> jsonDoc)
{    assertEnrichmentsExists("threatintels.", setOf("hbaseThreatIntel"), jsonDoc.keySet());    assertEnrichmentsExists("enrichments.", setOf("geo", "host", "hbaseEnrichment"), jsonDoc.keySet());        for (Map.Entry<String, Object> kv : jsonDoc.entrySet()) {        String actual = Objects.toString(kv.getValue(), "");        Assert.assertTrue(String.format("Value of '%s' is empty: '%s'", kv.getKey(), actual), StringUtils.isNotEmpty(actual));    }        Assert.assertNotNull(jsonDoc.get(SRC_IP));    Assert.assertNotNull(jsonDoc.get("ALL_CAPS"));    Assert.assertNotNull(jsonDoc.get("map.blah"));    Assert.assertNull(jsonDoc.get("map"));    Assert.assertNotNull(jsonDoc.get("one"));    Assert.assertEquals(1, jsonDoc.get("one"));    Assert.assertEquals(1, jsonDoc.get("map.blah"));    Assert.assertNotNull(jsonDoc.get("foo"));    Assert.assertNotNull(jsonDoc.get("alt_src_type"));    Assert.assertEquals("test", jsonDoc.get("alt_src_type"));    Assert.assertEquals("TEST", jsonDoc.get("ALL_CAPS"));    Assert.assertNotNull(jsonDoc.get("bar"));    Assert.assertEquals("TEST", jsonDoc.get("bar"));}
public boolean metron_f4948_0(EvaluationPayload payload)
{    return _predicate.apply(payload);}
public boolean metron_f4949_0(@Nullable EvaluationPayload evaluationPayload)
{    return evaluationPayload.indexedDoc.getOrDefault("enrichments.host." + evaluationPayload.key + ".known_info.local", "").equals("YES");}
public boolean metron_f4950_0(@Nullable EvaluationPayload evaluationPayload)
{    return evaluationPayload.indexedDoc.getOrDefault("enrichments.host." + evaluationPayload.key + ".known_info.local", "").equals("UNKNOWN");}
public boolean metron_f4951_0(@Nullable EvaluationPayload evaluationPayload)
{    return evaluationPayload.indexedDoc.getOrDefault("enrichments.host." + evaluationPayload.key + ".known_info.asset_value", "").equals("important");}
public boolean metron_f4952_0(@Nullable EvaluationPayload evaluationPayload)
{    return evaluationPayload.indexedDoc.getOrDefault("enrichments.host." + evaluationPayload.key + ".known_info.type", "").equals("printer");}
public boolean metron_f4953_0(@Nullable EvaluationPayload evaluationPayload)
{    return evaluationPayload.indexedDoc.getOrDefault("enrichments.host." + evaluationPayload.key + ".known_info.type", "").equals("webserver");}
public boolean metron_f4954_0(@Nullable EvaluationPayload evaluationPayload)
{    return evaluationPayload.indexedDoc.getOrDefault("enrichments.host." + evaluationPayload.key + ".known_info.type", "").equals("unknown");}
private static void metron_f4955_0(String topLevel, Set<String> expectedEnrichments, Set<String> keys)
{    for (String key : keys) {        if (key.startsWith(topLevel)) {            String secondLevel = Iterables.get(Splitter.on(".").split(key), 1);            String message = "Found an enrichment/threat intel (" + secondLevel + ") that I didn't expect (expected enrichments :" + Joiner.on(",").join(expectedEnrichments) + "), but it was not there.  If you've created a new" + " enrichment, then please add a validation method to this unit test.  Otherwise, it's a solid error" + " and should be investigated.";            Assert.assertTrue(message, expectedEnrichments.contains(secondLevel));        }    }}
private static void metron_f4956_0(Map<String, Object> indexedDoc)
{    if (indexedDoc.getOrDefault(SRC_IP, "").equals("10.0.2.3") || indexedDoc.getOrDefault(DST_IP, "").equals("10.0.2.3")) {        Assert.assertTrue(keyPatternExists("enrichments.hbaseEnrichment", indexedDoc));        if (indexedDoc.getOrDefault(SRC_IP, "").equals("10.0.2.3")) {            Assert.assertEquals(indexedDoc.get("enrichments.hbaseEnrichment." + SRC_IP + "." + PLAYFUL_CLASSIFICATION_TYPE + ".orientation"), PLAYFUL_ENRICHMENT.get("orientation"));            Assert.assertEquals(indexedDoc.get("src_classification.orientation"), PLAYFUL_ENRICHMENT.get("orientation"));            Assert.assertEquals(indexedDoc.get("is_src_malicious"), true);        } else if (indexedDoc.getOrDefault(DST_IP, "").equals("10.0.2.3")) {            Assert.assertEquals(indexedDoc.get("enrichments.hbaseEnrichment." + DST_IP + "." + PLAYFUL_CLASSIFICATION_TYPE + ".orientation"), PLAYFUL_ENRICHMENT.get("orientation"));            Assert.assertEquals(indexedDoc.get("dst_classification.orientation"), PLAYFUL_ENRICHMENT.get("orientation"));        }        if (!indexedDoc.getOrDefault(SRC_IP, "").equals("10.0.2.3")) {            Assert.assertEquals(indexedDoc.get("is_src_malicious"), false);        }    } else {        Assert.assertEquals(indexedDoc.get("is_src_malicious"), false);    }}
private static void metron_f4957_0(Map<String, Object> indexedDoc)
{    if (indexedDoc.getOrDefault(SRC_IP, "").equals("10.0.2.3") || indexedDoc.getOrDefault(DST_IP, "").equals("10.0.2.3")) {                Assert.assertTrue(keyPatternExists("threatintels.", indexedDoc));        Assert.assertEquals(indexedDoc.getOrDefault("is_alert", ""), "true");                Assert.assertTrue(indexedDoc.containsKey(ThreatIntelUtils.THREAT_TRIAGE_SCORE_KEY));        Double score = (Double) indexedDoc.get(ThreatIntelUtils.THREAT_TRIAGE_SCORE_KEY);        Assert.assertEquals(score, 10d, 1e-7);                Joiner joiner = Joiner.on(".");        Stream.of(joiner.join(ThreatIntelUtils.THREAT_TRIAGE_RULES_KEY, 0, ThreatIntelUtils.THREAT_TRIAGE_RULE_NAME), joiner.join(ThreatIntelUtils.THREAT_TRIAGE_RULES_KEY, 0, ThreatIntelUtils.THREAT_TRIAGE_RULE_COMMENT), joiner.join(ThreatIntelUtils.THREAT_TRIAGE_RULES_KEY, 0, ThreatIntelUtils.THREAT_TRIAGE_RULE_REASON), joiner.join(ThreatIntelUtils.THREAT_TRIAGE_RULES_KEY, 0, ThreatIntelUtils.THREAT_TRIAGE_RULE_SCORE)).forEach(key -> Assert.assertTrue(String.format("Missing expected key: '%s'", key), indexedDoc.containsKey(key)));    } else {                Assert.assertNull(indexedDoc.get("is_alert"));        Assert.assertFalse(keyPatternExists("threatintels.", indexedDoc));    }        if (keyPatternExists("threatintels.hbaseThreatIntel.", indexedDoc)) {        if (indexedDoc.getOrDefault(SRC_IP, "").equals("10.0.2.3")) {            Assert.assertEquals(indexedDoc.get("threatintels.hbaseThreatIntel." + SRC_IP + "." + MALICIOUS_IP_TYPE), "alert");        } else if (indexedDoc.getOrDefault(DST_IP, "").equals("10.0.2.3")) {            Assert.assertEquals(indexedDoc.get("threatintels.hbaseThreatIntel." + DST_IP + "." + MALICIOUS_IP_TYPE), "alert");        } else {            Assert.fail("There was a threat intels that I did not expect: " + indexedDoc);        }    }}
private static void metron_f4958_0(Map<String, Object> indexedDoc)
{        if (indexedDoc.containsKey("enrichments.geo." + DST_IP + ".location_point")) {        Assert.assertEquals(DEFAULT_LOCATION_POINT, indexedDoc.get("enrichments.geo." + DST_IP + ".location_point"));        Assert.assertEquals(DEFAULT_LONGITUDE, indexedDoc.get("enrichments.geo." + DST_IP + ".longitude"));        Assert.assertEquals(DEFAULT_CITY, indexedDoc.get("enrichments.geo." + DST_IP + ".city"));        Assert.assertEquals(DEFAULT_LATITUDE, indexedDoc.get("enrichments.geo." + DST_IP + ".latitude"));        Assert.assertEquals(DEFAULT_COUNTRY, indexedDoc.get("enrichments.geo." + DST_IP + ".country"));        Assert.assertEquals(DEFAULT_DMACODE, indexedDoc.get("enrichments.geo." + DST_IP + ".dmaCode"));        Assert.assertEquals(DEFAULT_POSTAL_CODE, indexedDoc.get("enrichments.geo." + DST_IP + ".postalCode"));    }    if (indexedDoc.containsKey("enrichments.geo." + SRC_IP + ".location_point")) {        Assert.assertEquals(DEFAULT_LOCATION_POINT, indexedDoc.get("enrichments.geo." + SRC_IP + ".location_point"));        Assert.assertEquals(DEFAULT_LONGITUDE, indexedDoc.get("enrichments.geo." + SRC_IP + ".longitude"));        Assert.assertEquals(DEFAULT_CITY, indexedDoc.get("enrichments.geo." + SRC_IP + ".city"));        Assert.assertEquals(DEFAULT_LATITUDE, indexedDoc.get("enrichments.geo." + SRC_IP + ".latitude"));        Assert.assertEquals(DEFAULT_COUNTRY, indexedDoc.get("enrichments.geo." + SRC_IP + ".country"));        Assert.assertEquals(DEFAULT_DMACODE, indexedDoc.get("enrichments.geo." + SRC_IP + ".dmaCode"));        Assert.assertEquals(DEFAULT_POSTAL_CODE, indexedDoc.get("enrichments.geo." + SRC_IP + ".postalCode"));    }}
private static void metron_f4959_0(Map<String, Object> indexedDoc)
{    boolean enriched = false;        {        Set<String> ips = setOf("10.0.2.15", "10.60.10.254");        if (ips.contains(indexedDoc.get(SRC_IP))) {                        Assert.assertTrue(Predicates.and(HostEnrichments.LOCAL_LOCATION, HostEnrichments.IMPORTANT, HostEnrichments.PRINTER_TYPE).apply(new EvaluationPayload(indexedDoc, SRC_IP)));            enriched = true;        }        if (ips.contains(indexedDoc.get(DST_IP))) {            boolean isEnriched = Predicates.and(HostEnrichments.LOCAL_LOCATION, HostEnrichments.IMPORTANT, HostEnrichments.PRINTER_TYPE).apply(new EvaluationPayload(indexedDoc, DST_IP));            Assert.assertTrue(isEnriched);            enriched = true;        }    }        {        Set<String> ips = setOf("10.1.128.236");        if (ips.contains(indexedDoc.get(SRC_IP))) {                        Assert.assertTrue(Predicates.and(HostEnrichments.LOCAL_LOCATION, HostEnrichments.IMPORTANT, HostEnrichments.WEBSERVER_TYPE).apply(new EvaluationPayload(indexedDoc, SRC_IP)));            enriched = true;        }        if (ips.contains(indexedDoc.get(DST_IP))) {            boolean isEnriched = Predicates.and(HostEnrichments.LOCAL_LOCATION, HostEnrichments.IMPORTANT, HostEnrichments.WEBSERVER_TYPE).apply(new EvaluationPayload(indexedDoc, DST_IP));            Assert.assertTrue(isEnriched);            enriched = true;        }    }    if (!enriched) {        Assert.assertFalse(keyPatternExists("enrichments.host", indexedDoc));    }}
private static boolean metron_f4960_0(String pattern, Map<String, Object> indexedObj)
{    for (String k : indexedObj.keySet()) {        if (k.startsWith(pattern)) {            return true;        }    }    return false;}
private static Set<String> metron_f4961_0(String... items)
{    Set<String> ret = new HashSet<>();    for (String item : items) {        ret.add(item);    }    return ret;}
private static List<Map<String, Object>> metron_f4962_0(List<byte[]> outputMessages)
{    List<Map<String, Object>> tmp = new ArrayList<>();    Iterables.addAll(tmp, Iterables.transform(outputMessages, message -> {        try {            return new HashMap<>(JSONUtils.INSTANCE.load(new String(message, StandardCharsets.UTF_8), JSONUtils.MAP_SUPPLIER));        } catch (Exception ex) {            throw new IllegalStateException(ex);        }    }));    return tmp;}
private KafkaProcessor<Map<String, List<Map<String, Object>>>> metron_f4963_0()
{    return new KafkaProcessor<>().withKafkaComponentName("kafka").withReadTopic(Constants.INDEXING_TOPIC).withErrorTopic(ERROR_TOPIC).withValidateReadMessages(new Function<KafkaMessageSet, Boolean>() {        @Nullable        @Override        public Boolean apply(@Nullable KafkaMessageSet messageSet) {            return (messageSet.getMessages().size() == inputMessages.size()) && (messageSet.getErrors().size() == inputMessages.size());        }    }).withProvideResult(new Function<KafkaMessageSet, Map<String, List<Map<String, Object>>>>() {        @Nullable        @Override        public Map<String, List<Map<String, Object>>> apply(@Nullable KafkaMessageSet messageSet) {            return new HashMap<String, List<Map<String, Object>>>() {                {                    put(Constants.INDEXING_TOPIC, loadMessages(messageSet.getMessages()));                    put(ERROR_TOPIC, loadMessages(messageSet.getErrors()));                }            };        }    });}
public Boolean metron_f4964_0(@Nullable KafkaMessageSet messageSet)
{    return (messageSet.getMessages().size() == inputMessages.size()) && (messageSet.getErrors().size() == inputMessages.size());}
public Map<String, List<Map<String, Object>>> metron_f4965_0(@Nullable KafkaMessageSet messageSet)
{    return new HashMap<String, List<Map<String, Object>>>() {        {            put(Constants.INDEXING_TOPIC, loadMessages(messageSet.getMessages()));            put(ERROR_TOPIC, loadMessages(messageSet.getErrors()));        }    };}
public void metron_f4966_0(byte[] rowKey, ColumnList cols, Durability durability)
{    if (cols.hasColumns()) {        Put put = createPut(rowKey, cols, durability);        mutations.add(put);    }    if (cols.hasCounters()) {        Increment inc = createIncrement(rowKey, cols, durability);        mutations.add(inc);    }    if (mutations.isEmpty()) {        mutations.add(new Put(rowKey));    }}
public void metron_f4967_0(byte[] rowKey, ColumnList cols, Durability durability, Long timeToLiveMillis)
{    if (cols.hasColumns()) {        Put put = createPut(rowKey, cols, durability, timeToLiveMillis);        mutations.add(put);    }    if (cols.hasCounters()) {        Increment inc = createIncrement(rowKey, cols, durability, timeToLiveMillis);        mutations.add(inc);    }    if (mutations.isEmpty()) {        Put put = new Put(rowKey);        put.setTTL(timeToLiveMillis);        mutations.add(put);    }}
public void metron_f4968_0()
{    mutations.clear();}
public int metron_f4969_1()
{    int mutationCount = mutations.size();    Object[] result = new Object[mutationCount];    try {        table.batch(mutations, result);        mutations.clear();    } catch (Exception e) {        String msg = String.format("'%d' HBase write(s) failed on table '%s'", size(mutations), tableName(table));                throw new RuntimeException(msg, e);    }    return mutationCount;}
public void metron_f4970_0(byte[] rowKey, HBaseProjectionCriteria criteria)
{    Get get = new Get(rowKey);    if (criteria != null) {        criteria.getColumnFamilies().forEach(cf -> get.addFamily(cf));        criteria.getColumns().forEach(col -> get.addColumn(col.getColumnFamily(), col.getQualifier()));    }        this.gets.add(get);}
public void metron_f4971_0()
{    gets.clear();}
public Result[] metron_f4972_1()
{    try {        Result[] results = table.get(gets);        gets.clear();        return results;    } catch (Exception e) {        String msg = String.format("'%d' HBase read(s) failed on table '%s'", size(gets), tableName(table));                throw new RuntimeException(msg, e);    }}
public void metron_f4973_0() throws IOException
{    if (table != null) {        table.close();    }}
private Put metron_f4974_0(byte[] rowKey, ColumnList cols, Durability durability)
{    Put put = new Put(rowKey);    put.setDurability(durability);    addColumns(cols, put);    return put;}
private Put metron_f4975_0(byte[] rowKey, ColumnList cols, Durability durability, long timeToLiveMillis)
{    Put put = new Put(rowKey);    put.setDurability(durability);    put.setTTL(timeToLiveMillis);    addColumns(cols, put);    return put;}
private void metron_f4976_0(ColumnList cols, Put put)
{    for (ColumnList.Column col : cols.getColumns()) {        if (col.getTs() > 0) {            put.add(col.getFamily(), col.getQualifier(), col.getTs(), col.getValue());        } else {            put.add(col.getFamily(), col.getQualifier(), col.getValue());        }    }}
private Increment metron_f4977_0(byte[] rowKey, ColumnList cols, Durability durability)
{    Increment inc = new Increment(rowKey);    inc.setDurability(durability);    cols.getCounters().forEach(cnt -> inc.addColumn(cnt.getFamily(), cnt.getQualifier(), cnt.getIncrement()));    return inc;}
private Increment metron_f4978_0(byte[] rowKey, ColumnList cols, Durability durability, long timeToLiveMillis)
{    Increment inc = new Increment(rowKey);    inc.setDurability(durability);    inc.setTTL(timeToLiveMillis);    cols.getCounters().forEach(cnt -> inc.addColumn(cnt.getFamily(), cnt.getQualifier(), cnt.getIncrement()));    return inc;}
private static String metron_f4979_0(Table table)
{    String tableName = "null";    if (table != null) {        if (table.getName() != null) {            tableName = table.getName().getNameAsString();        }    }    return tableName;}
public void metron_f4980_0(String rowKey, String columnFamily, String columnQualifier, String value) throws IOException
{    Put put = new Put(Bytes.toBytes(rowKey));    put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(columnQualifier), Bytes.toBytes(value));    table.put(put);}
public List<String> metron_f4981_0() throws IOException
{    Scan scan = new Scan();    ResultScanner scanner = table.getScanner(scan);    List<String> rows = new ArrayList<>();    for (Result r = scanner.next(); r != null; r = scanner.next()) {        rows.add(Bytes.toString(r.getRow()));    }    return rows;}
public byte[] metron_f4982_0()
{    return family;}
public byte[] metron_f4983_0()
{    return qualifier;}
public byte[] metron_f4984_0()
{    return value;}
public long metron_f4985_0()
{    return ts;}
public long metron_f4986_0()
{    return incr;}
private ArrayList<Column> metron_f4987_0()
{    if (this.columns == null) {        this.columns = new ArrayList<>();    }    return this.columns;}
private ArrayList<Counter> metron_f4988_0()
{    if (this.counters == null) {        this.counters = new ArrayList<>();    }    return this.counters;}
public ColumnList metron_f4989_0(byte[] family, byte[] qualifier, long ts, byte[] value)
{    columns().add(new Column(family, qualifier, ts, value));    return this;}
public ColumnList metron_f4990_0(byte[] family, byte[] qualifier, byte[] value)
{    columns().add(new Column(family, qualifier, -1, value));    return this;}
public ColumnList metron_f4991_0(IColumn column)
{    return this.addColumn(column.family(), column.qualifier(), column.timestamp(), column.value());}
public ColumnList metron_f4992_0(byte[] family, byte[] qualifier, long incr)
{    counters().add(new Counter(family, qualifier, incr));    return this;}
public ColumnList metron_f4993_0(ICounter counter)
{    return this.addCounter(counter.family(), counter.qualifier(), counter.increment());}
public boolean metron_f4994_0()
{    return this.columns != null;}
public boolean metron_f4995_0()
{    return this.counters != null;}
public List<Column> metron_f4996_0()
{    return this.columns;}
public List<Counter> metron_f4997_0()
{    return this.counters;}
public byte[] metron_f4998_0()
{    return columnFamily;}
public byte[] metron_f4999_0()
{    return qualifier;}
public HBaseProjectionCriteria metron_f5000_0(String columnFamily)
{    this.columnFamilies.add(columnFamily.getBytes(StandardCharsets.UTF_8));    return this;}
public HBaseProjectionCriteria metron_f5001_0(ColumnMetaData column)
{    this.columns.add(column);    return this;}
public List<ColumnMetaData> metron_f5002_0()
{    return columns;}
public List<byte[]> metron_f5003_0()
{    return columnFamilies;}
public Connection metron_f5004_0() throws IOException
{    if (conn == null || conn.isClosed()) {        conn = ConnectionFactory.createConnection(config);    }    return conn;}
public Table metron_f5005_0(Configuration config, String tableName) throws IOException
{    return getConnection(config).getTable(TableName.valueOf(tableName));}
private Connection metron_f5006_0(Configuration config) throws IOException
{    ThreadLocal<RetryingConnection> threadLocal = connMap.computeIfAbsent(config, c -> ThreadLocal.withInitial(() -> new RetryingConnection(config)));    return threadLocal.get().getUnderlying();}
public String metron_f5007_0()
{    return tableName;}
public TableConfig metron_f5008_0(String impl)
{    connectorImpl = impl;    return this;}
public TableConfig metron_f5009_0(String table)
{    this.tableName = table;    return this;}
public TableConfig metron_f5010_0(Boolean isBatch)
{    this.batch = isBatch;    return this;}
public String metron_f5011_0()
{    return connectorImpl;}
public boolean metron_f5012_0()
{    return batch;}
public void metron_f5013_0(boolean batch)
{    this.batch = batch;}
public void metron_f5014_0(long writeBufferSize)
{    this.writeBufferSize = writeBufferSize;}
public long metron_f5015_0()
{    return writeBufferSize;}
public Set<String> metron_f5016_0()
{    return this.columnFamilies.keySet();}
 static TableProvider metron_f5017_0(String impl, Supplier<TableProvider> defaultSupplier) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
{    if (impl == null) {        return defaultSupplier.get();    }    Class<? extends TableProvider> clazz = (Class<? extends TableProvider>) Class.forName(impl);    return clazz.getConstructor().newInstance();}
public static void metron_f5018_0() throws Exception
{    Configuration config = HBaseConfiguration.create();    config.set("hbase.master.hostname", "localhost");    config.set("hbase.regionserver.hostname", "localhost");    util = new HBaseTestingUtility(config);    util.startMiniCluster();    admin = util.getHBaseAdmin();        table = util.createTable(Bytes.toBytes(tableName), cf);    util.waitTableEnabled(table.getName());        client = new HBaseClient((c, t) -> table, table.getConfiguration(), tableName);}
public static void metron_f5019_0() throws Exception
{    util.deleteTable(tableName);    util.shutdownMiniCluster();    util.cleanupTestDir();}
public void metron_f5020_0() throws Exception
{    List<Delete> deletions = new ArrayList<>();    for (Result r : table.getScanner(new Scan())) {        deletions.add(new Delete(r.getRow()));    }    table.delete(deletions);}
public void metron_f5021_0() throws Exception
{    rowKey1 = Bytes.toBytes("rowKey1");    cols1 = new ColumnList();    cols1.addColumn(cf, column, value1);    rowKey2 = Bytes.toBytes("rowKey2");    cols2 = new ColumnList();    cols2.addColumn(cf, column, value2);}
public void metron_f5022_0() throws Exception
{        client.addMutation(rowKey1, cols1, Durability.SYNC_WAL);    client.mutate();    HBaseProjectionCriteria criteria = new HBaseProjectionCriteria();    criteria.addColumnFamily(Bytes.toString(cf));        client.addGet(rowKey1, criteria);    Result[] results = client.getAll();    Assert.assertEquals(1, results.length);        assertEquals(1, results.length);    assertArrayEquals(rowKey1, results[0].getRow());    assertArrayEquals(value1, results[0].getValue(cf, column));}
public void metron_f5023_0() throws Exception
{        client.addMutation(rowKey1, cols1, Durability.SYNC_WAL);    client.addMutation(rowKey2, cols2, Durability.SYNC_WAL);    int count = client.mutate();        Assert.assertEquals(2, count);    HBaseProjectionCriteria criteria = new HBaseProjectionCriteria();    criteria.addColumnFamily(Bytes.toString(cf));        client.addGet(rowKey1, criteria);    client.addGet(rowKey2, criteria);    Result[] results = client.getAll();        assertEquals(2, results.length);    assertArrayEquals(rowKey1, results[0].getRow());    assertArrayEquals(value1, results[0].getValue(cf, column));    assertArrayEquals(rowKey1, results[0].getRow());    assertArrayEquals(value2, results[1].getValue(cf, column));}
public void metron_f5024_0() throws Exception
{        int count = client.mutate();    Assert.assertEquals(0, count);    HBaseProjectionCriteria criteria = new HBaseProjectionCriteria();    criteria.addColumnFamily(Bytes.toString(cf));        client.addGet(rowKey1, criteria);    client.addGet(rowKey2, criteria);    Result[] results = client.getAll();        assertEquals(2, results.length);    for (Result result : results) {        Assert.assertTrue(result.isEmpty());    }}
public void metron_f5025_0() throws Exception
{    long timeToLive = TimeUnit.DAYS.toMillis(30);        client.addMutation(rowKey1, cols1, Durability.SYNC_WAL, timeToLive);    client.addMutation(rowKey2, cols2, Durability.SYNC_WAL, timeToLive);    client.mutate();    HBaseProjectionCriteria criteria = new HBaseProjectionCriteria();    criteria.addColumnFamily(Bytes.toString(cf));        client.addGet(rowKey1, criteria);    client.addGet(rowKey2, criteria);    Result[] results = client.getAll();        assertEquals(2, results.length);    assertArrayEquals(rowKey1, results[0].getRow());    assertArrayEquals(value1, results[0].getValue(cf, column));    assertArrayEquals(rowKey1, results[0].getRow());    assertArrayEquals(value2, results[1].getValue(cf, column));}
public void metron_f5026_0() throws Exception
{    long timeToLive = TimeUnit.MILLISECONDS.toMillis(1);        client.addMutation(rowKey1, cols1, Durability.SYNC_WAL, timeToLive);    client.addMutation(rowKey2, cols2, Durability.SYNC_WAL, timeToLive);    client.mutate();    HBaseProjectionCriteria criteria = new HBaseProjectionCriteria();    criteria.addColumnFamily(Bytes.toString(cf));        Thread.sleep(TimeUnit.SECONDS.toMillis(2));        client.addGet(rowKey1, criteria);    client.addGet(rowKey2, criteria);    Result[] results = client.getAll();        assertEquals(2, results.length);    assertTrue(results[0].isEmpty());    assertTrue(results[1].isEmpty());}
public void metron_f5027_0() throws IOException
{        TableProvider tableProvider = mock(TableProvider.class);    when(tableProvider.getTable(any(), any())).thenThrow(new IllegalArgumentException("test exception"));    client = new HBaseClient(tableProvider, HBaseConfiguration.create(), tableName);}
public void metron_f5028_0() throws IOException, InterruptedException
{        Table table = mock(Table.class);    doThrow(new IOException("exception!")).when(table).batch(any(), any());    TableProvider tableProvider = mock(TableProvider.class);    when(tableProvider.getTable(any(), any())).thenReturn(table);    client = new HBaseClient(tableProvider, HBaseConfiguration.create(), tableName);    client.addMutation(rowKey1, cols1, Durability.SYNC_WAL);    client.mutate();}
public void metron_f5029_0() throws IOException
{        Table table = mock(Table.class);    when(table.get(anyListOf(Get.class))).thenThrow(new IOException("exception!"));    TableProvider tableProvider = mock(TableProvider.class);    when(tableProvider.getTable(any(), any())).thenReturn(table);    HBaseProjectionCriteria criteria = new HBaseProjectionCriteria();    criteria.addColumnFamily(Bytes.toString(cf));    client = new HBaseClient(tableProvider, HBaseConfiguration.create(), tableName);    client.addGet(rowKey1, criteria);    client.addGet(rowKey2, criteria);    client.getAll();}
public Table metron_f5030_0(Configuration configuration, String tableName) throws IOException
{    Table ret = _cache.get(tableName);    return ret;}
public static Table metron_f5031_0(String tableName)
{    return _cache.get(tableName);}
public static Table metron_f5032_0(String tableName, String... columnFamilies)
{    MockHTable ret = new MockHTable(tableName, columnFamilies);    _cache.put(tableName, ret);    return ret;}
public static void metron_f5033_0()
{    _cache.clear();}
private static List<KeyValue> metron_f5034_0(byte[] row, NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> rowdata, int maxVersions)
{    return toKeyValue(row, rowdata, 0, Long.MAX_VALUE, maxVersions);}
private static List<KeyValue> metron_f5035_0(byte[] row, NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> rowdata, long timestampStart, long timestampEnd, int maxVersions)
{    List<KeyValue> ret = new ArrayList<KeyValue>();    for (byte[] family : rowdata.keySet()) for (byte[] qualifier : rowdata.get(family).keySet()) {        int versionsAdded = 0;        for (Map.Entry<Long, byte[]> tsToVal : rowdata.get(family).get(qualifier).descendingMap().entrySet()) {            if (versionsAdded++ == maxVersions)                break;            Long timestamp = tsToVal.getKey();            if (timestamp < timestampStart)                continue;            if (timestamp > timestampEnd)                continue;            byte[] value = tsToVal.getValue();            ret.add(new KeyValue(row, family, qualifier, timestamp, value));        }    }    return ret;}
public int metron_f5036_0()
{    return data.size();}
public void metron_f5037_0(String columnFamily)
{    this.columnFamilies.add(columnFamily);    descriptors = new HColumnDescriptor[columnFamilies.size()];    int i = 0;    for (String cf : columnFamilies) {        descriptors[i++] = new HColumnDescriptor(cf);    }}
public byte[] metron_f5038_0()
{    return Bytes.toBytes(tableName);}
public TableName metron_f5039_0()
{    return TableName.valueOf(tableName);}
public Configuration metron_f5040_0()
{    return HBaseConfiguration.create();}
public HTableDescriptor metron_f5041_0() throws IOException
{    HTableDescriptor ret = new HTableDescriptor(tableName);    for (HColumnDescriptor c : descriptors) {        ret.addFamily(c);    }    return ret;}
public boolean metron_f5042_0(Get get) throws IOException
{    if (get.getFamilyMap() == null || get.getFamilyMap().size() == 0) {        return data.containsKey(get.getRow());    } else {        byte[] row = get.getRow();        if (!data.containsKey(row)) {            return false;        }        for (byte[] family : get.getFamilyMap().keySet()) {            if (!data.get(row).containsKey(family)) {                return false;            } else {                return true;            }        }        return true;    }}
public boolean[] metron_f5043_0(List<Get> gets) throws IOException
{    boolean[] ret = new boolean[gets.size()];    int i = 0;    for (boolean b : exists(gets)) {        ret[i++] = b;    }    return ret;}
public Boolean[] metron_f5044_0(List<Get> list) throws IOException
{    Boolean[] ret = new Boolean[list.size()];    int i = 0;    for (Get g : list) {        ret[i++] = exists(g);    }    return ret;}
public void metron_f5045_0(List<? extends Row> list, Object[] objects) throws IOException, InterruptedException
{    Object[] results = batch(list);    System.arraycopy(results, 0, objects, 0, results.length);}
public Object[] metron_f5046_0(List<? extends Row> actions) throws IOException, InterruptedException
{    List<Result> results = new ArrayList<Result>();    for (Row r : actions) {        if (r instanceof Delete) {            delete((Delete) r);            continue;        }        if (r instanceof Put) {            put((Put) r);            continue;        }        if (r instanceof Get) {            results.add(get((Get) r));        }    }    return results.toArray();}
public void metron_f5047_0(List<? extends Row> list, Object[] objects, Batch.Callback<R> callback) throws IOException, InterruptedException
{    throw new UnsupportedOperationException();}
public Object[] metron_f5048_0(List<? extends Row> list, Batch.Callback<R> callback) throws IOException, InterruptedException
{    throw new UnsupportedOperationException();}
public Result metron_f5049_0(Get get) throws IOException
{    if (!data.containsKey(get.getRow()))        return new Result();    byte[] row = get.getRow();    List<KeyValue> kvs = new ArrayList<KeyValue>();    if (!get.hasFamilies()) {        kvs = toKeyValue(row, data.get(row), get.getMaxVersions());    } else {        for (byte[] family : get.getFamilyMap().keySet()) {            if (data.get(row).get(family) == null)                continue;            NavigableSet<byte[]> qualifiers = get.getFamilyMap().get(family);            if (qualifiers == null || qualifiers.isEmpty())                qualifiers = data.get(row).get(family).navigableKeySet();            for (byte[] qualifier : qualifiers) {                if (qualifier == null)                    qualifier = "".getBytes(StandardCharsets.UTF_8);                if (!data.get(row).containsKey(family) || !data.get(row).get(family).containsKey(qualifier) || data.get(row).get(family).get(qualifier).isEmpty())                    continue;                Map.Entry<Long, byte[]> timestampAndValue = data.get(row).get(family).get(qualifier).lastEntry();                kvs.add(new KeyValue(row, family, qualifier, timestampAndValue.getKey(), timestampAndValue.getValue()));            }        }    }    Filter filter = get.getFilter();    if (filter != null) {        filter.reset();        List<KeyValue> nkvs = new ArrayList<KeyValue>(kvs.size());        for (KeyValue kv : kvs) {            if (filter.filterAllRemaining()) {                break;            }            if (filter.filterRowKey(kv.getBuffer(), kv.getRowOffset(), kv.getRowLength())) {                continue;            }            if (filter.filterKeyValue(kv) == Filter.ReturnCode.INCLUDE) {                nkvs.add(kv);            }                }        if (filter.hasFilterRow()) {            filter.filterRow();        }        kvs = nkvs;    }    return new Result(kvs);}
public Result[] metron_f5050_0(List<Get> list) throws IOException
{    Result[] ret = new Result[list.size()];    int i = 0;    for (Get g : list) {        ret[i++] = get(g);    }    return ret;}
public Result metron_f5051_0(byte[] bytes, byte[] bytes1) throws IOException
{    throw new UnsupportedOperationException();}
public ResultScanner metron_f5052_0(Scan scan) throws IOException
{    final List<Result> ret = new ArrayList<Result>();    byte[] st = scan.getStartRow();    byte[] sp = scan.getStopRow();    Filter filter = scan.getFilter();    for (byte[] row : data.keySet()) {                if (st != null && st.length > 0 && Bytes.BYTES_COMPARATOR.compare(st, row) != 0) {                        if (st != null && st.length > 0 && Bytes.BYTES_COMPARATOR.compare(st, row) > 0)                continue;                        if (sp != null && sp.length > 0 && Bytes.BYTES_COMPARATOR.compare(sp, row) <= 0)                break;        }        List<KeyValue> kvs = null;        if (!scan.hasFamilies()) {            kvs = toKeyValue(row, data.get(row), scan.getTimeRange().getMin(), scan.getTimeRange().getMax(), scan.getMaxVersions());        } else {            kvs = new ArrayList<KeyValue>();            for (byte[] family : scan.getFamilyMap().keySet()) {                if (data.get(row).get(family) == null)                    continue;                NavigableSet<byte[]> qualifiers = scan.getFamilyMap().get(family);                if (qualifiers == null || qualifiers.isEmpty())                    qualifiers = data.get(row).get(family).navigableKeySet();                for (byte[] qualifier : qualifiers) {                    if (data.get(row).get(family).get(qualifier) == null)                        continue;                    for (Long timestamp : data.get(row).get(family).get(qualifier).descendingKeySet()) {                        if (timestamp < scan.getTimeRange().getMin())                            continue;                        if (timestamp > scan.getTimeRange().getMax())                            continue;                        byte[] value = data.get(row).get(family).get(qualifier).get(timestamp);                        kvs.add(new KeyValue(row, family, qualifier, timestamp, value));                        if (kvs.size() == scan.getMaxVersions()) {                            break;                        }                    }                }            }        }        if (filter != null) {            filter.reset();            List<KeyValue> nkvs = new ArrayList<KeyValue>(kvs.size());            for (KeyValue kv : kvs) {                if (filter.filterAllRemaining()) {                    break;                }                if (filter.filterRowKey(kv.getBuffer(), kv.getRowOffset(), kv.getRowLength())) {                    continue;                }                Filter.ReturnCode filterResult = filter.filterKeyValue(kv);                if (filterResult == Filter.ReturnCode.INCLUDE) {                    nkvs.add(kv);                } else if (filterResult == Filter.ReturnCode.NEXT_ROW) {                    break;                }                        }            if (filter.hasFilterRow()) {                filter.filterRow();            }            kvs = nkvs;        }        if (!kvs.isEmpty()) {            ret.add(new Result(kvs));        }    }    return new ResultScanner() {        private final Iterator<Result> iterator = ret.iterator();        @Override        public Iterator<Result> iterator() {            return iterator;        }        @Override        public Result[] next(int nbRows) throws IOException {            ArrayList<Result> resultSets = new ArrayList<Result>(nbRows);            for (int i = 0; i < nbRows; i++) {                Result next = next();                if (next != null) {                    resultSets.add(next);                } else {                    break;                }            }            return resultSets.toArray(new Result[resultSets.size()]);        }        @Override        public Result next() throws IOException {            try {                return iterator().next();            } catch (NoSuchElementException e) {                return null;            }        }        @Override        public void close() {        }    };}
public Iterator<Result> metron_f5053_0()
{    return iterator;}
public Result[] metron_f5054_0(int nbRows) throws IOException
{    ArrayList<Result> resultSets = new ArrayList<Result>(nbRows);    for (int i = 0; i < nbRows; i++) {        Result next = next();        if (next != null) {            resultSets.add(next);        } else {            break;        }    }    return resultSets.toArray(new Result[resultSets.size()]);}
public Result metron_f5055_0() throws IOException
{    try {        return iterator().next();    } catch (NoSuchElementException e) {        return null;    }}
public ResultScanner metron_f5057_0(byte[] family) throws IOException
{    Scan scan = new Scan();    scan.addFamily(family);    return getScanner(scan);}
public ResultScanner metron_f5058_0(byte[] family, byte[] qualifier) throws IOException
{    Scan scan = new Scan();    scan.addColumn(family, qualifier);    return getScanner(scan);}
public List<Put> metron_f5059_0()
{    synchronized (putLog) {        return ImmutableList.copyOf(putLog);    }}
public void metron_f5060_0(Put put)
{    synchronized (putLog) {        putLog.add(put);    }}
public void metron_f5061_0()
{    synchronized (putLog) {        putLog.clear();    }    data.clear();}
public void metron_f5062_0(Put put) throws IOException
{    addToPutLog(put);    byte[] row = put.getRow();    NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> rowData = forceFind(data, row, new TreeMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>>(Bytes.BYTES_COMPARATOR));    for (byte[] family : put.getFamilyMap().keySet()) {        NavigableMap<byte[], NavigableMap<Long, byte[]>> familyData = forceFind(rowData, family, new TreeMap<byte[], NavigableMap<Long, byte[]>>(Bytes.BYTES_COMPARATOR));        for (KeyValue kv : put.getFamilyMap().get(family)) {            kv.updateLatestStamp(Bytes.toBytes(System.currentTimeMillis()));            byte[] qualifier = kv.getQualifier();            NavigableMap<Long, byte[]> qualifierData = forceFind(familyData, qualifier, new TreeMap<Long, byte[]>());            qualifierData.put(kv.getTimestamp(), kv.getValue());        }    }}
private V metron_f5063_0(NavigableMap<K, V> map, K key, V newObject)
{    V data = map.get(key);    if (data == null) {        data = newObject;        map.put(key, data);    }    return data;}
public void metron_f5064_0(List<Put> puts) throws IOException
{    for (Put put : puts) put(put);}
public boolean metron_f5065_0(byte[] bytes, byte[] bytes1, byte[] bytes2, byte[] bytes3, Put put) throws IOException
{    throw new UnsupportedOperationException();}
public boolean metron_f5066_0(byte[] row, byte[] family, byte[] qualifier, CompareFilter.CompareOp compareOp, byte[] value, Put put) throws IOException
{    return false;}
public void metron_f5067_0(Delete delete) throws IOException
{    byte[] row = delete.getRow();    if (data.containsKey(row)) {        data.remove(row);    } else {        throw new IOException();    }}
public void metron_f5068_0(List<Delete> list) throws IOException
{    throw new UnsupportedOperationException();}
public boolean metron_f5069_0(byte[] bytes, byte[] bytes1, byte[] bytes2, byte[] bytes3, Delete delete) throws IOException
{    throw new UnsupportedOperationException();}
public boolean metron_f5070_0(byte[] row, byte[] family, byte[] qualifier, CompareFilter.CompareOp compareOp, byte[] value, Delete delete) throws IOException
{    return false;}
public void metron_f5071_0(RowMutations rowMutations) throws IOException
{    throw new UnsupportedOperationException();}
public Result metron_f5072_0(Append append) throws IOException
{    throw new UnsupportedOperationException();}
public Result metron_f5073_0(Increment increment) throws IOException
{    throw new UnsupportedOperationException();}
public long metron_f5074_0(byte[] bytes, byte[] bytes1, byte[] bytes2, long l) throws IOException
{    throw new UnsupportedOperationException();}
public long metron_f5075_0(byte[] bytes, byte[] bytes1, byte[] bytes2, long l, Durability durability) throws IOException
{    throw new UnsupportedOperationException();}
public long metron_f5076_0(byte[] bytes, byte[] bytes1, byte[] bytes2, long l, boolean b) throws IOException
{    throw new UnsupportedOperationException();}
public boolean metron_f5077_0()
{    return autoflush;}
public CoprocessorRpcChannel metron_f5080_0(byte[] bytes)
{    throw new UnsupportedOperationException();}
public Map<byte[], R> metron_f5081_0(Class<T> aClass, byte[] bytes, byte[] bytes1, Batch.Call<T, R> call) throws ServiceException, Throwable
{    throw new UnsupportedOperationException();}
public void metron_f5082_0(Class<T> aClass, byte[] bytes, byte[] bytes1, Batch.Call<T, R> call, Batch.Callback<R> callback) throws ServiceException, Throwable
{    throw new UnsupportedOperationException();}
public void metron_f5083_0(boolean b)
{    autoflush = b;}
public void metron_f5084_0(boolean b, boolean b1)
{    autoflush = b;}
public void metron_f5085_0(boolean b)
{    autoflush = b;}
public long metron_f5086_0()
{    return writeBufferSize;}
public void metron_f5087_0(long l) throws IOException
{    writeBufferSize = l;}
public Map<byte[], R> metron_f5088_0(Descriptors.MethodDescriptor methodDescriptor, Message message, byte[] bytes, byte[] bytes1, R r) throws ServiceException, Throwable
{    throw new UnsupportedOperationException();}
public void metron_f5089_0(Descriptors.MethodDescriptor methodDescriptor, Message message, byte[] bytes, byte[] bytes1, R r, Batch.Callback<R> callback) throws ServiceException, Throwable
{    throw new UnsupportedOperationException();}
public boolean metron_f5090_0(byte[] row, byte[] family, byte[] qualifier, CompareFilter.CompareOp compareOp, byte[] value, RowMutations mutation) throws IOException
{    return false;}
public void metron_f5091_1(CoprocessorEnvironment ce) throws IOException
{        if (ce instanceof RegionCoprocessorEnvironment) {        this.coprocessorEnv = (RegionCoprocessorEnvironment) ce;    } else {        throw new CoprocessorException("Enrichment coprocessor must be loaded on a table region.");    }        if (null == this.cache) {                        String zkUrl = getZookeeperUrl(this.coprocessorEnv.getConfiguration());        if (null == globalConfigService) {            globalConfigService = getGlobalConfigService(zkUrl);        }        globalConfig = globalConfigService.get();        Configuration config = this.coprocessorEnv.getConfiguration();        CacheWriter<String, String> cacheWriter = null;        try {            String hbaseTableProviderName = (String) globalConfig.get(EnrichmentConfigurations.TABLE_PROVIDER);            String tableName = (String) globalConfig.get(EnrichmentConfigurations.TABLE_NAME);            String columnFamily = (String) globalConfig.get(EnrichmentConfigurations.COLUMN_FAMILY);            cacheWriter = new HBaseCacheWriter(config, TableProvider.create(hbaseTableProviderName, HTableProvider::new), tableName, columnFamily, COLUMN_QUALIFIER);        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {            throw new IOException("Unable to instantiate cache writer", e);        }        this.cache = Caffeine.newBuilder().writer(cacheWriter).build();            }    }
private String metron_f5092_0(Configuration config)
{    String zkUrl = config.get(ZOOKEEPER_URL);    if (null == zkUrl) {        throw new IllegalStateException("Enrichment coprocessor requires property '" + ZOOKEEPER_URL + "' to be provided at startup.");    }    return zkUrl;}
private GlobalConfigService metron_f5093_0(String zkUrl)
{    return new GlobalConfigService() {        @Override        public Map<String, Object> get() {            try (CuratorFramework client = ConfigurationsUtils.getClient(zkUrl)) {                client.start();                return ConfigurationsUtils.readGlobalConfigFromZookeeper(client);            } catch (Exception e) {                throw new IllegalStateException("Unable to read global configuration from zookeeper", e);            }        }    };}
public Map<String, Object> metron_f5094_0()
{    try (CuratorFramework client = ConfigurationsUtils.getClient(zkUrl)) {        client.start();        return ConfigurationsUtils.readGlobalConfigFromZookeeper(client);    } catch (Exception e) {        throw new IllegalStateException("Unable to read global configuration from zookeeper", e);    }}
public void metron_f5095_1(ObserverContext<RegionCoprocessorEnvironment> e, Put put, WALEdit edit, Durability durability) throws IOException
{    LOG.trace("enrichment coprocessor postPut call begin");    try {        LOG.trace("Extracting enrichment type from rowkey");        String type = getEnrichmentType(put);                final String metadata = "{}";        LOG.trace("Enrichment type '{}' extracted from rowkey", type);        addToCache(type, metadata);    } catch (Throwable t) {                        throw new IOException("Error occurred while processing enrichment Put.", t);    }    LOG.trace("enrichment coprocessor postPut call complete");}
private String metron_f5096_0(Put put)
{    EnrichmentKey key = new EnrichmentKey();    key.fromBytes(put.getRow());    return key.type;}
private void metron_f5097_0(String cacheKey, String value)
{    LOG.trace("Checking if cacheKey '{}'present in cache", cacheKey);        if (null == cache.getIfPresent(cacheKey)) {        LOG.trace("cacheKey '{}' not present, adding with value='{}' to cache", cacheKey, value);        cache.put(cacheKey, value);        LOG.trace("Done adding cacheKey '{}' to cache with value='{}'", cacheKey, value);    }}
public void metron_f5098_1(@Nonnull String key, @Nonnull String value)
{        try (HBaseClient hbClient = new HBaseClient(this.tableProvider, this.config, this.tableName)) {                hbClient.put(key, columnFamily, columnQualifier, value);            } catch (IOException e) {        throw new RuntimeException("Error writing to HBase table", e);    }    }
public static void metron_f5100_0() throws Exception
{    silenceLogging();        startZookeeper(new Properties());    globalConfig = globalConfig.replace("%TABLE_NAME%", ENRICHMENT_LIST_TABLE).replace("%COLUMN_FAMILY%", COLUMN_FAMILY).replace("%PROVIDER_NAME%", HTableProvider.class.getName());    uploadGlobalConfigToZK(globalConfig);    configureAndStartHBase();    addCoprocessor(enrichmentTable.getName());}
private static void metron_f5101_0()
{    originalLog4jRootLoggerLevel = UnitTestHelper.getLog4jLevel();    originalJavaLoggerLevel = UnitTestHelper.getJavaLoggingLevel();    UnitTestHelper.setLog4jLevel(Level.ERROR);        /*    UnitTestHelper.setLog4jLevel(EnrichmentCoprocessor.class, Level.DEBUG);    UnitTestHelper.setLog4jLevel(HBaseCacheWriter.class, Level.DEBUG);    */    UnitTestHelper.setJavaLoggingLevel(java.util.logging.Level.SEVERE);}
private static void metron_f5102_0(Properties properties) throws UnableToStartException
{    zookeeperComponent = getZKServerComponent(properties);    componentRunner = new ComponentRunner.Builder().withComponent("zk", zookeeperComponent).withMillisecondsBetweenAttempts(15000).withNumRetries(10).build();    componentRunner.start();}
private static void metron_f5103_0(String config) throws Exception
{    ConfigurationsUtils.writeGlobalConfigToZookeeper(config.getBytes(StandardCharsets.UTF_8), zookeeperComponent.getConnectionString());}
private static void metron_f5104_0() throws Exception
{    Configuration extraConfig = new Configuration();    extraConfig.set(EnrichmentCoprocessor.ZOOKEEPER_URL, zookeeperComponent.getConnectionString());    Map.Entry<HBaseTestingUtility, Configuration> kv = HBaseUtil.INSTANCE.create(true, extraConfig);    testUtil = kv.getKey();    hBaseConfig = kv.getValue();    enrichmentTable = testUtil.createTable(Bytes.toBytes(ENRICHMENT_TABLE), Bytes.toBytes(COLUMN_FAMILY));    enrichmentListTable = testUtil.createTable(Bytes.toBytes(ENRICHMENT_LIST_TABLE), Bytes.toBytes(COLUMN_FAMILY));    for (Result r : enrichmentTable.getScanner(Bytes.toBytes(COLUMN_FAMILY))) {        Delete d = new Delete(r.getRow());        enrichmentTable.delete(d);    }    for (Result r : enrichmentListTable.getScanner(Bytes.toBytes(COLUMN_FAMILY))) {        Delete d = new Delete(r.getRow());        enrichmentListTable.delete(d);    }}
private static void metron_f5105_0(TableName tableName) throws IOException
{        Admin hbaseAdmin = testUtil.getConnection().getAdmin();    hbaseAdmin.disableTable(tableName);    HTableDescriptor htd = new HTableDescriptor(tableName);    htd.addFamily(new HColumnDescriptor(COLUMN_FAMILY));    htd.addCoprocessor(EnrichmentCoprocessor.class.getCanonicalName());    hbaseAdmin.modifyTable(tableName, htd);    hbaseAdmin.enableTable(tableName);}
public static void metron_f5106_0() throws Exception
{    HBaseUtil.INSTANCE.teardown(testUtil);    componentRunner.stop();    resetLogging();}
private static void metron_f5107_0()
{    UnitTestHelper.setLog4jLevel(originalLog4jRootLoggerLevel);    UnitTestHelper.setJavaLoggingLevel(originalJavaLoggerLevel);}
public void metron_f5108_0() throws Exception
{        Map<String, String> enrichments = new HashMap<String, String>() {        {            put("111", "foo");            put("222", "foo");            put("333", "bar");            put("444", "bar");            put("555", "baz");            put("666", "baz");        }    };    Set<String> expectedEnrichmentTypes = new HashSet<>();    for (Map.Entry<String, String> enrichKV : enrichments.entrySet()) {        String indicator = enrichKV.getKey();        String type = enrichKV.getValue();        expectedEnrichmentTypes.add(type);        HelperDao.insertRecord(enrichmentTable, new EnrichmentKey(type, indicator), COLUMN_FAMILY, "{ \"apache\" : \"metron\" }");    }    List<String> enrichmentsList = HelperDao.readRecords(enrichmentListTable);    assertThat(new HashSet<String>(enrichmentsList), equalTo(expectedEnrichmentTypes));}
public void metron_f5109_0()
{    MockitoAnnotations.initMocks(this);    cop = new EnrichmentCoprocessor(cacheWriter, globalConfigService);    config = HBaseConfiguration.create();    config.set(EnrichmentCoprocessor.ZOOKEEPER_URL, "foobar");    when(copEnv.getConfiguration()).thenReturn(config);    instantiatedCustomTableProvider = false;}
public void metron_f5110_0() throws Exception
{    cop.start(copEnv);    String[] enrichTypes = new String[] { "foo", "bar", "baz", "metron" };    final int putsPerType = 3;    Map<String, List<Put>> putsByType = simulateMultiplePutsPerType(putsPerType, enrichTypes);    int totalPuts = 0;    for (Map.Entry<String, List<Put>> entry : putsByType.entrySet()) {        String type = entry.getKey();        List<Put> puts = entry.getValue();        for (Put put : puts) {            cop.postPut(observerContext, put, null, null);            verify(cacheWriter, times(1)).write(eq(type), eq("{}"));            totalPuts++;        }    }    assertThat(totalPuts, equalTo(enrichTypes.length * putsPerType));}
private Map<String, List<Put>> metron_f5111_0(int count, String... types)
{    Map<String, List<Put>> putsByType = new HashMap<>();    for (String type : types) {        List<Put> puts = putsByType.getOrDefault(type, new ArrayList<>());        for (int i = 0; i < count; i++) {            EnrichmentKey ek = new EnrichmentKey(type, String.valueOf(i));            puts.add(new Put(ek.toBytes()));            putsByType.put(type, puts);        }    }    return putsByType;}
public Table metron_f5112_0(Configuration config, String tableName) throws IOException
{        return null;}
public void metron_f5113_0() throws Exception
{    cop = new EnrichmentCoprocessor(globalConfigService);    Map<String, Object> globalConfig = new HashMap<String, Object>() {        {            put(EnrichmentConfigurations.TABLE_PROVIDER, TestTableProvider.class.getName());        }    };    when(globalConfigService.get()).thenReturn(globalConfig);    cop.start(copEnv);    assertThat(instantiatedCustomTableProvider, equalTo(true));}
public void metron_f5114_0() throws Exception
{    thrown.expect(IOException.class);    thrown.expectMessage("Error occurred while processing enrichment Put.");    thrown.expectCause(instanceOf(RuntimeException.class));    cop.start(copEnv);    cop.postPut(observerContext, new Put("foo".getBytes(StandardCharsets.UTF_8)), null, null);}
public void metron_f5115_0() throws Exception
{    Throwable cause = new Throwable("Bad things happened.");    thrown.expect(IOException.class);    thrown.expectMessage("Error occurred while processing enrichment Put.");    thrown.expectCause(equalTo(cause));            willAnswer(i -> {        throw cause;    }).given(cacheWriter).write(any(), any());    cop.start(copEnv);    EnrichmentKey ek = new EnrichmentKey("foo", "bar");    cop.postPut(observerContext, new Put(ek.toBytes()), null, null);}
public static void metron_f5116_0(Table table, EnrichmentKey key, String cf, String value) throws IOException
{    Put put = createPut(key, cf, value);    table.put(put);}
private static Put metron_f5117_0(EnrichmentKey rowKey, String cf, String value) throws IOException
{    return new EnrichmentConverter().toPut(cf, rowKey, new EnrichmentValue(JSONUtils.INSTANCE.load(value, JSONUtils.MAP_SUPPLIER)));}
public static List<String> metron_f5118_0(Table table) throws Exception
{    Scan scan = new Scan();    ResultScanner scanner = table.getScanner(scan);    List<String> rows = new ArrayList<>();    for (Result r = scanner.next(); r != null; r = scanner.next()) {        rows.add(Bytes.toString(r.getRow()));    }    return rows;}
public Supplier<Map<String, Object>> metron_f5119_0()
{    return globalConfigSupplier;}
public void metron_f5120_0(Supplier<Map<String, Object>> globalConfigSupplier)
{    this.globalConfigSupplier = globalConfigSupplier;}
public Function<String, String> metron_f5121_0()
{    return indexSupplier;}
public void metron_f5122_0(Function<String, String> indexSupplier)
{    this.indexSupplier = indexSupplier;}
public Integer metron_f5123_0()
{    return maxSearchResults;}
public void metron_f5124_0(Integer maxSearchResults)
{    this.maxSearchResults = maxSearchResults;}
public Integer metron_f5125_0()
{    return maxSearchGroups;}
public void metron_f5126_0(Integer maxSearchGroups)
{    this.maxSearchGroups = maxSearchGroups;}
public Map<String, String> metron_f5127_0()
{    return optionalSettings;}
public void metron_f5128_0(Map<String, String> optionalSettings)
{    this.optionalSettings = optionalSettings;}
public TableProvider metron_f5129_0()
{    return tableProvider;}
public void metron_f5130_0(TableProvider tableProvider)
{    this.tableProvider = tableProvider;}
public Boolean metron_f5131_0()
{    return isKerberosEnabled;}
public void metron_f5132_0(Boolean kerberosEnabled)
{    isKerberosEnabled = kerberosEnabled;}
public String metron_f5133_0()
{    return guid;}
public String metron_f5134_0()
{    return sensorType;}
public static Key metron_f5135_0(byte[] buffer) throws IOException
{    ByteArrayInputStream baos = new ByteArrayInputStream(buffer);    DataInputStream w = new DataInputStream(baos);    baos.skip(KeyUtil.HASH_PREFIX_SIZE);    return new Key(w.readUTF(), w.readUTF());}
public byte[] metron_f5136_0() throws IOException
{    ByteArrayOutputStream baos = new ByteArrayOutputStream();    if (getGuid() == null || getSensorType() == null) {        throw new IllegalStateException("Guid and sensor type must not be null: guid = " + getGuid() + ", sensorType = " + getSensorType());    }    DataOutputStream w = new DataOutputStream(baos);    w.writeUTF(getGuid());    w.writeUTF(getSensorType());    w.flush();    byte[] key = baos.toByteArray();    byte[] prefix = KeyUtil.INSTANCE.getPrefix(key);    return KeyUtil.INSTANCE.merge(prefix, key);}
public static byte[] metron_f5137_0(Key k) throws IOException
{    return k.toBytes();}
public boolean metron_f5138_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    Key key = (Key) o;    if (getGuid() != null ? !getGuid().equals(key.getGuid()) : key.getGuid() != null)        return false;    return getSensorType() != null ? getSensorType().equals(key.getSensorType()) : key.getSensorType() == null;}
public int metron_f5139_0()
{    int result = getGuid() != null ? getGuid().hashCode() : 0;    result = 31 * result + (getSensorType() != null ? getSensorType().hashCode() : 0);    return result;}
public synchronized SearchResponse metron_f5140_0(SearchRequest searchRequest) throws InvalidSearchException
{    return null;}
public GroupResponse metron_f5141_0(GroupRequest groupRequest) throws InvalidSearchException
{    return null;}
public synchronized void metron_f5142_0(AccessConfig config)
{    if (this.tableInterface == null) {        this.config = config;        Map<String, Object> globalConfig = config.getGlobalConfigSupplier().get();        if (globalConfig == null) {            throw new IllegalStateException("Cannot find the global config.");        }        String table = (String) globalConfig.get(HBASE_TABLE);        String cf = (String) config.getGlobalConfigSupplier().get().get(HBASE_CF);        if (table == null || cf == null) {            throw new IllegalStateException("You must configure " + HBASE_TABLE + " and " + HBASE_CF + " in the global config.");        }        try {            tableInterface = config.getTableProvider().getTable(HBaseConfiguration.create(), table);            this.cf = cf.getBytes(StandardCharsets.UTF_8);        } catch (IOException e) {            throw new IllegalStateException("Unable to initialize HBaseDao: " + e.getMessage(), e);        }    }}
public Table metron_f5143_0()
{    if (tableInterface == null) {        init(config);    }    return tableInterface;}
public synchronized Document metron_f5144_0(String guid, String sensorType) throws IOException
{    Key k = new Key(guid, sensorType);    Get get = new Get(Key.toBytes(k));    get.addFamily(cf);    Result result = getTableInterface().get(get);    return getDocumentFromResult(result);}
public Iterable<Document> metron_f5145_0(List<GetRequest> getRequests) throws IOException
{    List<Get> gets = new ArrayList<>();    for (GetRequest getRequest : getRequests) {        gets.add(buildGet(getRequest));    }    Result[] results = getTableInterface().get(gets);    List<Document> allLatest = new ArrayList<>();    for (Result result : results) {        Document d = getDocumentFromResult(result);        if (d != null) {            allLatest.add(d);        }    }    return allLatest;}
private Document metron_f5146_0(Result result) throws IOException
{    NavigableMap<byte[], byte[]> columns = result.getFamilyMap(cf);    if (columns == null || columns.size() == 0) {        return null;    }    Map.Entry<byte[], byte[]> entry = columns.lastEntry();    Long ts = Bytes.toLong(entry.getKey());    if (entry.getValue() != null) {        Map<String, Object> json = JSONUtils.INSTANCE.load(new String(entry.getValue(), StandardCharsets.UTF_8), JSONUtils.MAP_SUPPLIER);                @SuppressWarnings("unchecked")        List<Map<String, Object>> commentsMap = (List<Map<String, Object>>) json.get(COMMENTS_FIELD);        try {            if (commentsMap != null) {                List<AlertComment> comments = new ArrayList<>();                for (Map<String, Object> commentMap : commentsMap) {                    comments.add(new AlertComment(commentMap));                }                if (comments.size() > 0) {                    json.put(COMMENTS_FIELD, comments.stream().map(AlertComment::asMap).collect(Collectors.toList()));                }            }            Key k = Key.fromBytes(result.getRow());            return new Document(json, k.getGuid(), k.getSensorType(), ts);        } catch (IOException e) {            throw new RuntimeException("Unable to convert row key to a document", e);        }    } else {        return null;    }}
public synchronized Document metron_f5147_0(Document update, Optional<String> index) throws IOException
{    Put put = buildPut(update);    getTableInterface().put(put);    return update;}
public Map<Document, Optional<String>> metron_f5148_0(Map<Document, Optional<String>> updates) throws IOException
{    List<Put> puts = new ArrayList<>();    for (Map.Entry<Document, Optional<String>> updateEntry : updates.entrySet()) {        Document update = updateEntry.getKey();        Put put = buildPut(update);        puts.add(put);    }    getTableInterface().put(puts);    return updates;}
protected Get metron_f5149_0(GetRequest getRequest) throws IOException
{    Key k = new Key(getRequest.getGuid(), getRequest.getSensorType());    Get get = new Get(Key.toBytes(k));    get.addFamily(cf);    return get;}
protected Put metron_f5150_0(Document update) throws IOException
{    Key k = new Key(update.getGuid(), update.getSensorType());    Put put = new Put(Key.toBytes(k));    long ts = update.getTimestamp() == null || update.getTimestamp() == 0 ? System.currentTimeMillis() : update.getTimestamp();    byte[] columnQualifier = Bytes.toBytes(ts);    byte[] doc = JSONUtils.INSTANCE.toJSONPretty(update.getDocument());    put.addColumn(cf, columnQualifier, doc);    return put;}
public Map<String, FieldType> metron_f5151_0(List<String> indices) throws IOException
{    return null;}
public Document metron_f5152_0(CommentAddRemoveRequest request) throws IOException
{    Document latest = getLatest(request.getGuid(), request.getSensorType());    return addCommentToAlert(request, latest);}
public Document metron_f5153_0(CommentAddRemoveRequest request, Document latest) throws IOException
{    if (latest == null || latest.getDocument() == null) {        throw new IOException(String.format("Unable to add comment. Document with guid %s cannot be found.", request.getGuid()));    }    List<Map<String, Object>> comments = (List<Map<String, Object>>) latest.getDocument().getOrDefault(COMMENTS_FIELD, new ArrayList<>());    List<Map<String, Object>> originalComments = new ArrayList<>(comments);        List<Map<String, Object>> commentsMap = new ArrayList<>();    for (Map<String, Object> comment : originalComments) {        commentsMap.add(new AlertComment(comment).asMap());    }    commentsMap.add(new AlertComment(request.getComment(), request.getUsername(), request.getTimestamp()).asMap());    Document newVersion = new Document(latest);    newVersion.getDocument().put(COMMENTS_FIELD, commentsMap);    return update(newVersion, Optional.empty());}
public Document metron_f5154_0(CommentAddRemoveRequest request) throws IOException
{    Document latest = getLatest(request.getGuid(), request.getSensorType());    return removeCommentFromAlert(request, latest);}
public Document metron_f5155_0(CommentAddRemoveRequest request, Document latest) throws IOException
{    if (latest == null || latest.getDocument() == null) {        throw new IOException(String.format("Unable to remove comment. Document with guid %s cannot be found.", request.getGuid()));    }    List<Map<String, Object>> commentMap = (List<Map<String, Object>>) latest.getDocument().get(COMMENTS_FIELD);        if (commentMap == null) {        throw new IOException(String.format("Unable to remove comment. Document with guid %s has no comments.", request.getGuid()));    }    List<Map<String, Object>> originalComments = new ArrayList<>(commentMap);    List<AlertComment> comments = new ArrayList<>();    for (Map<String, Object> commentStr : originalComments) {        comments.add(new AlertComment(commentStr));    }    comments.remove(new AlertComment(request.getComment(), request.getUsername(), request.getTimestamp()));    Document newVersion = new Document(latest);    if (comments.size() > 0) {        List<Map<String, Object>> commentsAsMap = comments.stream().map(AlertComment::asMap).collect(Collectors.toList());        newVersion.getDocument().put(COMMENTS_FIELD, commentsAsMap);        update(newVersion, Optional.empty());    } else {        newVersion.getDocument().remove(COMMENTS_FIELD);    }    return update(newVersion, Optional.empty());}
public static List<IndexDao> metron_f5156_0(String daoImpls, AccessConfig config) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
{    List<IndexDao> ret = new ArrayList<>();    for (String daoImpl : Splitter.on(",").split(daoImpls)) {        Class<? extends IndexDao> clazz = (Class<? extends IndexDao>) Class.forName(daoImpl);        IndexDao instance = clazz.getConstructor().newInstance();        instance.init(config);        ret.add(instance);    }    return ret;}
public static IndexDao metron_f5157_0(Iterable<IndexDao> daos) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
{    return combine(daos, x -> x);}
public static IndexDao metron_f5158_0(Iterable<IndexDao> daos, Function<IndexDao, IndexDao> daoTransformation) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
{    int numDaos = Iterables.size(daos);    if (numDaos == 0) {        throw new IllegalArgumentException("Trying to combine 0 dao's into a DAO is not a supported configuration.");    }    if (numDaos == 1) {        return daoTransformation.apply(Iterables.getFirst(daos, null));    }    return new MultiIndexDao(daos, daoTransformation);}
 String metron_f5159_0()
{    return MetaAlertConstants.THREAT_FIELD_DEFAULT;}
 String metron_f5160_0()
{    return MetaAlertConstants.THREAT_SORT_DEFAULT;}
public UpdateDao metron_f5161_0()
{    return updateDao;}
public MetaAlertRetrieveLatestDao metron_f5162_0()
{    return retrieveLatestDao;}
public MetaAlertConfig metron_f5163_0()
{    return config;}
public Document metron_f5164_0(RetrieveLatestDao retrieveLatestDao, PatchRequest request, Optional<Long> timestamp) throws OriginalNotFoundException, IOException
{    if (isPatchAllowed(request)) {        return updateDao.patch(retrieveLatestDao, request, timestamp);    } else {        throw new IllegalArgumentException("Meta alert patches are not allowed for /alert or /status paths.  " + "Please use the add/remove alert or update status functions instead.");    }}
public Map<Document, Optional<String>> metron_f5165_0(Map<Document, Optional<String>> updates)
{    throw new UnsupportedOperationException("Meta alerts do not allow for bulk updates");}
protected Document metron_f5166_0(Iterable<Document> alerts, List<String> groups, String alertField)
{        Map<String, Object> metaSource = new HashMap<>();    List<Map<String, Object>> alertList = new ArrayList<>();    for (Document alert : alerts) {        alertList.add(alert.getDocument());    }    metaSource.put(alertField, alertList);        String guid = UUID.randomUUID().toString();    metaSource.put(GUID, guid);    metaSource.put(Constants.Fields.TIMESTAMP.getName(), System.currentTimeMillis());    metaSource.put(MetaAlertConstants.GROUPS_FIELD, groups);    metaSource.put(MetaAlertConstants.STATUS_FIELD, MetaAlertStatus.ACTIVE.getStatusString());    return new Document(metaSource, guid, MetaAlertConstants.METAALERT_TYPE, System.currentTimeMillis());}
protected Map<Document, Optional<String>> metron_f5167_0(Document metaAlert, Iterable<Document> alerts) throws IOException
{    Map<Document, Optional<String>> updates = new HashMap<>();    List<String> alertGuids = new ArrayList<>();    for (Document alert : alerts) {        alertGuids.add(alert.getGuid());    }    List<Map<String, Object>> alertsBefore = new ArrayList<>();    Map<String, Object> documentBefore = metaAlert.getDocument();    if (documentBefore.containsKey(MetaAlertConstants.ALERT_FIELD)) {        alertsBefore.addAll((List<Map<String, Object>>) documentBefore.get(MetaAlertConstants.ALERT_FIELD));    }    boolean metaAlertUpdated = removeAlertsFromMetaAlert(metaAlert, alertGuids);    if (metaAlertUpdated) {        List<Map<String, Object>> alertsAfter = (List<Map<String, Object>>) metaAlert.getDocument().get(MetaAlertConstants.ALERT_FIELD);        if (alertsAfter.size() < alertsBefore.size() && alertsAfter.size() == 0) {            throw new IllegalStateException("Removing these alerts will result in an empty meta alert.  Empty meta alerts are not allowed.");        }        MetaScores.calculateMetaScores(metaAlert, config.getThreatTriageField(), config.getThreatSort());        updates.put(metaAlert, Optional.of(config.getMetaAlertIndex()));        for (Document alert : alerts) {            if (removeMetaAlertFromAlert(metaAlert.getGuid(), alert)) {                updates.put(alert, Optional.empty());            }        }    }    return updates;}
public Document metron_f5168_0(String metaAlertGuid, List<GetRequest> alertRequests) throws IOException
{    Document metaAlert = retrieveLatestDao.getLatest(metaAlertGuid, MetaAlertConstants.METAALERT_TYPE);    if (metaAlert == null) {        throw new IOException(String.format("Unable to add alerts to meta alert.  Meta alert with guid %s cannot be found.", metaAlertGuid));    }    if (MetaAlertStatus.ACTIVE.getStatusString().equals(metaAlert.getDocument().get(MetaAlertConstants.STATUS_FIELD))) {        Iterable<Document> alerts = retrieveLatestDao.getAllLatest(alertRequests);        Set<String> missingAlerts = getMissingAlerts(alertRequests, alerts);        if (!missingAlerts.isEmpty()) {            throw new IOException(String.format("Unable to add alerts to meta alert.  Alert with guid %s cannot be found.", missingAlerts.iterator().next()));        }        Map<Document, Optional<String>> updates = buildAddAlertToMetaAlertUpdates(metaAlert, alerts);        update(updates);        return metaAlert;    } else {        throw new IllegalStateException("Adding alerts to an INACTIVE meta alert is not allowed");    }}
public Document metron_f5169_0(String metaAlertGuid, List<GetRequest> alertRequests) throws IOException, IllegalStateException
{    Document metaAlert = retrieveLatestDao.getLatest(metaAlertGuid, MetaAlertConstants.METAALERT_TYPE);    if (metaAlert == null) {        throw new IOException(String.format("Unable to remove alerts from meta alert.  Meta alert with guid %s cannot be found.", metaAlertGuid));    }    if (MetaAlertStatus.ACTIVE.getStatusString().equals(metaAlert.getDocument().get(MetaAlertConstants.STATUS_FIELD))) {        Iterable<Document> alerts = retrieveLatestDao.getAllLatest(alertRequests);        Set<String> missingAlerts = getMissingAlerts(alertRequests, alerts);        if (!missingAlerts.isEmpty()) {            throw new IOException(String.format("Unable to remove alerts from meta alert.  Alert with guid %s cannot be found.", missingAlerts.iterator().next()));        }        Map<Document, Optional<String>> updates = buildRemoveAlertsFromMetaAlert(metaAlert, alerts);        update(updates);        return metaAlert;    } else {        throw new IllegalStateException("Removing alerts from an INACTIVE meta alert is not allowed");    }}
protected boolean metron_f5170_0(Document metaAlert, Collection<String> alertGuids)
{        if (!metaAlert.getDocument().containsKey(MetaAlertConstants.ALERT_FIELD) || alertGuids.size() == 0) {        return false;    }    @SuppressWarnings("unchecked")    List<Map<String, Object>> currentAlerts = (List<Map<String, Object>>) metaAlert.getDocument().get(MetaAlertConstants.ALERT_FIELD);    int previousSize = currentAlerts.size();        currentAlerts.removeIf(currentAlert -> alertGuids.contains(currentAlert.get(GUID)));    return currentAlerts.size() != previousSize;}
