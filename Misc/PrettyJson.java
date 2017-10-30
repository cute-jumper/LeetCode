public class PrettyJson {
    public static void main(String[] args) {
        PrettyJson pj = new PrettyJson();
        System.out.println(pj.prettyPrint("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}"));
        System.out.println(pj.prettyPrint("[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]"));
        System.out.println(pj.prettyPrint("[{\"bar\":[\"baz\",null,1.0,2]}, \"foo\"]"));
    }
    String prettyPrint(String s) {
        StringBuilder sb = new StringBuilder();
        int indent = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == ',') sb.append(c + "\n" + makeIndent(indent));
            else if (c == '{' || c == '[') {
                if (!hasIndentBefore(sb)) sb.append('\n' + makeIndent(indent));
                sb.append(c);
                indent++;
                sb.append("\n" + makeIndent(indent));
            } else if (c == '}' || c == ']') {
                indent--;
                if (!hasIndentBefore(sb)) sb.append('\n' + makeIndent(indent));
                else sb.deleteCharAt(sb.length() - 1);
                sb.append(c);
                if (i + 1 < s.length() && s.charAt(i + 1) == ',') sb.append(s.charAt(++i));
                if (i + 1 < s.length()) sb.append('\n' + makeIndent(indent));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    String makeIndent(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) sb.append('\t');
        return sb.toString();
    }
    boolean hasIndentBefore(StringBuilder sb) {
        return sb.length() == 0 || sb.charAt(sb.length() - 1) == '\t';
    }
}
