import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class AvpTerror{

    private String politician;
    private String pulp;
    private SubTerror terror;

    public String getPolitician() {
        return politician;
    }

    public void setPolitician(String politician) {
        this.politician = politician;
    }

    public String getPulp() {
        return pulp;
    }

    public void setPulp(String pulp) {
        this.pulp = pulp;
    }

    public SubTerror getTerror() {
        return terror;
    }

    public void setTerror(SubTerror terror) {
        this.terror = terror;
    }
}
class SubTerror{

    private List<SubTerrorLabel> labels;


    public List<SubTerrorLabel> getLabels() {
        return labels;
    }

    public void setLabels(List<SubTerrorLabel> labels) {
        this.labels = labels;
    }
}
class SubTerrorLabel {

    private String label;
    private Double score;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}

class  AvpPulp{

    private String terror;
    private String politician;
    private SubPulp pulp;


    public String getTerror() {
        return terror;
    }

    public void setTerror(String terror) {
        this.terror = terror;
    }

    public String getPolitician() {
        return politician;
    }

    public void setPolitician(String politician) {
        this.politician = politician;
    }

    public SubPulp getPulp() {
        return pulp;
    }

    public void setPulp(SubPulp pulp) {
        this.pulp = pulp;
    }
}
class SubPulp {

    private String label;
    private Double score;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}


class AvpPolitician {

    private String pulp;
    private String terror;
    private PoliticianOfPolitician politician;

    public String getPulp() {
        return pulp;
    }

    public void setPulp(String pulp) {
        this.pulp = pulp;
    }

    public String getTerror() {
        return terror;
    }

    public void setTerror(String terror) {
        this.terror = terror;
    }

    public PoliticianOfPolitician getPolitician() {
        return politician;
    }

    public void setPolitician(PoliticianOfPolitician politician) {
        this.politician = politician;
    }
}
class PoliticianOfPolitician{
    private List<SubPoliticianLabel> labels;

    public List<SubPoliticianLabel> getLabels() {
        return labels;
    }

    public void setLabels(List<SubPoliticianLabel> labels) {
        this.labels = labels;
    }
}
class SubPoliticianLabel{
    private String label;
    private Double score;
    private PoliticianBoundingBox bounding_box;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public PoliticianBoundingBox getBounding_box() {
        return bounding_box;
    }

    public void setBounding_box(PoliticianBoundingBox bounding_box) {
        this.bounding_box = bounding_box;
    }
}
class PoliticianBoundingBox{
    private List<List<Integer>> pts;
    private Double score;

    public List<List<Integer>> getPts() {
        return pts;
    }
    public void setPts(List<List<Integer>> pts) {
        this.pts = pts;
    }
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }
}

class AvpPClassify {

    AvpTerror terror;
    AvpPulp pulp;
    AvpPolitician politician;

    public AvpTerror getTerror() {
        return terror;
    }

    public void setTerror(AvpTerror terror) {
        this.terror = terror;
    }

    public AvpPulp getPulp() {
        return pulp;
    }

    public void setPulp(AvpPulp pulp) {
        this.pulp = pulp;
    }

    public AvpPolitician getPolitician() {
        return politician;
    }

    public void setPolitician(AvpPolitician politician) {
        this.politician = politician;
    }
}

public class FastJTest {

