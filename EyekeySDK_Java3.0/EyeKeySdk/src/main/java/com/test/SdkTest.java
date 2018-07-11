package com.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.eyekey.http.EyeKeyHttp;

public class SdkTest {
    
    private EyeKeyHttp request = null;
    
    @Before
    public void tearUp(){
        
        //request  = new EyeKeyHttp("9c02422f91f24129bf943d6e4bb38bc0", "3fffacd2aa72409cbe6c336a14b22180");
        //request  = new EyeKeyHttp("ef18a1f1a3b44fb0b64f341b54eba33c","46a9b582442f4fa7b539c66d8da13f8b");
        request = new EyeKeyHttp("000000","000000");
    }

    @Test
    public void testCheckingUrl() {
        JSONObject o = request.checkingImgUrl("http://img.bimg.126.net/photo/PB4A4hYW98DuED4pTE5VFg==/5705779252902308357.jpg", null);
        System.out.println(o);
    }

    @Test
    public void testCheckingImg() {
        JSONObject o = request.checkingImgB64(Base64.encodeBase64String(readImage("E:/资料/1cun.jpg")), null);
        System.out.println(o);
    }
    
    @Test
    public void checkMark(){
        JSONObject o = request.checkMark("ddc8611870b34ccfb7e7a23328ad5149", null);
        System.out.println(o);
        System.out.println(o.get("face_id"));
    }
    
    @Test
    public void matchCompare(){
        JSONObject o = request.matchCompare("ddc8611870b34ccfb7e7a23328ad5149", "266c381129f1406cb90e8a48de436ee3");
        System.out.println(o);
    }
    
    @Test
    public void matchVerifyById(){
        JSONObject o = request.matchVerifyById("ddc8611870b34ccfb7e7a23328ad5149", "1b04f0c3721f4a52b8f28c33ee616684");
        System.out.println(o);
    }
    
    @Test
    public void matchVerifyByName(){
        JSONObject o = request.matchVerifyByName("ddc8611870b34ccfb7e7a23328ad5149","f35ac18627714d088579a1e481ea0122");
        System.out.println(o);
    }
    
    @Test
    public void matchIdentifyById(){
        JSONObject o = request.matchIdentifyById("266c381129f1406cb90e8a48de436ee3", "196c93c69e474b2988551e408ee6a0a1");
        System.out.println(o);
    }
    
    @Test
    public void matchIdentifyByName(){
        JSONObject o = request.matchIdentifyByName("df73c4c012054ec2bdd385fb493a807d", "crowd_sln");
        System.out.println(o);
    }
    
    @Test
    public void matchSearchById(){
        JSONObject o = request.matchSearchById("266c381129f1406cb90e8a48de436ee3", "408e2d3def65476da0901292769f5de7", 9);
        System.out.println(o);
    }
    
    @Test
    public void createPeopleById(){
        JSONObject o = request.createPeopleById("张新磊", null, null, new String[]{"266c381129f1406cb90e8a48de436ee3"});
        System.out.println(o);
    }
    
    @Test
    public void createPeopleByName(){
        JSONObject o = request.createPeopleByName(null, null, null, new String[]{"ddc8611870b34ccfb7e7a23328ad5149"});
        System.out.println(o);
    }
    
    @Test
    public void deletePeopleById(){
        JSONObject o = request.deletePeopleById("1b04f0c3721f4a52b8f28c33ee616684");
        System.out.println(o);
    }
    @Test
    public void deletePeopleByName(){
        //JSONObject o = request.createPeopleById(null, null, null,null);
        //System.out.println(o);
        JSONObject o = request.deletePeopleByName("f35ac18627714d088579a1e481ea0122");
        System.out.println(o);
    }
    
    @Test
    public void addFaceToPeopleById(){
        JSONObject o = request.addFaceToPeopleById("1b04f0c3721f4a52b8f28c33ee616684", "266c381129f1406cb90e8a48de436ee3");
        System.out.println(o);
    }
    
    @Test
    public void addFaceToPeopleByName(){
        JSONObject o = request.addFaceToPeopleByName("f35ac18627714d088579a1e481ea0122", new String[]{"7737408f9fdc46bf9cfb32b13361700d","a7a52b12489e4f0e9b898d394bebb022"});
        System.out.println(o);
    }
    
    @Test
    public void removeFaceFromPeopleById(){
        JSONObject o = request.removeFaceFromPeopleById("f35ac18627714d088579a1e481ea0122", new String[]{"aa26f413199a4fb48a2933724335f1fa"});
        System.out.println(o);
    }
    
