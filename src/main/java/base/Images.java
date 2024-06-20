package base;

import lombok.Getter;

@Getter
public enum Images {
    PNG_IMG("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/img.png", "image/png"),
    URL_IMG("https://pictures.pibig.info/uploads/posts/2023-04/1680603592_pictures-pibig-info-p-realistichnie-risunki-zhivotnikh-instagram-35.jpg", "image/jpg"),
    GIF_IMG("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/HrNfJ.gif", "image/gif"),
    WEBP_IMG("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/i.webp", "image/webp"),
    NEW_PNG("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/free-icon-linux-2333464.png", "image/png"),
    MP4_VIDEO("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/funny-aww-cat-Sesame-is-too-cute.mp4", "image/mp4"),
    WEBM_VIDEO("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/sample_1920x1080.webm", "image/webm"),
    PNG1_IMG("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/img_1.png", "image/png");

    private String path;
    private String format;

    Images(String path, String contentType) {
        this.path = path;
        this.format = format;
    }


}
