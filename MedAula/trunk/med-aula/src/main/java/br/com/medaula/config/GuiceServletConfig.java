package br.com.medaula.config;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import br.com.medaula.resource.CommonsResource;
import br.com.medaula.resource.LugarResource;
import br.com.medaula.resource.TweetResource;
import br.com.medaula.resource.UsuarioResource;
import br.com.medaula.resource.VotoResource;

public class GuiceServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {

                install(new JpaPersistModule("medaula"));
                filter("/*").through(PersistFilter.class);

                bind(UsuarioResource.class);
                bind(LugarResource.class);
                bind(TweetResource.class);
                bind(VotoResource.class);
                bind(CommonsResource.class);

                Map<String, String> params = new HashMap<String, String>();
                params.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
                serve("/rest/*").with(GuiceContainer.class, params);

            }
        });
    }

}
