@Test
public void testGeoHashValue() throws Exception {
    String mapping = XContentFactory.jsonBuilder()
            .startObject().startObject("type")
            .startObject("properties").startObject("point")
            .field("type", "geo_point").field("lat_lon", true)
            .field("geohash", true).endObject().endObject()
            .endObject().endObject().string();

    DocumentMapper defaultMapper
    = createIndex("test").mapperService().documentMapperParser().parse(mapping);

    ParsedDocument doc = defaultMapper.parse("type", "1", XContentFactory
            .jsonBuilder()
            .startObject()
            .field("point", GeoHashUtils.encode(1.2, 1.3))
            .endObject()
            .bytes());

    assertThat(doc.rootDoc().getField("point.lat"), notNullValue());
    assertThat(doc.rootDoc().getField("point.lon"), notNullValue());
    assertThat(doc.rootDoc().get("point.geohash"),
        equalTo(GeoHashUtils.encode(1.2, 1.3)));
}
