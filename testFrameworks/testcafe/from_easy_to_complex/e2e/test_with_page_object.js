import { Selector } from 'testcafe';
import HomePage from './models/home'; // import the model
import PostsPage from './models/posts'; // import the model
import ArticlePage from './models/article'; // import the model
import AddPage from './models/add'; // import the model
import ToastPage from './models/toast'; // import the model

const homePage = new HomePage(); 
const postsPage = new PostsPage();
const articlePage = new ArticlePage();
const addPage = new AddPage(); 
const toastPage = new ToastPage(); 

fixture `Navigation`.page `https://xke-introduction-testcafe.surge.sh/`;

test('Access to an article from the home page. Page object', async t => {
    await t.click(homePage.startBtn);
    await postsPage.isPageDisplayed();
    
    await t.click(await postsPage.addBtn);
    await addPage.isPageDisplayed();
    
    await addPage.submitForm('How TestCafe is awesome!', 'Bla Bli Blou');
    await toastPage.isToastDisplayed();
});