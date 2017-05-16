package com.srt.congress1;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sriram on 11/22/16.
 */

public class legis {


    /**
     * results : [{"bioguide_id":"D000626","in_office":true,"thomas_id":"02296","govtrack_id":"412675","crp_id":"N00038767","fec_ids":["H6OH08315"],"first_name":"Warren","nickname":null,"last_name":"Davidson","middle_name":null,"name_suffix":null,"gender":"M","birthday":"1970-03-01","leadership_role":null,"term_start":"2016-06-09","term_end":"2017-01-03","state":"OH","state_name":"Ohio","party":"R","title":"Rep","chamber":"house","phone":"202-225-6205","fax":null,"website":null,"office":"1011 Longworth House Office Building","contact_form":null,"votesmart_id":166760,"district":8,"oc_email":null,"ocd_id":"ocd-division/country:us/state:oh/cd:8"},{"bioguide_id":"L000585","in_office":true,"thomas_id":"02295","govtrack_id":"412674","crp_id":"N00037031","fec_ids":["H6IL18088"],"first_name":"Darin","nickname":null,"last_name":"LaHood","middle_name":null,"name_suffix":null,"gender":"M","birthday":"1968-07-05","leadership_role":null,"term_start":"2015-09-17","term_end":"2017-01-03","state":"IL","state_name":"Illinois","party":"R","title":"Rep","chamber":"house","phone":"202-225-6201","fax":null,"website":"https://lahood.house.gov/","office":"2464 Rayburn House Office Building","contact_form":"https://lahood.house.gov/contact/email","votesmart_id":128760,"district":18,"oc_email":"Rep.Lahood@opencongress.org","twitter_id":"RepLaHood","youtube_id":null,"facebook_id":"1499570210366431","ocd_id":"ocd-division/country:us/state:il/cd:18"},{"bioguide_id":"K000388","in_office":true,"thomas_id":"02294","govtrack_id":"412673","crp_id":"N00037003","fec_ids":["H6MS01131"],"first_name":"Trent","nickname":null,"last_name":"Kelly","middle_name":null,"name_suffix":null,"gender":"M","birthday":"1966-03-01","leadership_role":null,"term_start":"2015-06-09","term_end":"2017-01-03","state":"MS","state_name":"Mississippi","party":"R","title":"Rep","chamber":"house","phone":"202-225-4306","fax":null,"website":"https://trentkelly.house.gov","office":"1427 Longworth House Office Building","contact_form":"https://trentkelly.house.gov/contact","votesmart_id":156389,"district":1,"oc_email":"Rep.Trentkelly@opencongress.org","twitter_id":"reptrentkelly","youtube_id":null,"facebook_id":"reptrentkelly","ocd_id":"ocd-division/country:us/state:ms/cd:1"},{"bioguide_id":"D000625","in_office":true,"thomas_id":"02293","govtrack_id":"412672","crp_id":"N00036928","fec_ids":["H6NY11174"],"first_name":"Daniel","nickname":null,"last_name":"Donovan","middle_name":"M.","name_suffix":"Jr.","gender":"M","birthday":"1956-11-06","leadership_role":null,"term_start":"2015-05-12","term_end":"2017-01-03","state":"NY","state_name":"New York","party":"R","title":"Rep","chamber":"house","phone":"202-225-3371","fax":null,"website":"https://donovan.house.gov","office":"1725 Longworth House Office Building","contact_form":null,"votesmart_id":127760,"district":11,"oc_email":"Rep.Donovan@opencongress.org","twitter_id":"RepDanDonovan","youtube_id":null,"facebook_id":"867632656644580","ocd_id":"ocd-division/country:us/state:ny/cd:11"},{"bioguide_id":"S001197","in_office":true,"thomas_id":"02289","govtrack_id":"412671","crp_id":"N00035544","fec_ids":["S4NE00090"],"first_name":"Benjamin","nickname":null,"last_name":"Sasse","middle_name":"Eric","name_suffix":null,"gender":"M","birthday":"1972-02-22","leadership_role":null,"term_start":"2015-01-06","term_end":"2021-01-03","state":"NE","state_name":"Nebraska","party":"R","title":"Sen","chamber":"senate","phone":"202-224-4224","fax":null,"website":"http://www.sasse.senate.gov/public","office":"386a Russell Senate Office Building","contact_form":null,"senate_class":2,"lis_id":"S382","state_rank":"junior","district":null,"oc_email":"Sen.Sasse@opencongress.org","twitter_id":"SenSasse","youtube_id":null,"facebook_id":"SenatorSasse","ocd_id":"ocd-division/country:us/state:ne"},{"bioguide_id":"W000819","in_office":true,"thomas_id":"02255","govtrack_id":"412670","crp_id":"N00035311","fec_ids":["H4NC06052"],"first_name":"Mark","nickname":null,"last_name":"Walker","middle_name":null,"name_suffix":null,"gender":"M","birthday":"1969-05-20","leadership_role":null,"term_start":"2015-01-06","term_end":"2017-01-03","state":"NC","state_name":"North Carolina","party":"R","title":"Rep","chamber":"house","phone":"202-225-3065","fax":"202-225-8611","website":"https://walker.house.gov","office":"312 Cannon House Office Building","contact_form":null,"district":6,"oc_email":"Rep.Walker@opencongress.org","twitter_id":"RepMarkWalker","youtube_id":null,"facebook_id":"RepMarkWalker","ocd_id":"ocd-division/country:us/state:nc/cd:6"},{"bioguide_id":"R000605","in_office":true,"thomas_id":"02288","govtrack_id":"412669","crp_id":"N00035187","fec_ids":["S4SD00049"],"first_name":"Mike","nickname":null,"last_name":"Rounds","middle_name":null,"name_suffix":null,"gender":"M","birthday":"1954-10-24","leadership_role":null,"term_start":"2015-01-06","term_end":"2021-01-03","state":"SD","state_name":"South Dakota","party":"R","title":"Sen","chamber":"senate","phone":"202-224-5842","fax":null,"website":"http://www.rounds.senate.gov","office":"502 Hart Senate Office Building","contact_form":null,"senate_class":2,"lis_id":"S381","state_rank":"junior","district":null,"oc_email":"Sen.Rounds@opencongress.org","twitter_id":"SenatorRounds","youtube_id":null,"facebook_id":"SenatorMikeRounds","ocd_id":"ocd-division/country:us/state:sd"},{"bioguide_id":"T000476","in_office":true,"thomas_id":"02291","govtrack_id":"412668","crp_id":"N00035492","fec_ids":["S4NC00162"],"first_name":"Thom","nickname":null,"last_name":"Tillis","middle_name":null,"name_suffix":null,"gender":"M","birthday":"1960-08-30","leadership_role":null,"term_start":"2015-01-06","term_end":"2021-01-03","state":"NC","state_name":"North Carolina","party":"R","title":"Sen","chamber":"senate","phone":"202-224-6342","fax":null,"website":"http://www.tillis.senate.gov","office":"185 Dirksen Senate Office Building","contact_form":null,"senate_class":2,"lis_id":"S384","state_rank":"junior","district":null,"oc_email":"Sen.Tillis@opencongress.org","twitter_id":"senthomtillis","youtube_id":null,"facebook_id":"1576257352609470","ocd_id":"ocd-division/country:us/state:nc"},{"bioguide_id":"E000295","in_office":true,"thomas_id":"02283","govtrack_id":"412667","crp_id":"N00035483","fec_ids":["S4IA00129"],"first_name":"Joni","nickname":null,"last_name":"Ernst","middle_name":null,"name_suffix":null,"gender":"F","birthday":"1970-07-01","leadership_role":null,"term_start":"2015-01-06","term_end":"2021-01-03","state":"IA","state_name":"Iowa","party":"R","title":"Sen","chamber":"senate","phone":"202-224-3254","fax":null,"website":"http://www.ernst.senate.gov/public","office":"111 Russell Senate Office Building","contact_form":null,"senate_class":2,"lis_id":"S376","state_rank":"junior","district":null,"oc_email":"Sen.Ernst@opencongress.org","twitter_id":"SenJoniErnst","youtube_id":null,"facebook_id":"351671691660938","ocd_id":"ocd-division/country:us/state:ia"},{"bioguide_id":"P000612","in_office":true,"thomas_id":"02286","govtrack_id":"412666","crp_id":"N00035516","fec_ids":["S4GA11285"],"first_name":"David","nickname":null,"last_name":"Perdue","middle_name":null,"name_suffix":null,"gender":"M","birthday":"1949-12-10","leadership_role":null,"term_start":"2015-01-06","term_end":"2021-01-03","state":"GA","state_name":"Georgia","party":"R","title":"Sen","chamber":"senate","phone":"202-224-3521","fax":null,"website":"http://www.perdue.senate.gov","office":"383 Russell Senate Office Building","contact_form":null,"senate_class":2,"lis_id":"S379","state_rank":"junior","district":null,"oc_email":"Sen.Perdue@opencongress.org","twitter_id":"sendavidperdue","youtube_id":null,"facebook_id":"311482539049477","ocd_id":"ocd-division/country:us/state:ga"}]
     * count : 538
     * page : {"count":10,"per_page":10,"page":1}
     */
    private int count;
    private PageB page;
    public List<ResultsB> results;


