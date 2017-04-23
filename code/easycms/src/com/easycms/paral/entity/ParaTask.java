package com.easycms.paral.entity;

import java.io.Serializable;
import java.util.Date;

public class ParaTask implements Serializable{
    private Integer id;
    private String name;
    private Date sdate;
    private Date edate;
    private String status;
    private String opera;
    private Integer member_id;
    private String up_path;
    private String down_path;
    private String filename;
    private String newfilename;
    private String username;

    public ParaTask(Integer id ,String name, Date sdate,String status,String opera,Integer member_id,String up_path,String down_path,String filename,String newfilename){
        this.id=id;
        this.name=name;
        this.sdate=sdate;
        this.status=status;
        this.opera=opera;
        this.member_id=member_id;
        this.up_path=up_path;
        this.down_path=down_path;
        this.filename=filename;
        this.newfilename=newfilename;
    }

    public ParaTask(){

    }

    public ParaTask(String name, Date sdate,String status,String opera,Integer member_id,String up_path,String down_path,String filename,String newfilename, String username){
        this.name=name;
        this.sdate=sdate;
        this.status=status;
        this.opera=opera;
        this.member_id=member_id;
        this.up_path=up_path;
        this.down_path=down_path;
        this.filename=filename;
        this.newfilename=newfilename;
        this.username=username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpera() {
        return opera;
    }

    public void setOpera(String opera) {
        this.opera = opera;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getUp_path() {
        return up_path;
    }

    public void setUp_path(String up_path) {
        this.up_path = up_path;
    }

    public String getDown_path() {
        return down_path;
    }

    public void setDown_path(String down_path) {
        this.down_path = down_path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getNewfilename() {
        return newfilename;
    }

    public void setNewfilename(String newfilename) {
        this.newfilename = newfilename;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }
}
