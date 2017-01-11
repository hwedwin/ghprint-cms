package com.ghprint.cms.utils;

import com.google.common.collect.ImmutableMap;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

/**
 * Author:  <a href="mailto:jlchen.cn@gmail.com">jlchen</a>
 * Date: 2013-04-02
 */
public class XMLMapper {
    private static final XStream cardXStream = new XStream();

    private static final XStream smsXStream = new XStream();

    static {
        MapEntryConverter converter = new MapEntryConverter();

        cardXStream.aliasType("RESULT", Map.class);
        cardXStream.registerConverter(converter);

        smsXStream.aliasType("smsMt", Map.class);
        smsXStream.registerConverter(converter);
    }

    @SuppressWarnings("unchecked")
    public static <T> T cardFromXML(String xml) {
        return (T) cardXStream.fromXML(xml);
    }

    public static String smsToXML(Map<String, String> input) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
            smsXStream.toXML(input, writer);
            String xml = outputStream.toString("UTF-8");
            writer.close();
            return xml;
        } catch (IOException e) {
            throw new RuntimeException("serialize to xml failed", e);
        }
    }

    public static class MapEntryConverter implements Converter {
        public boolean canConvert(Class clazz) {
            return Map.class.isAssignableFrom(clazz);
        }

        @SuppressWarnings("unchecked")
        public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
            Map<String, String> map = (Map<String, String>) value;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.startNode(entry.getKey());
                writer.setValue(entry.getValue());
                writer.endNode();
            }
        }

        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();

            while (reader.hasMoreChildren()) {
                reader.moveDown();
                builder.put(reader.getNodeName(), reader.getValue());
                reader.moveUp();
            }
            return builder.build();
        }
    }
}
