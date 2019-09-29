package test.example.fakeig;

import java.util.ArrayList;

class SnapData {
    private static String[][] data = new String[][] {
            {"siapa", "user"},
            {"kamu", "user"},
            {"danhill", "user"},
            {"cembre", "user"},
            {"condong", "user"},
            {"hoyaa", "user"},
            {"leee", "user"},
            {"opps", "user"}
    };

    static ArrayList<SnapModel> getAllData() {

        ArrayList<SnapModel> models = new ArrayList<>();

        for (String[] list: data) {
            SnapModel model = new SnapModel();
            model.setName(list[0]);
            model.setImages(list[1]);
            models.add(model);
        }

        return models;
    }
}