    public static class PageB {
        /**
         * count : 10
         * per_page : 10
         * page : 1
         */

        private int count;
        private int per_page;
        private int page;

    }

    public static class ResultsB implements Serializable{
        /**
         * bioguide_id : D000626
         * in_office : true
         * thomas_id : 02296
         * govtrack_id : 412675
         * crp_id : N00038767
         * fec_ids : ["H6OH08315"]
         * first_name : Warren
         * nickname : null
         * last_name : Davidson
         * middle_name : null
         * name_suffix : null
         * gender : M
         * birthday : 1970-03-01
         * leadership_role : null
         * term_start : 2016-06-09
         * term_end : 2017-01-03
         * state : OH
         * state_name : Ohio
         * party : R
         * title : Rep
         * chamber : house
         * phone : 202-225-6205
         * fax : null
         * website : null
         * office : 1011 Longworth House Office Building
         * contact_form : null
         * votesmart_id : 166760
         * district : 8
         * oc_email : null
         * ocd_id : ocd-division/country:us/state:oh/cd:8
         * twitter_id : RepLaHood
         * youtube_id : null
         * facebook_id : 1499570210366431
         * senate_class : 2
         * lis_id : S382
         * state_rank : junior
         */

        public String bioguide_id;
        public boolean in_office;
        public String thomas_id;
        public String govtrack_id;
        public String crp_id;
        public String first_name;
        public String name;
        public Object nickname;
        public String last_name;
        public Object middle_name;
        public Object name_suffix;
        public String gender;
        public String birthday;
        public Object leadership_role;
        public String term_start;
        public String term_end;
        public String state;
        public String state_name;
        public String party;
        public String title;
        public String chamber;
        public String phone;
        public Object fax;
        public Object website;
        public String office;
        public Object contact_form;
        public int votesmart_id;
        public int district;
        public Object oc_email;
        public String ocd_id;
        public String twitter_id;
        public Object youtube_id;
        public String facebook_id;
        public int senate_class;
        public String lis_id;
        public String state_rank;
        public List<String> fec_ids;
        public String imageurl;
        public String line2;
        public String pim;
        public String pn;
        public String fname ;
        public String stdate;
        public String etdate;
        public String chm;
        public String bday;
        public int prog;
        public boolean fav;






    }
}
