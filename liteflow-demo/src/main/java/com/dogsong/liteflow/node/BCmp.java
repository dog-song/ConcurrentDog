package com.dogsong.liteflow.node;

import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * ACmp
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/12/14
 */
@Slf4j
@Component("b")
public class BCmp extends NodeComponent {

    @Override
    public void process() throws Exception {
        System.out.println("bbb");
        log.info("--- bbb");
    }
}
