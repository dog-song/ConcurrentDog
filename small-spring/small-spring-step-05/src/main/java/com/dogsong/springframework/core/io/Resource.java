package com.dogsong.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/11/24
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
