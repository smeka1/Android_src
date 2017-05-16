package com.srt.congress1;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sriram on 11/25/16.
 */

public class Bills implements Serializable{


    /**
     * bill_id : sres601-114
     * bill_type : sres
     * number : 601
     * congress : 114
     * chamber : senate
     * short_title : null
     * official_title : A resolution designating September 2016 as "National Dystonia Awareness Month" and raising awareness and understanding of the disorder of dystonia.
     * popular_title : null
     * sponsor : {"first_name":"John","nickname":"Johnny","last_name":"Isakson","middle_name":"H.","name_suffix":null,"title":"Sen"}
     * sponsor_id : I000055
     * cosponsors_count : 1
     * withdrawn_cosponsors_count : 0
     * introduced_on : 2016-09-29
     * history : {"active":true,"active_at":"2016-09-29","awaiting_signature":false,"enacted":false,"senate_passage_result":"pass","senate_passage_result_at":"2016-09-29","vetoed":false}
     * enacted_as : null
     * last_action_at : 2016-09-29
     * last_vote_at : 2016-09-29
     * committee_ids : []
     * related_bill_ids : []
     * urls : {"congress":"http://beta.congress.gov/bill/114th/senate-resolution/601","govtrack":"https://www.govtrack.us/congress/bills/114/sres601","opencongress":"https://www.opencongress.org/bill/sres601-114"}
     * last_version_on : 2016-09-29
     * last_version : {"version_code":"ats","issued_on":"2016-09-29","version_name":"Agreed to Senate","bill_version_id":"sres601-114-ats","urls":{"html":"https://www.gpo.gov/fdsys/pkg/BILLS-114sres601ats/html/BILLS-114sres601ats.htm","pdf":"https://www.gpo.gov/fdsys/pkg/BILLS-114sres601ats/pdf/BILLS-114sres601ats.pdf","xml":"https://www.gpo.gov/fdsys/pkg/BILLS-114sres601ats/xml/BILLS-114sres601ats.xml"},"pages":3}
     */

    public String bill_id;
    public String bill_type;
    public int number;
    public int congress;
    public String chamber;
    public Object short_title;
    public String official_title;
    public Object popular_title;
    public SponsorB sponsor;
    public String sponsor_id;
    public int cosponsors_count;
    public int withdrawn_cosponsors_count;
    public String introduced_on;
    public HistoryB history;
    public Object enacted_as;
    public String last_action_at;
    public String last_vote_at;
    public UrlsB urls;
    public String last_version_on;
    public LastVersionB last_version;
    public List<?> committee_ids;
    public List<?> related_bill_ids;
    public boolean fav;
    public String intro;
    public  String spname;
    public String status;
    public static class SponsorB implements Serializable{
        /**
         * first_name : John
         * nickname : Johnny
         * last_name : Isakson
         * middle_name : H.
         * name_suffix : null
         * title : Sen
         */

        public String first_name;
        public String nickname;
        public String last_name;
        public String middle_name;
        public Object name_suffix;
        public String title;
    }

    public static class  HistoryB implements Serializable {
        /**
         * active : true
         * active_at : 2016-09-29
         * awaiting_signature : false
         * enacted : false
         * senate_passage_result : pass
         * senate_passage_result_at : 2016-09-29
         * vetoed : false
         */

        public boolean active;
        public String active_at;
        public boolean awaiting_signature;
        public boolean enacted;
        public String senate_passage_result;
        public String senate_passage_result_at;
        public boolean vetoed;
    }

    public static class UrlsB implements Serializable{
        /**
         * congress : http://beta.congress.gov/bill/114th/senate-resolution/601
         * govtrack : https://www.govtrack.us/congress/bills/114/sres601
         * opencongress : https://www.opencongress.org/bill/sres601-114
         */

        public String congress;
        public String govtrack;
        public String opencongress;
    }

    public static class LastVersionB implements Serializable{
        /**
         * version_code : ats
         * issued_on : 2016-09-29
         * version_name : Agreed to Senate
         * bill_version_id : sres601-114-ats
         * urls : {"html":"https://www.gpo.gov/fdsys/pkg/BILLS-114sres601ats/html/BILLS-114sres601ats.htm","pdf":"https://www.gpo.gov/fdsys/pkg/BILLS-114sres601ats/pdf/BILLS-114sres601ats.pdf","xml":"https://www.gpo.gov/fdsys/pkg/BILLS-114sres601ats/xml/BILLS-114sres601ats.xml"}
         * pages : 3
         */

        public String version_code;
        public String issued_on;
        public String version_name;
        public String bill_version_id;
        public UrlsBX urls;
        public int pages;

        public static class UrlsBX implements Serializable{
            /**
             * html : https://www.gpo.gov/fdsys/pkg/BILLS-114sres601ats/html/BILLS-114sres601ats.htm
             * pdf : https://www.gpo.gov/fdsys/pkg/BILLS-114sres601ats/pdf/BILLS-114sres601ats.pdf
             * xml : https://www.gpo.gov/fdsys/pkg/BILLS-114sres601ats/xml/BILLS-114sres601ats.xml
             */

            public String html;
            public String pdf;
            public String xmll;
        }
    }
}
