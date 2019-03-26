package com.github.ibronsveld.hippo.angular.field;

import com.github.ibronsveld.hippo.angular.AngularPluginContext;
import com.github.ibronsveld.hippo.angular.AngularPluginUtils;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.internal.HtmlHeaderContainer;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.hippoecm.frontend.plugin.IPluginContext;
import org.hippoecm.frontend.plugin.config.IPluginConfig;
import org.hippoecm.frontend.plugins.ckeditor.CKEditorNodePlugin;

public class AngularEnabledCKEditorNodePlugin extends CKEditorNodePlugin {

    private final AngularPluginContext pluginContext;

    public AngularEnabledCKEditorNodePlugin(IPluginContext context, IPluginConfig config) {
        super(context, config);

        // Load the dependencies
        pluginContext = new AngularPluginContext(context, config);
    }


    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        AngularPluginUtils.renderAngular(response);
        AngularPluginUtils.renderAngularMaterial(response);

        AngularPluginUtils.renderPluginScripts(pluginContext, response);
    }
}
