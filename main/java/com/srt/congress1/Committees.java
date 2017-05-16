package com.srt.congress1;

import java.io.Serializable;

/**
 * Created by sriram on 11/27/16.
 */

public class Committees implements Serializable{


    /**
     * committee_id : HLZI
     * name : House Select Committee on the Events Surrounding the 2012 Terrorist Attack in Benghazi
     * phone : (202) 226-7100
     * office : 1036 LHOB
     * chamber : house
     * subcommittee : false
     */

    public String committee_id;
    public String name;
    public String phone;
    public String office;
    public String chamber;
    public boolean subcommittee;
    public boolean fav;
    public String parent_committee_id;
}
