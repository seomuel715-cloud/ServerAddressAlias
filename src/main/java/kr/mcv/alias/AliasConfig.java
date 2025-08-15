
package kr.mcv.alias;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public class AliasConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String FILE_NAME = "serveralias.json";

    public final Map<String, String> aliases = new LinkedHashMap<>();

    public static AliasConfig load() {
        File cfgDir = new File(new File(System.getProperty("user.home"), ".minecraft"), "config");
        if (!cfgDir.exists()) cfgDir.mkdirs();
        File cfg = new File(cfgDir, FILE_NAME);

        AliasConfig data = new AliasConfig();
        if (cfg.exists()) {
            try (FileReader r = new FileReader(cfg)) {
                Type type = new TypeToken<Map<String, String>>(){}.getType();
                Map<String, String> map = GSON.fromJson(r, type);
                if (map != null) data.aliases.putAll(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            data.aliases.put("penguin.mcv.kr:25565", "penguin.mcv.kr:25565");
            for (int i = 25566; i <= 25583; i++) {
                data.aliases.put("penguin.mcv.kr:" + i, "penguin.mcv.kr:25565");
            }
            try (FileWriter w = new FileWriter(cfg)) {
                GSON.toJson(data.aliases, w);
            } catch (Exception e) { e.printStackTrace(); }
        }
        return data;
    }

    public String resolve(String input) {
        String key = input.trim();
        String mapped = aliases.get(key);
        return mapped != null ? mapped : input;
    }
}
