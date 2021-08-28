package com.example.successsynergyapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.successsynergyapp.databinding.ActivityEditProfileBindingImpl;
import com.example.successsynergyapp.databinding.ActivityLoginBindingImpl;
import com.example.successsynergyapp.databinding.ActivityMainBindingImpl;
import com.example.successsynergyapp.databinding.ActivityUserFormBindingImpl;
import com.example.successsynergyapp.databinding.ActivityUserTypeBindingImpl;
import com.example.successsynergyapp.databinding.ActivityWalkThroughBindingImpl;
import com.example.successsynergyapp.databinding.FragmentAccountDetails2BindingImpl;
import com.example.successsynergyapp.databinding.FragmentAccountDetails3BindingImpl;
import com.example.successsynergyapp.databinding.FragmentAccountDetailsBindingImpl;
import com.example.successsynergyapp.databinding.FragmentFormBindingImpl;
import com.example.successsynergyapp.databinding.FragmentIndividualAllBindingImpl;
import com.example.successsynergyapp.databinding.FragmentLoginBindingImpl;
import com.example.successsynergyapp.databinding.FragmentProfileBindingImpl;
import com.example.successsynergyapp.databinding.FragmentSignUpBindingImpl;
import com.example.successsynergyapp.databinding.FragmentWalkThroughBindingImpl;
import com.example.successsynergyapp.databinding.LayoutHomeBindingImpl;
import com.example.successsynergyapp.databinding.LayoutItemGeneralBindingImpl;
import com.example.successsynergyapp.databinding.LayoutItemPopularBindingImpl;
import com.example.successsynergyapp.databinding.LayoutItemSearchBindingImpl;
import com.example.successsynergyapp.databinding.LayoutSearchBindingImpl;
import com.example.successsynergyapp.databinding.LayoutSingleFormQuestionBindingImpl;
import com.example.successsynergyapp.databinding.LayoutUserProfileBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYEDITPROFILE = 1;

  private static final int LAYOUT_ACTIVITYLOGIN = 2;

  private static final int LAYOUT_ACTIVITYMAIN = 3;

  private static final int LAYOUT_ACTIVITYUSERFORM = 4;

  private static final int LAYOUT_ACTIVITYUSERTYPE = 5;

  private static final int LAYOUT_ACTIVITYWALKTHROUGH = 6;

  private static final int LAYOUT_FRAGMENTACCOUNTDETAILS = 7;

  private static final int LAYOUT_FRAGMENTACCOUNTDETAILS2 = 8;

  private static final int LAYOUT_FRAGMENTACCOUNTDETAILS3 = 9;

  private static final int LAYOUT_FRAGMENTFORM = 10;

  private static final int LAYOUT_FRAGMENTINDIVIDUALALL = 11;

  private static final int LAYOUT_FRAGMENTLOGIN = 12;

  private static final int LAYOUT_FRAGMENTPROFILE = 13;

  private static final int LAYOUT_FRAGMENTSIGNUP = 14;

  private static final int LAYOUT_FRAGMENTWALKTHROUGH = 15;

  private static final int LAYOUT_LAYOUTHOME = 16;

  private static final int LAYOUT_LAYOUTITEMGENERAL = 17;

  private static final int LAYOUT_LAYOUTITEMPOPULAR = 18;

  private static final int LAYOUT_LAYOUTITEMSEARCH = 19;

  private static final int LAYOUT_LAYOUTSEARCH = 20;

  private static final int LAYOUT_LAYOUTSINGLEFORMQUESTION = 21;

  private static final int LAYOUT_LAYOUTUSERPROFILE = 22;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(22);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.activity_edit_profile, LAYOUT_ACTIVITYEDITPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.activity_user_form, LAYOUT_ACTIVITYUSERFORM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.activity_user_type, LAYOUT_ACTIVITYUSERTYPE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.activity_walk_through, LAYOUT_ACTIVITYWALKTHROUGH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.fragment_account_details, LAYOUT_FRAGMENTACCOUNTDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.fragment_account_details2, LAYOUT_FRAGMENTACCOUNTDETAILS2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.fragment_account_details3, LAYOUT_FRAGMENTACCOUNTDETAILS3);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.fragment_form, LAYOUT_FRAGMENTFORM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.fragment_individual_all, LAYOUT_FRAGMENTINDIVIDUALALL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.fragment_profile, LAYOUT_FRAGMENTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.fragment_sign_up, LAYOUT_FRAGMENTSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.fragment_walk_through, LAYOUT_FRAGMENTWALKTHROUGH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.layout_home, LAYOUT_LAYOUTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.layout_item_general, LAYOUT_LAYOUTITEMGENERAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.layout_item_popular, LAYOUT_LAYOUTITEMPOPULAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.layout_item_search, LAYOUT_LAYOUTITEMSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.layout_search, LAYOUT_LAYOUTSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.layout_single_form_question, LAYOUT_LAYOUTSINGLEFORMQUESTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.successsynergyapp.R.layout.layout_user_profile, LAYOUT_LAYOUTUSERPROFILE);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYEDITPROFILE: {
          if ("layout/activity_edit_profile_0".equals(tag)) {
            return new ActivityEditProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_edit_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYUSERFORM: {
          if ("layout/activity_user_form_0".equals(tag)) {
            return new ActivityUserFormBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_user_form is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYUSERTYPE: {
          if ("layout/activity_user_type_0".equals(tag)) {
            return new ActivityUserTypeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_user_type is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWALKTHROUGH: {
          if ("layout/activity_walk_through_0".equals(tag)) {
            return new ActivityWalkThroughBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_walk_through is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTACCOUNTDETAILS: {
          if ("layout/fragment_account_details_0".equals(tag)) {
            return new FragmentAccountDetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_account_details is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTACCOUNTDETAILS2: {
          if ("layout/fragment_account_details2_0".equals(tag)) {
            return new FragmentAccountDetails2BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_account_details2 is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTACCOUNTDETAILS3: {
          if ("layout/fragment_account_details3_0".equals(tag)) {
            return new FragmentAccountDetails3BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_account_details3 is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFORM: {
          if ("layout/fragment_form_0".equals(tag)) {
            return new FragmentFormBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_form is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTINDIVIDUALALL: {
          if ("layout/fragment_individual_all_0".equals(tag)) {
            return new FragmentIndividualAllBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_individual_all is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGIN: {
          if ("layout/fragment_login_0".equals(tag)) {
            return new FragmentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPROFILE: {
          if ("layout/fragment_profile_0".equals(tag)) {
            return new FragmentProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSIGNUP: {
          if ("layout/fragment_sign_up_0".equals(tag)) {
            return new FragmentSignUpBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_sign_up is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWALKTHROUGH: {
          if ("layout/fragment_walk_through_0".equals(tag)) {
            return new FragmentWalkThroughBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_walk_through is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTHOME: {
          if ("layout/layout_home_0".equals(tag)) {
            return new LayoutHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_home is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTITEMGENERAL: {
          if ("layout/layout_item_general_0".equals(tag)) {
            return new LayoutItemGeneralBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_item_general is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTITEMPOPULAR: {
          if ("layout/layout_item_popular_0".equals(tag)) {
            return new LayoutItemPopularBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_item_popular is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTITEMSEARCH: {
          if ("layout/layout_item_search_0".equals(tag)) {
            return new LayoutItemSearchBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_item_search is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTSEARCH: {
          if ("layout/layout_search_0".equals(tag)) {
            return new LayoutSearchBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_search is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTSINGLEFORMQUESTION: {
          if ("layout/layout_single_form_question_0".equals(tag)) {
            return new LayoutSingleFormQuestionBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_single_form_question is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTUSERPROFILE: {
          if ("layout/layout_user_profile_0".equals(tag)) {
            return new LayoutUserProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_user_profile is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(22);

    static {
      sKeys.put("layout/activity_edit_profile_0", com.example.successsynergyapp.R.layout.activity_edit_profile);
      sKeys.put("layout/activity_login_0", com.example.successsynergyapp.R.layout.activity_login);
      sKeys.put("layout/activity_main_0", com.example.successsynergyapp.R.layout.activity_main);
      sKeys.put("layout/activity_user_form_0", com.example.successsynergyapp.R.layout.activity_user_form);
      sKeys.put("layout/activity_user_type_0", com.example.successsynergyapp.R.layout.activity_user_type);
      sKeys.put("layout/activity_walk_through_0", com.example.successsynergyapp.R.layout.activity_walk_through);
      sKeys.put("layout/fragment_account_details_0", com.example.successsynergyapp.R.layout.fragment_account_details);
      sKeys.put("layout/fragment_account_details2_0", com.example.successsynergyapp.R.layout.fragment_account_details2);
      sKeys.put("layout/fragment_account_details3_0", com.example.successsynergyapp.R.layout.fragment_account_details3);
      sKeys.put("layout/fragment_form_0", com.example.successsynergyapp.R.layout.fragment_form);
      sKeys.put("layout/fragment_individual_all_0", com.example.successsynergyapp.R.layout.fragment_individual_all);
      sKeys.put("layout/fragment_login_0", com.example.successsynergyapp.R.layout.fragment_login);
      sKeys.put("layout/fragment_profile_0", com.example.successsynergyapp.R.layout.fragment_profile);
      sKeys.put("layout/fragment_sign_up_0", com.example.successsynergyapp.R.layout.fragment_sign_up);
      sKeys.put("layout/fragment_walk_through_0", com.example.successsynergyapp.R.layout.fragment_walk_through);
      sKeys.put("layout/layout_home_0", com.example.successsynergyapp.R.layout.layout_home);
      sKeys.put("layout/layout_item_general_0", com.example.successsynergyapp.R.layout.layout_item_general);
      sKeys.put("layout/layout_item_popular_0", com.example.successsynergyapp.R.layout.layout_item_popular);
      sKeys.put("layout/layout_item_search_0", com.example.successsynergyapp.R.layout.layout_item_search);
      sKeys.put("layout/layout_search_0", com.example.successsynergyapp.R.layout.layout_search);
      sKeys.put("layout/layout_single_form_question_0", com.example.successsynergyapp.R.layout.layout_single_form_question);
      sKeys.put("layout/layout_user_profile_0", com.example.successsynergyapp.R.layout.layout_user_profile);
    }
  }
}