    public static void main(String[] args) throws Exception  {

        String js_pulp = "{\n" +
                "    \"pulp\": {\n" +
                "        \"label\": \"性感\",\n" +
                "        \"score\": 0.99985695\n" +
                "    },\n" +
                "    \"terror\": null,\n" +
                "    \"politician\": null\n" +
                "}";

        String js_pulp2 = "{\n" +
                "    \"pulp\": null,\n" +
                "    \"terror\": null,\n" +
                "    \"politician\": null\n" +
                "}";

        String netjson = "{\"teacherName\":\"crystall\",\"teacherAge\":27," +
                "\"course\":{\"courseName\":\"english\",\"code\":1270},\"" +
                "students\":[{\"studentName\":\"lily\",\"studentAge\":12}," +
                "{\"studentName\":\"lucy\",\"studentAge\":15}]}";

        String js_terror = "{\n" +
                "    \"pulp\": null,\n" +
                "    \"terror\": {\n" +
                "        \"labels\": [\n" +
                "            {\n" +
                "                \"label\": \"枪\",\n" +
                "                \"score\": 0.97436565\n" +
                "            },\n" +
                "\t\t\t\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"label\": \"刀\",\n" +
                "                \"score\": 0.88888\n" +
                "\t\t\t}\n" +
                "        ]\n" +
                "    },\n" +
                "    \"politician\": null\n" +
                "}";

        String js_snull = "{\n" +
                "    \"pulp\": null,\n" +
                "    \"terror\": null,\n" +
                "    \"politician\": null\n" +
                "}";

        String js_politician = "{\n" +
                "    \"pulp\": null,\n" +
                "    \"terror\": null,\n" +
                "    \"politician\": {\n" +
                "        \"labels\": [\n" +
                "            {\n" +
                "                \"label\": \"耿爽\",\n" +
                "                \"score\": 0.5768992,\n" +
                "                \"bounding_box\": {\n" +
                "                    \"pts\": [\n" +
                "                        [\n" +
                "                            280,\n" +
                "                            48\n" +
                "                        ],\n" +
                "                        [\n" +
                "                            332,\n" +
                "                            48\n" +
                "                        ],\n" +
                "                        [\n" +
                "                            332,\n" +
                "                            127\n" +
                "                        ],\n" +
                "                        [\n" +
                "                            280,\n" +
                "                            127\n" +
                "                        ]\n" +
                "                    ],\n" +
                "                    \"score\": 0.999992\n" +
                "                }\n" +
                "            }\n" +
                "\t\t\n" +
                "        ]\n" +
                "    }\n" +
                "}";

         //图片分类，第一次返回200的解析入口
        boolean isNUll = true;
        AvpPClassify avpPClassify = JSON.parseObject(js_terror, AvpPClassify.class);
        if(null == avpPClassify){
            System.out.println("recv is null");
            return;
        }

        if(null != avpPClassify.politician){
            isNUll = false;
            System.out.println("Politician json process");
            polititionProcess(js_politician);
        }
        if(null != avpPClassify.pulp){
            isNUll = false;
            System.out.println("Pulp json process");
            pulpProcess(js_pulp);
        }
        if(null != avpPClassify.terror){
            isNUll = false;
            System.out.println("Terror json process");
            terrorProcess(js_terror);
        }
        if(true == isNUll) {
            System.out.println("NULLLLLL");
        }
    }

    static void polititionProcess(String JsonPolitician){

        AvpPolitician avpPolitician = JSON.parseObject(JsonPolitician, AvpPolitician.class);
        System.out.println(avpPolitician.getPolitician());
    }

    static void pulpProcess(String JsonPulp){

        AvpPulp avpPulp = JSON.parseObject(JsonPulp, AvpPulp.class);
        if (null == avpPulp){
            System.out.println("avpPulp1  NULL");
            return;
        }

        SubPulp subPulp = avpPulp.getPulp();
        if (null == subPulp){
            System.out.println("subPulp2  NULL");
            return;
        }
        System.out.println(subPulp.getLabel() + ":" + subPulp.getScore());

    }

    static void terrorProcess(String JsonTerror){

        AvpTerror avpTerror = JSON.parseObject(JsonTerror, AvpTerror.class);
        if(null == avpTerror){
            System.out.println("avpTerror is null");
            return;
        }
        SubTerror subTerror =  avpTerror.getTerror();
        if(null == subTerror){
            System.out.println("subTerror is null");
            return;
        }

        List<SubTerrorLabel> sls = subTerror.getLabels();
        if(null == sls){
            System.out.println("sls is null");
            return;
        }
        for (SubTerrorLabel subTerrorlabel: sls){

            System.out.println(subTerrorlabel.getLabel() + ":" + subTerrorlabel.getScore());
        }
    }



}



