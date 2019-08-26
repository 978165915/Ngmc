package com.neu.demo01.entity;

public class Manufacturer {
    private int man_id;
    private String name_en;
    private String name_cn;
    private String gmc_report_type;
    private String gmc_report_url;
    private String description;
    private String sts_cd;

    public Manufacturer() {
    }

    public Manufacturer( String name_en, String name_cn, String gmc_report_type, String gmc_report_url, String description, String sts_cd) {
        this.name_en = name_en;
        this.name_cn = name_cn;
        this.gmc_report_type = gmc_report_type;
        this.gmc_report_url = gmc_report_url;
        this.description = description;
        this.sts_cd = sts_cd;
    }

    public int getMan_id() {
        return man_id;
    }

    public void setMan_id(int man_id) {
        this.man_id = man_id;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_cn() {
        return name_cn;
    }

    public void setName_cn(String name_cn) {
        this.name_cn = name_cn;
    }

    public String getGmc_report_type() {
        return gmc_report_type;
    }

    public void setGmc_report_type(String gmc_report_type) {
        this.gmc_report_type = gmc_report_type;
    }

    public String getGmc_report_url() {
        return gmc_report_url;
    }

    public void setGmc_report_url(String gmc_report_url) {
        this.gmc_report_url = gmc_report_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSts_cd() {
        return sts_cd;
    }

    public void setSts_cd(String sts_cd) {
        this.sts_cd = sts_cd;
    }
}
