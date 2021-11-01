package com.sb.projectapi.bootstrap;

import com.sb.projectapi.model.CfaItem;
import com.sb.projectapi.repositories.CfaMenuRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CfaLoader implements CommandLineRunner {
    public final CfaMenuRepository cfaMenuRepository;
    public CfaLoader(CfaMenuRepository cfaMenuRepository){
        this.cfaMenuRepository = cfaMenuRepository;
    }
    @Override
    public void run(String...args) throws Exception{
        loadItems();
    }

    private void loadItems(){
        cfaMenuRepository.save(
                CfaItem.builder()
                        .itemName("Chicken Sandwich")
                        .description("This is our chicken sandwich handcrafted")
                        .calories(500)

                        .build()

        );
        cfaMenuRepository.save(
                CfaItem.builder()
                        .itemName("Chicken Tenders")
                        .description("This is our chicken tenders with special spices")
                        .calories(800)

                        .build()

        );
        System.out.println("Items Loaded");
    }


}
