package openNeo.test;

import openNeo.FileCreater;

import java.util.Vector;

public class FishBucketTest {
    public static void main(String[] args) {
        String[] items = {"117506305", "117899265", "185008129", "117441793", "118161664", "65536", "50726144", "67764993",
                "234882305", "67110144", "117441025", "16778497", "101253888", "50660352", "918529", "2353440288", "918273",
                "67108865", "917504", "459008", "67699456", "67371009"};
        String[] value0 = {"117506305", "117899265", "185008129", "117441793", "118161664", "65536", "50726144", "67764993",
                "234882305", "67110144", "117441025", "16778497", "101253888", "50660352", "918529", "2353440288", "918273",
                "67108865", "917504", "459008", "67699456", "67371009"};
        String[] value1 = {"117506305", "117899265", "185008129", "117441793", "118161664", "65536", "50726144", "67764993",
                "234882305", "67110144", "117441025", "16778497", "101253888", "50660352", "918529", "2353440288", "918273",
                "67108865", "917504", "459008", "67699456", "67371009"};
        FileCreater fc = new FileCreater(items);
        fc.setPath("C:/Users/21290/AppData/Roaming/.minecraft/versions/1.20.1ZY/resourcepacks/StarVision JE/script/");
        fc.setPropertiesStructure("""
                type=item
                matchItems=tropical_fish_bucket
                components.bucket_entity_data.BucketVariantTag=<this>THIS.ITEM</this>
                texture=<this>THIS.ITEM</this>
                value0=<this>THIS.VALUE[0]</this>
                value1=<this>THIS.VALUE[1]</this>""");
        Vector<String[]> values = new Vector<>();
        values.add(value0);
        values.add(value1);
        fc.setValues(values);
        fc.setCustomVersion("new");
        fc.generate();
        fc.save();
    }
}
