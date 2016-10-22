package org.netbeans.modules.demo.hint;

import java.util.List;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.modules.csl.api.Hint;
import org.netbeans.modules.csl.api.HintSeverity;
import org.netbeans.modules.csl.api.RuleContext;
import org.netbeans.modules.html.editor.api.gsf.HtmlParserResult;
import org.netbeans.modules.html.editor.hints.HtmlRule;
import org.netbeans.modules.html.editor.hints.HtmlRuleContext;
import org.openide.filesystems.FileObject;
import org.openide.util.NbBundle.Messages;

@Messages({
    "MSG_MISSING_CUSTOMER_ID=No first name defined",
    "MSG_MISSING_CUSTOMER_DESC=Checks if first name exists."
})
public class MissingFirstNameRule extends HtmlRule {
    
    public MissingFirstNameRule() {
    }

    @Override
    protected void run(HtmlRuleContext context, List<Hint> result) {
//        try {
//            HtmlParserResult parserResult = context.getHtmlParserResult();
//            CssIdsVisitor visitor = new CssIdsVisitor(this, context, result);
//            ElementUtils.visitChildren(parserResult.root(), visitor, ElementType.OPEN_TAG);
//        } catch(IOException ioe) {
//            Exceptions.printStackTrace(ioe);
//        }
    }
    
    @Override
    public boolean appliesTo(RuleContext context) {
        HtmlParserResult result = (HtmlParserResult) context.parserResult;
        FileObject file = result.getSnapshot().getSource().getFileObject();
        if (file == null) {
            return false;
        }
        Project project = FileOwnerQuery.getOwner(file);
        if (project == null) {
            return false;
        }
        return true;
    }

    @Override
    public String getDescription() {
        return Bundle.MSG_MISSING_CUSTOMER_ID();
    }

    @Override
    public String getDisplayName() {
        return Bundle.MSG_MISSING_CUSTOMER_DESC();
    }

    @Override
    public boolean showInTasklist() {
        return false;
    }

    @Override
    public HintSeverity getDefaultSeverity() {
        return HintSeverity.CURRENT_LINE_WARNING;
    }
    
}
