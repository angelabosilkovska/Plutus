//
//  SimpleIosButton.swift
//  iosApp
//
//  Created by Inellipse on 31.3.25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import ComposeApp

class IOSNativeViewFactory: NativeViewFactory {
    static var shared = IOSNativeViewFactory()
    func createButtonView(label: String, onClick: @escaping () -> Void) -> UIViewController {
        let view = SimpleIosButton(label: label, action: onClick)
        return UIHostingController(rootView: view)
    }
}

struct SimpleIosButton: View {
    
    var label: String
    var action: () -> Void
    
    var body: some View {
        Button(action: action) {
            Text(label)
                .font(.headline)
        }
    }
}
