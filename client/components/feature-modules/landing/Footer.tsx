import { Github, Linkedin, Twitter } from "lucide-react";
import Link from "next/link";

export default function Footer() {
    return (
        <footer className="border-t">
            <div className="flex flex-col gap-8 py-8 md:flex-row md:py-12">
                <div className="flex-1 space-y-4 px-12 w-full">
                    <h2 className="font-bold">Okare</h2>
                    <p className="text-sm text-muted-foreground max-w-sm">
                        Bringing automation and management solutions to independent carers and small
                        businesses.
                    </p>
                </div>
                <div className="grid w-1/3 grid-cols-2 gap-12 ">
                    <div className="space-y-4">
                        <h3 className="text-sm font-medium">Solutions</h3>
                        <ul className="space-y-3 text-sm">
                            <li>
                                <Link
                                    href="/ai-analytics"
                                    className="text-muted-foreground transition-colors hover:text-primary"
                                >
                                    AI Analytics
                                </Link>
                            </li>
                            <li>
                                <Link
                                    href="/cloud-services"
                                    className="text-muted-foreground transition-colors hover:text-primary"
                                >
                                    Cloud Services
                                </Link>
                            </li>
                        </ul>
                    </div>
                    <div className="space-y-4">
                        <h3 className="text-sm font-medium">Connect</h3>
                        <div className="flex space-x-4">
                            <Link
                                href="https://github.com/amanesoft"
                                className="text-muted-foreground transition-colors hover:text-primary"
                            >
                                <Github className="h-5 w-5" />
                                <span className="sr-only">GitHub</span>
                            </Link>
                            <Link
                                href="https://twitter.com/amanesoft"
                                className="text-muted-foreground transition-colors hover:text-primary"
                            >
                                <Twitter className="h-5 w-5" />
                                <span className="sr-only">Twitter</span>
                            </Link>
                            <Link
                                href="https://linkedin.com/company/amanesoft"
                                className="text-muted-foreground transition-colors hover:text-primary"
                            >
                                <Linkedin className="h-5 w-5" />
                                <span className="sr-only">LinkedIn</span>
                            </Link>
                        </div>
                    </div>
                </div>
            </div>
            <div className="py-6">
                <p className="text-center text-sm text-muted-foreground">
                    © {new Date().getFullYear()} Okare, Inc. All rights reserved.
                </p>
            </div>
        </footer>
    );
}
