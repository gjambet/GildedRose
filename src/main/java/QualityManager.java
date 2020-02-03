import java.util.ArrayList;

public class QualityManager {
    public static void updateQuality(ArrayList<CorruptedItem> items)
    {
        int quality;
        for (int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getCorrupted()){
                quality = 2;
            }else{
                quality = 1;
            }
            Item item = items.get(i).getItem();
            if ((!"Aged Brie".equals(item.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
            {
                if (item.getQuality() > 0)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
                    {
                        item.setQuality(item.getQuality() - quality);
                        if(item.getQuality() < 0){

                            item.setQuality(0);
                        }
                    }
                }
            }
            else
            {
                if (item.getQuality() < 50)
                {
                    item.setQuality(item.getQuality() + quality);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (item.getQuality() < 50)
                            {
                                item.setQuality(item.getQuality() + 2);
                            }
                        }

                        if (item.getSellIn() < 6)
                        {
                            if (item.getQuality() < 50)
                            {
                                item.setQuality(item.getQuality() + 3);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
            {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0)
            {
                if (!"Aged Brie".equals(item.getName()))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    {
                        if (item.getQuality() > 0)
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
                            {
                                item.setQuality(item.getQuality() - 1);
                            }
                        }
                    }
                    else
                    {
                        item.setQuality(item.getQuality() - item.getQuality());
                    }
                }
                else
                {
                    if (item.getQuality() < 50)
                    {
                        item.setQuality(item.getQuality() + quality);
                    }
                }
            }
            items.get(i).setItem(item);
        }
    }
}
