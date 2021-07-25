import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmpresasListComponent } from './empresas/empresas-list.component';
import {EmpresasService} from "./empresas.service";
import { EmpresasFormComponent } from './empresas-form/empresas-form.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTableModule} from "@angular/material/table";
import {NgxMaskModule} from "ngx-mask";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatIconModule} from "@angular/material/icon";
import {MatDividerModule} from "@angular/material/divider";
import {MatGridListModule} from "@angular/material/grid-list";
import {FormsModule} from "@angular/forms";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import { PageNotFoundComponentComponent } from './page-not-found-component/page-not-found-component.component';

@NgModule({
  declarations: [
    AppComponent,
    EmpresasListComponent,
    EmpresasFormComponent,
    PageNotFoundComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTableModule,
    NgxMaskModule.forRoot(),
    MatPaginatorModule,
    MatIconModule,
    MatDividerModule,
    MatGridListModule,
    FormsModule,
    MatProgressSpinnerModule
  ],
  providers: [HttpClientModule, EmpresasService],
  bootstrap: [AppComponent]
})
export class AppModule { }
