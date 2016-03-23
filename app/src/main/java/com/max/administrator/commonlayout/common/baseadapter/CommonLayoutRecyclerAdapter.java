package com.max.administrator.commonlayout.common.baseadapter;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import com.max.administrator.commonlayout.R;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.ItemClickListener;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean.LoginItem;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.viewholder.AccountHolder;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.viewholder.MessageHolder;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.viewholder.ModifyNameHolder;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.viewholder.ModifySexHolder;
import com.max.administrator.commonlayout.common.baseadapter.utils.factory.viewholder.PasswordHolder;

import java.util.List;

/**
 * 所有不同功能的activity都在此初始化,但具体的处理业务逻辑,为了避免功能混淆和便于维护
 * 控件具体的值modifyName,modifySex,UserAccount,UserPass,UserCode在这个类里面初始化,
 * 通过get方式在具体activity进行逻辑处理
 * 这里与activity通信可以采用handler或者广播或者eventBus
 * Created by max on 2016/3/16.
 */
public class CommonLayoutRecyclerAdapter extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int LAYOUT_MSG = R.layout.max_baselogin_activity_item_msg;
    public static final int LAYOUT_PASS = R.layout.max_baselogin_activity_item_pass;
    public static final int LAYOUT_ACCOUNT = R.layout.max_baselogin_activity_item_account;
    public static final int LAYOUT_MODIFY_NAME = R.layout.max_baselogin_activity_item_name;
    public static final int LAYOUT_MODIFY_SEX = R.layout.max_baselogin_activity_item_sex;

    private CountDownTimer codeTimer; //计时器
    private PasswordHolder passwordHolder;
    private MessageHolder messageHolder;
    private AccountHolder accountHolder;
    private ModifyNameHolder nameHolder;
    private ModifySexHolder sexHolder;

    public List<LoginItem> data; //决定recyclerview布局文件的组成
    private Context context;
    private LayoutInflater inflater;
    private ItemClickListener listener;
    private Button signTV; // 登录按钮,可以通过get
    private String modifyName, modifySex, UserAccount, UserPass, UserCode;//修改姓名,修改性别,用户账号,用户密码,用户验证码

    public CommonLayoutRecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public CommonLayoutRecyclerAdapter(List<LoginItem> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0)
            return null;
        View view = inflater.inflate(viewType, parent, false);
        switch (viewType) {
            case LAYOUT_MSG:
                messageHolder = new MessageHolder(view);
                return messageHolder;
            case LAYOUT_PASS:
                passwordHolder = new PasswordHolder(view);
                return passwordHolder;
            case LAYOUT_ACCOUNT:
                accountHolder = new AccountHolder(view);
                return accountHolder;
            case LAYOUT_MODIFY_NAME:
                nameHolder = new ModifyNameHolder(view);
                return nameHolder;
            case LAYOUT_MODIFY_SEX:
                sexHolder = new ModifySexHolder(view);
                return sexHolder;
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int position) {

        final LoginItem item = data.get(position);
        switch (getItemViewType(position)) {
            case LAYOUT_MSG:
                // 填充数据
                ((MessageHolder) viewHolder).code.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (listener != null) { //具体点击事件,可以在这里直接写逻辑代码,但建议绑定接口,这边直接在对应activity处理业务逻辑
                            listener.codeClick(((MessageHolder) viewHolder).code, ((MessageHolder) viewHolder).account);
                        }
                    }
                });
                ((MessageHolder) viewHolder).account.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.itemClick(v);
                        }
                    }
                });
                ((MessageHolder) viewHolder).account.addTextChangedListener(new MsgEditWatcher(((MessageHolder) viewHolder).account));//绑定这个监听,获取到editext的数据
                break;
            case LAYOUT_ACCOUNT:
                ((AccountHolder) viewHolder).account.setInputType(EditorInfo.TYPE_CLASS_PHONE);

                break;
            case LAYOUT_PASS:
                    ((PasswordHolder) viewHolder).password.setHint("请输入验证码");
                break;
            case LAYOUT_MODIFY_SEX:

                break;
            case LAYOUT_MODIFY_NAME:
                ((ModifyNameHolder) viewHolder).name.addTextChangedListener(new TextWatcher() {

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        modifyName = ((ModifyNameHolder) viewHolder).name.getText().toString();
                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count,
                                                  int after) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                break;

            default:
                break;
        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        LoginItem item = data.get(position);
        int type = 0;
        if (item.getType().equals("0")) {
            type = LAYOUT_MSG;
        } else if (item.getType().equals("1")) {
            type = LAYOUT_PASS;
        } else if (item.getType().equals("2")) {
            type = LAYOUT_ACCOUNT;
        } else if (item.getType().equals("3")) {
            type = LAYOUT_MODIFY_SEX;
        } else if (item.getType().equals("4")) {
            type = LAYOUT_MODIFY_NAME;
        }
        return type;
    }

    /**
     * 手机位数的监听事件
     * 通过监听,可以实现具体控件监听逻辑
     * 和获取当前控件的数值
     * @author max
     *
     */
    class MsgEditWatcher implements TextWatcher {
        private EditText mEditText;

        public MsgEditWatcher(EditText mEditText) {
            super();
            this.mEditText = mEditText;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
                UserAccount = mEditText.getText().toString();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    public List<LoginItem> getData() {
        return data;
    }

    public void setData(List<LoginItem> data) {
        this.data = data;
    }

    public Button getSignTV() {
        return signTV;
    }

    public void setSignTV(Button signTV) {
        this.signTV = signTV;
    }

    public ItemClickListener getListener() {
        return listener;
    }

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }
}
