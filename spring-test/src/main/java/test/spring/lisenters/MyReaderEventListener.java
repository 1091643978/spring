package test.spring.lisenters;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.parsing.AliasDefinition;
import org.springframework.beans.factory.parsing.ComponentDefinition;
import org.springframework.beans.factory.parsing.DefaultsDefinition;
import org.springframework.beans.factory.parsing.ImportDefinition;
import org.springframework.beans.factory.parsing.ReaderEventListener;
import org.springframework.beans.factory.xml.DocumentDefaultsDefinition;

/**
 * @author: liubo
 * @date: 2019-10-24 18:39
 * @description:
 **/
public class MyReaderEventListener implements ReaderEventListener {
//    Logger log = LoggerFactory.getLogger(MyReaderEventListener.class);
    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public void defaultsRegistered(DefaultsDefinition defaultsDefinition) {
        DocumentDefaultsDefinition defaults = (DocumentDefaultsDefinition) defaultsDefinition;
        System.out.println("Default attributes registered: "
                + "autowire: " + defaults.getAutowire() + ", "
                + "autowire-candidats: " + defaults.getAutowireCandidates() + ", "
                + "destroy-method: " + defaults.getDestroyMethod() + ", "
                + "init-method: " + defaults.getInitMethod() + ", "
                + "lazy-init: " + defaults.getLazyInit() + ", "
                + "merge: " + defaults.getMerge());
    }
    @Override
    public void componentRegistered(ComponentDefinition componentDefinition) {
        logger.info("---event----");
        System.out.println("Component Registered: "
                + componentDefinition.getName());
    }

    @Override
    public void aliasRegistered(AliasDefinition aliasDefinition) {
        System.out.println("Alias Registered: " + aliasDefinition.getAlias());
    }

    @Override
    public void importProcessed(ImportDefinition importDefinition) {
        System.out.println("Import processed: "
                + importDefinition.getImportedResource());
    }
}
