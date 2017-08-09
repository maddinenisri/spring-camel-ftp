package com.mdstech.sample.filters;

import org.apache.camel.component.file.GenericFile;
import org.apache.camel.component.file.GenericFileFilter;
import org.springframework.stereotype.Component;

/**
 * Created by srini on 8/8/17.
 */
@Component("textFileFilter")
public class TextFileFilter<T> implements GenericFileFilter<T> {
    @Override
    public boolean accept(GenericFile<T> file) {
        return file.getFileName().endsWith("txt");
    }
}
