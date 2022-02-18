import com.intellij.codeInspection.*
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiFile
import org.jetbrains.kotlin.idea.KotlinFileType


class KotlinGreetingsInspection : LocalInspectionTool(), DumbAware {
    override fun checkFile(file: PsiFile, manager: InspectionManager, isOnTheFly: Boolean): Array<ProblemDescriptor>? {
        val fix: LocalQuickFix? = null
        val a = manager.createProblemDescriptor(file, "Hello from a kotlin file", fix, ProblemHighlightType.INFORMATION, true)
        return if (file.fileType == KotlinFileType.INSTANCE) arrayOf(a) else null
    }
}
