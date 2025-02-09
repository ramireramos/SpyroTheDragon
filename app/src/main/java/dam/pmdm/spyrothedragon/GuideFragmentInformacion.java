package dam.pmdm.spyrothedragon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class GuideFragmentInformacion extends Fragment {

    public GuideFragmentInformacion() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout para este fragment
        return inflater.inflate(R.layout.fragment_guide_informacion, container, false);
    }
}