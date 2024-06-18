import lombok.Getter;

@Getter
public enum Images {
    PNG_IMG("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/img.png"),
    URL_IMG("https://pictures.pibig.info/uploads/posts/2023-04/1680603592_pictures-pibig-info-p-realistichnie-risunki-zhivotnikh-instagram-35.jpg"),
    GIF_IMG("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/HrNfJ.gif"),
    WEBP_IMG("/home/user/IdeaProjects/backend-imgur-project/src/test/resources/image/i.webp");

    Images(String path) {
        this.path = path;

    }
    private final String path;


}
