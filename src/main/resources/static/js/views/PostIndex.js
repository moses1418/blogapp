export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
        
           <div>
              <form>
                    <label for="blog-id" >Blog id</label><br>
                    <input type="text" name="blog-id" placeholder="Enter title" class="new-post" id="blog-id"><br>
                    <label for="blog-name">Blog title</label><br>
                    <input type="text" name="blog-name" placeholder="Enter name" class="new-post" id="blog-title"><br>
                    <label for="blog-text">Blog it up!</label><br>
                    <input type="text" id="blog-text" name="blog-text" placeholder="Write your blog"><br>
                    <button type="submit" value="submit" id="add-post">Submit</button
                </form>
                
               
           </div>
           
           <div>
               ${props.posts.map(post => `
                    <div>
                        <input class="edit-title" contenteditable="false">${post.title}</input>
                        <input class="edit-content" contenteditable="false">${post.content}</input>
                        <button class="edit-btn" data-id=${post.id}>Edit</button>
                        <button class="delete-btn">Delete</button>
                    </div>
                `).join('')}
               
             
           </div>
        </main>
    `;
}

export function postEvents(){

    createPostEvent();
    editEvent();



}


function createPostEvent(){

    $("#btn-add").click(function () {

        let post = {
            title: $('#title').val(),
            content: $('#content').val()
        }

        let request = {
            method: "Post",
            headers: {"Content-Type":"application/json"},
            body: JSON.stringify(post)
        }

        fetch("http://localhost:8080/api/posts", request)
            .then(res => {
                console.log(res.status);
                createView("/posts")
            }).catch(error => {
            console.log(error);
            createView("/posts")
        });
    })
}


function editEvent() {

    $(".edit-post-btn").click(function () {

        console.log("edit event fired off");
        $(this).siblings(".edit-title, .edit-content").attr("contenteditable", true);
        $(this).text("Save");

    });










}