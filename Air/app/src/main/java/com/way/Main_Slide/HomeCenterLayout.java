package com.way.Main_Slide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import android.widget.Scroller;

public class HomeCenterLayout extends LinearLayout {

    public static final int LEFT = 0x001;               //左侧边栏标识符

    public static final int RIGHT = 0x002;              //右侧边栏标识符

    public static final int MIDDLE = 0x000;             //主页面标识符

    private int mCurState = MIDDLE;                     //声明当前页面状态

    public final int MENU_border_Width = 200;           //默认侧边栏宽度

    private Scroller mScroller;                         //声明滑动对象

    private LinearLayout leftLayout, rightLayout;       //左右侧边栏布局

    private Context context;                            //当前页面，上下文

    private boolean mIsBeingDragged = false;

    private int mTouchSlop;                             //移动距离的最小有效值

    private int menuWidth;                              //菜单宽度

    /************************************************************************************************************
     * 上一次点击屏幕的位置
     */
    private float mLastMotionX;
    private float mLastMotionY;

    /************************************************************************************************************
     *
     */
    private static final int INVALID_POINTER = -1;
    private int mActivePointerId = INVALID_POINTER;

    /************************************************************************************************************
     * 带样式的构造函数
     *
     * @param context 当前对象
     * @param attrs   对象样式
     */
    public HomeCenterLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    /************************************************************************************************************
     * 不带样式的构造函数
     *
     * @param context 当前对象
     */
    public HomeCenterLayout(Context context) {
        super(context);
        initView(context);
    }

