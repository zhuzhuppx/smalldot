import React from "react";
import {
  // BrowserRouter as Router,
  HashRouter as Router,
  Switch,
  Route,
  Redirect
} from "react-router-dom";
import router from "@/routes/index.js";
import PageLayout from "./layout/index";
import AdminPageLayout from "./layout/admin/adminIndex";
import { createBrowserHistory,createHashHistory } from "history";
import "reset-css";

// const history = createBrowserHistory();
const history = createHashHistory();
class App extends React.Component {
  render() {
    const { indexPage, mainPage, mainIndexPage, adminPage } = router;
    return (
      <Router history={history}>
        <Switch>
          <Route
            path={adminPage.path}
            component={() => <AdminPageLayout routes={adminPage.routes} />}
          />
        
          <Route
            path={mainPage.path}
            component={() => <PageLayout routes={mainPage.routes} />}
          />
        
          <Redirect exact from={indexPage.path} to={mainIndexPage.path} />
        </Switch>
      </Router>
    );
  }
}

export default App;
