package com.and.netease;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ViewSwitcher;

public class NewsContentActivity extends Activity {

	ImageButton btn_back;
	WebView webView;
	String content_url;

	ViewSwitcher viewSwitcher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_newscontent);
		initViews();
	}

	private void initViews() {
		btn_back = (ImageButton) findViewById(R.id.btn_newscontent_back);
		btn_back.setOnClickListener(listener);

		viewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);

		content_url = getIntent().getStringExtra("content_url");
		webView = new WebView(this);

		// ��ViewSwitcher���������View�������л�
		viewSwitcher.addView(webView);
		viewSwitcher.addView(getLayoutInflater().inflate(
				R.layout.layout_progress_page, null));
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);

		webView.setWebViewClient(client);
		webView.loadUrl(content_url);
	}

	private WebViewClient client = new WebViewClient() {

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			viewSwitcher.showPrevious();
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			viewSwitcher.showNext();
		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return super.shouldOverrideUrlLoading(view, url);
		}

	};

	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			NewsContentActivity.this.setResult(RESULT_OK);
			NewsContentActivity.this.finish();
		}
	};

	public void onBackPressed() {
		if (webView.canGoBack()) {
			webView.goBack();
		} else {
			NewsContentActivity.this.setResult(RESULT_OK);
			NewsContentActivity.this.finish();
		}
	};
}
