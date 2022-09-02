import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { UserformComponent } from './userform/userform.component';
import { UserlistComponent } from './userlist/userlist.component';
import { RouterModule, Routes } from '@angular/router';

const routes:Routes=[
{path:'userform',component:UserformComponent},
{path:'userlist',component:UserlistComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    UserformComponent,
    UserlistComponent
  ],
  imports: [
    BrowserModule,FormsModule,HttpClientModule,RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
