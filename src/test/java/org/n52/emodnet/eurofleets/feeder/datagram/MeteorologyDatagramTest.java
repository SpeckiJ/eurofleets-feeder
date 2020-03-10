package org.n52.emodnet.eurofleets.feeder.datagram;

import org.junit.jupiter.api.Test;
import org.n52.emodnet.eurofleets.feeder.ObservedProperties;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MeteorologyDatagramTest {

    @Test
    public void testParse() throws DatagramParseException {
        final MeteorologyDatagram parse = new MeteorologyDatagram("$PSDGMET,20160505,003250,5.30,5.98,5.38,16.77,103.20,0.00,1014.66,17.4");

        assertThat(parse.getDateTime(), is(OffsetDateTime
                                                   .of(2016, 5, 5, 0, 32, 50, 0, ZoneOffset.UTC)));
        assertThat(parse.getValue(ObservedProperties.WIND_MEAN), is(5.3));
        assertThat(parse.getValue(ObservedProperties.WIND_GUST), is(5.98));
        assertThat(parse.getValue(ObservedProperties.WIND_DIRECTION), is(5.38));
        assertThat(parse.getValue(ObservedProperties.AIR_TEMPERATURE), is(16.77));
        assertThat(parse.getValue(ObservedProperties.HUMIDITY), is(103.20));
        assertThat(parse.getValue(ObservedProperties.SOLAR_RADIATION), is(0.0));
        assertThat(parse.getValue(ObservedProperties.PRESSURE), is(1014.660));

    }
}