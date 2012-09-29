package com.palthomassen.synnedata.synnedata;

import com.palthomassen.synnedata.Storage.ShitRankingStorage;
import com.palthomassen.synnedata.Storage.TemperatureMeasurementStorage;
import com.palthomassen.synnedata.health.ShitRankingHealthCheck;
import com.palthomassen.synnedata.representations.ShitMeasurement;
import com.palthomassen.synnedata.representations.ShitRanking;
import com.palthomassen.synnedata.representations.TemperatureMeasurement;
import com.palthomassen.synnedata.health.TemperatureMeasurementHealthCheck;
import com.palthomassen.synnedata.resources.HTMLView;
import com.palthomassen.synnedata.resources.ShitRankingResource;
import com.palthomassen.synnedata.resources.TemperatureResource;
import com.palthomassen.synnedata.synnedataConfiguration.SynneDataConfiguration;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;

import java.util.ArrayList;

public class SynneDataService extends Service<SynneDataConfiguration> {

    public static void main(String[] args) throws Exception {
        new SynneDataService().run(args);
    }

    public SynneDataService() {
        super("SynneData");
        addBundle(new ViewBundle());
    }

    @Override
    protected void initialize(SynneDataConfiguration configuration,
                              Environment environment) {

        environment.addResource(new HTMLView());

        environment.addResource(new TemperatureResource(
                new TemperatureMeasurementStorage(new ArrayList<TemperatureMeasurement>())));
        environment.addHealthCheck(new TemperatureMeasurementHealthCheck(new TemperatureMeasurementStorage(new ArrayList<TemperatureMeasurement>())));

        environment.addResource(new ShitRankingResource(new ShitRankingStorage(new ArrayList<ShitMeasurement>())));
        environment.addHealthCheck(new ShitRankingHealthCheck(new ShitRankingStorage(new ArrayList<ShitMeasurement>())));

}


}
