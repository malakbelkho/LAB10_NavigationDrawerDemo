package ma.ensa.mobile.navigationdrawerdemo;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

public class PaletteListFragment extends ListFragment {

    private final String[] drawerTopics = {
            "Navigation Drawer",
            "Fragment Transaction",
            "FragmentManager",
            "Menu latéral",
            "Icônes vectorielles",
            "FrameLayout container",
            "Interface modulaire",
            "Navigation fluide",
            "Composants AndroidX",
            "Design personnalisé"
    };

    public PaletteListFragment() {
        // Constructeur vide obligatoire
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_palette_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireActivity(),
                R.layout.row_palette_item,
                R.id.topicTitle,
                drawerTopics
        );

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        String selectedTopic = drawerTopics[position];

        Toast.makeText(
                requireContext(),
                "Élément sélectionné : " + selectedTopic,
                Toast.LENGTH_SHORT
        ).show();
    }
}