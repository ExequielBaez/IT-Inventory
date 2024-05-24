import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { ElementListComponent } from './components/element-list/element-list.component';
import { HeaderAdminComponent } from './components/header-admin/header-admin.component';
import { Routes, RouterModule } from '@angular/router';


const routes : Routes = [
  {path:'', component:HomeComponent},
  {path:'admin/element', component: ElementListComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,    
    ElementListComponent, 
    HeaderAdminComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
