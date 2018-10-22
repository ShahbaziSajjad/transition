package refah.test.ar.transitionexanple;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
//    private SliderLayout mDemoSlider;
    StretchTopScrollView stretchTopView;
    LinearLayoutManager linearLayoutManager;
    ImageView arrow;
    private ArrayList<Integer> drawables = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        stretchTopView=(StretchTopScrollView)findViewById(R.id.stretchTopView);
//        arrow=(ImageView) findViewById(R.id.arrow);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//
//        mDemoSlider = (SliderLayout)findViewById(R.id.slider);
//
//        HashMap<String,String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
//
//        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
//        file_maps.put("Hannibal",R.drawable.hannibal);
//        file_maps.put("Big Bang Theory",R.drawable.bigbang);
//        file_maps.put("House of Cards",R.drawable.house);
//        file_maps.put("Game of Thrones", R.drawable.game_of_thrones);
//
//        for(String name : file_maps.keySet()){
//            TextSliderView textSliderView = new TextSliderView(this);
//            textSliderView
//                    .description(name)
//                    .image(file_maps.get(name))
//                    .setScaleType(BaseSliderView.ScaleType.Fit)
//                    .setOnSliderClickListener(this);
//
//            textSliderView.bundle(new Bundle());
//            textSliderView.getBundle()
//                    .putString("extra",name);
//
//            mDemoSlider.addSlider(textSliderView);
//        }
//        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
//        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
//        mDemoSlider.setDuration(4000);
//        mDemoSlider.addOnPageChangeListener(this);


        final RecyclerView l = (RecyclerView)findViewById(R.id.transformers);
        RecyclerView l1 = (RecyclerView)findViewById(R.id.transformers1);
        RecyclerView l2 = (RecyclerView)findViewById(R.id.transformers2);
        RecyclerView l3 = (RecyclerView)findViewById(R.id.transformers2);
         linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        HomeAdapter homeAdapter=new HomeAdapter(getApplicationContext());
        SqAdapter sqAdapter=new SqAdapter(getApplicationContext());
        l.setLayoutManager(linearLayoutManager);
        l.setAdapter(homeAdapter);
        l1.setLayoutManager(linearLayoutManager1);
        l1.setAdapter(sqAdapter);
        l2.setLayoutManager(linearLayoutManager2);
        l2.setAdapter(sqAdapter);
        l3.setLayoutManager(linearLayoutManager3);
        l3.setAdapter(sqAdapter);
        init();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
//        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }



    private void init() {

        final FrameLayout topView = (FrameLayout)stretchTopView.getTopView();
//        final LinearLayout bottomView = (LinearLayout)stretchTopView.getBottomView();

        final CirclePageIndicator indicator = (CirclePageIndicator) topView.getChildAt(1);

//        TextView descriptionTextView = (TextView) bottomView.findViewById(R.id.descriptionTextView);
//        descriptionTextView.setText(Html.fromHtml(Globals.DESC));

        stretchTopView.setFactor(1.5f);

        stretchTopView.setChangeListener(new StretchTopScrollView.onOverScrollChanged() {
            @Override
            public void onChanged(float factor) {
                indicator.setAlpha(factor);
            }
        });

        addDatasToViewPager((ViewPager) topView.getChildAt(0), indicator);
    }

    private void addDatasToViewPager(ViewPager vp, CirclePageIndicator indicator) {
        for (int i = 0; i < 3; i++) {
            int res = getResources().getIdentifier("img" + (i + 1), "drawable", this.getPackageName());
            drawables.add(res);
        }

        ImageViewAdapter adapter = new ImageViewAdapter(this, drawables);
        vp.setAdapter(adapter);
        indicator.setViewPager(vp);
    }

}
