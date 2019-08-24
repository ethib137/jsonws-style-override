package com.dnebinger.api.jsonws;

import com.liferay.portal.deploy.hot.CustomJspBag;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.url.URLContainer;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * class ApiJsonwsJspBag: The default styling for the /api/jsonws is something to be desired. I mean, seriously,
 * it is a development resource. We don't need it constrained to the size of a tablet all the time...
 *
 * Anywho, this is the custom jsp bag for the overriding jsp of the jsonws discovery page. The jsp file has all the details.
 *
 * @author dnebinger
 */
@Component(
		immediate = true,
		property = {
				"context.id=ApiJsonwsJspBag",
				"context.name=API JSONWS Override JSP Bag",
				"service.ranking:Integer=100"
		}
)
public class ApiJsonwsJspBag implements CustomJspBag {

	@Override
	public String getCustomJspDir() {
		return "META-INF/jsps/";
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_bundle = bundleContext.getBundle();

		_customJsps = new ArrayList<>();

		if (_log.isDebugEnabled()) {
			_log.debug("Found the following jsp/jspf files to serve:");
		}

		Enumeration<URL> entries = _bundle.findEntries(
				getCustomJspDir(), "*.jsp", true);

		if (entries != null) {
			while (entries.hasMoreElements()) {
				URL url = entries.nextElement();

				_customJsps.add(url.getPath());

				if (_log.isDebugEnabled()) {
					_log.debug("   Path: " + url.getPath());
				}
			}
		}

		// also allow the jspf overrides
		entries = _bundle.findEntries(
				getCustomJspDir(), "*.jspf", true);

		if (entries != null) {
			while (entries.hasMoreElements()) {
				URL url = entries.nextElement();

				_customJsps.add(url.getPath());

				if (_log.isDebugEnabled()) {
					_log.debug("   Path: " + url.getPath());
				}
			}
		}
	}

	@Override
	public List<String> getCustomJsps() {
		return _customJsps;
	}

	@Override
	public URLContainer getURLContainer() {
		return _urlContainer;
	}

	private final URLContainer _urlContainer = new URLContainer() {

		@Override
		public URL getResource(String name) {
			if (_log.isDebugEnabled()) {
				_log.debug("Returning URL for [" + name + "].");
			}
			return _bundle.getEntry(name);
		}

		@Override
		public Set<String> getResources(String path) {
			Set<String> paths = new HashSet<>();

			for (String entry : _customJsps) {
				if (entry.startsWith(path)) {
					paths.add(entry);
				}
			}

			if (_log.isDebugEnabled()) {
				_log.debug("Returning following resource paths: ");
				for (String p : paths) {
					_log.debug("  Path: " + p);
				}
			}

			return paths;
		}
	};

	@Override
	public boolean isCustomJspGlobal() {
		return true;
	}

	private Bundle _bundle;
	private List<String> _customJsps;

	private static final Log _log = LogFactoryUtil.getLog(ApiJsonwsJspBag.class);
}