    /************************************************************************************************************
     * 初始化当前页面
     *
     * @param context 当前对象
     */
    public void initView(Context context) {
        this.context = context;
        this.menuWidth = MENU_border_Width;
        //android.R.anim.overshoot_interpolator 减速前进,冲过终点前再后退
        //android.R.anim.decelerate_interpolator 减速进入
        //android.R.anim.accelerate_interpolator 加速进入
        this.mScroller = new Scroller(context, AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
        final ViewConfiguration configuration = ViewConfiguration.get(context);
        mTouchSlop = configuration.getScaledTouchSlop() / 4;
        mCurState = MIDDLE;
    }


    /************************************************************************************************************
     * 获取当前视图宽度
     *
     * @param context 当前对象
     * @return viewWidthInPix 返回宽度
     */
    private int getViewWidthInPix(Context context) {
        int viewWidthInPix;
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        viewWidthInPix = manager.getDefaultDisplay().getWidth();
        return viewWidthInPix;
    }

    /************************************************************************************************************
     * 完成滑动
     */
    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), 0);
            postInvalidate(); //更新界面
        }
    }

    /************************************************************************************************************
     * 配合onTouchEvent完成触碰事件
     *
     * @param ev 触碰事件
     * @return 返回true则进入onTouchEvent处理事件，false则继续在本方法执行
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final int action = ev.getAction();                                  //获取触控事件
        if ((action == MotionEvent.ACTION_MOVE) && (mIsBeingDragged)) {
            return true;                                                    //判断移动事件
        }
        switch (action & MotionEvent.ACTION_MASK) {                         //ACTION_MASK实现多点触控的统一处理
            case MotionEvent.ACTION_DOWN: {
                final float x = ev.getX();
                final float y = ev.getY();
                if (!inChild((int) x, (int) y)) {
                    mIsBeingDragged = false;
                    break;
                }
                mLastMotionX = x;
                mLastMotionY = y;
                mActivePointerId = ev.getPointerId(0);
                mIsBeingDragged = !mScroller.isFinished();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                final int activePointerId = mActivePointerId;
                if (activePointerId == INVALID_POINTER) {
                    break;
                }
                final int pointerIndex = ev.findPointerIndex(activePointerId);
                final float x = ev.getX(pointerIndex);
                final float y = ev.getY(pointerIndex);
                final int xDiff = (int) Math.abs(x - mLastMotionX);
                final int yDiff = (int) Math.abs(y - mLastMotionY);
                if (xDiff > mTouchSlop &&yDiff < xDiff) {
                    mIsBeingDragged = true;
                }
                break;
            }
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                mIsBeingDragged = false;
                mActivePointerId = INVALID_POINTER;
                scrollToScreen();
                break;
        }
        return mIsBeingDragged;
    }

    /************************************************************************************************************
     * 配合onInterceptTouchEvent完成触碰事件
     *
     * @param event 滑动事件
     * @return 处理结果
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN && !inChild((int) event.getX(), (int) event.getY())) {
            return false;
        }
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:
                final int activePointerIndex = event.findPointerIndex(mActivePointerId);
                final float x = event.getX(activePointerIndex);
                final float y = event.getY(activePointerIndex);
                final int distanceX = (int) -(x - mLastMotionX);
                if (distanceX < 0 && getScrollX() < 0 && leftLayout != null) {
                    setBrotherVisibility(LEFT);
                } else if (distanceX > 0 && getScrollX() > 0 && rightLayout != null) {
                    setBrotherVisibility(RIGHT);
                } else {
                    setBrotherVisibility(MIDDLE);
                }
                scrollBy(distanceX, 0);
                mLastMotionX = x;
                mLastMotionY = y;
                break;
            case MotionEvent.ACTION_UP:
                mIsBeingDragged = false;
                mActivePointerId = INVALID_POINTER;
                scrollToScreen();
                break;
        }
        return mIsBeingDragged;
    }

    public void scroll(){
        scrollToScreen();
    }
    /************************************************************************************************************
     * 根据滑动事件进行滑动
     */
    private void scrollToScreen() {
        int scrollDistance;
        if (Math.abs(getScrollX()) > getWidth() / 6)
            scrollDistance = (getScrollX() > 0) ? getWidth() - menuWidth - getScrollX() : -(getWidth() - menuWidth - Math.abs(getScrollX()));
        else
            scrollDistance = -getScrollX();
        int distance = scrollDistance + getScrollX();
        if (distance > 0) {
            mCurState = RIGHT;
        } else if (distance < 0) {
            mCurState = LEFT;
        } else {
            mCurState = MIDDLE;
        }
        mScroller.startScroll(getScrollX(), 0, scrollDistance, 0, Math.abs(scrollDistance) / 2);
        invalidate();

    }

    /************************************************************************************************************
     * 根据坐标判断触动是否发生在子页面
     */
    private boolean inChild(int x, int y) {
        if (getChildCount() > 0) {
            final int scrollX = mScroller.getCurrX();
            return !(scrollX + x < 0 || scrollX + x > getWidth() || y < 0 || y > getHeight());
        }
        return false;
    }

    /************************************************************************************************************
     * @param which_page 设置显示页面
     */
    public void setPage(int which_page) {
        int targetX = 0;
        int moveDistance;
        if (which_page == LEFT) {
            targetX = -(getViewWidthInPix(context) - menuWidth);
            mCurState = LEFT;
        } else if (which_page == RIGHT) {
            targetX = getViewWidthInPix(context) - menuWidth;
            mCurState = RIGHT;
        } else {
            mCurState = MIDDLE;
        }
        setBrotherVisibility(which_page);
        moveDistance = targetX - getScrollX();
        mScroller.startScroll(getScrollX(), 0, moveDistance, 0, Math.abs(moveDistance) / 2);
        invalidate();
    }

    /************************************************************************************************************
     * 根据当前页面的状态判断页面
     *
     * @return 当前页面的状态
     */
    public int getPage() {
        return mCurState;
    }

    /************************************************************************************************************
     * 设置左右侧边栏
     *
     * @param left  左侧边栏
     * @param right 右侧边栏
     */
    public void setBrotherLayout(LinearLayout left, LinearLayout right) {
        this.leftLayout = left;
        this.rightLayout = right;
    }

    /************************************************************************************************************
     * 根据状态显示左右侧边栏
     *
     * @param state 要显示的侧边栏
     */
    private void setBrotherVisibility(int state) {
        switch (state) {
            case LEFT:
                rightLayout.setVisibility(View.GONE);
                leftLayout.setVisibility(View.VISIBLE);
                break;
            case RIGHT:
                rightLayout.setVisibility(View.VISIBLE);
                leftLayout.setVisibility(View.GONE);
                break;
            case MIDDLE:
                break;
        }
    }

}
