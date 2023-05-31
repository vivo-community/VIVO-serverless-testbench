package edu.cornell.mannlib.vitro.webapp.controller.json;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.cornell.mannlib.vitro.webapp.controller.VitroRequest;
import edu.cornell.mannlib.vitro.webapp.startup.StartupManager;
import edu.cornell.mannlib.vitro.webapp.startup.StartupStatus;
import stubs.javax.servlet.ServletContextStub;
import stubs.javax.servlet.http.HttpServletRequestStub;
import stubs.javax.servlet.http.HttpServletResponseStub;
import stubs.javax.servlet.http.HttpSessionStub;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GetRenderedSearchIndividualsByVClassTest {
    private static final Log log = LogFactory.getLog(GetRenderedSearchIndividualsByVClass.class);
    private static ServletContextStub ctx;
    private static ServletContextEvent sce;
    private static VitroRequest vreq;
    private static HttpSessionStub session;
    private static HttpServletRequestStub hreq;
    private static StartupManager sm;
    private static StartupStatus ss;
    private static ArrayList<String> irisList;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("vitro.home", (new File("src/main/resources")).getAbsolutePath() + "/vivo/home");
        ctx = new ServletContextStub();
        sm = new StartupManager();
        sce = new ServletContextEvent(ctx);
        ss = StartupStatus.getBean(ctx);
        session = new HttpSessionStub();
        session.setServletContext(ctx);
//        sm.contextInitialized(sce, false);
        sm.contextInitialized(sce);
    }

    private String vClass;
    

    private void buildOrganisationList() {
        vClass = "http://vivoweb.org/ontology/core#AcademicDepartment";
        irisList = new ArrayList<>();
        irisList.add("http://vivo-demo.uqam.ca/individual/n2350");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2360");
        irisList.add("http://localhost:8080/vivo_i18n/individual/n4085");
        irisList.add("http://localhost:8080/vivo_i18n/individual/n7257");
        irisList.add("http://vivo-demo.uqam.ca/individual/n6324");
        irisList.add("http://vivo-demo.uqam.ca/individual/n5951");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2223");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2450");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2080");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2110");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2310");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2120");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2050");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2100");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2060");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2340");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2013");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2430");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2040");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2090");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2140");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2350");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2440");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2360");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2012");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2390");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2150");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2080");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2310");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2290");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2160");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2050");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2180");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2060");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2340");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2430");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2040");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2090");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2140");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2440");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2230");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2012");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2390");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2240");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2150");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2160");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2180");
    }

    private void buildResearchList() {
        vClass = "http://purl.org/ontology/bibo/AcademicArticle";
        irisList = new ArrayList<>();
        irisList.add("http://vivo-demo.uqam.ca/individual/n85825a16-53ab-3f8f-8ed3-8a237ababce6");
        irisList.add("http://vivo-demo.uqam.ca/individual/n9d980958-429b-3bff-8699-66044be0dff7");
        irisList.add("http://vivo-demo.uqam.ca/individual/ee82088b-f887-3ad4-9fa7-0612b35d78eb");
        irisList.add("http://vivo-demo.uqam.ca/individual/a5b431e2-53c1-3b77-b9b7-e4c72400deb7");
        irisList.add("http://vivo-demo.uqam.ca/individual/n91efdf06-08a2-3126-9e48-1fb53b30c2c0");
        irisList.add("http://vivo-demo.uqam.ca/individual/ce0260c5-20db-30a8-b259-f022129a57aa");
        irisList.add("http://vivo-demo.uqam.ca/individual/ad1ccc9b-341f-39b6-b44f-226372a39078");
        irisList.add("http://vivo-demo.uqam.ca/individual/ed6a11db-60f2-3dad-9cbc-a542ebc3756e");
        irisList.add("http://vivo-demo.uqam.ca/individual/b0be4aa0-bb0d-307b-a217-190323fe41c1");
        irisList.add("http://vivo-demo.uqam.ca/individual/d8f11997-b668-3036-9e34-5fb5b627afbb");
        irisList.add("http://vivo-demo.uqam.ca/individual/n1e246183-a389-3cb7-89ff-2661ec17d7d6");
        irisList.add("http://vivo-demo.uqam.ca/individual/n2e9d3776-4b92-3a34-bc05-45a73269a7d3");
        irisList.add("http://vivo-demo.uqam.ca/individual/n9e568619-6170-3246-8b89-19e2df6ce7cf");
        irisList.add("http://vivo-demo.uqam.ca/individual/n7509b1f1-6545-36c0-9549-bfc6729b2cb2");
        irisList.add("http://vivo-demo.uqam.ca/individual/n7fb66e7c-ddfc-3606-a5a7-1808e1e17e86");
        irisList.add("http://vivo-demo.uqam.ca/individual/n0d1e1204-6544-3301-8bbb-9337c0457c7b");
        irisList.add("http://vivo-demo.uqam.ca/individual/n99775fb8-cf80-3021-be45-137ea0039bd1");
        irisList.add("http://vivo-demo.uqam.ca/individual/n19a7b11b-33a6-31d2-ae41-d922fb2f69d9");
        irisList.add("http://vivo-demo.uqam.ca/individual/n319a3b31-fbc6-30fd-986e-715195f81290");
        irisList.add("http://vivo-demo.uqam.ca/individual/n12bf0c80-9211-34ce-9e24-d5d2b6116021");
        irisList.add("http://vivo-demo.uqam.ca/individual/n7b64eaa0-fd75-3ea4-aafe-c1fa5454ce5d");
        irisList.add("http://vivo-demo.uqam.ca/individual/fa5bcbe8-a450-3ce4-bc72-e249fb8abd1e");
        irisList.add("http://vivo-demo.uqam.ca/individual/b10aa3b4-f5a4-3f4b-a2b0-d9309fa3788a");
        irisList.add("http://vivo-demo.uqam.ca/individual/n8217d0d2-d0f1-30cb-8094-b4d98b0f40bf");
        irisList.add("http://vivo-demo.uqam.ca/individual/n15db7a7d-11da-3f60-ac03-cbc5a6c93508");
        irisList.add("http://vivo-demo.uqam.ca/individual/n6d608e75-0cab-3984-ba73-a928ed6bd0bb");
        irisList.add("http://vivo-demo.uqam.ca/individual/n3e2ed94b-8da0-3625-83d5-3aa3a7cc4e0b");
        irisList.add("http://vivo-demo.uqam.ca/individual/c22f37d4-a34f-30f6-941c-ab92b9755282");
        irisList.add("http://vivo-demo.uqam.ca/individual/n60a02044-43bd-3f8b-8dba-d97954851800");
        irisList = new ArrayList<>();

        irisList.add("http://vivo-demo.uqam.ca/individual/n9142cf41-6c97-30b1-a397-57ef5817aca2");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        hreq = new HttpServletRequestStub();
        hreq.setSession(session);
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testPersonsList() throws IOException {
        vClass = "http://vivoweb.org/ontology/core#FacultyMember";
        irisList = new ArrayList<>();
        irisList.add("http://vivo-demo.uqam.ca/individual/abergel_elisabeth_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/adjiwanou_visseho_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/agbobli_christian_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/ajib_wessam_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/alhaji_ahmad_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/alandry_aymeric_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/alessandra_amandine_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/cadieux_alexandre_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/alexeeva_olga_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/allard_s_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/allen_marie_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/alloing_camille_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/amamou_salem_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/amiot_catherine_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/amireault_valerie_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/ananian_priscilla_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/anaya_arenas_ana_maria_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/ancelovici_marcos_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/angenot_valerie_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/annabi_borhane_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/Charrette_anne_marie_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/belanger_anouk_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/apostolov_vestislav_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/araujo_oliveira_anderson_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/arcand_manon_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/archambault_denis_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/armony_victor_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/arroyo_pardo_paulina_uqam_ca");
        irisList.add("http://vivo-demo.uqam.ca/individual/arseneault_paul_uqam_ca");
        testRenderShortView();
    }

    @Test
    public void testOneRendershortView() throws IOException {
        irisList = new ArrayList<>();
        irisList.add("http://vivo-demo.uqam.ca/individual/abergel_elisabeth_uqam_ca");
        vClass = "http://vivoweb.org/ontology/core#FacultyMember";
        testRenderShortView();
        vClass = "http://vivoweb.org/ontology/core#AcademicDepartment";
        irisList = new ArrayList<>();
        irisList.add("http://vivo-demo.uqam.ca/individual/n5951");
        testRenderShortView();
        vClass = "http://purl.org/ontology/bibo/AcademicArticle";
        irisList = new ArrayList<>();
        irisList.add("http://vivo-demo.uqam.ca/individual/n85825a16-53ab-3f8f-8ed3-8a237ababce6");
        testRenderShortView();
    }

    @Test
    public void testOnePersonRendershortView() throws IOException {
        irisList = new ArrayList<>();
        irisList.add("http://vivo-demo.uqam.ca/individual/abergel_elisabeth_uqam_ca");
        vClass = "http://vivoweb.org/ontology/core#FacultyMember";
        testRenderShortView();
    }
    public void testRenderShortView() throws IOException {
        hreq.addParameter("vclassId", vClass);
        vreq = new VitroRequest(hreq);
        int irisListSize = irisList.size();
        Instant t0 = Instant.now();
        for (Iterator iterator = irisList.iterator(); iterator.hasNext();) {
//            Instant t1 = Instant.now();
            String anIri = (String) iterator.next();
            new GetRenderedSearchIndividualsByVClass(vreq).renderShortView(anIri, vClass);
            Instant t2 = Instant.now();
            // long totalTime = ChronoUnit.MILLIS.between(t1, t2);
//            log.info("ANALYSER: indv:(" + anIri + ") total time (sec.):(" + totalTime / 1000.0 + ")");
        }
        Instant t3 = Instant.now();
        long totalTime = ChronoUnit.MILLIS.between(t0, t3);
        log.info("ANALYSER: total indv:(" + irisListSize + ") total time (sec.):(" + totalTime / 1000.0
                + ") avrg time (sec.): " + (totalTime / irisListSize) / 1000.0);

    }

    @Test
    public void testParallelRenderShortView() throws IOException {
        buildOrganisationList();
        String vClass = "http://vivoweb.org/ontology/core#AcademicDepartment";
        hreq.addParameter("vclassId", vClass);
        vreq = new VitroRequest(hreq);
        Instant t0 = Instant.now();
        int irisListSize = irisList.size();
        ExecutorService es = Executors.newFixedThreadPool(irisListSize);
        for (Iterator iterator = irisList.iterator(); iterator.hasNext();) {
//            Instant t1 = Instant.now();
            String anIri = (String) iterator.next();
            ProcessIndividual pi = new ProcessIndividual();
            pi.setIri(anIri);
            pi.setVclassName(vClass);
            es.execute(pi);
            Instant t2 = Instant.now();
            // long totalTime = ChronoUnit.MILLIS.between(t1, t2);
//            log.info("ANALYSER: indv:(" + anIri + ") total time (sec.):(" + totalTime / 1000.0 + ")");
        }
        es.shutdown();
        try {
            while (!es.awaitTermination(10, TimeUnit.MILLISECONDS)) {
            }
        } catch (InterruptedException e1) {
        }
        Instant t3 = Instant.now();
        long totalTime = ChronoUnit.MILLIS.between(t0, t3);
        log.info("ANALYSER: total indv:(" + irisListSize + ") total time (sec.):(" + totalTime / 1000.0
                + ") avrg time (sec.): " + (totalTime / irisListSize) / 1000.0);

    }

    /*
     * The runnable class that executes the renderShortView
     */
    private class ProcessIndividual implements Runnable {
        private ObjectNode individual = null;
        private String vclassName;
        private String iri;

        public String getIri() {
            return iri;
        }

        public void setIri(String iri) {
            this.iri = iri;
        }

        public String getVclassName() {
            return vclassName;
        }

        public void setVclassName(String vclassName) {
            this.vclassName = vclassName;
        }

        // Method
        public void run() {
            new GetRenderedSearchIndividualsByVClass(vreq).renderShortView(iri, vclassName);
        }
    }

    @Test
    public void testProcessFacultyMember() throws IOException {
        hreq.addParameter("vclassId", "http://vivoweb.org/ontology/core#FacultyMember");
        vreq = new VitroRequest(hreq);
        HttpServletResponse resp = new HttpServletResponseStub();
        new GetRenderedSearchIndividualsByVClass(vreq).process(resp);
    }

    @Test
    public void testProcessAcademicDepartment() throws IOException {
        hreq.addParameter("vclassId", "http://vivoweb.org/ontology/core#AcademicDepartment");
        vreq = new VitroRequest(hreq);
        HttpServletResponse resp = new HttpServletResponseStub();
        new GetRenderedSearchIndividualsByVClass(vreq).process(resp);
    }

    @Test
    public void testProcessAcademicArticle() throws IOException {
        hreq.addParameter("vclassId", "http://purl.org/ontology/bibo/AcademicArticle");
        vreq = new VitroRequest(hreq);
        HttpServletResponse resp = new HttpServletResponseStub();
        new GetRenderedSearchIndividualsByVClass(vreq).process(resp);
    }

    @Test
    public void testProcessEvent() throws IOException {
        hreq.addParameter("vclassId", "http://purl.org/NET/c4dm/event.owl#Event");
        vreq = new VitroRequest(hreq);
        HttpServletResponse resp = new HttpServletResponseStub();
        new GetRenderedSearchIndividualsByVClass(vreq).process(resp);
    }

}
