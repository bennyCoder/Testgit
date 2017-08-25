import android.os.Bundle;

import com.codemybrainsout.onboarder.AhoyOnboarderActivity;
import com.codemybrainsout.onboarder.AhoyOnboarderCard;
import com.example.android.system.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RP on 2017/08/02.
 */

public class Onboarding extends AhoyOnboarderActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard("Collections", "General pictures", R.drawable.general);
        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard("For kids", "specific to children", R.drawable.kids);
        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard("specific", "House items", R.drawable.specific);

        ahoyOnboarderCard1.setBackgroundColor(R.color.colorAccent);
        ahoyOnboarderCard2.setBackgroundColor(R.color.colorAccent);
        ahoyOnboarderCard3.setBackgroundColor(R.color.colorAccent);

        List<AhoyOnboarderCard> pages = new ArrayList<>();

        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard2);
        pages.add(ahoyOnboarderCard3);

        for (AhoyOnboarderCard page : pages) {
            page.setTitleColor(R.color.colorAccent);
            page.setDescriptionColor(R.color.colorAccent);
            //page.setTitleTextSize(dpToPixels(12, this));
            //page.setDescriptionTextSize(dpToPixels(8, this));
            //page.setIconLayoutParams(width, height, marginTop, marginLeft, marginRight, marginBottom);
        }

        setFinishButtonTitle("Finish");
        showNavigationControls(true);
        setGradientBackground();

        //set the button style you created
        // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        // setFinishButtonDrawableStyle(ContextCompat.getDrawable(this, R.drawable.rounded_button));
        //}

        //Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        //setFont(face);

        setOnboardPages(pages);
    }




    @Override
    public void onFinishButtonPressed() {

    }
}
