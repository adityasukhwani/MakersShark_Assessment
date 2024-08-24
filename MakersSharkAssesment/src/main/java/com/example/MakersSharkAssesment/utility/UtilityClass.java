package com.example.MakersSharkAssesment.utility;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UtilityClass {
    public static String getSql(String sqlFileName, String sqlKey) throws IOException { // u can remove the sqlkey
        ClassPathResource resource = new ClassPathResource(sqlFileName);
        String sql = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        System.out.println("RAW SQL: " + sql);
        return sql;
    }
}
