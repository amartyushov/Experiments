package io.mart.xstream.tweakingOutput;

import com.thoughtworks.xstream.XStream;

public class TestDrive {
    public static void main(String[] args) {

        Blog teamBlog = new Blog(new Author("Guilherme Silveira"));
        teamBlog.add(new Entry("first","My first blog entry."));
        teamBlog.add(new Entry("tutorial", "Today we have developed a nice alias tutorial. Tell your friends! NOW!"));

        XStream xstream = new XStream();
        xstream.alias("blog", Blog.class);
        xstream.alias("entry", Entry.class);

        xstream.useAttributeFor(Blog.class, "writer");
        xstream.registerConverter(new AuthorConverter());
        // it makes possible to set name as xml attribute

        xstream.addImplicitCollection(Blog.class, "entries");
        // whenever you have a collection which doesn't need
        // to display it's root tag, you can map it as an implicit collection



        System.out.println(xstream.toXML(teamBlog));
    }
}