    @Test
    public void setPeople(){
        JSONObject o = request.setPeopleById("e7a63b92986b425692523bf6a6ffbb02", null, "mypeople");
        System.out.println(o);
    }
    
    @Test
    public void getPeople(){
        JSONObject o = request.getPeopleById("860f97b70b744077bc57632cbbbbb352","860f97b70b744077bc57632cbbbbb352");
        System.out.println(o);
    }
    
    @Test
    public void createCrowd(){
        JSONObject o = request.createCrowdById(null, "mycrowd", "598335e642534f34b8869a1aef78672e");
        System.out.println(o);
    }
    
    @Test
    public void deleteCrowdById(){
        JSONObject o = request.createCrowdById(null, "mycrowd", null);
        System.out.println(o);
        o = request.deleteCrowdById(o.getString("crowd_id"));
        System.out.println(o);
    }
    
    @Test
    public void deleteCrowdByName(){
        JSONObject o = request.createCrowdById(null, "mycrowd", null);
        System.out.println(o);
        o = request.deleteCrowdByName(o.getString("crowd_name"));
        System.out.println(o);
    }
    
    @Test
    public void getCrowd(){
        JSONObject o = request.getCrowdByName("crowd_sln");
                        //request.getCrowdById("196c93c69e474b2988551e408ee6a0a1");
        System.out.println(o);
    }
    
    @Test
    public void createFaceGather(){
        JSONObject o = request.createFaceGather(null, null, new String[]{"ddc8611870b34ccfb7e7a23328ad5149","266c381129f1406cb90e8a48de436ee3"});
        System.out.println(o);
    }
    
    @Test
    public void deleteFaceGatherByName(){
        JSONObject o = request.createFaceGather(null, null, null);
        System.out.println(o);
        o = request.deleteFaceGatherByName(o.getString("facegather_name"));
        System.out.println(o);
    }
    
    @Test
    public void addFaceToFaceGatherById(){
        JSONObject o = request.addFaceToFaceGatherById("d97d5d47d41f42c6bc23a062069a7a2a", new String[]{"d3bb0315c8514bb0be86573d4054986c"});
        System.out.println(o);
    }
    
    @Test
    public void addFaceToFaceGatherByName(){
        JSONObject o = request.addFaceToFaceGatherByName("5966da6c769141128921921c6c096d05", new String[]{"d3bb0315c8514bb0be86573d4054986c"});
        System.out.println(o);
    }
    
    @Test
    public void removeFaceFromFaceGatherById(){
        JSONObject o = request.removeFaceFromFaceGatherById("d97d5d47d41f42c6bc23a062069a7a2a", new String[]{"ddc8611870b34ccfb7e7a23328ad5149"});
        System.out.println(o);
    }
    
    @Test
    public void removeFaceFromFaceGatherByName(){
        JSONObject o = request.removeFaceFromFaceGatherByName("5966da6c769141128921921c6c096d05", new String[]{"d3bb0315c8514bb0be86573d4054986c"});
        System.out.println(o);
    }
    
    @Test
    public void deleteFaceGatherById(){
        JSONObject o = request.deleteFaceGatherById("d97d5d47d41f42c6bc23a062069a7a2a");
        System.out.println(o);
    }
    
    @Test
    public void setFaceGatherById(){
        JSONObject o = request.setFaceGatherById("d97d5d47d41f42c6bc23a062069a7a2a", null, null);
        System.out.println(o);
    }
    
    @Test
    public void setFaceGatherByName(){
        JSONObject o = request.setFaceGatherByName("5966da6c769141128921921c6c096d05", null, "mygather");
        System.out.println(o);
    }
    
    @Test
    public void addFaceToGatherById(){
        JSONObject o = request.addFaceToFaceGatherById("d97d5d47d41f42c6bc23a062069a7a2a", new String[]{"d2c4120164f349e381d022bae1590349"});
        System.out.println(o);
    }
    
    @Test
    public void getFaceGatherById(){
        JSONObject o = request.getFaceGatherById("d97d5d47d41f42c6bc23a062069a7a2a");
        System.out.println(o);
    }
    
    @Test
    public void getFaceGatherByName(){
        JSONObject o = request.getFaceGatherByName("5966da6c769141128921921c6c096d05");
        System.out.println(o);
    }
    

    public byte[] readImage(String path) {
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(new File(path));
            out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len = in.read(buf);
            while (len > 0) {
                out.write(buf, 0, len);
                len = in.read(buf);
            }

            byte[] returnBytes = out.toByteArray();
            return returnBytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }

                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
    // @Test
    // public void
}
